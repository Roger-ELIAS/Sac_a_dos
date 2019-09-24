import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            float poids;
            float valeur;
            float cap;
            Scanner fichier = new Scanner(new File("sac0"));
            cap = fichier.nextInt();

            ArrayList<Objet> objets = new ArrayList<>();
            Objet objet;
            while (fichier.hasNextInt()) {
                poids = fichier.nextInt();
                //System.out.print(nombre +" ");
                valeur= fichier.nextInt();
                //System.out.println(nombre);
                objet = new Objet(poids,valeur);
                objets.add(objet);
            }

            Collections.sort(objets);
            for(Objet element :objets){
                System.out.println(element.getRatio());
            }
            System.out.println("                      ");
            SacADos sac =new SacADos(cap,objets);
            sac.remplirSac();

            System.out.println(objets.size());
            System.out.println(sac.getValeur());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
