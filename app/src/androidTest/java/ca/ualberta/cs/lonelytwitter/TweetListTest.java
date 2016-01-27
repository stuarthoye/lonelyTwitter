package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.security.BasicPermission;
import java.util.ArrayList;

/**
 * Created by hoye on 1/26/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAdd() {
        //  Setup
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        // Add a tweet
        tweets.add(tweet);

        // Test that the tweet is present.
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testHasTweet() {
        //  Setup
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        //  Test that the list is empty to begin
        assertFalse(tweets.hasTweet(tweet));

        //  Add a Tweet
        tweets.add(tweet);

        //  Test that the test returns true for the tweet.
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet() {
        //  Setup
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");
        tweets.add(tweet);

        //  Test that the tweet is in the list
        assertTrue(tweets.hasTweet(tweet));

        Tweet returnedTweet = tweets.getTweet(0);

        //  Test the function
        //  assertEquals(tweet, returnedTweet);                     // Not testing that objs are ==
        assertEquals(tweet.getText(), returnedTweet.getText());
        assertEquals(tweet.getDate(), returnedTweet.getDate());
    }

    public void testDeleteTweet() {
        //  Setup
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");
        tweets.add(tweet);

        //  Test that there exists something to delete
        assertTrue(tweets.hasTweet(tweet));

        //  Remove it
        tweets.deleteTweet(tweet);

        //  Test that it's been removed
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testAddTweet() {
        //  Setup
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");
        tweets.addTweet(tweet);

        //  Test that the tweet is in the list
        assertTrue(tweets.hasTweet(tweet));

        // Try to get the exception thrown by adding the same tweet again.
        try {
            tweets.addTweet(tweet);
        } catch (IllegalArgumentException e) {
            assertTrue(Boolean.TRUE);
            return;
        }
        assertTrue(Boolean.FALSE);
    }

    public void testGetTweets() {
        //  Setup
        TweetList tweets = new TweetList();

        //  Test that empty TweetList returns empty list
        assertEquals(tweets.getTweets(), new ArrayList<Tweet>());

        Tweet tweet = new NormalTweet("Hello");
        tweets.addTweet(tweet);

        assertTrue(Boolean.FALSE);
    }

    public void testRemoveTweet() {
        assertTrue(Boolean.FALSE);
    }

    public void testGetCount() {
        assertFalse(Boolean.TRUE);
    }
}

