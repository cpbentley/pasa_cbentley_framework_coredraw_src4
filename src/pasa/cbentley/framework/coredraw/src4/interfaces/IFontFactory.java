package pasa.cbentley.framework.coredraw.src4.interfaces;

import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.framework.coredraw.src4.engine.VisualState;

public interface IFontFactory extends IStringable {

   /**
    * Tries to increase the size of the all the fonts
    * @return
    */
   public VisualState fontSizeDecrease();

   /**
    * Caller must call the hooks for updating computations based on current font sizes.
    * <br>
    * <br>
    * 
    * @return
    */
   public VisualState fontSizeIncrease();

   /**
    * 
    * @return
    */
   public IMFont getDefaultFont();

   public IMFont getDefaultFontMono();

   public IMFont getDefaultFontProportional();

   /**
    * Creates a Framework font.
    * Faces are
    * <li> {@link ITechFont#FACE_SYSTEM}
    * <li> {@link ITechFont#FACE_MONOSPACE}
    * <li> {@link ITechFont#FACE_PROPORTIONAL}
    * <br>
    * Styles are
    * <li> {@link ITechFont#STYLE_BOLD}
    * <li> {@link ITechFont#STYLE_ITALIC}
    * <li> {@link ITechFont#STYLE_PLAIN}
    * <li> {@link ITechFont#STYLE_UNDERLINED}
    * <br>
    * Sizes are
    * <li> {@link ITechFont#SIZE_4_LARGE}
    * <li> {@link ITechFont#SIZE_3_MEDIUM}
    * <li> {@link ITechFont#SIZE_2_SMALL}
    * <li> {@link ITechFont#SIZE_5_HUGE}
    * <br>
    * 
    * For a pure custom font with font points 
    * 
    * @param face
    * @param style
    * @param size
    * @return
    */
   public IMFont getFont(int face, int style, int size);

   /**
    * If Hosts does not support Font face, it will returns Default Font.
    * <br>
    * Font point are...
    * 
    * @param face
    * @param style
    * @param fontPoint
    * @return
    */
   public IMFont getFont(String face, int style, int fontPoint);

   public IMFont getFontDebug();

   /**
    * 
    * @param string
    * @return
    */
   public int getFontFaceID(String string);

   public String getFontName();

   public String[] getFontNames();

   /**
    * The font point values
    * @return
    */
   public int[] getFontPoints();

   public int getFontPoint(int size);

   public int getFontPointExtraShift();

   public float getFontScale(int size);

   /**
    * Returns the font that best fit the w and h according to sizeHint.
    * <br>
    * @param sizeHint {@link ISizer#SIZE_1_SMALLEST}
    * @param w
    * @param h
    * @return
    */
   public IMFont getFontScaled(int sizeHint, int w, int h);

   /**
    * Look up in the ressources for the font.
    * returns Face ID or -1 if not found
    * @param string
    * @return
    */
   public int loadCustomFont(String string);

   public void setFontName(String name);

   /**
    * Some Host might not be able to change Font size. in which case
    * the method returns
    */
   public void setFontRatio(int ratio, int etalon);
}
