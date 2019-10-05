import java.util.ArrayList;

public class BranchAndBound {
    ArrayList<Objet> object_list;
    int size;
    float capacity;
    float vmax =0;
    ArrayList<Objet> maxBag;
    ArrayList<Objet> object_list_taken;


    public BranchAndBound(ArrayList<Objet> object_list, float capacity) {
        this.object_list = object_list;
        this.size = object_list.size();
        this.capacity = capacity;
        object_list_taken = new ArrayList<>(object_list);
    }

    /**
     * Fonction récursive qui parcours l'arbre et calcule la valeur maximum du sac.
     * Elle utilise la fonciton optimum qui calcule l'optimum selon l'arbre courant.
     * Cela permet d'optimiser les decoupes.
     * @param bagCapacity repsente la capacaite restante du sac (au debut ce la represeente )
     * @param value valeur du sac 0 de base
     * @param i indece de l'objet dans l'arbre
     */
    public void branch_bound(float bagCapacity,float value,int i){
        float optimum = optimum(bagCapacity,value,i);
        if(i == size){
            if (value > vmax){
                vmax = value;
                maxBag = new ArrayList<>(object_list_taken);
            }
        }else{
            if(optimum>=vmax) {
                if (object_list.get(i).getWeight() <= bagCapacity) {
                    object_list_taken.set(i,object_list.get(i));
                    branch_bound(bagCapacity - object_list.get(i).getWeight(), value + object_list.get(i).getValue(), i + 1);
                }
            }
            object_list_taken.set(i,null);
            branch_bound(bagCapacity,value,i+1);
        }
    }

    /**
     * Cette fonction permet de calculer l'optimum a partir de l'objet courant
     * @param remainingCapacity Capacité restante dans le sac.
     * @param value valeur du sac actuel
     * @param i index de l'objet courant
     * @return l'optimum a partir de l'objet courant
     */
    public float optimum  (float remainingCapacity,float value, int i){
        float weightBag = capacity - remainingCapacity;
        float optimum = value;
        for(;i<size;++i){
            Objet objet = object_list.get(i);
            if(weightBag + objet.getWeight()<= capacity){
                weightBag += objet.getWeight();
                optimum += objet.getValue();
            }else{
                float poidrestant = capacity - weightBag;
                optimum += poidrestant * objet.getRatio();
                break;
            }
        }
        return optimum;
    }

    public ArrayList<Objet> getMaxBag() {
        return maxBag;
    }
}
