
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class SwingTetris {
  
  public static void main(String[] args) { 
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Tetris");
        FrameUserInput frameUserInput = new FrameUserInput();
        frame.setBounds(10,10,600,800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(frameUserInput);
      }
    });
  }
}
