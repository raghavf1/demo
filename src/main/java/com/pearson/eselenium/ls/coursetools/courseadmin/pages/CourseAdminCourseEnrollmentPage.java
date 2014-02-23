package com.pearson.eselenium.ls.coursetools.courseadmin.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class CourseAdminCourseEnrollmentPage extends BasePageObject {

    /**
     * Class contains all methods related to CourseAdminCourseEnrollmentPage
     * 
     * @author Raghav
     * @param uiDriver
     * 
     */
    /* UI element declarations for CourseAdminCourseEnrollmentPage */
    private UIElement txtpagetitle = createElement(UIType.Css, ".pageTitle");
    private UIElement lnkactive = createElement(UIType.LinkText, "Active");
    private UIElement lnkname = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    private UIElement btnback = createElement(UIType.LinkText, "back");
    private UIElement txtusernametitle = createElement(UIType.Css, ".tablehead");
    private UIElement lnkdropped = createElement(UIType.LinkText, "Dropped");
    
    /*Variables*/
    private  String  strPageTitle=null;
    
    /* constructor */
    public CourseAdminCourseEnrollmentPage(UIDriver driver) {
        super(driver);
        logInstruction("#######CourseEnrollmentPage########");

    }

    /**
     * This method is used to get the title of CourseEnrollmentPage
     * 
     * @author Raghav
     * @return CourseAdminCourseEnrollmentPage
     * @throws Exception
     */

    public String getTitle() throws Exception {
         
        try {
            frameSwitch.switchToFrameContent();
            logInstruction("LOG INSTRUCTION:VERIFY GENERAL COURSEENROLLMENTPAGE TITLE");
            uiDriver.waitToBeDisplayed(txtpagetitle, waitTime);
            if (txtpagetitle.isDisplayed()) {
                strPageTitle = txtpagetitle.getText().trim();
            }
        } catch (Exception e) {

            throw new Exception("ISSUE IN GETTING  'page title' " + "\n METHOD:getTitle \n" + e
                    .getLocalizedMessage());
        }
        return strPageTitle;
    }

    /**
     * This method is helps to click on active inside CourseEnrollment Tab
     * 
     * @author Raghav
     * @return CourseAdminCourseEnrollmentPage
     * @throws Exception
     */

    public CourseAdminCourseEnrollmentPage clickActive() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON ACTIVE LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkactive, waitTime);
            lnkactive.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'clickActivelink' " + "\n METHOD:clickActive \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method is helps to click on dropped inside CourseEnrollment Tab
     * 
     * @author Raghav
     * @return CourseAdminCourseEnrollmentPage
     * @throws Exception
     */

    public CourseAdminCourseEnrollmentPage clickDropped() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON DROPPED LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkdropped, waitTime);
            lnkdropped.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE ON CLICKING 'clickDropped'" + "\n MERTHOD:clickDropped \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method is helps to click on Name link inside CourseEnrollment Tab
     * 
     * @author Raghav
     * @return CourseAdminCourseEnrollmentPage
     * @throws Exception
     */

    public CourseAdminCourseEnrollmentPage clickNameLink(String name) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON NAME LINK");
            frameSwitch.switchToFrameContent();
            lnkname.replaceValues(name);
            uiDriver.waitToBeDisplayed(lnkname, waitTime);
            lnkname.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("ISSUE ON CLICKING 'namelink' " + "\n METHOD:clickNameLink \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is helps to click on Back link inside CourseEnrollment Tab
     * 
     * @author Raghav
     * @return CourseAdminCourseEnrollmentPage
     * @throws Exception
     */

    public CourseAdminCourseEnrollmentPage clickBack() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON BACK LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnback, waitTime);
            btnback.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING 'backbutton'" + "\n METHOD:clickBack" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is Verifies whether Back is button is Displayed
     * 
     * @author Raghav
     * @return CourseAdminCourseEnrollmentPage
     * @throws Exception
     */

    public boolean isBackLinkDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFIES BACK LINK");
            frameSwitch.switchToFrameContent();
            return btnback.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'backlink' " + "\n METHOD:isBackLinkDisplayed \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method is helps to Verify the Name,EmailAddress,status,Enrollment,Time Zone,Language
     * link is present
     * 
     * @author Raghav
     * @return CourseAdminCourseEnrollmentPage
     * @throws Exception
     */

    public boolean isLinkPresent(String name) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:VERIFIES THE LINK IS PRESENT");
            frameSwitch.switchToFrameContent();
            lnkname.replaceValues(name);
            return lnkname.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN VERIFYING 'link'" + "METHOD:isLinkPresent \n" + e
                    .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to determine whether page is displayed after clicking username
     * 
     * @author amit.deshmukh
     * @return String
     * @throws Exception
     */
    public String getUsernameTitle() throws Exception {
        try {
            frameSwitch.switchToFrameContent();
            logInstruction("LOG INSTRUCTION:VERIFY PAGE IS  DISPLAYED WITH NEW TITLE");
            uiDriver.waitToBeDisplayed(txtusernametitle, waitTime);
            if (txtusernametitle.isDisplayedAfterWaiting(waitTime)) {
            	strPageTitle = txtusernametitle.getText().trim();
            }
        } catch (Exception e) {

            throw new Exception(
                    "ISSUE IN GETTING 'username' " + "\n METHOD:getUsernameTitle \n" + e
                            .getLocalizedMessage());
        }
        return strPageTitle;
    }

}
