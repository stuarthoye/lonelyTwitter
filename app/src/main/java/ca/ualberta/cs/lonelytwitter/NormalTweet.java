package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hoye on 1/12/16.
 */
public class NormalTweet extends Tweet implements Tweetable {
    public NormalTweet(Date date, String text) {
        super(date, text);
    }

    public NormalTweet(String text) {
        super(text);
    }

    @Override
    public Boolean getIsImportant() {
        return Boolean.FALSE;
    }
}
