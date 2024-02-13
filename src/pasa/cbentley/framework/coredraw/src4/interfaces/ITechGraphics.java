package pasa.cbentley.framework.coredraw.src4.interfaces;

public interface ITechGraphics {

   public static final int BASELINE                     = 64;

   public static final int BOTTOM                       = 32;

   public static final int DOTTED                       = 1;

   public static final int HCENTER                      = 1;

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
   public static final int IMPL_FLAG_1_ANTI_ALIAS       = 1 << 0;

   /**
    * When has it, underlying pipeline uses OpenGL
    */
   public static final int IMPL_FLAG_2_OPEN_GL          = 1 << 1;

   /**
    * Used by Bentley framework to check if Host supports clear pixel images.
    */
   public static final int IMPL_FLAG_3_TRANS_BACKGROUND = 1 << 2;

   /**
    * Explicitely force the absence of alias
    */
   public static final int IMPL_FLAG_4_NO_ALIAS         = 1 << 3;

   public static final int LEFT                         = 4;

   public static final int MODSET_APP_ALIAS_0_BEST      = 0;

   public static final int MODSET_APP_ALIAS_1_ON        = 1;

   public static final int MODSET_APP_ALIAS_2_OFF       = 2;

   public static final int RIGHT                        = 8;

   public static final int SOLID                        = 0;

   public static final int TOP                          = 16;

   public static final int VCENTER                      = 2;

}
