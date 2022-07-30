package me.aroze.betterchat;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class ChatListener{

    private final BetterChat plugin;
    public ChatListener(BetterChat plugin) { this.plugin = plugin; }

    static BaseComponent[] lastMessage;

    public void addPacketListener() {

        plugin.getProtocolManager().addPacketListener(new PacketAdapter(plugin, PacketType.Play.Server.CHAT) {
            @Override
            public void onPacketSending(PacketEvent event) {

                PacketContainer packet = event.getPacket();

//                System.out.println(packet.getModifier().read(0)); //??
//                System.out.println(packet.getModifier().read(2)); //??
//
                //System.out.println(packet.getModifier().read(1)); // Chat thing

//                System.out.println(packet.getModifier().read(3)); // SYSTEM or CHAT
//                System.out.println(packet.getModifier().read(4)); // Sender's uuid
//                System.out.println(event.getPlayer().getUniqueId()); // Receiver's uuid

                // lastMessage = (BaseComponent[]) packet.getModifier().read(1);

                String gson = GsonComponentSerializer.gson().serialize((Component) packet.getModifier().read(1));
                JsonObject jsonObject = (JsonObject) new JsonParser().parse(gson);
                System.out.println(jsonObject.toString());

                BaseComponent[] text = TextComponent.fromLegacyText(jsonObject.toString());
                System.out.println(Arrays.toString(text));

                event.getPlayer().spigot().sendMessage(ComponentSerializer.parse(jsonObject.toString()));

                lastMessage = text;

//                String rawText = TextComponent.toPlainText(chatData);
//                String messageString = TextComponent.toLegacyText(chatData);

            }
        });
    }

}