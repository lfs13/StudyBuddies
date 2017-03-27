package edu.pitt.cs.cs1635.studybuddies;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Emily on 3/16/17.
 */
public class GroupQuestion implements Serializable {


    //constructors for the class
    public GroupQuestion(String q) {
        question = q;
    }

    public GroupQuestion(){

    }

    //Has the question been answered yet
    private boolean answered = false;

    //the question
    private String question = null;

    //an arraylist of the answers to the question
    private ArrayList<String> answerList = new ArrayList<String>();

    //setters

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswerList(ArrayList<String> answerList) {
        this.answerList = answerList;
    }

    public void addAddAnswer(String answer){
        answerList.add(answer);
    }
    //getters


    public boolean isAnswered() {
        return answered;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswerList() {
        return answerList;
    }


}
