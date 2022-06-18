package org.example;

import java.util.Scanner;

public class Game {
    private Scanner scanner=new Scanner(System.in);
    private String player;
    private String location;

    public Game() {
        this.player = player;
        this.location = location;
    }
    public void start(){
        System.out.println("Oyuna hoşgeldiniz.");
        System.out.print("Lütfen Oyuncu İsmi giriniz: ");
        String playerName=scanner.nextLine();
        Player player =new Player(playerName);
        System.out.println("Sayın "+player.getName()+" "+"Görkemli ve Karanlık Ada Oyununa Hoş geldiniz.");
        System.out.println("Lütfen karakter seçiniz: ");
        player.selectChar();

        for(;;) {
            player.prinİnfo();
            Location location = null;
            System.out.println();
            System.out.println("\t\t\t-----------------Bölgeler------------------ ");
            System.out.println();
            System.out.println("\t\t1-Güvenli Ev ---->Bölge Güvenli ve düşman yok.");
            System.out.println("\t\t2-Dükkan     ---->Burada Silah veya zırh alabilirsiniz.");
            System.out.println("\t\t3-Mağara     ----> <Ödül:yemek.> Dikkat içerisi tehlikeli gibi gözüküyor. Zombi Çıkabilir");
            System.out.println("\t\t4-Orman      ----> <Ödül:odun> Dikkat içerisi tehlikeli gibi gözüküyor. Vampir Çıkabilir");
            System.out.println("\t\t5-Nehir      ----> <Ödül:su> Dikkat içerisi tehlikeli gibi gözüküyor. Ayı Çıkabilir");
            System.out.println("\t\t6-Maden      ----> <Ödül: Eşya veya altın> Dikkat içerisi tehlikeli. Yılan çıkabilir. ");
            System.out.println("\t\t0-Oyundan çıkış ");
            System.out.print("\t\tLütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int a = scanner.nextInt();
            switch (a) {
                case 0:
                    location=null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;

                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location =new Cave(player);
                    break;
                case 4:
                    location =new Forest(player);
                    break;
                case 5:
                    location =new River(player);
                    break;
                case 6:
                    location=new Coal(player);
                    break;

                default:
                    location = new SafeHouse(player);break;

            }
            if(location==null){
                System.out.println("Bir dahaki sefere başarabilirsiniz.");
                System.out.println("Çıkış yapılıyor...");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Game Over");
            break;}
        }


    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
