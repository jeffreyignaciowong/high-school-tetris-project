
public class TShape extends Shape{
  
  //public int x
  //public int y;
  //public int rotation = 1;
  //public boolean instantDrop = false;
  int c = 6;//color
  public TShape(int objectx, int objecty)
  {
    x = objectx;
    y = objecty + 1;
    rotation = 1;
    //update();
    //add gameover
  }
  public void checkGameOver()
  {
    if(!(FinalProject.grid[y][x] == 0 && FinalProject.grid[y+1][x] == 0 && FinalProject.grid[y-1][x] == 0 && FinalProject.grid[y][x+1] == 0 && FinalProject.grid[y][x-1] == 0))
    {
      gameOver = true;
    }
  }
  public void toTop(int objectx, int objecty)
  {
    rotation = 1;
    x = objectx;
    y = objecty + 1;
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
    if(rotation == 1)
    {
      /*  x
       * xxx
       * */
      if(y != 19 && FinalProject.grid[y+1][x] == 0 && FinalProject.grid[y+1][x+1] == 0 && FinalProject.grid[y+1][x-1] == 0)
      {
        FinalProject.grid[y][x-1] = 0;
        FinalProject.grid[y][x+1] = 0;
        FinalProject.grid[y-1][x] = 0;
        y++;
        update();
      }
      else
      {
        FinalProject.newBlock = true;
        instantDrop = false;
      }
    }
    else if(rotation == 2)
    {
      /*  x
       *  xx
       *  x
       * */
      if(y != 18 && FinalProject.grid[y+2][x] == 0 && FinalProject.grid[y+1][x+1] == 0)
      {
        FinalProject.grid[y][x+1] = 0;
        FinalProject.grid[y-1][x] = 0;
        y++;
        update();
      }
      else
      {
        FinalProject.newBlock = true;
        instantDrop = false;
      }
    }
    else if(rotation == 3)
    {
      /*  
       * xxx
       *  x
       * */
      if(y != 18 && FinalProject.grid[y+2][x] == 0 && FinalProject.grid[y+1][x+1] == 0 && FinalProject.grid[y+1][x-1] == 0)
      {
        FinalProject.grid[y][x-1] = 0;
        FinalProject.grid[y][x+1] = 0;
        FinalProject.grid[y][x] = 0;
        y++;
        update();
      }
      else
      {
        FinalProject.newBlock = true;
        instantDrop = false;
      }
    }
    else if(rotation == 4)
    {
      /*   x
       *  xx
       *   x
       * */
      if(y != 18 && FinalProject.grid[y+2][x] == 0 && FinalProject.grid[y+1][x-1] == 0)
      {
        FinalProject.grid[y][x-1] = 0;
        FinalProject.grid[y-1][x] = 0;
        y++;
        update();
      }
      else
      {
        FinalProject.newBlock = true;
        instantDrop = false;
      }
    }
    
  }
  public void moveLeft()
  {
    if(rotation == 1)
    {
      /*  x
       * xxx
       * */
      if(x != 1 && FinalProject.grid[y][x-2] == 0 && FinalProject.grid[y-1][x-1] == 0)
      {
        FinalProject.grid[y][x+1] = 0;
        FinalProject.grid[y-1][x] = 0;
        x--;
        update();
      }
    }
    else if(rotation == 2)
    {
      /*  x
       *  xx
       *  x
       * */
      if(x != 0 && FinalProject.grid[y][x-1] == 0 && FinalProject.grid[y-1][x-1] == 0 && FinalProject.grid[y+1][x-1] == 0)
      {
        FinalProject.grid[y][x+1] = 0;
        FinalProject.grid[y-1][x] = 0;
        FinalProject.grid[y+1][x] = 0;
        x--;
        update();
      }
    }
    else if(rotation == 3)
    {
      /*  
       * xxx
       *  x
       * */
      if(x != 1 && FinalProject.grid[y][x-2] == 0 && FinalProject.grid[y+1][x-1] == 0)
      {
        FinalProject.grid[y][x+1] = 0;
        FinalProject.grid[y+1][x] = 0;
        x--;
        update();
      }
    }
    else if(rotation == 4)
    {
      /*   x
       *  xx
       *   x
       * fixed left x != 0 to left x != 1
       * */
      if(x != 1 && FinalProject.grid[y][x-2] == 0 && FinalProject.grid[y-1][x-1] == 0 && FinalProject.grid[y+1][x-1] == 0)
      {
        FinalProject.grid[y][x] = 0;
        FinalProject.grid[y-1][x] = 0;
        FinalProject.grid[y+1][x] = 0;
        x--;
        update();
      }
    }
  }
  public void moveRight()
  {
    if(rotation == 1)
    {
      /*  x
       * xxx
       * */
      if(x != 8 && FinalProject.grid[y][x+2] == 0 && FinalProject.grid[y-1][x+1] == 0)
      {
        FinalProject.grid[y][x-1] = 0;
        FinalProject.grid[y-1][x] = 0;
        x++;
        update();
      }
    }
    else if(rotation == 2)
    {
      /*  x
       *  xx
       *  x
       * */
      if(x != 8 && FinalProject.grid[y][x+2] == 0 && FinalProject.grid[y+1][x+1] == 0 && FinalProject.grid[y-1][x+1] == 0)
      {
        FinalProject.grid[y][x] = 0;
        FinalProject.grid[y-1][x] = 0;
        FinalProject.grid[y+1][x] = 0;
        x++;
        update();
      }
    }
    else if(rotation == 3)
    {
      /*  
       * xxx
       *  x
       * */
      //fixed x != 1 to x != 8
      if(x != 8 && FinalProject.grid[y][x+2] == 0 && FinalProject.grid[y+1][x+1] == 0)
      {
        FinalProject.grid[y][x-1] = 0;
        FinalProject.grid[y+1][x] = 0;
        x++;
        update();
      }
    }
    else if(rotation == 4)
    {
      /*   x
       *  xx
       *   x
       * */
      //fixed x != 0 to x != 9
      if(x != 9 && FinalProject.grid[y][x+1] == 0 && FinalProject.grid[y-1][x+1] == 0 && FinalProject.grid[y+1][x+1] == 0)
      {
        FinalProject.grid[y][x-1] = 0;
        FinalProject.grid[y-1][x] = 0;
        FinalProject.grid[y+1][x] = 0;
        x++;
        update();
      }
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
      if(y != 19 && FinalProject.grid[y+1][x] == 0 )
      {
      /*  x
       *  xx
       *  x
       * */
        //rotation++;
        FinalProject.grid[y][x-1] = 0;
        update();
      }
    }
    else if(rotation == 3)
    {
      if(x != 0 && FinalProject.grid[y][x-1] == 0)
      {
        /*  
       * xxx
       *  x
       * */
        //rotation++;
        FinalProject.grid[y-1][x] = 0;
        update();
      }
    }
    else if(rotation == 4)
    {
      if(FinalProject.grid[y-1][x] == 0)
      {
        /* x
       *  xx
       *   x
       * */
        //rotation++;
        FinalProject.grid[y][x+1] = 0;
        update();
      }
    }
    else if(rotation == 1)
    {
      if(x != 9 && FinalProject.grid[y][x+1] == 0)
      {
       /* x
       * xxx
       * */
        //rotation++;
        FinalProject.grid[y+1][x] = 0;
        update();
      }
    }
    update();
  }
  public void rotate()
  { 
    if(rotation == 1)
    {
      if(y != 19 && FinalProject.grid[y+1][x] == 0 )
      {
      /*  x
       *  xx
       *  x
       * */
        rotation++;
        FinalProject.grid[y][x-1] = 0;
        update();
      }
    }
    else if(rotation == 2)
    {
      if(x != 0 && FinalProject.grid[y][x-1] == 0)
      {
        /*  
       * xxx
       *  x
       * */
        rotation++;
        FinalProject.grid[y-1][x] = 0;
        update();
      }
    }
    else if(rotation == 3)
    {
      if(FinalProject.grid[y-1][x] == 0)
      {
        /* x
       *  xx
       *   x
       * */
        rotation++;
        FinalProject.grid[y][x+1] = 0;
        update();
      }
    }
    else if(rotation == 4)
    {
      if(x != 9 && FinalProject.grid[y][x+1] == 0)
      {
       /* x
       * xxx
       * */
        rotation++;
        FinalProject.grid[y+1][x] = 0;
        update();
      }
    }
    if(rotation >4)
    {
      rotation = 1;
    }
    update();
  }
  public void update()
  {
    if(rotation == 1)
    {
      /*  x
       * xxx
       * */
      FinalProject.grid[y][x] = c;
      FinalProject.grid[y-1][x] = c;
      FinalProject.grid[y][x+1] = c;
      FinalProject.grid[y][x-1] = c;
    }
    else if(rotation == 2)
    {
      /*  x
       *  xx
       *  x
       * */
      FinalProject.grid[y][x] = c;
      FinalProject.grid[y-1][x] = c;
      FinalProject.grid[y+1][x] = c;
      FinalProject.grid[y][x+1] = c;
    }
    else if(rotation == 3)
    {
      /*  
       * xxx
       *  x
       * */
      FinalProject.grid[y][x] = c;
      FinalProject.grid[y+1][x] = c;
      FinalProject.grid[y][x+1] = c;
      FinalProject.grid[y][x-1] = c;
    }
    else if(rotation == 4)
    {
      /*   x
       *  xx
       *   x
       * */
      FinalProject.grid[y][x] = c;
      FinalProject.grid[y+1][x] = c;
      FinalProject.grid[y-1][x] = c;
      FinalProject.grid[y][x-1] = c;
    }
  }
  public void clear()
  {
    if(rotation == 1)
    {
      /*  x
       * xxx
       * */
      FinalProject.grid[y][x] = 0;
      FinalProject.grid[y-1][x] = 0;
      FinalProject.grid[y][x+1] = 0;
      FinalProject.grid[y][x+-1] = 0;
    }
    else if(rotation == 2)
    {
      /*  x
       *  xx
       *  x
       * */
      FinalProject.grid[y][x] = 0;
      FinalProject.grid[y-1][x] = 0;
      FinalProject.grid[y+1][x] = 0;
      FinalProject.grid[y][x+1] = 0;
    }
    else if(rotation == 3)
    {
      /*  
       * xxx
       *  x
       * */
      FinalProject.grid[y][x] = 0;
      FinalProject.grid[y+1][x] = 0;
      FinalProject.grid[y][x+1] = 0;
      FinalProject.grid[y][x-1] = 0;
    }
    else if(rotation == 4)
    {
      /*   x
       *  xx
       *   x
       * */
      FinalProject.grid[y][x] = 0;
      FinalProject.grid[y+1][x] = 0;
      FinalProject.grid[y-1][x] = 0;
      FinalProject.grid[y][x-1] = 0;
    }
  }
  //public void toTop()
  //{
    //x = 4;
    //y = 1;
    //update();
  //}
  public String getType()
  {
    return "tShape";
  }
  public int getTypeNum()
  {
    return 6;
  }
}
