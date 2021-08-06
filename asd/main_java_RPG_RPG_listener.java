package RPG;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import sun.rmi.transport.Channel;

public class RPG_listener extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event){
        String select = new String();
        String contect =  event.getMessage().getContentRaw();
        if (event.getAuthor().isBot()) return;

    }
}
