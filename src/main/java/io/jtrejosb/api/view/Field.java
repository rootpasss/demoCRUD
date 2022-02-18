/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: NVIM 0.6.1
* Date: 17/02/2022, Time: 18:31:40.
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
package io.jtrejosb.api.view;

import java.awt.Color;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Field extends javax.swing.JTextField {
  private String PH;

  public Field(String PH) {
    this.PH=PH;
  }

  @Override
  public void paintComponent(java.awt.Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.GRAY);
    if(getText().isEmpty())
      g.drawString(PH,6,18);
  }
}
