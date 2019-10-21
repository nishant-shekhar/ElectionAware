package com.nsappsstudio.electionaware;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.ViewHolderClass> {
    public List<MainMenuItems> mainMenuItems;
    public Context context;

    public MainMenuAdapter(List<MainMenuItems> mainMenuItems, Context context) {
        this.mainMenuItems = mainMenuItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item,parent,false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        MainMenuItems mainMenuItem=mainMenuItems.get(position);
        holder.optionName.setText(mainMenuItem.getOptionName());
        if (mainMenuItem.getCounter()==null){
            holder.counter.setVisibility(View.INVISIBLE);
        }else {
            holder.optionName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(context,Candidate.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(intent);
                }
            });
            holder.counter.setText(mainMenuItem.getCounter());
            holder.counter.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public int getItemCount() {
        return mainMenuItems.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        public TextView optionName;
        public TextView counter;
        public ConstraintLayout constraintLayout;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            optionName=itemView.findViewById(R.id.option_name);
            counter=itemView.findViewById(R.id.counter);
            constraintLayout=itemView.findViewById(R.id.main_item);

        }
    }
}
