package Fachlogik;

import java.util.SortedMap;
import java.util.TreeMap;

import FilmVerwaltung.Programm;


public class Einkaufswagen {

private SortedMap<Programm, Integer> programmliste = new TreeMap<Programm, Integer>();
	
	/**
	 * F�gt dem Einkaufswagen einen Artikel hinzu. Gibt es diesen Artikel
	 * bereits im Einkaufswagen, wird die Anzahl seines Vorkommens um 1 erh�ht,
	 * ansonsten wird er der Liste der Artikel mit Anzahl 1 hinzugef�gt
	 *  
	 * @param artikel
	 */
	public void einfuegen(Programm programm) {
		if (programmliste.containsKey(programm)) {
			Integer value = programmliste.get(programm);
			programmliste.put(programm, value + 1);
		} else
			programmliste.put(programm, 1);
	}
	
	/**
	 * L�scht einen Artikel aus dem Einkaufswagen. Ist dessen Anzahl > 1,
	 * wird die Anzahl um eins verringert. Ansonsten wird der zugeh�rige Eintrag 
	 * aus der artikelliste gel�scht.
	 *   
	 * @param programm
	 * @return true, wenn Artikel in Einkaufswagen vorhanden, false sonst
	 */
	public boolean loeschen(Programm programm) {
		boolean OK = true;
		if (programmliste.containsKey(programm)) {
			Integer value = programmliste.get(programm);
			if (value > 1)
				programmliste.put(programm, value - 1);
			else
				programmliste.remove(programm);
		} else
			OK = false;
		return OK;
	}
	
	/**
	 * L�scht alle Artikel aus dem Einkaufswagen
	 */
	public void allesLoeschen() {
		programmliste = new TreeMap<Programm, Integer>();
	}	
	
	/**
	 * @return Gibt eine Kopie der Artikel im Einkaufswagen zur�ck (Kapselung)
	 */
	public SortedMap<Programm, Integer> getInhalt() {
		return (SortedMap<Programm, Integer>)((TreeMap<Programm, Integer>)programmliste).clone();
	}
	
	/**
	 * @return true, wenn keine Artikel im Einkaufswagen, false sonst
	 */
	public boolean istLeer() {
		return programmliste.isEmpty();
	}

}

