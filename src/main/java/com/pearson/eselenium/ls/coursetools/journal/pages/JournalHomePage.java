package com.pearson.eselenium.ls.coursetools.journal.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.PlainTextEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

public class JournalHomePage extends BasePageObject {

    /* UI Elements */
    private UIElement txtentercontent = createElement(UIType.Xpath, "//html/body");
    private UIElement radselectingsharing = createElement(
            UIType.Xpath,
            "//div[@role='radiogroup']/input[{1}]");
    private UIElement btnjournal = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    private UIElement btnaddentry = createElement(UIType.Css, ".subnavoff");
    private UIElement txtentertitle = createElement(UIType.Css, "#Title");
    private UIElement btnclickaddentryButton = createElement(UIType.Css, "input[value='Add Entry']");
    private UIElement btncancel = createElement(
            UIType.Css,
            ".outercontenttable table:nth-child(1) input[value='Cancel']");
    private UIElement getheaderjournal = createElement(UIType.Css, ".tablehead");
    private UIElement btnclickdelete = createElement(UIType.Css, "input[value='Delete']");
    private UIElement btnclickondelete = createElement(
            UIType.Xpath,
            "//tr[th[a[contains(text(),'{1}')]]]/td[4]/a/img");
    private UIElement lbljournalentry = createElement(UIType.LinkText, "{1}");
    private UIElement btneditjournal = createElement(
            UIType.Xpath,
            "//td[a[contains(text(),'{1}')]]/following-sibling::td[2]/a/img");
    private UIElement lbleditpagepresent = createElement(UIType.Css, ".tablehead");
    private UIElement btnsavechanges = createElement(
            UIType.Xpath,
            "//tr/td[2]/input[@value='Save Changes']");
    private UIElement lblDateTime = createElement(
            UIType.Xpath,
            "//tr[contains(@id,'collapsed')]//td[a[contains(text(),'{1}')]]/following-sibling::td[1]");
    private UIElement lnkExapandAll = createElement(UIType.LinkText, "Expand All");
    private String contentRadEditorTableId = "RadeEntryTextTop";
    // VisualEditor visualEditor = new VisualEditor(uiDriver, contentRadEditorTableId);
    PlainTextEditor plainEditor = new PlainTextEditor(uiDriver);
    private UIElement areaplaintexteditor = createElement(
            UIType.Xpath,
            "//a[@id='RadCourseText_simpleEditor']");
    private UIElement lnkJournal = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
  	private UIElement lbljournalEntry=createElement(UIType.Xpath, "//th[a[contains(text(),'{1}')]]"); 
    private UIElements lbljournalitems=createElements(UIType.Xpath, "//tr/th/a");
    
    
    		

    /* Variables */
    boolean journal = false;
    boolean flag = false;
    String strHeaderName = null;
    String strDateTime = null;
    
