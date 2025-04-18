package be.maxim.mc_discord_bot;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import java.io.File;
import java.util.Scanner;
import javax.security.auth.login.LoginException;

public class DiscordClient {

    private final ShardManager shardManager;

    public DiscordClient() throws LoginException {
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault("TOKEN");
        builder.setStatus(OnlineStatus.ONLINE);
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public void StartBot(){
        try {
            DiscordClient bot = new DiscordClient();
        } catch (LoginException e) {
            System.out.println("ERROR: Discord ogin exception");
        }
    }

}
