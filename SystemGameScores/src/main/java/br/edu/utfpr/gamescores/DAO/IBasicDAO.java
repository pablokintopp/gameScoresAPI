/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.gamescores.DAO;

import br.edu.utfpr.gamescores.model.Person;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author 
 */
public interface IBasicDAO<T> {
    public List<T> findAll();
    
    //Procura por nome
    public List<T> findByName(String name);
    
    //Procura por ID 
    public T findById(String id);
    
    //Insere
   public void create(T o);
    
   //Atualiza
   public void update(T o);
   
   //Deleta
   public void remove(T o); 
    
}
