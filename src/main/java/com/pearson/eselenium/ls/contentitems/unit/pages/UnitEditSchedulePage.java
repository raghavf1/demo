package com.pearson.eselenium.ls.contentitems.unit.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.DatePickerPage;
import com.pearson.eselenium.ls.course.pages.NextCourseHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * @category Milestone 2 Class contains methods related to edit scheduler page
 * @author ganapati.bhat
 * 
 */
public class UnitEditSchedulePage extends BasePageObject {

    /* elements */
    private UIElement drpGradebookTime = createElement(UIType.ID, "GBReviewTime");

    private UIElement lblDueDate = createElement(UIType.Xpath, "//label[contains(@for,'DueDate')]");
    private UIElement txtDueDate = createElement(UIType.Xpath, "//input[@id='DueDate']");
    private UIElement imgDueDateCalendar = createElement(
            UIType.Xpath,
            "//img[contains(@alt,'Due Date')]");
    private UIElement drpDueDate = createElement(UIType.Xpath, "//select[contains(@id,'DueTime')]");
    private UIElement btnSaveClose = createElement(
            UIType.Xpath,
            "//input[contains(@value,'Save ')]");

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
    private UIElement lblErrorMsg = createElement(
            UIType.Xpath,
            "//td[@class='inlineerror']//tr//td[2]");
    private UIElement radCourseButton = createElement(
            UIType.Xpath,
            "//tr[td[label[contains(.,'{1}')]]]//input");
    private UIElement lblInstructional = createElement(
            UIType.Xpath,
            "//td[@class='inlinemessage2']");
    private UIElement lblStartAndEndDates = createElement(
            UIType.Xpath,
            "//td[contains(text(),'Start and End')]");
    private UIElement lblStartDateCaption = createElement(
            UIType.Xpath,
            "//label[contains(text(),'Start')]");
    private UIElement lblEndDateCaption = createElement(
            UIType.Xpath,
            "//label[contains(text(),'End')]");
    private UIElement lblAsteriskDue = createElement(
            UIType.Xpath,
            "//tr[td[input[@id='DueDate']]]//td[1]");
    private UIElement lblAsteriskGradebook = createElement(
            UIType.Xpath,
            "//td[contains(@colspan,'3')]/text()");
    private UIElement lblAsteriskEnd = createElement(
            UIType.Xpath,
            "//tr[td[input[@id='EndDate']]]//td[3]");
    private UIElement lblAsteriskStart = createElement(
            UIType.Xpath,
            "//tr[td[input[@id='StartDate']]]//td[3]");

    static Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    Date dateAfter = new Date();

    private UIElement drpStarttimeSelected = createElement(
            UIType.Xpath,
            "//select[@id='StartTime']//option[@selected='']");
    private UIElement drpEndtimeSelected = createElement(
            UIType.Xpath,
            "//select[@id='EndTime']//option[@selected='']");
    private UIElement lblRestrictAccessBefore = createElement(
            UIType.Xpath,
            "//label[@for='RestrictBefore']");

    private UIElement btnCancel = createElement(UIType.Xpath, "//input[contains(@value,'Cancel')]");
    private UIElement imgStartDatePicker = createElement(
            UIType.Xpath,
            "//img[contains(@alt,'Pick Start Date')]");

    /* variables */
    String strText = null;
    String strTemp[];
    String strTableTitle = null;
    String strAccessBefore = null;
    String strAccessAfter = null;
    String strDueDate = "";
    String strStartDate = null;
    String strEndDate = null;
    String strGradebookReviewDate = null;
    String strErrMsg = null;
    String strInstructionalText = null;
    String strTextDisplayed = null;
    String strAfterDate = null;
    String strCurrentDate = null;
    String strBeforeDate = null;
    String strStartTime = null;
    String strEndTime = null;
    String strAlertMessage = null;
    boolean flag = false;

    private UIElement btnSaveandcloseButton = createElement(
            UIType.Xpath,
            "//table//tr//td//input[@id='cmdAddEntry']");

    private UIElement radClickStartRadioBtn = createElement(UIType.Css, "#IsScheduleInheritedYes");
    private UIElement radUseFollowingDateRadioBtn = createElement(
            UIType.ID,
            "IsScheduleInheritedNo");
    private UIElement txtEnterStartDate = createElement(UIType.ID, "StartDate");
    private UIElement txtEnterEndDate = createElement(UIType.ID, "EndDate");
    private UIElement chkRestrictAccess = createElement(UIType.Css, "#RestrictAfter");

    private UIElement txtGetToolTip = createElement(
            UIType.Css,
            ".inlinemessage2>table>tbody>tr>td:nth-child(2)");

    private UIElement drpDueDateTime = createElement(UIType.Css, "#DueTime");
    private UIElement drpStartDateTime = createElement(UIType.Css, "#StartTime");
    private UIElement drpEndDateTime = createElement(UIType.Css, "#EndTime");

    String strData = null;

