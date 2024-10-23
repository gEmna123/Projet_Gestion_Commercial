
package org3.java.classes;

import java.io.IOException;
import java.util.Scanner;

public class Test {
public static void clearScreen() {
//effacer ecran
try {
new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} 
catch (IOException | InterruptedException e) {}
}    
public static void main(String[] args) {
int type;
//Document myd = null;
Scanner scanner = new Scanner(System.in);
String id, code;
//Nouvelle Librairie
System.out.print("nom commercial: ");
String nom = scanner.nextLine();
System.out.print("adresse commercial: ");
String adresse = scanner.nextLine();
Commercial cm= new Commercial(nom, adresse);
while (true) {
 clearScreen();
System.out.println("\n\t------------ Menu commercial: "+cm.getNom()+" ------------");
System.out.println("1-Nouveau Article");
System.out.println("2-Nouveau Client");
System.out.println("3-Nouvelle commande ");
System.out.println("4-Historique magasin");
System.out.println("5-suppression article");
System.out.println("6-suppression Client");
System.out.println("7-Commande client");
System.out.println("8-Annuler commande");
System.out.println("0-Quitter le programme");
System.out.print("Entrez votre choix (0-8): ");
int choix = scanner.nextInt();
System.out.println();
scanner.nextLine(); // Pour consommer la nouvelle ligne
switch (choix) {
case 1:

System.out.print("designation: ");
String ds= scanner.nextLine();      
System.out.print("prix: ");
double prix= scanner.nextDouble();
//scanner.nextLine();
System.out.print("Quantité Stock: ");
int qt= scanner.nextInt();
scanner.nextLine();
    try {
    Article a=new Article(ds,prix,qt);
    cm.ajouterArticle(a);
    System.out.println("artcile ajouté avec succées");
    } catch (NegativeException e) {
        System.out.println(e+e.getMessage());
    }
    /* il est unitile de faire une exception si l'article existe deja car 
    /sa refrences est generer d'une maniere automatique donc il est impossible
    /de trouver deux article de meme refernces*/
    break;
case 2:
System.out.print("nom: ");
String nomc = scanner.nextLine();
System.out.print("adresse: ");
String adres = scanner.nextLine();
System.out.print("chiffre d'affaires: ");
Double chiffre = scanner.nextDouble();
    try {
        Client cl=new Client(nomc,adres,chiffre);
        cm.ajouterClient(cl);
        System.out.println("Client ajouté avec succées");
    } catch (NegativeException e) {
        System.out.println(e+e.getMessage());
    } break;
    /* il est unitile de faire une exception si le client existe deja car 
    /son id est generer d'une maniere automatique donc il est impossible
    /de trouver deux client de meme id*/
case 3:
    System.out.print("ID client: ");
    int idc= scanner.nextInt();
    scanner.nextLine();
    try {
    cm.ajouterCommande(idc);}
   catch(ExceptionExistance e2){System.out.println(e2.getMessage());}
   
     break;
case 4:
    cm.afficheAll();
    break;
case 5:
    System.out.print("ref: ");
    String ref=scanner.nextLine();

    try {
        cm.effacerArticle(cm.rechercheByRef(ref));
    } catch (ExceptionExistance e) { System.out.println(e.getMessage());}
    catch(IntegriteException e2){System.out.println(e2.getMessage());}
    break;
case 6:
    System.out.print("id client : ");
    int  idcl=scanner.nextInt();
    try{
        cm.effacerClient(cm.rechercheById(idcl));
    }
    catch (IntegriteException e){
       System.out.println(e.getMessage());
    }
    catch (ExceptionExistance e2){
        System.out.println(e2.getMessage());     
    }
    scanner.nextLine();

    break;
case 7:
    System.out.print("id client : ");
    int  idclient=scanner.nextInt();
    scanner.nextLine();
    try{
        cm.selectionnerCommandeClient(cm.rechercheById(idclient));
    }   catch (ExceptionExistance e2){
        System.out.println(e2.getMessage());     }
    break;
case 8:
    System.out.print("numero commande : ");
    int num=scanner.nextInt();
    scanner.nextLine();
    try {
        cm.annulerCommande(cm.rechercheByNum(num));
    } catch (ExceptionExistance e) 
    {System.out.println(e.getMessage());}
    break;
case 0:
    System.out.println("Quitter le programme!");
    System.exit(0);
    break;
default:
System.out.println("Choix invalide. Veuillez reessayer.");
}    
scanner.nextLine();
}
}

}




