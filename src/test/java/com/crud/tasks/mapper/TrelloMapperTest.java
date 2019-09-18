package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.trello.dto.TrelloBoardDto;
import com.crud.tasks.domain.trello.dto.TrelloCardDto;
import com.crud.tasks.domain.trello.dto.TrelloListDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Kamil Seweryn
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    private List<TrelloBoard> trelloBoards;
    private List<TrelloBoardDto> trelloBoardsDto;

    private List<TrelloList> trelloLists;
    private List<TrelloListDto> trelloListsDto;

    private TrelloBoard trelloBoard1;
    private TrelloBoard trelloBoard2;

    private TrelloBoardDto trelloBoardDto1;
    private TrelloBoardDto trelloBoardDto2;

    private TrelloListDto trelloListDto1;
    private TrelloListDto trelloListDto2;

    private TrelloList trelloList1;
    private TrelloList trelloList2;

    private TrelloCard trelloCard;
    private TrelloCardDto trelloCardDto;

    @Before
    public void setUp() {
        trelloBoards = new ArrayList<>();
        trelloBoardsDto = new ArrayList<>();

        trelloLists = new ArrayList<>();
        trelloListsDto = new ArrayList<>();

        trelloBoard1 = new TrelloBoard("678", "TestBoard1", trelloLists);
        trelloBoard2 = new TrelloBoard("901", "TestBoard2", trelloLists);

        trelloBoardDto1 = new TrelloBoardDto("678", "TestBoard1", trelloListsDto);
        trelloBoardDto2 = new TrelloBoardDto("901", "TestBoard2", trelloListsDto);

        trelloList1 = new TrelloList("123", "TestList1", true);
        trelloList2 = new TrelloList("345", "TestList2", false);

        trelloListDto1 = new TrelloListDto("123", "TestList1", true);
        trelloListDto2 = new TrelloListDto("345", "TestList2", false);

        trelloCard = new TrelloCard("TestCard", "TestCardDescription", "TestPos", "123");
        trelloCardDto = new TrelloCardDto("TestCard", "TestCardDescription", "TestPos", "123");
    }

    @Test
    public void testMapToBoards() {
        // Given
        trelloListsDto.add(trelloListDto1);
        trelloListsDto.add(trelloListDto2);

        trelloBoardsDto.add(trelloBoardDto1);
        trelloBoardsDto.add(trelloBoardDto2);

        // When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        // Then
        Assert.assertEquals(2, trelloBoards.size());
    }

    @Test
    public void testMapToBoardsDto() {
        // Given
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);

        trelloBoards.add(trelloBoard1);
        trelloBoards.add(trelloBoard2);

        // When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);

        // Then
        Assert.assertEquals(2, trelloBoardsDto.size());
    }

    @Test
    public void testMapToList() {
        // Given
        trelloListsDto.add(trelloListDto1);
        trelloListsDto.add(trelloListDto2);

        // When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListsDto);

        // Then
        Assert.assertEquals(2, trelloLists.size());
    }

    @Test
    public void testMapToListDto() {
        // Given
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);

        // When
        List<TrelloListDto> trelloListsDto = trelloMapper.mapToListDto(trelloLists);

        // Then
        Assert.assertEquals(2, trelloListsDto.size());
    }

    @Test
    public void testMapToCard() {
        // Given

        // When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        // Then
        Assert.assertEquals("TestCard", trelloCardDto.getName());
        Assert.assertEquals("TestCardDescription", trelloCardDto.getDescription());
        Assert.assertEquals("TestPos", trelloCardDto.getPos());
        Assert.assertEquals("123", trelloCardDto.getListId());
    }

    @Test
    public void testMapToCardDto() {
        // Given

        // When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        // Then
        Assert.assertEquals("TestCard", trelloCard.getName());
        Assert.assertEquals("TestCardDescription", trelloCard.getDescription());
        Assert.assertEquals("TestPos", trelloCard.getPos());
        Assert.assertEquals("123", trelloCard.getListId());
    }
}