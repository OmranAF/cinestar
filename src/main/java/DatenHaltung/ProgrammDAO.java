package DatenHaltung;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import FilmVerwaltung.Programm;
import KundeVerwaltung.UngueltigerNameException;





public class ProgrammDAO implements IProgrammDAO {

	/**
	 *  
	 * �nderung Version 3.0: R�ckgabetyp void; Verwendung von Exceptions
	 *  
	 * Erzeugt Artikelobjekte und gibt diese in artikelListe zur�ck
	 * 
	 * @param artikelListe
	 * @throws UngueltigerPreisException
	 * @throws UngueltigeBezeichnungException
	 */
	private void initDaten(List<Programm> programmListe)
			throws UngueltigerNameException {//muss die Exception ändern 
		//muss die Programm konstruktor einverstanden
		programmListe.add(new Programm(null,null,null));
		//programmListe.add(new Programm(null,null,null));
		//programmListe.add(new Programm());
		//programmListe.add(new Programm());
		
		// F�r Test, doppelte ID 3, Hier kein Problem, erst bei �bernahme der Daten in Artikelverwaltung
//		artikelListe.add(new TabletPC(3, 200.00, "Kindle Fire_2")); 
//		artikelListe.add(new TabletPC(200.00, "")); // Ung�ltige Bezeichnung
//		artikelListe.add(new TabletPC(0.00, "KF")); // Ung�ltiger Preis
		
	//	programmListe.add(new Programm());
	}
	

	/**
	 * �nderung Version 3.0: R�ckgabetyp jetzt List<Artikel>; Verwendung von Exceptions
	 * 
	 * L�dt die Artikel aus dem Persistenzmedium und speichert sie in
	 * artikelListe.
	 * 
     * @return Liste der geladenen Artikel
	 * @throws IOException
	 */
	public List<Programm> laden() throws IOException {
		List<Programm> liste = new ArrayList<Programm>();
		try {
			initDaten(liste);
			return liste;
		} catch (UngueltigerNameException e) {
			throw new IOException("Fehler beim Laden der Artikeldaten:"
					+ e.getMessage());
		}
	}

	/**
	 * Persistiert die in artikelListe �bergebenen Artikel
	 * 
	 * @param artikelListe
	 * @throws IOException
	 */
	public void speichern(List<Programm> programmListe) throws IOException {
		
	}
}
