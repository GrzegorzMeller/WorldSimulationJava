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
public class Turtle extends Animal {
    Turtle(World w){
        super(w);
        force=2;
        initiative =1;
        position_x=0;
        position_y=0;
        type = "TURTLE";
        color="green";
    }
    
    @Override
    protected void akcja(){
        int shouldIMove;
        Random generator = new Random();
        shouldIMove =generator.nextInt(100);
        if (shouldIMove > 75)
        {
            int randNewPosition;
            randNewPosition = generator.nextInt(8);
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
  }
    @Override
    protected boolean kolizja(String a, int force_a, String b, int force_b){
	if (!"TURTLE".equals(a))
	{
		if (force_a >5)
		{
			return false;
		}
	}
	else
	{
		if (force_b > 5)
		{
			return false;
		}
	}
	return true;
}
}
