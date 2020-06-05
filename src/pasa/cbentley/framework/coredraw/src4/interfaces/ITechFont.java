/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.interfaces;

public interface ITechFont {
   /**
    * Monospace font. i.e. all letters have the same width
    */
   public static final int FACE_MONOSPACE    = 32;

   /**
    * Proportional font: width varies
    */
   public static final int FACE_PROPORTIONAL = 64;

   /**
    * Font Face
    */
   public static final int FACE_SYSTEM       = 0;

   public static final int SIZE_0_DEFAULT    = 0;

   public static final int SIZE_1_TINY       = 1;

   public static final int SIZE_2_SMALL      = 2;

   public static final int SIZE_3_MEDIUM     = 3;

   public static final int SIZE_4_LARGE      = 4;

   public static final int SIZE_5_HUGE       = 5;

   public static final int SIZE_X_NUM        = 6;

   public static final int STYLE_BOLD        = 1;

   public static final int STYLE_ITALIC      = 2;

   /**
    * 
    */
   public static final int STYLE_PLAIN       = 0;

   public static final int STYLE_UNDERLINED  = 4;
}
