package edu.pitt.cs.cs1635.studybuddies;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class GroupQuestionListActivity extends AppCompatActivity {
    private static ArrayList<GroupQuestion> currQuestionList = new ArrayList<>() ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_group_questions);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*
        Working on this - adapting from favorites activity
         */
      //  ListView qs = (ListView) findViewById(R.id.Question_list);
       //   Bundle b = getIntent().getExtras();
      //  ArrayList<String> favorites = (ArrayList<String>) b.getSerializable("favorites");
     //   ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, currQuestionList);
     ///   favs.setAdapter(itemsAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void setQList(ArrayList<GroupQuestion> qList){ currQuestionList = qList;}


}

