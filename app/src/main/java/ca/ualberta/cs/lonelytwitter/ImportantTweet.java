package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hoye on 1/12/16.
 */
public class ImportantTweet extends Tweet implements Tweetable {
    public ImportantTweet(Date date, String text) {
        super(date, text);
    }

    public ImportantTweet(String text) {
        super(text);
    }

    @Override
    public Boolean getIsImportant() {
        return Boolean.TRUE;
    }
}
