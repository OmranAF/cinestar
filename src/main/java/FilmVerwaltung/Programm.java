package FilmVerwaltung;

public class Programm {
	
	
	private Film film;
	private Saal saal;
	private String showTime;
	private int verfuegbarPlatz;
	private int anzReservierung = 0 ;
		
	
	public Programm(Film film , Saal saal, String showTime) {
		
	setVerfuegbarPlatz(saal.getAnzPlatz());
	setShowTime(showTime);
	this.film = film;
	
	}
	
	
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public int getVerfuegbarPlatz() {
		return verfuegbarPlatz;
	}
	public void setVerfuegbarPlatz(int verfuegbarPlatz) {
		this.verfuegbarPlatz = verfuegbarPlatz;
	}
	public int getAnzReservierung() {
		return anzReservierung;
	}
	public void setAnzReservierung(int anzReservierung) {
		this.anzReservierung = anzReservierung;
	}
	public Film getFilm() {
		return film;
	}
	public Saal getSaal() {
		return saal;
	}


	public Kategorie getKategorie() {
		
		return film.getKategorie();
	}
	
	

}
