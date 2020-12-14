package pasa.cbentley.framework.coredraw.src4.interfaces;

import java.io.InputStream;

import pasa.cbentley.core.src4.logging.IStringable;

/**
 * A feature that might not be supported
 * 
 * Access Host font data
 * 
 * @author Charles Bentley
 *
 */
public interface IFontCustomizer extends IStringable {

   public void loadFont(String string);

   public void loadFont(InputStream is, String string);

   /**
    * Sets the font family for the logical font {@link ITechFont#FACE_MONOSPACE}
    * @param family
    */
   public void setFontFamilyMonospace(String family);

   /**
    * Sets the font family for the logical font {@link ITechFont#FACE_SYSTEM}
    * @param family
    */
   public void setFontFamilySystem(String family);

   /**
    * Sets the font family for the logical font {@link ITechFont#FACE_PROPORTIONAL}
    * @param family
    */
   public void setFontFamilyProportional(String family);
}
