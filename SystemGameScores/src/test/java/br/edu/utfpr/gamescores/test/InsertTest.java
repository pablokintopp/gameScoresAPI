/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.gamescores.test;

import br.edu.utfpr.gamescores.model.Game;
import br.edu.utfpr.gamescores.model.Person;
import br.edu.utfpr.gamescores.model.Score;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author Pablo
 */

public class InsertTest {
    private static Morphia morphia;
    private static MongoClient mongo;
    private static Datastore datastore;
    
    @BeforeClass
    public static void setupClass(){
        morphia = new Morphia();
        mongo = new MongoClient();
        datastore = morphia.createDatastore(mongo,"gamescores");
        
        
    }
    @AfterClass
    public static void tearDownClass(){
    
        mongo.close();
        
    }
    @Test
    public void insert(){
        ArrayList<Score> scoresTest = new ArrayList<Score>();
        ArrayList<Score> scoresTest2 = new ArrayList<Score>();
        ArrayList<Score> scoresTest3 = new ArrayList<Score>();
        scoresTest.add(new Score(1400, new Date()));
        scoresTest.add(new Score(1400, new Date()));
        scoresTest.add(new Score(1400, new Date()));
        scoresTest.add(new Score(1400, new Date(2015,01,15)));
        scoresTest.add(new Score(1400, new Date(2016,02,05)));
        scoresTest2.add(new Score(1400, new Date(2017,03,05)));
        scoresTest2.add(new Score(1400, new Date(2017,04,05)));
        scoresTest2.add(new Score(1400, new Date(2017,05,15)));
        scoresTest2.add(new Score(1400, new Date(2017,06,05)));
        scoresTest3.add(new Score(1400, new Date(2017,07,25)));
        scoresTest3.add(new Score(1400, new Date(2016,07,25)));
        scoresTest3.add(new Score(1400, new Date(2016,05,25)));
        scoresTest3.add(new Score(1400, new Date(2016,05,25)));
        
        Person p1 = new Person("Tiburcio dos santos", "tiburcio@email.com", "tititata", scoresTest);
        Person p2 = new Person("Fulano da silva", "fu@email.com", "fafu", scoresTest2);
        Person p3 = new Person("Pedrosa pedregulha", "pedra@email.com", "pepa", scoresTest3);
        
        
        Game g1 = new Game("Super Mario online", "Super mario versao online com rankeamneto de jogadores bla bla", p1, Arrays.asList(p1,p2,p3));
        
        datastore.save(p1);
        datastore.save(p2);
        datastore.save(p3);
        datastore.save(g1);

//    
//        datastore.save(p1);
//        datastore.save(p2);
//        datastore.save(p3);
//        
//        datastore.save(a1);
        
    }
}
