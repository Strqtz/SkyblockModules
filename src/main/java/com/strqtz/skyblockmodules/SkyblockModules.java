package com.strqtz.skyblockmodules;

import com.strqtz.skyblockmodules.commands.SkyblockModulesCommand;
import com.strqtz.skyblockmodules.utils.ConfigHandler;
import com.strqtz.skyblockmodules.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = SkyblockModules.MODID, name = SkyblockModules.MODNAME,version = SkyblockModules.VERSION, clientSideOnly = true)
public class SkyblockModules
{
    public static final String MODID = "sbm";

    public static final String MODNAME = "SkyblockModules";

    public static final String VERSION = "0.0.1";

    @Mod.Instance("sbm")
    public static SkyblockModules instance;


    public SkyblockModules() {
        instance = this;
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ConfigHandler.reloadConfig();
        MinecraftForge.EVENT_BUS.register(new com.strqtz.skyblockmodules.utils.EventHandler());
    }

    @EventHandler
    public void onInit(FMLInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);

        ClientCommandHandler.instance.registerCommand(new SkyblockModulesCommand());
    }

}
