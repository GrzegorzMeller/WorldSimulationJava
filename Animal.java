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
public abstract class Animal extends Organism {
    Animal(World w){
          super(w);
    }
    
    @Override
    protected void akcja() {
        
         Random generator = new Random();
	int randNewPosition;
	randNewPosition =generator.nextInt(8);
	switch (randNewPosition)
	{
	case 0:
		position_y--;
		position_x--;
		break;

	case 1:
		position_y--;
		break;

	case 2:
		position_y--;
		position_x++;
		break;

	case 3:
		position_x++;
		break;

	case 4:
		position_y++;
		position_x++;
		break;

	case 5:
		position_y++;
		break;

	case 6:
		position_y++;
		position_x--;
		break;

	case 7:
		position_x--;
		break;
	}
        
    }
    @Override
    protected boolean kolizja(String a, int force_a, String b, int force_b){
        if(a.equals(b)){
            return false;
        }
        
        return true; 
    }
    @Override
    protected void kolizja(String type, int aPositionX, int aPositionY, int bPositionX, int bPositionY){
        int y=0;
        int x=0;
        boolean posChagned=false;
         if(aPositionY==bPositionY){
            if(w.CheckOrganismForceOnPosition(aPositionY, aPositionX+1)==0&&aPositionX+1<20){
                y=aPositionY;
                x=aPositionX+1;
                posChagned=true;
            }
            else if(w.CheckOrganismForceOnPosition(aPositionY, aPositionX-1)==0 &&aPositionX-1>=0){
                y=aPositionY;
                x=aPositionX-1;
                posChagned=true;
            }
            else if(w.CheckOrganismForceOnPosition(bPositionY, bPositionX+1)==0 &&bPositionX+1<20){
                y=bPositionY;
                x=bPositionX+1;
                posChagned=true;
            }
            else if(w.CheckOrganismForceOnPosition(bPositionY, bPositionX-1)==0 &&bPositionX-1>=0){
                y=bPositionY;
                x=bPositionX-1;
                posChagned=true;
            }
        }
         else if(aPositionX==bPositionX){
              if(w.CheckOrganismForceOnPosition(aPositionY+1, aPositionX)==0&&aPositionY+1<20){
                y=aPositionY+1;
                x=aPositionX;
                posChagned=true;
            }
            else if(w.CheckOrganismForceOnPosition(aPositionY-1, aPositionX)==0 &&aPositionY-1>=0){
                y=aPositionY-1;
                x=aPositionX;
                posChagned=true;
            }
            else if(w.CheckOrganismForceOnPosition(bPositionY+1, bPositionX)==0&&bPositionY+1<20){
                y=bPositionY+1;
                x=bPositionX;
                posChagned=true;
            }
            else if(w.CheckOrganismForceOnPosition(bPositionY-1, bPositionX)==0 &&bPositionY-1>=0){
                y=bPositionY-1;
                x=bPositionX;
                posChagned=true;
            }
         }
         if(posChagned){
         if(type.equals("FOX")){
                   
                     Fox fox = new Fox(w);
                     fox.position_x=x;
                     fox.position_y=y;
                     Animal a = fox;
                     Organism o = a; 
                     w.rozmnazanie(o);
              
                 }
                  else if(type.equals("SHEEP")){
                     
                     Sheep sheep = new Sheep(w);
                     sheep.position_x=x;
                     sheep.position_y=y;
                     Animal a = sheep;
                     Organism o = a;
                     w.rozmnazanie(o);
                 }
                  else if(type.equals("ANTELOPE")){
                    
                     Antelope antelope = new Antelope(w);
                     antelope.position_x=x;
                     antelope.position_y=y;
                     Animal a = antelope;
                     Organism o = a;
                     w.rozmnazanie(o);
                    
                 }
                  else if(type.equals("TURTLE")){
                    
                     Turtle turtle = new Turtle(w);
                     turtle.position_x=x;
                     turtle.position_y=y;
                     Animal a = turtle;
                     Organism o = a;
                     w.rozmnazanie(o);
                 }
                  else if(type.equals("WOLF")){
                     
                     Wolf wolf = new Wolf(w);
                     wolf.position_x=x;
                     wolf.position_y=y;
                     Animal a = wolf;
                     Organism o = a;
                     w.rozmnazanie(o);
                  
                 }
    }
    }
}
