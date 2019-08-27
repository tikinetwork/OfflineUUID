package dev.foolen.offlineuuid.offlineuuid;

import dev.foolen.offlineuuid.offlineuuid.commands.OfflineUUID;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static final String PREFIX = ChatColor.DARK_GRAY + "[" + ChatColor.WHITE + "OfflineUUID" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + " ";

    @Override
    public void onEnable() {
        registerCommands();
    }

    private void registerCommands() {
        getCommand("offlineuuid").setExecutor(new OfflineUUID());
    }
}
