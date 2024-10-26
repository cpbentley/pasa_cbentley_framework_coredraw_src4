package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.core.src4.logging.LogParameters;

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
      dc.root(this, ObjectCDC.class, 27);
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ObjectCDC.class, 36);
      toStringPrivate(dc);
   }

   public LogParameters toStringGetLine(Class cl, String method, int value) {
      return toStringGetUCtx().toStringGetLine(cl, method, value);
   }

   public String toStringGetLine(int value) {
      return toStringGetUCtx().toStringGetLine(value);
   }

   public UCtx toStringGetUCtx() {
      return cdc.getUC();
   }

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
