import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {

            final long start = System.nanoTime() ;

            float weight, value, capacity;

            ArrayList<Objet> objets = new ArrayList<>();
            Objet objet;

            Scanner file = new Scanner(new File("sac4"));
            capacity = file.nextInt();

            int cpt =1;

            while (file.hasNextInt()) {
                weight = file.nextInt();
                value= file.nextInt();
                objet = new Objet(weight,value,cpt);
                cpt += 1;
                objets.add(objet);
            }

            Collections.sort(objets);

            BranchAndBound Bag = new BranchAndBound(objets,capacity);
            Bag.branch_bound(capacity,0,0);

            ArrayList<Objet> BestBag = Bag.getMaxBag();

            System.out.println("Objet dans le Sac : ");

            float valeur = 0;
            for(Objet obj : BestBag ){
                if (obj == null) continue;
                else
                    System.out.print(obj.getIndex()+ " ");
                    valeur = valeur + obj.getValue();

            }

            System.out.println("\n"+ "Valeur du Sac : " + valeur);

            final long end = System.nanoTime() ;
            final long time = (end - start) / 1_000_000 ;
            System.out.println("Durée  final = " + (double) time / 1000 + " s.") ;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
