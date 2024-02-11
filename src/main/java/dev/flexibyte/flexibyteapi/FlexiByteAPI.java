package dev.flexibyte.flexibyteapi;

import dev.flexibyte.flexibyteapi.libraries.ParticleLibrary;
import dev.flexibyte.flexibyteapi.tools.ItemTools;
import dev.flexibyte.flexibyteapi.tools.PlayerTools;
import dev.flexibyte.flexibyteapi.tools.StringTools;
import dev.flexibyte.flexibyteapi.tools.WorldTools;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class FlexiByteAPI extends JavaPlugin {

    private Plugin plug;
    private Logger logger;

    private ParticleLibrary particleLib;
    private ItemTools itemTools;
    private PlayerTools playerTools;
    private StringTools stringTools;
    private WorldTools worldTools;

    public FlexiByteAPI(Plugin plug){
        //get plugin instance
        this.plug = plug;
    }

    @Override
    public void onEnable() {
        //get logger
        this.logger = plug.getLogger();

        logger.log(Level.INFO, "Successfully connected");

        particleLib = new ParticleLibrary(plug);
        logger.log(Level.INFO, "Loaded particle library");

        itemTools = new ItemTools();
        logger.log(Level.INFO, "Loaded item tools");
        playerTools = new PlayerTools();
        logger.log(Level.INFO, "Loaded player tools");
        stringTools = new StringTools();
        logger.log(Level.INFO, "Loaded string tools");
        worldTools = new WorldTools();
        logger.log(Level.INFO, "Loaded world tools");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ParticleLibrary getParticleLib() {
        return particleLib;
    }

    public ItemTools getItemTools() {
        return itemTools;
    }

    public PlayerTools getPlayerTools() {
        return playerTools;
    }

    public StringTools getStringTools() {
        return stringTools;
    }

    public WorldTools getWorldTools() {
        return worldTools;
    }


}
