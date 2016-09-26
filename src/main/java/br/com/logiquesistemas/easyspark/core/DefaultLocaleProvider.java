package br.com.logiquesistemas.easyspark.core;

import br.com.caelum.iogi.spi.LocaleProvider;

import java.util.Locale;

/**
 * Created by gustavo on 30/04/2016.
 */
public class DefaultLocaleProvider implements LocaleProvider {

    @Override
    public Locale getLocale() {
        return new Locale("pt_BR");
    }
}
