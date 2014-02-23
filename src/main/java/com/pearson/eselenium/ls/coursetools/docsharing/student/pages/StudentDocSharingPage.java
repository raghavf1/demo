package com.pearson.eselenium.ls.coursetools.docsharing.student.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all the methods related to docSharingPage for student
 * 
 * @author kiran kumar
 * 
 */

public class StudentDocSharingPage extends BasePageObject {

    /* UI Elements */
    private UIElement chkSelect = createElement(
            UIType.Xpath,
            "//td[a[contains(text(),'{1}')]]/preceding-sibling::td[1]/input");
    private UIElement lnkfileName = createElement(UIType.Xpath, "//td[a[contains(text(),'{1}')]]/a");
    private UIElement lnkdownloaddocument = createElement(
            UIType.Xpath,
            "//a[contains(text(),'Download Documents')]");
    private UIElement lblDteTime = createElement(
            UIType.Xpath,
            "//td[a[contains(text(),'{1}')]]/following-sibling::td[2]");
    private UIElement lnkclickinstructororentireclass = createElement(
            UIType.Xpath,
            "//td[a[contains(text(),'{1}')]]/following-sibling::td[4]/a");
    private UIElement lblownerName = createElement(
            UIType.Xpath,
            "//td[a[contains(text(),'{1}')]]/following-sibling::td[1]");
    private UIElement lblSize = createElement(
            UIType.Xpath,
            "//td[a[contains(text(),'{1}')]]/following-sibling::td[3]");
    private UIElement lblclickinstructororentireclass = createElement(
            UIType.Xpath,
            "//td[a[contains(text(),'{1}')]]/following-sibling::td[4]");
    
    /*Variables*/
    
    private String strDateAndTime = null;
    boolean flag = false;
    private String strOwnerName = null;
    private String strShare = null;
    private String strSize = null;

    public StudentDocSharingPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("###########StudentDocSharingPage##############");
        // TODO Auto-generated constructor stub
    }

    /**
     * Method helps to select a file by chk box for student Login
     * 
     * @category Milestone 2
     * @author kiran kumar s
     * @return DocumentSharingPage
     */
    public StudentDocSharingPage selectAFileforStudent(String FileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:SELECT THE " + FileName + ".");
            frameSwitch.switchToFrameContent();
            chkSelect.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(chkSelect, waitTime);
            chkSelect.clickAndWait(waitTime);
            

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE 'file'" + "\nMETHOD:selectAFileforStudent\n" + e
                            .getLocalizedMessage());
        }
        return this;

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
            logInstruction("LOG INSTRUCTION:VERIFIYING THE UPLOADED FILE");
            frameSwitch.switchToFrameContent();
            lnkfileName.replaceValues(filename);
            return lnkfileName.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'uploaded' FILE" + "\nMETHOD:isUploadedFilePresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method click the DownloadDocument link in DocSharingPage
     * 
     * @category Milestone 2
     * @throws Exception
     * @author kiran.kumar
     */
    public StudentDocSharingPage clickDownloadDocumentLink() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:CLICK ON THE DOWNLOAD DOCUMENT LINK");
            frameSwitch.switchToFrameContent();
            //String browser = System.getProperty("browser.NAME");
            lnkdownloaddocument.isDisplayedAfterWaiting(waitTime);
            if (getBrowser().toString().equalsIgnoreCase("InternetExplorer")) {
                lnkdownloaddocument.clickByJavascript();
                Thread.sleep(waitTime); // Since clickAndWait() is hanging, performing the same
            } else {
                lnkdownloaddocument.clickAndWait(waitTime);
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'download' DOCUMENT" + "\nMETHOD:clickDownloadDocumentLink\n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * Method helps to get date and time
     * 
     * @category Milestone 2
     * @author kiran kumar s
     * @return DocumentSharingPage
     */
    public String getDateTime(String FileName) throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:DATE AND TIME FILE");
            frameSwitch.switchToFrameContent();
            lblDteTime.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(lblDteTime, waitTime);

            strDateAndTime = lblDteTime.getText().trim();

        } catch (Exception e) {
            throw new Exception("Unable to get Date and time" + e.getLocalizedMessage());

        }
        return strDateAndTime;
    }

    /**
     * This method to verify the uploaded file description is present or not
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:amit.deshmukh
     * @throws Exception
     */

    public boolean isFileDescriptionPresent(String filename) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFIYING THE UPLOADED FILE DESCRIPTION");
            frameSwitch.switchToFrameContent();
            lnkfileName.replaceValues(filename);
            return lnkfileName.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'uploaded' FILE DESCRIPTION " + "\nMETHOD:isFileDescriptionPresent\n" + e
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
    public StudentDocSharingPage clickInstructororEntireClassLink(String filename) throws Exception {
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
     * Method helps to get owner name
     * 
     * @category Milestone 2
     * @author Raghav S
     * @return DocumentSharingPage
     */
    public boolean isOwnerNameDisplayed(String FileName) throws Exception {
        
        
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE OWNER NAME");
            frameSwitch.switchToFrameContent();
            lblownerName.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(lblownerName, waitTime);
            strOwnerName = lblownerName.getText().trim();
            if (strOwnerName != null) {
            	flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'owner' NAME" + "\n METHOD:isOwnerNameDisplayed\n" + e
                            .getLocalizedMessage());

        }
        return flag;
    }

    /**
     * Method helps to get date and time
     * 
     * @category Milestone 2
     * @author Raghav
     * @return DocumentSharingPage
     */
    public boolean isDateTimeDisplayed(String FileName) throws Exception {
      
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE DATE AND TIME");
            frameSwitch.switchToFrameContent();
            lblDteTime.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(lblDteTime, waitTime);
            strDateAndTime = lblDteTime.getText().trim();
            if (strDateAndTime != null) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING 'date and time'" + "\nMETHOD:getDateTime\n" + e
                    .getLocalizedMessage());

        }
        return flag;
    }

    /**
     * Method helps to get date and time
     * 
     * @category Milestone 2
     * @author Raghav
     * @return DocumentSharingPage
     */
    public boolean isShareOptionDisplayed(String FileName) throws Exception {
        
        
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE SHARE OPTION");
            frameSwitch.switchToFrameContent();
            lblclickinstructororentireclass.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(lblclickinstructororentireclass, waitTime);
            strShare = lblclickinstructororentireclass.getText().trim();
            if (strShare != null) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'share' OPTION" + "\nMETHOD:isShareOptionDisplayed\n" + e
                            .getLocalizedMessage());

        }
        return flag;
    }

    /**
     * Method helps to get date and time
     * 
     * @category Milestone 2
     * @author Raghav
     * @return DocumentSharingPage
     */
    public boolean isSizeOfFileDisplayed(String FileName) throws Exception {
        
       
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE SIZE");
            frameSwitch.switchToFrameContent();
            lblSize.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(lblSize, waitTime);
            strSize = lblSize.getText().trim();
            if (strSize != null) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING 'size' " + "\nMETHOD:isSizeOfFileDisplayed\n" + e
                    .getLocalizedMessage());

        }
        return flag;
    }

}
