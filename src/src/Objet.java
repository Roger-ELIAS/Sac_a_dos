public class Objet implements Comparable<Objet> {
    float valeur;
    float poids;
    float ratio;


    public Objet(float poids, float valeur) {
        this.valeur = valeur;
        this.poids = poids;
        this.ratio = valeur / poids;

    }


    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    @Override
    public int compareTo(Objet o) {
        if(this.getRatio() < o.getRatio())
            return  1;
        return -1;
    }
}
