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
public class Fox extends Animal {
    Fox(World w){
        super(w);
        force=3;
        initiative =7;
        position_x=0;
        position_y=0;
        type = "FOX";
        color="red";
    }
    private int savePosX;
    private int savePosY;
    @Override
    protected void akcja(){
        savePosX = position_x;
        savePosY = position_y;
        randNewPosition();
        while(w.CheckOrganismForceOnPosition(savePosY,savePosX)>force){ 
            savePosX=position_x;
            savePosY=position_y;
            randNewPosition();
        }
        position_x=savePosX;
        position_y=savePosY;
        
    }
    
    protected void randNewPosition(){
          Random generator = new Random();
	int randNewPosition;
	randNewPosition =generator.nextInt(8);
	switch (randNewPosition)
	{
	case 0:
		savePosY--;
		savePosX--;
		break;

	case 1:
		savePosY--;
		break;

	case 2:
		savePosY--;
		savePosX++;
		break;

	case 3:
		savePosX++;
		break;

	case 4:
		savePosY++;
		savePosX++;
		break;

	case 5:
		savePosY++;
		break;

	case 6:
		savePosY++;
		savePosX--;
		break;

	case 7:
		savePosX--;
		break;
	}
    }
    
}
