/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: NVIM 0.6.1
* Date: 20/02/2022, Time: 11:07:16.
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

import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import io.jtrejosb.api.model.Entity;

@SuppressWarnings("serial")
public class TableView extends javax.swing.JFrame {
  private JPanel contentPane;
  private JLabel lTitle;
  private JScrollPane SP;
  private JTable T;
  private Model M;

  public TableView() {
    super("Calculo de Promedio");
    setSize(450,300);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    contentPane=new JPanel();
    contentPane.setLayout(null);
    add(contentPane);

    lTitle=new JLabel("MOSTRAR PERSONAS");
    lTitle.setBackground(Color.decode("#000000"));
    lTitle.setForeground(Color.decode("#FFFFFF"));
    lTitle.setFont(new Font(lTitle.getFont().getFontName(),Font.PLAIN,20));
    lTitle.setOpaque(true);
    lTitle.setBounds(0,0,getWidth(),35);
    lTitle.setHorizontalAlignment(SwingConstants.CENTER);

    M=new Model();
    T=new JTable(M);
    SP=new JScrollPane(T);
    SP.setBounds(0,35,getWidth(),getHeight()-40);

    contentPane.add(lTitle);
    contentPane.add(SP);
    setVisible(true);
  }

  public void applyData(List<Object> datalist) {
    for(Object O:datalist) {
      M.addRow(new Object[]{
        ((Entity)O).getID(),
        ((Entity)O).getName(),
        ((Entity)O).getGrade1(),
        ((Entity)O).getGrade2(),
        ((Entity)O).getGrade3(),
        ((Entity)O).getAverage()
      });
    }
  }
}

class Model extends DefaultTableModel {
  String[]titles={"Documento","Nombre","Nota 1","Nota2","Nota 3","Promedio"};

  @Override
  public String getColumnName(int col) {
    return titles[col];
  }

  @Override
  public int getColumnCount() {
    return titles.length;
  }

  @Override
  public boolean isCellEditable(int row,int col) {
    return false;
  }
}
