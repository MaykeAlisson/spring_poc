package br.com.mayke.studyspring.config;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignClientConfiguration {

    @Value("${viacep-service.connect-timeout}")
    private Integer connectTimeout;

    @Value("${viacep-service.read-timeout}")
    private Integer readTimeout;

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient()
                .newBuilder()
                .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .build();
    }
}
