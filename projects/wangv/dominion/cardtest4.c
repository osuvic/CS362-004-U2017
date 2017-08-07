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

  int temphand[MAX_HAND];
  int currentPlayer;
  int expHandCount;
  int expDeckCount;

  struct gameState G;

  initializeGame(2, k, 1, &G);//Initialize game with 2 players

  printf("TESTING Card Feast:\n");

  currentPlayer = whoseTurn(&G);

  expHandCount = 5;
  expDeckCount = G.deckCount[currentPlayer];

  assertFunc(G.handCount[currentPlayer], expHandCount);
  printf("Actual handcount = %d, expected = %d\n", G.handCount[currentPlayer], expHandCount);

  assertFunc(G.deckCount[currentPlayer], expDeckCount);
  printf("Actual deckCount = %d, expected = %d\n", G.deckCount[currentPlayer], expDeckCount);

  //int feastCard(int choice1, struct gameState *state, int currentPlayer, int temphand[]) {
  feastCard(1, &G, currentPlayer, temphand);

  printf("Playing Feast card...\n");

  expHandCount = 5;

  assertFunc(G.handCount[currentPlayer], expHandCount);
  printf("Actual handcount = %d, expected = %d\n", G.handCount[currentPlayer], expHandCount);

  assertFunc(G.deckCount[currentPlayer], expDeckCount);
  printf("Actual deckCount = %d, expected = %d\n", G.deckCount[currentPlayer], expDeckCount);


  return 0;
}
