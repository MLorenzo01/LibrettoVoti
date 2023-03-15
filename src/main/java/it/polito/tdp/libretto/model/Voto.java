package it.polito.tdp.libretto.model;
import java.time.LocalDate;

public class Voto {
	public Voto(String corso, int punti, LocalDate dataEsame) {
		this.corso = corso;
		this.punti = punti;
		this.dataEsame = dataEsame;
	}
	public String corso;
	private int punti; // da 18 a 31
	private LocalDate dataEsame;
	public String getCorso() {
		return corso;
	}
	public void setCorso(String corso) {
		this.corso = corso;
	}
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	public LocalDate getDataEsame() {
		return dataEsame;
	}
	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}
	public boolean isDuplicato(Voto altro){
		if(this.corso.equals(altro.getCorso()) && this.punti == altro.getPunti())
			return true;
	return false;
	
	}
	public boolean isConflitto(Voto altro){
		if(this.corso.equals(altro.getCorso()) && this.punti != altro.getPunti())
			return true;
	return false;
	}
	public Voto clone() {
		return new Voto(this.corso, this.punti, this.dataEsame);
	}
	@Override
	public String toString() {
		return corso + " (" + punti + " pt) il " + dataEsame;
	}
}
