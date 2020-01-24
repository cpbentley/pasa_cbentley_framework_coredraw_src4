package pasa.cbentley.framework.coredraw.src4.interfaces;

public interface IConfigDraw {

   /**
    * Overrides hardcoded font points.
    * 
    * @return when null, hardcoded points are used
    */
   public int[] getFontPoints();
   
   /**
    * <li> {@link ITechDrawer#MODSET_APP_ALIAS_0_BEST}
    * <li> {@link ITechDrawer#MODSET_APP_ALIAS_1_ON}
    * <li> {@link ITechDrawer#MODSET_APP_ALIAS_2_OFF}
    * @return
    */
   public int getAliasMode();
}
