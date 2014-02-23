package com.pearson.eselenium.ls.contentitems.unit.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class contains all the methods for the AddItems Page
 * 
 * @author ashish.juyal
 */

public class AddItemsPage extends BasePageObject {

    /* UIElements in the AddItems Page */
    private UIElement txtInputName = createElement(UIType.Css, "#txtItemTitle");
    private UIElement drpItemType = createElement(UIType.Css, "#itemContentType");
    private UIElement btnAddItem = createElement(UIType.Css, "#AddItem");
    private UIElement btnAddAndSaveAnotherUnit = createElement(UIType.Css, "#AddAndNew");
    private UIElement drpAddTo = createElement(UIType.Css, "#unitItems");
    private UIElement txtpageHeader = createElement(UIType.Css, ".tablehead");
    private UIElement chkCreateDropBoxBasketcheckbox = createElement(
            UIType.Xpath,
            "//*[@name='isCreateDropBoxBasket']");
    private UIElement chkHiddenFromStudents = createElement(
            UIType.Xpath,
            "//*[@name='isHiddenFromStudents']");
    private UIElement txtHeader = createElement(UIType.Xpath, "//div[@class='tablehead']");
    private UIElement drpName = createElement(UIType.Xpath, "//select[@id='drpItemTitle']");
    private UIElement chkCreatebasket = createElement(
            UIType.Css,
            "input[name='isCreateDropBoxBasket']");
    private UIElement btnCancel = createElement(UIType.Css, "#CancelItem");
    private UIElement drpAssignTo = createElement(UIType.ID, "courseGroupID");
    private UIElement drpSelectUnit = createElement(
            UIType.Xpath,
            "//select[@id='unitItems']/option[contains(.,'{1}')]");
    boolean flag = false;
    String strValue = null;
    String strText = null;

