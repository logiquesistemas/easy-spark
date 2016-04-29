package br.com.logique.easyspark;

import br.com.logique.easyspark.annotations.Controller;
import br.com.logique.easyspark.annotations.Delete;
import br.com.logique.easyspark.annotations.Post;
import br.com.logique.easyspark.annotations.Put;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.lang.reflect.Method;
import java.util.Set;

import static spark.Spark.staticFileLocation;

/**
 * Manage Spark framework.
 *
 * Created by gustavo on 26/04/2016.
 */
public class SparkEngine {

    private static Logger logger = LoggerFactory.getLogger(SparkEngine.class);

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

    /**
     * Spark framework initialization.
     */
    public void setUp() {
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration freeMarkerConfiguration = new Configuration(Configuration.getVersion());
        freeMarkerConfiguration.setOutputEncoding(defaultEncoding);
        freeMarkerConfiguration.setDefaultEncoding(defaultEncoding);
        freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(SparkEngine.class, templateLocation));
        freeMarkerEngine.setConfiguration(freeMarkerConfiguration);
        staticFileLocation(staticFileLocation);
        Spark.port(port);
        addRoutes();
        Spark.init();
        Spark.awaitInitialization();
    }

    private void addRoutes() {
        Reflections reflections = new Reflections(basePackage);
        Set<Class<?>> controllers = reflections.getTypesAnnotatedWith(Controller.class);
        for (Class<?> controller : controllers) {
            registerController(controller);
        }
    }

    private void registerController(Class<?> controller) {
        Method[] methods = controller.getDeclaredMethods();
        for (Method method : methods) {
            registerSparkRoute(controller, method);
        }
    }

    private void registerSparkRoute(Class<?> controller, Method method) {
        PathResolver defaultPathResolver = new DefaultPathResolver();
        String path = defaultPathResolver.resolvePath(controller, method);
        if (method.isAnnotationPresent(Post.class)) {
            logger.info("Registering a POST path {} --> {}::{}", path, controller.getSimpleName(), method.getName());
            Spark.post(path, (request, response) -> new InvocationHandle(controller, method).execute(request, response));
        } else if (method.isAnnotationPresent(Delete.class)) {
            logger.info("Registering a DELETE path {} --> {}::{}", path, controller.getSimpleName(), method.getName());
            Spark.delete(path, (request, response) -> new InvocationHandle(controller, method).execute(request, response));
        } else if (method.isAnnotationPresent(Put.class)) {
            logger.info("Registering a PUT path {} --> {}::{}", path, controller.getSimpleName(), method.getName());
            Spark.put(path, (request, response) -> new InvocationHandle(controller, method).execute(request, response));
        } else {
            logger.info("Registering a GET path {} --> {}::{}", path, controller.getSimpleName(), method.getName());
            Spark.get(path, (request, response) -> new InvocationHandle(controller, method).execute(request, response));
        }
    }

    public static class Builder {

        private int port = 4567;

        private String defaultEncoding = "UTF-8";

        public String staticFileLocation = "/public";

        public String templateLocation = "/public/templates";

        public String basePackage = "br.com";

        public Builder withPort(int port) {
            this.port = port;
            return this;
        }

        /**
         * Define the default encoding to FreeMarker. Default: UTF-8
         *
         * @param defaultEncoding encoding.
         * @return Spark engine builder
         */
        public Builder withDefaultEncoding(String defaultEncoding) {
            this.defaultEncoding = defaultEncoding;
            return this;
        }

        /**
         * Define the path to static file location (css,images,js, etc). Default: /public/
         *
         * @param staticFileLocation path to static file location.
         * @return Spark engine builder
         */
        public Builder withStaticFileLocation(String staticFileLocation) {
            this.staticFileLocation = staticFileLocation;
            return this;
        }

        /**
         * Define the base path to find freemarker templates. Default: /public/templates
         *
         * @param templateLocation path to templates
         * @return Spark engine builder
         */
        public Builder withTemplateLocation(String templateLocation) {
            this.templateLocation = templateLocation;
            return this;
        }

        /**
         * Define the base pakage to process annotated classes, ex: "org.hibernate". Default: br.com
         *
         * @param basePackage base package
         * @return Spark engine builder
         */
        public Builder withBasePackage(String basePackage) {
            this.basePackage = basePackage;
            return this;
        }

        public SparkEngine build() {
            return new SparkEngine(port, defaultEncoding, staticFileLocation, templateLocation, basePackage);
        }
    }

}
