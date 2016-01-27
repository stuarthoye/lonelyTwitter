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
    //----------------------------------------------------------------------------------------------
    //  Throws an exception when duplicate added.
    public void addTweet(Tweet tweet) {
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
    }

    //  Returns a list of tweets in the Tweetlist, in chronological order.
    public ArrayList<Tweet> getTweets(){
        return new ArrayList<Tweet>();
    }

    //  Should remove a tweet that exists inside the tweetlist.
    //  Will throw an exception when told to delete a tweet that doesn't exist.
    public void removeTweet(Tweet tweet){

    }

    //  Returns an integer count of the tweets in the tweet list.
    public int getCount() {
        return -1;
    }
}
