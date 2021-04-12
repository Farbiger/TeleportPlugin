package de.farbiger;


import de.farbiger.listeners.ClickEvents;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

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

public final class teleportplugin extends JavaPlugin {
    private static Inventory inventory;

    @Override
    public void onEnable() {

        System.out.println("TELEPORT PLUGIN ENABLED");
        System.out.println("-----------------------");
        System.out.println("Plugin Coded by: Farbiger");
        System.out.println("-----------------------");
        System.out.println("TELEPORT PLUGIN ENABLED");

        Bukkit.getPluginManager().registerEvents(new ClickEvents() , this);
        inventory = Bukkit.createInventory(null , 9*4 , "§9Server §8» §9Teleporter");
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {

                inventory.addItem(getItem(onlinePlayer));


        }

    }

    @Override
    public void onDisable() {

    }

    public static Inventory getInventory() { return inventory; }

    public ItemStack getItem(Player player){
        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(player.getUniqueId()));
        skullMeta.setDisplayName("§a" + player.getName());
        skullMeta.setLocalizedName(player.getName());
        skullMeta.setLore(Arrays.asList("§9Teleport §8» §9Klicke auf den Spieler Kopf"));
        itemStack.setItemMeta(skullMeta);
        return itemStack;
    }
}
