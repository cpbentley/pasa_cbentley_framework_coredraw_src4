/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.engine;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.ctx.ObjectCDC;
import pasa.cbentley.framework.coredraw.src4.ctx.ToStringStaticCoreDraw;
import pasa.cbentley.framework.coredraw.src4.interfaces.IMFont;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;

/**
 *
 */
public abstract class FontAbstract extends ObjectCDC implements IMFont {

   protected int face, style, size;

   protected FontAbstract(CoreDrawCtx cdc) {
      super(cdc);
   }

   protected FontAbstract(CoreDrawCtx cdc, int face, int style, int size) {
      super(cdc);
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
      return style == STYLE_1_BOLD;
   }

   public boolean isItalic() {
      return style == STYLE_2_ITALIC;
   }

   public boolean isMonospace() {
      if (face == ITechFont.FACE_01_MONOSPACE) {
         return true;
      }
      return stringWidth("m") == stringWidth("i");
   }

   public boolean isPLain() {
      return style == STYLE_0_PLAIN;
   }

   public abstract int stringWidth(String s);

   public abstract int substringWidth(String s, int offset, int length);

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, FontAbstract.class, 70);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FontAbstract.class, 70);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {
      dc.appendVarWithSpace("face", ToStringStaticCoreDraw.toStringFontFace(face));
      dc.appendVarWithSpace("size", ToStringStaticCoreDraw.toStringFontSize(size));
      dc.appendVarWithSpace("style", ToStringStaticCoreDraw.toStringFontStyle(style));
   }
   //#enddebug

}
