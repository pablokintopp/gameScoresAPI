/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.gamescores.DAO;

import br.edu.utfpr.gamescores.model.Score;
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
public class ScoreDAO implements IBasicDAO<Score>{
    
      
     //Lista todos
    public List<Score> findAll() {
      return  DataBaseAccess.datastore.find(Score.class).asList();
   }
      
    
    //Procura por ID 
    public Score findById(String id) {
        ObjectId objectId = new ObjectId(id);
      return  DataBaseAccess.datastore.get(Score.class,objectId);
   }
    
    //Insere
   public void create(Score s){
        DataBaseAccess.datastore.save(s);
   } 
    
   //Atualiza
   public void update(Score s){
        DataBaseAccess.datastore.merge(s);
   } 
   
   //Deleta
   public void remove(Score s){
        DataBaseAccess.datastore.delete(s);
   } 

    @Override
    public List<Score> findByName(String name) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
    
}
