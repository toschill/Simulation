package simulation;

import simulation.Event.EventTyp;

public class KassierenEvent extends Event{
	
	public KassierenEvent(Simulation simulation){
		this.s=simulation;
		int delta = s.generator.kassierenDauer();
		s.kassierZeit += delta;
		this.zeit=s.simZeit+delta;
		this.typ = EventTyp.startKassieren;
	}
	
	@Override
	public void start() {
		s.kassierenWS--;
		s.belegteTische--;
		this.planeEndeKassieren();
	}
}
