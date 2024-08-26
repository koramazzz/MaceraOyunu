import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);

    public void login(){
        Scanner scan= new Scanner(System.in);
        System.out.println("Welcome to the game");
        System.out.print("Enter your name before start to the game : ");
        String playerName = scan.nextLine();
        System.out.println("Your name is : "+playerName);
        System.out.println();
        player = new Player(playerName);
        player.selectChar();
        start();
    }
    public void start(){
        while (true){
            System.out.println();
            System.out.println("------------");
            System.out.println();
            System.out.println("Please select a location to do something :");
            System.out.println("1. Safe House --> This place safe for you, there is no enemy here");
            System.out.println("2. Cave --> There might be vampires !");
            System.out.println("3. Forest --> There might be zombies !");
            System.out.println("4. River --> There might be bears !");
            System.out.println("5. Shop --> You can buy gun or armor");
            System.out.print("Place that you want to go : ");
            int selLoc = scan.nextInt();
            while (selLoc < 0 || selLoc > 5){
                System.out.println();
                System.out.print("Please select a valid location : ");
                selLoc = scan.nextInt();
            }
            switch (selLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new Shop(player);
                    break;
            }
            if (location.getClass().getName().equals("SafeHouse")){
                if(player.getInv().isFood() && player.getInv().isFirewood() && player.getInv().isWater()){
                    System.out.println("\nCongratulations!");
                    System.out.println("\nYou have won the game!");
                    break;
                }
            }
            if(!location.getLocation()){
                System.out.println("Game Over !");
                break;
            }
        }
    }
}
