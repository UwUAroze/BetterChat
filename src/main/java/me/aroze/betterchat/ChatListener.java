package me.aroze.betterchat;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class ChatListener{

    private final BetterChat plugin;

    public ChatListener(BetterChat plugin) {
        this.plugin = plugin;
    }

    public void addPacketListener() {

        plugin.getProtocolManager().addPacketListener(new PacketAdapter(plugin, PacketType.Play.Server.CHAT) {
            @Override
            public void onPacketSending(PacketEvent event) {

                PacketContainer packet = event.getPacket();

                System.out.println(packet.getModifier().read(0)); //??
                System.out.println(packet.getModifier().read(2)); //??

                System.out.println(packet.getModifier().read(1)); // Chat thing
                System.out.println(packet.getModifier().read(3)); // SYSTEM or CHAT
                System.out.println(packet.getModifier().read(4)); // Sender's uuid
                System.out.println(event.getPlayer().getUniqueId()); // Receiver's uuid

//                String rawText = TextComponent.toPlainText(chatData);
//                String messageString = TextComponent.toLegacyText(chatData);

            }
        });
    }

}