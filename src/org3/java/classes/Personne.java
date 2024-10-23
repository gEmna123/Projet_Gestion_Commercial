
package org3.java.classes;


public abstract class Personne {
    private int id;
    private String nom;
    private String adresse;
    private static int count;

    public Personne( String nom, String adresse) {
        if(nom.isEmpty()||nom==null)
        {
            throw new IllegalArgumentException("le nom est erroné");
        }
        if(adresse.isEmpty()||adresse==null)
        {
            throw new IllegalArgumentException("l'adresse est erroné");
        }
        this.id = ++count;
        this.nom = nom;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if(nom.isEmpty()||nom==null)
        {
            throw new IllegalArgumentException("le nom est erroné");
        }
        this.nom = nom;
    }

    public String getAdresse() {
        
        return adresse;
    }

    public void setAdresse(String adresse) {
         if(adresse.isEmpty()||adresse==null)
        {
            throw new IllegalArgumentException("l'adresse est erroné");
        }
        this.adresse = adresse;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":\nid=" + id + "\nnom=" + nom + "\nadresse=" + adresse ;
    }

    
    
    
    
}
