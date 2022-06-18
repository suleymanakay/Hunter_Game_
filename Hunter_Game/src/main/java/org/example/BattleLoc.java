package org.example;
import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
    Scanner scanner = new Scanner(System.in);
    private Obstacle obstacle;
    private String award;
    private int maxObstacler;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacler) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacler = maxObstacler;
    }

    public int getMaxObstacler() {
        return maxObstacler;
    }

    public void setMaxObstacler(int maxObstacler) {
        this.maxObstacler = maxObstacler;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    @Override
    public boolean onLocation() {
        int obsnumber = randomNumber();
        System.out.println("Şuan buradasınız." + this.getName());
        System.out.println("Dikkatli ol burada " + obsnumber + " adet " + this.getObstacle().getName() + " yaşıyor!");
        System.out.print("(S)avaş veya (K)aç: ");
        String select = scanner.nextLine().toUpperCase();
        if (select.equals("S")) {
            System.out.println("Savaş ilemleri başlıyor...");
            if(combat(obsnumber)){
                System.out.println("Tüm düşmanları yendinizi.");
                return true;
            }

        }
        if(this.getPlayer().getHealth()<=0){
            System.out.println("Öldünüz...");
            return false;
        }
        return true;
}
    public boolean combat(int obsnumber) {
        this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
        for (int i = 1; i <= obsnumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                System.out.println("(V)ur veya (K)aç");
                String select=scanner.nextLine().toUpperCase();


                if(select.equals("V")){
                    Random random=new Random();
                    int a=random.nextInt(2);
                    switch (a){
                        case 0:
                    System.out.println("Siz vurdunuz");
                    this.obstacle.setHealth(this.obstacle.getHealth()-this.getPlayer().getTotalDamage());
                    afterhit(); break;
                        case 1:
                    if(this.getObstacle().getHealth()>0){
                        System.out.println();
                        System.out.println(this.getObstacle().getName()+" Size vurdu");
                        int obstotaldamage=(this.getObstacle().getDamage()) -(this.getPlayer().getInventory().getArmor().getBlock());
                        if(obstotaldamage<0){
                            obstotaldamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstotaldamage);
                        afterhit();
                    }
                }
                }
                else {
                    return false;
                }
            }}
            if(this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz! ");
                System.out.println(this.getObstacle().getAward()+ " altın para kazandınız.");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Güncel paranız: "+this.getPlayer().getMoney());
            }
            else{
                return false;
            }

        return true;
    }
    public void afterhit(){
        System.out.println("Canınız: "+ this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" Canı: "+this.getObstacle().getHealth());
        System.out.println();
    }
    public void playerStats(){
        System.out.println("----------------Oyuncu Değerleri--------------");
        System.out.println();
        System.out.println("Sağlık: "+getPlayer().getHealth());
        System.out.println("Hasar: "+getPlayer().getTotalDamage());
        System.out.println("Zırh: "+getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: "+getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para: "+getPlayer().getMoney());
    }
    public void obstacleStats(int i){
        System.out.println(i+ "."+this.getObstacle().getName()+" Değerleri");
        System.out.println("-----------------------");
        System.out.println("Sağlık değeri: "+getObstacle().getHealth());
        System.out.println("Saldırı değeri: "+getObstacle().getDamage());
        System.out.println("Ödül değeri: "+getObstacle().getAward());
    }

    public int randomNumber(){
        Random r =new Random();
        return r.nextInt(this.getMaxObstacler())+1;
    }
    private void awardGenerator(){
        int number = (int)(Math.random()*100);
        if (number <15){
            int number2 = (int)(Math.random()*100);
            if (number2 < 20){
                System.out.println("Tebrikler, Tufek kazandiniz !");
                this.getPlayer().getInventory().setWeapon(new Weapon("Tufek", 3, 7, 45));
                System.out.println("Yeni silahiniz " + this.getPlayer().getInventory().getWeapon());
            }else if (number2 > 20 && number2 < 50){
                System.out.println("Tebrikler, Kilic kazandiniz !");
                this.getPlayer().getInventory().setWeapon(new Weapon("Kilic", 2, 3, 35));
                System.out.println("Yeni silahiniz " + this.getPlayer().getInventory().getWeapon());
            }else {
                System.out.println("Tebrikler, Tabanca kazandiniz !");
                this.getPlayer().getInventory().setWeapon(new Weapon("Tabanca", 1, 2, 25));
                System.out.println("Yeni silahiniz " + this.getPlayer().getInventory().getWeapon());
            }
        }else if(number >15 && number <30){
            int number2 = (int)(Math.random()*100);
            if (number2 < 20){
                System.out.println("Tebrikler, Agir zirh kazandiniz !");
                this.getPlayer().getInventory().setArmor(new Armor(3, "Agir", 5, 40));
                System.out.println("Yeni zirhiniz " + this.getPlayer().getInventory().getArmor());
            }else if (number2 > 20 && number2 < 50){
                System.out.println("Tebrikler, Orta zirh kazandiniz !");
                this.getPlayer().getInventory().setArmor(new Armor(2, "Orta", 3, 25));
                System.out.println("Yeni zirhiniz " + this.getPlayer().getInventory().getArmor());
            }else {
                System.out.println("Tebrikler, Hafif zirh kazandiniz !");
                this.getPlayer().getInventory().setArmor(new Armor(1, "Hafif", 1, 15));
                System.out.println("Yeni zirhiniz " + this.getPlayer().getInventory().getArmor());
            }
        }else if(number >30 && number <55){
            int number2 = (int)(Math.random()*100);
            if (number2 < 20){
                System.out.println("Tebrikler, 10 para kazandiniz");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                System.out.println("Guncel paraniz " + this.getPlayer().getMoney());
            }else if (number2 > 20 && number2 < 50){
                System.out.println("Tebrikler, 5 para kazandiniz");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                System.out.println("Guncel paraniz " + this.getPlayer().getMoney());
            }else {
                System.out.println("Tebrikler, 1 para kazandiniz");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                System.out.println("Guncel paraniz " + this.getPlayer().getMoney());
            }
        }else {
            System.out.println("Bu canavardan esya yada para dusmedi !");
        }
    }

}
