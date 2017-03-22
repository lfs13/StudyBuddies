package edu.pitt.cs.cs1635.studybuddies;

/**
 * Created by Emily on 3/17/17.
 */
public class StudyGroup {
    private String name;
    private int time;
    private int floor;

    public StudyGroup() {
    }

    public StudyGroup(String n) {
        name = n;
        time = 2;
        floor = 3;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
