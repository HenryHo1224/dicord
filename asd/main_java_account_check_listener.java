package account;

import account.database;
import basic.Test;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class check_listener extends ListenerAdapter {



    public void onMessageReceived(MessageReceivedEvent event) {
        List<Role> member = event.getMember().getRoles();
        String Author_name = event.getAuthor().getName();
        MessageChannel channel = event.getChannel();
        String name = event.getMessage().getContentRaw();

        if (event.getAuthor().isBot()) {
            return;
        }



        if(name.equals(name)) {
            System.out.println(name);
            System.out.println(database.getbank(name));
            event.getChannel().sendMessage(name+ ": "+database.getbank(name) +" coins").queue();
            Test.jda.removeEventListener(this);
        }



    }
}