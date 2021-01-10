import java.io.*; 
import java.util.*;

public class Cell{
	private boolean value;
	private ArrayList <State> states;

	public Cell(boolean v){
		value=v;
		states=new ArrayList<State>();
	}

	public boolean getValue(){
		return value;
	}

	public ArrayList<State> getStates(){
		return states;
	}

	public State getState(State s){
		for(State state: states){
			if(state.equals(s)){
				return state;
			}
		}
		return null;
	}

	public void addState(State s){
		this.states.add(s);
	}

	public boolean hasState(State s){
		for(State state: states){
			if(state.equals(s)){
				return true;
			}
		}
		return false;
	}
	

}