package com.example.cavicardan.guifun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import static android.text.InputType.TYPE_CLASS_TEXT;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioG;
    private RadioButton radioB;
    private TextView textLabel;
    private TextView textLabel2;
    private EditText editText;
    private EditText passText;
    private Button button;
    private Switch switcher;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLabel = (TextView) findViewById(R.id.textView2);
        editText = (EditText) findViewById(R.id.editText);
        textLabel2= (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        radioG= (RadioGroup) findViewById(R.id.radioGr1);
        switcher=(Switch) findViewById(R.id.switch1);
        passText=(EditText) findViewById(R.id.PassText);
        //Dokładamy rzeczy do spinnera
       spinner=(Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.country_arrays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        //robimy coś z tym że wybraliśmy coś z radio buttonów
        addListenerRadioButtons();

        addListenerToButton();

        addListenerToSwitch();

        addListenerToSpinner();

    }

    private void addListenerToSpinner() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textLabel2.setText(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                textLabel2.setText("");
            }
        });
    }

    private void addListenerToSwitch() {
        switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    passText.setInputType( TYPE_CLASS_TEXT);
                    passText.setSelection(passText.getText().length());
                }else{
                    passText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD );
                    passText.setSelection(passText.getText().length());

                }
            }
        });
    }

    private void addListenerToButton() {
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                textLabel.setText(editText.getText());
            }
        });

    }

    private void addListenerRadioButtons() {
        radioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioB=(RadioButton) findViewById(radioG.getCheckedRadioButtonId());
                textLabel.setText(radioB.getText());
            }
        });

    }
}
