import java.util.Scanner;

public class Player {
    private int damage,healthy,money,rHealthy;
    private String name,cName;
    Inventory inv;
    Scanner scan =new Scanner(System.in);
    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectChar(){
        switch (charMenu()) {
            case 1 -> {
                initPlayer("Samurai",5,21,15);
            }
            case 2 -> {
                initPlayer("Archer",7,18,20);

            }
            case 3 -> {
                initPlayer("Knight",8,24,5);

            }
            default -> {
                setcName("Knight");
                setDamage(8);
                setHealthy(24);
                setMoney(5);
            }
        }
        System.out.println("Your new character is created");
        System.out.println("Character:"+getcName()+"\tDamage:"+getDamage()+"\tHealth:"+getHealthy()+"\tMoney:"+getMoney());
    }
    public int charMenu(){
        System.out.println("Please select a character :");
        System.out.println("1-Samurai :  Damage:5 , Health:21 , Money:15");
        System.out.println("2-Archer  :  Damage:7 , Health:18 , Money:20");
        System.out.println("3-Knight  :  Damage:8 , Health:24 , Money:5");
        System.out.print("Your Choice : ");
        int charID = scan.nextInt();
        while (charID < 1 || charID > 3){
            System.out.print("Please select a valid character : ");
            charID = scan.nextInt();
        }

        return charID;
    }

    public void initPlayer(String cName,int dmg,int heal,int mny){
        setcName(cName);
        setDamage(dmg);
        setHealthy(heal);
        setMoney(mny);
        setrHealthy(heal);
    }
    public int getTotalDamage(){
        return this.getDamage()+this.getInv().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public int getrHealthy() {
        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }
}
