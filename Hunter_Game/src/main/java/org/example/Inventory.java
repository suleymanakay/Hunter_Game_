package org.example;

public class Inventory {
    private Weapon weapon;
    private int food;
    private int fireWood;
    private int water;
    private Armor armor;

    public Inventory(){
        this.weapon=new Weapon("Yumruk",-1,0,0);
        this.armor=new Armor(0,"Don-Atlet",-1,0);
        this.fireWood=fireWood;
        this.water=water;
        this.food=food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFireWood() {
        return fireWood;
    }

    public void setFireWood(int fireWood) {
        this.fireWood = fireWood;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}