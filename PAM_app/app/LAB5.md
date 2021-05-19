# Laboratory Work Nr.5
## Task:
* Cover at least 3 Business Logic Modules with Unit Tests. Use only build in platform frameworks for tests. 
For iOS it is XCTest, for Android it is JUnit.Unit tests are tests which check if some specific class 
behaves in the right way. Please don't test UI or Network Requests with unit tests. Don't use concrete 
implementation of classes which are injected to your tested module, Use mocks and stubs in order to 
fake behavior of injected modules. Unit tests should be written and run isolated, this means that 
you must not to have Network Requests in your Unit Tests, Mock your API service and inject it inside 
your business logic module at start of test if you need it inside tested module.
* Select and add at least one test of next categories:
** Integration tests - Tests which check integration of several modules of your app or platform. 
In context of mobile app these can be tests where you perform network requests to real or mocked API 
and check app API layer behavior, these test can include testing of serialization and deserialization, 
check of requests components, check of returned API response.
** UI tests (a.k.a Automation Tests) - Tests which perform real user action of interaction with UI 
elements in automated way. Actually it is a code which press buttons and interact with your app
** Snapshot tests - Tests which perform screenshot of your app and compare it with previously recorded 
reference image. These tests check if you don't break your UI accidentally during development. 
For this type of test you will need some third party frameworks, just google it, there are a lot of 
examples on github.  

## What I did:
Firstly, I created unit tests for different classes that contain business logic and mainly for login
part of my application. Unit tests are located in  app/src/test package. So here I have tests for LoginValidator
class. Here, I verify if the validation part of the phone number and password work properly. For example,
the following test verify that login isn't accepted, because the phone field is empty and empty field is invalid:
```
@Test
    fun `empty phone field is invalid`() {
        //when
        val result = objectUnderTest.validatePhone("")
        //then
        assertThat(result).isFalse()
    }
```
Also, I have test for LoginPresenter where I test if login part work correctly with different types of
inputs. Following is the test that login a user with correct credentials:
```
@Test
    fun `login with correct data`() {
        //given
        given(loginRepositoryStub.login(anyString(), anyString())).willReturn(Observable.just(true))
        //when
        objectUnderTest.attemptLogin(LoginCredentials(phone = "068188035", password = "password"))
        //then
        verify(loginViewMock).onLoginSuccessful()
    }
``` 
Second type of test that I used is UI test located in app/src/androidTest folder. Here, I have FoodRecyclerViewUITest
where I verify if the recycler view for displaying food and drinks work properly. For example, I have 2 tests
one for visibility of the recycler view and another to test the scroll property.