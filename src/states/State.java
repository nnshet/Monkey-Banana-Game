package states;

import bean.Monkey;

public abstract class State {

	
	public State keyPressLeft(Monkey m) {
		// TODO Auto-generated method stub
		return this;
	}

	public State keyDownPressed(Monkey m, int smallSide) {
		// TODO Auto-generated method stub
		return this;
	}

	public State keyUpPressed(Monkey m) {
		// TODO Auto-generated method stub
		return this;
	}

	public State keyRightPressed(Monkey m,int smallSide) {
		// TODO Auto-generated method stub
		return this;
	}

	

	public State checkIdleState(Monkey monkey) {
		// TODO Auto-generated method stub
		return this;
	}

}
