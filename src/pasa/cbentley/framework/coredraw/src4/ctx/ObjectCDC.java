package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.logging.IStringable;

public class ObjectCDC implements IStringable {

   protected final CoreDrawCtx cdc;

   public ObjectCDC(CoreDrawCtx cdc) {
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
      dc.root(this, ObjectCDC.class, "@line5");
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ObjectCDC.class);
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return cdc.getUC();
   }

   //#enddebug
   

}
