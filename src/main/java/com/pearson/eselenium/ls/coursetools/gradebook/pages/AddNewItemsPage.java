package com.pearson.eselenium.ls.coursetools.gradebook.pages;

import org.apache.commons.lang.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This page contains all the methods for the AddNewItemsPage
 * 
 * @author ashish.juyal
 */
public class AddNewItemsPage extends BasePageObject {

    /* UIElements of the AddNewItemsPage */
    private UIElement chkCheckbox = createElement(
            UIType.Css,
            "#GradableCatsCheckList>tbody>tr:nth-of-type(3)>td:nth-of-type(1)>input");
    private UIElement btnAddButton = createElement(UIType.Css, "#save1");
    private UIElement btnNext = createElement(UIType.Css, "#next1");
    private UIElement chkThread = createElement(
            UIType.Xpath,
            "//table[@id='GradableCatsCheckList']//tr//td//label[contains(text(),'{1}')]/preceding-sibling::*");
    private UIElement chkUncheckThread = createElement(
            UIType.Xpath,
            "//table[@id='GradableCatsCheckList']//tr//td//label[contains(text(),'{1}')]/preceding-sibling::*");
    private UIElement chkCreateDropBoxBasket = createElement(
            UIType.Xpath,
            "//*[@name='isCreateDropBoxBasket']");
    private UIElement chkHiddenFromStudents = createElement(
            UIType.Xpath,
            "//*[@name='isHiddenFromStudents']");
    private UIElement txtentercustom = createElement(UIType.Css, "#CustomItem1_addCustomItemName");
    private UIElement btnadd = createElement(UIType.Css, "#CustomItem1_btnAddCustomItem");
    private UIElement drpselectexisting = createElement(UIType.Css, "#CustomItem1_existingItemList");
    private UIElement btndeletcustom = createElement(UIType.Css, "#CustomItem1_btnDeleteCustomItem");

