package spittr.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import spittr.service.SpittrService;
import spittr.service.impl.SpittrServiceImpl;

@Configuration
@Import({SpringjdbcConfig.class,WebSocketConfig.class})
//,"spittr.dao"
@ComponentScan(basePackages = {"spittr.service"})
public class SpringConfig {

}
