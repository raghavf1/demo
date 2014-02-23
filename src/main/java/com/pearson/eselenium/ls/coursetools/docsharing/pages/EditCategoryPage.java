package com.pearson.eselenium.ls.coursetools.docsharing.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all methods related to EditCategoryPage
 * 
 * @category Milestone 2
 * @author Raghav S
 * @param uiDriver
 */

public class EditCategoryPage extends BasePageObject {

    /* UI Elements */
    private UIElement lblpageheader = createElement(UIType.Css, "h2>div");
    private UIElement lblcategorytitle = createElement(UIType.Css, "#CategoryTitle");
    private UIElement drpassignto = createElement(UIType.Css, "#GroupID");
    private UIElement btnsaveChanges = createElement(UIType.Css, "input[value='Save Changes']");
    private UIElement btncancel = createElement(UIType.Css, "input[value='Cancel']");
    private UIElement lblerrormsg = createElement(
            UIType.Xpath,
            "//td[contains(text(),'Please enter')]");
    private UIElement lblgetCategory = createElement(
            UIType.Xpath,
            "//label[contains(text(),'Category Title')]");;
    private UIElement lblassignto = createElement(
            UIType.Xpath,
            "//label[contains(text(),'Assign Category to:')]");

    /* Variables*/
    private  String strPageHeader = null;
    
    /* Constructor */
    public EditCategoryPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOGINSTRUCTION:########EditCategoryPage########");
    }

    /**
     * This method get header details
     * 
     * @category Milestone 2
     * @return:string
     * @author:kiran.kumar
     * @throws Exception
     */
    public String getHeader() throws Exception {
      
        try {
            logInstruction("LOGINSTRUCTION:GETTING THE HEADER MESSAGE");
            frameSwitch.switchToFrameContent();
            strPageHeader = lblpageheader.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'header' MESSAGE" + "\nMETHOD:getHeader\n" + e
                            .getLocalizedMessage());

        }
        
        return strPageHeader;
    }

    /**
     * This method get header details
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */
    public boolean isHeaderDispalyed() throws Exception {
    	
        try {
            logInstruction("LOGINSTRUCTION:VERFIYING THE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            return lblpageheader.isDisplayedAfterWaiting();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'header' TITLE" + "\nMETHOD:isHeaderDispalyed\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to enter title
     * 
     * @category Milestone 2
     * @return:EditCategoryPage
     * @author:kiran.kumar
     * @throws Exception
     */
    public EditCategoryPage enterCategoryTitle(String titleName) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:ENTERING THE TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblcategorytitle);
            lblcategorytitle.clearAndSendKeys(titleName);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENETRING THE 'title'" + "\nMETHOD:enterCategoryTitle\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to select value for dropdown
     * 
     * @category Milestone 2
     * @return:EditCategoryPage
     * @author:kiran.kumar
     * @throws Exception
     */
    public EditCategoryPage selectAssigntoDrpdwn(String dropdwnvalue) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:SELECTING A DROPDOWN VALUE");
            frameSwitch.switchToFrameContent();
            drpassignto.selectByVisibleText(dropdwnvalue);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFIYING 'dropdown' VALUE" + "\nMETHOD:selectAssigntoDrpdwn\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps verify error msg
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */
    public boolean isErrorMessageDisplayed() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION:VERFIYING THE ERROR MESSAGE");
            frameSwitch.switchToFrameContent();
            return lblerrormsg.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFIYING 'error' MESSAGE" + "\nMETHOD:isErrorMessageDisplayed\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * 
     * This method helps to click save changes
     * 
     * @category Milestone 2
     * @return:DocSharingPage
     * @author:kiran.kumar
     * @throws Exception
     */

    public DocSharingPage clickSaveChanges() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:CLICK ON SAVE CHANGES");
            frameSwitch.switchToFrameContent();
            btnsaveChanges.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'savechanges' BUTTON" + "\nMETHOD:clickSaveChanges\n" + e
                            .getLocalizedMessage());
        }
        return new DocSharingPage(uiDriver);
    }

    /**
     * This method helps to click cancel btn
     * 
     * @category Milestone 2
     * @return:EditCategoryPage
     * @author:kiran.kumar
     * @throws Exception
     */

    public DocSharingPage clickCancel() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:CLICK ON CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            btncancel.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING 'cancel' BUTTON" + "\n METHOD:clickCancel\n" + e
                    .getLocalizedMessage());
        }
        return new DocSharingPage(uiDriver);
    }

    /**
     * This method helps to get label
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */

    public boolean isCategoryTitleLabelPresent() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:VERFIYING THE TITLE LABEL");
            frameSwitch.switchToFrameContent();
            return lblgetCategory.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING THE 'title' LABEL" + "\nMETHOD:isCategoryTitleLabelPresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to Assign to label get label
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */

    public boolean isAssigntoLabelPresent() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION:VERFIYING THE TITLE LABEL");
            frameSwitch.switchToFrameContent();
            return lblassignto.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING THE 'title' LABEL" + "\n METHOD:isAssigntoLabelPresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to verify savechanges button
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */
    public boolean isSaveButtonDispalyed() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:VERFIYING SAVE CHANGES BUTTON");
            frameSwitch.switchToFrameContent();
            return btnsaveChanges.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'save' CHANGES BUTTON" + "\nMETHOD:isSaveButtonDispalyed\n" + e
                            .getLocalizedMessage());

        }
    }

    /**
     * This method helps to verify cancel button
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */
    public boolean isCancelButtonDispalyed() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION:VERFIYING CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            return btncancel.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'cancel' BUTTON" + "\nMETHOD:isCancelButtonDispalyed\n" + e
                            .getLocalizedMessage());

        }

    }

    /**
     * This method helps to verify textbox
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:amit.deshmukh
     * @throws Exception
     */
    public boolean isEnterCategoryTextboxPresent() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:VERFIYING CATEGORY TEXTBOX");
            frameSwitch.switchToFrameContent();
            return lblcategorytitle.isDisplayedAfterWaiting(2000);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'Textbox'" + "\nMETHOD:isEnterCategoryTextboxPresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to verify dropdown
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:amit.deshmukh
     * @throws Exception
     */
    public boolean isAssigntoDropDownPresent() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:VERFIYING ASSIGNTO DROPDOWN");
            frameSwitch.switchToFrameContent();
            return drpassignto.isDisplayedAfterWaiting(2000);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING ASSIGNTO'Dropdown'" + "\nMETHOD:isEnterCategoryTextboxPresent\n" + e
                            .getLocalizedMessage());
        }

    }
    /**
     * This method helps to edit a existing category
     * @category Service level method
     * @category Milestone 2
     * @return:docsharingpage
     * @author:kiran.kumar
     * @throws Exception
     */
    public DocSharingPage editCategory(String categoryTitle,String assigntoDropdwnValue) throws Exception{
    	try {
			logInstruction("LOGINSTRUCTION:EDITING THE CATEGORY INSIDE DOCSHARING");
			frameSwitch.switchToFrameContent();
			lblcategorytitle.isDisplayedAfterWaiting(waitTime);
			lblcategorytitle.clearAndSendKeys(categoryTitle);
			drpassignto.isDisplayedAfterWaiting(waitTime);
			drpassignto.selectByVisibleText(assigntoDropdwnValue);
			btnsaveChanges.clickAndWait(waitTime);
    	} catch (Exception e) {
			throw new Exception("ISSUE IN EDITING THE CATEGORY"+"\n Method:editCategory \n"+e.getLocalizedMessage());
		}
		return new DocSharingPage(uiDriver);
    }
    
    
    

}
