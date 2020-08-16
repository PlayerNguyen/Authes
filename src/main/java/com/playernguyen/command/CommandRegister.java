package com.playernguyen.command;

import com.playernguyen.config.ConfigurationFlag;
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

            // If not validate arguments
            if (arguments.size() < 2) {
                player.sendMessage(getLanguage().get(LanguageFlag.MISSING_REGISTER_COMMAND));
                return CommandState.NOTHING;
            }

            // Valid the confirm password
            String password = arguments.get(0);
            String confirmPassword = arguments.get(1);
            if (!password.equalsIgnoreCase(confirmPassword)) {
                player.sendMessage(getLanguage().get(LanguageFlag.NOT_MATCH_REGISTER));
                return CommandState.NOTHING;
            }

            // Password checker
            // Length
            if (password.length() < getConfiguration().getInt(ConfigurationFlag.PASSWORD_MIN_SIZE)) {
                player.sendMessage(getLanguage().get(LanguageFlag.PASSWORD_TOO_SHORT));
                return CommandState.NOTHING;
            }

            // Registering
            if (getSQLAccountManager().register(player.getUniqueId(), password)) {
                // Set the registered to true and message to player
                player.sendMessage(getLanguage().get(LanguageFlag.REGISTER_SUCCESS));
                getAccountManager().getAccountFromUUID(player.getUniqueId()).setRegistered(true);
                // Auto login
                if (getConfiguration().getBoolean(ConfigurationFlag.LOGIN_AFTER_REGISTER)) {
                    getSessionManager().createSession(player.getUniqueId());
                    player.sendMessage(getLanguage().get(LanguageFlag.LOGIN_SUCCESS));
                }
            } else {
                // False
                player.sendMessage(getLanguage().get(LanguageFlag.REGISTER_FAILED));
            }
            return CommandState.NOTHING;

        } else {
            return CommandState.INVALID_SENDER;
        }
    }

    @Override
    public List<String> onTab(CommandSender sender, List<String> arguments) {
        return null;
    }
}