    /* Constructor */
    public AddItemsPage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "AddItemsPage";
        logInstruction("LOG INSTRUCTION: ## Add Items Page ##");
    }

    /**
     * This method writes the text into the title text box of the AddItemsPage;
     * 
     * @returns AddItemsPage
     * @param String
     * @author ashish.juyal
     * @throws Exception
     */
    public AddItemsPage writeInputText(String text) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER TEXT INTO THE TITLE TEXT BOX");
            frameSwitch.switchToFrameContent();
            txtInputName.isDisplayedAfterWaiting(waitTime);
            txtInputName.sendKeys(text);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN WRITING TEXT INTO TITLE TEXT BOX" + "\n METHOD: writeInputText \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method selects the value from the Item Type dropdown in AddItemsPage
     * 
     * @return AddItemsPage
     * @param String
     * @author ashish.juyal
     * @throws Exception
     */
    public AddItemsPage selectItemType(String text) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT THE VALUE FROM THE ITEM TYPE DROPDOWN LIST");
            frameSwitch.switchToFrameContent();
            drpItemType.isDisplayedAfterWaiting(waitTime);
            drpItemType.selectByVisibleText(text);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT TEXT FROM ITEMTYPE DROPDOWN LIST" + "\n METHOD:selectItemType \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method click the AddItem button after entering the details in the AddItemsPage
     * 
     * @return CourseItemsPage
     * @author ashish.juyal
     * @throws Exception
     */
    public CourseItemsPage clickAddItemButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK THE ADDITEM BUTTON");
            frameSwitch.switchToFrameContent();
            btnAddItem.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON ADD ITEMS BUTTON" + "\n METHOD:clickAddItemButton \n" + e
                            .getLocalizedMessage());
        }
        return new CourseItemsPage(uiDriver);
    }

    /**
     * This method click the save&AddMoreItems button
     * 
     * @return:AddItemsPage
     * @author ashish.juyal
     * @throws Exception
     */
    public AddItemsPage clickSaveAndAddAnotherItemButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON SAVE&ADDMORE BUTTON");
            frameSwitch.switchToFrameContent();
            btnAddAndSaveAnotherUnit.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON SAVE & ADDMORE BUTTON" + "\n METHOD:clickAddAndSaveAnotherItemButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method select the value from the AddTo dropdown in AddItems Page when try to insert a
     * new thread item in a newly created unit
     * 
     * @author ashish.juyal
     * @param String
     * @return AdditemPage
     * @throws Exception
     */
    public AddItemsPage selectValueFromAddTo() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT THE VALUE FROM THE ADDTO DROPDOWN LIST");
            frameSwitch.switchToFrameContent();
            drpAddTo.sendKeys(Keys.PAGE_DOWN);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT VALUE FROM ADDTO DROPDOWN LIST" + "\n METHOD:selectValueFromAddTo \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * this methods assert whether the addItem page is displayed or not
     * 
     * @author ashish.juyal
     * @return boolean value
     * @throws Exception
     */

    public boolean verifyAddItemPageIsDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING THE ADDITEMS PAGE");
            frameSwitch.switchToFrameContent();
            strValue = txtpageHeader.getText();
            if (strValue.equalsIgnoreCase("Add Items")) {
                logInstruction("LOG INSTRUCTION: VERIFIED ADDITEMS PAGE");
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY THE ADDITEMS PAGE" + "\n METHOD:verifyAddItemPageIsDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * this methods helps to select checkbox Create dropbox basket
     * 
     * @author hemant.kumar
     * 
     * @return AddItemsPage
     * 
     * @throws Exception
     */
    public AddItemsPage selectCreateDropboxBasketCheckbox() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: SELECT CREATEDROPBOXBASKET CHECKBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkCreateDropBoxBasketcheckbox);
            chkCreateDropBoxBasketcheckbox.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT CREATEDROPBOX BASKET CHECKBOX" + "\n METHOD:SelectCreateDropboxBasketCheckbox \n" + e
                            .getLocalizedMessage());

        }
        return this;
    }

    /**
     * this methods helps to select HiddenFromStudents checkbox
     * 
     * @author hemant.kumar
     * @return AddItemsPage
     * @throws Exception
     */
    public AddItemsPage selectHiddenFromStudentsCheckbox() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: SELECT HIDDENFROMSTUDENTS CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkHiddenFromStudents.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT HIDDENFROMSTUDENTS CHECKBOX" + "\n METHOD:SelectHiddenFromStudentsCheckbox \n" + e
                            .getLocalizedMessage());

        }
        return this;
    }

    /**
     * This method helps to get the header title
     * 
     * @author ashish.juyal
     * @throws Exception
     */

    public String getHeaderTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtHeader, waitTime);
            strText = txtHeader.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET HEADER TITLE" + "\n METHOD:getHeaderTitle \n" + e
                    .getLocalizedMessage());
        }
        return strText;
    }

    /**
     * This method helps to select the value from the existing item names
     * 
     * @author ashish.juyal
     * @param String
     * @return AddItemsPage
     * @throws Exception
     */

    public AddItemsPage selectExistingItemName(String itemname) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING THE ITEM NAME");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpName, waitTime);
            drpName.selectByVisibleText(itemname);
        } catch (Exception e) {
            throw new Exception(
                    "UANBLE TO SELECT EXISTING ITEM NAME" + "\n METHOD:selectExistingItemName \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method will Click on Create DropBox Basket CheckBox
     * 
     * @return AddItemsPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public AddItemsPage clickCheckboxCreateDropboxbasket() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING CREATE DROPBOX CHECK BOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkCreatebasket, waitTime);
            chkCreatebasket.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK CREATEDROPBOXBASKET CHECKBOX" + "\n METHOD:clickCheckboxCreateDropboxbasket \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method Will Click on Cancel button
     * 
     * @return AddItemsPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public AddItemsPage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK CANCEL BUTTON" + "\n METHOD:clickCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method Will Select assign to Dropdown
     * 
     * @return AddItemsPage
     * @throws Exception
     * @author Raghav S
     */
    public AddItemsPage selectAssignGroup(String groupName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:SELECT ASSIGN GROUP");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpAssignTo, waitTime);
            drpAssignTo.selectByVisibleText(groupName);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT ASSIGN GROUP" + "\n METHOD: selectAssignGroup \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method Will Click on Unit to be selected for item to add
     * 
     * @param String
     *            unitName
     * @return AddItemsPage
     * @throws Exception
     * @author Praveen.Maled
     */
    public AddItemsPage selectUnitFromAddTo(String unitName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:SELECT UNIT FROM ADDTO");
            frameSwitch.switchToFrameContent();
            drpSelectUnit.replaceValues(unitName);
            Select selectData = new Select(drpAddTo);
            selectData.deselectAll();
            drpSelectUnit.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT UNIT FROM DROPDOWN" + "\n METHOD:selectUnitFromAddTo \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /***
     * This Method helps to add an item
     * 
     * @param strItemName
     * @param strType
     * @param strUnit
     * @param strAssignTo
     * @param flagHideItem
     * @param flagCreateDropBox
     * @param flagSaveNAddMoreItems
     * @return Object
     * @throws Exception
     * 
     * @author sumanth.sv
     */
    public Object addItem(
            String strItemName,
            String strType,
            String strUnit,
            String strAssignTo,
            boolean flagHideItem,
            boolean flagCreateDropBox,
            boolean flagSaveNAddMoreItems) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:ADD ITEM");

            logInstruction("LOG INSTRUCTION: ENTER TEXT INTO THE TITLE TEXT BOX");
            frameSwitch.switchToFrameContent();
            if (!txtInputName.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Input Name' DOES NOT EXISTS \n METHOD: addItem");
            }

            txtInputName.sendKeys(strItemName);

            logInstruction("LOG INSTRUCTION: SELECT THE VALUE FROM THE ITEM TYPE DROPDOWN LIST");
            drpItemType.isDisplayedAfterWaiting(waitTime);
            if (!drpItemType.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Item Type Dropbox' DOES NOT EXISTS \n METHOD: addItem");
            }
            drpItemType.selectByVisibleText(strType);

            if (StringUtils.isNotBlank(strUnit)) {
                logInstruction("LOG INSTRUCTION:SELECT UNIT FROM ADDTO");
                drpSelectUnit.replaceValues(strUnit);
                Select selectData = new Select(drpAddTo);
                selectData.deselectAll();
                drpSelectUnit.clickAndWait(waitTime);
            }

            if (StringUtils.isNotBlank(strAssignTo)) {
                logInstruction("LOG INSTRUCTION:SELECT ASSIGN GROUP");
                if (!drpAssignTo.isDisplayedAfterWaiting(waitTime)) {
                    throw new Exception("'Assign to Dropbox' DOES NOT EXISTS \n METHOD: addItem");
                }
                drpAssignTo.selectByVisibleText(strAssignTo);
            }

            if (flagHideItem == true) {
                logInstruction("LOG INSTRUCTION: SELECT HIDDE ITEMS FROM STUDENTS CHECKBOX");
                if (!chkHiddenFromStudents.isDisplayedAfterWaiting(waitTime)) {
                    throw new Exception(
                            "'Hide From Students Checkobx' DOES NOT EXISTS \n METHOD: addItem");
                }
                chkHiddenFromStudents.clickAndWait(waitTime);
            }

            if (flagCreateDropBox == true) {
                logInstruction("LOG INSTRUCTION: SELECT CREATE DROPBOX BASKET CHECKBOX");
                if (!chkCreateDropBoxBasketcheckbox.isDisplayedAfterWaiting(waitTime)) {
                    throw new Exception(
                            "'Create DropBox Basket Checkbox' DOES NOT EXISTS \n METHOD: addItem");
                }
                chkCreateDropBoxBasketcheckbox.clickAndWait(waitTime);
            }

            if (flagSaveNAddMoreItems == true) {
                logInstruction("LOG INSTRUCTION: CLICK ON SAVE & ADD MORE ITEMS BUTTON");
                if (!btnAddAndSaveAnotherUnit.isDisplayedAfterWaiting(waitTime)) {
                    throw new Exception(
                            "'Save And Add More Items Button' DOES NOT EXISTS \n METHOD: addItem");
                }
                btnAddAndSaveAnotherUnit.clickAndWait(waitTime);
                return new AddItemsPage(uiDriver);
            } else {
                logInstruction("LOG INSTRUCTION: CLICK ADD ITEM BUTTON");
                if (!btnAddItem.isDisplayedAfterWaiting(waitTime)) {
                    throw new Exception("'Add Items Button' DOES NOT EXISTS \n METHOD: addItem");
                }
                btnAddItem.clickAndWait(waitTime);
                return new CourseItemsPage(uiDriver);
            }

        } catch (Exception e) {
            throw new Exception("UNABLE TO ADD ITEM" + "\n  METHOD: addItem \n" + e
                    .getLocalizedMessage());
        }

    }
}
