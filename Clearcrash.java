// 
// Decompiled by Procyon v0.5.36
// 

package com.apip.clearcrash;

import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Clearcrash extends JavaPlugin
{
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents((Listener)new ChatEvents(this), (Plugin)this);
    }
    
    public void onDisable() {
    }
}
