package io.github.maximpje.mc_discord_bot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static io.github.maximpje.mc_discord_bot.DiscordEventListener.channel;

public class MinecraftEventListener implements Listener{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        try {
            channel.sendMessage("Player joined the server: " + event.getPlayer().getName()).queue();
        }catch(NullPointerException e){
            System.out.println("EXCEPT: Discord channel not set!");
        }
    }
}
