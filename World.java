/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polab;

import java.awt.Color;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.E;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import polab.SwingWorld;

/**
 *
 * @author grzes
 */
public class World {

    private List<Organism> organisms;
    private List<Organism> newOrganisms;
    private SwingWorld swing;
    protected int height;
    protected int width;
    protected int key;
   // private boolean activate_skill;
   // private int count_skill_time;
    public boolean needToStop;
    private List<Organism> killedByPlants;
    private List<Organism> createdByMultiplication;
    public World() {
        needToStop = false;
        height = 10;
        width = 10;
        swing = new SwingWorld(height, width, this);
        organisms = new ArrayList<Organism>();
        newOrganisms = new ArrayList<Organism>();
        killedByPlants = new ArrayList<Organism>();
        createdByMultiplication = new ArrayList<Organism>();
       // activate_skill=false;
        //count_skill_time=0;
    }

    World(POLAB aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int CheckOrganismForceOnPosition(int y, int x) {
        for (Organism i : organisms) {
            if (i.getPositionY() == y && i.getPositionX() == x) {

                return i.getForce();
            }
        }
        return 0;
    }
    public void activateSpecialSkill(){
         for (Organism i : organisms) {
            if ("HUMAN".equals(i.getType())) {
                i.setActivateSkill(true);
            }
        }
    }
    public void stopSkill(){
        swing.stopSkill();
    }

    public void CleanList() {
        organisms.clear();
    }
    private void CopyFromNewList(){
        for (Organism o : newOrganisms) {
                organisms.add(o);
                //do I have to do any destructor here? Destroy element?
                swing.DisplayOrganism(o.position_y, o.position_x, o.color);
            }
    }

    public String CheckOrganismTypeOnPosition(int y, int x) {
        for (Organism i : organisms) {
            if (i.getPositionY() == y && i.getPositionX() == x) {

                return i.getType();
            }
        }
        return "EMPTY";
    }

    public void addOrganismToWorld(Organism o) {
        Random generator = new Random();
        o.setPositionY(generator.nextInt(height));
        o.setPositionX(generator.nextInt(width));
        while (swing.CheckPosition(o.position_y, o.position_x) != Color.WHITE) {
            o.setPositionY(generator.nextInt(height));
            o.setPositionX(generator.nextInt(width));
        }
        organisms.add(o);
        swing.DisplayOrganism(o.position_y, o.position_x, o.color);

        Collections.sort(organisms, (o1, o2) -> o1.initiative - o2.initiative); //TO DO: WHEN EQUAL sort by age!!!!
        Collections.reverse(organisms);
    }

    public void addOrganismToWorld(Organism o, int y, int x) {
        o.setPositionY(y);
        o.setPositionX(x);
        organisms.add(o);
        

        Collections.sort(newOrganisms, new OrganismCorparator()); //TO DO: WHEN EQUAL sort by age!!!!
        
    }
    public int getKey(){
        return key;
    }
    public void rozmnazanie(Organism o){
       createdByMultiplication.add(o);
       swing.DisplayOrganism(o.position_y, o.position_x, o.color);
    }
    public void addForce(String a, int position_x, int position_y)
    {
	for (Organism  j : organisms)
	{
		if (j.position_x == position_x && j.position_y == position_y && j.type.equals(a))
		{
                    int f=j.getForce();
                    f+=3;
                    j.setForce(f);
                    break;
		}
	}
    }
    public void addOrganismToKill(String a, int position_x, int position_y)
    {
	for (Organism  j : organisms)
	{
		if (j.position_x == position_x && j.position_y == position_y && j.type.equals(a))
		{
                        j.setAlive(false);
			killedByPlants.add(j);
		}
	}
    }
    
    public int findSpecialForce(){
        for (Organism  j : organisms)
	{
		if (j.getType().equals("HUMAN"))
		{
                       return j.returnSpecialForce();
		}
	}
        return 0;
    }
     public int findKeyClosed(){
        for (Organism  j : organisms)
	{
		if (j.getType().equals("HUMAN"))
		{
                       return j.returnKeyClosed();
		}
	}
        return 0;
    }
    public void newRound() {
        boolean mayImultiplicate = true;
         key = swing.ReturnKeyValue();
        if (needToStop == false) {
            List<Organism> deadOrganisms = new ArrayList<Organism>();
            for (Organism i : organisms) {
                if(needToStop){
                    CleanList();
                    CopyFromNewList();
                    break;
                }
                if(needToStop==false){
                if (i.amIAlive == true) {
                    key = 0;
                    int age=i.getAge();
                    age++;
                    i.setAge(age);
                    if (!(i.getType().equals("HUMAN"))) {
                        swing.CleanOnPosition(i.getPositionY(), i.getPositionX());
                    }
                    else{
                        key = swing.ReturnKeyValue();
                        swing.CleanKey();
                    }
                    int save_y = i.getPositionY();
                    int save_x = i.getPositionX();
                    i.akcja();
                    int pom = 0;
                    while (i.getPositionY() >= height || i.getPositionY() < 0 || i.getPositionX() >= width || i.getPositionX() < 0) {
                        pom++;
                        key = 0;
                        if (pom >= 100) {
                            i.setPositionY(save_y);
                            i.setPositionX(save_x);
                            break;
                        }
                       i.setPositionY(save_y);
                            i.setPositionX(save_x);
                       // while (key == 0 && i.type.equals("HUMAN")&&needToStop==false) {
                       //     key = swing.ReturnKeyValue();
                       // }
                        i.akcja();
                    }
                    if (swing.CheckPosition(i.getPositionY(), i.getPositionX()) == Color.WHITE) {
                        swing.DisplayOrganism(i.getPositionY(), i.getPositionX(), i.getColor());
                    } else {
                        for (Organism j : organisms) {
                            if (j.getPositionX() == i.getPositionX() && j.getPositionY() == i.getPositionY() && j.age!=i.age) {
                                boolean a = i.kolizja(i.getType(), i.getForce(), j.getType(), j.getForce());
                                boolean b = j.kolizja(i.getType(), i.getForce(), j.getType(), j.getForce());
                                if (a == true && b == true && i.getAlive() == true && j.getAlive() == true && i.getAlive() == true) {
                                    if (j.getForce() > i.getForce()) {
                                        i.setAlive(false);
                                        deadOrganisms.add(i);
                                        swing.CleanOnPosition(i.getPositionY(), i.getPositionX());
                                    } else if (j.getForce() <= i.getForce()) {
                                        j.amIAlive = false;
                                        deadOrganisms.add(j);
                                        swing.CleanOnPosition(j.getPositionY(), j.getPositionX());
                                        swing.DisplayOrganism(i.getPositionY(), i.getPositionX(), i.getColor());
                                    }
                                } else if ((a == false || b == false) && j.getType().equals("TURTLE")) {
                                    i.setPositionX(save_x);
                                    i.setPositionY(save_y);
                                    swing.DisplayOrganism(i.getPositionY(), i.getPositionX(), i.getColor());
                                }
                                else if(i.type.equals(j.type)){
                                    i.setPositionX(save_x);
                                    i.setPositionY(save_y);
                                    if(mayImultiplicate){
                                    i.kolizja(i.getType(), i.getPositionX(), i.getPositionY(), j.getPositionX(), j.getPositionY());
                                    mayImultiplicate = false;
                                    }
                                    else{
                                        mayImultiplicate=true;
                                    }
                                }
                            }

                        }
                    }
                     
                    swing.CleanBoard(height, width);
                    for (Organism x : organisms) {
                        if (x.amIAlive == true) {
                            swing.DisplayOrganism(x.getPositionY(), x.getPositionX(), x.getColor());
                            //TimeUnit.SECONDS.sleep(1);
                        }
                    }
                }
            }
            }
            for (Organism x : deadOrganisms) {
                organisms.remove(x);
                //do I have to do any destructor here? Destroy element?
            }
            for (Organism x : killedByPlants) {
                organisms.remove(x);
                //do I have to do any destructor here? Destroy element?
            }
            killedByPlants.clear();
            for(Organism x : createdByMultiplication){
                swing.DisplayOrganism(x.getPositionY(), x.getPositionX(), x.getColor());
                organisms.add(x);
            }
             Collections.sort(organisms, new OrganismCorparator()); //TO DO: WHEN EQUAL sort by age!!!!
            createdByMultiplication.clear();
        }
    }

}
