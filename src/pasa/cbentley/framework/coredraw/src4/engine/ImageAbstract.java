package pasa.cbentley.framework.coredraw.src4.engine;

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
}
