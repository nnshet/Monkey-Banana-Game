package bean;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import states.IdleMonkey;
import states.State;

public class Monkey {
	

    public String imgCrossFilename = "images/monkey.png";
    private State currentMonkeyState = new IdleMonkey();
    
	ImageIcon monkeyIcon = null;
	private int posX;
	private int poY;
	private int k=0;
		
	 public String getImgCrossFilename() {
			return imgCrossFilename;
	}
	public void setImgCrossFilename(String imgCrossFilename) {
			this.imgCrossFilename = imgCrossFilename;
	}
	public ImageIcon getMonkeyIcon() {
			return monkeyIcon;
	}
	public void setMonkeyIcon(ImageIcon iconCross) {
			this.monkeyIcon = iconCross;
	}
		
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPoY() {
		return poY;
	}
	public void setPoY(int poY) {
		this.poY = poY;
	}
	
	public ImageIcon getImageIconUsingURL() {
		
		URL imgURL = getClass().getClassLoader().getResource(this.imgCrossFilename);
		   
        if (imgURL != null) {
            this.monkeyIcon = new ImageIcon(imgURL);
            
        } else {
            System.err.println("Couldn't find file: " + this.imgCrossFilename);
         }
		return this.monkeyIcon;
        
	}

	public void keyLeftPressed() {
		// TODO Auto-generated method stub
		currentMonkeyState = currentMonkeyState.keyPressLeft(this);
	}
	public void keyDownPressed(int smallSide) {
		// TODO Auto-generated method stub
		currentMonkeyState = currentMonkeyState.keyDownPressed(this,smallSide);
	}
	public void KeyUpPressed() {
		// TODO Auto-generated method stub

		currentMonkeyState = currentMonkeyState.keyUpPressed(this);
	}
	public void keyRightPressed(int smallSide) {
		// TODO Auto-generated method stub

		currentMonkeyState = currentMonkeyState.keyRightPressed(this,smallSide);
	} 
	public void isAtDestination(JPanel panel){
		
		currentMonkeyState = currentMonkeyState.checkIdleState(this);
		panel.repaint();
	}
	
	
}
