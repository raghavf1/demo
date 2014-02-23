package com.pearson.eselenium.ls.common.pages;

import com.pearson.eselenium.ls.coursetools.courseadmin.pages.CourseAdminPage;
import com.pearson.eselenium.ls.coursetools.docsharing.pages.DocSharingPage;
import com.pearson.eselenium.ls.coursetools.dropbox.pages.DropboxPage;
import com.pearson.eselenium.ls.coursetools.email.pages.EmailHomePage;
import com.pearson.eselenium.ls.coursetools.gradebook.pages.GradebookHomePage;
import com.pearson.eselenium.ls.coursetools.journal.pages.JournalHomePage;
import com.pearson.eselenium.ls.coursetools.webliography.pages.WebliographyHomePage;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class is used to define the locator variables and methods for all Tool
 * Menu on the Top of the application.
 * 
 * @author Hemant.Kumar
 */
public class CourseToolNavigationBar extends BasePieceObject {

	/* Elements */
	private UIElement mnucourseAdminTool = createElement(UIType.Css,
			"#COURSEADMIN>span");
	private UIElement mnugradeBookTool = createElement(UIType.Css,
			"#GRADEBOOK>span");
	private UIElement mnudocSharingTool = createElement(UIType.Css, "#DC>span");
	private UIElement mnuemailTool = createElement(UIType.Css, "#EMAIL_C>span");
	private UIElement mnudropboxTool = createElement(UIType.Css, "#DBOX>span");
	private UIElement mnuwebliographyToolMenu = createElement(UIType.Css,
			"#WEB>span");
	private UIElement mnujournalToolMenu = createElement(UIType.Css,
			"#JOURNAL>span");
	private UIElement mnucoursetools = createElement(UIType.Xpath,
			"//span[contains(text(),'{1}')]");
	private UIElement lblcoursetooltitle = createElement(UIType.Css,
			".pageTitle");
	private UIElement lblcoursetitle = createElement(UIType.Css, ".coursetitle");
	private UIElement radinstructor = createElement(UIType.Css, ".profname");

	/* Variables */
	private boolean flag = false;
	private String strResult = null;
	

	/* Constructor */
	public CourseToolNavigationBar(UIElement element) {
		super(element);
		logInstruction("LOG INSTRUCTION: ## Course Tool Navigation Bar ##");
	}

