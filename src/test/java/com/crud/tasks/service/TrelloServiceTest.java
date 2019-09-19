package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.trello.CreatedTrelloCardDto;
import com.crud.tasks.domain.trello.dto.*;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Author Kamil Seweryn
 */

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService emailService;

    @Test
    public void testFetchTrelloBoards() {
        // Given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        List<TrelloListDto> trelloListDtos = new ArrayList<>();

        trelloListDtos.add(new TrelloListDto("1", "List", false));
        trelloBoardDtos.add(new TrelloBoardDto("1", "Board", trelloListDtos));

        when(trelloService.fetchTrelloBoards()).thenReturn(trelloBoardDtos);

        // When
        List<TrelloBoardDto> trelloBoardDtos1 = trelloService.fetchTrelloBoards();

        // Then
        Assert.assertEquals(1, trelloBoardDtos1.size());
    }

    @Test
    public void testCreateTrelloCard() {
        // Given
        TrelloTrelloDto trelloTrelloDto = new TrelloTrelloDto(1, 2);
        TrelloAttachmentByTypeDto trelloAttachmentByTypeDto = new TrelloAttachmentByTypeDto(trelloTrelloDto);
        TrelloBadgesDto trelloBadgesDto = new TrelloBadgesDto(5, trelloAttachmentByTypeDto);
        TrelloCardDto trelloCardDto = new TrelloCardDto("Card", "TestCardDescription", "TestPos", "1");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "Card", "URL", trelloBadgesDto);

        when(trelloService.createTrelloCard(trelloCardDto)).thenReturn(createdTrelloCardDto);

        // When
        CreatedTrelloCardDto createdTrelloCard = trelloService.createTrelloCard(trelloCardDto);

        // Then
        Assert.assertEquals("1", createdTrelloCard.getId());
        Assert.assertEquals("Card", createdTrelloCard.getName());
        Assert.assertEquals("URL", createdTrelloCard.getShortUrl());
    }
}