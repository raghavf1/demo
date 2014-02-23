package com.pearson.eselenium.ls.coursetools.docsharing.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of AddCategory Page Follow the below steps to
 * navigate the page: Login as prof Click on the Course Click on DocumentSharing Click on Add
 * Category Button *
 * 
 * @author Raghav S
 * 
 */
public class AddCategoryPage extends BasePageObject {

    /* UI Elements */
    private UIElement txtTopicTitle = createElement(UIType.ID, "CategoryTitle");
    private UIElement drpselectitem = createElement(UIType.ID, "GroupID");
    private UIElement btnClickAddCategory = createElement(UIType.Css, "input[value='Add Category']");
    private UIElement btnClickSaveAndAddCategory = createElement(
            UIType.Css,
            "input[value='Save and Add Another Category']");
    private UIElement btnClickCancel = createElement(UIType.Css, "input[value='Cancel']");
    private UIElement lblErrorMsg = createElement(
            UIType.Xpath,
            "//td[@class='inlineerror']/table/tbody/tr/td[2]");
    private UIElement lblHeaderMsg = createElement(UIType.Css, ".tablehead");
    private UIElement lblCategoryMsg = createElement(UIType.ClassName, "inlineerror");
    private UIElement lblpagetitle = createElement(UIType.Css, ".pageTitle");
    private UIElement lbltitlecategory = createElement(
            UIType.Xpath,
            "//tr/td[1]/label[contains(text(),'{1}')]");
    
    private UIElement drpdownbox = createElement(UIType.Css, "#GroupID");
    
    /*variables*/
    private String strHeaderMessage = null;
    private String strErrorMessage;
    boolean flag = false;
    
