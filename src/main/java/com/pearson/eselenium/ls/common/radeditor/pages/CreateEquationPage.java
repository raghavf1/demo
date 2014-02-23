package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class contains all the Elements and respective Actions/ Methods of
 * Create Equation pop-up page from Visual Editor.
 * 
 * @author Kapil.Aare
 */
public class CreateEquationPage extends BasePageObject {

	/* Elements */
	private UIElement showmathmlButton;
	private UIElement equationtitle;
	private UIElement saveandInsertButton;

	/* Variables */
	private boolean status = false;

	/* Constructor */
	public CreateEquationPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ## CreateEquationPage ##");
	}

	/**
	 * This methods helps to click on the MathMl Button
	 * 
	 * @author ashish.juyal
	 * @return MathMLPage
	 * @throws Exception
	 */
	public MathMLPage clickshowMathMlButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: clicking the showmathml button");
			frameSwitch.switchToPopUpContent();
			uiDriver.waitToBeDisplayed(showmathmlButton, waitTime);
			showmathmlButton.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK THE showmathmlbutton \n METHOD:clickshowMathMlButton"
							+ e.getLocalizedMessage());
		}
		return new MathMLPage(uiDriver);
	}

	/**
	 * This method checks for the EquationTitle is displayed or not
	 * 
	 * @author ashish.juyal
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isEquationTitleDisplayed() throws Exception {
		status = false;
		try {
			logInstruction("LOG INSTRUCTION: checking the Equation Title");
			frameSwitch.switchToPopUpContent();
			uiDriver.waitToBeDisplayed(equationtitle, waitTime);
			status = equationtitle.isDisplayed();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO FIND EQUATION TITLE \n METHOD:isEquationTitleDisplayed"
							+ e.getLocalizedMessage());
		}
		return status;
	}

	/**
	 * This method checks for the save and insert button is displayed or not
	 * 
	 * @author ashish.juyal
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isSaveAndInsertButtonDisplayed() throws Exception {
		status = false;
		try {
			logInstruction("LOG INSTRUCTION: checking the Equation Title");
			frameSwitch.switchToPopUpContent();
			uiDriver.waitToBeDisplayed(saveandInsertButton, waitTime);
			status = saveandInsertButton.isDisplayed();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO FIND THE SAVE AND INSERT BUTTON \n METHOD: isSaveAndInsertButtonDisplayed"
							+ e.getLocalizedMessage());
		}
		return status;
	}

	/**
	 * This method checks for the show mathml button is displayed or not
	 * 
	 * @author ashish.juyal
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isShowMathMLButtonDisplayed() throws Exception {
		status = false;
		try {
			logInstruction("LOG INSTRUCTION: checking the show math ml button");
			frameSwitch.switchToPopUpContent();
			uiDriver.waitToBeDisplayed(showmathmlButton, waitTime);
			status = showmathmlButton.isDisplayed();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO FIND THE showMathMLButton \n METHOD:isShowMathMLButtonDisplayed"
							+ e.getLocalizedMessage());
		}
		return status;
	}

	/**
	 * This method helps to enter the title
	 * 
	 * @author ashish.juyal
	 * @return CreateEquationPage
	 * @throws Exception
	 */
	public CreateEquationPage enterTitleinEquation(String titleName)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: entering the title in equation");
			frameSwitch.switchToPopUpContent();
			uiDriver.waitToBeDisplayed(showmathmlButton, waitTime);
			equationtitle.sendKeys(titleName);
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO ENTER THE TITLE IN EQUATION \n METHOD:enterTitleinEquation"
							+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * This method helps to click the save and insertButton
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public void clickSaveandInsertButton() throws Exception {
		try {

			logInstruction("LOG INSTRUCTION: cliking the save and insert button");
			frameSwitch.switchToPopUpContent();
			uiDriver.waitToBeDisplayed(saveandInsertButton, waitTime);
			saveandInsertButton.clickNoWait();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK THE SAVE AND INSERT BUTTON \n METHOD:clickSaveandInsertButton"
							+ e.getLocalizedMessage());
		}

	}
}
