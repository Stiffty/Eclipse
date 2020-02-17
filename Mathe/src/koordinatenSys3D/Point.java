package koordinatenSys3D;

public class Point {
    public double x;
    public double y;

    private double xO;
    private double yO;
    private double zO;



    public Point(double x, double y, double xO, double yO, double zO) {
        this.x = x;
        this.y = y;
        this.xO = xO;
        this.yO = yO;
        this.zO = zO;
    }

    public double getxO() {
        return xO;
    }

    public void setxO(double xO) {
        this.xO = xO;
    }

    public double getyO() {
        return yO;
    }

    public void setyO(double yO) {
        this.yO = yO;
    }

    public double getzO() {
        return zO;
    }

    public void setzO(double zO) {
        this.zO = zO;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