    /* Constructor */
    public AddCategoryPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## Add Category Page ##");
    }

    /**
     * Method helps to Enter the category title
     * 
     * @author amit.deshmukh
     * @param topicTitle
     * @return AddCategory
     * @throws Exception
     */
    public AddCategoryPage enterCateogryTitle(String Title) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING TOPIC TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtTopicTitle, waitTime);
            txtTopicTitle.clearAndSendKeys(Title);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING 'Category Title'" + "\n METHOD:enterCateogryTitle\n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * Method helps to select the value from DropDown
     * 
     * @author amit.deshmukh
     * @param topicTitle
     * @return AddCategory Page
     * @throws Exception
     */
    public AddCategoryPage selectAssignCategoryToDropDownItem(String dropdownitem) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING THE DROP DOWN VALUE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpselectitem, waitTime);
            drpselectitem.sendKeys(dropdownitem);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE 'drop down' VALUE" + "\n METHOD:selectAssignCategoryToDropDownItem" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * This method clicks on addCategory button
     * 
     * @return:DocumentSharing
     * @author:Raghav S
     * @throws Exception
     */

    public DocSharingPage clickAddCategoryButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON ADD CATEGORY BUTTON");
            frameSwitch.switchToFrameContent();
            btnClickAddCategory.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'addCategorybutton" + "\n METHOD:clickAddCategoryButton \n" + e
                            .getLocalizedMessage());
        }

        return new DocSharingPage(uiDriver);
    }

    /**
     * This method clicks on saveandaddCategory button
     * 
     * @return:AddCategoryPage
     * @author:Raghav S
     * @throws Exception
     */

    public AddCategoryPage clickSaveAndAddCategoryButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SAVEANDADDCATEGORY BUTTON");
            frameSwitch.switchToFrameContent();
            btnClickSaveAndAddCategory.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'saveandaddcategorybutton'" + "\n METHOD:clickSaveAndAddCategoryButton\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method clicks on cancel button
     * 
     * @return:DocumentSharing
     * @author:Raghav S
     * @throws Exception
     */

    public DocSharingPage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            btnClickCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'cancel'BUTTON" + "\n METHOD:clickCancelButton\n" + e
                            .getLocalizedMessage());
        }

        return new DocSharingPage(uiDriver);

    }

    /**
     * This method Verifies whether Error Message is displayed or not if displayed it captures the
     * error message.
     * 
     * @return:AddCategoryPage
     * @author:Raghav S
     * @throws Exception
     */

    public String getErrorMessage() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:CAPTURING THE ERROR MESSAGE");
            frameSwitch.switchToFrameContent();
            if (lblCategoryMsg.isDisplayedAfterWaiting(waitTime)) {
            	strErrorMessage = lblErrorMsg.getText();
                logInstruction("LOG INSTRUCTION: ERROR MESSAGE IS CAPTURED");
                return strErrorMessage;

            } else {
                logInstruction("LOG INSTRUCTION: ERROR MESSAGE IS NOT DISPLAYED");

            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CAPTURING 'error' MESSAGE" + "\n METHOD:getErrorMessage \n" + e
                            .getLocalizedMessage());
        }
        return null;

    }

    /**
     * This method Verifies whether Error Message is displayed or not if displayed it captures the
     * error message.
     * 
     * @return:DocumentSharing
     * @author:Raghav S
     * @throws Exception
     * 
     */

    public String getHeaderMessage() throws Exception {
        
        try {

            logInstruction("LOG INSTRUCTION:CAPTURING ADD CATEGORY HEADER MESSAGE");
            frameSwitch.switchToFrameContent();
            strHeaderMessage = lblHeaderMsg.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CAPTURING 'addCategory header message'" + "\n METHOD:getHeaderMessage \n" + e
                            .getLocalizedMessage());
        }

        return strHeaderMessage;

    }

    /**
     * Method helps to verify Focus Set To Title Field
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @param topicTitle
     * @return boolean
     * @throws Exception
     */
    public boolean isFocusSetToTitleField(String Title) throws Exception {
       

        try {
            logInstruction("LOG INSTRUCTION:VERFIYING THE FOCUS OF TITLE FIELD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtTopicTitle, waitTime);
            txtTopicTitle.clearAndSendKeys(Title);
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFIYING 'focus' OF TITLE FIELD" + "\n METHOD:isFocusSetToTitleField \n" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * This method used to get page title
     * 
     * @category Milestone2
     * @return:String
     * @author:Raghav S
     * @throws Exception
     */

    public String getPagetitle() throws Exception {
      
        try {
            logInstruction("LOG INSTRUCTION:CAPTURING PAGE TITLE");
            frameSwitch.switchToFrameContent();
            pageTitle = lblpagetitle.getText().trim();
            logInstruction("LOG INSTRUCTION:PAGE TITLE IS CAPTURED ");

        } catch (Exception e) {
            throw new Exception("ISSUE IN CAPTURING PAGE TITLE" + "\n METHOD:getPagetitle \n" + e
                    .getLocalizedMessage());
        }

        return pageTitle;
    }

    /**
     * methods helps to verify label title i.e Category title/Assign Category
     * 
     * @author amit.deshmukh
     * @throws Exception
     * @category Milestone2
     */

    public boolean isLabelPresent(String label) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:VERFIYING THE LABEL IS PRESENT");
            frameSwitch.switchToFrameContent();
            lbltitlecategory.replaceValues(label);
            return lbltitlecategory.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN VERFIYING LABEL" + "\n METHOD:isLabelPresent \n" + e
                    .getLocalizedMessage());
        }

    }

    /**
     * This method to verify Drop Down
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:amit.deshmukh
     * @throws Exception
     */
    public boolean isDropDownPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:VERFIYING THE DROPDOWN IS PRESENT");
            frameSwitch.switchToFrameContent();
            return drpdownbox.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING DROPDOWN" + "\n METHOD:isDropDownPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method Verify on addCategory button
     * 
     * @return:DocumentSharing
     * @author:Raghav S
     * @throws Exception
     */

    public boolean isClickAddCategoryButtonPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERFIYING THE ADD CATEGORY BUTTON IS PRESENT");
            frameSwitch.switchToFrameContent();
            return btnClickAddCategory.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING THE ADD CATEGORY BUTTON" + "\n METHOD:isClickAddCategoryButtonPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method verifies saveandaddCategory button
     * 
     * @category Milestone2
     * @return:AddCategoryPage
     * @author:amit.deshmukh
     * @throws Exception
     */

    public boolean isClickSaveAndAddCategoryButtonPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERFIYING THE CLICK AND SAVE ADD CATEGORY BUTTON IS PRESENT");
            frameSwitch.switchToFrameContent();
            return btnClickSaveAndAddCategory.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING THE  CLICK AND SAVE ADD CATEGORY BUTTON" + "\n METHOD:isClickSaveAndAddCategoryButtonPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method verifies on cancel button
     * 
     * @category Milestone2
     * @return:DocumentSharing
     * @author:Raghav S
     * @throws Exception
     */

    public boolean isClickCancelButtonPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERFIYING THE CANCEL BUTTON IS PRESENT");
            frameSwitch.switchToFrameContent();
            return btnClickCancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING THE  CANCEL BUTTON" + "\n METHOD:isClickCancelButtonPresent \n" + e
                            .getLocalizedMessage());
        }

    }
    
    
    /**
     * This method clicks on saveandaddCategory button
     * @ServiceLeveLMethods
     * @return:AddCategoryPage
     * @author:Raghav S
     * @throws Exception
     */

    public Object  createNewCategory(String categorytitle,String assignto,boolean addCategoryorsaveandaddanothercategory) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: METHOD CREATES A NEW CATEGORY");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtTopicTitle, waitTime);
            txtTopicTitle.clearAndSendKeys(categorytitle);
            uiDriver.waitToBeDisplayed(drpselectitem, waitTime);
            drpselectitem.sendKeys(assignto);
            if(addCategoryorsaveandaddanothercategory)
            {
            	 uiDriver.waitToBeDisplayed(btnClickAddCategory, waitTime);
                  btnClickAddCategory.clickAndWait(waitTime);
                  return new DocSharingPage(uiDriver);
            }
            else{
            		uiDriver.waitToBeDisplayed(btnClickAddCategory, waitTime);
            		btnClickSaveAndAddCategory.clickAndWait(waitTime);
            		return new AddCategoryPage(uiDriver);
            	
            }


        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CREATING 'addcategory'" + "\n METHOD:AddCategory\n" + e
                            .getLocalizedMessage());
        }
       
    }


}
