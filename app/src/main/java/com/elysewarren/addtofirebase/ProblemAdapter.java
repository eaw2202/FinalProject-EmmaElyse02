package com.elysewarren.addtofirebase;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

public class ProblemAdapter extends FirebaseRecyclerAdapter<Containproblems, ProblemHolder> {


    private List<Containproblems> containproblemsList = new ArrayList<>();
    private Context context;

//    public ProblemAdapter(Context context, List<Containproblems> containproblemsList) {
//        this.containproblemsList = containproblemsList;
//        this.context = context;
//    }

    public ProblemAdapter (Query ref){
        super(Containproblems.class, R.layout.card_view_problem, ProblemHolder.class, ref);
    }

    protected void populateViewHolder(ProblemHolder viewHolder, Containproblems containproblems, int position)
    {
        viewHolder.bind(containproblems);
    }
    @Override
    public ProblemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProblemHolder(LayoutInflater.from(context).inflate(R.layout.card_view_problem, parent, false));

    }

    @Override
    public void onBindViewHolder(ProblemHolder holder, int position) {
        final Containproblems containproblems = containproblemsList.get(position);
        if (containproblems != null) {
            holder.problem.setText(containproblems.problem);
            holder.answer.setText(String.valueOf(containproblems.answer));
        }
    }

    @Override
    public int getItemCount() {
        return containproblemsList != null ? containproblemsList.size() : 0;
    }




}