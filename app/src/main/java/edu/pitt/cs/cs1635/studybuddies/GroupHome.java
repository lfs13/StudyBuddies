package edu.pitt.cs.cs1635.studybuddies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.Window;
import android.content.Intent;
import android.widget.TextView;

import java.util.ArrayList;


public class GroupHome extends AppCompatActivity implements View.OnClickListener {

    private Button studyGroupListButton;
    private Button groupQButton;
    private static Group group;
    private static User user;
    //private static ArrayList<GroupQuestion> currQuestionList = new ArrayList<>() ;
    private TextView groupNameDisp;
    private TextView numMemsDisp;


    Intent inIntent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_group_home);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //set the buttons to correspond to the correct ids
        studyGroupListButton = (Button) findViewById(R.id.studyGroupsButton);
        groupQButton = (Button) findViewById(R.id.groupQsButton);

        //set onClick listeners for the buttons
        studyGroupListButton.setOnClickListener(GroupHome.this);
        groupQButton.setOnClickListener(GroupHome.this);

        //get the group name and number of members in the library views
        groupNameDisp = (TextView) findViewById(R.id.groupNameHeader);
        numMemsDisp = (TextView) findViewById(R.id.textView2);

        //get the group name and number of member in the library
        String name = group.getName();
        String numOfMembers = group.getNumMembers() + "";

        //set the group name and number of member in the library
        groupNameDisp.setText(name);
        numMemsDisp.setText(numOfMembers);

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
            Intent intent = new Intent(this, FavoritesActivity.class);
            ArrayList<String> favorites = new ArrayList<>();
            for (Group g : user.getFavorites()) {
                favorites.add(g.toString());
            }
            intent.putExtra("favorites", favorites);
            startActivity(intent);
            return true;
        }
        if (id == R.id.home_button) {
            Intent in = new Intent(this, MainActivity.class);
            startActivity(in);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void setUser(User currentUser) {
        user = currentUser;
    }


    public static void setGroup(Group currentGroup) {
        group = currentGroup;
    }

    //public static void setStudyGroupList(ArrayList<GroupQuestion> qList){ currQuestionList = qList;}

    /**
     * Method for when the buttons are clicked
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.studyGroupsButton) {

            Intent intent = new Intent(this, StudyGroupList.class);

            StudyGroupList sGL = new StudyGroupList();
            sGL.setStudyGroupList(group.getStudyGroupList());
            sGL.setUser(user);

            startActivity(intent);

        } else if (v.getId() == R.id.groupQsButton) {
            Intent intent = new Intent(this, GroupQuestionListActivity.class);

            GroupQuestionListActivity gQLA = new GroupQuestionListActivity();
            gQLA.setQList(group.getQuestionList());
            gQLA.setUser(user);

            startActivity(intent);
        }
    }
}

