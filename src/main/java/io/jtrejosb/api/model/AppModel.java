/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: NVIM 0.6.1
* Date: 17/02/2022, Time: 17:51:02.
*
* Additional Info.
*
* Source Code Target Or Details:
*
*     []
*
* Licenses: GNU GPL v3.0, Eclipse Public License 2.0, personal for non-commercial purposes.
* Developer Contact: jtrejosb@live.com
* github.com/jtrejosb
*/
package io.jtrejosb.api.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class AppModel {
  private Connection CC;

  public AppModel() {
    connect();
  }

  private void connect() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url="jdbc:mysql://localhost:3306/demo2";
      String usr="root";
      String pwd="rootpass";
      System.out.println("[INFO] Connecting...");
      CC=DriverManager.getConnection(url,usr,pwd);
      System.out.println("[INFO] Successfully connected to the MySQL localhost server");
    } catch(Exception e) {
      System.out.println("[ERROR] Terminated due to authentication or connectivity issues");
      javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"Connection Error",
          javax.swing.JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    }
  }

  public List<Object> getData(String Q,String ID) {
    List<Object>datalist=new ArrayList<>();
    try {
      PreparedStatement PS=CC.prepareStatement(Q);
      if(ID!=null)
        PS.setString(1,ID);
      ResultSet RS=PS.executeQuery();
      while(RS.next()) {
        datalist.add(new Entity(RS.getString("id"),
                                RS.getString("name"),
                                RS.getString("grade1"),
                                RS.getString("grade2"),
                                RS.getString("grade3"),
                                RS.getString("average")));
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return datalist;
  }

  public void store(String ID,String name,double grade1,double grade2,double grade3,double average) {
    try {
      String Q="INSERT INTO students values(?,?,?,?,?,?)";
      PreparedStatement PS=CC.prepareStatement(Q);
      PS.setString(1,ID);
      PS.setString(2,name);
      PS.setDouble(3,grade1);
      PS.setDouble(4,grade2);
      PS.setDouble(5,grade3);
      PS.setDouble(6,average);
      PS.executeUpdate();
      System.out.println("[INFO] Data has been stored");
      System.out.println(average);
      System.out.println("Se registra en la BD");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }
}
