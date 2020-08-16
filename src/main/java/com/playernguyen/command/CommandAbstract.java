package com.playernguyen.command;

import com.playernguyen.AuthesInstance;
import com.playernguyen.config.LanguageFlag;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.Arrays;
import java.util.List;

public abstract class CommandAbstract extends AuthesInstance implements TabExecutor {

    private final String command;

    public CommandAbstract(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public abstract CommandState onCommand(CommandSender sender, List<String> arguments);

    public abstract List<String> onTab(CommandSender sender, List<String> arguments);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // No permission detect
        if (!sender.hasPermission("authes.*")
                || !sender.hasPermission("authes.".concat(getCommand()))) {
            sender.sendMessage(getLanguage().get(LanguageFlag.NO_PERMISSION_COMMAND));
            return true;
        }

        CommandState commandState = onCommand(sender, Arrays.asList(args));
        switch (commandState) {
            case NO_PERMISSION: {
                sender.sendMessage(getLanguage().get(LanguageFlag.NO_PERMISSION_COMMAND));
                return true;
            }

            case INVALID_SENDER: {
                sender.sendMessage(getLanguage().get(LanguageFlag.INVALID_SENDER));
                return true;
            }

            case NOTHING: {
                return true;
            }

            default:
                throw new IllegalStateException("Unexpected value: " + commandState);
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return onTab(sender, Arrays.asList(args));
    }
}
