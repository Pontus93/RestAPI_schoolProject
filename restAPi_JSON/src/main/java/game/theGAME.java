package game;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// CHECKING SCOREBOARD: http://localhost:8080/scoreboard
// PLAY THE GAME 
// localhost:8080/game?weapen=rock
// localhost:8080/game?weapen=paper
// localhost:8080/game?weapen=scissor

@RestController
	public class theGAME {
	@RequestMapping(value = "/game", method = { RequestMethod.POST, RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public String GamingAi(String weapen) {
	String Aichoose = computerAI.computerChoice(); 
	String result = "{ \"PLAYER WON\":\"%s\", \"COMPUTER WON\":\"%s\", \"TIES\": \"%s\"}";

	// Switch by Aichoice and nested switch with players choice.
	switch (Aichoose){
     case "rock": System.out.println("The computer chose Rock!"); 
     switch (weapen){
     case "rock": System.out.println("You chose Rock! It's a draw!"); PointSystem.tie++;   break;
     case "paper": System.out.println("You chose Paper! You win!"); PointSystem.win++;   break;
     case "scissor": System.out.println("You chose Scissors! You loose!"); PointSystem.lose++;   break;
     }
     break;
   
     case "paper": System.out.println("The computer chose Paper!"); 
     switch (weapen){
     case "rock": System.out.println("You chose rock, You loose!");PointSystem.lose++;  break;
     case "paper": System.out.println("You chose Paper! It's a draw!");PointSystem.tie++;   break;
     case "scissor": System.out.println("You chose Scissors! You win!");PointSystem.win++;   break;
     }
     break;
     case "scissor": System.out.println("The computer chose Scissors!");
     switch (weapen){
     case "rock": System.out.println("You chose Rock! You win!");PointSystem.win++;  break;
     case "paper": System.out.println("You chose Paper! You loose!"); PointSystem.lose++;  break;
     case "scissor": System.out.println("You chose Scissors! It's a draw");PointSystem.tie++;   break;
    }	
     break;
     }
	return String.format(result, PointSystem.win, PointSystem.lose, PointSystem.tie);

   }
}