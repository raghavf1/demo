package com.pearson.eselenium.ls.contentitems.textmultimedia.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.DatePickerPage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * @category Milestone 2 Class contains methods related to edit scheduler page
 * @author ganapati.bhat
 * 
 */
public class TextMultimediaEditSchedulePage extends BasePageObject {

    /* elements */

    private UIElement drpGradebookTime = createElement(UIType.ID, "GBReviewTime");
    private UIElement lblAsteriskGradebook = createElement(
            UIType.Xpath,
            "//td[contains(@colspan,'3')]/text()");
    private UIElement lblDueDate = createElement(
            UIType.Xpath,
            "xpath=//label[contains(@for,'DueDate')]");
    private UIElement txtDueDate = createElement(UIType.Xpath, "//input[contains(@id,'DueDate')]");
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

    private UIElement btnSaveAndClose = createElement(
            UIType.Xpath,
            "//input[@value='Save & Close']");
    private UIElement radCourseStartEndDate = createElement(
            UIType.Xpath,
            "//input[@id='IsScheduleInheritedYes']");
    private UIElement radUseFollowingDate = createElement(
            UIType.Xpath,
            "//input[@id='IsScheduleInheritedNo']");

    private UIElement lblAsteriskEnd = createElement(UIType.Xpath, "");
    private UIElement lblAsteriskStart = createElement(UIType.Xpath, "");

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

    private UIElement txtStartDate = createElement(UIType.Xpath, "//input[@id='StartDate']");
    private UIElement txtGradebookReviewDate = createElement(UIType.ID, "GBReviewDate");
    private UIElement txtTitle = createElement(UIType.Xpath, "//h1/div[@class='tablehead']");
    private UIElement radCourseButton = createElement(
            UIType.Xpath,
            "//tr[td[label[contains(.,'{1}')]]]//input");
    private UIElement lblErrorMessage = createElement(
            UIType.Xpath,
            "//td[@class='inlineerror']//tr//td[2]");

    private UIElement imgStartDatePicker = createElement(
            UIType.Xpath,
            "//img[contains(@alt,'Pick Start Date')]");
    private UIElement imgEndDatePicker = createElement(
            UIType.Xpath,
            "//img[contains(@alt,'Pick End Date')]");
    private UIElement imgDueDatePicker = createElement(
            UIType.Xpath,
            "//img[contains(@alt,'Pick Due Date')]");
    private UIElement radUnitStartandEndDates = createElement(
            UIType.Xpath,
            "//tr[td[label[contains(.,'{1}')]]]//td//input");

    static Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    Date dateAfter = new Date();

