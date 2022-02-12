package edu.neumont.csc150;

public class Tank extends Zombie{
    private int baseHP;
    private int speed;

    private final int HP_MIN = 45;
    private final int HP_MAX = 70;
    private final int SPEED_MIN = 4;
    private final int SPEED_MAX = 8;
    private final int MODIFIER_MIN = 10;
    private final int MODIFIER_MAX = 20;

    private String attackType;
    private int damageDone;

    public Tank(){
        setArms(generateRandom(ARM_LEG_MIN, ARM_LEG_MAX));
        setLegs(generateRandom(ARM_LEG_MIN, ARM_LEG_MAX));
        setBaseHP(generateRandom(HP_MIN, HP_MAX));
        setSpeed(generateRandom(SPEED_MIN, SPEED_MAX));
        getAttackType(roll(1, 20));
        getDamage(attackType);
    }
    public Tank(int arms, int legs, int baseHP, int speed){
        setArms(arms);
        setLegs(legs);
        setBaseHP(baseHP);
        setSpeed(speed);
    }

    public int getDamageModifier(){
        return generateRandom(MODIFIER_MIN, MODIFIER_MAX);
    }


    @Override
    public void setBaseHP(int newBaseHP) {
        if (newBaseHP<=HP_MAX && newBaseHP>=HP_MIN){
            baseHP = newBaseHP;
        } else {
            throw new IllegalArgumentException("BaseHP entered is not in proper range. A random one will be generated.");
        }
    }

    @Override
    public void setSpeed(int newSpeed) {
        if (newSpeed<=SPEED_MAX && newSpeed>=SPEED_MIN){
            speed = newSpeed;
        } else {
            throw new IllegalArgumentException("*ERROR* New speed entered is not in proper range.");
        }

    }

    @Override
    public String getAttackType(int rollValue) {
        if (rollValue<10){
            attackType = "missed";
        } else if (rollValue>=10 && rollValue<=19){
            attackType = "hit";
        } else if (rollValue==20){
            attackType = "critical";
        }
        return attackType;
    }

    @Override
    public void getDamage(String attackType) {
        if (attackType.equals("missed")){
            damageDone = 0;
        } else if(attackType.equals("hit")){
            damageDone = (roll(3,6) + getDamageModifier());
        } else if(attackType.equals("critical")){
            damageDone = ((roll(3,6) + getDamageModifier())*3);
        }
    }

    @Override
    public String toString() {
        return "Tank{" +
                " arms=" + arms +
                ", legs=" + legs +
                ", baseHP=" + baseHP +
                ", speed=" + speed +
                ", attackType='" + attackType + '\'' +
                ", damageDone=" + damageDone +
                '}';
    }
}
