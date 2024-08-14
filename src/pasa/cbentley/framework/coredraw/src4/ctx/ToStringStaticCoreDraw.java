/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.core.src4.logging.ToStringStaticBase;
import pasa.cbentley.framework.coredraw.src4.interfaces.IMFont;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechGraphics;

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

   public static String aliasMode(int mode) {
      String str = aliasModeNull(mode);
      if (str == null) {
         return "Unknown Alias Mode " + mode;
      }
      return str;
   }

   public static String aliasModeNull(int mode) {
      switch (mode) {
         case ITechGraphics.MODSET_APP_ALIAS_0_BEST:
            return "Best";
         case ITechGraphics.MODSET_APP_ALIAS_1_ON:
            return "On";
         case ITechGraphics.MODSET_APP_ALIAS_2_OFF:
            return "Off";
         default:
            return null;
      }
   }

   public static String toStringFontFaceStyleSize(IMFont font) {
      return toStringFontFace(font.getFace()) + toStringFontStyle(font.getStyle()) + toStringFontSize(font.getSize());
   }
   
   public static String toStringFontFace(int face) {
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

   public static String toStringFontSize(int size) {
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
            return "Unknown " + size;
      }
   }

   public static String toStringFontStyle(int style) {
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
