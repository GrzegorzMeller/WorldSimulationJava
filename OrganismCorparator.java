/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polab;
import java.util.Comparator;
/**
 *
 * @author grzes
 */
public class OrganismCorparator implements Comparator<Organism> {
   
    @Override
    public int compare(Organism t, Organism t1) {
        
        if(t.initiative==t1.initiative){
            return t1.age-t.age;
        }   
        else{
            return t1.initiative-t.initiative;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
