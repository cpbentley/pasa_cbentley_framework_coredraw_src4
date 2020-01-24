package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.byteobjects.src4.tech.ITechCtxSettings;
import pasa.cbentley.framework.coredraw.src4.interfaces.IGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechDrawer;

public interface ITechCtxSettingsCoreDraw extends ITechCtxSettings {

   public static final int CTX_COREDRAW_BASIC_SIZE             = MODSET_BASIC_SIZE + 5;

   /**
    * When set, the alias mode defined here overrides any locally defined mode.
    */
   public static final int CTX_COREDRAW_FLAG_01_OVERRIDE_ALIAS = 1 << 0;

   public static final int CTX_COREDRAW_OFFSET_01_FLAG1        = MODSET_BASIC_SIZE;

   /**
    * Defines the global alias mode for {@link IGraphics} implementations
    * 
    * An implementation can be created with an explicit mode defined
    * in {@link ITechDrawer}
    */
   public static final int CTX_COREDRAW_OFFSET_02_MODE_ALIAS1  = MODSET_BASIC_SIZE + 1;

}
