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
public class SowThistle extends Plant{
    SowThistle(World w){
        super(w);
        force=0;
        initiative =0;
        position_x=0;
        position_y=0;
        type = "SNOWTHISTLE";
        color="dark_gray";
    }
    
    @Override
    protected void akcja() {
        for(int i=0;i<3;++i){
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
                     SowThistle sowThistle = new SowThistle(w);
                     sowThistle.position_x=x;
                     sowThistle.position_y=y;
                     Plant a = sowThistle;
                     Organism o = a; 
                     w.rozmnazanie(o);
             }
             
        }
    }
    }
}
