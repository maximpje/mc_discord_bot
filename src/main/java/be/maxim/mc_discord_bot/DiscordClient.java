package be.maxim.mc_discord_bot;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.security.auth.login.LoginException;

public class DiscordClient {

    private final ShardManager shardManager;
    private String TOKEN;


    public DiscordClient() throws LoginException {
        try {
            File token = new File("auth/tokens.txt");
            Scanner reader = new Scanner(token);
            while (reader.hasNextLine()) {
                TOKEN = reader.nextLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Can't read tokens.txt");
        }
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(TOKEN);
        builder.setStatus(OnlineStatus.ONLINE);
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public void StartBot(){
        DiscordClient bot;
        try {
            bot = new DiscordClient();
            System.out.println("started bot");
        } catch (LoginException e) {
            System.out.println("ERROR: Discord login exception");
        }
    }

}
