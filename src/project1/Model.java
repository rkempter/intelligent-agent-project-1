package project1;

import java.awt.Color;
import java.util.ArrayList;

import carryDrop.CarryDropAgent;

import uchicago.src.sim.engine.BasicAction;
import uchicago.src.sim.engine.Schedule;
import uchicago.src.sim.engine.SimInit;
import uchicago.src.sim.engine.SimModelImpl;
import uchicago.src.sim.gui.DisplaySurface;
import uchicago.src.sim.gui.ColorMap;
import uchicago.src.sim.gui.Value2DDisplay;
import uchicago.src.sim.util.SimUtilities;

public class Model extends SimModelImpl{

	private Schedule schedule;

	private World worldSpace;
	private DisplaySurface displaySurf;
	private ArrayList<Rabbit> rabbitList;


	// Default Values
	private static final int NUMRABBITS = 20;
	private static final int WORLDXSIZE = 20;
	private static final int WORLDYSIZE = 20;
	private static final int REPRODUCTIONCOST = 5;
	private static final int INITIALGRASS = 5;

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
		rabbitList = new ArrayList<Rabbit>();

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

		displaySurf.display();
	}

	public void buildModel(){
		System.out.println("Running BuildModel");
		worldSpace = new World(worldXSize, worldYSize);

		for(int i = 0; i < numRabbits; i++) {
			addNewRabbit();
		}
	}

	public void buildSchedule(){
		System.out.println("Running BuildSchedule");


		class worldStep extends BasicAction {
			public void execute() {
				SimUtilities.shuffle(rabbitList);
				for(int i =0; i < rabbitList.size(); i++){
					Rabbit rabbit = (Rabbit)rabbitList.get(i);
					rabbit.moveRabbit();
				}
				//call function to make the rabbit reproducing
			}
		}

		schedule.scheduleActionBeginning(0, new worldStep());

		class LivingRabbit extends BasicAction {
			public void execute(){
				livingRabbits();
			}
		}

		schedule.scheduleActionAtInterval(10, new LivingRabbit());
	}
	
	private int livingRabbits(){
		int livingRabbits = 0;
		for(int i = 0; i < rabbitList.size(); i++){
			Rabbit rabbit = (Rabbit)rabbitList.get(i);
			if(rabbit.getEnergy() > 0) livingRabbits++;
		}
		System.out.println("Number of living agents is: " + livingRabbits);

		return livingRabbits;
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
		System.out.println("Init parameters");
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

	public void addNewRabbit() {
		Rabbit r = new Rabbit();
		rabbitList.add(r);
		worldSpace.placeRabbit(r);
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
