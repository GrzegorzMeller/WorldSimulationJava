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
public abstract class Organism {
    
    protected int initiative;
    protected int position_x;
    protected int position_y;
    protected char character;
    protected int age;
    protected int force;
    protected String type;
    protected String color;
    protected boolean amIAlive;
    protected boolean activate_skill;
    protected int count_skill_time;
    protected int count_extra_rounds;
    public World w;    
    Organism(World world){
        w = world;
        amIAlive=true;
    }
    protected  void akcja(){
       
    }
    protected boolean kolizja(String a, int force_a, String b, int force_b){
        return true; 
    }
    protected void kolizja(String type, int aPositionX, int aPositionY, int bPositionX, int bPositionY){
       
    }
      public int returnSpecialForce(){
        return count_skill_time;
    }
    public int returnKeyClosed(){
        return count_extra_rounds;
    }
    public int getInitiative(){
        return initiative;
    }
    public int getPositionX(){
        return position_x;
    }
    public void setPositionX(int x){
        position_x=x;
    }
    public int getPositionY(){
        return position_y;
    }
    public void setPositionY(int y){
        position_y=y;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int a){
        age=a;
    }
    public int getForce(){
        return force;
    }
    public void setForce(int f){
        force = f;
    }
    public String getType(){
        return type;
    }
    public String getColor(){
        return color;
    }
    public boolean getAlive(){
        return amIAlive;
    }
    public void setAlive(boolean a){
        amIAlive=a;
    }
    public boolean getActivateSkill(){
        return activate_skill;
    }
    public void setActivateSkill(boolean a){
        activate_skill=a;
    }
    public void setSkillTime(int a){
        count_skill_time= a;
    }
    public void setCountExtraRounds(int a){
        count_extra_rounds=a;
    }
    
}
