package com.pearson.eselenium.ls.coursetools.webliography.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

public class WebliographyHomePage extends BasePageObject {

    /* Constructor */

    public WebliographyHomePage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## Webliography Page ##");
    }

    /* elements */
    private UIElement lbltitle = createElement(UIType.Css, "#weblioEntryTitle");
    private UIElement lblcategory = createElement(UIType.Css, "#weblioEntryCategoryTitle");
    private UIElement lblwebaddress = createElement(UIType.Css, "#weblioEntryWebURL");
    private UIElement lbldescription = createElement(UIType.Css, "#weblioEntryDescription");
    private UIElement lblauthor = createElement(UIType.Css, "#weblioEntrySiteAuthor");
    private UIElement lblsitelastedited = createElement(UIType.Css, "#weblioEntrySiteModifiedDate");
    private UIElement txtEntersubmitterfirstname = createElement(
            UIType.Css,
            "#weblioEntrySubmitterFirstName");
    private UIElement txtEntersubmitterlastname = createElement(
            UIType.Css,
            "#weblioEntrySubmitterLastName");
    private UIElement lblgettitle = createElement(UIType.Css, "#weblioEntryTitle");
    private UIElement lblgetselectedcategory = createElement(
            UIType.Css,
            "#weblioEntryCategoryTitle");
    private UIElement lblgetwebaddressurl = createElement(UIType.Css, "#weblioEntryWebURL");
    private UIElement lblgetdescription = createElement(UIType.Css, "#weblioEntryDescription");
    private UIElement lblgetsitelastedited = createElement(
            UIType.Css,
            "#weblioEntrySiteModifiedDate");

    private UIElement lblsubmitter = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]/following-sibling::td[2]");
    private UIElement btnclickadd = createElement(UIType.Css, "a[title='Add New Entry']");
    private UIElement btnclickcancel = createElement(UIType.Css, "#cancelButton");
    private UIElement btnclicksave = createElement(UIType.Css, "#saveButton");
    private UIElement btndelwebilography = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]/following-sibling::td[4]/a/img");
    private UIElement btndelclick = createElement(UIType.Css, "input[value='Delete']");
    private String name = null;
    
    private UIElement lbltitlecategory =  createElement(UIType.Css, "#weblioCategoryTitle");
    private UIElement btnaddcategory = createElement(UIType.Xpath, "//input[@value='Add Category']");
    private UIElement lblwebliogrpahypresent=createElement(UIType.Xpath, "//th[a[contains(text(),'{1}')]]");
    private UIElements lblwebliographyitems=createElements(UIType.Xpath, "//tr/th/a");
    
