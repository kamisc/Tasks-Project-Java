package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author Kamil Seweryn
 */

@Getter
@AllArgsConstructor
public class Mail {
    private String mailTo;
    private String toCc;
    private String subject;
    private String message;
}
