package prolab;

public class UserInfo {
    private String username;
    private String nameSurname;
    private int followersCount;
    private int followingCount;
    private String language;
    private String region;

    public UserInfo(String username, String nameSurname, int followersCount, int followingCount, String language, String region) {
        this.username = username;
        this.nameSurname = nameSurname;
        this.followersCount = followersCount;
        this.followingCount = followingCount;
        this.language = language;
        this.region = region;
    }

    public String getUsername() {
        return username;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public String getLanguage() {
        return language;
    }

    public String getRegion() {
        return region;
    }
}
