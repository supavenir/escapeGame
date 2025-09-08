package game.escape.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.escape.exceptions.NullResponseException;
import game.escape.models.Enigme;
import game.escape.models.Salle;

class SalleTest {
	
	private Salle salle;
	private String bonneReponse;
	private String mauvaiseReponse;

	@BeforeEach
	void setUp() throws Exception {
		salle=new Salle("C12", 30);
		bonneReponse="AA";
		mauvaiseReponse="BB";
		
		salle.ajouterEnigme(new Enigme("Cheval blanc", "Cheval blanc de Henry IV ?", bonneReponse));
	}

	@Test
	void testAjouterEnigme() {
		//Scénario nominal
		assertEquals(1, salle.getEnigmes().size());
		Enigme enigme1=new Enigme("Cheval vert", "Cheval rouge de Barberousse ?", "rouge");
		salle.ajouterEnigme(enigme1);
		assertEquals(2, salle.getEnigmes().size());
		//Cas d'exception : ajout du même objet
		salle.ajouterEnigme(enigme1);
		assertEquals(2, salle.getEnigmes().size());
		//Cas d'exception : ajout de la même question
		salle.ajouterEnigme(new Enigme("Cheval rouge", "Cheval rouge de Barberousse ?", "rouge"));
		assertEquals(2, salle.getEnigmes().size());
		//Cas d'exception : Description nulle
		salle.ajouterEnigme(new Enigme("", null, ""));
		assertEquals(3, salle.getEnigmes().size());
	}

	@Test
	void testResoudreEnigme() throws NullResponseException {
		//Scénario nominal : je donne la bonne réponse
		assertTrue(salle.resoudreEnigme(0, bonneReponse));
		
		//Scénario nominal : je donne la mauvaise réponse
		assertFalse(salle.resoudreEnigme(0, mauvaiseReponse));
		
		assertFalse(salle.resoudreEnigme(0, null));
	}

}
