/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scc;

import BaseClasses.Assessment;
import java.io.Serializable;

/**
 *
 * @author raren
 */
public class InitialAssessmentTest extends Assessment implements Serializable {
    
    public InitialAssessmentTest(){
        super(); //calls so that it calls the Assessment constructor, saving itme on  lots of dupulicate work
    }
}
