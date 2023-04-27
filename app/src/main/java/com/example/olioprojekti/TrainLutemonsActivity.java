package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class TrainLutemonsActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private int chosenLutemonId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_lutemons);
        getSupportActionBar().hide();
        RadioGroup trainingLutemonsGroup = (RadioGroup) findViewById(R.id.trainingLutemonsList);

        for (Lutemon lutemon : Storage.getInstance().getLutemons()) {
            if (lutemon.getLocation().equals("training")) {
                RadioButton newLutemon = new RadioButton(this);
                newLutemon.setHeight(50);
                newLutemon.setScaleX(0.75f);
                newLutemon.setScaleY(0.75f);
                newLutemon.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        chosenLutemonId = lutemon.getLutemonId();
                    }
                });
                newLutemon.setText(lutemon.getName() + " (" + lutemon.getType() + ")");
                trainingLutemonsGroup.addView(newLutemon);
            }
        }

    }

    public void trainChosenLutemon(View view) {
        TextView startTxt = findViewById(R.id.startTxt);
        TextView newAttack = findViewById(R.id.newAttack);
        TextView newDefence = findViewById(R.id.newDefence);
        TextView endTxt = findViewById(R.id.endTxt);
        Lutemon lutemonToTrain = Storage.getInstance().getLutemonById(chosenLutemonId);
        int randomMultiplier1 = ThreadLocalRandom.current().nextInt(0, 2);
        int randomMultiplier2 = ThreadLocalRandom.current().nextInt(0, 2);
        int lutemonNewAttack = lutemonToTrain.getAttack() + (lutemonToTrain.getExp() * randomMultiplier1);
        int lutemonNewDefence = lutemonToTrain.getDefence() + (lutemonToTrain.getExp() * randomMultiplier2);
        startTxt.setText("Aloitetaan harjoitus lutemonille " + lutemonToTrain.getName() + " (" + lutemonToTrain.getType() + ")");
        newAttack.setText("Hyökkäys kehittyi luvusta " + lutemonToTrain.getAttack() +" lukuun" + lutemonNewAttack);
        newDefence.setText("Puolustus kehittyi luvusta " + lutemonToTrain.getDefence() +" lukuun" + lutemonNewDefence);
        lutemonToTrain.setAttack(lutemonNewAttack);
        lutemonToTrain.setDefence(lutemonNewDefence);
        endTxt.setText("Treeni päättyy");
        Storage.getInstance().addLutemon(lutemonToTrain);
    }
}