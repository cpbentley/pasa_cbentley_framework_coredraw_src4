/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.engine;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.structs.IntToStrings;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontCustomizer;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.IMFont;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFeaturesDraw;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;

/**
 * Template src4 implementation of the {@link IFontFactory}
 * 
 * Uses a cache of {@link IMFont}, which in turn allow Factory wide increase/decrease
 * 
 * Assume we don't have access to custom fonts. Custom fonts is the job of {@link FontCustomizerAbstract}
 * 
 * @author Charles Bentley
 *
 */
public abstract class FontFactoryAbstract implements IFontFactory, ITechFont {

   protected final CoreDrawCtx cdc;

   public IntToStrings         customFonts;

   protected IMFont            fontDef;

   private IMFont              fontDefMono;

   private IMFont              fontDefProp;

   protected int               fontPointsExtraShift;

   /**
    * In some frameworks like J2ME and android, font points are not used
    */
   protected int[]             fontPoints = null;

   /**
    * Cache of Fonts
    * <li> Face ID
    * <li> Style ID
    * <li> Size IDs
    */
   private IMFont[][][]        fonts      = new IMFont[3][4][6];

   protected IMFont            z_refFontDebug;

   public FontFactoryAbstract(CoreDrawCtx cdc) {
      this.cdc = cdc;

   }
   
   public int[] getFontSizes() {
      int[] vs = new int[5];
      vs[0] = ITechFont.SIZE_1_TINY;
      vs[1] = ITechFont.SIZE_2_SMALL;
      vs[2] = ITechFont.SIZE_3_MEDIUM;
      vs[3] = ITechFont.SIZE_4_LARGE;
      vs[4] = ITechFont.SIZE_5_HUGE;
      return vs;
   }

   public void clearFontCache() {
      z_refFontDebug = null;
      fontDef = null;
      fontDefProp = null;
      fontDefMono = null;
      for (int i = 0; i < fonts.length; i++) {
         for (int j = 0; j < fonts[i].length; j++) {
            for (int k = 0; k < fonts[i][j].length; k++) {
               fonts[i][j][k] = null;
            }
         }
      }
   }

   public int getFontPointExtraShift() {
      return fontPointsExtraShift;
   }

   public VisualState fontSizeDecrease() {
      VisualState vs = new VisualState();
      for (int i = 0; i < fontPoints.length; i++) {
         if (fontPoints[i] > 0)
            fontPoints[i]--;
      }
      //update all fonts
      vs.fontPoints = fontPoints;
      clearFontCache();
      return vs;
   }

   public IFontCustomizer getFontCustomizer() {
      IFontCustomizer fontCustomizer = (IFontCustomizer) cdc.getFeatureObject(ITechFeaturesDraw.SUP_ID_06_CUSTOM_FONTS);
      return fontCustomizer;
   }

   public void setFontName(String name) {
      if (cdc.hasFeatureSupport(ITechFeaturesDraw.SUP_ID_06_CUSTOM_FONTS)) {
         IFontCustomizer fontCustomizer = getFontCustomizer();
         if (fontCustomizer != null) {
            fontCustomizer.setFontFamilySystem(name);
         }
         clearFontCache();
      }
   }

   /**
    * Caller must call the hooks for updating current fonts in the GUI layout, i.e. it has to renew the
    * layout of all graphical components including cached.
    * <br>
    * 
    * @return
    */
   public VisualState fontSizeIncrease() {
      VisualState vs = new VisualState();
      for (int i = 0; i < fontPoints.length; i++) {
         fontPoints[i]++;
      }
      vs.fontPoints = fontPoints;
      clearFontCache();
      return vs;
   }

   public IMFont getDefaultFont() {
      if (fontDef == null) {
         fontDef = getFont(IMFont.FACE_SYSTEM, IMFont.STYLE_PLAIN, IMFont.SIZE_4_LARGE);
      }
      return fontDef;
   }

   public IMFont getDefaultFontMono() {
      if (fontDefMono == null) {
         fontDefMono = getFont(IMFont.FACE_MONOSPACE, IMFont.STYLE_PLAIN, IMFont.SIZE_4_LARGE);
      }
      return fontDefMono;
   }

   public IMFont getDefaultFontProportional() {
      if (fontDefProp == null) {
         fontDefProp = getFont(IMFont.FACE_PROPORTIONAL, IMFont.STYLE_PLAIN, IMFont.SIZE_4_LARGE);
      }
      return fontDefProp;
   }

   /**
    * Returns null if Font was not previously created in the current cycle.
    * @param face
    * @param style
    * @param size
    * @return
    */
   public IMFont getFontCached(int face, int style, int size) {
      int idFace = 0;
      if (face == IMFont.FACE_PROPORTIONAL) {
         idFace = 1;
      } else if (face == IMFont.FACE_SYSTEM) {
         idFace = 2;
      }
      int idStyle = 0;
      if (style == IMFont.STYLE_PLAIN) {
         idStyle = 1;
      } else if (style == IMFont.STYLE_BOLD) {
         idStyle = 2;
      } else if (style == IMFont.STYLE_ITALIC) {
         idStyle = 3;
      }
      int idSize = 0;
      switch (size) {
         case IMFont.SIZE_1_TINY:
            idSize = 1;
            break;
         case IMFont.SIZE_2_SMALL:
            idSize = 2;
            break;
         case IMFont.SIZE_3_MEDIUM:
            idSize = 3;
            break;
         case IMFont.SIZE_4_LARGE:
            idSize = 4;
            break;
         case IMFont.SIZE_5_HUGE:
            idSize = 5;
            break;
         default:
            idSize = 0;
            break;
      }
      return fonts[idFace][idStyle][idSize];
   }

