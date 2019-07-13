package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author Kamil Seweryn
 */

@Getter
@AllArgsConstructor
public class Task {
    private Long id;
    private String title;
    private String content;
}
