/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.interfaces;

import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.framework.coredraw.src4.ctx.IConfigCoreDraw;
import pasa.cbentley.framework.coredraw.src4.engine.VisualState;
import pasa.cbentley.layouter.src4.tech.ITechLayout;
import pasa.cbentley.layouter.src4.tech.IBOSizer;

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
    * Path to the .ttf or otf file
    * @param path
    */
   public void loadFont(String path);

   /**
    * Array with
    * <li> {@link ITechFont#SIZE_1_TINY}
    * <li> {@link ITechFont#SIZE_2_SMALL}
    * <li> {@link ITechFont#SIZE_3_MEDIUM}
    * <li> ...
    * @return
    */
   public int[] getFontSizes();
   /**
    * Call this for the default size.
    * @return
    */
   public IMFont getDefaultFont();

   /**
    * <li> {@link ITechFont#FACE_MONOSPACE}
    * @return
    */
   public IMFont getDefaultFontMono();

   /**
    * <li> {@link ITechFont#FACE_PROPORTIONAL}
    * @return
    */
   public IMFont getDefaultFontProportional();
   
   public String getFontFaceFromID(int id, String def);
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
    * This method allows to create 
    * If host draw context does not support {@link ITechFeaturesDraw#SUP_ID_06_CUSTOM_FONTS} , it will returns Default Font.
    * <br>
    * Font point are host based value...
    * The {@link ITechFont#SIZE_2_SMALL} value will be the closest to its configured fontPoints
    * 
    * @param fontFaceName
    * @param style {@link ITechFont#STYLE_BOLD}, {@link ITechFont#STYLE_BOLD}
    * @param fontPoint 
    * @return
    */
   public IMFont getFont(String fontFaceName, int style, int fontPoint);

   /**
    * The {@link IMFont} used for debugging message on screen.
    * @return
    */
   public IMFont getFontDebug();

   /**
    * Part of the custom
    * Associates Font name with an ID. that is not {@link ITechFont#FACE_MONOSPACE}
    * 
    * Reuse this ID in the method {@link IFontFactory#getFont(int, int, int)}
    * 
    * @param fontFaceName
    * @return -1 if System does not support fontFaceName
    */
   public int getFontFaceID(String fontFaceName);

   /**
    * The Font names available to this {@link IFontFactory}.
    * 
    * <li>
    * <li>
    * @return
    */
   public String[] getFontNames();

   /**
    * The Font Families available to this {@link IFontFactory}
    * @return
    */
   public String[] getFontFamilies();

   /**
    * The font point values associated to logical sizes
    * <li>{@link ITechFont#SIZE_0_DEFAULT}
    * <li>{@link ITechFont#SIZE_1_TINY}
    * <li>{@link ITechFont#SIZE_2_SMALL}
    * <li>{@link ITechFont#SIZE_3_MEDIUM}
    * <li>{@link ITechFont#SIZE_4_LARGE}
    * <li>{@link ITechFont#SIZE_5_HUGE}
    * @return
    */
   public int[] getFontPoints();

   /**
    * Matches size argument with host font points
    * 
    * <li>{@link ITechFont#SIZE_1_TINY}
    * <li>{@link ITechFont#SIZE_2_SMALL}
    * <li>{@link ITechFont#SIZE_3_MEDIUM}
    * <li>{@link ITechFont#SIZE_4_LARGE}
    * <li>{@link ITechFont#SIZE_5_HUGE}
    * 
    * @param size
    * @return
    */
   public int getFontPoint(int size);

   /**
    * The number of Font Points to add when creating a new Font with {@link IFontFactory#getFontPoint(int)}.
    * 
    * <p>
    * This value allows to easily test increase/decrease of font sizes 
    * </p>
    * 
    * {@link IConfigCoreDraw#getFontPointsExtraShift()}
    * 
    * @return
    */
   public int getFontPointExtraShift();

   /**
    * Float value for scaling up font sizes on small high definition screen.
    * 
    * Usage on Android.
    * 
    * Another possiblity is to manually configure bigger font points in the configuration
    * @param size
    * @return
    */
   public float getFontScale(int size);

   /**
    * Returns the font that best fit the height.
    * <br>
    * <li>{@link ITechLayout#SIZE_1_SMALLEST}
    * <li>{@link ITechLayout#SIZE_2_SMALL}
    * <li>{@link ITechLayout#SIZE_3_MEDIUM}
    * <li>{@link ITechLayout#SIZE_4_BIG}
    * <li>{@link ITechLayout#SIZE_5_BIGGEST}
    * 
    * @param sizeHint Hint.. can be ignored maybe
    * @param srcFont the font to be scaled so that its H best fits the given height.
    * @param h height to be matched against
    * @return
    */
   public IMFont getFontScaled(int sizeHint, IMFont srcFont, int h);

   /**
    * Changes the default font to.
    * 
    * If font is unknow, the default system font might be used.
    * @param name
    */
   public void setFontName(String name);

   /**
    * Some Host might not be able to change Font size. in which case
    * the method returns
    */
   public void setFontRatio(int ratio, int etalon);

}
