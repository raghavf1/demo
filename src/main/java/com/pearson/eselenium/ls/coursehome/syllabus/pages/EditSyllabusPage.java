package com.pearson.eselenium.ls.coursehome.syllabus.pages;

import org.openqa.selenium.Keys;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.PlainTextEditor;
import com.pearson.eselenium.ls.common.pages.RadEditorSwitchPlainOrVisual;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all the methods related to Edit Syllabus page
 * 
 * @author monica.anand
 * 
 */

public class EditSyllabusPage extends BasePageObject {

	public EditSyllabusPage(UIDriver uidriver) {
		super(uidriver);
		logInstruction("LOG INSTRUCTION: ## Edit Syllabus Page ##");

	}

	private String radFrameid = "RadeEntryText_contentIframe";
	private String radToolId = "RadeEntryText";
	private UIElement btnSaveChanges = createElement(UIType.Css, "#saveButton");
	private UIElement btnCancel = createElement(UIType.Css, "#cancelButton");
	private UIElement txtTitle = createElement(UIType.Css, "#Title");
	private UIElement divTableHead = createElement(UIType.Css, ".tablehead");
	private UIElement areaRadeEditorContent = createElement(UIType.Xpath,
			"//html/body");
	private UIElement lblSymbol = createElement(UIType.Xpath,
			"//tr[@role='section']//span[@class='redtext']");
	private UIElement lblMandatoryField = createElement(UIType.Xpath,
			"//input[@id='saveButton']/parent::td/preceding-sibling::td");
	private UIElement msgError = createElement(UIType.Xpath,
			"//td[@class='inlineerror']//td");
	private UIElement msgTool = createElement(UIType.Css,
			"table:nth-child(2)>tbody>tr:nth-child(1)>td");
	private UIElement lblLabel = createElement(UIType.Xpath,
			"//label[contains(.,'{1}')]");
	private UIElement btnBrowse = createElement(UIType.Xpath,
			"//input[@name='FileName']");
	private UIElement btnDownloadCopy = createElement(UIType.Xpath,
			"//input[@value='Download Copy']");
	private UIElement btnUploadFile = createElement(UIType.Xpath,
			"//input[@id='btnUpload']");
	private UIElement txterrormessage = createElement(UIType.Xpath,
			"//td[@class='inlineerror']//tbody/tr/td[2]");
	private UIElement MsgErrorTitle = createElement(UIType.Xpath,
			"//table//tr/td/table[1]//tr/td[2]/table//tr/td[2]");

	PlainTextEditor plainEditor = new PlainTextEditor(uiDriver);

	private String visualEditorLink = "RadeEntryText_visualEditor";
	private String plainTextEditorLink = "RadeEntryText_simpleEditor";
	boolean flag = false;
	private String errorMsg = null;
	private RadEditorSwitchPlainOrVisual radSwitch = new RadEditorSwitchPlainOrVisual(
			uiDriver, visualEditorLink, plainTextEditorLink);
	private VisualEditor visualEditor = new VisualEditor(uiDriver, radToolId,
			radFrameid, radToolId);

	public VisualEditor getVisualEditor() {
		return visualEditor;
	}

	public PlainTextEditor getPlainTextEditor() {
		return plainEditor;
	}

	public RadEditorSwitchPlainOrVisual getRadSwitch() {
		return radSwitch;
	}

