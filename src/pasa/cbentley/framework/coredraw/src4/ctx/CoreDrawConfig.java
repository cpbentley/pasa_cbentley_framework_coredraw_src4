package pasa.cbentley.framework.coredraw.src4.ctx;

import pasa.cbentley.core.src4.ctx.UCtx;

/**
 * Configuration by default
 * @author Charles Bentley
 *
 */
public class CoreDrawConfig {

   public static final int FONT_LARGE_POINTS      = 20;

   public static final int FONT_MEDIUM_POINTS     = 16;

   public static final int FONT_SMALL_POINTS      = 12;

   public static final int FONT_VERY_LARGE_POINTS = 24;

   public static final int FONT_VERY_SMALL_POINTS = 8;

   private String          fontNameMonoSpace      = "Trebuchet MS";

   private String          fontNameProportional   = "Trebuchet MS";

   private String          fontNameSystem         = "Trebuchet MS";

   private int[]           fontPoints             = new int[] { FONT_SMALL_POINTS, FONT_MEDIUM_POINTS, FONT_LARGE_POINTS, FONT_VERY_SMALL_POINTS, FONT_VERY_LARGE_POINTS };

   public CoreDrawConfig(UCtx uc) {

   }
}
