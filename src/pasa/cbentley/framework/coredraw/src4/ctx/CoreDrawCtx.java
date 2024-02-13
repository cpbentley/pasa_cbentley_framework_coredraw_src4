/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.ctx.ABOCtx;
import pasa.cbentley.byteobjects.src4.ctx.BOCtx;
import pasa.cbentley.byteobjects.src4.ctx.IConfigBO;
import pasa.cbentley.byteobjects.src4.ctx.IEventsBO;
import pasa.cbentley.core.src4.ctx.ICtx;
import pasa.cbentley.core.src4.event.BusEvent;
import pasa.cbentley.core.src4.interfaces.IFeaturable;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.coredraw.src4.interfaces.IBOGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.IGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImage;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImageFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.IMFont;
import pasa.cbentley.framework.coredraw.src4.interfaces.IScaler;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFeaturesDraw;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechGraphics;

/**
 * Provides just the bare minimum UI
 * 
 * <li> {@link IMFont} and its factory {@link IFontFactory}
 * <li> {@link IImage} and its factory {@link IImageFactory}
 * <li> {@link IGraphics} the drawing interface
 * 
 * <p>
 * This context is independant from other framework contexts. You do not need Core Framework.
 * 
 * It is done on purpose so that a Swing app can use this drawing Ctx without loading the Application framework
 * </p>
 * 
 * 
 * @author Charles Bentley
 *
 */
public abstract class CoreDrawCtx extends ABOCtx implements IBOCtxSettingsCoreDraw, ITechFeaturesDraw, IFeaturable {

   protected final BOModuleCoreDraw boModule;

   /**
    * In memory constrained context, config is null, and the default one is used packed in bytes ?
    * @param configDraw could be null, use the default config,
    * @param boc
    */
   public CoreDrawCtx(IConfigCoreDraw configDraw, BOCtx boc) {
      super(configDraw, boc);

      boModule = new BOModuleCoreDraw(this);
   }

   public IConfigCoreDraw getConfigCoreDraw() {
      return (IConfigCoreDraw) config;
   }

   public BOModuleCoreDraw getModule() {
      return boModule;
   }

   public int getColorImageBackgroundDefault() {
      return getConfigCoreDraw().getColorImageBackgroundDefault();
   }

   public ICtx[] getCtxSub() {
      return new ICtx[] { boc };
   }

   /**
    * Call the {@link Runnable} later in the drawing thread.
    * @param run
    */
   public abstract void callSerially(Runnable run);

   /**
    * {@link IBOCtxSettingsCoreDraw}
    * @return
    */
   public ByteObject getBOCtxSettingsCoreDraw() {
      return getBOCtxSettings();
   }

   public ByteObject createBOGraphicsDefault() {
      ByteObject bo = getBOC().getByteObjectFactory().createParameter(IBOGraphics.GRAPHICS_BASIC_SIZE);
      return bo;
   }

   public void applySettings(ByteObject settingsNew, ByteObject settingsOld) {
      boc.getEventBus().sendNewEvent(IEventsBO.PID_01_CTX, IEventsBO.PID_01_CTX_1_SETTINGS_CHANGE, this);
   }

   public void applySettingsAlias() {
      BusEvent be = boc.getEventBus().createEvent(IEventsBO.PID_01_CTX, IEventsBO.PID_01_CTX_1_SETTINGS_CHANGE, this);
      be.setParam1(IEventsCoreDraw.SETTINGS_1_ALIAS);
      be.putOnBus();
   }

   public int getBOCtxSettingSize() {
      return IBOCtxSettingsCoreDraw.CTX_COREDRAW_BASIC_SIZE;
   }

   public abstract IFontFactory getFontFactory();

   public abstract IImageFactory getImageFactory();

   public abstract IScaler getScaler();

