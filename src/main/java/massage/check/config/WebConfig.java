package massage.check.config;

import lombok.RequiredArgsConstructor;
import massage.check.config.auth.CustomUserDetails;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebConfig implements WebMvcConfigurer {

    private final CustomUserDetails customUserDetails;

}
