package com.pearson.eselenium.ls.coursetools.courseadmin.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all methods related to CourseAdminPage
 * 
 * @author Pratush.Manglik
 * @param uiDriver
 */

public class CourseAdminPage extends BasePageObject {

    /* UI element declarations for CourseAdminPage */
    private UIElement btnStyleManager = createElement(UIType.Css, "a[href*='ManageStylesView.ed']");
    private UIElement btnEnableDisable = createElement(
            UIType.Css,
            "a[href*='ManageCourseFeaturesView.ed']");
    private UIElement btnthreaddiscussion = createElement(
            UIType.LinkText,
            "Threaded Discussion Preferences");
    private UIElement generalinformation = createElement(
            UIType.LinkText,
            "General Information & Settings");
    private UIElement coursescheduler = createElement(UIType.LinkText, "Course Scheduler");
    private UIElement lnkGroupMgt = createElement(UIType.LinkText, "Group Management");
    private UIElement btnGroupManagement = createElement(
            UIType.Css,
            "div[id='contentMenu']>a[href*='../CourseGroupProf/ListGroupsView.ed']");
    private UIElement lnkCourseScheduler = createElement(UIType.LinkText, "Course Scheduler");
    private UIElement lblHeaderTitle = createElement(
            UIType.Xpath,
            "//div[contains(@class,'pageTitle')]");
    private UIElement btnInformationAndPreferences = createElement(
            UIType.Xpath,
            "//a[contains(@class,'ON')]");
    private UIElement lblTitle = createElement(UIType.Xpath, "//div[@class='pageTitle']");
    private UIElement lnkcourseinfoandpreferences = createElement(
            UIType.LinkText,
            "Course Information & Preferences");
    private UIElement btngeneralinformation = createElement(
            UIType.Css,
            ".outercontenttable>tbody>tr>td>table>tbody>tr:nth-of-type(1)>td:nth-of-type(2)");
    private UIElement lnkstylemanager = createElement(UIType.LinkText, "Style Manager");
    private UIElement txtstylemanagerinstructional = createElement(
            UIType.Css,
            ".outercontenttable>tbody>tr>td>table>tbody>tr:nth-of-type(2)>td:nth-of-type(2)");
    private UIElement lnkenabledisabletools = createElement(UIType.LinkText, "Enable/Disable Tools");
    private UIElement txtenabledisabletools = createElement(
            UIType.Css,
            ".outercontenttable>tbody>tr>td>table>tbody>tr:nth-of-type(3)>td:nth-of-type(2)");
    private UIElement lnkthreadeddiscussionpreferences = createElement(
            UIType.LinkText,
            "Threaded Discussion Preferences");
    private UIElement txtthreadeddiscussionpreferences = createElement(
            UIType.Css,
            ".outercontenttable>tbody>tr>td>table>tbody>tr:nth-of-type(4)>td:nth-of-type(2)");
    private UIElement txtcourseschedulerinstructional = createElement(
            UIType.Css,
            ".outercontenttable>tbody>tr>td>table>tbody>tr:nth-of-type(5)>td:nth-of-type(2)");
    private UIElement lnkcourseEnrollment = createElement(UIType.LinkText, "Course Enrollment");
    private UIElement lnkstyleunderlined = createElement(
            UIType.Xpath,
            "//a[contains(text(),'{1}')]");
    private UIElement lnkstylenotunderlined = createElement(
            UIType.Xpath,
            "//a[contains(text(),'{1}')]");
    private UIElement txttitle = createElement(UIType.Css, ".tablehead");
    private UIElement lnkpathbuilder = createElement(UIType.LinkText, "Path Builder");
    private UIElement lnknewroman = createElement(UIType.Xpath, "//td[a[contains(text(),'{1}')]]");
    private UIElement lblcourseInformationPref = createElement(UIType.ClassName, "tablehead");
    
    /*variables*/
    private String strLink = null;
    private boolean flag = false;
    private String strTableHeader = "";
    