    /* Constructor */
    public UnitEditSchedulePage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "UnitEditSchedulePage";
        logInstruction("## UNIT EDITSCHEDULERPAGE ##");
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
            logInstruction("LOGINSTRUCTION: VERIFY THE CONTENT OF GRADE BOOK REVIEW TIME DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();
            List<UIElement> options = drpGradebookTime.findUIElements(By.tagName("option"));
            for (UIElement option : options) {
                if (option.getText().contains(grdTime)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY THE CONTENT OF GRADE BOOK REVIEW TIME DROPDOWN" + "\n isContentOfGradebookTimeDropdownDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify gradebook asterisk
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isGradebookAsteriskDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY GRADEBOOK ASTERISK");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblAsteriskGradebook, waitTime);
            if (lblAsteriskGradebook.getText().contains("*")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "GRADEBOOK ASTERISK IS NOT DISPLAYED" + "\n isGradebookAsteriskDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify due date caption
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateCaptionDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY DUE DATE CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblDueDate, waitTime);
            if (lblDueDate.getText().contains("Due Date")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "DUE DATE CAPTION IS NOT DISPLAYED" + "\n isDueDateCaptionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify due date textBox
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateTextboxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY DUE DATE TEXT BOX");
            frameSwitch.switchToPopUpContentFrame();

            flag = txtDueDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "DUE DATE TEXTBOX IS NOT DISPLAYED" + "\n METHOD:isDueDateTextboxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify due date calendar icon
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateCalendarDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY DUE DATE CALENDAR ICON");
            frameSwitch.switchToPopUpContentFrame();

            flag = imgDueDateCalendar.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "DUE DATE CALENDAR ICON NOT DISPLAYED " + "\nMETHOD: isDueDateCalendarDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify due date calendar icon
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateCalendarEnabled() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY DUE DATE CALENDAR ICON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(imgDueDateCalendar, waitTime);
            flag = imgDueDateCalendar.isEnabled();
        } catch (Exception e) {
            throw new Exception(
                    "DUE DATE CALENDAR ICON NOT DISPLAYED " + "\n METHOD:isDueDateCalendarEnabled \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify due date dropdown
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDateDropDownVisible() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY DUE DATE DROPDOWN");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(drpDueDate, waitTime);
            flag = drpDueDate.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "DUE DATE DROPDOWN IS NOT VISIBLE" + "\n METHOD:isDueDateDropDownVisible \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify Save & Close button
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isSaveAndCloseButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY SAVE & CLOSE BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveClose, waitTime);
            flag = btnSaveClose.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "SAVE & CLOSE BUTTON IS NOT DISPLAYED" + "\n METHOD:isSaveAndCloseButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify Caption of Save & Close button
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isSaveAndCloseButtonCaptionDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY SAVE & CLOSE BUTTON CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveClose, waitTime);
            if (btnSaveClose.getAttribute("value").contains("Save & Close")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "SAVE & CLOSE BUTTON CAPTION IS NOT DISPLAYED" + "\n METHOD:isSaveAndCloseButtonCaptionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify Cancel button
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isCancelButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY CANCEL BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            flag = btnCancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "CANCEL BUTTON IS NOT DISPLAYED" + "\n METHOD:isCancelButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify Caption of Cancel button
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isCancelButtonCaptionDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY CANCEL BUTTON CAPTION");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            if (btnCancel.getAttribute("value").contains("Cancel")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "CANCEL BUTTON CAPTION IS NOT DISPLAYED" + "\nMETHOD: isCancelButtonCaptionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to verify instructional text about time zone
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isInstructionalTextAboutTimeZoneDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY INSTRUCTIONAL TEXT ABOUT TIME ZONE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblTimeZone, waitTime);
            flag = lblTimeZone.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY INSTRUCTIONAL TEXT ABOUT TIME ZONE" + "\nMETHOD: isInstructionalTextAboutTimeZoneDisplayed \n" + e
                            .getLocalizedMessage());

        }
        return flag;
    }

