package com.strqtz.skyblockmodules.utils;

import net.minecraft.client.Minecraft;

public class Utils {
    public static String cleanColour(String in) {
        return in.replaceAll("(?i)\\u00A7.", "");
    }


    public static boolean checkonHypixel() {
        Minecraft mc = Minecraft.getMinecraft();
        if(mc != null && mc.theWorld != null && !mc.isSingleplayer()) {
            return mc.getCurrentServerData().serverIP.toLowerCase().contains("hypixel.net");
        }
        return false;
    }
}
