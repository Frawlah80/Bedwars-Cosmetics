package xyz.iamthedefender.cosmetics.util;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import xyz.iamthedefender.cosmetics.Cosmetics;

public class EntityUtil {

    public static void entityForPlayerOnly(Entity entityToHide, Player player){
        if (!Cosmetics.getInstance().getEntityPlayerHashMap().containsKey(entityToHide.getEntityId())){
            Cosmetics.getInstance().getEntityPlayerHashMap().put(entityToHide.getEntityId(), player);
        }
        PacketContainer packet = new PacketContainer(PacketType.Play.Server.ENTITY_DESTROY);
        int[] entityIds = new int[] { entityToHide.getEntityId() };
        packet.getIntegerArrays().write(0, entityIds);
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (!onlinePlayer.getUniqueId().equals(player.getUniqueId())){
                ProtocolLibrary.getProtocolManager().sendServerPacket(onlinePlayer, packet);
            }
        }
    }
}
