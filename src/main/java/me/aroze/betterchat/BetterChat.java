package me.aroze.betterchat;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterChat extends JavaPlugin {

    private ProtocolManager protocolManager;
    public ProtocolManager getProtocolManager() {
        return protocolManager;
    }

    @Override
    public void onEnable() {
        protocolManager = ProtocolLibrary.getProtocolManager();

        ChatListener chatListener = new ChatListener(this);
        chatListener.addPacketListener();

        getCommand("lastlog").setExecutor(new TestCommand());
    }

    @Override
    public void onDisable() {
        //
    }
}
