package KinoUI;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import FilmVerwaltung.Programm;

import java.util.Map.Entry;


public class EinkaufswagenView extends UI {

	private Controller controller;

	public EinkaufswagenView(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Zeigt die Artikel aus dem Einkaufswagen an. Die Liste der im Einkaufswagen
	 * befindlichen Artikel wird vom Controller erfragt
	 * 
	 * @param artikelliste
	 */
	public void anzeigenInhalt() {
		//TODO alle Artikel im Einkaufswagen an.
		//     Zeigt pro Artikel an: Kategorie, Bezeichnung, St�ckzahl, 
		//     Stueckpreis und den Gesamtpreis
	}
	
	/**
	 * Zeigt die als Parameter �bergebene Artikelliste analog zu "anzeigenInhalt()" an. 
	 * Das sind die Artikel aus dem Einkaufswagen. 
	 * Jeder Auflistung eines Artikels wird eine Nummer vorangestellt, �ber
	 * die eine sp�tere Auswahl zum Entnehmen aus dem Einkaufswagen erfolgen
	 * kann. Das Auswahlkriterium wird dem Benutzer angezeigt
	 * 
	 * @param artikelliste
	 */
	private void anzeigenZurAuswahl(Map<Programm, Integer> programmliste) {
		//TODO Implementierung
	}
	

	/**
	 * Solange der Einkaufswagen nicht leer ist und der Kunde noch Artikel
	 * zur�cklegen m�chte, werden Artikel einzeln aus dem Einkaufswagen genommen.
	 * Dabei wird auf die entsprechende Methode des Webshops zur�ckgegriffen
	 * 
	 * @param artikelliste
	 *            Liste der Artikel im Einkaufswagen realisiert als Map
	 */
	public void ausEinkaufswagenNehmen() {
		// TODO "ausEinkaufswagenNehmen" implementieren
	}

}
