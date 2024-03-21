import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int defHealt;
    private int money;
    private String name;
    private String characterClass;
    private Inventory inventory;
    Scanner input = new Scanner(System.in);

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Player(String name) {

        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {

        HeroClass[] heroList = {new Yasuo(), new Ashe(), new Garen()};
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (HeroClass heroes : heroList) {
            System.out.println("ID " + heroes.getId() +
                    "\t Hero : " + heroes.getName() +
                    "\t Damage : " + heroes.getDamage() + " " +
                    "\t Healt : " + heroes.getHealth() + "\t" +
                    "\t Money : " + heroes.getMoney());
        }
        System.out.print("Pick Your Hero Class ! : ");
        int selectHero = input.nextInt();
        switch (selectHero) {
            case 1:
                initPlayer(new Yasuo());
                break;
            case 2:
                initPlayer(new Ashe());
                break;
            case 3:
                initPlayer(new Garen());
                break;
            default:
                initPlayer(new Yasuo());
        }
        System.out.println("Your hero : " + this.getName() +
                ",    Damage : " + this.getDamage() +
                ",   Health : " + this.getHealth() +
                ",   Money : " + this.getMoney());

    }

    public void selectLocation() {
        Location location = null;
        System.out.println("Bölgeler :");
        System.out.println("1- Güvenli Ev");
        System.out.println("2- Mağaza ");
        System.out.println("Lütfen gitmek istediğiniz yeri seçiniz .");
        int selectLoc = input.nextInt();
        switch (selectLoc) {
            case 1:
                location = new SafeHouse(this);
                break;
            case 2:
                location = new ToolStore(this);
                break;
            default:
                location = new SafeHouse(this);
        }
        location.onLocation();
    }

    public void initPlayer(HeroClass pickHero) {
        this.setDamage(pickHero.getDamage());
        this.setHealth(pickHero.getHealth());
        this.setDefHealt(pickHero.getHealth());
        this.setMoney(pickHero.getMoney());
        this.setName(pickHero.getName());
    }

    public void printInfo() {
        System.out.println(
                "Silahınız : " + this.getInventory().getWeapon().getName() +
                        ",    Zırh : " + this.getInventory().getArmor().getName() +
                        ",    Block Şansınız : " + this.getInventory().getArmor().getBlock() +
                        ",    Damage : " + this.getTotalDamage() +
                        ",   Health : " + this.getHealth() +
                        ",   Money : " + this.getMoney());
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getDefHealt() {
        return defHealt;
    }

    public void setDefHealt(int defHealt) {
        this.defHealt = defHealt;
    }
}
