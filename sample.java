import java.sql.*;

class Test {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/demodb";
    // Database credentials
    static final String USER = "dbuser";
    static final String PASS = "Kmit123$";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "CREATE TABLE Dept501 " +
                    "(deptno INTEGER not NULL, " +
                    " dname VARCHAR(255), " +
                    " loc VARCHAR(255), " +
                    " constraint pk_dept primary key (deptno))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            // STEP 5: Extract data from result set
            /*
             * while(rs.next()){
             * //Retrieve by column name
             * int id = rs.getInt("empno");
             * String first = rs.getString("ename");
             * //Display values
             * System.out.print("ID: " + id);
             * System.out.print(", First: " + first);
             * 
             * }
             */
            // STEP 6: Clean-up environment
            // rs.close();
            stmt.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
          // System.out.println("Goodbye!");
    }// end main
}
