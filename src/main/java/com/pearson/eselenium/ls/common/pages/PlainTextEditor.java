package com.pearson.eselenium.ls.common.pages;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.plaintexteditor.elements.AddALinkElement;
import com.pearson.eselenium.ls.common.plaintexteditor.elements.InsertAnImageElement;
import com.pearson.eselenium.ls.common.plaintexteditor.elements.MathEditorLinkElement;
import com.pearson.eselenium.ls.common.plaintexteditor.elements.PlainTextEditorElementsEnum;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class contains all the UI Elements and Methods/ Actions for Plain Text Editor of RAD Editor.
 * This class can be reached after you click on the link of Plain Editor from RadEditorSwitchPlainOrVisual class.
 * 
 * @author Kapil.Aare
 */
public class PlainTextEditor extends BasePageObject {

	/* Elements */
	private UIElement lnkAddALink = createElement(UIType.Xpath,
			"//a[contains(.,'Add a Link')]");
	private UIElement lnkInsertAnImage = createElement(UIType.Xpath,
			"//a[contains(.,'Insert an Image')]");
	private UIElement lnkMathEditor = createElement(UIType.Xpath,
			"//a[contains(.,'Math Editor')]");
	private UIElement txtPlainEditor = createElement(UIType.Xpath,
			"//div[@id='simpleTextArea']/textarea");
	private UIElement getHeightAndWidth = createElement(UIType.Xpath,
			"//div[@id='simpleTextArea']/textarea");
	private UIElement enterTextToRAD=createElement(UIType.Xpath, "//html/body");
	
	/* Variables */
	private boolean flag = false;
	private String response = null;
	private String data = null;

	/* Constructor */
	public PlainTextEditor(UIDriver driver) {
		super(driver);
		logInstruction("LOG INSTRUCTION: ## Plain Text Editor ##");
	}

	/**
	 * Method helps to click the radEditor
	 * 
	 * @param PlainTextEditorElementsEnum elementName
	 * @return Object
	 * @throws Exception
	 * @author soundarya
	 */
	public Object clickPlainTextEditorElement(
			PlainTextEditorElementsEnum elementName) throws Exception {
		switch (elementName) {
		case ADD_A_lINK:
			AddALinkElement addALink = new AddALinkElement(lnkAddALink);			
			return addALink.clickAddaLink();
		case INSERT_AN_IMAGE:
			InsertAnImageElement image = new InsertAnImageElement(
					lnkInsertAnImage);
			return image.clcikInsertAnImageLink();
		case MATH_EDITOR:
			MathEditorLinkElement mathEditor = new MathEditorLinkElement(
					lnkMathEditor);
			return mathEditor.clcikMathEditorLink();
		default:
			return null;
		}
	}

	/**
	 * Method helps to check for radEditor Icon display
	 * 
	 * @param PlainTextEditorElementsEnum elementName
	 * @return boolean
	 * @throws Exception
	 * @author ganapati.bhat
	 */
	public boolean isPlainEditorElementDisplayed(
			PlainTextEditorElementsEnum elementName) throws Exception {
		flag = false;
		switch (elementName) {
		case ADD_A_lINK:
			AddALinkElement addALink = new AddALinkElement(lnkAddALink);
			return addALink.isAddLinkDisplayed();
		case INSERT_AN_IMAGE:
			InsertAnImageElement image = new InsertAnImageElement(
					lnkInsertAnImage);
			return image.isInsertAnImageLinkdisplayed();
		case MATH_EDITOR:
			MathEditorLinkElement mathEditor = new MathEditorLinkElement(
					lnkMathEditor);
			return mathEditor.isMathEditorLinkDisplayed();
		default:
			return flag;
		}
	}

