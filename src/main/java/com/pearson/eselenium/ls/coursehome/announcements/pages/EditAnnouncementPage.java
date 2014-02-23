package com.pearson.eselenium.ls.coursehome.announcements.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.eselenium.ls.course.pages.NextAuthorHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.elements.DefaultUIActions;
import com.pearson.test.eselenium.framework.elements.UIActions;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of EditAnnouncement Follow the below steps to
 * navigate the page: Login as prof Click on the Course Select Author Tab
 * 
 * @author Raghav S
 */

public class EditAnnouncementPage extends BasePageObject {

    private String radeditortoolid = "RadText";
    private String radeditorframeid = "RadText_contentIframe";
    private String subjectradframeid = "SubLineRadText_contentIframe";
    private String subjecttoolid = "SubLineRadText";
    private UIElement btnClickSaveChanges = createElement(UIType.Css, "#saveButtonUp");
    private UIElement btnClickCancel = createElement(UIType.Css, "#cancelButtonUp");
    private UIElement drpStartTime = createElement(UIType.Css, "#startTime");
    private UIElement drpEndTime = createElement(UIType.Css, "#endTime");
    private UIElement lblAnnouncementTitle = createElement(
            UIType.Xpath,
            "//h1[contains(.,'Announcements')]");
    private UIElement lblEditAnnouncementHeaderTitle = createElement(
            UIType.Xpath,
            "//h2[@class='headertitle']//div[contains(.,'Edit Announcement')]");
    private UIElement lblValue = createElement(UIType.Xpath, "//label[contains(.,'{1}')]");
    private UIElement txtSubjectFieldEditor = createElement(
            UIType.Xpath,
            "//table[@id='SubLineRadTextWrapper']");
    private UIElement lblDisplayDates = createElement(
            UIType.Xpath,
            "//td[@class='innercontenttable']//table[tbody//tr[td[contains(.,'Display Dates')]]]");
    private UIElement imgStartDatePicker = createElement(
            UIType.Xpath,
            "//td[input[@id='StartDisplayDate']]//img");
    private UIElement imgEndDatePicker = createElement(
            UIType.Xpath,
            "//td[input[@id='EndDisplayDate']]//img");
    private UIElement lblMandatoryField = createElement(
            UIType.Xpath,
            "//input[@id='saveButton']/parent::td/preceding-sibling::td");
    private UIElement lnkhtml = createElement(UIType.Xpath, "//div//span[contains(.,'HTML')]");
    private UIElement lnkDesign = createElement(UIType.Xpath, "//div//span[contains(.,'Design')]");
    private UIElement txtEditInfo = createElement(
            UIType.Xpath,
            "//td[@class='inlinemessage2']//td[contains(.,'Please be careful when editing')]");
    private UIElement txtradEditorBody = createElement(UIType.Xpath, "//html/body");
    private UIElement lblErrorMessage = createElement(
            UIType.Xpath,
            "//*[@id='frmManageAnnouncement']/table/tbody/tr/td/table[1]/tbody/tr/td[2]/table/tbody/tr/td[2]");
    private UIElement txtStartDate = createElement(UIType.Css, "#StartDisplayDate");
    private UIElement txtEndDate = createElement(UIType.Css, "#EndDisplayDate");
    private UIElements lstDates = createElements(UIType.Css, "#Calendar1>tbody>tr>td>a");
    private UIElement btnCancel = createElement(UIType.Xpath, "//a[contains(.,'Cancel')]");
    private VisualEditor radEditior=new VisualEditor(uiDriver, radeditortoolid, radeditorframeid,radeditorframeid);
    private VisualEditor subjectRadEditor=new VisualEditor(uiDriver, subjecttoolid, subjectradframeid,subjectradframeid);
   
