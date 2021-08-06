package basic;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

import javax.security.auth.login.LoginException;

public class Test {
    public static JDA jda;
    public static String message = "`";
    public static void main(String[] args) throws LoginException {
        String token = "ODcxNTgyMzc4MDY4NDI2ODAz.YQdaWA.ofNwHiS7MATVQOPu_LKyz4bkQtk";

        jda = JDABuilder.createDefault(token).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.addEventListener(new list_see_listener());
    }
}

