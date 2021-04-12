package de.farbiger.listeners;

import de.farbiger.teleportplugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

/********************************************************************************
 *    Urheberrechtshinweis                                                      *
 *    Copyright © Farbiger 2021                                                 *
 *    Erstellt: 08.04.2018 / 02:09                                              *
 *                                                                              *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.          *
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,  *
 *    bei Pascal Falk. Alle Rechte vorbehalten.                                 *
 *                                                                              *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,       *
 *    öffentlichen Zugänglichmachung oder andere Nutzung                        *
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Farbiger.         *
 *******************************************************************************/

import java.util.Arrays;

public class ConnectionEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        teleportplugin.getInventory().addItem(getItem(e.getPlayer()));
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        teleportplugin.getInventory().clear();
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer != e.getPlayer()){
                teleportplugin.getInventory().addItem(getItem(onlinePlayer));

            }
        }
    }
    public ItemStack getItem(Player player){
        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(player.getUniqueId()));
        skullMeta.setDisplayName("§9Name §8» §c" + player.getName());
        skullMeta.setLocalizedName(player.getName());
        skullMeta.setLore(Arrays.asList("§9Teleport §8» §9Klicke auf den Spieler Kopf"));
        itemStack.setItemMeta(skullMeta);
        return itemStack;
    }
}
