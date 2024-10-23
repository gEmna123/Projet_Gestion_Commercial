
package org3.java.classes;


public class Fournisseur extends Personne{
    private String specialite;

    public Fournisseur(String nom, String adresse, String specialite) {
        super(nom, adresse);
        if(specialite.isEmpty()||specialite==null)
        {
            throw new IllegalArgumentException("la spécialité est erroné");
        }
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        if(specialite.isEmpty()||specialite==null)
        {
            throw new IllegalArgumentException("la spécialité est erroné");
        }
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return super.toString()+"\nspecialite = "+this.specialite;
    }
    
    

  
    
}
