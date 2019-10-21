package com.nsappsstudio.electionaware;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CandidateAdapter extends RecyclerView.Adapter<CandidateAdapter.ViewHolderClass> {

    public List<CandidateList> candidateLists;
    public Context context;

    public CandidateAdapter(List<CandidateList> candidateLists, Context context) {
        this.candidateLists = candidateLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.candidate_list, parent, false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {

        CandidateList candidateList =candidateLists.get(position);
        holder.name.setText(candidateList.getName());
        holder.qualification.setText(candidateList.getQualification());
        holder.partyName.setText(candidateList.getPartyName());

        switch (candidateList.getPartyName()){
            case "BJP":
                holder.partyIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.bjp));
                break;
            case "INC":
                holder.partyIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.congress));
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(context,CandidateProfile.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                    }
                });

                break;
            case "RJD":
                holder.partyIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.rjd));

                break;
            case "JDU":
                holder.partyIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.jdu));

                break;
            default:

                break;
        }

    }

    @Override
    public int getItemCount() {
        return candidateLists.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView partyName;
        private TextView qualification;
        private ImageView partyIcon;
        private ImageView dp;
        private CardView cardView;

        public ViewHolderClass(@NonNull View itemView) {

            super(itemView);
            name=itemView.findViewById(R.id.cl_name);
            partyName=itemView.findViewById(R.id.cl_party_name);
            qualification=itemView.findViewById(R.id.cl_qualification);
            partyIcon=itemView.findViewById(R.id.cl_partyIcon);
            dp=itemView.findViewById(R.id.cl_dp);
            cardView=itemView.findViewById(R.id.cl_cardview);

        }
    }
}
