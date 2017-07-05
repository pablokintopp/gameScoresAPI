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
import br.edu.utfpr.gamescores.DAO.GameDAO;
import br.edu.utfpr.gamescores.model.Game;
import br.edu.utfpr.gamescores.model.Person;
import br.edu.utfpr.gamescores.model.Score;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Pablo
 */
@Controller
@Path("/api/game")
public class GameController {
    @Inject
    private GameDAO gameDAO;
    
    @Inject
    private Result result;
    
    @Get(value = {"","/"})
    public void list(){    
       result.use(Results.json()).withoutRoot().from(gameDAO.findAll()).serialize();
    }
    
    //@Logado
    @Get("{id}")
    public void get(String id){
        result.use(Results.json()).withoutRoot().from(gameDAO.findById(id)).serialize();
    }
    
    @Get(value = {"{id}/scores","{id}/scores/"})
    public void getScores(String id){
        List<Person> players = gameDAO.findById(id).getPlayers();
        ArrayList<Score> scores = new ArrayList<Score>();
        for(Person p : players)
            scores.addAll(p.getScores());
        
        result.use(Results.json()).withoutRoot().from(scores).serialize();
    }
    
    //@Logado
    @Consumes(value = "application/json")
    @Post(value = {"","/"})
    public void save(Game g){
        
        try {
            gameDAO.create(g);
            result.use(Results.json()).withoutRoot().from(g).serialize();
        } catch (Exception e) {
            e.printStackTrace();
            result.notFound();
        }
        
        
    }
    //@Logado
    @Put
    @Consumes(value = "application/json")
    public void update(Game g){
        if(g.getId()!= null)
            gameDAO.update(g);
    }
    
    //@Logado
    @Delete("{id}")
    public void delete(String id){       
        gameDAO.remove(gameDAO.findById(id));      
        result.nothing();
        
    }
    
}
