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
import br.edu.utfpr.gamescores.DAO.PersonDAO;
import br.edu.utfpr.gamescores.DAO.ScoreDAO;
import br.edu.utfpr.gamescores.model.Game;
import br.edu.utfpr.gamescores.model.Person;
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
    private PersonDAO personDAO;
    
    @Inject
    private GameDAO gameDAO;
    
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
    @Post(value = {"/{idGame}/{idPlayer}","/{idGame}/{idPlayer}/"})
    public void save(Score p,String idGame, String idPlayer){
        //System.out.println("Score POST: "+p.toString());
        try {
            scoreDAO.create(p);
            Person player = personDAO.findById(idPlayer);
            Game game = gameDAO.findById(idGame);
            player.getScores().add(p);
            personDAO.update(player);
            if(!game.getPlayers().contains(player)){
                game.getPlayers().add(player);
                gameDAO.update(game);
            }
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
