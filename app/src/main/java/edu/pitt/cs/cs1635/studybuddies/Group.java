package edu.pitt.cs.cs1635.studybuddies;

import java.util.ArrayList;

/**
 * Created by Louie on 3/13/17.
 */

public class Group {
    String name = "";
    int numMembers = 0;
    int maxMembers = 0;

    public Group(){
    }

    public Group(String n){
        name = n;
    }

    @Override
    public String toString(){
        return name;
    }
}
