package be.maxim.mc_discord_bot;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;

public final class McDiscordBot extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Mc_discord_bot is starting...");
        Objects.requireNonNull(this.getCommand("test")).setExecutor(new CommandTest());

        DiscordClient bot = new DiscordClient();
    }

    @Override
    public void onDisable() {
        System.out.println("Mc_discord_bot is stopping...");
    }
}
