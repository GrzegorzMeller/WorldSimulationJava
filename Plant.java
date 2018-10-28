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
public abstract class Plant extends Organism {
     Plant(World w){
          super(w);
    }
     
     @Override
    protected void akcja() {
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
             if(type.equals("GRASS")){
                     Grass grass = new Grass(w);
                     grass.position_x=x;
                     grass.position_y=y;
                     Plant a = grass;
                     Organism o = a; 
                     w.rozmnazanie(o);
                 }
             else  if(type.equals("GUARANA")){
                   
                     Guarana guarana = new Guarana(w);
                     guarana.position_x=x;
                     guarana.position_y=y;
                     Plant a = guarana;
                     Organism o = a; 
                     w.rozmnazanie(o);
                 }
             else  if(type.equals("BLUEBERRIES")){
                   
                     Blueberries blueberries = new Blueberries(w);
                     blueberries.position_x=x;
                     blueberries.position_y=y;
                     Plant a = blueberries;
                     Organism o = a; 
                     w.rozmnazanie(o);
              
                 }
             else  if(type.equals("SOSNOWSKY")){
                   
                     Sosnowsky sosnowsky = new Sosnowsky(w);
                     sosnowsky.position_x=x;
                     sosnowsky.position_y=y;
                     Plant a = sosnowsky;
                     Organism o = a; 
                     w.rozmnazanie(o);
              
                 }
        }}
    }
     
      @Override
    protected boolean kolizja(String a, int force_a, String b, int force_b){
        return true; 
    }
}
