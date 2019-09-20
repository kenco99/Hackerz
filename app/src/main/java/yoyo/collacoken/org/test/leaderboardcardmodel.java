package yoyo.collacoken.org.test;

public class leaderboardcardmodel {
    private int rankNo, userProfile, scorePoints;
    private String userName;

    public leaderboardcardmodel(int rankNo, int userProfile, int scorePoints, String userName) {
        this.rankNo = rankNo;
        this.userProfile = userProfile;
        this.scorePoints = scorePoints;
        this.userName = userName;
    }

    public int getRankNo() {
        return rankNo;
    }

    public int getUserProfile() {
        return userProfile;
    }

    public int getScorePoints() {
        return scorePoints;
    }

    public String getUserName() {
        return userName;
    }
}
