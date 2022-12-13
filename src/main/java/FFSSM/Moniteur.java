/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public List<Embauche> myEmplois = new ArrayList<>();
    public int numeroDiplome;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, GroupeSanguin groupeSanguin, int niveau,int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, groupeSanguin, niveau);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        Optional<Club> opt;
        if (!myEmplois.isEmpty() && !myEmplois.get(myEmplois.size()-1).estTerminee()){
            Club c = myEmplois.get(myEmplois.size()-1).getEmployeur();
            opt = Optional.ofNullable(c);
        }
        else
        {
            Club c = null;
            opt=Optional.ofNullable(c);
        }
        return opt;
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
         Embauche e = new Embauche(debutNouvelle, this, employeur);
         terminerEmbauche(debutNouvelle);
         myEmplois.add(e);
    }
    public void terminerEmbauche(LocalDate dateFin){
        if (!myEmplois.isEmpty() && !myEmplois.get(myEmplois.size()-1).estTerminee())
            myEmplois.get(myEmplois.size()-1).terminer(dateFin);
    }

    public List<Embauche> emplois() {
     return myEmplois;
    }

}
