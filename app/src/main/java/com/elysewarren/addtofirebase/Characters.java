package com.elysewarren.addtofirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Characters extends AppCompatActivity {
    private ImageButton fishChar;
    private ImageButton dolphinChar;
    private ImageButton octupusChar;
    private ImageButton whaleChar;

    public ImageButton getFishChar() {
        return fishChar;
    }

    public ImageButton getDolphinChar() {
        return dolphinChar;
    }

    public ImageButton getOctupusChar() {
        return octupusChar;
    }

    public ImageButton getWhaleChar() {
        return whaleChar;
    }

    public void setFishChar(ImageButton fishChar) {
        this.fishChar = fishChar;
    }

    public void setDolphinChar(ImageButton dolphinChar) {
        this.dolphinChar = dolphinChar;
    }

    public void setOctupusChar(ImageButton octupusChar) {
        this.octupusChar = octupusChar;
    }

    public void setWhaleChar(ImageButton whaleChar) {
        this.whaleChar = whaleChar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);

        fishChar = (ImageButton) findViewById(R.id.fish_pic);
        dolphinChar = (ImageButton) findViewById(R.id.dolphin_pic);
        octupusChar = (ImageButton) findViewById(R.id.octupus_pic);
        whaleChar = (ImageButton) findViewById(R.id.whale_pic);
    }


    public void openDoProblems(View view)
    {
        Intent i = new Intent(this, DoProblemsActivity.class);
        startActivity(i);
    }
//    public void openDoProblems(View view) {
//        Intent i = new Intent(this, DoProblemsActivity.class);
//        startActivity(i);
//        Toast t = Toast.makeText(this, "READY TO DIVE IN?", Toast.LENGTH_SHORT);
//        t.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);
//        t.show();
//    }

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
