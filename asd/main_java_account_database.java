package account;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;
import java.util.HashMap;

public class database {
    public static HashMap<String,Integer> bank= new HashMap<>();            ///bank database
    public static HashMap<String,String>RPG = new HashMap<>();              ///RPG database
    private static Integer value;
    private String error = new String();
    private static String money = new String();
    public  static String login = new String();
    public boolean access = false;
    public static String access_result = new String();

    public database(){
    }

    public static void createbank(String name){
        bank.put(name,0);
    }


    public static void setbank(String name, Integer money){
        value = bank.get(name);
        bank.replace(name,value + money);
    }

    public static String getbank(String name){
        money = bank.get(name).toString();
        return money;
    }

    public void setlogin(String login){
        this.login=login;
    }

    public String getlogin(){
        return login;
    }

    public boolean checklogin(String login){
        access = bank.containsKey(login);
        return access;
}
    public boolean getaccess(){
        return access;
    }

    public String getAccess_result(){
        if (access==true){
            access_result="成功登入";
        }else if (access==false){
            access_result="沒有此帳戶";
        }

        return access_result;
    }










}
