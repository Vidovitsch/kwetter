package Domain;

import java.util.HashSet;

public class User {

    // region Fields
    private int id;

    private Profile profile;
    private String username;
    private HashSet<Role> roles = new HashSet<Role>();

    private HashSet<User> following = new HashSet<User>();
    private HashSet<User> followers = new HashSet<User>();

    private HashSet<Kweet> kweets = new HashSet<Kweet>();
    private HashSet<Kweet> mentions = new HashSet<Kweet>();
    //endregion

    public User(String username) {
        this.username = username;
    }

    //region Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashSet<Role> getRoles() {
        return roles;
    }

    public void setRoles(HashSet<Role> roles) {
        this.roles = roles;
    }

    public HashSet<User> getFollowing() {
        return following;
    }

    public void setFollowing(HashSet<User> following) {
        this.following = following;
    }

    public HashSet<User> getFollowers() {
        return followers;
    }

    public void setFollowers(HashSet<User> followers) {
        this.followers = followers;
    }

    public HashSet<Kweet> getKweets() {
        return kweets;
    }

    public void setKweets(HashSet<Kweet> kweets) {
        this.kweets = kweets;
    }

    public HashSet<Kweet> getMentions() {
        return mentions;
    }

    public void setMentions(HashSet<Kweet> mentions) {
        this.mentions = mentions;
    }
    //endregion

    public Profile createProfile(String username) {
        // To Do
        return null;
    }

    public Kweet createKweet(String message) {
        return createKweet(message, new HashSet<String>());
    }

    public Kweet createKweet(String message, HashSet<String> mentions) {
        // To Do
        return null;
    }

    public void removeKweet(Kweet kweet) {
        // To Do
    }

    public void addFollowing(User following) {
        // To Do
    }

    public void removeFollowing(User following) {
        // To Do
    }
}