/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.byteobjects.src4.ctx.IConfigBO;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechGraphics;

/**
 * Generic configuration API for the {@link CoreDrawCtx}
 * 
 * @author Charles Bentley
 *
 */
public interface IConfigCoreDraw extends IConfigBO {

   /**
    * 
    * @return
    */
   public int getFontPoint_01_Tiny();

   /**
    * 
    * @return
    */
   public int getFontPoint_02_Small();

   /**
    * 
    * @return
    */
   public int getFontPoint_03_Medium();

   /**
    * 
    * @return
    */
   public int getFontPoint_04_Large();

   /**
    * 
    * @return
    */
   public int getFontPoint_05_Huge();

   /**
    * {@link IFontFactory#getFontPointExtraShift()}
    * 
    * @return
    */
   public int getFontPointsExtraShift();

   /**
    * <li> {@link ITechGraphics#MODSET_APP_ALIAS_0_BEST}
    * <li> {@link ITechGraphics#MODSET_APP_ALIAS_1_ON}
    * <li> {@link ITechGraphics#MODSET_APP_ALIAS_2_OFF}
    * @return
    */
   public int getAliasMode();

   /**
    * 
    * @return
    */
   public int getAliasModeText();

   /**
    * The color used by default when creating an empty image with an unspecified background color
    * @return
    */
   public int getColorImageBackgroundDefault();
}
