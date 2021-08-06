package gambling;


import account.database;
import basic.Test;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.lang.reflect.Array;
import java.util.List;

public class tiger_machine_listener extends ListenerAdapter {
public int[] result = new int[10];
private String[] result_s= new String[10];
private String result_f = new String();
private StringBuffer sb = new StringBuffer();
private String award = new String();
private int j=0;

    public void onMessageReceived(MessageReceivedEvent event) {
        List<Role> member = event.getMember().getRoles();
        String Author_name = event.getAuthor().getName();
        MessageChannel channel = event.getChannel();
        String[] content = event.getMessage().getContentRaw().split("");
        if (event.getAuthor().isBot())return;

        if(content[0].equals(Test.message+"exit")){
            Test.jda.removeEventListener(this);
        } else if (content[0].equals(content[0])){
            int number =Integer.parseInt(content[0]);
            tiger_machine bet = new tiger_machine();
            bet.setbet(number);
            result = bet.add(result);

            for (int i = 1; i < 10; i++) {
                result_f = sb.append(result[i]).toString();
                if (i%3==0){
                    result_f= String.valueOf(sb.append("\n"));
                }
                System.out.println(result[i]);
            }
            channel.sendMessage(result_f).queue();
            result_f="";
            award = bet.award(result);
            channel.sendMessage("你得到了"+award +" coins").queue();
            Test.jda.removeEventListener(this);
        }




    }
}
