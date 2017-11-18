package bean;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class WonderLand extends JPanel {

	    private static final int GAP = 0;
	    private static final Color BG = Color.green;
	    private static final Dimension BTN_PREF_SIZE = new Dimension(120, 120);
	    private KeyLis listener;
	    
	    JLabel label1;
	    JLabel label2;
	    JLabel labelTimer;
	    JLabel gameStatus = new JLabel("",SwingConstants.CENTER);
	    JLabel kBananas,gameTimerLabel;
	  
	    Banana banana = new Banana();
	    Timer timer,timerGame;
	    GameControl game = new GameControl();
	    Monkey m = new Monkey();
	    
	    private final int SML_SIDE = game.getN();

	    JLabel[][] smallPanels = new JLabel[SML_SIDE][SML_SIDE];
	    JPanel mainPanel;
	    JPanel gameState = new JPanel();
	    
	    
	    int counter = banana.getTimer();
	    int gameCounter = game.getTimer();
	    
	    public WonderLand() {
			// TODO Auto-generated constructor stub
	        mainPanel = new JPanel(new GridLayout(SML_SIDE, SML_SIDE));
	        mainPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
	        mainPanel.setBackground(BG);
	        for (int i = 0; i < smallPanels.length; i++) {
	            for (int j = 0; j < smallPanels.length; j++) {
	                //smallPanels[i][j] = new JLabel(new GridLayout(SML_SIDE, SML_SIDE));
	            	smallPanels[i][j] = new JLabel();
	                smallPanels[i][j].setPreferredSize(BTN_PREF_SIZE);
	                smallPanels[i][j].setBackground(BG);
	                mainPanel.add(smallPanels[i][j]);
	            }
	        }	      
	        m.setPosX(3);
	        m.setPoY(4);
	        smallPanels[m.getPosX()][m.getPoY()].setIcon( m.getImageIconUsingURL());
	        setLayout(new BorderLayout());
	        add(mainPanel, BorderLayout.CENTER);
	        
	        JPanel infoPanel = new JPanel(new GridLayout(1,4));
	        kBananas = new JLabel("Bananas 0/"+game.getK());
	        infoPanel.add(kBananas, BorderLayout.WEST);
	        labelTimer = new JLabel("Banana time left:"+String.valueOf(banana.getTimer()));
	        infoPanel.add(labelTimer, BorderLayout.CENTER);
	        gameTimerLabel = new JLabel("Game Time Left:"+String.valueOf(game.getTimer()));
	        infoPanel.add(gameTimerLabel,BorderLayout.EAST);        
	        gameState.add(gameStatus, SwingConstants.CENTER);
	        add(gameState,BorderLayout.PAGE_START);
	        infoPanel.setSize(infoPanel.getPreferredSize());
	        add(infoPanel,BorderLayout.PAGE_END);
	        changeBananaPosition();
	        listener = new KeyLis();
	        this.setFocusable(true);
	        this.requestFocus();
	        this.addKeyListener(listener);
	        timerGame = new Timer();
	        timerGame.schedule(new GameTimer(),1000,1000);        
	    }
	    
	    private void changeBananaPosition() {
	    
	    	counter = banana.getTimer();
	    	smallPanels[banana.getPosX()][banana.getPosY()].setIcon(null);
	    	repaint();
			banana.setPosX(banana.returnRandomNumber(SML_SIDE));
			banana.setPosY(banana.returnRandomNumber(SML_SIDE));
			smallPanels[banana.getPosX()][banana.getPosY()].setIcon(banana.getBananaImageIconUsingURL());
			labelTimer.setText("Banana time left:"+String.valueOf(counter));
			timer = new Timer();
	        timer.scheduleAtFixedRate(new BananaTimer(), 1000, 1000);
	     
	    }
	    
	    private class BananaTimer extends TimerTask {
	    	
			@Override
			public void run() {
				
				// TODO Auto-generated method stub
				counter--;
				labelTimer.setText("Banana time left:"+String.valueOf(counter));
				if(counter <= 0) {
					timer.cancel();
					changeBananaPosition();
				}
			}
		}
	    private class GameTimer extends TimerTask {

			@Override
			public void run() {
				
				gameCounter--;
				gameTimerLabel.setText("Game Time Left:"+String.valueOf(gameCounter));
				if(gameCounter <=0) {
					
					timer.cancel();
					timerGame.cancel();
					removeKeyListener(listener);
					
					if(m.getK() == game.getK()) {
					
						gameStatus.setText("Game Over. You Win");
						System.out.println("Game Over. You win");
					
					} else {
						
						gameStatus.setText("Game Over. You Loose");
						System.out.println("Game Over. You Loose");
					}
				}
				
			}
		}
	    
	    private class KeyLis extends KeyAdapter {
	    	
	        @Override
	        public void keyPressed(KeyEvent e) {
	        	

	           repaint();
	           switch (e.getKeyCode()) {
	           	case KeyEvent.VK_LEFT:
	           		
	           		smallPanels[m.getPosX()][m.getPoY()].setIcon(null);
	           		m.keyLeftPressed();
	           		smallPanels[m.getPosX()][m.getPoY()].setIcon( m.getImageIconUsingURL());
		              break;
	           	case KeyEvent.VK_RIGHT:
		        	   
	           		smallPanels[m.getPosX()][m.getPoY()].setIcon(null);
	           		m.keyRightPressed(SML_SIDE);
	           		smallPanels[m.getPosX()][m.getPoY()].setIcon( m.getImageIconUsingURL());
		        	break;
	           case KeyEvent.VK_UP:
	        	   
	        	   smallPanels[m.getPosX()][m.getPoY()].setIcon(null);
	        	   m.KeyUpPressed();
	        	   smallPanels[m.getPosX()][m.getPoY()].setIcon( m.getImageIconUsingURL());
		              break;
		       case KeyEvent.VK_DOWN:
		    	   
		    	   smallPanels[m.getPosX()][m.getPoY()].setIcon(null);
		    	   m.keyDownPressed(SML_SIDE);
		    	   smallPanels[m.getPosX()][m.getPoY()].setIcon( m.getImageIconUsingURL());
		              break;
	           }
	           m.isAtDestination(mainPanel);
	           checkGameStatus();
	           
	        }	
	    }

	    private void checkGameStatus() {
			// TODO Auto-generated method stub
			if(banana.getPosX() == m.getPosX() && banana.getPosY() == m.getPoY()){

				m.setK(m.getK()+1);
				kBananas.setText("Bananas "+String.valueOf(m.getK())+"/"+game.getK());
				
				if(m.getK() == game.getK()) {
					
					timer.cancel();
					timerGame.cancel();
					gameStatus.setText("Game Over. You Win");
					removeKeyListener(listener);
					System.out.println("You win");
				} else {
					timer.cancel();
					changeBananaPosition();
					smallPanels[m.getPosX()][m.getPoY()].setIcon( m.getImageIconUsingURL());
				}
			}
		}

}
