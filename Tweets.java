package prolab;

public class Tweets {

    private long tweetId;
    private String content;
    private String hashtag;

    public Tweets(long tweetId, String content, String hashtag) {
        this.tweetId = tweetId;
        this.content = content;
        this.hashtag = hashtag;
    }

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public void print(){
        System.out.print("tweet id: ");
        System.out.println(tweetId);
        System.out.print("content: ");
        System.out.println(content);
        System.out.print("hashtag: ");
        System.out.println(hashtag);
    }

}
