package com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages;

import org.apache.commons.lang.StringUtils;

import com.pearson.eselenium.ls.common.pages.AddRemoveAttachmentsPage;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all the methods related to Add Topic page
 * 
 * @author ganapati.bhat
 * 
 */

public class AddTopicPage extends BasePageObject {

	/* Elements */
	private UIElement lnkEditorSwitch = createElement(UIType.Css, "#telerikRAD");
	private UIElement txtTopicTitle = createElement(UIType.Css,
			"input#topicTitle");
	private UIElement btnAddTopic = createElement(UIType.ID, "btnAdd");
	private UIElement lblAddTopicPageTitle = createElement(UIType.Css,
			".tablehead");
	private UIElement btnCancel = createElement(UIType.Css, "#btncancel");
	private UIElement lnkAttachedFile = createElement(UIType.Xpath,
			"//a[@name='downloadAttachment'][contains(text(),'{1}')]");
	private UIElement lnkAddRemoveAttachments = createElement(UIType.Xpath,
			"//a[contains(.,'Add/Remove')]");

	/* Variables */
	private static final String strAddTopicRadToolId = "RadeEntryText";
	private static final String strAddTopicRadFrameId = "RadeEntryText_contentIframe";
	private static final String ADD_TOPIC = "Add Topic";
	private UIElement txterrormessage = createElement(UIType.Xpath,
			"//td[@class='inlineerror']//tbody/tr/td[2]");
	private String strErrorMsg = null;
	private String strResult = null;
	boolean flag = false;

	/* Objects */
	private VisualEditor objAddTopic = new VisualEditor(uiDriver,
			strAddTopicRadToolId, strAddTopicRadFrameId, strAddTopicRadToolId);

