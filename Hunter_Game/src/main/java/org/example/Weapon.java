package org.example;

public class Weapon {
    private String name;
    private int damage;
    private int id;
    private int price;

    public Weapon(String name,int damage, int id, int price) {
        this.damage = damage;
        this.id = id;
        this.price = price;
        this.name=name;
    }
    public static Weapon[] weapons(){
        Weapon [] weaponList=new Weapon[3];
        weaponList[0]=new Weapon("Tabanca",2,1,25);
        weaponList[1]=new Weapon("Uzi   -",3,2,35);
        weaponList[2]=new Weapon("AWM   -",7,3,45);
        return weaponList;
    }
    public static Weapon getWeaponObjByID(int id){
        for (Weapon w:Weapon.weapons()) {
            if(w.getId()==id)
                return w;
        }
        return null;

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
