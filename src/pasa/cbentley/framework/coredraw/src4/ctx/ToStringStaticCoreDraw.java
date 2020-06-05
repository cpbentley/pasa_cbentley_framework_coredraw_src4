/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
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
      if (str == null) {
         return "UnknownSize " + size;
      }
      return str;
   }

   public static String fontFace(int face) {
      switch (face) {
         case ITechFont.FACE_MONOSPACE:
            return "Mono";
         case ITechFont.FACE_PROPORTIONAL:
            return "Proportional";
         case ITechFont.FACE_SYSTEM:
            return "System";
         default:
            return "Unknown " + face;
      }
   }

   public static String debugFontSize(int size) {
      switch (size) {
         case ITechFont.SIZE_4_LARGE:
            return "LARGE";
         case ITechFont.SIZE_3_MEDIUM:
            return "MEDIUM";
         case ITechFont.SIZE_2_SMALL:
            return "SMALL";
         case ITechFont.SIZE_5_HUGE:
            return "VERY LARGE";
         case ITechFont.SIZE_1_TINY:
            return "Very SMALL";
         default:
            return "Unknown " + size;
      }
   }

   public static String debugFontStyle(int style) {
      switch (style) {
         case ITechFont.STYLE_BOLD:
            return "Bold";
         case ITechFont.STYLE_ITALIC:
            return "Italic";
         case ITechFont.STYLE_PLAIN:
            return "Plain";
         case ITechFont.STYLE_UNDERLINED:
            return "Underlined";
         default:
            return "Unknown " + style;
      }
   }

}
