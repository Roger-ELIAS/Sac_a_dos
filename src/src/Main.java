import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            float weight;
            float value;
            float capacity;
            Scanner fichier = new Scanner(new File("sac0"));
            capacity = fichier.nextInt();
            int cpt =1;
            ArrayList<Objet> objets = new ArrayList<>();
            Objet objet;
            while (fichier.hasNextInt()) {
                weight = fichier.nextInt();
                value= fichier.nextInt();
                objet = new Objet(weight,value,cpt);
                cpt += 1;
                objets.add(objet);
            }

            Collections.sort(objets);

            BranchAndBound bb = new BranchAndBound(objets,capacity);
            bb.branch_bound(capacity,0,0);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
