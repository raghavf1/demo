package com.pearson.eselenium.ls.contentitems.exams.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
public class ExamEditSchedulePage extends BasePageObject {

	/* Elements */
	private UIElement drpGradebookTime = createElement(UIType.ID,
			"GBReviewTime");
	private UIElement lblAsteriskGradebook = createElement(UIType.Xpath,
			"//td[contains(@colspan,'3')]/text()");
	private UIElement lblDueDate = createElement(UIType.Xpath,
			"//label[contains(@for,'ExamDueDate')]");
	private UIElement txtDueDate = createElement(UIType.Xpath,
			"//input[contains(@name,'examDueDate')]");
	private UIElement imgDueDateCalendar = createElement(UIType.Xpath,
			"//img[contains(@alt,'Due Date')]");
	private UIElement drpDueDate = createElement(UIType.Xpath,
			"//select[contains(@id,'ExamDueTime')]");
	private UIElement btnSaveClose = createElement(UIType.Xpath,
			"//input[contains(@value,'Save ')]");
	private UIElement btnCancel = createElement(UIType.Xpath,
			"//input[contains(@value,'Cancel')]");
	private UIElement lblTimeZone = createElement(UIType.Xpath,
			"//div[contains(@class,'dkgraytext')]");
	private UIElement lblFrameHeader = createElement(UIType.Xpath,
			"//div[contains(@class,'tablehead')]");
	private UIElement chkRestrictAccessAfter = createElement(UIType.ID,
			"RestrictAfter");
	private UIElement chkRestrictAccessBefore = createElement(UIType.ID,
			"RestrictBefore");
	private UIElement lblAsteriskEnd = createElement(UIType.Xpath,
			"//tr[td[input[@id='EndDate']]]//td[3]");
	private UIElement lblAsteriskStart = createElement(UIType.Xpath,
			"//tr[td[input[@id='StartDate']]]//td[3]");
	private UIElement lblStartDate = createElement(UIType.Xpath,
			"//label[contains(@for,'StartDate')]");
	private UIElement lblStartEndDateCaption = createElement(UIType.Xpath,
			"//label[contains(@for,'StartDate')]");
	private UIElement lblUseFollowingDateCaption = createElement(UIType.Xpath,
			"//label[contains(@for,'IsScheduleInheritedNo')]");
	private UIElement lblEndDate = createElement(UIType.Xpath,
			"//label[contains(@for,'EndDate')]");
	private UIElement txtStartdate = createElement(UIType.Xpath,
			"//input[@id='ExamCustomStartDate']");
	private UIElement txtEndDate = createElement(UIType.Xpath,
			"//input[@id='ExamCustomEndDate']");
	private UIElement drpStartTime = createElement(UIType.Xpath,
			"//select[contains(@id,'StartTime')]");
	private UIElement drpEndTime = createElement(UIType.Xpath,
			"//select[contains(@id,'EndTime')]");
	private UIElement drpDueTime = createElement(UIType.Xpath,
			"//select[contains(@id,'DueTime')]");
	private UIElement txtGradebookReview = createElement(UIType.Xpath,
			"//input[@id='GBReviewDate']");
	private UIElement imgCalendarGradebookReview = createElement(UIType.Xpath,
			"//td[input[@id='GBReviewDate']]//a/img");
	private UIElement imgCalendarStart = createElement(UIType.Xpath,
			"//td[input[contains(@id,'StartDate')]]//a/img");
	private UIElement imgCalendarEnd = createElement(UIType.Xpath,
			"//td[input[contains(@id,'EndDate')]]//a/img");
	private UIElement radCourseStartEndDate = createElement(UIType.Xpath,
			"//input[@id='CourseDates']");
	private UIElement radUseFollowingDate = createElement(UIType.Xpath,
			"//input[@id='CustomDates']");
	private UIElement btnSaveAndClose = createElement(UIType.Xpath,
			"//input[@value='Save & Close']");
	private UIElement btncancel = createElement(UIType.Xpath,
			"//input[@value='Cancel']");
	private UIElement txtStartDate = createElement(UIType.Xpath,
			"//input[@id='ExamCustomStartDate']");
	private UIElement txtGradebookReviewDate = createElement(UIType.Xpath,
			"//input[@id='GBReviewDate']");
	private UIElement txtTitle = createElement(UIType.Xpath,
			"//table//tr/td[@class='tablehead']");
	private UIElement radCourseDates = createElement(UIType.Xpath,
			"//input[contains(@id,'CourseDates')]");
	private UIElement radCourseRadioButton = createElement(UIType.Xpath,
			"//tr[td[label[contains(.,'{1}')]]]//input");
	private UIElement radUnitStartEndDates = createElement(UIType.Xpath,
			"//input[@id='CourseDates']");
	private UIElement lblStartEndDates = createElement(UIType.Xpath,
			"//td[contains(text(),'Start and End Dates:')]");
	private UIElement lblUseUnitDates;
	private UIElement radUseUnitDates;
	private UIElement lblRestrictBefore = createElement(UIType.Xpath,
			"//label[contains(@for,'RestrictBefore')]");
	private UIElement lblRestrictAfter = createElement(UIType.Xpath,
			"//label[contains(@for,'RestrictAfter')]");
	private UIElement lblErrorMessage = createElement(UIType.Xpath,
			"//td[@class='inlineerror']//tr//td[2]");

