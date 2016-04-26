package br.com.logique.easyspark.sparkengine;

import br.com.logique.easyspark.util.PathUtil;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import org.reflections.Reflections;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.lang.reflect.Method;
import java.util.Set;

import static spark.Spark.staticFileLocation;

/**
 * Created by gustavo on 26/04/2016.
 */
public class SparkEngine {

    private String basePackage;

    private int port;

    private String defaultEncoding;

    public String staticFileLocation;

    public String templateLocation;

    private SparkEngine(int port, String defaultEncoding, String staticFileLocation, String templateLocation, String basePackage) {
        this.port = port;
        this.defaultEncoding = defaultEncoding;
        this.staticFileLocation = staticFileLocation;
        this.templateLocation = templateLocation;
        this.basePackage = basePackage;
    }

    public void setUp() {
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration freeMarkerConfiguration = new Configuration(Configuration.getVersion());
        freeMarkerConfiguration.setOutputEncoding(defaultEncoding);
        freeMarkerConfiguration.setDefaultEncoding(defaultEncoding);
        freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(SparkEngine.class, templateLocation));
        freeMarkerEngine.setConfiguration(freeMarkerConfiguration);
        staticFileLocation(staticFileLocation);
        Spark.port(port);
        findControllers();
    }

    private void findControllers() {
        Reflections reflections = new Reflections(basePackage);
        Set<Class<?>> controllers = reflections.getTypesAnnotatedWith(Controller.class);
        for (Class<?> controller : controllers) {
            registerController(controller);
        }
    }

    private void registerController(Class<?> controller) {
        String clazzName = controller.getSimpleName();
        Method[] methods = controller.getDeclaredMethods();
        for (Method method : methods) {
            Spark.get(PathUtil.getPath(clazzName, method.getName()),
                    (request, response) -> new InvocationProxy(controller, method).execute(request, response));
        }
    }

    public static class Builder {

        private int port = 4567;

        private String defaultEncoding = "UTF-8";

        public String staticFileLocation = "/public";

        public String templateLocation = "/public/templates";

        public String basePackage = "com";

        public Builder withPort(int port) {
            this.port = port;
            return this;
        }

        public Builder withDefaultEncoding(String defaultEncoding) {
            this.defaultEncoding = defaultEncoding;
            return this;
        }

        public Builder withStaticFileLocation(String staticFileLocation) {
            this.staticFileLocation = staticFileLocation;
            return this;
        }

        public Builder withTemplateLocation(String templateLocation) {
            this.templateLocation = templateLocation;
            return this;
        }

        public Builder withBasePackage(String basePackage){
            this.basePackage = basePackage;
            return this;
        }

        public SparkEngine build() {
            return new SparkEngine(port, defaultEncoding, staticFileLocation, templateLocation, basePackage);
        }

    }


}
