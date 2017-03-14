package edu.pitt.cs.cs1635.studybuddies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    User currentUser;
    ArrayList<Group> groups = new ArrayList<Group>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create dummy groups
        createGroups();

        //set list of buttons to groups
        updateAvailableGroups(groups);

        final EditText search = (EditText) findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                filterGroups(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

    }

    /**
     * Hard code some groups
     */
    public void createGroups(){
        groups.add(new Group("CS007"));
        groups.add(new Group("CS401"));
        groups.add(new Group("CS441"));
        groups.add(new Group("CS445"));
        groups.add(new Group("CS447"));
        groups.add(new Group("CS449"));
        groups.add(new Group("CS1501"));
        groups.add(new Group("CS1550"));
        groups.add(new Group("CS1555"));
        groups.add(new Group("CS1635"));
    }

    /**
     * Update UI to reflect filtered groups
     * @param updatedGroups filtered list of groups
     */
    public void updateAvailableGroups(ArrayList<Group> updatedGroups){
        LinearLayout groupList = (LinearLayout) findViewById(R.id.group_list);
        groupList.removeAllViews();

        for(int i = 0; i < updatedGroups.size(); i++){
            Button tempButton = new Button(this);
            Group tempGroup = updatedGroups.get(i);
            tempButton.setText(tempGroup.toString());
            tempButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            groupList.addView(tempButton);
        }
    }

    /**
     * create filtered group list and send to update method
     * @param s filter string
     */
    public void filterGroups(String s){
        if(s.length()==0){
            updateAvailableGroups(groups);
        }
        else {
            ArrayList<Group> filtered = new ArrayList<>();
            s = s.toLowerCase();
            for (int i = 0; i < groups.size(); i++) {
                Group temp = groups.get(i);
                if (temp.toString().toLowerCase().contains(s)) {
                    filtered.add(temp);
                }
            }
            updateAvailableGroups(filtered);
        }
    }

    /**
     * to be implemented
     * bring up form with group elements, pass into constructor(will need to add one with all relevant parameters)
     */
    public void addGroup(){
        //this is the add buttons onCLick method as defined in main_activity.xml
        //TODO
    }


}
