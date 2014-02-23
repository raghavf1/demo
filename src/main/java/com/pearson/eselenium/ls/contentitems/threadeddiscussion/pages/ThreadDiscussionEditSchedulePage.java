package com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * @category Milestone 2 Class contains methods related to edit scheduler page
 * @author ganapati.bhat
 * 
 */
public class ThreadDiscussionEditSchedulePage extends BasePageObject {

    /* Elements */
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
    private UIElement lblAsteriskEnd = createElement(
            UIType.Xpath,
            "//tr[td[input[@id='EndDate']]]//td[3]");
    private UIElement lblAsteriskStart = createElement(
            UIType.Xpath,
            "//tr[td[input[@id='StartDate']]]//td[3]");
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
    private UIElement btnClose = createElement(UIType.Xpath, "//input[@value='Cancel']");
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
    private UIElement drpStarttimeSelected = createElement(
            UIType.Xpath,
            "//select[@id='StartTime']//option[@selected='']");
    private UIElement drpEndtimeSelected = createElement(
            UIType.Xpath,
            "//select[@id='EndTime']//option[@selected='']");

    private UIElement lblAsteriskDue = createElement(
            UIType.Xpath,
            "//tr[td[input[@id='DueDate']]]//td[1]");
    private UIElement lblRestrictAccessAfter = createElement(
            UIType.Xpath,
            "//label[@for='RestrictAfter']");
    private UIElement lblRestrictAccessBefore = createElement(
            UIType.Xpath,
            "//label[@for='RestrictBefore']");
    private UIElement lblEndDateCaption = createElement(
            UIType.Xpath,
            "//label[contains(text(),'End')]");
    private UIElement lblStartDateCaption = createElement(
            UIType.Xpath,
            "//label[contains(text(),'Start')]");
    private UIElement lblStartAndEndDates = createElement(
            UIType.Xpath,
            "//td[contains(text(),'Start and End')]");
    private UIElement lblInstructional = createElement(
            UIType.Xpath,
            "//td[@class='inlinemessage2']");

    private Calendar objCalendar = Calendar.getInstance();
    private Date objDateAfter = new Date();

    private static final String DUE_DATE = "Due Date";
    private static final String SAVE_AND_CLOSE = "Save & Close";
    private static final String VALUE = "value";
    private static final String CANCEL = "Cancel";
    private static final String TIMES_ARE_DISPLAYED = " * Times are displayed ";
    private static final String OPTION = "option";
    private static final String DATE_SDF_FORMAT = "M/d/yyyy";

    private boolean flag = false;
    private String strArraytemp[];
    private String strResult = null;
    
