public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String characterClass;

    public Player(String name) {
        this.name = name;
    }

    public void selectChar() {

        HeroClass[] heroList ={new Yasuo(),new Ashe(),new Garen()};
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for(HeroClass heroClass : heroList);
        System.out.println(heroList.getClass());
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
