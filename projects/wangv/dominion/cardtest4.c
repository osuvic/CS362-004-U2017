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
  int expNumActions;
  int expNumBuys;

  struct gameState G;

  initializeGame(2, k, 1, &G);//Initialize game with 2 players

  printf("TESTING Card Village:\n");

  currentPlayer = whoseTurn(&G);

  expHandCount = 5;
  expNumActions = 1;
  expNumBuys = 1;

  assertFunc(G.handCount[currentPlayer], expHandCount);
  printf("Actual handcount = %d, expected = %d\n", G.handCount[currentPlayer], expHandCount);

  assertFunc(G.numActions, expNumActions);
  printf("Actual numActions = %d, expected = %d\n", G.numActions, expNumActions);

  assertFunc(G.numBuys, expNumBuys);
  printf("Actual numBuys = %d, expected = %d\n", G.numBuys, expNumBuys);

  cardEffectVillage(currentPlayer, &G, 0);
  printf("Playing Village card...\n");

  expHandCount = 5;
  expNumActions = 2;
  expNumBuys = 1;

  assertFunc(G.handCount[currentPlayer], expHandCount);
  printf("Actual handcount = %d, expected = %d\n", G.handCount[currentPlayer], expHandCount);

  assertFunc(G.numActions, expNumActions);
  printf("Actual numActions = %d, expected = %d\n", G.numActions, expNumActions);

  assertFunc(G.numBuys, expNumBuys);
  printf("Actual numBuys = %d, expected = %d\n", G.numBuys, expNumBuys);

  return 0;
}
