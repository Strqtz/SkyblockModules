package com.strqtz.skyblockmodules.utils;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.ConfigCategory;
import org.lwjgl.Sys;

import java.io.File;
import java.util.concurrent.ExecutionException;

public class ConfigHandler {
    public static Configuration config;
    private static String file = "config/sbm.cfg";

    public static void init() {
        config = new Configuration(new File(file));
        try {
            config.load();
            System.out.println("[SBM] Loading config");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("[SBM] Error Loading config");
        } finally {
            config.save();
            System.out.println("[SBM] Saved config");
        }


    }
    public static int getInt(String category, String key) {
        config = new Configuration(new File(file));
        try {
            config.load();
            if(config.getCategory(category).containsKey(key)) {
                return config.get(category, key, 0).getInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            config.save();
        }
        return 0;
    }
    public static double getDouble(String category, String key) {
        config = new Configuration(new File(file));
        try {
            config.load();
            if(config.getCategory(category).containsKey(key)) {
                return config.get(category, key, 0D).getDouble();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            config.save();
        }
        return 0D;
    }
    public static String getString(String category, String key) {
        config = new Configuration(new File(file));
        try {
            config.load();
            if(config.getCategory(category).containsKey(key)) {
                return config.get(category, key, "").getString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            config.save();
        }
        return "";
    }
    public static boolean getBoolean(String category, String key) {
        config = new Configuration(new File(file));
        try {
            config.load();
            if(config.getCategory(category).containsKey(key)) {
                return config.get(category, key, 0).getBoolean();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            config.save();
        }
        return true;
    }

    public static void writeIntConfig(String category, String key, int value) {
        config = new Configuration(new File(file));
        try {
            config.load();
            int set = config.get(category, key, value).getInt();
            config.getCategory(category).get(key).set(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            config.save();
        }
    }

    public static void writeDoubleConfig(String category, String key, double value) {
        config = new Configuration(new File(file));
        try {
            config.load();
            double set = config.get(category, key, value).getDouble();
            config.getCategory(category).get(key).set(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            config.save();
        }
    }

    public static void writeStringConfig(String category, String key, String value) {
        config = new Configuration(new File(file));
        try {
            config.load();
            String set = config.get(category, key, value).getString();
            config.getCategory(category).get(key).set(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            config.save();
        }
    }

    public static void writeBooleanConfig(String category, String key, boolean value) {
        config = new Configuration(new File(file));
        try {
            config.load();
            boolean set = config.get(category, key, value).getBoolean();
            config.getCategory(category).get(key).set(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            config.save();
        }
    }

    public static boolean hasKey(String category, String key) {
        config = new Configuration(new File(file));
        try {
            config.load();
            if(!config.hasCategory(category)) return false;
            return config.getCategory(category).containsKey(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            config.save();
        }
        return false;
    }

    public static int initInt(String category, String key, int defaultValue) {
        config = new Configuration(new File(file));
        if(!hasKey(category, key)) {
            writeIntConfig(category, key, defaultValue);
            return defaultValue;
        } else {
            return getInt(category, key);
        }
    }

    public static double initDouble(String category, String key, double defaultValue) {
        config = new Configuration(new File(file));
        if(!hasKey(category, key)) {
            writeDoubleConfig(category, key, defaultValue);
            return defaultValue;
        } else {
            return getInt(category, key);
        }
    }

    public static String initString(String category, String key, String defaultValue) {
        config = new Configuration(new File(file));
        if(!hasKey(category, key)) {
            writeStringConfig(category, key, defaultValue);
            return defaultValue;
        } else {
            return getString(category, key);
        }
    }

    public static boolean initBoolean(String category, String key, boolean defaultValue) {
        config = new Configuration(new File(file));
        if(!hasKey(category, key)) {
            writeBooleanConfig(category, key, defaultValue);
            return defaultValue;
        } else {
            return getBoolean(category, key);
        }
    }

    public static void reloadConfig() {

    }
}
