package account;

import account.database;
import basic.Test;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class create_listener extends ListenerAdapter {



    public void onMessageReceived(MessageReceivedEvent event) {
        List<Role> member = event.getMember().getRoles();
        String Author_name = event.getAuthor().getName();
        MessageChannel channel = event.getChannel();
        String[] content = event.getMessage().getContentRaw().split("");
        if (event.getAuthor().isBot()) {
            return;
        }

        if (content[0].equals(Test.message)){
            channel.sendMessage("頭一個字不能是 \" ` \"  ").queue();
        }else if(String.join("",content).equals(String.join("",content))) {

            database.createbank(String.join("",content));
            channel.sendMessage("完成").queue();
            Test.jda.removeEventListener(this);
        }



    }
}