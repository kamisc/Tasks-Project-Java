package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author Kamil Seweryn
 */

@AllArgsConstructor
@Getter
public class TrelloCard {
    private String name;
    private String description;
    private String pos;
    private String listId;
}
