/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scc;

import java.io.Serializable;

/**
 *
 * @author raren
 */
public final class Student extends User implements Serializable {
    
    private int level;
    private double grade;
    private double points;
    private int banannaStickers;
    
    
    public Student(){
         username = "";
         password = "";
         firstname = "";
         middlename="";
         lastname="";
         level = 0;
         grade = -1;
         points = 0.0;
         banannaStickers = 0;
    }
    
    
    
    public void setLevel(int level){
        this.level = level;
    }
    
    public void setGrade(double grade){
        this.grade = grade;
    }
    
    public void setPoints(double points){
        this.points = points;
    }
    
    public void setBanannaStickers(int stickers){
        banannaStickers = stickers;
    }
    
    public int getLevel(){
        return level;
    }
    
    public double getGrade(){
        return grade;
    }
    
    public double getPoints(){
        return points;
    }
    
    public double getBanannaStickers(){
        return banannaStickers;
    }
    
    public void subtractPoints(double pointsToSubtract){
        points = points - pointsToSubtract;
    }
    
    public void addPoints(double pointsToAdd){
        points = points + pointsToAdd;
    }
    
    public void subtractBanannaStickers(int stickersToSubtract){
        banannaStickers = banannaStickers - stickersToSubtract;
    }
    
    public void addBanannaStickers(int stickersToAdd) {
        banannaStickers = banannaStickers + stickersToAdd;
    }
    
}
