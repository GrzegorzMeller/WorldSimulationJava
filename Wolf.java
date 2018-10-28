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
public class Wolf extends Animal {
    
    Wolf(World w){
        super(w);
        force=9;
        initiative =5;
        position_x=0;
        position_y=0;
        type = "WOLF";
        color="pink";
    }
}
