# demo project for CDC Test with pact, SprintBoot

## Reporduce Steps

0. Import project with IDE
1. consumer test & generate pact file
   run method runTest()  in ConsumerTest.java under test folder,
   it will generate myConsumer-myProvider.json under target/pacts
2. provider test
   run method runTest() in ProviderTest.java under test folder,
   but it occurs: java.lang.Exception: No tests found matching Method runTest(demo_pact.ProviderTest) 
   
