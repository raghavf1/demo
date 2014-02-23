package com.pearson.eselenium.ls.coursetools.courseadmin.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all methods related to CourseAdminGroupManagementPage
 * 
 * @author Raghav
 * @param uiDriver
 * 
 */
public class CourseAdminGroupManagementPage extends BasePageObject {

    /* UI element declarations for CourseAdminGroupManagementPage */
    private UIElement btnaddgroup = createElement(UIType.LinkText, "Add Group");
    private UIElement lnkedit = createElement(
            UIType.Xpath,
            " //td[h3[div[contains(text(),'{1}')]]]/following-sibling::td[1]/a/img");
    private UIElement lnkdelete = createElement(
            UIType.Xpath,
            "//td[h3[div[contains(text(),'{1}')]]]/following-sibling::td[2]/a/img");
    private UIElement lblgroupid = createElement(UIType.Xpath, "//div[contains(text(),'{1}')]");
    private UIElement btndelete = createElement(
            UIType.Xpath,
            "//tr[td[h3[div[contains(text(),'{1}')]]]]/td[3]/a/img");
    private UIElement chkiagree = createElement(UIType.ID, "chk");
    private UIElement btndelgroup = createElement(UIType.Css, "input[name='bttnSubmit']");
    private UIElement txttitle = createElement(UIType.Xpath, "//div[@class='tablehead']");
    private UIElement imgaddlink = createElement(
            UIType.Xpath,
            "//a[contains(text(),'Add Group')]/img");
    private UIElement txtinstructional = createElement(
            UIType.Xpath,
            "//tr[td[contains(text(),'There are no members')]]/preceding-sibling::tr/td/table/tbody/tr/td/h3/div[contains(text(),'{1}')]");
    private UIElement groupDetails = createElement(
            UIType.Xpath,
            "//table[tbody[tr[td[h3[div[contains(text(),'{1}')]]]]]]/following-sibling::table/tbody/tr[{2}]/td");
    private UIElement btngrppresent = createElement(
            UIType.Xpath,
            "//td[h3[div[contains(text(),'{1}')]]]");
    private UIElement txtgrpname = createElement(UIType.Xpath, "//div[contains(text(),'{1}')]");
    private UIElements lblgrouplist=createElements(UIType.Css, "div[class='graytext']");
    
    /*Variables*/
    private boolean flag = false;
    private String strPageTitle = null;
    private String strEntiretitle=null;
    /* constructor */

    public CourseAdminGroupManagementPage(UIDriver driver) {
        super(driver);

        logInstruction("LOG INSTRUCTION:########CourseAdminGroupManagementPage###########");

    }

