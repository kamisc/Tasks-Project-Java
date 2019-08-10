package com.crud.tasks.controller;

import com.crud.tasks.domain.trello.CreatedTrelloCard;
import com.crud.tasks.domain.trello.dto.TrelloBoardDto;
import com.crud.tasks.domain.trello.dto.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author Kamil Seweryn
 */

@RestController
@RequestMapping("/v1/trello")
@CrossOrigin(origins = "*")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createNewCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }
}
