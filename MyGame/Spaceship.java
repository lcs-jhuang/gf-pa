import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The battleship
 * 
 * @author J.Huang
 * @version 1.0
 */
public class Spaceship extends Actor
{
    /**
     * Act - do whatever the Spaceship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int gunReloadTime;              
    private int reloadDelayCount;           
    
    // Set the initial reload time and delay count
    public Spaceship()
    {
        gunReloadTime = 8;
        reloadDelayCount = 0;
    }
    
    public void act() 
    {
        checkKeyPress();
        checkCollision();
        reloadDelayCount++;
    }  
        
    // set reload time to avoid rapid fire
    public void setGunReloadTime(int reloadTime)
    {
        gunReloadTime = reloadTime;
    }
    
    // control the spaceship with keys
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-4);
        }
        
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+4);
        }  
        
        if(Greenfoot.isKeyDown("space")) 
        {
            fire();
        }   
    }
    
    // If the spaceship collided with an asteroid, the game is over
    private void checkCollision()
    {
        if (isTouching(Asteroid.class)) 
        {           
            getWorld().showText("GAMEOVER", 300, 200);
            Greenfoot.stop();
        }
    }
    
    // Make the spaceship fire bullets, each bullet would cost you 2 points
    private void fire()
    {
        if (reloadDelayCount >= gunReloadTime)
        {
            getWorld().addObject(new Bullet(), getX(), getY());
            reloadDelayCount = 0;   
            Space world = (Space) getWorld();
            world.changeScoreBy(-2);
        }
    }        
}
