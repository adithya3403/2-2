// 8.a.Write a java program to store the employee details in an ArrayList and
// display the employee details in ascending order of their experience. Create
// 'Employee' class with two instance variables Employee name and Employee
// experience (no. of years).

import java.util.*;

class Employee {
    String empname;
    int exp;

    Employee(String empname, int exp) {
        this.empname = empname;
        this.exp = exp;
    }

    public String toString() {
        return this.empname + " " + this.exp;
    }
}

class Sortbyexp implements Comparator<Employee> {
    public int compare(Employee a, Employee b) {
        return a.exp - b.exp;
    }
}

class q8a {
    public static void main(String[] args) {
        ArrayList<Employee> ar = new ArrayList<Employee>();
        ar.add(new Employee("John", 5));
        ar.add(new Employee("Nic", 3));
        ar.add(new Employee("Roma", 9));
        System.out.println("Unsorted Emp List");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i).toString());
        Collections.sort(ar, new Sortbyexp());
        System.out.println("Sorted by Experience");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i).toString());
    }
}

// EXPECTED OUTPUT :
// Unsorted Emp List
// John 5
// Nic 3 
// Roma 9
// Sorted by Experience
// Nic 3
// John 5
// Roma 9