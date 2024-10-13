/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.interfaces;

public interface ITechFont {
   /**
    * Font Face depends on the system. Should not be used for consistent across platforms.
    * <p>
    * Value:0
    * </p>
    */
   public static final int FACE_00_SYSTEM       = 0;

   /**
    * Monospace font. i.e. all letters have the same width.
    * <p>
    * Value:32
    * </p>
    */
   public static final int FACE_01_MONOSPACE    = 1;

   /**
    * Proportional font: width varies.
    * <p>
    * Value:64
    * </p>
    */
   public static final int FACE_02_PROPORTIONAL = 2;

   public static final int SIZE_0_DEFAULT       = 0;

   public static final int SIZE_1_TINY          = 1;

   public static final int SIZE_2_SMALL         = 2;

   public static final int SIZE_3_MEDIUM        = 3;

   public static final int SIZE_4_LARGE         = 4;

   public static final int SIZE_5_HUGE          = 5;

   public static final int SIZE_X_NUM           = 6;

   /**
    * 
    */
   public static final int STYLE_0_PLAIN        = 0;

   public static final int STYLE_1_BOLD         = 1;

   public static final int STYLE_2_ITALIC       = 2;

   public static final int STYLE_3_UNDERLINED   = 3;
}
