package game.escape.models;

public class SalleExplosiveRandom extends SalleExplosive {

	public SalleExplosiveRandom(String nom, int tempsLimite) {
		super(nom, tempsLimite,null);
	}
	
	@Override
	public void initialize() {
		selectRandom();
	}
	
	public boolean selectRandom() {
		if(enigmes.size()>0) {
			int aleatNumber=(int) Math.round(Math.random()*enigmes.size());
			setEnigmeFausse(enigmes.get(aleatNumber));
			return true;
		}
		return false;
	}

}
