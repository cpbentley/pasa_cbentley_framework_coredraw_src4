/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.byteobjects.src4.ctx.IConfigBO;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechGraphics;

/**
 * Generic configuration API for the {@link CoreDrawCtx}
 * 
 * @author Charles Bentley
 *
 */
public interface IConfigCoreDraw extends IConfigBO {

  
   /**
    * The color used by default when creating an empty image with an unspecified background color
    * @return
    */
   public int getColorImageBackgroundDefault();

   /**
    * Size of fonts
    * Must be 
    * <li> {@link ITechFont#SIZE_1_TINY}
    * <li> {@link ITechFont#SIZE_2_SMALL}
    * <li> {@link ITechFont#SIZE_3_MEDIUM}
    * <li> {@link ITechFont#SIZE_4_LARGE}
    * <li> {@link ITechFont#SIZE_5_HUGE}
    * @return
    */
   public int getDefaultFontSize();

   /**
    * When false, every call to {@link IFontFactory#getFont(int, int, int)} creates a new object.
    * 
    * <p>
    * Used for comparing use of cache and no use of cache.
    * </p>
    * @return
    */
   public boolean isUsingFontCache();
}
