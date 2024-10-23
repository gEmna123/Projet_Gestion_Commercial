
package org3.java.classes;


public class Client extends Personne {
    private double chiffreAffaire;

    public Client(String nom, String adresse ,double chiffreAffaire)throws NegativeException {
        super(nom, adresse);
        if(this.chiffreAffaire<0)
        {
            throw new NegativeException("chiffre d'affaire erroné");
        }
      
        this.chiffreAffaire = chiffreAffaire;
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(double chiffreAffaire)throws NegativeException {
           if(this.chiffreAffaire<0)
        {
            throw new NegativeException("chiffre d'affaire erroné");
        }
        this.chiffreAffaire =chiffreAffaire;
    }

    @Override
    public String toString() {
        return super.toString() +"\nchiffre d'affaires ="+this.chiffreAffaire;
        
    }
     
    
    
}
