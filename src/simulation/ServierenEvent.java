package simulation;

import simulation.Event.EventTyp;

public class ServierenEvent extends Event{

	public ServierenEvent(Simulation simulation){
		this.s=simulation;
		int delta = s.generator.servierenDauer(); 
		s.servierZeit+=delta;
		this.zeit=s.simZeit+delta;
		this.typ = EventTyp.startServieren;
	}
	
	@Override
	public void start() {
		s.servierenWS--;
		this.planeEndeServieren();
	}

}
