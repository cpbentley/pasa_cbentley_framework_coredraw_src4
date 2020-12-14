/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.interfaces;

import pasa.cbentley.core.src4.interfaces.ITech;

/**
 * Tech parameters for {@link IGraphics}
 * 
 * @author Charles Bentley
 *
 */
public interface ITechFeaturesDraw extends ITech {

   /**
    * When {@link IGraphics} has this flag, it is anti aliased.
    * <br>
    * In Android, its an easy flag on the Paint object.
    * <br>
    * <br>
    * Link to the
    * {@link IModSetAppli#MODSET_APP_OFFSET_08_ANTI_ALIAS1}
    * <br>
    * Also when creating an image, user may decide to remove alias, if it is on by default.
    */
   public static final int IMPL_FLAG_1_ANTI_ALIAS           = 1 << 0;

   /**
    * When has it, underlying pipeline of {@link IGraphics} uses OpenGL
    */
   public static final int IMPL_FLAG_2_OPEN_GL              = 1 << 1;

   /**
    * {@link IModSetAppli#MODSET_APP_OFFSET_08_ANTI_ALIAS1}
    */
   public static final int IMPL_FLAG_3_ANTI_ALIAS_TEXT      = 1 << 2;

   /**
    * Used by Bentley framework to check if Host supports clear pixel images.
    * <br>
    * A framework like J2ME do not support and paint images white.
    */
   public static final int IMPL_FLAG_3_TRANS_BACKGROUND     = 1 << 2;

   /**
    * Explicitely force the absence of alias
    */
   public static final int IMPL_FLAG_4_NO_ALIAS             = 1 << 3;

   /**
    * When has it, underlying pipeline uses OpenGL
    */
   public static final int SUP_ID_03_OPEN_GL                = 3;

   /**
    * support the aliasing of draw
    */
   public static final int SUP_ID_04_ALIAS                  = 4;

   /**
    * Specific switch to disable/enable alias on text only
    */
   public static final int SUP_ID_05_ALIAS_TEXT             = 5;

   /**
    * Fonts can be changed by name etc. The {@link IFontCustomizer} interface is available
    */
   public static final int SUP_ID_06_CUSTOM_FONTS           = 6;

   /**
    * Scaling is done by the host implementation
    */
   public static final int SUP_ID_07_IMAGE_SCALING          = 7;

   /**
    * All but J2ME
    */
   public static final int SUP_ID_10_TRANSPARENT_BACKGROUND = 10;
}
