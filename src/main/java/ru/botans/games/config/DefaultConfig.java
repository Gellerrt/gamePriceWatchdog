package ru.botans.games.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Data
@Slf4j
@Profile("dev")
@Component
@PropertySource("file:/resources/config/conf.properties")
public class DefaultConfig {

    @Value("${business.steam.url}")
    private String steamUrl;

    @Value("${business.steam.url}")
    private String description;

    @PostConstruct
    public void logInit() {
        log.info("Инициализировал конфиг!!!");
        log.info(this.toString());
    }

}