   public IMFont getFontDebug() {
      if (z_refFontDebug == null)
         z_refFontDebug = getFont(IMFont.FACE_SYSTEM, IMFont.STYLE_BOLD, IMFont.SIZE_3_MEDIUM);
      return z_refFontDebug;
   }

   /**
    * 
    * @param string
    * @return
    */
   public int getFontFaceID(String string) {
      if (customFonts == null) {
         return IMFont.FACE_SYSTEM;
      } else {
         int index = customFonts.getFirstStringIndex(string);
         if (index != -1) {
            return customFonts.ints[index];
         }
         return IMFont.FACE_SYSTEM;
      }
   }

   public String getFontFaceFromID(int id, String def) {
      if (customFonts != null) {
         if (customFonts.nextempty > id && id >= 0) {
            String str = customFonts.getString(id);
            if (str != null) {
               return str;
            }
         }
      }
      return def;
   }

   public IMFont getFontScaled(int sizeHint, IMFont srcFont, int h) {
      int diff = h - srcFont.getHeight();

      int face = srcFont.getFace();
      int style = srcFont.getStyle();

      return srcFont;
   }

   /**
    * Look up in the ressources for the font.
    * returns Face ID or -1 if not found
    * @param string
    * @return
    */
   public int loadCustomFont(String string) {
      return -1;
   }

   public void loadFont(String path) {
      throw new RuntimeException("Implement in a subclass. otherwise method cannot be called");
   }

   public void setFontFromCache(int face, int style, int size, IMFont font) {
      int idFace = 0;
      if (face == IMFont.FACE_PROPORTIONAL) {
         idFace = 1;
      } else if (face == IMFont.FACE_SYSTEM) {
         idFace = 2;
      }
      int idStyle = 0;
      if (style == IMFont.STYLE_PLAIN) {
         idStyle = 1;
      } else if (style == IMFont.STYLE_BOLD) {
         idStyle = 2;
      } else if (style == IMFont.STYLE_ITALIC) {
         idStyle = 3;
      }
      int idSize = 0;
      if (face == IMFont.SIZE_4_LARGE) {
         idSize = 1;
      } else if (size == IMFont.SIZE_3_MEDIUM) {
         idSize = 2;
      } else if (size == IMFont.SIZE_5_HUGE) {
         idSize = 4;
      } else if (size == IMFont.SIZE_1_TINY) {
         idSize = 3;
      }
      fonts[idFace][idStyle][idSize] = font;
   }

   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, FontFactoryAbstract.class, "@line5");
      toStringPrivate(dc);
      if (fontPoints == null) {
         dc.append("fontPoints array is null");
      } else {
         for (int i = 0; i < fontPoints.length; i++) {
            dc.appendVarWithNewLine("SIZE_0_DEFAULT", fontPoints[ITechFont.SIZE_0_DEFAULT]);
            dc.appendVarWithNewLine("SIZE_1_TINY", fontPoints[ITechFont.SIZE_1_TINY]);
            dc.appendVarWithNewLine("SIZE_2_SMALL", fontPoints[ITechFont.SIZE_2_SMALL]);
            dc.appendVarWithNewLine("SIZE_3_MEDIUM", fontPoints[ITechFont.SIZE_3_MEDIUM]);
            dc.appendVarWithNewLine("SIZE_4_LARGE", fontPoints[ITechFont.SIZE_4_LARGE]);
            dc.appendVarWithNewLine("SIZE_5_HUGE", fontPoints[ITechFont.SIZE_5_HUGE]);
         }
      }
      dc.nlLvl(fontDef, "fontDef");
      dc.nlLvl(fontDefMono, "fontDefMono");
      dc.nlLvl(fontDefProp, "fontDefProp");
      dc.nlLvl(z_refFontDebug, "z_refFontDebug");
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FontFactoryAbstract.class);
      toStringPrivate(dc);
   }

   public String toStringFontFamilies() {
      Dctx dc = new Dctx(toStringGetUCtx());
      toStringFontFamilies(dc);
      return dc.toString();
   }

   public void toStringFontFamilies(Dctx dc) {
      String[] names = getFontFamilies();
      if (names == null) {
         dc.append("getFontFamilies array is null");
      } else {
         dc.appendVar("#fonts families", names.length);
         for (int i = 0; i < names.length; i++) {
            dc.nl();
            dc.appendWithSpace(names[i]);
         }
      }
   }

   public String toStringFontNames() {
      Dctx dc = new Dctx(toStringGetUCtx());
      toStringFontNames(dc);
      return dc.toString();
   }

   public void toStringFontNames(Dctx dc) {
      String[] names = getFontNames();
      if (names == null) {
         dc.append("getFontNames array is null");
      } else {
         dc.appendVar("#fonts", names.length);
         for (int i = 0; i < names.length; i++) {
            dc.nl();
            dc.appendWithSpace(names[i]);
         }
      }
   }

   public UCtx toStringGetUCtx() {
      return cdc.getUCtx();
   }

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
