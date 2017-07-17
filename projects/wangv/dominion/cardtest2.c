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

  struct gameState G;

  initializeGame(2, k, 1, &G);//Initialize game with 2 players

  printf("TESTING Card Smithy:\n");

  currentPlayer = whoseTurn(&G);

  expHandCount = 5;

  assertFunc(G.handCount[currentPlayer], expHandCount);
  printf("Actual handcount = %d, expected = %d\n", G.handCount[currentPlayer], expHandCount);

  cardEffectSmithy(currentPlayer, &G, 0);
  printf("Playing Smithy...\n");

  expHandCount = 7;

  assertFunc(G.handCount[currentPlayer], expHandCount);
  printf("Actual handcount = %d, expected = %d\n", G.handCount[currentPlayer], expHandCount);

  if (assertFunc(G.handCount[currentPlayer], expHandCount) == 0){
    printf("All tests passed!\n");
  }


  return 0;
}

