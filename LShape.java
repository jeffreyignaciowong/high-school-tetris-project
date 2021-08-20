
public class LShape extends Shape{
  public int x2;
  public int y2;
  public int x3;
  public int y3;
  public int x4;
  public int y4;
  public LShape(int objectx, int objecty)
  {
      x = objectx;
      y = objecty + 1;
      x2 = objectx + 1;
      y2 = objecty + 1;
      x3 = objectx + 2;
      y3 = objecty + 1;
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
    x3 = objectx + 2;
    y3 = objecty + 1;
    x4 = objectx + 2;
    y4 = objecty;
  }
  public void moveDown()
  {
    if(rotation == 1 && y2 !=19 && FinalProject.grid[y2+1][x2] == 0 && FinalProject.grid[y3+1][x3] == 0 && FinalProject.grid[y+1][x] == 0)
    {
      clear();
      y4++;
      y3++;
      y2++;
      y++;
      update();
    }
    else if(rotation == 2 && y3 != 19 && FinalProject.grid[y3+1][x3] == 0 && FinalProject.grid[y4+1][x4] == 0)
    {
      clear();
      y4++;
      y3++;
      y2++;
      y++;
      update();
    }
    else if(rotation == 3 && y4 !=19 && FinalProject.grid[y4+1][x4] == 0 && FinalProject.grid[y2+1][x2] == 0 && FinalProject.grid[y+1][x] == 0)
    {
      clear();
      y4++;
      y3++;
      y2++;
      y++;
      update();
    }
    else if(rotation == 4 && y != 19 && FinalProject.grid[y+1][x] == 0 && FinalProject.grid[y4+1][x4] == 0)
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
    if(rotation == 1 && x !=0 && FinalProject.grid[y][x-1] == 0 && FinalProject.grid[y4][x4-1] == 0)
    {
      clear();
      x--;
      x2--;
      x3--;
      x4--;
      update();
    }
    else if(rotation == 2 && x3 !=0 && FinalProject.grid[y3][x3-1] == 0 && FinalProject.grid[y][x-1] == 0 && FinalProject.grid[y2][x2-1] == 0)
    {
      clear();
      x--;
      x2--;
      x3--;
      x4--;
      update();
    }
    else if(rotation == 3 && x4 !=0 && FinalProject.grid[y3][x3-1] == 0 && FinalProject.grid[y4][x4-1] == 0)
    {
      clear();
      x--;
      x2--;
      x3--;
      x4--;
      update();
    }
    else if(rotation == 4 && x4 !=0 && FinalProject.grid[y][x-1] == 0 && FinalProject.grid[y4][x4-1] == 0 && FinalProject.grid[y2][x2-1] == 0)
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
    if(rotation == 1 && x4 !=9 && FinalProject.grid[y4][x4+1] == 0 && FinalProject.grid[y3][x3+1] == 0)
    {
      clear();
      x++;
      x2++;
      x3++;
      x4++;
      update();
    }
    else if(rotation == 2 && x4 != 9 && FinalProject.grid[y4][x4+1] == 0 && FinalProject.grid[y2][x2+1] == 0 && FinalProject.grid[y][x+1] == 0)
    {
      clear();
      x++;
      x2++;
      x3++;
      x4++;
      update();
    }
    else if(rotation == 3 && x !=9 && FinalProject.grid[y4][x4+1] == 0 && FinalProject.grid[y][x+1] == 0)
    {
      clear();
      x++;
      x2++;
      x3++;
      x4++;
      update();
    }
    else if(rotation == 4 && x2 != 9 && FinalProject.grid[y][x+1] == 0 && FinalProject.grid[y3][x3+1] == 0 && FinalProject.grid[y2][x2+1] == 0)
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
      if(rotation >4)
      {
        rotation = 1;
      }
    }
    else
    {
      rotation--;
      if(rotation < 1)
      {
        rotation = 4;
      }
    }
    if(rotation == 2)
    {
      if(y != 19 && FinalProject.grid[y-1][x+1] == 0 && FinalProject.grid[y3+1][x3-1] == 0 && FinalProject.grid[y4+2][x4] == 0)
      {
        //rotation++;
        clear();
        x++;
        y--;
        x3--;
        y3++;
        
        y4+=2;
        update();
      }
    }
    else if(rotation == 3)
    {
      if(x != 0 && FinalProject.grid[y+1][x+1] == 0 && FinalProject.grid[y3-1][x3-1] == 0 && FinalProject.grid[y4][x4-2] == 0)
      {
        //rotation++;
        clear();
        y++;
        x++;
        x3--;
        y3--;
        x4-=2;
        
        update();
      }
    }
    else if(rotation == 4)
    {
      if(y != 0 && FinalProject.grid[y+1][x-1] == 0 && FinalProject.grid[y3-1][x3+1] == 0 && FinalProject.grid[y4-2][x4] == 0)
      {
        //rotation++;
        clear();
        x--;
        y++;
        x3++;
        y3--;
        
        y4-=2;
        update();
      }
    }
    else if(rotation == 1)
    {
      if(x != 9 && FinalProject.grid[y-1][x-1] == 0 && FinalProject.grid[y3+1][x3+1] == 0 && FinalProject.grid[y4][x4+2] == 0)
      {
        //rotation++;
        clear();
        y--;
        x--;
        x3++;
        y3++;
        x4+=2;
        
        update();
      }
    }
  }
  public void rotate()
  {
    
    if(rotation == 1)
    {
      if(y != 19 && FinalProject.grid[y-1][x+1] == 0 && FinalProject.grid[y3+1][x3-1] == 0 && FinalProject.grid[y4+2][x4] == 0)
      {
        rotation++;
        clear();
        x++;
        y--;
        x3--;
        y3++;
        
        y4+=2;
        update();
      }
    }
    else if(rotation == 2)
    {
      if(x != 0 && FinalProject.grid[y+1][x+1] == 0 && FinalProject.grid[y3-1][x3-1] == 0 && FinalProject.grid[y4][x4-2] == 0)
      {
        rotation++;
        clear();
        y++;
        x++;
        x3--;
        y3--;
        x4-=2;
        
        update();
      }
    }
    else if(rotation == 3)
    {
      if(y != 0 && FinalProject.grid[y+1][x-1] == 0 && FinalProject.grid[y3-1][x3+1] == 0 && FinalProject.grid[y4-2][x4] == 0)
      {
        rotation++;
        clear();
        x--;
        y++;
        x3++;
        y3--;
        
        y4-=2;
        update();
      }
    }
    else if(rotation == 4)
    {
      if(x != 9 && FinalProject.grid[y-1][x-1] == 0 && FinalProject.grid[y3+1][x3+1] == 0 && FinalProject.grid[y4][x4+2] == 0)
      {
        rotation++;
        clear();
        y--;
        x--;
        x3++;
        y3++;
        x4+=2;
        
        update();
      }
    }
    if(rotation >4)
    {
      rotation = 1;
    }
  }
  public void update()
  {
    FinalProject.grid[y][x] = 3;
    FinalProject.grid[y2][x2] = 3;
    FinalProject.grid[y3][x3] = 3;
    FinalProject.grid[y4][x4] = 3;
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
    return "lShape";
  }
  public int getTypeNum()
  {
    return 3;
  }
}
