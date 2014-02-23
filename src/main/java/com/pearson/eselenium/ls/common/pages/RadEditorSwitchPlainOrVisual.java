package com.pearson.eselenium.ls.common.pages;

import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class contains the UI Elements and Methods / Actions for Switching between Visual and Plain editors of RAD Editor Component.
 * 
 * @author Kapil.Aare
 */
public class RadEditorSwitchPlainOrVisual extends BasePageObject {

	/* Elements */
	private UIElement lnkvisualeditor = createElement(UIType.Xpath,
			"//a[@id='{1}']");
	private UIElement lnkplainTexteditor = createElement(UIType.Css, "#{1}");
	
	/* Variables */
	private String lnkVisualEditorLocator;
	private String lnkPlainTextEditorLocator;
	private String alertMessage = null;
	private boolean flag = false;
	private String textColor = null;
	private String textStyle = null;
	private String text = null;

	/* Constructor */
	public RadEditorSwitchPlainOrVisual(UIDriver driver, String VELink,
			String PELink) {
		super(driver);
		this.lnkVisualEditorLocator = VELink;
		this.lnkPlainTextEditorLocator = PELink;
		logInstruction("LOG INSTRUCTION: ## Visual OR Plain Editor Switch Page ##");
	}

	/**
	 * this method helps to check Plain text editor selected
	 * 
	 * @author Soundarya
	 * @param String acceptOrDecline
	 * @return void
	 * @throws Exception
	 */
	public void clickVisualEditorLink(String acceptOrDecline) throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			lnkvisualeditor.replaceValues(lnkVisualEditorLocator);
			uiDriver.waitToBeDisplayed(lnkvisualeditor, waitTime);
			lnkvisualeditor.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED ON VISUAL EDITOR LINK");
			if (acceptOrDecline.equalsIgnoreCase("Accept")) {
				alertMessage = uiDriver.getUIAlert()
						.acceptAlertIfPresentAndGetMessage();
				logInstruction("LOG INSTRUCTION: ACCEPTED ALERT");
			} else {
				uiDriver.getUIAlert().dismissAlertIfPresent();
				logInstruction("LOG INSTRUCTION: DISMISSED ALERT");
			}
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION:UNABLE TO CLICK VISUAL EDITOR \n METHOD :clickVisualEditorLink");
		}
	}

	/**
	 * this method helps to check Plain text editor selected
	 * 
	 * @author Soundarya
	 * @param String acceptOrDecline
	 * @return void
	 * @throws Exception
	 */
	public void clickPlainTextEditorLink(String acceptOrDecline)
			throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			lnkplainTexteditor.replaceValues(lnkPlainTextEditorLocator);
			uiDriver.waitToBeDisplayed(lnkplainTexteditor, waitTime);
			lnkplainTexteditor.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED ON PLAIN TEXT EDITOR LINK");
			if (acceptOrDecline.equalsIgnoreCase("Accept")) {
				alertMessage = uiDriver.getUIAlert()
						.acceptAlertIfPresentAndGetMessage();
				logInstruction("LOG INSTRUCTION: ACCEPTED ALERT");
			} else {
				uiDriver.getUIAlert().dismissAlertIfPresent();
				logInstruction("LOG INSTRUCTION: DISMISSED ALERT");
			}
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION:UNABLE TO CLICK PLAIN TEXT EDITOR \n METHOD :clickPlainTextEditorLink");
		}
	}
	
	/**
	 * @author Soundarya
	 * @return String
	 * @throws Exception
	 */
	public String getAlertMessage() {
		return alertMessage.trim();
	}

	/**
	 * this method helps to check Plain text editor selected
	 * 
	 * @author Soundarya
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isPlainTextEditorSelected() throws Exception {
		flag = false;
		try {
			frameSwitch.switchToFrameContent();
			lnkplainTexteditor.replaceValues(lnkPlainTextEditorLocator);
			if (lnkplainTexteditor.getAttribute("class")
					.equals("toggleDisable")) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION:UNABLE TO  CHECK PLAIN TEXT EDITOR SELECTED \n METHOD :isPlaintexteditorselected");
		}
		return flag;
	}

	/**
	 * This method will check whether Visual Editor link is being selected or
	 * not.
	 * 
	 * @author Suchi.Singh
	 * @return boolean
	 * @throws Exception
	 * **/
	public boolean isVisualEditorSelected() throws Exception {
		flag = false;
		try {
			frameSwitch.switchToFrameContent();
			lnkvisualeditor.replaceValues(lnkVisualEditorLocator);
			uiDriver.waitToBeDisplayed(lnkvisualeditor, waitTime);
			if ((lnkvisualeditor.getAttribute("class")).equals("toggleDisable")) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"VISUAL EDITOR LINK IS NOT SELECTED. \n METHOD :isVisualEditorSelected"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method will get Text Colour Of Editor .
	 * 
	 * @author Suchi.Singh
	 * @param String
	 *            Editor ( Visual/ plain)
	 * @return String
	 * @throws Exception
	 * **/
	public String getTextColourOfEditor(String Editor) throws Exception {
		textColor = null;
		try {
			frameSwitch.switchToFrameContent();
			if (Editor.equalsIgnoreCase("Visual")) {
				lnkvisualeditor.replaceValues(lnkVisualEditorLocator);
				uiDriver.waitToBeDisplayed(lnkvisualeditor, waitTime);
				if ((lnkvisualeditor.getAttribute("class"))
						.equals("toggleDisable")) {
					textColor = "black";
				} else {
					textColor = "blue";
				}
			} else {
				lnkplainTexteditor.replaceValues(lnkPlainTextEditorLocator);
				uiDriver.waitToBeDisplayed(lnkplainTexteditor, waitTime);
				if ((lnkplainTexteditor.getAttribute("class"))
						.equals("toggleDisable")) {
					textColor = "black";
				} else {
					textColor = "blue";
				}
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET TEXT COLOUR OF  EDITOR \n METHOD :getTextColourOfEditor. "
							+ e.getLocalizedMessage());
		}
		return textColor;
	}

	/**
	 * This method will get Text Style Of Editor .
	 * 
	 * @author Suchi.Singh
	 * @param String
	 *            Editor ( Visual/ plain)
	 * @return String
	 * @throws Exception
	 * **/
	public String getTextStyleOfEditor(String Editor) throws Exception {
		textStyle = null;
		try {
			frameSwitch.switchToFrameContent();
			if (Editor.equalsIgnoreCase("Visual")) {
				lnkvisualeditor.replaceValues(lnkVisualEditorLocator);
				uiDriver.waitToBeDisplayed(lnkvisualeditor, waitTime);
				if ((lnkvisualeditor.getAttribute("class"))
						.equals("toggleDisable")) {
					textStyle = "Bold";
				} else {
					textStyle = "Underline";
				}
			} else {
				lnkplainTexteditor.replaceValues(lnkPlainTextEditorLocator);
				uiDriver.waitToBeDisplayed(lnkplainTexteditor, waitTime);
				if ((lnkplainTexteditor.getAttribute("class"))
						.equals("toggleDisable")) {
					textStyle = "Bold";
				} else {
					textStyle = "Underline";
				}
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET TEXT STYLE OF  EDITOR . \n METHOD :getTextStyleOfEditor"
							+ e.getLocalizedMessage());
		}
		return textStyle;
	}

	/**
	 * this method helps to check visual editor link displayed
	 * 
	 * @author Soundarya
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isVisualEditorLinkDisplayed() throws Exception {
		flag = false;
		try {
			frameSwitch.switchToFrameContent();
			lnkvisualeditor.replaceValues(lnkVisualEditorLocator);
			flag = lnkvisualeditor.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION:UNABLE TO CHECK VISUAL EDITOR LINK DISPLAYED \n METHOD :isVisualEditorLinkDisplayed");
		}
		return flag;
	}

	/**
	 * this method helps to check plain text editor displayed
	 * 
	 * @author Soundarya
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isPlainTextEditorLinkDisplayed() throws Exception {
		flag = false;
		try {
			frameSwitch.switchToFrameContent();
			lnkplainTexteditor.replaceValues(lnkPlainTextEditorLocator);
			flag = lnkplainTexteditor.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION:UNABLE TO CHECK PLAIN TEXT EDITOR DISPLAYED \n METHOD :isPlainTextEditorLinkDisplayed");
		}
		return flag;
	}

	/**
	 * This method helps to get the alert message after clicking the visual
	 * editor link
	 * 
	 * @author ashish.juyal
	 * @param String acceptOrDecline
	 * @return String
	 * @throws Exception
	 */
	public String getAlertMessageAfterclikingVisualEditor(String acceptOrDecline)
			throws Exception {
		text = null;
		try {
			frameSwitch.switchToFrameContent();
			lnkvisualeditor.replaceValues(lnkVisualEditorLocator);
			uiDriver.waitToBeDisplayed(lnkvisualeditor, waitTime);
			lnkvisualeditor.clickNoWait();
			text = uiDriver.getUIAlert().getAlertMessage();
			if (acceptOrDecline.equalsIgnoreCase("Accept")) {
				uiDriver.getUIAlert().acceptAlertIfPresent();
			} else {
				uiDriver.getUIAlert().dismissAlertIfPresent();
			}
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: UNABLE TO CLICK VISUAL EDITOR");
		}
		return text;
	}

}
