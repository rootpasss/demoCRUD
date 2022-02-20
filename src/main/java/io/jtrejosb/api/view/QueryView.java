/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: NVIM 0.6.1
* Date: 18/02/2022, Time: 18:57:21.
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
import java.awt.Font;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import io.jtrejosb.api.model.Entity;

@SuppressWarnings("serial")
public class QueryView extends javax.swing.JFrame {
  private JPanel contentPane;
  private JLabel lTitle;
  private JLabel lProm;
  private JLabel lStatus;
  private Field fCode;
  private Field fName;
  private Field fGrade1;
  private Field fGrade2;
  private Field fGrade3;
  private JButton bFind;

  public QueryView() {
    setSize(450,300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosing(java.awt.event.WindowEvent evt) {
        clearAllFields();
      }
    });

    contentPane=new JPanel();
    contentPane.setLayout(null);
    add(contentPane);

    lTitle=new JLabel("CONSULTAR");
    lTitle.setBackground(Color.decode("#000000"));
    lTitle.setForeground(Color.decode("#FFFFFF"));
    lTitle.setFont(new Font(lTitle.getFont().getFontName(),Font.PLAIN,20));
    lTitle.setOpaque(true);
    lTitle.setBounds(0,0,getWidth(),35);
    lTitle.setHorizontalAlignment(SwingConstants.CENTER);

    fCode=new Field("Documento");
    fName=new Field("Nombre");
    fGrade1=new Field("Nota 1");
    fGrade2=new Field("Nota 2");
    fGrade3=new Field("Nota 3");

    bFind=new JButton("Consultar");

    lProm=new JLabel("Promedio: ");
    lProm.setFont(new Font(lProm.getFont().getFontName(),Font.PLAIN,17));
    lStatus=new JLabel("Resultado: ");
    lStatus.setFont(lProm.getFont());

    fCode.setBounds(310,40,90,30);
    fName.setBounds(60,80,200,30);
    fGrade1.setBounds(60,115,50,30);
    fGrade2.setBounds(120,115,50,30);
    fGrade3.setBounds(180,115,50,30);
    bFind.setBounds(310,155,95,25);
    lProm.setBounds(60,190,getWidth(),25);
    lStatus.setBounds(60,220,getWidth(),25);

    contentPane.add(lTitle);
    contentPane.add(fCode);
    contentPane.add(fName);
    contentPane.add(fGrade1);
    contentPane.add(fGrade2);
    contentPane.add(fGrade3);
    contentPane.add(bFind);
    contentPane.add(lProm);
    contentPane.add(lStatus);
  }

  public String getStudentID() {
    return fCode.getText();
  }

  public void addQueryListener(java.awt.event.ActionListener L) {
    bFind.addActionListener(L);
  }

  public void applyData(List<Object> datalist) {
    fName.setText(((Entity)datalist.get(0)).getName());
    fGrade1.setText(((Entity)datalist.get(0)).getGrade1());
    fGrade2.setText(((Entity)datalist.get(0)).getGrade2());
    fGrade3.setText(((Entity)datalist.get(0)).getGrade3());
    double prom=((Entity)datalist.get(0)).getAverage();
    lProm.setText("Promedio: "+prom);
    if(prom>=3)
      lStatus.setText("Resultado: Gana la materia");
    else
      lStatus.setText("Resultado: Pierde la materia");
  }

  private void clearAllFields() {
    fCode.setText("");
    fName.setText("");
    fGrade1.setText("");
    fGrade2.setText("");
    fGrade3.setText("");
  }
}
