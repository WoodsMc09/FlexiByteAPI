package dev.flexibyte.flexibyteapi;

import dev.flexibyte.flexibyteapi.libraries.ParticleLibrary;
import dev.flexibyte.flexibyteapi.tools.ItemTools;
import dev.flexibyte.flexibyteapi.tools.PlayerTools;
import dev.flexibyte.flexibyteapi.tools.StringTools;
import dev.flexibyte.flexibyteapi.tools.WorldTools;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class FlexiByteAPI {

    private Plugin plug = null;
    private Logger logger = null;

    private ParticleLibrary particleLib = null;
    private ItemTools itemTools = null;
    private PlayerTools playerTools = null;
    private StringTools stringTools = null;
    private WorldTools worldTools = null;



    public void initialize(Plugin plug, String dev, String client) {
        this.plug = plug;

        //get logger
        this.logger = plug.getLogger();

        //log connected
        logger.log(Level.INFO, "Successfully connected");

        //log libraries
        particleLib = new ParticleLibrary(plug);
        logger.log(Level.INFO, "Loaded particle library");

        //log tools
        itemTools = new ItemTools();
        logger.log(Level.INFO, "Loaded item tools");
        playerTools = new PlayerTools();
        logger.log(Level.INFO, "Loaded player tools");
        stringTools = new StringTools();
        logger.log(Level.INFO, "Loaded string tools");
        worldTools = new WorldTools(plug);
        logger.log(Level.INFO, "Loaded world tools");

        //log commands

        if(plug.getServer().getPluginCommand("flexibyte") == null){
            logger.log(Level.SEVERE, "Could not register command '/flexibyte'! Make sure command is registered in plugin.yml!");
            logger.log(Level.SEVERE, "IF IT IS REGISTERED PLEASE CONTACT A DEVELOPER AT FlexiByte Services!");
        }
        else {
            plug.getServer().getPluginCommand("flexibyte").setExecutor(new FlexiCommand(plug, dev, client, stringTools));
            logger.log(Level.INFO, "Successfully registered /flexibyte");
        }

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
