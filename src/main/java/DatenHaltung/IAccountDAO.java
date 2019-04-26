package DatenHaltung;

import java.io.IOException;
import java.util.List;

import KundeVerwaltung.Account;


/**
 * Ein Interface fuer ein Account-DAO. Zur Vereinfachung wird ueber dieses
 * Interface immer der komplette Datenbestand gelesen und geschrieben. Fuer
 * einen Zugriff auf einzelne Datansaetze wuerde dieses Interface im Normalfall
 * die Methoden create, read, update und delete anbieten.
 */
public interface IAccountDAO {
	List<Account> laden() throws IOException;
	void speichern(List<Account> accountListe)  throws IOException;
}
