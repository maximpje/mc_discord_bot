package io.github.maximpje.mc_discord_bot;

import org.bukkit.plugin.java.JavaPlugin;

public final class McDiscordBot extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Mc_discord_bot is starting...");

        getServer().getPluginManager().registerEvents(new MinecraftEventListener(), this);

        DiscordClient bot = new DiscordClient();
    }

    @Override
    public void onDisable() {
        System.out.println("Mc_discord_bot is stopping...");
    }
}
