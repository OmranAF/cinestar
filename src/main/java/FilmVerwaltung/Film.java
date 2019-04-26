package FilmVerwaltung;

public abstract class Film implements Comparable<Film> {
	private static int anzFilm = 0;
	private int filmId;
	private Kategorie kategorie;
	private String filmName;
	private String beschreibung;
	
	public Film (Kategorie kategorie, String beschreibung,String filmName) {
		
		filmId = ++anzFilm;
		this.kategorie = kategorie;
		setBeschreibung(beschreibung);
		setFilmName(filmName);
		

	}
	
	public int getFilmId() {
		return filmId;
	}

	public Kategorie getKategorie() {
		return kategorie;
	}

	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
}