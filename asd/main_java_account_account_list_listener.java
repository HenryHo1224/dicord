package account;

import basic.Test;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;
import java.util.List;

public class account_list_listener extends ListenerAdapter {
    public static database account = new database();
    private static HashMap<User, Integer> playerXp = new HashMap<>();
    public void onMessageReceived(MessageReceivedEvent event) {
        List<Role> member = event.getMember().getRoles();
        String Author_name = event.getAuthor().getName();

        MessageChannel channel = event.getChannel();

        String[] content = event.getMessage().getContentRaw().split(" ");

        String[] command_list = new String[]{"`create","`show","`check"};


        if (event.getAuthor().isBot()) return;
        if (content[0].equals(Test.message+"create")){
            channel.sendMessage("新帳號的名字是?").queue();
            String name = event.getMessage().getContentRaw();
            Test.jda.addEventListener(new create_listener());
            Test.jda.removeEventListener(this);

        }else if (content[0].equals(Test.message+"check")){
            channel.sendMessage("輸入帳戶名:").queue();

            Test.jda.addEventListener(new check_listener());
            Test.jda.removeEventListener(this);

        }else if (content[0].equals(Test.message+"show")){
            channel.sendMessage("所有人的財富 ").queue();
            for (String key : database.bank.keySet()) {
                channel.sendMessage((key+": "+ database.bank.get(key)+ " coins")).queue();
            }
            Test.jda.removeEventListener(this);
        }else if (content[0].equals(Test.message+"")){

        }else if (content[0].equals(Test.message+"")){

        }else if (!content[0].equals(command_list)){
            channel.sendMessage("輸入錯誤! ");
        }
    }
}
