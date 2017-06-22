/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pablo.gamescores.model;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.*;
import org.mongodb.morphia.annotations.*;

/**
 *
 * @author Pablo
 */
@Embedded(value = "score")
public class Score {    
    private int score;
    private Date date;

    public Score(int score, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}




