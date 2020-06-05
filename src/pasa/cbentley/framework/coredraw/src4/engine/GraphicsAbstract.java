/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.engine;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.ctx.IBOTypesBOC;
import pasa.cbentley.core.src4.ctx.UCtx;
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

   //#debug
   protected String       nameDebug;

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
      dc.root(this, GraphicsAbstract.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
      dc.nlLvl(tech, "ITechDrawer");
   }

   public void toStringSetNameDebug(String name) {
      this.nameDebug = name;
   }

   private void toStringPrivate(Dctx dc) {
      if (nameDebug != null) {
         dc.append('[');
         dc.append(nameDebug);
         dc.append(']');
      }
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, GraphicsAbstract.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
