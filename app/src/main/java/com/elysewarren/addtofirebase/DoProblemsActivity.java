package com.elysewarren.addtofirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;


public class DoProblemsActivity extends AppCompatActivity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference wpProblems = database.getReference("Problems");
    private ArrayList<MathProblem> mathProblemsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addProblem(View view) {
        String id = UUID.randomUUID().toString();
        MathProblem p = new MathProblem(id, "2 + 2 =", 4, true);
        mathProblemsArrayList.add(p);
        wpProblems.child(id).setValue(p);
    }

    public void removeProblem(View view) {
        if (mathProblemsArrayList.size() == 0) return;
        MathProblem p = mathProblemsArrayList.remove(0);
        wpProblems.child(p.id).removeValue();
    }

    public void openScoreBoard(View view) {
        Intent i = new Intent(this, ScoreBoard.class);
        startActivity(i);
    }

}
