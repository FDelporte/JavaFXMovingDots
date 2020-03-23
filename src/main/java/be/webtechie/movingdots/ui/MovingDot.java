package be.webtechie.movingdots.ui;

import javafx.geometry.Bounds;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MovingDot extends Circle {

    private double moveX;
    private double moveY;
    private double hue = 0;
    private double changeHue = 0.01;

    public MovingDot(double moveX, double moveY, double startX, double startY) {
        this.moveX = moveX;
        this.moveY = moveY;

        this.setRadius(10);
        this.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        this.relocate(startX, startY);
    }

    public void move(Bounds bounds) {
        this.setLayoutX(this.getLayoutX() + moveX);
        this.setLayoutY(this.getLayoutY() + moveY);

        hue += changeHue;
        if (hue >= 1.0 || hue <= -1.0) {
            changeHue = -changeHue;
        }
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setHue(hue);
        this.setEffect(colorAdjust);

        if (this.getLayoutX() <= (bounds.getMinX() + this.getRadius())
                || this.getLayoutX() >= (bounds.getMaxX() - this.getRadius())) {
            moveX = -moveX;
        }

        if ((this.getLayoutY() >= (bounds.getMaxY() - this.getRadius()))
                || (this.getLayoutY() <= (bounds.getMinY() + this.getRadius()))) {
            moveY = -moveY;
        }
    }
}
