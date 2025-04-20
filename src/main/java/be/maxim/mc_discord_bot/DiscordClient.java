package be.maxim.mc_discord_bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DiscordClient {

    public DiscordClient(){
        try {
            File token = new File("auth/tokens.txt");
            Scanner reader = new Scanner(token);
            while (reader.hasNextLine()) {
                String TOKEN = reader.nextLine();
                JDA bot = JDABuilder.createDefault(TOKEN).build();
                System.out.println("Logged into DISCORD with: " + TOKEN);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Can't read tokens.txt");
        }
    }


}
