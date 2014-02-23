package com.pearson.eselenium.ls.common.pages;

import com.pearson.eselenium.ls.course.pages.NextCourseHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all the methods related to the DashBoard page
 * 
 * @author ganapati.bhat
 */
public class DashboardPage extends BasePageObject {

    /* Elements */
    private UIElement lnkCourse = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    private UIElement clickOnSignOff = createElement(
            UIType.Xpath,
            "//*[@id='cntHeader2']/tbody/tr/td[3]/div/a[contains(@title,'Signoff')]");
    private UIElement lblUserName = createElement(
            UIType.Xpath,
            "//*[@id='cntHeader2']/tbody/tr/td[2]");// "//*[@id='cntHeader2']/tbody/tr/td[2]/font");

    /* Variables */
    private String data = null;
    private boolean flag = false;
    private String strUname = null;
    String environmentValue = null;

    /* Constructor */
    public DashboardPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## Dashboard Page ##");
    }

    /**
     * Method helps to select the course and click on it.
     * 
     * @author ganapati.bhat
     * @param String
     *            courseName
     * @return TeachingSolutionWindow
     * @throws Exception
     */
    public NextCourseHomePage selectNextCourse(String courseName) throws Exception {
        try {
            lnkCourse.replaceValues(courseName);
            uiDriver.waitToBeDisplayed(lnkCourse, waitTime);
            lnkCourse.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: SELECTED THE COURSE");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT THE COURSE \n METHOD :selectNextCourse");
        }
        return new NextCourseHomePage(uiDriver);
    }

    /**
     * Method helps to verify the proper login
     * 
     * @author ganapati.bhat
     * @return boolean
     * @throws Exception
     */
    public boolean isDashBoardPageDisplayed() throws Exception {
        try {
            environmentValue = config.getValue("environment");
            String dashtitle = uiDriver.getTitle();
            if (environmentValue.equalsIgnoreCase("VCD"))
                return dashtitle.equalsIgnoreCase("Academics PSH");
            else
                if (environmentValue.equalsIgnoreCase("PRODUCTION"))
                    return dashtitle.equalsIgnoreCase("Courses");
            logInstruction("LOG INSTRUCTION: LOGIN PAGE IS DISPLAYED");
        } catch (Exception e) {
            throw new Exception(
                    "LOGIN IS FAILED. UNABLE TO LOCATE WELCOME IN THE DASH BOARD PAGE \n METHOD :isDashBoardPageDisplayed");
        }
        return false;
    }

    /**
     * Method helps to verify the whether course link is present or not
     * 
     * @author Raghav S
     * @param String
     *            courseName
     * @return boolean
     * @throws Exception
     */
    public boolean isCourseHomelinkDisplayed(String courseName) throws Exception {
        flag = false;
        try {
            lnkCourse.replaceValues(courseName);
            flag = lnkCourse.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "LOGIN IS FAILED. UNABLE TO LOCATE THE LINK\n METHOD :iscourseHomelinkDisplayed ");
        }
        return flag;
    }

    /**
     * This method will give DashBoardPage title
     * 
     * @return String
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public String getPagetitle() throws Exception {
        try {
            data = uiDriver.getTitle();
        } catch (Exception e) {
            throw new Exception("NOT ABLE TO GET PAGETITLE \n METHOD :getPagetitle");
        }
        return data;
    }

    /**
     * Method for clicking on sign off link
     * 
     * @author Suchi.Singh
     * @return LoginPage Instance
     * @throws Exception
     */
    public LoginPage clickOnSignOff() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SUCCESSFULLY CLICKED ON SIGN OFF LINK");
            clickOnSignOff.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "LOGIN IS FAILED. UNABLE TO LOCATE WELCOME IN THE DASH BOARD PAGE \n METHOD :clickOnSignOff");
        }
        return new LoginPage(uiDriver);
    }

    /**
     * Method for checking whether given user is Logged in
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @param String
     *            strUserName
     * @return boolean
     * @throws Exception
     */
    public boolean isUserLoggedInPage(String strUserName) throws Exception {
        flag = false;
        try {
            uiDriver.waitToBeDisplayed(lblUserName, waitTime);
            strUname = lblUserName.getText().trim();
            if (strUname.toLowerCase().contains(strUname.toLowerCase()))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "METHOD FOR CHECKING WHETHER GIVEN USER IS LOGGED IN OR NOT \n METHOD :isUserLoggedInPage");
        }
        return flag;
    }
}
