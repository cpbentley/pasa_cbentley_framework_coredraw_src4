/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.engine;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImage;

/**
 * J2SE bridge class for the {@link javax.microedition.lcdui.Image} class of MIDP 2.0.
 * <br>
 * <br>
 * @author Charles Bentley
 *
 */
public abstract class ImageAbstract extends AbstractDrawTemplate implements IImage {

   protected ImageAbstract(CoreDrawCtx cac) {
      super(cac);
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, ImageAbstract.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ImageAbstract.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   

}
