package com.playernguyen.command;

import org.bukkit.command.CommandSender;

import java.util.List;

public class CommandRecoveryPassword extends CommandAbstract {

    public CommandRecoveryPassword() {
        super("recoverypassword", "", "Recovery the password");
    }

    @Override
    public CommandState onCommand(CommandSender sender, List<String> arguments) {
        return null;
    }

    @Override
    public List<String> onTab(CommandSender sender, List<String> arguments) {
        return null;
    }
}
