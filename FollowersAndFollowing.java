package prolab;

import java.util.ArrayList;


public class FollowersAndFollowing {

    private ArrayList<String> following;
    private ArrayList<String> followers;

    public FollowersAndFollowing(ArrayList<String> following, ArrayList<String> followers) {
        this.following = following;
        this.followers = followers;
    }

    public ArrayList<String> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<String> following) {
        this.following = following;
    }

    public ArrayList<String> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<String> followers) {
        this.followers = followers;
    }
}
