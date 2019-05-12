package tweetanalyzer.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TweetObject {
    private long id;
    private Date createdAt;
    private long replyTo;
    private String text;
    private String user;
    private String location;
    private String langId;
    private String language;
    private String topic;

    public TweetObject(long id, Date createdAt, long replyTo, String text, String user, String location, String langId, String topic) {
        this.id = id;
        this.createdAt = createdAt;
        this.replyTo = replyTo;
        this.text = text;
        this.user = user;
        this.location = location;
        this.langId = langId;
        this.language = setFullLanguageName();
        this.topic = topic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(long replyTo) {
        this.replyTo = replyTo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    private String setFullLanguageName() {
        List<String> isoLanguages = Arrays.asList(Locale.getISOLanguages());
        if (langId.equals("und")) return "Indeterminado";
        return new Locale(isoLanguages.get(isoLanguages.indexOf(langId))).getDisplayName();
    }
}
