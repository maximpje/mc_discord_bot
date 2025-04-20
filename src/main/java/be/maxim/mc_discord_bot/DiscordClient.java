package be.maxim.mc_discord_bot;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.security.auth.login.LoginException;

public class DiscordClient {

    private ShardManager shardManager;

    public DiscordClient() throws LoginException {
        try {
            File token = new File("auth/tokens.txt");
            Scanner reader = new Scanner(token);
            while (reader.hasNextLine()) {
                String TOKEN = reader.nextLine();
                System.out.println(TOKEN);
                DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(TOKEN);
                builder.setStatus(OnlineStatus.ONLINE);
                shardManager = builder.build();
                System.out.println("Logged into DISCORD with: " + TOKEN);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Can't read tokens.txt");
        }
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

}