/* Variables */
    String strTitle = null;
    String strWebaddressurl = null;
    String strDescription = null;
    String strSiteLastEdited = null;
    Select strSelect= null;
    WebElement option;
    String[] strTemp;
    
    /**
     * This method helps to enter the title in the text box
     * 
     * @author ashish.juyal
     * @throws Exception
     */
    public WebliographyHomePage enterTitle(String titletobeEntered) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTER THE TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lbltitle, waitTime);
            lbltitle.sendKeys(titletobeEntered);
        } catch (Exception e) {
            throw new Exception("ISSUE IN ENTERING 'title'" + "\nMETHOD:enterTitle \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to select the category from the dropdown list
     * 
     * @author ashish.juyal
     * @throws Exception
     */

    public WebliographyHomePage selectCategory(String categoryToBeSelected) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING THE CATEGORY");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblcategory, waitTime);
            lblcategory.selectByVisibleText(categoryToBeSelected);
        } catch (Exception e) {
            throw new Exception("ISSUE IN SELECTING 'category'" + "\nMETHOD:selectCategory \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to enter the webAddress
     * 
     * @author ashish.juyal
     * @throws Exception
     */

    public WebliographyHomePage enterWebAddress(String webAddresstext) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING THE WEBADDRESS");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblwebaddress, waitTime);
            lblwebaddress.clearAndSendKeys(webAddresstext);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING 'webaddress'" + "\nMETHOD:enterWebAddress \n" + e
                            .getLocalizedMessage());

        }
        return this;
    }

    /**
     * This method helps to enter the description
     * 
     * @author ashish.juyal
     * @throws Exception
     */

    public WebliographyHomePage enterTheDescription(String descriptionText) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING THE DESCRIPTION");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lbldescription, waitTime);
            lbldescription.clearAndSendKeys(descriptionText);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING 'description'" + "\nMETHOD:enterTheDescription \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to enter the Site Author
     * 
     * @author ashish.juyal
     * @throws Exception
     */
    public WebliographyHomePage enterSiteAuthor(String AuthorText) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTERING SITE AUTHOR");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblauthor, waitTime);
            lblauthor.clearAndSendKeys(AuthorText);
        } catch (Exception e) {
            throw new Exception("ISSUE IN ENTERING 'siteauthor'" + "\nMETHOD:enterSiteAuthor\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to enter the text in sitelastedited
     * 
     * @author ashish.juyal
     * @throws Exception
     */

    public WebliographyHomePage enterSiteLastEdited(String date) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING LAST EDITED SITE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblsitelastedited, waitTime);
            lblsitelastedited.sendKeys(Keys.CONTROL, "a");
            lblsitelastedited.sendKeys(Keys.DELETE);
            lblsitelastedited.sendKeys(date);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING 'lastsiteedited'" + "\nMETHOD:enterSiteLastEdited \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * * Method for Entersubmitterfirstname
     * 
     * @author suchi.singh * @return WebliographyPage
     * @param String
     *            FirstName
     * @throws Exception
     */

    public WebliographyHomePage enterSubmitterFirstName(String FirstName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTER SUBMITTER FIRST NAME");
            frameSwitch.switchToFrameContent();
            txtEntersubmitterfirstname.clearAndSendKeys(FirstName);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING 'submitter' FIRST NAME" + "\nMETHOD:Entersubmitterfirstname\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /***
     * Method for Entersubmitterlastname
     * 
     * @author suchi.singh
     * @return WebliographyPage
     * @param String
     *            LastName
     * @throws Exception
     */

    public WebliographyHomePage enterSubmitterLastName(String LastName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTER SUBMITTER LAST NAME");
            frameSwitch.switchToFrameContent();
            txtEntersubmitterlastname.clearAndSendKeys(LastName);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING 'submitter' LAST NAME" + "\nMETHOD:Entersubmitterlastname\n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /***
     * Method for Gettitle
     * 
     * @author suchi.singh
     * @return String
     * @throws Exception
     */

    public String gettitle() throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION: GETTING TITLE");
            frameSwitch.switchToFrameContent();
            strTitle = lblgettitle.getAttribute("value");
           

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING 'title' " + "\nMETHOD:Gettitle \n" + e
                    .getLocalizedMessage());
        }
        return strTitle;

    }

    /***
     * Method for Getselectedcategory
     * 
     * @author suchi.singh
     * @return String
     * @throws Exception
     */

    public String getSelectedCategory() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELCTED GETTING CATEGORY");
            frameSwitch.switchToFrameContent();

            strSelect = new Select(lblgetselectedcategory);
            option = (WebElement) strSelect.getFirstSelectedOption();
         
            return option.getText();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'selectedcategory'" + "\nMETHOD:getSelectedCategory" + e
                            .getLocalizedMessage());
        }
    }

    /***
     * Method for Getwebaddressurl
     * 
     * @author suchi.singh
     * @return String
     * @throws Exception
     */

    public String getWebAddressUrl() throws Exception {
       

        try {
            logInstruction("LOG INSTRUCTION:GETTING WEB ADDRESS URL");
            frameSwitch.switchToFrameContent();
            strWebaddressurl = lblgetwebaddressurl.getAttribute("value");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'webaddress' URL" + "\nMETHOD:getWebAddressUrl \n" + e
                            .getLocalizedMessage());
        }
        return strWebaddressurl;

    }

    /***
     * Method for getDescription
     * 
     * @author suchi.sing
     * @return String
     * @throws Exception
     */

    public String getDescription() throws Exception {
        

        try {
            logInstruction("LOG INSTRUCTION:GETTING DESCRIPTION");
            frameSwitch.switchToFrameContent();
            strDescription = lblgetdescription.getText();
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING 'description'" + "\nMETHOD:getDescription\n" + e
                    .getLocalizedMessage());
        }
        return strDescription;

    }

    /***
     * Method for getSiteLastEdited
     * 
     * @author suchi.singh
     * @return String
     * @throws Exception
     */

    public String getSiteLastEdited() throws Exception {
        

        try {
            logInstruction("LOG INSTRUCTION: GETTING LAST EDITED SITE");
            frameSwitch.switchToFrameContent();
            strSiteLastEdited = lblgetsitelastedited.getAttribute("value");
           

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'last' EDITED SITE" + "\nMETHOD:getSiteLastEdited \n" + e
                            .getLocalizedMessage());
        }
        return strSiteLastEdited;
    }

    /**
     * This function will give the first name of the submitter.
     * 
     * @param entryName
     *            :: entryName is the name of the entry whose submitter you want to get
     * @return {@link String}
     * @throws {@link Exception}
     * @author Shishir.Dwivedi
     */

    public String getSubmitterFirstName(String entryName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION :GET SUBMITTER FIRST NAME");
            frameSwitch.switchToFrameContent();
            lblsubmitter.replaceValues(entryName.trim());
            uiDriver.waitToBeDisplayed(lblsubmitter, waitTime);
            strTemp = lblsubmitter.getText().trim().split(" ");
            name = strTemp[0];
        } catch (Exception e) {

            logInstruction("ISSUE IN GETTING 'submitter' FIRST NAME" + "\nMETHOD:getSubmitterFirstName \n" + e
                    .getLocalizedMessage());
        }
        return name;
    }

    /**
     * This function will give the Last name of the submitter
     * 
     * @param entryName
     *            :: entryName is the name of the entry whose submitter you want to get
     * @return {@link String}
     * @throws {@link Exception}
     * @author Shishir.Dwivedi
     */

    public String getSubmitterLastName(String entryName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:GETTING SUBMITTER LAST NAME");
            frameSwitch.switchToFrameContent();
            lblsubmitter.replaceValues(entryName.trim());
            uiDriver.waitToBeDisplayed(lblsubmitter, waitTime);
            strTemp = lblsubmitter.getText().trim().split(" ");
            name = strTemp[1];

        } catch (Exception e) {
            logInstruction("UNABLE TO GET 'submitter' LAST NAME" + e.getLocalizedMessage());

        }
        return name;
    }

    /**
     * This Method will click on the Add entry button on webliography page
     * 
     * @return {@link WebliographyHomePage}
     * @throws {@link Exception}
     * @author Shishir.Dwivedi
     * 
     */
    public WebliographyHomePage clickAddEntry() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK ADD ENTRY");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnclickadd, waitTime);
            btnclickadd.clickAndWait(waitTime);
        } catch (Exception e) {

            logInstruction("ISSUE IN CLICKING 'add' ENTRY" + "\nMETHOD:clickAddEntry \n" + e
                    .getLocalizedMessage());
        }

        return this;
    }

    /**
     * This Method will click on the Cancel button on webliography page
     * 
     * @return {@link WebliographyHomePage}
     * @throws {@link Exception}
     * @author Shishir.Dwivedi
     * 
     */
    public WebliographyHomePage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnclickcancel, waitTime);
            btnclickcancel.clickAndWait(waitTime);
        } catch (Exception e) {
            logInstruction("ISSUE IN CLICKING 'cancel' BUTTON" + "\nMETHOD:clickCancelButton\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method will click on the save button on webliography page
     * 
     * @return {@link WebliographyHomePage}
     * @throws {@link Exception}
     * @author Raghav
     * 
     */
    public WebliographyHomePage clickSaveButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK SAVE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnclicksave, waitTime);
            btnclicksave.clickAndWait(waitTime);
        } catch (Exception e) {

            logInstruction("ISSUE IN CLICKING 'save' BUTTON " + "\nMETHOD:clicksaveButton \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method will click on deletebutton on webliography page
     * 
     * @return {@link WebliographyHomePage}
     * @throws {@link Exception}
     * @author kiran kumar
     * 
     */

    public WebliographyHomePage deleteAWebilograpgy(String weblographyname) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: DELETE WEBILOGRAPHY");
            btndelwebilography.replaceValues(weblographyname);
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btndelwebilography, waitTime);
            btndelwebilography.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN DELETING 'webilography'" + "\nMETHOD:deleteAwebilograpgy\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method will click on deletebutton deleteEntery page
     * 
     * @return {@link WebliographyHomePage}
     * @throws {@link Exception}
     * @author kiran kumar
     * 
     */

    public WebliographyHomePage clickDelete() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON DELETE");

            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btndelclick, waitTime);
            btndelclick.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING 'delete'" + "\nMETHOD:clickDelete \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }
    
   
    
    /**Method helps to add Entry
     * @author amit.deshmukh
     * @category Milestone2 Service Level
     * @param title
     * @param category
     * @param webaddress
     * @param description
     * @param author
     * @param lastedited
     * @param firstname
     * @param lastname
     * @return {@link WebliographyHomePage}
     * @throws Exception
     */
    public WebliographyHomePage addEntry(String title,String category,String webaddress,String description,String author,String lastedited,String firstname,String lastname ) throws Exception{
    	
    	logInstruction("LOG INSTRUCTION : ADDING ENTRY");
    	try{
			if(StringUtils.isNotBlank(title)&&StringUtils.isNotBlank(webaddress)){
				
				logInstruction("LOG INSTRUCTION : ENTER TITLE");
				frameSwitch.switchToFrameContent();
	            uiDriver.waitToBeDisplayed(lbltitle, waitTime);
	            lbltitle.clearAndSendKeys(title);
	            
	            if(StringUtils.isBlank(category)){
	            	logInstruction("LOG INSTRUCTION : NO CATEGORY ENTERED");
	            	
	            }
	            else{
	            	logInstruction("LOG INSTRUCTION : ENTER CATEGORY");
	            	uiDriver.waitToBeDisplayed(lblcategory, waitTime);
	                lblcategory.selectByVisibleText(category);
	            }
	            
	            
	            logInstruction("LOG INSTRUCTION: ENTERING THE WEBADDRESS");
	            uiDriver.waitToBeDisplayed(lblwebaddress, waitTime);
	            lblwebaddress.clearAndSendKeys(webaddress);
	            
	            if(StringUtils.isBlank(description)){
	            	
	            	logInstruction("LOG INSTRUCTION:DESCRIPTION NOT ENTERED");
	            }
	            else {
	            logInstruction("LOG INSTRUCTION: ENTERING THE DESCRIPTION");
	            uiDriver.waitToBeDisplayed(lbldescription, waitTime);
	            lbldescription.clearAndSendKeys(description);
	            }
	            
	            if(StringUtils.isBlank(author)){
	            	logInstruction("LOG INSTRUCTION:SITE AUTHOR NOT ENTERED");
	            }
	            else{
	                logInstruction("LOG INSTRUCTION:ENTERING SITE AUTHOR");
		            uiDriver.waitToBeDisplayed(lblauthor, waitTime);
		            lblauthor.clearAndSendKeys(author);
		            
	            }
	            	
	            if(StringUtils.isBlank(lastedited)){
	            	  logInstruction("LOG INSTRUCTION: LAST EDITED SITE NOT ENTERED");
	            }else{
	            	 logInstruction("LOG INSTRUCTION: ENTERING LAST EDITED SITE");
	 	            uiDriver.waitToBeDisplayed(lblsitelastedited, waitTime);
	 	            lblsitelastedited.sendKeys(Keys.CONTROL, "a");
	 	            lblsitelastedited.sendKeys(Keys.DELETE);
	 	            lblsitelastedited.sendKeys(lastedited);
	            }
	            
	            if(StringUtils.isBlank(firstname)){
	            	 logInstruction("LOG INSTRUCTION:FIRST NAME NOT ENTERED");
	            }else{
	            	logInstruction("LOG INSTRUCTION:ENTER SUBMITTER FIRST NAME");
	  	            txtEntersubmitterfirstname.clearAndSendKeys(firstname);
	            }
	            
	            if(StringUtils.isBlank(lastname)){
	            	 logInstruction("LOG INSTRUCTION:LAST NAME NOT ENTERED");
	            }else{
	            	
	            	logInstruction("LOG INSTRUCTION:ENTER SUBMITTER LAST NAME");
	  	            txtEntersubmitterlastname.clearAndSendKeys(lastname);
	            }
				logInstruction("LOG INSTRUCTION : CLICK ADD ENTRY");
	            uiDriver.waitToBeDisplayed(btnclickadd, waitTime);
	            btnclickadd.clickAndWait(waitTime);
	      }
    		
		} catch (Exception e) {
			throw new Exception("UNABLE TO ADD 'entry'"+"\nMETHOD: addEntry \n"+e.getLocalizedMessage());
		}
    	
    	return this;
    	
    	
    }
    
    
    
    
    /**Method helps to edit entry
     * @author amit.deshmukh
     * @category Milestone2 Service level Method
     * @param title
     * @param category
     * @param webaddress
     * @param description
     * @param author
     * @param lastedited
     * @param firstname
     * @param lastname
     * @return WebliographyHomePage
     * @throws Throwable
     */
    public WebliographyHomePage editEntry(String title,String category,String webaddress,String description,String author,String lastedited,String firstname,String lastname ) throws Throwable{
    	
    	logInstruction("LOG INSTRUCTION : EDITING ENTRY");
    	try{
				logInstruction("LOG INSTRUCTION : ENTER TITLE");
				frameSwitch.switchToFrameContent();
				
				if(StringUtils.isNotBlank(title)){
	            uiDriver.waitToBeDisplayed(lbltitle, waitTime);
	            lbltitle.clearAndSendKeys(title);
				}
	            
	            if(StringUtils.isBlank(category)){
	            	logInstruction("LOG INSTRUCTION : NO CATEGORY ENTERED");
	            	
	            }
	            else{
	            	logInstruction("LOG INSTRUCTION : ENTER CATEGORY");
	            	uiDriver.waitToBeDisplayed(lblcategory, waitTime);
	                lblcategory.selectByVisibleText(category);
	            }
	            
	            if(StringUtils.isNotBlank(webaddress)){
	            logInstruction("LOG INSTRUCTION: ENTERING THE WEBADDRESS");
	            uiDriver.waitToBeDisplayed(lblwebaddress, waitTime);
	            lblwebaddress.clearAndSendKeys(webaddress);
	            }
	            
	            if(StringUtils.isBlank(description)){
	            	
	            	logInstruction("LOG INSTRUCTION:DESCRIPTION NOT EDITED");
	            }
	            else {
	            logInstruction("LOG INSTRUCTION: ENTERING THE DESCRIPTION");
	            uiDriver.waitToBeDisplayed(lbldescription, waitTime);
	            lbldescription.clearAndSendKeys(description);
	            }
	            
	            if(StringUtils.isBlank(author)){
	            	logInstruction("LOG INSTRUCTION:SITE AUTHOR NOT EDITED");
	            }
	            else{
	                logInstruction("LOG INSTRUCTION:ENTERING SITE AUTHOR");
		            uiDriver.waitToBeDisplayed(lblauthor, waitTime);
		            lblauthor.clearAndSendKeys(author);
		            
	            }
	            	
	            if(StringUtils.isBlank(lastedited)){
	            	  logInstruction("LOG INSTRUCTION: LAST EDITED SITE NOT EDITED");
	            }else{
	            	 logInstruction("LOG INSTRUCTION: ENTERING LAST EDITED SITE");
	 	            uiDriver.waitToBeDisplayed(lblsitelastedited, waitTime);
	 	            lblsitelastedited.sendKeys(Keys.CONTROL, "a");
	 	            lblsitelastedited.sendKeys(Keys.DELETE);
	 	            lblsitelastedited.sendKeys(lastedited);
	            }
	            
	            if(StringUtils.isBlank(firstname)){
	            	 logInstruction("LOG INSTRUCTION:FIRST NAME NOT EDITED");
	            }else{
	            	logInstruction("LOG INSTRUCTION:ENTER SUBMITTER FIRST NAME");
	  	            txtEntersubmitterfirstname.clear();
	  	            txtEntersubmitterfirstname.clearAndSendKeys(firstname);
	            }
	            
	            if(StringUtils.isBlank(lastname)){
	            	 logInstruction("LOG INSTRUCTION:LAST NAME NOT EDITED");
	            }else{
	            	
	            	logInstruction("LOG INSTRUCTION:ENTER SUBMITTER LAST NAME");
	  	            txtEntersubmitterlastname.clear();
	  	            txtEntersubmitterlastname.clearAndSendKeys(lastname);
	            }
	            
	            logInstruction("LOG INSTRUCTION : CLICK SAVE BUTTON");
	            uiDriver.waitToBeDisplayed(btnclicksave, waitTime);
	            btnclicksave.clickAndWait(waitTime);
	     
		} catch (Exception e) {
			throw new Exception("UNABLE TO EDIT 'entry'"+"\nMETHOD: editEntry \n"+e.getLocalizedMessage());
		}
    	
    	return this;
    }
    
    
  /**Method helps to add new Category
   * @author amit.deshmukh
   * @category Milestone2 Service Level Method
   * @param categoryname
   * @return {@link WebliographyHomePage}
   * @throws Exception
   */
    public WebliographyHomePage addNewCategory(String categoryname) throws Exception{
    	try{
			if(StringUtils.isNotBlank(categoryname))
			{
				logInstruction("LOG INSTRUCTION : ENTER CATEGORY TITLE");
				frameSwitch.switchToFrameContent();
				lbltitlecategory.isDisplayedAfterWaiting(waitTime);
				lbltitlecategory.clearAndSendKeys(categoryname);
				
				logInstruction("LOG INSTRUCTION : CLICK ON ADD CATEGORY");
				btnaddcategory.isDisplayedAfterWaiting(waitTime);
				btnaddcategory.clickAndWait(waitTime);
			}
    		
		} catch (Exception e) {
			throw new Exception("UNABLE TO ADD 'category'"+"\n METHOD:addNewCategory \n"+e.getLocalizedMessage());
		}
    	
    	
    	return this;
    	
    	
    	
    }
    
    

      /**
       * Method helps to verify Whether Webliography Entry is Deleted or not
       * 
       * @author Raghav
       * @return boolean
       * @throws Exception
       */
  	
  	
  	public boolean isWebliographyEntryDeleted(String webliographyEntry) throws Exception
  	{
  		try{
  			logInstruction("LOGINSTRUCTION:VERIFYING WEBLIOGRAPHY ENTRY IS DELETED");
  			frameSwitch.switchToFrameContent();
  			lblwebliogrpahypresent.replaceValues(webliographyEntry);
  			return lblwebliogrpahypresent.isDisplayedAfterWaiting(waitTime);
  			
  		}catch(Exception e){
  			throw new Exception("ISSUE IN VERIFYING THE 'webliography' "+"\nMETHOD:isWebliographyEntryDeleted\n"+e.getLocalizedMessage());
  			
  		}
  	}	
    
    
    
}
