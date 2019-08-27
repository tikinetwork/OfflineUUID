package dev.foolen.offlineuuid.offlineuuid.commands;

import dev.foolen.offlineuuid.offlineuuid.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.UUID;

import static java.nio.charset.StandardCharsets.UTF_8;

public class OfflineUUID implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            System.out.println("You need to be a player to execute this command.");
            return true;
        }

        Player p = (Player) sender;

        if (!p.hasPermission("offlineuuid.use")) {
            p.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
            return true;
        }

        if (args.length == 0) {
            p.sendMessage(ChatColor.RED + "Please specify a playername.");
            p.sendMessage(ChatColor.RED + "Command usage: /offlineuuid <playername>");
            return true;
        }

        String offlinePlayerName = args[0];
        UUID uuid = UUID.nameUUIDFromBytes(("OfflinePlayer:" + offlinePlayerName).getBytes(UTF_8));

        p.sendMessage(Main.PREFIX + "The Offline UUID from " + offlinePlayerName + " is:");
        TextComponent message = new TextComponent(Main.PREFIX + ChatColor.WHITE + uuid);
        message.setClickEvent( new ClickEvent( ClickEvent.Action.SUGGEST_COMMAND, uuid.toString()));
        p.spigot().sendMessage(message);
        return true;
    }
}
