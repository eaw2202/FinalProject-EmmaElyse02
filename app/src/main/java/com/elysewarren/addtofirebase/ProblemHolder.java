package com.elysewarren.addtofirebase;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by cmltdstudent on 5/8/17.
 */

public class ProblemHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private Context context;

        public TextView problem;
        public TextView answer;
        public TextView correct;

        public ProblemHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            this.context = itemView.getContext();
            problem = (TextView) itemView.findViewById(R.id.problem);
            answer = (TextView) itemView.findViewById(R.id.answer);
            correct = (TextView) itemView.findViewById(R.id.correct);

        }

        public void bind(final Containproblems containproblems){
            problem.setText(containproblems.problem);
            answer.setText("Answer: " + containproblems.answer);
            answer.setText("Correct? " + containproblems.correct);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, problem.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

