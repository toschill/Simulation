package simulation;

public abstract class Event implements Comparable<Event>{
	
	public EventTyp typ;
	public int zeit;
	public Simulation s;
	
	public abstract void start();
	

	public enum EventTyp{
		ankunftGast, startNotieren, startServieren, startKassieren, startKochen, startEssen
	}
	
	public void planeAnkunftGast(){
		Event ankunftGast = new neuerGastEvent(s);
		s.eventList.add(ankunftGast);
	}
	
	public void planeAnkunftNotieren(){
		Event startNotieren = new NotierenEvent(s);
		s.eventList.add(startNotieren);
	}
	
	public void planeAnkunftServieren(){
		Event servieren = new ServierenEvent(s);
		s.eventList.add(servieren);
	}
	
	public void planeAnkunftKassieren(){
		Event kassieren = new KassierenEvent(s);
		s.eventList.add(kassieren);
	}
	
	public void planeAnkunftEssen(){
		Event essen = new EssenEvent(s);
		s.eventList.add(essen);
	}
	public void planeAnkunftKochen(){
		Event kochen = new KochenEvent(s);
		s.eventList.add(kochen);
	}
	
	public void planeEndeGast(){
		planeAnkunftNotieren();
	}
	
	public void planeEndeNotieren(){
		planeAnkunftKochen();
	}
	
	public void planeEndeServieren(){
		planeAnkunftEssen();
	}
	
	public void planeEndeKassieren(){
		/*
		if(s.notierenWS>0){
			planeAnkunftNotieren();
			return;
		}
		if(s.servierenWS>0){
			planeAnkunftServieren();
			return;
		}
		if(s.kassierenWS>0){
			planeAnkunftKassieren();
			return;
		}
		else{
			System.out.println("Bedienung macht nichts");
		}*/
	}
	
	public void planeEndeKochen(){
		planeAnkunftServieren();
	}
	
	public void planeEndeEssen(){
		planeAnkunftKassieren();
	}
	
	@Override
	public int compareTo(Event o) {
		return this.zeit-o.zeit;
	}
	
}
