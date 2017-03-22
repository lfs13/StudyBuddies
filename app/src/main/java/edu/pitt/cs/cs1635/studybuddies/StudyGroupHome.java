package edu.pitt.cs.cs1635.studybuddies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class StudyGroupHome extends AppCompatActivity implements View.OnClickListener{

    private Button submitButton;
    private TextView studyGroupName;
    private TextView floor;
    private TextView timeRemaining;
    private TextView chat;
    private EditText submitChat;
    private String chatText = "";

    Intent inIntent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_group_home);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //set the buttons to correspond to the correct ids
        studyGroupName = (TextView) findViewById(R.id.studyGroupNameHeader);
        floor = (TextView) findViewById(R.id.floor);
        timeRemaining = (TextView) findViewById(R.id.timeRemaining);
        chat = (TextView) findViewById(R.id.chat);
        submitChat = (EditText) findViewById(R.id.submitChat);
        submitButton = (Button) findViewById(R.id.submitButton);


        studyGroupName.setText("Homework Help");
        floor.setText("Floor 3");
        timeRemaining.setText("2 hours remaining");
        chatText = chatText + "User1 has joined Homework Help";
        chat.setText(chatText);

        //set onClick listeners for the buttons
        submitButton.setOnClickListener(StudyGroupHome.this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
//        if (id == R.id.fav_button) {
//            Intent intent = new Intent(this, FavoritesActivity.class);
//            ArrayList<String> favorites = new ArrayList<>();
//            for (Group g : user.getFavorites()) {
//                favorites.add(g.toString());
//            }
//            intent.putExtra("favorites", favorites);
//            startActivity(intent);
//            return true;
//        }
        if (id == R.id.home_button) {
            Intent in = new Intent(this, MainActivity.class);
            startActivity(in);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
    }

}
