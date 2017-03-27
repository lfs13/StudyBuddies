package edu.pitt.cs.cs1635.studybuddies;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Jason on 3/27/2017.
 */

public class CreateStudyGroupActivity extends AppCompatActivity {

    public static User currentUser = new User("user");

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navbar, menu);
        return true;
    }
    @Override

    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_study_group);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fav_button:
                Intent intent = new Intent(this, FavoritesActivity.class);
                ArrayList<String> favorites = new ArrayList<>();
                for(Group g : currentUser.getFavorites()){
                    favorites.add(g.toString());
                }
                intent.putExtra("favorites", favorites);
                startActivity(intent);
                return true;

            case R.id.home_button:
                //TODO
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
    public void confirmCreateGroup(View v){
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Are you sure you want to create this study group?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        createStudyGroup();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
    public void cancelAction(View v){
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Are you sure you want to cancel create a study group?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
    public void createStudyGroup(){
        EditText subject   = (EditText)findViewById(R.id.subject);
        EditText location   = (EditText)findViewById(R.id.location);
        EditText time   = (EditText)findViewById(R.id.time);
        EditText length   = (EditText)findViewById(R.id.length);

        StudyGroup g = new StudyGroup(subject.getText().toString(), location.getText().toString(),
                time.getText().toString(),length.getText().toString());
        Intent data = new Intent();
        data.putExtra("newStudyGroup", g);
        setResult(1,data);
        finish();
    }
}