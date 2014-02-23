package com.pearson.eselenium.ls.coursehome.syllabus.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.utils.AutoITMethods;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

public class UploadSyllabusPage extends BasePageObject {

	/**
	 * This class contains all the methods of Upload Syllabus Page.
	 * 
	 * @navigation On Syllabus page (in author view), select
	 *             "Upload Microsoft Word Syllabus (.doc)" checkbox and click
	 *             add button to get this page.
	 * **/

	/* Constructor */
	public UploadSyllabusPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ## Upload Syllabus Page ##");
	}

	/** UIElements **/
	private UIElement lblNote = createElement(UIType.Css, ".dkgraytext");
	private UIElement lblFindFile = createElement(UIType.Css,
			".innercontenttable>table>tbody>tr>td>label");
	private UIElement btnBrowse = createElement(UIType.Css, "#FileName");
	private UIElement lnkFormattingTips = createElement(UIType.Css,
			"Formatting Tips");
	private UIElement lblHeader = createElement(UIType.Css, ".tablehead");
	private UIElement lblMsgInfo = createElement(UIType.Css,
			".inlinemessage2 td:last-of-type");
	private UIElement btnUploadAndConvert = createElement(UIType.Css,
			"#btnUpload");
	private UIElement btnCancel = createElement(UIType.Css, "#btnCancel");
	private UIElement lblDescriptionFormattingTips = createElement(UIType.Css,
			".dkgraytext");
	private UIElement lblDescription = createElement(UIType.Css,
			".outercontenttable>tbody>tr>td>table:nth-of-type(2)>tbody>tr:first-of-type>td");
	private String descrptionFormattingTips = "";
	private String path = "";
	private String description = "";
	private String not;
	private boolean flag = false;
	private String message;
	String[] note;

	/**
	 * Method helps to get the Note
	 * 
	 * @author Soundarya
	 * @return string - notelabel
	 * @throws Exception
	 */
	public String getNote() throws Exception {
		logInstruction("LOG INSTRUCTION: GET THE NOTE LABEL");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblNote, waitTime);
			not = lblNote.getText();
			note = not
					.split("Note: This document will override any Syllabus items you added in the alternate view. ");

		} catch (Exception e) {
			throw new Exception("LOG INSTRUCTION: ISSUE IN GETTING 'Note' LINK"
					+ "\n getNote \n" + e.getLocalizedMessage());
		}
		logInstruction("LOG INSTRUCTION: SUCCESSFULLY GET THE NOTE ");
		return note[0];
	}

	/**
	 * Method helps to getLabelFindFile
	 * 
	 * @author Soundarya
	 * @return string - label
	 * @throws Exception
	 */
	public String getLabelFindFile() throws Exception {
		logInstruction("LOG INSTRUCTION: GET THE LABEL FOR FIND FILE");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblFindFile, waitTime);
			logInstruction("LOG INSTRUCTION: SUCCESSFULLY GET THE LABEL FOR FIND FILE");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Label Find File' LINK"
							+ "\n METHOD: getLabelFindFile \n"
							+ e.getLocalizedMessage());
		}
		return lblFindFile.getText();
	}

	/**
	 * method help to click Browse Button for Chrome and Firefox browser
	 * 
	 * @author Soundarya
	 * @return UploadSyllabusPage
	 * @throws Exception
	 */
	private UploadSyllabusPage clickBrowseButton() throws Exception {
		try {
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
					"LOG INSTRUCTION: ISSUE IN CLICKING ON 'Browse Button' LINK"
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
	private UploadSyllabusPage clickBrowseButton(String absoluteFilePath)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING THE BROWSE BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
			btnBrowse.sendKeysToFileInput(absoluteFilePath);
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING ON 'Browse Button' LINK"
							+ "\n METHOD: clickBrowseButton \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to clickFormattingTipsLink
	 * 
	 * @author Soundarya
	 * @return
	 * @throws Exception
	 */
	public void clickFormattingTipsLink() throws Exception {
		logInstruction("LOG INSTRUCTION: CLICK FORMATTING TIPS LINK");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkFormattingTips, waitTime);
			lnkFormattingTips.click();
			logInstruction("LOG INSTRUCTION: successfully clicked Formatting Tips Link");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING ON 'Formatting Tips Link' LINK"
							+ "\n METHOD: clickFormattingTipsLink \n"
							+ e.getLocalizedMessage());
		}
	}

	/**
	 * Method helps to check isBrowseButtonVisible
	 * 
	 * @author Soundarya
	 * @return boolean
	 * @throws Exception
	 */
	public Boolean isBrowseButtonVisible() throws Exception {
		logInstruction("LOG INSTRUCTION: IS BROWSE BUTTONVISIBLE");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
			flag = btnBrowse.isDisplayed();
			logInstruction("LOG INSTRUCTION: successfully find the Browse Button");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING ON 'Browse Button Visible' LINK"
							+ "\n METHOD: isBrowseButtonVisible \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method will return header title of Upload syllabus page.
	 * 
	 * @author Vivek.Singh
	 * @return String - header
	 * @throws Exception
	 * **/
	public String getHeaderTitle() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: GETTING HEADER TITLE.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblHeader, waitTime);
			message = lblHeader.getText();
			logInstruction("LOG INSTRUCTION: Got header title.");
			return message;
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING'Header Title' LINK"
							+ "\n METHOD: getHeaderTitle \n"
							+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method will return Info from Upload Syllabus Page.
	 * 
	 * @author Vivek.Singh
	 * @return String - info
	 * @throws Exception
	 * **/
	public String getInfo() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: GETTING INFO FROM UPLOAD SYLLABUS PAGE.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblMsgInfo, waitTime);
			message = lblMsgInfo.getText();
			logInstruction("LOG INSTRUCTION: GOT INFO FROM UPLOAD SYLLABUS PAGE.");
			return message;
		} catch (Exception e) {
			throw new Exception("LOG INSTRUCTION: ISSUE IN GETTING 'Info' LINK"
					+ "\n METHOD: getInfo \n" + e.getLocalizedMessage());
		}
	}

	/**
	 * Method helps to click UploadAndConvertFile button
	 * 
	 * @author Chaitali
	 * @return SyllabusHomePage
	 * @throws Exception
	 */
	public SyllabusHomePage clickUploadAndConvertFileButton() throws Exception {
		logInstruction("LOG INSTRUCTION: CLICK ON UPLOADANDCONVERTFILEBUTTON BUTTON");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnUploadAndConvert, waitTime);
			btnUploadAndConvert.click();
			logInstruction("LOG INSTRUCTION: UploadAndConvertFileButton clicked");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Upload And Convert File Button"
							+ "\n METHOD: clickUploadAndConvertFileButton \n"
							+ e.getLocalizedMessage());
		}
		return new SyllabusHomePage(uiDriver);
	}

	/**
	 * Method helps to get Description
	 * 
	 * @author Chaitali
	 * @return String - decription
	 * @throws Exception
	 */
	public String getDescription() throws Exception {
		logInstruction("LOG INSTRUCTION: GET DESCRIPTION");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblDescription, waitTime);
			description = lblDescription.getText();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Description'"
							+ "\n METHOD: getDescription \n"
							+ e.getLocalizedMessage());
		}
		return description;
	}

	/**
	 * Method helps to click Cancel button
	 * 
	 * @author Chaitali
	 * @return
	 * @throws Exception
	 */
	public void clickCancelButton() throws Exception {
		logInstruction("LOG INSTRUCTION: CLICK ON CANCEL BUTTON");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnCancel, waitTime);
			btnCancel.click();
			logInstruction("LOG INSTRUCTION: Cancel clicked");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING 'Cancel Button'"
							+ "\n METHOD: clickCancelButton \n"
							+ e.getLocalizedMessage());
		}

	}

	/**
	 * Method helps to check whether FormattingTips is visible
	 * 
	 * @author Chaitali
	 * @return boolean - true if formatting tips is visible false if not visible
	 * @throws Exception
	 */
	public boolean isFormattingTipsVisible() throws Exception {
		logInstruction("LOG INSTRUCTION: IS FORMATTING TIPS VISIBLE");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkFormattingTips, waitTime);
			if (isFormattingTipsVisibleChecked(lnkFormattingTips))
				flag = true;
			else
				flag = false;

			return flag;

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING 'Formatting Tips Visible'"
							+ "\n METHOD: isFormattingTipsVisible \n"
							+ e.getLocalizedMessage());
		}

	}

	/**
	 * Method helps to check whether FormattingTips is visible
	 * 
	 * @author Chaitali
	 * @return boolean - true if finds formatting tips false if not found
	 * @throws Exception
	 */
	public boolean isFormattingTipsVisibleChecked(UIElement tips)
			throws Exception {
		logInstruction("LOG INSTRUCTION: IS FORMATTING TIPS VISIBLE");
		try {
			frameSwitch.switchToFrameContent();
			if (tips.isDisplayed())
				flag = true;
			else
				flag = false;

			return flag;

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING 'Formatting Tips Visible Checked'"
							+ "\n METHOD: isFormattingTipsVisibleChecked \n"
							+ e.getLocalizedMessage());
		}

	}

	/**
	 * Method helps to get descriptionFormattingTips
	 * 
	 * @author Chaitali
	 * @return String - descriptionFormattingTips
	 * @throws Exception
	 */
	public String getDescriptionFormattingTips() throws Exception {
		logInstruction("LOG INSTRUCTION: GET DESCRIPTION FORMATTING TIPS");
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblDescriptionFormattingTips, waitTime);
			descrptionFormattingTips = lblDescriptionFormattingTips.getText()
					.substring(104);
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Description Formatting Tips'"
							+ "\n METHOD: getDescriptionFormattingTips \n"
							+ e.getLocalizedMessage());
		}
		return descrptionFormattingTips;
	}

	/**
	 * Method helps to get file Path
	 * 
	 * @author Chaitali
	 * @return String - filepath
	 * @throws Exception
	 */
	public String getFilePath() throws Exception {
		logInstruction("LOG INSTRUCTION: GET FILEPATH");
		try {

			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
			btnBrowse.click();
			List<String> windows = new ArrayList<String>();
			windows.addAll(uiDriver.getWindowHandles());
			uiDriver.switchTo().window(windows.get(1));
			uiDriver.close();
			uiDriver.switchTo().window(windows.get(0));
			btnBrowse.sendKeys(Keys.CONTROL + "a");
			btnBrowse.sendKeys(Keys.CONTROL + "c");
			Clipboard clipboard = Toolkit.getDefaultToolkit()
					.getSystemClipboard();
			path = clipboard.getData(DataFlavor.stringFlavor).toString();
		} catch (Exception e) {
			throw new Exception("LOG INSTRUCTION: ISSUE IN GETTING 'File Path'"
					+ "\n METHOD: getFilePath \n" + e.getLocalizedMessage());
		}
		return path;
	}

	/**
	 * This method gets the text of the upload and convert file
	 * 
	 * @return String - uploadtext
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public String getTextUploadAndConvertFileisDisplayed() throws Exception {
		String btnupload = null;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR THE UPLOAD AND CONVERT FILE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnUploadAndConvert, waitTime);
			btnupload = btnUploadAndConvert.getAttribute("value");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CHECKING 'Text Upload And Convert File is Displayed'"
							+ "\n METHOD: getTextUploadAndConvertFileisDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return btnupload;
	}

	/**
	 * This method checks whether the upload and convert file is present or not
	 * 
	 * @return boolean
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public boolean isUploadAndConvertFileisDisplayed() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR THE UPLOAD AND CONVERT FILE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnUploadAndConvert, waitTime);
			flag = btnUploadAndConvert.isDisplayed();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CHECKING 'Upload And Convert File is Displayed'"
							+ "\n METHOD: isUploadAndConvertFileisDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method checks whether the upload and convert file is present or not
	 * 
	 * @return boolean
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public boolean isCancelButtonisDisplayed() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR THE UPLOAD AND CONVERT FILE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnCancel, waitTime);
			flag = btnCancel.isDisplayed();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CHECKING 'Cancel Button is Displayed'"
							+ "\n METHOD: isCancelButtonisDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This is Service level method to Upload Syllabus Document
	 * 
	 * @author Kapil
	 * @param path
	 *            of File
	 * @return SyllabusHomePage
	 */
	public SyllabusHomePage uploadSyllabusFile(String pathOfFile,
			String action, String tag, boolean renameFile) throws Exception {
		try {
			Browser browser = getBrowser();
			AutoITMethods autoit = new AutoITMethods();
			uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
			if (browser.equals(Browser.FIREFOX)
					|| browser.equals(Browser.CHROME)) {
				btnBrowse.clickAndWait(waitTime);
				autoit.uploadFile(pathOfFile, action, tag, renameFile);
			} else if (browser.equals(Browser.INTERNETEXPLORER)) {
				String absolutePath = this.getClass().getResource(pathOfFile)
						.toString();
				absolutePath = absolutePath.split("file:/")[1];
				absolutePath = absolutePath.replaceAll("/", "\\\\");
				btnBrowse.sendKeysToFileInput(absolutePath);
			} else {
				throw new Exception("BROWSER IS NOT SUPPORTED");
			}
			logInstruction("LOG INSTRUCTION: FILE UPLOAD IS DONE");
			uiDriver.waitToBeDisplayed(btnUploadAndConvert, waitTime);
			btnUploadAndConvert.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED ON 'Upload and Convert File' BUTTON");
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN UPLOAD SYLLABUS PAGE SERVICE LEVEL METHOD FOR 'Uploading Syllabus Document'"
							+ "\n METHOD: uploadSyllabusFile \n"
							+ e.getLocalizedMessage());
		}
		return new SyllabusHomePage(uiDriver);
	}

	/**
	 * This is Handler method to Upload Syllabus Document to use with Granular
	 * Methods
	 * 
	 * @author Kapil
	 * @param relativeFilePath
	 *            of File
	 * @param action
	 * @param tag
	 * @param renameFile
	 * @return UploadSyllabusPage
	 */
	public UploadSyllabusPage uploadFileHandler(String relativeFilePath,
			String action, String tag, boolean renameFile) throws Exception {
		try {
			Browser browser = getBrowser();
			AutoITMethods autoit = new AutoITMethods();
			if (browser.equals(Browser.FIREFOX)
					|| browser.equals(Browser.CHROME)) {
				clickBrowseButton();
				autoit.uploadFile(relativeFilePath, action, tag, renameFile);
			} else if (browser.equals(Browser.INTERNETEXPLORER)) {
				String absolutePath = this.getClass()
						.getResource(relativeFilePath).toString();
				absolutePath = absolutePath.split("file:/")[1];
				absolutePath = absolutePath.replaceAll("/", "\\\\");
				clickBrowseButton(absolutePath);
			} else {
				throw new Exception("BROWSER IS NOT SUPPORTED");
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN UPLOAD FILE HANDLER FOR 'Uploading Syllabus Document'"
							+ "\n METHOD: uploadFileHandler \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}
}
