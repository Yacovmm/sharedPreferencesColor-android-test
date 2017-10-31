package com.yacov.preferencescoloruser;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonSelected;
    private Button saveButton;
    private RelativeLayout layout;

    private static final String FILE_PREFERENCES = "FilePreference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupID);
//        radioButtonSelected = (RadioButton) findViewById(R.id.)
        saveButton = (Button) findViewById(R.id.button);
        layout = (RelativeLayout) findViewById(R.id.layoutID);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();
                radioButtonSelected = (RadioButton) findViewById( idRadioButtonEscolhido);

                radioButtonSelected.getText().toString();

                if (idRadioButtonEscolhido > 0){

                    radioButtonSelected = (RadioButton) findViewById( idRadioButtonEscolhido);

                    SharedPreferences sharedPreferences = getSharedPreferences(FILE_PREFERENCES, 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    String corEscolhida = radioButtonSelected.getText().toString();
                    editor.putString("corEscolhida", corEscolhida);
                    editor.commit();

                    setBackground(corEscolhida);

                }

            }
        });

        //Restaure the saved color
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_PREFERENCES, 0);
        if (sharedPreferences.contains("corEscolhida")){
            String colorRestaured = sharedPreferences.getString("corEscolhida", "Laranja");
            setBackground(colorRestaured);
        }
    }

    private void setBackground(String color){

        if (color.equals("Azul")){
            layout.setBackgroundColor(Color.parseColor("#8cabf2"));
        }else if (color.equals("Laranja")){
            layout.setBackgroundColor(Color.parseColor("#ff960c"));
        }else if (color.equals("Verde")){
            layout.setBackgroundColor(Color.parseColor("#43ff00"));
        }
    }
}
