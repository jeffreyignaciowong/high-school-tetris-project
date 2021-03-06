
public class SShape extends Shape{
  public int x2;
  public int y2;
  public int x3;
  public int y3;
  public int x4;
  public int y4;
  public SShape(int objectx, int objecty)
  {
      x = objectx;
      y = objecty + 1;
      x2 = objectx + 1;
      y2 = objecty + 1;
      x3 = objectx + 1;
      y3 = objecty;
      x4 = objectx + 2;
      y4 = objecty;
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
    y = objecty + 1;
    x2 = objectx + 1;
    y2 = objecty + 1;
    x3 = objectx + 1;
    y3 = objecty;
    x4 = objectx + 2;
    y4 = objecty;
  }
  public void moveDown()
  {
    if(rotation == 1 && y !=19 && FinalProject.grid[y+1][x] == 0 && FinalProject.grid[y2+1][x2] == 0 && FinalProject.grid[y4+1][x4] == 0)
    {
      clear();
      y4++;
      y3++;
      y2++;
      y++;
      update();
    }
    else if(rotation == 2 && y !=19 && FinalProject.grid[y+1][x] == 0 && FinalProject.grid[y3+1][x3] == 0)
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
      if(y4 != 0 && FinalProject.grid[y4-1][x4-1] == 0 && FinalProject.grid[y][x+2] == 0)
      {
        //rotation++;
        clear();
        x += 2;
      
        y2--;
        x2++;
        y4--;
        x4--;
        update();
      }
    }
    else if(rotation == 1)
    {
      if(x3 != 0 && FinalProject.grid[y][x-2] == 0 && FinalProject.grid[y2+1][x2-1] == 0)
      {
        //rotation++;
        clear();
        x -= 2;
      
        y2++;
        x2--;
        y4++;
        x4++;
        update();
      }
    }
  }
  public void rotate()
  {
    
    if(rotation == 1)
    {
      if(y4 != 0 && FinalProject.grid[y4-1][x4-1] == 0 && FinalProject.grid[y][x+2] == 0)
      {
        rotation++;
        clear();
        x += 2;
      
        y2--;
        x2++;
        y4--;
        x4--;
        update();
      }
    }
    else if(rotation == 2)
    {
      if(x3 != 0 && FinalProject.grid[y][x-2] == 0 && FinalProject.grid[y2+1][x2-1] == 0)
      {
        rotation++;
        clear();
        x -= 2;
      
        y2++;
        x2--;
        y4++;
        x4++;
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
    FinalProject.grid[y][x] = 5;
    FinalProject.grid[y2][x2] = 5;
    FinalProject.grid[y3][x3] = 5;
    FinalProject.grid[y4][x4] = 5;
  }
  public void clear()
  {
    FinalProject.grid[y][x] = 0;
    FinalProject.grid[y2][x2] = 0;
    FinalProject.grid[y3][x3] = 0;
    FinalProject.grid[y4][x4] = 0;
  }
  public String getType()
  {
    return "sShape";
  }
  public int getTypeNum()
  {
    return 5;
  }
}
