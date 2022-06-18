package org.example;

public class Armor {
    private int id;
    private String name;
    private int block;
    private int price;

    public Armor(int id, String name, int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }
    public static Armor[] Armors(){
        Armor[] armorList=new Armor[3];
        armorList[0]=new Armor(1,"Hafif",1,20);
        armorList[1]=new Armor(2,"Orta",3,30);
        armorList[2]=new Armor(3,"Ağır",5,40);
        return armorList;
    }
    public static Armor getArmorObjByID(int id){
        for (Armor a:Armor.Armors()) {
            if(a.getId()==id)
                return a;
        }
        return null;

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

    public int getBlock() {
        if(block<0){
            block=0;
        }
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
