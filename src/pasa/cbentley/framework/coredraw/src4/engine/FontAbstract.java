/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.engine;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.ctx.ToStringStaticCoreDraw;
import pasa.cbentley.framework.coredraw.src4.interfaces.IMFont;

/**
 * J2SE bridge class for the {@link mordan.device.ui.FontAbstract.Font} class of MIDP 2.0 <br>
 * 
 * TODO how to provide antialiased font drawing in this bridge?
 * 
 * <br>
 * Font class is final in J2ME...
 * 
 * 
 * @author
 *
 */
public abstract class FontAbstract implements IMFont {

   protected final CoreDrawCtx cac;

   protected int               face, style, size;

   protected FontAbstract(CoreDrawCtx cac) {
      this.cac = cac;

   }

   protected FontAbstract(CoreDrawCtx cac, int face, int style, int size) {
      this.cac = cac;
      this.face = face;
      this.style = style;
      this.size = size;
   }

   public abstract int charsWidth(char[] c, int ofs, int len);

   public abstract int charWidth(char c);

   public int getFace() {
      return face;
   }

   public abstract int getHeight();

   public int getSize() {
      return size;
   }

   public int getStyle() {
      return style;
   }

   public boolean isBold() {
      return (style & IMFont.STYLE_BOLD) != 0;
   }

   public boolean isItalic() {
      return (style & IMFont.STYLE_ITALIC) != 0;
   }

   public boolean isPLAIN() {
      return style == IMFont.STYLE_PLAIN;
   }

   public boolean isUnderlined() {
      return (style & IMFont.STYLE_UNDERLINED) != 0;
   }

   public abstract int stringWidth(String s);

   public abstract int substringWidth(String s, int offset, int length);

   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, FontAbstract.class, "@line5");
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FontAbstract.class);
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return cac.getUC();
   }

   private void toStringPrivate(Dctx dc) {
      dc.appendVarWithSpace("face", ToStringStaticCoreDraw.toStringFontFace(face));
      dc.appendVarWithSpace("size", ToStringStaticCoreDraw.toStringFontSize(size));
      dc.appendVarWithSpace("style", ToStringStaticCoreDraw.toStringFontStyle(style));
   }

   //#enddebug

}
