/**
 * Auto Generated Java Class.
 */
import java.io.InputStream;
import sun.audio.*;
import java.io.File;
import java.io.FileInputStream;
public class ThreadMusic implements Runnable{
  private static boolean play;
  private static AudioStream audios;
  public ThreadMusic()
  {
    
  }
  
  public void run()
  {
    play = true;
    while(play)
    {
    InputStream music;
    try
    {
      music = new FileInputStream(new File("Tetris theme.wav"));
      audios = new AudioStream(music);
      AudioPlayer.player.start(audios);
      //sleep(5000);
      Thread.sleep(83000);
      AudioPlayer.player.stop(audios);
    }
    catch(Exception e)
    {
      //JOptionPane.showMessageDialog(null,"Error");
    }
    }
  }
  public static void setPlayMusic(boolean value)
  {
    play = value;
  }
  public static void stop()
  {
    AudioPlayer.player.stop(audios);
  }
}
