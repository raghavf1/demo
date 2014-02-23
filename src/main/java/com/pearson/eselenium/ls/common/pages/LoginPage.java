package com.pearson.eselenium.ls.common.pages;

import com.pearson.eselenium.ls.common.pages.utils.AutomationEnvironment;
import com.pearson.test.eselenium.framework.config.Config;
import com.pearson.test.eselenium.framework.config.DefaultConfig;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all the methods related to login page
 * 
 * @author ganapati.bhat
 */
public class LoginPage extends BasePageObject {

    /* Elements */
    private UIElement txtUserName = createElement(UIType.Name, "Username");
    private UIElement txtPassword = createElement(UIType.Name, "Password");
    private UIElement btnSubmit = createElement(UIType.Css, "input[value='Login']");
    private UIElement lnkAcademicsPSH = createElement(
            UIType.Xpath,
            "//a[contains(@title,'Academics PSH')]");
    private UIElement btnGoToClass = createElement(
            UIType.Xpath,
            "//input[contains(@value,'Go to Class')]");
    private UIElement lnkHere = createElement(UIType.Xpath, "//a[contains(.,'here')]");
    
    /* Variables */
    protected static Config config = DefaultConfig.getConfig();
    String environmentValue = config.getValue("environment");

    private boolean flag = false;

    /* Constructor */
    public LoginPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## Login Page ##");
    }

    /**
     * Method helps to login to the LS pages
     * 
     * @author ganapati.bhat
     * @param String
     *            username
     * @param String
     *            password
     * @return DashboardPage Instance
     * @throws Exception
     */
    public DashboardPage doLogin(String username, String password) throws Exception {
        try {
            if (environmentValue.equalsIgnoreCase(AutomationEnvironment.PRODUCTION.toString())) {

                txtUserName.sendKeys(username);
                txtPassword.sendKeys(password);
                btnSubmit.clickAndWait(waitTime);

            } else {

                txtUserName.sendKeys(username);
                txtPassword.sendKeys(password);
                btnGoToClass.clickAndWait(waitTime);
                uiDriver.waitToBeDisplayed(lnkAcademicsPSH, waitTime);
                lnkAcademicsPSH.clickAndWait(waitTime);

            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO LOGIN \n METHOD :doLogin" + e.getLocalizedMessage());
        }
        return new DashboardPage(uiDriver);
    }

    /**
     * Method helps to verify the login page
     * 
     * @return boolean login page
     * @throws Exception
     * @author ganapati.bhat
     */
    public boolean isLoginPageDisplayed() throws Exception {
        flag = false;
        try {
            if (environmentValue.equalsIgnoreCase(AutomationEnvironment.PRODUCTION.toString())) {
                flag = btnSubmit.isDisplayedAfterWaiting(waitTime);
            } else {
                flag = btnGoToClass.isDisplayedAfterWaiting(waitTime);
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO VERIFY LOGIN PAGE :isLoginPageDisplayed" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to login to the LS pages as Admin
     * 
     * @author ganapati.bhat
     * @param String
     *            username
     * @param String
     *            password
     * @return DashboardPage Instance
     * @throws Exception
     */
    public DashboardPage doLoginAsAdmin(String username, String password) throws Exception {
        try {
            if (environmentValue.equalsIgnoreCase(AutomationEnvironment.PRODUCTION.toString())) {

                txtUserName.sendKeys(username);
                txtPassword.sendKeys(password);
                btnSubmit.clickAndWait(waitTime);

            } else {

                txtUserName.sendKeys(username);
                txtPassword.sendKeys(password);
                btnGoToClass.clickAndWait(waitTime);
                uiDriver.waitToBeDisplayed(lnkAcademicsPSH, waitTime);
                lnkAcademicsPSH.clickAndWait(waitTime);
                uiDriver.waitToBeDisplayed(lnkHere, waitTime);
                lnkHere.clickAndWait(waitTime);

            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO LOGIN \n METHOD :doLoginAsAdmin" + e
                    .getLocalizedMessage());
        }
        return new DashboardPage(uiDriver);
    }

    /**
     * Method is used to verify that UsernameField is Empty or not
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isUsernameFieldEmpty() throws Exception {
        flag = false;
        try {
            uiDriver.waitToBeDisplayed(txtUserName, waitTime);
            if (txtUserName.getText().length() == 0) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO VERIFY ISUSERNAMEFIELDEMPTY \n METHOD :isUsernameFieldEmpty" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify that PasswordField is Empty or not
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isPasswordFieldEmpty() throws Exception {
        flag = false;
        try {
            uiDriver.waitToBeDisplayed(txtPassword, waitTime);
            if (txtPassword.getText().length() == 0) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO VERIFY ISPASSWORDFIELDEMPTY \n METHOD :isPasswordFieldEmpty" + e
                            .getLocalizedMessage());
        }
        return flag;
    }
}
