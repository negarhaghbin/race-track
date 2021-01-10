import java.io.*; 
import java.util.*; 

public class TrackField{
	private static final int GRID_SIZE = 25;
	private ArrayList < ArrayList <Cell> > field= new ArrayList < ArrayList <Cell> > ();
	private ArrayList <Point> startingPoints= new ArrayList <Point>(); 
	private ArrayList <Point> finishingPoints= new ArrayList <Point>(); 

	public TrackField(String filename){
		try{
			//System.out.println("opening file");
			File file = new File(filename); 
    		Scanner sc = new Scanner(file);
    		int spCount=sc.nextInt();
    		int fpCount=sc.nextInt();
    		for (int i=0;i<spCount;i++){
    			int pointx=sc.nextInt();
    			int pointy=sc.nextInt();
    			startingPoints.add(new Point(pointx,pointy));
    		}
    		for (int i=0;i<fpCount;i++){
    			int pointx=sc.nextInt();
    			int pointy=sc.nextInt();
    			finishingPoints.add(new Point(pointx,pointy));
    		}
    		for (int j=0;j<GRID_SIZE;j++) {
    			ArrayList <Cell> row=new ArrayList<Cell>();
    			for (int i=0;i<GRID_SIZE;i++){
    				row.add(sc.nextInt()==1?new Cell(true):new Cell(false));
    			}
    			field.add(row);
    		}
    		//System.out.println("closing file");
		}
		catch (FileNotFoundException e){
			System.out.println("File not found");
		}
	}

	public ArrayList < ArrayList <Cell> > getField(){
		return field;
	}

	public boolean isInPath(Point p){
		if(p.getX()>0 && p.getY()>0 && 26>p.getX() && 26>p.getY())
			return (field.get(GRID_SIZE-p.getY()).get(p.getX()-1).getValue())==false;
		return false;
	}

	public boolean isInPath(int i, int j){
		if(i>-1 && j>-1 && 25>i && 25>j)
			return (field.get(i).get(j).getValue())==false;
		return false;
	}

	public Cell getCell(Point p){
		return field.get(GRID_SIZE-p.getY()).get(p.getX()-1);
	}

	public Cell getCell(int i, int j){
		return field.get(i).get(j);
	}

	public ArrayList<Point> getStartingPoints(){
		return startingPoints;
	}

	public boolean isFinishingPoint(Point p){
		for(Point a:finishingPoints){
			if (a.equals(p))
				return true;
		}
		return false;
	}

	public boolean isStartingPoint(Point p){
		for(Point a:startingPoints){
			if (a.equals(p))
				return true;
		}
		return false;
	}

	public void print(){
		System.out.println("Starting Points: ");
		for(Point p:startingPoints)
			p.print();

		System.out.println("Finishing Points: ");
		for(Point p:finishingPoints)
			p.print();

		for(ArrayList<Cell> a:field){
			for (Cell c:a){
				System.out.print(c.getValue()?1:0);
			}
			System.out.println();
		}

		for(ArrayList<Cell> a:field){
			for (Cell c:a){
				System.out.print(c.getStates().size());
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}