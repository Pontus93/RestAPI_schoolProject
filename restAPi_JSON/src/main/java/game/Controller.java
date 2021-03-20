package game;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

//CHECKING SCOREBOARD: http://localhost:8080/scoreboard
//PLAY THE GAME 
//localhost:8080/game?weapen=rock
//localhost:8080/game?weapen=paper
//localhost:8080/game?weapen=scissor

@RestController
public class Controller {
	// Check the status of the game.
	@RequestMapping(value = "/scoreboard", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getScoreBean() { 	
		String result = "{ \"PLAYER WON\":\"%s\", \"COMPUTER WON\":\"%s\", \"TIES\": \"%s\"}";
		
		return String.format(result, PointSystem.win, PointSystem.lose, PointSystem.tie);
	}
}