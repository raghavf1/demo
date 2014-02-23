package com.pearson.eselenium.ls.contentitems.microsoftofficedocument.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
public class MicrosoftOfficeDocEditSchedulePage extends BasePageObject {

    /* UIElement Declaration */
    private UIElement drpGradebookTime = createElement(UIType.ID, "GBReviewTime");
    private UIElement lblAsteriskGradebook = createElement(
            UIType.Xpath,
            "//td[contains(@colspan,'3')]/text()");
    private UIElement lblDueDate = createElement(
            UIType.Xpath,
            "//label[contains(@for,'ExamDueDate')]");
    private UIElement txtDueDate = createElement(UIType.Xpath, "//input[@id='DueDate']");
    private UIElement imgDueDateCalendar = createElement(
            UIType.Xpath,
            "//img[contains(@alt,'Due Date')]");
    private UIElement drpDueDate = createElement(
            UIType.Xpath,
            "//select[contains(@id,'ExamDueTime')]");
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
    private UIElement lblAsteriskEnd = createElement(UIType.Css, "");
    private UIElement lblAsteriskStart = createElement(UIType.Css, "");
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
    String strTableTitle = null;
    String strDueDate = null;
    String strStartDate = null;
    String strErrorMessage = null;
    String strCurrentDate = null;
    String strAfterDate = null;
    String strEndDate = null;
    String strGradebookReviewDate = null;
    String strText = null;
    String temp[];
    String strBeforeDate = null;

    Date todayDate = new Date();
    SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");

