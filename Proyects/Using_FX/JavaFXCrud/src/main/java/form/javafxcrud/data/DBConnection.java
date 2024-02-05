package form.javafxcrud.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public void getDBConection(){
        synchronized ("") {
            try {
                if (getCon() == null || con.isClosed()) {
                    try {
                        String url = "jdbc:mysql://localhost:3306/form1";
                        //Class.forName("com.mysql.cj.jdbc.Driver");
                        setCon(    DriverManager.getConnection(url, "Leon", "yoProgramo"));
                  
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("error");
                    }
                } else {
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public  Connection getCon() {
        return con;
    }

    public  void setCon(Connection conn) {
        con = conn;
    }

    public  void closeConn() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