    private UIElement txtRadEditor = createElement(UIType.Xpath, "/html/body");
    /** Date format **/
    Date date1hrAhead = null;
    Date date2hrBefore = null;
    static Date date = new Date();
    SimpleDateFormat sdfwithDate = new SimpleDateFormat("MM/dd/yyyy h:mm a");
    SimpleDateFormat sdfwithTime = new SimpleDateFormat("h:mm a");
    DateFormat parser = new SimpleDateFormat("M/d/yyyy");
    Calendar calendar = Calendar.getInstance();
    private boolean flag = false;

    String strTableTitle = null;
    String strLabelValue = null;
    String strStartDate = null;
    String strEndDate = null;
    String strMessage = null;
    String strContentText = null;
    String strAlertMessage = null;
    String strSelectedValue = null;
    String strValue = null;
    String strRetrievedDate = null;
    UIElement lblParentElement;
    String strDateCellStyle;
    String strDateTime = null;
    String strFormatTime[];
    String strFormatMinute[];
    String strFormattedTime = null;
    int minute;
    String strCurrentTime = null;

    /**
     * Constructor
     * 
     * @param uiDriver
     */
    public EditAnnouncementPage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "Edit Announcement Page";
        logInstruction("LOG INSTRUCTION: ## EDIT ANNOUNCEMENT PAGE ##");
    }

    /**
     * Method helps to get the content radEditor
     * 
     * @author Kapil
     * @return
     */
    public VisualEditor getContentRadEditor() {
        return radEditior;
    }

    /**
     * Method helps to get the subject radEditor
     * 
     * @author Kapil
     * @return
     */
    public VisualEditor getSubjectRaEditor() {
        return subjectRadEditor;
    }

    /**
     * This method clicks on save changes button
     * 
     * @return:NextAuthorHomePage
     * @author:Raghav S
     * @throws Exception
     */
    public Object clickSaveChangesButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON SAVE CHANGES BUTTON");
            frameSwitch.switchToFrameContent();
            btnClickSaveChanges.clickAndWait(waitTime);
            if ((subjectRadEditor.getResponseFromVisualEditor()).isEmpty())
                return this;
            else {
                return new NextAuthorHomePage(uiDriver);
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Click Save Changes Button '" + "\n METHOD:ClickSaveChangesButton \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method clicks on Cancel button
     * 
     * @return:NextAuthorHomePage
     * @author:Raghav S
     * @throws Exception
     */
    public NextAuthorHomePage ClickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            btnClickCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Click Cancel Button '" + "\n METHOD:ClickCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return new NextAuthorHomePage(uiDriver);
    }

    /**
     * This method selects the value from Start Time Drop Down
     * 
     * @return:EditAnnouncementPage
     * @author Raghav S
     * @throws Exception
     */
    public EditAnnouncementPage selectStartTime(String text) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT THE VALUE FROM START TIME DROPDOWN LIST");
            frameSwitch.switchToFrameContent();
            drpStartTime.isDisplayedAfterWaiting(waitTime);
            drpStartTime.selectByVisibleText(text);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Select Start Time '" + "\n METHOD:selectStartTime \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method selects the value from End Time Drop Down
     * 
     * @return:EditAnnouncementPage
     * @param String
     *            - text with end time
     * @author Raghav S
     * @throws Exception
     */
    public EditAnnouncementPage selectEndTime(String text) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT THE VALUE FROM END TIME DROPDOWN LIST");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpEndTime, waitTime);
            drpEndTime.selectByVisibleText(text);
        } catch (Exception e) {
            throw new Exception("UNABLE TO 'Select End Time '" + "\n METHOD:selectEndTime \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to get the Announcements Title
     * 
     * @author ganapati.bhat
     * @return String - title
     * @throws Exception
     */
    public String getAnnouncementsTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GET ANNOUNCEMENT TITLE");
            frameSwitch.switchToFrameContent();
            if (lblAnnouncementTitle.isDisplayedAfterWaiting(waitTime)) {
                strTableTitle = lblAnnouncementTitle.getText();
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Get Announcements Title '" + "\n METHOD:getAnnouncementsTitle \n" + e
                            .getLocalizedMessage());
        }
        return strTableTitle;
    }

    /**
     * Method helps to verify the Add Announcements Header Title
     * 
     * @author ganapati.bhat
     * @return String - title
     * @throws Exception
     */
    public String getEditAnnouncementsHeaderTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: VERIFY EDIT ANNOUNCEMENT TITLE");
            frameSwitch.switchToFrameContent();
            strTableTitle = lblEditAnnouncementHeaderTitle.getText();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Get Edit Announcements Header Title '" + "\n METHOD:getEditAnnouncementsHeaderTitle \n" + e
                            .getLocalizedMessage());
        }
        return strTableTitle;
    }

    /**
     * Method helps to check for Save changes button
     * 
     * @author ganapati.bhat
     * @return boolean
     * @throws Exception
     */
    public boolean isSaveChangesButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK IF SAVE CHANGES BUTTON DISPLAYED");
            frameSwitch.switchToFrameContent();
            if (btnClickSaveChanges.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK If 'Save Changes Button Is Displayed '" + "\n METHOD:isSaveChangesButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check for Cancel button
     * 
     * @author ganapati.bhat
     * @return boolean
     * @throws Exception
     */
    public boolean isCancelButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK  FOR CANCEL  BUTTON");
            frameSwitch.switchToFrameContent();
            if (btnClickCancel.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK If 'Cancel Button Is Displayed '" + "\n METHOD:isCancelButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get label
     * 
     * @author ganapati.bhat
     * @return String - label
     * @throws Exception
     */
    public String getLabel(String label) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CHECK FOR LABEL " + label);
            lblValue.replaceValues(label);
            frameSwitch.switchToFrameContent();
            strLabelValue = lblValue.getText();

        } catch (Exception e) {
            throw new Exception(" UNABLE TO 'Get Label'" + "\n METHOD:getLabel \n" + e
                    .getLocalizedMessage());
        }

        return strLabelValue;
    }

    /**
     * Method helps to verify for the display dates label
     * 
     * @author ganapati.bhat
     * @return boolean
     * @throws Exception
     */
    public boolean isDisplayDateslabelDisplayed() throws Exception {
        flag = false;
        try {

            logInstruction("LOG INSTRUCTION: CHECK FOR DISPLAY DATES LABEL");
            frameSwitch.switchToFrameContent();
            if (lblDisplayDates.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK IF  'Dispaly Dates Label Is Displayed '" + "\n METHOD:isDisplayDateslabelDisplayed \n" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * Method helps to check for subject text editor
     * 
     * @author ganapati.bhat
     * @return boolean
     * @throws Exception
     */
    public boolean isSubjectTextEditorDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK IF SUBJECT TEXT RAD EDITOR IS DISPLAYED");
            frameSwitch.switchToFrameContent();
            if (txtSubjectFieldEditor.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF  'Subject Text Rad Editor Is Displayed '" + "\n METHOD:isSubjectTextEditorDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check for Start Date Text Field
     * 
     * @author ganapati.bhat
     * @return boolean
     * @throws Exception
     */
    public boolean isStartDateFieldDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK IF START DATE FIELD IS DISPLAYED");
            frameSwitch.switchToFrameContent();
            if (txtStartDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF  'Start Date Field Is Displayed'" + "\n METHOD:isStartDateFieldDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check for End Date text field
     * 
     * @author ganapati.bhat
     * @return boolean
     * @throws Exception
     */
    public boolean isEndDateFieldDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK FOR  THE END DATE TEXT FIELD");
            frameSwitch.switchToFrameContent();
            if (txtEndDate.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF  'End Date Field Is Displayed'" + "\n METHOD:isEndDateFieldDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check for Start Date Date Picker
     * 
     * @author ganapati.bhat
     * @return boolean
     * @throws Exception
     */
    public boolean isStartDatePickerIconDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK FOR START  DATE  PICKER ICON");
            frameSwitch.switchToFrameContent();
            if (imgStartDatePicker.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK IF  'Start Date Picker Icon Is Displayed'" + "\n METHOD:isStartDatePickerIconDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check for End Date Date Picker
     * 
     * @author ganapati.bhat
     * @return boolean
     * @throws Exception
     */
    public boolean isEndDatePickerIconDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK FOR END DATE DATE PICKER ICON");
            frameSwitch.switchToFrameContent();
            if (imgEndDatePicker.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK IF  'End Date Picker Icon Is Displayed'" + "\n METHOD:isEndDatePickerIconDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the mandatory field information is displayed
     * 
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isMandatoryFieldTextInfoDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:  CHECK IF MANDATORY FIELD TEXT INFO IS DISPLAYED  ");
            frameSwitch.switchToFrameContent();
            if (lblMandatoryField.isDisplayedAfterWaiting(waitTime))
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK IF  'Mandatory Field Text Info Is Displayed'" + "\n METHOD:isMandatoryFieldTextInfoDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click on the HTML link
     * 
     * @author ganapati.bhat
     * @return EditAnnouncementPage
     * @throws Exception
     */
    public EditAnnouncementPage clickHtmlLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON THE HTML LINK");
            frameSwitch.switchToFrameContent();
            if (lnkhtml.isDisplayedAfterWaiting(waitTime)) {
                lnkhtml.clickAndWait(waitTime);
            }

        } catch (Exception e) {
            throw new Exception(" UNABLE TO 'Click Html Link'" + "\n METHOD:clickHtmlLink \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to click on the Design link
     * 
     * @author ganapati.bhat
     * @return EditAnnouncementPage
     */
    public EditAnnouncementPage clickDesignLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON THE DESIGN LINK");
            frameSwitch.switchToFrameContent();
            if (lnkDesign.isDisplayedAfterWaiting(waitTime)) {
                lnkDesign.clickAndWait(waitTime);
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Click Design Link'" + "\n METHOD:clickDesignLink \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to get the Start Date
     * 
     * @author ganapati.bhat
     * @return String - start date
     * @throws Exception
     */
    public String getStartDate() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: FETCHING THE START DATE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBePresent(txtStartDate, waitTime);
            strStartDate = txtStartDate.getValue();
        } catch (Exception e) {
            throw new Exception(" UNABLE TO 'Get Start Date'" + "\n METHOD:getStartDate \n" + e
                    .getLocalizedMessage());
        }
        return strStartDate;
    }

    /**
     * Method helps to get end date
     * 
     * @author ganapati.bhat
     * @return String - enddate
     * @param String
     *            - Date
     * @throws Exception
     */
    public String getEndDate(String Date) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: FETCHING THE END DATE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBePresent(txtEndDate, waitTime);
            strEndDate = txtEndDate.getValue();
        } catch (Exception e) {
            throw new Exception(" UNABLE TO 'Get End  Date'" + "\n METHOD:getEndDate \n" + e
                    .getLocalizedMessage());
        }
        return strEndDate;
    }

    /**
     * Method helps to get the edit information message
     * 
     * @author ganapati.bhat
     * @return String
     * @throws Exception
     */
    public String getEditInformationMessage() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GET EDIT INFORMATION MESSAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBePresent(txtEditInfo, waitTime);
            if (txtEditInfo.isDisplayedAfterWaiting(waitTime)) {
                strMessage = txtEditInfo.getText();
            }

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO 'Get Edit Information Message'" + "\n METHOD:getEditInformationMessage \n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * @author Ganapati.bhat Method helps to Enter/edit the subject
     * @return String - radeditor subject
     * @throws Exception
     */

    public String getTextFromSubjectRadEditor() throws Exception {

        try {

            logInstruction("LOG INSTRUCTION: GET THE CONTENT FROM RADEDITOR");
            if (!getBrowser().equals(Browser.INTERNETEXPLORER)) {
                frameSwitch.switchToFrameContent();
                frameSwitch.switchToRadEditorSubjectFrame();
                strContentText = txtradEditorBody.getText();

            } else {
                frameSwitch.switchToFrameContent();
                frameSwitch.switchToRadEditorSubjectFrame();
                strContentText = txtRadEditor.getText();
            }

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO 'Get Text From Subject Rad Editor'" + "\n METHOD:getTextFromSubjectRadEditor \n" + e
                            .getLocalizedMessage());
        }
        return strContentText;
    }

    /**
     * @author Ganapati.bhat Method helps to Enter/edit the subject
     * @return String
     * @throws Exception
     */

    public String getTextFromContentRadEditor() throws Exception {

        try {

            logInstruction("LOG INSTRUCTION: GET THE CONTENT FROM RADEDITOR");
            if (!getBrowser().equals(Browser.INTERNETEXPLORER)) {
                frameSwitch.switchToFrameContent();
                frameSwitch.switchToRadeEntryTextcontentIframe();
                strContentText = txtradEditorBody.getText();

            } else {
                logInstruction("LOG INSTRUCTION: SKIPPING TEXT FETCH FOR IE");
            }

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO 'Get Text From Content Rad Editor'" + "\n METHOD:getTextFromContentRadEditor \n" + e
                            .getLocalizedMessage());
        }
        return strContentText;
    }

    /**
     * Method helps to verify the error msg displayed if end date is less than start date
     * 
     * @author kiran kumar s
     * @return String - error msg to verify.
     * @throws Exception
     * 
     */

    public String isErrorMsgForInvalidStartDatePresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: FETCHING ERROR MSG FROM PAGE");
            frameSwitch.switchToFrameContent();

            lblErrorMessage.getText();
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO 'Get Error Message For Invalid Start Date'" + "\n METHOD:IsErrorMsgForInvalidStartDatePresent \n" + e
                            .getLocalizedMessage());
        }
        return lblErrorMessage.getText();
    }

    /**
     * This method is used to check if the start time dropdown is displayed
     * 
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isStartTimeDropdownDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK  FOR START TIME DROPDOWN");
            frameSwitch.switchToFrameContent();
            if (drpStartTime.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF 'Start Time Dropdown Is Displayed'" + "\n METHOD:isStartTimeDropdownDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the end time dropdown is displayed
     * 
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isEndTimeDropdownDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK  FOR END TIME DROPDOWN");
            frameSwitch.switchToFrameContent();
            if (drpEndTime.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK IF 'End Time Dropdown Is Displayed'" + "\n METHOD:isEndTimeDropdownDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to enter End StartDate
     * 
     * @author Raghavendra.Andewadikar
     * @param String
     *            - startdate
     * @return EditAnnouncementPage
     * @throws Exception
     * 
     */
    public EditAnnouncementPage enterStartDate(String startDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR START DATE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtStartDate, waitTime);

            txtStartDate.clear();
            uiDriver.getUIAlert().acceptAlertIfPresent();

            txtStartDate.clickAndWait(waitTime);

            txtStartDate.sendKeys(startDate);

        } catch (Exception e) {
            throw new Exception(" UNABLE TO 'Enter Start Date'" + "\n METHOD:enterStartDate \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to enter End End Date
     * 
     * @author Raghavendra.Andewadikar
     * @return EditAnnouncementPage
     * @param String
     *            - endDate
     * @throws Exception
     * 
     */
    public EditAnnouncementPage enterEndDate(String endDate) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR END DATE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
            txtEndDate.clear();
            uiDriver.getUIAlert().acceptAlertIfPresent();
            txtEndDate.sendKeys(endDate);

        } catch (Exception e) {
            throw new Exception(" UNABLE TO 'Enter End Date'" + "\n METHOD:enterEndDate \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to enter wrong StartDate and get alert message
     * 
     * @author monica.anand
     * @return String - alertmsg
     * @param String
     *            startDate
     * @throws Exception
     * 
     */
    public String enterWrongDateAndGetAlertMessage(String startDate) throws Exception {

        try {

            logInstruction("LOG INSTRUCTION: GETTING THE ALERT MESSAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtStartDate, waitTime);
            txtStartDate.clear();
            txtStartDate.sendKeys(startDate);
            uiDriver.switchTo().activeElement().sendKeys(Keys.ENTER);

        } catch (UnhandledAlertException e) {

            if (getBrowser().equals(Browser.FIREFOX)) {
                strAlertMessage = e.getAlertText();

            } else {
                try {
                    if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
                        btnClickSaveChanges.click();
                        strAlertMessage = uiDriver.getUIAlert().getAlertMessage();
                        uiDriver.getUIAlert().acceptAlertIfPresent();
                    }
                    if (getBrowser().equals(Browser.CHROME)) {
                        strAlertMessage = uiDriver.getUIAlert().getAlertMessage();
                        uiDriver.getUIAlert().acceptAlertIfPresent();
                    }
                } catch (Exception e1) {
                    throw new Exception(
                            "UNABLE TO 'Enter Wrong Date And Get Alert Message'" + "\n METHOD:enterWrongDateAndGetAlertMessage \n" + e1
                                    .getLocalizedMessage());
                }
            }

        }

        return strAlertMessage;

    }

    /**
     * This method is used to check if the tooltip is displayed for start date picker
     * 
     * @author monica.anand
     * @return boolean
     * @param string
     * @throws Exception
     */
    public boolean isTooltipDisplayedForStartDateCalendarIcon(String Expected) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY IF TOOL TIP IS DISPLAYED FOR START DATE CALENDAR ICON");
            frameSwitch.switchToFrameContent();
            UIActions action = new DefaultUIActions(uiDriver, imgStartDatePicker);
            action.mouseMoveHere();
            if (imgStartDatePicker.getAttribute("title").equalsIgnoreCase(Expected))
                flag = true;
            else
                flag = false;
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK IF 'Tool Tip Is Displayed For Start Date Calendar Icon'" + "\n METHOD:isTooltipDisplayedForStartDateCalendarIcon \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to return the default value for start time
     * 
     * @author monica.anand
     * @return String - defaultstarttime
     * @throws Exception
     */
    public String getDefaultStartTime() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: Get Default Start Time");

            frameSwitch.switchToFrameContent();
            List<UIElement> options = drpStartTime.findUIElements(By.tagName("option"));
            for (UIElement option : options) {
                if (option.isSelected()) {
                    return option.getText();
                }
            }

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO 'Get Default Start Time'" + "\n METHOD:getDefaultStartTime \n" + e
                            .getLocalizedMessage());
        }
        return strSelectedValue;
    }

    /**
     * This method is used to check the contents of start time
     * 
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isStartTimeContentsDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR START TIME CONTENTS");
            frameSwitch.switchToFrameContent();
            List<UIElement> options = drpStartTime.findUIElements(By.tagName("option"));
            if (options.size() == 49) {
                flag = true;

            }
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK IF 'Start Time Contents Are Displayed'" + "\n METHOD:isStartTimeContentsDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This method is used to check if the start date field reflects the current date
     * 
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isStartDateDefaultValueDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR START DATE DEFAULT VALUE");
            frameSwitch.switchToFrameContent();
            strValue = txtStartDate.getValue();

            Date date = (Date) parser.parse(strValue);

            strRetrievedDate = parser.format(date);
            java.util.Date d1 = new Date();

            String systemDate = parser.format(d1);
            if (strRetrievedDate.contains(systemDate)) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF 'Start Date Default Value Is Displayed'" + "\n METHOD:isStartDateDefaultValueDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method to click on calendar icon for start date
     * 
     * @author monica.anand
     * @return EditAnnouncementPage
     * @throws Exception
     */
    public EditAnnouncementPage clickStartDateCalendarIcon() throws Exception {
        try {

            logInstruction("LOG INSTRUCTION: Click start date calendar icon");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(imgStartDatePicker);
            imgStartDatePicker.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CLICK  'Start Date Calendar Icon '" + "\n METHOD:clickStartDateCalendarIcon \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to select date
     * 
     * @author monica.anand
     * @param String
     *            - date
     * @return EditAnnouncementPage
     * @throws Exception
     */
    public EditAnnouncementPage selectDate(String Date) throws Exception {
        logInstruction("LOG INSTRUCTION: SELECT DATE");
        frameSwitch.switchToDatePickerPage();
        try {
            uiDriver.waitToBeDisplayed(lstDates.getUIElementByText(Date), waitTime);

            lstDates.getUIElementByText(Date).clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToMainWindow();
        } catch (Exception e) {
            throw new Exception(" UNABLE TO  'Select Date '" + "\n METHOD:selectDate \n" + e
                    .getLocalizedMessage());
        }

        return this;
    }

    /**
     * Method helps to verify focused date
     * 
     * @param String
     *            - Date
     * @throws Exception
     * @returns boolean - true if date is focused false if date not focused
     */
    public boolean isFocusOnDate(String date) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING FOCUS ON DATE");

            frameSwitch.switchToDatePickerPage();
            uiDriver.waitToBeDisplayed(lstDates.getUIElementByIndex(0), waitTime);
            lblParentElement = (UIElement) lstDates.getUIElementByText(date).findElement(
                    By.xpath(".."));
            strDateCellStyle = lblParentElement.getAttribute("style");
            strDateCellStyle = strDateCellStyle.toLowerCase();
            if (!(strDateCellStyle.contains("background-color:white")))
                flag = true;
            else
                flag = false;
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK IF 'Focus Is On Date '" + "\n METHOD:isFocusOnDate \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click cancel button
     * 
     * @author Chaitali
     * @return EditAnnouncementPage
     * @throws Exception
     */
    public EditAnnouncementPage clickCancelButtonInDatePicker() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK CANCEL BUTTON");
            frameSwitch.switchToDatePickerPage();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);

            btnCancel.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToMainWindow();

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO  'Click Cancel Button In Date Picker '" + "\n METHOD:clickCancelButtonInDatePicker \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to check if the tooltip is displayed for end date picker
     * 
     * @author monica.anand
     * @return boolean
     * @param string
     *            - ExpectedToolTip
     * @throws Exception
     */
    public boolean isTooltipDisplayedForEndDateCalendarIcon(String ExpectedToolTip)
            throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: GET TOOL TIP FOR END DATE CALENDAR ICON");
            frameSwitch.switchToFrameContent();
            UIActions action = new DefaultUIActions(uiDriver, imgEndDatePicker);
            action.mouseMoveHere();
            if (imgEndDatePicker.getAttribute("title").equalsIgnoreCase(ExpectedToolTip)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK IF  'TOOL TIP IS DISPLAYED FOR END DATE CALENDAR ICON  '" + "\n METHOD:isTooltipDisplayedForEndDateCalendarIcon \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to return the default value for end time
     * 
     * @author monica.anand
     * @return String - Default end time
     * @throws Exception
     */
    public String getDefaultEndTime() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GET DEFAULT END TIME");

            frameSwitch.switchToFrameContent();
            List<UIElement> options = drpEndTime.findUIElements(By.tagName("option"));
            for (UIElement option : options) {
                if (option.isSelected()) {
                    strSelectedValue = option.getText();
                }
            }

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO 'Get Default End Time'" + "\n METHOD:getDefaultEndTime \n" + e
                            .getLocalizedMessage());
        }
        return strSelectedValue;
    }

    /**
     * This method is used to check the contents of start time
     * 
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isEndTimeContentsDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR END TIME CONTENTS ");
            frameSwitch.switchToFrameContent();
            List<UIElement> options = drpEndTime.findUIElements(By.tagName("option"));
            if (options.size() == 49) {
                flag = true;

            }

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK 'IF END TIME CONTENTS ARE DISPLAYED'" + "\n METHOD:isEndTimeContentsDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method to click on calendar icon for end date
     * 
     * @author monica.anand
     * @return EditAnnouncementPage
     * @throws Exception
     */
    public EditAnnouncementPage clickEndDateCalendarIcon() throws Exception {
        try {

            logInstruction("LOG INSTRUCTION: CLICK END DATE CALENDAR ICON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(imgEndDatePicker);
            imgEndDatePicker.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO 'Click End Date Calendar Icon'" + "\n METHOD:clickEndDateCalendarIcon \n" + e
                            .getLocalizedMessage());
        }
        return this;
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
            logInstruction("LOG INSTRUCTION:FORMAT DATE AND TIME");
            strDateTime = currentDate + " " + currentTime;
            try {
                date = sdfwithDate.parse(strDateTime);

            } catch (ParseException e) {

                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO  'Format Date And Time'" + "\n METHOD:formatDateandTime \n" + e
                            .getLocalizedMessage());
        }
        return date;
    }

    /**
     * Method helps to get the current time
     * 
     * @author ganapati.bhat
     * @return time
     * @throws Exception
     */
    public String getCurrentTime() throws Exception {

        strFormattedTime = sdfwithTime.format(date);
        try {
            logInstruction("LOG INSTRUCTION:GET CURRENT TIME");
            strFormatTime = strFormattedTime.split(":");

            if (strFormatTime[0].equals("00")) {
                strFormatTime[0] = "12";
            }

            strFormatMinute = strFormatTime[1].split(" ");

            minute = Integer.parseInt(strFormatMinute[0]);

            if (minute >= 0 & minute < 30) {
                minute = 0;

            } else {
                minute = 30;

            }
            strFormatMinute[0] = String.valueOf(minute);
            if (strFormatMinute[0].equals("0")) {
                strFormatMinute[0] = "00";
            }

            strDateTime = strFormatTime[0] + ":" + strFormatMinute[0] + " " + strFormatMinute[1];

        } catch (Exception e) {
            throw new Exception("UNABLE TO  'Get Current Time'" + "\n METHOD:getCurrentTime \n" + e
                    .getLocalizedMessage());
        }

        return strDateTime;
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
        strFormattedTime = sdfwithTime.format(date);
        try {
            logInstruction("LOG INSTRUCTION:GET TIME AHEAD OF CURRENT TIME");
            strCurrentTime = getCurrentTime();
            Date formatDate = formatDateandTime(currentDate, strCurrentTime);
            calendar.setTime(formatDate);
            calendar.add(Calendar.HOUR, time);
            date1hrAhead = calendar.getTime();
            strFormattedTime = sdfwithTime.format(date1hrAhead);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO  'Get Time Ahead Of Current Time'" + "\n METHOD:getTimeAheadOfCurrentTime \n" + e
                            .getLocalizedMessage());
        }
        return strFormattedTime;
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
        strFormattedTime = sdfwithTime.format(date);
        try {
            logInstruction("LOG INSTRUCTION:GET TIME BEFORE THE CURRENT TIME");
            strCurrentTime = getCurrentTime();
            Date formatDate = formatDateandTime(currentDate, strCurrentTime);
            calendar.setTime(formatDate);
            calendar.add(Calendar.HOUR, -time);
            date2hrBefore = calendar.getTime();
            strFormattedTime = sdfwithTime.format(date2hrBefore);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO  'Get Time Before The Current Time'" + "\n METHOD:getTimeBeforeTheCurrentTime \n" + e
                            .getLocalizedMessage());
        }
        return strFormattedTime;

    }
}
