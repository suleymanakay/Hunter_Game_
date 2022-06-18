package org.example;

import java.util.Scanner;

public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        boolean deger = true;
        while (deger) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Mağazaya Hoş geldiniz.");
            System.out.println("1-Silahlar");
            System.out.println("2-Zırhlar");
            System.out.println("3-Çıkış Yap");
            System.out.println("Seçiminizi Yapınız.");
            int select = scanner.nextInt();
            while (select < 1 || select > 3) {
                System.out.print("Yanlış değer girdiniz tekrar giriniz:");
                select = scanner.nextInt();
            }
            switch (select) {
                case 1:
                    selectWeapons();
                    buyWeapons();
                    break;
                case 2:
                    selectArmors();
                    buyArmors();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz...");
                    deger = false;
                    break;

            }
        }
        return true;
    }

    public void selectWeapons() {
        System.out.println("\t\t\t\t\t----------------------Silahlar------------------------");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println(
                    "\t\tSilah İsmi: " + w.getName() +
                            "\t\t Silah id: " + w.getId() +
                            "\t\t Silah Hasarı: " + w.getDamage() +
                            "\t\t Silah Fiyatı: " + w.getPrice());

        }
    }

    public void buyWeapons() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bir Silah -id- seçiniz: ");
        System.out.println("Çıkış için '0' giriniz.");
        int select = scanner.nextInt();
        while (select < 0 || select > Weapon.weapons().length) {
            System.out.print("Yanlış değer girdiniz tekrar giriniz:");
            select = scanner.nextInt();
        }
        if (select != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(select);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney())
                    System.out.println("Yeterli bakiyeniz bulunmamakta.");
                else {
                    System.out.println(selectedWeapon.getName() + " Silahını satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan bakiyeniz: " + this.getPlayer().getMoney());
                    System.out.println("Eski Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    public void selectArmors() {
        System.out.println("\t\t\t\t----------------------------Zırhlar-----------------------------");
        System.out.println();
        for (Armor w : Armor.Armors()) {
            System.out.println(
                    "\t\t Zırh İsmi: " + w.getName() +
                            "\t\t Zırh id: " + w.getId() +
                            "\t\t Zırh blok değeri: " + w.getBlock() +
                            "\t\t Zırh Fiyatı: " + w.getPrice()
            );
        }
    }

    public void buyArmors() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bir Zırh Satın almak için -id- seçiniz: ");
        System.out.println("Çıkış için '0' giriniz.");
        int selectarmor = scanner.nextInt();
        while (selectarmor < 0 || selectarmor > Armor.Armors().length) {
            System.out.print("Yanlış değer girdiniz tekrar giriniz:");
            selectarmor = scanner.nextInt();
        }
        if(selectarmor !=0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectarmor);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney())
                    System.out.println("Yeterli bakiyeniz bulunmamakta.");
                else {
                    System.out.println(selectedArmor.getName() + " Zırhını satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan bakiyeniz: " + this.getPlayer().getMoney());
                    System.out.println("Eski Zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni Zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }
}
}