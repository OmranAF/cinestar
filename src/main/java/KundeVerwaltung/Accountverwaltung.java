package KundeVerwaltung;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Accountverwaltung {
	private Set<Account> accountListe;
	private DatenHaltung.IAccountDAO dao;


	public void laden() throws IOException, AccountBereitsVorhandenException {
		accountListe.clear();
		List<Account> liste = dao.laden();
		try {
			for (Account ac : liste)
				this.addAccount(ac);

		} catch (AccountBereitsVorhandenException ex) {
			throw new AccountBereitsVorhandenException(
					"Fehler beim Laden der Kundendaten. " + ex.getMessage());
		}
	}
		
		public void speichern() throws IOException {
			List<Account> liste = new ArrayList<Account>();
			for (Account ac : accountListe)
				liste.add(ac);
			dao.speichern(liste);
		}

		public boolean istLeer() {
			return accountListe.isEmpty();
		}

		public void addAccount(Account account) throws AccountBereitsVorhandenException {
			if (!accountListe.add(account)) {
				String str = "Es gibt bereits einen Account mit der angegebenen Emailadresse:\n" + account.toString();
				throw new AccountBereitsVorhandenException(str);
			}
		}

		public boolean istGueltig(Account account) {
			for (Account ac : accountListe) {
				if (ac.match(account))
					return true;
			}
			return false;
		}

		public Account getMatchingAccount(Account account) {
			for (Account ac : accountListe) {
				if (ac.match(account))
					return ac;
			}
			return null;
		}
	}

