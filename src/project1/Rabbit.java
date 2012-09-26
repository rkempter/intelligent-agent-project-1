package project1;

public class Rabbit {
	
	private int x;
	private int y;
	private int energy;
	private World worldSpace;
	
	public Rabbit() {
		System.out.println("Create new rabbit");
	}
	
	public void setPosXY(int newX,int newY){
		x = newX;
		y = newY;
	}
	
	public int getPositionX() {
		return x;
	}
	
	public int getPositionY() {
		return y;
	}
	
	public void setWorld(World _worldSpace) {
		worldSpace = _worldSpace;
	}
	
	public void eatGrass() {
		energy += worldSpace.eatGrassAt(x,y);
	}
	
	public void moveRabbit() {
		
	}
	
	public void report() {
		System.out.println("Position x " + x +
				" and Position y " + y +
				" with " + energy + " energy.");
		
	}
	
	

}
