package pasa.cbentley.framework.coredraw.src4.engine;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;

public class AbstractDrawTemplate implements IStringable {
   
   protected final CoreDrawCtx cdc;

   protected AbstractDrawTemplate(CoreDrawCtx cdc) {
      this.cdc = cdc;
   }
   
   public CoreDrawCtx getCDC() {
      return cdc;
   }

   //#mdebug
   public String toString() {
      return Dctx.toString(this);
   }
   
   public IDLog toDLog() {
      return cdc.toDLog();
   }
 
   public IDLog toLog() {
      return cdc.toDLog();
   }

   public void toString(Dctx dc) {
      dc.root(this, "AbstractUITemplate");
   }

   public UCtx toStringGetUCtx() {
      return cdc.getUCtx();
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "AbstractUITemplate");
   }
   //#enddebug

}
