package com.nsappsstudio.electionaware;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Candidate extends AppCompatActivity {

    private List<CandidateList> candidateLists=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);
        generateList();
    }
    private void generateList(){
        final RecyclerView recyclerView = findViewById(R.id.candidate_list);
        recyclerView.hasFixedSize();
        recyclerView.setVisibility(View.VISIBLE);
        RecyclerView.LayoutManager recyclerViewLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        CandidateList candidateList=new CandidateList("Vinay Kumar","BJP","M.Sc.");
        candidateLists.add(candidateList);
        candidateList=new CandidateList("Ajay Kumar","INC","Graduate");
        candidateLists.add(candidateList);
        candidateList=new CandidateList("Vijay Kumar","JDU","B.Tech.");
        candidateLists.add(candidateList);
        candidateList=new CandidateList("Sameer Kumar","RJD","M.Com.");
        candidateLists.add(candidateList);
        RecyclerView.Adapter adapter=new CandidateAdapter(candidateLists,this);
        recyclerView.setAdapter(adapter);
    }
}
