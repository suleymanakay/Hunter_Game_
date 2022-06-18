package org.example;

public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }
    @Override
    public boolean onLocation(){
        System.out.println("Güvenli Evdesiniz.");
        System.out.println("Şimdiki canınız: "+this.getPlayer().getHealth());
        this.getPlayer().setHealth(this.getPlayer().getOriginalllHealth());
        System.out.println("Canınız yenilendi. Yeni canınız: "+this.getPlayer().getHealth());

        return true;
    }
}
