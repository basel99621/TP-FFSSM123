/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;

public class Licence {

    public Personne possesseur;

    public String numero;

    public LocalDate delivrance;

    public Club club;
    public int niveau;

    public Licence(Personne possesseur, String numero, LocalDate delivrance,int niveau, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.club = club;
        this.niveau=niveau;
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getClub() {
        return club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * Une licence est valide pendant un an à compter de sa date de délivrance
     *
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(LocalDate d) {
        // Si la licence n'a pas encore été délivrée à la date d, retourne false
        if (d.compareTo(delivrance) < 0)
            return false;
        // expiry = date de fin de validité de la licence
        LocalDate expiry = delivrance.plusYears(1);
        // Retourne true si la date d est antérieure la date de fin de validité de la licence, false sinon.
        return d.compareTo(expiry) < 0;
    }
}
