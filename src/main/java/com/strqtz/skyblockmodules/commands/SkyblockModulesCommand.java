package com.strqtz.skyblockmodules.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SkyblockModulesCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "skyblockmodules";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/skyblockmodules";
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.singletonList("sbm");
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        String txt = "--------------Skyblock Modules Help--------------" + "\n" + "help";

        IChatComponent chatComponent = new ChatComponentText(txt);

        sender.addChatMessage(chatComponent);
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
