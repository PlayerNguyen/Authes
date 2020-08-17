package com.playernguyen.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class CommandForgotPassword extends CommandAbstract {

    public CommandForgotPassword() {
        super("forgotpassword", "", "Forgot your password");
    }

    @Override
    public CommandState onCommand(CommandSender sender, List<String> arguments) {

        if (sender instanceof Player) {



            return CommandState.NOTHING;
        }
        return CommandState.INVALID_SENDER;
    }

    @Override
    public List<String> onTab(CommandSender sender, List<String> arguments) {
        return null;
    }
}
