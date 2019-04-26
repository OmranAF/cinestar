package KinoUI;

import java.util.SortedMap;

import Fachlogik.Kino;
import FilmVerwaltung.Programm;
import Webshop.Fachlogik.Webshop;
import Webshop.Fachlogik.Kundenverwaltung.Account;
import Webshop.Fachlogik.Kundenverwaltung.UngueltigerAccountException;
import Webshop.UI.AnmeldeView;
import Webshop.UI.AuswahlView;
import Webshop.UI.BestellView;
import Webshop.UI.EinkaufswagenView;
import Webshop.UI.HinweisView;
import Webshop.UI.MainView;


public class Controller {

	/**
	 * Attribute deklarieren; Assoziation zu Webshop
	 */
	private Kino kino;
	
	private MainView mainwindow; // V4.0
	
	// ********* V5.0 ***************/
	private AuswahlView auswahlView;
	private AnmeldeView anmeldeView;
	private BestellView bestellView;
	private EinkaufswagenView ekwView;

	

	public Controller(Kino kino) {
		this.kino = kino;
	}

	/**
	 * Erste Aktion des Controllers
	 */
	public void start() {
		// TODO Daten laden und Willkommensgru� mit Name des Betreibers anzeigen
		//      Anmeldung durchf�hren und Hauptmenue starten
	}
	
	/**
	 * Die Methode ausfuehren nimmt die Nummer der vom Benutzer im Hauptmenue 
	 * gew�hlten Aktion entgegen und und st��t die entsprechende Aktion an.
	 * (ausfuehren wird durch Methode starteMenue der MainView aufgerufen)
	 * 
	 * @param auswahl: Nummer der auszuf�hrenden Aktion
	 *            (z.B. 1 f�r einkaufen, 2 f�r Anzeige des Einkaufswagens etc.)
	 */
	public void ausfuehren(int auswahl) {
		//TODO Implementierung erg�nzen
	}

	/**
	 * Die Anmeldedaten (Benutzername & Passwort) werden vom Benutzer 
	 * erfragt und beim Webshop auf G�ltigkeit gepr�ft. (Der Webshop
	 * fragt daf�r bei der Kundenverwaltung / Accountverwaltung nach.)
	 * Sind die Anmeldedaten g�ltig, wird der Kunde beim Webshop 
	 * angemeldet, ansonsten erfolgt eine Fehlermeldung.
	 * 
	 * @return anmeldenErfolgreich
	 */
	private boolean anmelden() {
		// TODO anmelden implementieren
		anmeldeView = new AnmeldeView(mainwindow, this);
		// V5.0 Aus Konstruktor ausgelagert wegen Punkt 3)
		anmeldeView.setVisible(true); 
		boolean anmeldenErfolgreich = false;
		try {
			String email = anmeldeView.getEmail();
			String pwd = anmeldeView.getPwd();
			Account account = new Account(email, pwd);
			if (webshop.istGueltig(account)) {
				anmeldenErfolgreich = true;
				webshop.anmelden(account);
			} else {
				new HinweisView(mainwindow, 
						   "Ungültige Anmeldeinformationen: Emailadresse = " 
	                       + email + ", Passwort = " + pwd);
			}
		} catch (UngueltigerAccountException e) {
			new HinweisView(mainwindow, e.toString());
		}
		return anmeldenErfolgreich;
	}
	
	private void einkaufsWagenAusgeben() {
		// TODO Inhalt des Einkaufswagens anzeigen
	}

	/**
	 * Es werden erst alle Artikel ausgew�hlt. Danach kommen sie alle 
	 * zusammen in den Einkaufswagen (keine Einzelauswahl der Artikel) 
	 */
	private void einkaufen() {
		// TODO einkaufen implementieren
	}

	/**
	 * Es wird einfach eine Bestell�bersicht angezeigt (Artikel im
	 * Einkaufswagen)
	 * 
	 * Bei ggf. sp�terer Erweiterung des Funktionsumfangs m�ssten hier noch
	 * weitere Daten erfasst werden wie Versandadresse, Zahlungsart etc. (siehe
	 * ToDo)
	 */
	private void zurKasse() {
		// TODO zu Kunde geh�renden Einkaufswagen ermitteln
		// Fehlende Daten erfassen wie Versandadresse, Zahlungsart etc.
		// Ggf. Kundenadresse aktualisieren
		// Bestell�bersicht anfertigen inkl. Gesamtpreis
		// Bestell�bersicht anzeigen

	}

	/**
	 * Es wird eine einfache Versandnachricht mit dem Namen des Kunden geschickt
	 * ohne Auflistung der gekauften Artikel, Lieferzeiten etc. Der
	 * Einkaufswagen des Kunden wird geleert
	 */
	private void jetztKaufen() {
		// TODO jetztKaufen implementieren
	}
	
	/**
	 * Es wird eine einfache Nachricht mit dem Namen des Kunden angezeigt (Auf Wiedersehen ...).
	 * Der Kunde wird am Webshop abgemeldet
	 */
	private void abmelden() {
		// TODO Implementierung
	}

	// Durchreichen an Webshop
	public void ausEinkaufswagenNehmen(Programm zuLoeschenderProgramm) {
		kino.ausEinkaufswagenNehmen(zuLoeschenderProgramm);
	}
	
	public SortedMap<Programm, Integer> getInhaltEinkaufswagen() {
		return kino.getInhaltEinkaufswagen();
	}

}
