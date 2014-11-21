package simulation;

public class Bedienung {
	public Simulation s;
	
	public Bedienung(Simulation simulation){
		this.s = simulation;
	}
	
	public void start(){
			if(s.servierenWS>0){
				//plane neues Servieren Ereignis
				return;
			}
			if(s.notierenWS>0){
				//plane neues Notieren Ereignis
				return;
			}
			if(s.kassierenWS>0){
				//plane neues Kassieren Ereignis
				return;
			}
		
	}
}