	/**
	 * This method is used to enter text in the plain text editor
	 * 
	 * @param String
	 *            - text
	 * @return void
	 * @throws Exception
	 * @author Soundarya
	 */
	public void enterTextInPlainTextEditor(String text) throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPlainEditor, waitTime);
			txtPlainEditor.sendKeys(text);
			logInstruction("LOG INSTRUCTION: ENTERED TEXT IN THE PLAIN EDITOR");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION:UNABLE TO ENTER TEXT IN THE RAD EDITOR \n METHOD :enterTextInPlainTextEditor"
							+ e.getLocalizedMessage());
		}
	}
	
	/**
	 * This method is used to add text in the plain text editor
	 * 
	 * @param String
	 *            - text
	 * @return void
	 * @throws Exception
	 * @author Soundarya
	 */
	public void editTextInPlainTextEditor(String text) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:add text in the rad editor");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPlainEditor, waitTime);
			txtPlainEditor.sendKeys(text);
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION:unable to add text in the rad editor"
							+ e.getLocalizedMessage());
		}
	}
	/**
	 * This method is used to get text in the plain text editor
	 * 
	 * @return String -response
	 * @throws Exception
	 * @author Soundarya
	 */
	public String getTextFromPlainTextEditor() throws Exception {		
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPlainEditor, waitTime);
			response = txtPlainEditor.getText();
			logInstruction("LOG INSTRUCTION: GOT TEXT FROM PLAIN EDITOR");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION:UNABLE TO GET TEXT IN THE RAD EDITOR \n METHOD :getTextFromPlainTextEditor"
							+ e.getLocalizedMessage());
		}
		return response;
	}

	/**
	 * This Method will check if Width of Plain text editor is Equal to given
	 * width.
	 * 
	 * @author Shishir.Dwivedi
	 * @param String width
	 *            width of plain text editor which you want to check
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isWidthOFPlainTextEditorISEqualTo(String width)
			throws Exception {		
		flag = false;
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(getHeightAndWidth, waitTime);
			data = getHeightAndWidth.getAttribute("style");
			if (data.contains(width))
				flag = true;
		} catch (Exception e) {
			throw new Exception("NOT ABLE TO GET THE WIDTH OF PLAIN TEXT EDITOR"
					+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * This Method will check if height of Plain text editor is Equal to given
	 * height.
	 * 
	 * @author Shishir.Dwivedi
	 * @param String height
	 *            height of plain text editor which you want to check
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isHeightOFPlainTextEditorISEqualTo(String height)
			throws Exception {
		data = null;
		flag = false;
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(getHeightAndWidth, waitTime);
			data = getHeightAndWidth.getAttribute("style");
			if (data.contains(height))
				flag = true;
		} catch (Exception e) {
			throw new Exception("LOG INSTRUCTION: NOT ABLE TO GET THE WIDTH OF PLAIN TEXT EDITOR"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to click the radEditor
	 * 
	 * @param PlainTextEditorElementsEnum elementName	 
	 * @return Object
	 * @throws Exception
	 * @author soundarya
	 */
	public Object clickPlainTextEdiotrElementReturnObject(
			PlainTextEditorElementsEnum elementName) throws Exception {
		switch (elementName) {
		case ADD_A_lINK:
			AddALinkElement addALink = new AddALinkElement(lnkAddALink);
			return addALink.clickAddaLink();

		case INSERT_AN_IMAGE:
			InsertAnImageElement image = new InsertAnImageElement(
					lnkInsertAnImage);
			return image.clcikInsertAnImageLink();

		case MATH_EDITOR:
			MathEditorLinkElement mathEditor = new MathEditorLinkElement(
					lnkMathEditor);
			return mathEditor.clcikMathEditorLink();

		default:
			return null;
		}
	}

	/**
	 * This method is used to delete text in the plain text editor
	 * 
	 * @return void
	 * @throws Exception
	 * @author Soundarya
	 */
	public void clearTextFromPlainTextEditor() throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPlainEditor, waitTime);
			txtPlainEditor.clear();
			logInstruction("LOG INSTRUCTION: CLEARED TEXT IN PLAIN EDITOR");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION:UNABLE TO GET TEXT IN THE RAD EDITOR \n METHOD :clearTextFromPlainTextEditor "
							+ e.getLocalizedMessage());
		}

    }

    /**
     * This method is used to get link text in the plain text editor added from Add Link Assuming
     * editor will have only one link text
     * 
     * @return String -response
     * @throws Exception
     * @author Praveen.Maled
     * @Category Milestone 2
     */
    public String getLinkTextFromPlainTextEditor() throws Exception {
        response = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Link Text' IN THE RAD EDITOR");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtPlainEditor, waitTime);
            enterTextToRAD.clickAndWait(waitTime);
            response = txtPlainEditor.getText().trim();
            if (StringUtils.isNotBlank(response)) {
                response = response.replaceAll("\"", "\\\"");
                response = response.substring(response.indexOf(">") + 1).trim();
                response = response.substring(0, response.indexOf("<")).trim();
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'Link Text' IN THE RAD EDITOR" + "\nMETHOD:getLinkTextFromPlainTextEditor \n" + e
                            .getLocalizedMessage());
        }
        return response;
    }
}
