/*
  @author   rakel
  @project   work
  @class  AuditorAwareImpl
  @version  1.0.0 
  @since 08.04.2025 - 18.15
*/
package org.example.work.config;/*
  @author   rakel
  @project   work
  @class  AuditorAwareImpl
  @version  1.0.0 
  @since 08.04.2025 - 18.15
*/

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(System.getProperty("user.name"));
    }
}
