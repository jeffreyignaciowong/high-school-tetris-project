/**
 * Fixed the T-shap right side out of bounds
 *   x
 * x x
 *   x
 * add rotation counterclockwise
 * //add pause menu
 * //add start screen and controls screen
 * //add end screen
 * //re-add restart option
 * //add loop music
 * add menu music
 * add better score
 * 
 * Jeffrey Wong
 * May 14, 2019
 * ICS4Ua
 * The game is very similar to Tetris. The game is made up of a 10 by 20 grid that can be filled up by blocks.
 * The program will be displayed with java swings instead of ascii characters. The player will be given a random shape that will start at the top and will slowly drop to the bottom.
 * The player can move the block left, right, rotate it 90 degrees and increase the speed or instantly drop to bottom. 
 * The goal of the game is to create a horizontal line of ten units without gaps. This will destroy the line and give the player 10 points. 
 * Also, any block above the deleted line will fall by the number of rows destroyed. 
 */
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.*;
import javax.swing.*;

import java.io.IOException;
public class FinalProject 
{
  public static int [] [] grid = new int[20][10];
  public static boolean drop; //The drop thread will change this value to move down after the thread.sleep
  public static boolean moveLeft; //the user input thread will wait for input and change the value
  public static boolean moveRight; //the user input thread will wait for input and change the value
  public static boolean newBlock; //if movedown in the shape class can not move down then make a new block by changing a value
  public static boolean rotate; //the user input thread will wait for input and change the value
  public static boolean instantDrop; //the user input thread will wait for input and change the value
  
