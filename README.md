FlexiByte Services, Developer Utilities Plugin

This plugin contains a list of useful methods that make it easier to code.
This includes:
- A library of different particle effects
- Create items with custom names, lores, and model datas with one method
- Create player skulls
- Create potions
- Add enchant glint
- Get nearby players
- Format chat color codes
- Format prefixes
- Get strings from config and format
- Format chat color codes in string lists
- Get string lists from config and format
- Check chunks for blocks
- Check chunks for entities
- Get a list of all blocks in a chunk
- Remove all blocks in a chunk
- Get a list of all of one block in a chunk
- Get nearby blocks
- Get random location
- More soon to come..


**Implementation:**

pom.xml:
      
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>

        <dependency>
            <groupId>com.github.WoodsMc09</groupId>
            <artifactId>FlexiByteAPI</artifactId>
            <version>Version</version>
        </dependency>

Main class:

    private FlexiByteAPI api = null;

    @Override
    public void onEnable() {
        // Plugin startup logic

        api = new FlexiByteAPI();

        api.initialize(this, "<Dev>", "<Client>");

    }

plugin.yml:

    commands:
      flexibyte:
        description: "FlexiByte Services, Plugin Information"
        permission: flexibyte.info
        permission-message: "I'm sorry only admins can execute this command!"
        usage: "USAGE: /flexibyte"