    /* Constructor */
    public ThreadDiscussionEditSchedulePage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "ThreadDiscussionEditSchedulePage";
        logInstruction("LOG INSTRUCTION: ## ThreadDiscussion EditSchedulerPage ##");
    }

    /**
     * Method is used to verify the content of grade book review time drop down
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @param String grdTime
     * @return boolean
     * @throws Exception
     */
    public boolean isContentOfGradebookTimeDropdownDisplayed(String strGrdTime) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY THE CONTENT OF GRADE BOOK 'review time dropdown'.");
            frameSwitch.switchToPopUpContentFrame();
            List<WebElement> lstWebElement = drpGradebookTime.findElements(By.tagName("option"));
            for (WebElement objWebElement : lstWebElement) {
                if (objWebElement.getText().contains(strGrdTime)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY THE CONTENT OF GRADE BOOK 'review time dropdown'. \nMETHOD: isContentOfGradebookTimeDropdownDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify grade book asterisk.
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isGradebookAsteriskDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY GRADEBOOK 'Asterisk'");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblAsteriskGradebook, waitTime);
            flag = lblAsteriskGradebook.getText().contains("*");
        } catch (Exception e) {
            throw new Exception(
                    "GRADEBOOK 'Asterisk' IS NOT DISPLAYED. \nMETHOD: isGradebookAsteriskDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify 'due date' caption.
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateCaptionDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY 'Due date' CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblDueDate, waitTime);
            flag = lblDueDate.getText().contains(DUE_DATE);
        } catch (Exception e) {
            throw new Exception(
                    "'Due date' CAPTION IS NOT DISPLAYED. \nMETHOD: isDueDateCaptionDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify 'due date' textBox.
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateTextboxDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: VERIFY 'due date' TEXT BOX");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtDueDate, waitTime);
            return txtDueDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "'due date' TEXTBOX IS NOT DISPLAYED. \nMETHOD: isDueDateTextboxDisplayed()." + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method is used to verify 'due date calendar' icon.
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateCalendarDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY 'due date calendar' ICON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(imgDueDateCalendar, waitTime);
            flag = imgDueDateCalendar.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "'due date calendar' ICON NOT DISPLAYED. \nMETHOD: isDueDateCalendarDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify due date dropdown.
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateDropDownVisible() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY 'due date' DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(drpDueDate, waitTime);
            flag = drpDueDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "'due date' DROPDOWN IS NOT VISIBLE. \nMETHOD: isDueDateDropDownVisible" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify 'Save & Close' button.
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isSaveAndCloseButtonDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY 'Save & Close' BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveClose, waitTime);
            flag = btnSaveClose.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "'Save & Close' BUTTON IS NOT DISPLAYED. \nMETHOD: isSaveAndCloseButtonDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify Caption of 'Save & Close' button.
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isSaveAndCloseButtonCaptionDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY 'Save & Close' BUTTON CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveClose, waitTime);
            flag = btnSaveClose.getAttribute(VALUE).contains(SAVE_AND_CLOSE);
        } catch (Exception e) {
            throw new Exception(
                    "'Save & Close' BUTTON CAPTION IS NOT DISPLAYED. \nMETHOD: isSaveAndCloseButtonCaptionDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify 'Cancel' button
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isCancelButtonDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY 'Cancel' BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            flag = btnCancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "'Cancel' BUTTON IS NOT DISPLAYED. \nMETHOD: isCancelButtonDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify Caption of 'Cancel' button.
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isCancelButtonCaptionDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY 'Cancel' BUTTON CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            flag = btnCancel.getAttribute(VALUE).contains(CANCEL);
        } catch (Exception e) {
            throw new Exception(
                    "'Cancel' BUTTON CAPTION IS NOT DISPLAYED. \nMETHOD: isCancelButtonCaptionDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify instructional text about time zone.
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isInstructionalTextAboutTimeZoneDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY INSTRUCTIONAL TEXT ABOUT TIME ZONE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblTimeZone, waitTime);
            flag = lblTimeZone.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY INSTRUCTIONAL TEXT ABOUT TIME ZONE. \nMETHOD: isInstructionalTextAboutTimeZoneDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify instructional text caption about time zone.
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isInstructionalTextAboutTimeZoneCaptionDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY INSTRUCTIONAL TEXT CAPTION ABOUT TIME ZONE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblTimeZone, waitTime);
            flag = lblTimeZone.getText().contains(TIMES_ARE_DISPLAYED);
        } catch (Exception e) {
            throw new Exception("UNABLE TO VERIFY INSTRUCTIONAL TEXT CAPTION ABOUT TIME ZONE" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to get frame header title.
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String frameHeaderTitle() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET 'frame header' TITLE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblFrameHeader, waitTime);
            strResult = lblFrameHeader.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'frame header' TITLE. \nMETHOD: frameHeaderTitle()." + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to click on Restrict access after check box.
     * 
     * @category Milestone 2
     * @return ThreadDiscussionEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public ThreadDiscussionEditSchedulePage clickRestrictAccessAfterCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:  CLICK ON 'Restrict Access After' CHECKBOX ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessAfter, waitTime);
            chkRestrictAccessAfter.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'Restrict Access After' CHECKBOX.\nMETHOD: clickRestrictAccessAfterCheckBox()." + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to verify Restrict access after check box.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isRestrictAccessAfterCheckBoxDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY 'Restrict Access After' CHECKBOX PRESENT ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessAfter, waitTime);
            flag = chkRestrictAccessAfter.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "'Restrict Access After' CHECKBOX IS NOT PRESENT. \nMETHOD: isRestrictAccessAfterCheckBoxDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click on Restrict access before check box.
     * 
     * @category Milestone 2
     * @return ThreadDiscussionEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public ThreadDiscussionEditSchedulePage clickRestrictAccessBeforeCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:  CLICK ON 'Restrict Access Before' CHECKBOX ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessBefore, waitTime);
            chkRestrictAccessBefore.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'Restrict Access Before' CHECKBOX. \nMETHOD: clickRestrictAccessBeforeCheckBox()." + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to verify Restrict access before check box.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isRestrictAccessBeforeCheckBoxDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY 'Restrict Access Before' CHECKBOX PRESENT ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessBefore, waitTime);
            flag = chkRestrictAccessBefore.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "'Restrict Access Before' CHECKBOX IS NOT PRESENT. \nMETHOD: isRestrictAccessBeforeCheckBoxDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify Asterisk.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isAsteriskStartDateDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY 'Asterisk' PRESENT ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblAsteriskStart, waitTime);
            flag = lblAsteriskStart.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "'Asterisk' IS NOT PRESENT. \nMETHOD: isAsteriskStartDateDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify Asterisk.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isAsteriskEndDateDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY 'Asterisk' PRESENT ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblAsteriskEnd, waitTime);
            flag = lblAsteriskEnd.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "'Asterisk' IS NOT PRESENT. \nMETHOD: isAsteriskEndDateDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify End date caption.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEndDateCaptionDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY END DATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblEndDate, waitTime);
            flag = lblEndDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "END DATE CAPTION IS NOT PRESENT. \nMETHOD: isEndDateCaptionDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify Start date caption.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isStartDateCaptionDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY START DATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblStartDate, waitTime);
            flag = lblStartDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "START DATE CAPTION IS NOT PRESENT. \nMETHOD: isStartDateCaptionDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify calendar for start date.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCalendarStartDateDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY START DATE CALENDAR ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(imgCalendarStart, waitTime);
            flag = imgCalendarStart.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "START DATE CALENDAR IS NOT PRESENT. \nMETHOD: isCalendarStartDateDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify calendar for end date.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCalendarEndDateDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY END DATE CALENDAR ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(imgCalendarEnd, waitTime);
            flag = imgCalendarEnd.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "END DATE CALENDAR IS NOT PRESENT. \nMETHOD: isCalendarEndDateDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify End time dropdown.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEndTimeDropDownDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY END TIME DROPDOWN ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(drpEndTime, waitTime);
            flag = drpEndTime.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "END TIME DROPDOWN IS NOT PRESENT.\nMETHOD: isEndTimeDropDownDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify start time dropdown.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isStartTimeDropDownDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY START TIME DROPDOWN ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(drpEndTime, waitTime);
            flag = drpStartTime.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "START TIME DROPDOWN IS NOT PRESENT. \nMETHOD: isStartTimeDropDownDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify due time dropdown.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isDueTimeDropDownDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY DUE TIME DROPDOWN ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(drpDueTime, waitTime);
            flag = drpDueTime.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "DUE TIME DROPDOWN IS NOT PRESENT. \nMETHOD: isDueTimeDropDownDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify start date text box.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isStartDateTextBoxDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY START DATE TEXTBOX ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtStartdate, waitTime);
            flag = txtStartdate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "START DATE TEXTBOX IS NOT PRESENT.\nMETHOD: isStartDateTextBoxDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify end date text box.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEndDateTextBoxDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY END DATE TEXTBOX ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            flag = txtEndDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "END DATE TEXTBOX IS NOT PRESENT. \nMETHOD: isEndDateTextBoxDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify caption for course start and end date radio button.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCaptionForUseCourseStartandEndDatesRadioButtonDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY START AND END DATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblStartEndDateCaption, waitTime);
            flag = lblStartEndDateCaption.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "START AND END DATE CAPTION IS NOT PRESENT. \nMETHOD: isCaptionForUseCourseStartandEndDatesRadioButtonDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify course start and end date radio button is selected.
     * 
     * @category Milestone 2 Method helps to verify course start and end date radio button is
     *           selected.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCaptionForUseCourseStartandEndDatesRadioButtonSelected() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY START AND END DATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblStartEndDateCaption, waitTime);
            flag = lblStartEndDateCaption.isSelected();
        } catch (Exception e) {
            throw new Exception(
                    "START AND END DATE CAPTION IS NOT PRESENT. \nMETHOD: isCaptionForUseCourseStartandEndDatesRadioButtonSelected()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click course start and end date radio button.
     * 
     * @category Milestone 2
     * @return ThreadDiscussionEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public ThreadDiscussionEditSchedulePage clickUseCourseStartandEndDatesRadioButton()
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:  CLICK USE COURSE START END DATE RADIO BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseStartEndDate, waitTime);
            radCourseStartEndDate.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK USE COURSE START END DATE RADIO BUTTON. \nMETHOD: clickUseCourseStartandEndDatesRadioButton()." + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to verify caption for use the following date radio button.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCaptionForUseTheFollowingDatesRadioButtonDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY START AND END DATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblUseFollowingDateCaption, waitTime);
            flag = lblUseFollowingDateCaption.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "START AND END DATE CAPTION IS NOT PRESENT. \nMETHOD: isCaptionForUseTheFollowingDatesRadioButtonDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click on use following dates radio button.
     * 
     * @category Milestone 2
     * @return ThreadDiscussionEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public ThreadDiscussionEditSchedulePage clickUseFollowingDatesRadioButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:  CLICK 'use following date' RADIO BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radUseFollowingDate, waitTime);
            radUseFollowingDate.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK 'use following date' RADIO BUTTON. \nMETHOD: clickUseFollowingDatesRadioButton()." + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to click on Save and Close button.
     * 
     * @throws Exception
     * @author saurabh.jain1
     */
    public void clickSaveAndCloseButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:  CLICK 'save and close' BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
            btnSaveAndClose.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK SAVE AND CLOSE BUTTON. \nMETHOD: clickSaveAndCloseButton()." + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method helps to verify the content of end time drop down.
     * 
     * @category Milestone 2
     * @param strEndTime
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEndTimeDisplayedInDropDown(String strEndTime) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY CONTENT OF END TIME DROPDOWN");
            if (StringUtils.isBlank(strEndTime))
                throw new Exception(
                        "UNABLE TO VERIFY CONTENT OF END TIME DROPDOWN. END TIME IS NULL \nMETHOD: isEndTimeDisplayedInDropDown().");

            frameSwitch.switchToPopUpContentFrame();
            List<WebElement> lstWebElement = drpEndTime.findElements(By.tagName(OPTION));
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
     * Method helps to verify the content of start time drop down.
     * 
     * @category Milestone 2
     * @param String
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isStartTimeDisplayedInDropDown(String strStartTime) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY CONTENT OF END TIME DROPDOWN");
            if (StringUtils.isBlank(strStartTime))
                throw new Exception(
                        "UNABLE TO VERIFY CONTENT OF END TIME DROPDOWN. START TIME IS NULL \nMETHOD: isEndTimeDisplayedInDropDown().");

            frameSwitch.switchToPopUpContentFrame();
            List<WebElement> lstWebElement = drpStartTime.findElements(By.tagName(OPTION));
            for (WebElement objWebElement : lstWebElement) {
                if (objWebElement.getText().contains(strStartTime)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY CONTENT OF END TIME DROPDOWN. \nMETHOD: isStartTimeDisplayedInDropDown()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify grade book text box.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isGradeboobReviewTextBoxDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY GRADEBOOK TEXTBOX ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtGradebookReview, waitTime);
            flag = txtGradebookReview.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "VERIFY GRADEBOOK TEXTBOX IS NOT PRESENT.\nMETHOD: isGradeboobReviewTextBoxDisplayed()." + e
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
            logInstruction("LOG INSTRUCTION:  VERIFY GRADEBOOK CALENDAR ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(imgCalendarGradebookReview, waitTime);
            flag = imgCalendarGradebookReview.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "GRADEBOOK CALENDAR IS NOT PRESENT. \nMETHOD: isCalendarGradebookDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to enter start date.
     * 
     * @category Milestone 2
     * @param startDate
     * @return ThreadDiscussionEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public ThreadDiscussionEditSchedulePage enterStartDate(String strStartDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR START DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtStartdate, waitTime);
            txtStartdate.clearAndSendKeys(strStartDate);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER START DATE. \nMETHOD: enterStartDate()." + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to enter due date.
     * 
     * @category Milestone 2
     * @param dueDate
     * @return ThreadDiscussionEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public ThreadDiscussionEditSchedulePage enterDueDate(String strDueDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtDueDate, waitTime);
            txtDueDate.sendKeys(strDueDate);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER DUE DATE. \nMETHOD: enterDueDate()." + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to get value entered in due date.
     * 
     * @category Milestone 2
     * @param 
     * @return String
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getDueDate() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtDueDate, waitTime);
            strResult = txtDueDate.getAttribute("value");
        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception("UNABLE TO ENTER DUE DATE. \nMETHOD: getDueDate()." + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to enter gradebook review date.
     * 
     * @category Milestone 2
     * @param strDueDate
     * @return ThreadDiscussionEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public ThreadDiscussionEditSchedulePage enterGradebookReviewDate(String strDueDate)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR GRADEBOOK REVIEW DATE");
            if (StringUtils.isBlank(strDueDate))
                throw new Exception(
                        "UNABLE TO ENTER GRADEBOOK REVIEW DATE IT IS NULL . \nMETHOD: enterGradebookReviewDate().");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtGradebookReview, waitTime);
            txtGradebookReview.sendKeys(strDueDate);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER GRADEBOOK REVIEW DATE. \nMETHOD: enterGradebookReviewDate()." + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to get start date.
     * 
     * @category Milestone 2
     * @author Usha
     * @return String
     * @throws Exception
     */
    public String getStartDate() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING START DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtStartDate, waitTime);
            strResult = txtStartDate.getAttribute("value");
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET START DATE.\nMETHOD: getStartDate" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to Enter end date.
     * 
     * @category Milestone 2
     * @author Usha
     * @param endDate
     * @return ThreadDiscussionEditSchedulePage
     * @throws Exception
     */
    public ThreadDiscussionEditSchedulePage enterEndDate(String strEndDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER END DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtEndDate.clearAndSendKeys(strEndDate);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER END DATE. \nMETHOD: enterEndDate()." + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to get end date.
     * 
     * @category Milestone 2
     * @author Usha
     * @return String
     * @throws Exception
     */
    public String getEndDate() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING END DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            strResult = txtEndDate.getAttribute(VALUE);
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET END DATE.\nMETHOD: getEndDate()." + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to get gradebookReview Date.
     * 
     * @category Milestone 2
     * @author Usha
     * @return String
     * @throws Exception
     */
    public String getGradebookReviewDate() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING GRADEBOOKREVIEW DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtGradebookReviewDate, waitTime);
            strResult = txtGradebookReviewDate.getAttribute(VALUE);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET GRADEBOOKREVIEW DATE. \nMETHOD: getGradebookReviewDate()." + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to get header title
     * 
     * @category Milestone 2
     * @author Usha
     * @return String
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING HEADER TITLE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            strResult = txtTitle.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET HEADER TITLE. \nMETHOD: getHeaderTitle()." + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method is used to check radio button is selected or not.
     * 
     * @category Milestone 2
     * @author Usha
     * @param String
     * @return boolean
     * @throws Exception
     **/
    public boolean isRadioButtonSelected(String strRadioButtonLabel) throws Exception {
    	flag = false;
        logInstruction("LOG INSTRUCTION: CHECKING IF A PARTICULAR RADIO BUTTON SELECTED");
        try {
            frameSwitch.switchToPopUpContentFrame();
            radCourseButton.replaceValues(strRadioButtonLabel);
            flag = radCourseButton.isSelected();
        } catch (Exception e) {
            throw new Exception(
                    "RADIO BUTTON IS NOT  SELECTED. \nMETHOD:  isRadioButtonSelected()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get text next to schedule in header title.
     * 
     * @category Milestone 2
     * @author Usha ,
     * @return String
     * @throws Exception
     */
    public String getTextFromFieldNextToSchedule() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING TEXT NEXT TO SCHEDULE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            strArraytemp = txtTitle.getText().split(" ");
            strResult = strArraytemp[2];
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET TEXT NEXT TO SCHEDULE IN HEADER TITLE. \nMETHOD: getTextFromFieldNextToSchedule()." + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method is used to check if alert displayed.
     * 
     * @category Milestone 2
     * @author Usha
     * @return boolean throws Exception
     */
    public boolean isAlertMessageDisplayedAfterEnteringInvalidDate() throws Exception {
    	flag = false;
        logInstruction("LOG INSTRUCTION: CHECKING IF ALERT DISPLAYED");
        try {
            uiDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            uiDriver.switchTo().alert();
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "LABEL IS NOT DISPLAYED .\nMETHOD: isAlertMessageDisplayedAfterEnteringInvalidDate()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get alert text.
     * 
     * @category Milestone 2
     * @author Usha
     * @return String
     * @throws Exception
     */
    public String getAlertMesssageContentsAfterEnteringInvalidDate() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING ALERT TEXT");
            strResult = uiDriver.getUIAlert().acceptAlertIfPresentAndGetMessage(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET ALERT TEXT. \nMETHOD: getAlertMesssageContentsAfterEnteringInvalidDate()." + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method is used to click on the cancel button.
     * 
     * @category Milestone 2
     * @author ganapati
     * @throws Exception
     */
    public void clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON THE 'Cancel' BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnClose, waitTime);
            btnClose.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE 'Cancel' BUTTON. \nMETHOD: clickCancelButton()." + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method is used to Check if Start Date Field is Disabled.
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isStartDateFieldDisabled() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK IF START DATE FIELD IS DISABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseDates, waitTime);
            flag = radCourseDates.isSelected();
        } catch (Exception e) {
            throw new Exception(
                    "CHECK IF START DATE FIELD IS DISABLED. \nMETHOD: isStartDateFieldDisabled()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to Check if End Date Field is Disabled.
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isEndDateFieldDisabled() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK IF END DATE FIELD IS DISABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseDates, waitTime);
            flag = radCourseDates.isSelected();
        } catch (Exception e) {
            throw new Exception(
                    "CHECK IF END DATE FIELD IS DISABLED. \nMETHOD: isEndDateFieldDisabled()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to Enter end date.
     * 
     * @category Milestone 2
     * @author Usha
     * @param String
     * @return ThreadDiscussionEditSchedulePage
     * @throws Exception
     */
    public ThreadDiscussionEditSchedulePage enterInvalidEndDate(String strEndDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER END DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtEndDate.clearAndSendKeys(strEndDate);
            txtStartDate.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER END DATE. \nMETHOD: enterInvalidEndDate()." + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to Enter end date.
     * 
     * @category Milestone 2
     * @author Usha
     * @param String
     * @return ThreadDiscussionEditSchedulePage
     * @throws Exception
     */
    public ThreadDiscussionEditSchedulePage enterInvalidStartDate(String strEndDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER START DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtStartDate.clearAndSendKeys(strEndDate);
            txtEndDate.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER END DATE. \nMETHOD: enterInvalidStartDate()." + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to Enter end date.
     * 
     * @category Milestone 2
     * @author Usha
     * @param String
     * @return ThreadDiscussionEditSchedulePage
     * @throws Exception
     */
    public ThreadDiscussionEditSchedulePage enterInvalidDueDate(String strEndDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtDueDate.clearAndSendKeys(strEndDate);
            txtStartDate.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER END DATE. \nMETHOD: enterInvalidDueDate()." + e
                    .getLocalizedMessage());
        }

        return this;
    }

    /**
     * Method is used to Check if error message is Disabled
     * 
     * @category Milestone 2
     * @author Mamatha
     * @return boolean
     * @throws Exception
     */
    public boolean isErrorMessageDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: LOG INSTRUCTION: VERIFICATION OF ERROR MESSAGE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblErrorMessage, waitTime);
            flag = lblErrorMessage.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ERROR MESSAGE IS NOT DISPLAYING. \nMETHOD: isErrorMessageDisplayed()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method used to getErrorMessage.
     * 
     * @category Milestone 2
     * @author Mamatha
     * @return String
     * @throws Exception
     */
    public String getErrorMessage() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: VERIFICATION OF ERROR MESSAGE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblErrorMessage, waitTime);
            strResult = lblErrorMessage.getText();
        } catch (Exception e) {
            throw new Exception("ERROR MESSAGE IS NOT DISPLAYING. \nMETHOD: getErrorMessage()." + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to click on Save and Close button.
     * 
     * @category Milestone 2
     * @return String
     * @throws Exception
     * @author saurabh.jain1
     */
    public String clickSaveAndCloseButtonForInvalidData(String strData) throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION:  CLICK SAVE AND CLOSE BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
            btnSaveAndClose.clickAndWait(waitTime);
            if (!strData.equalsIgnoreCase("")) {
                strResult = uiDriver.getUIAlert().getAlertMessage();
                uiDriver.getUIAlert().acceptAlertIfPresent();
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK SAVE AND CLOSE BUTTON. \nMETHOD: clickSaveAndCloseButtonForInvalidData()." + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to get the current date
     * 
     * @author ganapati.bhat
     * @return String
     * @throws Exception
     */

    public String getCurrentDate() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET CURRENT DATE");
            Date todayDate = new Date();
            SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat(DATE_SDF_FORMAT);
            strResult = sdfwithOnlyDate.format(todayDate);
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET CURRENT DATE. \nMETHOD: getCurrentDate()." + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to get future date
     * 
     * @author ganapati.bhat
     * @param int
     * @return String
     * @throws Exception
     */

    public String getFutureDate(int intDays) throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET FUTURE DATE");
            Date todayDate = new Date();
            SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat(DATE_SDF_FORMAT);
            objCalendar.setTime(todayDate);
            objCalendar.add(Calendar.DATE, intDays);
            objDateAfter = objCalendar.getTime();
            strResult = sdfwithOnlyDate.format(objDateAfter);
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET FUTURE DATE. \nMETHOD: getFutureDate()." + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to get past date
     * 
     * @author ganapati.bhat
     * @return String
     * @param int
     * @throws Exception
     */

    public String getPastDate(int intDays) throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET FUTURE DATE");
            Date todayDate = new Date();
            SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat(DATE_SDF_FORMAT);
            objCalendar.setTime(todayDate);
            objCalendar.add(Calendar.DATE, -intDays);
            objDateAfter = objCalendar.getTime();
            strResult = sdfwithOnlyDate.format(objDateAfter);
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET PAST DATE. \nMETHOD: getPastDate()." + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to get the start time
     * 
     * @author ganapati.bhat
     * @return String
     * @throws Exception
     */

    public String getStartTime() throws Exception {
    	strResult = null;
    	try {
            logInstruction("LOG INSTRUCTION: GET THE START TIME.");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(drpStarttimeSelected, waitTime);
            strResult = drpStarttimeSelected.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET START TIME. \nMETHOD: getStartTime()." + e
                    .getLocalizedMessage());
        }
    	return strResult;
    }

    /**
     * Method helps to get the end time
     * 
     * @author ganapati.bhat
     * @return String
     * @throws Exception
     */

    public String getEndTime() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET THE END TIME");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(drpEndtimeSelected, waitTime);
            strResult = drpEndtimeSelected.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET END TIME. \nMETHOD: getEndTime()." + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method is used to verify instructional text
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isInstructionalTextDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:verify instructional text");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblInstructional, waitTime);
            if (!lblInstructional.getText().isEmpty()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO VERIFY INSTRUCTIONAL TEXT . \nMETHOD: isInstructionalTextDisplayed." + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get instructional text.
     * 
     * @category MileStone 2
     * @return String
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getInstructionalText() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION:get instructional text");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblInstructional, waitTime);
            strResult = lblInstructional.getText();

        } catch (Exception e) {
                throw new Exception("UNABLE TO GET INSTRUCTIONAL TEXT . \nMETHOD: getInstructionalText." + e
                        .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to verify start end date caption.
     * 
     * @return boolean
     * @category MileStone 2
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isStartEndDateLabelDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: verify instructional text");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblStartAndEndDates, waitTime);
            if (lblStartAndEndDates.isDisplayed()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO VERIFY START END DATE DISPLAY . \nMETHOD: isStartEndDateLabelDisplayed." + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get start end date caption.
     * 
     * @return String
     * @category MileStone 2
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getStartEndDateLabelCaption() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION:verify start end date caption text");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblStartAndEndDates, waitTime);
            strResult = lblStartAndEndDates.getText();

        } catch (Exception e) {
           throw new Exception("UNABLE TO VERIFY START END DATE CAPTION TEXT . \nMETHOD: getStartEndDateLabelCaption." + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to get start date caption.
     * 
     * @return String
     * @category MileStone 2
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getStartDateCaption() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION:verify start date caption text");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblStartDateCaption, waitTime);
            strResult = lblStartDateCaption.getText();

        } catch (Exception e) {
            throw new Exception("UNABLE TO VERIFY START DATE CAPTION TEXT . \nMETHOD: getStartDateCaption." + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to get caption of End date
     * 
     * @return
     * @category MileStone 2
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getEndDateCaption() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION:verify end date caption text");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblEndDateCaption, waitTime);
            strResult = lblEndDateCaption.getText();

        } catch (Exception e) {
            throw new Exception("UNABLE TO VERIFY END DATE CAPTION TEXT . \nMETHOD: getStartDateCaption." + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method is used to check radio button is selected or not
     * 
     * @author Usha
     * @param  String
     * @return boolean 
     * @throws Exception
     */
    public boolean isRadioButtonDisplayed(String strRadioButtonLabel) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:checking if a particular radio button displayed");
            frameSwitch.switchToPopUpContentFrame();
            radCourseButton.replaceValues(strRadioButtonLabel);
            if (radCourseButton.isDisplayedAfterWaiting(waitTime))
                flag = true;
        } catch (Exception e) {
            throw new Exception("RADIO BUTTON IS NOT DISPLAYED . \nMETHOD: isRadioButtonDisplayed." + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get caption of restrict access before checkbox.
     * 
     * @return String
     * @category MileStone 2
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getRestrictAccessBeforeCheckBoxCaption() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: Get Restrict Access Before CheckBox present ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblRestrictAccessBefore, waitTime);
            strResult = lblRestrictAccessBefore.getText();

        } catch (Exception e) {
            throw new Exception("RESTRICT ACCESS BEFORE CHECKBOX IS NOT PRESENT . \nMETHOD: getRestrictAccessBeforeCheckBoxCaption." + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to get caption of restrict access before checkbox.
     * 
     * @return String
     * @category MileStone 2
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getRestrictAccessAfterCheckBoxCaption() throws Exception {
        strResult = null;
        try {
            logInstruction(" LOG INSTRUCTION:VERIFY RESTRICT ACCESS AFTER CHECKBOX PRESENT ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblRestrictAccessAfter, waitTime);
            strResult = lblRestrictAccessAfter.getText();

        } catch (Exception e) {
            throw new Exception("RESTRICT ACCESS AFTER CHECKBOX IS NOT PRESENT . \nMETHOD: getRestrictAccessAfterCheckBoxCaption." + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to verify Asterisk after due date.
     * 
     * @category MileStone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isAsteriskDueDateDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction(" LOG INSTRUCTION:VERIFY ASTERISK PRESENT AFTER DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblAsteriskDue, waitTime);

            if (lblAsteriskDue.getText().contains("*")) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception("ASTERISK IS NOT PRESENT AFTER DUE DATE . \nMETHOD: isAsteriskDueDateDisplayed." + e
                    .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify whether Restrict access before check box is disabled.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author Mamatha
     */
    public boolean isRestrictAccessBeforeCheckBoxDisabled() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY 'RESTRICT ACCESS BEFORE' CHECKBOX DISABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessBefore, waitTime);
            if (chkRestrictAccessBefore.getAttribute("disabled").contains(""))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Restrict Access Before' CHECKBOX IS DISABLED. \nMETHOD: isRestrictAccessBeforeCheckBoxDisabled()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify whether Restrict access before check box is disabled.
     * 
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     * @author Mamatha
     */
    public boolean isRestrictAccessAfterCheckBoxDisabled() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  VERIFY 'RESTRICT ACCESS AFTER' CHECKBOX DISABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessAfter, waitTime);
            if (chkRestrictAccessAfter.getAttribute("disabled").contains(""))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Restrict Access After' CHECKBOX IS DISABLED. \nMETHOD: isRestrictAccessAfterCheckBoxDisabled()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * METHOD IS USED TO SCHEDULE DATE
     * 
     * @author Pratush.Manglik
     * @param userCourseHomeDates
     * @param strStartDate
     * @param strEndDate
     * @param strDueDate
     * @param chkRestrictAcessBefore
     * @param chkRestrictAcessAfter
     * @throws Exception
     */
    public void scheduleDate(
            boolean flagUserCourseHomeDates,
            String strStartDate,
            String strEndDate,
            String strDueDate,
            boolean flagChkRestrictAcessBefore,
            boolean flagChkRestrictAcessAfter) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : SCHEDULE DATE");
            frameSwitch.switchToPopUpContentFrame();

            logInstruction("LOG INSTRUCTION:  CLICK USE COURSE START END DATE RADIO BUTTON ");
            uiDriver.waitToBeDisplayed(radCourseStartEndDate, waitTime);
            radCourseStartEndDate.clickAndWait(waitTime);

            logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR START DATE");
            uiDriver.waitToBeDisplayed(txtStartdate, waitTime);
            txtStartdate.clearAndSendKeys(strStartDate);

            logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR END DATE");
            frameSwitch.switchToPopUpContentFrame();
            txtEndDate.clearAndSendKeys(strEndDate);

            logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            txtDueDate.sendKeys(strDueDate);

            logInstruction("LOG INSTRUCTION:  CLICK ON 'Restrict Access Before' CHECKBOX ");
            if (flagChkRestrictAcessBefore == true) {
                uiDriver.waitToBeDisplayed(chkRestrictAccessBefore, waitTime);
                chkRestrictAccessBefore.clickAndWait(waitTime);
            }

            logInstruction("LOG INSTRUCTION:  CLICK ON 'Restrict Access After' CHECKBOX ");
            if (flagChkRestrictAcessAfter == true) {
                uiDriver.waitToBeDisplayed(chkRestrictAccessAfter, waitTime);
                chkRestrictAccessAfter.clickAndWait(waitTime);
            }

            logInstruction("LOG INSTRUCTION:  CLICK 'save and close' BUTTON ");
            uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
            btnSaveAndClose.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO SCHEDULE DATE" + "\n METHOD : scheduleDate \n" + e
                    .getLocalizedMessage());
        }
    }
}
