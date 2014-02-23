package com.pearson.eselenium.ls.coursehome.filemanager.pages;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of AddFolderPage Follow the below steps to
 * navigate the page:
 * 
 * 1 - Login as prof 2 - Click on the Course 3 - Select Author Tab 4 - Click FileManager Tab 5 -
 * click AddFolder link
 * 
 * @author Chaitali
 * @modifiedBy Vivek.Singh - - Based on code review comments by Lanka Pearson
 */
public class AddFolderPage extends BasePageObject {

    /* Elements */
    private UIElement btnAddFolder = createElement(UIType.Css, "input[name='AddFolder']");
    private UIElement btnSaveAndAddAnotherFolder = createElement(
            UIType.Css,
            "input[name='AddAnotherFolder']");
    private UIElement btnCancel = createElement(UIType.Css, "#btnCancel");
    private UIElement txtEnterFolderName = createElement(UIType.Css, "#Name");
    private UIElement lblFolderName = createElement(
            UIType.Css,
            ".innercontenttable>tbody>tr>td>table>tbody>tr>td>table>tbody>tr:first-of-type>td:last-of-type");
    private UIElement msgError = createElement(UIType.Xpath, "//table[2]//table[1]//table//td[2]");
    private UIElement lblHeaderTitle = createElement(UIType.Css, ".tablehead");
    private UIElement lblInstructionalText = createElement(
            UIType.Xpath,
            "//table//table[2]//tr[4]/td[1]");
    private UIElement lblAddFolderTo = createElement(
            UIType.Xpath,
            "//table/tbody/tr/td[1][@role='section']");
    private UIElement lblFolderNameText = createElement(
            UIType.Css,
            ".innercontenttable>tbody>tr>td>table>tbody>tr>td>table>tbody>tr:nth-child(1)>td:nth-child(2)");

    /* JavascriptExecutor elements */
    private static final String LBLNAME_JS = "$('.innercontenttable>tbody>tr>td>table>tbody>tr>td>table>tbody>tr>td')[0]";
    private static final String LBLADDFOLDERTO_JS = "('label')[0]";
    private static final String AREATEXT_JS = "$('.innercontenttable>tbody>tr>td>table>tbody>tr>td>table>tbody>tr>td>label')[0]";
    private static final String LBLFOLDERNAME_JS = "('Name')";
    private static final String TBLTABLE1_JS = "('table')[1]";
    private static final String AREAINPUT1_JS = "('input')[8]";
    private static final String AREAINPUT2_JS = "('input')[9]";
    private static final String AREAINPUT3_JS = "('input')[10]";
    private static final String TBLTABLE2_JS = "$('.outercontenttable')[0]";
    private static final String BTNA1_JS = "('a')[0]";
    private static final String BTNA2_JS = "('a')[1]";
    private static final String BTNA3_JS = "('a')[2]";
    private static final String ADD_FOLDER_TO = "Add folder to:";
    private static final String FOLDER_NAME = "Folder Name:";
	private static final String STR_RETURN = "return";
	private String strMessage = null;
	private StringBuilder strScript1 = null;
	private StringBuilder strScript2 = null;
	private StringBuilder strScript3 = null;
	private StringBuilder strScript4 = null;
	private int intLocation1 = 0;
	private int intLocation2 = 0;
	private int intLocation3 = 0;
	private int intLocation4 = 0;
	private boolean flag = false;

	/* Constructor */
	public AddFolderPage(UIDriver driver) {
		super(driver);
		pageTitle = "Add Folder";
		logInstruction("LOG INSTRUCTION: ## AddFolderPage ##");
	}

