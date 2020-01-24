package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.core.src4.logging.ToStringStaticBase;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;

public class ToStringStaticCoreDraw extends ToStringStaticBase {

   public static String fontSizeNull(int size) {
      switch (size) {
         case ITechFont.SIZE_0_DEFAULT:
            return "Default";
         case ITechFont.SIZE_1_TINY:
            return "Tiny";
         case ITechFont.SIZE_2_SMALL:
            return "Small";
         case ITechFont.SIZE_3_MEDIUM:
            return "Medium";
         case ITechFont.SIZE_4_LARGE:
            return "Large";
         case ITechFont.SIZE_5_HUGE:
            return "Huge";
         default:
            return null;
      }
   }

   public static String fontSize(int size) {
      String str = fontSizeNull(size);
      if(str == null) {
         return "UnknownSize "+size;
      } 
      return str;
   }
   
   
}
