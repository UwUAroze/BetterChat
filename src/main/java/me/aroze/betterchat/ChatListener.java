package me.aroze.betterchat;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.ComponentConverter;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class ChatListener{

    private final BetterChat plugin;

    public ChatListener(BetterChat plugin) {
        this.plugin = plugin;
    }

    public void addPacketListener() {

        plugin.getProtocolManager().addPacketListener(new PacketAdapter(plugin, PacketType.Play.Server.CHAT) {
            @Override
            public void onPacketSending(PacketEvent event) {

                System.out.println("a");

                PacketContainer packet = event.getPacket();

//                WrappedChatComponent message = packet.getChatComponents().read(0);
//                Player user = event.getPlayer();
//
//                BaseComponent[] chatData = ComponentConverter.fromWrapper(message);
//                String rawText = TextComponent.toPlainText(chatData);
//                String messageString = TextComponent.toLegacyText(chatData);

                System.out.println("b");

            }
        });
    }

}
