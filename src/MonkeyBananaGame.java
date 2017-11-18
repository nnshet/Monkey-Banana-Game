import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import bean.WonderLand;

public class MonkeyBananaGame {

	
	   private static void createAndShowGui() {
	    	
	        JFrame frame = new JFrame("MonkeyBananaGame");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add(new WonderLand());
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(new Runnable() {
    	    public void run() {
    	    	createAndShowGui();
    	    }
    	});
	}

}
