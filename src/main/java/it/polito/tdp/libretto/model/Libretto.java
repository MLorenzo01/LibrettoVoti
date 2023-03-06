package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	private List<Voto> voti;

	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	/**
	 * Aggiungi un nuovo voto al libretto
	 * (per ora non fa nessun controllo)
	 * @param v il voto da aggiungere
	 * @return true
	 */
	public boolean add(Voto v) {
		return voti.add(v); //delega cieca, senza controlli
		
	}
	/*public void add(String corso, int punti, LocalDate data) {
		
	}*/ // non è consigliato, perché se un giorno vorrei salvare le volte che provo un esame, 
	   // dovrei cambiare anche questa classe, mentre con l'altro modifico solo la classe voto
	  //  devo evitare di avere delle dipendenze, almeno faccio meno modifiche possibili
	
	public void stampa() {
		for(Voto v: this.voti) {
			System.out.println(v);
		}
	}
	public List<Voto> getVoti(){
		return this.voti;
	}
	public void stampaPuntiUguali(int valore) {
		for(Voto v: this.voti) {
			if(v.getPunti() == valore)
				System.out.println(v);
		}
	}
	public Voto CercaVotoPerNome(String corso) {
		for(Voto v: this.voti) {
			//if(v.getCorso().compareTo(corso) == 0) {
			if(v.getCorso().equals(corso)) {
				return v;
			}
		}
		return null;
		
		//throw new RuntimeException("Voto non trovato");
		// non conviene usare l'eccezione per un valore non trovato ma conviene usarla per cose più importanti
	}
	public boolean esisteVoto(Voto nuovo) {
		for(Voto v: this.voti) {
			//if(v.equalsCorsoPunti(nuovo)) si crea un metodo nell'altra classe solo nel caso in cui io uso questo 
			//if in almeno 2 parti (refattorizzazione se faccio questa cosa in un secondo momento)
			
			if(v.getCorso().equals(nuovo.getCorso()) && v.getPunti() == nuovo.getPunti())
			{
				return true;
			}
		}
		return false;
	}
	

}
