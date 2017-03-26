package edu.pitt.cs.cs1635.studybuddies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class GroupQuestionListActivity extends AppCompatActivity implements View.OnClickListener{

    private static ArrayList<GroupQuestion> currQuestionList = new ArrayList<>();
    private static User user;
    private static Group group;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_questions);

        //create dummy questions
        createQuestions();

        //set list of buttons to groups
        updateAvailableQuestions(currQuestionList);

        //set up the dummy group buttons
        setDummyQuestionButtons();

        final EditText search = (EditText) findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                filterGroupQuestions(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.fav_button) {
            Intent intent = new Intent(this, FavoritesActivity.class);
            ArrayList<String> favorites = new ArrayList<>();
            for (Group g : user.getFavorites()) {
                favorites.add(g.toString());
            }
            intent.putExtra("favorites", favorites);
            startActivity(intent);
            return true;
        }
        if (id == R.id.home_button){
            Intent in = new Intent(this, MainActivity.class);
            startActivity(in);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navbar, menu);
        return true;
    }

    public static void setUser(User currentUser) {
        user = currentUser;
    }

    public static void setQList(ArrayList<GroupQuestion> qList){ currQuestionList = qList;}

    public static void setGroup(Group currentGroup) {
        group = currentGroup;
    }



    /**
     * Hard code some questions
     */
    public void createQuestions(){
        if(group.c2 <= 0){
            currQuestionList.add(new GroupQuestion("Why is the sky blue?"));
            currQuestionList.add(new GroupQuestion("What is the meaning of life"));
            group.c2++;
        }


    }

    /**
     * Update UI to reflect filtered questions
     * @param updatedQuestions filtered list of questions
     */
    public void updateAvailableQuestions(ArrayList<GroupQuestion> updatedQuestions){

        LinearLayout qList = (LinearLayout) findViewById(R.id.question_list);

        qList.removeAllViews();

        for(int i = 0; i < updatedQuestions.size(); i++){
            Button tempButton = new Button(this);
            GroupQuestion tempGroupQ = updatedQuestions.get(i);
            tempButton.setText(tempGroupQ.getQuestion());
            tempButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            qList.addView(tempButton);
        }
    }

    /**
     * create filtered question list and send to update method
     * @param s filter string
     */
    public void filterGroupQuestions(String s){
        if(s.length()==0){
            updateAvailableQuestions(currQuestionList);
        }
        else {
            ArrayList<GroupQuestion> filtered = new ArrayList<>();
            s = s.toLowerCase();
            for (int i = 0; i < currQuestionList.size(); i++) {
                GroupQuestion temp = currQuestionList.get(i);
                if (temp.getQuestion().toLowerCase().contains(s)) {
                    filtered.add(temp);
                }
            }
            updateAvailableQuestions(filtered);
        }
    }


    /**
     * Make the dummy question buttons clickable
     */
    private void setDummyQuestionButtons(){

        LinearLayout QuestionList = (LinearLayout) findViewById(R.id.question_list);

        for(Object obj: QuestionList.getTouchables()){
            if (obj instanceof Button) {
                Button tempButton = (Button) obj;
                tempButton.setClickable(true);
                tempButton.setFocusable(true);
                tempButton.setOnClickListener(this);

            }
        }
    }


    /**
     * Create the appropriate behavior for the dummy buttons upon being clicked
     * @param v
     */
    @Override
    public void onClick(View v) {

        ArrayList<GroupQuestion> g_list = currQuestionList;

        for(GroupQuestion g : g_list){

            if ( v instanceof Button) {

                String candidateBtnText = g.getQuestion().toLowerCase().trim();
                String viewText = ((Button) v).getText().toString().toLowerCase().trim();

                if(candidateBtnText.equals(viewText)){

                    /**
                     * NAVIGATE TO A QUESTION PAGE TO BE IMPLEMENTED
                     */

                }
            }
        }
    }

    /**
     * ADD A QUESTION PAGE TO BE IMPLEMENTED
     */
    public void addGroup(View v){
        //this is the add buttons onCLick method as defined in main_activity.xml
        Intent createGroup = new Intent(this, GroupQuestionListActivity.class);
       // startActivityForResult(createGroup, 1);
        startActivity(createGroup);

    }




}

