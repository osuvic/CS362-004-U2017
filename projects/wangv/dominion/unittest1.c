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

  int oldHandCount = 0;//expected handcount for player ending turn
  int numActions = 1;//expected number of actions for player starting new turn
  int numBuys = 1;
  int newHandCount = 5;

  struct gameState G;

  initializeGame(2, k, 1, &G);//Initialize game with 2 players

  printf("TESTING endTurn(): \n");

  currentPlayer = whoseTurn(&G);

  for(i = 0; i < 5; i++){
    endTurn(&G);
    printf("\nEnding turn...\n");

    assert(G.handCount[currentPlayer] == oldHandCount);
    printf("Player %d actual handCount = %d, expected = %d\n", currentPlayer, G.handCount[currentPlayer], oldHandCount);

    if (currentPlayer < (G.numPlayers - 1)){
        currentPlayer = currentPlayer + 1;//Still safe to increment
    }
    else{
        currentPlayer = 0;//Max player has been reached, loop back around to player 1
    }

    assert(whoseTurn(&G) == currentPlayer);
    printf("Whose turn is now player %d\n", whoseTurn(&G));

    assert(G.numActions == numActions);
    assert(G.numBuys == numBuys);

    printf("Player %d actual action = %d buy = %d, expected action = %d expected buy = %d\n",
            currentPlayer, G.numActions, G.numBuys, numActions, numBuys);

    assert(G.handCount[currentPlayer] == newHandCount);
    printf("Player %d actual handcount = %d, expected = %d\n", currentPlayer, G.handCount[currentPlayer], newHandCount);
  }
  printf("All tests passed!\n\n");

  return 0;
}