    /* Constructor */
    public AddNewItemsPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## Add New Items Page ##");
    }

    /**
     * This method clicks on the checkbox
     * 
     * @param name
     * @return:AddNewItemsPage
     * @author ashish.juyal
     * @throws Exception
     */
    public AddNewItemsPage checkThread(String name) throws Exception {
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: clicks the checkbox");
            frameSwitch.switchToFrameContent();
            chkThread.replaceValues(name);
            uiDriver.waitToBeDisplayed(chkThread, waitTime);
            flag = chkThread.isSelected();
            if (flag) {
                // unselecting and selecting the thread
                chkThread.click();
                chkThread.click();
            } else {
                chkThread.click();
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Checking Thread'" + "\n METHOD:checkThread:\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is unchecking the checkbox
     * 
     * @author: ashish .juyal
     * @return:AddNewItemsPage
     * @throws Exception
     */
    public AddNewItemsPage uncheckThread(String name) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: Uncheck the checkbox");
            frameSwitch.switchToFrameContent();
            chkUncheckThread.replaceValues(name);
            String checkvalue = chkUncheckThread.getAttribute("checked");
            if (checkvalue == null) {
                chkCheckbox.click();
            }
        } catch (Exception e) {
            throw new Exception("ISSUE IN 'Unchecking Checkbox'" + "\n METHOD:uncheckThread:\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method click on the save Button
     * 
     * @return:SelectGradableitemsPage
     * @author ashish.juyal
     * @throws Exception
     */
    public AddNewItemsPage clickSaveChangesButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: click on the save button");
            frameSwitch.switchToFrameContent();
            btnAddButton.click();
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Save Changes' BUTTON" + "\n METHOD:'clickSaveChanges:\n'" + e
                            .getLocalizedMessage());
        }
        return new AddNewItemsPage(uiDriver);
    }

    /**
     * This method clicks the next Button
     * 
     * @return:SelectGrdableItemsPage
     * @author ashish.juyal
     * @throws Exception
     */
    public SelectGradableItemsPage clickNext() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: click on the next button");
            frameSwitch.switchToFrameContent();
            btnNext.click();
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING ON 'Next' BUTTON" + "\n METHOD:clickNext:\n" + e
                    .getLocalizedMessage());
        }
        return new SelectGradableItemsPage(uiDriver);
    }

    /*
     * This methods helps to select checkbox Create dropbox basket
     * 
     * @author hemant.kumar
     * 
     * @return boolean value
     * 
     * @throws Exception
     */

    public boolean selectCreateDropboxBasketCheckbox() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: Select CreateDropboxBasket Checkbox");
            frameSwitch.switchToFrameContent();
            chkCreateDropBoxBasket.click();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'CREATE DROPBOX BASKET'" + "\n METHOD:selectCreateDropboxBasketCheckbox:\n" + e
                            .getLocalizedMessage());

        }
        return true;
    }

    /**
     * This methods helps to select HiddenFromStudents checkbox
     * 
     * @author hemant.kumar
     * @return boolean value
     * @throws Exception
     */
    public boolean selectHiddenFromStudentsCheckbox() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: Select HiddenFromStudents checkbox");
            frameSwitch.switchToFrameContent();
            chkHiddenFromStudents.click();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING  ON'HIDDEN FROM STUDENT'" + "\n METHOD:selectHiddenFromStudentsCheckbox:\n" + e
                            .getLocalizedMessage());

        }
        return true;
    }

    /**
     * this Method will enter text in Add Custom item text box
     * 
     * @param name
     *            text which you want to enter
     * @return
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public AddNewItemsPage enterCustomItem(String name) throws Exception {
        try {
            logInstruction("LOG INSTRCUTION : ENTERING TEXT IN TEXT BOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtentercustom, waitTime);
            txtentercustom.sendKeys(name);

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE TEXT BOX \n METHOD :enterCustomItem ");
        }
        return this;
    }

    /**
     * This Method will click on Add Cutom Item button
     * 
     * @return {@link AddNewItemsPage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public AddNewItemsPage clickAddbutton() throws Exception {
        try {
            logInstruction("LOG INSTRCUTION: CLICKING ON ADD BUTTON ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnadd, waitTime);
            btnadd.click();

        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON ADD BUTTON \n METHOD: clickAddbutton");
        }
        return this;
    }

    /**
     * This function will select item to delete custom item from gradebook
     * 
     * @param name
     * @return
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public AddNewItemsPage selectEditExisting(String name) throws Exception {
        try {
            logInstruction("LOG INSTRCUTION: SELECTING ITEM");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpselectexisting, waitTime);
            drpselectexisting.selectByVisibleText(name);

        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT THE ITEM \n METHOD : selectEditExisting");
        }
        return this;
    }

    /**
     * This method will delete the custom item
     * 
     * @return
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public AddNewItemsPage clickDeleteCustomItem() throws Exception {
        try {
            logInstruction("LOG INSTRCUTION: CLICKING ON DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btndeletcustom, waitTime);
            btndeletcustom.click();
            uiDriver.getUIAlert().acceptAlertIfPresent();

        } catch (Exception e) {
            throw new Exception("UNABLE TO DELETE THE ITEM \n METHOD:clickDeleteCustomItem");
        }
        return this;
    }

    /**
     * This method helps to check on the checkbox Category Milestone 2
     * 
     * @param name
     * @return:AddNewItemsPage
     * @author Raghav
     * @throws Exception
     */
    public AddNewItemsPage checkGradeableCheckBox(String name) throws Exception {
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE CHECKBOx");
            frameSwitch.switchToFrameContent();
            chkThread.replaceValues(name);
            uiDriver.waitToBeDisplayed(chkThread, waitTime);
            flag = chkThread.isSelected();
            if (flag == true) {
                logInstruction("LOG INSTRUCTION:CHECKBOX IS ALREADY CHECKED");
            } else {
                chkThread.click();
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Checking Thread'" + "\n METHOD:checkThread:\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }
    /**
     * This method helps Add new item by selecting the checkbox
     * @Category Milestone 2
     * @ Category Service Level Method
     * @param name
     * @return:AddNewItemsPage
     * @author Raghav
     * @throws Exception
     */
    public Object addItem(String itemName,String addCustomeItem,String buttonName) throws Exception{
    	Object value=null;
    	try {
			logInstruction("LOGINSTRUCTION:ADDING NEW ITEM");
			frameSwitch.switchToFrameContent();
			chkThread.replaceValues(itemName);
			if(chkThread.isSelected()){
				logInstruction("LOGINSTRUCTION:ITEM IS ALREADY CHECKED");
			}else{
				chkThread.clickNoWait();
			}
			if(StringUtils.isBlank(addCustomeItem)){
				logInstruction("LOGINSTRUCTION:NOTHING IS ENTERED IN CUSTOM ITEM FIELD");
			}else{
				txtentercustom.isDisplayedAfterWaiting(waitTime);
				txtentercustom.clearAndSendKeys(addCustomeItem);
			}
			
			if(buttonName.contains("Save Changes")){
				btnAddButton.clickNoWait();
				uiDriver.getUIAlert().acceptAlertIfPresent();
				value=this;
			}else if(buttonName.contains("Next")){
				btnNext.clickNoWait();
				value=new SelectGradableItemsPage(uiDriver);
				
			}
			
			
		} catch (Exception e) {
			throw new Exception("ISSUE IN ADDING NEW ITEM"+"\n Method:addItem \n"+e.getLocalizedMessage());
		}
    	return value;
    	
    }
    

}
