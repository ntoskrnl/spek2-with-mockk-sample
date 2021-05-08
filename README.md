# spek2-with-mockk-sample
Sample project that demonstrates issue during Spek2 execution from Android Studio if MockK library is used.

There are 3 test classes in  the project: `ExampleJUnit4Test`, `ExampleJUnit5Test` and `ExampleSpekTest`.
Each of them contain 2 tests – with and without mockk.

When tests are run from command line, everything is ok. 
However there is some weird behavior the tests are run tests from Android Studio.

**Prerequisites**
1. Android studio 4.2 (but the issue will also reproduced on previous versions)
2. Installed Spek Framework IDE plugin (2.0.16-IJ2020.2)

**Scenario 1:**
1. Right-click on `ExampleSpekTest`
2. Click `Run 'Spek: com.example.sp...'` in the popup menu.

Expected: test runs ExampleSpekTest and passes

Actual: 1 test crashes with exception: java.lang.NoClassDefFoundError: io/mockk/proxy/MockKAgentFactory

**Scenario 2:**
1. Right-click on `ExampleJUnit5Test`
2. Click `Run 'ExampleJUnit5Test'` in the popup menu.

Expected: Test runs ExampleJUnit5Test and passes

Actual: Both tests ExampleJUnit5Test and ExampleSpekTest run and both pass

**Scenario 3:**
1. Right click on package `com.example.spek_mockk` or default package (test/java directory).

Expected: I should be able to run all tests in package

Actual: The option to run all tests is replaced with `Run 'Speks in ...'` and it will only run Spek tests. 
If the package doesn't have spek tests, the spek engine will crash.

This issues is reported here: https://github.com/spekframework/spek/issues/837