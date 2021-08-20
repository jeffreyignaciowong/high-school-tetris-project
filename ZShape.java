
public class ZShape extends Shape{
  public int x2;
  public int y2;
  public int x3;
  public int y3;
  public int x4;
  public int y4;
  public ZShape(int objectx, int objecty)
  {
      x = objectx;
      y = objecty;
      x2 = objectx + 1;
      y2 = objecty;
      x3 = objectx + 1;
      y3 = objecty + 1;
      x4 = objectx + 2;
      y4 = objecty + 1;
  /*if(FinalProject.grid[y][x] == 0 && FinalProject.grid[y2][x2] == 0 && FinalProject.grid[y3][x3] == 0 && FinalProject.grid[y4][x4] == 0)
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
    if(!(FinalProject.grid[y][x] == 0 && FinalProject.grid[y2][x2] == 0 && FinalProject.grid[y3][x3] == 0 && FinalProject.grid[y4][x4] == 0))
    {
      gameOver = true;
    }
  }
  public void toTop(int objectx, int objecty)
  {
    rotation = 1;
    x = objectx;
    y = objecty;
    x2 = objectx + 1;
    y2 = objecty;
    x3 = objectx + 1;
    y3 = objecty + 1;
    x4 = objectx + 2;
    y4 = objecty + 1;
  }
  public void moveDown()
  {
    if(rotation == 1 && y4 !=19 && FinalProject.grid[y+1][x] == 0 && FinalProject.grid[y3+1][x3] == 0 && FinalProject.grid[y4+1][x4] == 0)
    {
      clear();
      y4++;
      y3++;
      y2++;
      y++;
      update();
    }
    else if(rotation == 2 && y4 !=19 && FinalProject.grid[y4+1][x4] == 0 && FinalProject.grid[y2+1][x2] == 0)
    {
      clear();
      y4++;
      y3++;
      y2++;
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
    if(rotation == 1 && x !=0 && FinalProject.grid[y][x-1] == 0 && FinalProject.grid[y3][x3-1] == 0)
    {
      clear();
      x--;
      x2--;
      x3--;
      x4--;
      update();
    }
    else if(rotation == 2 && x3 !=0 && FinalProject.grid[y3][x3-1] == 0 && FinalProject.grid[y4][x4-1] == 0 && FinalProject.grid[y][x-1] == 0)
    {
      clear();
      x--;
      x2--;
      x3--;
      x4--;
      update();
    }
  }
  public void moveRight()
  {
    if(rotation == 1 && x4 !=9 && FinalProject.grid[y4][x4+1] == 0 && FinalProject.grid[y2][x2+1] == 0)
    {
      clear();
      x++;
      x2++;
      x3++;
      x4++;
      update();
    }
    else if(rotation == 2 && x != 9 && FinalProject.grid[y4][x4+1] == 0 && FinalProject.grid[y2][x2+1] == 0 && FinalProject.grid[y][x+1] == 0)
    {
      clear();
      x++;
      x2++;
      x3++;
      x4++;
      update();
    }
  }
  public void rotate(boolean clockwise)
  {
    if(clockwise)
    {
      rotation++;
      if(rotation >2)
      {
        rotation = 1;
      }
    }
    else
    {
      rotation--;
      if(rotation < 1)
      {
        rotation = 2;
      }
    }
    if(rotation == 2)
    {
      if(y != 0 &&FinalProject.grid[y-1][x+1] == 0 && FinalProject.grid[y4][x4-2] == 0)
      {
        //rotation++;
        clear();
        x++;
        y--;
        y3--;
        x3--;
        x4 -= 2;
        update();
      }
    }
    else if(rotation == 1)
    {
      if(x != 9 && FinalProject.grid[y3+1][x3+1] == 0 && FinalProject.grid[y4][x4+2] == 0)
      {
        //rotation++;
        clear();
        x4 += 2;
        y3++;
        x3++;
        x--;
        y++;
        update();
      }
    }
  }
  public void rotate()
  {
    
    if(rotation == 1)
    {
      if(y != 0 &&FinalProject.grid[y-1][x+1] == 0 && FinalProject.grid[y4][x4-2] == 0)
      {
        rotation++;
        clear();
        x++;
        y--;
        y3--;
        x3--;
        x4 -= 2;
        update();
      }
    }
    else if(rotation == 2)
    {
      if(x != 9 && FinalProject.grid[y3+1][x3+1] == 0 && FinalProject.grid[y4][x4+2] == 0)
      {
        rotation++;
        clear();
        x4 += 2;
        y3++;
        x3++;
        x--;
        y++;
        update();
      }
    }
    if(rotation >2)
    {
      rotation = 1;
    }
  }
  public void update()
  {
    FinalProject.grid[y][x] = 7;
    FinalProject.grid[y2][x2] = 7;
    FinalProject.grid[y3][x3] = 7;
    FinalProject.grid[y4][x4] = 7;
  }
  public void clear()
  {
    FinalProject.grid[y][x] = 0;
    FinalProject.grid[y2][x2] = 0;
    FinalProject.grid[y3][x3] = 0;
    FinalProject.grid[y4][x4] = 0;
  }
  public void debugprint()
  {
    System.out.println("x = " + x); 
    System.out.println("y = " + y);  
    System.out.println("x2 = " + x2);   
    System.out.println("y2 = " + y2);  
    System.out.println("x3 = " + x3); 
    System.out.println("y3 = " + y3); 
    System.out.println("x4 = " + x4); 
    System.out.println("y4 = " + y4);
  }
  public String getType()
  {
    return "zShape";
  }
  public int getTypeNum()
  {
    return 7;
  }
}