    /* Constructor */
    public MicrosoftOfficeDocEditSchedulePage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "MicrosoftOfficeDocEditSchedulePage";
        logInstruction("## Microsoft Office Doc EditSchedulePage ##");
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
            logInstruction("LOG INSTRUCTION:VERIFY THE CONTENT OF GRADEBOOK REVIEW TIME DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();
            List<UIElement> options = drpGradebookTime.findUIElements(By.tagName("option"));
            for (UIElement option : options) {
                if (option.getText().contains(grdTime)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY CONTENT OF GRADEBOOK REVIEW TIME DROPDOWN" + "\n METHOD:isContentOfGradebookTimeDropdownDisplayed \n" + e
                            .getLocalizedMessage());

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
            logInstruction("LOG INSTRUCTION:VERIFY GRADEBOOK ASTERISK");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblAsteriskGradebook, waitTime);
            if (lblAsteriskGradebook.getText().contains("*")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY GRADEBOOK ASTERISK IS DISPLAYED" + "\n METHOD:isGradebookAsteriskDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY DUE DATE CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblDueDate, waitTime);
            if (lblDueDate.getText().contains("Due Date")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY DUEDATE CAPTION " + "\n METHOD:isDueDateCaptionDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY DUE DATE TEXT BOX");
            frameSwitch.switchToPopUpContentFrame();

            if (txtDueDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY Duedate TextBox" + "\n METHOD:isDueDateTextboxDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY DUEDATE CALENDAR ICON");
            frameSwitch.switchToPopUpContentFrame();

            if (imgDueDateCalendar.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY DUEDATE CALENDAR ICON" + "\n METHOD:isDueDateCalendarDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY DUEDATE DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();

            flag = drpDueDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Duedate DropDown' Is Visible" + "\n METHOD:isDueDateDropDownVisible \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY SAVE & CLOSE BUTTON");
            frameSwitch.switchToPopUpContentFrame();

            if (btnSaveClose.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Save & Close' Button" + "\n METHOD:isSaveAndCloseButtonDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY SAVE & CLOSE BUTTON CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveClose, waitTime);
            if (btnSaveClose.getAttribute("value").contains("Save & Close")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Save & Close' Button Caption" + "\n METHOD:isSaveAndCloseButtonCaptionDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY CANCEL BUTTON");
            frameSwitch.switchToPopUpContentFrame();

            if (btnCancel.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY Cancel Button" + "\n METHOD:isCancelButtonDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY CANCEL BUTTON CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            if (btnCancel.getAttribute("value").contains("Cancel")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY Cancel Button Caption" + "\n METHOD:isCancelButtonCaptionDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY INSTRUCTIONAL TEXT ABOUT TIME ZONE");
            frameSwitch.switchToPopUpContentFrame();

            if (lblTimeZone.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY Instructional Text About Time Zone" + "\n METHOD:isInstructionalTextAboutTimeZoneDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY INSTRUCTIONAL TEXT CAPTION ABOUT TIME ZONE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblTimeZone, waitTime);
            if (lblTimeZone.getText().contains(" * Times are displayed ")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY Instructional Text Caption About Time Zone" + "\n METHOD:isInstructionalTextAboutTimeZoneCaptionDisplayed \n" + e
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
    public String getFrameHeaderTitle() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:GET FRAME HEADER TITLE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblFrameHeader, waitTime);
            strTableTitle = lblFrameHeader.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET Frame Header Title" + "\n METHOD:getFrameHeaderTitle \n" + e
                            .getLocalizedMessage());
        }
        return strTableTitle;
    }

    /**
     * @category Milestone 2 Method helps to click on Restrict access after check box.
     * @return MicrosoftOfficeDocEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public MicrosoftOfficeDocEditSchedulePage clickRestrictAccessAfterCheckBox() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:CLICK ON RESTRICT ACCESS AFTER CHECKBOX ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessAfter, waitTime);
            chkRestrictAccessAfter.clickAndWait(waitTime);
        } catch (Exception e) {
            logInstruction("UNABLE TO CLICK ON Restrict Access After CheckBox" + "\n METHOD:clickRestrictAccessAfterCheckBox \n" + e
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
            logInstruction("LOG INSTRUCTION: VERIFY RESTRICT ACCESS AFTER CHECKBOX DISPLAYED");
            frameSwitch.switchToPopUpContentFrame();

            if (chkRestrictAccessAfter.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY Restrict Access After CheckBox" + "\n METHOD:isRestrictAccessAfterCheckBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method helps to click on Restrict access before check box.
     * @return MicrosoftOfficeDocEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public MicrosoftOfficeDocEditSchedulePage clickRestrictAccessBeforeCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON RESTRICT ACCESS BEFORE CHECKBOX ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessBefore, waitTime);
            chkRestrictAccessBefore.clickAndWait(waitTime);
        } catch (Exception e) {
            logInstruction("UNABLE TO CLICK On Restrict Access Before CheckBox" + "\n METHOD:clickRestrictAccessBeforeCheckBox \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY RESTRICT ACCESS BEFORE CHECKBOX DISPLAYED");
            frameSwitch.switchToPopUpContentFrame();

            if (chkRestrictAccessBefore.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY Restrict Access Before CheckBox DISPLAYED" + "\n METHOD:isRestrictAccessBeforeCheckBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method helps to verify Asterisk.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isAsteriskStartDateDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:VERIFY STARTDATE ASTERISK DISPLAYED ");
            frameSwitch.switchToPopUpContentFrame();

            if (lblAsteriskStart.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'StartDateAsterisk' DISPLAYED" + "\n METHOD:isAsteriskStartDateDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to verify Asterisk.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isAsteriskEndDateDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:VERIFY ENDDATE ASTERISK PRESENT");
            frameSwitch.switchToPopUpContentFrame();

            if (lblAsteriskEnd.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'EndDateAsterisk' DISPLAYED" + "\n METHOD:isAsteriskEndDateDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY END DATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();

            if (lblEndDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Enddate Caption' DISPLAYED" + "\n METHOD:isEndDateCaptionDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY STARTDATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();

            if (lblStartDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Startdate Caption' DISPLAYED" + "\n METHOD:isStartDateCaptionDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY STARTDATE CALENDAR ICON ");
            frameSwitch.switchToPopUpContentFrame();

            if (imgCalendarStart.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Startdate Calendar Icon'DISPLAYED" + "\n METHOD:isCalendarStartDateDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY ENDDATE CALENDAR ICON ");
            frameSwitch.switchToPopUpContentFrame();

            if (imgCalendarEnd.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Enddate Calendar Icon'DISPLAYED" + "\n METHOD:isCalendarEndDateDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY END TIME DROPDOWN ");
            frameSwitch.switchToPopUpContentFrame();

            if (drpEndTime.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Endtime Dropdown' DISPLAYED" + "\n METHOD:isEndTimeDropDownDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY STARTTIME DROPDOWN ");
            frameSwitch.switchToPopUpContentFrame();

            if (drpStartTime.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY Starttime Dropdown" + "\n METHOD:isStartTimeDropDownDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY DUETIME DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();

            if (drpDueTime.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY Duetime Dropdown" + "\n METHOD:isDueTimeDropDownDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY STARTDATE TEXTBOX ");
            frameSwitch.switchToPopUpContentFrame();

            if (txtStartdate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Startdate Textbox' DISPLAYED" + "\n METHOD:isStartDateTextBoxDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY ENDDATE TEXTBOX");
            frameSwitch.switchToPopUpContentFrame();

            if (txtEndDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Enddate Textbox' DISPLAYED" + "\n METHOD:isEndDateTextBoxDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY CAPTION FOR USE COURSE STARTANDENDDATES RADIOBUTTON");
            frameSwitch.switchToPopUpContentFrame();

            if (lblStartEndDateCaption.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Caption For Use Course StartandEndDates RadioButton' DISPLAYED" + "\n METHOD:isCaptionForUseCourseStartandEndDatesRadioButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to verify course start and end date radio button is
     *           selected.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isUseCourseStartandEndDatesRadioButtonSelected() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:VERIFY USE COURSE START AND ENDDATES RADIOBUTTON SELECTED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblStartEndDateCaption, waitTime);
            if (lblStartEndDateCaption.isSelected()) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Use Course Start and EndDates RadioButton' SELECTED" + "\n METHOD:isUseCourseStartandEndDatesRadioButtonSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to click course start and end date radio button.
     * @return MicrosoftOfficeDocEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public MicrosoftOfficeDocEditSchedulePage clickUseCourseStartandEndDatesRadioButton()
            throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK USE COURSE START END DATE RADIO BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseStartEndDate, waitTime);
            radCourseStartEndDate.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK 'Use Course Start End Date' RADIO BUTTON" + "\n METHOD:clickUseCourseStartandEndDatesRadioButton \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY CAPTION FOR USE THE FOLLOWINGDATES RADIOBUTTON");
            frameSwitch.switchToPopUpContent();

            if (lblUseFollowingDateCaption.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Caption For UseTheFollowingDates'RADIOBUTTON" + "\n METHOD:isCaptionForUseTheFollowingDatesRadioButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to click on use following dates radio button.
     * @return MicrosoftOfficeDocEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public MicrosoftOfficeDocEditSchedulePage clickUseFollowingDatesRadioButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:CLICK USE FOLLOWING DATES RADIO BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radUseFollowingDate, waitTime);
            radUseFollowingDate.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK 'Use Following Dates' RADIO BUTTON" + "\n METHOD:clickUseFollowingDatesRadioButton \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps to click on Save and Close button.
     * 
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public void clickSaveAndCloseButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:CLICK SAVE AND CLOSE BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
            btnSaveAndClose.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK 'Save And Close' BUTTON" + "\n METHOD:clickSaveAndCloseButton \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * @category Milestone 2 Method helps to verify the content of end time drop down.
     * @param String
     *            endTime
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEndTimeDisplayedInDropDown(String endTime) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:VERIFY CONTENT OF END TIME DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();
            List<UIElement> options = drpEndTime.findUIElements(By.tagName("option"));
            for (UIElement option : options) {
                if (option.getText().contains(endTime)) {
                    flag = true;
                }
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Content Of End Time' DROPDOWN" + "\n METHOD:isEndTimeDisplayedInDropDown \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY CONTENT OF END TIME DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();
            List<UIElement> options = drpStartTime.findUIElements(By.tagName("option"));
            for (UIElement option : options) {
                if (option.getText().contains(startTime)) {
                    flag = true;
                }
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Content Of End Time' DROPDOWN" + "\n METHOD:isStartTimeDisplayedInDropDown \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY GRADEBOOK TEXTBOX ");
            frameSwitch.switchToPopUpContentFrame();

            if (txtGradebookReview.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Gradebook' TEXTBOX" + "\n METHOD:isGradeboobReviewTextBoxDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION:VERIFY GRADEBOOK CALENDAR ICON");
            frameSwitch.switchToPopUpContentFrame();

            if (imgCalendarGradebookReview.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Gradebook Calendar'ICON" + "\n METHOD:isCalendarGradebookDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * @category Milestone 2 Method helps to enter start date.
     * @param startDate
     * @return MicrosoftOfficeDocEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public MicrosoftOfficeDocEditSchedulePage enterStartDate(String startDate) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:ENTERING VALUE FOR START DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtStartdate, waitTime);
            txtStartdate.clearAndSendKeys(startDate);

        } catch (Exception e) {

            throw new Exception("UNABLE TO ENTER Start Date" + "\n METHOD:enterStartDate \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @category Milestone 2 Method helps to enter due date.
     * @param dueDate
     * @return MicrosoftOfficeDocEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public MicrosoftOfficeDocEditSchedulePage enterDueDate(String dueDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTER VALUE FOR DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtDueDate, waitTime);
            txtDueDate.sendKeys(dueDate);

        } catch (Exception e) {

            throw new Exception("UNABLE TO ENTER Due Date" + "\n METHOD:enterDueDate \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @category Milestone 2 Method helps to get value entered in due date.
     * 
     * @return String
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getDueDate() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:GETTING DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtDueDate, waitTime);
            strDueDate = txtDueDate.getAttribute("value");
        } catch (Exception e) {

            throw new Exception("UNABLE TO ENTER Due Date" + "\n METHOD:getDueDate \n" + e
                    .getLocalizedMessage());
        }
        return strDueDate;
    }

    /**
     * @category Milestone 2 Method helps to enter gradebook review date.
     * @param dueDate
     * @return MicrosoftOfficeDocEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public MicrosoftOfficeDocEditSchedulePage enterGradebookReviewDate(String dueDate)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTER VALUE FOR GRADEBOOK REVIEW DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtGradebookReview, waitTime);
            txtGradebookReview.sendKeys(dueDate);
            txtGradebookReview.sendKeys(Keys.ENTER);

        } catch (Exception e) {

            throw new Exception(
                    "UNABLE TO ENTER Gradebook Review Date" + "\n METHOD:enterGradebookReviewDate \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to get start date
     * @return String
     * @throws Exception
     */
    public String getStartDate() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:GETTING START DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtStartDate, waitTime);
            strStartDate = txtStartDate.getAttribute("value");
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET Start Date" + "\n METHOD:getStartDate \n" + e
                    .getLocalizedMessage());
        }

        return strStartDate;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to Enter end date
     * @param endDate
     * @return MicrosoftOfficeDocEditSchedulePage
     * @throws Exception
     */
    public MicrosoftOfficeDocEditSchedulePage enterEndDate(String endDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTER END DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtEndDate.clearAndSendKeys(endDate);

        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER End Date" + "\n METHOD:enterEndDate \n" + e
                    .getLocalizedMessage());
        }

        return this;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to get end date
     * @return String
     * @throws Exception
     */
    public String getEndDate() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:GETTING END DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            strEndDate = txtEndDate.getAttribute("value");
        } catch (Exception e) {
            throw new Exception("Unable to get end date" + "\n METHOD:getEndDate \n" + e
                    .getLocalizedMessage());
        }

