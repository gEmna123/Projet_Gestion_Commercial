
package org3.java.classes;

import java.util.*;

public class Commande {
    private int numero;
    private Date dateCommande;
    private Client client;
    private static int count;
    
    public Commande(Client client){
        this.numero = ++count;
        this.dateCommande = new Date();
        this.client = client;
    }

    public int getNumero() {
        return numero;
    }

    

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return  "Commande N° " + numero + ", effectuée le " + dateCommande + ", par le client=" + client ;
    }
    
    
    
}