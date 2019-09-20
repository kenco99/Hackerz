package yoyo.collacoken.org.test;

public class datasetter {
    String UserName;
    String Email;
    String Password;
    String Image;
    String Score;
    String GoodImage;
    String badImage;
    String Progress;

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setScore(String score) {
        Score = score;
    }

    public void setGoodImage(String goodImage) {
        GoodImage = goodImage;
    }

    public void setBadImage(String badImage) {
        this.badImage = badImage;
    }

    public void setProgress(String progress) {
        Progress = progress;
    }

    public String getUserName() {
        return UserName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getImage() {
        return Image;
    }

    public String getScore() {
        return Score;
    }

    public String getGoodImage() {
        return GoodImage;
    }

    public String getBadImage() {
        return badImage;
    }

    public String getProgress() {
        return Progress;
    }

    public datasetter(String userName, String email, String password, String image, String score, String goodImage, String badImage, String progress) {
        UserName = userName;
        Email = email;
        Password = password;
        Image = image;
        Score = score;
        GoodImage = goodImage;
        this.badImage = badImage;
        Progress = progress;
    }
}
