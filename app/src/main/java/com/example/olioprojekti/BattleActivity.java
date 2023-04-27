package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {

    private LinearLayout battleLutemonsList;
    private ArrayList<Integer> chosenLutemonsIds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        getSupportActionBar().hide();
        battleLutemonsList  = findViewById(R.id.battleLutemonsList);
        chosenLutemonsIds = new ArrayList<>();

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
                battleLutemonsList.addView(newLutemon);
            }
        }


    }

    public void battle(View view) {
        TextView warningText = findViewById(R.id.warningText);
        if (chosenLutemonsIds.size() > 2 || chosenLutemonsIds.size() < 2) {
            warningText.setText("Valitse 2 Lutemonia taisteluun!");
        } else {
            warningText.setText("");
            LinearLayout battleOutcome = findViewById(R.id.battleOutcome);

            Lutemon lutemon1 = Storage.getInstance().getLutemonById(chosenLutemonsIds.get(0));
            Lutemon lutemon2 = Storage.getInstance().getLutemonById(chosenLutemonsIds.get(1));
            int currentRound = 3;

            while (lutemon1.getHealth() > 0 && lutemon2.getHealth() > 0) {
                TextView firstLutemonInfo = new TextView(this);
                TextView secondLutemonInfo = new TextView(this);
                TextView attackText = new TextView(this);
                TextView outcomeText = new TextView(this);
                switch (currentRound % 2) {
                    case 1:
                        // Make lutemon1 attack lutemon2
                        firstLutemonInfo.setText(lutemon1.getName() + " (" + lutemon1.getType() + ") hyö: " + lutemon1.getAttack() + ", puo: " + lutemon1.getDefence() + ", kok: " + lutemon1.getExp() + ", eläm: " + lutemon1.getHealth());
                        secondLutemonInfo.setText(lutemon2.getName() + " (" + lutemon2.getType() + ") hyö: " + lutemon2.getAttack() + ", puo: " + lutemon2.getDefence() + ", kok: " + lutemon2.getExp() + ", eläm: " + lutemon2.getHealth());
                        attackText.setText(lutemon1.getName() + " (" + lutemon1.getType() + ") hyökkää lutemoniin " + lutemon2.getName() + " (" + lutemon2.getType() + ")" );
                        lutemon2.defend((int) (lutemon1.getAttack() * (Math.random() * 2)));
                        battleOutcome.addView(firstLutemonInfo);
                        battleOutcome.addView(secondLutemonInfo);
                        battleOutcome.addView(attackText);
                        if (lutemon2.getHealth() > 0) {
                            outcomeText.setText(lutemon2.getName() + " (" + lutemon2.getType() + ") onnistuu välttämään kuoleman");
                            battleOutcome.addView(outcomeText);
                        } else {
                            outcomeText.setText(lutemon2.getName() + " (" + lutemon2.getType() + ") kuolee");
                            battleOutcome.addView(outcomeText);
                        }
                        break;
                    case 0:
                        // Make lutemon2 attack lutemon2
                        secondLutemonInfo.setText(lutemon1.getName() + " (" + lutemon1.getType() + ") hyö: " + lutemon1.getAttack() + ", puo: " + lutemon1.getDefence() + ", kok: " + lutemon1.getExp() + ", eläm: " + lutemon1.getHealth());
                        firstLutemonInfo.setText(lutemon2.getName() + " (" + lutemon2.getType() + ") hyö: " + lutemon2.getAttack() + ", puo: " + lutemon2.getDefence() + ", kok: " + lutemon2.getExp() + ", eläm: " + lutemon2.getHealth());
                        attackText.setText(lutemon2.getName() + " (" + lutemon2.getType() + ") hyökkää lutemoniin " + lutemon1.getName() + " (" + lutemon1.getType() + ")" );
                        lutemon1.defend((int) (lutemon2.getAttack() * (Math.random() * 2)));
                        battleOutcome.addView(firstLutemonInfo);
                        battleOutcome.addView(secondLutemonInfo);
                        battleOutcome.addView(attackText);
                        if (lutemon1.getHealth() > 0) {
                            outcomeText.setText(lutemon1.getName() + " (" + lutemon1.getType() + ") onnistuu välttämään kuoleman");
                            battleOutcome.addView(outcomeText);
                        } else {
                            outcomeText.setText(lutemon1.getName() + " (" + lutemon1.getType() + ") kuolee");
                            battleOutcome.addView(outcomeText);
                        }
                        break;
                }
                currentRound++;
            }
            TextView endText = new TextView(this);
            endText.setText("Taistelu on ohi");
            battleOutcome.addView(endText);
            if (lutemon1.getHealth() > 0) {
                lutemon1.setHealth(lutemon1.getMaxHealth());
                lutemon1.incrementExp();
                lutemon1.setLocation("home");
                Storage.getInstance().addLutemon(lutemon1);
            } else if (lutemon2.getHealth() > 0) {
                lutemon2.setHealth(lutemon2.getMaxHealth());
                lutemon1.incrementExp();
                lutemon1.setLocation("home");
                Storage.getInstance().addLutemon(lutemon2);
            }

        }



    }


}