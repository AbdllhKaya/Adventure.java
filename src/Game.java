import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome To Adventure Game ! ");
        System.out.print("Please enter a Nickname :");
        String playerNickName = input.nextLine();
        Player player = new Player(playerNickName);
        System.out.println(player.getName() + " Welcome the Wild World");
        System.out.println("Pick Your Hero Class ! : ");
        player.selectChar();
    }
}
