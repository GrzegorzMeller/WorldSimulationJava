/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polab;

/**
 *
 * @author grzes
 */
public class Blueberries extends Plant {
    Blueberries(World w){
        super(w);
        force=99;
        initiative =0;
        position_x=0;
        position_y=0;
        type = "BLUEBERRIES";
        color="cyan";
    }
     
     @Override
    protected boolean kolizja(String a, int force_a, String b, int force_b){
        if (!"BLUEBERRIES".equals(a))
	{
		w.addOrganismToKill(a, position_x, position_y);
	}
	else
	{
		w.addOrganismToKill(b, position_x, position_y);
	}
	
        return false; 
    }
}
