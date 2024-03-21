import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome To Adventure Game ! ");
        System.out.print("Please enter a Nickname :");
        String playerNickName = input.nextLine();
        Player player = new Player(playerNickName);
        System.out.println(player.getName() + " Welcome the Wild World");
        player.selectChar();
        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("<<<<<Bölgeler>>>>> :");
            System.out.println();
            System.out.println("1- Güvenli Ev");
            System.out.println("2- Demirci  ");
            System.out.println("3- Mağara Gir ");
            System.out.println("4- Ormana Git ");
            System.out.println("5- Nehire Git ");
            System.out.println("0- Çıkış Yap(Oyunu Sonlandır)");
            System.out.println("Lütfen gitmek istediğiniz yeri seçiniz .");
            int selectLoc = input.nextInt();
            //location.onLocation();
            switch (selectLoc) {
                case 0 :
                location = null;
                break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3 :
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5 :
                    location = new River(player);
                    break;

                default:
                    location = new SafeHouse(player);
            }
            if (location == null){
                System.out.println("Oyunu kapattınız İyi günler .");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Game Over !");
                break;
            }
        }
    }
}

