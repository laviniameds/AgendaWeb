/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author lavinia
 */
public class Agenda {
    private ArrayList<Contato> contatos;
    
    public Agenda(){
        contatos = new ArrayList<Contato>();
    }
    
    public ArrayList<Contato> getAgenda(){
        return contatos;
    }
    
    public void inserirContato(Contato c) throws Exception{
        for(Contato cont: contatos){
            if(cont.getNome().equalsIgnoreCase(c.getNome()))
                throw new Exception("Contato ja existe!");
            else{
                contatos.add(c);
            } 
        }
    }
    
    public void editarContato(Contato c) throws Exception{
        for(Contato cont: contatos){
            if(cont.getNome().equalsIgnoreCase(c.getNome())){
                contatos.add(c);
                contatos.remove(cont);
            }              
            else
                throw new Exception("Contato não encontrado!");
        }    
    }
    
    public void removerContato(Contato c) throws Exception{
        for(Contato cont: contatos){
            if(cont.getNome().equalsIgnoreCase(c.getNome()))
                contatos.remove(cont);
            else
                throw new Exception("Contato não encontrado!");
        }    
    }
}
