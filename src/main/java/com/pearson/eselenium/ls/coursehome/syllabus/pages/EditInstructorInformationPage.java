package com.pearson.eselenium.ls.coursehome.syllabus.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.PlainTextEditor;
import com.pearson.eselenium.ls.common.pages.RadEditorSwitchPlainOrVisual;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.eselenium.ls.common.radeditor.pages.LinkWizardUploadImagePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of
 * EditInstructorInformationPage Follow the below steps to navigate the page:
 * Login as prof Click on the Course Click on Author Tab Click on Syllabus Click
 * on Instructor Information
 * 
 * @author Raghav S
 * 
 */
public class EditInstructorInformationPage extends BasePageObject {

	/* Elements */
	private UIElement lblPhoto = createElement(UIType.Css,
			".innercontenttable>table>tbody>tr:nth-child(8)>td:nth-child(1)>label");
	private UIElement lbldispSyllabus = createElement(UIType.Xpath,
			"//td[contains(text(),'Display on Syllabus:')]");
	private UIElement msgName = createElement(UIType.Css,
			".innercontenttable>table>tbody>tr:nth-child(2)>td:nth-child(2)");
	private UIElement msgEmailid = createElement(UIType.Css,
			".innercontenttable>table>tbody>tr:nth-child(3)>td:nth-child(2)");
	private UIElement txtEnterOfficeLocation = createElement(UIType.ID,
			"syllabusInstructorInfo.OfficeLocation");
	private UIElement txtEnterOfficeHrs = createElement(UIType.ID,
			"syllabusInstructorInfo.OfficeHours");
	private UIElement txtEnterPhoneNumber = createElement(UIType.ID,
			"syllabusInstructorInfo.Phone");
	private UIElement txtEnterFax = createElement(UIType.ID,
			"syllabusInstructorInfo.Fax");
	private UIElement txtEnterPhotoFilePath = createElement(UIType.ID,
			"photopath");
	private UIElement lnkAddPhoto = createElement(UIType.Xpath,
			"//a[@title='Add Photo']");
	private UIElement msgOfficeLocation = createElement(UIType.ID,
			"syllabusInstructorInfo.OfficeLocation");
	private UIElement msgOfficeHours = createElement(UIType.ID,
			"syllabusInstructorInfo.OfficeHours");
	private UIElement lblName = createElement(
			UIType.Css,
			".innercontenttable>table:nth-of-type(1)>tbody>tr:nth-of-type(1)>td:nth-of-type(1)");
	private UIElement lblEmail = createElement(
			UIType.Css,
			".innercontenttable>table:nth-of-type(1)>tbody>tr:nth-of-type(2)>td:nth-of-type(1)");
	private UIElement lblOfficeloc = createElement(
			UIType.Css,
			".innercontenttable>table:nth-of-type(1)>tbody>tr:nth-of-type(3)>td:nth-of-type(1)");
	private UIElement lblOfficeHrs = createElement(
			UIType.Css,
			".innercontenttable>table:nth-of-type(1)>tbody>tr:nth-of-type(4)>td:nth-of-type(1)");
	private UIElement lblOfficePhone = createElement(
			UIType.Css,
			".innercontenttable>table:nth-of-type(1)>tbody>tr:nth-of-type(5)>td:nth-of-type(1)");
	private UIElement lblOfficeFax = createElement(
			UIType.Css,
			".innercontenttable>table:nth-of-type(1)>tbody>tr:nth-of-type(6)>td:nth-of-type(1)");
	private UIElement msgPhone = createElement(UIType.Css,
			"#syllabusInstructorInfo.Phone");
	private UIElement msgFax = createElement(UIType.Css,
			"#syllabusInstructorInfo.Fax");
	private UIElement msgPhotoFilePath = createElement(UIType.Css, "#photopath");
	private UIElement msgDisplayOnSyllabus = createElement(UIType.Css,
			".innercontenttable tr:nth-child(9)>td:nth-child(2)");
	private UIElement lbPositions = createElement(UIType.Xpath,
			"//tbody[input[@name='syllabusInstructorInfo.ID']]/tr['{1}']/td[1]");
	private UIElement radSelectDisplay = createElement(UIType.Xpath,
			"//tr/td[2]/input['{1}'][@id='DisplayInfo']");
	private UIElement lblPositions = createElement(UIType.Xpath,
			"//tbody[input[@name='syllabusInstructorInfo.ID']]/tr['{1}']/td[1]");
	private UIElement drpSelectInstructor = createElement(UIType.Css,
			"#SelectedIntstructor");
	private UIElement btnOk = createElement(UIType.Xpath,
			"//form[@id='frmInstructorView']//table[1]//tr//input[@value='OK']");
	private UIElement btnSaveChanges = createElement(UIType.Css,
			"input[value='Save Changes']");
	private UIElement lblElement = createElement(UIType.Xpath,
			"//div[@class='tablehead']");
	private UIElement msgHeaderTitle = createElement(UIType.Xpath,
			"//div[@class='tablehead']");
	private UIElement txtNameEdit = createElement(UIType.Xpath,
			"//td[@class='innercontenttable']/table/tbody/tr[1]/td[2]/input");
	private UIElement areaRaded = createElement(UIType.Xpath, "//html//body");

private UIElement btnCancel=createElement(UIType.Css, "input[value='Cancel']");
	private String RADEditotToolId = "RadeEntryText";
	private String RADEditotFrameId = "RadeEntryText_contentIframe";
	private String RADEditotFooterId = "RadeEntryText_ModesWrapper";
    private String visualEditorLink = "RadeEntryText_visualEditor";
	private String plainTextEditorLink = "RadeEntryText_simpleEditor";

