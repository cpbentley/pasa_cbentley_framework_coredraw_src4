/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.byteobjects.src4.core.interfaces.IBOCtxSettings;
import pasa.cbentley.framework.coredraw.src4.interfaces.IGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.IBOGraphics;

public interface IBOCtxSettingsCoreDraw extends IBOCtxSettings {

   public static final int CTX_COREDRAW_BASIC_SIZE                 = CTX_BASIC_SIZE + 5;

   /**
    * When set, the alias mode defined here overrides any locally defined mode.
    */
   public static final int CTX_COREDRAW_FLAG_01_OVERRIDE_ALIAS     = 1 << 0;

   public static final int CTX_COREDRAW_OFFSET_01_FLAG1            = CTX_BASIC_SIZE;

   /**
    * Defines the global alias mode for {@link IGraphics} implementations
    * 
    * An implementation can be created with an explicit mode defined
    * in {@link IBOGraphics}
    * <li> {@link ITechGraphics#MODSET_APP_ALIAS_0_BEST}
    * <li> {@link ITechGraphics#MODSET_APP_ALIAS_1_ON}
    * <li> {@link ITechGraphics#MODSET_APP_ALIAS_2_OFF}
    */
   public static final int CTX_COREDRAW_OFFSET_02_MODE_ALIAS1      = CTX_BASIC_SIZE + 1;

   public static final int CTX_COREDRAW_OFFSET_03_MODE_TEXT_ALIAS1 = CTX_BASIC_SIZE + 2;

}
