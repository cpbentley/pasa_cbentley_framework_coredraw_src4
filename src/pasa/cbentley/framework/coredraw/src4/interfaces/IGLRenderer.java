package pasa.cbentley.framework.coredraw.src4.interfaces;

public interface IGLRenderer {

   /**
    * Called to draw the current frame.
    * @param gl
    */
   public void onDrawFrame(IGL2ES gl);

   /**
   *  Called when the surface changed size.
   */
   public void onSurfaceChanged(IGL2ES gl, int width, int height);

   /**
    * Called when the surface is created or recreated. 
    * @param gl
    * @param config
    */
   public void onSurfaceCreated(IGL2ES gl, Object config);

}
