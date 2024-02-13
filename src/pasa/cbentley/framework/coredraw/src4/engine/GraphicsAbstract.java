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
import pasa.cbentley.framework.coredraw.src4.ctx.ObjectCDC;
import pasa.cbentley.framework.coredraw.src4.interfaces.IGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.IBOGraphics;

/**
 * Base implementation of the Host Graphics.
 * 
 * It has its own configuration so that one app can create a {@link GraphicsAbstract} with its own
 * alias settings.
 * 
 * @author Charles Bentley
 *
 */
public abstract class GraphicsAbstract extends ObjectCDC implements IGraphics, IBOGraphics {

   /**
    * {@link IBOGraphics}
    */
   protected ByteObject boGraphics;

   //#debug
   protected String       nameDebug;

   protected GraphicsAbstract(CoreDrawCtx cdc) {
      this(cdc, cdc.createBOGraphicsDefault());
   }

   protected GraphicsAbstract(CoreDrawCtx cdc, ByteObject boGraphics) {
      super(cdc);
      if(boGraphics == null) {
         throw new NullPointerException();
      }
      this.boGraphics = boGraphics;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, GraphicsAbstract.class, 50);
      toStringPrivate(dc);
      super.toString(dc.sup());
      dc.nlLvl(boGraphics, "boGraphics");
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
