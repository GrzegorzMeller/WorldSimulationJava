/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polab;

/**
 *
 * @author grzes
 */public class Guarana extends Plant{
     Guarana(World w){
        super(w);
        force=0;
        initiative =0;
        position_x=0;
        position_y=0;
        type = "GUARANA";
        color="black";
    }
     
     @Override
    protected boolean kolizja(String a, int force_a, String b, int force_b){
        if (!"GUARANA".equals(a))
	{
		w.addForce(a, position_x, position_y);
	}
	else
	{
		w.addForce(b, position_x, position_y);
	}
	
        return true; 
    }
    
 }