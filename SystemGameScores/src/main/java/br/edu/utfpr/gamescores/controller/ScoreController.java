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
import br.edu.utfpr.gamescores.DAO.ScoreDAO;
import br.edu.utfpr.gamescores.model.Score;
import javax.inject.Inject;

/**
 *
 * @author Pablo
 */
@Controller
@Path("/api/score")
public class ScoreController {
    
    @Inject
    private ScoreDAO scoreDAO;
    
    @Inject
    private Result result;
    
    @Get(value = {"","/"})
    public void list(){    
       result.use(Results.json()).withoutRoot().from(scoreDAO.findAll()).serialize();
    }
    
    //@Logado
    @Get("{id}")
    public void get(String id){
        result.use(Results.json()).withoutRoot().from(scoreDAO.findById(id)).serialize();
    }
    
    //@Logado
    @Consumes(value = "application/json")
    @Post(value = {"","/"})
    public void save(Score p){
        
        try {
            scoreDAO.create(p);
            result.use(Results.json()).withoutRoot().from(p).serialize();
        } catch (Exception e) {
            e.printStackTrace();
            result.notFound();
        }
        
        
    }
    //@Logado
    @Put
    @Consumes(value = "application/json")
    public void update(Score g){
        if(g.getId()!= null)
            scoreDAO.update(g);
    }
    
    //@Logado
    @Delete("{id}")
    public void delete(String id){       
        scoreDAO.remove(scoreDAO.findById(id));      
        result.nothing();
        
    }
    
}
