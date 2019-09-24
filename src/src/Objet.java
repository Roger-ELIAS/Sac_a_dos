public class Objet implements Comparable<Objet> {
    float valeur;
    float poids;
    float ratio;
    boolean present;


    public Objet(float poids, float valeur) {
        this.valeur = valeur;
        this.poids = poids;
        this.ratio = poids / valeur;
        this.present = false;
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

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    @Override
    public int compareTo(Objet o) {
        if(this.getRatio() < o.getRatio())
            return  1;
        return -1;
    }
}
