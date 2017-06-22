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

@Entity(value = "person",noClassnameStored = true)
public class Person {
    @Id
    private ObjectId id;
    private String name;
    private String email;
    private String password;
    private List<Score>scores;

    public Person() {
    }

    public Person(String name, String email, String password, List<Score> scores) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.scores = scores;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
    
    
}
