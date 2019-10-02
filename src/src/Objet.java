public class Objet implements Comparable<Objet> {
    float value;
    float weight;
    float ratio;
    int index;

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

    /*Comparateur entre les differents ratio des objets */
    @Override
    public int compareTo(Objet o) {
        if(this.getRatio() < o.getRatio())
            return  1;
        return -1;
    }


}
