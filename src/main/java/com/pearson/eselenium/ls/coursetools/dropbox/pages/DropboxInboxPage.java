package com.pearson.eselenium.ls.coursetools.dropbox.pages;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.AddRemoveAttachmentsPage;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods of Assignment Page. Navigation --> 1) Login as
 * Prof/Admin 2) Select Course 3) Click 'Dropbox' 4) Click 'Baskets' Tab 5)
 * Click Student Name in 'Inbox' section.
 * 
 * @author Chaitali
 * @modifiedBy Vivek.Singh -- as per code review comments by Lanka Pearson
 * **/
public class DropboxInboxPage extends BasePageObject {

	/* UIElements */
	private UIElement lnkAddRemove = createElement(UIType.Xpath,
			"//a[contains(.,'Add/Remove')]");
	private UIElement btnSaveAndClose = createElement(UIType.Css,
			"#SaveAndClose");
	private UIElement btnCanel = createElement(UIType.Css,
			"input[value='Cancel']");
	private UIElement txtPageTitle = createElement(UIType.Css, ".tablehead");
	private UIElement lblAttachedFiles = createElement(UIType.Xpath,
			"//a[@href[contains(.,'DownloadAttachment')]][contains(.,'{1}')]");
	private String RadToolId = "RadeEntryText";
	private String frameId = "RadeEntryText_contentIframe";
	private VisualEditor DropBoxRadEditor = new VisualEditor(uiDriver,
			RadToolId, frameId, RadToolId);
	private UIElement lnkEditorSwitch= createElement(UIType.Css, "#telerikRAD");
    
	private boolean flag = false;

	/* Constructor */
	public DropboxInboxPage(UIDriver uiDriver) {
		super(uiDriver);
		pageTitle = "Dropbox Inbox";
		logInstruction("## DropboxInboxPage ##");
	}

	public VisualEditor getDropBoxRadEditor() {
		return DropBoxRadEditor;
	}

	/**
	 * This method clicks on the link 'Add/Remove'. Navigates to
	 * {@link AddRemoveAttachmentsPage}.
	 * 
	 * @return {@link AddRemoveAttachmentsPage}
	 * @author Chaitali.Barhate
	 * @throws Exception
	 * @category Milestone 2
	 */
	public AddRemoveAttachmentsPage clickAddOrRemoveAttachmentsLink()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION : CLICK ON THE 'Add/Remove' LINK");
			frameSwitch.switchToNewWindowBottomFrame();
			if (!lnkAddRemove.isDisplayedAfterWaiting(waitTime)) {
				throw new Exception(
						"'AddOrRemove Attachments Link' DOES NOT EXISTS");
			}
			if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				lnkAddRemove.clickByJavascript();
				uiDriver.sleep(waitTime, "ClickAndWait is hanging");
			} else
				lnkAddRemove.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON THE 'Add/Remove' LINK. \nMETHOD: clickAddOrRemoveAttachmentsLink.\n"
							+ e.getLocalizedMessage());
		}
		return new AddRemoveAttachmentsPage(uiDriver, this);
	}

	/**
	 * This method clicks on 'Save And Close' button.
	 * 
	 * @return {@link BasketHomePage}
	 * @author Chaitali.Barhate
	 * @throws Exception
	 * @category Milestone 2
	 */
	public BasketHomePage clickSaveAndCloseButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION : CLICKING ON 'Save And Close' BUTTON");
			frameSwitch.switchToNewWindowBottomFrame();
			uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
				btnSaveAndClose.clickAndWait(waitTime);
				uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON THE 'Save And Close' BUTTON. \nMETHOD: clickSaveAndCloseButton.\n"
							+ e.getLocalizedMessage());
		}
		return new BasketHomePage(uiDriver);
	}

	/**
	 * This method clicks on 'Cancel' button. Navigates to
	 * {@link BasketHomePage}.
	 * 
	 * @return {@link BasketHomePage}
	 * @author Chaitali.Barhate
	 * @throws Exception
	 * @category Milestone 2
	 */
	public BasketHomePage clickCancelButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION : CLICKING ON 'Cancel' BUTTON");
			frameSwitch.switchToNewWindowBottomFrame();
			uiDriver.waitToBeDisplayed(btnCanel, waitTime);
			if (Browser.INTERNETEXPLORER.equals(getBrowser())) {
				btnCanel.clickByJavascript();
				uiDriver.sleep(waitTime, "ClickAndWait is hanging");
			} else
				btnCanel.clickAndWait(waitTime);
			uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON THE 'Cancel' BUTTON. \nMETHOD: clickCancelButton.\n"
							+ e.getLocalizedMessage());
		}
		return new BasketHomePage(uiDriver);
	}

	/**
	 * This method checks whether the Attached file(s) is listed or not.
	 * 
	 * @author Chaitali.Barhate
	 * @param String
	 *            fileName
	 * @return boolean
	 * @throws Exception
	 * @category Milestone 2
	 * **/
	public boolean isAttachedFileDisplayed(String strFileName) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION : CHECKING FOR NEWLY ATTACHED FILE.");
			frameSwitch.switchToNewWindowBottomFrame();
			if (StringUtils.isNotBlank(strFileName)) {
				lblAttachedFiles.replaceValues(strFileName);
				flag = lblAttachedFiles.isDisplayedAfterWaiting(waitTime);
			} else {
				throw new Exception(
						"FILE(s) IS NULL. \nMETHOD: isAttachedFileDisplayed.\n");
			}
		} catch (Exception e) {
			throw new Exception(
					"FILE(s) NOT ATTACHED. \nMETHOD: isAttachedFileDisplayed.\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method Verify Title of DropboxInboxPage.
	 * 
	 * @return DropboxPage
	 * @author Bharat.Goel
	 * @throws Exception
	 */
	public boolean isPageTitleDisplayed(String strName) throws Exception {
		flag = false;
		try {
			if (StringUtils.isNotBlank(strName)) {
				logInstruction("LOG INSTRUCTION : VERIFYING 'Title' OF PAGE.");
				frameSwitch.switchToNewWindowTopFrame();
				flag = txtPageTitle.getText().contains(strName);
			} else
				throw new Exception(
						"FILE(s) IS NULL. \nMETHOD: isPageTitleDisplayed.\n");
		} catch (Exception e) {
			throw new Exception(
					"Cannot find page 'Title'. \nMETHOD: isPageTitleDisplayed.\n"
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
                    "ISSUE IN VERIFYING ALTERNATIVE EDITOR SWITCH OPTION." + "\n METHOD : isEditorSwitchDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

	}
}