	/* Constructor */
	public AddTopicPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ## Add Topic Page ##");
	}

	/***
	 * Method helps to get add Topic RadEditor Instance
	 * 
	 * @return VisualEditor
	 * @throws Exception
	 */

	public VisualEditor getaddTopicRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return objAddTopic;
	}

	/**
	 * @author ganapati.bhat Method helps to Enter the topic title
	 * @param strTopicTitle
	 * @return AddTopicPage
	 * @throws Exception
	 */
	public ThreadHomePage addTopic(String strTitle, String strContent)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION : ADD TOPIC ");
			frameSwitch.switchToFrameContent();

			if (StringUtils.isNotBlank(strTitle)
					&& StringUtils.isNotBlank(strContent)) {
				logInstruction("LOG INSTRUCTION : ENTER TITLE");
				if (!txtTopicTitle.isDisplayedAfterWaiting(waitTime)) {
					throw new Exception("'Topic Title' DOES NOT EXISTS");
				}
				txtTopicTitle.clearAndSendKeys(strTitle);

				logInstruction("LOG INSTRUCTION : ENTER TEXT");
				getaddTopicRadEditor().enterText(strContent);

				frameSwitch.switchToFrameContent();

				logInstruction("LOG INSTRUCTION : CLICK ADD TOPIC BUTTON");
				if (!btnAddTopic.isDisplayedAfterWaiting(waitTime)) {
					throw new Exception("'Add Topic Button' DOES NOT EXISTS");
				}
				btnAddTopic.clickAndWait(waitTime);
			}
		} catch (Exception e) {
			throw new Exception("UNABLE TO ADD TOPIC"
					+ " \n METHOD : addTopic \n" + e.getLocalizedMessage());
		}

		return new ThreadHomePage(uiDriver);
	}

	/**
	 * @author ganapati.bhat Method helps to click on the Add topic button
	 * @return Object
	 * @throws Exception
	 */
	public Object clickAddTopic() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE ADD TOPIC BUTTON");
			frameSwitch.switchToFrameContent();
			if (!btnAddTopic.isDisplayedAfterWaiting(waitTime)) {
				throw new Exception("'Add Topic Button' DOES NOT EXISTS");
			}
			btnAddTopic.clickAndWait(waitTime);
			if (strErrorMsg == null) {
				return new ThreadHomePage(uiDriver);
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING THE 'Add Topic Button' \n METHOD: clickAddTopic \n"
							+ e.getLocalizedMessage());
		}
		return new AddTopicPage(uiDriver);
	}

	/**
	 * @author ganapati.bhat Method helps to verify the addTopic page
	 * @return boolean
	 * @throws Exception
	 */
	public boolean VerifyAddTopicTitle() throws Exception {
		flag = false;
		try {
			frameSwitch.switchToFrameContent();
			logInstruction("LOG INSTRUCTION: VERIFY THE ADD TOPIC PAGE TITLE");
			strResult = lblAddTopicPageTitle.getText().trim();
			if (ADD_TOPIC.contains(strResult)) {
				logInstruction("LOG INSTRUCTION: PAGE TITLE CONTAINS ADD TOPIC");
				flag = true;
			} else {
				logInstruction("LOG INSTRUCTION: PAGE TITLE IS NOT ADD TOPIC");
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING 'AddTopic Title' \n METHOD: VerifyAddTopicTitle \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * To get Add Topic Page Title
	 * 
	 * @author Vivek.Singh
	 * @return String
	 * @throws Exception
	 */
	public String getHeaderTitle() throws Exception {
		strResult = null;
		try {
			frameSwitch.switchToFrameContent();
			logInstruction("LOG INSTRUCTION: ADD TOPIC PAGE TITLE");
			strResult = lblAddTopicPageTitle.getText().trim();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING 'AddTopic Title' \n METHOD: getHeaderTitle \n"
							+ e.getLocalizedMessage());
		}
		return strResult;
	}

	/**
	 * methods helps to click on attached file on Add/Remove attachments page
	 * 
	 * @author Chaitali.Barhate
	 * @return void
	 * @param String
	 * @throws Exception
	 * @category Milestone 2
	 */
	public void clickAttachedFile(String strFileName) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION : CLICKING ON ATTACHED FILE");
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strFileName)) {
				lnkAttachedFile.replaceValues(strFileName);

				if (!lnkAttachedFile.isDisplayedAfterWaiting(waitTime)) {
					throw new Exception("'Attached File' DOES NOT EXISTS");
				}
				lnkAttachedFile.clickAndWait(waitTime);
			} else {
				logInstruction("LOG INSTRUCTION: PROVIDED FILE NAME IS NULL");
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING ON 'Attached File' \n METHOD: clickAttachedFile \n"
							+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method clicks on the link AddOrRemoveAttachment
	 * 
	 * @return AddRemoveAttachmentsPage
	 * @author Chaitali.Barhate
	 * @throws Exception
	 */
	public AddRemoveAttachmentsPage clickAddOrRemoveAttachmentsLink()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION : CLICK ON THE ADDORREMOVEATTACHMENT LINK");
			frameSwitch.switchToFrameContent();

			if (!lnkAddRemoveAttachments.isDisplayedAfterWaiting(waitTime)) {
				throw new Exception(
						"'AddOrRemove Attachments Link' DOES NOT EXISTS");
			}
			if ("INTERNETEXPLORER".equalsIgnoreCase(System
					.getProperty("browser.NAME"))) {
				lnkAddRemoveAttachments.clickByJavascript();
				Thread.sleep(waitTime);
			} else
				lnkAddRemoveAttachments.clickAndWait(waitTime);
			uiDriver.getUIWindowLocator().switchToNewWindow();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING ON 'AddOrRemove Attachments Link' \n METHOD: clickAddOrRemoveAttachmentsLink \n"
							+ e.getLocalizedMessage());
		}
		return new AddRemoveAttachmentsPage(uiDriver, this);
	}

	/**
	 * Method helps to check whether the attached file exists
	 * 
	 * @author Sumanth SV
	 * @category Milestone-2
	 * @param String
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean isAttachedFileExists(String strFileName) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECK FOR EXISTANCE OF ATTACHED FILE");
			frameSwitch.switchToFrameContent();

			lnkAttachedFile.replaceValues(strFileName);

			flag = lnkAttachedFile.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING THE 'Existence of Attached File' \n METHOD:  isAttachedFileExists \n"
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
		logInstruction("LOG INSTRUCTION: ALTERNATIVE EDITOR PRESENT OR NOT...");
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
	 * Method helps to verify rad editor.
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isRadEditorDisplayed() throws Exception {
		flag = false;
		logInstruction("LOG INSTRUCTION: RAD EDITOR IS DISPLAYED OR NOT.");
		try {
			if (objAddTopic != null) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER RAD EDITOR IS DISPLAYED OR NOT."
							+ "\n METHOD : isRadEditorDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method helps to get the error message when the add item button
	 * pressed without entering the title
	 * 
	 * @author Suchi.Singh
	 * @return String
	 * @throws Exception
	 */
	public String getErrorMessage() throws Exception {
		strResult = null;
		try {
			frameSwitch.switchToFrameContent();
			if (txterrormessage.isDisplayedAfterWaiting()) {
				strResult = txterrormessage.getText();
			} else {
				strResult = null;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE 'Error' MESSAGE"
					+ "\n METHOD:getErrorMessage\n" + e.getLocalizedMessage());
		}
		return strResult;

	}

	/**
	 * This method will click the Cancel button on Add Topic Page
	 * 
	 * @author Shishir
	 * @return ThreadHomePage
	 * @throws Exception
	 */
	public ThreadHomePage clickCancel() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE CANCEL BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnCancel, waitTime);
			btnCancel.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING THE 'Cancel Button' \n METHOD: clickCancel \n"
							+ e.getLocalizedMessage());
		}
		return new ThreadHomePage(uiDriver);
	}

	/**
	 * @author ganapati.bhat Method helps to Enter the topic title
	 * @param String
	 *            strTopicTitle
	 * @return AddTopicPage
	 * @throws Exception
	 */
	public AddTopicPage enterTopicTitle(String strTopicTitle) throws Exception {
		logInstruction("LOG INSTRUCTION: ENTER THE TOPIC TITLE");
		try {
			frameSwitch.switchToFrameContent();
			if (!txtTopicTitle.isDisplayedAfterWaiting(waitTime)) {
				throw new Exception("'Topic Title' DOES NOT EXISTS");
			}
			txtTopicTitle.clearAndSendKeys(strTopicTitle);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN ENTERING THE 'Topic Title' \n METHOD: enterTopicTitle \n"
							+ e.getLocalizedMessage());
		}

		return new AddTopicPage(uiDriver);
	}

}
