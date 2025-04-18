package be.maxim.mc_discord_bot;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;
import java.util.Objects;
//import java.io.File;
//import java.util.Scanner;

public final class Mc_discord_bot extends JavaPlugin {

    private final ShardManager shardManager;

    public Mc_discord_bot() throws LoginException {
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault("TOKEN");
        builder.setStatus(OnlineStatus.ONLINE);
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    @Override
    public void onEnable() {
        System.out.println("Mc_discord_bot is starting...");
        Objects.requireNonNull(this.getCommand("test")).setExecutor(new CommandTest());

        try {
            Mc_discord_bot bot = new Mc_discord_bot();
        } catch (LoginException e) {
            System.out.println("ERROR: Discord ogin exception");
        }
    }

    @Override
    public void onDisable() {
        System.out.println("Mc_discord_bot is stopping...");
    }
}
