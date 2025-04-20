package io.github.maximpje.mc_discord_bot;

import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

public class DiscordEventListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("connect")){
            Channel channel = event.getChannel();
            event.reply("Set Broadcast channel").queue();

            Bukkit.getServer().broadcastMessage("Broadcast channel in discord set to: " + channel.getName());
        }
    }
}