   protected void matchConfig(IConfigBO config, ByteObject settings) {
      IConfigCoreDraw configDraw = (IConfigCoreDraw) config;
      settings.set1(CTX_COREDRAW_OFFSET_02_MODE_ALIAS1, configDraw.getAliasMode());
      settings.set1(CTX_COREDRAW_OFFSET_03_MODE_TEXT_ALIAS1, configDraw.getAliasModeText());
   }

   /**
    * Factory tells us if produced images supports such or such feature.
    * 
    * <li>{@link ITechFeaturesDraw#SUP_ID_03_OPEN_GL}
    * <li>{@link ITechFeaturesDraw#SUP_ID_04_ALIAS}
    * <li>{@link ITechFeaturesDraw#SUP_ID_05_ALIAS_TEXT}
    * <li>{@link ITechFeaturesDraw#SUP_ID_06_CUSTOM_FONTS}
    * <li>{@link ITechFeaturesDraw#SUP_ID_07_IMAGE_SCALING}
    * <li>{@link ITechFeaturesDraw#SUP_ID_10_TRANSPARENT_BACKGROUND}
    * 
    * @param supportID
    * @return
    */
   public abstract boolean hasFeatureSupport(int supportID);

   /**
    * Toggle ctx wide alias mode
    * @param renderingFlags
    * @return true if alias is on
    */
   public boolean toogleAlias() {
      ByteObject techCtx = getBOCtxSettings();
      int mode = techCtx.get1(CTX_COREDRAW_OFFSET_02_MODE_ALIAS1);
      if (mode == ITechGraphics.MODSET_APP_ALIAS_0_BEST || mode == ITechGraphics.MODSET_APP_ALIAS_1_ON) {
         techCtx.set1(CTX_COREDRAW_OFFSET_02_MODE_ALIAS1, ITechGraphics.MODSET_APP_ALIAS_2_OFF);
      } else {
         techCtx.set1(CTX_COREDRAW_OFFSET_02_MODE_ALIAS1, ITechGraphics.MODSET_APP_ALIAS_1_ON);
      }
      //send event

      applySettingsAlias();
      return techCtx.get1(CTX_COREDRAW_OFFSET_02_MODE_ALIAS1) != ITechGraphics.MODSET_APP_ALIAS_2_OFF;
   }

   /**
    * Force Toggle overriding even images that have their own settings
    * @param renderingFlags
    */
   public boolean toogleAliasForce() {
      ByteObject techCtx = getBOCtxSettings();
      techCtx.toggleFlag(CTX_COREDRAW_OFFSET_01_FLAG1, CTX_COREDRAW_FLAG_01_OVERRIDE_ALIAS);
      applySettingsAlias();
      return techCtx.hasFlag(CTX_COREDRAW_OFFSET_01_FLAG1, CTX_COREDRAW_FLAG_01_OVERRIDE_ALIAS);
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, CoreDrawCtx.class);
      toStringPrivate(dc);
      super.toString(dc.sup());

      dc.nlLvl(boModule, "BOModuleCoreDraw");
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, CoreDrawCtx.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   /**
    * {@link IBOCtxSettingsCoreDraw}
    */
   public void toStringCtxSettings(Dctx dc, ByteObject bo) {
      super.toStringCtxSettings(dc, bo);
      dc.nl();
      dc.rootN(bo, "IBOCtxSettingsCoreDraw", CoreDrawCtx.class, 190);

      int mode = bo.get1(IBOCtxSettingsCoreDraw.CTX_COREDRAW_OFFSET_02_MODE_ALIAS1);
      dc.appendVarWithNewLine("Mode_Alias", mode);
      dc.appendBracketedWithSpace(ToStringStaticCoreDraw.aliasMode(mode));

      int modeText = bo.get1(IBOCtxSettingsCoreDraw.CTX_COREDRAW_OFFSET_03_MODE_TEXT_ALIAS1);
      dc.appendVarWithNewLine("Mode_Alias_Text", modeText);
      dc.appendBracketedWithSpace(ToStringStaticCoreDraw.aliasMode(modeText));

   }
   //#enddebug

}
