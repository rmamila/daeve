package au.pexa.hack.daeve.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Suggestion {

    @Id
    private String id;

    private String username;

    private String pattern;

    private String ratings;

     private String lastAccessedPage;

     private String lastAccessedSystem;

     private String subscriberId;

     private String subscriberType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getLastAccessedPage() {
        return lastAccessedPage;
    }

    public void setLastAccessedPage(String lastAccessedPage) {
        this.lastAccessedPage = lastAccessedPage;
    }

    public String getLastAccessedSystem() {
        return lastAccessedSystem;
    }

    public void setLastAccessedSystem(String lastAccessedSystem) {
        this.lastAccessedSystem = lastAccessedSystem;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getSubscriberType() {
        return subscriberType;
    }

    public void setSubscriberType(String subscriberType) {
        this.subscriberType = subscriberType;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", pattern='" + pattern + '\'' +
                ", ratings='" + ratings + '\'' +
                ", lastAccessedPage='" + lastAccessedPage + '\'' +
                ", lastAccessedSystem='" + lastAccessedSystem + '\'' +
                ", subscriberId='" + subscriberId + '\'' +
                ", subscriberType='" + subscriberType + '\'' +
                '}';
    }
}
