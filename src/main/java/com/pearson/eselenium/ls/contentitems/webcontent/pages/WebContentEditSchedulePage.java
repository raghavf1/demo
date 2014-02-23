package com.pearson.eselenium.ls.contentitems.webcontent.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * @category Milestone 2 Class contains methods related to edit scheduler page
 * @author ganapati.bhat
 * 
 */
public class WebContentEditSchedulePage extends BasePageObject {

    /* elements */
    private UIElement drpGradebookTime = createElement(UIType.ID, "GBReviewTime");
    private UIElement lblAsteriskGradebook = createElement(
            UIType.Xpath,
            "//td[contains(@colspan,'3')]/text()");
    private UIElement lblDueDate = createElement(UIType.Xpath, "//label[contains(@for,'DueDate')]");
    private UIElement txtDueDate = createElement(UIType.Xpath, "//input[@id='DueDate']");
    private UIElement imgDueDateCalendar = createElement(
            UIType.Xpath,
            "//img[contains(@alt,'Due Date')]");
    private UIElement drpDueDate = createElement(UIType.Xpath, "//select[contains(@id,'DueTime')]");
    private UIElement btnSaveClose = createElement(
            UIType.Xpath,
            "//input[contains(@value,'Save ')]");
    private UIElement btnCancel = createElement(UIType.Xpath, "//input[contains(@value,'Cancel')]");
    private UIElement lblTimeZone = createElement(
            UIType.Xpath,
            "//div[contains(@class,'dkgraytext')]");
    private UIElement lblFrameHeader = createElement(
            UIType.Xpath,
            "//div[contains(@class,'tablehead')]");

    private UIElement chkRestrictAccessAfter = createElement(UIType.ID, "RestrictAfter");
    private UIElement chkRestrictAccessBefore = createElement(UIType.ID, "RestrictBefore");

    private UIElement lblStartDate = createElement(
            UIType.Xpath,
            "//label[contains(@for,'StartDate')]");
    private UIElement lblStartEndDateCaption = createElement(
            UIType.Xpath,
            "//label[contains(@for,'StartDate')]");
    private UIElement lblUseFollowingDateCaption = createElement(
            UIType.Xpath,
            "//label[contains(@for,'IsScheduleInheritedNo')]");
    private UIElement lblEndDate = createElement(UIType.Xpath, "//label[contains(@for,'EndDate')]");

    private UIElement txtStartdate = createElement(UIType.Xpath, "//input[@id='StartDate']");
    private UIElement txtEndDate = createElement(UIType.Xpath, "//input[@id='EndDate']");
    private UIElement drpStartTime = createElement(
            UIType.Xpath,
            "//select[contains(@id,'StartTime')]");
    private UIElement drpEndTime = createElement(UIType.Xpath, "//select[contains(@id,'EndTime')]");
    private UIElement drpDueTime = createElement(UIType.Xpath, "//select[contains(@id,'DueTime')]");
    private UIElement txtGradebookReview = createElement(UIType.ID, "GBReviewDate");
    private UIElement imgCalendarGradebookReview = createElement(
            UIType.Xpath,
            "//td[input[@id='GBReviewDate']]//a/img");
    private UIElement imgCalendarStart = createElement(
            UIType.Xpath,
            "//td[input[contains(@id,'StartDate')]]//a/img");

    private UIElement imgCalendarEnd = createElement(
            UIType.Xpath,
            "//td[input[contains(@id,'EndDate')]]//a/img");
    private UIElement radCourseStartEndDate = createElement(
            UIType.Xpath,
            "//input[@id='IsScheduleInheritedYes']");
    private UIElement radUseFollowingDate = createElement(
            UIType.Xpath,
            "//input[@id='IsScheduleInheritedNo']");
    private UIElement btnSaveAndClose = createElement(
            UIType.Xpath,
            "//input[@value='Save & Close']");

