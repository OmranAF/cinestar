package DatenHaltung;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import KundeVerwaltung.Account;
import KundeVerwaltung.Kunde;
import KundeVerwaltung.UngueltigerAccountException;
import KundeVerwaltung.UngueltigerNameException;

public class AccountDAO implements IAccountDAO {

	private void initDaten(List<Account> accountListe) {
		KundeVerwaltung.Kunde kunde;
		Account account;
		kunde = new KundeVerwaltung.Kunde("Anton Meyer");
		account = new Account("a.meyer@web.de", "derKluge", kunde);
		accountListe.add(account);

		kunde = new Kunde("Hansi Mueller");
		account = new Account("hansi.mueller@ac.at", "2H355sRe", kunde);
		accountListe.add(account);

		// F�r Test; kurze Eingaben
		kunde = new Kunde("Ernst Otto");
		account = new Account("eo@web.de", "xx", kunde);
		accountListe.add(account);

	}

	/**
	 * L�dt die Accounts aus dem Persistenzmedium und speichert sie in
	 * accountListe. Da noch keine Persistenz bekannt, Initialisierung der
	 * Daten.
	 * 
	 * @param accountListe
	 * @return Gibt 0 zur�ck, wenn das Laden erfolgreich war, sonst 1
	 */
	
	////// muss Exception Ändern
	public List<Account> laden() throws IOException {
		try {
			List<Account> liste = new ArrayList<Account>();
			initDaten(liste); // Da noch keine IO bekannt
			return liste;
		} catch (NullPointerException e) {
			throw new IOException("Fehler beim Laden der Kundendaten: " + e.getMessage());
		}
	}

	/**
	 * Persistiert die in accountliste �bergebenen Accountsl
	 * 
	 * @return Gibt 0 zur�ck, wenn das Speichern erfolgreich war, sonst >0
	 */
	public void speichern(List<Account> accountListe) throws IOException {
		
	}
}
