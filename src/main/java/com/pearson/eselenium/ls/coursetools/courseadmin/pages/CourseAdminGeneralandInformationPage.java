package com.pearson.eselenium.ls.coursetools.courseadmin.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all methods related to CourseAdminGeneralandInformationPage
 * 
 * @author Raghav
 * @param uiDriver
 * 
 */

public class CourseAdminGeneralandInformationPage extends BasePageObject {

	/* UI element declarations for CourseAdminGeneralandInformationPage */

	private UIElement txtcoursetitle = createElement(UIType.ID, "courseTitle");
	private UIElement txtinstructortitle = createElement(UIType.ID,
			"instructorTitle");
	private UIElement txttatitle = createElement(UIType.ID, "taTitle");
	private UIElement txtunitheader = createElement(UIType.ID, "unitHeader");
	private UIElement chkunittitles = createElement(UIType.ID, "wrapUnitTitles");
	private UIElement chkcontentitem = createElement(UIType.ID,
			"wrapContentItemTitles");
	private UIElement chkdisplayunitheader = createElement(UIType.ID,
			"displayUnitHeaders");
	private UIElement lblcourselocale = createElement(UIType.ID, "courseLocale");
	private UIElement btnsavechanges = createElement(UIType.Css,
			"input[value='Save Changes']");
	private UIElement btncancel = createElement(UIType.Css,
			"input[value='Cancel']");
	private UIElement txttitle = createElement(UIType.Xpath,
			"//h2[@class='headertitle']/div");
	private UIElement txtdisplaysetting = createElement(UIType.Xpath,
			"//td[label]");
	private UIElement lblpresent = createElement(UIType.Xpath,
			"//th[label[contains(text(),'{1}')]]");
	private UIElement txtinstructional = createElement(UIType.Css,
			".dkgraytext");
	private UIElement lblavailable = createElement(UIType.Xpath,
			"//th[contains(text(),'{1}')]");
	private UIElement radcoursedescription = createElement(UIType.ID,
			"radCourseDescription");
	private UIElement radrequiredtext = createElement(UIType.ID,
			"radRequiredText");
	private String textvisualeditorframeid = "radRequiredText_contentIframe";
	private String textvisualeditortoolid = "radRequiredText";
	private String textvisualeditorfooterid = "radRequiredText_ModesWrapper";
	private String courseradframeid = "radCourseDescription_contentIframe";
	private String coursetoolid = "radCourseDescription";
	private String courseradfooterid = "radCourseDescription_ModesWrapper";
	private VisualEditor visualeditorcourse = new VisualEditor(uiDriver,
			coursetoolid, courseradframeid, courseradfooterid);
	private VisualEditor requiredTextviusaleditor = new VisualEditor(uiDriver,
			textvisualeditortoolid, textvisualeditorframeid,
			textvisualeditorfooterid);
	private UIElement lnkEditorSwitch= createElement(UIType.Css, "#telerikRAD");
	
