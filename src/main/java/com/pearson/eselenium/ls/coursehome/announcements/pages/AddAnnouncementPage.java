package com.pearson.eselenium.ls.coursehome.announcements.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
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
 * Class has the methods to handle the page objects of AddAnnouncement Follow
 * the below steps to navigate the page: Login as prof Click on the Course
 * Select Author Tab
 * 
 * @author Hemant.Kumar
 */

public class AddAnnouncementPage extends BasePageObject {

	private UIElement btnSave = createElement(UIType.Xpath,
			"//*[@id='saveButton']");
	private UIElement btnCancel = createElement(UIType.ID, "cancelButton");
	private UIElement drpStartTime = createElement(UIType.ID, "startTime");
	private UIElement txtSubject = createElement(UIType.ID,
			"SubLineRadTextCenter");
	private UIElement txtBody = createElement(UIType.ID, "RadTextCenter");
	private UIElement lblErrorMessage = createElement(
			UIType.Xpath,
			"//*[@id='frmManageAnnouncement']/table/tbody/tr/td/table[1]/tbody/tr/td[2]/table/tbody/tr/td[2]");
	private UIElement drpEndTime = createElement(UIType.Css, "#endTime");
	private UIElement txtStartDate = createElement(UIType.Css,
			"#StartDisplayDate");
	private UIElement txtEndDate = createElement(UIType.Css, "#EndDisplayDate");
	private UIElement lnkText = createElement(UIType.LinkText, "a");
	private UIElement radEditor = createElement(UIType.ID,
			"RadText_contentIframe");
	private UIElement lblAnnouncementTitle = createElement(UIType.Xpath,
			"//h1[contains(.,'Announcements')]");
	private UIElement lblAddAnnouncementHeaderTitle = createElement(
			UIType.Xpath,
			"//h2[@class='headertitle']//div[contains(.,'Add Announcement')]");
	private UIElement lblText = createElement(UIType.Xpath,
			"//label[contains(.,'{1}')]");
	private UIElement txtSubjectFieldEditor = createElement(UIType.Xpath,
			"//table[@id='SubLineRadTextWrapper']");
	private UIElement lblDisplayDates = createElement(
			UIType.Xpath,
			"//td[@class='innercontenttable']//table[tbody//tr[td[contains(.,'Display Dates')]]]");
	private UIElement imgStartDatePicker = createElement(UIType.Xpath,
			"//td[input[@id='StartDisplayDate']]//img");
	private UIElement imgEndDatePicker = createElement(UIType.Xpath,
			"//td[input[@id='EndDisplayDate']]//img");
	private UIElement lblMandatoryField = createElement(UIType.Xpath,
			"//input[@id='saveButton']/parent::td/preceding-sibling::td");
	private UIElement lnkhtml = createElement(UIType.Xpath,
			"//div//span[contains(.,'HTML')]");
	private UIElement lnkDesign = createElement(UIType.Xpath,
			"//div//span[contains(.,'Design')]");
	private UIElements lblDates = createElements(UIType.Css,
			"#Calendar1>tbody>tr>td>a");
	private UIElement btnMathEditor = createElement(UIType.Css,
			"a[ title='MathEquationEditor']>span");
	private UIElement txtRadSubject = createElement(UIType.Css, "html>body");
	private UIElement lnkParagraphyStyle = createElement(UIType.Css,
			"a[ title='Paragraph Style']>span");
	private UIElement btnDateCancel = createElement(UIType.Xpath,
			"//a[contains(.,'Cancel')]");
	private UIElement txtradEditorBody = createElement(UIType.Xpath,
			"//html/body");;

	/** Date format **/
	Date date1hrAhead = null;
	Date date2hrBefore = null;
	static Date date = new Date();
	SimpleDateFormat sdfwithDate = new SimpleDateFormat("MM/dd/yyyy h:mm a");
	static SimpleDateFormat sdfwithTime = new SimpleDateFormat("h:mm a");
	DateFormat parser = new SimpleDateFormat("M/d/yyyy");
	Calendar calendar = Calendar.getInstance();
	private static String formattedTime = sdfwithTime.format(date);
	private String strSubjectRadEditorToolId = "SubLineRadText";
	private String strSubjectRadEditorFrameId = "SubLineRadText_contentIframe";
	private String strContentRadEditorToolId = "RadText";
	private String strContentRadEditorFrameId = "RadText_contentIframe";
	private VisualEditor subjectRadEditor = new VisualEditor(uiDriver,
			strSubjectRadEditorToolId, strSubjectRadEditorFrameId,
			strSubjectRadEditorToolId);
	private VisualEditor contentRadEditor = new VisualEditor(uiDriver,
			strContentRadEditorToolId, strContentRadEditorFrameId,
			strContentRadEditorToolId);
	UIElement lblParentElement;
	private boolean flag = false;
	String strStartDate = null;
	String strEndDate = null;
	String strTag = null;
	String strTitle = null;
	String strLabelValue = null;
	String strAlertMessage = null;
	String strSelectedValue = "";
	String strStartTimeValue = null;
	String strRetrievedDate = null;
	String strSystemDate = null;