	/**
	 * This method will click on Course Admin on Tool Menu.
	 * 
	 * @author Hemant.Kumar
	 * @return CourseAdminPage instance
	 * @throws Exception
	 */
	public CourseAdminPage clickCourseAdmin() throws Exception {
		try {
			frameSwitch.selectTopFrame();
			uiDriver.waitToBeDisplayed(mnucourseAdminTool, waitTime);
			mnucourseAdminTool.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: CLICKED ON COURSE ADMIN ON TOOLBAR");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON COURSE ADMIN ON TOOLBAR \n METHOD :clickCourseAdmin"
							+ e.getLocalizedMessage());
		}
		return new CourseAdminPage(uiDriver);
	}

	/**
	 * This method will click on Gradebook on Tool Menu.
	 * 
	 * @author Hemant.Kumar
	 * @return GradebookHomePage instance
	 * @throws Exception
	 */
	public GradebookHomePage clickGradebook() throws Exception {
		try {
			frameSwitch.selectTopFrame();
			uiDriver.waitToBeDisplayed(mnugradeBookTool, waitTime);
			mnugradeBookTool.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED ON GRADE BOOK ON TOOLBAR");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON GRADEBOOK ON TOOLBAR \n METHOD :clickGradebook"
							+ e.getLocalizedMessage());
		}
		return new GradebookHomePage(uiDriver);
	}

	/**
	 * This method will click on DocSharing on Tool Menu.
	 * 
	 * @author Hemant.Kumar
	 * @return DocSharingPage instance
	 * @throws Exception
	 */
	public DocSharingPage clickDocSharing() throws Exception {
		try {
			frameSwitch.selectTopFrame();
			uiDriver.waitToBeDisplayed(mnudocSharingTool, waitTime);
			mnudocSharingTool.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: CLICKED ON DOC SHARING ON TOOLBAR");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON DOC SHARING ON TOOLBAR \n METHOD :clickDocSharing"
							+ e.getLocalizedMessage());
		}
		return new DocSharingPage(uiDriver);
	}

	/**
	 * This method will click on Dropbox on Tool Menu.
	 * 
	 * @author Hemant.Kumar
	 * @return DropboxPage instance
	 * @throws Exception
	 */
	public DropboxPage clickDropbox() throws Exception {
		try {
			frameSwitch.selectTopFrame();
			uiDriver.waitToBeDisplayed(mnudropboxTool, waitTime);
			mnudropboxTool.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED ON DROPBOX ON TOOLBAR");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON GRADEBOOK ON TOOLBAR \n METHOD :clickDropbox"
							+ e.getLocalizedMessage());
		}
		return new DropboxPage(uiDriver);
	}

	/**
	 * This method will click on Email on Tool Menu.
	 * 
	 * @author Hemant.Kumar
	 * @return EmailHomePage instance
	 * @throws Exception
	 */
	public EmailHomePage clickEmail() throws Exception {
		try {
			frameSwitch.selectTopFrame();
			uiDriver.waitToBeDisplayed(mnuemailTool, waitTime);
			mnuemailTool.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED ON EMAIL ON TOOLBAR");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON EMAIL ON TOOLBAR \n METHOD :clickEmail"
							+ e.getLocalizedMessage());
		}
		return new EmailHomePage(uiDriver);
	}

	/**
	 * This method will click on Webliogrpahy tool menu
	 * 
	 * @author Raghav S
	 * @return WebliographyHomePage
	 * @throws Exception
	 */
	public WebliographyHomePage clickWebliography() throws Exception {
		try {
			frameSwitch.selectTopFrame();
			uiDriver.waitToBeDisplayed(mnuwebliographyToolMenu, waitTime);
			mnuwebliographyToolMenu.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED ON WEBLIOGRAPHY ON TOOLBAR");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON WEBLIOGRAPHY ON TOOLBAR \n METHOD :clickWebliography"
							+ e.getLocalizedMessage());
		}
		return new WebliographyHomePage(uiDriver);
	}

	/**
	 * Method helps to click on Journal Tool Bar
	 * 
	 * @author Raghav S
	 * @return JournalHomePage
	 * @throws Exception
	 */

	public JournalHomePage clickJournal() throws Exception {
		try {
			frameSwitch.selectTopFrame();
			uiDriver.waitToBeDisplayed(mnujournalToolMenu, waitTime);
			mnujournalToolMenu.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED ON JOURNAL ON TOOLBAR");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON JOURNAL ON TOOLBAR \n METHOD :clickJournal"
							+ e.getLocalizedMessage());
		}
		return new JournalHomePage(uiDriver);
	}

	/**
	 * This Method verifies whether Course Tool are displayed
	 * 
	 * @param String
	 *            toolname
	 * @return boolean
	 * @throws Exception
	 * @author Raghav
	 */

	public boolean isCourseToolsDisplayed(String toolname) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFIYING COURSE HOME TOOL PRESENT OR NOT");
			frameSwitch.selectTopFrame();
			mnucoursetools.replaceValues(toolname);
			if (mnucoursetools.isDisplayed()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN EXECUTING THE METHOD 'isCourseToolsDisplayed' \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method gets the Page Title of Coursetools
	 * 
	 * @author Raghav
	 * @return String - title
	 * @throws Exception
	 */
	public String getCourseNavigatedPageTitle() throws Exception {
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE PAGE TITLE FOR COURSE TOOLS");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblcoursetooltitle, waitTime);
			strResult = lblcoursetooltitle.getText().trim();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING COURSE TOOLS PAGE TITLE 'getCourseNavigatedPageTitle' \n" + e.getLocalizedMessage());
		}
		return strResult;

	}

	/**
	 * This method will check the is tool displayed. @ kiran kumar
	 * 
	 * @author Raghav
	 * @return boolean
	 * @param String
	 *            - toolname
	 * @throws Exception
	 */
	public boolean isDisabledCourseToolsDisplayed(String toolname)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFIYING COURSE HOME TOOL PRESENT OR NOT");
			frameSwitch.selectTopFrame();
			mnucoursetools.replaceValues(toolname);
			if (mnucoursetools.isDisplayed()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CHECKING WHETHER THE TOOL IS DISPLAYED OR NOT 'isDisabledCourseToolsDisplayed' \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will give the course title
	 * 
	 * @return String
	 * @throws Exception
	 * @author Raghav.S
	 */
	public String getCourseTitle() throws Exception {
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING COURSE TITLE");
			frameSwitch.selectTopFrame();
			uiDriver.waitToBeDisplayed(lblcoursetitle, waitTime);
			strResult = lblcoursetitle.getText().trim();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE COURSE TITLe \n METHOD :getCourseTitle"
							+ e.getLocalizedMessage());
		}
		return strResult;
	}

	/**
	 * This Method will give the instructor
	 * 
	 * 
	 * @return String
	 * @throws Exception
	 * @author Raghav.S
	 */
	public String getInstructor() throws Exception {
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING INSTRUCTOR DATA");
			frameSwitch.selectTopFrame();
			uiDriver.waitToBeDisplayed(radinstructor, waitTime);
			strResult = radinstructor.getText().trim();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE INSTRUCTOR \n METHOD : getInstructor" + e.getLocalizedMessage());
		}
		return strResult;
	}

	/**
	 * This Method will verify whether CourseAdmin Subsystem is displayed or not
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */

	public boolean isCourseAdminDisplayed() throws Exception {
		flag = false;
		try {
			uiDriver.waitToBeDisplayed(mnucourseAdminTool, waitTime);
			if (mnucourseAdminTool.isDisplayed())
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: UNABLE TO GET THE COURSE ADMIN \n METHOD :isCourseAdminDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * his Method will verify whether Gradebook Subsystem is displayed or not
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isGradeBookDisplayed() throws Exception {
		flag = false;
		try {
			uiDriver.waitToBeDisplayed(mnugradeBookTool, waitTime);
			if (mnugradeBookTool.isDisplayed())
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: UNABLE TO GET THE GRADEBOOK \n METHOD :isGradeBookDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will verify whether Email Subsystem is displayed or not
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isEmailDisplayed() throws Exception {
		flag = false;
		try {
			uiDriver.waitToBeDisplayed(mnuemailTool, waitTime);
			if (mnuemailTool.isDisplayed())
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: UNABLE TO GET THE EMAIL \n METHOD : isEmailDisplayed"
							+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * This Method will verify whether Document Sharing Subsystem is displayed
	 * or not
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isDocumentSharingDisplayed() throws Exception {
		flag = false;
		try {
			uiDriver.waitToBeDisplayed(mnudocSharingTool, waitTime);
			if (mnudocSharingTool.isDisplayed())
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: UNABLE TO GET THE DOC SHARING \n METHOD :isDocumentSharingDisplayed"
							+ e.getLocalizedMessage());

		}
		return flag;

	}

	/**
	 * This Method will verify whether Webliography Subsystem is displayed or
	 * not
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */

	public boolean isWebliographyDisplayed() throws Exception {
		flag = false;
		try {
			uiDriver.waitToBeDisplayed(mnuwebliographyToolMenu, waitTime);
			if (mnuwebliographyToolMenu.isDisplayed())
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: UNABLE TO GET THE WEBLIOGRAPHY \n METHOD :isWebliographyDisplayed"
							+ e.getLocalizedMessage());

		}
		return flag;

	}

	/**
	 * This Method will verify whether journal Subsystem is displayed or not
	 * 
	 * @author Shishir.Dwivedi
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isJournalDisplayed() throws Exception {
		flag = false;
		try {
			uiDriver.waitToBeDisplayed(mnujournalToolMenu, waitTime);
			if (mnujournalToolMenu.isDisplayed())
				flag = true;

		} catch (Exception e) {
			throw new Exception("UNABLE TO GET THE JOURNAL \n METHOD :isJournalDisplayed"
					+ e.getLocalizedMessage());
		}
		return flag;
	}
}
