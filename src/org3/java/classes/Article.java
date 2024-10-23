
package org3.java.classes;

public class Article {
    private String reference;
    private String designation;
    private double prix;
    private int quantiteStock;
    private static int count;

    public Article(String designation, double prix, int quantiteStock) throws NegativeException{
        if(designation.isEmpty()||designation==null)
        {
            throw new IllegalArgumentException("la designation de produit est erroné");
        }
        
        
        if(prix<=0) throw new NegativeException("Le prix est invalid");
        if(quantiteStock<0) throw new NegativeException("La quantité est invalide");
        this.reference = "Ref" + (++count);
        this.designation = designation;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
    }

    public String getReference() {
        return reference;
    }

    

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        if(designation.isEmpty()||designation==null)
        {
            throw new IllegalArgumentException("la designation de produit est erroné");
        }
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) throws NegativeException{
        if(prix<=0) throw new NegativeException("Le prix est invalid");
        this.prix = prix;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) throws NegativeException{
        if(quantiteStock<0) throw new NegativeException("La quantité est invalide");
        this.quantiteStock = quantiteStock;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "reference=" + reference + ", designation=" + designation + ", prix=" + prix + ", quantiteStock=" + quantiteStock ;
    }

    
    
    
    
}
