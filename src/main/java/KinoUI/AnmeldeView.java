package KinoUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class AnmeldeView  extends JDialog {

private JTextField textfeldEmailAdresse;
	
	// V6.0 JPasswordFiels statt JTextField
	private JPasswordField textfeldPasswort; 
	
	// V5.0 als Attribut wegen Methode focusToNextComponent
	JButton weiter = new JButton("anmelden"); 
	private String emailAdresse;
	private String passwort;

	/**
	 * Erfragt Emailadresse und Passwort und speichert sie in Attributen
	 */
	public AnmeldeView(Window owner, Controller controller) {
		super(owner, "Anmelden");
		setModal(true);

		setSize(300, 170);
		setMinimumSize(new Dimension(300, 170)); // Damit Fenster nicht zu klein
												 // werden kann

		setLocationRelativeTo(owner); // In Mitte des Owners positionieren

		setLayout(new GridLayout(5, 1));

		JLabel labelEmailAdresse = new JLabel("Geben Sie Ihre Emailadresse ein");
		JLabel labelPasswort = new JLabel("Geben Sie Ihr Passwort ein");
		textfeldEmailAdresse = new JTextField();
		textfeldPasswort = new JPasswordField(); // V6.0

		add(labelEmailAdresse);
		add(textfeldEmailAdresse);
		add(labelPasswort);
		add(textfeldPasswort);
		add(weiter);
		
		iniAnmeldeDialog();
		
     	// V5.0: Beobachter registrieren, hier Controllercode in 
		// innerer Klasse AnmeldeListener von Controller
		Controller.AnmeldeListener al = controller.new AnmeldeListener();
		textfeldEmailAdresse.addKeyListener(al);
		textfeldPasswort.addKeyListener(al);
		weiter.addKeyListener(al);
		weiter.addActionListener(al);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// V5.0 setVisible -> Methode anmelden im Controller. 
		// Begründung siehe V5.0
		// setVisible(true);
	}
	
	private void iniAnmeldeDialog() {
		textfeldEmailAdresse.setText("");
		textfeldPasswort.setText("");
		textfeldEmailAdresse.requestFocus();
	}
	public void erfrageAnmeldeInfos() {
		// TODO erfragen der Anmeldeinfos implementieren
	}

	public String getEmail() {
		return emailAdresse;
	}

	public String getPwd() {
		return passwort;
	}


	/**
	 * Gibt die ung�ltigen Anmeldeinformationen aus
	 * 
	 * @param account
	 */
	public void anzeigenAccountError(String email, String pwd) {
		new HinweisView("Ung�ltige Anmeldeinformationen: Emailadresse = " 
	                       + email + ", Passwort = " + pwd);
	}

}
