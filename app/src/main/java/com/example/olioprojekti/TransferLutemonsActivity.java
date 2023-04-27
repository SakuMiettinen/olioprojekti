package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class TransferLutemonsActivity extends AppCompatActivity {

    private LinearLayout lutemonsList;
    private ArrayList<Integer> chosenLutemonsIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_lutemons);
        lutemonsList  = findViewById(R.id.lutemonsList);
        chosenLutemonsIds = new ArrayList<Integer>();
    }

    public void onHomeButtonClick(View view) {
        lutemonsList.removeAllViews();
        chosenLutemonsIds.clear();
        for (Lutemon lutemon : Storage.getInstance().getLutemons()) {
            if (lutemon.getLocation().equals("home")) {
                CheckBox newLutemon = new CheckBox(this);
                newLutemon.setHeight(50);
                newLutemon.setScaleX(0.75f);
                newLutemon.setScaleY(0.75f);
                newLutemon.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (((CheckBox) v).isChecked()) {
                            chosenLutemonsIds.add(lutemon.getLutemonId());
                        } else {
                            chosenLutemonsIds.remove(Integer.valueOf(lutemon.getLutemonId()));
                        }
                    }
                });
                newLutemon.setText(lutemon.getName() + " (" + lutemon.getType() + ")");
                lutemonsList.addView(newLutemon);
            }
        }
    }

    public void onBattleButtonClick(View view) {
        lutemonsList.removeAllViews();
        chosenLutemonsIds.clear();
        for (Lutemon lutemon : Storage.getInstance().getLutemons()) {
            if (lutemon.getLocation().equals("battle")) {
                CheckBox newLutemon = new CheckBox(this);
                newLutemon.setHeight(50);
                newLutemon.setScaleX(0.75f);
                newLutemon.setScaleY(0.75f);
                newLutemon.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (((CheckBox) v).isChecked()) {
                            chosenLutemonsIds.add(lutemon.getLutemonId());
                        } else {
                            chosenLutemonsIds.remove(Integer.valueOf(lutemon.getLutemonId()));
                        }
                    }
                });
                newLutemon.setText(lutemon.getName() + " (" + lutemon.getType() + ")");
                lutemonsList.addView(newLutemon);
            }
        }
    }

    public void onTrainingButtonClick(View view) {
        lutemonsList.removeAllViews();
        chosenLutemonsIds.clear();
        for (Lutemon lutemon : Storage.getInstance().getLutemons()) {
            if (lutemon.getLocation().equals("training")) {
                CheckBox newLutemon = new CheckBox(this);
                newLutemon.setHeight(50);
                newLutemon.setScaleX(0.75f);
                newLutemon.setScaleY(0.75f);
                newLutemon.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (((CheckBox) v).isChecked()) {
                            chosenLutemonsIds.add(lutemon.getLutemonId());
                        } else {
                            chosenLutemonsIds.remove(Integer.valueOf(lutemon.getLutemonId()));
                        }
                    }
                });
                newLutemon.setText(lutemon.getName() + " (" + lutemon.getType() + ")");
                lutemonsList.addView(newLutemon);
            }
        }
    }

    public void transferLutemons(View view) {
        RadioGroup optionsRadioGroup = findViewById(R.id.optionsGroup);
        int selectedButtonId = optionsRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedOptionRb = (RadioButton) findViewById(selectedButtonId);
        String selectedLocation;
        switch(selectedOptionRb.getText().toString()) {
            case "Kotiin":
                selectedLocation = "home";
                break;
            case "Taistelemaan":
                selectedLocation = "battle";
                break;
            case "Treenaamaan":
                selectedLocation = "training";
                break;
            default:
                selectedLocation = "";
        }
        for (Lutemon lutemon : Storage.getInstance().getLutemons()) {
            if (chosenLutemonsIds.contains(lutemon.getLutemonId())) {
                lutemon.setLocation(selectedLocation);
            }
        }
        lutemonsList.removeAllViews();
        chosenLutemonsIds.clear();
    }

}