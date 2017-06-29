package br.edu.utfpr.gamescores.DAO;


import com.mongodb.MongoClient;
import javax.xml.transform.Source;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public  class DataBaseAccess {
    public static final String DB_NAME = "gamescores";
    public static  Morphia morphia = new Morphia();;
    public static  MongoClient mongo = new MongoClient();
    public static Datastore datastore =  morphia.createDatastore(mongo,DB_NAME);
    
}
