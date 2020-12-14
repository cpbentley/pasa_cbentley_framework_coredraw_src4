/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.ctx.ABOCtx;
import pasa.cbentley.core.src4.ctx.ConfigAbstract;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.utils.interfaces.IColors;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechDrawer;

/**
 * Configuration by default
 * @author Charles Bentley
 *
 */
public class ConfigCoreDrawDef extends ConfigAbstract implements IConfigCoreDraw {

   public static final int FONT_LARGE_POINTS      = 20;

   public static final int FONT_MEDIUM_POINTS     = 16;

   public static final int FONT_SMALL_POINTS      = 12;

   public static final int FONT_VERY_LARGE_POINTS = 24;

   public static final int FONT_VERY_SMALL_POINTS = 8;

   private int[]           fontPoints             = new int[] { FONT_SMALL_POINTS, FONT_MEDIUM_POINTS, FONT_LARGE_POINTS, FONT_VERY_SMALL_POINTS, FONT_VERY_LARGE_POINTS };

   public ConfigCoreDrawDef(UCtx uc) {
      super(uc);
   }

   public int getAliasMode() {
      return ITechDrawer.MODSET_APP_ALIAS_1_ON;
   }

   public int getAliasModeText() {
      return ITechDrawer.MODSET_APP_ALIAS_1_ON;
   }

   public int getColorImageBackgroundDefault() {
      return IColors.FULLY_OPAQUE_BLACK;
   }

   public int[] getFontPoints() {
      return fontPoints;
   }

   public void postProcessing(ByteObject settings, ABOCtx ctx) {

   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, ConfigCoreDrawDef.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());

      dc.line();
      dc.appendColorWithSpace("getColorImageBackgroundDefault", getColorImageBackgroundDefault());
      dc.line();
      dc.appendVarWithSpace("getAliasMode()", ToStringStaticCoreDraw.aliasMode(getAliasMode()));
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ConfigCoreDrawDef.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
