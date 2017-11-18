package states;

import bean.Monkey;

public class MovingMonkey extends State{

	@Override
	public State checkIdleState(Monkey monkey){
		
	
		return new IdleMonkey();
	}
}
