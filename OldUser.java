/*package prolab;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {

    private String username;
    private String name;
    private Integer followers_count;
    private Integer following_count;
    private String language;
    private String region;
    private ArrayList<String> tweets;
    private ArrayList<String> following;
    private ArrayList<String> followers;

    public User(String username, String name, Integer followers_count, Integer following_count, String language, String region, ArrayList<String> tweets, ArrayList<String> following, ArrayList<String> followers) {
        this.username = username;
        this.name = name;
        this.followers_count = followers_count;
        this.following_count = following_count;
        this.language = language;
        this.region = region;
        this.tweets = tweets;
        this.following = following;
        this.followers = followers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(Integer followers_count) {
        this.followers_count = followers_count;
    }

    public Integer getFollowing_count() {
        return following_count;
    }

    public void setFollowing_count(Integer following_count) {
        this.following_count = following_count;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public ArrayList getTweets() {
        return tweets;
    }

    public void setTweets(ArrayList tweets) {
        this.tweets = tweets;
    }

    public ArrayList getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList following) {
        this.following = following;
    }

    public ArrayList getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList followers) {
        this.followers = followers;
    }

    public void printObject() {

        System.out.println("{");
        System.out.println("  username: " + this.username);
        System.out.println("  name: " + this.name);
        System.out.println("  followers_count: " + this.followers_count);
        System.out.println("  following_count: " + this.following_count);
        System.out.println("  language: " + this.language);
        System.out.println("  region: " + this.region);
        System.out.println("  tweets: ");
        printList(this.tweets);
        System.out.println("  following: ");
        printList(this.following);
        System.out.println("  followers: ");
        printList(this.followers);
        System.out.println("}");
    }

    public static void printList(ArrayList<String> list) {
        for (String item : list) {
            System.out.println("    " + item);
        }
    }







}
*/