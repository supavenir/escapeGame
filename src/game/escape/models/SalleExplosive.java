package game.escape.models;

public class SalleExplosive extends Salle {
	private Enigme enigmeFausse;

	public SalleExplosive(String nom, int tempsLimite, Enigme enigmeFausse) {
		super(nom, tempsLimite);
		setEnigmeFausse(enigmeFausse);
	}
	
	public void setEnigmeFausse(Enigme enigmeFausse) {
		if(ajouterEnigme(enigmeFausse)) {
			this.enigmeFausse=enigmeFausse;
		}
	}

}
