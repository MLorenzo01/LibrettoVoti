package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto lib = new Libretto();
		
		lib.add(new Voto("Analisi 1", 29, LocalDate.of(2021, 2, 15)));
		lib.add(new Voto("Fisica 2", 21, LocalDate.of(2022, 6, 10)));
		lib.add(new Voto("Informatica", 25, LocalDate.of(2021, 6, 10)));
		
		System.out.println("Stampa generale \n");
		lib.stampa();
		System.out.println("\nStampa tutti i voti uguali a 25 \n");
		lib.stampaPuntiUguali(25);
		Voto v = lib.CercaVotoPerNome("Analisi 1");
		System.out.println("\nCerca voto per nome");
		System.out.println(v);
		
		Voto a1bis = new Voto("Analisi 1", 29, LocalDate.of(2025, 2, 15));
		Voto alter = new Voto("Analisi 1", 30, LocalDate.of(2025, 2, 15));
		
		System.out.println(a1bis + "è duplicato " + a1bis.isDuplicato(alter));
		System.out.println(alter + "è duplicato " + alter);
		
		try {
			lib.add(new Voto("Informatica", 25, LocalDate.of(2023, 7 ,10)));
		} catch(IllegalArgumentException e) {
			System.out.println("Errore nell'inserimento del voto");
			
		}
		Libretto migliore = lib.librettoMigliorato();
		System.out.println("Libretto migliorato");
		migliore.stampa();
		System.out.println("Libretto originario");


	}

}
