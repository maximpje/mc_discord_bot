package io.github.maximpje.mc_discord_bot;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

import java.util.Objects;

public class EventListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("echo")){
            String message = Objects.requireNonNull(event.getOption("message")).getAsString();
            event.reply(message).queue();
            Bukkit.getServer().broadcastMessage(message);
        }
    }
}