    private static final String DUE_DATE = "Due Date";
    private static final String VALUE = "value";
    private static final String SAVE_AND_CLOSE = "Save & Close";
    private static final String CANCEL = "Cancel";
    private static final String TIMES_ARE_DISPLAYED = " * Times are displayed ";
    private static final String OPTION = "option";
    boolean flag = false;
    String strTempArr[];
    String strTitle = null;
    private String strResult = null;

    
    /* Constructor */
    public TextMultimediaEditSchedulePage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## TextMultimedia EditSchedulerPage ##");
    }

    /**
     * @category Milestone 2 Method is used to verify the content of grade book review time dropdown
     * @author Pratush.Manglik
     * @param strGrdTime
     * @return boolean
     * @throws Exception
     */
    public boolean isContentOfGradebookTimeDropdownDisplayed(String strGrdTime) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY THE CONTENT OF GRADE BOOK REVIEW TIME DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();
            List<WebElement> lstWebElement = drpGradebookTime.findElements(By.tagName(OPTION));
            for (WebElement objWebElement : lstWebElement) {
                if (objWebElement.getText().contains(strGrdTime)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Content Of Grade Book Review Time Dropdown' \n METHOD:isContentOfGradebookTimeDropdownDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION: VERIFY GRADEBOOK ASTERISK");
            frameSwitch.switchToPopUpContentFrame();

            if (!lblAsteriskGradebook.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Grade Book Asterisk' DOES NOT EXISTS");

            if (lblAsteriskGradebook.getText().contains("*")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Grade Book Asterisk' \n METHOD:isGradebookAsteriskDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION: VERIFY DUE DATE CAPTION");
            frameSwitch.switchToPopUpContentFrame();

            if (!lblDueDate.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Due Date' DOES NOT EXISTS");

            if (lblDueDate.getText().contains(DUE_DATE)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Due Date Caption' \n METHOD:isDueDateCaptionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify due date caption
     * @author Pratush.Manglik
     * @param String
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateCaptionDisplayed(String strDueDate) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY DUE DATE CAPTION");
            frameSwitch.switchToPopUpContentFrame();

            if (!lblDueDate.isDisplayedAfterWaiting(waitTime) && StringUtils.isNotBlank(strDueDate))
                throw new Exception("'Due Date' DOES NOT EXISTS");

            if (lblDueDate.getText().contains(strDueDate)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Due Date Caption' \n METHOD:isDueDateCaptionDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION: VERIFY DUE DATE TEXT BOX");
            frameSwitch.switchToPopUpContentFrame();
            flag =  txtDueDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Due Date Textbox' \n METHOD:isDueDateTextboxDisplayed \n" + e
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
        try {
            logInstruction("LOG INSTRUCTION: VERIFY DUE DATE CALENDAR ICON");
            frameSwitch.switchToPopUpContentFrame();
            return imgDueDateCalendar.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Due Date Calendar' \n METHOD:isDueDateCalendarDisplayed \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * @category Milestone 2 Method is used to verify due date dropdown
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateDropDownVisible() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: VERIFY DUE DATE DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();
            return drpDueDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Due Date Dropdown' \n METHOD:isDueDateDropDownVisible \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * @category Milestone 2 Method is used to verify Save & Close button
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isSaveAndCloseButtonDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: VERIFY SAVE & CLOSE BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            return btnSaveClose.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Save & Close Button' \n METHOD:isSaveAndCloseButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
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
            logInstruction("LOG INSTRUCTION: VERIFY SAVE & CLOSE BUTTON CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            if (!btnSaveClose.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Save & Close Button' DOES NOT EXISTS");

            if (btnSaveClose.getAttribute(VALUE).contains(SAVE_AND_CLOSE)) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Save & Close Button' \n METHOD:isSaveAndCloseButtonCaptionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify Caption of Save & Close button
     * @author Pratush.Manglik
     * @return boolean
     * @param String
     * @throws Exception
     */
    public boolean isSaveAndCloseButtonCaptionDisplayed(String strCaption) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY SAVE & CLOSE BUTTON CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            if (!btnSaveClose.isDisplayedAfterWaiting(waitTime) && StringUtils
                    .isNotBlank(strCaption))
                throw new Exception("'Save & Close Button' DOES NOT EXISTS");

            if (btnSaveClose.getAttribute(VALUE).contains(strCaption)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Save & Close Button' \n METHOD:isSaveAndCloseButtonCaptionDisplayed \n" + e
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
        try {
            logInstruction("LOG INSTRUCTION: VERIFY CANCEL BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            return btnCancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Cancel Button' \n METHOD:isCancelButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
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
            logInstruction("LOG INSTRUCTION: VERIFY CANCEL BUTTON CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            if (!btnCancel.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Cancel Button' DOES NOT EXISTS");

            if (btnCancel.getAttribute(VALUE).contains(CANCEL)) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Cancel Button's Caption' \n METHOD:isCancelButtonCaptionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to verify Caption of Cancel button
     * @author Pratush.Manglik
     * @return boolean
     * @param String
     * @throws Exception
     */
    public boolean isCancelButtonCaptionDisplayed(String strCaption) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY CANCEL BUTTON CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            if (!btnCancel.isDisplayedAfterWaiting(waitTime) && StringUtils.isNotBlank(strCaption))
                throw new Exception("'Cancel Button' DOES NOT EXISTS");

            if (btnCancel.getAttribute(VALUE).contains(strCaption)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Cancel Button's Caption' \n METHOD:isCancelButtonCaptionDisplayed \n" + e
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
        try {
            logInstruction("LOG INSTRUCTION: VERIFY INSTRUCTIONAL TEXT ABOUT TIME ZONE");
            frameSwitch.switchToPopUpContentFrame();
            return lblTimeZone.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Instructional Text About TimeZone' \n METHOD:isInstructionalTextAboutTimeZoneDisplayed \n" + e
                            .getLocalizedMessage());

        }
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
            logInstruction("LOG INSTRUCTION: VERIFY INSTRUCTIONAL TEXT CAPTION ABOUT TIME ZONE");
            frameSwitch.switchToPopUpContentFrame();
            if (!lblTimeZone.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Instructional Text About Time Zone' DOES NOT EXISTS");

            if (lblTimeZone.getText().contains(TIMES_ARE_DISPLAYED)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Instructional Text About Time Zone Caption' \n METHOD:isInstructionalTextAboutTimeZoneCaptionDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION: GET FRAME HEADER TITLE");
            frameSwitch.switchToPopUpContentFrame();
            if (!lblFrameHeader.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Frame Header Title' DOES NOT EXISTS");
            return lblFrameHeader.getText();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Frame Header Title' \n METHOD: frameHeaderTitle\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * @category Milestone 2 Method helps to click on Restrict access after check box.
     * @return TextMultimediaEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public TextMultimediaEditSchedulePage clickRestrictAccessAfterCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON RESTRICT ACCESS AFTER CHECKBOX");
            frameSwitch.switchToPopUpContentFrame();
            if (!chkRestrictAccessAfter.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Restrict Access After CheckBox' DOES NOT EXISTS");
            chkRestrictAccessAfter.clickAndWait(waitTime);
        } catch (Exception e) {
        	throw new Exception("LOG INSTRUCTION: unable to click on Restrict Access After CheckBox" + e
                    .getLocalizedMessage());         
        }
        return new TextMultimediaEditSchedulePage(uiDriver);
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
            logInstruction("LOG INSTRUCTION: VERIFY RESTRICT ACCESS AFTER CHECKBOX PRESENT");
            frameSwitch.switchToPopUpContentFrame();
            flag = chkRestrictAccessAfter.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Restrict Access After CheckBox' \n METHOD: isRestrictAccessAfterCheckBoxDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method helps to click on Restrict access before check box.
     * @return TextMultimediaEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public TextMultimediaEditSchedulePage clickRestrictAccessBeforeCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON RESTRICT ACCESS BEFORE CHECKBOX");
            frameSwitch.switchToPopUpContentFrame();
            if (!chkRestrictAccessBefore.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Restrict Access Before CheckBox' DOES NOT EXISTS");
            chkRestrictAccessBefore.clickAndWait(waitTime);
        } catch (Exception e) {
        	throw new Exception("LOG INSTRUCTION: unable to click on Restrict Access Before CheckBox" + e
                    .getLocalizedMessage());
        }
        return new TextMultimediaEditSchedulePage(uiDriver);
    }

    /**
     * @category Milestone 2 Method helps to verify Restrict access before check box.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isRestrictAccessBeforeCheckBoxDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: VERIFY RESTRICT ACCESS BEFORE CHECKBOX PRESENT");
            frameSwitch.switchToPopUpContentFrame();
            return chkRestrictAccessBefore.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Restrict Access Before CheckBox' \n METHOD: isRestrictAccessBeforeCheckBoxDisplayed\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * @category Milestone 2 Method helps to verify Asterisk.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isAsteriskStartDateDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: VERIFY ASTERISK PRESENT");
            frameSwitch.switchToPopUpContentFrame();
            return lblAsteriskStart.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Asterisk In Start Date' \n METHOD: isAsteriskStartDateDisplayed\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * @category Milestone 2 Method helps to verify Asterisk.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isAsteriskEndDateDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: VERIFY ASTERISK PRESENT");
            frameSwitch.switchToPopUpContentFrame();
            return lblAsteriskEnd.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Asterisk In End Date' \n METHOD: isAsteriskEndDateDisplayed\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * @category Milestone 2 Method helps to verify End date caption.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEndDateCaptionDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: VERIFY END DATE CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            return lblEndDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'End Date Caption' \n METHOD: isEndDateCaptionDisplayed\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * @category Milestone 2 Method helps to verify Start date caption.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isStartDateCaptionDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: VERIFY START DATE CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            return lblStartDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Start Date Caption' \n METHOD: isStartDateCaptionDisplayed\n" + e
                            .getLocalizedMessage());
        }
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
            logInstruction("LOG INSTRUCTION: VERIFY START DATE CALENDAR");
            frameSwitch.switchToPopUpContentFrame();
            flag = imgCalendarStart.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Calendar Start Date' \n METHOD: isCalendarStartDateDisplayed\n" + e
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
            logInstruction("LOG INSTRUCTION: VERIFY END DATE CALENDAR");
            frameSwitch.switchToPopUpContentFrame();
            flag = imgCalendarEnd.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Calendar End Date' \n METHOD: isCalendarEndDateDisplayed\n" + e
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
            logInstruction("LOG INSTRUCTION: VERIFY END TIME DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();
            flag = drpEndTime.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'End Time DropDown' \n METHOD: isEndTimeDropDownDisplayed\n" + e
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
            logInstruction("LOG INSTRUCTION: VERIFY START TIME DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();
            flag = drpEndTime.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Start Time DropDown' \n METHOD: isStartTimeDropDownDisplayed\n" + e
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
            logInstruction("LOG INSTRUCTION: VERIFY DUE TIME DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();
            flag = drpDueTime.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Due Time DropDown' \n METHOD: isDueTimeDropDownDisplayed\n" + e
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
        try {
        	flag = false;
            logInstruction("LOG INSTRUCTION: VERIFY START DATE TEXTBOX");
            frameSwitch.switchToPopUpContentFrame();
            flag = txtStartdate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Start Date TextBox' \n METHOD: isStartDateTextBoxDisplayed\n" + e
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
            logInstruction("LOG INSTRUCTION: VERIFY END DATE TEXTBOX");
            frameSwitch.switchToPopUpContentFrame();
            flag = txtEndDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'End Date TextBox' \n METHOD: isEndDateTextBoxDisplayed\n" + e
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
            logInstruction("LOG INSTRUCTION: VERIFY START AND END DATE CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            flag = lblStartEndDateCaption.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Caption For Use Course Start and End Dates RadioButton' \n METHOD: isCaptionForUseCourseStartandEndDatesRadioButtonDisplayed\n" + e
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
    public boolean isCaptionForUseCourseStartandEndDatesRadioButtonSelected() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: VERIFY CAPTION FOR USE COURSE START AND END DATES RADIOBUTTON");
            frameSwitch.switchToPopUpContentFrame();
            if (!lblStartEndDateCaption.isDisplayedAfterWaiting(waitTime))
                throw new Exception(
                        "'Caption For Use Course Start and End Dates RadioButton' DOES NOT EXISTS");

            if (lblStartEndDateCaption.isSelected()) {
                return true;
            } else {
                throw new Exception(
                        "ISSUE IN VERIFYING THE 'Caption For Use Course Start and End Dates RadioButton' IS NOT SELECTED \n METHOD: isCaptionForUseCourseStartandEndDatesRadioButtonSelected\n");
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Caption For Use Course Start and End Dates RadioButton' \n METHOD: isCaptionForUseCourseStartandEndDatesRadioButtonSelected\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * @category Milestone 2 Method helps to click course start and end date radio button.
     * @return TextMultimediaEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public TextMultimediaEditSchedulePage clickUseCourseStartandEndDatesRadioButton()
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK USE COURSE START END DATE RADIO BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            if (!radCourseStartEndDate.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Use Course Start and EndDates RadioButton' DOES NOT EXISTS");

            radCourseStartEndDate.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Use Course Start and EndDates RadioButton' \n METHOD: clickUseCourseStartandEndDatesRadioButton\n" + e
                            .getLocalizedMessage());
        }
        return new TextMultimediaEditSchedulePage(uiDriver);

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
            logInstruction("LOG INSTRUCTION: VERIFY START AND END DATE CAPTION");
            frameSwitch.switchToPopUpContent();
            flag = lblUseFollowingDateCaption.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Caption For Use The Following Dates RadioButton' \n METHOD: isCaptionForUseTheFollowingDatesRadioButtonDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method helps to click on use following dates radio button.
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public TextMultimediaEditSchedulePage clickUseFollowingDatesRadioButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK USE FOLLOWING DATE RADIO BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            if (!radUseFollowingDate.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Use Following Dates RadioButton' DOES NOT EXISTS");

            radUseFollowingDate.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Use Following Dates RadioButton' \n METHOD: clickUseFollowingDatesRadioButton\n" + e
                            .getLocalizedMessage());
        }
        return new TextMultimediaEditSchedulePage(uiDriver);

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
            logInstruction("LOG INSTRUCTION: CLICK SAVE AND CLOSE BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            if (!btnSaveAndClose.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Save And Close Button' DOES NOT EXISTS");

            btnSaveAndClose.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Save And Close Button' \n METHOD: clickSaveAndCloseButton\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * @category Milestone 2 Method helps to verify the content of end time drop down.
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
                        "ISSUE IN VERIFYING WHETHER THE 'End Time Displayed In DropDown' END TIME IS NULL \n METHOD: isEndTimeDisplayedInDropDown\n");

            frameSwitch.switchToPopUpContentFrame();
            List<WebElement> options = drpEndTime.findElements(By.tagName(OPTION));
            for (WebElement option : options) {
                if (option.getText().contains(strEndTime)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING WHETHER THE 'End Time Displayed In DropDown' \n METHOD: isEndTimeDisplayedInDropDown\n" + e
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
    public boolean isStartTimeDisplayedInDropDown(String strStartTime) throws Exception {
        flag = false;

        try {
            logInstruction("LOG INSTRUCTION: VERIFY CONTENT OF END TIME DROPDOWN");

            frameSwitch.switchToPopUpContentFrame();
            List<WebElement> options = drpStartTime.findElements(By.tagName(OPTION));
            for (WebElement option : options) {
                if (option.getText().contains(strStartTime)) {
                    flag = true;
                }
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING WHETHER THE 'Start Time Displayed In DropDown' \n METHOD: isStartTimeDisplayedInDropDown\n" + e
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
    public boolean isGradebookReviewTextBoxDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY GRADEBOOK TEXTBOX");
            frameSwitch.switchToPopUpContentFrame();
            flag = txtGradebookReview.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Gradebook Review TextBox' \n METHOD: isGradebookReviewTextBoxDisplayed\n" + e
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
            logInstruction("LOG INSTRUCTION: VERIFY GRADEBOOK CALENDAR");
            frameSwitch.switchToPopUpContentFrame();
            flag = imgCalendarGradebookReview.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Calendar Gradebook' \n METHOD: isCalendarGradebookDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method helps to enter start date.
     * @param strStartDate
     * @return TextMultimediaEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public TextMultimediaEditSchedulePage enterStartDate(String strStartDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR START DATE");
            frameSwitch.switchToPopUpContentFrame();
            if (!txtStartdate.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Start Date' DOES NOT EXISTS");
            txtStartdate.clearAndSendKeys(strStartDate);

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception(
                    "ISSUE IN ENTERING THE 'Start Date' \n METHOD: enterStartDate\n" + e
                            .getLocalizedMessage());
        }
        return new TextMultimediaEditSchedulePage(uiDriver);
    }

    /**
     * @category Milestone 2 Method helps to enter due date.
     * @param strDueDate
     * @return TextMultimediaEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public TextMultimediaEditSchedulePage enterDueDate(String strDueDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            if (!txtDueDate.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Due Date' DOES NOT EXISTS");

            txtDueDate.sendKeys(strDueDate);
            txtDueDate.sendKeys(Keys.ENTER);

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception("ISSUE IN ENTERING THE 'Due Date' \n METHOD: enterDueDate\n" + e
                    .getLocalizedMessage());
        }
        return new TextMultimediaEditSchedulePage(uiDriver);
    }

    /**
     * @category Milestone 2 Method helps to get value entered in due date.
     * @param 
     * @return String
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getDueDate() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            if (!txtDueDate.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Due Date' DOES NOT EXISTS");
            return txtDueDate.getAttribute(VALUE);

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception("ISSUE IN GETTING THE 'Due Date' \n METHOD: getDueDate\n" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * @category Milestone 2 Method helps to enter gradebook review date.
     * @param strDueDate
     * @return TextMultimediaEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public TextMultimediaEditSchedulePage enterGradebookReviewDate(String strDueDate)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR GRADEBOOK REVIEW DATE");
            frameSwitch.switchToPopUpContentFrame();
            if (!txtGradebookReview.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Gradebook Review Date' DOES NOT EXISTS");
            txtGradebookReview.sendKeys(strDueDate);
            txtGradebookReview.sendKeys(Keys.ENTER);

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception(
                    "ISSUE IN ENTERING THE 'Gradebook Review Date' \n METHOD: enterGradebookReviewDate\n" + e
                            .getLocalizedMessage());
        }
        return new TextMultimediaEditSchedulePage(uiDriver);
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to get start date
     * @return String
     * @throws Exception
     */
    public String getStartDate() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING START DATE");
            frameSwitch.switchToPopUpContentFrame();
            if (!txtStartDate.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Start Date' DOES NOT EXISTS");
            strResult = txtStartDate.getAttribute("value");
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE 'Start Date' \n METHOD: getStartDate\n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to Enter end date
     * @param strEndDate
     * @return TextMultimediaEditSchedulePage
     * @throws Exception
     */
    public TextMultimediaEditSchedulePage enterEndDate(String strEndDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER END DATE");
            frameSwitch.switchToPopUpContentFrame();
            if (!txtEndDate.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'End Date' DOES NOT EXISTS");
            txtEndDate.clearAndSendKeys(strEndDate);
            
        } catch (Exception e) {
            throw new Exception("ISSUE IN ENTERING THE 'End Date' \n METHOD: enterEndDate\n" + e
                    .getLocalizedMessage());
        }

        return new TextMultimediaEditSchedulePage(uiDriver);
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to get end date
     * @return String
     * @throws Exception
     */
    public String getEndDate() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING END DATE");
            frameSwitch.switchToPopUpContentFrame();
            if (!txtEndDate.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'End Date' DOES NOT EXISTS");
            strResult = txtEndDate.getAttribute("value");
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE 'End Date' \n METHOD: getEndDate\n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to get gradebookReview Date
     * @return String
     * @throws Exception
     */
    public String getGradebookReviewDate() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING GRADEBOOKREVIEW DATE");
            frameSwitch.switchToPopUpContentFrame();
            if (!txtGradebookReviewDate.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Gradebook Review Date' DOES NOT EXISTS");
            strResult = txtGradebookReviewDate.getAttribute("value");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'Gradebook Review Date' \n METHOD: getGradebookReviewDate\n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to get header title
     * @return String
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING HEADER TITLE");
            frameSwitch.switchToPopUpContentFrame();
            if (!txtTitle.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Header Title' DOES NOT EXISTS");
            strResult = txtTitle.getText();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'Header Title' \n METHOD: getHeaderTitle\n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * @category Milestone 2 This method is used to check radio button is selected or not
     * 
     * @author Usha
     * @param String
     * @return boolean 
     * @throws Exception
     */
    public boolean isRadioButtonSelected(String strRadioButtonLabel) throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING IF A PARTICULAR RADIO BUTTON SELECTED");
            frameSwitch.switchToPopUpContentFrame();
            radCourseButton.replaceValues(strRadioButtonLabel);
            if (radCourseButton.isSelected())
                flag = true;
            else
                throw new Exception(
                        "ISSUE IN VERIFYING WHETHER THE 'RadioButton is Selected' COURSE BUTTON IS NOT SELECTED \n METHOD: isRadioButtonSelected\n");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING WHETHER THE 'RadioButton is Selected' \n METHOD: isRadioButtonSelected\n" + e
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
        strTitle = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING TEXT NEXT TO SCHEDULE");
            frameSwitch.switchToPopUpContentFrame();
            if (!txtTitle.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Text From Field Next To Schedule' DOES NOT EXISTS");
            strTitle = txtTitle.getText();
            strTempArr = strTitle.split(" ");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'Text From Field Next To Schedule' \n METHOD: getTextFromFieldNextToSchedule\n" + e
                            .getLocalizedMessage());
        }
        return strTempArr[2];
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
        	 logInstruction("LOG INSTRUCTION: CHECKING IF ALERT DISPLAYED");
            uiDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            uiDriver.switchTo().alert();
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING WHETHER THE 'Alert Message is Displayed After Entering Invalid Date' \n METHOD: isAlertMessageDisplayedAfterEnteringInvalidDate\n" + e
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
        strTitle = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING ALERT TEXT");
            strTitle = uiDriver.getUIAlert().getAlertMessage();
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'Alert Message Content After Entering Invalid Date' \n METHOD: getAlertMesssageContentsAfterEnteringInvalidDate\n" + e
                            .getLocalizedMessage());
        }
        return strTitle;
    }

    /**
     * @category Milestone 2 Method is used to click on the cancel button
     * @author ganapati
     * 
     * @throws Exception
     */
    public void clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON THE CANCEL BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            if (!btnCancel.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Cancel Button' DOES NOT EXISTS");
            btnCancel.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Cancel Button' \n METHOD: clickCancelButton\n" + e
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
            logInstruction("LOG INSTRUCTION: CHECK IF START DATE FIELD IS DISABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseStartEndDate, waitTime);
            if (radCourseStartEndDate.isSelected()) {
            	flag = true;
            }
        } catch (Exception e) {
            throw new Exception("CHECK IF START DATE FIELD IS DISABLED \n METHOD : isStartDateFieldDisabled" + e.getLocalizedMessage());
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
            logInstruction("LOG INSTRUCTION: CHECK IF END DATE FIELD IS DISABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseStartEndDate, waitTime);
            if (radCourseStartEndDate.isSelected()) {
            	flag = true;
            }
        } catch (Exception e) {
            throw new Exception("CHECK IF END DATE FIELD IS DISABLED \n METHOD : isEndDateFieldDisabled " + e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to Enter end date
     * @param strEndDate
     * @return TextMultimediaEditSchedulePage
     * @throws Exception
     */
    public TextMultimediaEditSchedulePage enterInvalidEndDate(String strEndDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER END DATE");
            frameSwitch.switchToPopUpContentFrame();
            if (!txtEndDate.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'End Date Textbox' DOES NOT EXISTS");

            txtEndDate.clearAndSendKeys(strEndDate);
            // To take focus out click on startdate field
            txtStartDate.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING THE 'Invalid End Date' \n METHOD: enterInvalidEndDate\n" + e
                            .getLocalizedMessage());
        }

        return new TextMultimediaEditSchedulePage(uiDriver);
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to Enter end date
     * @param strEndDate
     * @return TextMultimediaEditSchedulePage
     * @throws Exception
     */
    public TextMultimediaEditSchedulePage enterInvalidStartDate(String strEndDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER START DATE");
            frameSwitch.switchToPopUpContentFrame();
            if (!txtEndDate.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Start Date' DOES NOT EXISTS");

            txtStartDate.clearAndSendKeys(strEndDate);
            // To take focus out click on end date field
            txtEndDate.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING THE 'Invalid Start Date' \n METHOD: enterInvalidStartDate\n" + e
                            .getLocalizedMessage());
        }

        return new TextMultimediaEditSchedulePage(uiDriver);
    }

    /**
     * @category Milestone 2
     * @author Usha , Method helps to Enter end date
     * @param strEndDate
     * @return TextMultimediaEditSchedulePage
     * @throws Exception
     */
    public TextMultimediaEditSchedulePage enterInvalidDueDate(String strEndDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            if (!txtEndDate.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Due Date' DOES NOT EXISTS");

            txtDueDate.clearAndSendKeys(strEndDate);
            // To take focus out click on end date field
            txtStartDate.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING THE 'Invalid Due Date' \n METHOD: enterInvalidDueDate\n" + e
                            .getLocalizedMessage());
        }

        return new TextMultimediaEditSchedulePage(uiDriver);
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
                    "ISSUE IN VERIFYING THE 'Error Message' \n METHOD: isErrorMessageDisplayed\n" + e
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
        strResult = null;
        try {
        	logInstruction("LOG INSTRUCTION: VERIFICATION OF ERROR MESSAGE");
            frameSwitch.switchToPopUpContentFrame();
            if (!lblErrorMessage.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Error Message' DOES NOT EXISTS");
            strResult = lblErrorMessage.getText();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'Error Message' \n METHOD: getErrorMessage\n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * @category Milestone 2 Method helps to click on Save and Close button.
     * @return TextMultimediaEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public TextMultimediaEditSchedulePage clickSaveAndCloseButtonForInvalidData() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK SAVE AND CLOSE BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            if (!btnSaveAndClose.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Save And Close Button' DOES NOT EXISTS");

            btnSaveAndClose.clickNoWait();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Save And Close Button For Invalid Data' \n METHOD: clickSaveAndCloseButtonForInvalidData\n" + e
                            .getLocalizedMessage());
        }
        return new TextMultimediaEditSchedulePage(uiDriver);

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
            SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");
            strResult = sdfwithOnlyDate.format(todayDate);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'Current Date' \n METHOD: getCurrentDate\n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to get future date
     * 
     * @author ganapati.bhat
     * @para, days
     * @return String
     * @throws Exception
     */

    public String getFutureDate(int days) throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET FUTURE DATE");
            Date todayDate = new Date();
            SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");
            calendar.setTime(todayDate);
            calendar.add(Calendar.DATE, days);
            dateAfter = calendar.getTime();
            strResult = sdfwithOnlyDate.format(dateAfter);
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE 'Future Date' \n METHOD: getFutureDate\n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to get past date
     * 
     * @author ganapati.bhat
     * @param days
     * @return String
     * @throws Exception
     */

    public String getPastDate(int days) throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET FUTURE DATE");
            Date todayDate = new Date();
            SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");
            calendar.setTime(todayDate);
            calendar.add(Calendar.DATE, -days);
            dateAfter = calendar.getTime();
            strResult = sdfwithOnlyDate.format(dateAfter);

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE 'Past Date' \n METHOD: getPastDate\n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * @category Milestone 2 Method is used to Check if Start Date Field is Enabled
     * @author Mamatha
     * @return boolean
     * @throws Exception
     */

    public boolean isStartDateFieldEnabled() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:CHECK IF START DATE FIELD IS ENABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radUseFollowingDate, waitTime);
            if (radUseFollowingDate.getAttribute("onclick").contains("optionEnable_onClick()")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "CHECK IF START DATE FIELD IS ENABLED \n METHOD: isStartDateFieldEnabled\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to Check if End Date Field is Disabled
     * @author Mamatha
     * @return boolean
     * @throws Exception
     */
    public boolean isEndDateFieldEnabled() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:CHECK IF END DATE FIELD IS ENABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radUseFollowingDate, waitTime);
            if (radUseFollowingDate.getAttribute("onclick").contains("optionEnable_onClick()")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "CHECK IF END DATE FIELD IS ENABLED \n METHOD: isEndDateFieldEnabled\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone 2 Method is used to Check if Date Picker is Disabled
     * @author Mamatha
     * @return boolean
     * @throws Exception
     */
    public boolean isDatePickerDisabled() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:CHECK IF DATE PICKER IS DISABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseStartEndDate, waitTime);
            if (radCourseStartEndDate.isSelected()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "CHECK IF DATE PICKER IS DISABLED" + "\n METHOD:isDatePickerDisabled\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category Milestone2 Method is used to Click start date calendar icon
     * @author mamatha
     * @param
     * @return DatePickerPage
     * @throws Exception
     */
    public DatePickerPage clickStartDateCalendarIcon() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK START DATE CALENDAR ICON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(imgStartDatePicker, waitTime);
            imgStartDatePicker.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK START DATE CALENDAR ICON" + "\n METHOD:clickStartDateCalendarIcon\n" + e
                            .getLocalizedMessage());
        }
        return new DatePickerPage(uiDriver);

    }

    /**
     * @category Milestone2 Method is used to Click end date calendar icon
     * @author Mamatha
     * @param
     * @return DatePickerPage
     * @throws Exception
     */
    public DatePickerPage clickEndDateCalendarIcon() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK END DATE CALENDAR ICON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(imgEndDatePicker, waitTime);
            imgEndDatePicker.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK END DATE CALENDAR ICON"+ "\n METHOD: clickEndDateCalendarIcon \n" + e.getLocalizedMessage());
        }
        return new DatePickerPage(uiDriver);

    }

    /**
     * @category Milestone2 Method is used to Click due date calendar icon
     * @author Mamatha
     * @param
     * @return DatePickerPage
     * @throws Exception
     */
    public DatePickerPage clickDueDateCalendarIcon() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK DUE DATE CALENDAR ICON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(imgDueDatePicker, waitTime);
            imgDueDatePicker.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK DUE DATE CALENDAR ICON" + "\n METHOD: clickDueDateCalendarIcon \n" + e.getLocalizedMessage());
        }
        return new DatePickerPage(uiDriver);

    }
/**
     * Method helps to schedule the date
     * @author Chaitali.Barhate
     * @param isUseFollowingDates
     * @param startDate
     * @param endDate
     * @param startTime
     * @param endTime
     * @param dueDate
     * @param dueTime
     * @return TextMultimediaToolboxPage
     * @throws Exception
     */
    public TextMultimediaToolboxPage scheduleDate(
            boolean isUseFollowingDates,
            String startDate,
            String endDate,
            String startTime,
            String endTime,
            String dueDate,
            String dueTime) throws Exception {

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
                if (StringUtils.isNotBlank(startTime)) {

                    logInstruction("LOG INSTRUCTION: ENTER START TIME");
                    drpStartTime.selectByVisibleText(startTime);
                }

                if (StringUtils.isNotBlank(endTime)) {

                    logInstruction("LOG INSTRUCTION: ENTER END TIME");
                    drpEndTime.selectByVisibleText(endTime);
                }
            }

            if (StringUtils.isNotBlank(dueDate)) {

                logInstruction("LOG INSTRUCTION: ENTER DUE DATE");
                txtDueDate.clearAndSendKeys(dueDate);
            }

            if (StringUtils.isNotBlank(dueTime)) {

                logInstruction("LOG INSTRUCTION: ENTER END TIME");
                drpDueTime.selectByVisibleText(dueTime);
            }

            btnSaveAndClose.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("UNABLE TO  'SCHEDULE THE DATE'" + "\n METHOD:scheduleDate \n" + e
                    .getLocalizedMessage());
        }
        return new TextMultimediaToolboxPage(uiDriver);
    }

    /**
     * * @category Milestone 2 Method helps to click course Unit id start and end date radio button.
     * 
     * @return TextMultimediaEditSchedulePage
     * @throws Exception
     * @author Mamatha
     */
    public TextMultimediaEditSchedulePage clickUseUnitIdStartandEndDatesRadioButton(String unitid)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK USE UNIT ID START END DATE RADIO BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            radUnitStartandEndDates.replaceValues(unitid);
            if (!radUnitStartandEndDates.isDisplayedAfterWaiting(waitTime))
                throw new Exception("'Use UnitId Start and EndDates RadioButton' DOES NOT EXISTS");

            radUnitStartandEndDates.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Use UnitId Start and EndDates RadioButton' \n METHOD: clickUseUnitIdStartandEndDatesRadioButton\n" + e
                            .getLocalizedMessage());
        }
        return new TextMultimediaEditSchedulePage(uiDriver);
    }

}