    /* constructor */
    public CourseAdminPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## CourseAdminPage ##");
    }

    /**
     * This method is used to click on style manager
     * 
     * @author Pratush.Manglik
     * @return CourseAdminPage
     * @throws Exception
     */
    public CourseAdminStyleManagerPage clickStyleManager() throws Exception {

        logInstruction("LOG INSTRUCTION:  CLICK STYLE MANAGER ");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnStyleManager, waitTime);
            btnStyleManager.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'style manager' " + "\n METHOD:clickStyleManager \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminStyleManagerPage(uiDriver);
    }

    /**
     * This method helps to click on Group Management Tab in CourseAdminGroupManagementPage
     * 
     * @author Raghav
     * @return CourseAdminCourseEnrollmentPage
     * @throws Exception
     */

    public CourseAdminCourseEnrollmentPage clickCourseEnrollementTab() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON COURSE ENROLLMENT TAB");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkcourseEnrollment, waitTime);
            lnkcourseEnrollment.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON'Course Enrollement Tab'" + "\n METHOD:clickCourseEnrollementTab \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminCourseEnrollmentPage(uiDriver);

    }

    /**
     * This method is used to click on the enable/disable button
     * 
     * @author Pratush.Manglik
     * @return EnableDisablepage
     * @throws Exception
     */
    public EnableDisableToolsPage clickEnableDisable() throws Exception {
        logInstruction("LOG INSTRUCTION:  CLICK ENABLE/DISABLE BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnEnableDisable, waitTime);
            btnEnableDisable.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'enable/disable' " + "\n METHOD:clickEnableDisable \n" + e
                            .getLocalizedMessage());
        }
        return new EnableDisableToolsPage(uiDriver);
    }

    /**
     * This method is used to click on ThreadDiscussionPreferencePage
     * 
     * @author Raghav S
     * @return CourseAdminPage
     * @throws Exception
     */
    public CourseAdminThreadedDiscussionPreferencesPage clickThreaddiscussion() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:  CLICKS ON THREAD DISCUSSIONPREFERENCES PAGE ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnthreaddiscussion, waitTime);
            btnthreaddiscussion.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Thread DiscussionPreferences' " + "\n METHOD:clickThreaddiscussion \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminThreadedDiscussionPreferencesPage(uiDriver);
    }

    /**
     * This method is used to click on General Information & Settings
     * 
     * @author Raghav S
     * @return CourseAdminPage
     * @throws Exception
     */
    public CourseAdminGeneralandInformationPage clickGeneralSettings() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:  CLICK ON GENERAL INFORMATION & SETTINGS ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(generalinformation, waitTime);
            generalinformation.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON ' General Information & Settings' " + "\n METHOD:clickGeneralSettings \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminGeneralandInformationPage(uiDriver);
    }

    /**
     * This Method Will click on Group Management tab
     * 
     * @return {@link CourseAdminGroupManagementPage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public CourseAdminGroupManagementPage clickGroupManagement() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING GROUP MANAGEMENT");
            uiDriver.waitToBeDisplayed(lnkGroupMgt, waitTime);
            lnkGroupMgt.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'GroupManagement'" + "\n METHOD:clickGroupManagement \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminGroupManagementPage(uiDriver);

    }

    /**
     * This method helps to click on Group Management Tab in CourseAdminGroupManagementPage
     * 
     * @author Raghav
     * @return CourseAdminGeneralandInformationPage
     * @throws Exception
     */

    public CourseAdminGroupManagementPage clickGroupManagementTab() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON GROUP MANAGEMENT TAB");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnGroupManagement, waitTime);
            btnGroupManagement.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON ' Course Enrollement Tab'" + "\n METHOD:clickGroupManagementTab \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminGroupManagementPage(uiDriver);

    }

    /**
     * This method Verifies whether courseinformation and Preferences Tab Present
     * 
     * @category Milestone 2
     * @author Raghav
     * 
     * @return CourseAdminPage
     * @throws Exception
     */

    public boolean iscourseInfoPreferencesTabDisplayed() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:VERIFIES COURSEINFORMATION AND PREFERENCES TAB");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkcourseinfoandpreferences, waitTime);
            if (lnkcourseinfoandpreferences.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            } else {
            	flag = false;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING ' preferences tab'" + "\n METHOD:iscourseInfoPreferencesTabDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 This method is used to click on course scheduler link
     * @author Pratush.Manglik
     * @return CourseSchedulerPage
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage clickCourseSchedulerLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK ON COURSE SCHEDULER LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkCourseScheduler, waitTime);
            lnkCourseScheduler.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON'course scheduler link' " + "\n METHOD:clickCourseSchedulerLink \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminCourseSchedulerPage(uiDriver);
    }

    /**
     * Methods helps to determine whether GeneralInformationandSettingsLinkPresent
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isGeneralInformationandSettingsLinkPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:LOG INSTRUCTION : WAIT FOR LINK");
            frameSwitch.switchToFrameContent();
            return generalinformation.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'GeneralInformationandSettingsLink'" + "\n METHOD:isGeneralInformationandSettingsLinkPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to determine whether GeneralInformationandSettingsTextPresent
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isGeneralInformationandSettingsInstructionalTxtPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:LOG INSTRUCTION : WAIT FOR TEXT");
            frameSwitch.switchToFrameContent();
            return btngeneralinformation.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'GeneralInformationandSettingsInstructionalTxt'" + "\n METHOD:isGeneralInformationandSettingsInstructionalTxtPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to determine whether StyleManagerlinkPresent
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public boolean isStyleManagerlinkPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:LOG INSTRUCTION :WAIT FOR LINK");
            frameSwitch.switchToFrameContent();
            return lnkstylemanager.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'StyleManagerlink'" + "\n METHOD:isStyleManagerlinkPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to determine whether StyleManagerinstructionaltxtPresent
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public boolean isStyleManagerInstructionalTxtPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:WAIT FOR STYLEMANAGERINSTRUCTIONAL TEXT");
            frameSwitch.switchToFrameContent();
            return txtstylemanagerinstructional.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'StyleManagerInstructionalTxt'" + "\n METHOD:isStyleManagerInstructionalTxtPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to determine whether EnableDisableToolsLinkPresent
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isEnableDisableToolsLinkPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:LOG INSTRUCTION :WAIT FOR LINK");
            frameSwitch.switchToFrameContent();
            return lnkenabledisabletools.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING  enabledisablelink" + "\n METHOD:isEnableDisableToolsLinkPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to determine whether EnableDisableToolsinstructionaltextpresent
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isEnableDisableToolsInstructionalTextPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:WAIT FOR TEXT");
            frameSwitch.switchToFrameContent();
            return txtenabledisabletools.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'EnableDisableToolsInstructionalText'" + "\n METHOD:isEnableDisableToolsInstructionalTextPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to determine whether EnableDisableToolsinstructionaltextpresent
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isThreadedDiscussionPreferencesLinkPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:WAIT FOR LINK");
            frameSwitch.switchToFrameContent();
            return lnkthreadeddiscussionpreferences.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'ThreadedDiscussionPreferencesLink'" + "\n METHOD:isEnableDisableToolsInstructionalTextPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to determine ThreadedDiscussionPreferencesinstructionaltext is present.
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean;
     * @throws Exception
     */
    public boolean isThreadedDiscussionPreferencesInstructionalTextPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:WAIT FOR TEXT");
            frameSwitch.switchToFrameContent();
            return txtthreadeddiscussionpreferences.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'ThreadedDiscussionPreferencesInstructionalText'" + "\n METHOD:ThreadedDiscussionPreferencesInstructionalTextPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to determine CourseSchedulerLink is present
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isCourseSchedulerLinkPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:WAIT FOR LINK");
            frameSwitch.switchToFrameContent();
            return coursescheduler.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'CourseSchedulerLink'" + "\n METHOD:isCourseSchedulerLinkPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to determine CourseSchedulerinstructionaltext is present
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public boolean isCourseSchedulerInstructionalTextPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:WAIT FOR TEXT");
            frameSwitch.switchToFrameContent();
            return txtcourseschedulerinstructional.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'CourseSchedulerInstructionalText'" + "\n METHOD:isCourseSchedulerInstructionalTextPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Method helps to check whether Course Enrollment tab displayed
     * 
     * @category Milestone 2
     * @author Raghav S
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isCourseEnrollmentTabDisplayed() throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING THE COURSE ENROLLMENT TAB DISPLAYED");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkcourseEnrollment, waitTime);
            if (lnkcourseEnrollment.isEnabled())
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  Course Enrollment tab" + "\n METHOD:isCourseEnrollmentTabDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method Verifies Whether Group Management Tab is Displayed or not
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminPage
     * @throws Exception
     */

    public boolean isGroupManagementTabDisplayed() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:VERIFIES  GROUP MANAGEMENT TAB");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnGroupManagement, waitTime);
            if (btnGroupManagement.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            } else {
                flag = false;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE   'Group Management Tab'" + "\n METHOD:isGroupManagementTabDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify the Header Title of the CourseAdminPage
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isCourseAdminHeaderTitleDisplayed() throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION : VERIFY THE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblHeaderTitle, waitTime);
            flag = lblHeaderTitle.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE ' header title'" + "\n METHOD:isCourseAdminHeaderTitleDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This method Verifies Whether a link is Underlined
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminPage
     * @throws Exception
     */

    public boolean isLinkStyleUnderlined(String lnkname) throws Exception {
      
        strLink = null;
        try {
            logInstruction("LOG INSTRUCTION:VERIFIES WHETHER A LINK IS UNDERLINED");
            frameSwitch.switchToFrameContent();
            lnkstyleunderlined.replaceValues(lnkname);
            uiDriver.waitToBeDisplayed(lnkstyleunderlined, waitTime);
            if (getBrowser().equals(Browser.CHROME)) {
            	strLink = lnkstyleunderlined.getCssValue("TEXT-DECORATION");
            } else {
            	strLink = lnkstyleunderlined.getCssValue("text-decoration");
            }

            if (strLink.contains("underline")) {
            	flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'link'" + "\n METHOD:isLnkStyleUnderlined \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method Verifies a link is not Underlined
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminPage
     * @throws Exception
     */

    public boolean isLinkStyleNotUnderlined(String lnkname) throws Exception {
       
        strLink = null;
        try {
            logInstruction("LOG INSTRUCTION:VERIFIES WHETHER A LINK IS UNDERLINED");
            frameSwitch.switchToFrameContent();
            lnkstylenotunderlined.replaceValues(lnkname);
            uiDriver.waitToBeDisplayed(lnkstylenotunderlined, waitTime);
            if ((getBrowser().equals(Browser.CHROME))) {
            	strLink = lnkstylenotunderlined.getCssValue("TEXT-DECORATION");
            } else {
            	strLink = lnkstylenotunderlined.getCssValue("text-decoration");
            }
            if (strLink.contains("none")) {
                flag = true;
            } else {
            	flag = false;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Stylelink'" + "\n METHOD:isLnkStyleNotUnderlined \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to get the title of CourseAdminPage
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminPage
     * @throws Exception
     */

    public String getTitle() throws Exception {
        try {
            frameSwitch.switchToFrameContent();
            logInstruction("LOG INSTRUCTION:GETTING THE TITLE OF COURSEADMIN PAGE");
            uiDriver.waitToBeDisplayed(txttitle, waitTime);
            strLink = txttitle.getText().trim();

        } catch (Exception e) {

            throw new Exception(
                    "ISSUE IN GETTING THE ' CourseAdmin Page Title'" + "\n METHOD:getTitle \n" + e
                            .getLocalizedMessage());
        }
        return strLink;
    }

    /**
     * This method Verifies the pathbuilder link
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isPathBuilderPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:VERIFYING PATH BUILDER");
            frameSwitch.switchToFrameContent();
            return lnkpathbuilder.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Pathbuilder link'" + "\n METHOD:isPathBuilderPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method Verifies Whether a link is Underlined
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminPage
     * @throws Exception
     */

    public boolean isFontChangedTimesNewRoman(String lnkname) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:VERIFIES WHETHER FONT IS CHANGED");
            frameSwitch.switchToFrameContent();
            lnknewroman.replaceValues(lnkname);
            uiDriver.waitToBeDisplayed(lnknewroman, waitTime);
            if ((getBrowser().equals(Browser.CHROME))) {
            	strLink = lnknewroman.getCssValue("FONT-FAMILY");
            } else {
            	strLink = lnknewroman.getCssValue("font-family");
            }

            if (strLink.contains("Times New Roman")) {
                flag = true;
            } else {
                flag = false;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'font'" + "\n METHOD:isFontChangedTimesNewRoman \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method Verifies Whether a link is Underlined
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminPage
     * @throws Exception
     */

    public boolean isFontSize(String lnkname) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFIES THE FONT SIZE");
            frameSwitch.switchToFrameContent();
            lnknewroman.replaceValues(lnkname);
            uiDriver.waitToBeDisplayed(lnknewroman, waitTime);
            if ((getBrowser().equals(Browser.CHROME))) {
            	strLink = lnknewroman.getCssValue("FONT-SIZE");
            } else {
            	strLink = lnknewroman.getCssValue("font-size");
            }

            if (strLink.contains("7")) {
                flag = true;
            } else {
            	flag = false;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'FONTSIZE'" + "\n METHOD:isFontSize \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether Course Enrollment tab displayed
     * 
     * @category Milestone 2
     * @author Raghav S
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isCourseEnrollmentTabSelected() throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING THE COURSE ENROLLMENT TAB DISPLAYED");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkcourseEnrollment, waitTime);
            if (lnkcourseEnrollment.isSelected())
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN FINDING THE 'Enrollment tab'" + "\n METHOD:isCourseEnrollmentTabSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether Course Information & Preferences tab displayed
     * 
     * @category Milestone 2
     * @author Raghav S
     * @return
     * @throws Exception
     * 
     */

    public CourseAdminPage clickCourseInformationPrefencesTab() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON COURSEINFORMATION&PREFENCES TAB");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkcourseinfoandpreferences, waitTime);
            lnkcourseinfoandpreferences.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'CourseInformation&Prefences Tab'" + "\n METHOD:clickCourseInformationPrefencesTab \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Methods determine Whether CourseInformation&Preferences Screen is Displayed
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @throws Exception
     * @return boolean
     */

    public boolean isCourseInformationPreferenceScreenDisplayed() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:Verifying Course Information Preference Displayed");
            frameSwitch.switchToFrameContent();
            return lblcourseInformationPref.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Course Enrollment tab'" + "\n METHOD:isCourseInformationPreferenceScreenDisplayed \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * @category Milestone 2 Method is used to verify Course Information & Preferences tab is
     *           selected
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isInformationAndPreferencesTabSelected() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION : VERIFY INFORMATION & PREFERENCES TAB");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnInformationAndPreferences, waitTime);
            if (btnInformationAndPreferences.getText().contains("Course Information & Preferences")) {
                flag= true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING Course Information & Preferences tab" + "\n METHOD:isInformationAndPreferencesTabSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to get the header text
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return String
     * @throws Exception
     */

    public String getHeader() throws Exception {
         strTableHeader = "";
        try {
            logInstruction("LOG INSTRUCTION:CHECKING FOR THE TABLE HEADER");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblTitle, waitTime);
            strTableHeader = lblTitle.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE  'table header'" + "\n METHOD:getHeader \n" + e
                            .getLocalizedMessage());
        }
        return strTableHeader;
    }

    /**
     * This method is used to click on Course Scheduler
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminPage
     * @throws Exception
     */
    public CourseAdminPage clickCourseCopyContent() throws Exception {

        logInstruction("LOG INSTRUCTION: CLICK ON COURSE COPY CONTENT");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(coursescheduler, waitTime);
            coursescheduler.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'style manager' " + "\n METHOD:clickCourseCopyContent \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

}
