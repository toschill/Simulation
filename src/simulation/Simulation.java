package simulation;

import java.util.PriorityQueue;

import simulation.Event.EventTyp;

public class Simulation {
	
	private static Simulation instanz = new Simulation();
	
	final int ANZAHL_TISCHE=7;
	final int SIM_ENDE=600;
	public int verloreneKunden=0;
	public int bedienteKunden=0;
	public int kochZeit=0;
	public int notierZeit=0;
	public int servierZeit=0;
	public int kassierZeit=0;
	
	public int belegteTische=0;
	public int simZeit=0;
	//Warteschlangen
	public int notierenWS=0;
	public int servierenWS=0;
	public int kassierenWS=0;
	
	
	public Generator generator = new Generator();
	public PriorityQueue<Event> eventList = new PriorityQueue<Event>(20);
	
	private Simulation(){
		
	}
	
	public static Simulation getInstance(){
		return instanz;
	}
	public void start(){
		//Anstarten der Simulation
		eventList.add(new neuerGastEvent(this));
		
		while(simZeit<SIM_ENDE||belegteTische>0){
			Event aktuell = eventList.poll();
			simZeit=aktuell.zeit;
			aktuell.start();
			this.ausgabe(aktuell.typ);
		}
		
		ausgabeStatistik();
	}
	
	public void ausgabeStatistik(){
		System.out.println();
		System.out.println("--------------------------");
		System.out.println("ServierZeit: "+servierZeit);
		System.out.println("NotierZeit: "+ notierZeit);
		System.out.println("KassierZeit: "+kassierZeit);
		System.out.println("KochZeit: "+kochZeit);
		System.out.println("verlorene Kunden: "+verloreneKunden);
		System.out.println("bediente Kunden: "+bedienteKunden);
	}
	
	public void ausgabe(EventTyp event){
	
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("Event: "+event);
		System.out.println("Simulationszeit: "+simZeit);
		System.out.println("Belegte Tische: "+belegteTische);
		System.out.println("Notieren Warteschlagen: "+notierenWS);
		System.out.println("Servieren Warteschlagen: "+servierenWS);
		System.out.println("Kassieren Warteschlagen: "+kassierenWS);

		
		
		System.out.println();
		System.out.println("-------------------------");
		for(Event e : eventList){
			System.out.print(e.typ);
			System.out.print(":");
			System.out.print(e.zeit);
			System.out.print("|");
		}
	}
}
