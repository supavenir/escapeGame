package game.escape;

import java.util.Scanner;

import game.escape.exceptions.NullResponseException;
import game.escape.models.Enigme;

public class Prog {
	public static void main(String[] args) throws NullResponseException {
		Enigme c=new Enigme("Enigme 1", "Quelle est la couleur du cheval blanc d'Henri IV ?", "Blanc");
        Scanner s = new Scanner(System.in);
        System.out.println(c);
        c.resoudre("noir");
        System.out.println(c);
        c.resoudre("blanc");
        System.out.println(c);
        if (c.resoudre("blanc")) {
        	System.out.println("Il est bien blanc !");
        }
	}
}
