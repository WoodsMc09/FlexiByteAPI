package dev.flexibyte.flexibyteapi;

import org.bukkit.plugin.Plugin;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;

public class FlexiByteAPIManager {

    private Plugin plugin;

    private Connection connection;

    public FlexiByteAPIManager(Plugin plugin){
        this.plugin = plugin;
    }



    public Connection getConnection() throws SQLException {
        if(connection != null){
            return connection;
        }

        String url = "jdbc:mysql://web1.revivenode.com/flexibyt_data";
        String user = "flexibyt_data";
        String password = decode();

        Connection connection = DriverManager.getConnection(url, user, password);
        plugin.getServer().getConsoleSender().sendMessage("Successfully connected to database URL: " + url);

        this.connection = connection;

        return connection;
    }

    public void initializeDatabase() throws SQLException {

        PreparedStatement pluginProfileStatement = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS plugin_profile(name varchar(99) primary key, description varchar(99), enabled boolean)");

        pluginProfileStatement.execute();

        pluginProfileStatement.close();

        plugin.getServer().getConsoleSender().sendMessage("Successfully created table");

    }

    public PluginProfile findPluginProfileByName(String name) throws SQLException{

        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM plugin_profile WHERE name = ?");

        statement.setString(1, name);

        ResultSet results = statement.executeQuery();

        if(results.next()){

            String description = results.getString("description");
            boolean enabled = results.getBoolean("enabled");

            PluginProfile pluginProfile = new PluginProfile(name, description, enabled);

            statement.close();

            return pluginProfile;

        }

        statement.close();

        return null;
    }

    public void createPluginProfile(PluginProfile profile) throws SQLException{

        PreparedStatement statement = getConnection().prepareStatement("INSERT INTO plugin_profile(name, description, enabled) VALUES (?, ?, ?)");

        statement.setString(1, profile.getName());
        statement.setString(2, profile.getDescription());
        statement.setBoolean(3, profile.isEnabled());

        statement.executeUpdate();

        statement.close();
    }

    public void updatePluginProfile(PluginProfile profile) throws SQLException{

        PreparedStatement statement = getConnection().prepareStatement("UPDATE plugin_profile SET description = ?, enabled = ? WHERE name = ?");


        statement.setString(1, profile.getDescription());
        statement.setString(3, profile.getName());
        statement.setBoolean(2, profile.isEnabled());

        statement.executeUpdate();

        statement.close();
    }

    public PluginProfile getPluginProfileFromDatabase(String name) throws SQLException {

        PluginProfile profile = findPluginProfileByName(name);

        if (profile == null) {
            profile = new PluginProfile(name, "", true);
            createPluginProfile(profile);
        }

        return profile;
    }



    public void checkPluginProfile(PluginProfile profile) throws SQLException{
        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM plugin_profile WHERE name = ?");

        statement.setString(1, profile.getName());

        ResultSet results = statement.executeQuery();

        if(results.next()){

            boolean enabled = results.getBoolean("enabled");

            if(!enabled){
                statement.close();
                plugin.getServer().getLogger().log(Level.SEVERE, "["+ plugin.getName() +"] has been disabled by FlexiByte Services due to restricted activity! Contact: https://flexibyte.dev/contact");
                plugin.getServer().getPluginManager().disablePlugin(plugin);
            }

        }

        statement.close();
    }

    public void closeConnection(){

        try {

            if(this.connection != null)
                connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    private String decode(){

        List<String> list = FlexiByteAPI.getInfo().getStringList("plugin-info");

        for(String s : list){
            if(s.contains("serviceID:")){
                String e =  s.replace("serviceID: ", "").replace("93", Decoder.ninetyThree()).replace("7*", Decoder.seven()).replace("D*", Decoder.D()).replace("12", Decoder.twelve()).replace("A*", Decoder.a()).replace("12*", Decoder.Twelve()).replace("9*", Decoder.nine()).replace("K1", Decoder.k()).replace("01", Decoder.one()).replace(" ", "");

                String f = e.replace("lf", "l").replace("t12", "F").replace("x", "e").replace("2*", "i").replace("s1", "x").replace("2*", "B").replace("et", "t").replace("kf", "y").replace("yt", "t").replace("s12*", "e");

                return f.replace("tt", "By").replace("xi23", "teData23");
            }
        }

        return null;
    }

}
