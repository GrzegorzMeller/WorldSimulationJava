/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polab;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grzes
 */
public class Human extends Animal{
     Human(World w){
        super(w);
        force=5;
        initiative =4;
        position_x=0;
        position_y=0;
        type = "HUMAN";
        color="blue";
        activate_skill=false;
        count_rounds= false;
        count_extra_rounds=0;
        count_skill_time=0;
    }
    
   
    boolean count_rounds;
    @Override
    protected void akcja(){
         if(count_rounds){
             count_extra_rounds++;
         }
         if(count_extra_rounds>=5){
             w.stopSkill();
             count_extra_rounds=0;
             count_rounds = false;
         }
         if(w.getKey()==38){
             position_y--;
         }
         if(w.getKey()==40){
             position_y++;
         }
         if(w.getKey()==37){
             position_x--;
         }
         if(w.getKey()==39){
             position_x++;
         }
         if(activate_skill && count_skill_time<=5){
             count_skill_time++;
             int savePosX = position_x;
        int savePosY = position_y;
        savePosY--; savePosX--;
        String a = w.CheckOrganismTypeOnPosition(savePosY, savePosX); 
        if ( !"EMPTY".equals(a)) { 
            w.addOrganismToKill(a, savePosX, savePosY); 
        } savePosX++; savePosY++;
        savePosY--;
	String b= w.CheckOrganismTypeOnPosition(savePosY, savePosX); 
        if (!"EMPTY".equals(b)) { 
            w.addOrganismToKill(b, savePosX, savePosY); 
        } savePosY++;
        savePosY--; savePosX++;
	String c = w.CheckOrganismTypeOnPosition(savePosY, savePosX);  
        if (!"EMPTY".equals(c)) { 
            w.addOrganismToKill(c, savePosX, savePosY);
        } savePosX--; savePosY++;
        savePosX++;
	String d = w.CheckOrganismTypeOnPosition(savePosY, savePosX);  
        if (!"EMPTY".equals(d)) { 
            w.addOrganismToKill(d, savePosX, savePosY);
        } savePosX--;
        savePosY++;  savePosX++;
	String e = w.CheckOrganismTypeOnPosition(savePosY, savePosX);  
        if (!"EMPTY".equals(e)) { 
            w.addOrganismToKill(e, savePosX, savePosY);
        } savePosX--; savePosY--;
        savePosY++;
	String f = w.CheckOrganismTypeOnPosition(savePosY, savePosX); 
        if (!"EMPTY".equals(f)) { 
            w.addOrganismToKill(f, savePosX, savePosY); 
        } savePosY--;
        savePosY++; savePosX--;
	String g = w.CheckOrganismTypeOnPosition(savePosY, savePosX); 
        if (!"EMPTY".equals(g)) { 
            w.addOrganismToKill(g, savePosX, savePosY); 
        } savePosX++; savePosY--;
        savePosX--;
	String h = w.CheckOrganismTypeOnPosition(savePosY, savePosX);  
        if (!"EMPTY".equals(h)) { 
            w.addOrganismToKill(h, savePosX, savePosY); 
        } savePosX++;
         }
         if(count_skill_time>=5){
             activate_skill=false;
             count_skill_time=0;
             count_extra_rounds=0;
             count_rounds=true;
         }
    }
  
}
