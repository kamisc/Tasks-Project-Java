package com.crud.tasks.trello.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Author Kamil Seweryn
 */

@Getter
@Component
public class TrelloConfig {

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;

    @Value("${trello.app.key}")
    private String trelloAppKey;

    @Value("${trello.app.token}")
    private String trelloAppToken;

    @Value("${trello.app.username}")
    private String trelloAppUsername;
}
