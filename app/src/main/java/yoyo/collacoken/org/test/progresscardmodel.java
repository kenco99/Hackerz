package yoyo.collacoken.org.test;

public class progresscardmodel {
    private int points, days, img;

    public progresscardmodel(int points, int days, int img) {
        this.points = points;
        this.days = days;
        this.img = img;
    }

    public int getPoints() {
        return points;
    }

    public int getDays() {
        return days;
    }

    public int getImg() {
        return img;
    }
}

