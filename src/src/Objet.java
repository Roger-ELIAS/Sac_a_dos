public class Objet implements Comparable<Objet> {
    float value;
    float weight;
    float ratio;
    int index;

    /**
     * Constucteur des objets avec leur différentes caractérisques
     * @param weight poids de l'objets
     * @param value valeur de l'objet
     * @param index indice de l'objet selon le fichier
     */
    public Objet(float weight, float value,int index) {
        this.value = value;
        this.weight = weight;
        this.ratio = value / weight;
        this.index = index;
    }

    public float getValue() {
        return value;
    }

    public float getWeight() {
        return weight;
    }

    public float getRatio() {
        return ratio;
    }

    public int getIndex() { return index; }

    /**
     * Comparateur entre deux objets differents selon leurs ratio
     * @param o Objets a comparé
     * @return
     */
    @Override
    public int compareTo(Objet o) {
        if(this.getRatio() < o.getRatio())
            return  1;
        return -1;
    }


}
