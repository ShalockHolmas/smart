package felixgu.start.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置允许跨域的url
 */
@Configuration
public class CorsConfiguraton {

    //@Bean
    //public WebMvcConfigurer corsConfigurer() {
    //    return new WebMvcConfigurer() {
    //        @Override
    //        public void addCorsMappings(CorsRegistry registry) {
    //            registry.addMapping("/api/**");
    //        }
    //    };
    //}
}
