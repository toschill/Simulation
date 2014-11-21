package simulation;


public class neuerGastEvent extends Event{
	
	public neuerGastEvent(Simulation simulation) {
		this.s=simulation;
		this.zeit=s.simZeit+s.generator.neuerGastDauer();
		this.typ=EventTyp.ankunftGast;
	}

	@Override
	public void start() {
		//unabhängiges Ereignis
		if(s.simZeit<s.SIM_ENDE){
			this.planeAnkunftGast();
		}
				if(s.belegteTische<s.ANZAHL_TISCHE){
					s.bedienteKunden++;
					s.belegteTische++;
					s.notierenWS++;
					this.planeEndeGast();
				}
				else{
					s.verloreneKunden++;
				}
		
	}
	
	

}
