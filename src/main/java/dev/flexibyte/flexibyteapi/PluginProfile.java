package dev.flexibyte.flexibyteapi;

public class PluginProfile {

    private String name;
    private String description;
    private boolean enabled;


    public PluginProfile(String name, String description, boolean enabled) {
        this.name = name;
        this.description = description;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
