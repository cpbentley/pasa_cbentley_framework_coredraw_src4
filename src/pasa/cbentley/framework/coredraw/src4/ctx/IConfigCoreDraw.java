/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.byteobjects.src4.ctx.IConfigBO;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontFactory;
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
}
