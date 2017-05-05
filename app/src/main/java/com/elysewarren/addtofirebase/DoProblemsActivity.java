package com.elysewarren.addtofirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DoProblemsActivity extends AppCompatActivity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference wpProblems = database.getReference("Problems");
    private ArrayList<MathProblem> mathProblemsArrayList = new ArrayList<>();
    private TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_problems);
        displayText = (TextView) findViewById(R.id.problem_text_view);

        wpProblems.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mathProblemsArrayList.add(dataSnapshot.getValue(MathProblem.class));
                displayMathProblems();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void displayMathProblems() {
        String text = "";
        for (MathProblem mathProblem : mathProblemsArrayList)
            text += mathProblem + "\n";
        displayText.setText(text);
    }

    public void openScoreBoard(View view) {
        Intent i = new Intent(this, ScoreBoard.class);
        startActivity(i);
    }

}

