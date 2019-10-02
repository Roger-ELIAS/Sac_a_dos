import java.util.ArrayList;

public class BranchAndBound {
    ArrayList<Objet> liste_objet;
    int taille;
    float capacite;
    float vmax =0;
    ArrayList<Objet> SacMax;
    ArrayList<Objet> ObjetPris = new ArrayList<>();


    public BranchAndBound(ArrayList<Objet> liste_objet, float capacité) {
        this.liste_objet = liste_objet;
        this.taille = liste_objet.size();
        this.capacite = capacité;
    }

    public void branch_bound(float capa,float valeur,int i ){
        float optimum = optimum(capa,liste_objet,valeur,i);
        if(i == taille){
            if (valeur > vmax){
                vmax = valeur;
                SacMax = new ArrayList<Objet>(ObjetPris);
                ObjetPris.clear();
            }
        }else{
            if(optimum>=vmax) {
                if (liste_objet.get(i).getWeight() <= capa) {
                    ObjetPris.add(liste_objet.get(i));
                    branch_bound(capa - liste_objet.get(i).getWeight(), valeur + liste_objet.get(i).getWeight(), i + 1);
                }
            }
            branch_bound(capa,valeur,i+1);
        }
    }

    public float optimum  (float capRestante,ArrayList<Objet> liste_objet, float valeur, int i){
        float poidsSac = capacite - capRestante;
        float optimum = valeur;
        for(;i<taille;++i){
            Objet objet = liste_objet.get(i);
            if(poidsSac + objet.getWeight()<= capacite){
                poidsSac += objet.getWeight();
                optimum += objet.getValue();
            }else{
                float poidrestant = capacite - poidsSac;
                optimum += poidrestant * objet.getRatio();
                break;
            }
        }
        return optimum;
    }

    public float getVmax() {
        return vmax;
    }

    public ArrayList<Objet> getSacMax() {
        return SacMax;
    }
}
