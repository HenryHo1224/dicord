package gambling;
import account.account_list_listener;
import account.login_listener;
import basic.Test;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class gambling_listener extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        List<Role> member = event.getMember().getRoles();
        String Author_name = event.getAuthor().getName();
        MessageChannel channel = event.getChannel();
        String content = event.getMessage().getContentRaw();
        if (event.getAuthor().isBot()) return;

        if (content.equals(Test.message+"exit") ){
            Test.jda.addEventListener(new login_listener());
        }else if (content.equals(Test.message+"t")) {
            if(account_list_listener.account.getaccess()==false) {
                channel.sendMessage("先登入").queue();
                Test.jda.addEventListener(new login_listener());
            }

            if(account_list_listener.account.getaccess()==true) {
                channel.sendMessage("`exit 來離開").queue();
                channel.sendMessage("老虎機賭注").queue();
                Test.jda.addEventListener(new tiger_machine_listener());

            }

        }
    }
}