	/* Variables */
	static Date date = new Date();
	Calendar calendar = Calendar.getInstance();
	Date dateAfter = new Date();
	boolean gradeBookTime;
	boolean isAsteriskDisplayed;
	boolean isCaptionDisplayed;
	boolean isCalendarDisplayed;
	boolean isTextboxDisplayed;
	boolean isDropdowVisible;
	boolean isButtonDisplayed;
	boolean isInstructionalTextDisplayed;
	boolean accessAfter;
	boolean accessBefore;
	boolean asterisk;
	boolean endDate;
	boolean startDate;
	boolean calStartDate;
	boolean calEndDate;
	boolean endDateDropdown;
	boolean drpStartDate;
	boolean captionStartEnd;
	boolean captionUseFollowing;
	boolean endTimeDropdown;
	boolean isStartTime;
	boolean gradeBook;
	boolean calGradebook;
	boolean isSelected;
	boolean isDisplayed;
	boolean isDisabled;
	boolean isRadDisplayed;
	String duedate;
	String startDateValue;
	String endDateValue;
	String gradebookReviewDate;
	String text = null;
	String temp[];
	String message;
	String title;
	String label;
	String currentDate;
	String afterDate;
	String beforeDate;
	String alertmessage;
	String errorMessage;

	/* Constructor */
	public ExamEditSchedulePage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("## Exam EditSchedulerPage ##");
	}

	/**
	 * @category Milestone 2 Method is used to verify the content of grade book
	 *           review time drop down
	 * @author Pratush.Manglik
	 * @param grdTime
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isContentOfGradebookTimeDropdownDisplayed(String grdTime)
			throws Exception {
		gradeBookTime = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY THE CONTENT OF GRADE BOOKREVIEW TIME DROPDOWN");
			frameSwitch.switchToPopUpContentFrame();
			List<WebElement> options = drpGradebookTime.findElements(By
					.tagName("option"));
			for (WebElement option : options) {
				if (option.getText().contains(grdTime)) {
					gradeBookTime = true;
				}
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN  VERIFYING THE CONTENT OF GRADE BOOKREVIEW TIME DROPDOWN"
							+ "\n METHOD : isContentOfGradebookTimeDropdownDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return gradeBookTime;
	}

	/**
	 * @category Milestone 2 Method is used to verify grade book asterisk
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isGradebookAsteriskDisplayed() throws Exception {
		isAsteriskDisplayed = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY GRADEBOOK ASTERISK");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblAsteriskGradebook, waitTime);
			if (lblAsteriskGradebook.getText().contains("*")) {
				isAsteriskDisplayed = true;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING GRADEBOOK ASTERISK "
					+ "\n METHOD : isGradebookAsteriskDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return isAsteriskDisplayed;
	}

	/**
	 * @category Milestone 2 Method is used to verify due date caption
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isDueDateCaptionDisplayed() throws Exception {
		isCaptionDisplayed = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY DUE DATE CAPTION");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblDueDate, waitTime);
			if (lblDueDate.getText().contains("Due Date")) {
				isCaptionDisplayed = true;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING DUE DATE CAPTION"
					+ "\n METHOD : isDueDateCaptionDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return isCaptionDisplayed;
	}

	/**
	 * @category Milestone 2 Method is used to verify due date textBox
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isDueDateTextboxDisplayed() throws Exception {
		isTextboxDisplayed = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY DUE DATE TEXT BOX");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(txtDueDate, waitTime);
			isTextboxDisplayed = txtDueDate.isDisplayed();
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING DUE DATE TEXT BOX "
					+ "\n METHOD : isDueDateTextboxDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return isTextboxDisplayed;
	}

	/**
	 * @category Milestone 2 Method is used to verify due date calendar icon
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isDueDateCalendarDisplayed() throws Exception {
		isCalendarDisplayed = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY DUE DATE CALENDAR ICON");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(imgDueDateCalendar, waitTime);
			isCalendarDisplayed = imgDueDateCalendar.isDisplayed();
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING DUE DATE CALENDAR ICON "
					+ "\n METHOD : isDueDateCalendarDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return isCalendarDisplayed;
	}

	/**
	 * @category Milestone 2 Method is used to verify due date drop down
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isDueDateDropDownVisible() throws Exception {
		isDropdowVisible = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY DUE DATE DROPDOWN");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(drpDueDate, waitTime);
			isDropdowVisible = drpDueDate.isDisplayed();
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING DUE DATE DROPDOWN "
					+ "\n METHOD : isDueDateDropDownVisible \n"
					+ e.getLocalizedMessage());
		}
		return isDropdowVisible;
	}

	/**
	 * @category Milestone 2 Method is used to verify Save & Close button
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isSaveAndCloseButtonDisplayed() throws Exception {
		isButtonDisplayed = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY SAVE AND CLOSE BUTTON");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(btnSaveClose, waitTime);
			isButtonDisplayed = btnSaveClose.isDisplayed();
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING SAVE AND CLOSE BUTTON "
					+ "\n METHOD : isSaveAndCloseButtonDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return isButtonDisplayed;
	}

	/**
	 * @category Milestone 2 Method is used to verify Caption of Save & Close
	 *           button
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isSaveAndCloseButtonCaptionDisplayed() throws Exception {
		isCaptionDisplayed = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY SAVE AND CLOSE BUTTON CAPTION");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(btnSaveClose, waitTime);
			if (btnSaveClose.getAttribute("value").contains("Save & Close")) {
				isCaptionDisplayed = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING SAVE AND CLOSE BUTTON CAPTION "
							+ "\n METHOD : isSaveAndCloseButtonCaptionDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return isCaptionDisplayed;
	}

	/**
	 * @category Milestone 2 Method is used to verify Cancel button
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isCancelButtonDisplayed() throws Exception {
		isButtonDisplayed = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY CANCEL BUTTON");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(btnCancel, waitTime);
			isButtonDisplayed = btnCancel.isDisplayed();
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING CANCEL BUTTON "
					+ "\n METHOD : isCancelButtonDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return isButtonDisplayed;
	}

	/**
	 * @category Milestone 2 Method is used to verify Caption of Cancel button
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isCancelButtonCaptionDisplayed() throws Exception {
		isCaptionDisplayed = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY CANCEL BUTTON CAPTION");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(btnCancel, waitTime);
			if (btnCancel.getAttribute("value").contains("Cancel")) {
				isCaptionDisplayed = true;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING CANCEL BUTTON CAPTION"
					+ "\n METHOD : isCancelButtonCaptionDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return isCaptionDisplayed;
	}

	/**
	 * @category Milestone 2 Method is used to verify instructional text about
	 *           time zone
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isInstructionalTextAboutTimeZoneDisplayed() throws Exception {
		isInstructionalTextDisplayed = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY INSTRCUTIONAL TEXT ABOUT TIME ZONE");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblTimeZone, waitTime);
			isInstructionalTextDisplayed = lblTimeZone.isDisplayed();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING INSTRCUTIONAL TEXT ABOUT TIME ZONE"
							+ "\n METHOD : isInstructionalTextAboutTimeZoneDisplayed \n"
							+ e.getLocalizedMessage());

		}
		return isInstructionalTextDisplayed;
	}

	/**
	 * @category Milestone 2 Method is used to verify instructional text caption
	 *           about time zone
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isInstructionalTextAboutTimeZoneCaptionDisplayed()
			throws Exception {
		isCaptionDisplayed = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY INSTRCUTIONAL TEXT CAPTION ABOUT TIME ZONE");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblTimeZone, waitTime);
			if (lblTimeZone.getText().contains(" * Times are displayed ")) {
				isCaptionDisplayed = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING INSTRCUTIONAL TEXT CAPTION ABOUT TIME ZONE"
							+ "\n METHOD : isInstructionalTextAboutTimeZoneCaptionDisplayed \n"
							+ e.getLocalizedMessage());

		}
		return isCaptionDisplayed;
	}

	/**
	 * @category Milestone 2 Method is used to get frame header title
	 * @author Pratush.Manglik
	 * @return String
	 * @throws Exception
	 */
	public String frameHeaderTitle() throws Exception {
		title = null;
		try {
			logInstruction("LOG INSTRUCTION: GET FRAME HEADER TITLE");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblFrameHeader, waitTime);
			title = lblFrameHeader.getText();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING FRAME HEADER TITLE"
					+ "\n METHOD : frameHeaderTitle \n"
					+ e.getLocalizedMessage());
		}
		return title;
	}

	/**
	 * @category Milestone 2 Method helps to click on Restrict access after
	 *           check box.
	 * @return
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public ExamEditSchedulePage clickRestrictAccessAfterCheckBox()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON RESTRICT ACCESS AFTER CHECKBOX");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(chkRestrictAccessAfter, waitTime);
			chkRestrictAccessAfter.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING ON RESTRICT ACCESS AFTER CHECKBOX "
							+ "\n METHOD : clickRestrictAccessAfterCheckBox \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * @category Milestone 2 Method helps to verify Restrict access after check
	 *           box.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isRestrictAccessAfterCheckBoxDisplayed() throws Exception {
		accessAfter = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY RESTRICT ACCESS AFTER CHECKBOX PRESENT");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(chkRestrictAccessAfter, waitTime);
			if (chkRestrictAccessAfter.isDisplayed()) {
				accessAfter = true;

			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING RESTRICT ACCESS AFTER CHECKBOX PRESENT"
							+ "\n METHOD : isRestrictAccessAfterCheckBoxDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return accessAfter;
	}

	/**
	 * @category Milestone 2 Method helps to click on Restrict access before
	 *           check box.
	 * @return ExamEditSchedulePage
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public ExamEditSchedulePage clickRestrictAccessBeforeCheckBox()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON RESTRICT ACCESS BEFORE CHECKBOX");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(chkRestrictAccessBefore, waitTime);
			chkRestrictAccessBefore.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING ON RESTRICT ACCESS BEFORE CHECKBOX"
							+ "\n METHOD : clickRestrictAccessBeforeCheckBox \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * @category Milestone 2 Method helps to verify Restrict access before check
	 *           box.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isRestrictAccessBeforeCheckBoxDisplayed() throws Exception {
		accessBefore = false;
		try {
			logInstruction(" LOG INSTRUCTION: VERIFY RESTRICT ACCESS BEFORE CHECKBOX PRESENT");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(chkRestrictAccessBefore, waitTime);
			if (chkRestrictAccessBefore.isDisplayed()) {
				accessBefore = true;

			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING RESTRICT ACCESS BEFORE CHECKBOX PRESENT "
							+ "\n METHOD : isRestrictAccessBeforeCheckBoxDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return accessBefore;
	}

	/**
	 * @category Milestone 2 Method helps to verify Asterisk.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isAsteriskStartDateDisplayed() throws Exception {
		asterisk = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY ASTERISK PRESENT");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblAsteriskStart, waitTime);
			if (lblAsteriskStart.isDisplayed()) {
				return asterisk = true;

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING ASTERISK PRESENT "
					+ "\n METHOD : isAsteriskStartDateDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return asterisk;

	}

	/**
	 * @category Milestone 2 Method helps to verify Asterisk.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isAsteriskEndDateDisplayed() throws Exception {
		asterisk = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY ASTERISK PRESENT ");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblAsteriskEnd, waitTime);
			if (lblAsteriskEnd.isDisplayed()) {
				return asterisk = true;

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING ASTERISK PRESENT  "
					+ "\n METHOD : isAsteriskEndDateDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return asterisk;

	}

	/**
	 * @category Milestone 2 Method helps to verify End date caption.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isEndDateCaptionDisplayed() throws Exception {
		endDate = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY END DATE CAPTION");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblEndDate, waitTime);
			if (lblEndDate.isDisplayed()) {
				return endDate = true;

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING END DATE CAPTION "
					+ "\n METHOD : isEndDateCaptionDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return endDate;

	}

	/**
	 * @category Milestone 2 Method helps to verify Start date caption.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isStartDateCaptionDisplayed() throws Exception {
		startDate = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY START DATE CAPTION");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblStartDate, waitTime);
			if (lblStartDate.isDisplayed()) {
				return startDate = true;

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING START DATE CAPTION "
					+ "\n METHOD : isStartDateCaptionDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return startDate;

	}

	/**
	 * @category Milestone 2 Method helps to verify calendar for start date.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isCalendarStartDateDisplayed() throws Exception {
		calStartDate = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY START DATE CALENDAR");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(imgCalendarStart, waitTime);
			if (imgCalendarStart.isDisplayed()) {
				return calStartDate = true;

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING START DATE CALENDAR"
					+ "\n METHOD : isCalendarStartDateDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return calStartDate;

	}

	/**
	 * @category Milestone 2 Method helps to verify calendar for end date.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isCalendarEndDateDisplayed() throws Exception {
		calEndDate = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY END DATE CALENDAR");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(imgCalendarEnd, waitTime);
			if (imgCalendarEnd.isDisplayed()) {
				return calEndDate = true;

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING END DATE CALENDAR"
					+ "\n METHOD : isCalendarEndDateDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return calEndDate;

	}

	/**
	 * @category Milestone 2 Method helps to verify End time drop down.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isEndTimeDropDownDisplayed() throws Exception {
		endDateDropdown = false;
		try {
			logInstruction(" LOG INSTRUCTION: VERIFY END TIME DROPDOWN");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(drpEndTime, waitTime);
			if (drpEndTime.isDisplayed()) {
				return endDateDropdown = true;

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING END TIME DROPDOWN"
					+ "\n METHOD : isEndTimeDropDownDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return endDateDropdown;

	}

	/**
	 * @category Milestone 2 Method helps to verify start time drop down.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isStartTimeDropDownDisplayed() throws Exception {
		drpStartDate = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY START TIME DROPDOWN");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(drpEndTime, waitTime);
			if (drpStartTime.isDisplayed()) {
				return drpStartDate = true;

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING START TIME DROPDOWN"
					+ "\n METHOD : isStartTimeDropDownDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return drpStartDate;

	}

	/**
	 * @category Milestone 2 Method helps to verify due time drop down.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isDueTimeDropDownDisplayed() throws Exception {
		drpStartDate = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY DUE TIME DROPDOWN");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(drpDueTime, waitTime);
			if (drpDueTime.isDisplayed()) {
				return drpStartDate = true;

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING DUE TIME DROPDOWN"
					+ "\n METHOD : isDueTimeDropDownDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return drpStartDate;

	}

	/**
	 * @category Milestone 2 Method helps to verify start date text box.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isStartDateTextBoxDisplayed() throws Exception {
		startDate = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY START DATE TEXTBOX");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(txtStartdate, waitTime);
			if (txtStartdate.isDisplayed()) {
				return startDate = true;

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING START DATE TEXTBOX "
					+ "\n METHOD : isStartDateTextBoxDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return startDate;

	}

	/**
	 * @category Milestone 2 Method helps to verify end date text box.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isEndDateTextBoxDisplayed() throws Exception {
		endDate = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY END DATE TEXTBOX");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
			if (txtEndDate.isDisplayed()) {
				return endDate = true;

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING END DATE TEXTBOX"
					+ "\n METHOD : isEndDateTextBoxDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return endDate;

	}

	/**
	 * @category Milestone 2 Method helps to verify caption for course start and
	 *           end date radio button.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isCaptionForUseCourseStartandEndDatesRadioButtonDisplayed()
			throws Exception {
		captionStartEnd = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY START AND END DATE CAPTION");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblStartEndDateCaption, waitTime);
			if (lblStartEndDateCaption.isDisplayed()) {
				return captionStartEnd = true;

			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING START AND END DATE CAPTION"
							+ "\n METHOD : isCaptionForUseCourseStartandEndDatesRadioButtonDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return captionStartEnd;

	}

	/**
	 * @category Milestone 2 Method helps to verify course start and end date
	 *           radio button is selected.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isCaptionForUseCourseStartandEndDatesRadioButtonSelected()
			throws Exception {
		captionStartEnd = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY START AND END DATE CAPTION");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblStartEndDateCaption, waitTime);
			if (lblStartEndDateCaption.isSelected()) {
				return captionStartEnd = true;

			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING START AND END DATE CAPTION"
							+ "\n METHOD : isCaptionForUseCourseStartandEndDatesRadioButtonSelected \n"
							+ e.getLocalizedMessage());
		}
		return captionStartEnd;

	}

	/**
	 * @category Milestone 2 Method helps to click course start and end date
	 *           radio button.
	 * @return ExamEditSchedulePage
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public ExamEditSchedulePage clickUseCourseStartandEndDatesRadioButton()
			throws Exception {

		try {
			logInstruction(" LOG INSTRUCTION: CLICK USE COURSE START END DATE RADIO BUTTON");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(radCourseStartEndDate, waitTime);
			radCourseStartEndDate.clickNoWait();

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING USE COURSE START END DATE RADIO BUTTON"
							+ "\n METHOD : clickUseCourseStartandEndDatesRadioButton \n"
							+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * @category Milestone 2 Method helps to verify caption for use the
	 *           following date radio button.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isCaptionForUseTheFollowingDatesRadioButtonDisplayed()
			throws Exception {
		captionUseFollowing = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY START AND END DATE CAPTION");
			frameSwitch.switchToPopUpContent();
			uiDriver.waitToBeDisplayed(lblUseFollowingDateCaption, waitTime);
			if (lblUseFollowingDateCaption.isDisplayed()) {
				return captionUseFollowing = true;

			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN  VERIFYING START AND END DATE CAPTION"
							+ "\n METHOD : isCaptionForUseTheFollowingDatesRadioButtonDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return captionUseFollowing;

	}

	/**
	 * @category Milestone 2 Method helps to click on use following dates radio
	 *           button.
	 * @return ExamEditSchedulePage
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public ExamEditSchedulePage clickUseFollowingDatesRadioButton()
			throws Exception {

		try {
			logInstruction(" LOG INSTRUCTION: CLICK USE FOLLOWING DATE RADIO BUTTON");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(radUseFollowingDate, waitTime);
			radUseFollowingDate.clickNoWait();

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING USE FOLLOWING DATE RADIO BUTTON"
							+ "\n METHOD : clickUseFollowingDatesRadioButton \n"
							+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * @category Milestone 2 Method helps to click on Save and Close button.
	 * 
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public void clickSaveAndCloseButton() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CLICK SAVE AND CLOSE BUTTON");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
			btnSaveAndClose.clickAndWait(waitTime);
			uiDriver.getUIWindowLocator().switchToFirstWindow();

		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING SAVE AND CLOSE BUTTON "
					+ "\n METHOD : clickSaveAndCloseButton \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * @category Milestone 2 Method helps to verify the content of end time drop
	 *           down.
	 * @param endTime
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isEndTimeDisplayedInDropDown(String endTime)
			throws Exception {
		endTimeDropdown = false;

		try {
			logInstruction("LOG INSTRUCTION: VERIFY CONTENT OF END TIME DROPDOWN");

			frameSwitch.switchToPopUpContentFrame();
			List<WebElement> options = drpEndTime.findElements(By
					.tagName("option"));
			for (WebElement option : options) {
				if (option.getText().contains(endTime)) {
					endTimeDropdown = true;
				}
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING CONTENT OF END TIME DROPDOWN"
							+ "\n METHOD : isEndTimeDisplayedInDropDown \n"
							+ e.getLocalizedMessage());
		}
		return endTimeDropdown;
	}

	/**
	 * @category Milestone 2 Method helps to verify the content of start time
	 *           drop down.
	 * @param startTime
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isStartTimeDisplayedInDropDown(String startTime)
			throws Exception {
		isStartTime = false;

		try {
			logInstruction("LOG INSTRUCTION: VERIFY CONTENT OF START TIME DROPDOWN");

			frameSwitch.switchToPopUpContentFrame();
			List<WebElement> options = drpStartTime.findElements(By
					.tagName("option"));
			for (WebElement option : options) {
				if (option.getText().contains(startTime)) {
					isStartTime = true;
				}
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING CONTENT OF START TIME DROPDOWN"
							+ "\n METHOD : isStartTimeDisplayedInDropDown \n"
							+ e.getLocalizedMessage());
		}
		return isStartTime;
	}

	/**
	 * @category Milestone 2 Method helps to verify grade book text box.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isGradeboobReviewTextBoxDisplayed() throws Exception {
		gradeBook = false;
		try {
			logInstruction(" LOG INSTRUCTION: VERIFY GRADEBOOK TEXTBOX ");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(txtGradebookReview, waitTime);
			if (txtGradebookReview.isDisplayed()) {
				return gradeBook = true;

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING GRADEBOOK TEXTBOX "
					+ "\n METHOD : isGradeboobReviewTextBoxDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return gradeBook;

	}

	/**
	 * @category Milestone 2 Method helps to verify calendar for grade book.
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isCalendarGradebookDisplayed() throws Exception {
		calGradebook = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY GRADEBOOK CALENDAR ");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(imgCalendarGradebookReview, waitTime);
			if (imgCalendarGradebookReview.isDisplayed()) {
				return calGradebook = true;

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING GRADEBOOK CALENDAR "
					+ "\n METHOD : isCalendarGradebookDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return calGradebook;

	}

	/**
	 * @category Milestone 2 Method helps to enter start date.
	 * @param startDate
	 * @return ExamEditSchedulePage
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public ExamEditSchedulePage enterStartDate(String startDate)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR START DATE");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(txtStartdate, waitTime);
			txtStartdate.clearAndSendKeys(startDate);

		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING VALUE FOR START DATE"
					+ "\n METHOD : enterStartDate \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * @category Milestone 2 Method helps to enter due date.
	 * @param dueDate
	 * @return ExamEditSchedulePage
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public ExamEditSchedulePage enterDueDate(String dueDate) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR DUE DATE");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(txtDueDate, waitTime);

			txtDueDate.sendKeys(dueDate);

		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING VALUE FOR DUE DATE"
					+ "\n METHOD : enterDueDate \n" + e.getLocalizedMessage());
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
		duedate = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING VALUE FOR DUE DATE");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(txtDueDate, waitTime);

			duedate = txtDueDate.getText();

		} catch (Exception e) {

			throw new Exception("ISSUE IN GETTING VALUE FOR DUE DATE"
					+ "\n METHOD : getDueDate \n" + e.getLocalizedMessage());
		}
		return duedate;
	}

	/**
	 * @category Milestone 2 Method helps to enter grade book review date.
	 * @param dueDate
	 * @return ExamEditSchedulePage
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public ExamEditSchedulePage enterGradebookReviewDate(String dueDate)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING VALUE FOR GRADEBOOK REVIEW DATE");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(txtGradebookReview, waitTime);

			txtGradebookReview.sendKeys(dueDate);

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN ENTERING VALUE FOR GRADEBOOK REVIEW DATE"
							+ "\n METHOD : enterGradebookReviewDate \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * @category Milestone 2
	 * @author Usha Method helps to get start date
	 * @return String
	 * @throws Exception
	 */
	public String getStartDate() throws Exception {
		startDateValue = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING START DATE");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(txtStartDate, waitTime);
			startDateValue = txtStartDate.getAttribute("value");
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING START DATE"
					+ "\n METHOD : getStartDate \n" + e.getLocalizedMessage());
		}

		return startDateValue;
	}

	/**
	 * @category Milestone 2
	 * @author Usha Method helps to Enter end date
	 * @param endDate
	 * @return ExamEditSchedulePage
	 * @throws Exception
	 */
	public ExamEditSchedulePage enterEndDate(String endDate) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTER END DATE");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
			txtEndDate.clearAndSendKeys(endDate);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING END DATE"
					+ "\n METHOD : enterEndDate \n" + e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * @category Milestone 2
	 * @author Usha Method helps to get end date
	 * @return String
	 * @throws Exception
	 */
	public String getEndDate() throws Exception {
		endDateValue = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING END DATE");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(txtEndDate, waitTime);
			endDateValue = txtEndDate.getAttribute("value");
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING END DATE"
					+ "\n METHOD : getEndDate \n" + e.getLocalizedMessage());
		}

		return endDateValue;
	}

	/**
	 * @category Milestone 2
	 * @author Usha Method helps to get gradebookReview Date
	 * @return String
	 * @throws Exception
	 */
	public String getGradebookReviewDate() throws Exception {
		gradebookReviewDate = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING GRADEBOOK REVIEW DATE");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(txtGradebookReviewDate, waitTime);
			gradebookReviewDate = txtGradebookReviewDate.getAttribute("value");
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING GRADEBOOK REVIEW DATE"
					+ "\n METHOD : getGradebookReviewDate \n"
					+ e.getLocalizedMessage());
		}

		return gradebookReviewDate;
	}

	/**
	 * @category Milestone 2
	 * @author Usha Method helps to get header title
	 * @return String
	 * @throws Exception
	 */
	public String getHeaderTitle() throws Exception {
		title = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING HEADER TITLE");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(txtTitle, waitTime);
			title = txtTitle.getText();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING HEADER TITLE"
					+ "\n METHOD : getHeaderTitle \n" + e.getLocalizedMessage());
		}
		return title;
	}

	/**
	 * @category Milestone 2 This method is used to check radio button is
	 *           selected or not
	 * @param radioButtonLabel
	 * @author Usha
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isRadioButtonSelected(String radioButtonLabel)
			throws Exception {
		logInstruction("LOG INSTRUCTION: CHECKING IF A PARTICULAR RADIO BUTTON IS SELECTED");
		isSelected = false;
		try {
			frameSwitch.switchToPopUpContentFrame();
			radCourseRadioButton.replaceValues(radioButtonLabel);
			uiDriver.waitToBeDisplayed(radCourseRadioButton, waitTime);
			isSelected = radCourseRadioButton.isSelected();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CHECKING IF A PARTICULAR RADIO BUTTON IS SELECTED"
							+ "\n METHOD : isRadioButtonSelected \n"
							+ e.getLocalizedMessage());
		}
		return isSelected;
	}

	/**
	 * @category Milestone 2
	 * @author Usha Method helps to get text next to schedule in header title
	 * @return String
	 * @throws Exception
	 */
	public String getTextFromFieldNextToSchedule() throws Exception {
		text = null;
		title = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING TEXT NEXT TO SCHEDULE");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(txtTitle, waitTime);
			title = txtTitle.getText();
			temp = title.split(" ");
			text = temp[2];

		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING TEXT NEXT TO SCHEDULE"
					+ "\n METHOD : getTextFromFieldNextToSchedule \n"
					+ e.getLocalizedMessage());
		}
		return text;
	}

	/**
	 * @category Milestone 2 This method is used to check if alert displayed
	 * 
	 * @author Usha
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAlertMessageDisplayedAfterEnteringInvalidDate()
			throws Exception {
		logInstruction("LOG INSTRUCTION: CHECKING IF ALERT DISPLAYED");
		isDisplayed = false;
		message = null;
		try {
			uiDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			message = uiDriver.getUIAlert().getAlertMessage();
			if (message != null) {
				isDisplayed = true;
				uiDriver.getUIAlert().acceptAlertIfPresent();
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN  CHECKING IF ALERT DISPLAYED"
							+ "\n METHOD : isAlertMessageDisplayedAfterEnteringInvalidDate \n"
							+ e.getLocalizedMessage());
		}
		return isDisplayed;
	}

	/**
	 * @author Usha Method helps to get alert text
	 * @return String
	 * @throws Exception
	 */
	public String getAlertMesssageContentsAfterEnteringInvalidDate()
			throws Exception {
		title = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING ALERT TEXT");
			title = uiDriver.getUIAlert().getAlertMessage();
			uiDriver.getUIAlert().acceptAlertIfPresent();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN GETTING ALERT TEXT"
							+ "\n METHOD : getAlertMesssageContentsAfterEnteringInvalidDate \n"
							+ e.getLocalizedMessage());
		}
		return title;
	}

	/**
	 * Method is used to Check if Start Date Field is Disabled
	 * 
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isStartDateFieldDisabled() throws Exception {
		isDisabled = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECK IF START DATE FIELD IS DISABLED");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(radCourseDates, waitTime);
			if (radCourseDates.isSelected()) {
				isDisabled = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CHECKING IF START DATE FIELD IS DISABLED"
							+ "\n METHOD : isStartDateFieldDisabled \n"
							+ e.getLocalizedMessage());
		}
		return isDisabled;
	}

	/**
	 * Method is used to Check if End Date Field is Disabled
	 * 
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isEndDateFieldDisabled() throws Exception {
		isDisabled = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECK IF END DATE FIELD IS DISABLED");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(radCourseDates, waitTime);
			if (radCourseDates.isSelected()) {
				isDisabled = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CHECKING IF END DATE FIELD IS DISABLED"
							+ "\n METHOD : isEndDateFieldDisabled \n"
							+ e.getLocalizedMessage());
		}
		return isDisabled;
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
			logInstruction("LOG INSTRUCTION: CLICK ON THE CANCEL BUTTON");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(btncancel, waitTime);
			btncancel.clickAndWait(waitTime);
			uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON THE CANCEL BUTTON"
					+ "\n METHOD : clickCancelButton \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * Method is used to click use end start end date radio button
	 * 
	 * @author Pratush.Manglik
	 * @return ExamEditSchedulePage
	 * @throws Exception
	 */
	public ExamEditSchedulePage clickUseUnitStartandEndDatesRadioButton()
			throws Exception {

		try {
			logInstruction(" LOG INSTRUCTION: CLICKING USE CORSE START END DATE RADIO BUTTON ");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(radUnitStartEndDates, waitTime);
			radUnitStartEndDates.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN  CLICKING USE CORSE START END DATE RADIO BUTTON"
							+ "\n METHOD : clickUseUnitStartandEndDatesRadioButton \n"
							+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * @category Milestone 2 Method is used to get lable next to title Start and
	 *           End Dates:
	 * @author Pratush.Manglik
	 * @return String
	 * @throws Exception
	 */
	public String getStartEndLabel() throws Exception {
		label = null;
		try {
			logInstruction("LOG INSTRUCTION:GET LABLE NEXT TO TITLE START AND END DATES");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblStartEndDates, waitTime);
			label = lblStartEndDates.getText();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN GETTING LABLE NEXT TO TITLE START AND END DATES "
							+ "\n METHOD : getStartEndLabel \n"
							+ e.getLocalizedMessage());
		}
		return label;
	}

	/**
	 * @category Milestone 2 Method is used to verify use unit start end dates
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isUseUnitStartEndDatesRadioButtonDisplayed()
			throws Exception {
		isRadDisplayed = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY USE UNIT START END DATES");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(radUseUnitDates, waitTime);
			isRadDisplayed = radUseUnitDates.isDisplayed();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING USE UNIT START END DATES"
							+ "\n METHOD : isUseUnitStartEndDatesRadioButtonDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return isRadDisplayed;
	}

	/**
	 * @category Milestone 2 Method is used to verify use unit start end dates
	 *           caption
	 * @author Pratush.Manglik
	 * @return String
	 * @throws Exception
	 */
	public String getUseUnitDatesCaption() throws Exception {
		label = null;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY USE UNIT START END DATES CAPTION");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblUseUnitDates, waitTime);
			label = lblUseUnitDates.getText();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING USE UNIT START END DATES CAPTION"
							+ "\n METHOD : getUseUnitDatesCaption \n"
							+ e.getLocalizedMessage());

		}
		return label;
	}

	/**
	 * @category Milestone 2 Method is used to verify restrict Access before
	 *           caption
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isRestrictBeforeCaptionDisplayed() throws Exception {
		isDisplayed = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY RESTRICT ACCESS BEFORE CAPTION");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblRestrictBefore, waitTime);
			isDisplayed = lblRestrictBefore.containsText("before");
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING RESTRICT ACCESS BEFORE CAPTION"
							+ "\n METHOD : isRestrictBeforeCaptionDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return isDisplayed;
	}

	/**
	 * @category Milestone 2 Method is used to verify restrict Access after
	 *           caption
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isRestrictAfterCaptionDisplayed() throws Exception {
		isDisplayed = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY RESTRICT ACCESS AFTER CAPTION");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblRestrictAfter, waitTime);
			isDisplayed = lblRestrictAfter.containsText("after");
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING RESTRICT ACCESS AFTER CAPTION"
							+ "\n METHOD : isRestrictAfterCaptionDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return isDisplayed;
	}

	/**
	 * Method helps to get the current date
	 * 
	 * @author ganapati.bhat
	 * @return String
	 * @throws Exception
	 */

	public String getCurrentDate() throws Exception {
		currentDate = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING CURRENT DATE");
			Date todayDate = new Date();
			SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");
			currentDate = sdfwithOnlyDate.format(todayDate);

		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING CURRENT DATE"
					+ "\n METHOD : getCurrentDate \n" + e.getLocalizedMessage());
		}
		return currentDate;
	}

	/**
	 * Method helps to get future date
	 * 
	 * @param days
	 * @author ganapati.bhat
	 * @return String
	 * @throws Exception
	 */

	public String getFutureDate(int days) throws Exception {
		afterDate = null;
		try {
			logInstruction("LOG INSTRUCTION: GET FUTURE DATE");
			Date todayDate = new Date();
			SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");
			calendar.setTime(todayDate);
			calendar.add(Calendar.DATE, days);
			dateAfter = calendar.getTime();
			afterDate = sdfwithOnlyDate.format(dateAfter);

		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING FUTURE DATE"
					+ "\n METHOD : getFutureDate \n" + e.getLocalizedMessage());
		}
		return afterDate;
	}

	/**
	 * Method helps to get past date
	 * 
	 * @param days
	 * @author ganapati.bhat
	 * @return String
	 * @throws Exception
	 */

	public String getPastDate(int days) throws Exception {
		beforeDate = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING PAST DATE");
			Date todayDate = new Date();
			SimpleDateFormat sdfwithOnlyDate = new SimpleDateFormat("M/d/yyyy");
			calendar.setTime(todayDate);
			calendar.add(Calendar.DATE, -days);
			dateAfter = calendar.getTime();
			beforeDate = sdfwithOnlyDate.format(dateAfter);

		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING PAST DATE"
					+ "\n METHOD : getPastDate \n" + e.getLocalizedMessage());
		}
		return beforeDate;
	}

	/**
	 * @category Milestone 2 Method helps to click on Save and Close button.
	 * @return String
	 * @param data
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public String clickSaveAndCloseButtonForInvalidData(String data)
			throws Exception {
		alertmessage = null;

		try {
			logInstruction("LOG INSTRUCTION: CLICKING SAVE AND CLOSE BUTTON ");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
			btnSaveAndClose.clickNoWait();
			if (!data.equalsIgnoreCase("")) {
				alertmessage = uiDriver.getUIAlert().getAlertMessage();
				uiDriver.getUIAlert().acceptAlertIfPresent();
			}

		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING SAVE AND CLOSE BUTTON"
					+ "\n METHOD : clickSaveAndCloseButtonForInvalidData \n"
					+ e.getLocalizedMessage());
		}

		return alertmessage;
	}

	/**
	 * @category Milestone 2
	 * @author Mamatha Method used to getErrorMessage
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String getErrorMessage() throws Exception {
		errorMessage = null;

		try {
			logInstruction("LOG INSTRUCTION: VERIFYCATION OF ERROR MESSAGE");
			frameSwitch.switchToPopUpContentFrame();
			uiDriver.waitToBeDisplayed(lblErrorMessage, waitTime);
			errorMessage = lblErrorMessage.getText();
		} catch (Exception e) {

			throw new Exception("ISSUE IN GETTING THE ERROR MESSAGE"
					+ "\n METHOD : getErrorMessage \n"
					+ e.getLocalizedMessage());
		}
		return errorMessage;
	}

}
