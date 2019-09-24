import java.util.ArrayList;

public class SacADos {
    float poids;
    float valeur;
    float capacite;
    ArrayList<Objet> objets;
    ArrayList<Objet> sac;


    public SacADos(float capacite, ArrayList<Objet> objets) {
        this.poids = 0;
        this.valeur =0;
        this.capacite = capacite;
        this.objets = objets;
        this.sac = new ArrayList<>();
    }

    void addSac(Objet objet){
        this.poids = this.poids + objet.getPoids();
        this.valeur = this.valeur + objet.getValeur();
        sac.add(objet);
    }

    void remplirSac(){
        boolean stop= false;
        for (Objet objet: objets){
            if(objet.getPoids() + poids <= capacite){
               addSac(objet);
            }
            else if(!stop){
                float reste = capacite -poids;
                float fraction = reste / objet.getPoids();
                Objet obj = new Objet(objet.getPoids()*fraction,objet.getValeur()*fraction);
                addSac(obj);
                stop = true;
            }
        }


    }

    public float getPoids() {
        return poids;
    }

    public float getCapacite() {
        return capacite;
    }

    public ArrayList<Objet> getSac() {
        return sac;
    }

    public float getValeur() {
        return valeur;
    }
}
