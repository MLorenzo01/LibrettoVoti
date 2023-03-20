package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import it.polito.tdp.libretto.db.VotoDAO;

public class Libretto {
	private List<Voto> voti;

	
	public Libretto() {
		VotoDAO dao = new VotoDAO();
		this.voti = dao.listVoti();
	}
	/**
	 * Aggiungi un nuovo voto al libretto
	 * (per ora non fa nessun controllo)
	 * @param v il voto da aggiungere
	 * @return true
	 */
	public boolean add(Voto v) {
		if(esisteVotoConflitto(v) || esisteVotoDuplicato(v)) {
			throw new IllegalArgumentException("Voto errato: " + v);
		}
		VotoDAO dao = new VotoDAO();
		dao.createVoto(v);
		return voti.add(v);
		
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
	
	public String toString() {
		String txt = "";
		for(Voto v: this.voti) {
			txt = txt +v.toString()+ "\n";
		}
		return txt;
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
	public boolean esisteVotoDuplicato(Voto nuovo) {
		for(Voto v: this.voti) {

			if(v.isDuplicato(nuovo))
				return true;
		}
		return false;
	}
	
	public boolean esisteVotoConflitto(Voto nuovo) {
		for(Voto v: this.voti) {

			if(v.isConflitto(nuovo))
				return true;
		}
		return false;
	}
	
	
	
	/**
	 * Metodo 'factory' per creare un nuovo libretto con i voti migliorati.
	 * @return 
	 */
	public Libretto librettoMigliorato() {
		Libretto migliore = new Libretto();
		migliore.voti = new ArrayList<>();
		for(Voto v: this.voti) {
			migliore.voti.add(v.clone());
			//migliore.voti.add(new Voto(v));
		}
		for(Voto v: migliore.voti) {
			v.setPunti(v.getPunti()+2);
		}
		return migliore;
	}
	/*public void cancellaVotiInferiori(int punti) {
		for(Voto v: this.voti) {				// non è consigliato, perchè quando ne cancello 1
			if(v.getPunti() < punti) {			// gli altri si spostano di una posizione e salta quello dopo
				this.voti.remove(v);
			}
		}
		/*for(int i=0; i<this.voti.size(); i++) {      //non si modifica la lista su cui
			if(this.voti.get(i).getPunti()<punti) {	   // si sta iterando MAI
				this.voti.remove(i);
			}
		}*/
	public void cancellaVotiInferiori(int punti) {
		List<Voto> daCanc = new ArrayList<Voto>();
		for(Voto k: voti) {
			if(k.getPunti() < punti) {
				daCanc.add(k);
			}
		}
		for(Voto v: daCanc) {
			voti.remove(v);
		}
	}

	
	public Libretto librettoOrdinatoAlfabeticamente() {
		Libretto ordinato = new Libretto();
		ordinato.voti = new ArrayList<>(this.voti);
		ordinato.voti.sort(new ComparatorByName());
		//Collections.sort(ordinato.voti, new ComparatorByName());
		return ordinato;
	}
	public Libretto librettoOrdinatoPerVoto() {
		Libretto ordinato = new Libretto();
		ordinato.voti = new ArrayList<>(this.voti);
		
		ordinato.voti.sort(new Comparator<Voto>() {

			@Override
			public int compare(Voto o1, Voto o2) {
				return o2.getPunti()-o1.getPunti();
			}});
		
		return ordinato;
	}
}
