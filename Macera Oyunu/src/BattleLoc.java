import java.util.Scanner;
import java.util.SplittableRandom;

public abstract class BattleLoc extends Location{
    protected Obstacle obstacle;
    protected String award;
    Scanner scan = new Scanner(System.in);

    BattleLoc(Player player,String name,Obstacle obstacle,String award) {
        super(player);
        this.obstacle = obstacle;
        this.name = name;
        this.award = award;
    }
    public boolean getLocation() {
        int obsCount = obstacle.obstacleCount();
        System.out.println();
        System.out.println("You are in " + this.getName() + " right now !");
        System.out.println("Be Careful !");
        System.out.println("There is " + obsCount +" "+ obstacle.getName() + " here");
        System.out.println("<F>ight or <R>un");
        String selCase = scan.nextLine();
        selCase = selCase.toUpperCase();
        if (selCase.equals("F")) {
            if (combat(obsCount)) {
                System.out.println("You killed the all enemies in the "+this.getName());
                System.out.println();
                if(this.award.equals("Food") && player.getInv().isFood() == false) {
                    System.out.println("You won the "+this.award);
                    player.getInv().setFood(true);
                }else {
                    if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
                        System.out.println("You won the " + this.award);
                        player.getInv().setFirewood(true);
                    }else {
                        if(this.award.equals("Water") && player.getInv().isWater() == false) {
                            System.out.println("You won the " + this.award);
                            player.getInv().setWater(true);
                        }
                    }
                }
            }else {
                if (player.getHealthy() <= 0){
                    System.out.println("You are dead");
                    return false;
                }

            }
        }
        return true;
    }
    public boolean combat(int obsCount){
        for ( int i = 0; i < obsCount; i++) {
            int defObsHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while (player.getHealthy() > 0 && obstacle.getHealth() > 0){
                System.out.println("<F>ight or <R>un");
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();
                if (selCase.equals("F")){
                    System.out.println("You hit");
                    obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
                    afterHit();
                    if(obstacle.getHealth() > 0) {
                        System.out.println();
                        System.out.println("Obstacle hit you !");
                        player.setHealthy(player.getHealthy()-(blockDamage()));
                        afterHit();
                        System.out.println();
                    }
                }else{
                    break;
                }
            }
            if(obstacle.getHealth() <= 0 && player.getHealthy() > 0){
                System.out.println();
                System.out.println("You beat the enemy !");
                player.setMoney(player.getMoney()+obstacle.getAward());
                System.out.println("Your current money is : "+player.getMoney());
                System.out.println();
                obstacle.setHealth(defObsHealth);
            }else {
                return false;
            }
        }
        return true;
    }
    public int blockDamage(){
        if (player.getInv().getArmor() > obstacle.getDamage()){
            return 0;
        }else {
            return obstacle.getDamage()-player.getInv().getDamage();
        }
    }
    public void afterHit(){
        if (player.getHealthy() < 0){
            player.setHealthy(0);
        }
        if (obstacle.getHealth() < 0){
            obstacle.setHealth(0);
        }
        System.out.println("Player Health : "+player.getHealthy());
        System.out.println(obstacle.getName()+" Health : "+obstacle.getHealth());
    }
    public void playerStats(){
        System.out.println("Player Informations\n-------------");
        System.out.println("Health : " +player.getHealthy());
        System.out.println("Damage : "+player.getTotalDamage());
        System.out.println("Money  : "+player.getMoney());
        if(player.getInv().getDamage()>0){
            System.out.println("Weapon : "+player.getInv().getwName());
        }
        if(player.getInv().getArmor()>0){
            System.out.println("Armor : "+player.getInv().getaName());
        }
        System.out.println("-------------");
    }
    public void enemyStats(){
        System.out.println("\n"+obstacle.getName()+" Informations\n-------------");
        System.out.println("Health : " +obstacle.getHealth());
        System.out.println("Damage : "+obstacle.getDamage());
        System.out.println("Award  : "+obstacle.getAward());
        System.out.println("-------------");
    }
}
