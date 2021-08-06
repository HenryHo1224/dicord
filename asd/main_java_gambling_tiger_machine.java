package gambling;

import java.util.Random;

public class tiger_machine {

    private int bet ;
    Random rand = new Random();
    private boolean win =false;
    private int number;
    private int[] result = new int[10];
    private int award;

    public tiger_machine(){

    }

    public void setbet(int bet){
        this.bet=bet;
    }

    public int[] add(int result[]){
        for (int i=0;i<9;i++){
            number=rand.nextInt(7);
            result[i]=number;
        }
        return result;
    }

    public String getbet(){
        return Integer.toString(bet);
    }


    public String award(int[] result){
        win = iswin(result);

        if (win==true&&result[5]!=0){
            award=bet *result[5];
        }else if (win==true&&result[5]==0){
            award=bet*10;
        } else if (win == false) {
            award = 0;
        }



        return Integer.toString(award);
    }

    public String toString(int award){
        return Integer.toString(award);
    }

    public boolean iswin(int[] result){
        if(result[1]==result[5]&&result[5]==result[9]){
            win=true;
        }else if(result[4]==result[5]&&result[5]==result[6]){
            win=true;
        }else if(result[7]==result[5]&&result[5]==result[3]){
            win=true;
        }else if(result[1]==result[2]&&result[2]==result[3]){
            win=true;
        }else if(result[7]==result[8]&&result[8]==result[9]){
            win=true;
        }else {
            win = false;
        }

        System.out.println("");
        System.out.print(win);
        return win;
    }
}