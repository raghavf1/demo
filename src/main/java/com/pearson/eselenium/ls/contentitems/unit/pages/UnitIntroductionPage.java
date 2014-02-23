package com.pearson.eselenium.ls.contentitems.unit.pages;

/**
 * Class contains all the methods related to unit introduction page
 * coursehome-Unit-
 * @author kiran kumar
 * @return
 * @throws Exception
 */
import java.util.List;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.PlainTextEditor;
import com.pearson.eselenium.ls.common.pages.RadEditorSwitchPlainOrVisual;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

public class UnitIntroductionPage extends BasePageObject {

	private UIElement lnkclickONLink = createElement(UIType.Css,
			"span[class='LinkWizardInsertLink']");
	private UIElement lnkSelectLInk = createElement(UIType.Xpath,
			"//td[label[contains(text(),'{1}')]]/preceding-sibling::td[1]/input");
	private UIElement btnClickOnContinue = createElement(UIType.Css,
			"[value='Continue >']");
	private UIElement btnSaveChanges = createElement(UIType.Css,
			"input[value='Save Changes']");
	private UIElements lstSaveChanges = createElements(UIType.Css,
			"input[value='Save Changes']");
	private UIElement lnkEquella = createElement(UIType.Xpath,
			"//a[contains(text(),'')]");
	private String unitIntroductionRadEditorToolId = "RadeEntryText";
    private String unitIntroductionRadEditorFrameId = "RadeEntryText_contentIframe";
    private String unitIntroductionRadEditorFooterId = "RadeEntryText_ModesWrapper";
	private PlainTextEditor unitIntroductionPlainEditor = new PlainTextEditor(
			uiDriver);
	private boolean flag = false;
	private UIElement txtRadEditor = createElement(UIType.ID,
			"RadeEntryText_contentIframe");
	private String visualEditorLink = "RadeEntryText_visualEditor";
	private String plainTextEditorLink = "RadeEntryText_simpleEditor";
 private VisualEditor unitIntroductionRadEditor = new VisualEditor(
            uiDriver,
            unitIntroductionRadEditorToolId,
            unitIntroductionRadEditorFrameId,unitIntroductionRadEditorFooterId);
	private RadEditorSwitchPlainOrVisual radSwitch = new RadEditorSwitchPlainOrVisual(
			uiDriver, visualEditorLink, plainTextEditorLink);

	// Constructor

	public UnitIntroductionPage(UIDriver uiDriver) {
		super(uiDriver);
		pageTitle = "UnitIntroductionPage";
		logInstruction("LOG INSTRUCTION: ## UNITINTRODUCTIONPAGE ##");
	}

	/**
	 * Method helps to get the Unit Introduction Rad Editor
	 * 
	 * @author Kapil
	 * @return VisualEditor
	 */
	 public VisualEditor getUnitIntroductionRadEditor() throws Exception {
    	frameSwitch.switchToFrameContent();
        return unitIntroductionRadEditor;
    }


	/**
	 * Method helps to get the Unit Introduction Plain Text Editor
	 * 
	 * @author Kapil
	 * @return PlainTextEditor
	 */
	   public PlainTextEditor getUnitIntroductionPlainTextEditor() throws Exception {
    	frameSwitch.switchToFrameContent();
        return unitIntroductionPlainEditor;
    }

	/**
	 * Method helps to get the Unit Introduction rad Editor switch
	 * 
	 * @author Kapil
	 * @return RadEditorSwitchPlainOrVisual
	 */
 	public RadEditorSwitchPlainOrVisual getRadSwitch() throws Exception {
    	frameSwitch.switchToFrameContent();
        return radSwitch;
    }

	/**
	 * method helps to click on link wizard in radeditor
	 * 
	 * @author kiran kumar
	 * @return UnitIntroductionPage
	 * @throws Exception
	 */

