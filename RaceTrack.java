import java.io.*; 
import java.util.*; 
import java.lang.Integer;

public class RaceTrack{
	private static final int GRID_SIZE = 25;
	private static final int VELOCITY_LIMIT = 8;
	public static ArrayList <State> states=new ArrayList <State>();
	public static TrackField tf;
	
	public static void main(String[] args) {		
		RaceTrack.tf=new TrackField("dataset_assignment3/7.txt");
		creatStates();
		int minPath=Integer.MAX_VALUE;
		State minPathState=null;
		for(Point p:RaceTrack.tf.getStartingPoints()){
			State state= RaceTrack.tf.getCell(p).getStates().get(0);
			state.setDistance(0);
			State temp=dijkstra(state);
			if(temp!=null){
				if(temp.getDistance()<minPath){
					minPath=temp.getDistance();
					minPathState=temp;
				}
			}
		}
		System.out.println(minPath);
		printPath(minPathState);
		
	}

	public static void printPath(State s){
		if(s.getParent().getPos().equals(s.getPos())){
			s.getPos().print();
			return;
		}
		s.getPos().print();
		printPath(s.getParent());
	}

	public static void creatStates(){
		for(Point p:RaceTrack.tf.getStartingPoints()){
			State state=new State(p,new Velocity(0,0));
			state.setParent(state);
			bfs(state);
		}
	}

	public static void bfs(State s){
		Queue <State> q= new LinkedList<State>();
		RaceTrack.tf.getCell(s.getPos()).addState(s);
		q.add(s);
		while(q.peek()!=null){
			State u= q.remove();
			creatChildren(u);
			for(State state:RaceTrack.tf.getCell(u.getPos()).getState(u).getNextStates()){
				if (!RaceTrack.tf.getCell(state.getPos()).hasState(state)){
					RaceTrack.tf.getCell(state.getPos()).addState(state);
					q.add(state);
				}
			}
		}
	}

	public static void creatChildren(State state){
		if (RaceTrack.tf.isFinishingPoint(state.getPos()))
			return;
		for (int v_x=state.getVel().getX()-1;v_x<state.getVel().getX()+2;v_x++ ) {
			for (int v_y=state.getVel().getY()-1;v_y<state.getVel().getY()+2;v_y++ ) {
				Point temp=new Point(state.getPos().getX()+v_x,state.getPos().getY()+v_y);
				if(RaceTrack.tf.isStartingPoint(temp))
					continue;
				State s=new State(temp,new Velocity(v_x,v_y));
				if (RaceTrack.tf.isInPath(temp) && !RaceTrack.tf.getCell(s.getPos()).hasState(s) && !state.getPos().equals(s.getPos())){
					s.setParent(state);
					RaceTrack.tf.getCell(state.getPos()).getState(state).addNextState(s);
				}
			}
		}
	}

	public static State extractMin(Set<State> unsettledNodes){
		int minDistance=Integer.MAX_VALUE;
		State minDistanceNode=null;
		for(State s:unsettledNodes){
			if(s.getDistance()<=minDistance){
				minDistance=s.getDistance();
				minDistanceNode=s;
			}
		}

		return minDistanceNode;
	}

	public static State dijkstra(State state){
		Set<State> settledNodes = new HashSet<>();
    	Set<State> unsettledNodes = new HashSet<>();
    	int minPath=Integer.MAX_VALUE;
    	State minNode=null;
    	state.setParent(state);
    	unsettledNodes.add(state);

		while(unsettledNodes.size() != 0){
			State currentNode = extractMin(unsettledNodes);

			if(RaceTrack.tf.isFinishingPoint(currentNode.getPos())){
				if(minPath>currentNode.getDistance()){
					minPath=currentNode.getDistance();
					minNode=currentNode;
				}
			}

        	unsettledNodes.remove(currentNode);

        	for (State s: currentNode.getNextStates()) {
	            if (!settledNodes.contains(s)) {
	                if(s.getDistance()>currentNode.getDistance()+1){
						s.setDistance(currentNode.getDistance()+1);
					}
					s.setParent(currentNode);
	                unsettledNodes.add(s);
            	}
        	}
        	settledNodes.add(currentNode);

		}

		return minNode;
	}

}