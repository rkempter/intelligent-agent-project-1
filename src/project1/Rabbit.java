package project1;

public class Rabbit {
	
	private int x;
	private int y;
	private int energy;
	private World worldSpace;
	
	public void setPosition(int _x,int _y){
		x = _x;
		y = _y;
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

}
