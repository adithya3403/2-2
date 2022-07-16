// c. Demonstrate JDBC program to read three values (dno,dname,dloc) from the user and 
// insert those records into the dept table using Prepared Statement 
// The Reading of input should be first deptno followed by deptname followed by deptlocation
// Dept Schema
// +------------+---------------+-------+-------+-----------+-------+
// | Field      | Type          | Null  | Key   | Default   | Extra |
// +------------+---------------+-------+-------+-----------+-------+
// | deptno     | int(2)        | NO    | PRI   | NULL      |       |
// | dname      | varchar(50)   | NO    |       | NULL      |       |
// | location   | varchar(50)   | NO    |       | NULL      |       |
// +------------+---------------+-------+-------+-----------+-------+

// Sample Database :
// mysql> select * from dept;
// +--------+-------+----------+
// | deptno | dname | location |
// +--------+-------+----------+
// |      4 | ECE   | Collin   |
// |      5 | CSE   | Dallas   |
// |     12 | IT    | Denton   |
// +--------+-------+----------+
// 3 rows in set (0.00 sec)

import java.sql.*;
import java.util.*;

public class q10c {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Department No. : ");
        int dno = input.nextInt();
        System.out.print("Enter the Department Name : ");
        String dname = input.next();
        System.out.print("Enter the Department Location : ");
        String dloc = input.next();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "student", "student");
            PreparedStatement pstmt = null;
            String query = "INSERT INTO dept(deptno, dname, location)" + "VALUES (?, ?, ?)";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, dno);
            pstmt.setString(2, dname);
            pstmt.setString(3, dloc);
            int status = pstmt.executeUpdate();
            if (status > 0) {
                System.out.println("Record is inserted successfully !!!");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        input.close();
    }
}

// Expected Output:
// Enter the Department No. : 3
// Enter the Department Name : Mechanical
// Enter the Department Location : Dallas
// Record is inserted successfully !!!

// After Insertion, database would be as below:
// mysql> select * from dept;
// +--------+------------+----------+
// | deptno | dname      | location |
// +--------+------------+----------+
// |      3 | Mechanical | Dallas   |
// |      4 | ECE        | Collin   |
// |      5 | CSE        | Dallas   |
// |     12 | IT         | Denton   |
// +--------+------------+----------+
// 4 rows in set (0.00 sec)
