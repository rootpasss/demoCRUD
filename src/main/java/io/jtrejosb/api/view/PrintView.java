/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: NVIM 0.6.1
* Date: 19/02/2022, Time: 12:45:47.
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

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PrintView extends javax.swing.JFrame {
  private JPanel contentPane;
  private JLabel lTitle;
  private JTextArea TA;
  private JScrollPane SP;

  public PrintView() {
    super("CALCULO DE PROMEDIO");
    setSize(400,300);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    contentPane=new JPanel();
    contentPane.setLayout(null);
    add(contentPane);

    lTitle=new JLabel("IMPRIMIR INFORMACION");
    lTitle.setBackground(Color.decode("#000000"));
    lTitle.setForeground(Color.decode("#FFFFFF"));
    lTitle.setFont(new Font(lTitle.getFont().getFontName(),Font.PLAIN,20));
    lTitle.setOpaque(true);
    lTitle.setBounds(0,0,getWidth(),35);
    lTitle.setHorizontalAlignment(SwingConstants.CENTER);

    TA=new JTextArea();
    TA.setEditable(false);
    SP=new JScrollPane(TA);
    SP.setBounds(0,35,getWidth(),getHeight()-35);

    contentPane.add(lTitle);
    contentPane.add(SP);
    setVisible(true);
  }

  public void applyData(List<Object> datalist) {
    System.out.println("Desde ventana consulta general");
    for(Object O:datalist)
      TA.append(O.toString());
  }
}
