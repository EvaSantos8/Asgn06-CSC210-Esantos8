// Cannonball.java
// Represents the Cannonball that the Cannon fires
package com.deitel.cannongame;

import android.graphics.Canvas;
import android.graphics.Rect;

public class Cannonball extends GameElement {
   private float velocityX;
   private boolean onScreen;

   // constructor
   public Cannonball(CannonView view, int color, int x,
      int y, int radius, float velocityX, float velocityY) {
      super(view, color, x, y,
         2 * radius, 2 * radius, velocityY);
      this.velocityX = velocityX;
      onScreen = true;
   }

   // get Cannonball's radius
   private int getRadius() {
      return (shape.right - shape.left) / 2;
   }

   // test whether Cannonball collides with the given GameElement
   public boolean collidesWith(GameElement element) {
      return (Rect.intersects(shape, element.shape));
   }

   // returns true if this Cannonball is on the screen
   public boolean isOnScreen() {
      return onScreen;
   }

   // reverses the Cannonball's horizontal velocity
   public void reverseVelocityX() {
      double num = 0.1;
      int select = (int) (Math.random() * 3);
      if(select == 1)
         num = 0.25;
      if(select == 2)
         num = -0.25;
      velocityX = (float) ((velocityX* -1) + num);
   }
   public void reverseVelocityY() {
      double num = 0.1;
      int select = (int) (Math.random() * 3);
      if(select == 1)
         num = 0.25;
      if(select == 2)
         num = -0.25;
      velocityY = (float) ((velocityY* -1) + num);
   }
   // updates the Cannonball's position
   @Override
   public void update(double interval) {
      super.update(interval); // updates Cannonball's vertical position

      // update horizontal position
      shape.offset((int) (velocityX * interval), 0);

      // if Cannonball goes off the screen
      if (shape.top < 0  || shape.left < 0 ||
         shape.bottom > view.getScreenHeight())
      {
         reverseVelocityX();
         reverseVelocityY();
      }
         if(shape.right > view.getScreenWidth() )
            onScreen = false; // set it to be removed
   }

   // draws the Cannonball on the given canvas
   @Override
   public void draw(Canvas canvas) {
      canvas.drawCircle(shape.left + getRadius(),
         shape.top + getRadius(), getRadius(), paint);
   }
}

/*********************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and * Pearson Education, *
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this   *
 * book have used their * best efforts in preparing the book. These efforts      *
 * include the * development, research, and testing of the theories and programs *
 * * to determine their effectiveness. The authors and publisher make * no       *
 * warranty of any kind, expressed or implied, with regard to these * programs   *
 * or to the documentation contained in these books. The authors * and publisher *
 * shall not be liable in any event for incidental or * consequential damages in *
 * connection with, or arising out of, the * furnishing, performance, or use of  *
 * these programs.                                                               *
 *********************************************************************************/
