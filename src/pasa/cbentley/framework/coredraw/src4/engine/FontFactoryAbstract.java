/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.engine;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.structs.IntToStrings;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.ctx.ObjectCDC;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontCustomizer;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.IMFont;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechHostFeatureDraw;

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
public abstract class FontFactoryAbstract extends ObjectCDC implements IFontFactory, ITechFont {

   public IntToStrings  customFonts;

   protected IMFont     fontDef;

   private IMFont       fontDefMono;

   private IMFont       fontDefProp;

   protected int        fontPointsExtraShift;

   /**
    * Cache of Fonts
    * <li> Face ID
    * <li> Style ID
    * <li> Size IDs
    */
   private IMFont[][][] fonts = new IMFont[3][4][6];

   protected IMFont     z_refFontDebug;

   public FontFactoryAbstract(CoreDrawCtx cdc) {
      super(cdc);
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

   /**
    * By Default we are not able to do this. this will depend on the host capabilities
    */
   public VisualState fontSizeDecrease() {
      VisualState vs = new VisualState();
      return vs;
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

   public IFontCustomizer getFontCustomizer() {
      IFontCustomizer fontCustomizer = (IFontCustomizer) cdc.getFeatureObject(ITechHostFeatureDraw.SUP_ID_06_CUSTOM_FONTS);
      return fontCustomizer;
   }

   public IMFont getFontDebug() {
      if (z_refFontDebug == null)
         z_refFontDebug = getFont(IMFont.FACE_SYSTEM, IMFont.STYLE_BOLD, IMFont.SIZE_3_MEDIUM);
      return z_refFontDebug;
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

   public int getFontPointExtraShift() {
      return fontPointsExtraShift;
   }

   public IMFont getFontScaled(int sizeHint, IMFont srcFont, int h) {
      int diff = h - srcFont.getHeight();

      int face = srcFont.getFace();
      int style = srcFont.getStyle();

      return srcFont;
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

   public IMFont getFont(int face, int style, int size) {
      IMFont f = getFontCached(face, style, size);
      if (f == null) {
         f = createFont(face, style, size);
         setFontFromCache(face, style, size, f);
      }
      return f;
   }

   protected abstract IMFont createFont(int face, int style, int size);

   /**
    * Sets the font for {@link ITechFont#FACE_SYSTEM}
    */
   public void setFontName(String name) {
      if (cdc.hasFeatureSupport(ITechHostFeatureDraw.SUP_ID_06_CUSTOM_FONTS)) {
         IFontCustomizer fontCustomizer = getFontCustomizer();
         if (fontCustomizer != null) {
            fontCustomizer.setFontFamilySystem(name);
         }
         clearFontCache();
      }
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, FontFactoryAbstract.class, "@line5");
      toStringPrivate(dc);
      dc.nlLvl(fontDef, "fontDef");
      dc.nlLvl(fontDefMono, "fontDefMono");
      dc.nlLvl(fontDefProp, "fontDefProp");
      dc.nlLvl(z_refFontDebug, "z_refFontDebug");
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FontFactoryAbstract.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
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

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
