package com.pearson.eselenium.ls.contentitems.textmultimedia.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.course.pages.NextAuthorHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class DeleteTextMultimediaItemPage extends BasePageObject {

    /* Elements */
    private UIElement btnCancel = createElement(UIType.Css, ".buttontd[value='Cancel']");
    private UIElement btnDelete = createElement(UIType.Css, ".buttontd[value='Delete']");
    private UIElement chkIAgree = createElement(UIType.Css, "input[name='chk']");
    private UIElement btnDelAndDrop = createElement(UIType.Css, "input[name='btnSubmit']");

    /* Constructor */
    public DeleteTextMultimediaItemPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## DeleteTextMultimediaItemPage ##");
    }

    /**
     * This Method will delete the item on the Confirmation Page
     * 
     * @return:NextAuthorHomePage
     * @throws Exception
     * @author Chaitali
     */
    public NextAuthorHomePage clickDeleteButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK DELETE UNIT BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnDelete.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Delete Button' DOES NOT EXISTS");
            }
            btnDelete.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: SUCCESSFULLY CLICKED ON DELETE BUTTON");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Delete Button' \n METHOD:clickDeleteButton \n" + e
                            .getLocalizedMessage());
        }
        return new NextAuthorHomePage(uiDriver);
    }

    /**
     * This method will click the Cancel Button
     * 
     * @return: TextMultimediaToolboxPage
     * @throws Exception
     * @author Chaitali
     */
    public TextMultimediaToolboxPage clickCancelButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnCancel.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Cancel Button' DOES NOT EXISTS");
            }
            btnCancel.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY CLICKED ON CANCEL BUTTON");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Cancel Button' \n METHOD:clickCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return new TextMultimediaToolboxPage(uiDriver);
    }

    /**
     * This method helps to click 'I agree check box' on DeleteTextMultimediaPage.
     * 
     * @return: DeleteTextMultimediaItemPage
     * @throws Exception
     * @author Vivek.Singh
     */
    public DeleteTextMultimediaItemPage clickIAgreeChkbox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON CHECKBOX 'I Agree'");
            frameSwitch.switchToFrameContent();
            if (!chkIAgree.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("CHECKBOX 'I Agree' DOES NOT EXISTS");
            }
            chkIAgree.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON CHECKBOX 'I Agree' \n METHOD:clickIAgreeChkbox \n" + e
                            .getLocalizedMessage());
        }
        return new DeleteTextMultimediaItemPage(uiDriver);
    }

    /**
     * This method helps to click "Delete Content and Dropbox item" on DeleteTextMultimediaPage.
     * 
     * @return: NextAuthorHomePage
     * @throws Exception
     * @author Vivek.Singh
     */
    public NextAuthorHomePage clickDeleteContentAndDropbox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'DELETE CONTENT AND DROPBOX ITEM' BUTTON.");
            frameSwitch.switchToFrameContent();
            if (!btnDelAndDrop.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Delete Content And Dropbox Item' DOES NOT EXISTS");
            }
            btnDelAndDrop.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Delete Content And Dropbox Item' \n METHOD:clickDeleteContentAndDropbox \n" + e
                            .getLocalizedMessage());
        }
        return new NextAuthorHomePage(uiDriver);
    }
    
    
    /**
     * This method helps to click on delete link
     * @param boolean 
     * 		if true clicks on Delete Content and Dropbox item
     * 		if false clicks on delete button
     * @return NextAuthorHomePage
     * @throws Exception
     * @author Chaitali
     */
    public NextAuthorHomePage deleteItem(boolean flagContentItemAndDropBox) throws Exception
    {
       try {	
                frameSwitch.switchToFrameContent();
                if(flagContentItemAndDropBox){
                    logInstruction("LOG INSTRUCTION: CLICKING ON CHECKBOX 'I Agree'");
                    
                    if (!chkIAgree.isDisplayedAfterWaiting(waitTime)) {
                        throw new Exception("CHECKBOX 'I Agree' DOES NOT EXISTS");
                    }
                    chkIAgree.clickAndWait(waitTime);
                    logInstruction("LOG INSTRUCTION: CLICKING ON 'DELETE CONTENT AND DROPBOX ITEM' BUTTON.");
                    if (!btnDelAndDrop.isDisplayedAfterWaiting(waitTime)) {
	                    throw new Exception("'Delete Content And Dropbox Item' DOES NOT EXISTS");
	                }
	                btnDelAndDrop.clickAndWait(waitTime);
                }else{
                	 if (!btnDelete.isDisplayedAfterWaiting(waitTime)) {
                	        throw new Exception("'Delete Button' DOES NOT EXISTS");
                	    }
                	    btnDelete.clickAndWait(waitTime);
                	    logInstruction("LOG INSTRUCTION: SUCCESSFULLY CLICKED ON DELETE BUTTON");
	            } 
       }catch (Exception e) {
                throw new Exception(
                        "ISSUE IN CLICKING ON 'Delete button' \n METHOD:deleteItem \n" + e
                                .getLocalizedMessage());
            }
            return new NextAuthorHomePage(uiDriver);
        }
    
    /**
     * This method helps to Verify whether a checkbox is present or not.
     * 
     * @return: boolean
     * @throws Exception
     * @author Raghav
     */
    
    
    public boolean isCheckBoxPresent() throws Exception
    {
    	try{
    		logInstruction("LOG INSTRUCTION:VERFIES CHECKBOX IS PRESENT OT NOT");
    	    frameSwitch.switchToFrameContent();
    	    return  chkIAgree.isDisplayedAfterWaiting();
    		
    	}catch(Exception e){
    		throw new Exception("VERFIYING 'checkbox' IS PRESENT "+"\nMETHOD:isCheckBoxPresent\n"+e.getLocalizedMessage());
    	}
	    	
    }
}
