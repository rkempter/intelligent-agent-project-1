package project1;

import uchicago.src.sim.engine.Schedule;
import uchicago.src.sim.engine.SimInit;
import uchicago.src.sim.engine.SimModelImpl;

public class Model extends SimModelImpl{
	private Schedule schedule;
	
	private static final int NUMRABBITS = 20;
	private static final int WORLDXSIZE = 20;
	private static final int WORLDYSIZE = 20;
	
	private int numRabbits = NUMRABBITS;
	private int worldXSize = WORLDXSIZE;
	private int worldYSize = WORLDYSIZE;
	

	public String getName(){
		return "Rabbits Simulation";
	}

	public void setup(){
	
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
	}

	public Schedule getSchedule(){
	    return schedule;
	}

	public String[] getInitParam(){
	    String[] initParams = { "NumAgents" };
	    return initParams;
	}

	public int getNumRabbits(){
	    return numRabbits;
	}

	public void setNumRabbits(int na){
	    numRabbits = na;
	}

	public static void main(String[] args) {
		SimInit init = new SimInit();
		Model model = new Model();
		init.loadModel(model, null, false);
	}

}
