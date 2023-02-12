package com.empapp;

import java.sql.*;

public class TableOperationImpl implements TableOperationIntrf{
    Connection con;

    @Override
    public void createTableByName(String name) {
        con = DBConnection.createDBConnection();
        String query = "CREATE TABLE `employeedb`."+ name +
                "  (`id` BIGINT(20) NOT NULL,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  `lastName` VARCHAR(45) NULL,\n" +
                "  `age` TINYINT(3) NULL,\n" +
                "  PRIMARY KEY (`id`));";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            int cnt = pstm.executeUpdate();
        }catch (SQLException ex){
        }
    }

    @Override
    public void showAllTables() {
        con = DBConnection.createDBConnection();
        String query = "SHOW TABLES";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery(query);
            System.out.println("-----------------------------------------------");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
            System.out.println("-----------------------------------------------");
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteTableByName(String name) {
        con = DBConnection.createDBConnection();
        String query = "DROP TABLE " + name;
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
