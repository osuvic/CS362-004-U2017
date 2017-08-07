#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

int assertFunc(int actual, int expected)
{
  if (actual == expected){
    //printf("Assert confirmed.\n");
    return 0;
  }
  else {
    printf("Error! Assert failed!\n");
    return -1;
  }

}

int main(){

  int i;

  int k[10] = {adventurer, council_room, feast, gardens, mine,
	       remodel, smithy, village, baron, great_hall};

  int currentPlayer;
  int expHandCount;

  int temphand[MAX_HAND];
  int drawntreasure = 0;
  int cardDrawn = 0;

  struct gameState G;

  initializeGame(2, k, 1, &G);//Initialize game with 2 players

  printf("TESTING Card Adventurer:\n");

  currentPlayer = whoseTurn(&G);
  expHandCount = 5;

  printf("Actual handcount = %d, expected = %d\n", G.handCount[currentPlayer], expHandCount);

  adventurerCard(&G, currentPlayer, temphand, drawntreasure, cardDrawn, MAX_HAND);
  printf("Playing Adventurer...\n");

  expHandCount = 7;
  printf("Actual handcount = %d, expected = %d\n", G.handCount[currentPlayer], expHandCount);

  if (assertFunc(G.handCount[currentPlayer], expHandCount) == 0){
    printf("All tests passed!\n");
  }

  return 0;
}