        return strEndDate;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to get gradebookReview Date
     * @return String
     * @throws Exception
     */
    public String getGradebookReviewDate() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:GETTING GRADEBOOKREVIEW DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtGradebookReviewDate, waitTime);
            strGradebookReviewDate = txtGradebookReviewDate.getAttribute("value");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET Gradebook Review Date" + "\n METHOD:getGradebookReviewDate \n" + e
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
            logInstruction("LOG INSTRUCTION:GETTING HEADER TITLE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            strTableTitle = txtTitle.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET Header Title" + "\n METHOD: getHeaderTitle \n" + e
                    .getLocalizedMessage());
        }
        return strTableTitle;
    }

    /**
     * @category Milestone 2 This method is used to check radio button is selected or not
     * @param String
     * @author Usha
     * @return boolean
     * @throws Exception
     */
    public boolean isRadioButtonSelected(String radioButtonLabel) throws Exception {
        flag = false;

        try {
            logInstruction("LOG INSTRUCTION:CHECKING IF A PARTICULAR RADIO BUTTON SELECTED");
            frameSwitch.switchToPopUpContentFrame();
            radCourseButton.replaceValues(radioButtonLabel);
            if (radCourseButton.isSelected()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT Radio Button" + "\n METHOD:isRadioButtonSelected \n" + e
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
            logInstruction("LOG INSTRUCTION:GETTING TEXT NEXT TO SCHEDULE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            strTableTitle = txtTitle.getText();
            temp = strTableTitle.split(" ");
            strText = temp[2];

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Text Next To Schedule' IN HEADER TITLE" + "\n METHOD: getTextFromFieldNextToSchedule \n" + e
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
            logInstruction("LOG INSTRUCTION:CHECKING IF ALERT DISPLAYED");
            strErrorMessage = uiDriver.getUIAlert().getAlertMessage();

            if (!strErrorMessage.isEmpty()) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'AlertMessage Displayed For'INVALIDDATE" + "\n METHOD:isAlertMessageDisplayedAfterEnteringInvalidDate \n" + e
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
            logInstruction("LOG INSTRUCTION:GETTING ALERT TEXT");
            strTableTitle = uiDriver.getUIAlert().getAlertMessage();
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET Alert Text" + "\n METHOD:getAlertMesssageContentsAfterEnteringInvalidDate \n" + e
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
            logInstruction("LOG INSTRUCTION:CLICK ON CANCEL BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'End Date' BUTTON" + "\n METHOD:clickCancelButton \n" + e
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
            logInstruction("LOG INSTRUCTION:CHECK IF START DATE FIELD IS DISABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseDates, waitTime);
            if (radCourseDates.isSelected()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Start Date Field' Is DISABLED" + "\n METHOD:isStartDateFieldDisabled \n" + e
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
            logInstruction("LOG INSTRUCTION:CHECK IF END DATE FIELD IS DISABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseDates, waitTime);
            if (radCourseDates.isSelected()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'End Date Field' Is DISABLED" + "\n METHOD:isEndDateFieldDisabled \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to Enter Invalid EndDate
     * @param String
     *            endDate
     * @return MicrosoftOfficeDocEditSchedulePage
     * @throws Exception
     */
    public MicrosoftOfficeDocEditSchedulePage enterInvalidEndDate(String endDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTER END DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtEndDate.clearAndSendKeys(endDate);
            // To take focus out click on startdate field
            txtStartDate.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER End Date" + "\n METHOD:enterInvalidEndDate \n" + e
                    .getLocalizedMessage());
        }

        return this;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to Enter Invalid Start Date
     * @param String
     *            StartDate
     * @return MicrosoftOfficeDocEditSchedulePage
     * @throws Exception
     */
    public MicrosoftOfficeDocEditSchedulePage enterInvalidStartDate(String StartDate)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTER START DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtStartDate.clearAndSendKeys(StartDate);
            // To take focus out click on end date field
            txtEndDate.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER End Date" + "\n METHOD:enterInvalidStartDate \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to Enter Invalid Due date
     * @param DueDate
     * @return MicrosoftOfficeDocEditSchedulePage
     * @throws Exception
     */
    public MicrosoftOfficeDocEditSchedulePage enterInvalidDueDate(String DueDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTER DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtDueDate.clearAndSendKeys(DueDate);
            // To take focus out click on end date field
            txtStartDate.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER Due date" + "\n METHOD:enterInvalidDueDate \n" + e
                    .getLocalizedMessage());
        }

        return this;
    }

    /**
     * @category Milestone 2
     * @author Mamatha ,Method is used to Check if error message is Disabled
     * 
     * @return boolean
     * @throws Exception
     */
    public boolean isErrorMessageDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING OF ERROR MESSAGE");
            frameSwitch.switchToPopUpContentFrame();

            if (lblErrorMessage.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Error Message' DISPLAYED" + "\n METHOD:isErrorMessageDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2
     * @author Mamatha , Method used to getErrorMessage
     * @return String
     * @throws Exception
     */
    public String getErrorMessage() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: VERIFYING ERROR MESSAGE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblErrorMessage, waitTime);
            strErrorMessage = lblErrorMessage.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Error Message' DISPLAYED" + "\n METHOD:getErrorMessage \n" + e
                            .getLocalizedMessage());
        }
        return strErrorMessage;
    }

    /**
     * @category Milestone 2 Method helps to click on Save and Close button.
     * @return MicrosoftOfficeDocEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public MicrosoftOfficeDocEditSchedulePage clickSaveAndCloseButtonForInvalidData()
            throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK ON SAVE AND CLOSE BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
            btnSaveAndClose.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK On 'Save And Close' BUTTON" + "\n METHOD:clickSaveAndCloseButtonForInvalidData \n" + e
                            .getLocalizedMessage());
        }

        return new MicrosoftOfficeDocEditSchedulePage(uiDriver);
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
            logInstruction("LOG INSTRUCTION:GET CURRENT DATE");
            Date todayDate = new Date();
            SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");
            strCurrentDate = sdfwithOnlyDate.format(todayDate);

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET Current Date" + "\n METHOD:getCurrentDate \n" + e
                    .getLocalizedMessage());
        }
        return strCurrentDate;
    }

    /**
     * Method helps to get future date
     * 
     * @param int
     * @author ganapati.bhat
     * @return String
     * @throws Exception
     */

    public String getFutureDate(int Days) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:GET FUTURE DATE");
            Date todayDate = new Date();
            SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");
            calendar.setTime(todayDate);
            calendar.add(Calendar.DATE, Days);
            dateAfter = calendar.getTime();
            strAfterDate = sdfwithOnlyDate.format(dateAfter);

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET Future Date" + "\n METHOD:getFutureDate \n" + e
                    .getLocalizedMessage());
        }
        return strAfterDate;
    }

    /**
     * Method helps to get past date
     * 
     * @param int
     * @author ganapati.bhat
     * @return String
     * @throws Exception
     */

    public String getPastDate(int Days) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:GET PAST DATE");

            calendar.setTime(todayDate);
            calendar.add(Calendar.DATE, -Days);
            dateAfter = calendar.getTime();
            strBeforeDate = sdfwithOnlyDate.format(dateAfter);

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET Past Date" + "\n METHOD:getPastDate \n" + e
                    .getLocalizedMessage());
        }
        return strBeforeDate;
    }

}
