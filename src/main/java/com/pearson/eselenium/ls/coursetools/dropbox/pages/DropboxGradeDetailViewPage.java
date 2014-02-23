package com.pearson.eselenium.ls.coursetools.dropbox.pages;

import org.apache.commons.lang3.StringUtils;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods of Assignment Page. Navigation -->
 * 
 * @author Usha
 * @modifiedBy Vivek.Singh -- as per code review comments by Lanka Pearson
 * **/
public class DropboxGradeDetailViewPage extends BasePageObject {

    /* UIElements */
    private UIElement txtTitle = createElement(UIType.Css, "div.tablehead");
    private UIElement txtNumericGrade = createElement(UIType.ID, "ItemGrade.PointsAchieved");
    private UIElement txtLetterGrade = createElement(UIType.ID, "ItemGrade.LetterGrade");
    private UIElement btnSave = createElement(UIType.ID, "saveGradebutton");
    private UIElement btnCancel = createElement(UIType.ID, "CancelButton");

	private String strMessage = null;
    /* Constructor */
    public DropboxGradeDetailViewPage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "Dropbox Grade Detail View";
        logInstruction("LOG INSTRUCTION: ## DropboxGradeDetailViewPage ##");
    }

    /**
     * Method helps to get DropboxGradeDetailView page header name.
     * 
     * @author Usha
     * @return String - title
     * @throws Exception
     */
    public String getHeaderName() throws Exception {
		strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY 'DropboxGradeDetailView' PAGE TITLE");
            frameSwitch.switchToFrameContent();
			strMessage = txtTitle.getText();
        } catch (Exception e) {
            throw new Exception(
					"UNABLE TO CHECK FOR THE 'DropboxGradeDetailView' PAGE TITLE. \nMETHOD: getHeaderName.\n "
							+ e.getLocalizedMessage());
        }
		return strMessage;
    }

    /**
     * Method helps to enter the Numeric grade
     * 
     * @author Usha
     * @param String
     *            name: text
     * @return DropboxGradeDetailViewPage
     * @throws Exception
     */
	public DropboxGradeDetailViewPage enterNumberGrade(String strText)
			throws Exception {
        logInstruction("LOG INSTRUCTION: ENTER THE CONTENT FOR SUBJECT");
        try {
            if (StringUtils.isNotBlank(strText)) {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtNumericGrade, waitTime);
				txtNumericGrade.sendKeysToFileInput(strText);
            } else
				throw new Exception(
						"PARAMETERS IS BLANK. \nMETHOD: enterNumberGrade.\n");
        } catch (Exception e) {
            throw new Exception(
					"UNABLE TO ENTER THE NUMERIC GRADE. \nMETHOD: enterNumberGrade.\n"
							+ e.getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to enter letter grade
     * 
     * @author Usha
     * @param String
     *            name: text
     * @return DropboxGradeDetailViewPage
     * @throws Exception
     */
	public DropboxGradeDetailViewPage enterLetterGrade(String strText)
			throws Exception {
        logInstruction("LOG INSTRUCTION: ENTER 'Letter Grade'.");
        try {
            if (StringUtils.isNotBlank(strText)) {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtLetterGrade, waitTime);
				txtLetterGrade.sendKeysToFileInput(strText);
            } else
				throw new Exception(
						"PARAMETERS IS BLANK. \nMETHOD: enterLetterGrade.\n");
        } catch (Exception e) {
			throw new Exception(
					"UNABLE TO ENTER 'Letter Grade'. \nMETHOD: enterLetterGrade.\n"
							+ e.getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on 'Save' button
     * 
     * @author Usha
     * @throws Exception
     */
    public DropboxGradeDetailViewPage clickSaveButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Save' BUTTON.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSave, waitTime);
            btnSave.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
					"UNABLE TO CLICK ON 'Save' BUTTON. \nMETHOD: clickSaveButton.\n"
							+ e.getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on 'Cancel' button. Navigates to {@link BasketHomePage}
     * 
     * @return {@link BasketHomePage}
     * @author Usha
     * @throws Exception
     * @modifiedBy Vivek.Singh -- changed return type.
     */
    public BasketHomePage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Cancel' BUTTON.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
					"UNABLE TO CLICK ON 'Cancel' BUTTON. \nMETHOD: clickCancelButton.\n"
							+ e.getLocalizedMessage());
        }
        return new BasketHomePage(uiDriver);
    }
	
	    /**
     * This method helps to Enter all the Grade
     * @ServiceLevelMethod
     * @author Raghav
     * @throws Exception
     */
    public DropboxGradeDetailViewPage enterGradeDropboxDetailVewandClickSave(
			String strNumericgrade, String strLettergrade) throws Exception {
        try {
			if (StringUtils.isNotBlank(strNumericgrade)
					&& StringUtils.isNotBlank(strLettergrade)) {
            logInstruction("LOG INSTRUCTION: ENTERS THE GRADE.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtNumericGrade, waitTime);
				txtNumericGrade.sendKeysToFileInput(strNumericgrade);
            uiDriver.waitToBeDisplayed(txtLetterGrade, waitTime);
				txtLetterGrade.sendKeysToFileInput(strLettergrade);
            uiDriver.waitToBeDisplayed(btnSave, waitTime);
            btnSave.clickAndWait(waitTime);
            } else
                throw new Exception(
                        "PARAMETERS IS BLANK. \nMETHOD: enterGradeDropboxDetailVewandClickSave.\n");
        } catch (Exception e) {
            throw new Exception(
					"UNABLE TO ENTER THE 'grade' . \nMETHOD: enterGradeDropboxDetailVew.\n"
							+ e.getLocalizedMessage());
        }
        return this;
    }
    
}
