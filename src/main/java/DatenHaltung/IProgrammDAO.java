package DatenHaltung;

import java.io.IOException;
import java.util.List;

import FilmVerwaltung.Programm;


/**
 * Ein Interface fuer ein Artikel-DAO. Zur Vereinfachung wird ueber dieses
 * Interface immer der komplette Datenbestand gelesen und geschrieben. Fuer
 * einen Zugriff auf einzelne Datansaetze wuerde dieses Interface im Normalfall
 * die Methoden create, read, update und delete anbieten.
 */
public interface IProgrammDAO {
	List<Programm> laden() throws IOException;
	void speichern(List<Programm> liste) throws IOException;
}