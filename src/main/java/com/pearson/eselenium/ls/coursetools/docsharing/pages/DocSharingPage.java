package com.pearson.eselenium.ls.coursetools.docsharing.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.elements.DefaultUIActions;
import com.pearson.test.eselenium.framework.elements.UIActions;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of Doc Sharing
 * 
 * the below steps to navigate the page: Login as prof Click on the Course Select Author Tab Click
 * on Doc Sharing tools
 * 
 * @author Hemant.Kumar
 */
public class DocSharingPage extends BasePageObject {

    /* Elements */
    private UIElement lnkaddcategory = createElement(UIType.LinkText, "Add Category");
    private UIElement lnkuploaddocument = createElement(
            UIType.Xpath,
            "//a[contains(text(),'Upload Document')]");
    private UIElement lnkdownloaddocument = createElement(
            UIType.Xpath,
            "//a[contains(text(),'Download Documents')]");
    private UIElement chkselectAll = createElement(UIType.ID, "toggleSelection");
    private UIElement lblcategoryHeader = createElement(
            UIType.Xpath,
            "//h3[@class='headertitle']/div");
    private UIElement drpassignTo = createElement(UIType.Xpath, "//label[@for='GroupID']");
    private UIElement lblErrorMessage = createElement(
            UIType.Xpath,
            "//td[@class='inlineerror']/table/tbody/tr/td[2]");
    private UIElement lblHeaderMessage = createElement(UIType.Xpath, "//h2[@class='headertitle']/div");
    private UIElement btnClickedit = createElement(
            UIType.Xpath,
            "//tr[th[a[contains(@title,'{1}')]]]/td[1]/a/img[@title='Edit Category']");
    private UIElement btnClickdelete = createElement(
            UIType.Xpath,
            "//tr[th[a[contains(@title,'{1}')]]]/td[2]/a/img[@title='Delete Category']");
    private UIElement drpselectCategory = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    private UIElement btnEdit = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]/following-sibling::td[6]/a/img");
    private UIElement btnDelete = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]/following-sibling::td[7]/a/img");
    private UIElement chkselect = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]/preceding-sibling::td[1]/input");
    private UIElement btnclikdownloads = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]/a");
    private UIElement btndownloadCnt = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]/following-sibling::td[5]/a");
    private UIElement lblownerName = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]/following-sibling::td[1]");
    private UIElement lblDteTime = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]/following-sibling::td[2]");
    private UIElement lnkdocSharing = createElement(UIType.LinkText, "{1}");
    private UIElement lblcheckHeader = createElement(UIType.Name, "{1}");
    private UIElement lblfile = createElement(UIType.Name, "{1}");
    private UIElement lblvalue = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]/following-sibling::td[4]/a");
    private UIElement lnkshare = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]/following-sibling::td[4]/a");
    private UIElement txtdescription = createElement(UIType.Css, "#fileDescriptions[0]");
    private UIElement lnkUplodedDisplayed = createElement(UIType.Xpath, "//a[@title='Open {1}']");
    private UIElement lnkclickinstructororentireclass = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]/following-sibling::td[4]/a");
    private UIElement lbldatetimearrow = createElement(
            UIType.Css,
            "a[title='Sort by Date/Time']>img");
    private UIElement lblcoloumnnameforaddcategory = createElement(
            UIType.Xpath,
            "//table[@summary='Categories']/tbody/tr/th[contains(text(),'{1}')]");
    private UIElement lblgetCourseName = createElement(
            UIType.Xpath,
            "//table[@summary='Categories']/tbody/tr[2]/th");
    private UIElement lblColoumnname = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    private UIElement lblDiscreption = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]");

    private UIElement lblpagetitle = createElement(UIType.Css, ".pageTitle");
    private UIElement lbldisplayed = createElement(UIType.Xpath, "//th[contains(text(),'{1}')]");
    private UIElement lblbottompagetitle = createElement(UIType.Xpath, "//div[@class='dkgraytext']");
    private UIElement divActiveElement = createElement(UIType.Css, ".dkgraytext");
    private UIElement lblTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement lnkcategory = createElement(UIType.Xpath,"//a[contains(text(),'{1}')]");
    private UIElement chkiagree = createElement(UIType.ID, "isConfirmed");
    private UIElement btndeletecategory = createElement(UIType.ID, "deleteCategoryAndFilesButton");
    private UIElement btndeletewothoutuploading = createElement(UIType.ID, "deleteCategoryButton");
    private UIElements lbldocsharinguploadedvalues=createElements(UIType.Xpath, "//form[@id='listCategoriesAndFilesView']//table[7]/tbody//tr//th/a");
    private UIElements lbl=createElements(UIType.Xpath, "//form[@id='listCategoriesAndFilesView']//table[3]/tbody//tr//th/a");
    
    /* Variables*/
    
    private String strCount = null;
    private String strOwnerName = null;
    private String strDateAndTime = null;
    private String strCategoryHeaderText = null;
    private String strShareLinkName;
    private String strAssignToTextString = null;
    private String strErrorMessage = null;
    private String strHeaderName = null;
    private String strValueCourseName = null;
    private String strValueDateNTime = null;
    private String strValueColumName = null;
    private String strPageTitle = null;
    private String strBottomPageTitle = null;
    private String strClientHeight = null;
    private String strScrollHeight = null;
    private String strInstructorAttribute = null;
    private boolean flag = false;
    int clientHeightInt;
    int scrollHeightInt;
    /* Constructor */
    public DocSharingPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: #####DocSharingPage#####");

    }

    /**
     * This method click the Add Category link in the AddUnitPage
     * 
     * @returns DocSharingPage
     * @throws Exception
     * @author Hemant.kumar
     */
    public AddCategoryPage clickAddCategoryLink() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICKS ON ADD CATEGORY LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkaddcategory, waitTime);
            lnkaddcategory.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'add category' Link" + "\n METHOD:clickAddCategoryLink\n" + e
                            .getLocalizedMessage());
        }
        return new AddCategoryPage(uiDriver);
    }

    /**
     * This method helps to select Category
     * 
     * 
     * @returns AddCategoryPage
     * @throws Exception
     * @author Hemant.kumar
     */
    public DocSharingPage selectCategory(String CategoryName) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: SELECTING A CATEGORY FROM DROP DOWN ");
            frameSwitch.switchToFrameContent();
            drpselectCategory.replaceValues(CategoryName);
            uiDriver.waitToBeDisplayed(drpselectCategory, waitTime);
            drpselectCategory.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING FROM 'category'" + "\nMETHOD:selectCategory\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method click the Upload Document Link DocSharingPage
     * 
     * @throws Exception
     * @author Hemant.kumar
     */

    public UploadDocumentSharingEntryPage clickUploadDocumentLink() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:CLICK ON UPLOAD DOCUMENT LINK");
            frameSwitch.switchToFrameContent();
            lnkuploaddocument.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'upload' LINK" + "\nMETHOD:clickUploadDocumentLink\n" + e
                            .getLocalizedMessage());
        }

        return new UploadDocumentSharingEntryPage(uiDriver);
    }

    /**
     * This method click the Download Document Page DocSharingPage
     * 
     * @throws Exception
     * @author Hemant.kumar
     */
    public DocSharingPage clickDownloadDocumentLink() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:CLICK ON DOWNLOAD DOCUMENT LINK");
            frameSwitch.switchToFrameContent();
            lnkdownloaddocument.isDisplayedAfterWaiting(waitTime);
            if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
                lnkdownloaddocument.clickByJavascript();
                Thread.sleep(waitTime); // Since clickAndWait() is hanging, performing the same
            } else {
                lnkdownloaddocument.clickAndWait(waitTime);
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'download' LINK" + "\nMETHOD:clickDownloadDocumentLink\n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps toselect all files through chk box
     * 
     * @author kiran kumar s
     * @return DocumentSharingPage
     */
    public DocSharingPage selectAllCheckBox() throws Exception {
        try {

            logInstruction("LOG INSTRUCTION: SELECTING ALL CHECKBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkselectAll, waitTime);
            chkselectAll.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING 'all check box'" + "\n METHOD:selectAllCheckBox\n" + e
                            .getLocalizedMessage());
        }

        return this;

    }

    /**
     * Method helps to click on edit
     * 
     * @author kiran kumar s
     * @return DocumentSharingPage
     */
    public EditDocSharingEntryPage clickOnEditCourseButton(String FileName) throws Exception {
    	
        try {
        	
            logInstruction("LOG INSTRUCTION: CLICKING ON EDIT COURSE BUTTON");
            frameSwitch.switchToFrameContent();
            btnEdit.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(btnEdit, waitTime);
            btnEdit.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'edit' BUTTON" + "\n METHOD:clickOnEditCourseButton \n" + e
                            .getLocalizedMessage());
        }
        return new EditDocSharingEntryPage(uiDriver);

    }

    /**
     * Method helps to click on delete
     * 
     * @author kiran kumar s
     * @return DocumentSharingPage
     */

    public DeleteDocSharingEntryPage clickOnDeleteCourseButton(String FileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON DELETE COURSE BUTTON");
            frameSwitch.switchToFrameContent();
            btnDelete.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(btnDelete, waitTime);

            btnDelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'delete' COURSE BUTTON" + "\nMETHOD:clickOnDeleteCourseButton\n" + e
                            .getLocalizedMessage());
        }
        return new DeleteDocSharingEntryPage(uiDriver);

    }

    /**
     * Method helps to verify Whether click on Edit is Present
     * 
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isCourseEditButtonDisplayed(String FileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : VERFIYING EDIT BUTTON ");
            frameSwitch.switchToFrameContent();
            btnEdit.replaceValues(FileName);
            return btnEdit.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'edit' BUTTON" + "\n METHOD:isCourseEditButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method helps to verify Whether Click On Delete Is Present or Not
     * 
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public boolean isCourseDeleteButtonDisplayed(String FileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : VERFIYING DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            btnDelete.replaceValues(FileName);
            return btnDelete.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFIYING 'delete' BUTTON" + "\n METHOD: isCourseDeleteButtonDisplayed\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method helps to select a file by chk box
     * 
     * @author kiran kumar s
     * @return DocumentSharingPage
     */
    public DocSharingPage selectAFile(String FileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:SELECTING A FILE");
            frameSwitch.switchToFrameContent();
            chkselect.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(chkselect, waitTime);
            chkselect.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("ISSUE IN SELECTING A 'file'" + "\nMETHOD:selectAFile\n" + e
                    .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps to click on download btn for a particular file
     * 
     * @author Raghav S
     * @return DownloadDocSharingPage
     */
    public DownloadDocSharingPage clickOnDownload(String FileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON DOWNLOAD");
            frameSwitch.switchToFrameContent();
            btndownloadCnt.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(btndownloadCnt, waitTime);
            if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
                btndownloadCnt.clickByJavascript();
                Thread.sleep(waitTime); // Since clickAndWait() is hanging, performing the same
            } else {
                btndownloadCnt.clickAndWait(waitTime);
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'download' BUTTON" + "\nMETHOD:clickOnDownload\n" + e
                            .getLocalizedMessage());
        }
        return new DownloadDocSharingPage(uiDriver);

    }

    /**
     * Method helps to get download count
     * 
     * @author kiran kumar s
     * @return DocumentSharingPage
     */
    public String getDownloadCount(String FileName) throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE DOWNLOAD COUNT");
            frameSwitch.switchToFrameContent();
            btndownloadCnt.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(btndownloadCnt, waitTime);
            strCount = btndownloadCnt.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'download' COUNT" + "\n METHOD:getDownloadCount\n" + e
                            .getLocalizedMessage());

        }
        return strCount;
    }

    /**
     * Method helps to get owner name
     * 
     * @author kiran kumar s
     * @return DocumentSharingPage
     */
    public String getOwnerName(String FileName) throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE OWNER NAME");
            frameSwitch.switchToFrameContent();
            lblownerName.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(lblownerName, waitTime);
            strOwnerName = lblownerName.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'owner' NAME" + "\n METHOD:getOwnerName\n" + e
                            .getLocalizedMessage());

        }
        return strOwnerName;
    }

    /**
     * Method helps to get date and time
     * 
     * @author kiran kumar s
     * @return DocumentSharingPage
     */
    public String getDateTime(String FileName) throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE DATE AND TIME");
            frameSwitch.switchToFrameContent();
            lblDteTime.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(lblDteTime, waitTime);
            strDateAndTime = lblDteTime.getText().trim();

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING 'date and time'" + "\nMETHOD:getDateTime\n" + e
                    .getLocalizedMessage());

        }
        return strDateAndTime;
    }

    /**
     * This method sorts documents by header name
     * value-FileName/Descriptor,Owner,Date/time,Size,share,Downloads
     * 
     * @author Raghav
     * 
     * @return DocsharingPage
     * @throws Exception
     */
    public DocSharingPage clickSortBy(String value) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON SORT BY");
            frameSwitch.switchToFrameContent();
            lblcheckHeader.replaceValues(value);
            uiDriver.waitToBeDisplayed(lblcheckHeader, waitTime);
            lblcheckHeader.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING 'sort' BY" + "\nMETHOD:clickSortBy\n" + e
                    .getLocalizedMessage());
        }

        return this;
    }

    /**
     * This method returns category header title
     * 
     * @author Raghav S
     * 
     * @return String
     * @throws Exception
     */
    public String getCategoriesHeaderTitle() throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION:GETTING CATEGORY HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblcategoryHeader, waitTime);
            strCategoryHeaderText = lblcategoryHeader.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'category header' TITLE " + "\ngetCategoriesHeaderTitle\n" + e
                            .getLocalizedMessage());
        }

        return strCategoryHeaderText;
    }

    /**
     * This method clicks file
     * 
     * @author Raghavendra Andewadikar
     * @return DocsharingPage
     * @throws Exception
     */
    public DocSharingPage clickFileLink(String fileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON THE FILE LINK");
            frameSwitch.selectTopFrame();
            frameSwitch.switchToFrameContent();
            lblfile.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING 'file' LINK" + "\nMETHOD:clickFileLink\n" + e
                    .getLocalizedMessage());
        }

        return this;
    }

    /**
     * This method changes share option of a document
     * 
     * @author Raghavendra Andewadikar
     * @return DocsharingPage
     * @throws Exception
     */
    public DocSharingPage changeShareOption(String fileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CHANGING THE SHARE OPTION");
            frameSwitch.selectTopFrame();
            lnkdocSharing.clickAndWait(waitTime);
            frameSwitch.switchToFrameContent();
            uiDriver.wait(waitTime);
            if (lblvalue.isDisplayedAfterWaiting(waitTime)) {
                lblvalue.clickAndWait(waitTime);

            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CHANGING THE 'share' OPTION" + "\n METHOD:changeShareOption \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * This method returns share option of a document
     * 
     * @author Raghavendra Andewadikar
     * @return String
     * @throws Exception
     */
    public String getShareOption(String fileName) throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE SHARE OPTION");
            frameSwitch.selectTopFrame();

            lnkdocSharing.clickAndWait(waitTime);
            frameSwitch.switchToFrameContent();
            strShareLinkName = lnkshare.getText();
            isShareLinkPresent(strShareLinkName);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'share' OPTION" + "\n METHOD:getShareOption \n" + e
                            .getLocalizedMessage());
        }
        return strShareLinkName;
    }

    /**
     * This method returns boolean value whether a share link is present for a document
     * 
     * @author Raghavendra Andewadikar
     * 
     * @return boolean
     * @throws Exception
     */
    public boolean isShareLinkPresent(String link) throws Exception {
        
        try {
            if (!link.isEmpty()) {
                logInstruction("LOG INSTRUCTION: VERIFIYING SHARE LINK PRESENT: " + link);
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFIYING SHARE LINK" + "\n METHOD:isShareLinkPresent \n" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * This method returns label Assign Category To:
     * 
     * @author Raghav S
     * @return String
     * @throws Exception
     */
    public String getAssignCategorytoTitle() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:GETTING CATEGORY HEADER");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpassignTo, waitTime);
            strAssignToTextString = drpassignTo.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'category' HEADER " + "\n METHOD:getAssignCategorytoTitle \n" + e
                            .getLocalizedMessage());
        }

        return strAssignToTextString;
    }

    /**
     * @author amit.deshmukh Method helps to getErrorMessage
     * @return
     * @throws Exception
     */
    public String getErrorMessage() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:CAPTURING THE ERROR MESSAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblErrorMessage, waitTime);
            strErrorMessage = lblErrorMessage.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFIYING IN 'error' MESSAGE" + "\n METHOD:getErrorMessage\n" + e
                            .getLocalizedMessage());
        }
        return strErrorMessage;
    }

    /**
     * @author amit.deshmukh Method helps to getHeadertitle
     * @return
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblHeaderMessage, waitTime);
            strHeaderName = lblHeaderMessage.getText().trim();
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE 'header' TITLE" + "\nMETHOD:getHeaderTitle\n");
        }
        return strHeaderName;
    }

    /**
     * This method clicks on edit button
     * 
     * @return:DocumentSharing
     * @author:Raghav S
     * @throws Exception
     */
    public EditCategoryPage clickEditCategoriesButton(String groupname) throws Exception {
    	
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON EDIT BUTTON");
            frameSwitch.switchToFrameContent();
            btnClickedit.replaceValues(groupname);
            uiDriver.waitToBeDisplayed(btnClickedit, waitTime);
            btnClickedit.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'edit' BUTTON" + "\nMETHOD:clickEditCategoriesButton\n" + e
                            .getLocalizedMessage());
        }
        return new EditCategoryPage(uiDriver);
    }

    /**
     * This method clicks on delete button
     * 
     * @return:DocumentSharing
     * @author:Raghav S
     * @throws Exception
     */
    public DeleteCategoryPage clickDeleteCategoriesButton(String groupname) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON DELETE CATEGORY BUTTON");
            frameSwitch.switchToFrameContent();
            btnClickdelete.replaceValues(groupname);
            uiDriver.waitToBeDisplayed(btnClickdelete, waitTime);
            btnClickdelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'delete' CATEGORY BUTTON" + "\n METHOD:clickDeleteCategoriesButton\n" + e
                            .getLocalizedMessage());
        }
        return new DeleteCategoryPage(uiDriver);
    }

    /**
     * 
     * This method clicks on delete button
     * 
     * @return:DocumentSharing
     * @author:Raghav S
     * @throws Exception
     */
    public DocSharingPage enterDescription(String Description) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING THE DESCRIPTION");
            frameSwitch.switchToFrameContent();
            txtdescription.clearAndSendKeys(Description);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING THE 'description'" + "\n METHOD:enterdescription\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method to check if link to file added there or not
     * 
     * @return:boolean
     * @author:Chaitali
     * @throws Exception
     */
    public boolean isFileDisplayed(String link) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: VERFIYING THE FILE DISPLAYED");
            frameSwitch.switchToFrameContent();
            lnkUplodedDisplayed.replaceValues(link);
            if (!(lnkUplodedDisplayed.isDisplayedAfterWaiting(waitTime))) {
                return false;
            }
            if (lnkUplodedDisplayed.isDisplayedAfterWaiting(waitTime))
                return true;

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFIYING 'file' DISPLAYED" + "\n METHOD:isFileDisplayed\n");
        }
        return false;
    }

    /**
     * This method returns a boolean value whether a link is present or not
     * value-FileName/Descriptor,Owner,Date/time,Size,share,Downloads,AddEntry
     * 
     * @category Milestone 2
     * @author Raghav
     * 
     * @return boolean
     * @throws Exception
     */
    public boolean isLinkpresent(String value) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERFIES A LINK IS PRESENT");
            frameSwitch.switchToFrameContent();
            lblColoumnname.replaceValues(value);
            return lblColoumnname.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception("ISSUE IN VERIFIYING THE LINK" + "\nMETHOD:isLinkpresent\n" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * This method clicks on Share Instructor only/Entire Class
     * 
     * @category Milestone 2
     * @return:DocumentSharing
     * @author:Raghav S
     * @throws Exception
     */
    public DocSharingPage clickInstructororEntireClassLink(String filename) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON ENTIRE OR INSTRUCTOR LINK");
            frameSwitch.switchToFrameContent();
            lnkclickinstructororentireclass.replaceValues(filename);
            uiDriver.waitToBeDisplayed(lnkclickinstructororentireclass, waitTime);
            lnkclickinstructororentireclass.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE LINK" + "\n METHOD:clickInstructororEntireClassLink\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to verify Whether Sharing Status Is Present
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public boolean isSharingStatusDisplayed(String File) throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION :VERFIYING THE SHARING STATUS");
            frameSwitch.switchToFrameContent();
            lnkclickinstructororentireclass.replaceValues(File);
            uiDriver.waitToBeDisplayed(lnkclickinstructororentireclass, waitTime);
            if (lnkclickinstructororentireclass.isDisplayedAfterWaiting(waitTime))
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFIYING SHARING STATUS" + "\nMETHOD:isSharingStatusDisplayed\n" + e
                            .getLocalizedMessage());
        }

        return flag;

    }

    /**
     * This method to click on the date time arrow
     * 
     * @category Milestone 2
     * @return:DocSharingPage
     * @author:kiran.kumar
     * @throws Exception
     */
    public DocSharingPage clickOnDateTimeArrow() throws Exception {

        try {
        	
            logInstruction("LOG INSTRUCTION: CLICKING ON DATE AND ARROW");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lbldatetimearrow, waitTime);
            lbldatetimearrow.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'date and arrow'" + "\nMETHOD:clickOnDateTimeArrow\n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method to get the tooltip messeg of date time arrow
     * 
     * @category Milestone 2
     * @return:string
     * @author:kiran.kumar
     * @throws Exception
     */
    public String getToolTipofArrow() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE TOOL TIP ARROW");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lbldatetimearrow, waitTime);
            strValueDateNTime = lbldatetimearrow.getAttribute("alt");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'tooltip'" + "\n METHOD:getToolTipofArrow\n" + e
                            .getLocalizedMessage());
        }
        return strValueDateNTime;
    }

    /**
     * This method to verify add category button
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */
    public boolean isAddCategorieBtnDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERFIYING ADD CATEGORIES BUTTON");
            frameSwitch.switchToFrameContent();
            return lnkaddcategory.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'addcategory' BUTTON" + "\nMETHOD:isAddCategorieBtnDisplayed\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method to verify add category coloumns
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */
    public boolean isColoumnNameExistforAddCategory(String coloumnName) throws Exception {

        try {
            logInstruction("LOG INSRUCTION:VERIFIYING THE COLUMN NAME");
            lblcoloumnnameforaddcategory.replaceValues(coloumnName);
            frameSwitch.switchToFrameContent();
            return lblcoloumnnameforaddcategory.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFIYING THE 'column' NAME" + "\nMETHOD:isColoumnNameExistforAddCategory\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method to verify the coursename present below the addcategory button
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */
    public String getCourseNamefromAddCategoryTable() throws Exception {
       
        try {
            logInstruction("LOGINSRUCTION:GETTING THE ADD CATEGORY TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBePresent(lblgetCourseName, waitTime);
            strValueCourseName = lblgetCourseName.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'addcategory' TITLE" + "\nMETHOD:getCourseNamefromAddCategoryTable\n" + e
                            .getLocalizedMessage());
        }
        return strValueCourseName;
    }

    /**
     * This method to verify uploadbutton
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */
    public boolean isUploadButtonPresent() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:VERFIYING THE UPLOAD BUTTON");
            frameSwitch.switchToFrameContent();
            return lnkuploaddocument.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'upload' BUTTON" + "\nMETHOD:isUploadBtnPresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method to verify downloadbtn
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */
    public boolean isDownloadPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:VERFIYING THE DOWNLAOD BUTTON");
            frameSwitch.switchToFrameContent();
            return lnkdownloaddocument.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFIYING 'download' BUTTON" + "\nMETHOD:isDownloadPresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method to verify coloumn name in course table ie:2nd table
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */
    public boolean isColoumnNameDisplayedInCourseTable(String coloumnName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFIYING THE COLUMN NAME");
            frameSwitch.switchToFrameContent();
            lblColoumnname.replaceValues(coloumnName);
            return lblColoumnname.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'column' NAME" + "\nMETHOD:isColoumnNameDisplayedInCourseTable\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method to tool tip of coloumn name in course table ie:2nd table
     * 
     * @category Milestone 2
     * @return:String
     * @author:kiran.kumar
     * @throws Exception
     */
    public String getTooltipForcoloumn(String coloumnName) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:GETTING THE TOOL TIP");
            frameSwitch.switchToFrameContent();
            lblColoumnname.replaceValues(coloumnName);
            strValueColumName = lblColoumnname.getAttribute("title").trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'tool' TIP" + "\nMETHOD:getTooltipForcoloumn\n" + e
                            .getLocalizedMessage());
        }
        return strValueColumName;

    }

    /**
     * This method to verify the downloaded file is present or not
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */

    public boolean isUploadedFilePresent(String filename) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:VERFIYING THE UPLOADED FILE");
            frameSwitch.switchToFrameContent();
            btnclikdownloads.replaceValues(filename);
            return btnclikdownloads.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING THE 'uploaded' FILE" + "\nMETHOD:isUploadedFilePresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method to verify the description of uploaded file
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */
    public boolean isFileDescriptionPresent(String filename) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:VERFIYING THE FILE DESCRIPTION");
            frameSwitch.switchToFrameContent();
            lblDiscreption.replaceValues(filename);
            return lblDiscreption.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING THE 'file' DESCRIPTION" + "\nMETHOD:isFileDescriptionPresent\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method helps to Click on the Download Count
     * 
     * @param String
     *            Filename -Document file name which is Uploaded
     * @author Raghav
     * @return DocumentSharingPage
     */
    public DownloadDocSharingPage ClickOnDownloadCount(String FileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON DOWNLOAD COUNT");
            frameSwitch.switchToFrameContent();
            btndownloadCnt.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(btndownloadCnt, waitTime);
            btndownloadCnt.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING THE 'download' COUNT" + "\nMETHOD:ClickOnDownloadCount\n" + e
                            .getLocalizedMessage());

        }
        return new DownloadDocSharingPage(uiDriver);
    }

    /**
     * This method helps us to click on link in docSharingPage
     * 
     * @category Milestone 2
     * @return:
     * @author:Raghav
     * @throws Exception
     */
    public DocSharingPage clickOnLink(String name) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:CLICK ON LINK");
            frameSwitch.switchToFrameContent();
            lblColoumnname.replaceValues(name);
            lblColoumnname.isDisplayedAfterWaiting(waitTime);
            if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
                lblColoumnname.clickByJavascript();
                Thread.sleep(waitTime); // Since clickByJavascript() is hanging, performing the same
            } else {
                lblColoumnname.clickAndWait(waitTime);
            }

        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING ON 'link'" + "\nMETHOD:clickOnLink\n" + e
                    .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method verify Add category Link link in the
     * 
     * @category Milestone2
     * @returns DocSharingPage
     * @throws Exception
     * @author amit.deshmukh
     */
    public boolean isclickAddCategoryLinkPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:VERIFY THE ADD CATEGORY LINK");
            frameSwitch.switchToFrameContent();
            return lnkaddcategory.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFY THE ADD CATEGORY 'link'" + "\nMETHOD:isclickAddCategoryLinkPresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Method helps to verify Checkbox
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return boolean
     */
    public boolean isCheckboxPresent() throws Exception {
        try {

            logInstruction("LOG INSTRUCTION:VERIFY THE CHECKBOX");
            frameSwitch.switchToFrameContent();
            return chkselectAll.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFY THE ADD CATEGORY 'Checkbox'" + "\nMETHOD:isclickAddCategoryLinkPresent\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method to check if category is present or not
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return:boolean
     * @throws Exception
     */
    public boolean isCategoryPresent(String name) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:VERIFIES A CATEGORIES  PRESENT");
            frameSwitch.switchToFrameContent();
            lnkcategory.replaceValues(name);
            return lnkcategory.isDisplayedAfterWaiting(2000);
        } catch (Exception e) {
            throw new Exception("UNABLE TO FIND 'Category'" + "\nMETHOD:isCategoryPresent\n" + e
                    .getLocalizedMessage());
        }

    }

    /**
     * This method returns a boolean value whether a link is present or not for Edit and Delete
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isLinkDisplayed(String value) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFY THE EDIT AND DELETE LINK");
            frameSwitch.switchToFrameContent();
            lbldisplayed.replaceValues(value);
            return lbldisplayed.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFY THE ADD CATEGORY 'Link'" + "\nMETHOD:isLinkDisplayed\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps t get page title
     * 
     * @category Milestone 2
     * @return:String
     * @author:amit.deshmukh
     * @throws Exception
     */
    public String getPageTitle() throws Exception {
        
        try {
        	
            logInstruction("LOG INSTRUCTION:CAPTURING PAGE TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBePresent(lblpagetitle, waitTime);
            strPageTitle = lblpagetitle.getText().trim();
            
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE TO CAPTURE THE PAGE TITLE 'Label'" + "\nMETHOD:getPageTitle\n" + e
                            .getLocalizedMessage());
        }
        return strPageTitle;
    }

    /**
     * This method helps t get Bottom page title
     * 
     * @category Milestone 2
     * @return:String
     * @author:amit.deshmukh
     * @throws Exception
     */
    public String getBottomPageTitle() throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION:CAPTURING BOTTOM PAGE TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBePresent(lblbottompagetitle, waitTime);
            strBottomPageTitle = lblbottompagetitle.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE TO CAPTURE THE BOTTOM PAGE TITLE 'Label'" + "\nMETHOD:getBottomPageTitle\n" + e
                            .getLocalizedMessage());
        }
        return strBottomPageTitle;
    }

    public boolean isScrollBarDisplayed() throws Exception {
    	
       
        try {
            logInstruction(" LOG INSTRUCTION:CHECK FOR THE SCROLL BAR");
            UIActions act = new DefaultUIActions(uiDriver, divActiveElement);
            act.mouseMoveHere();
            divActiveElement.clickAndWait(waitTime);

            uiDriver.switchTo().activeElement();
            strClientHeight = uiDriver
                    .executeScript(" return this.document.getElementById('navigationDiv').clientHeight");
            strScrollHeight = uiDriver
                    .executeScript(" return this.document.getElementById('listCategoriesAndFilesView').scrollHeight");
             clientHeightInt = Integer.parseInt(strClientHeight);
             scrollHeightInt = Integer.parseInt(strScrollHeight);

            if (clientHeightInt < scrollHeightInt) {
                logInstruction(" LOG INSTRUCTION:VERTICAL SCROLL BAR IS  APPEAR");
                flag = true;
            } else {
                logInstruction(" LOG INSTRUCTION:VERTICAL SCROLL BAR IS NOT APPEAR");
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN  FINDING THE 'scroll bar'" + "\n METHOD:isScrollBarDisplayed() \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check for the page title of doc sharing page and return true or false for
     * whether DocSharing page is displayed or not.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return boolean
     * @throws Exception
     * **/
    public boolean isDocSharingPageDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: Checking whether DocSharing page or not.");
            frameSwitch.switchToFrameContent();
            flag = lblTitle.isDisplayedAfterWaiting(waitTime);
            return flag;
        } catch (Exception e) {
            throw new Exception("This is not a doc sharing page. " + e.getLocalizedMessage());
        }
    }

    /**
     * This method verifies edit categories button
     * 
     * @category Milestone2
     * @return: boolean
     * @author amit.deshmukh
     * @throws Exception
     */
    public boolean isEditCategoriesButtonPresent(String groupname) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING EDIT BUTTON");
            frameSwitch.switchToFrameContent();
            btnClickedit.replaceValues(groupname);
            return btnClickedit.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING'edit' BUTTON" + "\nMETHOD:isEditCategoriesButtonPresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method verifies categories delete button
     * 
     * @category Milestone2
     * @return: boolean
     * @author amit.deshmukh
     * @throws Exception
     */
    public boolean isDeleteCategoriesButtonPresent(String groupname) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING DELETE CATEGORY BUTTON");
            frameSwitch.switchToFrameContent();
            btnClickdelete.replaceValues(groupname);
            return btnClickdelete.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'delete' CATEGORY BUTTON" + "\n METHOD:clickDeleteCategoriesButton\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method returns label Assign Category To:
     * 
     * @category Milestone2
     * @author Raghav S
     * @return String
     * @throws Exception
     */
    public boolean isAssignCategorytoTitlePresent() throws Exception {
       
      
        try {
            logInstruction("LOG INSTRUCTION:VERFIES the ASSIGN CATEGORY HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpassignTo, waitTime);
            strAssignToTextString = drpassignTo.getText().trim();
            if (strAssignToTextString != null) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'category' HEADER " + "\n METHOD:isAssignCategorytoTitlePresent \n" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * This method verfies on the date time arrow
     * 
     * @category Milestone 2
     * @return:DocSharingPage
     * @author:Raghav S
     * @throws Exception
     */
    public boolean isClickOnDateTimeArrowPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: VERFIES DATE AND ARROW");
            frameSwitch.switchToFrameContent();
            return lbldatetimearrow.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'date and arrow'" + "\nMETHOD:isClickOnDateTimeArrowPresent\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method helps t get Bottom page title
     * 
     * @category Milestone 2
     * @return:String
     * @author:Raghav
     * @throws Exception
     */
    public boolean isInstructionalTextDisplayed() throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION:VERFIYINH INSTRUCTIONAL TEXT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBePresent(lblbottompagetitle, waitTime);
            strBottomPageTitle = lblbottompagetitle.getText().trim();
            if (strBottomPageTitle != null) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING THE 'instructional' TEXT" + "\nMETHOD:getBottomPageTitle\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method clicks on Share Instructor only/Entire Class
     * 
     * @category Milestone 2
     * @return:DocumentSharing
     * @author:Raghav S
     * @throws Exception
     */
    public String getInstructororEntireClassLinkTitle(String filename) throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON ENTIRE OR INSTRUCTOR LINK");
            frameSwitch.switchToFrameContent();
            lnkclickinstructororentireclass.replaceValues(filename);
            uiDriver.waitToBeDisplayed(lnkclickinstructororentireclass, waitTime);
            strInstructorAttribute = lnkclickinstructororentireclass.getAttribute("title").trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE LINK" + "\n METHOD:clickInstructororEntireClassLink\n" + e
                            .getLocalizedMessage());
        }
        return strInstructorAttribute;
    }

    /**
     * Method helps to get tilte attribute of download count
     * 
     * @category Milestone2
     * @author Raghav
     * @return DocumentSharingPage
     */
    public String getTitleAttributeDownloadCount(String FileName) throws Exception {
    	
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE ATTRIBUTE OF DOWNLOAD COUNT");
            frameSwitch.switchToFrameContent();
            btndownloadCnt.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(btndownloadCnt, waitTime);
            strCount = btndownloadCnt.getAttribute("title").trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE ATTRIBUTE OF 'download' COUNT" + "\n METHOD:getTitleAttributeDownloadCount\n" + e
                            .getLocalizedMessage());

        }
        return strCount;
    }

    /**
     * Method helps to get tilte attribute of Course Edit
     * 
     * @category Milestone2
     * @author Raghav
     * @return DocumentSharingPage
     */
    public String getTitleAttributeofCourseEdit(String FileName) throws Exception {
    	
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE ATTRIBUTE OF EDIT");
            frameSwitch.switchToFrameContent();
            btnEdit.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(btndownloadCnt, waitTime);
            strPageTitle = btnEdit.getAttribute("title").trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE ATTRIBUTE OF 'edit' " + "\n METHOD:getTitleAttributeofCourseEdit\n" + e
                            .getLocalizedMessage());

        }
        return strPageTitle;
    }

    /**
     * Method helps to get tilte attribute of Course Delete
     * 
     * @category Milestone2
     * @author Raghav
     * @return DocumentSharingPage
     */
    public String getTitleAttributeofCourseDelete(String FileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE ATTRIBUTE OF DELETE");
            frameSwitch.switchToFrameContent();
            btnDelete.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(btnDelete, waitTime);
            strPageTitle = btnDelete.getAttribute("title").trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE ATTRIBUTE OF 'delete' " + "\n METHOD:getTitleAttributeofCourseEdit\n" + e
                            .getLocalizedMessage());

        }
        return strPageTitle;
    }
    
    
    /**
     * This method clicks on delete button
     * @ServiceLevelMethod
     * @return:DocumentSharing
     * @author:Raghav S
     * @throws Exception
     */
    public DocSharingPage deleteACategory(String groupname,boolean checkbox) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:DELETES A CATEGORY");
            frameSwitch.switchToFrameContent();
            btnClickdelete.replaceValues(groupname);
            uiDriver.waitToBeDisplayed(btnClickdelete, waitTime);
            btnClickdelete.clickAndWait(waitTime);
            if(checkbox)
            {
            	   uiDriver.waitToBeDisplayed(chkiagree, waitTime);
                   chkiagree.clickAndWait(waitTime);
                   uiDriver.waitToBeDisplayed(btndeletecategory, waitTime);
                   btndeletecategory.clickAndWait(waitTime);
           }else
           {
        	   uiDriver.waitToBeDisplayed(btndeletewothoutuploading, waitTime);
               btndeletewothoutuploading.clickAndWait(waitTime);
           }
            
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN  'deleteing' CATEGORY BUTTON" + "\n METHOD:deleteACategory\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method Returns the List of Uploaded Files with Prefix LSAutoTest With Specified Time Stamp
     * 
     * @param 
     * @return
     * @throws Exception
     * @author Raghav S
     */
   	public List<String> getDocSharingUploadedList() throws Exception {
		 List<String> docSharinguploadedfilename = new ArrayList<String>();
		try {
			logInstruction("LOGINSTRUCTION:GETTING THE LIST OF UPLOADED FILES");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = lbldocsharinguploadedvalues.getUIElementsList();
			for (int i = 0; i < elements.size(); i++) {
							if (StringUtils.isNotBlank(elements.get(i).getText())
						 && (elements.get(i).getText().contains("LSAutoTest")) && (cleanup.verifyOnedayTimeStamp(elements.get(i).getText().trim()))) {
	
			docSharinguploadedfilename.add(elements.get(i).getText().trim());
				}
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN  GETTING THE  'uploaded' FILES"
					+ "\n METHOD:getDocSharingUploadedList \n"
					+ e.getLocalizedMessage());
		}

		return docSharinguploadedfilename;

	}
   	/**
     * This Method Returns the List of Category List with Prefix  LSAutoTest With Specified Time Stamp
     * 
     * @param 
     * @return
     * @throws Exception
     * @author Raghav S
     */
	public List<String> getDocSharingCategoryList() throws Exception {
		 List<String> docSharingcategoryname = new ArrayList<String>();
		try {
			logInstruction("LOGINSTRUCTION:GETTING CATEGORY FOLDER NAME LIST");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = lbl.getUIElementsList();
			for (int i = 0; i < elements.size(); i++) {
							if (StringUtils.isNotBlank(elements.get(i).getText())
						 && (elements.get(i).getText().contains("LSAutoTest")) && (!elements.get(i).getText().contains("Group")) && (cleanup.verifyOnedayTimeStamp(elements.get(i).getText().trim()))) {
	
			docSharingcategoryname.add(elements.get(i).getText().trim());
				}
			}
			
		} catch (Exception e) {
			throw new Exception("ISSUE IN  GETTING THE  'category' VALUES"
					+ "\n METHOD:getDocSharingCategoryList \n"
					+ e.getLocalizedMessage());
		}

		return docSharingcategoryname;

	}
	
	
	/**
     * Method helps to verify Whether Uploaded DocSharing Page is Deleted or not
     * 
     * @author Raghav
     * @return boolean
     * @throws Exception
     */
	
	
	public boolean isUploadedFileDeletedInDocSharing(String uploadedFileName) throws Exception
	{
		try{
			logInstruction("LOGINSTRUCTION:VERIFYING WHETHER UPLOADED FILE IN DOC SHARING PAGE DELETED");
			frameSwitch.switchToFrameContent();
			lblColoumnname.replaceValues(uploadedFileName);
			return lblColoumnname.isDisplayedAfterWaiting(waitTime);
			
		}catch(Exception e){
			throw new Exception("ISSUE IN VERIFYING THE 'announcement' "+"\nMETHOD:isUploadedFileDeletedInDocSharing\n"+e.getLocalizedMessage());
			
		}
	
	}
	
	
	
}
