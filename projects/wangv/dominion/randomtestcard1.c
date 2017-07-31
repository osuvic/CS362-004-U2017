#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"


int checkCardEffectSmithy(int p, struct gameState *post, int i)
{
  struct gameState pre;

  pre.handCount[p] = i;

  printf("pre handcount = %d, post handcount = %d\n", pre.handCount[p],post->handCount[p]);

  printf("Playing Smithy Card...\n");
  cardEffectSmithy(p, post, 0);

  pre.handCount[p] = pre.handCount[p] + 2;

  assertFunc(pre.handCount[p], post->handCount[p]);

}

assertFunc(int actual, int expected)
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

int main () {

  int n, p, handCount;

  int k[10] = {adventurer, council_room, feast, gardens, mine,
	       remodel, smithy, village, baron, great_hall};

  struct gameState G;

  initializeGame(2, k, 1, &G);

  printf ("Testing cardEffectSmithy.\n");

  printf ("RANDOM TESTS.\n");

  for (n = -1; n < 9; n++) {
    G.handCount[p] = floor(Random() * n);
    checkCardEffectSmithy(p, &G, n);
  }

  return 0;
}
