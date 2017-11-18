package bean;

import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;

public class Banana {


	public String bananaImgUrl = "images/smallbananapng.png";
	int posX;
	int posY;
	int timer = 15;
	ImageIcon bananaImg = null;
	
	public String getBananaImgUrl() {
		return bananaImgUrl;
	}

	public void setBananaImgUrl(String bananaImgUrl) {
		this.bananaImgUrl = bananaImgUrl;
	}

	public ImageIcon getBananaImg() {
		return bananaImg;
	}

	public void setBananaImg(ImageIcon bananaImg) {
		this.bananaImg = bananaImg;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getTimer() {
		return timer;
	}
	
	
	public ImageIcon getBananaImageIconUsingURL() {
		
		URL img2Url = getClass().getClassLoader().getResource(this.bananaImgUrl);
	  if (img2Url != null) {
          
          this.bananaImg = new ImageIcon(img2Url);
      } else {
          System.err.println("Couldn't find file: " + this.bananaImgUrl);
       }
	return this.bananaImg;
	}
	
	public int returnRandomNumber(int num) {
		
		Random random = new Random();
		return random.nextInt(num);
		//return 0;
		
	}
}
