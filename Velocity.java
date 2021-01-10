public class Velocity{
	private int vel_x;
	private int vel_y;

	public Velocity(int _x,int _y){
		this.vel_x=_x;
		this.vel_y=_y;
	}

	public int getX(){
		return vel_x;
	}
	public int getY(){
		return vel_y;
	}

	public void setX(int _x){
		this.vel_x=_x;
	}
	public void setY(int _y){
		this.vel_y=_y;
	}

	public void print(){
		System.out.println("x: "+ Integer.toString(vel_x) + " y: " + Integer.toString(vel_y) );
	}

	public boolean equals(Velocity v){
		return this.vel_x==v.getX() && this.vel_y==v.getY();
	}
	
}