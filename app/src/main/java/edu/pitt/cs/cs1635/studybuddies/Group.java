package edu.pitt.cs.cs1635.studybuddies;

import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Louie on 3/13/17.
 */

public class Group implements Serializable{
    String name = "";
    String professor ="";
    int gid;
    int numMembers = 0;
    int maxMembers = 0;
    private static ArrayList<GroupQuestion> QuestionList = new ArrayList<>() ;


    public Group(){
    }

    public Group(String n){
        name = n;
    }

    @Override
    public String toString(){
        return name;
    }


    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
    public int getGID(){
        return gid;
    }

    public int getNumMembers(){
        return numMembers;
    }
    public void setNumMembers(int n){
        numMembers = n;
    }
    public void addMember(){
        numMembers++;
    }
    public void removeMember(){
        numMembers--;
    }

    public int getMaxMembers(){
        return maxMembers;
    }
    public void setMaxMembers(int n){
        maxMembers = n;
    }

    public void setProfessor(String p){
        professor = p;
    }
    public String getProfessor(){
        return professor;
    }

    public static ArrayList<GroupQuestion> getQuestionList() {
        return QuestionList;
    }
}
