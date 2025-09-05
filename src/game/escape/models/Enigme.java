package game.escape.models;

public class Enigme {
	private String titre;
	private String description;
	private String codeSolution;
	private boolean estResolue;
	
	public Enigme(String titre, String description, String codeSolution) {
		this.titre = titre;
		this.description =description;
		this.codeSolution = codeSolution;
		this.estResolue = false;
	}
	
	@Override
	public String toString() {
		return "L'énigme " + titre + " - " + description + (estResolue ? "🔓 Énigme résolue !" : "❌ Mauvaise réponse");
	}
	
	public boolean resoudre(String tentative) {
		if(codeSolution.equalsIgnoreCase(tentative)) {
			estResolue = true;
		}
		return estResolue;
	}
	
	

}
