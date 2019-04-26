package FilmVerwaltung;

public class Saal {
	private static int anzSaal = 0 ; 
	private int saalId;
	private String saalName;
	private int anzPlatz;
	
	public Saal(String name , int anzPlatz) {
		saalId = ++anzSaal;
		setSaalName(name);
		setAnzPlatz(anzPlatz);		
	}
	
	
	public int getSaalId() {
		return saalId;
	}

	public String getSaalName() {
		return saalName;
	}
	public void setSaalName(String saalName) {
		this.saalName = saalName;
	}
	public int getAnzPlatz() {
		return anzPlatz;
	}
	public void setAnzPlatz(int anzPlatz) {
		this.anzPlatz = anzPlatz;
	}
	

}
