package project1;

import uchicago.src.sim.engine.Schedule;
import uchicago.src.sim.engine.SimInit;
import uchicago.src.sim.engine.SimModelImpl;
import uchicago.src.sim.gui.DisplaySurface;
import uchicago.src.sim.gui.ColorMap;
import uchicago.src.sim.gui.Value2DDisplay;

public class Model extends SimModelImpl{
	private Schedule schedule;
	
	private World worldSpace;
	private DisplaySurface displaySurf;
	
	
	// Default Values
	private static final int NUMRABBITS = 20;
	private static final int WORLDXSIZE = 20;
	private static final int WORLDYSIZE = 20;
	private static final int REPRODUCTIONCOST = 5;
	private static final int INITIALGRASS;
	
	private int numRabbits = NUMRABBITS;
	private int worldXSize = WORLDXSIZE;
	private int worldYSize = WORLDYSIZE;
	private int reproductionCost = REPRODUCTIONCOST;
	private int initialGrass = INITIALGRASS;

	public String getName(){
		return "Rabbits Simulation";
	}

	public void setup(){
		System.out.println("Setup of System");
		worldSpace = null;

	    if (displaySurf != null){
	      displaySurf.dispose();
	    }
	    displaySurf = null;

	    displaySurf = new DisplaySurface(this, "Rabbit World Window 1");

	    registerDisplaySurface("Rabbit World Window 1", displaySurf);
	}

	public void begin(){
		buildModel();
	    buildSchedule();
	    buildDisplay();
	}

	public void buildModel(){
	}

	public void buildSchedule(){
	
	}

	public void buildDisplay(){
		System.out.println("Running BuildDisplay");
		
		ColorMap map = new ColorMap();
		
		for(int i = 0; i < 16; i++) {
			map.mapColor(i, new Color((int)(i*8 + 127), 0, 0));
		}
		map.mapColor(0, Color.white);
		
		Value2DDisplay displayGrass = new Value2DDisplay(worldSpace.getCurrentGrassSpace(), map);

		displaySurf.addDisplayable(displayGrass, "Grass");
		
	}

	public Schedule getSchedule(){
	    return schedule;
	}

	public String[] getInitParam(){
	    String[] initParams = { "NumRabbits", "WorldXSize", "WorldYSize", "ReproductionCost" };
	    return initParams;
	}

	public int getNumRabbits(){
	    return numRabbits;
	}

	public void setNumRabbits(int na){
	    numRabbits = na;
	}
	
	public int getWorldXSize() {
		return worldXSize;
	}
	
	public void setWorldXSize(int x) {
		worldXSize = x;
	}
	
	public int getWorldYSize() {
		return worldYSize;
	}
	
	public void setWorldYSize(int y) {
		worldXSize = y;
	}
	
	public int getReproductionCost() {
		return reproductionCost;
	}
	
	public void setReproductionCost(int rc) {
		reproductionCost = rc;
	}

	public static void main(String[] args) {
		SimInit init = new SimInit();
		Model model = new Model();
		init.loadModel(model, null, false);
	}
	
	public void step() {
		// grass grow
		// each rabbit less energy
		// each rabbit move or eat, reproduce or die
	}

}