	public UnitIntroductionPage clickOnLink() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKIN ON LINK INSIDE RADEDITOR");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkclickONLink, waitTime);
			lnkclickONLink.clickAndWait(waitTime);

		} catch (Exception e) {
			throw new Exception("UNABLE TO CLICK ON LINK"
					+ "\n METHOD: clickOnLink \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * method helps to select the radio button
	 * 
	 * @author kiran kumar
	 * @return UnitIntroductionPage
	 * @param String
	 * @throws Exception
	 */

	public UnitIntroductionPage clickOnSelectTypeLink(String typeOfLink)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECTING TYPE OF LINK");
			frameSwitch.switchToAddLinkFrame();
			lnkSelectLInk.replaceValues(typeOfLink);
			lnkSelectLInk.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("UNABLE TO SELECT"
					+ "\n METHOD: clickOnSelectTypeLink \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * method helps click on continue button
	 * 
	 * @author kiran kumar
	 * @return UnitIntroductionPage
	 * @throws Exception
	 */

	public UnitIntroductionPage clickContinueButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON CONTINUE BUTTON");
			frameSwitch.switchToAddLinkFrame();
			btnClickOnContinue.clickAndWait(waitTime);

		} catch (Exception e) {
			throw new Exception("UNABLE TO CLICK"
					+ "\n METHOD: clickContinueButton \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method will click on the save changes button
	 * 
	 * @author Praveen.Maled
	 * @return UnitIntroductionPage
	 * @throws Exception
	 */
	public UnitIntroductionPage clickSaveChangesButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON SAVE CHANGES BUTTON");
			frameSwitch.switchToFrameContent();
			btnSaveChanges.isDisplayedAfterWaiting(waitTime);
			List<UIElement> buttons = lstSaveChanges.getUIElementsList();
			/*
			 * There are two save buttons with same parameters, we need click on
			 * the 2nd or last button
			 */
			buttons.get(buttons.size() - 1).clickAndWait(waitTime);
			if (isAlertPresent()) {
				uiDriver.getUIAlert().acceptAlertIfPresent();
			}
		} catch (Exception e) {
			throw new Exception("FAILED TO CLICK ON SAVE CHANGES  BUTTON"
					+ "\n METHOD: clickSaveChangesButton \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/***
	 * Method helps to verify the existence of the alert
	 * 
	 * @return boolean
	 * @author praveen.maled
	 */
	public boolean isAlertPresent() {
		try {
			// Webdriver code is required to verify the alert present
			uiDriver.switchTo().alert();
			return true;
		} catch (Exception Ex) {
			return false;
		}
	}

	/**
	 * This method is used to verify that Equella link is displayed
	 * 
	 * @author Pratush.Manglik
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isEquellaLinkDisplayed() throws Exception {
		flag = false;
		logInstruction("LOG INSTRUCTION : THIS METHOD IS USED TO VERIFY WHETHER THE EQUELLA LINK IS DISPLAYED");
		try {
			frameSwitch.switchToRadeCourseTextcontentIframe();
			uiDriver.waitToBeDisplayed(lnkEquella, waitTime);
			if (lnkEquella.getText().isEmpty()) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("EQUELLA LINK NOT DISPLAYED"
					+ "\n METHOD:isEquellaLinkDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method To Check if Alert Is Displayed After Clicking Save Changes
	 * 
	 * @author monica.anand
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAlertDisplayedAfterClickingSaveChanges() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON SAVE CHANGES BUTTON");
			frameSwitch.switchToFrameContent();
			btnSaveChanges.isDisplayedAfterWaiting(waitTime);
			List<UIElement> buttons = lstSaveChanges.getUIElementsList();
			/*
			 * There are two save buttons with same parameters, we need click on
			 * the 2nd or last button
			 */
			buttons.get(buttons.size() - 1).clickAndWait(waitTime);
			if (isAlertPresent()) {
				flag = true;
				uiDriver.getUIAlert().acceptAlertIfPresent();
			}
		} catch (Exception e) {
			throw new Exception("FAILED TO CLICK ON SAVE CHANGES  BUTTON"
					+ "\n METHOD:isAlertDisplayedAfterClickingSaveChanges \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
     * This method check whether the rad editor is displayed or not
     * 
     * @return boolean
     * @author suchi.singh
     * @throws Exception
     */

	public boolean isRadEditorDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING IF THE RAD EDITOR IS DISPLAYED");
			frameSwitch.switchToFrameContent();
			flag = txtRadEditor.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("RAD EDITOR IS NOT DISPLAYED"
					+ "\n METHOD:isRadEditorDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

}
