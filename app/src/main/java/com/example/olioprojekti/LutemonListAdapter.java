package com.example.olioprojekti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        switch (lutemons.get(position).getType()) {
            case "neon":
                holder.lutemon_image.setImageResource(R.drawable.neon_icon);
                break;
            case "vihreä":
                holder.lutemon_image.setImageResource(R.drawable.green_icon);
                break;
            case "punainen":
                holder.lutemon_image.setImageResource(R.drawable.red_icon);
                break;
            case "musta":
                holder.lutemon_image.setImageResource(R.drawable.black_icon);
                break;
            case "harmaa":
                holder.lutemon_image.setImageResource(R.drawable.grey_icon);
                break;
        }
        holder.lutemon_name_and_type.setText(lutemons.get(position).getName() + " ("+ lutemons.get(position).getType() + ")");
        holder.lutemon_attack.setText("Hyökkäys: " + lutemons.get(position).getAttack());
        holder.lutemon_defence.setText("Puolustus: " + lutemons.get(position).getDefence());
        holder.lutemon_health.setText("Elämäpisteet: " + lutemons.get(position).getHealth() + "/" + lutemons.get(position).getMaxHealth());
        holder.lutemon_exp.setText("Kokemuspisteet " + lutemons.get(position).getExp());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
