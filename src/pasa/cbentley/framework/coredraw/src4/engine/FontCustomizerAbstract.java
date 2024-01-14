package pasa.cbentley.framework.coredraw.src4.engine;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontCustomizer;

/**
 * 
 * @author Charles Bentley
 *
 */
public abstract class FontCustomizerAbstract implements IFontCustomizer {

   protected final CoreDrawCtx         cdc;

   private String                      defaultFontNameMono;

   private String                      defaultFontNameProportional;

   private String                      defaultFontNameSystem;

   protected final FontFactoryAbstract factory;

   public FontCustomizerAbstract(CoreDrawCtx cdc, FontFactoryAbstract factory) {
      this.cdc = cdc;
      this.factory = factory;
   }

   public void setFontFamilyMonospace(String family) {
      defaultFontNameMono = family;
   }

   public void setFontFamilySystem(String family) {
      defaultFontNameSystem = family;

   }

   public void setFontFamilyProportional(String family) {
      defaultFontNameProportional = family;
   }

   public String getDefaultFontNameMono() {
      if (defaultFontNameMono == null) {
         //use hardcoded default
         defaultFontNameMono = getDefaultFontNameMonoSub();
      }
      return defaultFontNameMono;
   }

   /**
    * Read it fron config or saved settings
    * @return
    */
   protected abstract String getDefaultFontNameMonoSub();

   /**
    * 
    * @return
    */
   public String getDefaultFontNameProportional() {
      if (defaultFontNameProportional == null) {
         //use hardcoded default
         defaultFontNameProportional = getDefaultFontNamePropSub();
      }
      return defaultFontNameProportional;
   }

   protected abstract String getDefaultFontNamePropSub();

   public String getDefaultFontNameSystem() {
      if (defaultFontNameSystem == null) {
         //use hardcoded default
         defaultFontNameSystem = getDefaultFontNameSystemSub();
      }
      return defaultFontNameSystem;
   }

   protected abstract String getDefaultFontNameSystemSub();

   public void setDefaultFontNameMono(String defaultFontNameMono) {
      //validates the font name for the system?
      this.defaultFontNameMono = defaultFontNameMono;
   }

   public void setDefaultFontNameProportional(String defaultFontNameProportional) {
      this.defaultFontNameProportional = defaultFontNameProportional;
   }

   public void setDefaultFontNameSystem(String defaultFontNameSystem) {
      this.defaultFontNameSystem = defaultFontNameSystem;
   }

   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, FontCustomizerAbstract.class, "@line45");
      toStringPrivate(dc);
      dc.appendVarWithSpace("defaultFontNameMono", defaultFontNameMono);
      dc.appendVarWithSpace("defaultFontNameProportional", defaultFontNameProportional);
      dc.appendVarWithSpace("defaultFontNameProportional", defaultFontNameProportional);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FontCustomizerAbstract.class);
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return cdc.getUCtx();
   }

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
