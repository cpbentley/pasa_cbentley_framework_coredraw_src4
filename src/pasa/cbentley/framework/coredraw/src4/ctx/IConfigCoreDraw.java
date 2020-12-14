/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.byteobjects.src4.ctx.IConfigBO;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechDrawer;

/**
 * Generic configuration API for the {@link CoreDrawCtx}
 * 
 * @author Charles Bentley
 *
 */
public interface IConfigCoreDraw extends IConfigBO {

   /**
    * Overrides hardcoded font points.
    * 
    * @return when null, hardcoded points are used
    */
   public int[] getFontPoints();

   /**
    * <li> {@link ITechDrawer#MODSET_APP_ALIAS_0_BEST}
    * <li> {@link ITechDrawer#MODSET_APP_ALIAS_1_ON}
    * <li> {@link ITechDrawer#MODSET_APP_ALIAS_2_OFF}
    * @return
    */
   public int getAliasMode();

   public int getAliasModeText();

   /**
    * The color used by default when creating an empty image with an unspecified background color
    * @return
    */
   public int getColorImageBackgroundDefault();
}
