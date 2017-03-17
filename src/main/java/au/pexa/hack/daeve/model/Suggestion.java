package au.pexa.hack.daeve.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document
public class Suggestion {

    @Id
    private String id;

    private String username;

    private Map<String, Integer> goal;

    private String lastAccessedPage;

    private String lastAccessedSystem;

     private String subscriberId;

     private String subscriberType;

     private String workspaceReference;

     private boolean isNewUser;

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

    public Map<String, Integer> getGoal() {
        return goal;
    }

    public void setGoal(Map<String, Integer> goal) {
        this.goal = goal;
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

    public String getWorkspaceReference() {
        return workspaceReference;
    }

    public void setWorkspaceReference(String workspaceReference) {
        this.workspaceReference = workspaceReference;
    }

    public boolean isNewUser() {
        return isNewUser;
    }

    public void setNewUser(boolean newUser) {
        isNewUser = newUser;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", goal=" + goal +
                ", lastAccessedPage='" + lastAccessedPage + '\'' +
                ", lastAccessedSystem='" + lastAccessedSystem + '\'' +
                ", subscriberId='" + subscriberId + '\'' +
                ", subscriberType='" + subscriberType + '\'' +
                ", workspaceReference='" + workspaceReference + '\'' +
                ", isNewUser=" + isNewUser +
                '}';
    }
}
