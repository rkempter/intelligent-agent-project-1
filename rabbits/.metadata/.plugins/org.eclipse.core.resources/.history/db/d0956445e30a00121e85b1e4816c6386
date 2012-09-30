package project1;

import java.awt.Color;

import uchicago.src.sim.gui.SimGraphics;
import uchicago.src.sim.gui.Drawable;
import java.util.Random;


public class Rabbit implements Drawable{
	
	private int x;
	private int y;
	private int energy;
	private static int maxInitialEnergy= 10;
	private static int minInitialEnergy= 5;

	private World worldSpace;
	
	public Rabbit() {
		energy = minInitialEnergy + (int)(Math.random()*maxInitialEnergy);
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
	
	public void draw(SimGraphics G){
		G.drawFastRoundRect(Color.blue);
	}
	
	/**
	 * Moves a rabbit from x, y to newX, newY, which is in a distance of 1 from the old cell.
	 */
	public void moveRabbit() {
		int directions[]= {-1,0,1};
		int vx = 0;
		int vy = 0;
		
		// Generate the direction in which the rabbit moves.
		Random rand = new Random();
		vx= directions[rand.nextInt( directions.length)];		
		if (vx != 0) {
			vy = 0;
		} else {
			vy = directions[rand.nextInt( directions.length)];
		}
		
		int newX = worldSpace.checkBoundryX(x+vx);
		int newY = worldSpace.checkBoundryY(y+vy);
		
		if(!worldSpace.checkIfRabbitOn(newX, newY)) {
			worldSpace.removeRabbitAt(x, y);
			x = newX;
			y = newY;
			worldSpace.placeRabbitIn(this);
		}
		consumeEnergy();
	}
	public void consumeEnergy(){
		energy-= 1;
	}
	
	public int getEnergy(){
		return energy;
	}
	
	public void setEnergy(int en) {
		energy = en;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	/**
	 * Debugging report method
	 */
	public void report() {
		System.out.println("Position x " + x +
				" and Position y " + y +
				" with " + energy + " energy.");
	}
}
