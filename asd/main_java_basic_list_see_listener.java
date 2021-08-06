package basic;

import RPG.RPG_listener;
import account.account_list_listener;
import gambling.gambling_listener;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class list_see_listener extends ListenerAdapter {
    RPG.script run = new RPG.script();
    String text = new String();

    public void onMessageReceived(MessageReceivedEvent event){
        text = run.opening();
        List<Role> member = event.getMember().getRoles();
        String Author_name = event.getAuthor().getName();
        MessageChannel channel = event.getChannel();
        String content = event.getMessage().getContentRaw();
        if (event.getAuthor().isBot()) return; // don't respond to other bot

        if (content.equals(Test.message+"help")){
            channel.sendMessage(Test.message+"gambling = 賭場 ").queue();
            channel.sendMessage(Test.message+"RPG = RPG").queue();
            channel.sendMessage(Test.message+"account = 帳號中心").queue();

        }else if(content.equals(Test.message+"gambling")){
            channel.sendMessage("遊戲指令 ").queue();
            channel.sendMessage(Test.message+"t = 老虎機 ").queue();
            Test.jda.addEventListener(new gambling_listener());


        }else if (content.equals(Test.message+"RPG")){
            channel.sendMessage("創建RPG中").queue();
            Test.jda.addEventListener(new RPG_listener());


        }else if (content.equals(Test.message+"account")){
            channel.sendMessage(Test.message+"create = 開新account").queue();
            channel.sendMessage(Test.message+"check = 帳戶查詢").queue();
            channel.sendMessage(Test.message+"show = 帳戶列表").queue();
            Test.jda.addEventListener(new account_list_listener());

        }

        
    }
}
