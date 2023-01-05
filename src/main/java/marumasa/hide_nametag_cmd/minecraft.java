package marumasa.hide_nametag_cmd;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public final class minecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        getCommand("nttoggle").setExecutor(new NameTagToggle(this,scoreboard));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
