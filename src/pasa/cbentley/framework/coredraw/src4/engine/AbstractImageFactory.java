package pasa.cbentley.framework.coredraw.src4.engine;

import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImageFactory;

public abstract class AbstractImageFactory implements IImageFactory {

   protected final CoreDrawCtx fc;

   public AbstractImageFactory(CoreDrawCtx fc) {
      this.fc = fc;
   }
}