    /* Constructor */
    public JournalHomePage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## Journal Page ##");
    }

    // /***
    // * Method for EnterContent
    // *
    // * @author amit.deshmukh * @return JournalPage
    // * @param String
    // * * @throws Exception
    // */
    //
    // public JournalHomePage entercontent(String Content) throws Exception {
    // try {
    //
    // frameSwitch.switchToFrameContent();
    // visualEditor.clickRadEditorIcon(
    // VisualEditorElementsEnum.MOVE_FOCUS_TO_TEXT_EDITOR,
    // contentRadEditorTableId);
    // uiDriver.sendKeysToBrowser(Content);
    //
    // /*
    // * logInstruction("LOG INSTRUCTION: Enter Content");
    // * frameSwitch.switchToRadeEntryTextcontentIframe(); // changes
    // * frame uiDriver.waitToBeDisplayed(entercontent, waitTime);
    // * entercontent.sendKeys(Content);
    // */
    //
    // } catch (Exception e) {
    // throw new Exception("Unable to enter Content"
    // + e.getLocalizedMessage());
    // }
    // return this;
    //
    // }

    /**
     *  Method for selectingsharingRadioButton 
     *@author suchi.singh 
     *@return JournalPage
     * 
     *@param String
     *SharingOption 
     *@throws Exception
     */

    public JournalHomePage selectingSharingRadioButton(String SharingOption) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:SELECTING SHARE RADIO BUTTON");
            frameSwitch.switchToFrameContent();
            radselectingsharing.replaceValues(SharingOption);
            radselectingsharing.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING 'share' RADIO BUTTON" + "\nMETHOD:selectingSharingRadioButton\n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method will click on the given journal name
     * 
     * @param journalName
     *            Name of the journal on which you want to click.
     * @return {@link JournalHomePage}
     * @throws Exception
     * @author Shishir.Dwivedi
     * 
     */
    public JournalHomePage clickJournalName(String journalName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKS ON JOURNAL NAME");
            frameSwitch.switchToFrameContent();
            btnjournal.replaceValues(journalName.trim());            
            btnjournal.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'journal' NAME " + "\nMETHOD:clickJournalName\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will click on Add entry Name.
     * 
     * @return {@link AddJournalEntryPage}
     * @throws Exception
     * @author Shishir.Dwivedi
     * 
     */
    public AddJournalEntryPage clickAddEntry() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKS ON ADD ENTRY BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnaddentry, waitTime);
            btnaddentry.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'add' ENTRY BUTTON" + "\nMETHOD:clickAddEntry\n" + e
                            .getLocalizedMessage());
        }
        return new AddJournalEntryPage(uiDriver);
    }

    /**
     * This method enter the title
     * 
     * @param
     * @return {@link JournalHomePage}
     * @throws Exception
     * @author Shishir.Dwivedi
     * 
     */
    public JournalHomePage enterTitle(String title) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENETRING THE JOURNAL TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtentertitle, waitTime);
            txtentertitle.clearAndSendKeys(title);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTRTING THE 'journal' TITLE" + "\nMETHOD:enterTitle\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will click on add Entry button
     * 
     * @return {@link JournalHomePage}
     * @throws {@link Exception}
     * @author Shishir.Dwivedi
     */
    public JournalHomePage clickToAddJournal() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON ADD JOURNAL");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnclickaddentryButton, waitTime);
            btnclickaddentryButton.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'add' JOURNAL" + "\nMETHOD:clickToAddJournal\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will click on Cancel button
     * 
     * @return {@link JournalHomePage}
     * @throws {@link Exception}
     * @author Shishir.Dwivedi
     */
    public JournalHomePage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btncancel, waitTime);
            btncancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'cancel' BUTTON " + "\nMETHOD:clickCancelButton\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to get header info of journal
     * 
     * @author amit.deshmukh
     * @return String
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(getheaderjournal, waitTime);
            strHeaderName = getheaderjournal.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'header' TITLE" + "\nMETHOD:getHeaderTitle\n" + e
                            .getLocalizedMessage());
        }

        return strHeaderName;
    }

    /**
     * Method helps to click on delete
     * 
     * @author amit.deshmukh
     * @return DocumentSharingPage
     */
    public JournalHomePage clickOnDelete(String FileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK " + FileName + "DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            btnclickondelete.replaceValues(FileName.trim());
            uiDriver.waitToBeDisplayed(btnclickondelete, waitTime);
            btnclickondelete.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'delete' BUTTON" + "\nMETHOD:clickOnDelete\n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method will verify given journal is present or not
     * 
     * @param journalName
     * @return {@link JournalHomePage}
     * @throws Exception
     * @author amit.deshmukh
     * 
     */
    public boolean isJournalPresent(String journalName) throws Exception {

        
        try {
            logInstruction("LOG INSTRUCTION:VERIFIYING THE JOURNAL ENTRY");
            if (lbljournalentry.replaceValues(journalName.trim()).isDisplayed()) {
                String temp = lbljournalentry.getText();
                if (temp.contains(journalName))
                    return journal = true;
            }
        } catch (Exception e) {

            throw new Exception(
                    "ISSUE IN VERIFYING 'journal' ENTRY " + "\nMETHOD:isJournalPresent\n" + e
                            .getLocalizedMessage());
        }
        return journal;
    }

    /**
     * Method helps to click on delete
     * 
     * @author amit.deshmukh
     * @return {@link JournalHomePage}
     */
    public EditJournalPage clickOnEdit(String FileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON  " + FileName + "EDIT BUTTON");
            frameSwitch.switchToFrameContent();
            btneditjournal.replaceValues(FileName.trim());
            uiDriver.waitToBeDisplayed(btneditjournal, waitTime);
            btneditjournal.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING 'edit' BUTTON" + "\nMETHOD:clickOnEdit\n" + e
                    .getLocalizedMessage());
        }
        return new EditJournalPage(uiDriver);

    }

    /**
     * method used to determine whether edit page is present
     * 
     * @author amit.deshmukh
     * @return {@link Boolean}
     * @throws Exception
     */

    public boolean isEditPagePresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFTING EDIT BUTTON");
            frameSwitch.switchToFrameContent();
            return lbleditpagepresent.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN VERIFYING 'edit' BUTTON" + "\nMETHOD:isEditPagePresent\n");
        }

    }

    /**
     * method helps to verify whether private entry is present or not
     * 
     * @author amit.deshmukh
     * @param Filename
     * @return {@link Boolean}
     * @throws Exception
     */

    public boolean isPrivateEntryPresent(String Filename) throws Exception {
        boolean entrypresent = false;
        try {
            logInstruction("LOG INSTRUCTION:VERIFTING PRIVATE ENTRY PRESENT");
            lbljournalentry.replaceValues(Filename.trim());
            if (lbljournalentry.getText().trim().contains("(Private Entry)")) {
                return entrypresent = true;

            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFIYING PRIVATE ENTRY" + "\nMETHOD:isPrivateEntryPresent\n" + e
                            .getLocalizedMessage());
        }

        return entrypresent;

    }

    /**
     * method helps to click delete button after u click on delete image
     * 
     * @author amit.deshmukh
     * @return {@link JournalHomePage}
     * @throws Exception
     */

    public JournalHomePage clickOnDeleteButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:CLICK ON DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnclickdelete, waitTime);
            btnclickdelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'delete' BUTTON" + "\nMETHOD:clickOnDeleteButton\n");
        }

        return this;

    }

    /**
     * method helps to click save changes after edit
     * 
     * @author amit.deshmukh
     * @return {@link JournalHomePage}
     * @throws Exception
     */
    public JournalHomePage clickSaveChanges() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON SAVE CHANGES");
            uiDriver.waitToBeDisplayed(btnsavechanges, waitTime);
            btnsavechanges.clickAndWait(waitTime);
        } catch (Exception e) {

            throw new Exception(
                    "ISSUE IN CLICKING SAVE CHANGES BUTTON" + "\nMETHOD:clickSaveChanges\n" + e
                            .getLocalizedMessage());

        }
        return this;
    }

    /**
     * method helps to find updated time after edit
     * 
     * @param nameOfAnnouncement
     * @return
     * @throws Exception
     */
    public String afterEditDateTime(String nameOfAnnouncement) throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE AFTER EDIT DATE TIME OF ANNOUNCEMENT");
            frameSwitch.switchToFrameContent();
            strDateTime = lblDateTime.replaceValues(nameOfAnnouncement).getText();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'after edit'DATE TIME OF ANNOUNCEMENT" + "\nMETHOD:afterEditDateTime\n" + e
                            .getLocalizedMessage());
        }
        return strDateTime;
    }

    /**
     * method helps to find updated time after edit
     * 
     * @author amit.deshmukh
     * @param nameOfAnnouncement
     * @return
     * @throws Exception
     */
    public String beforeEditDateTime(String nameOfAnnouncement) throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE BEFORE EDIT TIME ANNOUNCEMENT");

            frameSwitch.switchToFrameContent();
            strDateTime = lblDateTime.replaceValues(nameOfAnnouncement).getText();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'before edit'DATE TIME OF ANNOUNCEMENT" + "\nMETHOD:afterEditDateTime\n" + e
                            .getLocalizedMessage());
        }

        return strDateTime;

    }

    /**
     * this Method will click on Expand all link
     * 
     * @return {@link JournalHomePage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public JournalHomePage clickExapandAllLink() throws Exception {
        try {
            logInstruction("LOG INSTRCUTION : CLICKING ON EXPAND ALL LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkExapandAll, waitTime);
            lnkExapandAll.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE EXPAND ALL LINK \n METHOD: clickExapandAllLink");
        }
        return this;
    }

    /**
     * This method checks whether whether the simple editor is displayed or not
     * 
     * @author ashish.juyal
     * @return:boolean
     * @throws Exception
     * 
     */

    public boolean isSimpleEditorDisplayed() throws Exception {
        
        try {
            logInstruction("checking for the plain text editor");
            frameSwitch.switchToFrameContent();
            Thread.sleep(9000);
            flag = areaplaintexteditor.isAbsent();
        } catch (Exception e) {
            throw new Exception("cannot execute the simpleeditor displayed method" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click on journal link.
     * 
     * @param link
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public JournalHomePage clickOnJournalLink(String link) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON JOURNAL LINK");
            frameSwitch.switchToFrameContent();
            lnkJournal.replaceValues(link);
            uiDriver.waitToBeDisplayed(lnkJournal, waitTime);
            lnkJournal.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("CANNOT EXECUTE THE SIMPLEEDITOR DISPLAYED METHOD" + e
                    .getLocalizedMessage());
        }
        return this;
    }
    
  
   

    
    /**
     * This Method Returns the Journal List of Entries with LSAutoPrefix and with Specified Time Stamp
     * 
     * @param 
     * @return
     * @throws Exception
     * @author Raghav S
     */
      public List<String> getJournalList() throws Exception {
		 List<String> journallist = new ArrayList<String>();
		try {
			logInstruction("LOG INSTRUCTION:GETTING JOURNAL LIST ENTRIES");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = lbljournalitems.getUIElementsList();
			for (int i = 0; i < elements.size(); i++) {
							if (StringUtils.isNotBlank(elements.get(i).getText())
						 && (elements.get(i).getText().trim().contains("LSAutoTest")) && (cleanup.verifyOnedayTimeStamp(elements.get(i).getText().trim())) ) {
	
			journallist.add(elements.get(i).getText().trim());
				}
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN  GETTING  'journal' ENTRIES"
					+ "\n METHOD:getJournalList \n"
					+ e.getLocalizedMessage());
		}

		return journallist;

	}
      
      
      /**
       * Method helps to verify Whether Journal Entry is Deleted or not
       * 
       * @author Raghav
       * @return boolean
       * @throws Exception
       */
  	
  	
  	public boolean isJournalEntryDeleted(String journalEntry) throws Exception
  	{
  		try{
  			logInstruction("LOGINSTRUCTION:VERIFYING JOURNAL ENTRY IS DELETED");
  			frameSwitch.switchToFrameContent();
  			lbljournalEntry.replaceValues(journalEntry);
  			return lbljournalEntry.isDisplayedAfterWaiting(waitTime);
  			
  		}catch(Exception e){
  			throw new Exception("ISSUE IN VERIFYING THE 'journal' "+"\nMETHOD:isJournalEntryDeleted\n"+e.getLocalizedMessage());
  			
  		}
  	}
    
}
