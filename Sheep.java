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
public class Sheep extends Animal  {
    
     Sheep(World w){
        super(w);
        force=4;
        initiative =4;
        position_x=0;
        position_y=0;
        type = "SHEEP";
        color="gray";
    }
}
