package simulation;

public class NotierenEvent extends Event{

	
	public NotierenEvent(Simulation simulation) {
		this.s=simulation;
		int delta = s.generator.notierenDauer();
		s.notierZeit+=delta;
		this.zeit=s.simZeit+ delta;
		this.typ = EventTyp.startNotieren;
	}

	@Override
	public void start() {
		s.notierenWS--;
		this.planeEndeNotieren();
	}

}
