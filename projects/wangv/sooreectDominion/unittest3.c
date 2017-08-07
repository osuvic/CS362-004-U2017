#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

int main(){

  int i;

  int k[10] = {adventurer, council_room, feast, gardens, mine,
	       remodel, smithy, village, baron, great_hall};

  int currentPlayer;

  struct gameState G;

  initializeGame(2, k, 1, &G);//Initialize game with 2 players

  printf("TESTING whoseTurn(): 2 Players\n");
  for (i = 0; i < 12; i++){
    currentPlayer = whoseTurn(&G);
    printf("Whose turn is now player %d\n", G.whoseTurn);

    if (currentPlayer < (G.numPlayers - 1)){
      currentPlayer = currentPlayer + 1;//Still safe to increment
    }
    else{
      currentPlayer = 0;//Max player has been reached, loop back around to player 1
    }

    endTurn(&G);
    assert(G.whoseTurn == currentPlayer);
  }

  printf("All tests passed!\n\n");


  initializeGame(3, k, 1, &G);//Initialize game with 3 players

  printf("TESTING whoseTurn(): 3 Players\n");
  for (i = 0; i < 12; i++){
    currentPlayer = whoseTurn(&G);
    printf("Whose turn is now player %d\n", G.whoseTurn);

    if (currentPlayer < (G.numPlayers - 1)){
      currentPlayer = currentPlayer + 1;//Still safe to increment
    }
    else{
      currentPlayer = 0;//Max player has been reached, loop back around to player 1
    }

    endTurn(&G);
    assert(G.whoseTurn == currentPlayer);
  }
  printf("All tests passed!\n\n");


  initializeGame(4, k, 1, &G);//Initialize game with 4 players

  printf("TESTING whoseTurn(): 4 Players\n");
  for (i = 0; i < 12; i++){
    currentPlayer = whoseTurn(&G);
    printf("Whose turn is now player %d\n", G.whoseTurn);

    if (currentPlayer < (G.numPlayers - 1)){
      currentPlayer = currentPlayer + 1;//Still safe to increment
    }
    else{
      currentPlayer = 0;//Max player has been reached, loop back around to player 1
    }

    endTurn(&G);
    assert(G.whoseTurn == currentPlayer);
  }
  printf("All tests passed!\n");

  return 0;
}
