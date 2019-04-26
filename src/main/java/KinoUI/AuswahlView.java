package KinoUI;

import java.util.ArrayList;
import java.util.List;

import FilmVerwaltung.Programm;

public class AuswahlView extends UI {

	/**
	 * Zeigt die als Parameter �bergebene Artikelliste an
	 * Jedem Artikel wird eine Nummer vorangestellt, �ber die
	 * die sp�tere Auswahl erfolgen kann. Das Auswahlkriterium wird
	 * dem Benutzer angezeigt
	 * @param artikelliste
	 */
	private void anzeigeProgrammListe(List<Programm> programmliste) {
		// TODO Artikelliste sortiert nach Kategorie anzeigen.
	}

	/**
	 * Zeigt die �bergebene Artikelliste an und w�hlt Artikel �ber die
	 * Eingabe der vorangestellten Nummer aus. F�ngt ung�ltige Eingaben ab.
	 * Die ausgew�hlten Artikel werden einer neuen Liste hinzugef�gt, die 
	 * am Ende zur�ckgegeben wird
	 * 
	 * @param artikelliste Liste, die als Basis zur Auswahl dient
	 * @return ausgew�hlte Artikel
	 */
	public List<Programm> auswaehlenProgramm(List<Programm> programmliste) {
		// TODO Auswahl der Artikel implementieren
		return null;
	}
}
