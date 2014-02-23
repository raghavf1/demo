package com.pearson.eselenium.ls.coursetools.courseadmin.pages;

import java.util.ArrayList;

import java.util.List;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all methods related to CourseAdminGroupManagementNewGroupPage
 * 
 * @category Milestone 2
 * @author Raghav S
 * @param uiDriver
 * 
 */

public class CourseAdminGroupManagementNewGroupPage extends BasePageObject {

    /* UI element declarations for CourseAdminGroupManagementNewGroupPage */

    private UIElement txttitle = createElement(UIType.Xpath, "//h2[@class='headertitle']/div");
    private UIElement txtentergroupname = createElement(UIType.ID, "groupName");
    private UIElement drpgroupmembersleft = createElement(UIType.ID, "potentialGroupMembers");
    private UIElement drpgroupmembersright = createElement(UIType.ID, "groupMembers");
    private UIElement btnmoveright = createElement(UIType.Css, "input[aria-label='Add']");
    private UIElement btnmoveleft = createElement(UIType.Css, "input[aria-label='Remove']");
    private UIElement btnclickaddgroup = createElement(UIType.Css, "input[value='Add Group']");
    private UIElement btnclicksaveandaddgroup = createElement(
            UIType.Css,
            "input[value='Save & Add Another Group']");
    private UIElement btncancel = createElement(UIType.Css, "input[value='Cancel']");
    private UIElement btnsavechanges = createElement(UIType.Css, "input[value='Save Changes']");
    private UIElement txtgeterrormsg = createElement(
            UIType.Xpath,
            "//td[contains(text(),'Please enter')]");
    private UIElement txtgroupid = createElement(UIType.Xpath, "//td[contains(text(),'Group ID:')]");
    private UIElement lblget = createElement(UIType.Xpath, "//label[contains(text(),'{1}')]");
    private UIElements drplistright = createElements(UIType.ID, "potentialGroupMembers");
    private UIElements drplistleft = createElements(UIType.ID, "groupMembers");
    
    /*Variables*/
    private String strPageTitle = null;
    private boolean flag = false;
    List<String> dropdownlist;
    List<UIElement> elements;
    
    /* constructor */
    public CourseAdminGroupManagementNewGroupPage(UIDriver driver) {
        super(driver);
        logInstruction("#########CourseAdminGroupManagementNewGroupPage########");

    }

    /**
     * This method helps to get the title of CourseAdminGroupManagementNewGroupPage
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */

    public String getTitle() throws Exception {
        try {
            frameSwitch.switchToFrameContent();
            logInstruction("LOGINSTRUCTION:VERIFY GENERAL COURSEENROLLMENTPAGE TITLE");
            uiDriver.waitToBeDisplayed(txttitle, waitTime);
            if (txttitle.isDisplayed()) {
                strPageTitle = txttitle.getText().trim();
            }
        } catch (Exception e) {

            throw new Exception(
                    "ISSUE IN GETTING 'CourseEnrollmentPage Title'" + "\n METHOD:getTitle \n" + e
                            .getLocalizedMessage());
        }
        return strPageTitle;
    }

    /**
     * This method helps to enter the group name CourseAdminGroupManagementNewGroupPage
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */

