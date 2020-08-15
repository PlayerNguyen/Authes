package com.playernguyen.command;

import com.playernguyen.config.LanguageFlag;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class CommandRegister extends CommandAbstract {

    public CommandRegister() {
        super("register");
    }

    @Override
    public CommandState onCommand(CommandSender sender, List<String> arguments) {
        if (sender instanceof Player) {
            Player player = ((Player) sender);
            // Already registered
            if (getAccountManager().getAccountFromUUID(player.getUniqueId()).isRegistered()) {
                player.sendMessage(getLanguage().get(LanguageFlag.ALREADY_REGISTERED));
                return CommandState.NOTHING;
            }

            // Registering
            if (arguments.size() < 2) {
                player.sendMessage(getLanguage().get(LanguageFlag.MISSING_REGISTER_COMMAND));
                return CommandState.NOTHING;
            }

            String password =
        }
        return CommandState.NOTHING;
    }

    @Override
    public List<String> onTab(CommandSender sender, List<String> arguments) {
        return null;
    }
}
