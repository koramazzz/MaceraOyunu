public class SafeHouse extends NormalLoc{
    SafeHouse(Player player) {
        super(player, "Safe House");
    }
    public boolean getLocation(){
        player.setHealthy(player.getrHealthy());
        System.out.println("\nYou're healed");
        System.out.println("You're in safe house right now");
        return true;
    }
}
