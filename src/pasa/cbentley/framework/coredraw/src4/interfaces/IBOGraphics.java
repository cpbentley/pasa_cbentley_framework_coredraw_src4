/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.interfaces;

import pasa.cbentley.byteobjects.src4.core.interfaces.IByteObject;
import pasa.cbentley.byteobjects.src4.ctx.IBOTypesBOC;
import pasa.cbentley.framework.coredraw.src4.engine.GraphicsAbstract;

/**
 * Defines the behavior of a {@link GraphicsAbstract} implementation
 * 
 * <p>
 * Use generic type {@link IBOTypesBOC#TYPE_020_PARAMATERS} 
 * </p>
 * 
 * @author Charles Bentley
 *
 */
public interface IBOGraphics extends IByteObject {

   public static final int GRAPHICS_BASIC_SIZE                 = A_OBJECT_BASIC_SIZE + 4;

   public static final int GRAPHICS_OFFSET_01_FLAG1            = A_OBJECT_BASIC_SIZE;

   /**
    * <li>{@link ITechGraphics#MODSET_APP_ALIAS_0_BEST}
    * <li>{@link ITechGraphics#MODSET_APP_ALIAS_1_ON}
    * <li>{@link ITechGraphics#MODSET_APP_ALIAS_2_OFF}
    */
   public static final int GRAPHICS_OFFSET_02_MODE_ALIAS1      = A_OBJECT_BASIC_SIZE + 1;

   /**
    * <li>{@link ITechGraphics#MODSET_APP_ALIAS_0_BEST}
    * <li>{@link ITechGraphics#MODSET_APP_ALIAS_1_ON}
    * <li>{@link ITechGraphics#MODSET_APP_ALIAS_2_OFF}
    */
   public static final int GRAPHICS_OFFSET_02_MODE_ALIAS_TEXT1 = A_OBJECT_BASIC_SIZE + 2;

}
