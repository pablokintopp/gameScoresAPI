/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.gamescores.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.*;
import org.mongodb.morphia.annotations.*;

/**
 *
 * @author Pablo
 */
@Entity(value = "score", noClassnameStored = true)
@Embedded(value = "score")
public class Score  implements Serializable { 
    @Id
    private ObjectId id;
    private int score;
    private String date;

    public Score(int score, String date) {
        this.score = score;
        this.date = date;
    }

    public Score() {
    }

    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Score{" + "score=" + score + ", date=" + date + '}';
    }
    
    
    
    
}




