package RPG;

public class charactor {
    private int hp ;
    private int mp ;
    private int sp ;
    private int damage;
    private int power;



    public charactor(int hp ,int mp,int sp){
        this.hp=hp;
        this.mp=mp;
        this.sp=sp;
    }

    public void dead(){
        hp=0;
        mp=0;
        sp=0;
    }

    public int damage(int damage){
        hp = hp-damage;
        return hp;
    }

    public int power(int power){
        hp = mp-power;
        return mp;
    }


}
