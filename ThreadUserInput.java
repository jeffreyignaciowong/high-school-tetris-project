/**
 *User input thread
 */
import java.util.Scanner;
public class ThreadUserInput implements Runnable{
  
  
  public ThreadUserInput()
  {
    
  }
  
  public void run()
  {
   
    Scanner input = new Scanner(System.in);
    try{
      String userInput = "";
      while(true)
      {
        userInput = input.nextLine();
        if(userInput.equals("a"))
        {
          FinalProject.moveLeft = true; 
        }
        else if(userInput.equals("d"))
        {
          FinalProject.moveRight = true; 
        }
        else if(userInput.equals("e"))
        {
          FinalProject.rotate = true; 
        }
        else if(userInput.equals("w"))
        {
          FinalProject.instantDrop = true; 
        }
      }
    }catch(Exception e){input.close();}
  }
}
