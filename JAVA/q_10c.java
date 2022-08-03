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

public class q_10c {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Department No. : ");
        int dno = input.nextInt();
        System.out.print("Enter the Department Name : ");
        String dname = input.next();
        System.out.print("Enter the Department Location : ");
        String dloc = input.next();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
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

// D:\VSCODE-FILES\JAVA>mysql -u root
// Welcome to the MySQL monitor.  Commands end with ; or \g.
// Your MySQL connection id is 29
// Server version: 5.5.5-10.4.22-MariaDB mariadb.org binary distribution
// Copyright (c) 2000, 2022, Oracle and/or its affiliates.
// Oracle is a registered trademark of Oracle Corporation and/or its
// affiliates. Other names may be trademarks of their respective
// owners.
// Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.
// mysql> use test;
// Database changed
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
