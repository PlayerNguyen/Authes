package com.playernguyen.command;

import com.playernguyen.config.LanguageFlag;
import com.playernguyen.util.EmailChecker;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class CommandChangeEmail extends CommandAbstract {
    public CommandChangeEmail() {
        super("changeemail", "<email>", "Change current email");
    }

    @Override
    public CommandState onCommand(CommandSender sender, List<String> arguments) {

        if (sender instanceof Player) {
            // Not enough arguments
            if (arguments.size() < 1) {
                // Help
                showHelp(sender);
                return CommandState.NOTHING;
            }

            String plainEmail = arguments.get(0);
            // if not an email
            if (!EmailChecker.check(plainEmail)) {
                sender.sendMessage(getLanguage().get(LanguageFlag.INVALID_EMAIL_FORMAT));
                return CommandState.NOTHING;
            }

            // Check whether the email has existed or not


            // Change email
            if (!getSQLAccountManager().changeEmail(((Player) sender).getUniqueId(), plainEmail)) {
                sender.sendMessage(getLanguage().get(LanguageFlag.CHANGE_EMAIL_FAIL));
                return CommandState.NOTHING;
            }

            sender.sendMessage(getLanguage().get(LanguageFlag.CHANGE_EMAIL_SUCCESS));

        }

        return CommandState.INVALID_SENDER;
    }

    @Override
    public List<String> onTab(CommandSender sender, List<String> arguments) {
        return null;
    }
}
