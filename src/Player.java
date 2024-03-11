import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String characterClass;
    Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public void selectChar() {

        HeroClass[] heroList ={new Yasuo(),new Ashe(),new Garen()};
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (HeroClass heroes : heroList){
            System.out.println("ID "+ heroes.getId()+
                    "\t Hero : " + heroes.getName() +
                    "\t Damage : " + heroes.getDamage()+" " +
                    "\t Healt : " +heroes.getHealth()+ "\t" +
                    "\t Money : " + heroes.getMoney());
        }
        System.out.print("Pick Your Hero Class ! : ");
        int selectHero = input.nextInt();
        switch (selectHero){
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
        System.out.println("Your hero : "+ this.getName() +
                ",    Damage : " +this.getDamage() +
                ",   Health : " + this.getHealth() +
                ",   Money : "+ this.getMoney());

    }
    public void initPlayer(HeroClass pickHero){
        this.setDamage(pickHero.getDamage());
        this.setHealth(pickHero.getHealth());
        this.setMoney(pickHero.getMoney());
        this.setName(pickHero.getName());
    }
    public int getDamage() {
        return damage;
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
}