    /**
     * This method helps to click on AddaGroup
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGeneralandInformationPage
     * @throws Exception
     */
    public CourseAdminGroupManagementNewGroupPage clickAddGroup() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON ADD GROUP");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnaddgroup, waitTime);
            btnaddgroup.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON  'Add Group'" + "\n METHOD:clickAddGroup \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminGroupManagementNewGroupPage(uiDriver);

    }

    /**
     * This method helps to verify editlink
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isEditLinkPresent(String groupName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING EDIT LINK");
            frameSwitch.switchToFrameContent();
            lnkedit.replaceValues(groupName);
            return lnkedit.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'editlink'" + "\n METHOD:isEditLinkPresent \n " + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to verify delete link
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @param groupname
     * @throws Exception
     */
    public boolean isDeleteLinkPresent(String groupName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING DELETE LINK");
            frameSwitch.switchToFrameContent();
            lnkdelete.replaceValues(groupName);
            return lnkdelete.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'delete lnk'" + "\n METHOD:isDeleteLinkPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to verify group id label
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @param groupname
     * @throws Exception
     */
    public boolean isGroupIdLabelPresent(String groupName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING GROUPID LABEL");
            frameSwitch.switchToFrameContent();
            lblgroupid.replaceValues(groupName);
          return lblgroupid.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE ' groupid label'" + "\n METHOD:isGroupIdLabelPresent \n" + e
                            .getLocalizedMessage());
        }
        
    }

    /**
     * This method helps to click on edit
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @param groupname
     * @throws Exception
     */
    public CourseAdminGroupManagementNewGroupPage clickEditLink(String groupName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON EDIT LINK");
            frameSwitch.switchToFrameContent();
            lnkedit.replaceValues(groupName);
            uiDriver.waitToBeDisplayed(lnkedit, waitTime);
            lnkedit.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE ON CLICKING ON 'editlink" + "\n METHOD:clickEditLink \n" + e
                    .getLocalizedMessage());
        }
        return new CourseAdminGroupManagementNewGroupPage(uiDriver);

    }

    /**
     * This method helps to click on delete button
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */
    public CourseAdminGroupManagementPage clickOnDelete(String name) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            btndelete.replaceValues(name);
            uiDriver.waitToBeDisplayed(btndelete, waitTime);
            btndelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON ' delete button'" + "\n METHOD:clickOnDelete \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on deletegroup button
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */

    public CourseAdminGroupManagementPage clickDeleteGroup() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON DELETEGROUP BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btndelgroup, waitTime);
            btndelgroup.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'deletegroup button'" + "\n METHOD :clickDeleteGroup \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on i agree button
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */

    public CourseAdminGroupManagementPage clickIAgree() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON I AGREE CHECKBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkiagree, waitTime);
            chkiagree.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON ' i agree checkbox'" + "\n METHOD:clickIAgree \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to get the title of GroupManagement Page
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminGroupManagementNewGroupPage
     * @throws Exception
     */
    public String getTitle() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:GETS THE TITLE OF GROUPMANAGEMENTPAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txttitle, waitTime);
            strPageTitle = txttitle.getText().trim();

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE 'title'" + "\n METHOD:getTitle \n" + e
                    .getLocalizedMessage());
        }
        return strPageTitle;
    }

    /**
     * This method helps to verify Add Group is Present
     * 
     * @category Milestone 2
     * @author Raghav S
     * @return boolean
     * @throws Exception
     */
    public boolean isAddGroupPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING ADD GROUP LINK PRESENT");
            frameSwitch.switchToFrameContent();
            return btnaddgroup.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE'Add Group Link'" + "\n METHOD:isAddGroupPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to verify Add Group image is Present
     * 
     * @category Milestone 2
     * @author Raghav S
     * @return boolean
     * @throws Exception
     */
    public boolean isAddGroupImagePresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING ADD GROUP IMAGE PRESENT");
            frameSwitch.switchToFrameContent();
            return imgaddlink.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE ' Add Group Image editlink'" + "\n METHOD:isAddGroupImagePresent \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method helps to verify the instructional text below group without group members.
     * 
     * @author kiran .kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isInstructionalTextPresentBelowGroup(String groupname) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING INSTRUCTIONAL TXT BELOE THE GROUP");
            frameSwitch.switchToFrameContent();
            txtinstructional.replaceValues(groupname);
            return txtinstructional.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'Add Group Image editlink'" + "\n METHOD:isInstructionalTextPresentBelowGroup \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to verify the members details
     * 
     * @author kiran .kumar
     * @return String
     * @throws Exception
     */

    public String getGroupMemberDetails(String groupname, String rownum) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:GETTING DETAILS OF GROUP MEMBERS ");
            frameSwitch.switchToFrameContent();
            groupDetails.replaceValues(groupname, rownum);
            return groupDetails.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'groupmember details'" + "\n METHOD:getGroupMemberDetails \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method helps to verify whether group is present
     * 
     * @category Milestone 2
     * @author Raghav
     * @return boolean
     * @throws Exception
     */

    public boolean isGroupNamePresent(String groupname) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:VERIFIYING THE GROUPNAME ");
            frameSwitch.switchToFrameContent();
            btngrppresent.replaceValues(groupname);
            return btngrppresent.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE ' Group name'" + "\n METHOD :isGroupNamePresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to get the groupname
     * 
     * @category Milestone 2
     * @author Raghav
     * @return String
     * @throws Exception
     */

    public String getEntireGroupName(String groupname) throws Exception {
         strEntiretitle = null;
        try {
            logInstruction("LOG INSTRUCTION:GETS THE TITLE OF GROUPMANAGEMENTPAGE");
            frameSwitch.switchToFrameContent();
            txtgrpname.replaceValues(groupname);
            uiDriver.waitToBeDisplayed(txtgrpname, waitTime);
            strEntiretitle = txtgrpname.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'groupname'" + "\n METHOD:getEntireGroupName \n" + e
                            .getLocalizedMessage());
        }
        return strEntiretitle;
    }
    
    
    /**
     * This method helps to delete a group
     * @Service Level Method
     * @category Milestone 2
     * @author Raghav
     * @return String
     * @throws Exception
     */
    public CourseAdminGroupManagementPage deleteGroup(String groupName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:DELETES A GROUP");
            frameSwitch.switchToFrameContent();
            btndelete.replaceValues(groupName);
            uiDriver.waitToBeDisplayed(btndelete, waitTime);
            btndelete.clickAndWait(waitTime);
            uiDriver.waitToBeDisplayed(chkiagree, waitTime);
            chkiagree.clickAndWait(waitTime);
            uiDriver.waitToBeDisplayed(btndelgroup, waitTime);
            btndelgroup.clickAndWait(waitTime);
      } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN DELETING THE 'group'" + "\n METHOD:clickOnDelete \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }
    
      
    /**
     * This Method Returns the Group List of Entries with LSAutoPrefix and with Specified Time Stamp
     * 
     * @param 
     * @return
     * @throws Exception
     * @author Raghav S
     */
       public List<String> getGroupNameList() throws Exception {
		 List<String> grouplistname = new ArrayList<String>();
		try {
			logInstruction("LOGINSTRUCTION:GETTING THE GROUP NAME LIST");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = lblgrouplist.getUIElementsList();
			for (int i = 0; i < elements.size(); i++) {
							if (StringUtils.isNotBlank(elements.get(i).getText())
						 && (elements.get(i).getText().trim().contains("LSAutoTest")) && (cleanup.verifyOnedayTimeStamp(elements.get(i).getText().trim()))) {
	
			grouplistname.add(elements.get(i).getText().trim());
				}
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN  GETTING THE  'Group' MEMEBERS LIST"
					+ "\n METHOD:getGroupNameList \n"
					+ e.getLocalizedMessage());
		}

		return grouplistname;

	}

    
       /**
        * Method helps to verify Whether Uploaded DocSharing Page is Deleted or not
        * 
        * @author Raghav
        * @return boolean
        * @throws Exception
        */
   	
   	
   	public boolean isGroupDeleted(String groupName) throws Exception
   	{
   		try{
   			logInstruction("LOGINSTRUCTION:VERIFYING WHETHER GROUP IS DELETED");
   			frameSwitch.switchToFrameContent();
   			btngrppresent.replaceValues(groupName);
   			return btngrppresent.isDisplayedAfterWaiting(waitTime);
   			
   		}catch(Exception e){
   			throw new Exception("ISSUE IN VERIFYING THE 'group' "+"\nMETHOD:isGroupDeleted\n"+e.getLocalizedMessage());
   			
   		}
   	
   	}
       
       
       
}
