/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: NVIM 0.6.1
* Date: 17/02/2022, Time: 18:02:00.
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
package io.jtrejosb.api.controller;

import java.util.List;

import io.jtrejosb.api.model.AppModel;
import io.jtrejosb.api.view.AppView;

public class AppController {
  private AppModel APM;
  private AppView APV;

  public AppController(AppModel APM,AppView APV) {
    this.APM=APM;
    this.APV=APV;
    this.APV.addFindListener(e->find());
    this.APV.addQueryAllListener(e->findAll());
  }

  private void find() {
    String ID=APV.getStudentID();
    if(!ID.isEmpty()) {
      String Q="SELECT * FROM students WHERE ID = ?";
      List<String> datalist=APM.getData(Q,ID);
      if(datalist.size()>0)
        APV.applyData(datalist);
      else
        APV.showWarning("No students with ID '"+ID+"' were found",2);
    } else {
      APV.showWarning("Student ID is required",0);
    }
  }

  private void findAll() {
    String Q="SELECT * FROM students";
    List<String> datalist=APM.getData(Q,null);
    if(datalist.size()>0)
      APV.applyData(datalist);
    else
      APV.showWarning("No students were found",2);
  }
}
