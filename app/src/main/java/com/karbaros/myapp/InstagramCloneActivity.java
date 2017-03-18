package com.karbaros.myapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.karbaros.myapp.utility.ImageFilter;

import java.io.IOException;

//and maybe you need in some ocations

public class InstagramCloneActivity extends AppCompatActivity {

    private static final int RESULT_LOAD_IMAGE = 1999;
    ImageView ivResultImage;
    ImageView ivThumbnailOriginal;
    ImageView ivThumbGrayScale;
    ImageView ivThumbSnowEffect;
    ImageView ivThumbBrightness;
    ImageView ivThumbDark;
    ImageView ivThumbReflection;
    ImageView imageTemp;

    Animation animZnnmIn;
    Animation animZoomOut;

    private Uri imageUri;
    private Bitmap bitmap;
    private Bitmap bitmapTemp;
    private static final int CAMERA_REQUEST = 1888;
    private Bitmap bitmapOriginal;
    private Bitmap bitmapGrayScale;
    private Bitmap bitmapSnowEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_clone2);
        ivResultImage = (ImageView) findViewById(R.id.ivResultImage);
        ivThumbnailOriginal = (ImageView) findViewById(R.id.ivThumbOriginal);
        ivThumbGrayScale = (ImageView) findViewById(R.id.ivThumbGrayScale);
        ivThumbSnowEffect = (ImageView) findViewById(R.id.ivThumbSnowEffect);
        ivThumbBrightness = (ImageView) findViewById(R.id.ivThumbBrightness);
        ivThumbDark = (ImageView) findViewById(R.id.ivThumbDark);
        ivThumbReflection = (ImageView) findViewById(R.id.ivThumbReflection);

        imageTemp = (ImageView) findViewById(R.id.ivResultImage);

        Log.i("logiii", "onCreate");
        BitmapDrawable bitmapDrawableTemp = (BitmapDrawable) imageTemp.getDrawable();
        bitmapTemp = bitmapDrawableTemp.getBitmap();

        BitmapDrawable abmp = (BitmapDrawable) ivResultImage.getDrawable();
        bitmap = abmp.getBitmap();

        animZnnmIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }

        makeThumbnail(bitmap);

        registerForContextMenu(ivResultImage);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.instagram_context_menu, menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.instagram_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.zoomIn:
                ivResultImage.startAnimation(animZnnmIn);
                break;
            case R.id.zoomOut:
                ivResultImage.startAnimation(animZoomOut);
                break;
            case R.id.reset:
                ivResultImage.clearAnimation();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selectedItemId = item.getItemId();
        switch (selectedItemId) {
            case R.id.miCamera:
                takePhoto();
                break;
            case R.id.miGallery:
                selectFromGallery();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectFromGallery() {
        Intent intentSelectfromGallery = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intentSelectfromGallery, RESULT_LOAD_IMAGE);
    }

    public void takePhoto() {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_LOAD_IMAGE:
                if (resultCode == Activity.RESULT_OK) {
                    Uri uri = data.getData();

                    Bitmap photo = null;
                    try {
                        photo = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        ivResultImage.setImageBitmap(photo);
                        imageTemp.setImageBitmap(photo);
                        BitmapDrawable bitmapDrawableTemp = (BitmapDrawable) imageTemp.getDrawable();
                        bitmapTemp = bitmapDrawableTemp.getBitmap();

                        makeThumbnail(photo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                break;
            case CAMERA_REQUEST:
                if (resultCode == Activity.RESULT_OK) {
                    Bitmap photo = (Bitmap) data.getExtras().get("data");
                    Log.i("log", data.toString());
                    ivResultImage.setImageBitmap(photo);
                    imageTemp.setImageBitmap(photo);
                    BitmapDrawable bitmapDrawableTemp = (BitmapDrawable) imageTemp.getDrawable();
                    bitmapTemp = bitmapDrawableTemp.getBitmap();

                    makeThumbnail(photo);
                }
                break;
        }


        if (requestCode == RESULT_LOAD_IMAGE && resultCode == Activity.RESULT_OK) {
            Uri selectedImageUri = data.getData();
            Bitmap photo = null;
            try {
                photo = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Log.i("log", data.toString());
            ivResultImage.setImageBitmap(photo);
            imageTemp.setImageBitmap(photo);
            BitmapDrawable bitmapDrawableTemp = (BitmapDrawable) imageTemp.getDrawable();
            bitmapTemp = bitmapDrawableTemp.getBitmap();

            makeThumbnail(photo);
        }
    }


    public void makeThumbnail(Bitmap bitmapImage) {
        Bitmap resized = Bitmap.createScaledBitmap(bitmapImage, (int) (bitmapImage.getWidth() * 0.1), (int) (bitmapImage.getHeight() * 0.1), true);


        ivThumbnailOriginal.setImageBitmap(resized);
        ivThumbGrayScale.setImageBitmap(ImageFilter.doGreyscale(resized));
        ivThumbSnowEffect.setImageBitmap(ImageFilter.applySnowEffect(resized));
        ivThumbBrightness.setImageBitmap(ImageFilter.doBrightness(resized));
        ivThumbDark.setImageBitmap(ImageFilter.doDark(resized));
        ivThumbReflection.setImageBitmap(ImageFilter.applyReflection(resized));
        //return resized;
    }


    public void applyFilter(View view) {
        switch (view.getId()) {
            case R.id.ivThumbOriginal:
                Log.i("log", "thumbOriginal");
                ivResultImage.setImageBitmap(bitmapTemp);
                break;
            case R.id.ivThumbGrayScale:
                Log.i("log", "thumbGrayScale");
                ivResultImage.setImageBitmap(ImageFilter.doGreyscale(bitmapTemp));
                break;
            case R.id.ivThumbSnowEffect:
                ivResultImage.setImageBitmap(ImageFilter.applySnowEffect(bitmapTemp));
                break;
            case R.id.ivThumbBrightness:
                ivResultImage.setImageBitmap(ImageFilter.doBrightness(bitmapTemp));
                break;
            case R.id.ivThumbDark:
                ivThumbDark.setImageBitmap(ImageFilter.doDark(bitmapTemp));
                break;
            case R.id.ivThumbReflection:
                ivThumbReflection.setImageBitmap(ImageFilter.applyReflection(bitmapTemp));
                break;
            default:
                break;
        }

    }


}
