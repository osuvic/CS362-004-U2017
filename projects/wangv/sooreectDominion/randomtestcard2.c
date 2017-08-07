#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

int checkGreatHallCard(int p, struct gameState *post, int i)
{
  struct gameState pre;

  pre.handCount[p] = i;
  pre.numActions = i;

  printf("pre handcount = %d, post handcount = %d\n", pre.handCount[p],post->handCount[p]);
  printf("pre numActions = %d, post numActions = %d\n\n", pre.numActions, post->numActions);

  printf("Playing Great Hall Card...\n\n");
  greatHallCard(post, 0, p);

  printf("pre handcount = %d, post handcount = %d\n", pre.handCount[p],post->handCount[p]);
  printf("pre numActions = %d, post numActions = %d\n\n", pre.numActions, post->numActions);

  pre.handCount[p] = pre.handCount[p] + 1;
  pre.numActions = pre.numActions + 1;

  printf("Asserting handcount...\n\n");
  assertFunc(pre.handCount[p], post->handCount[p]);

  printf("Asserting numActions...\n\n");
  assertFunc(pre.numActions, post->numActions);
}

assertFunc(int actual, int expected)
{
  if (actual == expected){
    printf("Assert confirmed.\n");
    return 0;
  }
  else {
    printf("Error! Assert failed!\n");
    return -1;
  }
}

int main () {

  int n, p, handCount;

  int k[10] = {adventurer, council_room, feast, gardens, mine,
	       remodel, smithy, village, baron, great_hall};

  struct gameState G;

  initializeGame(2, k, 1, &G);

  printf ("Testing greatHallCard().\n");

  printf ("RANDOM TESTS.\n");

  for (n = -1; n < 9; n++) {
    G.handCount[p] = floor(Random() * n);
    G.numActions = floor(Random() * n);

    checkGreatHallCard(p, &G, n);
  }

  return 0;
}
