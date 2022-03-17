package madsen;

public class XXCircleAdapter implements Shape{

    XXCircle xxCircle;

    // public XXCircleAdapter(XXCircle xxCircle) {
    //     this.xxCircle = xxCircle;
    // }

    public void setLocation() {
        xxCircle.setLocation();
    }

    public void getLocation() {
        xxCircle.getLocation();
    }

    public void display() {
        xxCircle.displaylt();
    }

    public void fill() {
        xxCircle.filllt();
    }

    public void setColor() {
        xxCircle.setltsColor();
    }

    public void undisplay() {
        xxCircle.undisplaylt();
    }
}