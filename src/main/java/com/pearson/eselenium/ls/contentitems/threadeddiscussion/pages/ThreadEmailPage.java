package com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.eselenium.ls.coursehome.filemanager.pages.UploadFilesPage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * It contains methods related to Thread Email Page.
 * 
 * @author Praveen.Maled
 * @date Dec 31, 2013
 */
public class ThreadEmailPage extends BasePageObject {

	/* Elements */
	private UIElement lblHeaderTitle = createElement(UIType.Css,
			"div.pageTitle>h1");
	private UIElement btnSendMessage = createElement(UIType.Xpath,
			"//table[@class='outercontenttable']//input[@value='Send Message']");
	private UIElement btnCancel = createElement(UIType.Xpath,
			"//table[@class='outercontenttable']//input[@value='Cancel']");
	private UIElement areaRadEditor = createElement(UIType.ID,
			"RadeEntryText_contentIframe");
	private UIElement lnkAddRemove = createElement(UIType.Xpath,
			"//form[@id='respondToAuthorView']//a[contains(.,'Add/Remove')]");
	private static final String threadEmailRadEditorToolId = "RadeEntryText";
	private static final String threadEmailRadEditorFrameId = "RadeEntryText_contentIframe";
	private VisualEditor threadEmailRadEditor = new VisualEditor(uiDriver,
			threadEmailRadEditorToolId, threadEmailRadEditorFrameId,
			threadEmailRadEditorToolId);

	private String strResult = null;
	private boolean flag = false;

	/* Constructor */
	public ThreadEmailPage(UIDriver uiDriver) {
		super(uiDriver);
		pageTitle = "ThreadEmailPage";
		logInstruction("## Thread Email Page ##");
	}

	public VisualEditor getThreadEmailRadEditor() {
		return threadEmailRadEditor;
	}

	/**
	 * Method helps to get ThreadEmail page header name
	 * 
	 * @author Usha
	 * @return String - title
	 * @throws Exception
	 */
	public String getHeaderName() throws Exception {
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY THREADEMAIL 'Page Header'");
			frameSwitch.switchToFrameContent();
			strResult = lblHeaderTitle.getText();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THREADEMAIL 'Page Header'"
					+ "\nMETHOD:getHeaderName \n" + e.getLocalizedMessage());
		}
		return strResult;
	}

	/**
	 * Method helps to check RadEditorDisplayed or not for ThreadEmail Page
	 * 
	 * @return boolean
	 * @author usha.reddy
	 * @throws Exception
	 */

	public boolean isRadEditorDisplayedForThreadEmailPage() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECK IF THE 'Rad Editor' IS DISPLAYED FOR THREADEMAIL PAGE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(areaRadEditor, waitTime);
			flag = areaRadEditor.isDisplayedAfterWaiting();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING 'Rad Editor' IS DISPLAYED FOR THREADEMAIL PAGE"
							+ "\nMETHOD:isRadEditorDisplayedForThreadEmailPage \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to click on the SendMessage button
	 * 
	 * @author Usha
	 * @return ViewRespondTopicPage
	 * @throws Exception
	 */
	public ViewRespondTopicPage clickSendMessage() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE 'Send Message' BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnSendMessage, waitTime);
			btnSendMessage.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKIN ON THE 'Send Message' BUTTON"
					+ "\nMETHOD:clickSendMessage \n" + e.getLocalizedMessage());
		}

		return new ViewRespondTopicPage(uiDriver);
	}

	/**
	 * Method helps to click on the ExpandAll button
	 * 
	 * @author Usha
	 * @return void
	 * @throws Exception
	 */
	public void clickCancelButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE 'Cancel' BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnCancel, waitTime);
			btnCancel.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKIN ON THE 'Cancel' BUTTON"
					+ "\nMETHOD:clickCancelButton \n" + e.getLocalizedMessage());
		}
	}

	/**
	 * Method helps to check for AddRemove Link is displayed or not
	 * 
	 * @author Usha
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAddRemoveLinkDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECK FOR 'Add/Remove' LINK");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkAddRemove, waitTime);
			flag = lnkAddRemove.isDisplayedAfterWaiting();
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE  'Add/Remove' LINK"
					+ "\nMETHOD:isAddRemoveLinkDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to click on AddRemove Link
	 * 
	 * @author Usha
	 * @return UploadFilesPage
	 * @throws Exception
	 */
	public UploadFilesPage clickAddRemoveLink() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON THE 'Add/Remove' LINK");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkAddRemove, waitTime);
			btnCancel.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON THE  'Add/Remove' LINK"
					+ "\nMETHOD:clickAddRemoveLink \n"
					+ e.getLocalizedMessage());
		}
		return new UploadFilesPage(uiDriver);
	}

}
