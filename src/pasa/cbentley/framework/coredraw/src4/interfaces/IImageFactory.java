/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.interfaces;

import java.io.IOException;
import java.io.InputStream;

import pasa.cbentley.core.src4.logging.IStringable;

public interface IImageFactory extends IStringable {
   /**
    * Create an image from a byte array
    * @param data
    * @param start
    * @param len
    * @return
    */
   public IImage createImage(byte[] data, int start, int len);

   public IImage createImage(IImage source);

   /**
    * Creates an immutable image using pixel data from the specified region of a source image, transformed as specified.
    * <br>
    * <br>
    * @param image
    * @param x
    * @param y
    * @param width
    * @param height
    * @param transform
    * @return
    */
   public IImage createImage(IImage image, int x, int y, int width, int height, int transform);

   public IImage createImage(InputStream is) throws IOException;

   public IImage createImage(int w, int h);

   public IImage createImage(int w, int h, int color);

   public IImage createImage(String name) throws IOException;

   /**
    * Creates an immutable image from a sequence of ARGB values, specified as 0xAARRGGBB.
    * <br>
    * <br>
    * @param rgb
    * @param width
    * @param height
    * @param processAlpha
    * @return
    */
   public IImage createRGBImage(int[] rgb, int width, int height, boolean processAlpha);
   


}
