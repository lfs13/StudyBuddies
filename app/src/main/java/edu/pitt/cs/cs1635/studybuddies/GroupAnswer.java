package edu.pitt.cs.cs1635.studybuddies;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nick on 4/7/17.
 */

public class GroupAnswer implements Serializable {



    //constructors for the class
    public GroupAnswer(String q) {
        answer = q;
    }

    public GroupAnswer(){

    }

    //Has the question been answered yet
    private boolean ranked = false;

    //the question
    private String answer = null;

    private double total = 0;
    private double count = 0;


    //setters

    public void setRanked(boolean answered) {
        this.ranked = answered;
    }

    public void addRank(String answer){
        total = total + 1;
        count += 1;
    }
    //getters


    public boolean isRanked() {
        return ranked;
    }

    public double getRank() {
        return total/count;
    }

    public String getAnswer() { return answer; }


}