    /**
     * Method is used to verify instructional text caption about time zone
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isInstructionalTextAboutTimeZoneCaptionDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY INSTRUCTIONAL TEXT CAPTION ABOUT TIME ZONE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblTimeZone, waitTime);
            if (lblTimeZone.getText().contains(" * Times are displayed ")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY INSTRUCTIONAL TEXT CAPTION ABOUT TIME ZONE" + "\nMETHOD: isInstructionalTextAboutTimeZoneCaptionDisplayed \n" + e
                            .getLocalizedMessage());

        }
        return flag;
    }

    /**
     * Method is used to get frame header title
     * 
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String frameHeaderTitle() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: GET FRAME HEADER TITLE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblFrameHeader, waitTime);
            strTableTitle = lblFrameHeader.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET FRAME HEADER TITLE" + "\n frameHeaderTitle \n" + e
                    .getLocalizedMessage());
        }
        return strTableTitle;
    }

    /**
     * Method helps to click on Restrict access after check box.
     * 
     * @category MileStone 2
     * @return UnitEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public UnitEditSchedulePage clickRestrictAccessAfterCheckBox() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: CLICK ON RESTRICT ACCESS AFTER CHECKBOX ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessAfter, waitTime);
            chkRestrictAccessAfter.clickNoWait();
        } catch (Exception e) {
            logInstruction("UNABLE TO CLICK ON RESTRICT ACCESS AFTER CHECKBOX" + "\nMETHOD: clickRestrictAccessAfterCheckBox \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to verify Restrict access after check box.
     * 
     * @category MileStone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isRestrictAccessAfterCheckBoxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY RESTRICT ACCESS AFTER CHECKBOX PRESENT ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessAfter, waitTime);
            if (chkRestrictAccessAfter.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "RESTRICT ACCESS AFTER CHECKBOX IS NOT PRESENT" + "\n isRestrictAccessAfterCheckBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click on Restrict access before check box.
     * 
     * @category MileStone 2
     * @return UnitEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public UnitEditSchedulePage clickRestrictAccessBeforeCheckBox() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: CLICK ON RESTRICT ACCESS BEFORE CHECKBOX ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessBefore, waitTime);
            chkRestrictAccessBefore.clickNoWait();
        } catch (Exception e) {
            logInstruction("UNABLE TO CLICK ON RESTRICT ACCESS BEFORE CHECKBOX" + "\n METHOD:clickRestrictAccessBeforeCheckBox \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to verify Restrict access before check box.
     * 
     * @category MileStone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isRestrictAccessBeforeCheckBoxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY RESTRICT ACCESS BEFORE CHECKBOX PRESENT ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessBefore, waitTime);
            if (chkRestrictAccessBefore.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "RESTRICT ACCESS BEFORE CHECKBOX IS NOT PRESENT" + "\n METHOD:isRestrictAccessBeforeCheckBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get caption of restrict access before checkbox.
     * 
     * @return
     * @category MileStone 2
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getRestrictAccessBeforeCheckBoxCaption() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: GET RESTRICT ACCESS BEFORE CHECKBOX PRESENT ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblRestrictAccessBefore, waitTime);
            strAccessBefore = lblRestrictAccessBefore.getText();

        } catch (Exception e) {
            throw new Exception(
                    "RESTRICT ACCESS BEFORE CHECKBOX IS NOT PRESENT" + "\n METHOD: getRestrictAccessBeforeCheckBoxCaption \n" + e
                            .getLocalizedMessage());
        }
        return strAccessBefore;
    }

    /**
     * Method helps to get caption of restrict access before checkbox.
     * 
     * @return
     * @category MileStone 2
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getRestrictAccessAfterCheckBoxCaption() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: VERIFY RESTRICT ACCESS AFTER CHECKBOX PRESENT ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccessAfter, waitTime);
            strAccessAfter = chkRestrictAccessAfter.getText();

        } catch (Exception e) {
            throw new Exception(
                    "RESTRICT ACCESS AFTER CHECKBOX IS NOT PRESENT" + "\n getRestrictAccessAfterCheckBoxCaption \n" + e
                            .getLocalizedMessage());
        }
        return strAccessAfter;
    }

    /**
     * Method helps to verify Asterisk.
     * 
     * @category MileStone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isAsteriskStartDateDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY ASTERISK PRESENT ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblAsteriskStart, waitTime);
            if (lblAsteriskStart.getText().contains("*")) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "ASTERISK IS NOT PRESENT" + "\n isAsteriskStartDateDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify Asterisk after end date.
     * 
     * @category MileStone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isAsteriskEndDateDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY ASTERISK PRESENT AFTER END DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblAsteriskEnd, waitTime);
            if (lblAsteriskEnd.getText().contains("*")) {
                flag = true;

            }

        } catch (Exception e) {
            throw new Exception(
                    "ASTERISK IS NOT PRESENT AFTER END DATE" + "\n METHOD:isAsteriskEndDateDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

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
            logInstruction("LOGINSTRUCTION: VERIFY ASTERISK PRESENT AFTER DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblAsteriskDue, waitTime);

            if (lblAsteriskDue.getText().contains("*")) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "ASTERISK IS NOT PRESENT AFTER DUE DATE" + "\nMETHOD: isAsteriskDueDateDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify End date caption.
     * 
     * @category MileStone 2
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEndDateCaptionDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY END DATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblEndDate, waitTime);
            if (lblEndDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "END DATE CAPTION IS NOT PRESENT" + "\n METHOD:isEndDateCaptionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify Start date caption.
     * 
     * @category MileStone 2
     * @return booleans
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isStartDateCaptionDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY START DATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblStartDate, waitTime);
            if (lblStartDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "START DATE CAPTION IS NOT PRESENT" + "\n METHOD:isStartDateCaptionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify calendar for start date.
     * 
     * @category MileStone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCalendarStartDateDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY START DATE CALENDAR ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(imgCalendarStart, waitTime);
            if (imgCalendarStart.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "START DATE CALENDAR IS NOT PRESENT" + "\nMETHOD: isCalendarStartDateDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify calendar for end date.
     * 
     * @category MileStone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCalendarEndDateDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY END DATE CALENDAR ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(imgCalendarEnd, waitTime);
            if (imgCalendarEnd.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "END DATE CALENDAR IS NOT PRESENT" + "\n METHOD:isCalendarEndDateDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify End time dropdown.
     * 
     * @category MileStone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEndTimeDropDownDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY END TIME DROPDOWN ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(drpEndTime, waitTime);
            if (drpEndTime.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "END TIME DROPDOWN IS NOT PRESENT" + "\n METHOD:isEndTimeDropDownDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify start time dropdown.
     * 
     * @category MileStone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isStartTimeDropDownDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY START TIME DROPDOWN ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(drpEndTime, waitTime);
            if (drpStartTime.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "START TIME DROPDOWN IS NOT PRESENT" + "\nMETHOD: isStartTimeDropDownDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify due time dropdown.
     * 
     * @category MileStone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isDueTimeDropDownDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY DUE TIME DROPDOWN ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(drpDueTime, waitTime);
            if (drpDueTime.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "DUE TIME DROPDOWN IS NOT PRESENT" + "\n METHOD:isDueTimeDropDownDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify start date text box.
     * 
     * @category MileStone 2
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isStartDateTextBoxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY START DATE TEXTBOX ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtStartdate, waitTime);
            if (txtStartdate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "START DATE TEXTBOX IS NOT PRESENT" + "\n METHOD:isStartDateTextBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify end date text box.
     * 
     * @category MileStone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEndDateTextBoxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY END DATE TEXTBOX ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            if (txtEndDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "END DATE TEXTBOX IS NOT PRESENT" + "\n METHOD:isEndDateTextBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify caption for course start and end date radio button.
     * 
     * @category MileStone 2
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCaptionForUseCourseStartandEndDatesRadioButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY START AND END DATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();

            if (lblStartEndDateCaption.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "START AND END DATE CAPTION IS NOT PRESENT" + "\n METHOD:isCaptionForUseCourseStartandEndDatesRadioButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify course start and end date radio button is selected.
     * 
     * @category MileStone 2
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCaptionForUseCourseStartandEndDatesRadioButtonSelected() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY START AND END DATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblStartEndDateCaption, waitTime);
            if (lblStartEndDateCaption.isSelected()) {
                return flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "START AND END DATE CAPTION IS NOT PRESENT" + "\n METHOD:isCaptionForUseCourseStartandEndDatesRadioButtonSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to click course start and end date radio button.
     * 
     * @category MileStone 2
     * @return UnitEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public UnitEditSchedulePage clickUseCourseStartandEndDatesRadioButton() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: CLICK USE COURSE START END DATE RADIO BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseStartEndDate, waitTime);
            radCourseStartEndDate.clickNoWait();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK USE COURSE START END DATE RADIO BUTTON" + "\n METHOD: clickUseCourseStartandEndDatesRadioButton \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps to verify caption for use the following date radio button.
     * 
     * @category MileStone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCaptionForUseTheFollowingDatesRadioButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY START AND END DATE CAPTION ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblUseFollowingDateCaption, waitTime);
            if (lblUseFollowingDateCaption.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "START AND END DATE CAPTION IS NOT PRESENT" + "\n METHOD:isCaptionForUseTheFollowingDatesRadioButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to click on use following dates radio button.
     * 
     * @category MileStone 2
     * @return UnitEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public UnitEditSchedulePage clickUseFollowingDatesRadioButton() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: CLICK USE FOLLOWING DATE RADIO BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radUseFollowingDate, waitTime);
            radUseFollowingDate.clickNoWait();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK USE FOLLOWING DATE RADIO BUTTON" + "\n METHOD: clickUseFollowingDatesRadioButton \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps to click on Save and Close button.
     * 
     * @category MileStone 2
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public void clickSaveAndCloseButton() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: CLICK SAVE AND CLOSE BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
            btnSaveAndClose.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK SAVE AND CLOSE BUTTON" + "\n METHOD:clickSaveAndCloseButton \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Method helps to verify the content of end time drop down.
     * 
     * @category MileStone 2
     * @param String
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isEndTimeDisplayedInDropDown(String endTime) throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY CONTENT OF END TIME DROPDOWN");

            frameSwitch.switchToPopUpContentFrame();
            List<UIElement> options = drpEndTime.findUIElements(By.tagName("option"));
            for (UIElement option : options) {
                if (option.getText().contains(endTime)) {
                    flag = true;
                }
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY CONTENT OF END TIME DROPDOWN" + "\n METHOD: isEndTimeDisplayedInDropDown \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify the content of start time drop down.
     * 
     * @category MileStone 2
     * @param endTime
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isStartTimeDisplayedInDropDown(String startTime) throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY CONTENT OF END TIME DROPDOWN");

            frameSwitch.switchToPopUpContentFrame();
            List<UIElement> options = drpStartTime.findUIElements(By.tagName("option"));
            for (UIElement option : options) {
                if (option.getText().contains(startTime)) {
                    flag = true;
                }
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY CONTENT OF END TIME DROPDOWN" + "\n METHOD: isStartTimeDisplayedInDropDown \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify grade book text box.
     * 
     * @category MileStone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isGradeboobReviewTextBoxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY GRADEBOOK TEXTBOX ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtGradebookReview, waitTime);
            if (txtGradebookReview.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "VERIFY GRADEBOOK TEXTBOX IS NOT PRESENT" + "\n METHOD:isGradeboobReviewTextBoxDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to verify calendar for gradebook.
     * 
     * @category MileStone 2
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCalendarGradebookDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: VERIFY GRADEBOOK CALENDAR ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(imgCalendarGradebookReview, waitTime);
            if (imgCalendarGradebookReview.isDisplayedAfterWaiting(waitTime)) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    "GRADEBOOK CALENDAR IS NOT PRESENT" + "\n METHOD:isCalendarGradebookDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method helps to enter start date.
     * 
     * @category MileStone 2
     * @param startDate
     * @return UnitEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public UnitEditSchedulePage enterStartDate(String startDate) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: ENTERING VALUE FOR START DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtStartdate, waitTime);

            txtStartdate.clearAndSendKeys(startDate);

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception("UNABLE TO ENTER START DATE" + "\n METHOD: enterStartDate \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to enter due date.
     * 
     * @category MileStone 2
     * @param dueDate
     * @return UnitEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public UnitEditSchedulePage enterDueDate(String dueDate) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: ENTERING VALUE FOR DUE DATE");
            frameSwitch.switchToPopUpContentFrame();

            uiDriver.waitToBeDisplayed(txtDueDate, waitTime);
            txtDueDate.clearAndSendKeys(dueDate);
            txtDueDate.sendKeys(dueDate);

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception("UNABLE TO ENTER DUE DATE" + "\n METHOD:enterDueDate \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to get value entered in due date.
     * 
     * @category MileStone 2
     * @param dueDate
     * @return String
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getDueDate() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: ENTERING VALUE FOR DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtDueDate, waitTime);

            strDueDate = txtDueDate.getAttribute("value");

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception("UNABLE TO ENTER DUE DATE" + "\n getDueDate \n" + e
                    .getLocalizedMessage());
        }
        return strDueDate;
    }

    /**
     * Method helps to enter gradebook review date.
     * 
     * @category MileStone 2
     * @param dueDate
     * @return UnitEditSchedulePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public UnitEditSchedulePage enterGradebookReviewDate(String dueDate) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: ENTERING VALUE FOR GRADEBOOK REVIEW DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtGradebookReview, waitTime);

            txtGradebookReview.sendKeys(dueDate);

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception(
                    "UNABLE TO ENTER GRADEBOOK REVIEW DATE" + "\n METHOD:enterGradebookReviewDate \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @author Usha , Method helps to get start date
     * @return String
     * @throws Exception
     */
    public String getStartDate() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: GETTING START DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtStartDate, waitTime);
            strStartDate = txtStartDate.getAttribute("value");
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET START DATE" + "\n METHOD: getStartDate \n" + e
                    .getLocalizedMessage());
        }

        return strStartDate;
    }

    /**
     * @author Usha , Method helps to Enter end date
     * @param endDate
     * @return UnitEditSchedulePage
     * @throws Exception
     */
    public UnitEditSchedulePage enterEndDate(String endDate) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: ENTER END DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtEndDate.clearAndSendKeys(endDate);

        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER END DATE" + "\n METHOD: enterEndDate \n" + e
                    .getLocalizedMessage());
        }

        return this;
    }

    /**
     * @author Usha , Method helps to get end date
     * @return String
     * @throws Exception
     */
    public String getEndDate() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: GETTING END DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            strEndDate = txtEndDate.getAttribute("value");
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET END DATE" + "\n getEndDate \n" + e
                    .getLocalizedMessage());
        }

        return strEndDate;
    }

    /**
     * @author Usha , Method helps to get gradebookReview Date
     * @return String
     * @throws Exception
     */
    public String getGradebookReviewDate() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: GETTING GRADEBOOKREVIEW DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtGradebookReviewDate, waitTime);
            strGradebookReviewDate = txtGradebookReviewDate.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET GRADEBOOKREVIEW DATE" + "\n getGradebookReviewDate \n" + e
                            .getLocalizedMessage());
        }

        return strGradebookReviewDate;
    }

    /**
     * @author Usha , Method helps to get header title
     * @return
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: GETTING HEADER TITLE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            strTableTitle = txtTitle.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET HEADER TITLE" + "\n METHOD: getHeaderTitle \n" + e
                    .getLocalizedMessage());
        }
        return strTableTitle;
    }

    /**
     * This method is used to check radio button is selected or not
     * 
     * @author Usha
     * @param String
     * @return boolean throws Exception
     */
    public boolean isRadioButtonSelected(String radioButtonLabel) throws Exception {
        logInstruction("LOGINSTRUCTION: CHECKING IF A PARTICULAR RADIO BUTTON SELECTED");
        flag = false;
        try {
            frameSwitch.switchToPopUpContentFrame();
            radCourseButton.replaceValues(radioButtonLabel);
            if (radCourseButton.isSelected()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "RADIO BUTTON IS NOT  SELECTED" + "\n METHOD:s isRadioButtonSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @author Usha , Method helps to get text next to schedule in header title
     * @return
     * @throws Exception
     */
    public String getTextFromFieldNextToSchedule() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: GETTING TEXT NEXT TO SCHEDULE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            strTableTitle = txtTitle.getText();
            strTemp = strTableTitle.split(" ");
            // for(int i =0; i < temp.length ; i++)
            strText = strTemp[2];

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET TEXT NEXT TO SCHEDULE IN HEADER TITLE" + "\n METHOD: getTextFromFieldNextToSchedule \n" + e
                            .getLocalizedMessage());
        }
        return strText;
    }

    /**
     * This method is used to check if alert displayed
     * 
     * @author Usha
     * @return boolean throws Exception
     */
    public boolean isAlertMessageDisplayedAfterEnteringInvalidDate() throws Exception {
        logInstruction("LOGINSTRUCTION: CHECKING IF ALERT DISPLAYED");
        flag = false;
        try {
            uiDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            uiDriver.switchTo().alert();
            flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "LABEL IS NOT DISPLAYED " + "\n METHOD: isAlertMessageDisplayedAfterEnteringInvalidDate \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @author Usha , Method helps to get alert text
     * @return String
     * @throws Exception
     */
    public String getAlertMesssageContentsAfterEnteringInvalidDate() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: GETTING ALERT TEXT");

            strTableTitle = uiDriver.getUIAlert().getAlertMessage();
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET ALERT TEXT" + "\n METHOD: getAlertMesssageContentsAfterEnteringInvalidDate \n" + e
                            .getLocalizedMessage());
        }
        return strTableTitle;
    }

    /**
     * Method is used to click on the cancel button
     * 
     * @author ganapati
     * 
     * @throws Exception
     */
    public void clickCancelButton() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: CLICK ON THE CANCEL BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "CHECK IF END DATE FIELD IS DISABLED" + "\n METHOD: clickCancelButton \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Method is used to Check if Start Date Field is Disabled
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isStartDateFieldDisabled() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: CHECK IF START DATE FIELD IS DISABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseStartEndDate, waitTime);
            if (radCourseStartEndDate.isSelected()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "CHECK IF START DATE FIELD IS DISABLED" + "\n METHOD: isStartDateFieldDisabled \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to Check if End Date Field is Disabled
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isEndDateFieldDisabled() throws Exception {
        flag = false;
        try {
            logInstruction("LOGINSTRUCTION: CHECK IF END DATE FIELD IS DISABLED");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radCourseStartEndDate, waitTime);
            if (radCourseStartEndDate.isSelected()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "CHECK IF END DATE FIELD IS DISABLED" + "\n METHOD: isEndDateFieldDisabled \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get inline error message when date fields are empty
     * 
     * @category MileStone 2
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getInlineErrorMsgAfterEnteringBlankDate() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: GETTING INLINE ERROR TEXT");
            uiDriver.waitToBeDisplayed(lblErrorMsg, waitTime);
            strErrMsg = lblErrorMsg.getText();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET INLINE ERROR TEXT" + "\n METHOD: getInlineErrorMsgAfterEnteringBlankDate \n" + e
                            .getLocalizedMessage());
        }
        return strErrMsg;
    }

    /**
     * @author Usha , Method helps to Enter invalid end Date
     * @param String
     * @return UnitEditSchedulePage
     * @throws Exception
     */
    public UnitEditSchedulePage enterInvalidEndDate(String endDate) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: ENTER INVLAID END DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtEndDate.clearAndSendKeys(endDate);
            btnSaveAndClose.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER INVLAID END DATE" + "\n METHOD: enterInvalidEndDate \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * @author Usha , Method helps to Enter invalid start
     * @param String
     * @return UnitEditSchedulePage
     * @throws Exception
     */
    public UnitEditSchedulePage enterInvalidStartDate(String startDate) throws Exception {
        try {
            logInstruction("ENTER INVALID START DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtStartdate, waitTime);
            txtStartdate.clearAndSendKeys(startDate);
            btnSaveAndClose.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER INVALID START DATE" + "\nMETHOD:  enterInvalidStartDate \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * @author Usha , Method helps to Enter invalid due date
     * @param String
     * @return UnitEditSchedulePage
     * @throws Exception
     */
    public UnitEditSchedulePage enterInvalidDueDate(String dueDate) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: ENTER INVALID DUE DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtDueDate, waitTime);
            txtDueDate.clearAndSendKeys(dueDate);
            txtStartdate.clickNoWait();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER INVALID END DATE" + "\nMETHOD:  enterInvalidDueDate \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * @author Usha , Method helps to Enter blank end date.
     * @param endDate
     * @return UnitEditSchedulePage
     * @throws Exception
     */
    public UnitEditSchedulePage enterBlankEndDate(String endDate) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: ENTER BLANK END DATE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtEndDate.clearAndSendKeys(endDate);
            btnSaveAndClose.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER BLANK END DATE" + "\nMETHOD: enterBlankEndDate \n" + e
                            .getLocalizedMessage());
        }

        return this;
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
            logInstruction("LOGINSTRUCTION: VERIFY INSTRUCTIONAL TEXT");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblInstructional, waitTime);
            if (!lblInstructional.getText().isEmpty()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY INSTRUCTIONAL TEXT" + "\n METHOD: isInstructionalTextDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get instructional txex.
     * 
     * @category MileStone 2
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getInstructionalText() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: GET INSTRUCTIONAL TEXT");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblInstructional, waitTime);
            strInstructionalText = lblInstructional.getText();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET INSTRUCTIONAL TEXT" + "\n METHOD: getInstructionalText \n" + e
                            .getLocalizedMessage());
        }
        return strInstructionalText;
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
            logInstruction("LOGINSTRUCTION: VERIFY INSTRUCTIONAL TEXT");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblStartAndEndDates, waitTime);
            if (lblStartAndEndDates.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY INSTRUCTIONAL TEXT" + "\n METHOD: isStartEndDateLabelDisplayed \n" + e
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

        try {
            logInstruction("LOGINSTRUCTION: VERIFY START END DATE CAPTION TEXT");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblStartAndEndDates, waitTime);
            strTextDisplayed = lblStartAndEndDates.getText();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY START END DATE CAPTION TEXT" + "\n METHOD: getStartEndDateLabelCaption \n" + e
                            .getLocalizedMessage());
        }
        return strTextDisplayed;
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

        try {
            logInstruction("LOGINSTRUCTION: VERIFY START DATE CAPTION TEXT");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblStartDateCaption, waitTime);
            strTextDisplayed = lblStartDateCaption.getText();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY START DATE CAPTION TEXT" + "\n METHOD: getStartDateCaption \n" + e
                            .getLocalizedMessage());
        }
        return strTextDisplayed;
    }

    /**
     * Method helps to get caption of End date
     * 
     * @return String
     * @category MileStone 2
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getEndDateCaption() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: VERIFY END DATE CAPTION TEXT");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(lblEndDateCaption, waitTime);
            strTextDisplayed = lblEndDateCaption.getText();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY END DATE CAPTION TEXT" + "\n METHOD: getEndDateCaption \n" + e
                            .getLocalizedMessage());
        }
        return strTextDisplayed;
    }

    /**
     * This method is used to check radio button is selected or not
     * 
     * @author Usha
     * @return boolean throws Exception
     */
    public boolean isRadioButtonDisplayed(String radioButtonLabel) throws Exception {
        logInstruction("LOGINSTRUCTION: CHECKING IF A PARTICULAR RADIO BUTTON DISPLAYED");
        flag = false;
        try {
            frameSwitch.switchToPopUpContentFrame();
            radCourseButton.replaceValues(radioButtonLabel);
            if (radCourseButton.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "RADIO BUTTON IS NOT  DISPLAYED " + "\nMETHOD: isRadioButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
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
            logInstruction("LOGINSTRUCTION: GET CURRENT DATE");
            Date todayDate = new Date();
            SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");
            strCurrentDate = sdfwithOnlyDate.format(todayDate);

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET CURRENT DATE" + "\nMETHOD: getCurrentDate \n" + e
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

    public String getFutureDate(int days) throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: GET FUTURE DATE");
            Date todayDate = new Date();
            SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");
            calendar.setTime(todayDate);
            calendar.add(Calendar.DATE, days);
            dateAfter = calendar.getTime();
            strAfterDate = sdfwithOnlyDate.format(dateAfter);

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET CURRENT DATE" + "\n METHOD:getFutureDate \n" + e
                    .getLocalizedMessage());
        }
        return strAfterDate;
    }

    /**
     * Method helps to get past date
     * 
     * @author ganapati.bhat
     * @return String
     * @param int
     * @throws Exception
     */

    public String getPastDate(int days) throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: GET FUTURE DATE");
            Date todayDate = new Date();
            SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");
            calendar.setTime(todayDate);
            calendar.add(Calendar.DATE, -days);
            dateAfter = calendar.getTime();
            strBeforeDate = sdfwithOnlyDate.format(dateAfter);

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET CURRENT DATE" + "\nMETHOD: getPastDate \n" + e
                    .getLocalizedMessage());
        }
        return strBeforeDate;
    }

    /**
     * Method helps to get the start time
     * 
     * @author ganapati.bhat
     * @return
     * @throws Exception
     */

    public String getStartTime() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: GET THE START TIME");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(drpStarttimeSelected, waitTime);
            strStartTime = drpStarttimeSelected.getText();

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET START TIME" + "\n METHOD:getStartTime \n" + e
                    .getLocalizedMessage());
        }
        return strStartTime;
    }

    /**
     * Method helps to get the end time
     * 
     * @author ganapati.bhat
     * @return String
     * @throws Exception
     */

    public String getEndTime() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: GET THE END TIME");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(drpEndtimeSelected, waitTime);
            strEndTime = drpEndtimeSelected.getText();

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET END TIME" + "\n METHOD:getEndTime \n" + e
                    .getLocalizedMessage());
        }
        return strEndTime;
    }

    /**
     * @category Milestone 2 Method helps to click on Save and Close button.
     * @return String
     * @param String
     * @throws Exception
     * @author saurabh.jain1
     */
    public String clickSaveAndCloseButtonForInvalidData(String data) throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: CLICK SAVE AND CLOSE BUTTON ");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
            btnSaveAndClose.clickNoWait();
            if (!data.equalsIgnoreCase("")) {
                strAlertMessage = uiDriver.getUIAlert().getAlertMessage();
                uiDriver.getUIAlert().acceptAlertIfPresent();
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK SAVE AND CLOSE BUTTON" + "\n METHOD:clickSaveAndCloseButtonForInvalidData \n" + e
                            .getLocalizedMessage());
        }

        return strAlertMessage;
    }

    /**
     * Service method to enter Schedule dates. Second parameter is Optional since nothing is
     * required to pass if using 'Use Course start and end dates'.
     * 
     * @author Vivek.Singh
     * @param -- userCourseHomeDates -> to click on 'Use the following dates:' radio button
     * 
     *        --objDatesAndAccess[0] -> Contains 'Start Date'. Pass the value as {@link String} in
     *        form "mm/dd/yyyy". Will be treated as 'Due Date' if 'userCourseHomeDates' is false.
     * 
     *        --objDatesAndAccess[1] -> Is to provide 'boolean' value to check 'Restrict access
     *        before' checkbox.
     * 
     *        -- objDatesAndAccess[2] -> Contains 'End Date'. Pass the value as {@link String} in
     *        form "mm/dd/yyyy".
     * 
     *        -- objDatesAndAccess[3] -> Is to provide 'boolean' value to check 'Restrict access
     *        after' checkbox.
     * 
     *        -- objDatesAndAccess[4] -> Contains 'Due Date'. Pass the value as {@link String} in
     *        form "mm/dd/yyyy".
     * @return void
     * @throws Exception
     * @category Milestone 2
     * @Example scheduleDate(true, "12/17/2013", true, "10/17/2014", true, "10/17/2014") -- if
     *          Clicking 'Use the following dates:' radio button.
     * 
     *          schedulDate(false, "10/17/2014") -- if clicking 'Use Course start and end dates'
     *          radio button.
     * **/
    public void scheduleDate(boolean userCourseHomeDates, Object... objDatesAndAccess)
            throws Exception {
        logInstruction("LOG INSTRUCTION: ENTERING 'Unit Schedule Date'.");
        uiDriver.getUIWindowLocator().switchToNewWindow();
        try {
            frameSwitch.switchToPopUpContentFrame();
            if (userCourseHomeDates) {
                if (objDatesAndAccess.length > 0) {
                    if (objDatesAndAccess[0] instanceof String) {
                        logInstruction("LOG INSTRUCTION: SENDING KEYS TO 'Start Date'.");
                        uiDriver.waitToBeDisplayed(txtStartdate, waitTime);
                        txtStartdate.clearAndSendKeys((String) objDatesAndAccess[0]);
                    }

                    if (objDatesAndAccess[1] instanceof Boolean) {
                        logInstruction("LOG INSTRUCTION: CHECKING 'Restrict Access Before' CHECKBOX.");
                        if ((Boolean) objDatesAndAccess[1]) {
                            uiDriver.waitToBeDisplayed(chkRestrictAccessBefore, waitTime);
                            if (!chkRestrictAccessBefore.isSelected()) {
                                chkRestrictAccessBefore.clickNoWait();
                            }
                        } else { // if(boolRestrictAccessBefore)
                            uiDriver.waitToBeDisplayed(chkRestrictAccessBefore, waitTime);
                            if (chkRestrictAccessBefore.isSelected()) {
                                chkRestrictAccessBefore.clickNoWait();
                            }
                        }
                    }
                    if (objDatesAndAccess[2] instanceof String) {
                        logInstruction("LOG INSTRUCTION: SENDING KEYS TO 'End Date'.");
                        uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
                        txtEndDate.sendKeysToFileInput((String) objDatesAndAccess[2]);
                    }

                    if (objDatesAndAccess[3] instanceof Boolean) {
                        logInstruction("LOG INSTRUCTION: CHECKING 'Restrict Access After' CHECKBOX.");
                        if ((Boolean) objDatesAndAccess[1]) {
                            uiDriver.waitToBeDisplayed(chkRestrictAccessAfter, waitTime);
                            if (!chkRestrictAccessAfter.isSelected()) {
                                chkRestrictAccessAfter.clickNoWait();
                            }
                        } else { // if(boolRestrictAccessAfter){
                            uiDriver.waitToBeDisplayed(chkRestrictAccessAfter, waitTime);
                            if (chkRestrictAccessAfter.isSelected()) {
                                chkRestrictAccessAfter.clickNoWait();
                            }
                        }
                    }

                    if (objDatesAndAccess[4] instanceof String) {
                        logInstruction("LOG INSTRUCTION: SENDING KEYS TO 'Due Date'.");
                        uiDriver.waitToBeDisplayed(txtDueDate, waitTime);
                        txtDueDate.sendKeysToFileInput((String) objDatesAndAccess[4]);
                    }
                }

                logInstruction("LOG INSTRUCTION: CLICKING 'Save & Close' BUTTON.");
                uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
                btnSaveAndClose.clickAndWait(waitTime);
                uiDriver.getUIWindowLocator().switchToFirstWindow();
            } else {// if(userCourseHomeDates){
                logInstruction("LOG INSTRUCTION: CLICKING 'Use Course Dates' RADIO BUTTON.");
                uiDriver.waitToBeDisplayed(radCourseStartEndDate, waitTime);
                radCourseStartEndDate.clickNoWait();
                if (objDatesAndAccess.length > 0) {
                    if (objDatesAndAccess[0] instanceof String) {
                        logInstruction("LOG INSTRUCTION: SENDING KEYS TO 'Due Date'.");
                        uiDriver.waitToBeDisplayed(txtDueDate, waitTime);
                        txtDueDate.sendKeysToFileInput((String) objDatesAndAccess[0]);
                    }
                }
                logInstruction("LOG INSTRUCTION: CLICKING 'Save & Close' BUTTON.");
                uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
                btnSaveAndClose.clickAndWait(waitTime);
                uiDriver.getUIWindowLocator().switchToFirstWindow();
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO  ENTER 'Unit Schedule Date'." + "\n scheduleDate \n" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * this method Select Due Date
     * 
     * @return:NextCourseHomePage
     * @throws Exception
     * @author hemant.kumar
     */
    public NextCourseHomePage selectDueDate(String mmddyyyy) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING THE DUE DATE");
            frameSwitch.switchToFrameContent();
            uiDriver.switchTo().frame("popupcontent");
            uiDriver.waitToBeDisplayed(txtDueDate, waitTime);
            txtDueDate.sendKeys(mmddyyyy);

        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT DUE DATE");
        }
        return new NextCourseHomePage(uiDriver);
    }

    /**
     * This method click Save and close Button
     * 
     * @return:UnitToolboxPage
     * @throws Exception
     * @author soundarya
     */
    public UnitToolboxPage clickSaveandcloseButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK SAVE AND CLOSE BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(btnSaveandcloseButton, waitTime);
            btnSaveandcloseButton.clickNoWait();
            frameSwitch.switchToParentWindow();

            logInstruction("LOG INSTRUCTION: SUCUSSFULLY CLICK SAVE AND CLOSE BUTTON");
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK SAVE AND CLOSE BUTTON");
        }

        return new UnitToolboxPage(uiDriver);
    }

    /**
     * @author soundarya
     * @throws Exception
     */
    public void switchToEditSchedulePageWindow() throws Exception {
        {
            try {
                logInstruction("LOG INSTRUCTION: SWITCH TO EDITSCHEDULEPAGE WINDOW");
                String parentWindow = uiDriver.getWindowHandle();
                Set<String> handles = uiDriver.getWindowHandles();
                for (String windowHandle : handles) {
                    if (!windowHandle.equals(parentWindow)) {

                        uiDriver.switchTo().window(windowHandle);
                        uiDriver.switchTo().frame("popupcontent");
                    }
                }
            } catch (Exception e) {
                throw new Exception("UNABLE TO SWITCH TO WINDOW");
            }
        }

    }

    /**
     * This Method will click On course start Radio button
     * 
     * @return {@link EditSchedulePage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public UnitEditSchedulePage clickStartCourseRadioBtn() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON START COURSE RADIO BUTTON");
            uiDriver.waitToBeDisplayed(radClickStartRadioBtn, waitTime);
            radClickStartRadioBtn.clickNoWait();

        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: UNABLE TO GET THE RADIO BUTTON");
        }

        return this;
    }

    /**
     * This Method will Click on Following Date Radio button.
     * 
     * @return {@link EditSchedulePage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public UnitEditSchedulePage clickFollowingDateRadioBtn() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON RADIO BUTTON");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(radUseFollowingDateRadioBtn, waitTime);
            radUseFollowingDateRadioBtn.clickNoWait();

        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: UNABLE TO GET THE RADIO BUTTON");
        }
        return this;
    }

    /**
     * This Method Will click on Restric Access checkBox
     * 
     * @return {@link EditSchedulePage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public UnitEditSchedulePage clickRestricAccessChkBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON CHECK BOX");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(chkRestrictAccess, waitTime);
            chkRestrictAccess.clickNoWait();
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: UNABLE TO GET THE CHKBOX" + e.getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method will get the Tool Tip of the Edit Schedule Page .
     * 
     * @return {@link String}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public String getToolTipMessage() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING TOOL TIP MESSAGE");
            frameSwitch.switchToPopUpContentFrame();
            uiDriver.waitToBeDisplayed(txtGetToolTip, waitTime);
            strData = txtGetToolTip.getText();

        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: UNABLE TO GET THE TOOL TIP MSG" + e
                    .getLocalizedMessage());
        }
        return strData;
    }

    /**
     * Method helps to schedule the date
     * 
     * @param flagUseFollowingDates
     * @param strStartDate
     * @param strEndDate
     * @param strDueDate
     * @param flagRestrictAcessBefore
     * @param flagRestrictAcessAfter
     * @return UnitToolboxPage
     * @throws Exception
     * 
     * @author sumanth.sv
     */
    public UnitToolboxPage scheduleDate(
            boolean flagUseFollowingDates,
            String strStartDate,
            String strStartDateTime,
            String strEndDate,
            String strEndDateTime,
            String strDueDate,
            String strDueDateTime,
            boolean flagRestrictAcessBefore,
            boolean flagRestrictAcessAfter) throws Exception {

        try {

            logInstruction("LOG INSTRUCTION: SCHEDULE THE DATE");
            frameSwitch.switchToPopUpContentFrame();
            logInstruction("LOG INSTRUCTION: ENTER DUE DATE");
            if (!txtDueDate.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Due Date Textbox' DOES NOT EXISTS \n METHOD: scheduleDate");
            }
            txtDueDate.sendKeys(strDueDate);

            logInstruction("LOG INSTRUCTION:SELECT DUE DATE TIME");
            if (!drpDueDateTime.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception(
                        "'Due Date's Time Dropbox' DOES NOT EXISTS \n METHOD: scheduleDate");
            }
            drpDueDateTime.selectByVisibleText(strDueDateTime);

            if (flagUseFollowingDates == true) {

                if (!radUseFollowingDateRadioBtn.isDisplayedAfterWaiting(waitTime)) {
                    throw new Exception(
                            "'Use Following Date Radio Button' DOES NOT EXISTS \n METHOD: scheduleDate");
                }
                radUseFollowingDateRadioBtn.clickAndWait(waitTime);

                logInstruction("LOG INSTRUCTION: ENTER START DATE");
                if (!txtEnterStartDate.isDisplayedAfterWaiting(waitTime)) {
                    throw new Exception(
                            "'Start Date Textbox' DOES NOT EXISTS \n METHOD: scheduleDate");
                }
                txtEnterStartDate.clearAndSendKeys(strStartDate);

                logInstruction("LOG INSTRUCTION:SELECT START DATE TIME");
                if (!drpStartDateTime.isDisplayedAfterWaiting(waitTime)) {
                    throw new Exception(
                            "'Start Date's Time Dropbox' DOES NOT EXISTS \n METHOD: scheduleDate");
                }
                drpStartDateTime.selectByVisibleText(strStartDateTime);

                logInstruction("LOG INSTRUCTION: ENTER END DATE");
                if (!txtEnterEndDate.isDisplayedAfterWaiting(waitTime)) {
                    throw new Exception(
                            "'End Date Textbox' DOES NOT EXISTS \n METHOD: scheduleDate");
                }
                txtEnterEndDate.clearAndSendKeys(strEndDate);

                logInstruction("LOG INSTRUCTION:SELECT END DATE TIME");
                if (!drpEndDateTime.isDisplayedAfterWaiting(waitTime)) {
                    throw new Exception(
                            "'End Date's Time Dropbox' DOES NOT EXISTS \n METHOD: scheduleDate");
                }
                drpEndDateTime.selectByVisibleText(strEndDateTime);

                if (flagRestrictAcessAfter == true) {
                    logInstruction("LOG INSTRUCTION: CLICKING ON RESTRICT ACCESS BEFORE CHECKBOX");
                    if (!chkRestrictAccessBefore.isDisplayedAfterWaiting(waitTime)) {
                        throw new Exception(
                                "'Restrict Access Before Checkbox' DOES NOT EXISTS \n METHOD: scheduleDate");
                    }
                    chkRestrictAccessBefore.clickNoWait();
                }

                if (flagRestrictAcessAfter == true) {
                    logInstruction("LOG INSTRUCTION: CLICKING ON RESTRICT ACCESS AFTER CHECKBOX");
                    if (!chkRestrictAccessAfter.isDisplayedAfterWaiting(waitTime)) {
                        throw new Exception(
                                "'Restrict Access After Checkbox' DOES NOT EXISTS \n METHOD: scheduleDate");
                    }
                    chkRestrictAccessAfter.clickNoWait();
                }

                logInstruction("LOG INSTRUCTION: CLICK SAVE AND CLOSE BUTTON");
                if (!btnSaveandcloseButton.isDisplayedAfterWaiting(waitTime)) {
                    throw new Exception(
                            "'Save & Close Button' DOES NOT EXISTS \n METHOD: scheduleDate");
                }

                btnSaveandcloseButton.clickAndWait(waitTime);
                frameSwitch.switchToParentWindow();
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO  'SCHEDULE THE DATE'" + "\n METHOD:scheduleDate \n" + e
                    .getLocalizedMessage());
        }
        return new UnitToolboxPage(uiDriver);
    }

    /**
     * @category Milestone 2 Method is used to Check if Date Picker is Disabled
     * @author Mamatha
     * @return boolean
     * @throws Exception
     */
    public boolean isDatePickerDisabled() throws Exception {
        boolean flag = false;
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
     * @category Milestone2 Method is used to Click due date calendar icon
     * @author Mamatha
     * @param itemName
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
            throw new Exception("UNABLE TO CLICK START DATE CALENDAR ICON" + e
                    .getLocalizedMessage());
        }
        return new DatePickerPage(uiDriver);

    }

}
