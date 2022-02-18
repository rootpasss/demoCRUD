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

  public List<String> getData(String Q,String ID) {
    List<String>datalist=new ArrayList<>();
    try {
      PreparedStatement PS=CC.prepareStatement(Q);
      if(ID!=null)
        PS.setString(1,ID);
      ResultSet RS=PS.executeQuery();
      while(RS.next()) {
        datalist.add(RS.getString("id"));
        datalist.add(RS.getString("name"));
        datalist.add(RS.getString("grade1"));
        datalist.add(RS.getString("grade2"));
        datalist.add(RS.getString("grade3"));
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return datalist;
  }
}
