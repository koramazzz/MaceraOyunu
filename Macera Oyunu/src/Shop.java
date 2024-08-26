import javax.naming.BinaryRefAddr;
import java.util.Scanner;

public class Shop extends NormalLoc {
    Scanner scan = new Scanner(System.in);

    Shop(Player player) {
        super(player, "Shop");
    }

    public boolean getLocation() {
        System.out.println();
        System.out.println("Money : " + player.getMoney());
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Quit");
        System.out.print("Choice : ");
        int selTool = scan.nextInt();
        int selItemID;
        switch (selTool) {
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            default:
                break;

        }
        return true;
    }
    public int armorMenu(){
        System.out.println("1. Light  : Money:15 - Block: 1");
        System.out.println("2. Middle : Money:25 - Block: 3");
        System.out.println("3. Heavy  : Money:40 - Block: 5");
        System.out.println("4. Quit");
        System.out.print("Choose an armor : ");
        int selArmorID = scan.nextInt();
        return selArmorID;
    }

    public void buyArmor(int itemID) {
        int avoid = 0, price = 0;
        String aName = null;
        switch (itemID) {
            case 1:
                avoid = 1;
                aName = "Light";
                price = 15;
                break;
            case 2:
                avoid = 3;
                aName = "Middle";
                price = 25;
                break;
            case 3:
                avoid = 5;
                aName = "Heavy";
                price = 40;
                break;
            default:
                System.out.println("Invalid Choice !");
                break;
        }
        if (price >= 0){
            if (player.getMoney() > price) {
                player.getInv().setArmor(avoid);
                player.getInv().setaName(aName);
                player.setMoney(player.getMoney()-price);
                System.out.println("You bought the "+aName+" armor"+", Blocked Damage:"+player.getInv().getArmor());
                System.out.println("Remaining Fund : "+player.getMoney());
            }else {
                System.out.println("\nInsufficient fund\n");
            }

        }
    }

    public int weaponMenu() {
        System.out.println("1. Gun   : Money:25 - Damage: 2");
        System.out.println("2. Sword : Money:35 - Damage: 3");
        System.out.println("3. Rifle : Money:45 - Damage: 7");
        System.out.println("4. Quit");
        System.out.print("Choose a weapon : ");
        int selWeaponID = scan.nextInt();
        return selWeaponID;
    }

    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                damage = 2;
                wName = "Gun";
                price = 25;
                break;
            case 2:
                damage = 3;
                wName = "Sword";
                price = 35;
                break;
            case 3:
                damage = 7;
                wName = "Rifle";
                price = 45;
                break;
            default:
                System.out.println("Invalid Choice !");
                break;
        }
        if (price >= 0){
            if (player.getMoney() > price) {
                player.getInv().setDamage(damage);
                player.getInv().setwName(wName);
                player.setMoney(player.getMoney()-price);
                System.out.println("You bought the "
                        +wName+", Former Damage:"+player.getDamage()+" , New Damage: "+player.getTotalDamage());
                System.out.println("Remaining Fund : "+player.getMoney());
            }else {
                System.out.println("\nInsufficient fund\n");
            }

        }
    }
}
