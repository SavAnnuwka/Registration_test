package main.java.Helpers;

import java.sql.*;

public class DBRequests {
    private static final String DEFAULT_SERVER=null;
    private static final String DEFAULT_PORT =null;
    private static final String DEFAULT_DB=null ;
    static Connection conn;

    public static void init(String server, String port, String database, String user, String password) {
        String url = "jdbc:postgresql://" + server + ":" + port + "/" + database;
        try {
             conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void init(String user, String password) {
        init(DEFAULT_SERVER, DEFAULT_PORT, DEFAULT_DB, user, password);
    }
    public static String getUserFromDB(String email) throws SQLException {
        String request = "SELECT U.name FROM public.users  U WHERE U.email=  \'" + email + "\'";
        String result = "";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(request);
        while (rs.next()) {
            result = rs.getString(1);
        }
        rs.close();
        st.close();
        return result;
    }
}
