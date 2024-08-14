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
import pasa.cbentley.byteobjects.src4.ctx.IStaticIDsBO;
import pasa.cbentley.core.src4.ctx.CtxManager;
import pasa.cbentley.core.src4.ctx.ICtx;
import pasa.cbentley.core.src4.event.BusEvent;
import pasa.cbentley.core.src4.interfaces.IHost;
import pasa.cbentley.core.src4.interfaces.IHostData;
import pasa.cbentley.core.src4.interfaces.IHostFeature;
import pasa.cbentley.core.src4.interfaces.IHostService;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.coredraw.src4.interfaces.IBOGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.IGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImage;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImageFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.IMFont;
import pasa.cbentley.framework.coredraw.src4.interfaces.IScaler;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechHostFeatureDraw;

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
public abstract class CoreDrawCtx extends ABOCtx implements IBOCtxSettingsCoreDraw, ITechHostFeatureDraw {

   protected final BOModuleCoreDraw boModule;

   /**
    * Usually set externall using {@link CoreDrawCtx#setHost(IHost)}
    */
   protected IHost                  host;

   /**
    * In memory constrained context, config is null, and the default one is used packed in bytes ?
    * @param configDraw could be null, use the default config,
    * @param boc
    */
   public CoreDrawCtx(IConfigCoreDraw configDraw, BOCtx boc) {
      super(configDraw, boc);

      boModule = new BOModuleCoreDraw(this);

      CtxManager cm = uc.getCtxManager();
      cm.registerStaticRange(this, IStaticIDsBO.SID_BYTEOBJECT_TYPES, IBOTypesCoreDraw.AZ_BOTYPE_FW_A, IBOTypesCoreDraw.AZ_BOTYPE_FW_Z);

   }

   public void applySettings(ByteObject settingsNew, ByteObject settingsOld) {
      boc.getEventBus().sendNewEvent(IEventsBO.PID_01_CTX, IEventsBO.PID_01_CTX_1_SETTINGS_CHANGE, this);
   }

   public void applySettingsAlias() {
      BusEvent be = boc.getEventBus().createEvent(IEventsBO.PID_01_CTX, IEventsBO.PID_01_CTX_1_SETTINGS_CHANGE, this);
      be.setParam1(IEventsCoreDraw.SETTINGS_1_ALIAS);
      be.putOnBus();
   }

   public ByteObject createBOGraphicsDefault() {
      ByteObject bo = getBOC().getByteObjectFactory().createParameter(IBOGraphics.GRAPHICS_BASIC_SIZE);
      return bo;
   }

   /**
    * {@link IBOCtxSettingsCoreDraw}
    * @return
    */
   public ByteObject getBOCtxSettingsCoreDraw() {
      return getBOCtxSettings();
   }

   public int getBOCtxSettingSize() {
      return IBOCtxSettingsCoreDraw.CTX_COREDRAW_BASIC_SIZE;
   }

   public int getColorImageBackgroundDefault() {
      return getConfigCoreDraw().getColorImageBackgroundDefault();
   }

   public IConfigCoreDraw getConfigCoreDraw() {
      return (IConfigCoreDraw) config;
   }

   public ICtx[] getCtxSub() {
      return new ICtx[] { boc };
   }

   public Object getFeatureObject(int dataID) {
      return getHostData().getHostDataObject(dataID);
   }

   public abstract IFontFactory getFontFactory();

   public IHost getHost() {
      if (host == null) {
         throw new NullPointerException("Host must be set using setHost");
      }
      return host;
   }

   public IHostData getHostData() {
      return getHost().getHostData();
   }

   public IHostFeature getHostFeature() {
      return getHost().getHostFeature();
   }

   public IHostService getHostService() {
      return getHost().getHostService();
   }

   public abstract IImageFactory getImageFactory();

   public BOModuleCoreDraw getModule() {
      return boModule;
   }

   public abstract IScaler getScaler();

   /**
    * Factory tells us if produced images supports such or such feature.
    * 
    * <li>{@link ITechHostFeatureDraw#SUP_ID_03_OPEN_GL}
    * <li>{@link ITechHostFeatureDraw#SUP_ID_04_ALIAS}
    * <li>{@link ITechHostFeatureDraw#SUP_ID_05_ALIAS_TEXT}
    * <li>{@link ITechHostFeatureDraw#SUP_ID_06_CUSTOM_FONTS}
    * <li>{@link ITechHostFeatureDraw#SUP_ID_07_IMAGE_SCALING}
    * <li>{@link ITechHostFeatureDraw#SUP_ID_10_TRANSPARENT_BACKGROUND}
    * 
    * @param supportID
    * @return
    */
   public boolean hasFeatureSupport(int featureID) {
      return getHostFeature().isHostFeatureSupported(featureID);
   }

   public boolean isFeatureEnabled(int featureID) {
      return getHostFeature().isHostFeatureEnabled(featureID);
   }

   protected void matchConfig(IConfigBO config, ByteObject settings) {
   }

   /**
    * Must be set by the {@link CoreDrawCtx} implementation or user
    * @param host
    */
   public void setHost(IHost host) {
      this.host = host;
   }

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
      techCtx.flagToggle(CTX_COREDRAW_OFFSET_01_FLAG1, CTX_COREDRAW_FLAG_01_OVERRIDE_ALIAS);
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

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug

}
