/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polab;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author grzes
 */
public class POLAB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        World w = new World();
         Wolf wolf= new Wolf(w);
        Animal animal = wolf;
        Organism organism = animal;
        w.addOrganismToWorld(organism);
        Sheep sheep = new Sheep(w);
        animal = sheep;
        organism = animal;
        w.addOrganismToWorld(organism);
        Fox fox = new Fox(w);
        animal=fox;
        organism=animal;
        w.addOrganismToWorld(organism);
        Turtle turtle = new Turtle(w);
        animal = turtle;
        organism=animal;
        w.addOrganismToWorld(organism);
        Antelope antelope = new Antelope(w);
        animal=antelope;
        organism=animal;
        w.addOrganismToWorld(organism); 
        Human human = new Human(w);
        animal = human;
        organism=animal;
        w.addOrganismToWorld(organism);
        Grass grass = new Grass(w);
        Plant plant = grass;
        organism = plant;
        w.addOrganismToWorld(organism);
        Guarana guarana = new Guarana(w);
        plant = guarana;
        organism = plant;
        w.addOrganismToWorld(organism);
        Blueberries blueberries = new Blueberries(w);
        plant=blueberries;
        organism=plant;
        w.addOrganismToWorld(organism);
        Sosnowsky sosnowsky = new Sosnowsky(w);
        plant = sosnowsky;
        organism = plant;
        w.addOrganismToWorld(organism);
        SowThistle sowThistle = new SowThistle(w);
        plant = sowThistle;
        organism = plant;
        w.addOrganismToWorld(organism);
    }
    
}
