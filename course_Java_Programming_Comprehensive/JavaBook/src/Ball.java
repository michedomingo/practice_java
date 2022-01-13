public class Ball {
    private float x, y; // current (x, y) position of ball
    private float speedX, speedY; // speed of ball in pixels per second
    private int direction; // 0 (UP) or 1 (DOWN)
    private float width; // ball's width

    // constructor without paramaters
    public Ball() {
        setWidth(40); // mutator method for width field
        x = y = 0;
        speedX = 100;
        speedY = 200;
        direction = 1;
    }

    /*
     * method that updates the current position of the ball, (p167_pdf172)
     * based on its speed & distance traveled in the specified time interval
     */
    public void step(float timeInterval) {
        x += speedX * timeInterval;
        y += speedY * timeInterval;
    }

}

// ch5
