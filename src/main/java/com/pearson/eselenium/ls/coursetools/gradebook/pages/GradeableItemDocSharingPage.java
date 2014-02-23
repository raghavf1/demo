package com.pearson.eselenium.ls.coursetools.gradebook.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains the method related to Gradeable item docsharing page which
 * opens as a new window.
 * 
 * @author kiran.kumar
 * 
 */

public class GradeableItemDocSharingPage extends BasePageObject {

	/* UIElement declarations for the GradeableItemDocSharingPage page */
	private UIElement lbluploadDocument = createElement(UIType.Xpath,
			"//div[contains(text(),'Uploaded Documents')]");
	private UIElement lbldownloadDocument = createElement(UIType.Xpath,
			"//div[contains(text(),'Downloaded Documents')]");
	private UIElement lnkdownloadedheading = createElement(UIType.Xpath,
			"//table[contains(@summary,'Documents Downloaded')]//a[contains(text(),'{1}')]");
	private UIElement lnkuploadeddheading = createElement(UIType.Xpath,
			"//table[contains(@summary,'Documents Uploaded')]//a[contains(text(),'{1}')]");
	private UIElement lnkfile = createElement(UIType.Text, "{1}");
	private UIElement txtUploadDatetime = createElement(UIType.Xpath,
			"//td[a[contains(text(),'{1}')]]/following-sibling::td[2]");
	private UIElement txtnumericgrade = createElement(UIType.ID,
			"ItemGrade.PointsAchieved");
	private UIElement txtlettergrade = createElement(UIType.ID,
			"ItemGrade.LetterGrade");
	private UIElement btnsaveandclose = createElement(UIType.Name,
			"SaveAndClose");
	private UIElement chkshareGradewithstudent = createElement(UIType.ID,
			"shareGradeCheckBox");
	private String frameid = "RadeEntryText_contentIframe";
	private String gradableRadToolId = "RadeEntryText";

	public GradeableItemDocSharingPage(UIDriver driver) {
		super(driver);
		logInstruction("############GradeableItemDocSharingPage######");
	}

	private VisualEditor gradeablerad = new VisualEditor(uiDriver,
			gradableRadToolId, frameid, gradableRadToolId);

