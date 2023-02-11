package com.empapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Employee management application");

        Scanner sc = new Scanner(System.in);

        EmployeeDaoIntrf dao = new EmployeeDaoImpl();

        do {
            System.out.println("1. Add employee\n" +
                    "2. Show all employee\n" +
                    "3. Show employee based on id\n" +
                    "4. Update employee\n" +
                    "5. Delete employee\n" +
                    "6. Exit");
            int ch = sc.nextInt();

            switch (ch){
                case 1:
                    Employee emp = new Employee();
                    System.out.println("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.println("Enter name: ");
                    String name = sc.next();
                    System.out.println("Enter salary: ");
                    double salary = sc.nextDouble();
                    System.out.println("Enter age: ");
                    int age = sc.nextInt();
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
                    int empid = sc.nextInt();
                    dao.showEmployeeBasedOnId(empid);
                    break;
                case 4:
                    System.out.println("Enter employee id to change 'name': ");
                    int case4id = sc.nextInt();
                    System.out.println("New name: ");
                    String case4name = sc.next();
                    dao.updateEmployee(case4id, case4name);
                    break;
                case 5:
                    System.out.println("Enter employee id to delete employee: ");
                    int case5id = sc.nextInt();
                    dao.deleteEmployee(case5id);
                    break;
                case 6:
                    System.out.println("Thank you for using our application!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice!");
                    break;
            }

        }while (true);



    }

}