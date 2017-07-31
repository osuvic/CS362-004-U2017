#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

int checkCardEffectAdventurer(int p, struct gameState *post, int i)
{
  struct gameState pre;
  int drawntreasure = i;
  int carddrawn = i;
  int temphand[MAX_HAND];
  int size = i;

  pre.handCount[p] = i;

  printf("Playing Adventurer Card...\n\n");
  cardEffectAdventurer(p, post, drawntreasure, carddrawn, temphand, size);

  printf("Asserting handCount...\n");
  assertFunc(pre.handCount[p], post->handCount[p]);
}

assertFunc(int actual, int expected)
{
  if (actual == expected){
    printf("Assert confirmed.\n\n");
    return 0;
  }
  else {
    printf("Error! Assert failed!\n\n");
    return -1;
  }
}

int main () {

  int n, p, handCount;

  int k[10] = {adventurer, council_room, feast, gardens, mine,
	       remodel, smithy, village, baron, great_hall};

  struct gameState G;

  initializeGame(2, k, 1, &G);

  printf ("Testing cardEffectAdventurer.\n");

  printf ("RANDOM TESTS.\n");

  for (n = -1; n < 9; n++) {
    G.handCount[p] = floor(Random() * n);
    checkCardEffectAdventurer(p, &G, n);
  }

  return 0;
}
