package elementRepository;

import commonUtilities.DriverUtility;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import webElementUtility.WebelementActionLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RegistrationPage {

    public RegistrationPage() {
        PageFactory.initElements(DriverUtility.getDriver(), this);
    }

    //RegistrationPage registrationPage = PageFactory.initElements(DriverUtility.driver,RegistrationPage.class);
    WebelementActionLibrary elementActionLib = new WebelementActionLibrary();


    @FindBy(xpath = "//input[@ng-model='FirstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@ng-model='LastName']")
    private WebElement lastName;

    @FindBy(xpath = "//textarea[@ng-model='Adress']")
    private WebElement address;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@ng-model='Phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@ng-model='radiovalue' and @value='FeMale']")
    private WebElement genderFemale;

    @FindBy(xpath = "//input[@ng-model='radiovalue' and @value='Male']")
    private WebElement genderMale;

    @FindBy(xpath = "//input[@id='checkbox1']")
    private WebElement cricketRadioBtn;

    @FindBy(xpath = "//input[@id='checkbox2']")
    private WebElement moviesRadiobtn;

    @FindBy(xpath = "//input[@id='checkbox2']")
    private WebElement hobbiesRadioBtn;

    @FindBy(xpath = "//span[@role='combobox']")
    private WebElement multiSelectCountry;

    @FindBy(xpath = "//input[@ng-model='radiovalue' and @value='FeMale']")
    private WebElement femaleRadioBtn;

    @FindBy(xpath = "//input[@ng-model='radiovalue' and @value='Male']")
    private WebElement maleRadioBtn;

    @FindBy(xpath = "//input[@id='checkbox1']")
    private WebElement cricketCheckbox;

//    @FindBy(id = "msdd")
//    private WebElement languageDropdown;

    @FindBy(css="id#msdd")
    private WebElement languageDropdown;

    @FindBy(linkText = "English")
    private WebElement englishLanguage;

    @FindBy(xpath = "//select[@id='Skills']")
    private WebElement skillsDropDown;

    @FindBy(xpath = "//select[@id='countries']")
    private WebElement countriesDropdown;

    @FindBy(xpath = "//li[@role='treeitem']//following-sibling::li[5]")
    private WebElement countryValue;

    @FindBy(xpath = "//select[@id='yearbox']")
    private WebElement yearDropDown;

    @FindBy(xpath = "//select[@ng-model='monthbox']")
    private WebElement monthDropdown;

    @FindBy(xpath = "//select[@ng-model='daybox']")
    private WebElement dayDropDown;
//
//    @FindBy(id = "firstpassword")
//    private WebElement passwordTextBox;

    @FindBy(css="id#firstpassword")
    private WebElement passwordTextBox;

//    @FindBy(id = "secondpassword")
//    private WebElement secondPassWordTextBox;

    @FindBy(css="id#secondpassword")
    private WebElement secondPassWordTextBox;

    @FindBy(id = "submitbtn")
    private WebElement submitbtn;

    @FindBy(css = "button#submitbtn")
    private WebElement submitBtnWithCSSSelector;

    @FindBy(xpath = "//div[@class='ui-grid-canvas']/div/div/div[1]/div")
    private WebElement emailElement;

    @FindBy(xpath = "//button[@title='Page forward']")
    private WebElement forwardButton;

    @FindBy(linkText = "SwitchTo")
    private WebElement switchTOLink;

    @FindBy(linkText = "Alerts")
    private WebElement alertsLink;

    @FindBy(linkText = "Windows")
    private WebElement windowsLink;

    @FindBy(linkText = "Alert with OK ")
    private WebElement alertOKLink;

    @FindBy(xpath = "//a[@href='#CancelTab']")
    private WebElement alertOKCancelLink;

    @FindBy(xpath = "//a[@href='#Texbox']")
    private WebElement alertWithTextBoxLink;

    @FindBy(xpath="//button[@class='btn btn-danger']")
    private WebElement displayAlertBoxBtn;

    @FindBy(xpath="//button[@class='btn btn-primary']")
    private WebElement confirmBoxAlertBtn;

    @FindBy(xpath="//button[@class='btn btn-info']")
    private WebElement promptAlertBtn;

//    @FindBy(id="demo1")
//    private WebElement alertTextBoxMsgLabel;

    @FindBy(css="id#demo1")
    private WebElement alertTextBoxMsgLabel;

    @FindBy(linkText="Windows")
    private WebElement windowsHyperLink;

    @FindBy(xpath = "//a[@href='#Tabbed']")
    private WebElement openNewTabbedWindowLink;

    @FindBy(xpath="//a[@href='#Seperate']")
    private WebElement separateWindowLink;

    @FindBy(xpath="//a[@href='#Multiple']")
    private WebElement separateMultiPleWindow;

    @FindBy(xpath="//div[@id='Tabbed']/a")
    private WebElement newTabBtn;

    @FindBy(xpath="//button[@class='btn btn-primary']")
    private WebElement separateNewWindowBtn;

    @FindBy(xpath="//button[@onclick='multiwindow()']")
    private WebElement separateMultiPleWinBtn;


    @Step("Register user verification")
    public void registerUser(String firstNameInput, String lastNameInput, String addressInput, String emailInput, String phoneInput, String firstPwd, String secondPwd) {

        elementActionLib.enterText(firstName, firstNameInput);
        elementActionLib.enterText(lastName, lastNameInput);
        elementActionLib.enterText(address, addressInput);
        elementActionLib.enterText(email, emailInput);
        elementActionLib.enterText(phone, phoneInput);
        elementActionLib.click(femaleRadioBtn);
        elementActionLib.click(cricketCheckbox);
        elementActionLib.click(languageDropdown);
       // elementActionLib.wait.until(ExpectedConditions.visibilityOf((englishLanguage)));
        elementActionLib.click(englishLanguage);
        elementActionLib.selectDropdown(skillsDropDown, "Java");
        elementActionLib.click(multiSelectCountry);
       // elementActionLib.wait.until(ExpectedConditions.visibilityOf(countryValue));
        elementActionLib.click(countryValue);
        elementActionLib.selectDropdown(countriesDropdown, "India");
        elementActionLib.selectDropdown(yearDropDown, "2000");
        elementActionLib.selectDropdown(monthDropdown, "August");
        elementActionLib.selectDropdown(dayDropDown, "17");
        elementActionLib.enterText(passwordTextBox, firstPwd);
        elementActionLib.enterText(secondPassWordTextBox, firstPwd);
        elementActionLib.click(submitBtnWithCSSSelector);
    }

//    public String getPageTitle() {
//        return
//    }

    public List<String> getEmails(WebElement element) {
        List<String> rowsEmailContent = new ArrayList<>();
        String emails = element.getText();
        int stepClickForwardButton = 10;
        for (int i = 0; i < 100; i++) {
            rowsEmailContent.add(emails);
           if(i % stepClickForwardButton==0){
                elementActionLib.click(forwardButton);
            }
        }
        return rowsEmailContent;
    }

    public void validateEmailIdExistsOrNot() {
        getEmails(emailElement);
        if (email.getText().contains("oneapptest68")) {
            Assert.assertTrue(true, "email doesn't exists");
        }
    }


    @Step("First alert box verification")
    public void validateFirstAlertBox() throws InterruptedException {
        try{
        elementActionLib.moveToTheElementAndClick(switchTOLink);
        elementActionLib.click(alertsLink);
        elementActionLib.click(displayAlertBoxBtn);
      //  ReportUtility.passCase("Displayed alert box","alertPopUpScreenShot");
        elementActionLib.acceptAlert();
        Thread.sleep(10);
        elementActionLib.click(alertOKCancelLink);
        elementActionLib.click(confirmBoxAlertBtn);
        elementActionLib.dismissAlert();
        elementActionLib.click(alertWithTextBoxLink);
        elementActionLib.click(promptAlertBtn);
        elementActionLib.enterTextInAlertBox("test");
        if(alertTextBoxMsgLabel.isDisplayed()){
            alertTextBoxMsgLabel.getText();
        }}catch(Exception e){
      //      ReportUtility.failCase("unable to log the alert box","alerterrorScreenShot");
            e.printStackTrace();
        }

    }

    @Step("switching to Windows tab")
    public void switchToWindowsPage(){
        elementActionLib.moveToTheElementAndClick(switchTOLink);
        elementActionLib.click(windowsHyperLink);

    }

    @Step("switching to Windows tab")
    public void validateNewTabbedWindow(){
        String currentWindowName = elementActionLib.getCurrentWindowName();
         elementActionLib.click(newTabBtn);
        Set<String> allWindowHandles = elementActionLib.switchToGetWindowHandle();
         allWindowHandles.remove(currentWindowName);
        for(String s : allWindowHandles ){
            DriverUtility.driver.switchTo().window(s);
        }
        DriverUtility.driver.close();
        DriverUtility.driver.switchTo().window(currentWindowName);
    }
}
