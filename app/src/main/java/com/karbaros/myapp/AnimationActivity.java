package com.karbaros.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {
    private ImageView ivAnimImg;
    Animation animBlink;
    Animation animBounce;
    Animation animClockwise;
    Animation animFade;
    Animation animZoomOut;
    Animation animZoomIn;
    Animation animMove;
    Animation animRotate;
    Animation animSequential;
    Animation animSlideUp;
    Animation animSlideDown;
    Animation animTogether;
    Animation animInLeft;
    Animation animInRight;
    Animation animFadeIn;
    Animation animFadeOut;
    Animation animMyAnim;


    public void doAnimation(View view) {
        switch (view.getId()) {
            case R.id.btnBlink:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animBlink);
                break;
            case R.id.btnBounce:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animBounce);
                break;
            case R.id.btnClockwise:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animClockwise);
                break;
            case R.id.btnFade:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animFade);
                break;
            case R.id.btnMove:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animMove);
                break;
            case R.id.btnRotate:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animRotate);
                break;
            case R.id.btnZoomIn:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animZoomIn);
                break;
            case R.id.btnZoomOut:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animZoomOut);
                break;
            case R.id.btnSequential:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animSequential);
                break;
            case R.id.btnSlideUp:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animSlideUp);
                break;
            case R.id.btnSlideDown:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animSlideDown);
                break;
            case R.id.btnTogether:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animTogether);
                break;
            case R.id.btnInLeft:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animInLeft);
                break;
            case R.id.btnInRight:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animInRight);
                break;
            case R.id.btnFadeIn:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animFadeIn);
                break;
            case R.id.btnFadeOut:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animFadeOut);
                break;
            case R.id.btnMyAnim:
                ivAnimImg.clearAnimation();
                ivAnimImg.startAnimation(animMyAnim);
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        ivAnimImg = (ImageView) findViewById(R.id.ivAnimImg);


        animBlink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_blink);
        animBounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_bounce);
        animClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_clockwise);
        animFade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_fade);
        animMove = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_move);
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_rotate);
        animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        animSequential = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_sequentional);
        animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_slide_up);
        animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_slide_down);
        animTogether = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_together);
        animSequential = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_sequentional);
        animInLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in_left);
        animInRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in_right);
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_fade_in);
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_fade_out);
        animMyAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.my_anim);

    }
}
