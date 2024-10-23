
package org3.java.classes;

import java.util.*;

public class Commercial {
    private String nom;
    private String adr;
    private List<Client> clients;
    private List<Article> articles;
    private List<Commande> commandes;
    private List<Ligne> lignesCommande;

    public Commercial(String nom, String adr) {
        this.nom = nom;
        this.adr = adr;
        this.clients = new ArrayList<>();
        this.articles = new ArrayList<>();
        this.commandes = new ArrayList<>();
        this.lignesCommande = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<Ligne> getLignesCommande() {
        return lignesCommande;
    }

    public void setLignesCommande(List<Ligne> lignesCommande) {
        this.lignesCommande = lignesCommande;
    }
    
    
    public void afficheAll(){
        System.out.println("nom: "+nom+"adresse: "+adr);
        if (articles.isEmpty()) System.out.println("la liste des articles est vide");
        else{
        System.out.println(">>>liste des articles");
        for (Article a : articles){
            System.out.println(a);}
        }
        if (clients.isEmpty()) System.out.println("la liste des clients est vide");
        else{
        System.out.println(">>>liste des clients");
        for(Client c: clients){
            System.out.println(c); }
        }
        if (commandes.isEmpty()) System.out.println("la liste des commandes est vide");
        else{
        System.out.println(">>>Liste des commandes");
        for(Commande c: commandes){
            System.out.println(c);
             System.out.println(">>>liste des Lignes de cette commandes");
            for(Ligne l: lignesCommande){
                if(l.getCmd().equals(c))
                System.out.println(l);}
            }
        }
        
       
    }
    
    public Client rechercheById(int id){
        for(Client c: clients){
            if(c.getId()==id){
            return c;
        }
        }
       
        return null;
    }
    
    public Article rechercheByRef(String ref){
        for(Article a: articles){
            if(a.getReference().equals(ref)){
                return a;
            }
        }
        return null;
    }
    
    public Commande rechercheByNum(int num){
        for(Commande c :commandes){
            if(c.getNumero()==num){
                return c;
            }
        }
        return null;
    }
    
    public void ajouterClient(Client c){
            clients.add(c);
    }
    
    public void ajouterArticle(Article a){
            articles.add(a);
    }
    
     private void ajouterLigneCommandes (Commande c)throws ExceptionExistance{
               System.out.println("ref article: ");
                Scanner clavier=new Scanner(System.in);
                String ref=clavier.nextLine();
                System.out.println("quantité: ");
                int qt = clavier.nextInt();
                clavier.nextLine();
            
                Article a = this.rechercheByRef(ref);
                if (a==null){
                    throw new ExceptionExistance("article non existant!!");
                }
                if (articles.get(articles.indexOf(a)).getQuantiteStock()<qt){
                     throw new ExceptionExistance("la quantité pour cet article est non disponible!!");
                }
                try{
                    Ligne l=new Ligne(a,qt);
                    l.setCmd(c);
                    this.lignesCommande.add(l);
                    System.out.println("ligne ajouté");
                }
                  catch(NegativeException e){
                    System.out.println(e.getMessage());
                }
      
    }
    public void ajouterCommande (int idc) throws ExceptionExistance {
        Client cli=this.rechercheById(idc);
        if(cli==null) throw new ExceptionExistance ("client non existant");
        Commande comn=new Commande(cli);
        
        Scanner clavier=new Scanner(System.in);
        commandes.add(comn);
        System.out.println("donner le nombre d'articles : ");
        int n=clavier.nextInt();
        for(int i=1;i<=n;i++){
       
            System.out.println("donner l' article N"+i );    
                this.ajouterLigneCommandes(comn);
        
         
        }
        System.out.println("commande effectuer avec succes");
  
   
        }

   
    
/*       public void supprimerLigne(Ligne l){
        if(!lignesCommande.contains(l)){
            System.out.println("Ligne n'existe pas pour la supprimer !");
        }else{
            lignesCommande.remove(l);
            System.out.println("Ligne de commande effacée avec succés ");
        }
    }*/
    
    public void effacerClient (Client c)throws ExceptionExistance,IntegriteException{
        if(c==null){
            throw new ExceptionExistance ("client non existant pour le suprimer");
        }
        for(Commande x: commandes){
            if(x.getClient().equals(c)){
                throw new IntegriteException("ce client a des commandes donc on ne peut pas le supprimer \n vous devez supprimer vos commandes");
            }
            
            clients.remove(c);
            System.out.println("Client effacer avec succés ");
             
        }
    }
            
        
    
    
    public void effacerArticle(Article a) throws ExceptionExistance,IntegriteException{
        if(a==null){
            throw new ExceptionExistance ("article non existant pour le suprimer");
        }
        for(Ligne l : this.lignesCommande){
            if (l.getArt().equals(a)){
                throw new IntegriteException("cet article existe dans une ou des commandes donc vous ne peuvez pas le supprimer ");
            }
        }
            articles.remove(a);
            System.out.println("Articles effacer avec succés");
        
    }
    
    public void selectionnerCommandeClient(Client c)throws ExceptionExistance{
        double t=0;
        boolean exist=false;
        if(c==null){
            throw new ExceptionExistance ("client non existant");
        }
        
        for(Commande x: commandes){
            if(x.getClient().equals(c)){
                exist=true;
                t=0;
                System.out.println(c);
                for(Ligne l: lignesCommande){
                    if(l.getCmd().equals(x)){
                        System.out.println(l);
                        t+=l.getArt().getPrix()*l.getQuantite();
                    }
                }
            System.out.println("total a payer: "+t+" Dt");    
            }  
            
        }
        if (!exist) System.out.println("ce client n'a pas effectué aucune commande"); 
        
    }
    
    public void annulerCommande(Commande c)throws ExceptionExistance{
        if(c==null){
            throw new ExceptionExistance ("Commande n'existe pas pour la suuprimer !");
        }
        
        for(Ligne l: lignesCommande){
            if(l.getCmd().equals(c)){
                lignesCommande.remove(l);
            }
        }
        commandes.remove(c);
    }
     
    public void afficherClients(){
        if (clients.isEmpty()) System.out.println("la liste des clients est vide");
        else{
        for(Client c: clients){
            System.out.println(c);
        }}
    }
    
    public void afficherCommandes(){
        
        if (commandes.isEmpty()) System.out.println("la liste des commandes est vide");
        else{
        for(Commande c: commandes){
            System.out.println(c);
        }
        }
    }
    public void afficherArticles(){
        System.out.println("nom: "+nom+"adresse: "+adr);
        if (articles.isEmpty()) System.out.println("la liste des articles est vide");
        else{
        for(Article a: articles){
            System.out.println(a);
        }
        }
        
    }
   public void afficherlignescommande(){
       if (this.lignesCommande.isEmpty()) System.out.println("la liste des ligne des commmnade est vide");
        else{
       for(Ligne l :lignesCommande){
           System.out.println(l);
       }
       }
       
   }
        
}
