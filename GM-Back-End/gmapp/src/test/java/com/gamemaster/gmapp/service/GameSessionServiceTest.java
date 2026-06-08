package com.gamemaster.gmapp.service;

import com.gamemaster.gmapp.model.GameSession;
import com.gamemaster.gmapp.repository.GameSessionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameSessionServiceTest {

    @Mock
    private GameSessionRepository gameSessionRepository;

    @Mock
    private GameSaveService gameSaveService;

    @InjectMocks
    private GameSessionService gameSessionService;

    @Test
    public void testGeneratedGameSessionCodesIsEightCharacters() {
        //Tell mock repo to always return empty Optional, which is what happens when no pre-existing game session exists for a given session code.
        when(gameSessionRepository.findBySessionCode(anyString())).thenReturn(Optional.empty());

        //Call createGameSession
        GameSession testSession = new GameSession();
        testSession.setName("Test Session");
        testSession.setStatus("active");

        //Tell it to always respond with the session code, which is returned by a createGameSession call where the repository saves the session at the end
        when(gameSessionRepository.save(any(GameSession.class))).thenAnswer(invocation -> invocation.getArgument(0));

        GameSession result = gameSessionService.createGameSession(testSession);

        // Verify the session code is 8 characters
        assertNotNull(result.getSessionCode());
        assertEquals(8, result.getSessionCode().length());
    }

    @Test public void testGenerateGameSessionCodeConsistentlyUnique() {
        HashSet<String> codesGenerated = new HashSet<String>();
        int duplicatesEncountered = 0;

        //generate a code, and then add it to the HashSet, then repeat, and check that each is unique. Do this until the
        //hashset has a length of 20, and log the number of duplicate codes encountered. If we get 3 dupes, exit and fail
        codesGenerated.add(gameSessionService.generateGameSessionCode());
        while(codesGenerated.size() < 20 && duplicatesEncountered < 3)
        {
            if(!codesGenerated.add(gameSessionService.generateGameSessionCode()))
            {
                ++duplicatesEncountered;
            }
        }

        System.out.println(codesGenerated);
        //Assert that hashset isn't null (shouldn't be possible), has 20 codes (hashset is inherently unique), and there were no more than 3 dupes.
        assertNotNull(codesGenerated);
        assertTrue(duplicatesEncountered < 3); //Technically don't need this, but here for learning :)
        assertEquals(20, codesGenerated.size());
    }

}
