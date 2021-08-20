/**
 * Jeffrey Wong
 */
public class Square extends Shape
{
  //public int x;
  //public int y;
  //public int rotation = 1;
  //public boolean instantDrop = false;
  public Square(int objectx, int objecty)
  {
    x = objectx;
    y = objecty;
    /*if(FinalProject.grid[y][x] == 0 && FinalProject.grid[y][x+1] == 0 && FinalProject.grid[y+1][x] == 0 && FinalProject.grid[y+1][x+1] == 0)
    {
      update();
    }
    else
    {
      gameOver = true;
    }*/
  }
  public void checkGameOver()
  {
    if(!(FinalProject.grid[y][x] == 0 && FinalProject.grid[y][x+1] == 0 && FinalProject.grid[y+1][x] == 0 && FinalProject.grid[y+1][x+1] == 0))
    {
      gameOver = true;
    }
  }
  public void toTop(int objectx, int objecty)
  {
    x = objectx;
    y = objecty;
    //update();
  }
  public void instantDrop()
  {
    instantDrop = true;
    while(instantDrop)
    {
      moveDown();
    }
  }
  public void moveDown()
  {
    if(y != 18 && FinalProject.grid[y+2][x] == 0 && FinalProject.grid[y+2][x+1] == 0)
    {
      FinalProject.grid[y][x] = 0;
      FinalProject.grid[y][x+1] = 0;
      y++;
      update();
    }
    else
    {
      FinalProject.newBlock = true;
      instantDrop = false;
    }
  }
  public void moveLeft()
  {
    if(x != 0 && FinalProject.grid[y][x-1] == 0 && FinalProject.grid[y+1][x-1] == 0)
    {
      FinalProject.grid[y][x+1] = 0;
      FinalProject.grid[y+1][x+1] = 0;
      x--;
      update();
    }
  }
  public void moveRight()
  {
    if(x != 8 && FinalProject.grid[y][x+2] == 0 && FinalProject.grid[y+1][x+2] == 0)
    {
      FinalProject.grid[y][x] = 0;
      FinalProject.grid[y+1][x] = 0;
      x++;
      update();
    }
  }
  public void rotate()
  {
    //lol ;)
  }
  public void rotate(boolean clockwise)
  {
    
  }
  public void update()
  {
    FinalProject.grid[y][x] = 4;
    FinalProject.grid[y+1][x] = 4;
    FinalProject.grid[y][x+1] = 4;
    FinalProject.grid[y+1][x+1] = 4;
  }
  public void clear()
  {
    FinalProject.grid[y][x] = 0;
    FinalProject.grid[y+1][x] = 0;
    FinalProject.grid[y][x+1] = 0;
    FinalProject.grid[y+1][x+1] = 0;
  }
  public static void sleep(int time)
  {
    try{
      Thread.sleep(time);
    } catch (Exception e) {}
  }
  public String getType()
  {
    return "square";
  }
  public int getTypeNum()
  {
    return 4;
  }
}
