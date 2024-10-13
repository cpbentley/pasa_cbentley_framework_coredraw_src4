package pasa.cbentley.framework.coredraw.src4.interfaces;

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

   /**
    * Loads the font data from its name. Maps it to his name as string.
    * @param string
    */
   public void loadFont(String string);

   /**
    * Sets the font family for the logical font {@link ITechFont#FACE_01_MONOSPACE}
    * @param family
    */
   public void setFontFamilyMonospace(String family);

   /**
    * Sets the font family for the logical font {@link ITechFont#FACE_00_SYSTEM}
    * @param family
    */
   public void setFontFamilySystem(String family);

   /**
    * Sets the font family for the logical font {@link ITechFont#FACE_02_PROPORTIONAL}.
    * <p>
    * Set to null to go back to the starting configuration value
    * </p>
    * @param family
    */
   public void setFontFamilyProportional(String family);
}
