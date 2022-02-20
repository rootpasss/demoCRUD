/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: NVIM 0.6.1
* Date: 17/02/2022, Time: 18:06:19.
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

import java.text.DecimalFormat;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AppView extends javax.swing.JFrame {
  private JPanel contentPane;
  private Field fCode;
  private Field fName;
  private Field fGrade1;
  private Field fGrade2;
  private Field fGrade3;
  private JButton bCalc;
  private JButton bPrintAll;
  private JButton bQueryAll;
  private JButton bFind;
  private JLabel lTitle;
  private JLabel lProm;
  private JLabel lStatus;

  public AppView() {
    super("CALCULO DE PROMEDIO");
    System.out.println("[INFO] Preparing GUI client...");
    setSize(450,400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosing(java.awt.event.WindowEvent evt) {
        System.out.println("[INFO] Finished");
        System.exit(0);
      }
      @Override
      public void windowOpened(java.awt.event.WindowEvent evt) {
        System.out.println("[INFO] Ready");
      }
    });

    contentPane=new JPanel();
    contentPane.setLayout(null);
    add(contentPane);

    lTitle=new JLabel("CALCULAR PROMEDIO");
    lTitle.setBackground(Color.decode("#000000"));
    lTitle.setForeground(Color.decode("#FFFFFF"));
    lTitle.setFont(new Font(lTitle.getFont().getFontName(),Font.PLAIN,20));
    lTitle.setOpaque(true);
    lTitle.setBounds(0,0,getWidth(),35);
    lTitle.setHorizontalAlignment(SwingConstants.CENTER);

    fName=new Field("Nombre");
    fCode=new Field("CC");
    fGrade1=new Field("Nota 1");
    fGrade2=new Field("Nota 2");
    fGrade3=new Field("Nota 3");

    bCalc=new JButton("Calcular");
    bPrintAll=new JButton("Imprimir Total");
    bQueryAll=new JButton("Consulta Total");//TODO: Create view for this action (frame with JTable)
    bFind=new JButton("Consultar");

    lProm=new JLabel();
    lProm.setFont(new Font(lProm.getFont().getFontName(),Font.PLAIN,17));
    lStatus=new JLabel();
    lStatus.setFont(new Font(lProm.getFont().getFontName(),Font.PLAIN,17));
    lStatus.setForeground(Color.RED);

    fName.setBounds(30,90,150,25);
    fCode.setBounds(210,90,60,25);
    fGrade1.setBounds(30,125,60,25);
    fGrade2.setBounds(120,125,60,25);
    fGrade3.setBounds(210,125,60,25);
    bCalc.setBounds(185,170,85,25);
    lProm.setBounds(30,210,150,25);
    lStatus.setBounds(30,235,getWidth(),25);
    bPrintAll.setBounds(30,290,125,25);
    bQueryAll.setBounds(160,290,130,25);
    bFind.setBounds(295,290,125,25);

    contentPane.add(lTitle);
    contentPane.add(fName);
    contentPane.add(fCode);
    contentPane.add(fGrade1);
    contentPane.add(fGrade2);
    contentPane.add(fGrade3);
    contentPane.add(bCalc);
    contentPane.add(lProm);
    contentPane.add(lStatus);
    contentPane.add(bPrintAll);
    contentPane.add(bQueryAll);
    contentPane.add(bFind);
    setVisible(true);
  }

  public String getStudentID() {
    return fCode.getText();
  }

  public String getStudentName() {
    return fName.getText();
  }

  public double getGrade1() {
    return Double.parseDouble(fGrade1.getText().isEmpty()?"-1":fGrade1.getText());
  }

  public double getGrade2() {
    return Double.parseDouble(fGrade2.getText().isEmpty()?"-1":fGrade2.getText());
  }

  public double getGrade3() {
    return Double.parseDouble(fGrade3.getText().isEmpty()?"-1":fGrade3.getText());
  }

  public void addStoreListener(java.awt.event.ActionListener L) {
    bCalc.addActionListener(L);
  }

  public void addFindListener(java.awt.event.ActionListener L) {
    bFind.addActionListener(L);
  }

  public void addPrintAllListener(java.awt.event.ActionListener L) {
    bPrintAll.addActionListener(L);
  }

  public void addQueryAllListener(java.awt.event.ActionListener L) {
    bQueryAll.addActionListener(L);
  }

  /*public void applyData(List<Object> datalist) {
    fName.setText(datalist.get(1));
    fGrade1.setText(datalist.get(2));
    fGrade2.setText(datalist.get(3));
    fGrade3.setText(datalist.get(4));
  }*/

  public void updatePromLabel(double value) {
    DecimalFormat DF=new DecimalFormat("#.##");
    lProm.setText("Promedio: "+String.valueOf(DF.format(value)));
    if(value>=3) {
      lStatus.setForeground(Color.GREEN.darker());
      lStatus.setText("RESULTADO: GANA LA MATERIA");
    } else {
      lStatus.setForeground(Color.RED);
      lStatus.setText("RESULTADO: PIERDE LA MATERIA");
    }
  }

  public void showWarning(String W,int TYPE) {
    //clearAllFields();
    String TITLE=TYPE==0?"Missing Data Input":"Notice";
    JOptionPane.showMessageDialog(null,W,TITLE,TYPE);
  }

  public void clearGradesFields() {
    fGrade1.setText("");
    fGrade2.setText("");
    fGrade3.setText("");
  }
}
