/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerPattern;

import java.util.ArrayList;
import java.util.List;
import observerPattern.Observer;

public abstract class Subject {
    
    protected String ID;
    private List<String> tweets = new ArrayList<String>();    // do I need to initialize it?
    
    private List<Observer> followers = new ArrayList<Observer>();   // list of users that will recieve updates
    
    public void addFollower(Observer user) {     // add this user to the list
        followers.add(user);
    }

 //   public void remove(Observer user)     // not required in project specs, but could be added.
    
    public void newTweet(String newTweet) {
        tweets.add(newTweet);
        notifyObservers();
        // add to Admin's records
    }
    
    private void notifyObservers() {     // send the new tweet to every user in the list.
        for(Observer thisUser : followers) {
            thisUser.update(this);
        }
    }
    
    public String getTweet() {              // for use with UserView updates
        return tweets.get(tweets.size() - 1);
    }
    
    public String getTweet(int index) {     // for use with Visitor calculations
        return tweets.get(index);
    }
    
    public int getTweetsSize() {
        return tweets.size();
    }
    
    public String getID() {
        return ID;
    }
    
    public void setID(String input) {
        ID = input;
    }
}
