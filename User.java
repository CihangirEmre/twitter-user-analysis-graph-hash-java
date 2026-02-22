package prolab;

import java.util.ArrayList;
import java.util.List;

public class User {

    private UserInfo userInfo;
    private ArrayList<Tweets> tweetsContents;
    private FollowersAndFollowing followerRelationship;


    public User(UserInfo userInfo, ArrayList<Tweets> tweetsContents, FollowersAndFollowing followerRelationship) {
        this.userInfo = userInfo;
        this.tweetsContents = tweetsContents;
        this.followerRelationship = followerRelationship;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Tweets> getTweetsContents() {
        return tweetsContents;
    }

    public void setTweetsContents(ArrayList<Tweets> tweetsContents) {
        this.tweetsContents = tweetsContents;
    }

    public FollowersAndFollowing getFollowerRelationship() {
        return followerRelationship;
    }

    public void setFollowerRelationship(FollowersAndFollowing followerRelationship) {
        this.followerRelationship = followerRelationship;
    }

    public void printObject() {

        System.out.println("{");
        System.out.println("  username: " + userInfo.getUsername());
        System.out.println("  name: " + userInfo.getNameSurname());
        System.out.println("  followers_count: " + userInfo.getFollowersCount());
        System.out.println("  following_count: " + userInfo.getFollowingCount());
        System.out.println("  language: " + userInfo.getLanguage());
        System.out.println("  region: " + userInfo.getRegion());
        System.out.println("  tweet content: ");
        for(int i = 0 ; i<tweetsContents.size() ; i++){
            System.out.println();
            tweetsContents.get(i).print();
        }
        System.out.println("  following: ");
        printList(this.followerRelationship.getFollowing());
        System.out.println("  followers: ");
        printList(this.followerRelationship.getFollowers());
        System.out.println("}");
    }

    public static void printList(ArrayList<String> list) {
        for (String item : list) {
            System.out.println("    " + item);
        }
    }


}
