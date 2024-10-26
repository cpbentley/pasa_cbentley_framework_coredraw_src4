/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.interfaces;

import pasa.cbentley.core.src4.logging.IStringable;

public interface IGraphics extends IStringable, ITechGraphics {

   /**
    * Intersects the current clip with the specified rectangle. 
    * The resulting clipping area is the intersection of the current clipping area and the specified rectangle.
    * This method can only be used to make the current clip smaller. 
    * To set the current clip larger, use the setClip method. 
    * Rendering operations have no effect outside of the clipping area. 
    * @param x
    * @param y
    * @param width
    * @param height
    */
   public abstract void clipRect(int x, int y, int width, int height);

   public abstract void drawArc(int x, int y, int w, int h, int sa, int aa);

   /**
    * Draws the character at x,y using 
    * @param character
    * @param x
    * @param y
    * @param anchor
    */
   public abstract void drawChar(char character, int x, int y, int anchor);

   public abstract void drawChars(char[] data, int offset, int length, int x, int y, int anchor);

   public abstract void drawImage(IImage img, int x, int y, int anchor);

   public abstract void drawLine(int x1, int y1, int x2, int y2);

   public abstract void drawRect(int x, int y, int width, int height);

   public abstract void drawRegion(IImage src, int x_src, int y_src, int width, int height, int transform, int x_dst, int y_dst, int anchor);

   public abstract void drawRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height, boolean processAlpha);

   public abstract void drawRoundRect(int x, int y, int w, int h, int r1, int r2);

   public abstract void drawString(String str, int x, int y, int anchor);

   public abstract void drawSubstring(String str, int offset, int len, int x, int y, int anchor);

   /**
    * Is the feature enable for this specific {@link IGraphics} instance
    * 
    * <li> {@link ITechHostFeatureDraw#SUP_ID_03_OPEN_GL}
    * <li> {@link ITechHostFeatureDraw#SUP_ID_04_ALIAS}
    * <li> {@link ITechHostFeatureDraw#SUP_ID_05_ALIAS_TEXT}
    * <li> {@link ITechHostFeatureDraw#SUP_ID_10_TRANSPARENT_BACKGROUND}
    * 
    * @param featureID
    * @return true if feature could be enabled
    */
   public boolean featureEnable(int featureID, boolean enable);

   public abstract void fillArc(int x, int y, int w, int h, int sa, int aa);

   public abstract void fillRect(int x, int y, int width, int height);

   public abstract void fillRoundRect(int x, int y, int w, int h, int r1, int r2);

   public abstract void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3);

   public abstract int getBlueComponent();

   public abstract int getClipHeight();

   public abstract int getClipWidth();

   public abstract int getClipX();

   public abstract int getClipY();

   public abstract int getColor();

   /**
    * Gets the color that will be displayed if the specified color is requested. <br>
    * This method enables the developer to check the manner in which RGB values are mapped 
    * to the set of distinct colors that the device can actually display. 
    * <br>
    * <br>
    * For example, with a monochrome device, 
    * this method will return either 0xFFFFFF (white) or 0x000000 (black) depending on the brightness of the specified color.
    * @param color the desired color (in 0x00RRGGBB format, the high-order byte is ignored) 
    * @return the corresponding color that will be displayed on the device's screen (in 0x00RRGGBB format)
    */
   public abstract int getDisplayColor(int color);

   public abstract IMFont getFont();

   /**
    * Asks for the {@link IMFont} with the defined font characteristics.
    * @param face
    * @param style
    * @param size
    * @return
    */
   public abstract IMFont getFont(int face, int style, int size);

   public abstract int getGrayScale();

   public abstract int getGreenComponent();

   public abstract int getRedComponent();

   public abstract int getStrokeStyle();

   public abstract int getTranslateX();

   public abstract int getTranslateY();

   /**
    * Is the feature enable for this specific {@link IGraphics} instance
    * 
    * <li> {@link ITechHostFeatureDraw#SUP_ID_03_OPEN_GL}
    * <li> {@link ITechHostFeatureDraw#SUP_ID_04_ALIAS}
    * <li> {@link ITechHostFeatureDraw#SUP_ID_05_ALIAS_TEXT}
    * <li> {@link ITechHostFeatureDraw#SUP_ID_10_TRANSPARENT_BACKGROUND}
    * 
    * @param featureID
    * @return
    */
   public boolean hasFeatureEnabled(int featureID);

   /**
    * 
    * @param x
    * @param y
    * @param width
    * @param height
    */
   public abstract void setClip(int x, int y, int width, int height);

   /**
    * 
    * @param RGB
    */
   public abstract void setColor(int RGB);

   /**
    * 
    * @param red
    * @param green
    * @param blue
    */
   public abstract void setColor(int red, int green, int blue);

   /**
    * Sets the {@link IMFont} that will be used when drawing String
    * @param font
    * @throws NullPointerException when null
    */
   public abstract void setFont(IMFont font);

   public abstract void setGrayScale(int v);

   /**
    * Stroke style for line drawing isn't something AWT supports.
    * 
    */
   public abstract void setStrokeStyle(int style);

   /**
    * translate needs to remember the current translation, since AWT doesn't provide getTranslate methods.
    */
   public abstract void setTranslate(int x, int y);

}
