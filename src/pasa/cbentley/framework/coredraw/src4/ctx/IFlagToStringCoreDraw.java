package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.core.src4.ctx.IFlagsToString;
import pasa.cbentley.core.src4.interfaces.IEvents;
import pasa.cbentley.core.src4.interfaces.IFlags;

/**
 * Definition for {@link CoreDrawCtx} of flags following the {@link IFlags} framework.
 * 
 * @author Charles Bentley
 *
 */
public interface IFlagToStringCoreDraw extends IFlagsToString {

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
