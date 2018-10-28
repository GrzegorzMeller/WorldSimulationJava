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
public class Antelope extends Animal{
     Antelope(World w){
        super(w);
        force=4;
        initiative =4;
        position_x=0;
        position_y=0;
        type = "ANTELOPE";
        color="yellow";
    }
    private int savePosX;
    private int savePosY;
    @Override
    protected void akcja(){
        Random generator = new Random();
        int randNewPosition = generator.nextInt(8);
        switch (randNewPosition)
	{
	case 0:
		position_y-=2;
		position_x-=2;
		break;

	case 1:
		position_y-=2;
		break;

	case 2:
		position_y-=2;
		position_x+=2;
		break;

	case 3:
		position_x+=2;
		break;

	case 4:
		position_y+=2;
		position_x+=2;
		break;

	case 5:
		position_y+=2;
		break;

	case 6:
		position_y+=2;
		position_x-=2;
		break;

	case 7:
		position_x-=2;
		break;
	}
    }
    @Override
    protected boolean kolizja(String a, int force_a, String b, int force_b){
        Random generator = new Random();
        int shouldIMove = generator.nextInt(100);
        if(shouldIMove>50){
             savePosX = position_x;
             savePosY = position_y;
		randNewPosition();
                int checkPos=1;
                if(savePosY<w.height && savePosY>=0 && savePosX<w.width && savePosX>0){
                checkPos = w.CheckOrganismForceOnPosition(savePosY, savePosX);
                }
		while (checkPos !=0 )
		{
			savePosX = position_x;
			savePosY = position_y;
			randNewPosition();
                        if(savePosY<w.height && savePosY>=0 && savePosX<w.width && savePosX>0){
                            checkPos = w.CheckOrganismForceOnPosition(savePosY, savePosX);
                        }
		}
                position_x = savePosX;
                position_y = savePosY;
		return false;
	}
		return true;
    }
    
    protected void randNewPosition(){
        Random generator = new Random();
        int randNewPosition = generator.nextInt(8);
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
    

