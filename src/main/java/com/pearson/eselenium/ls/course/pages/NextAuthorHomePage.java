package com.pearson.eselenium.ls.course.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.PlainTextEditor;
import com.pearson.eselenium.ls.common.pages.RadEditorSwitchPlainOrVisual;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.eselenium.ls.contentitems.unit.pages.CourseItemsPage;
import com.pearson.eselenium.ls.coursehome.announcements.pages.AddAnnouncementPage;
import com.pearson.eselenium.ls.coursehome.announcements.pages.DeleteAnnouncementPage;
import com.pearson.eselenium.ls.coursehome.announcements.pages.EditAnnouncementPage;
import com.pearson.eselenium.ls.coursehome.filemanager.pages.FileManagerPage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.elements.DefaultUIActions;
import com.pearson.test.eselenium.framework.elements.UIActions;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of Author Home page Follow
 * the below steps to navigate the page: Login as prof Click on the Course
 * Select Author Tab
 * 
 * @author sumanth.sv
 */
public class NextAuthorHomePage extends BasePageObject {

	/* Elements */
	private UIElement areaIsRADDisplayed = createElement(UIType.Xpath,
			"//html//body");
	private UIElement lnktabCourseItem = createElement(UIType.LinkText,
			"Course Items");
	private UIElement lnktabCourseFileManager = createElement(UIType.LinkText,
			"File Manager");
	private UIElement lnktabCourseHome = createElement(UIType.LinkText,
			"Course Home");
	private UIElement btnAddAnnouncementButton = createElement(UIType.Xpath,
			"//table//tr//td//a[@title='Add Announcement']");
	private UIElement btnEditIcon = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]//td[4]//a");
	private UIElement btnDeleteIcon = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]//td[5]//a");
	private UIElement lnkExpandAllIcon = createElement(UIType.Css,
			"a#AnnouncementBox_Announcement1_expandAllLink");
	// private UIElement lnkCollapseAllIcon = createElement(UIType.Css,
	// "a#AnnouncementBox_Announcement1_collapseAllLink");
	private UIElement lnkExpandIcon = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]//a//img[@title='Expand']");
	private UIElement lnkCollpaseIcon = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]//a//img[@alt='Collapse']");
	private UIElements lstAnnouncementsList = createElements(UIType.Xpath,
			"//a");
	private UIElement mnuSelectAnnouncement = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]//a[contains(.,'{2}')]");
	private UIElement txtSelectAnnouncementStartTime = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]//td[2]");
	private UIElement txtSelectAnnouncementEndTime = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]//td[3]");
	private UIElement txtSelectAnnouncementContent = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]/following-sibling::tr[1]/td");
	private UIElement btnClickSaveChanges = createElement(UIType.Xpath,
			"//input[contains(@value,'Save Changes')]");
	private UIElement lblCourseTitle = createElement(UIType.Xpath,
			"//h1[contains(.,'Course Home')]");
	private UIElement lblAnnouncementHeaderTitle = createElement(UIType.Xpath,
			"//h2[@class='headertitle']//div[contains(.,'Announcements')]");
	private UIElements lblAnnouncementPosition = createElements(UIType.Css,
			"div.tablehead");
	private UIElement btnCourseHome = createElement(UIType.Xpath,
			"//a[@class='contentNavigationON']");
	private UIElement lnkCollapseAllIcon = createElement(UIType.ID,
			"AnnouncementBox_Announcement1_collapseAllLink");
	private UIElement lnkExpandAll = createElement(UIType.ID,
			"AnnouncementBox_Announcement1_expandAllLink");
	private UIElement imgCollapseIcon = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr[th//a[contains(.,'{1}')]]//a//img[@alt='Collapse']");
	private UIElement lblAnouncementTableHeader = createElement(UIType.Xpath,
			"//tr[th[@class='tableheading']]//th[contains(.,'{1}')]");
	private UIElement msgGrayTimeDisplay = createElement(UIType.Css,
			".dkgraytext");
	private UIElement lblHeaderTextDisplayed = createElement(UIType.Xpath,
			"//h2[div[contains(text(),'{1}')]]");
	private UIElement txtRADEditorText = createElement(UIType.Xpath,
			"//iframe[@id='RadCourseText_contentIframe']");
	private UIElements lstAnnouncementDisplay = createElements(UIType.Css,
			".innercontenttable>table>tbody>tr>th:nth-of-type(1)");
	private UIElement lblGetCourseIntroductionTitle = createElement(
			UIType.Xpath,
			"//*[@id='frmAnnouncement']/table[4]/tbody/tr/td/h2/div");
	private UIElement lnkAddChatroom = createElement(UIType.Xpath,
			"//a[contains(text(),'Add Chatroom')]");
	private UIElement lstUnit = createElement(UIType.Xpath, "//a[@title='{1}']");
	private UIElement lstItem = createElement(UIType.LinkText, "{1}");
	private UIElements lblListOfAnnouncementsValues = createElements(
			UIType.Xpath,
			"//table[contains(@summary,'Announcements')]//tr//th//a");
	private UIElement lnkannouncementpresent = createElement(UIType.Xpath,
			"//th[a[contains(.,'{1}')]]");
	private UIElement btnSaveChanges = createElement(UIType.Xpath,
			"//input[contains(@value,'Save Changes')]");

	/* Variables */
	private String courseIntroductionRadToolId = "RadCourseText";
	private String courseIntroductionRadFrameId = "RadCourseText_contentIframe";
	private String courseIntroductionRadFooterId = "RadCourseText_ModesWrapper";
	private static String browser;
	private String visualEditorLink = "RadCourseText_visualEditor";
	private String plainTextEditorLink = "RadCourseText_simpleEditor";
	private boolean flag = false;
	List<String> announcementValues;
	String announcementContent;
	String startTime;
	String endTime;
	String courseHomeTitle;
	String announcementHeaderTitle;
	String timeZoneDisplay;
	String scrollHeight;
	String clientHeight;
	String courseIntroductionTitle;
	String pageSource;

	// RAD element initialization
	VisualEditor visualEditor = new VisualEditor(uiDriver,
			courseIntroductionRadToolId, courseIntroductionRadFrameId,
			courseIntroductionRadFooterId);
	PlainTextEditor plainEditor = new PlainTextEditor(uiDriver);
	RadEditorSwitchPlainOrVisual radSwitch = new RadEditorSwitchPlainOrVisual(
			uiDriver, visualEditorLink, plainTextEditorLink);

	/* Constructor */
	public NextAuthorHomePage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ## NextAuthorHomePage ##");
	}

	public VisualEditor getVisualEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return visualEditor;
	}

	public PlainTextEditor getPlainTextEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return plainEditor;
	}

	public RadEditorSwitchPlainOrVisual getRadSwitch() throws Exception {
		frameSwitch.switchToFrameContent();
		return radSwitch;
	}

	/**
	 * Method helps to select the Course Items Tab
	 * 
	 * @author sumanth.sv
	 * @return CourseItemsPage
	 * @throws Exception
	 */
	public CourseItemsPage clickCourseItemsTab() throws Exception {
		logInstruction("LOG INSTRUCTION: Switch to Content Frame");
		frameSwitch.switchToFrameContent();
		try {
			logInstruction("LOG INSTRUCTION: Wait for Tab: Course Items Tab");
			uiDriver.waitToBeDisplayed(lnktabCourseItem, waitTime);
			logInstruction("LOG INSTRUCTION: Click on Tab:  Course Items Tab");
			lnktabCourseItem.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Course Items'TAB "
					+ "\n METHOD:clickCourseItemsTab:\n"
					+ e.getLocalizedMessage());
		}
		return new CourseItemsPage(uiDriver);
	}

	/**
	 * Method helps to select the select File Manager Tab
	 * 
	 * @author sumanth.sv
	 * @return FileManagerPage
	 * @throws Exception
	 */
	public FileManagerPage selectFileManagerTab() throws Exception {
		logInstruction("LOG INSTRUCTION: Switch to Content Frame");
		frameSwitch.switchToFrameContent();
		try {
			logInstruction("LOG INSTRUCTION: Wait for Tab: Course File Manager Tab");
			uiDriver.waitToBeDisplayed(lnktabCourseFileManager, waitTime);
			logInstruction("LOG INSTRUCTION: Click on Tab: Course File Manager Tab");
			lnktabCourseFileManager.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'File Manager'TAB "
					+ "\n METHOD:selectFileManagerTab:\n"
					+ e.getLocalizedMessage());
		}
		return new FileManagerPage(uiDriver);
	}

	/**
	 * Method helps to select the select Course Home Tab
	 * 
	 * @author sumanth.sv
	 * @return NextAuthorHomePage
	 * @throws Exception
	 */
	public NextAuthorHomePage selectCourseHomeTab() throws Exception {
		logInstruction("LOG INSTRUCTION: Switch to Content Frame");
		frameSwitch.switchToFrameContent();
		try {
			logInstruction("LOG INSTRUCTION: Wait for Tab: Course Home Tab");
			uiDriver.waitToBeDisplayed(lnktabCourseHome, waitTime);
			logInstruction("LOG INSTRUCTION: Click on Tab: Course Home Tab");
			lnktabCourseHome.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Course Home'TAB "
					+ "\n METHOD:selectCourseHomeTab:\n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to click the AddAnnouncementLink
	 * 
	 * @author ashish.juyal
	 * @return AddAnnouncementPage
	 * @throws Exception
	 */
	public AddAnnouncementPage clickAddAnnouncementLink() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: Clicking the AddAnnouncement button");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnAddAnnouncementButton, waitTime);
			btnAddAnnouncementButton.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Add Announcement' "
					+ "\n METHOD:clickAddAnnouncementLink:\n"
					+ e.getLocalizedMessage());
		}
		return new AddAnnouncementPage(uiDriver);
	}

	/**
	 * this method helps to select the announcement
	 * 
	 * @author ashish.juyal
	 * @return NextAuthorHomePage
	 * @throws Exception
	 * @throwsException
	 */
	public NextAuthorHomePage selectAnnouncement(String nameofAnnouncement)
			throws Exception {
		logInstruction("LOG INSTRUCTION: selecting the announcement");
		try {
			frameSwitch.switchToFrameContent();
			mnuSelectAnnouncement.replaceValues(nameofAnnouncement,
					nameofAnnouncement);
			mnuSelectAnnouncement.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Announcement'"
					+ "\n METHOD:selectAnnouncement:\n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to click on the expand all button
	 * 
	 * @author ashish.juyal
	 * @return NextAuthorHomePage
	 * @throws Exception
	 */
	public NextAuthorHomePage clickExpandAllIcon() throws Exception {
		logInstruction("LOG INSTRUCTION: clicking the expand all button");
		try {
			frameSwitch.switchToFrameContent();
			lnkExpandAllIcon.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Expand All 'ICON"
					+ "\n METHOD:clickExpandAllIcon:\n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to click on the Collapse All button
	 * 
	 * @author ashish.juyal
	 * @return NextAuthorHomePage
	 * @throws Exception
	 */

	public NextAuthorHomePage clickCollpaseAllButton() throws Exception {
		logInstruction("LOG INSTRUCTION: clicking collapse all button");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkCollapseAllIcon, waitTime);
			lnkCollapseAllIcon.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Collapse All'ICON"
					+ "\n METHOD:clickCollpaseAllButton:\n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to click the edit icon of announcement
	 * 
	 * @param String
	 *            nameOfAnnouncement
	 * @author ashish.juyal
	 * @return EditAnnouncementPage
	 * @throws Exception
	 */
	public EditAnnouncementPage clickEditIcon(String nameOfAnnouncement)
			throws Exception {
		logInstruction("LOG INSTRUCTION: clicking the edit icon");
		try {
			frameSwitch.switchToFrameContent();
			btnEditIcon.replaceValues(nameOfAnnouncement);
			btnEditIcon.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Edit'ICON"
					+ "\n METHOD:clickEditIcon:\n" + e.getLocalizedMessage());
		}
		return new EditAnnouncementPage(uiDriver);
	}

	/**
	 * Helps to click the delete icon
	 * 
	 * @param String
	 *            name
	 * @author ashish.juyal
	 * @throws Exception
	 * @return DeleteAnnouncementPage
	 */
	public DeleteAnnouncementPage clickDeleteIcon(String name) throws Exception {
		logInstruction("LOG INSTRUCTION: clicking the delete icon");
		try {
			frameSwitch.switchToFrameContent();
			btnDeleteIcon.replaceValues(name);
			btnDeleteIcon.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Deletes'ICON"
					+ "\n METHOD:clickDeleteIcon:\n" + e.getLocalizedMessage());
		}
		return new DeleteAnnouncementPage(uiDriver);
	}

	/**
	 * This method helps to click on the expand icon of the announcement
	 * 
	 * @param String
	 *            name
	 * @author ashish.juyal
	 * @return NextAuthorHomePage
	 * @throws Exception
	 * 
	 */
	public NextAuthorHomePage clickExpandIcon(String name) throws Exception {
		logInstruction("LOG INSTRUCTION: clicking the expand icon");
		try {
			frameSwitch.switchToFrameContent();
			lnkExpandIcon.replaceValues(name);
			lnkExpandIcon.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Expand'ICON"
					+ "\n METHOD:clickExpandIcon:\n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * this method helps to click on the collapse icon
	 * 
	 * @author ashish.juyal
	 * @return NextAuthorHomePage
	 * @throws Exception
	 */
	public NextAuthorHomePage clickCollpaseIcon(String name) throws Exception {
		try {
			frameSwitch.selectTopicContentFrame();
			lnkCollpaseIcon.replaceValues(name);
			lnkCollpaseIcon.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Collapse'ICON"
					+ "\n METHOD:clickCollpaseIcon:\n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method for Verify Announcement Displayed
	 * 
	 * @author suchi.singh
	 * @param String
	 *            name: announcementName
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAnnouncementDisplayed(String announcementName)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: Checking if Announcement is displayed in the list");
			frameSwitch.switchToFrameContent();
			browser = System.getProperty("browser.NAME");
			if (browser.equalsIgnoreCase("firefox")) {
				List<UIElement> announcementListElement = lstAnnouncementDisplay
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

				List<UIElement> announcementListElement = lstAnnouncementsList
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
			throw new Exception("ISSUE IN LOCATING THE 'Announcement'"
					+ "\n METHOD:isAnnouncementDisplayed\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method for Verify whether announcement text is bold
	 * 
	 * @author suchi.singh
	 * @param String
	 *            name: announcementName
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAnnouncementTextBold(String announcementName)
			throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: Verify new announcement(Bold)");
			frameSwitch.switchToFrameContent();
			mnuSelectAnnouncement.replaceValues(announcementName,
					announcementName);
			String s = mnuSelectAnnouncement.getAttribute("class");
			if (s.equalsIgnoreCase("unread")) {
				logInstruction("LOG INSTRUCTION: Announcement is in bold letter");
				return true;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CHECKING THE 'Announcement' TEXT BOLDNESS"
							+ "\n METHOD:isAnnouncementTextBold:\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * @author shishir.dwivedi
	 * @param String
	 *            name: announcementName
	 * @return String name: announcementContent
	 * @throws Exception
	 */
	public String getAnnouncementContent(String announcementName)
			throws Exception {
		announcementContent = null;
		try {
			logInstruction("LOG INSTRUCTION: Getting the announcement content");
			frameSwitch.switchToFrameContent();
			announcementContent = txtSelectAnnouncementContent.replaceValues(
					announcementName).getText();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE ANNOUNCEMENT CONTENT "
					+ "\n METHOD:getAnnouncementContent\n"
					+ e.getLocalizedMessage());
		}
		return announcementContent;
	}

	/**
	 * @author shishir.dwivedi
	 * @param String
	 *            name: announcementName
	 * @return String name: startTime
	 * @throws Exception
	 */
	public String getAnnouncementStartTime(String announcementName)
			throws Exception {
		startTime = null;
		try {
			logInstruction("LOG INSTRUCTION: Get Start Time of Announcement");
			frameSwitch.switchToFrameContent();
			startTime = txtSelectAnnouncementStartTime.replaceValues(
					announcementName).getText();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE ANNOUNCEMENT STARTTIME "
					+ "\n METHOD:getAnnouncementStartTime:\n"
					+ e.getLocalizedMessage());
		}
		return startTime;
	}

	/**
	 * @author shishir.dwivedi
	 * @param String
	 *            name: announcementName
	 * @return String name: endTime
	 * @throws Exception
	 */
	public String getAnnouncementEndTime(String announcementName)
			throws Exception {
		endTime = null;
		try {
			logInstruction("LOG INSTRUCTION: Get End Time of Announcement");
			frameSwitch.switchToFrameContent();
			endTime = txtSelectAnnouncementEndTime.replaceValues(
					announcementName).getValue();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE ANNOUNCEMENT ENDTIME "
					+ "\n METHOD:getAnnouncementEndTime:\n"
					+ e.getLocalizedMessage());
		}
		return endTime;
	}

	/**
	 * @author shishir.dwivedi
	 * @param String
	 *            name: expectedToolTip
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isTooltipDisplayedForExpandAllIcon(String expectedToolTip)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: Get Toop top");
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
					"ISSUE IN LOCATING THE TOOLTIP MESSAGE FOR 'Expand All' ICON "
							+ "\n METHOD:isTooltipDisplayedForExpandAllIcon:\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/***
	 * Method for clickSaveChanges
	 * 
	 * @author suchi.singh
	 * @return NextAuthorHomePage
	 * @throws Exception
	 */
	public NextAuthorHomePage clickSaveChanges() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: Clicking Save Changes button");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnClickSaveChanges, waitTime);
			btnClickSaveChanges.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Save Changes'BUTTON"
					+ "\n METHOD:clickSaveChanges:\n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to get the CourseHome Title
	 * 
	 * @author ganapati.bhat
	 * @return String name: Title
	 * @throws Exception
	 */
	public String getCourseHomeTitle() throws Exception {
		courseHomeTitle = null;

		try {
			frameSwitch.switchToFrameContent();
			logInstruction("LOG INSTRUCTION: Verify CourseHome Title");
			if (lblCourseTitle.isDisplayed()) {
				courseHomeTitle = lblCourseTitle.getText();
			}
		} catch (Exception e) {

			throw new Exception("ISSUE IN GETTING THE 'Course Home'TITLE"
					+ "\n METHOD:getCourseHomeTitle:\n"
					+ e.getLocalizedMessage());
		}
		return courseHomeTitle;
	}

	/**
	 * Method helps to verify the Announcements Header Title
	 * 
	 * @author ganapati.bhat
	 * @return String name; Title
	 * @throws Exception
	 */
	public String getAnnouncementHeaderTitle() throws Exception {
		announcementHeaderTitle = null;

		try {
			logInstruction("LOG INSTRUCTION: Verify Announcement Title");
			frameSwitch.switchToFrameContent();
			announcementHeaderTitle = lblAnnouncementHeaderTitle.getText();

		} catch (Exception e) {

			throw new Exception(
					"ISSUE IN GETTING THE 'Announcement'HEADER TITLE"
							+ "\n METHOD:getAnnouncementHeaderTitle\n"
							+ e.getLocalizedMessage());
		}
		return announcementHeaderTitle;
	}

	/**
	 * Method helps to Check the position of the AnnouncementsHeader
	 * 
	 * @author ganapati.bhat
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAnnouncementsDisplayedInTopPosition() throws Exception {
		flag = false;

		try {
			logInstruction("LOG INSTRUCTION: Verify the position of the Announcements");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = lblAnnouncementPosition
					.getUIElementsList();
			int totalHeader = elements.size();
			for (int i = 0; i < totalHeader; i++) {
				if (elements.get(i).getText().trim().equals("Announcements")) {
					if (i == 0) {
						logInstruction("LOG INSTRUCTION: The Announcements is in the First position");
						flag = true;
					}

					break;
				}
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN LOCATING THE ANNOUNCEMENT IN TOP POSITION "
							+ "\n METHOD:isAnnouncementsDisplayedInTopPosition:\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to return the Announcement Header display
	 * 
	 * @param String
	 *            tableHeaderName
	 * @author ganapati.bhat
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAnnouncementTableHeaderDisplayed(String tableHeaderName)
			throws Exception {
		flag = false;
		try {
			lblAnouncementTableHeader.replaceValues(tableHeaderName);
			logInstruction("LOG INSTRUCTION: Get Announcement table header");
			frameSwitch.switchToFrameContent();
			if (lblAnouncementTableHeader.isDisplayed()) {
				flag = true;
			}

		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE 'Announcement' HEADER"
					+ "\n METHOD:isAnnouncementTableHeaderDisplayed:\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method Helps to verify the time Displayed at the bottom of the page
	 * 
	 * @author ganapati.bhat
	 * @return String name: timeDisplay
	 * @throws Exception
	 */
	public String getTimeZoneDisplayedAtTheBottom() throws Exception {

		timeZoneDisplay = null;
		try {
			logInstruction("LOG INSTRUCTION: Get the timeZoneMessage ");
			frameSwitch.switchToFrameContent();
			timeZoneDisplay = msgGrayTimeDisplay.getText();

		} catch (Exception e) {
			throw new Exception("ISSUE IN LOCATING THE TIME ZONE "
					+ "\n METHOD:getTimeZoneDisplayedAtTheBottom:\n"
					+ e.getLocalizedMessage());
		}
		return timeZoneDisplay;
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
			logInstruction("LOG INSTRUCTION: Verify collapse announcement");
			frameSwitch.switchToFrameContent();
			lnkExpandIcon.replaceValues(announcementName);
			String s = lnkExpandIcon.getAttribute("title");

			if (s.equalsIgnoreCase("Expand")) {
				flag = true;
			}
		} catch (Exception e) {
			logInstruction(e.getMessage());
			throw new Exception(
					"ISSUE IN LOCATING THE 'Announcement' COLLAPSED ICON"
							+ "\n METHOD:isAnnouncementCollapsed:\n"
							+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to check if course items tab is displayed
	 * 
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isCourseItemsTabDisplayed() throws Exception {
		flag = false;
		logInstruction("LOG INSTRUCTION: Switch to Content Frame");
		frameSwitch.switchToFrameContent();
		try {
			logInstruction("LOG INSTRUCTION: Wait for Tab: Course Items Tab");
			uiDriver.waitToBeDisplayed(lnktabCourseItem, waitTime);
			if (lnktabCourseItem.isDisplayed())
				flag = true;

		} catch (Exception e) {
			throw new Exception("ISSUE IN LOCATING THE 'Course Items'TAB"
					+ "\n METHOD:isCourseItemsTabDisplayed:\n"
					+ e.getLocalizedMessage());

		}
		return flag;
	}

	/**
	 * Method helps to check if file manager tab is displayed
	 * 
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isFileManagerTabDisplayed() throws Exception {
		flag = false;
		logInstruction("LOG INSTRUCTION: Switch to Content Frame");
		frameSwitch.switchToFrameContent();
		try {
			logInstruction("LOG INSTRUCTION: Wait for Tab: Course File Manager Tab");
			uiDriver.waitToBeDisplayed(lnktabCourseFileManager, waitTime);
			if (lnktabCourseFileManager.isDisplayed())
				flag = true;
		} catch (Exception e) {
			throw new Exception("ISSUE IN LOCATING THE 'File Manager'TAB"
					+ "\n METHOD:isFileManagerTabDisplayed:\n"
					+ e.getLocalizedMessage());

		}
		return flag;
	}

	/**
	 * Method helps to check if course home tab is displayed
	 * 
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isCourseHomeTabDisplayed() throws Exception {
		flag = false;
		logInstruction("LOG INSTRUCTION: Switch to Content Frame");
		frameSwitch.switchToFrameContent();
		try {
			logInstruction("LOG INSTRUCTION: Wait for Tab: Course Home Tab");
			uiDriver.waitToBeDisplayed(lnktabCourseHome, waitTime);
			if (lnktabCourseHome.isDisplayed())
				flag = true;
		} catch (Exception e) {
			throw new Exception("Unable to click on the course home button"
					+ e.getLocalizedMessage());

		}
		return flag;
	}

	/**
	 * Method helps to check if course home tab is selected by default
	 * 
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isCourseHomeTabSelectedByDefault() throws Exception {
		flag = false;
		logInstruction("LOG INSTRUCTION: Switch to Content Frame");
		frameSwitch.switchToFrameContent();
		try {
			logInstruction("LOG INSTRUCTION: Wait for Tab: Course Home Tab");
			uiDriver.waitToBeDisplayed(btnCourseHome, waitTime);
			if (btnCourseHome.isDisplayed())
				flag = true;
		} catch (Exception e) {
			throw new Exception("ISSUE IN LOCATING THE COURSE HOME TAB"
					+ "\n METHOD:isCourseHomeTabSelectedByDefault\n"
					+ e.getLocalizedMessage());

		}
		return flag;
	}

	/**
	 * Helps to check if the delete icon is present
	 * 
	 * @param announcementName
	 * @author monica.anand
	 * @throws Exception
	 * @return boolean
	 */
	public boolean isDeleteIconDisplayed(String announcementName)
			throws Exception {
		flag = false;
		logInstruction("LOG INSTRUCTION: check if the delete icon is present ");
		try {
			frameSwitch.switchToFrameContent();
			btnDeleteIcon.replaceValues(announcementName);
			uiDriver.waitToBeDisplayed(btnDeleteIcon, waitTime);
			if (btnDeleteIcon.isDisplayed())
				flag = true;
		} catch (Exception e) {
			logInstruction(e.getMessage());
			throw new Exception("ISSUE IN LOCATING THE 'Delete' ICON"
					+ "'\n METHOD:isDeleteIconDisplayed:\n'"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to check if the tooltip is displayed for collapse all
	 * icon
	 * 
	 * @author monica.anand
	 * @param String
	 *            name: expectedToolTip
	 * @return boolean
	 * @param string
	 */
	public boolean isTooltipDisplayedForCollapseAllIcon(String expectedToolTip)
			throws Exception {
		try {
			flag = false;
			logInstruction("LOG INSTRUCTION: Get Tool tip");
			frameSwitch.switchToFrameContent();
			UIActions action = new DefaultUIActions(uiDriver,
					lnkCollapseAllIcon);
			action.mouseMoveHere();
			if (lnkCollapseAllIcon.getAttribute("title").equalsIgnoreCase(
					expectedToolTip))
				flag = true;
			else
				flag = false;
		} catch (Exception e) {
			throw new Exception("ISSUE IN LOCATING THE 'Collapse All' ICON"
					+ "\n METHOD:isTooltipDisplayedForCollapseAllIcon:\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to check if the collapse all link is displayed
	 * 
	 * @return boolean
	 * @author monica.anand
	 * @throws Exception
	 */

	public boolean isCollapseAllLinkDisplayed() throws Exception {
		logInstruction("LOG INSTRUCTION: Checking if collapse all link is displayed ");
		flag = false;
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkCollapseAllIcon, waitTime);
			if (lnkCollapseAllIcon.isDisplayed())
				flag = true;

		} catch (Exception e) {
			logInstruction(e.getMessage());
			throw new Exception("ISSUE IN LOCATING THE 'Collapse All' LINK"
					+ "\n METHOD:isCollapseAllLinkDisplayed\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is to verify add announcement link.
	 * 
	 * @author saurabh.jain1
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAddAnnouncementLinkDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: Verifying the AddAnnouncement button");
			frameSwitch.switchToFrameContent();
			if (btnAddAnnouncementButton.isDisplayed()) {
				flag = true;
			}

		} catch (Exception e) {

			throw new Exception("ISSUE IN LOCATING THE 'Add Announcement' LINK"
					+ "\n METHOD:isAddAnnouncementLinkDisplayed:\n"
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
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: Verifying the Expand All Link");
			frameSwitch.switchToFrameContent();
			if (lnkExpandAll.isDisplayed()) {
				flag = true;
			}

		} catch (Exception e) {

			throw new Exception("ISSUE IN LOCATING THE 'Expand All' LINK"
					+ "\n METHOD:isExpandAllLinkDisplayed:\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * this method helps to click the edit icon of announcement
	 * 
	 * @return boolean
	 * @param nameOfAnnouncement
	 * @author ganapati.bhat
	 * @throws Exception
	 */
	public boolean isEditIconDisplayed(String nameOfAnnouncement)
			throws Exception {
		flag = false;
		logInstruction("LOG INSTRUCTION: clicking the edit icon");
		try {
			frameSwitch.switchToFrameContent();
			btnEditIcon.replaceValues(nameOfAnnouncement);
			if (btnEditIcon.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN LOCATING THE 'Edit' ICON"
					+ "\n METHOD:isEditIconDisplayed\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to check for collapse icon
	 * 
	 * @param String
	 *            announcemntName
	 * @author ganapati.bhat
	 * @return boolean
	 * @param string
	 */
	public boolean isTooltipDisplayedForCollapseIcon(String announcementName)
			throws Exception {
		flag = false;
		logInstruction("LOG INSTRUCTION: Checking tooltip display for collapse icon.");
		try {
			imgCollapseIcon.replaceValues(announcementName);
			frameSwitch.switchToFrameContent();

			if (imgCollapseIcon.isDisplayed()) {
				flag = true;
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN LOCATING THE TOOLTIP MESSAGE 'Collapse'ICON'"
							+ "\n METHOD:isTooltipDisplayedForCollapseIcon\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to click for collapse icon
	 * 
	 * @param String
	 *            announcementName
	 * @author ganapati.bhat
	 * @return boolean
	 */
	public boolean clickForCollapseIcon(String announcementName)
			throws Exception {
		flag = false;
		logInstruction("LOG INSTRUCTION: Checking for collapse icon.");
		try {
			imgCollapseIcon.replaceValues(announcementName);
			frameSwitch.switchToFrameContent();
			imgCollapseIcon.clickNoWait();

		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Collapse' ICON"
					+ "\n METHOD:clickForCollapseIcon:\n"
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
	public boolean isTooltipDisplayedForExpandIcon(String announcementName)
			throws Exception {
		flag = false;
		logInstruction("LOG INSTRUCTION: Checking for tooltip display for expand icon.");
		try {
			lnkExpandIcon.replaceValues(announcementName);
			frameSwitch.switchToFrameContent();

			if (lnkExpandIcon.isDisplayed()) {
				flag = true;
			}

		} catch (Exception e) {
			throw new Exception("ISSUE IN LOCATING THE TOOLTIP"
					+ "\n METHOD:isTooltipDisplayedForExpandIcon\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to Verify whether the select Course Home is Present or not
	 * 
	 * @author Raghav
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isselectCourseHomePresent() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: Verify course home link is displayed");

			flag = lnktabCourseHome.isDisplayed();

		} catch (Exception e) {
			throw new Exception("ISSUE IN LOCATING THE COURSE HOME LINK"
					+ "\n METHOD:isselectCourseHomePresent:\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to Check the position of Whats new
	 * 
	 * @author Raghav s
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isWhatsNewDisplayedInSecondPosition() throws Exception {
		flag = false;

		try {
			logInstruction("LOG INSTRUCTION: Verify the position of the Whats new");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = lblAnnouncementPosition
					.getUIElementsList();
			int totalHeader = elements.size();
			for (int i = 0; i < totalHeader; i++) {
				if (elements.get(i).getText().trim().equals("What's New")) {
					if (i == 1) {
						flag = true;
						break;
					}
				}
			}

		} catch (Exception e) {
			throw new Exception("ISSUE IN CHCECKING THE POSITION OF  WHATS NEW"
					+ "\n METHOD:isWhatsNewDisplayedInSecondPosition:\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to Check the position of the Course Checklist
	 * 
	 * @author Raghav s
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isCoursechecklistInthirdPosition() throws Exception {
		flag = false;

		try {
			logInstruction("LOG INSTRUCTION: Verify the position of the coursechecklist");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = lblAnnouncementPosition
					.getUIElementsList();
			int totalHeader = elements.size();
			for (int i = 0; i < totalHeader; i++) {
				if (elements.get(i).getText().trim().equals("Course Checklist")) {
					if (i == 2) {
						flag = true;
					}
					break;
				}
			}

		} catch (Exception e) {
			throw new Exception("ISSUE IN CHECKING THE POSITION OF COURSELIST "
					+ "\n METHOD:isCoursechecklistInthirdPosition\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify the header
	 * 
	 * @author Raghav S
	 * @return boolean
	 * @param string
	 */
	public boolean isHeaderInAuthorHomePagePresent(String header)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: Verifying the header title in Author Home page.");
			frameSwitch.switchToFrameContent();
			lblHeaderTextDisplayed.replaceValues(header);
			uiDriver.waitToBeDisplayed(lblHeaderTextDisplayed, waitTime);
			if (lblHeaderTextDisplayed.isDisplayed()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE HEADER TITLE"
					+ "\n METHOD:isheaderinauthorhomepagepresent:\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method check whether the rad editor is displayed or not
	 * 
	 * @return boolean
	 * @author Raghav
	 * @throws Exception
	 */
	public boolean isRadEditorDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: Checking the rad editor");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtRADEditorText, waitTime);
			flag = txtRADEditorText.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN LOCATING 'Radeditor'"
					+ "\n METHOD:isRadEditorDisplayed:\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify whether Scroll Bar is Present or Not
	 * 
	 * @author Raghav S
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isScrollBarDisplayed() throws Exception {
		flag = false;
		clientHeight = null;
		scrollHeight = null;
		try {
			logInstruction(" LOG INSTRUCTION:Check for the scroll bar");
			clientHeight = uiDriver
					.executeScript("return this.document.getElementsByClassName('Authortree')[0].clientHeight");
			scrollHeight = uiDriver
					.executeScript("return this.document.getElementsByClassName('Authortree')[0].scrollHeight");
			int clientHeightInt = Integer.parseInt(clientHeight);
			int scrollHeightInt = Integer.parseInt(scrollHeight);

			if (clientHeightInt < scrollHeightInt) {
				logInstruction(" LOG INSTRUCTION:Vertical scrollbar is Displayed");
				flag = true;
			} else {
				logInstruction(" LOG INSTRUCTION:Vertical scrollbar is not Displayed");
			}

		} catch (Exception e) {
			throw new Exception("ISSUE IN LOCATING THE SCROLL BAR"
					+ "\n METHOD:isScrollBarDisplayed\n"
					+ e.getLocalizedMessage());
		}

		return flag;
	}

	/**
	 * Method Helps to verify the time Displayed at the bottom of the page
	 * 
	 * @author ganapati.bhat
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isTimeZoneDisplayedAtTheBottom() throws Exception {

		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: Get the timeZoneMessage displayed at bottom ");
			frameSwitch.switchToFrameContent();
			if (msgGrayTimeDisplay.isDisplayed())
				flag = true;

		} catch (Exception e) {
			throw new Exception("ISSUE IN LOCATING THE TIME ZONE"
					+ "\n METHOD:isTimeZoneDisplayedAtTheBottom\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method will get course introduction title
	 * 
	 * @author Suchi.Singh
	 * 
	 * @return String CourseIntroductionTitle
	 * @throws Exception
	 * **/
	public String getCourseIntroductionTitle() throws Exception {
		courseIntroductionTitle = null;
		try {
			logInstruction("Getting course introduction title");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblGetCourseIntroductionTitle, waitTime);
			courseIntroductionTitle = lblGetCourseIntroductionTitle.getText()
					.trim();

		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE 'Introduction' TITLE "
					+ "\n METHOD:getCourseIntroductionTitle\n"
					+ e.getLocalizedMessage());
		}
		return courseIntroductionTitle;

	}

	/**
	 * This method will get page source
	 * 
	 * @author Suchi.Singh
	 * @return String
	 * @throws Exception
	 * **/
	public String getPageSource() throws Exception {
		pageSource = null;
		try {
			logInstruction("Getting page source");
			frameSwitch.switchToFrameContent();
			pageSource = uiDriver.getPageSource();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE 'Page Source'"
					+ "\n METHOD:getPageSource\n" + e.getLocalizedMessage());
		}
		return pageSource;

	}

	/**
	 * This Method will check Whether RAD IS Displayed or not.
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */

	public boolean isRADDisplayd() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: Checking if RAD Editor is displayed or not");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(areaIsRADDisplayed, waitTime);
			flag = areaIsRADDisplayed.isDisplayed();
		} catch (Exception e) {
			logInstruction("ISSUE IN LOCATING THE 'Radeditor'"
					+ "\n METHOD:isRADDisplayd\n" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to check if "Add Chatroom " link is displayed
	 * 
	 * @category Milestone 2
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAddChatroomLinkDisplayed() throws Exception {
		try {
			flag = false;
			logInstruction("LOG INSTRUCTION : CHECKING IF ADD CHATROOM LINK IS DISPLAYED  ");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkAddChatroom, waitTime);
			if (lnkAddChatroom.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			logInstruction("UNABLE TO CHECK IF ADD CHATROOM LINK IS DISPLAYED"
					+ "\n METHOD:isAddChatroomLinkDisplayed\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method will check the provided table header is displayed in the page or
	 * not
	 * 
	 * @author Praveen.Maled
	 * @param String
	 *            strTableHeader
	 * @return boolean
	 * @throws Exception
	 * @category Milestone 2
	 */
	public boolean isTableHeaderExist(String strTableHeader) throws Exception {
		try {
			flag = false;
			logInstruction("LOG INSTRUCTION : CHECKING TABLE HEADER '"
					+ strTableHeader + "' IS DISPLAYED OR NOT");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = lblAnnouncementPosition
					.getUIElementsList();
			int totalHeader = elements.size();
			for (int i = 0; i < totalHeader; i++) {
				if (elements.get(i).getText().trim().equals(strTableHeader)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logInstruction("ISSUE IN CHECKING TABLE HEADER"
					+ "\n METHOD:isTableHeaderPresent\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method Returns the Announcement List of Entries with LSAutoPrefix
	 * and with Specified Time Stamp
	 * 
	 * @return List<String>
	 * @throws Exception
	 * @author Raghav S
	 */

	public List<String> getAnnouncementItemList() throws Exception {
		announcementValues = new ArrayList<String>();
		try {
			logInstruction("LOGINSTRUCTION: GETTING ANNOUNCEMENT NAMES");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = lblListOfAnnouncementsValues
					.getUIElementsList();
			for (int i = 0; i < elements.size(); i++) {
				if (StringUtils.isNotBlank(elements.get(i).getText())
						&& (elements.get(i).getText().contains("LSAutoTest"))
						&& (cleanup.verifyOnedayTimeStamp(elements.get(i)
								.getText().trim()))) {

					announcementValues.add(elements.get(i).getText().trim());
				}
			}

		} catch (Exception e) {
			throw new Exception("ISSUE IN  GETTING  'announcment' NAME"
					+ "\n METHOD:getAnnouncementItemList \n"
					+ e.getLocalizedMessage());
		}

		return announcementValues;

	}

	/**
	 * This Method Returns a Boolean value if the Announcement is deleted it
	 * returns false if announcement is not deleted then it returns true
	 * 
	 * @param String
	 *            announcementName
	 * @return boolean
	 * @throws Exception
	 * @author Raghav S
	 */
	public boolean isAnnouncementDeleted(String announcementName)
			throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:VERIFYING WHETHER ANNOUNCEMENT IS DELETED");
			frameSwitch.switchToFrameContent();
			lnkannouncementpresent.replaceValues(announcementName);
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'announcement' "
					+ "\nMETHOD:isAnnouncementDeleted\n"
					+ e.getLocalizedMessage());

		}
		return lnkannouncementpresent.isDisplayedAfterWaiting(waitTime);

	}

	/**
	 * Method helps to verify whether Content Item is deleted or not
	 * 
	 * @param String
	 *            itemName
	 * @author Raghav.Sunderrajan
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isContentItemDeleted(String itemName) throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:VERIFYING CONTENT ITEM IS DELETED");
			frameSwitch.switchToTreePane();
			lstItem.replaceValues(itemName);
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'content' ITEM "
					+ "\nMETHOD:isContentItemDeleted\n"
					+ e.getLocalizedMessage());

		}
		return lstItem.isDisplayedAfterWaiting(waitTime);
	}

	/**
	 * Method helps to verify Whether Content Unit is deleted or not
	 * 
	 * @param String
	 *            unitName
	 * @author Raghav.Sunderrajan
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isContentUnitDeleted(String unitName) throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:VERIFYING UNIT ITEM IS DELETED");
			frameSwitch.switchToTreePane();
			lstUnit.replaceValues(unitName);
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'unit' ITEM "
					+ "\nMETHOD:isContentUnitDeleted\n"
					+ e.getLocalizedMessage());

		}
		return lstUnit.isDisplayedAfterWaiting(waitTime);
	}

	/***
	 * Method verifies whether save changes button is present
	 * 
	 * @author Raghav S
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isSaveChangesbtnPresent() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: Save Changes button is clicked");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
			if (btnSaveChanges.isDisplayed()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception("Unable to click Save Changes button"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

}
