/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pablo.gamescores.model;

import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.*;
import org.mongodb.morphia.annotations.*;

/**
 *
 * @author Pablo
 */
@Entity(value = "game",noClassnameStored = true)
public class Game {
    @Id
    private ObjectId id;
    private String name;
    private String description;
    private Person admin;
    private List<Person> players;

    public Game(String name, String description, Person admin, List<Person> players) {
        this.name = name;
        this.description = description;
        this.admin = admin;
        this.players = players;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getAdmin() {
        return admin;
    }

    public void setAdmin(Person admin) {
        this.admin = admin;
    }

    public List<Person> getPlayers() {
        return players;
    }

    public void setPlayers(List<Person> players) {
        this.players = players;
    }
    
    
}
