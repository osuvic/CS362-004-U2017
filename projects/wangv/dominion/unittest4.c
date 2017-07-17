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

  int tempCount;

  int actualCount;

  struct gameState G;

  initializeGame(2, k, 1, &G);//Initialize game with 2 players

  printf("TESTING supplyCount():\n");

  printf("Initial Count of Adventurer is %d\n", supplyCount(adventurer, &G));
  for (i = 0; i < 12; i++)
  {
    tempCount = supplyCount(adventurer, &G);

    gainCard(7, &G, 0, 0);
    actualCount = supplyCount(adventurer, &G);
    if(tempCount > 0){
      tempCount = tempCount - 1;
    }
    //int gainCard(int supplyPos, struct gameState *state, int toFlag, int player)

    assert(tempCount == actualCount);
    printf("Actual count = %d, expected count = %d\n", actualCount, tempCount);
  }

  printf("\nInitial Count of Province is %d\n", supplyCount(province, &G));
  for (i = 0; i < 10; i++)
  {
    tempCount = supplyCount(province, &G);

    gainCard(3, &G, 0, 0);
    actualCount = supplyCount(province, &G);
    if(tempCount > 0){
      tempCount = tempCount - 1;
    }

    assert(tempCount == actualCount);
    printf("Actual count = %d, expected count = %d\n", actualCount, tempCount);
  }


  return 0;

}

