package pasa.cbentley.framework.coredraw.src4.engine;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.interfaces.IScaler;
import pasa.cbentley.layouter.src4.tech.ITechLayout;

public abstract class ScalerAbstract implements IScaler, ITechLayout {

   protected final CoreDrawCtx cdc;

   public ScalerAbstract(CoreDrawCtx cdc) {
      this.cdc = cdc;
   }
   
   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, "ScalerAbstract");
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "ScalerAbstract");
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return cdc.getUCtx();
   }

   //#enddebug
   

}
