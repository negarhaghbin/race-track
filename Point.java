public class Point{
	private int x;
	private int y;

	public Point(int _x,int _y){
		this.x=_x;
		this.y=_y;
		// this.isOnTheTrack=t;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	// public boolean getIsOnTheTrack(){
	// 	return isOnTheTrack;
	// }

	public void setX(int _x){
		this.x=_x;
	}
	public void setY(int _y){
		this.y=_y;
	}

	public boolean equals(Point p){
		return this.x==p.getX() && this.y==p.getY();
	}

	public void print(){
		System.out.println("x: "+ Integer.toString(x) + " y: " + Integer.toString(y) );
	}
}