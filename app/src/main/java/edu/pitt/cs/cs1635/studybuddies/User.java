package edu.pitt.cs.cs1635.studybuddies;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Louie on 3/13/17.
 */

public class User {
    String name = "";
    ArrayList<Group> favorites;

    /**
     * Constructor
     * @param n name of user
     */
    public User(String n){
        name = n;
        favorites = new ArrayList<>();
    }

    /**
     * change current user's username
     * @param newUsername new name
     */
    public void changeUsername(String newUsername){
        name = newUsername;
    }

    /**
     * add a new group to favorites
     * @param g group to be added to favorites
     */
    public void addFavorite(Group g){
        favorites.add(g);
        g.addMember();
    }

    public ArrayList<Group> getFavorites(){
        return favorites;
    }

    public String getName(){ return name; }


    /**
     * return username
     * @return string representation of user's name
     */
    @Override
    public String toString(){
        return name;
    }
    
}
