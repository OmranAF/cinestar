package Fachlogik;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;

import FilmVerwaltung.Film;
import FilmVerwaltung.Filmverwaltung;
import FilmVerwaltung.Kategorie;
import FilmVerwaltung.Programm;
import FilmVerwaltung.ProgrammBereitsVorhandenException;
import FilmVerwaltung.Programmverwaltung;
import KundeVerwaltung.Account;
import KundeVerwaltung.AccountBereitsVorhandenException;
import KundeVerwaltung.Accountverwaltung;
import KundeVerwaltung.Kunde;
public class Kino {

	private String betreiber;
	private Kunde aktuellerKunde;
	private Einkaufswagen aktuellerEinkaufswagen;
	private Programmverwaltung programmverwaltung;
	private Accountverwaltung accountverwaltung;
	public Kino(Filmverwaltung flimverwaltung,
			Accountverwaltung accountverwaltung, String betreiber) {
		
	}
	public void laden() throws IOException, ProgrammBereitsVorhandenException, AccountBereitsVorhandenException {
		String str = null;
		try {
			programmverwaltung.laden();
		} catch (IOException ex) {
			str = ex.getMessage();
		} finally {
			try {
				accountverwaltung.laden();
			} catch (IOException e) {
				if (str == null)
					str = e.getMessage();
				else
					str += "\n" + e.getMessage();
			}
			if (str != null)
				throw new IOException(str);
		}
	}
	
	public String getBetreiber() {
		return betreiber;
	}
	public void anmelden(Account account) {
		Account ac = accountverwaltung.getMatchingAccount(account);
		aktuellerKunde = ac.getKunde();
		aktuellerEinkaufswagen = new Einkaufswagen();
		
	}
	public void abmelden() {
		aktuellerKunde = null;
		aktuellerEinkaufswagen = null;
		
	}

	public String getKundenName() {
		return aktuellerKunde.getName();
	}

	public boolean einkaufswagenIstLeer() {
		return aktuellerEinkaufswagen.istLeer();
	}

	public void leereEinkaufswagen() {
		aktuellerEinkaufswagen.allesLoeschen();
	}
	public void inEinkaufswagen(List<Programm> ausgewaehlteProgramm) {
		for (Programm programm : ausgewaehlteProgramm) {
			aktuellerEinkaufswagen.einfuegen(programm);
		}
		
	}

	public void ausEinkaufswagenNehmen(Programm zuLoeschenderProgramm) {
		aktuellerEinkaufswagen.loeschen(zuLoeschenderProgramm);
	}
	public boolean istGueltig(Account account) {
		return accountverwaltung.istGueltig(account);
	
	}

	public List<Programm> getProgrammliste() {
		return programmverwaltung.getProgrammliste();
	}
	
	public List<Programm> getProgrammProKategorie(Kategorie kategorie) {
		return programmverwaltung.getProgrammliste(kategorie);
	}
	
	public SortedMap<Programm, Integer> getInhaltEinkaufswagen() {
		return aktuellerEinkaufswagen.getInhalt();
	}
}
