/*
 * package com.demoqa.framework.tests;
 * 
 * import org.testng.annotations.DataProvider; import
 * org.testng.annotations.Test;
 * 
 * import com.demoqa.framework.base.BaseTest; import
 * com.demoqa.framework.pages.HomePage; import
 * com.demoqa.framework.pages.LoginPage; import
 * com.demoqa.framework.utils.ConfigReader; import
 * com.demoqa.framework.utils.ExcelUtils;
 * 
 * import dev.failsafe.internal.util.Assert;
 * 
 * 
 * public class LoginTest extends BaseTest {
 * 
 * @DataProvider(name = "loginData") public Object[][] getLoginData() { //String
 * projectPath = System.getProperty("user.dir"); return ExcelUtils.getTestData(
 * "C:/Users/Ajeet/eclipse-workspace/demoqa/src/test/resources/TestData.xlsx",
 * "login"); }
 * //C:\Users\Ajeet\eclipse-workspace\demoqa\src\test\resources\testdata.xlsx
 * 
 * @Test(dataProvider = "loginData") public void loginTest(String username,
 * String password) { driver.get(ConfigReader.getPropertyValue(
 * "https://practicetestautomation.com/practice-test-login/"));
 * 
 * LoginPage loginPage = new LoginPage(driver); loginPage.login(username,
 * password);
 * 
 * HomePage homePage = new HomePage(driver); System.out.println("At home page");
 * }
 * 
 *
 */