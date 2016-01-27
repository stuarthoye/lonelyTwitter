package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by hoye on 1/26/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        //  Setup
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello II");

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
}

