package pasa.cbentley.framework.coredraw.src4.interfaces;


/**
 * 
 * https://www.khronos.org/opengles/sdk/docs/man/
 * 
 * @author Charles Bentley
 *
 */
public interface IGL2ES {

   public void glEnd();

   void glVertexAttrib1f(int index, float v0);

   void glVertexAttrib2f(int index, float v0, float v1);

   void glVertexAttrib3f(int index, float v0, float v1, float v2);

   /**
    * 
    * v0, v1,v2, v3 Specifies the new values to be used for the specified vertex attribute.
    * 
    * @param index Specifies the index of the generic vertex attribute to be modified.
    * @param v0
    * @param v1
    * @param v2
    * @param v3
    */
   void glVertexAttrib4f(int index, float v0, float v1, float v2, float v3);

   /**
    * unsigned int
    * @param program
    * @param shader
    */
   void glAttachShader(int program, int shader);
}
