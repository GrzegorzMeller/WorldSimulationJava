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
    public class Grass extends Plant{
     Grass(World w){
        super(w);
        force=0;
        initiative =0;
        position_x=0;
        position_y=0;
        type = "GRASS";
        color="light_gray";
    }
}
