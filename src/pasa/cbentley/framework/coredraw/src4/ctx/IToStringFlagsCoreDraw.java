package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.core.src4.interfaces.IToStringFlags;

/**
 * Definition for {@link CoreDrawCtx} of flags following the {@link IToStringFlags} framework.
 * 
 * @author Charles Bentley
 *
 */
public interface IToStringFlagsCoreDraw extends IToStringFlags {

   /**
    * 
    */
   public static final int TOSTRING_FLAG_3_IGNORE_FONT_ATTRIBUTES = 1 << 2;

   /**
    * When debugging fonts, we want the complete font setup.
    * 
    * Mapped by the implementation to same flag 
    */
   public static final int TOSTRING_FLAG_4_SHOW_FONT_ENVIRONEMT   = 1 << 3;
}
