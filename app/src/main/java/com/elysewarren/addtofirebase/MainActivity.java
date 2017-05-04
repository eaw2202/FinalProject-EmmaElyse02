package com.elysewarren.addtofirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        authListener = new FirebaseAuth.AuthStateListener()

                //    // onClick
//    public void set(View view) {
//        mathRef.push().setValue(new MathProblem("Two fish swam up to four more fish. How many fish are all together? \n", 6, true));
//        mathRef.push().setValue(new MathProblem("There are 5 seals. 5 more come. How many seals are there?\n", 10 , true));
//        mathRef.push().setValue(new MathProblem("Dolphin had 10 clams. He ate 6 for lunch. How many more clams does dolphin have? \n", 4, true));
//        mathRef.push().setValue(new MathProblem("Some fish were swimming, and then 15 joined them. Now there are 57. How many fish started out swimming? \n", 42, true));
//        mathRef.push().setValue(new MathProblem("9-4\n", 5, true));
//        mathRef.push().setValue(new MathProblem("5+9\n", 14 , true));
//        mathRef.push().setValue(new MathProblem("1x2 \n", 2, true));
//        mathRef.push().setValue(new MathProblem("2x4 \n", 8, true));
//
//    }
        {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null)
                    startActivity(new Intent(MainActivity.this, SignUp.class));
            }
        };
}

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        auth.removeAuthStateListener(authListener);
    }

    public void signOut(View view) {
        auth.signOut();
    }
}