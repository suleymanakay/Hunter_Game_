package org.example;

import java.util.Scanner;

public class Player {
    private Inventory Inventory;
    private int damage;

    private int originalllHealth;
    private int health;
    private int money;
    private String charName;
    private String name;
    public static Scanner scanner=new Scanner(System.in);

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String name) {
        this.Inventory=new Inventory();
        this.name=name;
        this.charName=charName;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.originalllHealth=getOriginalllHealth();
    }

    public void selectChar(){
       GameChar[] arlist={new Samurai(),new Archer(),new Knight() };
        System.out.println("Karakterler");
        System.out.println("---------------------------------------");
        for (GameChar gameChar:arlist) {
            System.out.println("Karakter "+ gameChar.getName()+
                    "\tKarakter id: "+gameChar.getId()+
                    "\t\t --------------"
                    +"\t\t Hasar  "+gameChar.getDamage()
                    +"\t\t Sağlık "+gameChar.getHealth()
                    +"\t\t Para   "+gameChar.getMoney());
        }
        System.out.println("-----------------------------------");
        System.out.println("Karakter seçimi için -id- numarası giriniz: ");
        int secim= scanner.nextInt();
        switch (secim){
            case 1:
                inCharacter(new Samurai());break;
            case 2:
                inCharacter(new Archer());break;
            case 3:
                inCharacter(new Knight());break;

            default:
                inCharacter(new Samurai());
        }
        System.out.println("Seçilen karakterin:"+
                "\t ismi: "+getName()+
                "\t Hasarı: "+getDamage()+
                "\t Sağlığı: "+getHealth()+
                "\t Parası: "+getMoney());
       }
    public void inCharacter(GameChar gameChar){
        this.setName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setOriginalllHealth(gameChar.getHealth());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
    }


    public int getOriginalllHealth() {
        return originalllHealth;
    }

    public void setOriginalllHealth(int originalllHealth) {
        this.originalllHealth = originalllHealth;
    }

    public org.example.Inventory getInventory() {
        return Inventory;
    }

    public void setInventory(org.example.Inventory inventory) {
        Inventory = inventory;
    }

    public void prinİnfo(){
        System.out.println(
                        "\t Silah: "+this.getInventory().getWeapon().getName()+","+
                        "\t Zırh: "+this.getInventory().getArmor().getName()+","+
                        "\t Bloklama: "+this.getInventory().getArmor().getBlock()+","+
                        "\t Hasar: "+this.getTotalDamage()+","+
                        "\t Sağlık: "+this.getHealth()+","+
                        "\t Para: "+this.getMoney());
    }
public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
}
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health<0){
            health=0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }



}
