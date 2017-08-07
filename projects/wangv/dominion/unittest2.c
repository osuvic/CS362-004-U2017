#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

int main(){

  int actual;
  int expected;

  printf("TESTING getCost():\n");

  //Test Duchy
  expected = 5;  //cost of Duchy
  actual = (getCost(duchy));

  printf("Actual cost = %d, expected = %d\n", actual, expected);
  assert(expected == actual);

  //Test Province
  expected = 8;
  actual = (getCost(province));

  printf("Actual cost = %d, expected = %d\n", actual, expected);
  assert(expected == actual);

  //Test Copper
  expected = 0;
  actual = (getCost(copper));

  printf("Actual cost = %d, expected = %d\n", actual, expected);
  assert(expected == actual);

  //Test Gold
  expected = 6;
  actual = (getCost(gold));

  printf("Actual cost = %d, expected = %d\n", actual, expected);
  assert(expected == actual);

  //Test feast
  expected = 4;
  actual = (getCost(feast));

  printf("Actual cost = %d, expected = %d\n", actual, expected);
  assert(expected == actual);

  //Test Smithy
  expected = 4;
  actual = (getCost(smithy));

  printf("Actual cost = %d, expected = %d\n", actual, expected);
  assert(expected == actual);

  //Village
  expected = 3;
  actual = (getCost(village));

  printf("Actual cost = %d, expected = %d\n", actual, expected);
  assert(expected == actual);

  //Test Ambassador
  expected = 3;
  actual = (getCost(ambassador));

  printf("Actual cost = %d, expected = %d\n", actual, expected);
  assert(expected == actual);

  //Test Outpost
  expected = 5;
  actual = (getCost(outpost));

  printf("Actual cost = %d, expected = %d\n", actual, expected);
  assert(expected == actual);

  //Test Treasure Map
  expected = 4;
  actual = (getCost(treasure_map));

  printf("Actual cost = %d, expected = %d\n", actual, expected);
  assert(expected == actual);


  printf("All tests passed!\n");

  return 0;
}
