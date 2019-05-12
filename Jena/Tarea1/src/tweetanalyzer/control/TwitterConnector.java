package tweetanalyzer.control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import tweetanalyzer.model.TweetObject;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConnector {
    private static final String QUERY_PREFIX = "source:twitter4j ";
    private Twitter twitter;
    private Map<String, String> keys;
    
    public TwitterConnector() {
        keys = new HashMap<>();
        retrieveKeys();
        doLogin();
    }

    private void doLogin() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(keys.get("oauth.consumerKey"))
                .setOAuthConsumerSecret(keys.get("oauth.consumerSecret"))
                .setOAuthAccessToken(keys.get("oauth.accessToken"))
                .setOAuthAccessTokenSecret(keys.get("oauth.accessTokenSecret"));

        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    private void retrieveKeys() {
        try {
            BufferedReader fis = new BufferedReader(
                    new FileReader("config/twitter4j.properties"));
            
            String line = "";
            while((line = fis.readLine()) != null) {
                String[] param = line.split("=");
                keys.put(param[0].trim(), param[1].replaceAll("\"", "").trim());
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<TweetObject> searchTweets(String topic, int n) throws TwitterException {
        if (n <= 0) n = 1;
        else if (n > 200) n = 200;
        
        Query q = new Query(topic);
        q.setCount(n);
        QueryResult result = twitter.search(q);
        List<Status> tweets = result.getTweets();
        
        return tweets.parallelStream().map(s -> new TweetObject(
                s.getId(), s.getCreatedAt(), s.getInReplyToStatusId(), 
                s.getText(), s.getUser().getName(), 
                s.getUser().getLocation(), s.getLang(), topic))
                .collect(Collectors.toList());
    }
}
