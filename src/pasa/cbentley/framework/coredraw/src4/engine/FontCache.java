package pasa.cbentley.framework.coredraw.src4.engine;

import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.ctx.ObjectCDC;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontCache;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;

public class FontCache  extends ObjectCDC implements IFontCache, ITechFont {

   public FontCache(CoreDrawCtx cdc) {
      super(cdc);
   }

}
