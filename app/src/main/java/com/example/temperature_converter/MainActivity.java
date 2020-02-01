package com.example.temperature_converter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;


public class MainActivity extends AppCompatActivity {

    private Button mConvertButton;

    private EditText editText;
    private TextView textView;
    private TextView textView2;
    private RadioGroup radioSrcGroup;
    private RadioGroup radioTgtGroup;

    private RadioButton radioSrcButton;
    private RadioButton radioTgtButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mConvertButton = (Button) findViewById(R.id.convert_button);
        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                radioSrcGroup = (RadioGroup) findViewById(R.id.rbtngrpSrc);
                radioTgtGroup = (RadioGroup) findViewById(R.id.rbtngrpTgt);


                int selectedSrcId = radioSrcGroup.getCheckedRadioButtonId();
                int selectedTgtId = radioTgtGroup.getCheckedRadioButtonId();


                radioSrcButton = (RadioButton) findViewById(selectedSrcId);
                radioTgtButton = (RadioButton) findViewById(selectedTgtId);

                editText = (EditText) findViewById(R.id.enteredValue);
                textView = (TextView) findViewById(R.id.resultValue);
                textView2 = (TextView) findViewById(R.id.resultValue2);

                if (radioSrcButton.getText() == radioTgtButton.getText() || TextUtils.isEmpty(editText.getText())) {
                    Toast.makeText(MainActivity.this,"ERROR! No Conversion Requested.", Toast.LENGTH_SHORT).show();
                    double temperatureValue = Double.parseDouble(editText.getText().toString());
                    java.text.DecimalFormat decimalFormatter = new java.text.DecimalFormat("0.##");
                    textView.setText(decimalFormatter.format(temperatureValue));
                } else {
                    double temperatureValue = Double.parseDouble(editText.getText().toString());
                    double conversion = 0.0;
                    String conversion2 ="";

                    java.lang.CharSequence sSource = radioSrcButton.getText();
                    sSource = String.valueOf(sSource);
                    java.lang.CharSequence sTarget = radioTgtButton.getText();
                    sTarget = String.valueOf(sTarget);

                    if (sSource.equals("Celsius") && sTarget.equals("Fahrenheit")) {
                        conversion = ConvertTemp.c2f(temperatureValue);
                        conversion2 = "[F] = ([C] X 9/5)+32";
                    } else if ((sSource.equals("Celsius") && sTarget.equals("Kelvin"))) {
                        conversion = ConvertTemp.c2k(temperatureValue);
                        conversion2 = "[k] = [C]+273.15";
                    } else if ((sSource.equals("Celsius") && sTarget.equals("Rankine"))) {
                        conversion = ConvertTemp.c2r(temperatureValue);
                        conversion2 = "[R] = [C] * 9/5 + 491.67";
                    } else if ((sSource.equals("Fahrenheit") && sTarget.equals("Celsius"))) {
                        conversion = ConvertTemp.f2c(temperatureValue);
                        conversion2 = "[C] = ([F]-32) * 5/9]";
                    } else if ((sSource.equals("Fahrenheit") && sTarget.equals("Kelvin"))) {
                        conversion = ConvertTemp.f2k(temperatureValue);
                        conversion2 = "[K] = ([F]-32) * 5/9 + 273.15";
                    } else if ((sSource.equals("Fahrenheit") && sTarget.equals("Rankine"))) {
                        conversion = ConvertTemp.f2r(temperatureValue);
                        conversion2 = "[R] = [F] + 459.67";
                    } else if ((sSource.equals("Kelvin") && sTarget.equals("Celsius"))) {
                        conversion = ConvertTemp.k2c(temperatureValue);
                        conversion2 = "[C] = K - 273.15";
                    } else if ((sSource.equals("Kelvin") && sTarget.equals("Fahrenheit"))) {
                        conversion = ConvertTemp.k2f(temperatureValue);
                        conversion2 = "[F] = ([K]-273.15) * 9/5 + 32";
                    } else if ((sSource.equals("Kelvin") && sTarget.equals("Rankine"))) {
                        conversion = ConvertTemp.k2r(temperatureValue);
                        conversion2 = "[R] = [K] * 1.8";
                    } else if ((sSource.equals("Rankine") && sTarget.equals("Celsius"))) {
                        conversion = ConvertTemp.r2c(temperatureValue);
                        conversion2 = "[C] = ([R] - 491.67) * 5/9";
                    } else if ((sSource.equals("Rankine") && sTarget.equals("Fahrenheit"))) {
                        conversion = ConvertTemp.r2f(temperatureValue);
                        conversion2 = "[F] = [R] - 459.67 ";
                    } else if ((sSource.equals("Rankine") && sTarget.equals("Kelvin"))) {
                        conversion = ConvertTemp.r2k(temperatureValue);
                        conversion2= "[K] = [R] * 5/9";
                    }


                    java.text.DecimalFormat decimalFormatter = new java.text.DecimalFormat("0.##");
                    textView.setText(decimalFormatter.format(conversion));
                    textView2.setText(conversion2);

                }
            }
        });
    }
}
