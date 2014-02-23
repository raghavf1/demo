package com.pearson.eselenium.ls.course.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.coursehome.coursechecklist.pages.CourseCheckListPage;
import com.pearson.eselenium.ls.coursehome.coursechecklist.pages.StudentCourseCheckListPage;
import com.pearson.eselenium.ls.coursetools.gradebook.pages.GradebookDetailsUIPage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.elements.DefaultUIActions;
import com.pearson.test.eselenium.framework.elements.UIActions;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of Author Home page Follow
 * the below steps to navigate the page: Login as prof Click on the Course
 * Select Course Tab
 * 
 * @author sumanth.sv
 */

public class NextCourseHomePage extends BasePageObject {

	/* Elements */
	private UIElement lnkExpandAllIcon = createElement(UIType.Css,
			"a#AnnouncementBox_Announcement1_expandAllLink");
	private UIElement lnkCollapseAllIcon = createElement(UIType.Css,
			"a#AnnouncementBox_Announcement1_collapseAllLink");
	private UIElement lnkExpandIcon = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]//a//img[@title='Expand']");
	private UIElement lnkCollpaseIcon = createElement(
			UIType.Css,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]//a//img[@alt='Collapse']");
	private UIElement tblAnnouncementRow = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'')]]//a[contains(.,'{1}')]");
	private UIElement imgSelectAnnouncement = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]//a[contains(.,'{2}')]");
	private UIElements lnkAnnouncementsList = createElements(UIType.Xpath,
			"//a");
	private UIElement tblSelectAnnouncementContent = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]/following-sibling::tr[1]/td");
	private UIElement tblSelectAnnouncementDateTime = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]//td[2]");
	private UIElement lnkExpandAllToolTip = createElement(UIType.ID,
			"WhatsNew_expandAllLink");
	private UIElement txtDropdownValues = createElement(UIType.ID, "dateIndex");
	private UIElement btnGo = createElement(
			UIType.Xpath,
			"//td[@class='innercontenttable']//tr[td[table[tbody[tr[td[a[contains(.,'{1}')]]]]]]]//td[3]/a");
	private UIElement btnGrade = createElement(
			UIType.Xpath,
			"//td[@class='innercontenttable']//table[tbody[tr[td[table[tbody[tr[td[a[contains(.,'{1}')]]]]]]]]]//tr/td//table//tr[td[contains(.,'{2}')]]//td[4]//img");
	private UIElement lnkGrade = createElement(
			UIType.Xpath,
			"//td[@class='innercontenttable']//table[tbody[tr[td[table[tbody[tr[td[a[contains(.,'{1}')]]]]]]]]]//tr/td//table//tr[td[contains(.,'{2}')]]//td[4]//a");
	private UIElement msgHeader = createElement(UIType.Css,
			"#frmCourseHome>table:nth-of-type(4)>tbody>tr>td>h2");
	private UIElement msgDefaultInfo = createElement(UIType.Xpath,
			"//td[contains(text(),'There are no new items')]");
	private UIElement msgLastLoginInfo = createElement(UIType.Xpath,
			"//td[contains(text(),'Last Login')]");
	private UIElement drpWhatsNewsSinceDropdown = createElement(UIType.Css,
			"#dateIndex");
	private UIElement lnkClickExpandAll = createElement(UIType.Css,
			"WhatsNew_expandAllLink");
	private UIElement lnkClickCollapseAll = createElement(UIType.Css,
			"#WhatsNew_collapseAllLink");
	private UIElement lblSortBy = createElement(
			UIType.Css,
			"#frmCourseHome>table:nth-of-type(5)>tbody>tr>td>table:nth-of-type(1)>tbody>tr>td:nth-of-type(2)");
	private UIElement lnkWhatNewStudentLink = createElement(UIType.Css,
			".outercontenttable>tbody>tr>td>table>tbody>tr>td>a");
	private UIElement lnkGoLink = createElement(
			UIType.Xpath,
			"//td[@class='innercontenttable']//tr[td[table[tbody[tr[td[a[contains(.,'{1}')]]]]]]]//td[3]/a");
	private UIElement drpSortByItemLink = createElement(UIType.Css,
			".outercontenttable>tbody>tr>td>table>tbody>tr>td>a");
	private UIElement lblSelectSortBy = createElement(UIType.Css,
			".outercontenttable>tbody>tr>td>table>tbody>tr>td:nth-child(2)");
	private UIElement txtSortedByItemTxt = createElement(UIType.Css,
			".outercontenttable b");
	private UIElement lnkSortedByStudent = createElement(UIType.Xpath,
			"//a[text()='Student']");
	private UIElement btnClickOnExpand = createElement(
			UIType.Xpath,
			"//table[tbody[tr[td[a[contains(text(),'{1}')]]]]][contains(@id,'collapsed')]/tbody/tr/td[2]/preceding-sibling::td[1]/a/img");
	private UIElement btnClickOnCollapse = createElement(
			UIType.Xpath,
			"//table[@role='presentation']//tbody/tr[td[a[contains(.,'{1}')]]]//td[a[img[@alt='Collapse']]]");
	private UIElements drpListOfDropdown = createElements(UIType.ID,
			"dateIndex");
	private UIElement lblWhatsNewItem = createElement(
			UIType.Xpath,
			"//table[tbody[tr[td[a[contains(text(),'{1}')]]]]][contains(@id,'collapsed')]/tbody/tr/td[2]/a");
	private UIElement txtAudioLink = createElement(UIType.ID, "AudioLink");
	private UIElement txtVideo = createElement(UIType.ID, "VideoText");
	private UIElement lblVideoLink = createElement(UIType.Xpath,
			"//label[contains(@for,'VideoLink')]");
	private UIElement txtBoxAudio = createElement(UIType.Xpath,
			"//input[contains(@id,'AudioText')]");
	private UIElement lblAudioText = createElement(UIType.Xpath,
			"//table[@role='presentation']//tbody//td//label[@for='AudioText']");
	private UIElement lnkRADEditorDisplayed = createElement(UIType.Css,
			"#frmCourseHome>radeditor>a");
	private UIElement lnkCourseWork = createElement(UIType.Css,
			"#CourseChecklistBox_CourseWorkLink");
	private UIElement lblCourseCheckListHeaderDisplayed = createElement(
			UIType.Xpath, "//label[contains(@for,'Course Checklist')]");
	private UIElements txtAuthorTab = createElements(
			UIType.Xpath,
			"//td[@class='innercontenttable']//table[tbody[tr[td[table[tbody[tr[td[a[contains(.,'{1}')]]]]]]]]]//tr[2]/td");
	private UIElement lblCourseTitle = createElement(UIType.Xpath,
			"//h1[contains(.,'Course Home')]");
	private UIElement lblAnnouncementHeaderTitle = createElement(UIType.Xpath,
			"//h2[@class='headertitle']//div[contains(.,'Announcements')]");
	private UIElement imgCourseChecklistIcon = createElement(UIType.Xpath,
			"//table[contains(@id,'CourseChecklistBox')]//img");
	private UIElement lnkCourseChecklist = createElement(UIType.Css,
			"a[title*='Course Checklist']");
	private UIElement msgCourseChecklist = createElement(UIType.Css,
			"#CourseChecklistBox_StudentChecklistMessage");
	private UIElement msgGrayTimeDisplay = createElement(UIType.Css,
			".dkgraytext");
	private UIElements lblCourseChecklist = createElements(UIType.Css,
			"div.tablehead");
	private UIElement lblAnouncementTableHeader = createElement(UIType.Css,
			"course.AnnouncementTableheader");
	private UIElement imgAnnouncementRead = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tbody//tr[th[a[contains(.,'{1}')]]]//th//img[@alt='Mark as Read']");
	private UIElement lnkExpandAll = createElement(UIType.Css,
			"AnnouncementBox_Announcement1_expandAllLink");
	private UIElement lnkStudWhatsNewItem = createElement(UIType.Xpath,
			"//a[contains(text(),'{1}')]");
	private UIElement tblDefaultInfoStudent = createElement(UIType.Xpath,
			"table[id='announcement1_collapsed']>tbody>tr>td");
	private UIElement imgCollapseIcon = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]//a//img[@alt='Collapse']");
	private UIElement imgAnnouncementUnRead = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tbody//tr[th[a[contains(.,'{1}')]]]//th//img[@alt='Mark as UnRead']");
	private UIElement tblGetWhatsNewDetailsForStudent = createElement(
			UIType.Xpath,
			"//th[a[contains(text(),'{1}')]]/following-sibling::td");
	private UIElement lnkToFilesAdded = createElement(UIType.Xpath,
			"//a[text()='{1}']");
	private UIElement txtCourseIntrotext = createElement(UIType.Css,
			"#frmCourseHome>radeditor#frmCourseHome>radeditor");
	private UIElement btnClickSaveChanges = createElement(UIType.Xpath,
			"//input[contains(@value,' Save Changes')]");
	private UIElement msgCourseText = createElement(UIType.Css, ".coursetitle");
	private UIElement lnkUnderAnnoncement = createElement(UIType.Xpath,
			"//td[contains(.,'{1}')]/a[contains(.,'{2}')]");
	private UIElement lblRADEditor = createElement(UIType.Css, "radeditor");
	private UIElements lstAnnouncementDisplay = createElements(UIType.Css,
			".innercontenttable>table>tbody>tr>th:nth-of-type(1)");
	private UIElement msgErrorMsg = createElement(UIType.Xpath,
			"//td[2]//td[2]");
	private UIElement msgGetContent = createElement(UIType.Xpath, "//html/body");
	private UIElements lblTableHeaders = createElements(UIType.Xpath,
			"//th[@class='threadheading']");
	private UIElement lnkCourseIntroductionLink = createElement(UIType.Xpath,
			"//a[contains(.,'{1}')]");
	private UIElement lnkAddEntry = createElement(UIType.Xpath,
			"//a[@title='Add Entry']");
	private UIElement lnkBaskets = createElement(UIType.Xpath,
			"//a[contains(text(),'Baskets')]");
	private UIElement lnkStudents = createElement(UIType.Xpath,
			"//a[contains(text(),'Students')]");
	private UIElement lnkEntireInbox = createElement(UIType.Xpath,
			"//a[contains(text(),'Entire Inbox')]");
	private UIElement lnkSubmitAssignment = createElement(UIType.Xpath,
			"//a[@title='Submit Assignment']");
	private UIElements lblEmail = createElements(UIType.Xpath, "//label");
	private UIElement lnkGradebook = createElement(UIType.Xpath,
			"//a[contains(text(),'{1}')]");
	private UIElement lblStudentTableHeader = createElement(UIType.Xpath,
			"//div[@class='tablehead']");
	private UIElement lblHeader = createElement(UIType.Xpath,
			"//div[@class='pageTitle']");
	private UIElement imgUploaded = createElement(UIType.ID,
			"//img[@title='{1}']");
	private UIElement txtTitle = createElement(UIType.Xpath,
			"//html/body/h1/div");
	private UIElement lblCourseHome = createElement(UIType.Css,
			"a[class='unitON']");
	private UIElements lnkClickSimpleEditor = createElements(UIType.Xpath,
			"//simpleeditor/a");
	private UIElement txtSimpleEditor = createElement(UIType.Xpath,
			"//simpleeditor//a[contains(text(),'{1}')]");
	private UIElement lblSimpleEditor = createElement(UIType.Xpath,
			"//simpleeditor");
	private UIElement lblInstructor = createElement(UIType.Xpath,
			"//div[@class='profname']");
	private UIElement lblImgTitle = createElement(UIType.Xpath,
			"//img[@title='{1}']");
	private UIElement lblPageTitle = createElement(UIType.ClassName,
			"pageTitle");
	private UIElement msgSimple = createElement(UIType.Xpath,
			"html/body/form/simpleeditor/font");
	private UIElement txtFontStyleCourseintrtext = createElement(
            UIType.Xpath,
            "//form/radeditor/font[contains(.,'{1}')]");

	// local variables
	private UIElement simpleEditorText;
	private static final String COURSE_HOME = "Course Home";
	String announcementContent = null;
	String dateTime = null;
	List<UIElement> announcementListElement;
	List<String> dropdownlist;
	List<UIElement> dropDownElements;
	UIElement whatsNewGoButton = null;
	UIElement gradeIcon = null;
	UIElement gradeLink = null;
	String hdrTitle = null;
	String defaultInfo = null;
	String lastLoginInfo = null;
	String getlabelBySort = null;
	String selectSortBy = null;
	String selectedWhatsNewSinceDwn;
	String videoLinklabel = null;
	String strAnnouncementNameBold = null;
	String expandAllToolTip = null;
	String[] sectionTitleNames;
	boolean flag;
	String fontStyle = null;
	
	/* Constructor */
	public NextCourseHomePage(UIDriver uiDriver) throws Exception {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ## NextCourseHomePage ##");
	}

	/**
	 * This method helps to select the announcement
	 * 
	 * @author ashish.juyal
	 * @param String
	 *            name: announcementName
	 * @return NextAuthorHomePage
	 * @throws Exception
	 */
	public NextCourseHomePage selectAnnouncement(String announcementName)
			throws Exception {
		logInstruction("LOG INSTRUCTION: SELECTING THE ANNOUNCEMENT");
		try {
			frameSwitch.switchToFrameContent();
			imgSelectAnnouncement.replaceValues(announcementName,
					announcementName);
			imgSelectAnnouncement.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON THE ANNOUNCEMENT \n METHOD: selectAnnouncement"
							+ "\n METHOD:selectAnnouncement\n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to click on the expand all button
	 * 
	 * @return NextCourseHomePage
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public NextCourseHomePage clickExpandAllButton() throws Exception {
		logInstruction("LOG INSTRUCTION: CLICKING THE EXPAND ALL BUTTON");
		try {
			frameSwitch.switchToFrameContent();
			lnkExpandAllIcon.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON THE EXPAND ALL BUTTON \n METHOD:clickExpandAllButton "
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to click on the Collapse All button
	 * 
	 * @author ashish.juyal
	 * @return NextCourseHomePage
	 * @throws Exception
	 */
	public NextCourseHomePage clickCollpaseAllButton() throws Exception {
		logInstruction("LOG INSTRUCTION: CLICKING COLLAPSE ALL BUTTON");
		try {
			frameSwitch.switchToFrameContent();
			lnkCollapseAllIcon.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON THE COLLAPSE ALL BUTTON \n METHOD : clickCollpaseAllButton"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to click on the expand icon of the announcement.
	 * 
	 * @param String
	 *            announcementName
	 * @author ashish.juyal
	 * @return NextCourseHomePage
	 * @throws Exception
	 * 
	 */
	public NextCourseHomePage clickExpandIcon(String announcementName)
			throws Exception {
		logInstruction("LOG INSTRUCTION: CLICKING EXPAND ICON");
		try {
			frameSwitch.switchToFrameContent();
			lnkExpandIcon.replaceValues(announcementName);
			lnkExpandIcon.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON THE EXPAND ALL ICON \n METHOD : clickExpandIcon"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to click on the collapse icon
	 * 
	 * @author ashish.juyal
	 * @param String
	 *            name: announcementName
	 * @return NextCourseHomePage
	 * @throws Exception
	 */
	public NextCourseHomePage clickCollpaseIcon(String announcementName)
			throws Exception {

		logInstruction("LOG INSTRUCTION: CLICKING COLLAPSE ICON");
		try {
			frameSwitch.selectTopicContentFrame();
			lnkCollpaseIcon.replaceValues(announcementName);
			lnkCollpaseIcon.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON THE COLLAPSE ICON \n METHOD : clickCollpaseIcon"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to get announcement content
	 * 
	 * @author shishir.dwivedi
	 * @return String name:announcementContent
	 * @param String
	 *            name: announcementName
	 * 
	 */
	public String getAnnouncementContent(String announcementName)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE ANNOUNCEMENT CONTENT");
			frameSwitch.switchToFrameContent();
			announcementContent = tblSelectAnnouncementContent.replaceValues(
					announcementName).getText();

		} catch (Exception e) {
			throw new Exception(
					"ANNOUNCEMENT CONTENT NOT AVAILABLE. \n METHOD :getAnnouncementContent "
							+ e.getLocalizedMessage());
		}
		return announcementContent;
	}

	/**
	 * This method helps to get announcement date and time.
	 * 
	 * @author shishir.dwivedi
	 * @return String name: dateTime
	 * @param String
	 *            name: announcementName
	 * @throws Exception
	 */
	public String getAnnouncementDateTime(String announcementName)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: GETTING DATE AND TIME OF ANNOUNCEMENT");
			frameSwitch.switchToFrameContent();
			dateTime = tblSelectAnnouncementDateTime.replaceValues(
					announcementName).getValue();
		} catch (Exception e) {
			throw new Exception(
					"ANNOUNCEMENT CONTENT NOT AVAILABLE \n METHOD :getAnnouncementDateTime "
							+ e.getLocalizedMessage());
		}
		return dateTime;
	}

	/**
	 * This method helps to find whether tool tip is displayed for expand all
	 * icon..
	 * 
	 * @author Shishir.Dwivedi
	 * @return boolean
	 * @param string
	 *            name: expectedToolTip
	 * @throws Exception
	 */
	public boolean isTooltipDisplayedForExpandAllIcon(String expectedToolTip)
			throws Exception {
		try {
			flag = false;
			logInstruction("LOG INSTRUCTION: SWITCH TO CONTENT FRAME");
			frameSwitch.switchToFrameContent();
			UIActions action = new DefaultUIActions(uiDriver, lnkExpandAllIcon);
			action.mouseMoveHere();
			if (lnkExpandAllIcon.getAttribute("title").equalsIgnoreCase(
					expectedToolTip))
				flag = true;
			else
				flag = false;
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET TOOLTIP \n METHOD : isTooltipDisplayedForExpandAllIcon "
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method to Verify Announcement Displayed
	 * 
	 * @author suchi.singh
	 * @param String
	 *            name: announcementName
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAnnouncementDisplayed(String announcementName)
			throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING IF ANNOUNCEMENT IS DISPLAYED IN THE LIST");
			frameSwitch.switchToFrameContent();
			String browser = System.getProperty("browser.NAME");
			if (browser.equalsIgnoreCase("firefox")) {
				announcementListElement = lstAnnouncementDisplay
						.getUIElementsList();
				announcementListElement.remove(0);
				for (int i = 0; i < announcementListElement.size(); i++) {
					if (announcementName.equals(announcementListElement.get(i)
							.getText())) {
						flag = true;
						break;
					}
				}
			} else {

				announcementListElement = lnkAnnouncementsList
						.getUIElementsList();
				for (int i = 0; i < announcementListElement.size(); i++) {
					if (announcementListElement.get(i).getText()
							.contains(announcementName)) {
						flag = true;
						break;
					}

				}
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO VERIFY THE ANNOUNCEMENT \n METHOD :isAnnouncementDisplayed "
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method for Verify collapse announcement
	 * 
	 * @author suchi.singh
	 * @param String
	 *            name: announcementName
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAnnouncementCollapsed(String announcementName)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY COLLAPSE ANNOUNCEMENT");
			frameSwitch.switchToFrameContent();
			tblAnnouncementRow.replaceValues(announcementName);
			String s = tblAnnouncementRow.getAttribute("title");
			if (s.trim().equalsIgnoreCase("Collapse")) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO VERIFY COLLAPSE ANNOUNCEMENT \n METHOD :isAnnouncementCollapsed "
							+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method for Verify new announcement(Bold)
	 * 
	 * @author suchi.singh
	 * @param String
	 *            name: announcementName
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAnnouncementTextBold(String announcementName)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY NEW ANNOUNCEMENT(BOLD)");
			frameSwitch.switchToFrameContent();
			imgSelectAnnouncement.replaceValues(announcementName,
					announcementName);
			strAnnouncementNameBold = imgSelectAnnouncement
					.getAttribute("class");
			if (strAnnouncementNameBold.equalsIgnoreCase("unread")) {
				logInstruction("LOG INSTRUCTION: ANNOUNCEMENT IS IN BOLD LETTER");
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO VERIFY NEW ANNOUNCEMENT(BOLD) \n METHOD :isAnnouncementTextBold "
							+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method for verify read announcement(Regular Text)
	 * 
	 * @author suchi.singh
	 * @param String
	 *            name: announcementName
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAnnouncementRead(String announcementName) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY READ ANNOUNCEMENT(REGULAR TEXT)");
			frameSwitch.switchToFrameContent();
			imgAnnouncementRead.replaceValues(announcementName);
			if (imgAnnouncementRead.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO VERIFY READ ANNOUNCEMENT(REGULAR TEXt) \n METHOD : isAnnouncementRead"
							+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * This Method gets the tooltip of Expand in WhatsNewPage
	 * 
	 * @return String
	 * @author Raghav S
	 * @throws Exception
	 */
	public String getExpandAllToolTip() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CAPTURING THE EXPANDALL TOOL TIP VALUE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkExpandAllToolTip, waitTime);
			expandAllToolTip = lnkExpandAllToolTip.getAttribute("title");
			logInstruction("LOG INSTRUCTION: ExpandAll Tool Tip Value is Captured");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE TOOL TIP OF WHATSNEW \n METHOD : getExpandAllToolTip"
							+ e.getLocalizedMessage());
		}
		return expandAllToolTip;
	}

	/**
	 * This Method gets the WhatsNewSinceDropdownValues in WhatsNewPage
	 * 
	 * 
	 * @return List<String> name: dropdownlist for WhatsNewSince
	 * @author:Raghav S
	 * @throws Exception
	 */
	public List<String> getWhatsNewSinceDropdownValues() throws Exception {

		dropdownlist = new ArrayList<String>();
		try {
			logInstruction("LOG INSTRUCTION: CAPTURING WHATSNEWSINCE DROP DOWN VALUES");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtDropdownValues, waitTime);
			dropDownElements = drpListOfDropdown.getUIElementsList();
			for (int i = 0; i < dropDownElements.size(); i++) {
				dropdownlist.add(dropDownElements.get(i).getText().trim());
			}
			logInstruction("LOG INSTRUCTION: WhatsNewSince Drop Down Values are Captured");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET WHATSNEWSINCE DROP DOWN VALUES \n METHOD :getWhatsNewSinceDropdownValues "
							+ e.getLocalizedMessage());
		}
		return dropdownlist;
	}

	/**
	 * This Method checks whether the GoButton is Displayed or not
	 * 
	 * @return boolean
	 * @param String
	 *            name:WhatsNewTitle
	 * @author:Raghav S
	 * @throws Exception
	 */

	public boolean isGoButtonDisplayed(String whatsNewtitle) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CAPTURING THE ISGOBUTTON STATUS");
			frameSwitch.switchToFrameContent();
			btnGo.replaceValues(whatsNewtitle);
			uiDriver.waitToBeDisplayed(whatsNewGoButton, waitTime);
			if (btnGo.getAttribute("title").trim().equalsIgnoreCase("Go")) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CAPTURE GO BUTTON \n METHOD :isGoButtonDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method checks whether the GradeIcon is Displayed or not
	 * 
	 * @param String
	 *            whatsNewTitle String subTitle
	 * @return boolean
	 * @author:Raghav S
	 * @throws Exception
	 */
	public boolean isGradeIconDisplayed(String whatsNewTitle, String subTitle)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CAPTURING THE GRADEICONDISPLAYED STATUS");
			frameSwitch.switchToFrameContent();
			btnGrade.replaceValues(whatsNewTitle, subTitle);
			uiDriver.waitToBeDisplayed(gradeIcon, waitTime);
			if (btnGrade.isPresent()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CAPTURE GRADEICONDISPLAYED \n METHOD :isGradeIconDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method checks whether the GradeLink is Displayed or not
	 * 
	 * @author Raghav S
	 * @return boolean
	 * @param String
	 *            name: whatsnewtitle
	 * @param String
	 *            name: subtitle
	 * @throws Exception
	 */
	public boolean isGradeLinkDisplayed(String whatsnewTitle, String subTitle)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CAPTURING THE GRADELINKDISPLAYED STATUS");
			frameSwitch.switchToFrameContent();
			lnkGrade.replaceValues(whatsnewTitle, subTitle);
			uiDriver.waitToBeDisplayed(gradeLink, waitTime);
			if (lnkGrade.getAttribute("title").equalsIgnoreCase("Grade")) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CAPTURE GRADELINK DSIPALYED \n METHOD :isGradeLinkDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method checks whether the GradeLink is Displayed or not
	 * 
	 * @author Raghav S
	 * @return boolean
	 * @param String
	 *            name: whatsnewtitle
	 * @param String
	 *            name: subtitle
	 * @throws Exception
	 */
	public boolean isGradeLinkPresent(String whatsnewTitle, String subTitle)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CAPTURING THE GRADELINKDISPLAYED STATUS");
			frameSwitch.switchToFrameContent();
			lnkGrade.replaceValues(whatsnewTitle, subTitle);
			if (lnkGrade.isDisplayed()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CAPTURE GRADELINK DSIPALYED \n METHOD :isGradeLinkPresent"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method checks whether the GradeLink is Displayed or not
	 * 
	 * @return GradebookDetailsUIPage
	 * @author Raghav S
	 * @param String
	 *            name: whatsnewtitle
	 * @param String
	 *            name: subtitle
	 * @throws Exception
	 */
	public GradebookDetailsUIPage clickGradeLink(String whatsnewtitle,
			String subtitle) throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON THE GRADELINK");
			frameSwitch.switchToFrameContent();
			gradeLink = lnkGrade.replaceValues(whatsnewtitle, subtitle);
			uiDriver.waitToBeDisplayed(gradeLink, waitTime);
			lnkGrade.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED ON THE GRADELINK");
		} catch (Exception e) {
			throw new Exception(
					"Unable to Click on Grade Link \n METHOD :clickGradeLink"
							+ e.getLocalizedMessage());
		}
		return null;
	}

	/**
	 * Method helps to getHeadertitle
	 * 
	 * @author amit.deshmukh
	 * @return String name: header title
	 * @throws Exception
	 */

	public String getHeaderTitle() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: GET HEADER TITLE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(msgHeader, waitTime);
			hdrTitle = msgHeader.getText();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET HEADER MSG \n METHOD :getHeaderTitle"
							+ e.getLocalizedMessage());
		}
		return hdrTitle;
	}

	/**
	 * Before using the this Method execute selectWhatsNewSinceDropDown Method
	 * Method helps to getDefaultInfo
	 * 
	 * @author amit.deshmukh
	 * @return String name: defaultInfo
	 * @throws Exception
	 */

	public String getDefaultInfo() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: GET DEFAULT INFO");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(msgDefaultInfo, waitTime);
			defaultInfo = msgDefaultInfo.getText().trim();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET DEFAULT INFO \n METHOD :getDefaultInfo"
							+ e.getLocalizedMessage());
		}
		return defaultInfo;
	}

	/**
	 * Method helps to getLastLoginInfo
	 * 
	 * @author amit.deshmukh
	 * @return String name: lastLoginInfo
	 * @throws Exception
	 */

	public String getLastLoginInfo() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: GET LAST LOGIN INFO");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(msgLastLoginInfo, waitTime);
			lastLoginInfo = msgLastLoginInfo.getText();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE GET LAST LOGIN INFO \n METHOD :getLastLoginInfo"
							+ e.getLocalizedMessage());
		}
		return lastLoginInfo;
	}

	/**
	 * Method helps to selectWhatsNewSinceDropDown
	 * 
	 * @author amit.deshmukh
	 * @param String
	 *            name:element
	 * @return NextCourseHomePage
	 * @throws Exception
	 */

	public NextCourseHomePage selectWhatsNewSinceDropDown(String element)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECT WHAT NEW SINCE DROP DOWN");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(drpWhatsNewsSinceDropdown, waitTime);
			drpWhatsNewsSinceDropdown.selectByVisibleText(element);
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO SELECT WHAT NEW SINCE DROP DOWN \n METHOD :selectWhatsNewSinceDropDown"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to clickExpandAll
	 * 
	 * @author amit.deshmukh
	 * @return NextCourseHomePage
	 * @throws Exception
	 */
	public NextCourseHomePage clickExpandAll() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CLICK EXPAND ALL");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkClickExpandAll, waitTime);
			lnkClickExpandAll.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK EXPAND ALL \n METHOD :clickExpandAll"
							+ e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * Method helps to ClickCollapseAll
	 * 
	 * @author amit.deshmukh
	 * @return NextCourseHomePage
	 * @throws Exception
	 */

	public NextCourseHomePage ClickCollapseAll() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK COLLAPSE ALL");
			uiDriver.waitToBeDisplayed(lnkClickCollapseAll, waitTime);
			frameSwitch.switchToFrameContent();
			lnkClickCollapseAll.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK COLLAPSE ALL \n METHOD :ClickCollapseAll"
							+ e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * Method helps to getLabelSortBy
	 * 
	 * @author amit.deshmukh
	 * @return String name: getlabelbysort
	 * @throws Exception
	 */

	public String getLabelSortBy() throws Exception {
		String getlabelBySort = null;
		try {

			uiDriver.waitToBeDisplayed(lblSortBy, waitTime);
			logInstruction("LOG INSTRUCTION: GET LABEL SORT BY");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblSortBy, waitTime);
			getlabelBySort = lblSortBy.getText();

		} catch (Exception e) {
			throw new Exception("GET LABEL SORT BY \n METHOD :getLabelSortBy"
					+ e.getLocalizedMessage());
		}

		return getlabelBySort;

	}

	/**
	 * This method clicks Sort By Student Link
	 * 
	 * @author Raghavendra Andewadikar
	 * @return NextCourseHomePage
	 * @throws Exception
	 */
	public NextCourseHomePage clickSortByStudentLink() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING STUDENT LINK");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkWhatNewStudentLink, waitTime);
			lnkWhatNewStudentLink.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK SORT BY STUDENT LINK \n METHOD :clickSortByStudentLink "
							+ e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * This method clicks Go Link
	 * 
	 * @author Raghavendra Andewadikar
	 * @param String
	 *            name: itemName
	 * @return NextCourseHomePage
	 * @throws Exception
	 */
	public NextCourseHomePage clickGoLink(String itemName) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING GO LINK");
			frameSwitch.switchToFrameContent();
			lnkGoLink.replaceValues(itemName);
			lnkGoLink.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK GO LINK \n METHOD :clickGoLink"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method clicks Sort By Item Link
	 * 
	 * @author Raghavendra Andewadikar
	 * @return NextCourseHomePage
	 * @throws Exception
	 */
	public NextCourseHomePage clickSortByItemLink() throws Exception {
		try {
			clickSortByStudentLink();
			logInstruction("LOG INSTRUCTION: CLICKING SORT BY ITEM LINK");
			frameSwitch.switchToFrameContent();
			if (drpSortByItemLink.isDisplayed()) {
				uiDriver.waitToBeDisplayed(drpSortByItemLink, waitTime);
				drpSortByItemLink.clickNoWait();
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK SORT BY ITEM LINK \n METHOD:clickSortByItemLink"
							+ e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * This method returns Select Sort By label
	 * 
	 * @author Raghavendra Andewadikar
	 * @return String name: label Select sort by
	 * @throws Exception
	 */
	public String getSelectedSortBy() throws Exception {

		try {
			clickSortByStudentLink();
			logInstruction("LOG INSTRUCTION: VERIFYING LABEL SELECT SORT BY");
			frameSwitch.switchToFrameContent();
			if (lblSelectSortBy.isDisplayed()) {
				uiDriver.waitToBeDisplayed(lblSelectSortBy, waitTime);
				selectSortBy = lblSelectSortBy.getText();
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET LABEL SORT BY ITEM \n METHOD :getSelectedSortBy"
							+ e.getLocalizedMessage());
		}

		return selectSortBy;
	}

	/**
	 * This method clicks Whats New Item
	 * 
	 * @author Raghavendra Andewadikar
	 * @param String
	 *            name: itemName
	 * @return NextCourseHomePage
	 * @throws Exception
	 */
	public NextCourseHomePage clickWhatsNewItem(String itemName)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING WHATSNEW ITEM");
			frameSwitch.switchToFrameContent();
			if (lblWhatsNewItem.isDisplayed()) {
				lblWhatsNewItem.replaceValues(itemName);
				lblWhatsNewItem.clickNoWait();
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK WHATS NEW ITEM \n METHOD :clickWhatsNewItem "
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method clicks Whats New Item
	 * 
	 * @author Raghavendra Andewadikar
	 * @param String
	 *            name: itemName
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isWhatsNewItemExist(String itemName) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER NEW ITEM EXIST");
			frameSwitch.switchToFrameContent();
			lblWhatsNewItem.replaceValues(itemName);
			if (lblWhatsNewItem.isEnabled()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET WHATS NEW ITEM \n METHOD :isWhatsNewItemExist"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method returns Select WhatsNew Since label
	 * 
	 * @author Raghavendra Andewadikar
	 * @return String name: selectSortBy Label
	 * @throws Exception
	 */
	public String getSelectedWhatsNewSinceDropdown() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING SELECT SORT BY LABEL");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblSelectSortBy);
			selectedWhatsNewSinceDwn = lblSelectSortBy.getText();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET LABEL SEE WHAT'S NEW SINCE:\n METHOD :getSelectedWhatsNewSinceDropdown  "
							+ e.getLocalizedMessage());
		}
		return selectedWhatsNewSinceDwn;
	}

	/**
	 * Method helps to sortItem in whats new
	 * 
	 * @author kiran kumar s
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isWhatsNewItemSortedByItem() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING IS WHATS NEWITEM SORTED BYITEM ");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtSortedByItemTxt, waitTime);
			if (txtSortedByItemTxt.getText().equalsIgnoreCase("Item")) {
				logInstruction("LOG INSTRUCTION: WHATS NEWITEM IS SORTED BYITEM");
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE IT FIND THE SORT OPTION \n METHOD :isWhatsNewItemSortedByItem"
							+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to sort item by student in whats new
	 * 
	 * @author kiran kumar s
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isWhatsNewItemSortedByStudent() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING IS WHATS NEWITEM SORTED STUDENT ");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkSortedByStudent, waitTime);
			if (lnkSortedByStudent.getText().equalsIgnoreCase("Student")) {
				logInstruction("LOG INSTRUCTION: WHATS NEWITEM IS SORTED STUDENT");
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE IT FIND THE SORT OPTION \n METHOD :isWhatsNewItemSortedByStudent"
							+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to click on expand button
	 * 
	 * @author kiran kumar s
	 * @param String
	 *            name: whatsnewItem
	 * @return NextCourseHomePage
	 * @throws Exception
	 * 
	 */
	public NextCourseHomePage clickExpandWhatsNewItem(String whatsNewItem)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE EXPAND ");
			frameSwitch.switchToFrameContent();
			btnClickOnExpand.replaceValues(whatsNewItem.trim());
			uiDriver.sleep(waitTime, "wait to cleck button on expand");
			btnClickOnExpand.clickNoWait();

		} catch (Exception e) {
			logInstruction("LOG INSTRUCTION: Already Expanded");
			throw new Exception(
					"UNABLE TO CLICK IN THE EXPND BUTTON \n METHOD :clickExpandWhatsNewItem"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to click on collapse button
	 * 
	 * @author kiran kumar s
	 * @param String
	 *            name: whatsnewItem
	 * @return NextCourseHomePage
	 * @throws Exception
	 * 
	 */
	public NextCourseHomePage clickCollapseWhatsNewItem(String whatsNewItem)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE COLLAPSE ");
			btnClickOnCollapse.replaceValues(whatsNewItem.trim());
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnClickOnCollapse, waitTime);
			btnClickOnCollapse.clickNoWait();
		} catch (Exception e) {
			logInstruction("LOG INSTRUCTION: Already Collapsed");
			throw new Exception(
					"UNABLE TO CLICK IN THE COLLAPSE BUTTON \n METHOD :clickCollapseWhatsNewItem "
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method is used to check if the video text box is displayed
	 * 
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isVideoTxtBoxDisplayed() throws Exception {
		flag = false;
		try {

			logInstruction("LOG INSTRUCTION: CHECK WHETHER VIDEO TEXT BOX IS DISPLAYED");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtVideo, waitTime);
			if (txtVideo.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO LOCATE VIDEO TEXT BOX \n METHOD :isVideoTxtBoxDisplayed "
							+ e.getLocalizedMessage());
		}

		return flag;
	}

	/**
	 * This method is used to check if the audio link text box is displayed
	 * 
	 * @author monica.anand
	 * @return Boolean
	 * @throws Exception
	 */
	public boolean isaudioLnkTxtBoxPresent() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: Check whether audio link  text box is displayed");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtAudioLink, waitTime);
			if (txtAudioLink.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("Unable to locate audio link text box "
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to get the text of the video link label
	 * 
	 * @author Pratush.Manglik
	 * @return String name: label
	 * @throws Exception
	 */
	public String getVideoLinkLabelText() throws Exception {

		try {
			// logInstruction("LOG INSTRUCTION:  GET VIDEO LINK LABEL TEXT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblVideoLink, waitTime);
			videoLinklabel = lblVideoLink.getText();
		} catch (Exception e) {
			throw new Exception(
					" CANNOT FIND VIDEO LINK LABEL TEXT \n METHOD :getVideoLinkLabelText"
							+ e.getLocalizedMessage());
		}
		return videoLinklabel;
	}

	/**
	 * This method is used to verify that Audio text box is displayed
	 * 
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAudioTextBoxDisplayed() throws Exception {
		logInstruction("LOG INSTRUCTION:  VERIFY : IS AUDIO LINK TEXT BOX DISPLAYED ");
		boolean flag = false;
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtBoxAudio, waitTime);
			if (txtBoxAudio.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					" CANNOT FIND AUDIO TEXT BOX \n METHOD :isAudioTextBoxDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to get label of Audio text
	 * 
	 * @author Usha
	 * @return String name: label
	 * @throws Exception
	 */
	public String getAudioLabeltext() throws Exception {
		String label = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING LABEL OF AUDIO TEXT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblAudioText, waitTime);
			label = lblAudioText.getText();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET LABEL OF AUDIO TEXT \n METHOD :getAudioLabeltext"
							+ e.getLocalizedMessage());
		}
		return label;
	}

	/**
	 * This function will check whether link text is stripping or not .
	 * 
	 * @param String
	 *            name of the link text.
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isLinkStripping(String linkName) throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING IS LINK IS STRIPPING OR NOT?");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkRADEditorDisplayed, waitTime);
			String name = lnkRADEditorDisplayed.getTagName();
			if (name.equals("a")
					&& lnkRADEditorDisplayed.getText().equals(linkName))
				flag = true;
			else
				flag = false;
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE LINK TEXT \n METHOD : isLinkStripping"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This function will check whether Course link text is visible or not.
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isCourseCheckListLinkDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFIYING IS COURSE CHECKLIST LINKED DISPLAYED OR NOT ?");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkCourseWork, waitTime);
			if (lnkCourseWork.isDisplayedAfterWaiting(waitTime))
				flag = true;
			else
				flag = false;
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE COURSE LINK \n METHOD :isCourseCheckListLinkDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/***
	 * Method for isCourseCheckListHeaderDisplayed
	 * 
	 * @author suchi.singh
	 * @return Boolean
	 * @throws Exception
	 */
	public boolean isCourseCheckListHeaderDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: COURSE CHECKLIST HEADER IS BEING DISPLAYED");
			// switchToFrame.switchToFrameContent();
			uiDriver.switchTo().frame("Main");
			uiDriver.switchTo().frame("Content");
			uiDriver.waitToBeDisplayed(lblCourseCheckListHeaderDisplayed, 2000);
			if (lblCourseCheckListHeaderDisplayed.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO DISPLAY THE COURSE CHECKLIST HEADER \n METHOD :isCourseCheckListHeaderDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method returns the authorName
	 * 
	 * @param String
	 *            name: Whatsnewtitle
	 * @return List<String> name: authordetails
	 * @author:Raghav S
	 * @throws Exception
	 */
	public List<String> getWhatsNewItemAuthor(String whatsnewtitle)
			throws Exception {
		List<String> authordetails = null;
		try {
			authordetails = new ArrayList<String>();
			logInstruction("LOG INSTRUCTION: GETTING NEW ITEM DETAILS");
			frameSwitch.switchToFrameContent();
			txtAuthorTab.replaceValues(whatsnewtitle);
			List<UIElement> tabledata = txtAuthorTab.getUIElementsList();// count.findElements(By.tagName("td"));
			String allValues[] = null;
			String xyz[] = null;
			for (int i = 0; i < tabledata.size(); i++) {
				authordetails.add(tabledata.get(i).getText().trim());
				xyz = stringUtils.replace(tabledata.get(i).getText().trim(),
						",");
				for (int j = 0; j < xyz.length; j++) {
					allValues = stringUtils.replace(xyz[j], " ");
					authordetails.addAll(Arrays.asList(allValues));
				}
			}
			logInstruction("LOG INSTRUCTION: WHATSNEWSINCE DROP DOWN VALUES ARE CAPTURED \n METHOD : getWhatsNewItemAuthor");

		} catch (Exception e) {
			throw new Exception("unable to fetch the deatils of whats new"
					+ e.getLocalizedMessage());
		}
		return authordetails;
	}

	/**
	 * Method helps to get check isExpandallLInkPresent
	 * 
	 * @author kiran kumar s
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean isExpandallLinkPresent() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING THE EXPAND ALL LINK PRESENT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkClickExpandAll, waitTime);
			flag = lnkClickExpandAll.isEnabled();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO FIND EXPAND ALL \n METHOD :isExpandallLinkPresent"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to get tooltip for collapse
	 * 
	 * @author kiran kumar s
	 * @param String
	 *            name: whatsnewItem
	 * @return String name: tooltip
	 * @throws Exception
	 * 
	 */

	public String getTooltipforCollapse(String whatsNewItem) throws Exception {
		String tooltip = null;
		try {
			logInstruction("LOG INSTRUCTION: GET COLLAPSE TOOL TIP ");
			btnClickOnCollapse.replaceValues(whatsNewItem.trim());
			frameSwitch.switchToFrameContent();

			uiDriver.waitToBeDisplayed(btnClickOnCollapse, waitTime);
			tooltip = btnClickOnCollapse.getAttribute("title");

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE TOOLTIP \n METHOD :getTooltipforCollapse"
							+ e.getLocalizedMessage());
		}
		return tooltip;
	}

	/**
	 * Method helps to get the CourseHome Title
	 * 
	 * @author ganapati.bhat
	 * @return String name: title
	 * @throws Exception
	 */
	public String getCourseHomeTitle() throws Exception {
		String title = null;

		try {
			frameSwitch.switchToFrameContent();
			logInstruction("LOG INSTRUCTION: VERIFY COURSEHOME TITLE");
			if (lblCourseTitle.isDisplayed()) {
				title = lblCourseTitle.getText();
			}
		} catch (Exception e) {

			throw new Exception(
					"UNABLE TO CHECK FOR THE COURSEHOME \n METHOD :getCourseHomeTitle"
							+ e.getLocalizedMessage());
		}
		return title;
	}

	/**
	 * Method helps to verify the Announcements Header Title
	 * 
	 * @author ganapati.bhat
	 * @return String name: title
	 * @throws Exception
	 */
	public String getAnnouncementHeaderTitle() throws Exception {
		String title = null;

		try {
			logInstruction("LOG INSTRUCTION: VERIFY ANNOUNCEMENT TITLE");
			frameSwitch.switchToFrameContent();
			title = lblAnnouncementHeaderTitle.getText();

		} catch (Exception e) {

			throw new Exception(
					"UNABLE TO CHECK FOR THE ANNOUNCEMENTS TITLE \n METHOD :getAnnouncementHeaderTitle"
							+ e.getLocalizedMessage());
		}
		return title;
	}

	/**
	 * Method helps to check for the Course Checklist frame title
	 * 
	 * @author ganapati.bhat
	 * @return boolean
	 * @throws Exception
	 */
	public String[] getTitlesOfSections() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: VERIFY THE COURSE CHECKLIST FRAME TITLE");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = lblCourseChecklist.getUIElementsList();
			int totalHeader = elements.size();
			for (int i = 0; i < totalHeader; i++) {
				// if (elements.get(i).getText().trim().equals(courseCheckList))
				// {
				// logInstruction("LOG INSTRUCTION: THE COURSE CHECK LIST FRAME EXISTS IN THE COURSE HOME PAGE \n METHOD :isCourseCheckListTitle");
				// flag = true;
				// break;
				// }
				sectionTitleNames[i] = elements.get(i).getText().trim();
			}
			logInstruction("LOG INSTRUCTION: FETCHED TITLES OF ALL SECTIONS IN COURSE HOME PAGE");
		} catch (Exception e) {
			throw new Exception("unable to Verify the Course Checklist title "
					+ e.getLocalizedMessage());
		}
		return sectionTitleNames;
	}

	/**
	 * Method helps to check for the course Checklist icon
	 * 
	 * @author ganapati.bhat
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isCourseCheckListIconDisplayed() throws Exception {
		boolean flag = false;
		try {
			frameSwitch.switchToFrameContent();
			logInstruction("LOG INSTRUCTION: CHECK FOR THE COURSE CHECK LIST IMAGE");
			boolean isCourseCheckListIconDisplayed = imgCourseChecklistIcon
					.isDisplayed();
			if (isCourseCheckListIconDisplayed) {
				logInstruction("LOG INSTRUCTION: THE COURSECHECKLIST ICON IS DISPLAYED");
				flag = true;
			} else {
				logInstruction("LOG INSTRUCTION: THE COURSECHECKLIST ICON IS  NOT DISPLAYED");

			}

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK THE COURSE CHECKLIST IMAGE \n METHOD :isCourseCheckListIconDisplayed");
		}

		return flag;

	}

	/**
	 * Method helps to click on the Course check list link
	 * 
	 * @author Praveen.Maled
	 * @return CourseCheckListPage
	 * @throws Exception
	 */
	public Object clickOnCourseCheckListLink() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE COURSE CHECKLIST LINK");
			if (getNavigationPane().isAuthorTabDisplayed()) {
				flag = true;
			}
			frameSwitch.switchToFrameContent();
			lnkCourseChecklist.click();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON THE COURSECHECK LIST LINK \n METHOD : clickOnCourseCheckListLink ");
		}
		if (flag) {
			return new CourseCheckListPage(uiDriver);
		} else {
			return new StudentCourseCheckListPage(uiDriver);
		}
	}

	/**
	 * Method helps to check the course checklist message
	 * 
	 * @author ganapati.bhat
	 * @return String name: Checklistmessage
	 * @throws Exception
	 */
	public String getCourseChecklistMessage() throws Exception {

		String checkListMessage = null;
		try {
			logInstruction("LOG INSTRUCTION: CHECK FOR THE MESSAGE DISPLAYED IN THE COURSE CHECKLIST ");
			frameSwitch.switchToFrameContent();
			checkListMessage = msgCourseChecklist.getText();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON THE COURSECHECK LIST LINK  \n METHOD :getCourseChecklistMessage"
							+ e.getLocalizedMessage());
		}
		return checkListMessage;
	}

	/**
	 * Method Helps to verify the time Displayed at the bottom of the page
	 * 
	 * @author ganapati.bhat
	 * @return String name: timeDisplay
	 * @throws Exception
	 */
	public String getTimeZoneDisplayedAtTheBottom() throws Exception {

		String timeDisplay = null;
		try {
			logInstruction("LOG INSTRUCTION: GET THE TIMEZONEMESSAGE ");
			frameSwitch.switchToFrameContent();
			timeDisplay = msgGrayTimeDisplay.getText();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON THE COURSECHECK LIST LINK \n METHOD :getTimeZoneDisplayedAtTheBottom"
							+ e.getLocalizedMessage());
		}
		return timeDisplay;
	}

	/**
	 * Method helps to Check the position of the AnnouncementsHeader
	 * 
	 * @author ganapati.bhat
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAnnouncementsDisplayedInTopPosition() throws Exception {
		boolean flag = false;

		try {
			logInstruction("LOG INSTRUCTION: VERIFY THE POSITION OF THE ANNOUNCEMENTS");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = lblCourseChecklist.getUIElementsList();
			int totalHeader = elements.size();
			for (int i = 0; i < totalHeader; i++) {
				if (elements.get(i).getText().trim().equals("Announcements")) {
					if (i == 0) {
						logInstruction("LOG INSTRUCTION: THE ANNOUNCEMENTS IS IN THE FIRST POSITION \n METHOD :isAnnouncementsDisplayedInTopPosition");
						flag = true;
					}

					break;
				}
			}

		} catch (Exception e) {
			throw new Exception(
					"unable to check the position of the Announcements "
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to Check the position of the What's New
	 * 
	 * @author ganapati.bhat
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isWhatsNewHeaderDisplayedInSecondPosition() throws Exception {
		boolean flag = false;

		try {
			logInstruction("LOG INSTRUCTION: VERIFY THE POSITION OF THE WHAT'S NEW");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = lblCourseChecklist.getUIElementsList();
			int totalHeader = elements.size();
			for (int i = 0; i < totalHeader; i++) {
				if (elements.get(i).getText().trim().contains("What's New")) {
					if (i == 1) {
						logInstruction("LOG INSTRUCTION: THE WHAT'S NEW IS IN THE SECOND POSITION ");
						flag = true;
					}

					break;
				}
			}

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK THE POSITION OF THE WHAT'S NEW \n METHOD :isWhatsNewHeaderDisplayedInSecondPosition"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to Check the position of the What's New
	 * 
	 * @author ganapati.bhat
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isCourseChecklistHeaderDisplyedInThirdPosition()
			throws Exception {
		boolean flag = false;

		try {
			logInstruction("LOG INSTRUCTION: VERIFY THE POSITION OF THE COURSE CHECKLIST");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = lblCourseChecklist.getUIElementsList();
			int totalHeader = elements.size();
			for (int i = 0; i < totalHeader; i++) {
				if (elements.get(i).getText().trim()
						.contains("Course Checklist")) {
					if (i == 2) {
						logInstruction("LOG INSTRUCTION: THE COURSE CHECKLIST IS IN THE LAST POSITION");
						flag = true;
					}
					break;
				}
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK THE POSITION OF THE COURSE CHECKLIST \n METHOD :isCourseChecklistHeaderDisplyedInThirdPosition"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to click on whats new item for student
	 * 
	 * @author kiran kumar s
	 * @param String
	 *            name: itemname
	 * @return NextCourseHomePage
	 * @throws Exception
	 * 
	 */
	public NextCourseHomePage clickWhatsnewItemStudent(String itemname)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON WHATS NEW ITEM");

			Thread.sleep(5000);
			frameSwitch.switchToFrameContent();
			lnkStudWhatsNewItem.replaceValues(itemname);
			uiDriver.waitToBePresent(lnkStudWhatsNewItem, waitTime);
			lnkStudWhatsNewItem.click();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON \n METHOD :clickWhatsnewItemStudent"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Before using the below Method execute selectWhatsNewSinceDropDown Method
	 * Method helps to getDefaultInfo for Student
	 * 
	 * @author amit.deshmukh
	 * @return String name: defaultinfo
	 * @throws Exception
	 */

	public String getDefaultInfoforStudent() throws Exception {

		String defaultinfo = null;
		try {
			logInstruction("LOG INSTRUCTION: GET DEFAULT INFO");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(tblDefaultInfoStudent, waitTime);
			defaultinfo = tblDefaultInfoStudent.getText().trim();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET DEFAULT INFO \n METHOD :getDefaultInfoforStudent"
							+ e.getLocalizedMessage());
		}

		return defaultinfo;
	}

	/**
	 * Method helps to return the Announcement Header display
	 * 
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAnnouncementTableHeaderDisplayed(String tableHeaderName)
			throws Exception {
		boolean flag = false;
		try {
			lblAnouncementTableHeader.replaceValues(tableHeaderName);
			logInstruction("LOG INSTRUCTION: GET ANNOUNCEMENT TABLE HEADER");
			frameSwitch.switchToFrameContent();
			if (lblAnouncementTableHeader.isDisplayed()) {
				flag = true;
			}

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE ANNOUNCEMENT TABLE HEADER \n METHOD :isAnnouncementTableHeaderDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is for verifying Expand All link.
	 * 
	 * @author saurabh.jain1
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isExpandAllLinkDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING THE EXPAND ALL LINK");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkExpandAll, waitTime);
			if (lnkExpandAll.isDisplayed()) {
				flag = true;
			}

		} catch (Exception e) {

			throw new Exception(
					"UNABLE TO VERIFY THE EXPAND ALL LINK \n METHOD :isExpandAllLinkDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to check for collapse icon
	 * 
	 * @author ganapati.bhat
	 * @return boolean
	 * @param string
	 */
	public boolean isTooltipDisplayedForCollapseIcon(String Announcement)
			throws Exception {
		boolean flag = false;
		try {
			imgCollapseIcon.replaceValues(Announcement);
			frameSwitch.switchToFrameContent();

			if (imgCollapseIcon.isDisplayed()) {
				flag = true;
			}

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE TOOLTIP MESSAGE. \n METHOD :isTooltipDisplayedForCollapseIcon"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to click for collapse icon
	 * 
	 * @author ganapati.bhat
	 * @return boolean
	 * @param string
	 */
	public boolean clickForCollapseIcon(String Announcement) throws Exception {
		boolean flag = false;
		try {
			imgCollapseIcon.replaceValues(Announcement);
			frameSwitch.switchToFrameContent();
			imgCollapseIcon.click();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE TOOLTIP MESSAGE.\n METHOD :clickForCollapseIcon "
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method to get read announcement(Regular Text)
	 * 
	 * @author Ganapati bhat
	 * @return boolean
	 * @throws Exception
	 */
	public String getAnnouncementReadTooltip(String announcementName)
			throws Exception {

		String toolTip = "";
		try {
			logInstruction("LOG INSTRUCTION: VERIFY READ ANNOUNCEMENT(REGULAR TEXT)");
			frameSwitch.switchToFrameContent();
			imgAnnouncementRead.replaceValues(announcementName);
			if (imgAnnouncementRead.isDisplayed()) {
				toolTip = imgAnnouncementRead.getAttribute("alt");
			}
		} catch (Exception e) {

			throw new Exception(
					"UNABLE TO GET READ ANNOUNCEMENT(REGULAR TEXT) \n METHOD :getAnnouncementReadTooltip"
							+ e.getLocalizedMessage());
		}
		return toolTip;

	}

	/**
	 * Method to get read announcement(Regular Text)
	 * 
	 * @author Ganapati bhat
	 * @return boolean
	 * @throws Exception
	 */
	public String getAnnouncementUnReadTooltip(String announcementName)
			throws Exception {

		String toolTip = "";
		try {
			logInstruction("LOG INSTRUCTION: VERIFY READ ANNOUNCEMENT(REGULAR TEXT)");
			frameSwitch.switchToFrameContent();
			imgAnnouncementUnRead.replaceValues(announcementName);
			if (imgAnnouncementUnRead.isDisplayed()) {
				toolTip = imgAnnouncementUnRead.getAttribute("alt");
			}
		} catch (Exception e) {

			throw new Exception(
					"UNABLE TO GET UNREAD ANNOUNCEMENT(REGULAR TEXT) \n METHOD :getAnnouncementUnReadTooltip"
							+ e.getLocalizedMessage());
		}
		return toolTip;

	}

	/**
	 * Method to click read announcement(Regular Text)
	 * 
	 * @author Ganapati bhat
	 * @return boolean
	 * @throws Exception
	 */
	public NextCourseHomePage clickAnnouncementReadIcon(String announcementName)
			throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: VERIFY READ ANNOUNCEMENT(REGULAR TEXT)");
			frameSwitch.switchToFrameContent();
			imgAnnouncementRead.replaceValues(announcementName);
			if (imgAnnouncementRead.isDisplayed()) {
				imgAnnouncementRead.click();
			}
		} catch (Exception e) {

			throw new Exception(
					"UNABLE TO CLICK READ ANNOUNCEMENT(REGULAR TEXT) \n METHOD :clickAnnouncementReadIcon"
							+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * Method to click read announcement(Regular Text)
	 * 
	 * @author Ganapati bhat
	 * @return boolean
	 * @throws Exception
	 */
	public NextCourseHomePage clickAnnouncementUnReadIcon(
			String announcementName) throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: VERIFY READ ANNOUNCEMENT(REGULAR TEXT)");
			frameSwitch.switchToFrameContent();
			imgAnnouncementUnRead.replaceValues(announcementName);
			if (imgAnnouncementUnRead.isDisplayed()) {
				imgAnnouncementUnRead.click();
			}
		} catch (Exception e) {

			throw new Exception(
					"UNABLE TO CLICK UNREAD ANNOUNCEMENT(REGULAR TEXT) \n METHOD :clickAnnouncementUnReadIcon"
							+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * Method helps to check for collapse icon
	 * 
	 * @author ganapati.bhat
	 * @return boolean
	 * @param string
	 */
	public boolean isTooltipDisplayedForExpandIcon(String Announcement)
			throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION:VERIFYING TOOL TIP IS DISPLAYED OR NOT ");
			lnkExpandIcon.replaceValues(Announcement);
			frameSwitch.switchToFrameContent();

			if (lnkExpandIcon.isDisplayed()) {
				flag = true;
			}

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE TOOLTIP MESSAGE. \n METHOD :isTooltipDisplayedForExpandIcon"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify whats new item for student
	 * 
	 * @author kiran kumar s
	 * @return:CourseHomeWhatsNewpage
	 * @throws Exception
	 * 
	 */
	public boolean isWhatsnewItempresentForStudent(String itemname)
			throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON WHATS NEW ITEM");
			lnkStudWhatsNewItem.replaceValues(itemname);
			frameSwitch.switchToFrameContent();

			uiDriver.waitToBePresent(lnkStudWhatsNewItem, waitTime);
			lnkStudWhatsNewItem.isEnabled();
			flag = true;
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON \n METHOD :isWhatsnewItempresentForStudent"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to get the details of students whats new
	 * 
	 * @author kiran kumar s
	 * @return:CourseHomeWhatsNewpage
	 * @throws Exception
	 */
	public String getDetailsOfStudentWhatsNew(String studName) throws Exception {

		String authordetails = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING STUDENT DETAILS");
			tblGetWhatsNewDetailsForStudent.replaceValues(studName);
			frameSwitch.switchToFrameContent();
			authordetails = tblGetWhatsNewDetailsForStudent.getText();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET DETAILS \n METHOD :getDetailsOfStudentWhatsNew"
							+ e.getLocalizedMessage());
		}
		return authordetails;
	}

	/**
	 * This method click on collapse in whats new section
	 * 
	 * @author kiran.kumar
	 * @return
	 * @throws Exception
	 */

	public NextCourseHomePage clickonCollapseWhatsnewItem(String WhatsNewITem)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKONG ON COLLAPSE BTN");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnClickOnCollapse, waitTime);
			btnClickOnCollapse.click();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK\n METHOD :clickonCollapseWhatsnewItem"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method to check if link to file displayed or not
	 * 
	 * @param String
	 *            - filename
	 * @author Chaitali
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isLinkAddedDisplayed(String fileName) throws Exception {
		try {
			boolean flag = false;
			logInstruction("LOG INSTRUCTION: CHECKING FOR NEWLY ADDED LINK.");
			frameSwitch.switchToFrameContent();
			lnkToFilesAdded.replaceValues(fileName);
			flag = lnkToFilesAdded.isDisplayedAfterWaiting(waitTime);
			if (flag == false) {
				return false;
			}
			if (lnkToFilesAdded.isDisplayed())
				return true;
		} catch (Exception e) {
			logInstruction(e.getMessage());
			throw new Exception(
					"FILE NOT FOUND \n METHOD :isLinkAddedDisplayed");
		}
		return false;
	}

	/**
	 * Methods helps to verify courseIntroduction is displayed or not
	 * 
	 * @author amit.deshmukh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isCourseIntroductionTextisDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING THE COURSE INTRODUCTION TEXT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBePresent(txtCourseIntrotext, waitTime);
			txtCourseIntrotext.isPresent();
			flag = true;
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO FIND COURSE INTRODUCTION TEXT \n METHOD :isCourseIntroductionTextisDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to check if the video link text box is displayed
	 * 
	 * @author Raghav
	 * @return Boolean
	 * @throws Exception
	 */
	public boolean isvideoLnkTxtBoxPresent() throws Exception {
		boolean flag = false;
		try {

			logInstruction("LOG INSTRUCTION: CHECK WHETHER VIDEO LINK  TEXT BOX   IS DISPLAYED");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblVideoLink, waitTime);
			if (lblVideoLink.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO LOCATE AUDIO LINK TEXT BOX  \n METHOD :isvideoLnkTxtBoxPresent"
							+ e.getLocalizedMessage());
		}

		return flag;
	}

	/***
	 * Method verifies whether savechanges button is present
	 * 
	 * @author Raghav S
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isSaveChangesbtnPresent() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: SAVE CHANGES BUTTON IS CLICKED");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnClickSaveChanges, waitTime);
			if (btnClickSaveChanges.isDisplayed()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK SAVE CHANGES BUTTON \n METHOD :isSaveChangesbtnPresent"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method to get link text.
	 * 
	 * @param String
	 *            - filename
	 * @author Vivek.Singh
	 * @return boolean
	 * @throws Exception
	 */
	public String getLinkContent(String linkName) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR NEWLY ADDED LINK.");
			frameSwitch.switchToFrameContent();
			lnkToFilesAdded.replaceValues(linkName);
			lnkToFilesAdded.isDisplayedAfterWaiting(waitTime);
			return lnkToFilesAdded.getText();
		} catch (Exception e) {
			throw new Exception("LINK NOT AVAILABLE. \n METHOD :getLinkContent"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method will click the invalid link created.
	 * 
	 * @author Vivek.Singh
	 * @param {@link String}
	 * @return {@link NextCourseHomePage}
	 * @throws Exception
	 * **/
	public NextCourseHomePage clickInvalidLink(String linkName)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON LINK.");
			frameSwitch.switchToFrameContent();
			lnkToFilesAdded.replaceValues(linkName);
			lnkToFilesAdded.isDisplayedAfterWaiting(waitTime);
			lnkToFilesAdded.click();
		} catch (Exception e) {
			throw new Exception(
					"LINK NOT AVAILABLE.\n METHOD :clickInvalidLink "
							+ e.getLocalizedMessage());
		}
		return new NextCourseHomePage(uiDriver);
	}

	/**
	 * This method will get the invalid links error message.
	 * 
	 * @author Vivek.Singh
	 * @param {@link String}
	 * @return {@link NextCourseHomePage}
	 * @throws Exception
	 * **/
	public String getInvalidErrorMessage() throws Exception {
		String arr[], arr2[];
		String inlineErrorMsg = "", textGot = "";
		try {
			logInstruction("LOG INSTRUCTION: GETTING INVALID LINK.");
			if ("INTERNETEXPLORER".equalsIgnoreCase(System
					.getProperty("browser.NAME"))) {
				uiDriver.getUIWindowLocator().switchToNewWindow();
				uiDriver.waitToBeDisplayed(msgErrorMsg, waitTime);
				inlineErrorMsg = msgErrorMsg.getText();
			} else {
				frameSwitch.handleMultipleWindows("File not Found");
				JavascriptExecutor js = (JavascriptExecutor) uiDriver;
				inlineErrorMsg = (String) js
						.executeScript("return document.getElementsByTagName('td')[3].textContent");

			}
			frameSwitch.switchToParentWindow();
			arr = inlineErrorMsg.split("\\.");
			for (String string : arr) {
				textGot += string;
			}
			arr2 = textGot.split("\n\n");
			textGot = "";
			for (String string : arr2) {
				textGot += string;
			}
		} catch (Exception e) {
			throw new Exception(
					"CANNOT LOCATE THE ERROR MESSAGE \n METHOD :getInvalidErrorMessage"
							+ e.getLocalizedMessage());
		}
		return textGot.trim();
	}

	/**
	 * Method helps to display course introduction text in Whats new
	 * 
	 * @author amit.deshmukh
	 * @return String
	 * @throws Exception
	 */
	public String gettextCourseIntroduction() throws Exception {
		String courseintroduction = null;
		try {
			logInstruction("LOG INSTRUCTION: GET COURSEINTRODUCTION TEXT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtCourseIntrotext, waitTime);
			courseintroduction = txtCourseIntrotext.getText();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET COURSEINTRODUCTION TEXT \n METHOD :gettextCourseIntroduction"
							+ e.getLocalizedMessage());
		}

		return courseintroduction;

	}

	/**
	 * Method helps to check course title
	 * 
	 * @author amit.deshmukh
	 * @return String
	 * @throws Exception
	 */
	public boolean iscoursetittledisplayed() throws Exception {

		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING THE COURSE");
			frameSwitch.selectTopFrame();
			uiDriver.waitToBeDisplayed(msgCourseText, waitTime);
			msgCourseText.isEnabled();
			flag = true;
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO FIND COURSE \n METHOD :iscoursetittledisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * This method is used to click link added under announcement
	 * 
	 * @param String
	 *            - annoncementName
	 * @param String
	 *            - linkName
	 * @author Chaitali
	 * @throws Exception
	 */
	public void clickLinkUnderAnnouncement(String annoncementName,
			String linkName) throws Exception {
		logInstruction("LOG INSTRUCTION :CLICKING ON LINK UNDER ANNOUNCEMENT");

		try {
			frameSwitch.switchToFrameContent();
			lnkUnderAnnoncement.replaceValues(annoncementName, linkName);
			if (lnkUnderAnnoncement.isDisplayedAfterWaiting(waitTime))
				lnkUnderAnnoncement.clickAndWait(waitTime);
			else
				logInstruction("LOG INSTRUCTION: Link under annoncement not displayed......");

		} catch (Exception e) {
			throw new Exception(
					"LINK UNDER ANNONCEMENT NOT PRESENT \n METHOD : clickLinkUnderAnnouncement");
		}
	}

	/**
	 * This method will get content from the CourseHome radeditor section.
	 * 
	 * @author Vivek.Singh
	 * @return String
	 * @throws Exception
	 */
	public String getContent() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: GETTING CONTENT FROM RADEDITOR.");
			frameSwitch.switchToFrameContent();
			lblRADEditor.isDisplayedAfterWaiting(waitTime);
			return lblRADEditor.getText();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET TEXT FROM LBL CONTENT FROM COURSE HOME RADEDITOR CONTENT SECTION. \n METHOD :getContent"
							+ "" + e.getLocalizedMessage());
		}
	}

	/**
	 * This method will get content from the CourseHome .
	 * 
	 * @author Suchi.Singh
	 * @return String
	 * @throws Exception
	 */
	public String getTextInCourseView() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: GETTING CONTENT .");
			frameSwitch.switchToFrameContent();
			msgGetContent.isDisplayedAfterWaiting(waitTime);
			// return uiDriver.getInnerHtmlOf(getcontent);
			return msgGetContent.getText().trim();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET TEXT FROM COURSE HOME. \n METHOD :getTextInCourseView"
							+ "" + e.getLocalizedMessage());
		}
	}

	/**
	 * Method Helps to verify the time Displayed at the bottom of the page
	 * 
	 * @author ganapati.bhat
	 * @return String name: timeDisplay
	 * @throws Exception
	 */
	public boolean isTimeZoneDisplayedAtTheBottom() throws Exception {

		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: GET THE TIMEZONEMESSAGE ");
			frameSwitch.switchToFrameContent();
			if (msgGrayTimeDisplay.isDisplayed())
				;
			flag = true;

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET TIMEZONE MESSAGE \n METHOD :isTimeZoneDisplayedAtTheBottom"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method will click on link created in rad-editor
	 * 
	 * @author Praveen.Maled
	 * @param linkName
	 * @throws Exception
	 * @category Milestone 2
	 */
	public void clickRadeditorLink(String linkName) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON LINK.");
			if (StringUtils.isNotBlank(linkName)) {
				frameSwitch.switchToFrameContent();
				lnkToFilesAdded.replaceValues(linkName);
				lnkToFilesAdded.isDisplayedAfterWaiting(waitTime);
				lnkToFilesAdded.clickAndWait(waitTime);

			} else
				throw new Exception("Provided link name is NULL");
		} catch (Exception e) {
			throw new Exception(
					"LINK NOT AVAILABLE .\n METHOD :clickRadeditorLink "
							+ e.getLocalizedMessage());
		}
	}

	/**
	 * This Method will check whether Embedded video is present or not
	 * 
	 * @return {@link Boolean}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isEmbeddedVideoDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR IFRAME ");
			frameSwitch.switchToFrameContent();

			UIElement frame = uiDriver.findUIElement(UIType.TagName, "iframe");
			if (frame.isDisplayedAfterWaiting(waitTime))
				flag = true;

		} catch (Exception e) {
			logInstruction("LOG INSTRUCTION: UNABLE TO GET THE IFRAME \n METHOD :isEmbeddedVideoDisplayed");
		}
		return flag;
	}

	/**
	 * This method gets the content from the plain text
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */

	/**
	 * This method is used to check if a particular header is displayed in
	 * student view
	 * 
	 * @category Milestone 2
	 * @author monica.anand
	 * @param tableheader
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isTableHeaderDisplayed(String tableHeader) throws Exception {
		boolean flag = false;
		try {

			logInstruction("LOG INSTRUCTION : CHECKING IF A  PARTICULAR TABLE HEADER IS DISPLAYED IN STUDENT VIEW ");
			frameSwitch.switchToFrameContent();
			List<UIElement> lstTableHeaders = lblTableHeaders
					.getUIElementsList();
			for (int i = 0; i < lstTableHeaders.size(); i++) {
				if (lstTableHeaders.get(i).getText().contains(tableHeader)) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK IF A PARTICULAR TABLE HEADER IS DISPLAYED \n METHOD :"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to click on link created in course introduction
	 * 
	 * @category Milestone 2
	 * @author monica.anand
	 * @param link
	 *            name
	 * @throws Exception
	 */

	public void clickLinkCreatedInCourseIntroduction(String linkName)
			throws Exception {
		logInstruction("LOG INTRODUCTION :CLICKING ON LINK CREATED IN COURSE INTRODUCTION");

		try {
			frameSwitch.switchToFrameContent();
			lnkCourseIntroductionLink.replaceValues(linkName);
			if (lnkCourseIntroductionLink.isDisplayedAfterWaiting(waitTime))
				lnkCourseIntroductionLink.click();
			/*
			 * List<WebElement> frameset =
			 * uiDriver.findElements(By.tagName("frame")); if(frameset.size()>0)
			 * { for (WebElement framename : frameset) {
			 * System.out.println("frameid: " + framename.getAttribute("name"));
			 * } }
			 */
			uiDriver.switchTo().frame("Top");
			uiDriver.switchTo().defaultContent();

			uiDriver.switchTo().frame("Tree");
			uiDriver.switchTo().defaultContent();
			uiDriver.switchTo().frame("Content");

		} catch (Exception e) {
			throw new Exception(
					" LINK  NOT DISPLAYED......\n METHOD :clickLinkCreatedInCourseIntroduction "
							+ e.getLocalizedMessage());
		}

	}

	/**
	 * This method is used to check if Course Link is displayed in course view
	 * 
	 * @category Milestone 2
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isCourseCheckListDisplayedInCourseView() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: IS COURSE CHECKLIST DISPLAYED IN COURSE VIEW ");

			if (lnkCourseWork.isDisplayedAfterWaiting(waitTime))
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: COURSE CHECKLIST  NOT DISPLAYED...... \n METHOD :isCourseCheckListDisplayedInCourseView"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method gets the content from the plain text
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public String getContentFromPlainText() throws Exception {
		String text = null;
		try {
			logInstruction("GETTING THE CONTENT FROM THE PLAIN TEXT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(simpleEditorText, waitTime);
			text = simpleEditorText.getText();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE TEXT \n METHOD :getContentFromPlainText"
							+ e.getLocalizedMessage());
		}
		return text;

	}

	/**
	 * @category Milestone 2 Method helps to verify unit header title in course
	 *           view.
	 * @return
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isUnitHeaderDisplayInCourseView() throws Exception {

		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: GET THE HEADER TITLE IN COURSE VIEW ");
			frameSwitch.switchToFrameContent();
			if (txtTitle.isDisplayedAfterWaiting(waitTime))
				flag = true;

		} catch (Exception e) {
			throw new Exception("unable to get header title in course view"
					+ "\nMETHOD: isUnitHeaderDisplayInCourseView\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to check if the add entry link is getting displayed
	 * 
	 * @category Milestone 2
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean isAddEntryLinkDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION : CHECKING IF THE ADD ENTRY LINK IS DISPLAYED");
			frameSwitch.switchToFrameContent();
			if (lnkAddEntry.isDisplayedAfterWaiting(waitTime)) {
				flag = true;

			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK IF ADD ENTRY LINK IS DISPLAYED \n METHOD :isAddEntryLinkDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * methods helps to check if Baskets tab has been displayed
	 * 
	 * @category MileStone2
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isBasketsTabDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION:METHOD TO CHECK IF BASKETS TAB HAS BEEN DISPLAYED");
			frameSwitch.switchToFrameContent();
			if (lnkBaskets.isDisplayedAfterWaiting(waitTime)) {
				flag = true;

			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK IF BASKETS TAB IS DISPLAYED \n METHOD :isBasketsTabDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * methods helps to check if Students tab has been displayed
	 * 
	 * @category MileStone2
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isStudentsTabDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION:METHOD TO CHECK IF STUDENTS TAB HAS BEEN DISPLAYED");
			frameSwitch.switchToFrameContent();
			if (lnkStudents.isDisplayedAfterWaiting(waitTime)) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK IF STUDENTS TAB HAS BEEN DISPLAYED \n METHOD :isStudentsTabDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * methods helps to check if Entire Inbox tab has been displayed
	 * 
	 * @category MileStone2
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isEntireInboxTabDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION:METHOD TO CHECK IF ENTIRE INBOX TAB HAS BEEN DISPLAYED");
			frameSwitch.switchToFrameContent();

			if (lnkEntireInbox.isDisplayedAfterWaiting(waitTime)) {
				flag = true;

			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK IF ENTIRE INBOX TAB HAS BEEN DISPLAYED \n METHOD :isEntireInboxTabDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * methods helps to check if Submit Assignment Link Has been displayed
	 * 
	 * @category MileStone2
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isSubmitAssignmentLinkDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION:METHOD TO CHECK IF SUBMIT ASSIGNMENT LINK HAS BEEN DISPLAYED");
			frameSwitch.switchToFrameContent();

			if (lnkSubmitAssignment.isDisplayedAfterWaiting(waitTime)) {
				flag = true;

			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK IF SUBMIT ASSIGNMENT LINK HAS BEEN DISPLAYED  \n METHOD :isSubmitAssignmentLinkDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to check if a particular label is displayed on Email
	 * Page
	 * 
	 * @category Milestone 2
	 * @author monica.anand
	 * @param message
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isLabelDisplayed(String labelName) throws Exception {
		boolean flag = false;
		try {

			logInstruction("LOG INSTRUCTION : CHECKING IF A  PARTICULAR LABEL IS DISPLAYED  ");
			frameSwitch.switchToFrameContent();
			List<UIElement> lstLabel = lblEmail.getUIElementsList();
			for (int i = 0; i < lstLabel.size(); i++) {
				if (lstLabel.get(i).getText().contains(labelName)) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK IF A  PARTICULAR LABEL IS DISPLAYED  \n METHOD :isLabelDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to check if a particular tab is displayed on
	 * Gradebook Page
	 * 
	 * @category Milestone 2
	 * @author monica.anand
	 * @param message
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isTabDisplayedInGradebookPage(String tabName)
			throws Exception {
		boolean flag = false;
		try {

			logInstruction("LOG INSTRUCTION : CHECKING IF A  PARTICULAR TAB IS DISPLAYED  IN GRADEBOOK PAGE");
			frameSwitch.switchToFrameContent();
			lnkGradebook.replaceValues(tabName);
			if (lnkGradebook.isDisplayedAfterWaiting(waitTime)) {
				flag = true;

			}
		} catch (Exception e) {

			throw new Exception(
					"UNABLE TO CHECK IF A PARTICULAR TAB  IS DISPLAYED \n METHOD :isTabDisplayedInGradebookPage"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to get the gradebook table header in student view
	 * 
	 * @category Milestone 2
	 * @author monica.anand
	 * @return String
	 * @throws Exception
	 * 
	 */
	public String getTableHeaderTitle() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION : GET TABLE HEADER TITLE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblStudentTableHeader, waitTime);
			return lblStudentTableHeader.getText();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET TABLE HEADER TITLE \n METHOD :getTableHeaderTitle"
							+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method is used to check if header is displayed in Course View
	 * 
	 * @category Milestone 2
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isHeaderDisplayedInCourseView() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: IS HEADER DISPLAYED IN COURSE VIEW ");

			if (lblHeader.isDisplayedAfterWaiting(waitTime))
				flag = true;
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK IF HEADER IS DISPLAYED IN COURSE VIEW \n METHOD :isHeaderDisplayedInCourseView"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to check if the image is displayed in Course View
	 * Page
	 * 
	 * @category Milestone 2
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean isImageDisplayed(String imageTitle) throws Exception {
		try {

			logInstruction("LOG INSTRUCTION: CHECKING FOR NEWLY ADDED IMAGE.");
			frameSwitch.switchToFrameContent();
			imgUploaded.replaceValues(imageTitle);
			return imgUploaded.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK IF IMAGE IS ADDED  \n METHOD :isImageDisplayed"
							+ e.getLocalizedMessage());
		}
	}

	/**
	 * Method helps Checking course home is focused by default or not.
	 * 
	 * @category Milestone 2
	 * @author Vivek.Singh
	 * @return boolean
	 * @throws Exception
	 * **/
	public boolean isCourseHomeFocused() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: Checking course home is focussed by default or not.");
			frameSwitch.switchToTreePane();
			lblCourseHome.isDisplayedAfterWaiting(waitTime);

			if (COURSE_HOME.equalsIgnoreCase(lblCourseHome.getText())) {
				flag = true;
			}
			return flag;
		} catch (Exception e) {
			throw new Exception("Not able to get course home unit.");
		}
	}

	/**
	 * This method helps to click on the link created on the course home
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public void clickLinkInCourseTab(String NameofTheLink) throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:clicking the link");
			frameSwitch.switchToFrameContent();
			List<UIElement> list = lnkClickSimpleEditor.getUIElementsList();
			for (UIElement ele : list) {
				uiDriver.waitToBeDisplayed(ele, waitTime);
				ele.click();
			}
			uiDriver.getUIWindowLocator().switchToMainWindow();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE LINK"
					+ "\n METHOD:\n:clickLinkInCourseTab"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method chcks whether the link are present
	 * 
	 * @author ashish.juyal
	 */
	public boolean isLinkInCourseTab(String NameofTheLink) throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOGINSTRUCTION:LOCATING THE LINK");
			frameSwitch.switchToFrameContent();
			txtSimpleEditor.replaceValues(NameofTheLink);
			uiDriver.waitToBeDisplayed(txtSimpleEditor, waitTime);

			flag = txtSimpleEditor.isDisplayed();

		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE LINK"
					+ "\n METHOD:clickLinkInCourseTab"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * this method checks is the simpleeditor tag displayed
	 * 
	 * @throws Exception
	 * 
	 */
	public boolean isSimpleEditorDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOGINSTRUCTION:CHECKING FOR THE SIMPLE EDITOR");
			frameSwitch.switchToFrameContent();
			flag = lblSimpleEditor.isDisplayed();
		} catch (Exception e) {
			throw new Exception("ISSUE IN LOCATING THE SIMPLEDITOR"
					+ "\n METHOD:SimpleEditorDisplayed"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method verify whether RealEd user is logged in
	 * 
	 * @author bharat.goel
	 * @throws Exception
	 * @return boolean
	 * @param String
	 *            -title
	 */
	public boolean isRealEdLoggedIn(String strIns) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: REALED USER IS LOGGED IN");
			frameSwitch.selectTopFrame();
			lblInstructor.isDisplayedAfterWaiting(waitTime);
			return strIns.equals(lblInstructor.getText().trim());

		} catch (Exception e) {
			throw new Exception("Realed user is not logged in "
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method gets the content from the plain text
	 * 
	 * @author bharat.goel
	 * @throws Exception
	 * @return boolean
	 * @param String
	 *            -title
	 */
	public boolean isImageDisplayedInCourseHomePage(String title)
			throws Exception {
		try {
			logInstruction("Image Disp in course home page");
			frameSwitch.switchToFrameContent();
			lblImgTitle.replaceValues(title);

		} catch (Exception e) {
			throw new Exception(
					"Image Disp in course home page  not displayed...... "
							+ e.getLocalizedMessage());
		}

		return lblImgTitle.isDisplayedAfterWaiting(waitTime);
	}

	/**
	 * Method helps to getHeadertitle
	 * 
	 * @category milestone2
	 * @author kiran.kumar
	 * @return String name: header title
	 * @throws Exception
	 */

	public String getPageTitle() throws Exception {
		String hdrname = null;
		try {
			logInstruction("LOG INSTRUCTION: GET PAGE TITLE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblPageTitle, waitTime);
			hdrname = lblPageTitle.getText().trim();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET PAGETITLE \n METHOD :getPageTitle"
							+ e.getLocalizedMessage());
		}
		return hdrname;
	}

	/**
	 * This Method will the tag whether the text is not didplayed under the span
	 * tag
	 * 
	 * @param text
	 *            text which you want to get
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isSpanNotDisplayed(String text) throws Exception {
		flag = false;
		try {
			logInstruction("LOGINSTRUCTION:checking the span");
			frameSwitch.switchToFrameContent();
			UIElement content = createElement(UIType.Xpath,
					"//html//body//font");

			String spanText = content.getText();
			if (text.contains(spanText)) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception("UNABLE TO GET THE FONT"
					+ e.getLocalizedMessage());

		}
		return flag;
	}

	/**
	 * This method gets the content from the plain text
	 * 
	 * @author soundarya
	 * @throws Exception
	 */

	public String getContentFromPlainTextInsideTag() throws Exception {
		String text = null;
		try {
			logInstruction("GETTING THE CONTENT FROM THE PLAIN TEXT");
			frameSwitch.switchToFrameContent();
			if (msgSimple.isDisplayedAfterWaiting())
				text = msgSimple.getText().trim();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE TEXT \n METHOD :getContentFromPlainText"
							+ e.getLocalizedMessage());
		}
		return text;

	}

/**
     * Method helps to display course introduction text in Whats new
     * 
     * @author Suchi.Singh
     * @return String
     * @throws Exception
     */
    public String getFontStyleOfTextInCourseIntroduction(String text) throws Exception {
        fontStyle = null;
        try {
            logInstruction("LOG INSTRUCTION: GET COURSEINTRODUCTION TEXT");
            frameSwitch.switchToFrameContent();
            txtFontStyleCourseintrtext.replaceValues(text);
            txtFontStyleCourseintrtext.isDisplayedAfterWaiting(waitTime);
            fontStyle = txtFontStyleCourseintrtext.getAttribute("face").trim();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET COURSEINTRODUCTION TEXT \n METHOD :gettextCourseIntroduction" + e
                            .getLocalizedMessage());
        }
        return fontStyle;
    }
}
