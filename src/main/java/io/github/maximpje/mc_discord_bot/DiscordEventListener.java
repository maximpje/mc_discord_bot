package io.github.maximpje.mc_discord_bot;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

public class DiscordEventListener extends ListenerAdapter {

    public static MessageChannel channel;

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("connect")){
            channel = event.getMessageChannel();
            event.reply("Set Broadcast channel").queue();

            Bukkit.getServer().broadcastMessage("Broadcast channel in discord set to: " + channel.getName());
        }
    }
}
