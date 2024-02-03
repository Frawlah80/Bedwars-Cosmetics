package me.defender.cosmetics.category.bedbreakeffects.items;


import com.cryptomorin.xseries.XMaterial;
import com.hakan.core.utils.ColorUtil;
import me.defender.cosmetics.api.cosmetics.RarityType;
import me.defender.cosmetics.api.cosmetics.category.BedDestroy;
import me.defender.cosmetics.api.handler.ITeamHandler;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

/**
 * Bed destroy effect.
 * Spawns a hologram at the location of bed
 */
public class HologramBedDestroy extends BedDestroy {
    /** {@inheritDoc} */
    @Override
    public ItemStack getItem() {
        return new ItemStack(XMaterial.matchXMaterial("STICK").get().parseMaterial());
    }
    /** {@inheritDoc} */
    @Override
    public String base64() {
        return null;
    }
    /** {@inheritDoc} */
    @Override
    public String getIdentifier() {
        return "hologram";
    }
    /** {@inheritDoc} */
    @Override
    public String getDisplayName() {
        return "Hologram";
    }
    /** {@inheritDoc} */
    @Override
    public List<String> getLore() {
        return Arrays.asList("&7Spawns a hologram at the","&7location of bed");
    }
    /** {@inheritDoc} */
    @Override
    public int getPrice() {
        return 5000;
    }
    /** {@inheritDoc} */
    @Override
    public RarityType getRarity() {
        return RarityType.COMMON;
    }
    /** {@inheritDoc} */
    @Override
    public void execute(Player player, Location bedLocation, ITeamHandler victimTeam) {
        ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(bedLocation.add(0,1,0), EntityType.ARMOR_STAND);
        stand.setVisible(false);
        stand.setGravity(false);
        stand.setCustomName(ColorUtil.colored("&c" + victimTeam.getName() + "'s Bed was destroyed by " + player.getDisplayName()));
        stand.setCustomNameVisible(true);
    }
}