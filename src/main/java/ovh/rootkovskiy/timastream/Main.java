package ovh.rootkovskiy.timastream;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("Plugin enabled");
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "TimaStream v0.1 Loaded and Enabled!" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "MC Version: 1.12.2" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "Author: Timur Rootkovskiy (Adminov)" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "VK: @timurroot" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled");
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "TimaStream v0.1 Disabled!" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "MC Version: 1.12.2" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "Author: Timur Rootkovskiy (Adminov)" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "VK: @timurroot" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "Goodbye ;p" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + getConfig().getString("messages.not_player").replace("&", "§"));
            return true;
        }


        if (!sender.hasPermission("tima.stream")) {
            sender.sendMessage(getConfig().getString("messages.noperm").replace("&", "§"));
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(getConfig().getString("messages.noargs").replace("&", "§"));
            return true;
        }


        sender.sendMessage(getConfig().getString("messages.strstart").replace("&", "§"));

        for (final Player plrs : Bukkit.getOnlinePlayers()) {
            plrs.sendMessage(getConfig().getString("messages.stream").replace("&", "§").replaceAll("%player%", sender.getName()).replaceAll("%link%", args[0]));

        }
        return true;
    }
}
