/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.gamescores.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.edu.utfpr.gamescores.DAO.PersonDAO;
import br.edu.utfpr.gamescores.model.Person;
import java.util.List;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author Pablo
 */
@Controller
@Path("/api/person")
public class PersonController {

    @Inject
    private PersonDAO personDAO;
    
    @Inject
    private Result result;
    
    @Get(value = {"","/"})
    public void list(){    
       result.use(Results.json()).withoutRoot().from(personDAO.findAll()).serialize();
    }
    
    //@Logado
    @Get("{id}")
    public void get(String id){
        result.use(Results.json()).withoutRoot().from(personDAO.findById(id)).serialize();
    }
    
    //@Logado
    @Consumes(value = "application/json")
    @Post(value = {"","/"})
    public void save(Person p){
        
        try {
            personDAO.create(p);
            result.use(Results.json()).withoutRoot().from(p).serialize();
        } catch (Exception e) {
            e.printStackTrace();
            result.notFound();
        }
        
        
    }
    //@Logado
    @Put
    @Consumes(value = "application/json")
    public void update(Person g){
        if(g.getId()!= null)
            personDAO.update(g);
    }
    
    //@Logado
    @Delete("{id}")
    public void delete(String id){       
        personDAO.remove(personDAO.findById(id));      
        result.nothing();
        
    }
}
