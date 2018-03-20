package viewmodels;

import java.util.Date;
import java.util.List;

public class TimelineItem implements Comparable<TimelineItem> {

    private Long kweetId;
    private Date postDate;
    private String message;
    private String username;
    private List<UserUsernameView> hearts;
    private boolean ownKweet;
    private List<UserUsernameView> mentions;

    public Long getKweetId() {
        return kweetId;
    }

    public void setKweetId(Long kweetId) {
        this.kweetId = kweetId;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserUsernameView> getHearts() {
        return hearts;
    }

    public void setHearts(List<UserUsernameView> hearts) {
        this.hearts = hearts;
    }

    public boolean isOwnKweet() {
        return ownKweet;
    }

    public void setOwnKweet(boolean ownKweet) {
        this.ownKweet = ownKweet;
    }

    public List<UserUsernameView> getMentions() {
        return mentions;
    }

    public void setMentions(List<UserUsernameView> mentions) {
        this.mentions = mentions;
    }

    @Override
    public int compareTo(TimelineItem timelineItem) {
        int first = timelineItem.postDate.compareTo(this.postDate);
        first = first == 0 ? this.postDate.compareTo(timelineItem.postDate) : first;
        if (first == 0 && kweetId.equals(timelineItem.kweetId)) {
            return -1;
        } else {
            return first;
        }
    }

    @Override
    public boolean equals(Object obj) {
        TimelineItem timelineItem = (TimelineItem) obj;
        return kweetId.equals(timelineItem.getKweetId());
    }
}
