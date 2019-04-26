package KundeVerwaltung;

public class Kunde {

	private static int anzahlKunden = 0;
	private int kundenID;
	private String name;
	private String adresse;
	
	public Kunde(String name)
	{
		kundenID = ++anzahlKunden;
		this.name = name;
	}	
	
	public int hashCode() {
		return kundenID;
	}
		public boolean equals (Object k) {
		// TODO equals implementieren
		return true;
	}
	
	public long getKundenID() {
		return kundenID;
	}

	public String getName() {
		return name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
