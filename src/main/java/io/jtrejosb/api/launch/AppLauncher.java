/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: NVIM 0.6.1
* Date: 17/02/2022, Time: 18:34:27.
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
package io.jtrejosb.api.launch;

import java.awt.EventQueue;

import javax.swing.UIManager;

import io.jtrejosb.api.controller.AppController;
import io.jtrejosb.api.model.AppModel;
import io.jtrejosb.api.view.AppView;
import io.jtrejosb.api.view.PrintView;
import io.jtrejosb.api.view.QueryView;

public class AppLauncher {
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
          AppModel APM=new AppModel();
          AppView APV=new AppView();
          QueryView QV=new QueryView();
          new AppController(APM,APV,QV);
        } catch(Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
