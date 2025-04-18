package be.maxim.mc_discord_bot;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;
import java.io.File;
import java.util.Scanner;

public final class Mc_discord_bot extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Mc_discord_bot is starting...");
        Objects.requireNonNull(this.getCommand("test")).setExecutor(new CommandTest());

    }

    @Override
    public void onDisable() {
        System.out.println("Mc_discord_bot is stopping...");
    }
}
