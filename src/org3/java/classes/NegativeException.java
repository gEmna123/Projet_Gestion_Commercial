/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org3.java.classes;


class NegativeException extends Exception {
    public NegativeException(String str){
        super(str);
        
    }

    @Override
    public String toString() {
        return "erreur de saisie :";
    }
    
}
