package account;

import account.database;
import basic.Test;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class login_listener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        List<Role> member = event.getMember().getRoles();
        String Author_name = event.getAuthor().getName();
        MessageChannel channel = event.getChannel();
        String[] login = event.getMessage().getContentRaw().split(" ");
        if (event.getAuthor().isBot()) {
            return;
        }

        if(login[0].equals(Test.message+"exit")){
            Test.jda.removeEventListener(this);
        }
        else if (login[0].equals(login[0])){
            account_list_listener.account.setlogin(login[0]);
            if(account_list_listener.account.checklogin(login[0])==true) {
                channel.sendMessage(account_list_listener.account.getAccess_result()).queue();
                Test.jda.removeEventListener(this);
            }else if (account_list_listener.account.checklogin(login[0])==false){
                channel.sendMessage(account_list_listener.account.getAccess_result()).queue();
            }


        }



    }
}