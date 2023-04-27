package com.example.olioprojekti;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    ImageView lutemon_image;
    TextView lutemon_name_and_type;
    TextView lutemon_attack;
    TextView lutemon_defence;
    TextView lutemon_health;
    TextView lutemon_exp;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemon_name_and_type = itemView.findViewById(R.id.txtLutemonNameAndType);
        lutemon_attack = itemView.findViewById(R.id.txtAttack);
        lutemon_defence = itemView.findViewById(R.id.txtDefence);
        lutemon_health = itemView.findViewById(R.id.txtHealth);
        lutemon_exp = itemView.findViewById(R.id.txtExp);
        lutemon_image = itemView.findViewById(R.id.ivLutemonImage);
    }
}
