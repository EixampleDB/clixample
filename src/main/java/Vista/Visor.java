
package Vista;
import Controller.Controller;
import Model.ValueType;

import java.io.IOException;

 public class Visor {
    Controller controller=new Controller();




  private void set(String key,String value,ValueType valuetype){
      String header="";
      if(valuetype.isNumber()){

          header="NUM";

      }
      else if(valuetype.isString()){
          header="STR";
      }

   try {
    controller.sendPost(key,value,header);
   } catch (IOException e) {
    e.printStackTrace();
   }

  }

 }


