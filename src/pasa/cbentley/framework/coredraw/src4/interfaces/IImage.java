/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.interfaces;

import pasa.cbentley.core.src4.interfaces.ITechTransform;
import pasa.cbentley.core.src4.logging.IStringable;

public interface IImage extends ITechTransform, IStringable {

   /**
    * Creates a new Graphics object that renders to this image. This image must be mutable; it is illegal to call this method on an immutable image. The mutability of an image may be tested with the isMutable() method.
    * <br>
    * The newly created Graphics object has the following properties:
    * 
    * <li>the destination is this Image object;
    * <li>the clip region encompasses the entire Image;
    * <li>the current color is black;
    * <li>the font is the same as the font returned by Font.getDefaultFont();
    * <li>the stroke style is SOLID; and
    * <li>the origin of the coordinate system is located at the upper-left corner of the Image.
    * <br>
    * The lifetime of Graphics objects created using this method is indefinite. They may be used at any time, by any thread.
    * 
    * @return {@link IGraphics}
    * @throws IllegalStateException if called on an immutable image.
    */
   public IGraphics getGraphics();

   /**
    * The height in pixels
    * @return
    */
   public int getHeight();

   /**
    * 
    * @param rgbData
    * @param offset
    * @param scanlength
    * @param x
    * @param y
    * @param width
    * @param height
    */
   public void getRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height);

   /**
    * The width in pixels
    * @return
    */
   public int getWidth();

   /**
    * Returns false if Image is immutable by default
    * <br>
    * Check if this image is mutable. 
    * <br>
    * Mutable images can be modified by rendering to them through a Graphics object obtained from the getGraphics() method of this object. 
    * <br>
    * An {@link IImage} can always be made mutable.
    * <br>
    * Using the {@link IImage#getGraphics()}
    * @return
    */
   public boolean isMutable();

}
