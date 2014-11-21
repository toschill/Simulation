package simulation;

import simulation.Event.EventTyp;

public class KochenEvent extends Event{
	
	public KochenEvent(Simulation simulation) {
		this.s=simulation;
		int delta = s.generator.zubereitungsDauer();
		s.kochZeit += delta;
		this.zeit=s.simZeit+ delta;
		this.typ = EventTyp.startKochen;
	}

	@Override
	public void start() {
		s.servierenWS++;
		this.planeAnkunftServieren();
	}

}
