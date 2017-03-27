package edu.pitt.cs.cs1635.studybuddies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nick on 3/26/17.
 */
public class ViewAnswer extends AppCompatActivity{



    /*
    Sets the question and the answer to view on the view question page.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_answers);


        final EditText search = (EditText) findViewById(R.id.search);

        Intent i = getIntent();
        GroupQuestion question = (GroupQuestion) i.getSerializableExtra("sampleObject");
        TextView myAwesomeTextView = (TextView)findViewById(R.id.TEXT_STATUS_ID);
        myAwesomeTextView.setText(question.getQuestion() + "?");
        TextView myAwesomeTextView2 = (TextView)findViewById(R.id.TEXT_STATUS_ID2);
        myAwesomeTextView2.setText(question.getAnswerList().get(0));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




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
        if (id == R.id.fav_button) {
            Toast.makeText(this, "Favorites Not Available from this screen", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.home_button) {
            Intent in = new Intent(this, MainActivity.class);
            startActivity(in);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
