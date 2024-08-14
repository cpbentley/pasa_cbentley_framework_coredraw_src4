/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.src4.interfaces;

import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.layouter.src4.tech.ITechLayout;

/**
 * 
 * @author Charles Bentley
 *
 */
public interface IScaler extends IStringable {
   /**
    * Get the Pixel value of a scale value
    * <br>
    * <li>{@link ITechLayout#SIZE_1_SMALLEST}
    * <li>{@link ITechLayout#SIZE_2_SMALL}
    * <li>{@link ITechLayout#SIZE_3_MEDIUM}
    * <br>
    * <br>
    * For the scale id
    * <li>{@link ITechLayout#SCALE_0_PADDING}  Mostly used to find how much padding is possible
    * <li>{@link ITechLayout#SCALE_1_EXPO}
    * <br>
    * <br>
    * Return values may change when Font size or other events change the Host
    * dimensions.
    * <br>
    * Scales are managed by the Host config files and may dynamically changes if screen sizes
    * changes.
    * <br>
    * @param valu {@link ITechLayout#SIZE_1_SMALLEST}
    * @param fun
    * @return
    */
   public int getScalePixel(int valu, int fun);

}
