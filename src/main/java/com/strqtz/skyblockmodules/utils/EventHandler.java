package com.strqtz.skyblockmodules.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Timer;
import java.util.TimerTask;

public class EventHandler {
    @SubscribeEvent
    public void onChatMessage(ClientChatReceivedEvent event) {
        String msg = Utils.cleanColour(event.message.getUnformattedText());
        if(msg.startsWith("Your new API key is ") && Utils.checkonHypixel()) {
            String key = event.message.getSiblings().get(0).getChatStyle().getChatClickEvent().getValue();
            ConfigHandler.writeStringConfig("api", "apiKey", key);
            IChatComponent hoverkey = new ChatComponentText(EnumChatFormatting.AQUA + key);
            IChatComponent chat = new ChatComponentText(EnumChatFormatting.DARK_PURPLE + "Set your API key to " + EnumChatFormatting.GOLD + key);
            HoverEvent hoverApi = new HoverEvent(HoverEvent.Action.SHOW_TEXT, hoverkey);
            chat.getChatStyle().setChatHoverEvent(hoverApi);
            Minecraft.getMinecraft().thePlayer.addChatMessage(chat);
        }
    }
}
