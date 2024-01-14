/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.byteobjects.src4.core.BOModuleAbstract;
import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDebugStringable;

/**
 * Managed all the Types of this Business Model module.
 * <br>
 * <br>
 * 
 * @author Charles-Philip Bentley
 *
 */
public class BOModuleCoreDraw extends BOModuleAbstract implements IDebugStringable, IBOTypesCoreDraw {

   protected final CoreDrawCtx cdc;

   public BOModuleCoreDraw(CoreDrawCtx cdc) {
      super(cdc.getBOC());
      this.cdc = cdc;
      //#debug
      toDLog().pInit("starts", this, BOModuleCoreDraw.class, "constructor", LVL_05_FINE, true);
   }

   public ByteObject getFlagOrderedBO(ByteObject bo, int offset, int flag) {
      // TODO Auto-generated method stub
      return null;
   }

   public String toStringGetDIDString(int did, int value) {
      return null;
   }

   /**
    * {@link IBOTypesCoreDraw}
    */
   public ByteObject merge(ByteObject root, ByteObject merge) {
      int type = merge.getType();
      switch (type) {
      }
      return null;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, BOModuleCoreDraw.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public boolean toString(Dctx dc, ByteObject bo) {
      int type = bo.getType();
      switch (type) {
         case 0:
            break;
         default:
            return false;
      }
      return true;
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, BOModuleCoreDraw.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   public boolean toString1Line(Dctx dc, ByteObject bo) {
      int type = bo.getType();
      switch (type) {
         case 0:
            break;
         default:
            return false;
      }
      return true;
   }

   //#enddebug

   public String toStringOffset(ByteObject bo, int offset) {
      int type = bo.getType();
      switch (type) {
         default:
      }
      return null;
   }

   private void toStringPrivate(Dctx dc) {

   }

   public String toStringType(int type) {
      switch (type) {
         default:
            return null;
      }
   }

}
