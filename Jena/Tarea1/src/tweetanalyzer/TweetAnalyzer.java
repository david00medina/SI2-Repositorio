package tweetanalyzer;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tweetanalyzer.control.TwitterConnector;
import tweetanalyzer.gui.TweetAnalyzerScreen;
import tweetanalyzer.model.TweetObject;
import twitter4j.TwitterException;

public class TweetAnalyzer {

    public static void main(String[] args) {
        /*try {
            result = tc.searchTweets("#usa");
            for (TweetObject s : result) {
                System.out.println(s);
            }
        } catch (TwitterException ex) {
            Logger.getLogger(TweetAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        new TweetAnalyzerScreen().setVisible(true);
    }
    
}
