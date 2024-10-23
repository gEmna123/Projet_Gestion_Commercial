
package org3.java.classes;

public class Ligne {
    private Commande cmd;
    private Article art;
    private int quantite;

    public Ligne(Article art, int quantite)throws NegativeException{
        //exception si l'article n'existe pas 
       // if(rechercheByRef(art.getReference())==null )
        if(quantite<0) throw new NegativeException("La quantité est invalide");
        this.art = art;
        this.quantite = quantite;
    }

    public Commande getCmd() {
        return cmd;
    }

    public void setCmd(Commande cmd) {
        this.cmd = cmd;
    }

    public Article getArt() {
        return art;
    }

    public void setArt(Article art) {
        this.art = art;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite)throws NegativeException{
        if(quantite<0) throw new NegativeException("La quantité est invalide");
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Ligne{" + "cmd=" + cmd + ", art=" + art + ", quantite=" + quantite + '}';
    }
    
    
    
    
    
    
    
    
}


