/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: NVIM 0.6.1
* Date: 19/02/2022, Time: 19:05:09.
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

import java.io.Serializable;

public class Entity implements Serializable {
  private String eID;
  private String eName;
  private String eG1;
  private String eG2;
  private String eG3;
  private String eAvg;

  public Entity(String eID,String eName,String eG1,String eG2, String eG3,String eAvg) {
    this.eID=eID;
    this.eName=eName;
    this.eG1=eG1;
    this.eG2=eG2;
    this.eG3=eG3;
    this.eAvg=eAvg;
  }

  public String getID() {
    return eID;
  }

  public String getName() {
    return eName;
  }

  public String getGrade1() {
    return eG1;
  }

  public String getGrade2() {
    return eG2;
  }

  public String getGrade3() {
    return eG3;
  }

  public double getAverage() {
    return Double.parseDouble(eAvg);
  }

  @Override
  public String toString() {
    return "Documento: "+eID+"\nNombre: "+eName+"\nNota 1: "+eG1+" | Nota 2: "+eG2+" | Nota 3: "+eG3+
      "\nPromedio: "+eAvg+"\n\n";
  }
}