	String strDateCellStyle;
	String strDateTime = null;
	String strFormatTime[];
	String strFormatMinute[];

	String strSelectedMonthYear = "";

	int minute;

	// constructor
	public AddAnnouncementPage(UIDriver uiDriver) {
		super(uiDriver);
		pageTitle = "Add Announcement Page";
		logInstruction("LOG INSTRUCTION: ## Add Announcement Page ##");
	}

	/**
	 * Method helps to get the subject radEditor
	 * 
	 * @category milestone 2
	 * @author Kapil
	 * @return VisualEditor
	 * @throws Exception
	 */
	public VisualEditor getSubjectRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return subjectRadEditor;
	}

	/**
	 * Method helps to get the content radEditor
	 * 
	 * @category milestone 2
	 * @author Kapil
	 * @return VisualEditor
	 * @throws Exception
	 */
	public VisualEditor getContentRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return contentRadEditor;
	}

	/**
	 * @author amit.deshmukh Method helps to click on the Add Announcement
	 *         button
	 * @return Object
	 * @throws Exception
	 */
	public Object clickAddAnnouncement() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE ADD ANNOUNCEMENT BUTTON");

			frameSwitch.switchToFrameContent();
			btnSave.clickAndWait(waitTime);

			if ((subjectRadEditor.getResponseFromVisualEditor()).isEmpty()) {

				return this;

			} else {
				return new NextAuthorHomePage(uiDriver);

			}
		} catch (Exception e) {
			throw new Exception(" UNABLE TO CLICK  ADD ANNOUNCEMENT"
					+ "\n METHOD:clickAddAnnouncement \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * @author amit.deshmukh Method helps to Cancel the content
	 * @return NextAuthorHomePage
	 * @throws Exception
	 */
	public NextAuthorHomePage clickCancelButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON CANCEL BUTTON");

			frameSwitch.switchToFrameContent();

			btnCancel.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception(" UNABLE TO CLICK  CANCEL BUTTON"
					+ "\n METHOD:clickCancelButton \n"
					+ e.getLocalizedMessage());
		}
		return new NextAuthorHomePage(uiDriver);
	}

	/**
	 * @author amit.deshmukh Method helps to add Start time
	 * @param String
	 *            name: start time
	 * @return AddAnnouncementPage
	 * @throws Exception
	 */
	public AddAnnouncementPage enterStartTime(String starttime)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTER START TIME");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(drpStartTime, waitTime);
			drpStartTime.selectByVisibleText(starttime);

		} catch (Exception e) {
			throw new Exception(" UNABLE TO ENTER START TIME"
					+ "\n METHOD:enterStartTime \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to verify the add announcement SubjectText box
	 * 
	 * @author kiran kumar s
	 * @return boolean true if enabled
	 * @throws Exception
	 */
	public boolean isSubjectTextDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY THE SUBJECT TEXT BOX");
			frameSwitch.switchToFrameContent();

			flag = txtSubject.isEnabled();
		} catch (Exception e) {
			throw new Exception(" UNABLE TO VERIFY SUBJECT TXT"
					+ "\n METHOD:verifySubjectTxt \n" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify the add announcement BodyText box
	 * 
	 * @author kiran kumar s
	 * @return boolean true if enabled
	 * @throws Exception
	 */

	public boolean isBodyTextDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY THE BODY TEXT BOX");
			frameSwitch.switchToFrameContent();

			flag = txtBody.isEnabled();
		} catch (Exception e) {
			throw new Exception(" UNABLE TO VERIFY BODY TXT"
					+ "\n METHOD:verifyBodyTxt \n" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to get the Start Date
	 * 
	 * @author kiran kumar s
	 * @return String name: stratdate
	 * @throws Exception
	 */
	public String getStartDate() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: FETCHING THE START DATE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtStartDate, waitTime);
			strStartDate = txtStartDate.getValue();

		} catch (Exception e) {
			throw new Exception(" UNABLE TO GET START DATE"
					+ "\n METHOD:getStartDate \n" + e.getLocalizedMessage());
		}
		return strStartDate;
	}

	/**
	 * Method helps to get end date
	 * 
	 * @author kiran kumar s
	 * @return String name: enddate
	 * @throws Exception
	 */
	public String getEndDate() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: FETCHING THE END DATE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
			strEndDate = txtEndDate.getValue();

		} catch (Exception e) {
			throw new Exception(" UNABLE TO GET END DATE"
					+ "\n METHOD:getEndDate \n" + e.getLocalizedMessage());
		}
		return strEndDate;
	}

	/**
	 * Method helps to verify the error msg displayed if end date is less than
	 * start date
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
					" UNABLE TO VERIFY IF ERROR MSG IS DISPLAYED FOR INVALID START DATE"
							+ "\n METHOD:IsErrorMsgForInvalidStartDatePresent \n"
							+ e.getLocalizedMessage());
		}
		return lblErrorMessage.getText();
	}

	/**
	 * Method helps to enter End Time
	 * 
	 * @author Raghavendra.Andewadikar
	 * @param String
	 *            - endtime
	 * @return AddAnnouncementPage
	 * @throws Exception
	 * 
	 */
	public AddAnnouncementPage enterEndTime(String endTime) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECT END TIME");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(drpEndTime, waitTime);
			drpEndTime.selectByVisibleText(endTime);
		} catch (Exception e) {
			throw new Exception(" UNABLE TO SELECT END TIME"
					+ "\n METHOD:enterEndTime \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to enter End StartDate
	 * 
	 * @author Raghavendra.Andewadikar
	 * @param String
	 *            - startdate
	 * @return AddAnnouncementPage
	 * @throws Exception
	 * 
	 */
	public AddAnnouncementPage enterStartDate(String startDate)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR START DATE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtStartDate, waitTime);

			txtStartDate.sendKeys(Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE);

			boolean alert = isAlert();
			if (alert) {
				uiDriver.getUIAlert().acceptAlertIfPresent();
			}
			frameSwitch.switchToFrameContent();

			txtStartDate.clickAndWait(waitTime);

			txtStartDate.sendKeys(startDate);

		} catch (Exception e) {
			throw new Exception(" UNABLE TO ENTER START DATE"
					+ "\n METHOD:enterStartDate \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to enter End End Date
	 * 
	 * @author Raghavendra.Andewadikar
	 * @param String
	 *            - enddate
	 * @return AddAnnouncementPage
	 * @throws Exception
	 * 
	 */
	public AddAnnouncementPage enterEndDate(String endDate) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR END DATE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
			txtEndDate.sendKeys(Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE);

			boolean alert = isAlert();
			if (alert) {
				uiDriver.getUIAlert().acceptAlertIfPresent();
			}
			frameSwitch.switchToFrameContent();
			txtEndDate.sendKeys(endDate);

		} catch (Exception e) {
			throw new Exception(" UNABLE TO ENTER END DATE"
					+ "\n METHOD:enterEndDate \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to to verify link text in editor.
	 * 
	 * @author hemant.kumar
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isLinkInEditerPresent() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY FOR THE LINK AVAILABLE IN EDITER");
			frameSwitch.selectTopicContentFrame();
			strTag = lnkText.getTagName();
			if (strTag.equals("a")) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					" UNABLE TO VERIFY IF LINK IS PRESENT IN EDITER"
							+ "\n METHOD:IsLinkInEditerPresent \n"
							+ e.getLocalizedMessage());
		}
		return flag;
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
			logInstruction("LOG INSTRUCTION: VERIFY ANNOUNCEMENT TITLE");
			frameSwitch.switchToFrameContent();
			if (lblAnnouncementTitle.isDisplayedAfterWaiting(waitTime)) {
				strTitle = lblAnnouncementTitle.getText();
			}
		} catch (Exception e) {
			throw new Exception(" UNABLE TO  GET ANNOUNCEMENTS TITLE"
					+ "\n METHOD:getAnnouncementsTitle \n"
					+ e.getLocalizedMessage());
		}
		return strTitle;
	}

	/**
	 * Method helps to verify the Add Announcements Header Title
	 * 
	 * @author ganapati.bhat
	 * @return String - title
	 * @throws Exception
	 */
	public String getAddAnnouncementsHeaderTitle() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: VERIFY ADD ANNOUNCEMENT TITLE");
			frameSwitch.switchToFrameContent();
			strTitle = lblAddAnnouncementHeaderTitle.getText();

		} catch (Exception e) {
			throw new Exception(" UNABLE TO GET ADD ANNOUNCEMENTS TITLE"
					+ "\n METHOD:getAddAnnouncementsHeaderTitle \n"
					+ e.getLocalizedMessage());
		}
		return strTitle;
	}

	/**
	 * Method helps to check for Add Announcement button
	 * 
	 * @author ganapati.bhat
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAddAnnouncementButtonDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECK FOR ADD ANNOUNCEMENT BUTTON");
			frameSwitch.switchToFrameContent();
			if (btnSave.isDisplayedAfterWaiting(waitTime)) {
				flag = true;
			}

		} catch (Exception e) {
			throw new Exception(
					" UNABLE TO VERIFY IF ADD ANNOUNCEMENTS BUTTON IS DISPLAYED"
							+ "\n METHOD:isAddAnnouncementButtonDisplayed \n"
							+ e.getLocalizedMessage());
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
			if (btnCancel.isDisplayedAfterWaiting(waitTime)) {
				flag = true;
			}

		} catch (Exception e) {
			throw new Exception(
					" UNABLE TO VERIFY IF CANCEL BUTTON IS DISPLAYED"
							+ "\n METHOD:isCancelButtonDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to get label
	 * 
	 * @author ganapati.bhat
	 * @param String
	 *            - label
	 * @return String - labelValue
	 * @throws Exception
	 */
	public String getLabel(String label) throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CHECK FOR LABEL " + label);
			lblText.replaceValues(label);
			frameSwitch.switchToFrameContent();
			strLabelValue = lblText.getText();

		} catch (Exception e) {
			throw new Exception(" UNABLE TO CHECK IF LABEL IS DISPLAYED"
					+ "\n METHOD:getLabel \n" + e.getLocalizedMessage());
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
					" UNABLE TO CHECK IF DISPLAY DATES LABEL IS DISPLAYED"
							+ "\n METHOD:isDisplayDateslabelDisplayed \n"
							+ e.getLocalizedMessage());
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
			logInstruction("LOG INSTRUCTION: VERIFY IF SUBJECT TEXT EDITOR IS DISPLAYED");
			frameSwitch.switchToFrameContent();
			if (txtSubjectFieldEditor.isDisplayedAfterWaiting(waitTime)) {
				flag = true;
			}

		} catch (Exception e) {
			throw new Exception(
					" UNABLE TO VERIFY IF SUBJECT TEXT EDITOR IS DISPLAYED"
							+ "\n METHOD:isSubjectTextEditorDisplayed \n"
							+ e.getLocalizedMessage());
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
			logInstruction("LOG INSTRUCTION: CHECK FOR  THE START DATE TEXT FIELD");
			frameSwitch.switchToFrameContent();

			if (txtStartDate.isDisplayedAfterWaiting(waitTime)) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					" UNABLE TO VERIFY IF START DATE TEXT FIELD IS DISPLAYED"
							+ "\n METHOD:isStartDateFieldDisplayed \n"
							+ e.getLocalizedMessage());
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
					" UNABLE TO VERIFY IF END DATE TEXT FIELD IS DISPLAYED"
							+ "\n METHOD:isEndDateFieldDisplayed \n"
							+ e.getLocalizedMessage());
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
					" UNABLE TO VERIFY IF START  DATE  PICKER ICON IS DISPLAYED"
							+ "\n METHOD:isStartDatePickerIconDisplayed \n"
							+ e.getLocalizedMessage());
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
					" UNABLE TO VERIFY IF END DATE DATE PICKER ICON IS DISPLAYED"
							+ "\n METHOD:isEndDatePickerIconDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to check if the mandatory field information is
	 * displayed
	 * 
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isMandatoryFieldTextInfoDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION:  IS MANDATORY FIELD TEXT INFO DISPLAYED  ");
			frameSwitch.switchToFrameContent();
			if (lblMandatoryField.isDisplayedAfterWaiting(waitTime))
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					" UNABLE TO VERIFY IF MANDATORY FIELD TEXT INFO IS DISPLAYED"
							+ "\n METHOD:isMandatoryFieldTextInfoDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to click on the HTML link
	 * 
	 * @author ganapati.bhat
	 * @rturn AddAnnouncementPage
	 * @throws Exception
	 */
	public AddAnnouncementPage clickHtmlLink() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE HTML LINK");
			frameSwitch.switchToFrameContent();
			if (lnkhtml.isDisplayedAfterWaiting(waitTime)) {
				lnkhtml.clickAndWait(waitTime);
			}

		} catch (Exception e) {
			throw new Exception(" UNABLE TO CLICK HTML LINK"
					+ "\n METHOD:clickHtmlLink \n" + e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * Method helps to click on the Design link
	 * 
	 * @author ganapati.bhat
	 * @return AddAnnouncementPage
	 * @throws Exception
	 */
	public AddAnnouncementPage clickDesignLink() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE DESIGN LINK");
			frameSwitch.switchToFrameContent();
			if (lnkDesign.isDisplayedAfterWaiting(waitTime)) {
				lnkDesign.clickAndWait(waitTime);
			}

		} catch (Exception e) {
			throw new Exception(" UNABLE TO CLICK DESIGN LINK"
					+ "\n METHOD:clickDesignLink \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to Verify the rad editor displayed or not.
	 * 
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isRadEditorisdisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING IF RAD EDITOR IS DISPLAYED");
			frameSwitch.switchToFrameContent();
			if (radEditor.isDisplayedAfterWaiting(waitTime)) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(" UNABLE TO VERIFY IF RAD EDITOR IS DISPLAYED"
					+ "\n METHOD:isRadEditorisdisplayed \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * @author monica.anand Method helps to enter the topic content
	 * @param String
	 *            - editorContent
	 * @return AddAnnouncementPage
	 * @throws Exception
	 */
	public AddAnnouncementPage enterEditorContentInHTML(String editorContent)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTER THE CONTENT IN HTML MODE");

			frameSwitch.switchToFrameContent();
			uiDriver.sendKeysToBrowser(editorContent);
		} catch (Exception e) {
			throw new Exception(" UNABLE TO ENTER THE CONTENT IN HTML MODE"
					+ "\n METHOD:enterEditorContentInHTML \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to enter wrong StartDate and get alert message
	 * 
	 * @author Usha
	 * @param String
	 *            startDate
	 * @return String - alertmsg
	 * @throws Exception
	 * 
	 */
	public String enterWrongDateAndGetAlertMessage(String startDate)
			throws Exception {

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
						btnSave.click();
						strAlertMessage = uiDriver.getUIAlert()
								.getAlertMessage();
						uiDriver.getUIAlert().acceptAlertIfPresent();
					}
					if (getBrowser().equals(Browser.CHROME)) {

						strAlertMessage = uiDriver.getUIAlert()
								.getAlertMessage();
						uiDriver.getUIAlert().acceptAlertIfPresent();
					}
				} catch (Exception e1) {
					throw new Exception(" UNABLE TO GET THE ALERT MESSAGE"
							+ "\n METHOD:enterWrongDateAndGetAlertMessage \n"
							+ e.getLocalizedMessage());
				}
			}

		}

		return strAlertMessage;

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
					" UNABLE TO CHECK IF START TIME DROPDOWN IS DISPLAYED "
							+ "\n METHOD:isStartTimeDropdownDisplayed \n"
							+ e.getLocalizedMessage());
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
					" UNABLE TO CHECK IF END TIME DROPDOWN IS DISPLAYED "
							+ "\n METHOD:isEndTimeDropdownDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to check if the tooltip is displayed for start date
	 * picker
	 * 
	 * @author monica.anand
	 * @return boolean
	 * @param string
	 *            - ExpectedToolTip
	 * @throws Exception
	 */
	public boolean isTooltipDisplayedForStartDateCalendarIcon(String Expected)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY IF TOOL TIP IS DISPLAYED FOR START DATE CALENDAR ICON");
			frameSwitch.switchToFrameContent();
			UIActions action = new DefaultUIActions(uiDriver,
					imgStartDatePicker);
			action.mouseMoveHere();
			if (imgStartDatePicker.getAttribute("title").equalsIgnoreCase(
					Expected)) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					" UNABLE TO CHECK IF IF TOOL TIP IS DISPLAYED FOR START DATE CALENDAR ICON "
							+ "\n METHOD:isTooltipDisplayedForStartDateCalendarIcon \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to return the default value for start time
	 * 
	 * @author monica.anand
	 * @return String
	 * @throws Exception
	 */
	public String getDefaultStartTime() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: GET DEFAULT START TIME");

			frameSwitch.switchToFrameContent();
			List<UIElement> options = drpStartTime.findUIElements(By
					.tagName("option"));
			for (UIElement option : options) {
				if (option.isSelected()) {
					return option.getText();
				}
			}

		} catch (Exception e) {
			throw new Exception(" UNABLE TO GET DEFAULT START TIME "
					+ "\n METHOD:getDefaultStartTime \n"
					+ e.getLocalizedMessage());
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
			List<UIElement> options = drpStartTime.findUIElements(By
					.tagName("option"));
			if (options.size() == 49) {
				flag = true;

			}
		} catch (Exception e) {
			throw new Exception(" UNABLE TO GET START TIME CONTENTS "
					+ "\n METHOD:isStartTimeContentsDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to check if the start date field reflects the current
	 * date
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
			strStartTimeValue = txtStartDate.getValue();

			Date date = (Date) parser.parse(strStartTimeValue);

			strRetrievedDate = parser.format(date);
			java.util.Date d1 = new Date();

			strSystemDate = parser.format(d1);
			if (strRetrievedDate.contains(strSystemDate)) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(" UNABLE TO GET START DATE DEFAULT VALUE "
					+ "\n METHOD:isStartDateDefaultValueDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method to click on calendar icon for start date
	 * 
	 * @author monica.anand
	 * @return AddAnnouncementPage
	 * @throws Exception
	 */
	public AddAnnouncementPage clickStartDateCalendarIcon() throws Exception {
		try {

			logInstruction("LOG INSTRUCTION: CLICK START DATE CALENDAR ICON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(imgStartDatePicker);
			imgStartDatePicker.clickAndWait(waitTime);

		} catch (Exception e) {
			throw new Exception(" UNABLE TO CLICK START DATE CALENDAR ICON "
					+ "\n METHOD:clickStartDateCalendarIcon \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to select date
	 * 
	 * @author monica.anand
	 * @param String
	 *            - date
	 * @return AddAnnouncementPage
	 * @throws Exception
	 */
	public AddAnnouncementPage selectDate(String Date) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECT DATE");
			frameSwitch.switchToDatePickerPage();

			uiDriver.waitToBeDisplayed(lblDates.getUIElementByText(Date),
					waitTime);
			// List<String> windows = new ArrayList<String>();
			// windows.addAll(uiDriver.getWindowHandles());
			lblDates.getUIElementByText(Date).click();
			uiDriver.getUIWindowLocator().switchToMainWindow();
		} catch (Exception e) {
			throw new Exception(" UNABLE TO SELECT DATE"
					+ "\n METHOD:selectDate \n" + e.getLocalizedMessage());
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
	public boolean verifyFocusOnDate(String date) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING FOCUS ON DATE");

			frameSwitch.switchToDatePickerPage();
			uiDriver.waitToBeDisplayed(lblDates.getUIElementByIndex(0),
					waitTime);
			lblParentElement = (UIElement) lblDates.getUIElementByText(date)
					.findElement(By.xpath(".."));
			strDateCellStyle = lblParentElement.getAttribute("style");
			strDateCellStyle = strDateCellStyle.toLowerCase();

			if (!(strDateCellStyle.contains("background-color:white"))) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(" UNABLE TO VERIFY FOCUS ON DATE"
					+ "\n METHOD:verifyFocusOnDate \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to click cancel button in date picker
	 * 
	 * @author Chaitali
	 * @return AddAnnouncementPage
	 * @throws Exception
	 */
	public AddAnnouncementPage clickCancelButtonInDatePicker() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK CANCEL BUTTON IN DATE PICKER");
			frameSwitch.switchToDatePickerPage();
			uiDriver.waitToBeDisplayed(btnDateCancel, waitTime);
			// List<String> windows = new ArrayList<String>();
			// windows.addAll(uiDriver.getWindowHandles());
			btnDateCancel.clickAndWait(waitTime);
			uiDriver.getUIWindowLocator().switchToMainWindow();

		} catch (Exception e) {
			throw new Exception(" UNABLE TO CLICK CANCEL BUTTON IN DATE PICKER"
					+ "\n METHOD:clickCancelButtonInDatePicker \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method is used to check if the tooltip is displayed for end date
	 * picker
	 * 
	 * @author monica.anand
	 * @return boolean
	 * @param string
	 *            - ExpectedToolTip
	 * @throws Exception
	 */
	public boolean isTooltipDisplayedForEndDateCalendarIcon(String Expected)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY IF TOOL TIP IS DISPLAYED FOR END DATE CALENDAR ICON");
			frameSwitch.switchToFrameContent();
			UIActions action = new DefaultUIActions(uiDriver, imgEndDatePicker);
			action.mouseMoveHere();
			if (imgEndDatePicker.getAttribute("title").equalsIgnoreCase(
					Expected)) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					" UNABLE TO VERIFY IF TOOL TIP IS DISPLAYED FOR END DATE CALENDAR ICON"
							+ "\n METHOD:isTooltipDisplayedForEndDateCalendarIcon \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to return the default value for end time
	 * 
	 * @author monica.anand
	 * @return String - defaultendtime
	 * @throws Exception
	 */
	public String getDefaultEndTime() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: GET DEFAULT END TIME");

			frameSwitch.switchToFrameContent();
			List<UIElement> options = drpEndTime.findUIElements(By
					.tagName("option"));
			for (UIElement option : options) {
				if (option.isSelected()) {
					strSelectedValue = option.getText();
				}
			}

		} catch (Exception e) {
			throw new Exception(" UNABLE TO GET DEFAULT END TIME "
					+ "\n METHOD:getDefaultEndTime \n"
					+ e.getLocalizedMessage());
		}
		return strSelectedValue;
	}

	/**
	 * This method is used to check the contents of end time
	 * 
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isEndTimeContentsDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY IF END TIME CONTENTS ARE DISPLAYED");

			frameSwitch.switchToFrameContent();
			List<UIElement> options = drpEndTime.findUIElements(By
					.tagName("option"));
			if (options.size() == 49) {
				flag = true;

			}

		} catch (Exception e) {
			throw new Exception(
					" UNABLE TO  VERIFY IF END TIME CONTENTS ARE DISPLAYED"
							+ "\n METHOD:isEndTimeContentsDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method to click on calendar icon for end date
	 * 
	 * @author monica.anand
	 * @return AddAnnouncementPage
	 * @throws Exception
	 */
	public AddAnnouncementPage clickEndDateCalendarIcon() throws Exception {
		try {

			logInstruction("LOG INSTRUCTION: CLICK END DATE CALENDAR ICON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(imgEndDatePicker);
			imgEndDatePicker.clickAndWait(waitTime);

		} catch (Exception e) {
			throw new Exception(" UNABLE TO   CLICK END DATE CALENDAR ICON"
					+ "\n METHOD:clickEndDateCalendarIcon \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to check for Alert. It is a webdriver code required to
	 * verify the alert present.
	 * 
	 * @return
	 * @author Ashish
	 */
	public boolean isAlert() {
		try {
			logInstruction("LOG INSTRUCTION: SWITCHING TO ALERT");
			uiDriver.switchTo().alert();
			flag = true;
		} catch (NoAlertPresentException e) {
			flag = false;
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
			logInstruction("LOG INSTRUCTION: GET CURENT TIME");
			strFormatTime = formattedTime.split(":");

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

			strDateTime = strFormatTime[0] + ":" + strFormatMinute[0] + " "
					+ strFormatMinute[1];

		} catch (Exception e) {
			throw new Exception(" UNABLE TO   GET CURENT TIME"
					+ "\n METHOD:getCurrentTime \n" + e.getLocalizedMessage());
		}

		return strDateTime;
	}

	/**
	 * Method helps to get text from content editor
	 * 
	 * @return String
	 * @author Chaitali
	 */
	public String getTextFromContentRadEditor() throws Exception {

		try {

			logInstruction("LOG INSTRUCTION: GET THE CONTENT FROM RADEDITOR");
			if (!getBrowser().toString().equalsIgnoreCase("INTERNETEXPLORER")) {
				frameSwitch.switchToFrameContent();
				uiDriver.switchTo().frame("RadText_contentIframe");
				strTitle = txtradEditorBody.getText();
			} else {
				logInstruction("Skipping text fetch for IE");
			}

		} catch (Exception e) {
			throw new Exception(" UNABLE TO GET THE CONTENT FROM RADEDITOR"
					+ "\n METHOD:getTextFromContentRadEditor \n"
					+ e.getLocalizedMessage());
		}
		return strTitle;
	}

	/**
	 * This Method will click on the MathEquationEditor on RAD Editor
	 * 
	 * @return {@link AddAnnouncementPage}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public AddAnnouncementPage clickMathEditorButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON MATH EDITOR ");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnMathEditor, waitTime);
			btnMathEditor.clickAndWait(waitTime);

		} catch (Exception e) {
			throw new Exception(" UNABLE TO CLICK ON MATH EDITOR"
					+ "\n METHOD:clickMathEditorButton \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This Method will check whether Entered Text in RAD Editor subject Field
	 * Is Present or Not.
	 * 
	 * @return {@link Boolean}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isEnteredTextInAnnouncementSubjectDisplayed()
			throws Exception {
		flag = false;
		try {

			logInstruction("LOG INSTRUCTION: CHECKING TEXT IS DISPLAYED IN SUBJECT RAD EDITOR");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtRadSubject, waitTime);
			strTitle = txtRadSubject.getText().trim();
			if (strTitle != null) {
				flag = true;
			}

		} catch (Exception e) {
			throw new Exception(
					" UNABLE TO CHECK IF TEXT IS DISPLAYED IN SUBJECT RAD EDITOR"
							+ "\n METHOD:isEnteredTextInAnnouncementSubjectDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check whether Paragraph Style Button on RAD Editor is
	 * displayed or not
	 * 
	 * @return {@link Boolean}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isParagraphStyleDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING IF PARAGRAPH STYLE IS DISPLAYED ");
			frameSwitch.switchToFrameContent();
			if (lnkParagraphyStyle.isDisplayedAfterWaiting(waitTime)) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					" UNABLE TO CHECK IF  PARAGRAPH STYLE IS DISPLAYED"
							+ "\n METHOD:isParagraphStyleDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will click on Paragraph Style Button on RAD Editor .
	 * 
	 * @return {@link AddAnnouncementPage}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public AddAnnouncementPage clickParagraphStyleButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:CLICKING ON  PARAGRAPH STYLE BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkParagraphyStyle, waitTime);
			lnkParagraphyStyle.clickAndWait(waitTime);

		} catch (Exception e) {
			throw new Exception(" UNABLE TO CLICK ON   PARAGRAPH STYLE BUTTON "
					+ "\n METHOD:clickParagraphStyleButton \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This Method will get error message when subject field is blank
	 * 
	 * @return String
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public String getErrorMessage() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION:GETTING ERROR MSG WHEN SUBJECT FIELD IS BLANK");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblErrorMessage, waitTime);
			strTitle = lblErrorMessage.getText().trim();

		} catch (Exception e) {
			throw new Exception(" UNABLE TO GET ERROR MESSAGE  "
					+ "\n METHOD:getErrorMessage \n" + e.getLocalizedMessage());
		}
		return strTitle;
	}

	/**
	 * Method helps to verify Alternative Editor Present or not..
	 * 
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author suchi.singh
	 */
	public boolean isEditorSwitchDisplayed() throws Exception {
		flag = false;

		try {
			logInstruction("LOG INSTRUCTION: ALTERNATIVE EDITOR PRESENT OR NOT...");
			flag = false;

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING ALTERNATIVE EDITOR SWITCH OPTION."
							+ "\n METHOD : isEditorSwitchDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify subject rad editor.
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isSubjectRadEditorDisplayed() throws Exception {
		flag = false;

		try {
			logInstruction("LOG INSTRUCTION: VERIFYING SUBJECT RAD EDITOR IS DISPLAYED OR NOT.");
			if (subjectRadEditor != null) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER SUBJECT RAD EDITOR IS DISPLAYED OR NOT."
							+ "\n METHOD : isSubjectRadEditorDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify content rad editor.
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isContentRadEditorDisplayed() throws Exception {
		flag = false;

		try {
			logInstruction("LOG INSTRUCTION: VERIFYING CONTENT RAD EDITOR IS DISPLAYED OR NOT.");

			if (contentRadEditor != null) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER CONTENT RAD EDITOR IS DISPLAYED OR NOT."
							+ "\n METHOD : isSubjectRadEditorDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * 
	 * Method helps to add the announcement. If the values are not needed then,
	 * mention it as null
	 * 
	 * @category milestone 2
	 * @author ganapati.bhat
	 * @param editorContent
	 * @return NextAuthorHomePage
	 * @throws Exception
	 */
	public NextAuthorHomePage addAnnouncement(String title, String content,

	String startDate, String endDate) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTER TITLE.");
			getSubjectRadEditor().enterText(title);
			logInstruction("LOG INSTRUCTION: ENTER CONTENT");
			getContentRadEditor().enterText(content);

			frameSwitch.switchToFrameContent();

			if (StringUtils.isNotBlank(startDate)) {

				logInstruction("LOG INSTRUCTION: ENTER START DATE");

				txtStartDate.sendKeys(Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE);

				boolean alert = isAlert();
				if (alert) {
					uiDriver.getUIAlert().acceptAlertIfPresent();
				}
				frameSwitch.switchToFrameContent();

				txtStartDate.clickAndWait(waitTime);

				txtStartDate.sendKeys(startDate);

			}

			if (StringUtils.isNotBlank(endDate)) {
				logInstruction("LOG INSTRUCTION: ENTER END DATE");
				txtEndDate.sendKeys(Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE);

				boolean alert = isAlert();
				if (alert) {
					uiDriver.getUIAlert().acceptAlertIfPresent();
				}
				frameSwitch.switchToFrameContent();
				txtEndDate.sendKeys(endDate);
			}

			btnSave.clickAndWait(waitTime);

		} catch (Exception e) {
			throw new Exception("UNABLE TO ADD THE ANNOUNCEMENT."
					+ "\n METHOD : addAnnouncement \n"
					+ e.getLocalizedMessage());

		}

		return new NextAuthorHomePage(uiDriver);

	}
}
