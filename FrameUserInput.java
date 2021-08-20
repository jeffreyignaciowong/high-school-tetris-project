/**
 * Auto Generated Java Class.
 */
import javax.swing.JPanel;
//import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*; 
//import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.LinkedList;
import java.awt.BasicStroke;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.event.MouseListener;
public class FrameUserInput extends JPanel implements KeyListener, MouseListener {
  /*private enum STATE{ //https://www.youtube.com/watch?v=FZWX5WoGW00
    MENU,
    GAME
  };//https://www.youtube.com/watch?v=qfjxLRrHS0c*/
  /*
   * https://stackoverflow.com/questions/15327220/fill-rectangle-with-pattern-in-java-swing 
   https://stackoverflow.com/questions/6132988/painting-in-a-bufferedimage-inside-swing 
   http://www.java2s.com/Code/Java/2D-Graphics-GUI/Loadanddrawimage.htm 
   https://www.youtube.com/watch?time_continue=728&v=5jhzWZa1J7I 
   https://www.youtube.com/watch?v=5jhzWZa1J7I 
*/
  private static boolean pause = false;
  private static String state = "menu";
  private final int buttonWidth = 150;
  private final int buttonLength = 50;
  public Rectangle playButton = new Rectangle(100,150,buttonWidth,buttonLength);
  public Rectangle controlsButton = new Rectangle(100,250,buttonWidth,buttonLength);
  public Rectangle quitButton = new Rectangle(100,350,buttonWidth,buttonLength);
  public void renderMenu(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    this.setBackground(Color.darkGray);
    Font fnt0 = new Font("arial", Font.BOLD, 50);
    g.setFont(fnt0);
    g.setColor(Color.white);
    g.drawString("Tetris",100,100);
    
    Font fnt1 = new Font("arial", Font.BOLD, 30);
    g.setFont(fnt1);
    g.drawString("Play",playButton.x,playButton.y+30);
    g2d.draw(playButton);
    g.drawString("Controls",controlsButton.x,controlsButton.y+30);
    g2d.draw(controlsButton);
    g.drawString("Quit",quitButton.x,quitButton.y+30);
    g2d.draw(quitButton);
  }
  public void renderControls(Graphics g)
  {
    Graphics2D g2d = (Graphics2D) g;
    this.setBackground(Color.darkGray);
    Font fnt0 = new Font("arial", Font.BOLD, 50);
    g.setFont(fnt0);
    g.setColor(Color.white);
    g.drawString("Controls",100,100);
    
    Font fnt1 = new Font("arial", Font.BOLD, 30);
    g.setFont(fnt1);
    g.drawString("hold 's' to speed up the drop speed",playButton.x,playButton.y);
    g.drawString("'a' is to move left. 'd' is to move right.",playButton.x,playButton.y+30);
    g.drawString("'w' is to instant drop. 'e' is to rotate",playButton.x,playButton.y+60);
    g.drawString("'escape' to pause",playButton.x,playButton.y+90);
    g.drawString("Menu",controlsButton.x,controlsButton.y+30);
    g2d.draw(controlsButton);

  }
  public void renderGameOver(Graphics g)
  {
    Graphics2D g2d = (Graphics2D) g;
    this.setBackground(Color.darkGray);
    Font fnt0 = new Font("arial", Font.BOLD, 50);
    g.setFont(fnt0);
    g.setColor(Color.white);
    g.drawString("Game Over",100,100);
    
    Font fnt1 = new Font("arial", Font.BOLD, 30);
    g.setFont(fnt1);
    g.setColor(Color.RED);
    g.drawString("High Score = " + FinalProject.getHighScore(),playButton.x,playButton.y+30);
    g.setColor(Color.white);
    g.drawString("restart",controlsButton.x,controlsButton.y+30);
    g2d.draw(controlsButton);
    g.drawString("Quit",quitButton.x,quitButton.y+30);
    g2d.draw(quitButton);
  }
  //private STATE State = STATE.MENU;
  @Override
  public void mouseEntered(MouseEvent e)
  {
    
  }
  @Override
  public void mouseExited(MouseEvent e)
  {
    
  }
  @Override
  public void mousePressed(MouseEvent e)
  {
    int mx = e.getX();
    int my = e.getY();
    //System.out.println("DEBUG: mx = " + mx + "my = " + my);
    if(mx > playButton.x &&  mx < buttonWidth + playButton.x)
    {
      //System.out.println("DEBUG: inside mx");
      if(state.equals("menu"))
      {
        if(my > playButton.y && my < buttonLength + playButton.y)
        {
          state = "game";
        }
        else if(my > controlsButton.y && my < buttonLength + controlsButton.y)
        {
          //System.out.println("DEBUG: inside control");
          state = "control";
        }
        else if(my > quitButton.y && my < buttonLength + quitButton.y)
        {
          System.exit(0);
        }
      }
      else if(state.equals("control"))
      {
        if(my > controlsButton.y && my < buttonLength + controlsButton.y)
        {
          state = "menu";
        }
      }
      else if(state.equals("gameOver"))
      {
        if(my > controlsButton.y && my < buttonLength + controlsButton.y)
        {
          state = "menu";
        }
        else if(my > quitButton.y && my < buttonLength + quitButton.y)
        {
          System.exit(0);
        }
      }
    }
  }
  @Override
  public void mouseReleased(MouseEvent e)
  {
    
  }
  @Override
  public void mouseClicked(MouseEvent e) 
  {
    
  }
  public String getState()
  {
    return state;
  }
  public void setState(String state)
  {
    this.state = state;
  }
  /*
   * grid size is 20 * 32
   * 10*32
   * 
   * */
  public static final long serialVersionUID = 2L;
  private int[][] grid;
  private boolean withGrid;
  private int topY = 55;//25;
  private int topX = 170;//200;
  private int qX = 11;
  //private int queuey = 0;
  private Queue<Shape> queue;
  //private boolean queueBeingUsed = false;
  private Queue<Shape> holdQ;
  private static boolean hold;
  private static boolean usedHold;
  private static BufferedImage[] img;
  private static boolean rotateCounterclockwise;
  public FrameUserInput()
  {
    hold = false;
    usedHold = false;
    withGrid = false;
    addKeyListener(this);
    setFocusable(true);
    queue = new LinkedList<Shape>();
    holdQ = new LinkedList<Shape>();
    this.addMouseListener(this);
    //setFocusTraversalKeysEnable(false);
  }
  public FrameUserInput(int[][] grid)
  {
    hold = false;
    usedHold = false;
    this.grid = grid;
    withGrid = true;
    addKeyListener(this);
    setFocusable(true);
    queue = new LinkedList<Shape>();
    holdQ = new LinkedList<Shape>();
    this.addMouseListener(this);
    //setFocusTraversalKeysEnable(false);
    
    
    img = new BufferedImage [7];
    try
    {
       
       img[0]= ImageIO.read(new File("lightBlue.png"));
       img[1]= ImageIO.read(new File("blue.png"));
       img[2]= ImageIO.read(new File("orange.png"));
       img[3]= ImageIO.read(new File("yellow.png"));
       img[4]= ImageIO.read(new File("green.png"));
       img[5]= ImageIO.read(new File("purple.png"));
       img[6]= ImageIO.read(new File("red.png"));
       //img[7]= ImageIO.read(new File("background.png"));
    }
    catch(Exception e)
    {
      
    }
  }
  public void drawing() {
    repaint();
  }
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    if(state.equals("game"))
    {
      renderGame(g);
      if(pause)
      {
        //System.out.println("DEBUG: pause paint");
        renderPause(g);
      }
    }
    else if(state.equals("menu"))
    {
      renderMenu(g);
    }
    else if(state.equals("control"))
    {
      renderControls(g);
    }
    else if(state.equals("gameOver"))
    {
      renderGameOver(g);
    }
  }
  public void renderPause(Graphics g)
  {
    //g.setColor(Color.darkGray);
    //g.fillRect(0,0,672,800);
    g.setColor(Color.RED);
    Font fnt1 = new Font("arial", Font.BOLD, 50);
    g.setFont(fnt1);
    g.drawString("press",topX,200);
    g.drawString("'escape'",topX,250);
    g.drawString("to unpause",topX,300);
  }
  public void renderGame(Graphics g)
  {
    this.setBackground(Color.darkGray);
    
    
    
    g.setColor(Color.lightGray);
    g.fillRect(topX,topY,320,640);
    //g.drawImage(img[7],0,0,null);
    g.setColor(Color.RED);
    Font fnt1 = new Font("arial", Font.BOLD, 30);
    g.setFont(fnt1);
    g.drawString("score = " + FinalProject.getScore(),topX,35);
    if(withGrid){
      square(g,1,1);
      printGrid(g);
      //might cause a bug queue access by to threads
      //queueBeingUsed = true;
      for(int i = 0; i<queue.size(); i++)
      {
        Shape shape = queue.remove();
        int type = shape.getTypeNum();
        switch(type)
        {
          case(1)://"iShape":
            drawI(g,qX,i*3);
            break;
          case(2)://"jShape":
            drawJ(g,qX,i*3);
            break;
          case(3)://"lShape":
            drawL(g,qX,i*3);
            break;
          case(4)://"square":
            drawSquare(g,qX,i*3);
            break;
          case(5)://"sShape":
            drawS(g,qX,i*3);
            break;
          case(6)://"tShape":
            drawT(g,qX,i*3);
            break;
          case(7)://"zShape":
            drawZ(g,qX,i*3);
            break;
        }
        queue.add(shape);
      }
      for(int i = 0; i<holdQ.size(); i++)
      {
      Shape shape = holdQ.remove();
        int type = shape.getTypeNum();
        switch(type)
        {
          case(1)://"iShape":
            drawI(g,-5,0);
            break;
          case(2)://"jShape":
            drawJ(g,-5,0);
            break;
          case(3)://"lShape":
            drawL(g,-5,0);
            break;
          case(4)://"square":
            drawSquare(g,-5,0);
            break;
          case(5)://"sShape":
            drawS(g,-5,0);
            break;
          case(6)://"tShape":
            drawT(g,-5,0);
            break;
          case(7)://"zShape":
            drawZ(g,-5,0);
            break;
        }
        holdQ.add(shape);
      }
    }
  }
  public void square(Graphics g, int x , int y,int color){
    x= topX + x*32;
    y= topY+ y*32;
    g.drawImage(img[color-1],x,y,null);
  }
  
  public void square(Graphics g, int x , int y){
    x= topX + x*32;
    y= topY+ y*32;
    //g.setColor(Color.BLUE);
    g.setColor(Color.BLUE);
    g.fillRect(x,y,32,32);
    float thickness = 1.0f;
    Graphics2D g2 = (Graphics2D) g;
    Stroke oldStroke = g2.getStroke();
    g2.setStroke(new BasicStroke(thickness));
    g2.setPaint(Color.GRAY);
    //g2.setColor(Color.BLUE);
    Rectangle r = new Rectangle(x,y,32,32);
    
    g2.draw(r);
    //g2.fillRect(x,y,30,30);
    g2.setStroke(oldStroke);
  }
  public void blank(Graphics g, int x , int y){
    x= topX + x*32;
    y= topY+ y*32;
    g.setColor(Color.lightGray);
    g.fillRect(x,y,32,32);
    float thickness = 1.0f;
    Graphics2D g2 = (Graphics2D) g;
    Stroke oldStroke = g2.getStroke();
    g2.setStroke(new BasicStroke(thickness));
    g2.setPaint(Color.GRAY);
    //g.setColor(Color.lightGray);
    Rectangle r = new Rectangle(x,y,32,32);
    
    g2.draw(r);
    g2.setStroke(oldStroke);
    //g.fillRect(x,y,30,30);
  }
  
  public void drawI(Graphics g, int x , int y)
  {
    // x x x x
    square(g,x,y,1);
    square(g,x+1,y,1);
    square(g,x+2,y,1);
    square(g,x+3,y,1);
  }
  public void drawJ(Graphics g, int x , int y)
  {
    /*
     * x
     * x x x
     * */
    square(g,x,y,2);
    square(g,x,y+1,2);
    square(g,x+1,y+1,2);
    square(g,x+2,y+1,2);
  }
  public void drawL(Graphics g, int x , int y)
  {
    /*
     *     x
     * x x x
     * */
    square(g,x,y+1,3);
    square(g,x+1,y+1,3);
    square(g,x+2,y+1,3);
    square(g,x+2,y,3);
  }
  public void drawSquare(Graphics g, int x , int y)
  {
    /*
     * x x
     * x x 
     * */
    square(g,x,y,4);
    square(g,x,y+1,4);
    square(g,x+1,y,4);
    square(g,x+1,y+1,4);
  }
  public void drawS(Graphics g, int x , int y)
  {
    /*
     *   x x
     * x x 
     * */
    square(g,x,y+1,5);
    square(g,x+1,y+1,5);
    square(g,x+1,y,5);
    square(g,x+2,y,5);
  }
  public void drawT(Graphics g, int x , int y)
  {
    /*
     *   x
     * x x x
     * */
    square(g,x,y+1,6);
    square(g,x+1,y+1,6);
    square(g,x+1,y,6);
    square(g,x+2,y+1,6);
  }
  public void drawZ(Graphics g, int x , int y)
  {
    /*
     * x x
     *   x x
     * */
    square(g,x,y,7);
    square(g,x+1,y,7);
    square(g,x+1,y+1,7);
    square(g,x+2,y+1,7);
  }
  public void printGrid(Graphics g)
  {
    //System.out.println("DEBUG: OOF2");
    for(int row = 0; row <= grid.length - 1;row++)
    {
      for(int col = 0; col <= grid[row].length -1; col++)
      {
        //System.out.print(grid[row][col]);
        if(grid[row][col] == 0)
        {
          blank(g,col,row);
        }
        else
        {
          //System.out.println("DEBUG: OOF3");
          square(g,col,row,grid[row][col]);
        }
      }
    }
  }
  
  @Override
  public void keyTyped(KeyEvent e){
  }
  @Override
  public void keyReleased(KeyEvent e){
  }
  @Override
  public void keyPressed(KeyEvent e)
  {
    //System.out.println("Test");
    if(e.getKeyCode() == KeyEvent.VK_A)
    {
      FinalProject.moveLeft = true; 
    }
    else if(e.getKeyCode() == KeyEvent.VK_D)
    {
      FinalProject.moveRight = true; 
    }
    else if(e.getKeyCode() == KeyEvent.VK_E)
    {
      FinalProject.rotate = true; 
    }
    /*else if(e.getKeyCode() == KeyEvent.VK_Q)
    {
      rotateCounterclockwise = true;
    }*/
    else if(e.getKeyCode() == KeyEvent.VK_W)
    {
      FinalProject.instantDrop = true; 
    }
    else if(e.getKeyCode() == KeyEvent.VK_S)
    {
      FinalProject.drop = true; 
    }
    else if(e.getKeyCode() == KeyEvent.VK_F)
    {
      hold = true;
      //System.out.println("DEBUG: HOLD F");
      //System.out.println("DEBUG: hold" + hold);
      //System.out.println("DEBUG: usedHold" + usedHold);
    }
    else if(e.getKeyCode() == KeyEvent.VK_ESCAPE && state.equals("game"))
    {
      //System.out.println("DEBUG: esc");
      pause = !pause;
    }
  }
  public Boolean getRotateCounterclockwise()
  {
    return rotateCounterclockwise;
  }
  public void setRotateCounterclockwise(boolean value)
  {
    rotateCounterclockwise = value;
  }
  public Boolean getPause()
  {
    return pause;
  }
  public void setPause(boolean value)
  {
    pause = value;
  }
  public void addQueue(Shape object)
  {
    queue.add(object);
  }
  public Shape removeQueue()
  {
    return queue.remove();
  }
  public int queueSize()
  {
    return queue.size();
  }
  public void addHoldQ(Shape object)
  {
    holdQ.add(object);
  }
  public Shape removeHoldQ()
  {
    return holdQ.remove();
  }
  public int sizeHoldQ()
  {
    return holdQ.size();
  }
  public Boolean getHold()
  {
    //System.out.println("DEBUG: hold" + hold);
    return hold;
  }
  public void setHold(boolean value)
  {
    hold = value;
  }
  public Boolean getUsedHold()
  {
    return usedHold;
  }
  public void setUsedHold(boolean value)
  {
    usedHold = value;
  }
}
