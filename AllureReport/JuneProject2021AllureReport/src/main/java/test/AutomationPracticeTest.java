package test;

import commonUtilities.DriverUtility;
import commonUtilities.ReadExcelFileUtility;

import elementRepository.APMainPage;
import elementRepository.APMyAccountCreationPage;
import elementRepository.APMyAccountPage;
import elementRepository.RegistrationPage;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import  org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class AutomationPracticeTest {

    APMainPage apMainPage;
    APMyAccountPage apMyAccountPage;
    APMyAccountCreationPage apMyAccountCreationPage;
    ReadExcelFileUtility readExcelFileUtility;
    RegistrationPage registrationPage;
    // BeforeClass and AfterClass annotation usage

    @BeforeSuite(alwaysRun = true)
    public void openBrowser() {
        DriverUtility.getDriver();
        readExcelFileUtility = new ReadExcelFileUtility();
        apMainPage = new APMainPage();
        registrationPage  = new RegistrationPage();

    }

    @BeforeMethod(alwaysRun = true)
    public void navigateToLaunchAutomationSite(Method method) {
      //  DriverUtility.driver.get("http://automationpractice.com/index.php");
       DriverUtility.driver.get("http://demo.automationtesting.in/Register.html");
       // DriverUtility.driver.get("http://demo.automationtesting.in/Static.html");

    }

//    @BeforeTest
//    public void verifyMainPage(){
//        System.out.println("This is printing from before Test from Automation Practice Test ");
//    }

    @Attachment
    public byte[] saveScreenshot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test(groups = {"regression-automationDemoSite"}, dependsOnMethods ={"verifySwitchToNewTabbedWindowTest"} )
    @Severity(SeverityLevel.BLOCKER)
    @Description("Alert window verification on application")
    @Epic("story=180")
    @Story("alertStory")
    public void automationDemoSiteAlertSite() throws InterruptedException {
      //  apMainPage.dragAndDropTOStaticElement();
        apMainPage.switchTOAlerts();
        saveScreenshot(DriverUtility.driver);
    }

    @Test(groups = "regression-automationDemoSite")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Alert window verification on application")
    @Epic("story=181")
    @Story("alertStory")
    public void registerUserTest()
    {
        registrationPage.registerUser("test","user","4425 ethel street","test7889@gmail.com", "1234567889","DummyPwd345","DummyPwd345");
        saveScreenshot(DriverUtility.driver);
        // Assert.assertEquals(registrationPage.getPageTitle(),"Web Table");
        //registrationPage.validateEmailIdExistsOrNot();
    }

    @Test(groups = "automation-regression", priority = 2)
    public void registerAccount() {
        apMyAccountPage = apMainPage.goToMyAccountPage();
        apMyAccountCreationPage = apMyAccountPage.goToMyAccountCreationPage();
        apMyAccountCreationPage.createNewAccount();
    }

    @Test(groups = "regression-automationDemoSite")
    @Severity(SeverityLevel.MINOR)
    @Description("Alert window verification on application")
    @Epic("story=182")
    @Story("alertStory")
    public void alertFirstBoxValidationTest() throws InterruptedException {
        registrationPage.validateFirstAlertBox();
        saveScreenshot(DriverUtility.driver);
    }

     @Test(groups = {"regression-automationDemoSite"})
//    @TmsLink("1559933")
//    @Severity(SeverityLevel.NORMAL)
//    @Description("Alert window verification on application")
//    @Epic("story=183")
//    @Story("alertStory")
    public void verifySwitchToNewTabbedWindowTest(){
        registrationPage.switchToWindowsPage();
        registrationPage.validateNewTabbedWindow();
        saveScreenshot(DriverUtility.driver);
    }

    @Test(groups = {"automation-regression"}, priority = 1)
    public void verifyMyAccountPage() {
        apMyAccountPage = apMainPage.goToMyAccountPage();
        Assert.assertEquals(apMyAccountPage.getTitle(), "Login - My Store");
        System.out.println("test case passed");
    }
//    @Test
//    public void registerAccountWithJavaScript() throws InterruptedException {
//        apMainPage.goToContactUsPage();
//
//    }

    @Test
    public void tShirtCartPageNavigationWithKeysActions() throws InterruptedException {
         apMainPage.gotoWomenTShirtsPage();
    }

    @Test(dataProvider = "test123")
    public void runTestViaDataProviderTestData(String email, String pwd) {
        System.out.println(email);
        System.out.println(pwd);
    }

    @Test(dataProvider = "registerTestData",retryAnalyzer = commonUtilities.RetryAnalyzerUtility.class)
    public void registerAccountWithDataProviderData(String custFN, String custLN, String custEmail, String dropDaysValue, String dropDMonth, String dropDownYear, String addressFirName, String addressLastName, String companyName, String address, String cityName, String addressState, String zip, String countryDdTextValue, String phoneNumber) {
        apMyAccountPage = apMainPage.goToMyAccountPage();
        apMyAccountCreationPage = apMyAccountPage.goToMyAccountCreationPage();
        Assert.assertTrue(apMyAccountCreationPage.isAPMyAccountPageValidated());
        apMyAccountCreationPage.createNewAccount(custFN, custLN, custEmail, dropDaysValue, dropDMonth, dropDownYear, addressFirName, addressLastName, companyName, address, cityName, addressState, zip, countryDdTextValue, phoneNumber);
    }

    @Test
    public void getDataFromExcelSheet() {
        String excelCellData = readExcelFileUtility.getData("LoginData", 1, 0);
        System.out.println(excelCellData);
    }

    @Test
    public void Test(){
        apMainPage.getElementByJavaScript();

    }

    @DataProvider(name = "test123")
    public Object[][] getTestData() {
        return new Object[][]{{"test@gmail.com", "pwd123"}, {"test2@gmail.com", "pwd124"}};

    }

    @DataProvider(name = "registerTestData")
    public Object[][] getRegistrationTestData() {
        return new Object[][]{{"testone", "testtwo", "test@678", "1", "1", "2000", "testone", "testtwo", "ABCCompany", "123 main street", "cypress", "California", "90630", "United States", "234567890"}};
    }

    @AfterMethod
    public void afterMethod(ITestResult result,Method method){

        switch(result.getStatus()){
            case 1: readExcelFileUtility.writeDataToExcel("TestCaseStatus",0,1,method.getName()+" PASSED");
                    break;
            case 2: readExcelFileUtility.writeDataToExcel("TestCaseStatus", 0,1, method.getName()+ "FAILED");
        }
    }

    @AfterSuite
    public void closeBrowser() {
//        DriverUtility.driver.quit();
    }

    @AfterSuite
    public void openReportInBrowser() throws IOException {
//        DriverUtility.driver.get(ReportUtility.reportFile);
//        Runtime.getRuntime().exec("taskkill /IM chromedirver.exe /f");
    }

}
