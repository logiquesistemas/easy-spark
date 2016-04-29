package br.com.logique.easyspark;

import br.com.caelum.iogi.reflection.Target;
import br.com.caelum.iogi.spi.DependencyProvider;

/**
 * Created by gustavo on 28/04/2016.
 */
public class NullDependencyProvider implements DependencyProvider {

    @Override
    public boolean canProvide(Target<?> target) {
        return false;
    }

    @Override
    public Object provide(Target<?> target) {
        return null;
    }
}
