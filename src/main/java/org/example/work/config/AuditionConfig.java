/*
  @author   rakel
  @project   work
  @class  AuditionConfig
  @version  1.0.0 
  @since 08.04.2025 - 18.16
*/
package org.example.work.config;/*
  @author   rakel
  @project   work
  @class  AuditionConfig
  @version  1.0.0 
  @since 08.04.2025 - 18.16
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@Configuration
public class AuditionConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

}
