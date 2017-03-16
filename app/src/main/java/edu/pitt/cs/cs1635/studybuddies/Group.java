package edu.pitt.cs.cs1635.studybuddies;

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

    public Group(){
    }

    public Group(String n){
        name = n;
    }

    @Override
    public String toString(){
        return name;
    }

    public void setName(String n){
        name = n;
    }
    public void setProfessor(String p){
        professor = p;
    }
    public int getGID(){
        return gid;
    }
    public String getProfessor(){
        return professor;
    }
    public int getNumMembers(){
        return numMembers;
    }
    public void addMember(){
        numMembers++;
    }
    public void removeMember(){
        numMembers--;
    }
}
