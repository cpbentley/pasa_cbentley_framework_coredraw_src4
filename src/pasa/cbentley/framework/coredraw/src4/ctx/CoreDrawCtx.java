package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.ctx.ABOCtx;
import pasa.cbentley.byteobjects.src4.ctx.BOCtx;
import pasa.cbentley.byteobjects.src4.ctx.IEventsBO;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.event.BusEvent;
import pasa.cbentley.framework.coredraw.src4.interfaces.IConfigDraw;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.IGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImage;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImageFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.IMFont;
import pasa.cbentley.framework.coredraw.src4.interfaces.IScaler;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechDrawFeatures;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechDrawer;

/**
 * Provides just the bare minimum UI
 * 
 * <li> {@link IMFont} and its factory {@link IFontFactory}
 * <li> {@link IImage} and its factory {@link IImageFactory}
 * <li> {@link IGraphics} the drawing interface
 * 
 * The context is independant from other framework contexts.
 * 
 * Implementation
 * 
 * @author Charles Bentley
 *
 */
public abstract class CoreDrawCtx extends ABOCtx implements ITechCtxSettingsCoreDraw, ITechDrawFeatures {

   protected final IConfigDraw configDraw;

   /**
    * In memory constrained context, config is null, and the default one is used packed in bytes ?
    * 
    * @param uc
    * @param boc
    * @param configDraw could be null, use the default config,
    */
   public CoreDrawCtx(UCtx uc, BOCtx boc, IConfigDraw configDraw) {
      super(boc);
      this.configDraw = configDraw;
      
      //when settings don't exist yet. print the config to it
      if(hasCtxData()) {
         
      } else {
         //create settings based on config
         ByteObject sets = getSettingsBO();
         sets.set1(CTX_COREDRAW_OFFSET_02_MODE_ALIAS1, configDraw.getAliasMode());
      }
      
   }
   
   /**
    * {@link ITechCtxSettingsCoreDraw}
    * @return
    */
   public ByteObject getTech() {
      return getSettingsBO();
   }

   public void applySettings() {
      boc.getEventBus().sendNewEvent(IEventsBO.PID_1_CTX, IEventsBO.PID_1_CTX_1_SETTINGS_CHANGE, this);
   }

   public void applySettingsAlias() {
      BusEvent be = boc.getEventBus().createEvent(IEventsBO.PID_1_CTX, IEventsBO.PID_1_CTX_1_SETTINGS_CHANGE, this);
      be.setParam1(IEventsCoreDraw.SETTINGS_1_ALIAS);
      be.putOnBus();
   }

   public int getBOSettingsCtxSize() {
      return ITechCtxSettingsCoreDraw.CTX_COREDRAW_BASIC_SIZE;
   }

   public abstract IFontFactory getFontFactory();

   public abstract IImageFactory getImageFactory();

   public abstract IScaler getScaler();

   /**
    * Factory tells us if produced images supports such or such feature.
    * 
    * {@link ITechDrawFeatures#SUP_ID_06_CUSTOM_FONTS}
    * {@link ITechDrawFeatures#SUP_ID_07_IMAGE_SCALING}
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
      ByteObject techCtx = getSettingsBO();
      int mode = techCtx.get1(CTX_COREDRAW_OFFSET_02_MODE_ALIAS1);
      if (mode == ITechDrawer.MODSET_APP_ALIAS_0_BEST || mode == ITechDrawer.MODSET_APP_ALIAS_1_ON) {
         techCtx.set1(CTX_COREDRAW_OFFSET_02_MODE_ALIAS1, ITechDrawer.MODSET_APP_ALIAS_2_OFF);
      } else {
         techCtx.set1(CTX_COREDRAW_OFFSET_02_MODE_ALIAS1, ITechDrawer.MODSET_APP_ALIAS_1_ON);
      }
      //send event

      applySettingsAlias();
      return techCtx.get1(CTX_COREDRAW_OFFSET_02_MODE_ALIAS1) != ITechDrawer.MODSET_APP_ALIAS_2_OFF;
   }

   /**
    * Force Toggle overriding even images that have their own settings
    * @param renderingFlags
    */
   public boolean toogleAliasForce() {
      ByteObject techCtx = getSettingsBO();
      techCtx.toggleFlag(CTX_COREDRAW_OFFSET_01_FLAG1, CTX_COREDRAW_FLAG_01_OVERRIDE_ALIAS);
      applySettingsAlias();
      return techCtx.hasFlag(CTX_COREDRAW_OFFSET_01_FLAG1, CTX_COREDRAW_FLAG_01_OVERRIDE_ALIAS);
   }
}
