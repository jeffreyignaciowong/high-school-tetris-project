/**
 * Superclass
 */
public abstract class Shape {
  public int x;
  public int y;
  public boolean instantDrop = false;
  public boolean gameOver = false;
  public int rotation = 1;
  public void instantDrop()
  {
    instantDrop = true;
    while(instantDrop)
    {
      moveDown();
    }
  }
  
  abstract public void toTop(int objectx, int objecty);
  
  public static void sleep(int time)
  {
    try{
      Thread.sleep(time);
    } catch (Exception e) {}
  }
  abstract public void moveDown();

  abstract public void moveLeft();

  abstract public void moveRight();

  abstract public void rotate();
  
  abstract public void rotate(boolean clockwise);

  abstract public void update();

  abstract public String getType();
  
  abstract public int getTypeNum();
  
  abstract public void clear();
  
  abstract public void checkGameOver();
}
