import java.io.*; 
import java.util.*; 
import java.lang.Integer;

public class State{
	private Point pos;
	private Velocity vel;
	private ArrayList <State> nextStates;
	private State parent;
	private int distance=Integer.MAX_VALUE;

	public State(Point p, Velocity v){
		this.pos=p;
		this.vel=v;
		nextStates=new ArrayList<State>();
	}

	public Point getPos(){
		return pos;
	}

	public Velocity getVel(){
		return vel;
	}

	public State getParent(){
		return parent;
	}

	public int getDistance(){
		return distance;
	}

	public void setDistance(int d){
		distance=d;
	}

	public void setPos(Point p){
		this.pos=p;
	}

	public void setVel(Velocity v){
		this.vel=v;
	}

	public ArrayList<State> getNextStates(){
		return nextStates;
	}

	public void addNextState(State s){
		nextStates.add(s);
	}

	// public boolean isVisited(){
	// 	return visited;
	// }


	// public void setVisited(boolean v){
	// 	visited=v;
	// }

	public void setParent(State s){
		this.parent=s;
	}

	public boolean equals(State s){
		if (this.pos.equals(s.getPos()))
			if(this.vel.equals(s.getVel()))
				return true;

		return false;
	}

	public void print(){
		System.out.println("*");
		this.pos.print();
		this.vel.print();
		//System.out.println("visited: " + (this.visited?"true":"false"));
		System.out.println("distance: " + this.distance);
		System.out.print(Integer.toString(nextStates.size()));
		System.out.println("next states:");
		for(State s:nextStates)
			s.print();
		System.out.println("/*");
	}
	
}