import java.util.Random;

public class BattleLoc extends Location {
    private Enemy enemy;
    private String award;
    private int maxEnemy;

    public BattleLoc(Player player, String name, Enemy enemy, String award, int maxEnemy) {
        super(player, name);
        this.enemy = enemy;
        this.award = award;
        this.maxEnemy = maxEnemy;
    }

    @Override
    public boolean onLocation() {
        int enemyNumber = this.randomEnemyNumber();
        System.out.println("Şu an buradasınız : " + this.getName());
        System.out.println("Dikkatli Ol etrafta " + enemyNumber + " tane " + this.getEnemy().getName() + " geziyor !");
        System.out.println("<S>avaş veya <K>aç");
        String selectFight = input.nextLine();
        selectFight = selectFight.toUpperCase();
        if (selectFight.equals("S")) {
            if (combat(enemyNumber)){
                System.out.println(this.getName()+ "tüm canavarları yendiniz. ");
                return true;
            }
            System.out.print("Savaşmayı seçtin");
        }
        if (this.getPlayer().getHealth() <= 0 ){
            System.out.println("Öldünüz");
            return false;
        }
        return true;
    }

    public boolean combat(int enemyNumber) {
        for (int i = 1; i <= enemyNumber; i++) {
            this.getEnemy().setHealth(this.getEnemy().getDefHealth());
            playerStats();
            System.out.println();
            System.out.println();
            enemyStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getEnemy().getHealth() > 0) {
                System.out.println("<V>ur ve <K>aç");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")){

                    this.enemy.setHealth(this.getPlayer().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getEnemy().getHealth() > 0 ){
                        System.out.println();
                        System.out.println("Canavardan Hasar Yediniz.");
                        int enemyDamage = this.getEnemy().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(enemyDamage < 0 ){
                            enemyDamage =0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - enemyDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }
            if (this.getEnemy().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı Yendiniz ! ");
                System.out.println(this.enemy.getDrop() + " para kazandınız !");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+ this.getEnemy().getDrop());
                System.out.println("Güncel paranız " + this.getPlayer().getMoney());
            }
        }
        return false;
    }
    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getEnemy().getName() + " Canı : "+ this.getEnemy().getHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Oyuncu Değeleri");
        System.out.println("----------------------");
        System.out.println("Can :" + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Blocklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar :" + this.getPlayer().getTotalDamage());
        System.out.println("Para : " + this.getPlayer().getMoney());


    }

    public void enemyStats(int i) {
        System.out.println(i + "." + this.getEnemy().getName() + " Değerleri");
        System.out.println("----------------------");
        System.out.println("Sağlık : " + this.getEnemy().getHealth());
        System.out.println("Hasar : " + this.getEnemy().getDamage());
        System.out.println("Ödül : " + this.getEnemy().getDrop());
    }

    public int randomEnemyNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxEnemy()) + 1;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxEnemy() {
        return maxEnemy;
    }

    public void setMaxEnemy(int maxEnemy) {
        this.maxEnemy = maxEnemy;
    }
}

