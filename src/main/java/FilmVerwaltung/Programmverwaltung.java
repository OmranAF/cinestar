package FilmVerwaltung;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import DatenHaltung.IProgrammDAO;

public class Programmverwaltung {
	
		/**
		 * Attribut, in dem die vorhandenen Artikel abgelegt sind Da die Artikel
		 * sortierbar sein sollen, wurde SortedSet gew�hlt
		 */
		private SortedSet<Programm> programmListe;

		/**
		 * Attribut, in dem das DAO-Objekt f�r die Artikel gespeichert wird. �ber
		 * dieses Objekt wird aus Datei, DB o.�. geladen.
		 */
		private IProgrammDAO dao;

		public Programmverwaltung(IProgrammDAO dao) {
			programmListe = new TreeSet<Programm>();
			this.dao = dao;
		}

		/**
		 * L�dt die Artikeldaten aus dem Persistenzmedium und legt sie in
		 * artikelListe ab. Vorher werden alle noch in der artikelListe vorhandenen
		 * Artikel gel�scht.
		 * 
		 * @throws IOException
		 * @throws ArtikelBereitsVorhandenException
		 */
		public void laden() throws IOException, ProgrammBereitsVorhandenException {
			programmListe.clear();
			try {
				List<Programm> liste = dao.laden();
				for (Programm a : liste)
					this.addProgramm(a);

			} catch (ProgrammBereitsVorhandenException ex) {
				throw new ProgrammBereitsVorhandenException(
						"Fehler beim Laden der Artikeldaten. Es gibt zwei Artikel mit derselben ID!");
			}
		}

		/**
		 * Speichert den Inhalt der Liste durch Aufruf der entsprechenden Funktion
		 * auf dem DAO-Objekt
		 * 
		 * @throws IOException
		 */
		public void speichern() throws IOException {
			List<Programm> liste = new ArrayList<Programm>();
			for (Programm a : programmListe)
				liste.add(a);
			dao.speichern(liste);
		}

		public boolean istLeer() {
			return programmListe.isEmpty();
		}

		/**
		 * Gibt die in artikelliste gespeicherten Artikel in einer neuen Liste
		 * zur�ck
		 * 
		 * @return Referenz auf neue Liste mit Artikeln
		 */
		public List<Programm> getArtikelliste() {
			ArrayList<Programm> programmLi = new ArrayList<Programm>();
			for (Programm programm : programmListe) {
				programmLi.add(programm);
			}
			return programmLi;
		}

		/**
		 * Gibt die in artikelliste gespeicherten Artikel in einer neuen Liste
		 * zur�ck, die zur �bergebenen Kategorie geh�ren
		 * 
		 * @return Referenz auf neue Liste mit zur Kategorie geh�renden Artikeln
		 */
		public List<Programm> getProgrammliste(Kategorie kategorie) {
			ArrayList<Programm> programmLi = new ArrayList<Programm>();
			for (Programm programm : programmListe) {
				if (programm.getKategorie().equals(kategorie))
					programmLi.add(programm);
			}
			return programmLi;
		}
		
		public List<Programm> getProgrammliste() {
			ArrayList<Programm> programmLi = new ArrayList<Programm>();
			for (Programm programm : programmListe) {
				programmLi.add(programm);
			}
			return programmLi;
		}

		/**
		 * In Version 3.0 Schnittstelle ge�ndert: statt R�ckgabewert boolean jetzt
		 * Exception
		 * 
		 * F�gt den als Parameter �bergebenen Artikel der Menge der Artikel hinzu.
		 * Einf�gen wird nur vorgenommen, wenn es noch keinen �ber compareTo
		 * gleichen Artikel in artikelListe gibt.
		 * 
		 * @param artikel
		 *            Artikel, der der Menge hinzugef�gt werden soll
		 * @throws ArtikelBereitsVorhandenException
		 */
		public void addProgramm(Programm programm) throws ProgrammBereitsVorhandenException {
			if (!programmListe.add(programm)) {
				String str = "Artikel kann nicht hinzugef�gt werden,\n"
						+ "da bereits ein Artikel mit derselben ID existiert:\n" + programm.toString();
				throw new ProgrammBereitsVorhandenException(str);
			}
			updateKatLists(programm);
		}

		// Kategorie-abh�ngige Artikellisten aktualisieren,
		// falls realisiert
		private void updateKatLists(Programm programm) {
			// W�re noch zu erledigen
		}
	}