    public CourseAdminGroupManagementNewGroupPage enterGroupName(String groupname) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:ENTER THE GROUP NAME");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtentergroupname, waitTime);
            txtentergroupname.clearAndSendKeys(groupname);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING THE 'GroupName'" + "\n METHOD:enterGroupName \n" + e
                            .getLocalizedMessage());

        }
        return new CourseAdminGroupManagementNewGroupPage(uiDriver);

    }

    /**
     * This method helps to enter the group name CourseAdminGroupManagementNewGroupPage
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */

    public CourseAdminGroupManagementNewGroupPage enterGroupNameClearField() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:THIS WILL CLEAR THE GROUP NAME");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtentergroupname, waitTime);
            txtentergroupname.clear();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING 'Group Name'" + "\n METHOD:enterGroupNameClearField \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminGroupManagementNewGroupPage(uiDriver);

    }

    /**
     * This method helps to select group members which are in Left
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */

    public CourseAdminGroupManagementNewGroupPage selectGroupmembersLeft(String groupname)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:SELECTING A VALUE FROM GROUPMEMBERS");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpgroupmembersleft, waitTime);
            drpgroupmembersleft.selectByVisibleText(groupname);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE 'GroupMembers'" + "\n METHOD:selectGroupmembersLeft \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method helps to select group members which are in Right
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */

    public CourseAdminGroupManagementNewGroupPage selectGroupmembersRight(String groupname)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:SELECTING A VALUE FROM GROUPMEMBERS");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpgroupmembersright, waitTime);
            drpgroupmembersright.selectByVisibleText(groupname);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE 'GroupMembers'" + "\n METHOD:selectGroupmembersRight \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method helps to click on move right after selecting the members
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */

    public CourseAdminGroupManagementNewGroupPage clickMoveRight() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON MOVE RIGHT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnmoveright, waitTime);
            btnmoveright.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING 'moveright'" + "\n METHOD:clickMoveRight \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on move left after selecting the members
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */
    public CourseAdminGroupManagementNewGroupPage clickMoveLeft() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON MOVE RIGHT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnmoveleft, waitTime);
            btnmoveleft.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON  'move left'" + "\n METHOD:clickMoveLeft \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on addgroup button
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */

    public CourseAdminGroupManagementNewGroupPage clickOnAddGroup() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON ADDGROUP BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnclickaddgroup, waitTime);
            btnclickaddgroup.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE ON CLICKING ' AddGroup button'" + "\n METHOD:clickOnAddGroup \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on saveandaddgroup button
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */
    public CourseAdminGroupManagementNewGroupPage clickOnSaveandAddgroup() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON SAVE AND ADD ANOTHER GROUP BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnclicksaveandaddgroup, waitTime);
            btnclicksaveandaddgroup.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON  'save and add another group button'" + "\n METHOD:clickOnSaveandAddgroup \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on cancel button
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */
    public CourseAdminGroupManagementNewGroupPage clickCancel() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btncancel, waitTime);
            btncancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON ' cancel button'" + "\n METHOD:clickCancel \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to get the error msg if groupname is empty
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return String
     * @throws Exception
     */

    public String getErrorMessageLabel() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE ERROR MSG ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtgeterrormsg, waitTime);
            return txtgeterrormsg.getText();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE ON GETTING THE 'text'" + "\n METHOD:getErrorMessageLabel \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method helps to verify the error msg if groupname is empty
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */

    public boolean isErrorMessgaeLabelPresent() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING THE ERROR MSG ");
            frameSwitch.switchToFrameContent();
            txtgeterrormsg.isDisplayedAfterWaiting(waitTime);
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'label'" + "\n METHOD:isErrorMessgaeLabelPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to verify the move right button in CourseAdminGroupManagementNewGroupPage
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */

    public boolean isRightMoveButtonPresent() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING THE MOVE RIGHT BTN");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnmoveright, waitTime);
            btnmoveright.isEnabled();
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING  'move right button'" + "\n METHOD:isRightMoveButtonPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This method helps to verify the move left button in CourseAdminGroupManagementNewGroupPage
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */

    public boolean isLeftMoveButtonPresent() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING THE MOVE LEFT BTN");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnmoveleft, waitTime);
            btnmoveleft.isEnabled();
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'move left button'" + "\n METHOD:isLeftMoveButtonPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This method helps to get the add button label in CourseAdminGroupManagementNewGroupPage
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */
    public String getAddGroupButtonLabel() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE ADDGROUP BTN LABEL");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnclickaddgroup, waitTime);
            return btnclickaddgroup.getAttribute("value");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'btn label'" + "\n METHOD:getAddGroupButtonLabel \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method helps to get the cancel button label in CourseAdminGroupManagementNewGroupPage
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */
    public String getCancelButtonLabel() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE CANCEL BTN LABEL");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btncancel, waitTime);
            return btncancel.getAttribute("value");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'btn label'" + "\n METHOD:getCancelButtonLabel \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method helps to get the save and add button label in
     * CourseAdminGroupManagementNewGroupPage
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */
    public String getSaveAndAddLabel() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE SAVE AND ADD BTN LABEL");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnclicksaveandaddgroup, waitTime);
            return btnclicksaveandaddgroup.getAttribute("value");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'btn label'" + "\n METHOD:getSaveAndAddLabel \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method verfies whether GroupID label is present when we edit a Group
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGeneralandInformationPage
     * @throws Exception
     */
    public boolean isGroupIdTextDispalyed() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:VERFIY GROUPID TXT VISIBLE");
            frameSwitch.switchToFrameContent();
            if (txtgroupid.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Add Group'" + "\n METHOD:isGroupIdTextDispalyed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This method helps to verify the label present for a Element like Select Group Members:,Group
     * Members:,Group Name:
     * 
     * @category Milestone 2
     * @param element
     *            name
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isLabelPresent(String name) throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING THE LABEL OF THE ELEMENTS");
            frameSwitch.switchToFrameContent();
            lblget.replaceValues(name);
            lblget.isDisplayedAfterWaiting(waitTime);
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING TOOL  'label'" + "\n METHOD:isLabelPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to verify textbox group name CourseAdminGroupManagementNewGroupPage
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */

    public boolean isGroupNameTextPresent() throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING THE GROUP NAME");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtentergroupname, waitTime);
            txtentergroupname.isEnabled();
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'Group Name'" + "\n METHOD:isGroupNameTextPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This method helps to verify Save Changes btn is displayed or not
     * 
     * @category Milestone 2
     * @author Raghav S
     * @return boolean
     * @throws Exception
     */

    public boolean isSaveChangesButtonPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING THE SAVE CHANGES BTN");
            frameSwitch.switchToFrameContent();
            return btnsavechanges.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING ' Save changes'" + "\n METHOD:isSaveChangesButtonPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to verify Cancel btn is displayed or not
     * 
     * @category Milestone 2
     * @author Raghav S
     * @return boolean
     * @throws Exception
     */

    public boolean isCancelButtonPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING THE CANCEL BTN");
            frameSwitch.switchToFrameContent();
            return btncancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'cancel btn'" + "\n METHOD:isCancelButtonPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to get the values of Select Group Memebers if matching name Doesn't Exists
     * its returns-True if matching name exists it returns-false
     * 
     * @category Milestone 2
     * @author Raghav S
     * @return boolean
     * @throws Exception
     */

    public boolean isSelectGroupMembersValuepresent(String value) throws Exception {

         dropdownlist = new ArrayList<String>();
       
        try {
            logInstruction("LOG INSTRUCTION:CAPTURING SELECT GROUP MEMEBERS VALUES");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpgroupmembersleft, waitTime);

            elements = drplistright.getUIElementsList();

            for (int i = 0; i < elements.size(); i++) {
                dropdownlist.add(elements.get(i).getText().trim());

            }
            logInstruction("LOG INSTRUCTION:Group Members Drop Down Values are Captured");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE ' get Group Members Drop Down Values'" + "\n METHOD:isSelectGroupMembersValuepresent \n" + e
                            .getLocalizedMessage());
        }

        for (int i = 0; i < dropdownlist.size(); i++) {
            if (!dropdownlist.equals(value)) {
                flag = true;
            } else {
            	flag = false;
            }
        }

        return flag;

    }

    /**
     * This method helps to get the values of Select Group Memebers
     * 
     * @category Milestone 2
     * @author Raghav S
     * @return boolean
     * @throws Exception
     */

    public List<String> getSelectGroupMembersValues() throws Exception {

        List<String> dropdownlist = new ArrayList<String>();
        try {
            logInstruction("LOGINSTRUCTION:CAPTURING SELECT GROUP MEMEBERS VALUES");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnmoveright, waitTime);

            List<UIElement> elements = drplistright.getUIElementsList();

            for (int i = 0; i < elements.size(); i++) {
                dropdownlist.add(elements.get(i).getText().trim());

            }
            logInstruction("LOGINSTRUCTION:Select Group Memebers Values are Captured");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN  SELECTING THE  'Group Memebers'" + "\n METHOD:getSelectGroupMembersValues \n" + e
                            .getLocalizedMessage());
        }

        return dropdownlist;

    }

    /**
     * This method helps to click on save button
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */
    public CourseAdminGroupManagementPage clickSave() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: CLICK ON SAVE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnsavechanges, waitTime);
            btnsavechanges.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLCKING ON' Save button'" + "\n METHOD:clickSave \n" + e
                    .getLocalizedMessage());
        }
        return new CourseAdminGroupManagementPage(uiDriver);
    }

    /**
     * This method helps verify a group members are highlited or not in Select GroupMembers
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */
    public boolean isHighlitedGroupMembers(String groupmembersname) throws Exception {
       
        try {
            logInstruction("LOGINSTRUCTION:VERIFY GROUP MEMBERS ARE HIGHLITED");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpgroupmembersleft, waitTime);
            drpgroupmembersleft.selectByVisibleText(groupmembersname);
            flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'groupmembers'" + "\n METHOD:isHighlitedGroupMembers \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps verify a group members are Moved toGroupMembers Select box
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */

    public boolean isMovedtoGroupMembers(String groupmembersname) throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION:VERIFY GROUP MEMBERS ARE MOVED");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpgroupmembersright, waitTime);
            drpgroupmembersright.selectByVisibleText(groupmembersname);
            flag= true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'groupmembers'" + "\n METHOD:isMovedtoGroupMembers \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps get the value from name text box
     * 
     * @category Milestone 2
     * @author kiran kumar
     * @return String
     * @throws Exception
     */

    public String getTextFromGroupNameTextBox() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:GETTING VALUE FROM GROUP NAME TXT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtentergroupname, waitTime);
            return txtentergroupname.getAttribute("value").trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE DATA 'text box'" + "\n METHOD:getTextFromGroupNameTextBox \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method helps to get the values of Group Memebers
     * 
     * @category Milestone 2
     * 
     * @author kiran kumar
     * @return List
     * @throws Exception
     */

    public List<String> getGroupMembersValues() throws Exception {

        dropdownlist = new ArrayList<String>();
        try {
            logInstruction("LOGINSTRUCTION:CAPTURING SELECT GROUP MEMEBERS VALUES");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnmoveleft, waitTime);

            elements = drplistleft.getUIElementsList();

            for (int i = 0; i < elements.size(); i++) {
                dropdownlist.add(elements.get(i).getText().trim());

            }
            logInstruction("LOGINSTRUCTION:Select Group Memebers Values are Captured");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE VALUES 'GROUP MEMBERS" + "\n METHOD:getGroupMembersValues \n" + e
                            .getLocalizedMessage());
        }

        return dropdownlist;

    }

    /**
     * This method helps to get the values of Group Memebers if matching name Doesn't Exists its
     * returns-True if matching name exists it returns-false
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isGroupMembersPresent(String value) throws Exception {
        List<String> dropdownlist = new ArrayList<String>();
        try {
            logInstruction("LOG INSTRUCTION:CAPTURING SELECT GROUP MEMEBERS VALUES");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpgroupmembersright, waitTime);

            elements = drplistleft.getUIElementsList();

            for (int i = 0; i < elements.size(); i++) {
                dropdownlist.add(elements.get(i).getText().trim());

            }
            logInstruction("LOG INSTRUCTION:Group Members Drop Down Values are Captured");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE VALUES 'drpdown values" + "\n METHOD:isGroupMembersPresent \n" + e
                            .getLocalizedMessage());
        }

        for (int i = 0; i < dropdownlist.size(); i++) {
            if (!dropdownlist.equals(value)) {
                flag = true;
            } else {
                flag = false;
            }
        }

        return flag;

    }
    

    /**
     * This method helps to create a New Group
     * @param String-Group name-Name of the Group
     * String-selectgroupmembers-Name to be Selected
     * boolen-addgrouporsaveandaddanothergroup
     * click on addgroup-True
     * click on saveandaddanothergroup-False
	 * @ Category Service Level Method
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementPage
     * @throws Exception
     */

    
    public Object createGroup(String groupname,String selectleftgroupmembers,String selectrightgroupmembers,boolean addgrouporsaveandaddanothergroup) throws Exception
    {	
     	try{
    		logInstruction("LOG INSTRUCTION:CREATING A NEW GROUP");
    		frameSwitch.switchToFrameContent();
    		 uiDriver.waitToBeDisplayed(txtentergroupname, waitTime);
             txtentergroupname.clearAndSendKeys(groupname);
             if(selectleftgroupmembers!=null)
             {
            	 uiDriver.waitToBeDisplayed(drpgroupmembersleft, waitTime);
            	 drpgroupmembersleft.selectByVisibleText(selectleftgroupmembers);
            	 uiDriver.waitToBeDisplayed(btnmoveright, waitTime);
                 btnmoveright.clickAndWait(waitTime);
             }
             if(selectrightgroupmembers!=null)
             {
            	 uiDriver.waitToBeDisplayed(drpgroupmembersright, waitTime);
            	 drpgroupmembersright.selectByVisibleText(selectrightgroupmembers);
            	 uiDriver.waitToBeDisplayed(btnmoveleft, waitTime);
            	 btnmoveleft.clickAndWait(waitTime);
             }
             if(addgrouporsaveandaddanothergroup)
             {
            	  uiDriver.waitToBeDisplayed(btnclickaddgroup, waitTime);
                  btnclickaddgroup.clickAndWait(waitTime);
                  return new CourseAdminGroupManagementPage(uiDriver);
             }
             else
             {
            	   uiDriver.waitToBeDisplayed(btnclicksaveandaddgroup, waitTime);
                   btnclicksaveandaddgroup.clickAndWait(waitTime);
                   return new CourseAdminGroupManagementNewGroupPage(uiDriver);
             }
      	}catch(Exception e){
    		throw new Exception("ISSUE IN CREATING THE 'group'"+"\nMETHOD:createGroup\n"+e.getLocalizedMessage());
    		
    	}
    	
    }
    
    
    
    
}
