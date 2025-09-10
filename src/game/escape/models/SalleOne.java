package game.escape.models;

public class SalleOne extends Salle {

	public SalleOne(String nom, int tempsLimite) {
		super(nom, tempsLimite);
	}

	@Override
	public boolean estTerminee() {
		for(Enigme e:enigmes) {
			if(e.isResolue()) {
				return true;
			}
		}
		return false;
	}


}
