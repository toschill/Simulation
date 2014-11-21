package simulation;

import simulation.Event.EventTyp;

public class EssenEvent extends Event {
	
	public EssenEvent(Simulation simulation) {
		this.s=simulation;
		this.zeit=s.simZeit+s.generator.essenDauer();
		this.typ = EventTyp.startEssen;
	}

	@Override
	public void start() {
		s.kassierenWS++;
		this.planeEndeEssen();
	}

}