	/* constructor */
	public CourseAdminGeneralandInformationPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ## CourseAdminGeneralandInformationPage ##");

	}

	/* variables */
	private String strTitle = null;
	private boolean flag = false;
	private boolean flagOne = false;
	private boolean flagTwo = false;

	// VisualEditor visualEditor = new VisualEditor(uiDriver,
	// contentRadEditorTableId);
	/**
	 * Method helps to initialize the UIElements
	 * 
	 */

	public VisualEditor getCourseVisualEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return visualeditorcourse;
	}

	public VisualEditor getTextVisualEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return requiredTextviusaleditor;
	}

	/**
	 * This method helps to get the title of
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @author Raghav
	 * @return String
	 * @throws Exception
	 */

	public String getTitle() throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			logInstruction("LOG INSTRUCTION: VERIFY GENERAL INFORMATION & SETTINGS PAGE TITLE");
			if (txttitle.isDisplayedAfterWaiting(waitTime)) {
				strTitle = txttitle.getText().trim();
			}
		} catch (Exception e) {

			throw new Exception(
					"ISSUE IN GETTING  'General Information & Settings Page Title' "
							+ "\n METHOD:getTitle \n" + e.getLocalizedMessage());
		}
		return strTitle;
	}

	/**
	 * This method helps to enter the coursetitle in
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @author Raghav
	 * @return CourseAdminGeneralandInformationPage
	 * @throws Exception
	 */

	public CourseAdminGeneralandInformationPage enterCourseTitle(
			String Coursetitle) throws Exception {
		logInstruction("LOG INSTRUCTION: ENTER THE COURSE TITLE");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtcoursetitle, waitTime);
			txtcoursetitle.clearAndSendKeys(Coursetitle);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING  'course title'"
					+ "\n METHOD:\n " + e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * This method helps to enter the instructor title in
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @author Raghav
	 * @return CourseAdminGeneralandInformationPage
	 * @throws Exception
	 */
	public CourseAdminGeneralandInformationPage enterInstructorTitle(
			String Instructortitle) throws Exception {
		logInstruction("LOG INSTRUCTION: ENTER THE INSTRUCTOR TITLE");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtinstructortitle, waitTime);
			txtinstructortitle.clearAndSendKeys(Instructortitle);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE ' instructor title' "
					+ "\n METHOD:enterInstructorTitle \n"
					+ e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * This method helps to enter the TA title in
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @author Raghav
	 * @return CourseAdminGeneralandInformationPage
	 * @throws Exception
	 */
	public CourseAdminGeneralandInformationPage enterTaTitle(String taTitle)
			throws Exception {
		logInstruction("LOG INSTRUCTION: ENTER THE TA TITLE");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txttatitle, waitTime);
			txttatitle.clearAndSendKeys(taTitle);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING  the TA title "
					+ "\n METHOD:enterTaTitle \n" + e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * This method helps to enter the Unit heading in
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @author Raghav
	 * @return CourseAdminGeneralandInformationPage
	 * @throws Exception
	 */
	public CourseAdminGeneralandInformationPage enterUnitHeading(
			String UnitHeading) throws Exception {
		logInstruction("LOG INSTRUCTION: ENTER THE UNIT HEADING");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtunitheader, waitTime);
			txtunitheader.clearAndSendKeys(UnitHeading);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING  the Unit heading "
					+ "\n METHOD:enterUnitHeading \n" + e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * This method helps to check the Unit Titles checkbox in
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @author Raghav
	 * @return CourseAdminGeneralandInformationPage
	 * @throws Exception
	 */
	public CourseAdminGeneralandInformationPage clickCheckboxUnitTitles()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON UNIT TITLES CHECKBOX");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(chkunittitles, waitTime);
			if (chkunittitles.isSelected() == false) {
				chkunittitles.clickAndWait(waitTime);
			} else {
				logInstruction("LOG INSTRUCTION: Already checked");
			}
			logInstruction("LOG INSTRUCTION: Unit Titles CheckBox is Selected");
		} catch (Exception e) {
			throw new Exception("ISSUE IN SELECTING Unit Titles CheckBox"
					+ "\n METHOD:clickCheckboxUnitTitles +\n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to check the ContentItemnames checkbox in
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @author Raghav
	 * @return CourseAdminGeneralandInformationPage
	 * @throws Exception
	 */
	public CourseAdminGeneralandInformationPage clickCheckboxContentItemNames()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON CONTENT ITEM CHECKBOX");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(chkcontentitem, waitTime);
			if (chkcontentitem.isSelected() == false) {
				chkcontentitem.clickAndWait(waitTime);
			} else {
				logInstruction("LOG INSTRUCTION: Already checked");
			}
			logInstruction("LOG INSTRUCTION: Content Item CheckBox is Selected");
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN SELECTING THE' Content Item CheckBox'"
							+ "\n METHOD:clickCheckboxContentItemNames \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to check the checkboxunitheading in
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @author Raghav
	 * @return CourseAdminGeneralandInformationPage
	 * @throws Exception
	 */
	public CourseAdminGeneralandInformationPage clickCheckboxUnitHeading()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON DISPLAY UNIT HEADER CHECKBOX");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(chkdisplayunitheader, waitTime);
			if (chkdisplayunitheader.isSelected() == false) {
				chkdisplayunitheader.clickAndWait(waitTime);
			} else {
				logInstruction("LOG INSTRUCTION: Already checked");
			}
			logInstruction("LOG INSTRUCTION: Display Unit header CheckBox is Selected");
		} catch (Exception e) {
			throw new Exception(
					"ISSUE ON SELECTING THE ' Display Unit header Checkbox'"
							+ "\n METHOD:clickCheckboxUnitHeading \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method selects the value from the Course Locale in
	 * CourseAdminGeneralandInformationPageage
	 * 
	 * @return CourseAdminGeneralandInformationPage
	 * @author Raghav
	 * @throws Exception
	 */
	public CourseAdminGeneralandInformationPage selectCourseLocale(String text)
			throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			logInstruction("LOG INSTRUCTION: SELECT THE VALUE FROM THE COURSELOCALE LIST");
			uiDriver.waitToBeDisplayed(lblcourselocale, waitTime);
			lblcourselocale.selectByVisibleText(text);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN SELECTING THE CourseLocale dropdown list"
							+ "\n METHOD:selectCourseLocale \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to click on save button
	 * 
	 * 
	 * @return CourseAdminPage
	 * @author Raghav
	 * @throws Exception
	 */
	public CourseAdminPage clickSaveChanges() throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			logInstruction("LOG INSTRUCTION: CLICKING ON SAVE BUTTON");
			uiDriver.waitToBeDisplayed(btnsavechanges, waitTime);
			btnsavechanges.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'save changes button'"
					+ "\n METHOD:clicksavechanges \n" + e.getLocalizedMessage());
		}
		return new CourseAdminPage(uiDriver);
	}

	/**
	 * This method helps to click on cancel button
	 * 
	 * 
	 * @return CourseAdminPage
	 * @author Raghav
	 * @throws Exception
	 */
	public CourseAdminPage clickCancel() throws Exception {
		try {

			logInstruction("LOG INSTRUCTION: CLICKING ON CANCEL BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btncancel, waitTime);
			btncancel.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING  on cancel button"
					+ "\n METHOD:clickcancel \n" + e.getLocalizedMessage());
		}
		return new CourseAdminPage(uiDriver);
	}

	/**
	 * This Method click Check and Uncheck the
	 * "Display long Content Item names on multiple lines in the navigation tree (up to 40 characters)."
	 * checkbox
	 * 
	 * @return {@link CourseAdminGeneralandInformationPage}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */

	public CourseAdminGeneralandInformationPage clickCheckUncheckContentItemsName()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING THE CHECK BOX");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(chkcontentitem, waitTime);
			chkcontentitem.clickAndWait(waitTime);

		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON 'chkbox'"
					+ "\n METHOD:clickCheckUncheckContentItemsName \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method will be used to check and uncheck the
	 * "Display long Unit titles on multiple lines in the navigation tree (up to 40 characters). "
	 * checkbox
	 * 
	 * @return {@link CourseAdminGeneralandInformationPage}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */

	public CourseAdminGeneralandInformationPage clickCheckUncheckUnitHeading()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING THE CHECK BOX");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(chkdisplayunitheader, waitTime);
			chkdisplayunitheader.clickAndWait(waitTime);

		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON 'chkbox'"
					+ "\n METHOD:clickCheckUncheckUnitHeading \n"
					+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * This methow will be used to check and uncheck the
	 * " Display long Unit titles on multiple lines in the navigation tree (up to 40 characters). "
	 * Checkbox
	 * 
	 * @return {@link CourseAdminGeneralandInformationPage}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */

	public CourseAdminGeneralandInformationPage clickCheckUncheckUnitTitle()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING THE CHKBOX");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(chkunittitles, waitTime);
			chkunittitles.clickAndWait(waitTime);

		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON 'chkbox'"
					+ "\n METHOD:clickCheckUncheckUnitTitle \n"
					+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * This method helps to check is unit title checked
	 * 
	 * @return boolean
	 * @author kiran.kumar
	 * @throws Exception
	 */
	public boolean isUnitTitleChecked() throws Exception {

		try {
			logInstruction("LOGINSTRUCTION: VERIFYING IS UNIT TITLE CHK BOX CHECKED");
			frameSwitch.switchToFrameContent();
			if (chkunittitles.isSelected()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'checkbox'"
					+ "\n METHOD:isUnitTitleChecked \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method helps to check is unit title checked
	 * 
	 * @return boolean
	 * @author kiran.kumar
	 * @throws Exception
	 */
	public boolean isContentItemChecked() throws Exception {

		try {
			logInstruction("LOGINSTRUCTION: VERIFYING IS CONTENT ITEM CHK BOX CHECKED");
			frameSwitch.switchToFrameContent();
			chkcontentitem.isSelected();
			flag = true;
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'checkbox'"
					+ "\n METHOD:isContentItemChecked \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method helps to check is unit heading is checked
	 * 
	 * @return boolean
	 * @author kiran.kumar
	 * @throws Exception
	 */
	public boolean isUnitHeadingChecked() throws Exception {

		try {
			logInstruction("LOGINSTRUCTION: VERIFYING IS UNITHEADING CHK BOX CHECKED");
			frameSwitch.switchToFrameContent();
			if (chkdisplayunitheader.isSelected()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'checkbox'"
					+ "\n METHOD:isUnitHeadingChecked \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method helps to get the Unit heading in
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @author Suchi.Singh
	 * @return String
	 * @throws Exception
	 */
	public String getUnitHeading() throws Exception {
		strTitle = null;
		logInstruction("LOGINSTRUCTION: GETTING THE UNIT HEADING");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtunitheader, waitTime);
			strTitle = txtunitheader.getAttribute("value").trim();
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING 'UNITHEADING' "
					+ "\n METHOD:getUnitHeading \n " + e.getLocalizedMessage());
		}
		return strTitle;
	}

	/**
	 * Method helps to check whether course title is changed
	 * 
	 * @category Milestone 2
	 * @author Raghav S
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean isCourseTitleChanged(String newCourseTitle) throws Exception {
		try {
			logInstruction("LOGINSTRUCTION: VERIFYING COURSE TITLE CHANGE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtcoursetitle, waitTime);
			if (txtcoursetitle.isDisplayedAfterWaiting(waitTime)) {
				strTitle = txtcoursetitle.getText().trim();

				if (!newCourseTitle.equalsIgnoreCase(strTitle))
					flag = true;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING 'coursetitle'"
					+ "\n METHOD:isCourseTitleChanged \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to get course title
	 * 
	 * @category Milestone 2
	 * @author amit.deshmukh
	 * @return String
	 * @throws Exception
	 * 
	 */
	public String getCoursetitle() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION :GETTING COURSE TITLE");
			frameSwitch.switchToFrameContent();
			if (txtcoursetitle.isDisplayedAfterWaiting(waitTime)) {
				strTitle = txtcoursetitle.getAttribute("value").trim();

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING 'coursetitle'"
					+ "\n METHOD:getCoursetitle \n" + e.getLocalizedMessage());
		}
		return strTitle;
	}

	/**
	 * Method helps to check whether Instructor title is changed
	 * 
	 * @category Milestone 2
	 * @author Raghav
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean isInstructorTitleChanged(String newInstructorTitle)
			throws Exception {

		try {
			logInstruction("LOG INSTRUCTION : VERIFYING INSTRUCTOR TITLE CHANGE");
			frameSwitch.switchToFrameContent();
			if (txtinstructortitle.isDisplayedAfterWaiting(waitTime)) {
				strTitle = txtinstructortitle.getText().trim();

				if (!newInstructorTitle.equalsIgnoreCase(strTitle))
					flag = true;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING 'instructional title'"
					+ "\n METHOD:isInstructorTitleChanged \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to check whether TA Title is changed
	 * 
	 * @category Milestone 2
	 * @author Raghav
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean isTaTitleChanged(String newTATitle) throws Exception {

		try {
			logInstruction("LOGINSTRUCTION : VERIFYING TA TITLE CHANGE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txttatitle, waitTime);
			if (txttatitle.isDisplayedAfterWaiting(waitTime)) {
				strTitle = txttatitle.getText();

				if (!newTATitle.equalsIgnoreCase(strTitle))
					flag = true;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING 'ta title'"
					+ "\n METHOD:isTaTitleChanged \n" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to check whether Unit Title is changed
	 * 
	 * @category Milestone 2
	 * @author Raghav
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean isUnitHeadingChanged(String newUnitHeading) throws Exception {

		try {
			logInstruction("LOGINSTRUCTION: VERIFYING UNIT HEADING CHANGE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtunitheader, waitTime);
			if (txtunitheader.isDisplayedAfterWaiting(waitTime)) {
				newUnitHeading = txtunitheader.getText();

				if (!newUnitHeading.equalsIgnoreCase(strTitle))
					flag = true;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING 'unit heading'"
					+ "\n METHOD:isUnitHeadingChanged \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to check whether Course Locale dropdown is present
	 * 
	 * @category Milestone 2
	 * @author Raghav
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean isCourseLocaleDropdownPresent() throws Exception {
		try {
			logInstruction("LOGINSTRUCTION: VERIFYING COURSE LOCALE DROPDOWN");
			frameSwitch.switchToFrameContent();
			return lblcourselocale.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING 'Course Locale dropdown"
					+ "\n METHOD:isCourseLocaleDropdownPresent \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * Method helps to check whether Course Description RAD Editor presence
	 * 
	 * @category Milestone 2
	 * @author Raghav
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean isCourseDecsriptionRadEditorPresent() throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:VERIFYING COURSE DESCRIPTION RAD EDITOR PRESENCE");
			frameSwitch.switchToFrameContent();
			return radcoursedescription.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'RAD Editor'"
					+ "\n METHOD:isCourseDecsriptionRadEditorPresent \n"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * Method helps to check whether Required Description RAD Editor presence
	 * 
	 * @category Milestone 2
	 * @author Raghav
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean isRequiredDescriptionRadEditorPresent() throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:VERIFYING REQUIRED DESCRIPTION RAD EDITOR PRESENCE");
			frameSwitch.switchToFrameContent();
			return radrequiredtext.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'RAD Editor'"
					+ "\n METHOD:isRequiredDescriptionRadEditorPresent \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * Methods helps to determine whether Display Setting Text Of Checkbox is
	 * present.
	 * 
	 * @category Milestone 2
	 * @author amit.deshmukh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isDisplaySettingTextPresent() throws Exception {

		try {
			logInstruction("LOGINSTRUCTION:VERIFYING TEXTIS PRESENT IN DISPLAY SETTINGS");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtdisplaysetting, waitTime);
			if (txtdisplaysetting.isDisplayedAfterWaiting(waitTime))
				flag = true;
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'displaysetting text'"
					+ "\n METHOD:isDisplaySettingTextPresent \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method helps to Uncheck the Unit Titles checkbox in
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @category Milestone 2
	 * @author amit.deshmukh
	 * @return CourseAdminGeneralandInformationPage
	 * @throws Exception
	 */
	public CourseAdminGeneralandInformationPage clickUnCheckboxUnitTitles()
			throws Exception {
		try {
			logInstruction("LOGINSTRUCTION: CLICKING ON UNIT TITLES CHECKBOX");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(chkunittitles, waitTime);
			if (chkunittitles.isSelected() == true) {
				chkunittitles.clickAndWait(waitTime);
			} else {
				logInstruction("Already Unchecked");
			}
			logInstruction("Unit Titles CheckBox is Not Selected");
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'checkbox'"
					+ "\n METHOD:clickUnCheckboxUnitTitles \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to Uncheck the ContentItemnames checkbox in
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @category Milestone 2
	 * @author amit.deshmukh
	 * @return CourseAdminGeneralandInformationPage
	 * @throws Exception
	 */
	public CourseAdminGeneralandInformationPage clickUnCheckboxContentItemNames()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:CLICKING ON CONTENT ITEM CHECKBOX TO UNCHECK IT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(chkcontentitem, waitTime);
			if (chkcontentitem.isSelected() == true) {
				chkcontentitem.clickAndWait(waitTime);
			} else {
				logInstruction("Already Unchecked");
			}
			logInstruction("Content Item CheckBox is not  Selected");
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'checkbox'"
					+ "\n METHOD:clickUnCheckboxContentItemNames \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Methods helps to determine whether label is present e.g Course
	 * Title,Instructor,Ta,unitheading,course locale,etc
	 * 
	 * @category Milestone 2
	 * @author amit.deshmukh
	 * @param label
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isLabelPresent(String label) throws Exception {

		try {

			logInstruction("LOG INSTRUCTION : VERIFYING LABEL IS PRESENT");
			frameSwitch.switchToFrameContent();
			lblpresent.replaceValues(label);
			uiDriver.waitToBeDisplayed(lblpresent, waitTime);
			if (lblpresent.isDisplayedAfterWaiting(waitTime))
				flag = true;

		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE LABEL"
					+ "\n METHOD:isLabelPresent \n" + e.getLocalizedMessage());
		}

		return flag;
	}

	/**
	 * This method helps to verify coursetitle checkbox is present in
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @category Milestone 2
	 * @author amit.deshmukh
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isCourseTitleTextBoxPresent() throws Exception {

		logInstruction("LOG INSTRUCTION:VERIFYING TEXTBOX");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtcoursetitle, waitTime);
			return txtcoursetitle.isDisplayedAfterWaiting(waitTime);

		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'textbox"
					+ "\n METHOD:isCourseTitleTextBoxPresent \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * This method helps to verify instructor title checkbox is present in
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @author amit.deshmukh
	 * @category Milestone 2
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isInstructorTitleTextBoxPresent() throws Exception {

		logInstruction("LOG INSTRUCTION:VERIFYING INSTRUCTOR TITLE TEXTBOX");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtinstructortitle, waitTime);
			return txtinstructortitle.isDisplayedAfterWaiting(waitTime);

		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'textbox"
					+ "\n METHOD:isInstructorTitleTextBoxPresent \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * This method helps to verify the TA title TextBox Present in
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @author amit.deshmukh
	 * @category Milestone 2
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isTaTitleTextBoxPresent() throws Exception {

		logInstruction("LOG INSTRUCTION:VERIFYING TA TITLE TEXTBOX");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txttatitle, waitTime);
			return txttatitle.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'textbox"
					+ "\n METHOD:isTaTitleTextBoxPresent \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * This method helps to verify the Unit heading textbox in
	 * CourseAdminGeneralandInformationPage
	 * 
	 * @author amit.deshmukh
	 * @category Milestone 2
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isUnitHeadingTextBoxPresent() throws Exception {

		logInstruction("LOGINSTRUCTION:VERIFY THE UNIT HEADING TEXTBOX");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtunitheader, waitTime);
			return txtunitheader.isDisplayedAfterWaiting(waitTime);

		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'textbox"
					+ "\n METHOD:isUnitHeadingTextBoxPresent \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * Methods helps to verify Instructional Text Releated to DropDown Locale
	 * 
	 * @author amit.deshmukh
	 * @category Milestone 2
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isInstructionalTextPresentDropDown() throws Exception {

		logInstruction("LOG INSTRUCTION:VERIFY THE INSTRUCTIONAL TEXT FOR DROPDOWN LOCALE");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtinstructional, waitTime);
			return txtinstructional.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'textInstructional"
					+ "\n METHOD:isInstructionalTextPresentDropDown \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * This method helps to verify save button
	 * 
	 * @return boolean
	 * @category Milestone 2
	 * @author amit.deshmukh
	 * @throws Exception
	 */
	public boolean isSaveChangesPresent() throws Exception {

		try {
			frameSwitch.switchToFrameContent();
			logInstruction("LOG INSTRUCTION: VERIFY SAVE BUTTON");
			uiDriver.waitToBeDisplayed(btnsavechanges, waitTime);
			return btnsavechanges.isDisplayedAfterWaiting(waitTime);

		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THEN save changes button"
					+ "\n METHOD:isSaveChangesPresent \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * This method helps to verify cancel button
	 * 
	 * @return boolean
	 * @category Milestone 2
	 * @author amit.deshmukh
	 * @throws Exception
	 */
	public boolean isCancelButtonPresent() throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			logInstruction("LOG INSTRUCTION:VERIFYING CANCEL BUTTON");
			return btncancel.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THEN CANCELbutton"
					+ "\n METHOD:isCancelButtonPresent \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * Methods helps to getlabel for coursedescription and reqtext
	 * 
	 * @author amit.deshmukh
	 * @category Milestone 2
	 * @return boolean
	 */

	public boolean isLabelPresentforCourseDesption(String label)
			throws Exception {
		try {

			logInstruction("LOG INSTRUCTION : VERIFYING LABEL IS PRESENT");
			frameSwitch.switchToFrameContent();
			lblavailable.replaceValues(label);
			return lblavailable.isDisplayedAfterWaiting(waitTime);

		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE 'Label'"
					+ "\n METHOD:isLabelPresentforCourseDesption \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * Method helps to enter the Course Description in rad editor
	 * 
	 * @category Milestone 2
	 * @return CourseAdminGeneralandInformationPage
	 * @author Raghav
	 * @throws Exception
	 */
	public CourseAdminGeneralandInformationPage enterRadCourseContent(
			String coursedescription) throws Exception {
		logInstruction("LOG INSTRUCTION : ENTER THE COURSE CONTENT");

		try {
			frameSwitch.switchToFrameContent();
			visualeditorcourse.enterText(coursedescription);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE 'Text'"
					+ "\n METHOD:enterRadCourseContent \n"
					+ e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * Method helps to enter the Required Content in rad editor
	 * 
	 * @category Milestone 2
	 * @return CourseAdminGeneralandInformationPage
	 * @author Raghav
	 * @throws Exception
	 */
	public CourseAdminGeneralandInformationPage enterRadRequiredContent(
			String text) throws Exception {
		logInstruction("LOG INSTRUCTION : ENTER THE REQUIRED CONTENT");

		try {
			frameSwitch.switchToFrameContent();
			requiredTextviusaleditor.enterText(text);

		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE 'Required Content'"
					+ "\n METHOD:enterRadRequiredContent \n"
					+ e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * This Method will check is REQUIRED TEXT RAD Editor Displayed
	 * 
	 * @return {@link boolean}
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isRequiredTextVisualRADEditorDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER REQUIRED TEXT RAD EDITOR IS BEING DISPLAYED");
			if (requiredTextviusaleditor != null) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER  REQUIRED TEXT RAD EDITOR IS DISPLAYED OR NOT"
							+ "\n METHOD : isRequiredTextVisualRADEditorDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check is COURSE DISCRIPTION RAD Editor Displayed
	 * 
	 * @return {@link boolean}
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isVisualEditorCourseRADEditorDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER COURSE DISCRIPTION RAD EDITOR IS BEING DISPLAYED");
			if (visualeditorcourse != null) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER  COURSE DISCRIPTION RAD EDITOR IS DISPLAYED OR NOT"
							+ "\n METHOD : isVisualEditorCourseRADEditorDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
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
			flag = lnkEditorSwitch.isDisplayedAfterWaiting(waitTime);
			logInstruction("LOG INSTRUCTION: VERIFYING ALTERNATIVE EDITOR PRESENT");
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING ALTERNATIVE EDITOR SWITCH OPTION."
							+ "\n METHOD : isEditorSwitchDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to Enter the Title and Click on Save Changes @ Category
	 * Service Level Method
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Raghav
	 */

	public CourseAdminPage enterTitleandClickSaveChanges(String CourseTitle,
			String InstructorTitle, String TATitle, String UnitHeadingTitle,
			boolean longtitles, boolean contentitem, boolean unitheading)
			throws Exception {

		try {
			logInstruction("LOG INSTRUCTION:ENTERING THE TITLE");
			frameSwitch.switchToFrameContent();
			if (CourseTitle != null) {
				uiDriver.waitToBeDisplayed(txtcoursetitle, waitTime);
				txtcoursetitle.clearAndSendKeys(CourseTitle);
			}
			if (InstructorTitle != null) {
				uiDriver.waitToBeDisplayed(txtinstructortitle, waitTime);
				txtinstructortitle.clearAndSendKeys(InstructorTitle);
			}
			if (TATitle != null) {
				uiDriver.waitToBeDisplayed(txttatitle, waitTime);
				txttatitle.clearAndSendKeys(TATitle);
			}
			if (UnitHeadingTitle != null) {
				uiDriver.waitToBeDisplayed(txtunitheader, waitTime);
				txtunitheader.clearAndSendKeys(UnitHeadingTitle);
			}
			flag = chkdisplayunitheader.isSelected();
			flagOne = chkunittitles.isSelected();
			flagTwo = chkcontentitem.isSelected();
			if (flag && !longtitles) {
				uiDriver.waitToBeDisplayed(chkdisplayunitheader, waitTime);
				chkdisplayunitheader.clickNoWait();
			} else {
				logInstruction("LOG INSTRUCTION:CHECKBOX IS ALREADY CHECKED");
			}
			if (flagOne && !unitheading) {
				uiDriver.waitToBeDisplayed(chkunittitles, waitTime);
				chkunittitles.clickNoWait();
			} else {
				logInstruction("LOG INSTRUCTION:CHECKBOX IS ALREADY CHECKED");

			}
			if (flagTwo && !contentitem) {
				uiDriver.waitToBeDisplayed(chkcontentitem, waitTime);
				chkcontentitem.clickNoWait();
			} else {
				logInstruction("LOG INSTRUCTION:CHECKBOX IS ALREADY CHECKED");
			}
			uiDriver.waitToBeDisplayed(btnsavechanges, waitTime);
			btnsavechanges.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE 'title'"
					+ "\nMETHOD:enterTitleandClickSaveChanges\n"
					+ e.getLocalizedMessage());

		}
		return new CourseAdminPage(uiDriver);
	}

}
