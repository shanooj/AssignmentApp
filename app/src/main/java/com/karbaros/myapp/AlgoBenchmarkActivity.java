package com.karbaros.myapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.karbaros.myapp.utility.ArrayOperation;
import com.karbaros.myapp.utility.SortingAlgoritham;

public class AlgoBenchmarkActivity extends AppCompatActivity {
    private static final String TAG = AlgoBenchmarkActivity.class.getSimpleName();
    private int[] array;
    double startTime = 0;
    double endTime = 0;
    double toalTime = 0;
    private EditText arrayLength;
    private RadioGroup rdgComplexity;
    TextView tvBubbleSortTime;
    TextView tvSelectionSortTime;
    TextView tvQuickSortTime;
    TextView tvInsertionSortTime;
    TextView tvHeapSortTime;
    TextView tvMergeSortTime;
    int[] arrayTemp;
    SortingAlgoritham sortingAlgoritham = new SortingAlgoritham();

    public void resetAll(View view) {
        arrayLength.setText("");
        tvInsertionSortTime.setText(null);
        tvSelectionSortTime.setText(null);
        tvBubbleSortTime.setText(null);
        tvQuickSortTime.setText(null);
    }

        private void doBubbleSort() {
            arrayTemp = ArrayOperation.makeTempArray(array);
                startTime = System.nanoTime();
                SortingAlgoritham.bubbleSort(arrayTemp);
                endTime = System.nanoTime();
                toalTime = (endTime - startTime) / 1000000;
                tvBubbleSortTime.setText("" + toalTime);
        }

        private void doSelectionSort() {
             arrayTemp = ArrayOperation.makeTempArray(array);
                startTime = System.nanoTime();
                SortingAlgoritham.selectionSort(arrayTemp);
                endTime = System.nanoTime();
                toalTime = (endTime - startTime) / 1000000;
                tvSelectionSortTime.setText("" + toalTime);
        }
        private void doQuickSort() {
             arrayTemp = ArrayOperation.makeTempArray(array);
                startTime = System.nanoTime();
                sortingAlgoritham.quickSort(arrayTemp);
                endTime = System.nanoTime();
                toalTime = (endTime - startTime) / 1000000;
                tvQuickSortTime.setText("" + toalTime);
        }
        private void doInsertionSort() {
            arrayTemp = ArrayOperation.makeTempArray(array);
                startTime = System.nanoTime();
                SortingAlgoritham.insertionSort(arrayTemp);
                endTime = System.nanoTime();
                toalTime = (endTime - startTime) / 1000000;
                tvInsertionSortTime.setText("" + toalTime);
        }

        private void doMergeSort() {
            arrayTemp = ArrayOperation.makeTempArray(array);
                startTime = System.nanoTime();
                SortingAlgoritham.mergeSort(arrayTemp, 0, arrayTemp.length-1);
                endTime = System.nanoTime();
                toalTime = (endTime - startTime) / 1000000;
            tvMergeSortTime.setText("" + toalTime);
        }
        private void doHeapSort() {
            arrayTemp = ArrayOperation.makeTempArray(array);
                startTime = System.nanoTime();
                SortingAlgoritham.heapSort(arrayTemp);
                endTime = System.nanoTime();
                toalTime = (endTime - startTime) / 1000000;
            tvHeapSortTime.setText("" + toalTime);
        }
        



    public void doBenchMark(View view) {
        switch (view.getId()) {

            case R.id.btnBubbleSort :
                doBubbleSort();
                break;
            case R.id.btnSelectionSort :
               doSelectionSort();
                break;
            case R.id.btnQuickSort :
                doQuickSort();
                break;
            case R.id.btnInsertionSort :
                doInsertionSort();
                break;
            case R.id.btnMergeSort:
                doMergeSort();
                break;
            case R.id.btnHeapSort:
                doHeapSort();
                break;
            case R.id.btnBenchmarkAll :
                doBubbleSort();
                doSelectionSort();
                doQuickSort();
                doInsertionSort();
                doMergeSort();
                doHeapSort();
                break;

        }
    }

    public void generatArray(View view) {
    // code for disable key board
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    // end....
        int arraySize = 0;
        try {
            arraySize = Integer.parseInt(arrayLength.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getBaseContext(), "!oops  Fill array length", Toast.LENGTH_LONG).show();
            return;
        }

        switch (rdgComplexity.getCheckedRadioButtonId()) {
            case R.id.rbBestCase:
                array = ArrayOperation.generateSortedArray(arraySize);
                Toast.makeText(getBaseContext(), "Array of length " + arraySize + " created with Best case", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbAvarageCase:
                array = ArrayOperation.generateRandomArray(arraySize);
                Toast.makeText(getBaseContext(), "Array of length " + arraySize + " created with Avarage case", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbWorstCase:
                array = ArrayOperation.generateSortedArrayDesc(arraySize);

                Toast.makeText(getBaseContext(), "Array of length " + arraySize + " created with Worst case", Toast.LENGTH_SHORT).show();

                break;
        }
        arrayLength.setText("");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algo_benchmark);
        arrayLength = (EditText) findViewById(R.id.etArrayLength);
        rdgComplexity = (RadioGroup) findViewById(R.id.rdgComplexity);
        tvBubbleSortTime = (TextView) findViewById(R.id.tvBubbleSortTime);
        tvSelectionSortTime = (TextView) findViewById(R.id.tvSelectionSortTime);
        tvQuickSortTime = (TextView) findViewById(R.id.tvQuickSortTime);
        tvInsertionSortTime = (TextView) findViewById(R.id.tvInsertionSortTime);
        tvMergeSortTime = (TextView) findViewById(R.id.tvMergeSortTime);
        tvHeapSortTime = (TextView) findViewById(R.id.tvHeapSortTime);

        //Action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }

    }
}
