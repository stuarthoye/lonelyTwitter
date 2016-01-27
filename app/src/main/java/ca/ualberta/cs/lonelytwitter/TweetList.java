package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by hoye on 1/26/16.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public void deleteTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    //  Lab excercise functions
    public void addTweet(Tweet tweet) {
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
    }

    public ArrayList<Tweet> getTweets(){
        return new ArrayList<Tweet>();
    }

    public void removeTweet(Tweet tweet){

    }

    public int getCount() {
        return -1;
    }
}