	public VisualEditor getGradableRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return gradeablerad;
	}

	/**
	 * method is to get the heading of upload documents
	 * 
	 * @author kirankumar
	 * @category MILESTONE 2
	 * @return GradeableItemDocSharingPage
	 * @throws Exception
	 */
	public String getUploadDocumentHeader() throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:GETTING THE UPLOAD DOCUMENTS HEADER");
			frameSwitch.switchToNewWindowBottomFrame();
			return lbluploadDocument.getText().trim();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING 'header'"
					+ "\n METHOD:getUploadDocumentHeader \n"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * method is to get the heading of download documents
	 * 
	 * @author kirankumar
	 * @category MILESTONE 2
	 * @return GradeableItemDocSharingPage
	 * @throws Exception
	 */
	public String getDownloadDocumentHeader() throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:GETTING THE DOWNLOAD DOCUMENTS HEADER");
			frameSwitch.switchToNewWindowBottomFrame();
			return lbldownloadDocument.getText().trim();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING 'header'"
					+ "\n METHOD:getDownloadDocumentHeader \n"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * method is to verify the header
	 * 
	 * @author kirankumar
	 * @category MILESTONE 2
	 * @return GradeableItemDocSharingPage
	 * @throws Exception
	 */

	public boolean isUploadedDocumentsHeadingDisplayed(String headingname)
			throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:VERIFYING THE HEADING PRESENT BELOW THE UPLOAD DOCUMENTS");
			frameSwitch.switchToNewWindowBottomFrame();
			lnkuploadeddheading.replaceValues(headingname);
			return lnkuploadeddheading.isDisplayedAfterWaiting(waitTime);

		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING 'heading'"
					+ "\n METHOD:isUploadedDocumentsHeadingDisplayed \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * method is to verify the download header
	 * 
	 * @author kirankumar
	 * @category milestone 2
	 * @return GradeableItemDocSharingPage
	 * @throws Exception
	 */
	public boolean isDownloadDocumentsHeadingDisplayed(String headingname)
			throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:VERIFYING THE HEADING PRESENT BELOW THE DOWNLOAD DOCUMENTS");
			frameSwitch.switchToNewWindowBottomFrame();
			lnkdownloadedheading.replaceValues(headingname);
			return lnkdownloadedheading.isDisplayedAfterWaiting(waitTime);

		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING 'heading'"
					+ "\n METHOD:isDownloadDocumentsHeadingDisplayed \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * method is to click the headings example:Filename/Description,Date/time
	 * ,Share,downloads,etc..
	 * 
	 * @author kirankumar
	 * @category milestone 2
	 * @return GradeableItemDocSharingPage
	 * @throws Exception
	 */
	public GradeableItemDocSharingPage clickOnDownloadHeadings(
			String headingname) throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:CLICKING ON THE HEADING PRESENT BELOW THE DOWNLOAD DOCUMENTS");
			frameSwitch.switchToNewWindowBottomFrame();
			lnkdownloadedheading.replaceValues(headingname);
			lnkdownloadedheading.click();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON THE '" + headingname
					+ "link'" + "\n METHOD:clickOnDownloadHeadings \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * method is to click on the headings for upload
	 * i.e:Filename/Description,Date/time ,Share,downloads,etc..
	 * 
	 * @author kirankumar
	 * @category milestone 2
	 * @return GradeableItemDocSharingPage
	 * @throws Exception
	 */
	public GradeableItemDocSharingPage clickOnUploadHeadings(String headingname)
			throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:CLICKING ON THE HEADING PRESENT BELOW THE UPLOAD DOCUMENTS");
			frameSwitch.switchToNewWindowBottomFrame();
			lnkuploadeddheading.replaceValues(headingname);
			lnkuploadeddheading.click();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON THE '" + headingname
					+ "link'" + "\n METHOD:clickOnDownloadHeadings \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * method is to click on the uploaded file
	 * 
	 * @author kirankumar
	 * @category milestone 2
	 * @return GradeableItemDocSharingPage
	 * @throws Exception
	 */

	public GradeableItemDocSharingPage clickOnFile(String filename)
			throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:CLICKING ON THE UPLOADED FILE");
			frameSwitch.switchToNewWindowBottomFrame();
			lnkfile.replaceValues(filename);
			lnkfile.click();

		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON 'link'"
					+ "\n METHOD:clickOnFile \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * method is to get the Date/Time for uploaded documents
	 * 
	 * @author kirankumar
	 * @category milestone 2
	 * @return GradeableItemDocSharingPage
	 * @throws Exception
	 */

	public String getUploadDateTime(String filename) throws Exception {
		try {
			logInstruction("loginstruction:getting the date and time");
			frameSwitch.switchToNewWindowBottomFrame();
			txtUploadDatetime.replaceValues(filename);
			return txtUploadDatetime.getText();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE 'date/time'"
					+ "\n METHOD:getUploadDateTime \n"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * Method will helps to enter the Numeric Grade
	 * 
	 * @category milestone 2
	 * @author Raghav S
	 * @throws Exception
	 */
	public GradeableItemDocSharingPage enterNumericGrade(String entergrade)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:ENTERING THE NUMERIC GRADE");
			frameSwitch.switchtopGeneralFrame();
			uiDriver.waitToBeDisplayed(txtnumericgrade, waitTime);
			txtnumericgrade.clearAndSendKeys(entergrade);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE'numeric' GRADE"
					+ "\n METHOD:enterNumericGrade\n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method will helps to enter the Letter Grade
	 * 
	 * @category milestone 2
	 * @author Raghav S
	 * @throws Exception
	 */
	public GradeableItemDocSharingPage enterLetterGrade(String lettergrade)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:ENTERING THE NUMERIC GRADE");
			frameSwitch.switchtopGeneralFrame();
			uiDriver.waitToBeDisplayed(txtlettergrade, waitTime);
			txtlettergrade.clearAndSendKeys(lettergrade);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE'letter' GRADE"
					+ "\n METHOD:enterLetterGrade\n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method Helps to click and Save
	 * 
	 * @category milestone 2
	 * @author Raghav S
	 * @throws Exception
	 */
	public GradebookHomePage clickSaveandClose() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:CLICK ON SAVE CHANGES");
			frameSwitch.switchtopGeneralFrame();
			uiDriver.waitToBeDisplayed(btnsaveandclose, waitTime);
			btnsaveandclose.clickAndWait(waitTime);
			uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICK'save' CHANGES"
					+ "\n METHOD:clickSaveandClose\n" + e.getLocalizedMessage());
		}
		return new GradebookHomePage(uiDriver);
	}

	/**
	 * Method to enter the grade of item type=docsharing
	 * 
	 * @category service level method
	 * @author kiran.kumar
	 * @throws Exception
	 */

	public GradebookHomePage enterGradePoints(String lettergrade,
			int numericgrade, boolean selectcheckbox, String radtext)
			throws Exception {
		try {
			logInstruction("ENTERING GRADE FOR DOCSHARING ITEM");
			frameSwitch.switchtopGeneralFrame();
			txtlettergrade.clearAndSendKeys(lettergrade);
			String numericgrade1 = Integer.toString(numericgrade);
			txtnumericgrade.clearAndSendKeys(numericgrade1);
			if (selectcheckbox == true
					&& !chkshareGradewithstudent.isSelected()) {
				logInstruction("LOGINSTRUCTION:ALREADY CHECKED");
			} else {
				chkshareGradewithstudent.clickNoWait();
			}
			getGradableRadEditor().enterText(radtext);

			frameSwitch.switchtopGeneralFrame();
			btnsaveandclose.clickAndWait(waitTime);
			uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING GRADE"
					+ "\n Method:enterGradePoints \n" + e.getLocalizedMessage());
		}

		return new GradebookHomePage(uiDriver);

	}

}
