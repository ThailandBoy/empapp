package com.empapp;

import java.sql.*;

public class EmployeeDaoImpl implements EmployeeDaoIntrf{
    Connection con;
    @Override
    public void createEmployee(Employee employee) {
        con = DBConnection.createDBConnection();
        String query = "insert into employee values(?,?,?,?)";
        try{

            // PreparedStatement - it is a dynamic query
            // for our goal need dynamic query
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, employee.getId());
            pstm.setString(2, employee.getName());
            pstm.setDouble(3, employee.getSalary());
            pstm.setInt(4, employee.getAge());
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee insert successfully!");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void showAllEmployee() {
        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM employeedb.employee";
        try {
            // here we need Static statement
            Statement stmt = con.createStatement();
            // executeQuery - it is return "ResultSet"
            ResultSet resultSet = stmt.executeQuery(query);
            System.out.println("-----------------------------------------------");
            System.out.format("%s|\t%s|\t%s|\t%s|\n","id","name","salary","age");
            while (resultSet.next()){
                System.out.format("%d|\t%s|\t%.2f|\t%d|\n",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4));
            }
            System.out.println("-----------------------------------------------");
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnId(int id) {
        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM employeedb.employee WHERE id="+id;
        try{
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            System.out.println("-----------------------------------------------");
            System.out.format("%s|\t%s|\t%s|\t%s|\n","id","name","salary","age");
            while (resultSet.next()){
                System.out.format("%d|\t%s|\t%.2f|\t%d|\n",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4));
            }
            System.out.println("-----------------------------------------------");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createDBConnection();
        String query = "UPDATE employee SET NAME=? WHERE id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Successful update!");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        con = DBConnection.createDBConnection();
        String query = "DELETE FROM employee WHERE id=?";
        try{
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1,id);
            int cnt = psmt.executeUpdate();
            if (cnt != 0)
                System.out.println("Delete successful");
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
