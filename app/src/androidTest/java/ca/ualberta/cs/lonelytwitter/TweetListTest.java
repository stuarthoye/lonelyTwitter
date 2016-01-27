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

        Tweet returnedTweet = tweets.getTweet(tweet);

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
}

