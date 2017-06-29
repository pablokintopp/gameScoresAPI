/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.gamescores.DAO;

import br.edu.utfpr.gamescores.model.Person;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author Pablo
 */
@RequestScoped
public class PersonDAO implements IBasicDAO<Person>{
    

    
     //Lista todos
   
    public List<Person> findAll() {
      return  DataBaseAccess.datastore.find(Person.class).asList();
   }
    
    //Procura por nome
    public List<Person> findByName(String name) {
      return  DataBaseAccess.datastore.find(Person.class).filter("name = ", name).order("name").asList();
   }
    
    //Procura por ID 
    public Person findById(String id) {
        ObjectId objectId = new ObjectId(id);
      return  DataBaseAccess.datastore.get(Person.class,objectId);
   }
    
    //Insere
   public void create(Person p){
        DataBaseAccess.datastore.save(p);
   } 
    
   //Atualiza
   public void update(Person p){
        DataBaseAccess.datastore.merge(p);
   } 
   
   //Deleta
   public void remove(Person p){
        DataBaseAccess.datastore.delete(p);
   } 
    
}
