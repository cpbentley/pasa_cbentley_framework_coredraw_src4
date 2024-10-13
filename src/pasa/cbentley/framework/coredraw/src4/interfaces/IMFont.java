/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.interfaces;

import pasa.cbentley.core.src4.logging.IStringable;

/**
 * Font interface for the Bentley framework.
 * <br>
 * Generic definitions are used to describe fonts. Specific implementations will do their best
 * to implement this specification.
 * <br>
 * Dynamic Font changes (size)
 * <br>
 * An application runs but fonts are too smal for the user, the application framework adapts font size
 * <li>at the framework System level without modifying the application
 * <li>at the Bentley framework system where all definitions are upped one grade. until all are maxed VERY LARGE
 * 
 * This is done at the creation level where the global font upgrade/downgrade is saved. Upon repaint, when the font is created
 * the size is upgraded.
 * <br>
 * 
 * TODO how do you provide total custom fonts? 
 * <br>
 * Can create a Font with any size from the host provided sizes and
 * the font faces and styles
 * 
 * @author Charles Bentley
 *
 */
public interface IMFont extends ITechFont, IStringable {

   public int charsWidth(char[] c, int ofs, int len);

   public int charWidth(char ch);

   public int stringWidth(String s);

   public int substringWidth(String s, int offset, int length);

   public int getHeight();

   /**
    * Returns a pixel weight of the font.
    * <br>
    * usually a measure of the biggest char for proportional face.
    * <br>
    * Any char with monospace fonts
    * @return
    */
   public int getWidthWeigh();

   public boolean isMonospace();

   public String getName();

   /**
    * 
    * @param flag
    * @return
    */
   public boolean isSupported(int flag);

   /**
    * <li> {@link ITechFont#FACE_01_MONOSPACE}
    * <li> {@link ITechFont#FACE_02_PROPORTIONAL}
    * <li> {@link ITechFont#FACE_00_SYSTEM}
    * @return
    */
   public int getFace();

   /**
    * <li> {@link ITechFont#STYLE_1_BOLD}
    * <li> {@link ITechFont#STYLE_2_ITALIC}
    * <li> {@link ITechFont#STYLE_0_PLAIN}
    * @return
    */
   public int getStyle();

   /**
    * <li> {@link ITechFont#SIZE_0_DEFAULT}
    * <li> {@link ITechFont#SIZE_1_TINY}
    * <li> {@link ITechFont#SIZE_2_SMALL}
    * <li> {@link ITechFont#SIZE_3_MEDIUM}
    * <li> {@link ITechFont#SIZE_4_LARGE}
    * <li> {@link ITechFont#SIZE_5_HUGE}
    * @return
    */
   public int getSize();
}
