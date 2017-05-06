package com.elysewarren.addtofirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewProblem extends AppCompatActivity {

    RecyclerView problem;
    ProblemAdapter problemAdapter;
    List<Containproblems> containproblemsList = new ArrayList<>();
    private DatabaseReference mathDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_problem);

        mathDatabase = FirebaseDatabase.getInstance().getReference();

        problem = (RecyclerView) findViewById(R.id.problem_text_view);
        problem.setLayoutManager(new LinearLayoutManager(this));
        problem.setAdapter(problemAdapter);
        mathDatabase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, Object> problemMap = (HashMap<String, Object>) dataSnapshot.getValue();

                Map<String, Object> map = (Map<String, Object>) problemMap.get("Problem");
                for (Map.Entry<String, Object> entry1 : map.entrySet()) {

                    if (entry1 == null) continue;
                    HashMap<String, Object> map2 = (HashMap<String, Object>) entry1.getValue();
                    int i = 0;
                    Containproblems containproblems = new Containproblems();

                    for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
                        if (i == 0) {
                            containproblems.setAnswer((long) entry2.getValue());
                            i++;
                        } else if (i == 1) {
                            containproblems.setCorrect((boolean) entry2.getValue());
                            i++;
                        } else {
                            containproblems.setProblem((String) entry2.getValue());
                            containproblemsList.add(containproblems);
                        }
                    }
                }
                problemAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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