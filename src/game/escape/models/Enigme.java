package game.escape.models;

import game.escape.exceptions.NullResponseException;

public class Enigme {
	private String titre;
	private String description;
	private String codeSolution;
	private boolean resolue;
	
	public Enigme(String titre, String description, String codeSolution) {
		this.titre = titre;
		this.description =description;
		this.codeSolution = codeSolution;
		this.resolue = false;
	}
	
	@Override
	public String toString() {
		return "L'énigme " + titre + " - " + description + (resolue ? "🔓 Énigme résolue !" : "❌ Mauvaise réponse");
	}
	
	public boolean resoudre(String tentative) throws NullResponseException  {
		if(tentative==null) {
			throw new NullResponseException();
		}
		return resolue = codeSolution.equalsIgnoreCase(tentative);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Enigme)) {
			return false;
		}
		Enigme autreEnigme=(Enigme) obj;
		return (description+"").equals(autreEnigme.description);
	}
	
	@Override
	public int hashCode() {
		return (description+"").hashCode();
	}
	
	public boolean isResolue() {
		return resolue;
	}

}
