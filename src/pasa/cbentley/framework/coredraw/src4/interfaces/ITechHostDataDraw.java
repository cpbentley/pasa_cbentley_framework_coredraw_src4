package pasa.cbentley.framework.coredraw.src4.interfaces;

import pasa.cbentley.core.src4.interfaces.IHostData;
import pasa.cbentley.core.src4.interfaces.ITech;

public interface ITechHostDataDraw extends ITech {

   public static final int DATA_ID_STR_01_MANUFACTURER   = 1;

   public static final int DATA_ID_STR_02_IMEI           = 2;

   public static final int DATA_ID_STR_03_DEVICE_MODEL   = 3;

   /**
    * Name of the Platform
    * 
    * <p>
    * Valid only in {@link IHostData#getHostDataString(int)}
    * </p>
    */
   public static final int DATA_ID_STR_04_PLATFORM       = 4;

   /**
    * Name of the Host
    * 
    * <p>
    * Valid only in {@link IHostData#getHostDataString(int)}
    * </p>
    */
   public static final int DATA_ID_STR_05_HOSTNAME       = 5;

   public static final int DATA_ID_STR_06_ENCODING       = 6;

   public static final int DATA_ID_STR_07_FILE_SEPARATOR = 7;
}
