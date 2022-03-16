package com.kodilla.controller;

import com.kodilla.dto.CreatedTrelloCard;
import com.kodilla.dto.TrelloBoardDto;
import com.kodilla.dto.TrelloCardDto;
import com.kodilla.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class TrelloController {

    private final TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "/trello")
    public void getTrelloBoards() {
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
        trelloBoards
                .stream().filter(trelloBoardDto -> trelloBoardDto.getName().equals("Service"))
                .forEach(trelloBoardDto -> {
                    System.out.println(trelloBoardDto.getId() + " - " + trelloBoardDto.getName());
                    System.out.println("This board contains lists: ");
                    trelloBoardDto.getLists().forEach(trelloList -> {
                        System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed());
                    });
                });
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trello")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }
}