  private static int highScore;
  private static int score;
  private static boolean gameOver;
  private static JFrame frame;
  private static FrameUserInput screen;
  public static void playMusic(String filepath)//https://www.youtube.com/watch?v=3q4f6I5zi2w To play music
  {
    while(true)
    {
      InputStream music;
      try
      {
        music = new FileInputStream(new File(filepath));
        AudioStream audios = new AudioStream(music);
        AudioPlayer.player.start(audios);
        //sleep(5000);
        sleep(83000);
        AudioPlayer.player.stop(audios);
      }
      catch(Exception e)
      {
        JOptionPane.showMessageDialog(null,"Error");
      }
    }
  }
  /*public static void playMusic(String filepath)
  {
    ContinuousAudioDataStream loop = null;
    InputStream in = null;
    try {
        in = new FileInputStream(filepath);
    } catch (FileNotFoundException ex) {
        System.out.println("File not found");
    }
    try {
      AudioStream s = new AudioStream(in);     
      AudioData audiodata = s.getData();
      loop = new ContinuousAudioDataStream(audiodata);
      AudioPlayer.player.start(loop);
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
  }*/
  /*public static void playMusic(String filepath)//www.youtube.com/watch?time_continue=494&v=SCf2x2qGcdI
  {
    AudioPlayer MGP = AudioPlayer.player;
    AudioStream BGM;
    AudioData MD;
    ContinuousAudioDataStream loop = null;
    try{
      BGM = new AudioStream(new FileInputStream(new File(filepath)));
      MD = BGM.getData();
      loop = new ContinuousAudioDataStream(MD);
    }catch(Exception e)
    {
      
    }
    MGP.start(loop);
  }*/
  /*public static void playMusic(String filepath)//https://www.youtube.com/watch?v=SL6xPHgrBmA
  {
    System.out.println("PLAY MUSIC");
    //Thread t2 = new Thread();
    try{
      AudioData data = new AudioStream(new FileInputStream(filepath)).getData();
      ContinuousAudioDataStream sound = new ContinuousAudioDataStream(data);
      AudioPlayer.player.start(sound);
      Scanner input = new Scanner(System.in);
    input.nextLine();
    input.close();
      AudioPlayer.player.stop(sound);
    }catch(Exception e)
    {
      
    }
    Scanner input = new Scanner(System.in);
    input.nextLine();
    input.close();
    
  }*/
  public static void main(String[] args) throws FileNotFoundException
  { 
    //playMusic("Tetris theme.wav");
    
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        frame = new JFrame("Tetris");
        FrameUserInput frameUserInput = new FrameUserInput();
        frame.setBounds(10,10,672,800);//704,800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(frameUserInput);
      }
    });
    
    homeScreen();
  }
  public static void homeScreen()throws FileNotFoundException
  {
    
    highScore = 0;
    Scanner highScoreReader = new Scanner(new File("highScore.txt"));
    highScore = highScoreReader.nextInt();
    //System.out.println("DEBUG: highScore = " + highScore);
    highScoreReader.close();
    screen = new FrameUserInput(grid);
    while(true)
    {
      drop = false;
      moveLeft = false;
      moveRight = false;
      newBlock = false;
      rotate = false;
      instantDrop = false;
      score = 0;
      gameOver = false;
      //String userInput = "";
      //Scanner input = new Scanner(System.in);
      //screen = new FrameUserInput(grid);
      printGrid();
      while(!gameOver)//waits for a valid input
      {
        //grid[0][0] = 1;
        //screen = new FrameUserInput(grid);
        //printGrid();
        if(screen.getState().equals("game"))
        {
          start();
        }
        printGrid();
        sleep(10);
        /*System.out.println("Enter 'start' to start or enter 'controls' for controls");
        System.out.println("High score = " + highScore);
        userInput = input.nextLine();
        userInput = userInput.toLowerCase();
        if(userInput.equals("controls"))
        {
          controls(input);
        }
        else if(userInput.equals("start"))
        {
          input.close();
          start();
          //System.out.println("DEBUG: NEW GAME WHILE LOOP");
          break;
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");*/
      }
      while(screen.queueSize() != 0)
      {
        //System.out.println("DEBUG: removeQueue");
        screen.removeQueue();
      }
      //System.out.println("DEBUG: " + screen.queueSize());
      while(screen.sizeHoldQ() != 0)
      {
        screen.removeHoldQ();
      }
    }
    //System.out.println("broke to far");
  }
  /*public static void controls(Scanner input)throws FileNotFoundException
  {
    System.out.println("'a' is to move left");
    System.out.println("'d' is to move right");
    System.out.println("'s' is to instant drop");
    System.out.println("'e' is to rotate");
    System.out.println("Press the enter to return to homescreen");
    input.nextLine();
    
    homeScreen();
  }*/
  public static void start() throws FileNotFoundException
  {
    zeroGrid();
    startThreads();
  }
  public static void startThreads() throws FileNotFoundException//start the drop thread and user inpu thread
  {
    ThreadDrop dropThread = new ThreadDrop();
    //Thread t1 = new Thread(new ThreadUserInput());
    Thread t1 = new Thread(new ThreadMusic());
    Thread t2 = new Thread(dropThread);
    t2.start();
    t1.start();
    for(int i = 0; i < 6; i++)
    {
      newShape();
    }
    while(!gameOver)
    {
      runGrid(screen.removeQueue(),t1,t2);
      if(screen.getHold())
      {
        //System.out.println("DEBUG: sizeHoldQ = " + screen.sizeHoldQ());
        screen.setHold(false);
        if(screen.sizeHoldQ() != 1)
        {
          //System.out.println("DEBUG: second time hold");
          //screen.setHold();
          runGrid(screen.removeHoldQ(),t1,t2);
          //screen.setUsedHold(false);
        }
        else
        {
          newShape();
          runGrid(screen.removeQueue(),t1,t2);
          //screen.setUsedHold(false);
        }
        screen.setUsedHold(false);
        screen.setHold(false);
      }
      newShape();
    }
  }
  public static void endThreads(Thread t1, Thread t2) throws FileNotFoundException//when you lose close the threads
  {
    ThreadMusic.stop();
    ThreadMusic.setPlayMusic(false);
    t1.interrupt();
    t2.interrupt();
  }
  public static void newShape() throws FileNotFoundException//This gets a new random shape 
  {
    
    int randnum = 0;
    Random rand = new Random();
    randnum = rand.nextInt(7)+1;
    switch (randnum)
    {
      case(1)://lightBlue
        Shape iShape = new IShape(4,0);
        screen.addQueue(iShape);
        //runGrid(iShape, t1, t2);
        break;
      case(2)://blue
        Shape jShape = new JShape(4,0);
        screen.addQueue(jShape);
        //runGrid(jShape, t1, t2);
        break;
      case(3)://orange
        Shape lShape = new LShape(4,0);
        screen.addQueue(lShape);
        //runGrid(lShape, t1, t2);
        break;
      case(4)://yellow
        Shape square = new Square(4,0);
        screen.addQueue(square);
        //runGrid(square, t1, t2);
        break;
      case(5)://green
        Shape sShape = new SShape(4,0);
        screen.addQueue(sShape);
        //runGrid(sShape, t1, t2);
        break;
      case(6)://purple
        Shape tShape = new TShape(4,0);
        screen.addQueue(tShape);
        //runGrid(tShape, t1, t2);
        break;
      case(7)://red
        Shape zShape = new ZShape(4,0);
        screen.addQueue(zShape);
        //runGrid(zShape, t1, t2);
        break;
    }
    
  }
  public static void runGrid(Shape object, Thread t1, Thread t2) throws FileNotFoundException//this methods checks for a change in value and if there is then do that change with the shape's method
  {
    //printGrid();
    //if(grid[0][4] == 0)
    //{
    object.checkGameOver();
    if(!object.gameOver)
    {
      object.update();
      printGrid();
    }
    //}
    //else
    //{
      //object.gameOver = true;
      //printGrid();
    //}
    while(true)
    {
      if(object.gameOver) //GAME OVER
      {
        Scanner input = new Scanner(System.in);
        endThreads(t1, t2);
        screen.setState("gameOver");
        printGrid();
        
        //System.out.println(screen.getState());
        while(true)//waits for a valid input
        {
          if(screen.getState().equals("menu"))
          {
            break;
          }
          printGrid();
          sleep(10);
        }
        /*System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n GAME OVER \n Press 'enter'");
        input.nextLine();
        input.close();*/
        if(score > highScore)
        {
          //System.out.println("DEBUG: new highScore score = " + score + " highScore = " + highScore);
          PrintStream output = new PrintStream("highScore.txt");
          output.println(score);
          output.close();
          highScore = score;
        }
        zeroGrid();
        gameOver = true;
        return;
      }
      if(screen.getPause())
      {
        //t2.suspend();
        //System.out.println("DEBUG: pause");
        printGrid();
        while(screen.getPause())        
        {
          
          sleep(10);
        }
        //t2.resume();
      }
      if(screen.getHold() && (!screen.getUsedHold()))// fix if player spams f
      {
        //System.out.println("DEBUG: inside hold");
        screen.setUsedHold(true);
        object.clear();
        object.toTop(4,0);
        screen.addHoldQ(object);
        return;
      }
      if(drop) //MOVEDOWN
      {
        drop = false;
        object.moveDown();
        printGrid();
      }
      if(rotate)
      {
        object.rotate();
        printGrid();
        rotate = false;
      }
      if(screen.getRotateCounterclockwise())
      {
        object.rotate(false);
        printGrid();
        screen.setRotateCounterclockwise(false);
      }
      if(moveLeft)
      {
        moveLeft = false;
        object.moveLeft();
        printGrid();
      }
      if(moveRight)
      {
        moveRight = false;
        object.moveRight();
        printGrid();
      }
      if(instantDrop)
      {
        instantDrop = false; 
        object.instantDrop();
      }
      if(newBlock)
      {
        newBlock = false;
        //boolean firstRowDeleted = false;
        int rowCount = 0;
        int []moveRowDown = {-1,-1,-1,-1};
        int rowdowncount = 0;
        for(int row = 19; row >= 0; row--)//checks if a row is full
        {
          for(int i = 0; i < 10;i++)
          {
            if(grid[row][i] != 0)
            rowCount ++;
          }
          if(rowCount == 10)
          {
            moveRowDown[rowdowncount] = row;
            rowdowncount++;
            for(int i = 0; i < 10;i++)//deleted the row by making it all zero
            {
              grid[row][i] = 0;
            }
            score += 10;
          }
          rowCount = 0;
        }
        if(moveRowDown[0] != -1 || moveRowDown[1] != -1 || moveRowDown[2] != -1 || moveRowDown[3] != -1)//see which rows are deleted
        {
          int s = 0;
          for(int t = 0; t <= 3; t++)//shifts the rows down
          {
            if(moveRowDown[t] != -1)
            {
             for(int z = moveRowDown[t]; z >= 1 +s;z--)
             {
              for(int i = 0; i < 10;i++)
              {
                grid[z+s][i] = grid[z+s -1][i];
              }
             }
             s++;
            }
          }
        }
        
        return;
      }
      sleep(10);
    }
  }
  public static void zeroGrid()
  {
    for(int row = 0; row <= grid.length - 1;row++)
    {
      for(int col = 0; col <= grid[row].length -1; col++)
      {
        grid[row][col] = 0;
      }
      //System.out.println();
    }
  }
  public static void printGrid()
  {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        screen.drawing();
        frame.add(screen);
      }
    });
  }
  public static void sleep(int time)
  {
    try{
      Thread.sleep(time);
    } catch (Exception e) {}
  }
  
  public static int getScore()
  {
    return score;
  }
  public static int getHighScore()
  {
    return highScore;
  }
}

