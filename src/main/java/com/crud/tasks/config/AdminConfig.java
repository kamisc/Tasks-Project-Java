package com.crud.tasks.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Author Kamil Seweryn
 */

@Component
@Getter
public class AdminConfig {
    @Value("${admin.mail}")
    private String adminMail;

    @Value("${admin.name}")
    private String adminName;

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.company.name}")
    private String companyName;

    @Value("${info.company.phone}")
    private String companyPhone;
}