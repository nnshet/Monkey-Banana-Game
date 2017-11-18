package states;

import bean.Monkey;

public class IdleMonkey extends State{

	@Override
	public State keyPressLeft(Monkey m) {
		// TODO Auto-generated method stub
		int y = m.getPoY();
		if(y > 0) {

	        m.setPoY(y-1);
        }
		return new MovingMonkey();
	}

	@Override
	public State keyDownPressed(Monkey m,int smallSide) {
		// TODO Auto-generated method stub
		int x = m.getPosX(); 
		if(x != smallSide-1){
		   m.setPosX(x+1);
		}
		return new MovingMonkey();
	}

	@Override
	public State keyUpPressed(Monkey m) {
		// TODO Auto-generated method stub
		int x = m.getPosX() ;
		  if(x > 0){
   		   
			  m.setPosX(x-1);
   	   }
   	  
		return new MovingMonkey();
	}

	@Override
	public State keyRightPressed(Monkey m,int smallSide) {
		// TODO Auto-generated method stub
		int y = m.getPoY();
		if(y != smallSide-1){
  		   
			 m.setPoY(y+1);
  	   }
  	  
		return new MovingMonkey();
	}
}

