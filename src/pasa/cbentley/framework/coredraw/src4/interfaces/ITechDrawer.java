/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.interfaces;

import pasa.cbentley.byteobjects.src4.core.interfaces.IByteObject;
import pasa.cbentley.framework.coredraw.src4.engine.GraphicsAbstract;

/**
 * Defines the behavior of a {@link GraphicsAbstract} implementation
 * 
 * @author Charles Bentley
 *
 */
public interface ITechDrawer extends IByteObject {

   public static final int DRAWER_BASIC_SIZE                = A_OBJECT_BASIC_SIZE + 3;

   public static final int MODSET_APP_ALIAS_0_BEST          = 0;

   public static final int MODSET_APP_ALIAS_1_ON            = 1;

   public static final int MODSET_APP_ALIAS_2_OFF           = 2;

   public static final int DRAWER_OFFSET_02_MODE_ALIAS1     = A_OBJECT_BASIC_SIZE + 1;

   public static final int DRAWER_OFFSET_01_FLAG1           = A_OBJECT_BASIC_SIZE;

}
