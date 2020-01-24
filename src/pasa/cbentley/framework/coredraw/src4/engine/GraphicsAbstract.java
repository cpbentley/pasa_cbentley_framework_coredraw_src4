package pasa.cbentley.framework.coredraw.src4.engine;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.ctx.IBOTypesBOC;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.interfaces.IGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechDrawer;

/**
 * Base implementation of the Host Graphics
 * @author Charles Bentley
 *
 */
public abstract class GraphicsAbstract extends AbstractDrawTemplate implements IGraphics, ITechDrawer {

   /**
    * {@link ITechDrawer}
    */
   protected ByteObject tech;

   protected GraphicsAbstract(CoreDrawCtx fc) {
      super(fc);
   }

   protected GraphicsAbstract(CoreDrawCtx fc, ByteObject tech) {
      super(fc);
      this.tech = tech;
   }

   
   public void createTech() {
      tech = cdc.getBOC().getByteObjectFactory().createByteObject(IBOTypesBOC.TYPE_020_PARAMATERS, ITechDrawer.DRAWER_BASIC_SIZE);
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "GraphicsAbstract");
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "GraphicsAbstract");
   }
   //#enddebug
}
