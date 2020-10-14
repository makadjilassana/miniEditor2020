package fr.istic.aco.editor;

import java.util.Scanner;

public class mainRest {

    public static void init(){
        System.out.println("Veuillez taper un texte SVP");
        Scanner scan= new Scanner(System.in);
        String texte= scan.next();
        System.out.println("=== Texte saisi: "+texte+" ===");
        System.out.println("Veuillez faire votre choix: 1, 2");
        System.out.println("1. Inserer un nouveau texte dans le Buffer qui remplace une selection de texte");
        System.out.println("2. Couper un texte du Buffer après selection du dit-texte");

        int choix= scan.nextInt();

        Engine engine= new EngineImpl();
        engine.setBufferContains(texte);

        switch(choix){
            case 1:
                System.out.print("Faites une selection, ");

                System.out.println("donnez indexDebut");
                int indexDebut= scan.nextInt();
                System.out.println("indexDebut: "+indexDebut);

                System.out.println("donnez indexFin");
                int indexFin= scan.nextInt();
                System.out.println("indexFin: "+indexFin);

                engine.setSelection(indexDebut,indexFin);
                engine.insert("merci");
                System.out.println("=== texte obtenu apres insertion du nouveau texte: ===");
                System.out.println(engine.getBufferContents());
                break;

            case  2:
                System.out.println("En cours de developpement ...");
                break;

            default:
                System.out.println("Erreur :: Saisissez 1 ou 2 SVP");
                break;
        }

    }

    public static void main(String[] args) {
        init();
    }

}