	/**
	 * This method is used to enter the title
	 * 
	 * @author Soundarya
	 * @param description
	 * @return AddSyllabusPage
	 * @throws Exception
	 */
	public String getErrorTitle() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: DONT ENTER TITLE GET ERROR MESSAGE ");
			frameSwitch.switchToFrameContent();
			if (MsgErrorTitle.isDisplayedAfterWaiting())
				errorMsg = MsgErrorTitle.getText().trim();

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN ENTERTING 'DONT ENTER TITLE GET ERROR MESSAGE'"
							+ "\n METHOD: enterTitle \n"
							+ e.getLocalizedMessage());
		}
		return errorMsg;
	}

	/**
	 * @author saurabh.jain1
	 * @return Object
	 * @throws Exception
	 *             Method for clicking on SaveChanges button.
	 */

	public Object clickSaveChangesButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: clicking on SaveChanges button");
			frameSwitch.switchToFrameContent();
			logInstruction("LOG INSTRUCTION: Click On SaveChanges Button");
			uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
			btnSaveChanges.click();
			if (getErrorMessage() == null) {
				return new SyllabusHomePage(uiDriver);
			}
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING 'Save Changes Button'"
							+ "\n METHOD: clickSaveChangesButton \n"
							+ e.getLocalizedMessage());
		}
		return new EditSyllabusPage(uiDriver);
	}

	/**
	 * @author saurabh.jain1
	 * @return SyllabusHomePage
	 * @throws Exception
	 *             Method for clicking on cancel button.
	 */
	public SyllabusHomePage clickCancelButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: clicking on Cancel button");
			frameSwitch.switchToFrameContent();
			logInstruction("LOG INSTRUCTION: Click On Cancel Button");
			uiDriver.waitToBeDisplayed(btnCancel, waitTime);
			btnCancel.click();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING 'Cancel Button'"
							+ "\n METHOD: clickCancelButton \n"
							+ e.getLocalizedMessage());
		}
		return new SyllabusHomePage(uiDriver);
	}

	/**
	 * @author saurabh.jain1
	 * @return String - header
	 * @throws Exception
	 *             Method for verify the header title on edit syllabus page.
	 */

	public String getHeaderTitle() throws Exception {
		String header;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING HEADER TITLE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(divTableHead, waitTime);
			header = divTableHead.getText();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Header Title'"
							+ "\n METHOD: getHeaderTitle \n"
							+ e.getLocalizedMessage());
		}
		return header;
	}

	/**
	 * @author saurabh.jain1
	 * @return boolean
	 * @param nameoftitle
	 * @throws Exception
	 *             Method for verify the header title on edit syllabus page.
	 */

	public boolean isHeaderTitleDisplayed(String nameoftitle) throws Exception {
		String header;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING HEADER TITLE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(divTableHead, waitTime);
			header = divTableHead.getText();
			if (header.equalsIgnoreCase(nameoftitle)) {
				flag = true;
			}
			return flag;
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CHECKING 'Header Title Displayed'"
							+ "\n METHOD: isHeaderTitleDisplayed \n"
							+ e.getLocalizedMessage());
		}
	}

	/**
	 * @author saurabh.jain1
	 * @return String - title content
	 * @throws Exception
	 *             Method for verifying title content.
	 */
	public String getTitleContent() throws Exception {
		String contentTitle;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING TITLE CONTENT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtTitle, waitTime);
			contentTitle = txtTitle.getAttribute("value");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Title Content'"
							+ "\n METHOD: getTitleContent \n"
							+ e.getLocalizedMessage());
		}
		return contentTitle;
	}

	/**
	 * To get Radeditor content
	 * 
	 * @return String - Radeditorcontent
	 * @throws Exception
	 * @author - Ganapati.Bhat
	 */
	public String getRadeEditorContent() throws Exception {
		String editorContent;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING RADE EDITOR CONTENT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(areaRadeEditorContent, waitTime);
			editorContent = areaRadeEditorContent.getText();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Rade Editor Content'"
							+ "\n METHOD: getRadeEditorContent \n"
							+ e.getLocalizedMessage());
		}
		return editorContent;
	}

	/**
	 * To get Mandatory message
	 * 
	 * @return String - mandatory message
	 * @throws Exception
	 * @author - Ganapati.Bhat
	 */
	public String getMandatoryMessage() throws Exception {
		String mandatory;
		try {
			logInstruction("LOG INSTRUCTION:GET MANDATORY MESSAGE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblMandatoryField, waitTime);
			mandatory = lblMandatoryField.getText();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Mandatory Message'"
							+ "\n METHOD: getMandatoryMessage \n"
							+ e.getLocalizedMessage());
		}
		return mandatory;
	}

	/**
	 * This method is used to check if the label title is displayed
	 * 
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isLabelTitleDisplayed() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: Inside is Label Title Displayed method ");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtTitle, waitTime);
			if (txtTitle.isDisplayed())
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CHECKING 'Label Title Displayed'"
							+ "\n METHOD: isLabelTitleDisplayed \n"
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

		try {
			logInstruction("LOG INSTRUCTION: INSIDE IS MANDATORY FIELD TEXT INFO DISPLAYED METHOD ");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblMandatoryField, waitTime);
			if (lblMandatoryField.isDisplayed())
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CHECKING 'Mandatory Field Text Info Displayed'"
							+ "\n METHOD: isMandatoryFieldTextInfoDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to check if the mandatory field symbol is displayed
	 * 
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isMandatoryFieldSymbolDisplayed() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: INSIDE IS MANDATORY FIELD SYMBOL DISPLAYED METHOD ");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblSymbol, waitTime);
			if (lblSymbol.isDisplayed())
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CHECKING 'Mandatory Field Symbol Displayed'"
							+ "\n METHOD: isMandatoryFieldSymbolDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This methods checks whether the save changes button is displayed
	 * 
	 * @return boolean
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public boolean issaveButtonDisplayed() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CHECKING THE SAVE CHANGES BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
			flag = btnSaveChanges.isDisplayed();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CHECKING 'save Button Displayed'"
							+ "\n METHOD: issaveButtonDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This methods checks whether the cancel button is displayed
	 * 
	 * @return boolean
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public boolean iscancelButtonDisplayed() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CHECKING THE SAVE CHANGES BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnCancel, waitTime);
			flag = btnCancel.isDisplayed();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CHECKING 'cancel Button Displayed'"
							+ "\n METHOD: iscancelButtonDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This methods Add the title
	 * 
	 * @return EditSyllabusPage
	 * @param String
	 *            - description
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public EditSyllabusPage enterTitle(String description) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: INSIDE ENTER TITLE METHOD");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtTitle, waitTime);
			txtTitle.clearAndSendKeys(description);

		} catch (Exception e) {
			throw new Exception("LOG INSTRUCTION: ISSUE IN ENTERING 'Title'"
					+ "\n METHOD: enterTitle \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * To clear title text box
	 * 
	 * @return EditSyllabusPage
	 * @throws Exception
	 * @author Kapil
	 */
	public EditSyllabusPage clearTitleTextBox() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: INSIDE ENTER TITLE METHOD");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtTitle, waitTime);
			txtTitle.sendKeys(Keys.CONTROL + "a");
			txtTitle.sendKeys(Keys.DELETE);

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLEARING 'Title Text Box'"
							+ "\n METHOD: clearTitleTextBox \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This methods checks for the error tooltip message displayed when the user
	 * does not enters the title field and click on save changes button
	 * 
	 * @author ashish.juyal
	 * @return boolean
	 * @throws Exception
	 */
	public String getErrorMessageDisplayed(String nameoferror) throws Exception {
		String msg = null;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR THE ERROR MESSAGE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(msgError, waitTime);
			msg = msgError.getText();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Error Message Displayed'"
							+ "\n METHOD: getErrorMessageDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return msg;
	}

	/**
	 * This method helps to verify the tool message in the edit instructor page
	 * 
	 * @return String - message
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public String getToolMessageDisplayed() throws Exception {
		String text = null;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING THE TOOL MESSAGE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(msgTool, waitTime);
			text = msgTool.getText();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Tool Message Displayed'"
							+ "\n METHOD: getToolMessageDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return text;
	}

	/**
	 * This method checks whether the download copy button exits or not
	 * 
	 * @return boolean
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public boolean isDownloadCopButtondisplayed() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: SEARCHING FOR THE DOWNLOAD COPY BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnDownloadCopy, waitTime);
			flag = btnDownloadCopy.isDisplayed();
		} catch (Exception e) {
			throw new Exception("unable to display the downloadcopybutton"
					+ e.getLocalizedMessage());

		}
		return flag;
	}

	/**
	 * This method gets the title value from the textbox
	 * 
	 * @return String - titlevalue
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public String getTitleValue() throws Exception {
		String text = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE TITLE INFORMATION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtTitle, waitTime);
			text = txtTitle.getAttribute("value");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Title Value'"
							+ "\n METHOD: getTitleValue \n"
							+ e.getLocalizedMessage());
		}
		return text;
	}

	/**
	 * Verify the label is present or not
	 * 
	 * @return boolean
	 * @param message
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public boolean islabelPresent(String message) throws Exception {

		String text = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE LABEL");
			frameSwitch.switchToFrameContent();
			lblLabel.replaceValues(message);
			uiDriver.waitToBeDisplayed(lblLabel, waitTime);
			text = lblLabel.getText();
			if (text.equalsIgnoreCase(message)) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CHECKING 'label Present'"
							+ "\n METHOD: islabelPresent \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method helps to click the download copy button
	 * 
	 * @return EditSyllabusPage
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public EditSyllabusPage clickDownloadcopyButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING THE DOWNLOAD COPY BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnDownloadCopy, waitTime);
			btnDownloadCopy.click();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING ON 'Download copy Button'"
							+ "\n METHOD: clickDownloadcopyButton \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to click the browse button
	 * 
	 * @return EditSyllabusPage
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public EditSyllabusPage clickBrowseButton() throws Exception {
		try {
			// String browser =
			// config.getValue(ConfigKeys.KEY_BROWSER.getKey());

			String browser = System.getProperty("browser.NAME");
			logInstruction("LOG INSTRUCTION: CLICKING THE BROWSE BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
			if (browser.equalsIgnoreCase("CHROME")) {
				btnBrowse.click();
			} else if (browser.equalsIgnoreCase("FIREFOX")) {
				btnBrowse.clickByJavascript();
			}
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING ON 'clickBrowseButton'"
							+ "\n METHOD: clickBrowseButton \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * method help to click Browse Button For IE Browser
	 * 
	 * @author Soundarya
	 * @return UploadSyllabusPage
	 * @throws Exception
	 */
	public EditSyllabusPage clickBrowseButton(String absoluteFilePath)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING THE BROWSE BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
			btnBrowse.sendKeysToFileInput(absoluteFilePath);
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING ON'Browse Button'"
							+ "\n METHOD: clickBrowseButton \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to click upload and conver file
	 * 
	 * @return SyllabusHomePage
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public SyllabusHomePage clickUploadFileButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING THE UPLOAD FILE BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnUploadFile, waitTime);
			btnUploadFile.click();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING ON'Upload File Button'"
							+ "\n METHOD: clickUploadFileButton \n"
							+ e.getLocalizedMessage());
		}

		return new SyllabusHomePage(uiDriver);
	}

/*
     * This method helps to get the error message when the add item buttoni pressed withouth
     * enetering the title
     * 
     * @author:suchi.singh
     * 
     * @return:String
     */
    public String getErrorMessage() throws Exception {

        try {
            frameSwitch.switchToFrameContent();
            if(txterrormessage.isDisplayedAfterWaiting())
            {
            errorMsg = txterrormessage.getText();
            }
            else
            {
            	errorMsg=null;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'Error' MESSAGE" + "\n METHOD:getErrorMessage\n" + e
                            .getLocalizedMessage());
        }
        return errorMsg;
    }
}
