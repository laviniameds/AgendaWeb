/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Contato;

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
    
    public Contato buscarContato(String nome){
        for(Contato cont: contatos){
            if(cont.getNome().equalsIgnoreCase(nome)){
                return cont;
            }     
        }
        return null;
    }
    
    public void inserirContato(Contato c){
        contatos.add(c);      
    }
    
    public void editarContato(Contato c){
        Contato cont = buscarContato(c.getNome());
        if(cont != null){
            contatos.add(c);
            contatos.remove(cont);
        }              
         
    }
    
    public void removerContato(Contato c) throws Exception{
        Contato cont = buscarContato(c.getNome());
        if(c != null){
            contatos.remove(cont);
        }              
        else
            throw new Exception("Contato não encontrado!");  
    }
}
