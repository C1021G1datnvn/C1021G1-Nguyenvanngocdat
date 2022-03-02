package ss6_inheritance.bai_tap.Point_MoveablePoint;

public class MoveablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;
    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MoveablePoint() {
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed() {
        float[] array = {this.getXSpeed(), this.getYSpeed()};
        return array;
    }

    @Override
    public String toString() {
        return super.toString() + ", speed=" + (this.xSpeed + ", " + this.ySpeed);
    }
    public MoveablePoint move() {
        float xNew = super.getX() + this.xSpeed;
        super.setX(xNew);
        float yNew = super.getY() + this.ySpeed;
        super.setY(yNew);
        return this;
    }

}
