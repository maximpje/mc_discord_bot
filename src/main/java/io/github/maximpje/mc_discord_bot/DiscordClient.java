package io.github.maximpje.mc_discord_bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

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
                JDA bot = JDABuilder.createDefault(TOKEN)
                        .addEventListeners(new EventListener())
                        .build();
                System.out.println("Logged into DISCORD with: " + TOKEN);
                bot.updateCommands().addCommands(
                        Commands.slash("echo", "Repeats messages back to you.")
                                .addOption(OptionType.STRING, "message", "The message to repeat.")
                ).queue();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Can't read tokens.txt");
        }

    }
}
