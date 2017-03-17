import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

class Database_controller {

    //global variables
    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = "jdbc:sqlserver://studev.groept.be\\groept";
    private static final String user = "a14_SD405";
    private static final String password = "a14_SD405";
    private static String UserDocuments = "";
    private static String Appdata = "";
    private static String Root = "";
    private static String LocalAppdata = "";

    //methods
    public Database_controller(String gameTitle, String username) {
        // TODO Auto-generated constructor stub
        this.addLibrary(gameTitle, username);
    }

    public Database_controller() {
    }

    private static void LoadDriver() {
        //String initialize = RegistryReader.readRegistry("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\User Shell Folders", "(Default)");
        UserDocuments = RegistryReader.readRegistry("Personal");
        Appdata = RegistryReader.readRegistry("AppData");
        LocalAppdata = RegistryReader.readRegistry("Local AppData");

        if (UserDocuments.contains("%USERPROFILE%"))
            UserDocuments = System.getProperty("user.home") + UserDocuments.substring(UserDocuments.indexOf("%USERPROFILE%") + 13);
        if (Appdata.contains("%USERPROFILE%"))
            Appdata = System.getProperty("user.home") + Appdata.substring(Appdata.indexOf("%USERPROFILE%") + 13);
        if (LocalAppdata.contains("%USERPROFILE%"))
            LocalAppdata = System.getProperty("user.home") + LocalAppdata.substring(LocalAppdata.indexOf("%USERPROFILE%") + 13);

        try {
            Class.forName(driver);
            //System.out.println(driverName + " loaded.");
        } catch (ClassNotFoundException e) {
            System.out.println("*** error loading driver *** \n\t" + e);
        }
    }

    public static String[] showDatabaseContent(long Game_ID, String Directory) {
        LoadDriver();
        Root = Directory;

        String query = "Select Game_ID, Location, Save_location FROM Game_exe_locations WHERE Game_ID = " + Game_ID;
        Connection con;
        Statement st;
        ResultSet rs = null;
        String temp[];

        try {
            con = DriverManager.getConnection(url, user, password);
            //System.out.println("\nUsing driver \"" + DriverManager.getDriver(url).getClass().getName() + "\"\n\n");

            st = con.createStatement();
            rs = st.executeQuery(query);

            rs.next();
            temp = new String[]{rs.getString("Location"), rs.getString("Save_location")};

        } catch (SQLException e) {
            temp = null;
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Thread.currentThread().getStackTrace();
            }
        }
        if (temp != null) {
            if (temp[1].contains("UserDocuments"))
                temp[1] = UserDocuments + temp[1].substring(temp[1].indexOf("UserDocuments") + 13);
            if (temp[1].contains("Roaming"))
                temp[1] = Appdata + temp[1].substring(temp[1].indexOf("Roaming") + 7);
            if (temp[1].contains("LocalAppdata"))
                temp[1] = LocalAppdata + temp[1].substring(temp[1].indexOf("LocalAppdata") + 12);
            if (temp[1].contains("Root"))
                temp[1] = Root + temp[1].substring(temp[1].indexOf("Root") + 4);
        }

        return temp;
    }

    private static void addContent(Long Game_ID, String Location, String Save_location) {
        LoadDriver();

        Connection con;
        Statement st;

        try {
            con = DriverManager.getConnection(url, user, password);
            //System.out.println("\nUsing driver \"" + DriverManager.getDriver(url).getClass().getName() + "\"\n\n");

            st = con.createStatement();


            String sql = "INSERT INTO dbo.Game_exe_locations ([Game_ID],[Location], [Save_location]) " + "VALUES (" + Game_ID + ", '" + Location + "', '" + Save_location + "')";
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editContent(Long Game_ID, String Location, String Save_location, String Directory) {
        LoadDriver();
        Root = Directory;

        if (Save_location.contains(UserDocuments))
            Save_location = "UserDocuments" + Save_location.substring(UserDocuments.length());
        if (Save_location.contains(Appdata))
            Save_location = "Roaming" + Save_location.substring(Appdata.length());
        if (Save_location.contains(LocalAppdata))
            Save_location = "LocalAppdata" + Save_location.substring(LocalAppdata.length());
        if (Save_location.contains(Root))
            Save_location = "Root" + Save_location.substring(Root.length());
        Connection con;
        Statement st;
        ResultSet rs;

        try {
            con = DriverManager.getConnection(url, user, password);
            //System.out.println("\nUsing driver \"" + DriverManager.getDriver(url).getClass().getName() + "\"\n\n");

            st = con.createStatement();

            String query = "Select Game_ID, Location FROM Game_exe_locations WHERE Game_ID = " + Game_ID;
            rs = st.executeQuery(query);

            rs.next();
            rs.getString("Location");

            String sql = "UPDATE dbo.Game_exe_locations SET [Location] = '" + Location + "', [Save_location] = '" + Save_location + "'  WHERE Game_ID = " + Game_ID;
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            addContent(Game_ID, Location, Save_location);
        }
    }

    public void clearComparison(String Name) {
        LoadDriver();
        Connection con;
        Statement st;
        ResultSet rs;

        try {
            con = DriverManager.getConnection(url, user, password);
            //System.out.println("\nUsing driver \"" + DriverManager.getDriver(url).getClass().getName() + "\"\n\n");

            st = con.createStatement();
            String query = "DELETE FROM Comparison WHERE Player = '" + Name + "'";
            rs = st.executeQuery(query);
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            //System.out.println(e);
        }
    }

    public void addLibrary(String gameName, String Name) {
        LoadDriver();
        Connection con;
        Statement st;
        try {

            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            String sql = "INSERT INTO dbo.Comparison ([Player],[gameName]) " + "VALUES ('" + Name + "', '" + gameName + "')";
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Compare> checkLibrary(String name) {
        LoadDriver();

        ObservableList<Compare> list1 = FXCollections.observableArrayList();
        String query = "Select * FROM Comparison WHERE Player<>'" + name + "'";
        //String query = "Select * FROM Comparison WHERE Game_ID = " + Game_ID;
        Connection con;
        Statement st;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            //System.out.println("\nUsing driver \"" + DriverManager.getDriver(url).getClass().getName() + "\"\n\n");

            st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                list1.add(new Compare(rs.getString("Player"), rs.getString("gameName")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list1;
    }
}
