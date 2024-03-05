package es.neesis.annotations;

import es.neesis.annotations.applications.ConstructorApplication;
import es.neesis.annotations.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConstructorApplication constructorApplication = context.getBean(ConstructorApplication.class);
        constructorApplication.menu();

    }
}
