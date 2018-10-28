/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polab;

import java.util.Random;

/**
 *
 * @author grzes
 */
public class Sosnowsky extends Plant{
     Sosnowsky(World w){
        super(w);
        force=10;
        initiative =0;
        position_x=0;
        position_y=0;
        type = "SOSNOWSKY";
        color="magenta";
    }
     
      @Override
    protected boolean kolizja(String a, int force_a, String b, int force_b){
        if (!"SOSNOWSKY".equals(a))
	{
		w.addOrganismToKill(a, position_x, position_y);
	}
	else
	{
		w.addOrganismToKill(b, position_x, position_y);
	}
	
        return false; 
    }
    
    @Override
    protected void akcja(){
        int savePosX = position_x;
        int savePosY = position_y;
        savePosY--; savePosX--;
        String a = w.CheckOrganismTypeOnPosition(savePosY, savePosX); 
        if (isAnimal(a)) { 
            w.addOrganismToKill(a, savePosX, savePosY); 
        } savePosX++; savePosY++;
        savePosY--;
	String b= w.CheckOrganismTypeOnPosition(savePosY, savePosX); 
        if (isAnimal(b)) { 
            w.addOrganismToKill(b, savePosX, savePosY); 
        } savePosY++;
        savePosY--; savePosX++;
	String c = w.CheckOrganismTypeOnPosition(savePosY, savePosX);  
        if (isAnimal(c)) { 
            w.addOrganismToKill(c, savePosX, savePosY);
        } savePosX--; savePosY++;
        savePosX++;
	String d = w.CheckOrganismTypeOnPosition(savePosY, savePosX);  
        if (isAnimal(d)) { 
            w.addOrganismToKill(d, savePosX, savePosY);
        } savePosX--;
        savePosY++;  savePosX++;
	String e = w.CheckOrganismTypeOnPosition(savePosY, savePosX);  
        if (isAnimal(e)) { 
            w.addOrganismToKill(e, savePosX, savePosY);
        } savePosX--; savePosY--;
        savePosY++;
	String f = w.CheckOrganismTypeOnPosition(savePosY, savePosX); 
        if (isAnimal(f)) { 
            w.addOrganismToKill(f, savePosX, savePosY); 
        } savePosY--;
        savePosY++; savePosX--;
	String g = w.CheckOrganismTypeOnPosition(savePosY, savePosX); 
        if (isAnimal(g)) { 
            w.addOrganismToKill(g, savePosX, savePosY); 
        } savePosX++; savePosY--;
        savePosX--;
	String h = w.CheckOrganismTypeOnPosition(savePosY, savePosX);  
        if (isAnimal(h)) { 
            w.addOrganismToKill(h, savePosX, savePosY); 
        } savePosX++;
        
         Random generator = new Random();
	int randNewPosition;
	randNewPosition =generator.nextInt(100);
        if(randNewPosition>=96){
            int x = position_x;
            int y = position_y;
            randNewPosition=generator.nextInt(8);
            switch (randNewPosition)
	{
	case 0:
		y--;
		x--;
		break;

	case 1:
		y--;
		break;

	case 2:
		y--;
		x++;
		break;

	case 3:
		x++;
		break;

	case 4:
		y++;
		x++;
		break;

	case 5:
		y++;
		break;

	case 6:
		y++;
		x--;
		break;

	case 7:
		x--;
		break;
	}
             if(x>=0&&x<20&&y>=0&&y<20){
                     Sosnowsky sosnowsky = new Sosnowsky(w);
                     sosnowsky.position_x=x;
                     sosnowsky.position_y=y;
                     Plant bx = sosnowsky;
                     Organism o = bx; 
                     w.rozmnazanie(o);
             }
    }
        }
    
    private boolean isAnimal(String animal){
        
	if (!"SOSNOWSKY".equals(animal)&&!"BLUEBERRIES".equals(animal)&&!"GUARANA".equals(animal)&&!"GRASS".equals(animal)&&!"EMPTY".equals(animal)) //add also snow thistle
	{
		return true;
	}
	return false;
    }
     
}
