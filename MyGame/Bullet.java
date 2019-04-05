import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

   
    public void act() 
   {
       Greenfoot.playSound("EnergyGun.wav");
       setLocation(getX()  + speed, getY());
       checkCollision();       
       checkBoundaries();
   }
   
   // Remove bullets if they are off screen
    public void checkBoundaries()
   { 
       if (getX() == 599) 
        {
          getWorld().removeObject(this);
        }
   }
    
   // Set the speed of the bullet 
   private int speed = 10;
   
   // Remove asteroid if touched and add points 
   public void checkCollision()
    {
       if (isTouching(Asteroid.class)) 
        {
            removeTouching(Asteroid.class); 
            Space world = (Space) getWorld();
            world.changeScoreBy(30);
        }              
    }
      
}