    private VisualEditor RADEditor= new VisualEditor(uiDriver,RADEditotToolId, RADEditotFrameId,RADEditotFooterId);
    private PlainTextEditor plainEditor=new PlainTextEditor(uiDriver);
	private RadEditorSwitchPlainOrVisual radSwitch= new RadEditorSwitchPlainOrVisual(uiDriver, visualEditorLink, plainTextEditorLink);


	/* Constructor */
	public EditInstructorInformationPage(UIDriver driver) {
		super(driver);
		logInstruction("LOG INSTRUCTION: ## Edit Instructor Information Page ##");
	}

	public VisualEditor getVisualEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return RADEditor;
	}
public PlainTextEditor getPlainTextEditor() throws Exception {
	frameSwitch.switchToFrameContent();
		return plainEditor;
}
  public RadEditorSwitchPlainOrVisual getRadSwitch() throws Exception {
	  frameSwitch.switchToFrameContent();
        return radSwitch;
    }
	/**
	 * This method gets the Photo Label in EditInstructorInformationPage
	 * 
	 * 
	 * @return: String - PhotoLabel
	 * @author:Raghav S
	 * @throws Exception
	 */

	public String getLabelPhoto() throws Exception {
		String photoLabel = null;
		try {
			logInstruction("LOG INSTRUCTION: CAPTURING PHOTO LABEL");
			frameSwitch.switchToFrameContent();
			photoLabel = lblPhoto.getText();
			logInstruction("LOG INSTRUCTION: PHOTO LABEL IS CAPTURED");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Label Photo'"
							+ "\n METHOD: getLabelPhoto \n"
							+ e.getLocalizedMessage());
		}
		return photoLabel;

	}

	/**
	 * This method gets the DisplayOnSyllabus Label in
	 * EditInstructorInformationPage
	 * 
	 * 
	 * @return String DisplayonSyllabus Label
	 * @author Raghav S
	 * @throws Exception
	 */

	public String getLabelDisplayOnSyllabus() throws Exception {
		String DisplayOnSyllabus = null;
		try {
			logInstruction("LOG INSTRUCTION: CAPTURING DISPLAYONSYLLABUS LABEL");
			frameSwitch.switchToFrameContent();
			DisplayOnSyllabus = lbldispSyllabus.getText();
			logInstruction("LOG INSTRUCTION: DISPLAYONSYLLABUS LABEL IS CAPTURED");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Label Display On Syllabus'"
							+ "\n METHOD: getLabelDisplayOnSyllabus \n"
							+ e.getLocalizedMessage());
		}
		return DisplayOnSyllabus;

	}

	/**
	 * This method gets the name in EditInstructorInformationPage
	 * 
	 * 
	 * @return String Name
	 * @author Raghav S
	 * @throws Exception
	 */

	public String getName() throws Exception {
		String name = null;
		try {
			logInstruction("LOG INSTRUCTION: FETCHING THE NAME IN EDITINSTRUCTORINFORMATIONPAGE ");
			frameSwitch.switchToFrameContent();
			name = msgName.getText().trim();

		} catch (Exception e) {
			throw new Exception("LOG INSTRUCTION: ISSUE IN GETTING 'Name'"
					+ "\n METHOD: getName \n" + e.getLocalizedMessage());
		}
		return name;
	}

	/**
	 * This method gets the email id in EditInstructorInformationPage
	 * 
	 * 
	 * @return String - Name
	 * @author Raghav S
	 * @throws Exception
	 */

	public String getEmail() throws Exception {
		String email = null;
		try {
			logInstruction("LOG INSTRUCTION: FETCHING THE EMAIL ID IN EDITINSTRUCTORINFORMATIONPAGE ");
			frameSwitch.switchToFrameContent();
			email = msgEmailid.getText().trim();

		} catch (Exception e) {
			throw new Exception("LOG INSTRUCTION: ISSUE IN GETTING 'Mail'"
					+ "\n METHOD: getEmail \n" + e.getLocalizedMessage());
		}
		return email;

	}

	/**
	 * This method enters the officeLocation in EditInstructorInformationPage
	 * 
	 * 
	 * @return EditInstructorInformationPage
	 * @param String
	 *            - officeLocation
	 * @author Raghav S
	 * @throws Exception
	 */

	public EditInstructorInformationPage enterOfficeLocation(
			String officeLocation) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING OFFICELOCATION");
			frameSwitch.switchToFrameContent();
			txtEnterOfficeLocation.clearAndSendKeys(officeLocation);
			logInstruction("LOG INSTRUCTION: office location details are entered");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Office Location'"
							+ "\n METHOD: enterOfficeLocation \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method enters the officeHours in EditInstructorInformationPage
	 * 
	 * @param String
	 *            - officeLocation
	 * @return EditInstructorInformationPage
	 * @author Raghav S
	 * @throws Exception
	 */
	public EditInstructorInformationPage enterOfficeHours(String OfficeHours)
			throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: ENTERING OFFICEHOURS");
			frameSwitch.switchToFrameContent();
			txtEnterOfficeHrs.clearAndSendKeys(OfficeHours);
			logInstruction("LOG INSTRUCTION: OFFICEHOURS DETAILS ARE ENTERED");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN ENTERING 'Office Hours'"
							+ "\n METHOD: enterOfficeHours \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to enter the number
	 * 
	 * @param String
	 *            phoneNumber
	 * @author kiran kumar s
	 * @return EditInstructorInformationPage
	 * @throws Exception
	 */

	public EditInstructorInformationPage enterPhone(String phoneNumber)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING PHONE NUMBER");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtEnterPhoneNumber, waitTime);
			txtEnterPhoneNumber.clearAndSendKeys(phoneNumber);
			logInstruction("LOG INSTRUCTION: PHONE NUMBER ENTERED");
		} catch (Exception e) {
			throw new Exception("LOG INSTRUCTION: ISSUE IN ENTERING 'Phone'"
					+ "\n METHOD: enterPhone \n" + e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * Method helps to enter the fax number
	 * 
	 * @param String
	 *            - faxNumber
	 * @author kiran kumar s
	 * @return EditInstructorInformationPage
	 * @throws Exception
	 */

	public EditInstructorInformationPage enterFax(String faxNumber)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING FAX PHONE NUMBER");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtEnterFax, waitTime);
			txtEnterFax.clearAndSendKeys(faxNumber);
			logInstruction("LOG INSTRUCTION:  FAX PHONE NUMBER ENTERED");
		} catch (Exception e) {
			throw new Exception("LOG INSTRUCTION: ISSUE IN ENTERING 'Fax'"
					+ "\n METHOD: enterFax \n" + e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * Method helps to enter the photo file path
	 * 
	 * @param String
	 *            - filepath
	 * @author kiran kumar s
	 * @return EditInstructorInformationPage
	 * @throws Exception
	 */

	public EditInstructorInformationPage enterPhotoFilePath(String filepath)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING PHOTOFILEPATH ");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtEnterPhotoFilePath, waitTime);
			txtEnterPhotoFilePath.clearAndSendKeys(filepath);
			logInstruction("LOG INSTRUCTION: PhotoFilePath entered ");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN ENTERING 'Photo File Path'"
							+ "\n METHOD: enterPhotoFilePath \n"
							+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * Method helps to click ploto link
	 * 
	 * @author kiran kumar s
	 * @return EditInstructorInformationPage
	 * @throws Exception
	 */

	public LinkWizardUploadImagePage clickAddPhotoLink() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON ADD PHOTO LINK");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkAddPhoto, waitTime);
			lnkAddPhoto.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: CLICKED ON ADD PHOTO LINK");
			uiDriver.getUIWindowLocator().switchToNewWindow();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING ON 'Add Photo Link'"
							+ "\n METHOD: clickAddPhotoLink \n"
							+ e.getLocalizedMessage());
		}
		return new LinkWizardUploadImagePage(uiDriver);
	}

	/**
	 * Method helps to get the entered office location
	 * 
	 * @author kiran kumar s
	 * @return String - office location
	 * @throws Exception
	 */

	public String getOfficeLocation() throws Exception {
		String loc = null;
		try {
			logInstruction("LOG INSTRUCTION: FETCHING THE LOCATION OF OFFICE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(msgOfficeLocation, waitTime);
			loc = msgOfficeLocation.getAttribute("value");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Office Location'"
							+ "\n METHOD: getOfficeLocation \n"
							+ e.getLocalizedMessage());
		}
		return loc;

	}

	/**
	 * Method helps to get the entered office hours
	 * 
	 * @author kiran kumar s
	 * @return String - office hours
	 * @throws Exception
	 */
	public String getOfficeHours() throws Exception {
		String hours = null;
		try {
			logInstruction("LOG INSTRUCTION: FETCHING THE OFFICE HOURS");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(msgOfficeHours, waitTime);
			hours = msgOfficeHours.getAttribute("value");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Office Hours'"
							+ "\n METHOD: getOfficeHours \n"
							+ e.getLocalizedMessage());
		}
		return hours;
	}

	/**
	 * Method helps to select display syllabus radio btn
	 * 
	 * @author kiran kumar s
	 * @param String
	 *            - num - INPUT SHOULD BE EITHER 1 OR 2
	 * @return EditInstructorInformationPage
	 * @throws Exception
	 */

	/* INPUT SHOULD BE EITHER 1 OR 2 */
	public EditInstructorInformationPage selectDisplaySyllabus(String num)
			throws Exception {
		try {
			if (num.equals("1") || num.equals("2")) {
				logInstruction("LOG INSTRUCTION: SELECTING THE DISPLAY SYLLABUS RADIO BUTTON");
				frameSwitch.switchToFrameContent();
				radSelectDisplay.replaceValues(num);
				uiDriver.waitToBeDisplayed(radSelectDisplay, waitTime);
				radSelectDisplay.click();
			}
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN SELECTING 'Display Syllabus'"
							+ "\n METHOD: selectDisplaySyllabus \n"
							+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * @author amit.deshmukh Method helps to getLabel name
	 * @return String - labelname
	 * @throws Exception
	 */

	public String getLabelName() throws Exception {
		String getlabelname = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING LABEL NAME");
			frameSwitch.switchToFrameContent();
			getlabelname = lblName.getText();

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Label Name'"
							+ "\n METHOD: getLabelName \n"
							+ e.getLocalizedMessage());

		}

		return getlabelname;

	}

	/**
	 * @author amit.deshmukh Method helps to getLabelEmail
	 * @return String - email
	 * @throws Exception
	 */

	public String getLabelEmail() throws Exception {

		String getlabelemail = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING LABEL NAME");
			frameSwitch.switchToFrameContent();
			getlabelemail = lblEmail.getText();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Label Email'"
							+ "\n METHOD: getLabelEmail \n"
							+ e.getLocalizedMessage());

		}

		return getlabelemail;

	}

	/**
	 * @author amit.deshmukh Method helps to getLabelOfficeLocation
	 * @return String - officelocation
	 * @throws Exception
	 */

	public String getLabelOfficeLocation() throws Exception {

		String getlabelofficelocation = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING LABEL OFFICE LOCATION");
			frameSwitch.switchToFrameContent();
			getlabelofficelocation = lblOfficeloc.getText();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Label Office Location'"
							+ "\n METHOD: getLabelOfficeLocation \n"
							+ e.getLocalizedMessage());

		}

		return getlabelofficelocation;

	}

	/**
	 * @author amit.deshmukh Method helps to getLabelOfficeHours
	 * @return String - officeours
	 * @throws Exception
	 */

	public String getLabelOfficeHours() throws Exception {

		String getlabelofficehrs = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING LABEL OFFICE HOURS");
			frameSwitch.switchToFrameContent();
			getlabelofficehrs = lblOfficeHrs.getText();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Label Office Hours'"
							+ "\n METHOD: getLabelOfficeHours \n"
							+ e.getLocalizedMessage());
		}

		return getlabelofficehrs;
	}

	/**
	 * @author amit.deshmukh Method helps to getLabelPhone
	 * @return String - phone
	 * @throws Exception
	 */

	public String getLabelPhone() throws Exception {

		String getlabelphone = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING LABEL PHONE");
			frameSwitch.switchToFrameContent();
			getlabelphone = lblOfficePhone.getText();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Label Phone'"
							+ "\n METHOD: getLabelPhone \n"
							+ e.getLocalizedMessage());

		}

		return getlabelphone;

	}

	/**
	 * @author amit.deshmukh Method helps to getLabelFax
	 * @return String - fax
	 * @throws Exception
	 */

	public String getLabelFax() throws Exception {

		String getlabelfax = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING LABEL FAX");
			frameSwitch.switchToFrameContent();
			getlabelfax = lblOfficeFax.getText();
		} catch (Exception e) {
			throw new Exception("LOG INSTRUCTION: ISSUE IN GETTING 'Label Fax'"
					+ "\n METHOD: getLabelFax \n" + e.getLocalizedMessage());

		}
		return getlabelfax;

	}

	/**
	 * @author Raghavendra Andewadikar This method returns Phone number
	 * @return String - phonenumber
	 * @throws Exception
	 */
	public String getPhone() throws Exception {
		String phoneNumber;
		try {
			logInstruction("LOG INSTRUCTION: GETTING ENTERED PHONE NUMBER");
			frameSwitch.switchToFrameContent();
			phoneNumber = msgPhone.getText();
		} catch (Exception e) {
			throw new Exception("LOG INSTRUCTION: ISSUE IN GETTING 'Phone'"
					+ "\n METHOD: getPhone \n" + e.getLocalizedMessage());
		}

		return phoneNumber;
	}

	/**
	 * @author Raghavendra Andewadikar This method returns Fax number
	 * @return String - faxnumber
	 * @throws Exception
	 */
	public String getFax() throws Exception {
		String faxNumber;
		try {
			logInstruction("LOG INSTRUCTION: GETTING ENTERED FAX NUMBER");
			frameSwitch.switchToFrameContent();
			faxNumber = msgFax.getText();
		} catch (Exception e) {
			throw new Exception("LOG INSTRUCTION: ISSUE IN GETTING 'Phone'"
					+ "\n METHOD: getPhone \n" + e.getLocalizedMessage());
		}

		return faxNumber;
	}

	/**
	 * @author Raghavendra Andewadikar This method returns photo file path
	 * @return String - Photofilepath
	 * @throws Exception
	 */
	public String getPhotoFilePath() throws Exception {
		String photoPath;
		try {
			logInstruction("LOG INSTRUCTION: GETTING PHOTO FILE PATH");
			frameSwitch.switchToFrameContent();
			photoPath = msgPhotoFilePath.getText();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Photo File Path'"
							+ "\n METHOD: getPhotoFilePath \n"
							+ e.getLocalizedMessage());
		}

		return photoPath;
	}

	/**
	 * @author Raghavendra Andewadikar This method returns Display On Syllabus
	 *         label
	 * @return String - displayonsyllabus
	 * @throws Exception
	 */
	public String getDisplayOnSyllabus() throws Exception {
		String displayOnSyllabus;
		try {
			logInstruction("LOG INSTRUCTION: GETTING DISPLAY ON SYLLABUS");
			frameSwitch.switchToFrameContent();
			displayOnSyllabus = this.msgDisplayOnSyllabus.getText();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Display On Syllabus'"
							+ "\n METHOD: getDisplayOnSyllabus \n"
							+ e.getLocalizedMessage());
		}

		return displayOnSyllabus;
	}

	/**
	 * This method get the header title
	 * 
	 * @author ashish.juyal
	 * @return string - header
	 * @throws Exception
	 */

	public String getHeaderTitle() throws Exception {
		String text = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(msgHeaderTitle, waitTime);
			text = msgHeaderTitle.getText();

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Header Title'"
							+ "\n METHOD: getHeaderTitle \n"
							+ e.getLocalizedMessage());
		}
		return text;
	}

	/**
	 * This method helps to click on ok button
	 * 
	 * @return EditInstructorInformationPage
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public EditInstructorInformationPage clickOkButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING THE OK BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnOk, waitTime);
			btnOk.click();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING ON  'Ok Button'"
							+ "\n METHOD: clickOkButton \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method checks the whether the ok button is displayed or not
	 * 
	 * @return boolean
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public boolean isokButtonDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING THE OK BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnOk, waitTime);
			flag = btnOk.isDisplayed();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CHECKING 'ok Button Displayed'"
							+ "\n METHOD: isokButtonDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * @author Raghavendra Andewadikar This method returns position of Name
	 *         field
	 * @return String - rownumber
	 * @throws Exception
	 */
	public String getNamePosition(String rowNo) throws Exception {
		String position = null;
		String positionno = null;
		try {
			logInstruction("LOG INSTRUCTION: GET POSITION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lbPositions, waitTime);
			lbPositions.replaceValues(rowNo);
			position = lbPositions.getText();

			if (position.equalsIgnoreCase("Name:")) {
				positionno = "1";
			} else
				logInstruction("LOG INSTRUCTION: Unable to get position of field Name:");

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Name Position'"
							+ "\n METHOD: getNamePosition \n"
							+ e.getLocalizedMessage());
		}

		return positionno;
	}

	/**
	 * @author Raghavendra Andewadikar This method returns position of email
	 *         field
	 * @return String - rownumber
	 * @throws Exception
	 */
	public String getEmailPosition(String rowNo) throws Exception {
		String position = null;
		String positionno = null;
		try {
			logInstruction("LOG INSTRUCTION: GET POSITION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lbPositions, waitTime);
			lbPositions.replaceValues(rowNo);
			position = lbPositions.getText();

			if (position.equalsIgnoreCase("Email:")) {
				positionno = "2";
			} else
				logInstruction("LOG INSTRUCTION: Unable to get position of field Name:");

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Email Position'"
							+ "\n METHOD: getEmailPosition \n"
							+ e.getLocalizedMessage());
		}

		return positionno;
	}

	/**
	 * 
	 * This method helps to select and instructor
	 * 
	 * @return EditInstructorInformationPage
	 * @param String
	 *            - instructorname
	 * @author ashish.juyal
	 * @throws Exception
	 * 
	 */

	public EditInstructorInformationPage selectInstructor(String instructorname)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECTING THE INSTRUCTOR");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(drpSelectInstructor, waitTime);
			drpSelectInstructor.selectByVisibleText(instructorname);
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN SELECTING 'Instructor'"
							+ "\n METHOD: selectInstructor \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to click the save changes button
	 * 
	 * @author ashish.juyal
	 * @return SyllabusHomePage
	 * @throws Exception
	 */

	public SyllabusHomePage clicksaveChangesButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING THE SAVE CHANGES BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
			btnSaveChanges.click();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING ON 'save Changes Button'"
							+ "\n METHOD: clicksaveChangesButton \n"
							+ e.getLocalizedMessage());
		}
		return new SyllabusHomePage(uiDriver);
	}

	/**
	 * This methods check the
	 * label("Select an instructor or teaching assistant:") present below the
	 * header title of the page
	 * 
	 * @return boolean
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public boolean isLabelDisplayed(String labelName) throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING THE LABEL");
			frameSwitch.switchToFrameContent();
			lblElement.replaceValues(labelName);
			if (lblElement.isDisplayedAfterWaiting())
				flag = true;
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN Checking 'Label Displayed'"
							+ "\n METHOD: isLabelDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * method help to get position of labels on EditInstructorInformation Page
	 * 
	 * @author Usha
	 * @param rowNo
	 * @return String - position
	 * @throws Exception
	 */

	public String getPosition(String rowNo) throws Exception {
		String position = null;
		try {
			logInstruction("LOG INSTRUCTION: GET POSITION");
			frameSwitch.switchToFrameContent();
			lblPositions.replaceValues(rowNo);
			uiDriver.waitToBeDisplayed(lblPositions, waitTime);
			lblPositions.replaceValues(rowNo);
			position = lblPositions.getText();
			if (position.equalsIgnoreCase("Name:")) {
				return "1";
			} else if (position.equalsIgnoreCase("Email:")) {
				return "2";
			} else if (position.equalsIgnoreCase("Office Location:")) {
				return "3";
			} else if (position.equalsIgnoreCase("Office Hours:")) {
				return "4";
			} else if (position.equalsIgnoreCase("Phone:")) {
				return "5";
			} else if (position.equalsIgnoreCase("Fax:")) {
				return "6";
			} else if (position.equalsIgnoreCase("Photo:")) {
				return "7";
			} else if (position.equalsIgnoreCase("Display on Syllabus:")) {
				return "8";
			} else {
				return "invalid String";
			}
		}

		catch (Exception e) {
			throw new Exception("LOG INSTRUCTION: ISSUE IN GETTING 'Position'"
					+ "\n METHOD: getPosition \n" + e.getLocalizedMessage());

		}

	}

	/**
	 * This method checks for the TA name present in the dropdown list
	 * 
	 * @author ashish.juyal
	 * @return boolean
	 * @throws Exception
	 */

	public boolean isUserNameDisplayedInDropdownList(String TAName)
			throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKS FOR THE TA NAME PRESENT IN THE DROPDOWN LIST");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(drpSelectInstructor, waitTime);
			List<UIElement> list = drpSelectInstructor.findUIElements(By
					.tagName("option"));
			int size = list.size();
			String text;
			for (int i = 0; i < size; i++) {
				text = list.get(i).getText();
				if (text.contains(TAName)) {
					flag = true;
					break;

				}
			}
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CHECKING 'User Name Displayed In Dropdown List'"
							+ "\n METHOD: isUserNameDisplayedInDropdownList \n"
							+ e.getLocalizedMessage());

		}
		return flag;
	}

	/**
	 * This methods get the location value
	 * 
	 * @return String - location value
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public String getLocationValue() throws Exception {
		String text = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE LOCATION VALUE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(msgOfficeLocation, waitTime);
			text = msgOfficeLocation.getAttribute("value");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Location Value'"
							+ "\n METHOD: getLocationValue \n"
							+ e.getLocalizedMessage());
		}
		return text;
	}

	/**
	 * This method get the fax no value from the input box;
	 * 
	 * @return String - FaxValue
	 * @author ashish.juyal
	 * 
	 */
	public String getFaxStringValue() throws Exception {
		String text = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE LOCATION VALUE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblOfficeFax, waitTime);
			text = lblOfficeFax.getAttribute("value");
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Fax String Value'"
							+ "\n METHOD: getFaxStringValue \n"
							+ e.getLocalizedMessage());
		}
		return text;
	}

	/**
	 * This method is to check the name field is not editable
	 * 
	 * @return boolean
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public boolean isNameFieldEditable() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR THE NAME FIELD");
			frameSwitch.switchToFrameContent();
			if (txtNameEdit.isDisplayedAfterWaiting())
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CHECKING 'Name Field Editable'"
							+ "\n METHOD: isNameFieldEditable \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method helps to enter value in rad editor
	 * 
	 * @return string
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public String getRadEditorValue() throws Exception {
		String name = null;
		try {
			logInstruction("LOG INSTRUCTION: ENTERING VALUE IN RAD EDITOR");
			frameSwitch.switchToRadeEntryTextcontentIframe();
			uiDriver.waitToBeDisplayed(areaRaded, waitTime);
			name = areaRaded.getText();
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN GETTING 'Rad Editor Value'"
							+ "\n METHOD: getRadEditorValue \n"
							+ e.getLocalizedMessage());
		}
		return name;
	}

	/**
	 * This method helps to enter value in rad editor
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public EditInstructorInformationPage enterRadEditorValue(String name)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING VALUE IN RAD EDITOR");
			frameSwitch.switchToRadeEntryTextcontentIframe();
			uiDriver.waitToBeDisplayed(areaRaded, waitTime);
			areaRaded.sendKeys(Keys.CONTROL + "a");
			areaRaded.sendKeys(Keys.DELETE);
			areaRaded.sendKeys(name);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING 'Rad Editor Value'"
					+ "\n METHOD: enterRadEditorValue \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This is Service level method to Add/Edit Instructor Information.
	 * 
	 * @author Kapil
	 * @param selectInstructor
	 * @param officeLocation
	 * @param officeHousrs
	 * @param phone
	 * @param fax
	 * @param photoPath
	 * @param actionForPhotoUpload
	 * @param tagForPhotoUpload
	 * @param renamePhotoUploadFile
	 * @param displayOnSyllabus
	 * @param description
	 * @return SyllabusHomePage
	 */
	public SyllabusHomePage enterInstructorInformation(String selectInstructor,
			String officeLocation, String officeHours, String phone,
			String fax, String photoPath, String actionForPhotoUpload,
			String tagForPhotoUpload, boolean renamePhotoUploadFile,
			String photoDescription, boolean displayOnSyllabus,
			String description) throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(drpSelectInstructor, waitTime);
			drpSelectInstructor.selectByVisibleText(selectInstructor);
			logInstruction("LOG INSTRUCTION: SELECTED INSTRUCTOR");
			txtEnterOfficeLocation.clearAndSendKeys(officeLocation);
			logInstruction("LOG INSTRUCTION: ENTERED OFFICE LOCATION");
			txtEnterOfficeHrs.clearAndSendKeys(officeHours);
			logInstruction("LOG INSTRUCTION: ENTERED OFFICE HOURS");
			txtEnterPhoneNumber.clearAndSendKeys(phone);
			logInstruction("LOG INSTRUCTION: ENTERED PHONE");
			uiDriver.waitToBeDisplayed(txtEnterFax, waitTime);
			txtEnterFax.clearAndSendKeys(fax);
			logInstruction("LOG INSTRUCTION: ENTERED FAX");
			uiDriver.waitToBeDisplayed(lnkAddPhoto, waitTime);
			lnkAddPhoto.clickAndWait(waitTime);
			LinkWizardUploadImagePage uploadImage = new LinkWizardUploadImagePage(
					uiDriver);
			uiDriver.getUIWindowLocator().switchToNewWindow();
			// uploadImage.enterDescriptiveText(photoDescription);
			// uploadImage.uploadFile(photoPath, actionForPhotoUpload,
			// tagForPhotoUpload, renamePhotoUploadFile, uploadImage);
			// uploadImage.clickAddLink();
			uploadImage.createUploadImage(photoDescription, true, false, null,
					null, photoPath, actionForPhotoUpload, tagForPhotoUpload,
					renamePhotoUploadFile);
			frameSwitch.switchToFrameContent();
			logInstruction("LOG INSTRUCTION: UPLOADED PHOTO");
			if (displayOnSyllabus) {
				radSelectDisplay.replaceValues("1");
				uiDriver.waitToBeDisplayed(radSelectDisplay, waitTime);
				radSelectDisplay.clickNoWait();
				logInstruction("LOG INSTRUCTION: SELECTED YES DISPLAY SYLLABUS RADIO BUTTON");
			} else {
				radSelectDisplay.replaceValues("2");
				uiDriver.waitToBeDisplayed(radSelectDisplay, waitTime);
				radSelectDisplay.clickNoWait();
				logInstruction("LOG INSTRUCTION: SELECTED NO DISPLAY SYLLABUS RADIO BUTTON");
			}
			logInstruction("LOG INSTRUCTION: SELECTED RADIO BUTTON FOR 'Display on Syllabus' OPTION");
			getVisualEditor().enterText(description);
			logInstruction("LOG INSTRUCTION: ENTERED DESCRIPTION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
			btnSaveChanges.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED ON SAVE CHANGES BUTTON");
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING 'Instructor Information'"
					+ "\n METHOD: enterInstructorInformation \n"
					+ e.getLocalizedMessage());
		}
		return new SyllabusHomePage(uiDriver);
	}
	
	
	  /**
     * This method helps to click the Cancel Button 
     * 
     * @author ashish.juyal
     * @return SyllabusHomePage
     * @throws Exception
     */

    public SyllabusHomePage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.click();
        } catch (Exception e) {
        	throw new Exception("LOG INSTRUCTION: ISSUE IN CLICKING ON 'CANCEL Button'"+"\n METHOD: clickCancelButton \n" + e.getLocalizedMessage());
        }
        return new SyllabusHomePage(uiDriver);
    }
    
    
    /**
     * Method helps to check whether Edit Introductory Informantion RAD Editor presence
     * 
     * @category Milestone 2
     * @author suchi.singh
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isEditIntroductoryInformantionRadEditorPresent() throws Exception {
        boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER EDIT INTRODUCTORY INFORMANTION RAD EDITOR IS BEING DISPLAYED");
			if ( RADEditor!= null) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER EDIT INTRODUCTORY INFORMANTION RAD EDITOR IS DISPLAYED OR NOT"
							+ "\n METHOD : isEditIntroductoryInformantionRadEditorPresent \n"
							+ e.getLocalizedMessage());
		}
		return flag;
    }

}
