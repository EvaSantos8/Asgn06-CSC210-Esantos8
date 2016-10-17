package com.deitel.cannongame;

import android.graphics.Rect;
import android.graphics.Canvas;

/**
 * Created by Eva Santos on 10/17/2016.
 */
public class Racket extends GameElement {
    public Racket(CannonView view, int color, int x, int y,
                  int width, int length, float velocityY) {
        super(view, color, x, y, width, length, velocityY);
    }
    // test whether Cannonball collides with the given GameElement
    public boolean collidesWith(GameElement element) {
        return (Rect.intersects(shape, element.shape));
    }
    public void moveY(int newY){
        y = newY;
        shape = new Rect(x, y, x + width, y + length);
    }
}
