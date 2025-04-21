package io.github.maximpje.mc_discord_bot;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

import static io.github.maximpje.mc_discord_bot.DiscordEventListener.channel;

public class MinecraftEventListener implements Listener{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        try {
            String playerName = event.getPlayer().getName();
            channel.sendMessage(playerName + ": Joined the server!").queue();
            Bukkit.broadcastMessage("Welcome to the server " + playerName + "!");
        }catch(NullPointerException e){
            System.out.println("EXCEPT: Discord channel not set!");
        }
    }
    @EventHandler
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent event) {
        try {
            if(!event.getAdvancement().getKey().toString().contains("recipe"))
               channel.sendMessage(event.getPlayer().getName() + " has made " + Objects.requireNonNull(event.getAdvancement().getDisplay()).getTitle() + " congratulations!").queue();
        }catch(NullPointerException e){
            System.out.println("EXCEPT: Discord channel not set!");
        }
    }
}
