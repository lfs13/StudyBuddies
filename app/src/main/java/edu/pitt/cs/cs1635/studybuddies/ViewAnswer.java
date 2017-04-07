package edu.pitt.cs.cs1635.studybuddies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by nick on 3/26/17.
 */
public class ViewAnswer extends AppCompatActivity{
    private GroupQuestion question;
    private ArrayList<GroupAnswer> updatedAnswers;
    protected static ArrayList<GroupQuestion> currQuestionList = GroupQuestionListActivity.currQuestionList;//way to access static variable using dot operator.
    private int index = -1;
    /*
    Sets the question and the answer to view on the view question page.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_answers);


        final EditText search = (EditText) findViewById(R.id.search);

        Intent i = getIntent();
        question = (GroupQuestion) i.getSerializableExtra("sampleObject");
        this.index = (int) i.getSerializableExtra("index");
        TextView myAwesomeTextView = (TextView)findViewById(R.id.TEXT_STATUS_ID);
        myAwesomeTextView.setText(question.getQuestion() + "?");
        TextView myAwesomeTextView2 = (TextView)findViewById(R.id.TEXT_STATUS_ID2);
        updatedAnswers = question.getAnswerList();
        updateAvailableAnswers(question.getAnswerList());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button button = (Button)findViewById(R.id.add_answer);

        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //System.out.println("HERE");
                        addAnswer();

                    }
                }
        );
    }

    private void addAnswer() {
        Intent i = new Intent(this, AnswerQuestion.class);
        i.putExtra("sampleObject", question);
        i.putExtra("answeredAlready", true);
        startActivityForResult(i, 1);
    }

    /**
     * Update UI to reflect filtered questions
     * @param updatedAnswers filtered list of questions
    */
    public void updateAvailableAnswers(ArrayList<GroupAnswer> updatedAnswers){

        LinearLayout qList = (LinearLayout) findViewById(R.id.answer_list);

        qList.removeAllViews();

        for(int i = 0; i < updatedAnswers.size(); i++){

            Button tempButton = new Button(this);
            GroupAnswer tempAnswer = updatedAnswers.get(i);
            tempButton.setText(tempAnswer.getAnswer());
            tempButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            qList.addView(tempButton);

        }
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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String stredittext=data.getStringExtra("sampleObject");
                System.out.println("Right here: " + stredittext);
                question.addAddAnswer(new GroupAnswer(stredittext));
                question.setAnswered(true);
                updateAnswered();

            }
        }
    }

    public void updateAnswered(){
        int k = 0;
        Iterator<GroupAnswer> iter = updatedAnswers.iterator();

        while (iter.hasNext()) {
            GroupAnswer tempQuest = iter.next();

            if (tempQuest.getAnswer().equals(question.getQuestion()))
                iter.remove();

        }

        updatedAnswers = question.getAnswerList();
        currQuestionList.set(index,question);

        updateAvailableAnswers(updatedAnswers);
    }

}
