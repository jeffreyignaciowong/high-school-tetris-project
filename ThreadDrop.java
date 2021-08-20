
public class ThreadDrop implements Runnable{
  
  public ThreadDrop()
  {
    
  }
  
  public void run()
  {
    try{
      while(true)
      {
        Thread.sleep(500);
        FinalProject.drop = true;
      }
    }catch(Exception e){
    }
  }
}
