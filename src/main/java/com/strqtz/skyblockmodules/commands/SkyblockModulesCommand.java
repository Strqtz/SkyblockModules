package com.strqtz.skyblockmodules.commands;

import com.strqtz.skyblockmodules.utils.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
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
        String helptxt = EnumChatFormatting.DARK_PURPLE + "---------------" + EnumChatFormatting.GOLD + "Skyblock Modules Help" + EnumChatFormatting.DARK_PURPLE + "---------------" + "\n" + EnumChatFormatting.LIGHT_PURPLE+ "-" + EnumChatFormatting.GREEN + "help " + EnumChatFormatting.GOLD + "Usage = " + "/help <command>" + "\n" + EnumChatFormatting.LIGHT_PURPLE+ "-" + EnumChatFormatting.GREEN + "sbdungeons" + EnumChatFormatting.GOLD + "Usage = " + "/sbdungeons [player]";

        IChatComponent helpchatComponent = new ChatComponentText(helptxt);

        if(args.length > 0) {
            if(args[0].equalsIgnoreCase("help")) {
                sender.addChatMessage(helpchatComponent);
            } else if(args[0].equalsIgnoreCase("setkey")) {
                String key = args[1];
                ConfigHandler.writeStringConfig("api", "apiKey", key);
                IChatComponent hoverkey = new ChatComponentText(EnumChatFormatting.AQUA + key);
                IChatComponent chat = new ChatComponentText(EnumChatFormatting.DARK_PURPLE + "Set your API key to " + EnumChatFormatting.GOLD + key);
                HoverEvent hoverApi = new HoverEvent(HoverEvent.Action.SHOW_TEXT, hoverkey);
                chat.getChatStyle().setChatHoverEvent(hoverApi);
                sender.addChatMessage(chat);
            }
        }
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