    private UIElement txtStartDate = createElement(UIType.Xpath, "//input[@id='StartDate']");
    private UIElement txtGradebookReviewDate = createElement(UIType.ID, "GBReviewDate");
    private UIElement txtTitle = createElement(UIType.Xpath, "//h1/div[@class='tablehead']");
    private UIElement radCourseDates = createElement(
            UIType.Xpath,
            "//input[contains(@id,'CourseDates')]");
    private UIElement radCourseButton = createElement(
            UIType.Xpath,
            "//tr[td[label[contains(.,'{1}')]]]//input");
    private UIElement lblErrorMessage = createElement(
            UIType.Xpath,
            "//td[@class='inlineerror']//tr//td[2]");
    static Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    Date dateAfter = new Date();
    boolean flag = false;
    String strDueDate = "";
    String strStartDate = null;
    String strEndDate = null;
    String strGradebookReviewDate = null;
    String strTableTitle = null;
    String strText = null;
    String strTemp[];
    String strErrorMessage = null;
    String strCurrentDate = null;
    String strAfterDate = null;
    String strBeforeDate = null;
    Date todayDate = new Date();
    SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");

    /* Constructor */
    public WebContentEditSchedulePage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "WebContentEditSchedulePage";
        logInstruction("## TextMultimedia EditSchedulerPage ##");
    }

    /**
     * @category Milestone 2 Method is used to verify the content of grade book review time dropdown
     * @author Pratush.Manglik
     * @param grdTime
     * @return boolean
     * @throws Exception
     */
    public boolean isContentOfGradebookTimeDropdownDisplayed(String grdTime) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION :VERIFY THE CONTENT OF GRADE BOOK REVIEW TIME DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();
            List<UIElement> options = drpGradebookTime.findUIElements(By.tagName("option"));
            for (UIElement option : options) {
                if (option.getText().contains(grdTime)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO VERIFY THE 'Content OF Gradebook Time Dropdown '" + "\n METHOD:isContentOfGradebookTimeDropdownDisplayed \n" +

                    e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify gradebook asterisk
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isGradebookAsteriskDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY GRADEBOOK ASTERISK");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblAsteriskGradebook, waitTime);
            if (lblAsteriskGradebook.getText().contains("*")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO 'Check If Gradebook Asterisk Is Displayed'" + "\n METHOD:isGradebookAsteriskDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify due date caption
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateCaptionDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY DUE DATE CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblDueDate, waitTime);
            if (lblDueDate.getText().contains("Due Date")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Check IF Due Date Caption Is Displayed'" + "\n METHOD:isDueDateCaptionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify due date textBox
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateTextboxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY DUE DATE TEXT BOX");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtDueDate, waitTime);
            flag = txtDueDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO 'Check IF Due Date Box Is Displayed'" + "\n METHOD:isDueDateTextboxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify due date calendar icon
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateCalendarDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY DUE DATE CALENDAR ICON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(imgDueDateCalendar, waitTime);
            flag = imgDueDateCalendar.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Check IF Due Date Calendar Icon Is Displayed' " + "\n METHOD:isDueDateCalendarDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify due date dropdown
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateDropDownVisible() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY DUE DATE DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(drpDueDate, waitTime);
            flag = drpDueDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Check IF Due Date DropDown Is  Visible'" + "\n METHOD:isDueDateDropDownVisible\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify Save & Close button
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isSaveAndCloseButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY SAVE & CLOSE BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveClose, waitTime);
            flag = btnSaveClose.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Check IF Save & Close button Is  Displayed'" + "\n METHOD:isSaveAndCloseButtonDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify Caption of Save & Close button
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isSaveAndCloseButtonCaptionDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY SAVE & CLOSE BUTTON CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveClose, waitTime);
            if (btnSaveClose.getValue().contains("Save & Close")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Check If Save & Close Button Caption Is  Displayed'" + "\n METHOD:isSaveAndCloseButtonCaptionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify Cancel button
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isCancelButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY CANCEL BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            flag = btnCancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Check If  Cancel button Is  Displayed'" + "\n METHOD:isCancelButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify Caption of Cancel button
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isCancelButtonCaptionDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION :Verify Cancel Button Caption");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            if (btnCancel.getValue().contains("Cancel")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Check If  Cancel button Caption Is  Displayed'" + "\n METHOD:isCancelButtonCaptionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify instructional text about time zone
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isInstructionalTextAboutTimeZoneDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY INSTRUCTIONAL TEXT ABOUT TIME ZONE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblTimeZone, waitTime);
            flag = lblTimeZone.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Check If  Instructional Text About Time Zone Is  Displayed'" + "\n METHOD:isInstructionalTextAboutTimeZoneDisplayed \n" + e
                            .getLocalizedMessage());

        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify instructional text caption about time zone
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isInstructionalTextAboutTimeZoneCaptionDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY INSTRUCTIONAL TEXT CAPTION ABOUT TIME ZONE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblTimeZone, waitTime);
            if (lblTimeZone.getText().contains(" * Times are displayed ")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Check If Instructional Text About Time Zone Caption Is Displayed'" + "\n METHOD:isInstructionalTextAboutTimeZoneCaptionDisplayed \n" + e
                            .getLocalizedMessage());

        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to get frame header title
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String frameHeaderTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GET FRAME HEADER TITLE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblFrameHeader, waitTime);
            pageTitle = lblFrameHeader.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Get frame header title'" + "\n METHOD:frameHeaderTitle \n" + e
                            .getLocalizedMessage());
        }
        return pageTitle;
    }

    /**
     * @category Milestone 2 Method helps to click on Restrict access after check box.
     * @return WebContentEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public WebContentEditSchedulePage clickRestrictAccessAfterCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK ON RESTRICT ACCESS AFTER CHECKBOX ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessAfter, waitTime);
            chkRestrictAccessAfter.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO 'Click on Restrict Access After CheckBox'" + "\n METHOD:clickRestrictAccessAfterCheckBox \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @category Milestone 2 Method helps to verify Restrict access after check box.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isRestrictAccessAfterCheckBoxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY RESTRICT ACCESS AFTER CHECKBOX PRESENT ");
            frameSwitch.switchToPopUpContentFrame();

            if (chkRestrictAccessAfter.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO 'Check If Restrict Access After CheckBox is displayed'" + "\n METHOD:isRestrictAccessAfterCheckBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method helps to click on Restrict access before check box.
     * @return WebContentEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public WebContentEditSchedulePage clickRestrictAccessBeforeCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK ON RESTRICT ACCESS BEFORE CHECKBOX ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessBefore, waitTime);
            chkRestrictAccessBefore.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO  'Click On Restrict Access Before CheckBox'" + "\n METHOD:clickRestrictAccessBeforeCheckBox \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @category Milestone 2 Method helps to verify Restrict access before check box.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isRestrictAccessBeforeCheckBoxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION :  VERIFY RESTRICT ACCESS BEFORE CHECKBOX PRESENT ");
            frameSwitch.switchToPopUpContentFrame();

            if (chkRestrictAccessBefore.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK 'If Restrict Access Before CheckBox Is Displayed'" + "\n METHOD:isRestrictAccessBeforeCheckBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method helps to verify End date caption.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEndDateCaptionDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY END DATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();

            if (lblEndDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK 'If End Date Caption Is Displayed'" + "\n METHOD:isEndDateCaptionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to verify Start date caption.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isStartDateCaptionDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY START DATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();

            if (lblStartDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK 'If Start Date Caption Is  Displayed'" + "\n METHOD:isStartDateCaptionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to verify calendar for start date.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCalendarStartDateDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY START DATE CALENDAR ");
            frameSwitch.switchToPopUpContentFrame();

            if (imgCalendarStart.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK 'If Start Date Calendar Is Displayed'" + "\n METHOD:isCalendarStartDateDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to verify calendar for end date.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCalendarEndDateDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY END DATE CALENDAR ");
            frameSwitch.switchToPopUpContentFrame();

            if (imgCalendarEnd.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK 'If End Date Calendar Is  Displayed'" + "\n METHOD:isCalendarEndDateDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to verify End time dropdown.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEndTimeDropDownDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY END TIME DROPDOWN ");
            frameSwitch.switchToPopUpContentFrame();

            if (drpEndTime.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK 'If End Time Dropdown Is Displayed'" + "\n METHOD:isEndTimeDropDownDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to verify start time dropdown.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isStartTimeDropDownDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY START TIME DROPDOWN ");
            frameSwitch.switchToPopUpContentFrame();

            if (drpStartTime.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK 'If Start Time Dropdown Is Displayed'" + "\n METHOD:isStartTimeDropDownDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to verify due time dropdown.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isDueTimeDropDownDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY DUE TIME DROPDOWN ");
            frameSwitch.switchToPopUpContentFrame();

            if (drpDueTime.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK 'If Due Time Dropdown Is Displayed'" + "\n METHOD:isDueTimeDropDownDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to verify start date text box.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isStartDateTextBoxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY START DATE TEXTBOX ");
            frameSwitch.switchToPopUpContentFrame();

            if (txtStartdate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK 'If Start Date Textbox Is Displayed'" + "\n METHOD:isStartDateTextBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to verify end date text box.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEndDateTextBoxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY END DATE TEXTBOX ");
            frameSwitch.switchToPopUpContentFrame();

            if (txtEndDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK 'If End Date Textbox Is Present'" + "\n METHOD:isEndDateTextBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to verify caption for course start and end date radio
     *           button.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCaptionForUseCourseStartandEndDatesRadioButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY USE COURSE START AND END DATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();

            if (lblStartEndDateCaption.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK 'If Use Course Start And End Date  Caption Is  Present'" + "\n METHOD:isCaptionForUseCourseStartandEndDatesRadioButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to click course start and end date radio button.
     * @return WebContentEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public WebContentEditSchedulePage clickUseCourseStartandEndDatesRadioButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : CLICK USE COURSE START END DATE RADIO BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseStartEndDate, waitTime);
            radCourseStartEndDate.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO 'Click On Use Course Start End Date Radio Button'" + "\n METHOD:clickUseCourseStartandEndDatesRadioButton \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * @category Milestone 2 Method helps to verify caption for use the following date radio button.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCaptionForUseTheFollowingDatesRadioButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY CAPTION FOR USE THE FOLLOWING DATES RADIO BUTTON ");
            frameSwitch.switchToPopUpContent();

            if (lblUseFollowingDateCaption.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK If 'Caption For Use The Following Dates Radio Button Is Displayed'" + "\n METHOD:isCaptionForUseTheFollowingDatesRadioButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to click on use following dates radio button.
     * @return WebContentEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public WebContentEditSchedulePage clickUseFollowingDatesRadioButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK USE FOLLOWING DATE RADIO BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radUseFollowingDate, waitTime);
            radUseFollowingDate.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Click Use Following Date Radio Button'" + "\n METHOD:clickUseFollowingDatesRadioButton \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * @category Milestone 2 Method helps to click on Save and Close button.
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public void clickSaveAndCloseButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : CLICK SAVE AND CLOSE BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
            btnSaveAndClose.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO  'Click Save And Close Button'" + "\n METHOD:clickSaveAndCloseButton \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * @category Milestone 2 Method helps to verify the content of end time drop down.
     * @param String
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEndTimeDisplayedInDropDown(String endTime) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY END TIME DISPLAYED IN DROPDOWN");

            frameSwitch.switchToPopUpContentFrame();
            List<UIElement> options = drpEndTime.findUIElements(By.tagName("option"));
            for (UIElement option : options) {
                if (option.getText().contains(endTime)) {
                    flag = true;
                }
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'End Time Displayed In Dropdown'" + "\n METHOD:isEndTimeDisplayedInDropDown \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method helps to verify the content of start time drop down.
     * @param String
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isStartTimeDisplayedInDropDown(String startTime) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION :  VERIFY START TIME DISPLAYED IN DROPDOWN ");

            frameSwitch.switchToPopUpContentFrame();
            List<UIElement> options = drpStartTime.findUIElements(By.tagName("option"));
            for (UIElement option : options) {
                if (option.getText().contains(startTime)) {
                    flag = true;
                }
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Start Time Displayed In Dropdown'" + "\n METHOD:isStartTimeDisplayedInDropDown \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method helps to verify grade book text box.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isGradeboobReviewTextBoxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION :  VERIFY GRADEBOOK TEXTBOX ");
            frameSwitch.switchToPopUpContentFrame();

            if (txtGradebookReview.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY ' Gradebook Textbox Is Displayed'" + "\n METHOD:isGradeboobReviewTextBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to verify calendar for gradebook.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCalendarGradebookDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY GRADEBOOK CALENDAR ");
            frameSwitch.switchToPopUpContentFrame();

            if (imgCalendarGradebookReview.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO VERIFY 'If  Gradebook Calendar Is Displayed'" + "\n METHOD:isCalendarGradebookDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to enter start date.
     * @param String
     * @return WebContentEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public WebContentEditSchedulePage enterStartDate(String startDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : ENTERING VALUE FOR START DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtStartdate, waitTime);
            txtStartdate.clearAndSendKeys(startDate);

            txtStartdate.sendKeys(Keys.ENTER);

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception(
                    " UNABLE TO  'Enter Start Date'" + "\n METHOD:enterStartDate \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @category Milestone 2 Method helps to enter due date.
     * @param dueDate
     * @return WebContentEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public WebContentEditSchedulePage enterDueDate(String dueDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : ENTERING VALUE FOR DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtDueDate, waitTime);

            txtDueDate.clearAndSendKeys(dueDate);
            txtDueDate.sendKeys(Keys.ENTER);

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception(" UNABLE TO  'Enter Due Date'" + "\n METHOD:enterDueDate \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @category Milestone 2 Method helps to get value entered in due date.
     * @param dueDate
     * @return String
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getDueDate() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GET VALUE FOR DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtDueDate, waitTime);

            strDueDate = txtDueDate.getValue();

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception("UNABLE TO 'Get  Due Date'" + "\n METHOD:getDueDate \n" + e
                    .getLocalizedMessage());
        }
        return strDueDate;
    }

    /**
     * @category Milestone 2 Method helps to enter gradebook review date.
     * @param String
     * @return WebContentEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public WebContentEditSchedulePage enterGradebookReviewDate(String dueDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : ENTERING VALUE FOR GRADEBOOK REVIEW DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtGradebookReview, waitTime);

            txtGradebookReview.clearAndSendKeys(dueDate);
            txtGradebookReview.sendKeys(Keys.ENTER);

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception(
                    "UNABLE TO  'Enter Gradebook Review Date'" + "\n METHOD:enterGradebookReviewDate \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to get start date
     * @return
     * @throws Exception
     */
    public String getStartDate() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION :  GETTING START DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtStartDate, waitTime);
            strStartDate = txtStartDate.getValue();
        } catch (Exception e) {
            throw new Exception("UNABLE TO 'Get Start Date'" + "\n METHOD:getStartDate \n" + e
                    .getLocalizedMessage());
        }

        return strStartDate;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to Enter end date
     * @param String
     * @return WebContentEditSchedulePage
     * @throws Exception
     */
    public WebContentEditSchedulePage enterEndDate(String endDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : ENTER END DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtEndDate.clearAndSendKeys(endDate);
            txtEndDate.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            throw new Exception("UNABLE TO 'Enter End Date'" + "\n METHOD:enterEndDate \n" + e
                    .getLocalizedMessage());
        }

        return this;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to get end date
     * @return
     * @throws Exception
     */
    public String getEndDate() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GETTING END DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            strEndDate = txtEndDate.getValue();
        } catch (Exception e) {
            throw new Exception("UNABLE TO 'Get End Date'" + "\n METHOD:getEndDate \n" + e
                    .getLocalizedMessage());
        }

        return strEndDate;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to get gradebookReview Date
     * @return
     * @throws Exception
     */
    public String getGradebookReviewDate() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION :  GETTING GRADEBOOKREVIEW DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtGradebookReviewDate, waitTime);
            strGradebookReviewDate = txtGradebookReviewDate.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Get GradebookReview Date'" + "\n METHOD:getGradebookReviewDate \n" + e
                            .getLocalizedMessage());
        }

        return strGradebookReviewDate;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to get header title
     * @return
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GETTING HEADER TITLE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            strTableTitle = txtTitle.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO 'Get header title'" + "\n METHOD:getHeaderTitle \n" + e
                    .getLocalizedMessage());
        }
        return strTableTitle;
    }

    /**
     * @category Milestone 2 This method is used to check radio button is selected or not
     * 
     * @author Usha
     * @return boolean
     * @param String
     * @throws Exception
     */
    public boolean isRadioButtonSelected(String radioButtonLabel) throws Exception {
        flag = false;

        try {
            logInstruction("LOG INSTRUCTION : CHECKING IF A PARTICULAR RADIO BUTTON SELECTED");
            frameSwitch.switchToPopUpContentFrame();
            radCourseButton.replaceValues(radioButtonLabel);
            if (radCourseButton.isSelected()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK 'If Radio Button Is Selected ' " + "\n METHOD:isRadioButtonSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to get text next to schedule in header title
     * @return String
     * @throws Exception
     */
    public String getTextFromFieldNextToSchedule() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION :GETTING TEXT NEXT TO SCHEDULE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            strTableTitle = txtTitle.getText();
            strTemp = strTableTitle.split(" ");

            strText = strTemp[2];

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO 'Get Text Next To Schedule'" + "\n METHOD:getTextFromFieldNextToSchedule \n" + e
                            .getLocalizedMessage());
        }
        return strText;
    }

    /**
     * @category Milestone 2 This method is used to check if alert displayed
     * 
     * @author Usha
     * @return boolean
     * @throws Exception
     */
    public boolean isAlertMessageDisplayedAfterEnteringInvalidDate() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECKING IF ALERT IS DISPLAYED AFTER ENTERING INVALID DATE");
            uiDriver.sleep(waitTime);
            String strAlertMessage = uiDriver.getUIAlert().getAlertMessage();
            if (!strAlertMessage.isEmpty()) {
                // uiDriver.switchTo().alert();
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO check 'if Alert Is Displayed After Entering Invalid Date' " + "\n METHOD:isAlertMessageDisplayedAfterEnteringInvalidDate \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to get alert text
     * @return String
     * @throws Exception
     */
    public String getAlertMesssageContentsAfterEnteringInvalidDate() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GETTING ALERT TEXT");
            strTableTitle = uiDriver.getUIAlert().getAlertMessage();
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'get Alert Messsage Contents After Entering Invalid Date'" + "\n METHOD:getAlertMesssageContentsAfterEnteringInvalidDate \n" + e
                            .getLocalizedMessage());
        }
        return strTableTitle;
    }

    /**
     * @category Milestone 2 Method is used to click on the cancel button
     * @author ganapati
     * 
     * @throws Exception
     */
    public void clickCancelButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : CLICK ON THE CANCEL BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ' Click Cancel Button '" + "\n METHOD:clickCancelButton \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * @category Milestone 2 Method is used to Check if Start Date Field is Disabled
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isStartDateFieldDisabled() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECK IF START DATE FIELD IS DISABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseDates, waitTime);
            if (radCourseDates.isSelected()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO Check if 'Start Date Field is Disabled'" + "\n METHOD:isStartDateFieldDisabled \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to Check if End Date Field is Disabled
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isEndDateFieldDisabled() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECK IF END DATE FIELD IS DISABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseDates, waitTime);
            if (radCourseDates.isSelected()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF  'End Date Field is Disabled'" + "\n METHOD:isEndDateFieldDisabled \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to Enter end date
     * @param endDate
     * @return WebContentEditSchedulePage
     * @throws Exception
     */
    public WebContentEditSchedulePage enterInvalidEndDate(String endDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION :ENTER 'INVALID END DATE'");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtEndDate.clearAndSendKeys(endDate);
            // To take focus out click on startdate field
            txtStartDate.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER 'Invalid End Date'" + "\n METHOD:enterInvalidEndDate \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to Enter end date
     * @param String
     * @return WebContentEditSchedulePage
     * @throws Exception
     */
    public WebContentEditSchedulePage enterInvalidStartDate(String endDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION :ENTER  INVALID START DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtStartDate.clearAndSendKeys(endDate);
            // To take focus out click on end date field
            txtEndDate.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO ENTER 'Invalid Start Date'" + "\n METHOD:enterInvalidStartDate \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to Enter end date
     * @param String
     * @return WebContentEditSchedulePage
     * @throws Exception
     */
    public WebContentEditSchedulePage enterInvalidDueDate(String endDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION :ENTER DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtDueDate.clearAndSendKeys(endDate);
            // To take focus out click on end date field
            txtStartDate.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER 'Invalid Due Date'" + "\n METHOD:enterInvalidDueDate \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * @category Milestone 2
     * @author Mamatha , Method is used to Check if error message is Disabled
     * 
     * @return boolean
     * @throws Exception
     */
    public boolean isErrorMessageDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFICATION OF ERROR MESSAGE");
            frameSwitch.switchToPopUpContentFrame();

            flag = lblErrorMessage.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF 'Error Message Is Displayed'" + "\n METHOD:isErrorMessageDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2
     * @author Mamatha , Method used to getErrorMessage
     * 
     * @return String
     * @throws Exception
     */
    public String getErrorMessage() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: VERIFICATION OF ERROR MESSAGE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblErrorMessage, waitTime);
            strErrorMessage = lblErrorMessage.getText();
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO GET 'Error Message'" + "\n METHOD:getErrorMessage \n" + e
                            .getLocalizedMessage());
        }
        return strErrorMessage;
    }

    /**
     * @category Milestone 2 Method helps to click on Save and Close button.
     * @return WebContentEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public WebContentEditSchedulePage clickSaveAndCloseButtonForInvalidData() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : CLICK SAVE AND CLOSE BUTTON FOR INVALID DATA");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
            btnSaveAndClose.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK 'Save And Close Button For Invalid Data'" + "\n METHOD:clickSaveAndCloseButtonForInvalidData \n" + e
                            .getLocalizedMessage());
        }
        return new WebContentEditSchedulePage(uiDriver);

    }

    /**
     * Method helps to get the current date
     * 
     * @author ganapati.bhat
     * @return
     * @throws Exception
     */

    public String getCurrentDate() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GET CURRENT DATE");

            strCurrentDate = sdfwithOnlyDate.format(todayDate);

        } catch (Exception e) {
            throw new Exception("UNABLE TO 'Get Current Date'" + "\n METHOD:getCurrentDate \n" + e
                    .getLocalizedMessage());
        }
        return strCurrentDate;
    }

    /**
     * Method helps to get future date
     * 
     * @author ganapati.bhat
     * @return String
     * @param int
     * @throws Exception
     */

    public String getFutureDate(int Days) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GET FUTURE DATE");

            calendar.setTime(todayDate);
            calendar.add(Calendar.DATE, Days);
            dateAfter = calendar.getTime();
            strAfterDate = sdfwithOnlyDate.format(dateAfter);

        } catch (Exception e) {
            throw new Exception("UNABLE TO 'Get Future Date'" + "\n METHOD:getFutureDate \n" + e
                    .getLocalizedMessage());
        }
        return strAfterDate;
    }

    /**
     * Method helps to get past date
     * 
     * @author ganapati.bhat
     * @return
     * @throws Exception
     */

    public String getPastDate(int Days) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION :  GET PAST DATE");

            calendar.setTime(todayDate);
            calendar.add(Calendar.DATE, -Days);
            dateAfter = calendar.getTime();
            strBeforeDate = sdfwithOnlyDate.format(dateAfter);

        } catch (Exception e) {
            throw new Exception("UNABLE TO  'Get Past date'" + "\n METHOD:getPastDate \n" + e
                    .getLocalizedMessage());
        }
        return strBeforeDate;
    }

    /**
     * Method helps to schedule the date
     * 
     * @param isUseFollowingDates
     * @param startDate
     * @param endDate
     * @param startTime
     * @param endTime
     * @param dueDate
     * @param dueTime
     * @return WebContentToolboxPage
     * @throws Exception
     */
    public WebContentToolboxPage scheduleDate(
            boolean isUseFollowingDates,
            String startDate,
            String endDate,

            String dueDate,

            boolean isRestrictBefore,
            boolean isRestrictAfter) throws Exception {

        try {

            logInstruction("LOG INSTRUCTION: SCHEDULE THE DATE");
            frameSwitch.switchToPopUpContentFrame();

            if (isUseFollowingDates == true) {

                radUseFollowingDate.clickAndWait(waitTime);

                if (StringUtils.isNotBlank(startDate)) {
                    logInstruction("LOG INSTRUCTION: ENTER START DATE");
                    txtStartdate.clearAndSendKeys(startDate);
                }
                if (StringUtils.isNotBlank(endDate)) {
                    logInstruction("LOG INSTRUCTION: ENTER END DATE");
                    txtEndDate.clearAndSendKeys(endDate);
                }

                if (isRestrictAfter == true) {
                    logInstruction("LOG INSTRUCTION: SELECT RESTRICT AFTER CHECK BOX");
                    uiDriver.waitToBeDisplayed(chkRestrictAccessAfter, waitTime);
                    chkRestrictAccessAfter.clickAndWait(waitTime);
                }

                if (isRestrictBefore == true) {
                    logInstruction("LOG INSTRUCTION: SELECT RESTRICT BEFORE CHECK BOX");
                    uiDriver.waitToBeDisplayed(chkRestrictAccessBefore, waitTime);
                    chkRestrictAccessBefore.clickAndWait(waitTime);
                }

            }

            if (StringUtils.isNotBlank(dueDate)) {

                logInstruction("LOG INSTRUCTION: ENTER DUE DATE");
                txtDueDate.clearAndSendKeys(dueDate);
            }

            btnSaveAndClose.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("UNABLE TO  'SCHEDULE THE DATE'" + "\n METHOD:scheduleDate \n" + e
                    .getLocalizedMessage());
        }
        return new WebContentToolboxPage(uiDriver);
    }

}
