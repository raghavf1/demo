package com.pearson.eselenium.ls.coursetools.courseadmin.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.DatePickerPage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * @category-Milestone 2 Class contains all methods related to CourseAdminCourseScheduler
 * 
 * @author Raghav S
 * @param uiDriver
 */

public class CourseAdminCourseSchedulerPage extends BasePageObject {

    /* UI element declarations for CourseAdminCourseScheduler */
    private UIElement lnkcourseschedluer = createElement(UIType.LinkText, "Course Scheduler");
    private UIElement lnkschedulefile = createElement(UIType.LinkText, "Schedule Files");
    private UIElement lnkpathbuilder = createElement(UIType.LinkText, "Path Builder");
    private UIElement btnsave = createElement(UIType.Css, "input[value='Save Changes']");
    private UIElement btncancel = createElement(UIType.Css, "input[value='Cancel']");
    private UIElement radcoursehomeorassignspecific = createElement(
            UIType.Xpath,
            "//tr[td[contains(text(),'{1}')]]//td[label[contains(text(),'{2}')]]/preceding-sibling::td/input");
    private UIElement btnrestrictaccessbeforeorafter = createElement(
            UIType.Xpath,
            "//tr[td[contains(text(),'{1}')]]//td[label[contains(text(),'{2}')]]/preceding-sibling::td/input[1]");
    private UIElement txtEndDate = createElement(
            UIType.Xpath,
            "//tr[td[contains(.,'{1}')]]//td[4]//input[contains(@aria-label,'Enter End Date')]");
    private UIElement txtStartDate = createElement(
            UIType.Xpath,
            "//tr[td[contains(.,'{1}')]]//td[3]//input[contains(@aria-label,'Enter Start Date')]");
    private UIElement txtDueDate = createElement(
            UIType.Xpath,
            "//tr[td[contains(.,'{1}')]]//td[5]//input[contains(@aria-label,'Due Date')]");
    private UIElement txtGradebookDate = createElement(
            UIType.Xpath,
            "//tr[td[contains(.,'{1}')]]//td[3]//input[contains(@aria-label,'Grade')]");
    private UIElement radAssignSpecificStartDate = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//td[input[contains(@aria-label,'Assign')]]");
    private UIElement drpStartTime = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//select[contains(@aria-label,'Select Start Date')]");
    private UIElement drpEndTime = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//select[contains(@aria-label,'Select End Date')]");
    private UIElement drpDueTime = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//select[contains(@aria-label,'Select Due Date')]");
    private UIElement drpGradebookTime = createElement(
            UIType.Xpath,
            "/form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//select[contains(@aria-label,'Select Gradebook Review Start Date')]");
    private UIElement imgStartDatePicker = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//td//a[img[contains(@alt,'Pick Start Date')]]");
    private UIElement imgEndDatePicker = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//td//a[img[contains(@alt,'Pick End Date')]]");
    private UIElement imgDueDatePicker = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//td//a[img[contains(@alt,'Pick Due Date')]]");
    private UIElement unitSelected = createElement(UIType.Xpath, "//td[contains(text(),'{1}')]");
    private UIElement lblInstructional = createElement(
            UIType.Xpath,
            "//td[contains(@class,'inlinemessage2')]");
    private UIElement radUseCourseStartEndDate = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//td[input[contains(@aria-label,'Assign')]]");
    private UIElement lblUseCourseStartEndDate = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//td[input[contains(@aria-label,'Assign')]]");
    private UIElement radAssignSpecificStartEndDate = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//td[input[contains(@aria-label,'Assign')]]");
    private UIElement lblAssignSpecificStartEndDate = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//td[input[contains(@aria-label,'Assign')]]");
    private UIElement lblTimeZoneInfo = createElement(
            UIType.Xpath,
            "//td[contains(@class,'dkgraytext')]");
    private UIElement lblheaderTitle = createElement(UIType.Xpath, "//h1//div[@class='pageTitle']");
    private UIElement txtinlineerrorMsg = createElement(
            UIType.Xpath,
            "//td[@class='inlineerror']//tbody//tr//td[2]");
    private UIElement txtcourseHomeTextWithintable = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[1]/td[contains(.,'Course Home')]");
    private UIElement txtTableHeading = createElement(
            UIType.Xpath,
            "//div[@class='tableheadtabs']//li[contains(.,'{1}')]");
    private UIElement lblmainTabs = createElement(
            UIType.Xpath,
            "//div[@id='contentMenu']//a[contains(.,'{1}')]");
    private UIElement radUseCourseHomeStartEndDate = createElement(
            UIType.Xpath,
            "//tr[td[contains(text(),'{1}')]]//table//tr//td[input[contains(@aria-label,'Use')]]");
    private UIElement txtItemUnit = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']//table//tr/td[contains(text(),'{1}')]");
    private UIElement msgNoItems = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']//table//tr/td[contains(text(),'No items')]");
    private UIElements lbldates = createElements(UIType.Xpath, "#Calendar1>tbody>tr>td>a");
    private UIElement chkclickrestrictaccessbeforeorafter = createElement(
            UIType.Xpath,
            "//tr[td[contains(text(),'{1}')]]//td[label[contains(text(),'{2}')]]/preceding-sibling::td/input[1]");
    private UIElement btnclicksave = createElement(UIType.Xpath, "//input[@value='Save Changes']");
    private UIElement btnclickcancel = createElement(UIType.Css, "input[value='Cancel']");

    private UIElement lblTimeZoneInstructionalText = createElement(UIType.Css, ".dkgraytext");
    private UIElement tblHeaderAllignment = createElement(
            UIType.Xpath,
            "//tr[th[contains(.,'{1}')]]");
    private UIElement lblUseSpecificRadioButton = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//td[label[contains(text(),'Assign')]]");
    private UIElement lblUseCourseHomeRadioButton = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//td[label[contains(text(),'Use')]]");
    private UIElement lblRestrictAccessBefore = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//td[label[contains(text(),'before')]]");
    private UIElement lblRestrictAccessAfter = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']/table/tbody/tr[td[contains(.,'{1}')]]//td[label[contains(text(),'after')]]");

    private UIElement noItems = createElement(
            UIType.Xpath,
            "//form[@id='frmCourseScheduleView']//table//tr[td[contains(.,'{1}')]]/following-sibling::tr[1]/td[contains(.,'No items')]");

    private UIElement txtTableHeader = createElement(
            UIType.Xpath,
            "//*[@id='mainTable']//table[@role='presentation']//tr[th[contains(.,'{1}')]]");
    private UIElement txtDateAssignmentData = createElement(
            UIType.Xpath,
            "//*[@id='frmCourseScheduleView']//table//tr/td[label[contains(.,'{1}')]]");
    
    /* Variables */
    private String strAlertMessage=null;
    private String strEndDate=null;
    private String strStartDate=null;
    private String strDueDate=null;
    private String strStartTime=null;
    private String strInstructionalText=null;
    private String strGradeBookDate=null;
    private String strContent=null ;
    private String strTimeZone=null;
    private String strErrorMessage=null;
    private String strTitle=null;
    private String strBeforeDate=null;
    String caption;
    private  boolean flag = false;
    Date date1hrAhead = null;
    Date date2hrBefore = null;
    static Date date = new Date();
    SimpleDateFormat sdfwithDate = new SimpleDateFormat("M/d/yyyy h:mm a");
    static SimpleDateFormat sdfwithTime = new SimpleDateFormat("h:mm a");
    private static String formattedtime = sdfwithTime.format(date);
    Calendar calendar = Calendar.getInstance();
    Date dateAfter = new Date();
    Date reviewdate = new Date();
    List<WebElement> options;
    String dateTime=null;
    String currentTime=null;
    List<String> windows;

