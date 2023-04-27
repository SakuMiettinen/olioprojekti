package com.example.olioprojekti;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CreateLutemonActivity extends MenuActivity {
    private String redLutemonRbName = "Punainen";
    private String greenLutemonRbName = "Vihreä";
    private String blackLutemonRbName = "Musta";
    private String greyLutemonRbName = "Harmaa";
    private String neonLutemonRbName = "Neon";
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_lutemon);
        getSupportActionBar().hide();
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

    public void OnRadioButtonClick(View view) {
        int selectedButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(selectedButtonId);
        ImageView image = (ImageView) findViewById(R.id.lutemonImage);
        if (rb.getText().equals(redLutemonRbName)) {
            image.setImageResource(R.drawable.red_icon);
        } else if (rb.getText().equals(greenLutemonRbName)) {
            image.setImageResource(R.drawable.green_icon);
        } else if (rb.getText().equals(blackLutemonRbName)) {
            image.setImageResource(R.drawable.black_icon);
        } else if (rb.getText().equals(greyLutemonRbName)) {
            image.setImageResource(R.drawable.grey_icon);
        } else if (rb.getText().equals(neonLutemonRbName)) {
            image.setImageResource(R.drawable.neon_icon);
        }
    }

    public void CreateLutemon(View view) {
        RadioGroup rg = findViewById(R.id.radioGroup);
        if (rg.getCheckedRadioButtonId() == -1) {

        } else {
            int selectedRbId = rg.getCheckedRadioButtonId();
            RadioButton selectedRb = findViewById(selectedRbId);
            String selectedRbText = (String) selectedRb.getText();
            Lutemon newLutemon;
            TextView nameInput = findViewById(R.id.LutemonName);
            Storage storage = Storage.getInstance();

            if (selectedRbText.equals(redLutemonRbName)) {
                String LutemonName = nameInput.getText().toString();
                newLutemon = new Red(LutemonName, Lutemon.getNumberOfCreatedLutemons());
                storage.addLutemon(newLutemon);
            } else if (selectedRbText.equals(greenLutemonRbName)) {
                String LutemonName = nameInput.getText().toString();
                newLutemon = new Green(LutemonName, Lutemon.getNumberOfCreatedLutemons());
                storage.addLutemon(newLutemon);
            } else if (selectedRbText.equals(greyLutemonRbName)) {
                String LutemonName = nameInput.getText().toString();
                newLutemon = new Grey(LutemonName, Lutemon.getNumberOfCreatedLutemons());
                storage.addLutemon(newLutemon);
            } else if (selectedRbText.equals(blackLutemonRbName)) {
                String LutemonName = nameInput.getText().toString();
                newLutemon = new Black(LutemonName, Lutemon.getNumberOfCreatedLutemons());
                storage.addLutemon(newLutemon);
            } else if (selectedRbText.equals(neonLutemonRbName)) {
                String LutemonName = nameInput.getText().toString();
                newLutemon = new Neon(LutemonName, Lutemon.getNumberOfCreatedLutemons());
                storage.addLutemon(newLutemon);
            }

        }
    }
}