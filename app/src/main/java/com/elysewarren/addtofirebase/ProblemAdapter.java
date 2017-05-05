package com.elysewarren.addtofirebase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProblemAdapter extends RecyclerView.Adapter<ProblemAdapter.ProblemHolder> {


    private List<Containproblems> containproblemsList = new ArrayList<>();
    private Context context;

    public ProblemAdapter(Context context, List<Containproblems> containproblemsList) {
        this.containproblemsList = containproblemsList;
        this.context = context;
    }

    @Override
    public ProblemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProblemHolder(LayoutInflater.from(context).inflate(R.layout.activity_problem_adapter, parent, false));

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

    public static class ProblemHolder extends RecyclerView.ViewHolder {

        public TextView problem;
        public TextView answer;

        public ProblemHolder(View itemView) {
            super(itemView);
            problem = (TextView) itemView.findViewById(R.id.problem);
            answer = (TextView) itemView.findViewById(R.id.answer);
        }
    }
}