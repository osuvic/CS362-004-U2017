/* 
 * Tida Sooreechine & Victor Wang
 * CS362 Final Project Part B
 * 8/17/2017
 * 
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import junit.framework.TestCase;


/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		
		//System.out.println(urlVal.isValid("http://www.yahoo.com"));
	   System.out.println("MANUAL TESTING\n");
	   
	   System.out.println("/Testing Valid URLs.../\n");
	   
	   //Valid scheme and authority
	   System.out.println("Testing Valid scheme and authority...");
	   System.out.println("http://www.yahoo.com");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("http://www.yahoo.com")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
		
	   //Valid scheme, authority, and path
	   System.out.println("Testing Valid scheme, authority and path...");
	   System.out.println("http://www.espn.com/nfl");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("http://www.espn.com/nfl")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   //Valid scheme, authority, path, and port
	   System.out.println("Testing Valid scheme, authority, path, and port...");
	   System.out.println("http://www.espn.com:80/nfl");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("http://www.espn.com:80/nfl")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   //Valid scheme, authority, path, port, and query
	   System.out.println("Testing Valid scheme, authority, path, port, and query...");
	   System.out.println("https://www.espn.com:80/nfl?key=value");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("https://www.espn.com:80/nfl?key=value")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   //Testing Invalid URLS
	   System.out.println("/Testing Invalid URLs.../\n");
	   
	   //Invalid scheme
	   System.out.println("Testing Invalid scheme...");
	   System.out.println("htt://www.wikipedia.com");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("htt://www.wikipedia.com")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   //Invalid authority
	   System.out.println("Testing Invalid authority...");
	   System.out.println("http://ww.wikipedia.com");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("http://ww.wikipedia.com")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   //Invalid path
	   System.out.println("Testing Invalid path...");
	   System.out.println("http://www.reddit.com/<new>");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("http://www.reddit.com/<new>")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   //Invalid port
	   System.out.println("Testing Invalid port...");
	   System.out.println("http://www.reddit.com:65536");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("http://www.reddit.com/new:65536")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   //Invalid query
	   System.out.println("Testing Invalid query...");
	   System.out.println("http://www.reddit.com?<key=value>");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("http://www.reddit.com?<key=value>")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   //Invalid scheme, authority, path, port, and query
	   System.out.println("Testing Invalid scheme, authority, path, port, and query...");
	   System.out.println("htt://ww.reddit.com:65536/<path>?<key=value>");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("htt://ww.reddit.com:65536/<path>?<key=value>")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	  
	   //Testing Other URLS
	   System.out.println("/Testing Other Test Cases.../\n");
	   
	   System.out.println("http://200.90.101.22");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("http://200.90.101.22")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://256.256.256.256");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("http://256.256.256.256")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://2147483648.2147483648.2147483648.2147483648");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("http://2147483648.2147483648.2147483648.2147483648")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://-1.-1.-1.-1");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("http://-1.-1.-1.-1")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://www.abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz.com");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("http://www.abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz.com")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://www.yahoo.com:-1");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("http://www.yahoo.com:-1")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://www.yahoo.com:9");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("http://www.yahoo.com:9")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://www.yahoo.com:99");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("http://www.yahoo.com:99")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://www.yahoo.com:999");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("http://www.yahoo.com:999")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://www.yahoo.com:9999");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("http://www.yahoo.com:9999")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://www.yahoo.com:1000");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("http://www.yahoo.com:1000")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://www.yahoo.com:65535");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("http://www.yahoo.com:65535")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://www.yahoo.com:65536");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("http://www.yahoo.com:65536")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://google.com");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("http://google.com")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://google.co.th");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("http://google.co.th")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://google.co.jp");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("http://google.co.jp")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("http://google.org");
	   System.out.println("Expected: PASS");
	   if (urlVal.isValid("http://google.org")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("h99p://www.google.com");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("h99p://www.google.com")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("99p://www.google.com");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("99p://www.google.com")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("9999://www.google.com");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("9999://www.google.com")){
		   System.out.println("Actual: FAIL\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("h99*://www.google.com");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("h99*://www.google.com")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }
	   
	   System.out.println("#99p://www.google.com");
	   System.out.println("Expected: FAIL");
	   if (urlVal.isValid("#99p://www.google.com")){
		   System.out.println("Actual: PASS\n");
	   }
	   else {
		   System.out.println("Actual: FAIL\n");
	   }   
   }
 
   public void testYourFirstPartition()
   {
	   System.out.println("Partition 1 = valid scheme ");
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	  
	   System.out.print("1a) http://www.google.com | Expected: Pass, ");
	   if (urlVal.isValid("http://www.google.com")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("1b) www.google.com | Expected: Pass, ");
	   if (urlVal.isValid("www.google.com")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.println("\n");   
   }
   
   public void testYourSecondPartition(){
	   System.out.println("Partition 2 = invalid scheme ");
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	  
	   System.out.print("2) httk//www.google.com | Expected: Fail, ");
	   if (urlVal.isValid("httk//www.google.com")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.println("\n");   
   }
   
   public void testYourThirdPartition(){
	   System.out.println("Partition 3 = valid authority ");
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	  
	   System.out.print("3a) http://google.com | Expected: Pass, ");
	   if (urlVal.isValid("http://google.com")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("3b) uk.yahoo.com | Expected: Pass, ");
	   if (urlVal.isValid("uk.yahoo.com")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("3c) 0.0.0.0 | Expected: Pass, ");
	   if (urlVal.isValid("http://0.0.0.0")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.println("\n");   
   }
   
   public void testYourFourthPartition(){
	   System.out.println("Partition 4 = invalid authority ");
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	  
	   System.out.print("4a) http://dd##>>??.com | Expected: Fail, ");
	   if (urlVal.isValid("http://dd##>>??.com")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("4b) -999.-999.-999.-999 | Expected: Fail, ");
	   if (urlVal.isValid("-999.-999.-999.-999")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("4c) http://:80/test | Expected: Fail, ");
	   if (urlVal.isValid("http://:80/test")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.println("\n");   
   }
   
   public void testYourFifthPartition(){
	   System.out.println("Partition 5 = valid port ");
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	  
	   System.out.print("5a) http://www.google.com:80 | Expected: Pass, ");
	   if (urlVal.isValid("http://www.google.com:80")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("5b) http://www.gmail.com:0 | Expected: Pass, ");
	   if (urlVal.isValid("http://www.gmail.com:0")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("5c) 0.0.0.0:65535 | Expected: Pass, ");
	   if (urlVal.isValid("http://www.google.com:65535")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("5d) http://www.ebay.com/test | Expected: Pass, ");
	   if (urlVal.isValid("http://www.ebay.com/test")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.println("\n");   
   }

   public void testYourSixthPartition(){
	   System.out.println("Partition 6 = invalid port ");
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	  
	   System.out.print("6a) http://www.google.com:1234567 | Expected: Fail, ");
	   if (urlVal.isValid("http://www.google.com:1234567")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("6b) http://www.google.com:-123 | Expected: Fail, ");
	   if (urlVal.isValid("http://www.google.com:-123")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("6c) http://www.google.com:xyz | Expected: Fail, ");
	   if (urlVal.isValid("http://www.google.com:xyz")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.println("\n");   
   }
   
   
   public void testYourSeventhPartition(){
	   System.out.println("Partition 7 = valid path ");
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	  
	   System.out.print("7a) http://www.goodreads.com/search | Expected: Pass, ");
	   if (urlVal.isValid("http://www.goodreads.com/search")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("7b) http://www.goodreads.com:80 | Expected: Pass, ");
	   if (urlVal.isValid("http://www.goodreads.com:80")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.println("\n");   
   }
   
   
   public void testYourEightPartition(){
	   System.out.println("Partition 8 = invalid path ");
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	  
	   System.out.print("8a) http://www.google.com:90//yellow | Expected: Fail, ");
	   if (urlVal.isValid("http://www.google.com:90//yellow")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("8b) http://www.facebook.com\\path | Expected: Fail, ");
	   if (urlVal.isValid("http://www.facebook.com\\path")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.println("\n");   
   }
   
   
   public void testYourNinthPartition(){
	   System.out.println("Partition 9 = valid query ");
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	  
	   System.out.print("9a) http://wwww.abc.com?hello=world | Expected: Pass, ");
	   if (urlVal.isValid("http://wwww.abc.com?hello=world")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("9b) http://wwww.123.com?hello=World&yes=no | Expected: Pass, ");
	   if (urlVal.isValid("http://wwww.123.com?hello=World&yes=no")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("9c) http://wwww.xyz.com/helloWorld | Expected: Pass, ");
	   if (urlVal.isValid("http://wwww.xyz.com/helloWorld")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.println("\n");   
   }
   
   
   public void testYourTenthPartition(){
	   System.out.println("Partition 10 = invalid query ");
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	  
	   System.out.print("10a) http://www.pottermore=harry?potter | Expected: Fail, ");
	   if (urlVal.isValid("http://www.pottermore=harry?potter")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.print("10b) http://www.pottermore?harry^potter | Expected: Fail, ");
	   if (urlVal.isValid("http://www.pottermore=?harry^potter")) 
		   System.out.print("Actual: Pass\n");
	   else
		   System.out.print("Actual: Fail\n");
	   
	   System.out.println("\n");   
   }
   
   public void testIsValid() {
	   testIsValid(testUrlParts);
   }
   
   public void testIsValid(Object[] testObjects)
   {
	   int z = 0;
	   int tests = 0;
	   int successes = 0;
	   boolean urlIsValid = true;
	   boolean actual = true;
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   for (int a = 0; a < testUrlScheme.length; a++) {
		   for (int b = 0; b < testUrlAuthority.length; b++) {
			   for (int c = 0; c < testUrlPort.length; c++) {
				   for (int d = 0; d < testUrlPath.length; d++) {
					   for (int e = 0; e < testUrlQuery.length; e++) {
						   
						   z = 0;
						   urlIsValid = true;
						   StringBuffer testUrl = new StringBuffer();
						   
						   //add scheme to URL string
						   ResultPair[] newScheme = (ResultPair[]) testObjects[z];
						   testUrl.append(newScheme[a].item);
						   if (!newScheme[a].valid)
							   urlIsValid = false;
						   z++;
						   
						   //add authority to URL string
						   ResultPair[] newAuthority = (ResultPair[]) testObjects[z];
						   testUrl.append(newAuthority[b].item);
						   if (!newAuthority[b].valid)
							   urlIsValid = false;
						   z++;
						   
						   //add port to URL string
						   ResultPair[] newPort = (ResultPair[]) testObjects[z];
						   testUrl.append(newPort[c].item);
						   if (!newPort[c].valid)
							   urlIsValid = false;
						   z++;
						   
						   //add path to URL string
						   ResultPair[] newPath = (ResultPair[]) testObjects[z];
						   testUrl.append(newPath[d].item);
						   if (!newPath[d].valid)
							   urlIsValid = false;
						   z++;
						   
						   //add query to URL string
						   ResultPair[] newQuery = (ResultPair[]) testObjects[z];
						   testUrl.append(newQuery[e].item);
						   if (!newQuery[e].valid)
							   urlIsValid = false;
						   z++;
						   tests++;
						   
						   //print results
						   System.out.print(tests + ".\n" + testUrl + "\n");
						   
						   System.out.print("Expected: ");
						   if (urlIsValid)
							   System.out.print("Valid\n");
						   else 
							   System.out.print("Invalid\n");
						   
						   System.out.print("Actual: ");
						   String testUrlString = testUrl.toString();
						   if (urlVal.isValid(testUrlString)) {
							   actual = true;
							   System.out.print("Valid\n");
						   }
						   else {
							   actual = false;
							   System.out.print("Invalid\n");
						   }
						   
						   if (urlIsValid == actual) {
							   System.out.print("PASS!\n\n");
							   successes++;
						   }
						   else
							   System.out.print("FAIL!\n\n");
					   }
				   }
			   }
		   }   
	   }
	   int percent = (int)((successes * 100.0f) / tests);
	   System.out.print("Total successful tests: " + successes + " of " + tests);
	   System.out.print(" (" + percent + "%)");
   }
   
   public void testAnyOtherUnitTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   int idxSch, idxAuth, idxPort, idxPath, idxQuery;
	   int counter = 0;
	   
	   for (idxSch = 0; idxSch < 6; idxSch++) {
		   for (idxAuth = 0; idxAuth < 6; idxAuth++) {
			   for (idxPort = 0; idxPort < 6; idxPort++) {
				   for (idxPath = 0; idxPath < 6; idxPath++) {
					   for (idxQuery = 0; idxQuery < 6; idxQuery++) {
						   
						   //Call to build URL
						   ResultPair testUrl = new ResultPair("", true); 
						   testUrl = buildUrl(idxSch,idxAuth,idxPort,idxPath,idxQuery);
						   //System.out.println(buildUrl(0,0,0,0,0));
						   System.out.print(counter);
						   System.out.println(". Testing validity of URL:");
						   System.out.println(testUrl.item);
						   System.out.print("Expected: ");
						   if (testUrl.valid) {
							   System.out.print("Pass\n");
						   } else {
							   System.out.print("Fail\n");
						   }
						   
						   //System.out.println(testUrl.valid);
						   System.out.print("Actual: ");
						   if (urlVal.isValid(testUrl.item)) {
							   System.out.println("Pass\n");
						   } else {
							   System.out.println("Fail\n");
						   }
						   counter++;
					   }
				   }
			   }	
		   }
	   }
   }
   
   public ResultPair buildUrl(int idxSch, int idxAuth, int idxPort, int idxPath, int idxQuery)
   {
	   ResultPair[] testUrlScheme = {new ResultPair("http://", true),
			   						 new ResultPair("https://", true),
								     new ResultPair("", true),
								     new ResultPair("htp:/", false),
								     new ResultPair("htpp:::", false),
								     new ResultPair("xyz@#//", false)
	   };

	   ResultPair[] testUrlAuthority = {new ResultPair("www.google.co.jp", true),
									    new ResultPair("yahoo.com", true),
									    new ResultPair("234.234.234.234", true),
									    new ResultPair("yahoo", false),
									    new ResultPair("222.444.666.888", false),
									    new ResultPair("", false)
	   };

	   ResultPair[] testUrlPort = {new ResultPair(":100", true),
                                   new ResultPair(":1000", true),
                                   new ResultPair(":0", true),
                                   new ResultPair("", true),
                                   new ResultPair(":-1", false),
                                   new ResultPair(":98989", true),
                                   new ResultPair(":xyz1", false)
	   };

	   ResultPair[] testUrlPath = {new ResultPair("/home", true),
	                               new ResultPair("/p90x", true),
	                               new ResultPair("/*45", true),
	                               new ResultPair("", true),
	                               new ResultPair("/...//", false),
	                               new ResultPair("/../", false),
	                               new ResultPair("/..///home", false),
	   };

	   ResultPair[] testUrlQuery = {new ResultPair("?request=open", true),
	                                new ResultPair("?request=get", true),
	                                new ResultPair("", true),
	                                new ResultPair("?>>edit", false),
	                                new ResultPair("?>", false),
	                                new ResultPair("?>>>=", false)
	   };
	   
		
		ResultPair completeUrl = new ResultPair("", true);
	   
		completeUrl.item = testUrlScheme[idxSch].item + testUrlAuthority[idxAuth].item + testUrlPort[idxPort].item + testUrlPath[idxPort].item + testUrlQuery[idxQuery].item;
			
		int flag = 0;
		
		if (!testUrlScheme[idxSch].valid) {
			flag++;
		}
		
		if (!testUrlAuthority[idxAuth].valid) {
			flag++;
		}
		
		if (!testUrlPort[idxPort].valid) {
			flag++;
		}
		
		if (!testUrlPath[idxPath].valid) {
			flag++;
		}
		
		if (!testUrlQuery[idxQuery].valid) {
			flag++;
		}
		
		if (flag > 0) {
			completeUrl.valid = false;
		}
		
		return completeUrl;      
   }

   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   ResultPair[] testUrlScheme = {new ResultPair("http://", true),
		   new ResultPair("ftp://", true),
		   new ResultPair("mailto://", true),
		   new ResultPair("", true),
		   new ResultPair("http:\\", false),
		   new ResultPair("htp::", false),
		   new ResultPair("xyz@@", false)
   };

   ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
		   new ResultPair("www.google.co.th", true),
		   new ResultPair("google.com", true),
		   new ResultPair("123.123.123", true),
		   new ResultPair("google", false),
		   new ResultPair("123.456.789", false),
		   new ResultPair("", false)
   };
   
   ResultPair[] testUrlPort = {new ResultPair(":90", true),
           new ResultPair(":65535", true),
           new ResultPair(":0", true),
           new ResultPair("", true),
           new ResultPair(":-1", false),
           new ResultPair(":65636", false),
           new ResultPair(":a123", false)
   };

   ResultPair[] testUrlPath = {new ResultPair("/path", true),
		   new ResultPair("/p789", true),
		   new ResultPair("/#56", true),
		   new ResultPair("", true),
		   new ResultPair("/../", false),
		   new ResultPair("/..//", false),
		   new ResultPair("/..//path", false),
   };

   ResultPair[] testUrlQuery = {new ResultPair("?search=hello+world", true),
		   new ResultPair("?request=valid", true),
		   new ResultPair("?request=open=file", true),
		   new ResultPair("", true),
		   new ResultPair("?>", false),
		   new ResultPair("?>request", false),
		   new ResultPair("?>=", false)
   };

   Object[] testUrlParts = {testUrlScheme, testUrlAuthority, testUrlPort, testUrlPath, testUrlQuery};
}
