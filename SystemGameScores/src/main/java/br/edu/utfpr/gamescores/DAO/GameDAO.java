/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.gamescores.DAO;

import br.edu.utfpr.gamescores.model.Game;
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
public class GameDAO  implements IBasicDAO<Game>{   
    
  
    
    //Lista todos
    public List<Game> findAll() {
      return  DataBaseAccess.datastore.find(Game.class).asList();
   }
    
    //Procura por nome
    public List<Game> findByName(String name) {
      return  DataBaseAccess.datastore.find(Game.class).filter("name = ", name).order("name").asList();
   }
    
    //Procura por ID 
    public Game findById(String id) {
        ObjectId objectId = new ObjectId(id);
      return  DataBaseAccess.datastore.get(Game.class,objectId);
   }
    
    //Insere
   public void create(Game game){
        DataBaseAccess.datastore.save(game);
   } 
    
   //Atualiza
   public void update(Game game){
        DataBaseAccess.datastore.merge(game);
   } 
   
   //Deleta
   public void remove(Game game){
        DataBaseAccess.datastore.delete(game);
   } 
    
   
    
}
