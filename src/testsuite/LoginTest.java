package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
@Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter the username
    sendTextToElement(By.id("username"),"tomsmith");

    // Enter the Password
    sendTextToElement(By.name("password"),"SuperSecretPassword!");

    //Click on Login
    clickOnElement(By.xpath("//i[contains(text(),'Login')]"));


   // Verify the text Secure Area
   String expectedResult = "Secure Area";
   WebElement actualMessage = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/h2[1]"));
  String actualMessageDisp = actualMessage.getText();

    Assert.assertEquals("Unable to Reach Secure Area",expectedResult,actualMessageDisp);
}
@Test
    public void verifyTheUserNameErrorMessage() {
        sendTextToElement(By.id("username"),"tomsmith1");

    sendTextToElement(By.name("password"),"SuperSecretPassword!");

    clickOnElement(By.xpath("//i[contains(text(),'Login')]"));

    String expectedResult = "Your username is invalid!\n" +
            "×";
    // acutal result
    WebElement actualResult = driver.findElement(By.xpath("//div[@id='flash']"));
    String actualMessageDisp = actualResult.getText();
// match the actual and expected are same or not
    Assert.assertEquals("Invalid user name",expectedResult,actualMessageDisp);
}
@Test
    public void verifyThePasswordErrorMessage() {
        // enter email address in the email field
    sendTextToElement(By.id("username"),"tomsmith");

    sendTextToElement(By.name("password"),"SuperSecretPassword");

    clickOnElement(By.xpath("//i[contains(text(),'Login')]"));

    String expectedResult = "Your password is invalid!\n" +
            "×";
    WebElement actualResult = driver.findElement(By.xpath("//div[@id='flash']"));
    String actualResultDisp = actualResult.getText();
    Assert.assertEquals("incorrect Password",expectedResult,actualResultDisp);

}
}
