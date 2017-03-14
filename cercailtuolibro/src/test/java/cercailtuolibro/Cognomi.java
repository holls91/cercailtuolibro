package cercailtuolibro;

import java.util.Random;

public enum Cognomi {
	Amato("Amato"), 
	Barbieri("Barbieri"), Barone("Barone"), Basile("Basile"), Battaglia("Battaglia"), Bellini("Bellini"), Benedetti("Benedetti"), Bernardi("Bernardi"), Bianchi("Bianchi"), Bianco("Bianco"), Bruno("Bruno"), 
	Caputo("Caputo"), Carbone("Carbone"), Caruso("Caruso"), Cattaneo("Cattaneo"), Colombo("Colombo"), Conte("Conte"), Conti("Conti"), Coppola("Coppola"), Costa("Costa"), Costantini("Costantini"), 
	Damico("Damico"), D_amico("D'amico"), Dangelo("Dangelo"), De__Angelis("De Angelis"), De__Luca("De Luca"), De__Rosa("De Rosa"), De__Santis("De Santis"), Donati("Donati"), 
	Esposito("Esposito"), 
	Fabbri("Fabbri"), Farina("Farina"), Ferrara("Ferrara"), Ferrari("Ferrari"), Ferraro("Ferraro"), Ferretti("Ferretti"), Ferri("Ferri"), Fiore("Fiore"), Fontana("Fontana"), 
	Galli("Galli"), Gallo("Gallo"), Gatti("Gatti"), Gentile("Gentile"), Giordano("Giordano"), Giuliani("Giuliani"), Grassi("Grassi"), Grasso("Grasso"), Greco("Greco"), Guerra("Guerra"), 
	Leone("Leone"), Lombardi("Lombardi"), Lombardo("Lombardo"), Longo("Longo"), 
	Mancini("Mancini"), Marchetti("Marchetti"), Mariani("Mariani"), Marini("Marini"), Marino("Marino"), Martinelli("Martinelli"), Martini("Martini"), Martino("Martino"), Mazza("Mazza"), Messina("Messina"), Milani("Milani"), Montanari("Montanari"), Monti("Monti"), Morelli("Morelli"), Moretti("Moretti"), 
	Negri("Negri"), Neri("Neri"), 
	Orlando("Orlando"), 
	Pagano("Pagano"), Palmieri("Palmieri"), Palumbo("Palumbo"), Parisi("Parisi"), Pellegrini("Pellegrini"), Pellegrino("Pellegrino"), Piras("Piras"), 
	Ricci("Ricci"), Rinaldi("Rinaldi"), Riva("Riva"), Rizzi("Rizzi"), Rizzo("Rizzo"), Romano("Romano"), Rossetti("Rossetti"), Rossi("Rossi"), Ruggiero("Ruggiero"), Russo("Russo"), 
	Sala("Sala"), Sanna("Sanna"), Santoro("Santoro"), Sartori("Sartori"), Serra("Serra"), Silvestri("Silvestri"), Sorrentino("Sorrentino"), 
	Testa("Testa"), 
	Valentini("Valentini"), Villa("Villa"), Vitale("Vitale"), Vitali("Vitali");

	private String cognome;

	private Cognomi(String cognome) { this.cognome = cognome; }

	public static String random() {
		return values()[new Random().nextInt(values().length)].toString();
	}
	
	public String toString() {
		return this.cognome;
	}

}