    /**
     * Method helps to click 'Add Folder' Button present at bottom right of table.
     * 
     * Navigates to {@link FileManagerPage} if valid folder name is provided.
     * 
     * @author Chaitali
     * @return Object
     * @throws Exception
     * @modifiedBy Vivek.Singh - - return type changed from FileManagerPage to Object
     */
    public Object clickAddFolderButton() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICK 'Add Folder' BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnAddFolder, waitTime);
            btnAddFolder.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'Add Folder' BUTTON. BUTTON IS NOT DISPLAYED. \n METHOD : clickAddFolderButton .\n " + e
                            .getLocalizedMessage());
        }
        if (isAddFolderButtonDisplayed())
            return this;
        else
            return new FileManagerPage(uiDriver);
    }

    /**
     * Method helps to click "Save And Add Another Folder" Button.
     * 
     * Remains on the same page, and provides ease to add more folders.
     * 
     * @author Chaitali
     * @return {@link AddFolderPage}
     * @throws Exception
     */
    public AddFolderPage clickSaveAndAddAnotherFolderButton() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICK 'Save And Add Another Folder' BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSaveAndAddAnotherFolder, waitTime);
            btnSaveAndAddAnotherFolder.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'Save And Add Another Folder' BUTTON. BUTTON IS NOT DISPLAYED.\n METHOD : clickSaveAndAddAnotherFolderButton .\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to click Cancel Button.
     * 
     * Navigates to {@link FileManagerPage} and doesnot adds any folder name last provided in text
     * area.
     * 
     * @author Chaitali
     * @return {@link FileManagerPage}
     * @throws Exception
     */
    public FileManagerPage clickCancelButton() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICK 'Cancel' BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'Cancel' BUTTON. BUTTON IS NOT DISPLAYED.\n METHOD : clickCancelButton .\n" + e
                            .getLocalizedMessage());
        }
        return new FileManagerPage(uiDriver);
    }

    /**
     * Method helps to enter folder name in text area opposite to 'Folder Name'.
     * 
     * @author Chaitali
     * @param String
     *            - name
     * @return {@link AddFolderPage}
     * @throws Exception
     */
    public AddFolderPage enterFolderName(String strName) throws Exception {
        logInstruction("LOG INSTRUCTION: ENTER FOLDER FAME IN THE GIVEN TEXT AREA. ");
        try {
        	if(StringUtils.isNotBlank(strName)){
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtEnterFolderName, waitTime);
                txtEnterFolderName.clearAndSendKeys(strName);
        	}else
        		throw new Exception("PARAMETER CONTAINING FOLDER NAME IS EMPTY. \n METHOD : enterFolderName .\n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER FOLDER NAME IN TEXT AREA OPPOSITE TO 'Folder Name: *'. TEXT AREA IS NOT DISPLAYED.\n METHOD : enterFolderName .\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to get folder name of default folder to which new folder is being added to.
     * 
     * @author Chaitali
     * @return String folderName
     * @throws Exception
     */
    public String getAddFolderTo() throws Exception {
    	strMessage = null;
        logInstruction("LOG INSTRUCTION: GET FOLDER NAME OPPOSITE TO 'Add folder to:' LABEL.");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblFolderName, waitTime);
            strMessage = lblFolderName.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET FOLDER NAME OPPOSITE TO 'Add folder to:' LABEL. LABEL IS NOT DISPLAYED.\n METHOD : getAddFolderTo .\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * Method helps to get header title of the {@link AddFolderPage}.
     * 
     * @author Chaitali
     * @return String headerTitle
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
    	strMessage = null;
        logInstruction("LOG INSTRUCTION: GET HEADER TITLE");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblHeaderTitle, waitTime);
            strMessage = lblHeaderTitle.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET HEADER TITLE.\n METHOD : getHeaderTitle .\n" + e
                    .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * Method helps to get error message when some incorrect folder name is provided. This will
     * arise when folder name contains special characters.
     * 
     * @author Chaitali
     * @return String errorMessage
     * @throws Exception
     */
    public String getErrorMessage() throws Exception {
    	strMessage = null;
        logInstruction("LOG INSTRUCTION: GET ERROR MESSAGE");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgError, waitTime);
            strMessage = msgError.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET ERROR MESSAGE. \nMETHOD : getErrorMessage .\n" + e
                    .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * Method helps to check whether 'Add Folder' button is displayed or not.
     * 
     * @author Chaitali
     * @return boolean - - true if button displayed false if button not displayed
     * @throws Exception
     * @modifiedBy Sumanth.SV -- Application is taking time to refresh the page so inserted
     *             Thread.sleep()
     */
    public boolean isAddFolderButtonDisplayed() throws Exception {
    	flag = false;
        logInstruction("LOG INSTRUCTION: CHECKING FOR EXISTENCE OF 'Add Folder' BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.sleep(waitTime, "APPLICATION IS TAKING TIME TO REFRESH THE PAGE");
            flag = btnAddFolder.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND 'Add Folder' BUTTON. \n METHOD : isAddFolderButtonDisplayed.\n " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether "Save and Add Another Folder" button is displayed or not.
     * 
     * @author Chaitali
     * @return boolean - - true if button is displayed false if button is not displayed
     * @throws Exception
     */
    public boolean isSaveAndAddAnotherFolderButtonDisplayed() throws Exception {
    	flag = false;
        logInstruction("LOG INSTRUCTION: CHECKING FOR EXISTENCE OF 'Save And Add Another Folder' BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            flag = btnSaveAndAddAnotherFolder.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND 'Save And Add Another Folder' BUTTON. \n METHOD : isSaveAndAddAnotherFolderButtonDisplayed.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether "Cancel" button is displayed or not.
     * 
     * @author Chaitali
     * @return boolean -- true if button displayed false if button not displayed
     * @throws Exception
     */
    public boolean isCancelButtonDisplayed() throws Exception {
    	flag = false;
        logInstruction("LOG INSTRUCTION: CHECKING FOR EXISTENCE OF 'Cancel' BUTTON.");
        try {
            frameSwitch.switchToFrameContent();
            flag = btnCancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND 'Cancel' BUTTON. \n METHOD : isCancelButtonDisplayed.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get instructional text
     * 
     * @author Chaitali
     * @return String instructional text
     * @throws Exception
     */
    public String getInstructionalText() throws Exception {
    	strMessage = null;
        logInstruction("LOG INSTRUCTION: GET 'Instructional Text'");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblInstructionalText, waitTime);
            strMessage = lblInstructionalText.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Instructional Text'. \n METHOD : getInstructionalText.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * Method helps to check if "Add folder to:" label exists or not
     * 
     * @author Chaitali
     * @return boolean --true if label found false if label not found
     * @throws Exception
     */
    public boolean isAddToFolderLabelExists() throws Exception {
    	flag = false;
        logInstruction("LOG INSTRUCTION: CHECKING 'Add folder to:' LABEL. ");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblAddFolderTo, waitTime);
            flag = ADD_FOLDER_TO.equalsIgnoreCase(lblAddFolderTo.getText());
        } catch (Exception e) {
            throw new Exception(
                    "LABEL 'Add folder to:' DOESNOT EXIST. \n METHOD : isAddToFolderLabelExists.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check if "Folder Name:" label exists or not.
     * 
     * @author Chaitali
     * @return boolean -- true if label found false if not found
     * @throws Exception
     */
    public boolean isFolderNameLabelExists() throws Exception {
    	flag = false;
        logInstruction("LOG INSTRUCTION: CHECKING 'Folder Name:' LABEL. ");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblFolderNameText, waitTime);
            flag = FOLDER_NAME.equalsIgnoreCase(lblFolderNameText.getText());
        } catch (Exception e) {
            throw new Exception(
                    "LABEL 'Folder Name:' DOESNOT EXIST. \n METHOD : isFolderNameLabelExists.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will get label opposite to "Add folder to:".
     * 
     * @author Vivek.Singh
     * @return String - folder label
     * @throws Exception
     * **/
    public String getLabelOppositeToAddFolderTo() throws Exception {
    	strMessage = null;
    	logInstruction("LOG INSTRUCTION: GETTING LBL OF FOLDER OPPOSITE TO 'Add folder to:' LABEL.");
    	try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblFolderNameText, waitTime);
            strMessage = lblFolderNameText.getText();
        } catch (Exception e) {
            throw new Exception(
                    "LABEL OPPOSITE TO 'Add folder to:' DOESNOT EXIST. \n METHOD : getLabelOppositeToAddFolderTo.\n" + e
                            .getLocalizedMessage());
        }
    	return strMessage;
    }

    /**
     * This method will check whether label name is below 'Add folder to:' label or not.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * 
     *             location to is returning double value hence casting :praveen 27Nov
     * **/
    public boolean isLabelNameBelowAddFolderTo() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN);
        strScript2 = new StringBuilder(STR_RETURN);
		intLocation1 = 0;
		intLocation2 = 0;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING LABEL NAME IS BELOW 'Add folder to:'.");
			frameSwitch.switchToFrameContent();
			intLocation1 = Integer.parseInt(uiDriver.executeScript(strScript1
					.append(LBLNAME_JS)
					.append(".getBoundingClientRect().bottom").toString()));
			intLocation2 = (int) Double
					.parseDouble(uiDriver.executeScript(strScript2
							.append(" document.getElementsByTagName")
							.append(LBLADDFOLDERTO_JS)
							.append(".getBoundingClientRect().top").toString()));
			if (intLocation1 < intLocation2)
				flag = true;
		} catch (Exception e) {
			throw new Exception(
					"LABEL BELOW 'Add folder to:' DOESNOT EXIST. \n METHOD : isLabelNameBelowAddFolderTo.\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

    /**
     * This method will check position of text area wrt "Folder Name:" label .
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isTextAreaDisplayedNextToFolderName() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN);
        strScript2 = new StringBuilder(STR_RETURN);
		intLocation1 = 0;
		intLocation2 = 0;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING POSITION OF TEXT AREA TOWARD RIGHT OF 'Folder Name:' LABEL.");
			frameSwitch.switchToFrameContent();
			intLocation1 = Integer.parseInt(uiDriver.executeScript(strScript1
					.append(AREATEXT_JS)
					.append(".getBoundingClientRect().right").toString()));
			intLocation2 = Integer.parseInt(uiDriver.executeScript(strScript2
					.append(" document.getElementById")
					.append(LBLFOLDERNAME_JS)
					.append(".getBoundingClientRect().left").toString()));
			if (intLocation2 > intLocation1)
				flag = true;
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO VERIFY POSITION OF TEXT AREA TOWARD RIGHT OF 'Folder Name:' LABEL. \n METHOD: isTextAreaDisplayedNextToFolderName.\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

    /**
     * This method will check whether position of add folder button wrt 'Add folder table'.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isAddFolderPresentBelowAddFolderTable() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN);
        strScript2 = new StringBuilder(STR_RETURN);
		intLocation1 = 0;
		intLocation2 = 0;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING POSITION OF 'Add Folder' BUTTON.");
			frameSwitch.switchToFrameContent();
			intLocation1 = Integer.parseInt(uiDriver.executeScript(strScript1
					.append(" document.getElementsByTagName")
					.append(TBLTABLE1_JS)
					.append(".getBoundingClientRect().bottom").toString()));
			intLocation2 = Integer.parseInt(uiDriver.executeScript(strScript1
					.append(" document.getElementsByTagName")
					.append(AREAINPUT1_JS)
					.append(".getBoundingClientRect().top").toString()));
			if (intLocation2 > intLocation1)
				flag = true;
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO VERIFY POSITION OF 'Add Folder' BUTTON TOWARDS BOTTOM OF 'Add Folder' TABLE. \n METHOD: isAddFolderPresentBelowAddFolderTable.\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

    /**
     * This method will check whether position of 'Save And Add Another Folder' button wrt 'Add
     * Folder' button.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isSaveAndAddFolderPresentRightOfAddFolderButton() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN);
        strScript2 = new StringBuilder(STR_RETURN);
		intLocation1 = 0;
		intLocation2 = 0;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING POSITION OF 'Save And Add Another Folder' BUTTON W.R.T. 'Add Folder' BUTTON.");
			frameSwitch.switchToFrameContent();
			intLocation1 = Integer.parseInt(uiDriver.executeScript(strScript1
					.append(" document.getElementsByTagName")
					.append(AREAINPUT1_JS)
					.append(".getBoundingClientRect().right").toString()));
			intLocation2 = Integer.parseInt(uiDriver.executeScript(strScript2
					.append(" document.getElementsByTagName")
					.append(AREAINPUT2_JS)
					.append(".getBoundingClientRect().left").toString()));
			if (intLocation2 > intLocation1)
				flag = true;
		} catch (Exception e) {
			throw new Exception(
					"UNABLE VERIFYING POSITION OF 'Save And Add Another Folder' BUTTON W.R.T. 'Add Folder' BUTTON. \nMETHOD: isSaveAndAddFolderPresentRightOfAddFolderButton.\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

    /**
     * This method will check whether position of cancel button wrt save and add another button.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isCancelButtonRightOfSaveAndAddAnother() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN);
        strScript2 = new StringBuilder(STR_RETURN);
		intLocation1 = 0;
		intLocation2 = 0;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING POSITION OF 'Cancel' BUTTON NEXT TO 'Save And Add Another Folder' BUTTON.");
			frameSwitch.switchToFrameContent();
			intLocation1 = Integer.parseInt(uiDriver.executeScript(strScript1
					.append(" document.getElementsByTagName")
					.append(AREAINPUT2_JS)
					.append(".getBoundingClientRect().right").toString()));
			intLocation2 = Integer.parseInt(uiDriver.executeScript(strScript2
					.append(" document.getElementsByTagName")
					.append(AREAINPUT3_JS)
					.append(".getBoundingClientRect().left").toString()));
			if (intLocation2 > intLocation1)
				flag = true;
		} catch (Exception e) {
			throw new Exception(
					"UNABLE VERIFYING POSITION OF 'Cancel' BUTTON W.R.T. 'Save And Add Another Folder' BUTTON. \nMETHOD: isCancelButtonRightOfSaveAndAddAnother.\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

    /**
     * This method will return 'Add Folder' caption.
     * 
     * @author Vivek.Singh
     * @return String - Add Folder caption
     * @throws Exception
     * **/
    public String getAddFolderCaption() throws Exception {
    	strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Add Folder' CAPTION");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnAddFolder, waitTime);
            strMessage = btnAddFolder.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Add Folder' CAPTION. \nMETHOD: getAddFolderCaption.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * This method will return 'Save And Add Another Folder' button caption.
     * 
     * @author Vivek.Singh
     * @return String - folder caption
     * @throws Exception
     * **/
    public String getSaveAndAddFolderCaption() throws Exception {
    	strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Save And Add Another Folder' BUTTON CAPTION");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSaveAndAddAnotherFolder, waitTime);
            strMessage = btnSaveAndAddAnotherFolder.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Save And Add Another Folder' BUTTON CAPTION. \nMETHOD: getSaveAndAddFolderCaption.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * This method will return 'Cancel' button caption.
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getCancelCaption() throws Exception {
    	strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Cancel' BUTTON CAPTION");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            strMessage = btnCancel.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Cancel' BUTTON CAPTION. \nMETHOD: getCancelCaption.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * This method will check whether 'Add Folder' table is below content navigation tabs or not.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isAddFolderTablePresentBelowContentNavigation() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN);
        strScript2 = new StringBuilder(STR_RETURN);
        strScript3 = new StringBuilder(STR_RETURN);
        strScript4 = new StringBuilder(STR_RETURN);
		intLocation1 = 0;
		intLocation2 = 0;
		intLocation3 = 0;
		intLocation4 = 0;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING WHETHER 'Add Folder' TABLE PRESENT BELOW CONTENT NAVIGATION TABS.");
			frameSwitch.switchToFrameContent();
			intLocation1 = Integer.parseInt(uiDriver.executeScript(strScript1
					.append(" document.getElementsByTagName").append(BTNA1_JS)
					.append(".getBoundingClientRect().bottom").toString()));
			intLocation2 = Integer.parseInt(uiDriver.executeScript(strScript2
					.append(" document.getElementsByTagName").append(BTNA2_JS)
					.append(".getBoundingClientRect().bottom").toString()));
			intLocation3 = Integer.parseInt(uiDriver.executeScript(strScript3
					.append(" document.getElementsByTagName").append(BTNA3_JS)
					.append(".getBoundingClientRect().bottom").toString()));
			intLocation4 = Integer.parseInt(uiDriver.executeScript(strScript4
					.append(TBLTABLE2_JS)
					.append(".getBoundingClientRect().top").toString()));
			if (intLocation1 == intLocation2) {
				if (intLocation1 == intLocation3) {
					if (intLocation1 < intLocation4) {
						logInstruction("LOG INSTRUCTION: TABLE IS BELOW");
						flag = true;
					}
				}
			} else {
				logInstruction("LOG INSTRUCTION: TABLE IS NOT BELOW.");
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"CANNOT LOCATE 'Add Folder' TABLE BELOW CONTENT NAVIGATION TABS. \n METHOD: isAddFolderTablePresentBelowContentNavigation.\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

    /**
     * Method helps to click 'Add Folder' Button. Navigates to {@link FileManagerPage}. Method was
     * introduced in order to prevent casting exception.
     * 
     * @author praveen.maled
     * @return Object
     * @throws Exception
     */
    public FileManagerPage clickForValidAddFolderButton() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICK 'Add Folder' BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnAddFolder, waitTime);
            btnAddFolder.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'Add Folder' BUTTON. \nMETHOD: clickForValidAddFolderButton.\n" + e
                            .getLocalizedMessage());
        }

        return new FileManagerPage(uiDriver);
    }

    /**
     * Method helps to click AddFolder Button Navigates to {@link AddFolderPage} if valid folder
     * name is not provided. Method was introduced in order to prevent casting exception.
     * 
     * @author praveen.maled
     * @return Object
     * @throws Exception
     */
    public AddFolderPage clickForInValidAddFolderButton() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICK 'Add Folder' BUTTON FOR INVALID ENTRY");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnAddFolder, waitTime);
            btnAddFolder.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'Add Folder' BUTTON. \nMETHOD: clickForInValidAddFolderButton.\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }
    
    /**
     * This is a service method to create a folder.
     *  
     * @Navigation If saveAndAnotherFolder is false - {@link FileManagerPage}, else remains on {@link AddFolderPage}
     * @author Vivek.Singh
     * @param {@link String}, {@link Boolean}
     * @return Object
     * @category Milestone 1
     * @throws Exception
     * **/
    public Object addFolder(String strFolderName,boolean saveAndAnotherFolder) throws Exception{
    	logInstruction("LOG INSTRUCTION: CREATING FOLDER.");
    	try{
    		if(StringUtils.isNotBlank(strFolderName)){
    			frameSwitch.switchToFrameContent();
    			logInstruction("LOG INSTRUCTION: ENTERING 'Folder' NAME.");
        		uiDriver.waitToBeDisplayed(txtEnterFolderName, waitTime);
                txtEnterFolderName.clearAndSendKeys(strFolderName);
                
                logInstruction("LOG INSTRUCTION: CHECKING WHETHER 'Save & Add Another Folder' BUTTON IS REQUIRED TO CLICK.");
                if(saveAndAnotherFolder){
                	logInstruction("LOGINSTRUCTION: CLICKING 'Save & Add Another Folder' button.");
                	uiDriver.waitToBeDisplayed(btnSaveAndAddAnotherFolder, waitTime);
                    btnSaveAndAddAnotherFolder.clickNoWait();
                    return this;
                }else { //if(saveAndAnotherFolder)
                	logInstruction("LOGINSTRUCTION: CLICKING 'Add Folder' button.");
                	uiDriver.waitToBeDisplayed(btnAddFolder, waitTime);
                    btnAddFolder.clickAndWait(waitTime);
                    return new FileManagerPage(uiDriver);
                }
    		}else 
    			throw new Exception("INPUT PARAMETER FOR 'Folder name' IS BLANK. \nMETHOD: addFolder.\n");
    	}catch(Exception e){
    		throw new Exception("ISSUE IN CREATING 'folder' IN ADD FOLDER PAGE. \nMETHOD: addFolder.\n" + e.getLocalizedMessage());
    	}
    }
}
