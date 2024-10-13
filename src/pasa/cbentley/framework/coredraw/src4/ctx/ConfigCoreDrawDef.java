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
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechGraphics;

/**
 * Configuration by default
 * @author Charles Bentley
 *
 */
public class ConfigCoreDrawDef extends ConfigAbstract implements IConfigCoreDraw {

   public ConfigCoreDrawDef(UCtx uc) {
      super(uc);

   }

   public int getDefaultFontSize() {
      return ITechFont.SIZE_3_MEDIUM;
   }

   public boolean isUsingFontCache() {
      return true;
   }

   public int getFontPoint_01_Tiny() {
      return 8;
   }

   public int getFontPoint_02_Small() {
      return 12;
   }

   public int getFontPoint_03_Medium() {
      return 16;
   }

   public int getFontPoint_04_Large() {
      return 20;
   }

   public int getFontPoint_05_Huge() {
      return 24;
   }

   public int getFontPointsExtraShift() {
      return 0;
   }

   public int getAliasMode() {
      return ITechGraphics.MODSET_APP_ALIAS_1_ON;
   }

   public int getAliasModeText() {
      return ITechGraphics.MODSET_APP_ALIAS_1_ON;
   }

   public int getColorImageBackgroundDefault() {
      return IColors.FULLY_OPAQUE_BLACK;
   }

   public void postProcessing(ByteObject settings, ABOCtx ctx) {

   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, ConfigCoreDrawDef.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());

      dc.appendVarWithNewLine("fontPointTiny  ", getFontPoint_01_Tiny());
      dc.appendVarWithNewLine("fontPointSmall ", getFontPoint_02_Small());
      dc.appendVarWithNewLine("fontPointMedium", getFontPoint_03_Medium());
      dc.appendVarWithNewLine("fontPointLarge ", getFontPoint_04_Large());
      dc.appendVarWithNewLine("fontPointHuge  ", getFontPoint_05_Huge());

      dc.appendVarWithNewLine("FontPointsExtraShift", getFontPointsExtraShift());
      dc.appendVarWithNewLine("ColorImageBackgroundDefault", getColorImageBackgroundDefault());
      dc.appendVarWithNewLine("AliasMode    ", ToStringStaticCoreDraw.aliasMode(getAliasMode()));
      dc.appendVarWithNewLine("AliasModeText", ToStringStaticCoreDraw.aliasMode(getAliasModeText()));
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
