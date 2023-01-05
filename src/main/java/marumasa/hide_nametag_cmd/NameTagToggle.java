package marumasa.hide_nametag_cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.Set;

public class NameTagToggle implements CommandExecutor {
    private final minecraft mc;
    private final Scoreboard sb;
    final Team team;

    public NameTagToggle(minecraft minecraft, Scoreboard scoreboard) {
        mc = minecraft;
        sb = scoreboard;
        team = sb.registerNewTeam("marumasa.HideNameTag");

    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        final Player senderPlayer = (Player) sender;
        final String senderPlayerName = senderPlayer.getName();
        final Set<String> Entries = team.getEntries();

        for (String Name : Entries) {
            if (Name.equals(senderPlayerName)) {
                team.removeEntry(senderPlayerName);
                senderPlayer.sendMessage("ネームタグが表示に設定されました");
                return true;
            }
        }
        senderPlayer.sendMessage("ネームタグが非表示に設定されました");
        team.addEntry(senderPlayerName);
        return true;
    }
}
