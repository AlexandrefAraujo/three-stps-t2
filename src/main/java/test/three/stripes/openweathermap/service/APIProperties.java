package test.three.stripes.openweathermap.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;


@ComponentScan(basePackages = "test.three.stripes.openweathermap.service")
@PropertySource(value={"classpath:api.properties"})
@Service("API")

class APIProperties {

    @Value("${base.uri}")
    String baseUri;

    @Value("${base.path}")
    String basePath;

    @Value("${api.key}")
    String apiKey;


    APIProperties loadContext() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(APIProperties.class);
        APIProperties properties = (APIProperties) context.getBean("API");
        context.close();
        return properties;
    }

}