    /* Constructor */
    public CourseAdminCourseSchedulerPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("## CourseAdminCourseScheduler ##");

    }

    
    /**
     * This method is used to click on Schedule File Tab
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminCourseScheduler
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage clickScheduleFileTab() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON SCHEDULE FILE TAB");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkschedulefile, waitTime);
            lnkschedulefile.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'schedulattab'" + "\n METHOD:clickScheduleFileTab \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click on the Path Builder Tab
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminCourseScheduler
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage clickPathBuilderTab() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON PATH BUILDER TAB");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkpathbuilder, waitTime);
            lnkpathbuilder.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'clickPathBuilderTab'" + "\n METHOD:clickPathBuilderTab \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click on the Course Schedluer Tab
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminCourseScheduler
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage clickCourseSchedulerTab() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON COURSE SCHEDLUER TAB");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkcourseschedluer, waitTime);
            lnkcourseschedluer.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'CourseSchedulerTab'" + "\n METHOD:clickCourseSchedulerTab \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click on the Save Button
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminCourseScheduler
     * @throws Exception
     */

    public CourseAdminCourseSchedulerPage clickOnSaveChangesButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON SAVE CHANGES BUTTON");
            frameSwitch.switchToCourseSchedularTopFrame();
            uiDriver.waitToBeDisplayed(btnsave, waitTime);
            btnsave.clickNoWait();
            uiDriver.sleep(4000);
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'saveChanges'" + "\n METHOD:clickOnSaveChangesBtn \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click on cancel button
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminCourseScheduler
     * @throws Exception
     */

    public CourseAdminPage clickOnCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON CANCEL BUTTON");
            frameSwitch.switchToCourseSchedularTopFrame();
            uiDriver.waitToBeDisplayed(btncancel, waitTime);
            btncancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'cancelbutton" + "\n METHOD clickOnCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminPage(uiDriver);
    }

    /**
     * This method is used to click Use Course Home/Assign specific Start/end radio
     * 
     * @category Milestone 2
     * @param Content
     *            - Content type date Assignment -Use Course Home start/end or Assign specific
     *            start/end
     * @author Raghav
     * @return CourseAdminCourseScheduler
     * @throws Exception
     */

    public CourseAdminCourseSchedulerPage clickCourseHomeorAssignSpecificRadiobtn(
            String Content,
            String dateAssignment) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON COURSEHOMEORASSIGNSPECIFICRADIOBTN");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radcoursehomeorassignspecific.replaceValues(Content, dateAssignment);
            uiDriver.waitToBeDisplayed(radcoursehomeorassignspecific, waitTime);
            radcoursehomeorassignspecific.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON CourseHomeorAssignSpecificRadiobtn" + "\n METHOD :clickCourseHomeorAssignSpecificRadiobtn \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click Use clickrestrictaccessbeforeorafter checkbox
     * 
     * @category Milestone 2
     * @param Content
     *            - Content type restrictaccessafterorbefore -Use Restrict access before or Restrict
     *            access after
     * @author Raghav
     * @return CourseAdminCourseScheduler
     * @throws Exception
     */

    public CourseAdminCourseSchedulerPage clickRestrictAccessBeforeorAfter(
            String Content,
            String restrictaccessafterorbefore) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON CLICKRESTRICTACCESSBEFOREORAFTER BUTTON");
            frameSwitch.switchToCourseSchedularBottomFrame();
            btnrestrictaccessbeforeorafter.replaceValues(Content, restrictaccessafterorbefore);
            uiDriver.waitToBeDisplayed(btnrestrictaccessbeforeorafter, waitTime);
            btnrestrictaccessbeforeorafter.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON onCourseHomeorAssignSpecificRadiobtn" + "\n METHOD:clickRestrictAccessBeforeorAfter \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to verify the save changse btn is present
     * 
     * @author kiran
     * @return boolean
     * @throws Exception
     */
    public boolean isSaveButtonPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFY THE SAVE CHANGES BUTTON");
            frameSwitch.switchToCourseSchedularTopFrame();
            return btnsave.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'save changes button'" + "\n METHOD :isSaveButtonPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Method helps to enter the end date
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage enterEndDate(String itemName, String date)
            throws Exception {
        try {
            logInstruction("ENTER END DATE");
            frameSwitch.switchToCourseSchedularBottomFrame();

            txtEndDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtEndDate.clearAndSendKeys(date);

            logInstruction("ENDDATE IS ENTERED");
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER THE END DATE" + e.getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps to enter the start date
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage enterStartDate(String itemName, String date)
            throws Exception {

        try {
            logInstruction("LOGINSTRUCTION:ENTER START DATE");
            frameSwitch.switchToCourseSchedularBottomFrame();

            txtStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(txtStartDate, waitTime);
            txtStartDate.clearAndSendKeys(date);
            // uiDriver.sendKeysToBrowser(Keys.TAB);

            logInstruction("StartDate is entered");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE ON ENTERING THE ' start date'" + "\n METHOD:enterStartDate \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps to enter the start date
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage enterDueDate(String itemName, String date)
            throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:ENTER DUE DATE");
            frameSwitch.switchToCourseSchedularBottomFrame();

            txtDueDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(txtDueDate, waitTime);
            txtDueDate.clearAndSendKeys(date);
            logInstruction("LOGINSTRUCTION:DUEDATE IS ENTERED");
        } catch (Exception e) {
            throw new Exception("ISSUE IN ENTERING ' due date'" + "\n METHOD:enterDueDate \n" + e
                    .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps to get the invalidAlert message
     * 
     * @author ganapati.bhat
     * @param  date
     * @return String
     * @throws Exception
     */
    public String getInvalidDateAlertMessage() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:GET ALERT MESSAGE");
            strAlertMessage = uiDriver.getUIAlert().getAlertMessage();
            uiDriver.getUIAlert().acceptAlertIfPresent();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'Alert message'" + "\n METHOD:getInvalidDateAlertMessage \n" + e
                            .getLocalizedMessage());
        }
        return strAlertMessage;

    }

    /**
     * Method helps to get the End Date
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public String getEndDate(String itemName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:GET END DATE");
            frameSwitch.switchToCourseSchedularBottomFrame();
            txtEndDate.replaceValues(itemName);
            strEndDate = txtEndDate.getAttribute("value");

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE  'end date'" + "\n METHOD :getEndDate \n" + e
                    .getLocalizedMessage());
        }
        return strEndDate;

    }

    /**
     * Method helps to get the start Date
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return String
     * @throws Exception
     */
    public String getStartDate(String itemName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:GET START DATE");
            frameSwitch.switchToCourseSchedularBottomFrame();
            txtStartDate.replaceValues(itemName);
            strStartDate = txtStartDate.getAttribute("value");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE  'startdate'" + "\n METHOD :getStartDate \n" + e
                            .getLocalizedMessage());
        }
        return strStartDate;

    }

    /**
     * Method helps to get the due Date
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return String
     * @throws Exception
     */
    public String getDueDate(String itemName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:GET DUE DATE");
            frameSwitch.switchToCourseSchedularBottomFrame();        
            txtDueDate.replaceValues(itemName);
            strDueDate = txtDueDate.getAttribute("value");
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE  'duedate'" + "\n METHOD :getDueDate \n" + e
                    .getLocalizedMessage());
        }
        return strDueDate;

    }

    /**
     * Method helps to enter gradebook date
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage enterGradeBookReviewDate(String itemName, String date)
            throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: ENTER GRADEBOOK REVIEW  DATE");
            frameSwitch.switchToCourseSchedularBottomFrame();
            txtGradebookDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(txtGradebookDate, waitTime);
            txtGradebookDate.clearAndSendKeys(date);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING 'enter gradebook date'" + "\n METHOD:enterGradeBookReviewDate \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps to get gradebook date
     * 
     * @author ganapati.bhat
     * @param  itemName
     * @param  date
     * @return String
     * @throws Exception
     */
    public String getGradeBookReviewDate(String itemName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:ENTER GRADEBOOK REVIEW  DATE");
            frameSwitch.switchToCourseSchedularBottomFrame();
            txtGradebookDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(txtGradebookDate, waitTime);
            strGradeBookDate = txtGradebookDate.getAttribute("value");

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING ' gradebook date'" + "\n METHOD:getGradeBookReviewDate \n" + e
                            .getLocalizedMessage());
        }
        return strGradeBookDate;

    }

    /**
     * select the gradebook time
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage setGradeBookReviewTime(String itemName, String time)
            throws Exception {

        try {
            logInstruction("LOGINSTRUCTION:SELECT GRADEBOOK TIME");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            drpGradebookTime.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(drpGradebookTime, waitTime);
            drpGradebookTime.selectByVisibleText(time);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SETTING  'gradebook time'" + "\n METHOD:setGradeBookReviewTime \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * select the start time
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage setStartTime(String itemName, String time)
            throws Exception {

        try {
            logInstruction("LOGINSTRUCTION:SELECT START TIME");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            drpStartTime.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(drpStartTime, waitTime);
            drpStartTime.selectByVisibleText(time);

        } catch (Exception e) {
            throw new Exception("ISSUE IN SETTING 'start time'" + "\n METHOD:setStartTime \n" + e
                    .getLocalizedMessage());
        }
        return this;

    }

    /**
     * select the end time
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage setEndTime(String itemName, String time) throws Exception {

        try {
            logInstruction("LOGINSTRUCTION:SELECT END TIME");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            drpEndTime.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(drpEndTime, waitTime);
            drpEndTime.selectByVisibleText(time);

        } catch (Exception e) {
            throw new Exception("ISSUE IN SETTING 'end time'" + "\n METHOD:setEndTime \n" + e
                    .getLocalizedMessage());
        }
        return this;

    }

    /**
     * select the due time
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage setDueTime(String itemName, String time) throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: SELECT DUE TIME");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            drpDueTime.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(drpDueTime, waitTime);
            drpDueTime.selectByVisibleText(time);

        } catch (Exception e) {
            throw new Exception("ISSUE IN SETTING ' due time'" + "\n METHOD:setDueTime" + e
                    .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps to check whether the start date text box displayed
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public boolean isStartDateTextBoxDisplayed(String itemName) throws Exception {
       
        try {
            logInstruction("LOGINSTRUCTION: VERIFYING IS START DATE TEXT BOX DISPLAYED");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            txtStartDate.replaceValues(itemName);
            flag = txtStartDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'startdate textbox'" + "\n METHOD:isStartDateTextBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to check whether the end date text box displayed
     * 
     * @author ganapati.bhat
     * @param  itemName
     * @param  date
     * @return boolean
     * @throws Exception
     */
    public boolean isEndDateTextBoxDisplayed(String itemName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: VERIFYING IS END DATE TEXT BOX DISPLAYED?");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            txtEndDate.replaceValues(itemName);
            flag = txtEndDate.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'end date text box'" + "\n METHOD:isEndDateTextBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to check whether the due date text box displayed
     * 
     * @author ganapati.bhat
     * @param  itemName
     * @param  date
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateTextBoxDisplayed(String itemName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: VERIFYING IS DUE DATE TEXT BOX DISPLAYED?");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            txtDueDate.replaceValues(itemName);
            flag = txtDueDate.isDisplayed();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'duedatetxtbox'" + "\n METHOD:isDueDateTextBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to check whether the start date picker displayed
     * 
     * @author ganapati.bhat
     * @param  itemName
     * @param  date
     * @return boolean
     * @throws Exception
     */
    public boolean isStartDatePickerDisplayed(String itemName) throws Exception {
 
        try {
            logInstruction("LOGINSTRUCTION: VERIFYING IS START DATE PICKER DISPLAYED?");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            imgStartDatePicker.replaceValues(itemName);
            flag = imgStartDatePicker.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'start date picker'" + "\n METHOD:isStartDatePickerDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to check whether the End date picker displayed
     * 
     * @author ganapati.bhat
     * @param  itemName
     * @param  date
     * @return boolean
     * @throws Exception
     */
    public boolean isEndDatePickerDisplayed(String itemName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:VERIFYING IS END DATE PICKER DISPLAYED?");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            imgEndDatePicker.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(imgEndDatePicker, waitTime);
            flag = imgEndDatePicker.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'end date picker'" + "\n METHOD:isEndDatePickerDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to check whether the due date picker displayed
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public boolean isDueDatePickerDisplayed(String itemName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:VERIFYING IS DUE DATE PICKER DISPLAYED?");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            imgDueDatePicker.replaceValues(itemName);
            flag = imgDueDatePicker.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'due date picker'" + "\n METHOD:isDueDatePickerDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to check whether the start time dropdown displayed
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public boolean isStartTimeDropdownListDisplayed(String itemName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: IS START TIME DROPDOWN DISPLAYED?");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            drpStartTime.replaceValues(itemName);

            flag = drpStartTime.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'start time dropdown' " + "\n METHOD:isStartTimeDropdownListDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to check whether the end time dropdown displayed
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public boolean isEndTimeDropdownListDisplayed(String itemName) throws Exception {

        try {
            logInstruction("LOGINSTRUCTION:VERIFYING IS END TIME DROPDOWN DISPLAYED?");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            drpEndTime.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(drpEndTime, waitTime);
            flag = drpEndTime.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'end time dropdown'" + "\n METHOD:isEndTimeDropdownListDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to check whether the due time dropdown displayed
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public boolean isDueTimeDropdownListDisplayed(String itemName) throws Exception {
       
        try {
            logInstruction("LOGINSTRUCTION:VERIFYING IS DUE TIME DROPDOWN DISPLAYED?");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            drpDueTime.replaceValues(itemName);
            flag = drpDueTime.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'due time dropdown'" + "\n METHOD:isDueTimeDropdownListDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to get the due time value
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return String
     * @throws Exception
     */
    public String getDueTimeDropdownValue(String itemName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:GET DUE TIME DROPDOWN VALUE");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            drpDueTime.replaceValues(itemName);
            options = drpDueTime.findElements(By.tagName("option"));
            for (WebElement option : options) {
                if (option.isSelected()) {
                	strDueDate = option.getText().trim();
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'due time dropdown value'" + "\n METHOD:getDueTimeDropdownValue \n" + e
                            .getLocalizedMessage());
        }
        return strDueDate;

    }

    /**
     * Method helps to get the end time value
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public String getEndTimeDropdownValue(String itemName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: GET END TIME DROPDOWN VALUE");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            drpEndTime.replaceValues(itemName);
            options = drpEndTime.findElements(By.tagName("option"));
            for (WebElement option : options) {
                if (option.isSelected()) {
                	strEndDate = option.getText().trim();
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING'end date dropdown value'" + "\n METHOD:getEndTimeDropdownValue \n" + e
                            .getLocalizedMessage());
        }
        return strEndDate;

    }

    /**
     * Method helps to get the start time value
     * 
     * @author ganapati.bhat
     * @param itemName
     * @param date
     * @return
     * @throws Exception
     */
    public String getStartTimeDropdownValue(String itemName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: GET START TIME DROPDOWN VALUE");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.clickAndWait(waitTime);
            drpStartTime.replaceValues(itemName);
           options = drpStartTime.findElements(By.tagName("option"));
            for (WebElement option : options) {
                if (option.isSelected()) {
                    strStartTime = option.getText().trim();
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING  'start time dropdown'" + "\n METHOD:getStartTimeDropdownValue \n" + e
                            .getLocalizedMessage());
        }
        return strStartTime;

    }

    /**
     * Method is used to verify assign specific start/end date
     * 
     * @author Pratush.Manglik
     * @param itemName
     * @return boolean
     * @throws Exception
     */
    public boolean isAssignSpecificStartAndEndDateRadioButtonSelected(String itemName)
            throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: VERIFY ASSIGN SPECIFIC START/END DATE");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            if (radAssignSpecificStartDate.isSelected()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING  assign specific start/end date" + "\n METHOD:isAssignSpecificStartAndEndDateRadioButtonSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify instructional text
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isInstructionalTextDisplayed() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: VERIFY INSTRUCTIONAL TEXT");
            frameSwitch.switchToCourseSchedularTopFrame();
            uiDriver.waitToBeDisplayed(lblInstructional, waitTime);
            if (!lblInstructional.getText().isEmpty()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING instructional text" + "\n METHOD :isInstructionalTextDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to get instructional text
     * 
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String getInstructionalText() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: GET INSTRUCTIONAL TEXT");
            frameSwitch.switchToCourseSchedularTopFrame();
            uiDriver.waitToBeDisplayed(lblInstructional, waitTime);
            strInstructionalText = lblInstructional.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING  instructional text" + "\n METHOD:getInstructionalText \n" + e
                            .getLocalizedMessage());
        }
        return strInstructionalText;
    }

    /**
     * Method is used to verify unit within table
     * 
     * @author Pratush.Manglik
     * @param unitName
     * @return boolean
     * @throws Exception
     */
    public boolean isUnitDisplayedWithinTable(String unitName) throws Exception {   
        try {
            logInstruction("LOGINSTRUCTION: VERIFY UNIT WITHIN TABLE");
            frameSwitch.switchToCourseSchedularBottomFrame();
            unitSelected.replaceValues(unitName);
            uiDriver.waitToBeDisplayed(unitSelected, waitTime);
            if (!unitSelected.getText().isEmpty()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIDYING  unit within table" + "\n METHOD:isUnitDisplayedWithinTable \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify restrict access before check box
     * 
     * @author Pratush.Manglik
     * @param content
     * @return boolean
     * @throws Exception
     */
    public boolean isRestrictAccessBeforeCheckboxDisplayed(String content) throws Exception {
    	strContent  = "Restrict access before";
        try {
            logInstruction("LOGINSTRUCTION: VERIFY RESTRICT ACCESS BEFORE CHECK BOX");
            frameSwitch.switchToCourseSchedularBottomFrame();
            chkclickrestrictaccessbeforeorafter.replaceValues(content, strContent);
            uiDriver.waitToBeDisplayed(chkclickrestrictaccessbeforeorafter, waitTime);
            flag = chkclickrestrictaccessbeforeorafter.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING restrict access before check box" + "\n METHOD:isRestrictAccessBeforeCheckboxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify caption of restrict access before check box
     * 
     * @author Pratush.Manglik
     * @param content
     * @return boolean
     * @throws Exception
     */
    public boolean isCaptionOfRestrictAccessBeforeCheckboxDisplayed(String content)
            throws Exception {
       
        strContent = "Restrict access before";
        try {
            logInstruction("LOGINSTRUCTION: VERIFY RESTRICT ACCESS BEFORE CHECK BOX");
            frameSwitch.switchToCourseSchedularBottomFrame();
            chkclickrestrictaccessbeforeorafter.replaceValues(content, strContent);
            uiDriver.waitToBeDisplayed(chkclickrestrictaccessbeforeorafter, waitTime);
            if (!chkclickrestrictaccessbeforeorafter.getText().isEmpty()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING  restrict access before check box" + "\n METHOD:isCaptionOfRestrictAccessBeforeCheckboxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify restrict access after check box
     * 
     * @author Pratush.Manglik
     * @param content
     * @return boolean
     * @throws Exception
     */
    public boolean isRestrictAccessAfterCheckboxDisplayed(String content) throws Exception {
        strContent = "Restrict access after";
        try {
            logInstruction("LOGINSTRUCTION: VERIFY RESTRICT ACCESS AFTER CHECK BOX");
            frameSwitch.switchToCourseSchedularBottomFrame();
            chkclickrestrictaccessbeforeorafter.replaceValues(content, strContent);
            uiDriver.waitToBeDisplayed(chkclickrestrictaccessbeforeorafter, waitTime);
            flag = chkclickrestrictaccessbeforeorafter.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING  restrict access after check box" + "\n METHOD:isRestrictAccessAfterCheckboxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify caption of restrict access after check box
     * 
     * @author Pratush.Manglik
     * @param content
     * @return boolean
     * @throws Exception
     */
    public boolean isCaptionOfRestrictAccessAfterCheckboxDisplayed(String content) throws Exception {
         strContent = "Restrict access after";
        try {
            logInstruction("LOGINSTRUCTION: VERIFY RESTRICT ACCESS AFTER CHECK BOX");
            frameSwitch.switchToCourseSchedularBottomFrame();
            chkclickrestrictaccessbeforeorafter.replaceValues(content, strContent);
            uiDriver.waitToBeDisplayed(chkclickrestrictaccessbeforeorafter, waitTime);
            if (!chkclickrestrictaccessbeforeorafter.getText().isEmpty()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING ' restrict access after check box'" + "\n METHOD:isCaptionOfRestrictAccessAfterCheckboxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to Verify Alert Message After entering invalid date
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isAllertMessageDisplayedAfterEnteringInvalidDate() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: VERIFY ALERT MESSAGE AFTER ENTERING INVALID DATE");
            strAlertMessage = uiDriver.getUIAlert().getAlertMessage();
            if (!strAlertMessage.isEmpty()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING Alert Message After entering invalid date" + "\n METHOD:isAllertMessageDisplayedAfterEnteringInvalidDate \n " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify cancel button.
     * 
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCancleButtonPresent() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:VERIFY THE CANCEL BUTTON");
            frameSwitch.switchToCourseSchedularTopFrame();
            if (btnclickcancel.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE cancel btn" + "\n METHOD:isCancleButtonPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify restrict access before or after is selected.
     * 
     * @param Content
     * @param restrictaccessafterorbefore
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isRestrictAccessBeforeOrAfterSelected(
            String Content,
            String restrictaccessafterorbefore) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: VERIFY RESTRICTACCESSBEFOREORAFTER IS SELECTED");
            frameSwitch.switchToCourseSchedularBottomFrame();
            chkclickrestrictaccessbeforeorafter.replaceValues(Content, restrictaccessafterorbefore);
            uiDriver.waitToBeDisplayed(chkclickrestrictaccessbeforeorafter, waitTime);
            if (chkclickrestrictaccessbeforeorafter.isSelected()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING restrictaccessbeforeorafter is selected" + "\n METHOD:isRestrictAccessBeforeOrAfterSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify Use Course Start/End Date Radio Button is selected
     * 
     * @param Content
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isUseCourseStartEndDateRadioButtonSelected(String Content) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: VERIFY USE COURSE START/END DATE RADIO BUTTON IS SELECTED");
            frameSwitch.switchToFrameContent();
            radUseCourseStartEndDate.replaceValues(Content);
            uiDriver.waitToBeDisplayed(radUseCourseStartEndDate, waitTime);
            if (radUseCourseStartEndDate.isSelected()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING  Use Course Start/End Date Radio Button is selected" + "\n METHOD:isUseCourseStartEndDateRadioButtonSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click Use Course Start/End Date Radio Button.
     * 
     * @param Content
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean clickUseCourseStartEndDateRadioButtonSelected(String Content) throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: CLICK USE COURSE START/END DATE RADIO BUTTON IS SELECTED");
            frameSwitch.switchToFrameContent();
            radUseCourseStartEndDate.replaceValues(Content);
            uiDriver.waitToBeDisplayed(radUseCourseStartEndDate, waitTime);
            radUseCourseStartEndDate.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON  Course Start/End Date Radio Button is selected" + "\n METHOD:clickUseCourseStartEndDateRadioButtonSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify assign specific Start/End Date Radio Button is displayed.
     * 
     * @param Content
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isAssignSecificStartEndDateRadioButtonDisplayed(String Content) throws Exception {   
        try {
            logInstruction("LOGINSTRUCTION: VERIFY ASSIGN SPECIFIC START/END DATE RADIO BUTTON IS DISPLAYED");
            frameSwitch.switchToFrameContent();
            radAssignSpecificStartEndDate.replaceValues(Content);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartEndDate, waitTime);
            if (radAssignSpecificStartEndDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING assign specific Start/End Date Radio Button is displayed" + "\n METHOD:isAssignSecificStartEndDateRadioButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify the caption of Use Course Start/End Date Radio Button is displayed.
     * 
     * @param Content
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCaptionOfUseCourseStartEndDateRadioButtonDisplayed(String Content)
            throws Exception {
       
        try {
            logInstruction("LOGINSTRUCTION: VERIFY CAPTION OF USE COURSE START/END DATE RADIO BUTTON IS DISPLAYED");
            frameSwitch.switchToNewWindowBottomFrame();
            lblUseCourseStartEndDate.replaceValues(Content);
            uiDriver.waitToBeDisplayed(lblUseCourseStartEndDate, waitTime);
            String caption = lblUseCourseStartEndDate.getText();
            if (!caption.isEmpty()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING caption Use Course Start/End Date Radio Button is displayed" + "\n METHOD:isCaptionOfUseCourseStartEndDateRadioButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify the caption of assign specific Start/End Date Radio Button is
     * displayed.
     * 
     * @param Content
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCaptionOfAssignSpecificStartEndDateRadioButtonDisplayed(String Content)
            throws Exception {
       
        try {
            logInstruction("LOGINSTRUCTION: VERIFY CAPTION OF ASSIGN SPECIFIC START/END DATE RADIO BUTTON IS DISPLAYED");
            frameSwitch.switchToNewWindowBottomFrame();
            lblAssignSpecificStartEndDate.replaceValues(Content);
            uiDriver.waitToBeDisplayed(lblAssignSpecificStartEndDate, waitTime);
            caption = lblAssignSpecificStartEndDate.getText();
            if (!caption.isEmpty()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUEIN VERIFYING  caption assign specific Start/End Date Radio Button is displayed" + "\n METHOD:isCaptionOfAssignSpecificStartEndDateRadioButtonDisplayed \n " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get time zone information.
     * 
     * @return String
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getTimeZoneInformation() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: GET TIME ZONE INFORMATION");
            frameSwitch.switchToCourseSchedularTopFrame();
            uiDriver.waitToBeDisplayed(lblTimeZoneInfo, waitTime);
            if (lblTimeZoneInfo.isDisplayedAfterWaiting(waitTime)) {

                strTimeZone = lblTimeZoneInfo.getText().trim();

            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE time zone information" + "\n METHOD:isCaptionOfAssignSpecificStartEndDateRadioButtonDisplayed:" + e
                            .getLocalizedMessage());
        }
        return strTimeZone;

    }

    /**
     * Method helps to press enter key.
     * 
     * @return CourseAdminCourseSchedulerPage
     * @throws Exception
     * @author saurabh.jain1
     */
    public CourseAdminCourseSchedulerPage pressEnterKey() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: PRESS ENTER KEY");
            frameSwitch.switchToCourseSchedularTopFrame();
            uiDriver.switchTo().activeElement().sendKeys(Keys.ENTER);
        } catch (Exception e) {
            throw new Exception("ISSUE IN PRESSING enter key" + "\n METHOD:pressEnterKey \n" + e
                    .getLocalizedMessage());
        }

        return this;
    }

    /**
     * @author Usha , Method helps to get header title
     * @category-Milestone 2
     * @return String
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: GETTING HEADER TITLE");
            frameSwitch.switchToCourseSchedularTopFrame();
            uiDriver.waitToBeDisplayed(lblheaderTitle, waitTime);
            strTitle = lblheaderTitle.getText();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING  header title" + "\n METHOD:getHeaderTitle \n" + e
                            .getLocalizedMessage());
        }

        return strTitle;
    }

    /**
     * Method helps to verify table heading.
     * 
     * @category-Milestone 2
     * @param Course
     *            Scheduler/ Schedule Files
     * @return  boolean
     * @throws Exception
     * @author Usha
     */
    public boolean isTableHeadingDisplayed(String tableHeaderName) throws Exception {
       
        try {
            logInstruction("LOGINSTRUCTION: VERIFY TABLE HEADING");
            frameSwitch.switchToCourseSchedularTopFrame();
            txtTableHeading.replaceValues(tableHeaderName);
            uiDriver.waitToBeDisplayed(txtTableHeading, waitTime);
            if (txtTableHeading.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING  table heading" + "\n METHOD:isTableHeadingDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify whether main tabs are selected or not
     * 
     * @category-Milestone 2
     * @param Course
     *            Information & Preferences/Course Enrollment/ Group Management
     * @return
     * @throws Exception
     * @author Usha
     */
    public boolean isTabSelected(String TabName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:  VERIFY WHETHER TAB SELECTED OR NOT");
            frameSwitch.switchToCourseSchedularTopFrame();
            lblmainTabs.replaceValues(TabName);
            uiDriver.waitToBeDisplayed(lblmainTabs, waitTime);
            strTitle = lblmainTabs.getAttribute("class");
            if (strTitle.contains("ON"))
                flag = true;
        } catch (Exception e) {
            throw new Exception("ISSUE IN VERIFYING THE  tab" + "\n METHOD:isTabSelected \n" + e
                    .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @author Usha , Method helps to get inline Error message
     * @category-Milestone 2
     * @return String
     * @throws Exception
     */
    public String getInlineErrorMessage() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: GETTING INLINE ERROR MESSAGE");
            frameSwitch.switchToCourseSchedularTopFrame();
            uiDriver.waitToBeDisplayed(txtinlineerrorMsg, waitTime);
            strErrorMessage = txtinlineerrorMsg.getText();
        } catch (Exception e) {

            throw new Exception(
                    "ISSUE IN GETTING THE inline Error message" + "\n METHOD:getInlineErrorMessage \n" + e
                            .getLocalizedMessage());
        }

        return strErrorMessage;
    }

    /**
     * Method helps to verify CourseHome text displayed within table
     * 
     * @category-Milestone 2
     * @return
     * @throws Exception
     * @author Usha
     */
    public boolean isCourseHomeTitleDisplayedWithinTable() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: VERIFY WHETHER COURSEHOME TEXT DISPLAYED WITHIN TABLE");
            frameSwitch.switchToCourseSchedularBottomFrame();
            return txtcourseHomeTextWithintable.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING  CourseHome text within table" + "\n METHOD:isCourseHomeTitleDisplayedWithinTable \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Method helps to verify UseCourseStartEnd RadioButton Displayed for particular item/unit
     * @return boolean
     * @category-Milestone 2
     * @param item
     *            /Unit text
     * @throws Exception
     * @author Usha
     */
    public boolean isUseCourseStartEndRadioButtonDisplayed(String itemUnitText) throws Exception {
        
        try {
            logInstruction("LOGINSTRUCTION: VERIFY USECOURSESTARTEND RADIOBUTTON DISPLAYED FOR PARTICULAR ITEM/UNIT");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radUseCourseHomeStartEndDate.replaceValues(itemUnitText);
            uiDriver.waitToBeDisplayed(radUseCourseHomeStartEndDate, waitTime);
            if (radUseCourseHomeStartEndDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE UseCourseStartEnd RadioButton Displayed for particular item/unit" + "\n METHOD:isUseCourseStartEndRadioButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify AssignspecificStartEnd RadioButton Displayed for particular item/unit
     * 
     * @category-Milestone 2
     * @param item
     *            /Unit text
     * @throws Exception
     * @author Usha
     */
    public boolean isAssignspecificStartEndRadioButtonDisplayed(String itemUnitText)
            throws Exception {
        
        try {
            logInstruction("LOGINSTRUCTION: VERIFY ASSIGNSPECIFICSTARTEND RADIOBUTTON DISPLAYED FOR PARTICULAR ITEM/UNIT");
            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemUnitText);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            if (radAssignSpecificStartDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'CourseHome text within table'" + "\n METHOD:isAssignspecificStartEndRadioButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify Particular item/unit displayed in Course scheduler
     * 
     * @category-Milestone 2
     * @param item
     *            /Unit text
     * @throws Exception
     * @author Usha
     */
    public boolean isItemORUnitDisplayed(String itemUnitText) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: VERIFY ITEM/UNIT DISPLAYED IN COURSE SCHEDULER");
            frameSwitch.switchToCourseSchedularBottomFrame();
            txtItemUnit.replaceValues(itemUnitText);
            return txtItemUnit.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING  item/unit" + "\n METHOD:isItemORUnitDisplayed \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Method helps to verify No-items message displayed in table
     * 
     * @category-Milestone 2
     * @param
     * @throws Exception
     * @author Usha
     */
    public boolean isNoItemsMessageDisplayed() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: VERIFY NO-ITEMS MESSAGE DISPLAYED IN TABLE");
            frameSwitch.switchToCourseSchedularBottomFrame();
            return msgNoItems.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING ' No-items message in table'" + "\n METHOD:isNoItemsMessageDisplayed \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Method helps to verify whether unit highlighted in Grey
     * 
     * @category-Milestone 2
     * @param
     * @throws Exception
     * @author Usha
     */
    public boolean isUnitHighlightedInGrey(String itemUnitText) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: VERIFY WHETHER UNIT HIGHLIGHTED IN GREY");
            frameSwitch.switchToCourseSchedularBottomFrame();
            txtItemUnit.replaceValues(itemUnitText);
            uiDriver.waitToBeDisplayed(txtItemUnit, waitTime);
            strTitle = txtItemUnit.getCssValue("background-color");
            if (strTitle.equalsIgnoreCase("#EEEEEE"))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING  whether unit highlighted in Grey" + "\n METHOD:isUnitHighlightedInGrey \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get the current time
     * 
     * @author ganapati.bhat
     * @return String -time
     * @throws Exception
     */
    public String getCurrentTime() throws Exception {
        try {
            String formattime[] = formattedtime.split(":");
            if (formattime[0].equals("00")) {
                formattime[0] = "12";
            }

            String formatminute[] = formattime[1].split(" ");

            int minute = Integer.parseInt(formatminute[0]);

            if (minute >= 0 & minute < 30) {
                minute = 0;

            } else {
                minute = 30;

            }
            formatminute[0] = String.valueOf(minute);
            if (formatminute[0].equals("0")) {
                formatminute[0] = "00";
            }

            strTimeZone = formattime[0] + ":" + formatminute[0] + " " + formatminute[1];

        } catch (Exception e) {
            throw new Exception("Unable to get the formatted current time " + e
                    .getLocalizedMessage());
        }

        return strTimeZone;
    }

    /**
     * Method helps to format the date and time
     * 
     * @author ganapati.bhat
     * @return date
     * @throws Exception
     */
    private Date formatDateandTime(String currentDate, String currentTime) throws Exception {
        try {
            dateTime = currentDate + " " + currentTime;
            logInstruction("LOG INSTRUCTION: date time is " + dateTime);
            try {
                date = sdfwithDate.parse(dateTime);

            } catch (ParseException e) {

                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN  FORMATTING the date and time " + "\n METHOD:formatDateandTime \n" + e
                            .getLocalizedMessage());
        }
        return date;
    }

    /**
     * Method helps to get the time ahead of current time
     * 
     * @author ganapati.bhat
     * @param currentDate
     * @param time
     * @return
     * @throws Exception
     */

    public String getTimeAheadOfCurrentTime(String currentDate, int time) throws Exception {
         formattedtime = sdfwithTime.format(date);
        try {

            currentTime = getCurrentTime();
            Date formatDate = formatDateandTime(currentDate, currentTime);
            calendar.setTime(formatDate);
            calendar.add(Calendar.HOUR, time);
            date1hrAhead = calendar.getTime();
            formattedtime = sdfwithTime.format(date1hrAhead);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE  time ahead of current time" + "\n METHOD:getTimeAheadOfCurrentTime \n" + e
                            .getLocalizedMessage());
        }
        return formattedtime;
    }

    /**
     * Method helps to get the time before the current time
     * 
     * @author ganapati.bhat
     * @param currentDate
     * @param time
     * @return
     * @throws Exception
     */
    public String getTimeBeforeTheCurrentTime(String currentDate, int time) throws Exception {
         formattedtime = sdfwithTime.format(date);
        try {

            currentTime = getCurrentTime();
            Date formatDate = formatDateandTime(currentDate, currentTime);
            calendar.setTime(formatDate);
            calendar.add(Calendar.HOUR, -time);
            date2hrBefore = calendar.getTime();
            formattedtime = sdfwithTime.format(date2hrBefore);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING  the time before current time" + "\n METHOD:getTimeBeforeTheCurrentTime \n" + e
                            .getLocalizedMessage());
        }
        return formattedtime;

    }

    /**
     * Method helps to get the current date
     * 
     * @author ganapati.bhat
     * @return String
     * @throws Exception
     */

    public String getCurrentDate() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: GET CURRENT DATE");
            Date todayDate = new Date();
            SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");
            strStartDate = sdfwithOnlyDate.format(todayDate);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE  current date" + "\n METHOD:getCurrentDate \n" + e
                            .getLocalizedMessage());
        }
        return strStartDate;
    }

    /**
     * Method helps to get future date
     * 
     * @author ganapati.bhat
     * @return
     * @throws Exception
     */

    public String getFutureDate(int Days) throws Exception {
        strDueDate = null;
        try {
            logInstruction("LOGINSTRUCTION: GET FUTURE DATE");
            Date todayDate = new Date();
            SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");
            calendar.setTime(todayDate);
            calendar.add(Calendar.DATE, Days);
            dateAfter = calendar.getTime();
            strDueDate = sdfwithOnlyDate.format(dateAfter);

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING  current date" + "\n METHOD:getFutureDate \n" + e
                    .getLocalizedMessage());
        }
        return strDueDate;
    }

    /**
     * Method helps to get past date
     * 
     * @author ganapati.bhat
     * @return String
     * @throws Exception
     */

    public String getPastDate(int Days) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: GET PAST DATE");
            Date todayDate = new Date();
            SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");
            calendar.setTime(todayDate);
            calendar.add(Calendar.DATE, -Days);
            dateAfter = calendar.getTime();
            strBeforeDate = sdfwithOnlyDate.format(dateAfter);

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING pastdate" + "\n METHOD:getPastDate \n" + e
                    .getLocalizedMessage());
        }
        return strBeforeDate;
    }

    /**
     * @category Milestone 2 Method helps to click on Save and Close button.
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public String clickSaveChangesButtonForInvalidData(String data) throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: CLICK SAVE AND CLOSE BUTTON ");
            frameSwitch.switchToCourseSchedularTopFrame();
            uiDriver.waitToBeDisplayed(btnclicksave, waitTime);
            btnclicksave.clickAndWait(waitTime);
            if (!data.equalsIgnoreCase("")) {
            	strTitle = uiDriver.getUIAlert().getAlertMessage();
                uiDriver.getUIAlert().acceptAlertIfPresent();
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLCIKING ON click save and close button" + "\n METHOD :clickSaveChangesButtonForInvalidData \n" + e
                            .getLocalizedMessage());
        }

        return strTitle;
    }

    /**
     * @category Milestone2 Method is used to Click start date calendar icon
     * @author Pratush.Manglik
     * @param itemName
     * @return DatePickerPage
     * @throws Exception
     */
    public DatePickerPage clickStartDateCalendarIcon(String itemName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK START DATE CALENDAR ICON");
            frameSwitch.switchToCourseSchedularBottomFrame();
            imgStartDatePicker.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(imgStartDatePicker, waitTime);
            imgStartDatePicker.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE ON CLICKING  start date calendar icon" + "\n METHOD:clickStartDateCalendarIcon \n" + e
                            .getLocalizedMessage());
        }
        return new DatePickerPage(uiDriver);
    }

    /**
     * @category Milestone2 Method is used to Click end date calendar icon
     * @author Pratush.Manglik
     * @param itemName
     * @return DatePickerPage
     * @return DatePickerPage
     * @throws Exception
     */
    public DatePickerPage clickEndDateCalendarIcon(String itemName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK END DATE CALENDAR ICON");
            frameSwitch.switchToCourseSchedularBottomFrame();
            imgEndDatePicker.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(imgEndDatePicker, waitTime);
            imgEndDatePicker.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE ON  CLICKING end date calendar icon" + "\n METHOD:clickEndDateCalendarIcon \n" + e
                            .getLocalizedMessage());
        }
        return new DatePickerPage(uiDriver);
    }

    /**
     * @category Milestone2 Method is used to select date
     * @author Pratush.Manglik
     * @param Date
     * @return
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage selectStartDateFromCalendar(String Date) throws Exception {
        logInstruction("LOG INSTRUCTION: SELECTING DATE");
        frameSwitch.switchToDatePickerPage();
        try {
            uiDriver.waitToBeDisplayed(lbldates.getUIElementByText(Date), waitTime);
            windows = new ArrayList<String>();
            windows.addAll(uiDriver.getWindowHandles());
            lbldates.getUIElementByText(Date).clickAndWait(waitTime);
            uiDriver.switchTo().window(windows.get(0));
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN  select date" + "\n method:selectStartDateFromCalendar \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @category Milestone2 Method is used to select date
     * @author Pratush.Manglik
     * @param Date
     * @return
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage selectEndDateFromCalendar(String Date) throws Exception {
        logInstruction("LOG INSTRUCTION: SELECT THE END DATE");
        frameSwitch.switchToDatePickerPage();
        try {
            uiDriver.waitToBeDisplayed(lbldates.getUIElementByText(Date), waitTime);
            windows = new ArrayList<String>();
            windows.addAll(uiDriver.getWindowHandles());
            lbldates.getUIElementByText(Date).clickAndWait(waitTime);
            uiDriver.switchTo().window(windows.get(0));
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELETING  'end date'" + "\n METHOD:selectEndDateFromCalendar \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @category Milestone2 Method is used to unable to GET INSTRUCTIONAL TEXT ABOUT TIMEZONE
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String getInstructionalTextAboutTimeZone() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : GET INSTRUCTIONAL TEXT ABOUT TIMEZONE");
            frameSwitch.switchToCourseSchedularTopFrame();
            uiDriver.waitToBeDisplayed(lblTimeZoneInstructionalText, waitTime);
            strTitle = lblTimeZoneInstructionalText.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET INSTRUCTIONAL TEXT ABOUT TIMEZONE" + e
                    .getLocalizedMessage());
        }
        return strTitle;
    }

    /**
     * @category Milestone2 Method is used to VERIFY TABLE HEADER IS CENTRE ALLIGNED
     * @author Pratush.Manglik
     * @param tableItem
     *            - Content/Date Assignment/Start Date/End Date/Due Date
     * @return boolean
     * @throws Exception
     */
    public boolean isTableHeaderCentreAlligned(String tableItem) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : VERIFY TABLE HEADER IS CENTRE ALLIGNED");
            frameSwitch.switchToCourseSchedularTopFrame();
            tblHeaderAllignment.replaceValues(tableItem);
            uiDriver.waitToBeDisplayed(tblHeaderAllignment, waitTime);
            strTitle = tblHeaderAllignment.getAttribute("align");
            if ((strTitle.contains("center") || strTitle.contains("middle"))) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception("TABLE HEADER IS NOT CENTRE ALLIGNED" + e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone2 Method is used to GET CAPTION OF ASSIGN SPECIFIC RADIO BUTTON
     * @author Pratush.Manglik
     * @param itemName
     * @return String
     * @throws Exception
     */
    public String getCaptionOfAssignSpecificRadioButton(String title) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : GET CAPTION OF ASSIGN SPECIFIC RADIO BUTTON");
            frameSwitch.switchToCourseSchedularBottomFrame();
            lblUseSpecificRadioButton.replaceValues(title);
            uiDriver.waitToBeDisplayed(lblUseSpecificRadioButton, waitTime);
            strTitle = lblUseSpecificRadioButton.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET CAPTION OF ASSIGN SPECIFIC RADIO BUTTON" + e
                    .getLocalizedMessage());
        }
        return strTitle;
    }

    /**
     * @category Milestone2 Method is used to GET CAPTION OF USE COURSE RADIO BUTTON
     * @author Pratush.Manglik
     * @param itemName
     * @return String
     * @throws Exception
     */
    public String getCaptionOfUseCourseRadioButton(String title) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : GET CAPTION OF USE COURSE RADIO BUTTON");
            frameSwitch.switchToCourseSchedularBottomFrame();
            lblUseCourseHomeRadioButton.replaceValues(title);
            uiDriver.waitToBeDisplayed(lblUseCourseHomeRadioButton, waitTime);
            strTitle = lblUseCourseHomeRadioButton.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET CAPTION OF USE COURSE RADIO BUTTON" + e
                    .getLocalizedMessage());
        }
        return strTitle;
    }

    /**
     * @category Milestone2 Method is used to GET CAPTION OF RESTRICT ACCESS BEFORE
     * @author Pratush.Manglik
     * @param itemName
     * @return String
     * @throws Exception
     */
    public String getCaptionRestrictBefore(String title) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : GET CAPTION OF RESTRICT ACCESS BEFORE");
            frameSwitch.switchToCourseSchedularBottomFrame();
            lblRestrictAccessBefore.replaceValues(title);
            uiDriver.waitToBeDisplayed(lblRestrictAccessBefore, waitTime);
            strTitle = lblRestrictAccessBefore.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET CAPTION OF RESTRICT ACCESS BEFORE" + e
                    .getLocalizedMessage());
        }
        return strTitle;
    }

    /**
     * @category Milestone2 Method is used to GET CAPTION OF RESTRICT ACCESS AFTER
     * @author Pratush.Manglik
     * @param itemName
     * @return String
     * @throws Exception
     */
    public String getCaptionRestrictAfter(String title) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : GET CAPTION OF RESTRICT ACCESS AFTER");
            frameSwitch.switchToCourseSchedularBottomFrame();
            lblRestrictAccessAfter.replaceValues(title);
            uiDriver.waitToBeDisplayed(lblRestrictAccessAfter, waitTime);
            strTitle = lblRestrictAccessAfter.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET CAPTION OF RESTRICT ACCESS AFTER" + e
                    .getLocalizedMessage());
        }
        return strTitle;
    }

    /**
     * Method helps to check whether the Gradebook Review Date text box displayed
     * 
     * @author Usha
     * @param itemName
     * @return boolean
     * @throws Exception
     */
    public boolean isGradebookReviewDateTextBoxDisplayed(String itemName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: VERIFYING IS GRADEBOOK REVIEW DATE TEXT BOX DISPLAYED?");
            frameSwitch.switchToCourseSchedularBottomFrame();
            txtGradebookDate.replaceValues(itemName);
            flag= txtGradebookDate.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING GRADEBOOK REVIEW DATE TEXT BOX" + "\n METHOD:isGradebookReviewDateTextBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to verify for No item displayed for unit.
     * @return
     * @throws Exception
     * @author sristi.lohani
     */
    public boolean isNoItemDisplayed(String unit) throws Exception {

        try {
            
                logInstruction("LOGINSTRUCTION: CHECK FOR NO ITEM DISPLAYED FOR UNIT" + unit);
                frameSwitch.switchToCourseSchedularBottomFrame();
                noItems.replaceValues(unit);
                if (noItems.isDisplayedAfterWaiting(waitTime))
                    flag = true;
            
        } catch (Exception e) {
            throw new Exception("NO ITEMS TEXT NOT VERIFIED FOR THE UNIT" + e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify table headers.
     * 
     * @category-Milestone 2
     * @param Course
     *            Scheduler/ Schedule Files
     * @return
     * @throws Exception
     * @author Sristi
     */
    public boolean isTableHeadersDisplayed(String tableHeaderName) throws Exception {
        
        try {
            logInstruction(" VERIFY TABLE HEADERS" + tableHeaderName);
            frameSwitch.switchToCourseSchedularTopFrame();
            txtTableHeader.replaceValues(tableHeaderName);
            uiDriver.waitToBeDisplayed(txtTableHeader, waitTime);
            if (txtTableHeader.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO VERIFY TABLE HEADING" + e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify the Data under Date Assignment.
     * 
     * @category-Milestone 2
     * @param Course
     *            Scheduler/ Schedule Files
     * @return boolean
     * @throws Exception
     * @author Sristi
     */
    public boolean isDateAssignmentDataDisplayed(String data) throws Exception {
      
        try {
            logInstruction(" verify data under Date Assignemtn Display" + data);
            frameSwitch.switchToCourseSchedularBottomFrame();
            txtDateAssignmentData.replaceValues(data);
            uiDriver.waitToBeDisplayed(txtDateAssignmentData, waitTime);
            logInstruction(data + " Dispalyed successfully");
            if (txtDateAssignmentData.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception("unable to verify table heading" + e.getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify the content of start time drop down.
     * 
     * @category Milestone 2
     * @param endTime
     * @return boolean
     * @throws Exception
     * @author Mamatha
     */
    public boolean isStartTimeDisplayedInDropDown(String startTime, String itemName)
            throws Exception {
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY CONTENT OF START TIME DROPDOWN");
            if (StringUtils.isBlank(startTime))
                throw new Exception(
                        "UNABLE TO VERIFY CONTENT OF END TIME DROPDOWN. START TIME IS NULL \nMETHOD: isStartTimeDisplayedInDropDown().");

            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.click();
            drpStartTime.replaceValues(itemName);
            List<WebElement> lstWebElement = drpStartTime.findElements(By.tagName("option"));
            for (WebElement objWebElement : lstWebElement) {
                if (objWebElement.getText().contains(startTime)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY CONTENT OF START TIME DROPDOWN. \nMETHOD: isStartTimeDisplayedInDropDown()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify the content of end time drop down.
     * 
     * @category Milestone 2
     * @param strEndTime
     * @return boolean
     * @throws Exception
     * @author Mamatha
     */
    public boolean isEndTimeDisplayedInDropDown(String strEndTime, String itemName)
            throws Exception {
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY CONTENT OF END TIME DROPDOWN");
            if (StringUtils.isBlank(strEndTime))
                throw new Exception(
                        "UNABLE TO VERIFY CONTENT OF END TIME DROPDOWN. END TIME IS NULL \nMETHOD: isEndTimeDisplayedInDropDown().");

            frameSwitch.switchToCourseSchedularBottomFrame();
            radAssignSpecificStartDate.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(radAssignSpecificStartDate, waitTime);
            radAssignSpecificStartDate.click();
            drpEndTime.replaceValues(itemName);
            List<WebElement> lstWebElement = drpEndTime.findElements(By.tagName("option"));
            for (WebElement objWebElement : lstWebElement) {
                if (objWebElement.getText().contains(strEndTime)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY CONTENT OF END TIME DROPDOWN. \nMETHOD: isEndTimeDisplayedInDropDown()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone2 Method is used to Click due date calendar icon
     * @author Pratush.Manglik
     * @param itemName
     * @return DatePickerPage
     * @throws Exception
     */

    public DatePickerPage clickDueDateCalendarIcon(String itemName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK START DATE CALENDAR ICON");
            frameSwitch.switchToCourseSchedularBottomFrame();
            imgDueDatePicker.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(imgDueDatePicker, waitTime);
            imgDueDatePicker.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE ON CLICKING  due date calendar icon" + "\n METHOD:clickDueDateCalendarIcon \n" + e
                            .getLocalizedMessage());
        }
        return new DatePickerPage(uiDriver);
    }

}
