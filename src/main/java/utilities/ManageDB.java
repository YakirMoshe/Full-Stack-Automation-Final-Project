package utilities;

import java.sql.DriverManager;

public class ManageDB extends CommonOps {

    //Creating a connection

    /**
     * This method initiates a connection with DB. Receives connection details from commonOps class(@BeforeClass). Also it defines SQL statement parameter
     *
     * @param dbURL
     * @param user
     * @param pass
     */
    public static void openConnection(String dbURL, String user, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, user, pass);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred while Connecting to DB, See Details: " + e);
        }
    }

    /**
     * This method closes a connection with DB
     */
    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error Occurred while Closing DB, See Details: \" + e");
        }
    }


}

