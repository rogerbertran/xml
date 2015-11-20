package Patterns.src;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness {

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	String cadena;
    	String pauta;
        try {
			while (true) {
				System.out.println("");
				System.out.println("Introdueix la pauta (pattern) a buscar (EXIT per sortir): ");
				pauta = sc.nextLine();
			    Pattern pattern = 
			    Pattern.compile(pauta);
			    
			    if (pauta.equals("EXIT")) throw new Exception();
			    
			    System.out.println("Introdueix ara la cadena (matcher) on es buscarà: ");
				cadena = sc.nextLine();  
				
				
			    Matcher matcher = 
			    pattern.matcher(cadena);

			    boolean found = false;
			    while (matcher.find()) {
			        System.out.println("Pauta trobada: <" + matcher.group() + "> i comença a l'índex " +
			        matcher.start() + " i acaba a l'índex " + matcher.end());
			        found = true;
			    }
			    if(!found){
			    	System.out.println("Pauta no trobada");
			    }
			}
		} catch (Exception e) {
			System.out.println("Sortida");
		} finally {
			sc.close();	
		}
        
    } 
}