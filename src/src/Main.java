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

            ArrayList<Objet> sac = new ArrayList<>();
            Objet objet;
            while (fichier.hasNextInt()) {
                poids = fichier.nextInt();
                //System.out.print(nombre +" ");
                valeur= fichier.nextInt();
                //System.out.println(nombre);
                objet = new Objet(poids,valeur);
                sac.add(objet);
            }
            Collections.sort(sac);
            for(Objet element :sac){
                System.out.println(element.getRatio());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
