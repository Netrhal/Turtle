import java.awt.Color;

public class Turtle {
    private double x, y;     // turtle is at (x, y)
    private double angle;    // facing this many degrees counterclockwise from the x-axis

    // start at (x0, y0), facing a0 degrees counterclockwise from the x-axis
    public Turtle(double x0, double y0, double a0) {
        x = x0;
        y = y0;
        angle = a0;
    }

    // rotate orientation delta degrees counterclockwise
    public void turnLeft(double delta) {
        angle += delta;
    }

    // move forward the given amount, with the pen down
    public void goForward(double step) {
        double oldx = x;
        double oldy = y;
        x += step * Math.cos(Math.toRadians(angle));
        y += step * Math.sin(Math.toRadians(angle));
        StdDraw.line(oldx, oldy, x, y);
    }

    // copy to onscreen
    public void show() {
        StdDraw.show();
    }

    // pause t milliseconds
    public void pause(int t) {
        StdDraw.pause(t);
    }


    public void setPenColor(Color color) {
        StdDraw.setPenColor(color);
    }

    public void setPenRadius(double radius) {
        StdDraw.setPenRadius(radius);
    }

    public void setCanvasSize(int width, int height) {
        StdDraw.setCanvasSize(width, height);
    }

    public void setXscale(double min, double max) {
        StdDraw.setXscale(min, max);
    }

    public void setYscale(double min, double max) {
        StdDraw.setYscale(min, max);
    }


    // sample client for testing
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        double x0 = 0.5;
        double y0 = 0.0;
        double a0 = 60;

        Turtle turtle = new Turtle(x0, y0, a0);
        triangle(turtle);
        //star(turtle);
    }

    public static void triangle (Turtle turtle) {
        double step = Math.sqrt(3)/2;
        turtle.goForward(step);
        turtle.turnLeft(120.0);
        turtle.goForward(step);
        turtle.turnLeft(120.0);
        turtle.goForward(step);
        turtle.turnLeft(120.0);
        turtle.show();

    }

    public static void star (Turtle turtle) {
        double step = 0.2;
        for (int i = 0; i < 6; i++) {
            turtle.goForward(step);
            turtle.turnLeft(60);
            turtle.goForward(step);
            turtle.turnLeft(-120);
        }
        turtle.show();
    }

}