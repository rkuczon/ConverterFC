package com.kuczon.converterfc;
import android.app.Activity;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends Activity
        implements TextView.OnEditorActionListener{

    private EditText FEdit;
    private TextView FLabel;
    private TextView cLabel;
    private TextView CTotalLabel;
    private String FeditTotalString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FEdit = (EditText) findViewById(R.id.FEdit);
        FLabel = (TextView) findViewById(R.id.FLabel);
        cLabel = (TextView) findViewById(R.id.cLabel);
        CTotalLabel = (TextView) findViewById(R.id.CTotalLabel);


        FEdit.setOnEditorActionListener(this);
    }
    @Override
    public boolean onEditorAction (TextView v, int actionId, KeyEvent event) {

        if (actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calculateAndDisplay();
        }
        return false;
    }

    private void calculateAndDisplay() {

        FeditTotalString = FEdit.getText().toString();
        float FAmount;
        if(FeditTotalString.equals("")) {
            FAmount = 0;
        }
        else {
            FAmount =Float.parseFloat(FeditTotalString);
        }
       Float CAmounttotal = (FAmount-32) * 5/9;

        NumberFormat degrees = NumberFormat.getNumberInstance();
        CTotalLabel.setText(degrees.format(CAmounttotal));
    }

}
