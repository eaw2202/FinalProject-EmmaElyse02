package com.elysewarren.addtofirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.UUID;


public class DoProblemsActivity extends AppCompatActivity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference wpProblems = database.getReference("Problems");
    private ArrayList<Containproblems> mathProblemsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_problems);


    }

    public void addProblem(View view) {
        String id = UUID.randomUUID().toString();
        Containproblems p = new Containproblems();
        mathProblemsArrayList.add(p);
        wpProblems.child(id).setValue(p);
    }

    public void removeProblem(View view) {
        if (mathProblemsArrayList.size() == 0) return;
        Containproblems p = mathProblemsArrayList.remove(0);
        wpProblems.child(p.getProblem()).removeValue();
    }

    public void openScoreBoard(View view) {
        Intent i = new Intent(this, ScoreBoard.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_item_save:
                Toast.makeText(this, "Save Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_item_settings:
                Toast.makeText(this, "Setting Clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
