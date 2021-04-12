package de.farbiger.listeners;

import de.farbiger.teleportplugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

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

public class ClickEvents implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        if (event.getView().getTitle().equals("§9Server §8» §9Teleporter")){
            event.setCancelled(true);
            if (event.getCurrentItem() != null){
                String playername = event.getCurrentItem().getItemMeta().getLocalizedName();
                event.getWhoClicked().closeInventory();
                event.getWhoClicked().teleport(Bukkit.getPlayer(playername));
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if (event.getItem() != null){
            if (event.getItem().getType() == Material.COMPASS){
                event.getPlayer().openInventory(teleportplugin.getInventory());

            }
        }

    }
}

