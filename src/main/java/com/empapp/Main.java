package com.empapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Employee management application");

        Scanner sc = new Scanner(System.in);

        EmployeeDaoIntrf dao = new EmployeeDaoImpl();
        TableOperationIntrf toi = new TableOperationImpl();

        do {
            System.out.println("1. Add employee\n" +
                    "2. Show all employee\n" +
                    "3. Show employee based on id\n" +
                    "4. Update employee\n" +
                    "5. Delete employee\n" +
                    "6. Exit\n" +
                    "7. Add employee without id. autoincrement test\n" +
                    "8. Create table by name\n" +
                    "9. Show all tables\n" +
                    "10. Drop table by name");
            int ch = sc.nextInt();

            Employee emp = new Employee();

            int id, age;
            String name;
            double salary;

            switch (ch){
                case 1:
                    System.out.println("Enter ID: ");
                    id = sc.nextInt();
                    System.out.println("Enter name: ");
                    name = sc.next();
                    System.out.println("Enter salary: ");
                    salary = sc.nextDouble();
                    System.out.println("Enter age: ");
                    age = sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    dao.createEmployee(emp);
                    System.out.println("");
                    break;
                case 2:
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter id to show details: ");
                    id = sc.nextInt();
                    dao.showEmployeeBasedOnId(id);
                    break;
                case 4:
                    System.out.println("Enter employee id to change 'name': ");
                    id = sc.nextInt();
                    System.out.println("New name: ");
                    name = sc.next();
                    dao.updateEmployee(id, name);
                    break;
                case 5:
                    System.out.println("Enter employee id to delete employee: ");
                    id = sc.nextInt();
                    dao.deleteEmployee(id);
                    break;
                case 6:
                    System.out.println("Thank you for using our application!");
                    System.exit(0);
                case 7:
                    System.out.println("Enter name: ");
                    name = sc.next();
                    System.out.println("Enter salary: ");
                    salary = sc.nextDouble();
                    System.out.println("Enter age: ");
                    age = sc.nextInt();
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    dao.createEmployeeWithoutId(emp);
                    System.out.println("");
                    break;
                case 8:
                    System.out.println("Enter table name: ");
                    name = sc.next();
                    toi.createTableByName(name);
                    break;
                case 9:
                    toi.showAllTables();
                    break;
                case 10:
                    System.out.println("Enter table name to delete: ");
                    name = sc.next();
                    toi.deleteTableByName(name);
                default:
                    System.out.println("Enter valid choice!");
                    break;
            }

        }while (true);



    }

}