package KundeVerwaltung;

public class Account {
	private Kunde kunde = null;
	private String emailAdresse = null;
	private String passwort = null;

	public Account(String emailAdresse, String passwort) {
		this.emailAdresse = emailAdresse;
		this.passwort = passwort;
	}

	public Account(String emailAdresse, String passwort, Kunde kunde) {
		this.emailAdresse = emailAdresse;
		this.passwort = passwort;
		this.kunde = kunde;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public String getEmailAdresse() {
		return emailAdresse;
	}

	public void setEmailAdresse(String emailAdresse) {
		this.emailAdresse = emailAdresse;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	/** 
	 * Pr�ft, ob das aktuelle Account-Objekt dieselbe Emailadresse
	 * und dasselbe Passwort besitzt, wie das �bergebene Account-Objekt k.
	 * Falls ja wird true zur�ckgegeben, ansonsten false
	 * 
	 * @param k 
	 */
	public boolean match(Account k) {
		// TODO match implementieren
		return true;
	}

	// Um zu gew�hrleisten, dass keine 2 Accounts mit derselben
	// Emailadresse gespeichert werden
	public boolean equals(Object k) {
		// TODO equals implementieren
		return true;
	}

	// Accounts werden in HashSet gespeichert,
	// also hashCode n�tig. Dieser muss f�r inhaltsgleiche
	// Objekte denselben Wert ergeben
	public int hashCode() {
		// TODO hashCode implementieren
		return 0;
	}

	public String toString() {
		return "Emailadresse = " + emailAdresse + ", Passwort = " + passwort;
	}

}
