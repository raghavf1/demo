package com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.eselenium.ls.course.pages.NextCourseHomePage;
import com.pearson.eselenium.ls.coursetools.gradebook.pages.GradebookDetailsUIPage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all the methods related to thread home page
 * 
 * @author ganapati.bhat
 * 
 */
public class ThreadHomePage extends BasePageObject {

	/* Elements */
	private UIElement lnkAddTopic = createElement(UIType.LinkText, "Add Topic");
	private UIElement mnuToolBox = createElement(UIType.Xpath,
			"//a[contains(.,'Toolbox')]");
	private UIElement lnkRespond = createElement(UIType.LinkText, "Respond");
	private UIElement lnkExpandAll = createElement(UIType.LinkText,
			"Expand All");
	private UIElement lnkSortByAuthor = createElement(UIType.Css,
			".threadheading>a[title='Sort by Author']");
	private UIElement imgSortByAuthor = createElement(UIType.Css,
			".threadheading>a[title='Sort by Author']>img");
	private UIElement lblThreadTitle = createElement(UIType.Css, ".pageTitle");
	private UIElement lnkAddedtopic = createElement(UIType.Xpath,
			"//th[contains(.,'{1}')]");
	private UIElements lstTableHeader = createElements(UIType.Css,
			"div.tablehead");
	private UIElement imgClickOnEdit = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'List Of Topics')]//tbody[tr[th[contains(.,'{1}')]]]//tr//td[1]/a");

	private UIElement imgClickOnDelete = createElement(
			UIType.Xpath,
			"//table[contains(@summary,'List Of Topics')]//tbody[tr[th[contains(.,'{1}')]]]//tr//td[2]/a");
	private UIElement chkIAgreeBox = createElement(UIType.Css,
			"input#isConfirmed");

	private UIElement chkdeletetopicresponse = createElement(UIType.Css,
			"#deleteButtton");
	private UIElement chkdeletecancel = createElement(UIType.Css,
			"input[value='Cancel']");

	private UIElement lnkTopicExpandCollapse = createElement(UIType.Xpath,
			"//td[a[contains(text(),'{1}')]]/preceding-sibling::td[2]/a");

	private UIElement lnkrespond = createElement(
			UIType.Xpath,
			"//tr[td[table[tbody[tr[td[a[contains(text(),'{1}')]]]]]]]/following-sibling::tr/td/table/tbody/tr/td[2]/div[3]/a[1]");
	private UIElement lnkEditLink = createElement(
			UIType.Xpath,
			"//tr[td[table[tbody[tr[td[a[contains(text(),'{1}')]]]]]]]/following-sibling::tr/td/table/tbody/tr/td[2]/div[3]/a[2]");
	private UIElement lnkDeleteLink = createElement(
			UIType.Xpath,
			"//tr[td[table[tbody[tr[td[a[contains(text(),'{1}')]]]]]]]/following-sibling::tr/td/table/tbody/tr/td[2]/div[3]/a[3]");
	private UIElement lnkClickPrintView = createElement(UIType.LinkText,
			"Print View");
	private UIElement lblVerifyResponseprint = createElement(UIType.Xpath,
			"//div[contains(text(),'Responses')]");
	private UIElement btnClicksave = createElement(UIType.ID, "btnAdd1");
	private UIElement btnPermanentdelete = createElement(UIType.Css,
			"#deleteButtton");
	private UIElement lnkClickEmailIcon = createElement(
			UIType.Xpath,
			"//tr[td[table[tbody[tr[td[a[contains(text(),'{1}')]]]]]]]//td/a/img[contains(@alt,'Email this Author')]");
	private UIElement lnkEditlink = createElement(UIType.Css,
			"span[ aria-hidden='true']");
	private UIElement btnToolBox = createElement(UIType.LinkText, "Toolbox");
	private UIElement imgIconDocument = createElement(
			UIType.Xpath,
			"//table[@class='threadborder']//tbody[tr//table//a[text()='{1}']][tr//span[@class='attachmentlink'][a//text()='{2}']]");
	private UIElement lblAttachedFileName = createElement(
			UIType.Xpath,
			"//table[@class='threadborder'][1]//tbody[tr//table//a[text()='{1}']][tr//span[@class='attachmentlink']]//tr[2]//span//a");
	private UIElement lnkClickAttachedFile = createElement(
			UIType.Xpath,
			"//table[@class='threadborder']//tbody[tr//table//a[text()='{1}']]//a[text()='{2}']");
	private UIElement lnkTopicAttachment = createElement(UIType.Xpath,
			"//a[contains(text(),'{1}')]");
	private UIElement lblpagetitle = createElement(UIType.Css, ".pageTitle");
	private UIElement lblheader = createElement(UIType.Css, ".tablehead");
	private UIElement lnkEditorSwitch = createElement(UIType.Css, "#telerikRAD");
	private UIElement mnuContent = createElement(UIType.Xpath,
			"//a[contains(.,'Content')]");
	private UIElement lnkresponseName;
	private UIElement imgGradeIcon;
	private UIElement lnktopic;
	private UIElement lnkEdit;
	private UIElement lnkFirstEdit;

	/* Variables */
	private boolean flag = false;
	private String strResult = null;

	/* Constructor */
	public ThreadHomePage(UIDriver uiDriver) {
		super(uiDriver);
		pageTitle = "ThreadHomePage";
		logInstruction("LOG INSTRUCTION: ## Thread Home Page ##");
	}

	private String toolID = "RadeEntryText";
	private String frameID = "RadeEntryText_contentIframe";
	private VisualEditor visual = new VisualEditor(uiDriver, toolID, frameID,
			toolID);

	public VisualEditor getvisualEditor() {
		return visual;
	}

	/**
	 * This method helps to click the ToolBox button
	 * 
	 * @author ganapati.bhat
	 * @throws Exception
	 * @return ThreadToolBoxPage
	 * 
	 * 
	 */
	public ThreadToolBoxPage clickToolBoxButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING THE 'ToolBox' BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnToolBox, waitTime);
			btnToolBox.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'ToolBox' BUTTON"
					+ "\nMETHOD:clickToolBoxButton \n"
					+ e.getLocalizedMessage());
		}
		return new ThreadToolBoxPage(uiDriver);
	}

	/**
	 * Method helps to click on the ToolBox tab
	 * 
	 * @author ganapati.bhat
	 * @return ThreadToolBoxPage
	 * @throws Exception
	 */
	public ThreadToolBoxPage selectToolBox() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECTING 'ToolBox'");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(mnuToolBox, waitTime);
			mnuToolBox.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON THE 'ToolBox' MENU "
					+ "\nMETHOD:selectToolBox \n" + e.getLocalizedMessage());
		}
		return new ThreadToolBoxPage(uiDriver);
	}

	/**
	 * Method helps to click on the addTopic link
	 * 
	 * @author ganapati.bhat
	 * @return AddTopicPage
	 * @throws Exception
	 */
	public AddTopicPage clickAddTopic() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON THE 'Add Topic' LINK");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkAddTopic, waitTime);
			lnkAddTopic.toString().trim();
			lnkAddTopic.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON THE 'Add Topic' LINK"
					+ "\nMETHOD:clickAddTopic \n" + e.getLocalizedMessage());
		}
		return new AddTopicPage(uiDriver);
	}

	/**
	 * Method helps to click on the respond link
	 * 
	 * @author ganapati.bhat
	 * @return ThreadRespondPage
	 * @throws Exception
	 */
	public ThreadRespondPage clickRespond() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON THE 'Respond' LINK");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkRespond, waitTime);
			lnkRespond.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON THE 'Respond' LINK"
					+ "\nMETHOD:clickRespond \n" + e.getLocalizedMessage());
		}

		return new ThreadRespondPage(uiDriver);
	}

	/**
	 * Method helps to sort the topic by Author
	 * 
	 * @author ganapati.bhat
	 * @throws Exception
	 * @return ThreadHomePage
	 */
	public ThreadHomePage sortAuthorLink() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON 'Sort By Author link'  ");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkSortByAuthor, waitTime);
			if (lnkSortByAuthor.isDisplayedAfterWaiting())
				lnkSortByAuthor.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'Sort By Author link'"
					+ "\nMETHOD:sortAuthorLink \n" + e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * Method helps to check for sorting icon
	 * 
	 * @author ganapati.bhat
	 * @throws Exception
	 * @return boolean
	 */
	public boolean checkForSortingIcon() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING THE AUTHOR 'Sorting Icon'");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(imgSortByAuthor, waitTime);
			flag = imgSortByAuthor.isDisplayedAfterWaiting();
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING AUTHOR 'Sorting Icon' "
					+ "\nMETHOD:checkForSortingIcon \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to click on the expand all link
	 * 
	 * @author ganapati.bhat
	 * @return ThreadHomePage
	 * @throws Exception
	 */
	public ThreadHomePage clickExpandAll() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE 'Expand All' LINK");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkExpandAll, waitTime);
			if (lnkExpandAll.isDisplayedAfterWaiting())
				lnkExpandAll.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: 'Expand All' IS CLICKED ");
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON THE 'Expand All' LINK"
					+ "\nMETHOD:clickExpandAll \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to select the required response
	 * 
	 * @author ganapati.bhat
	 * @param strResponseTitle
	 * @return ThreadHomePage
	 * @throws Exception
	 */
	public ThreadHomePage selectResponse(String strResponseTitle)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECTING THE RESPONSE '"
					+ strResponseTitle + "'");
			frameSwitch.switchToFrameContent();
			lnkresponseName.replaceValues(strResponseTitle);
			uiDriver.waitToBeDisplayed(lnkresponseName, waitTime);
			if (lnkresponseName.isDisplayedAfterWaiting()) {
				lnkresponseName.clickAndWait(waitTime);
				logInstruction("LOG INSTRUCTION: RESPONSE '" + strResponseTitle
						+ "' IS SELECTED");
			} else {
				logInstruction("LOG INSTRUCTION: RESPONSE '" + strResponseTitle
						+ "' IS NOT SELECTED");
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN SELECTING RESPONSE '"
					+ strResponseTitle + "' \nMETHOD:selectResponse \n"
					+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * Method helps to check whether the Gradebook icon displayed
	 * 
	 * @author ganapati.bhat
	 * @param strStudentResponseTitle
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isGradeIconExists(String strStudentResponseTitle)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECK FOR GRADE ICON EXIST FOR '"
					+ strStudentResponseTitle + "'");
			frameSwitch.switchToFrameContent();
			imgGradeIcon.replaceValues(strStudentResponseTitle);
			uiDriver.waitToBeDisplayed(imgGradeIcon, waitTime);
			flag = imgGradeIcon.isDisplayedAfterWaiting();
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING GRADE ICON FOR '"
					+ strStudentResponseTitle
					+ "' \nMETHOD:isGradeIconExists \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to select the topic required
	 * 
	 * @author ganapati.bhat
	 * @param strTopicName
	 * @throws Exception
	 * @return ThreadHomePage
	 */
	public ThreadHomePage selectTopic(String strTopicName) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECT THE TOPIC '" + strTopicName
					+ "'");
			frameSwitch.switchToFrameContent();
			lnktopic.replaceValues(strTopicName);
			uiDriver.waitToBeDisplayed(lnktopic, waitTime);
			if (lnktopic.isDisplayedAfterWaiting()) {
				lnktopic.clickAndWait(waitTime);
				logInstruction("LOG INSTRUCTION: TOPIC '" + strTopicName
						+ "'IS SELECTED");
			} else {
				List<UIElement> tableHead = lstTableHeader.getUIElementsList();
				int totalHeader = tableHead.size();
				for (int i = 0; i < totalHeader; i++) {
					if (tableHead.get(i).getText().trim().equals(strTopicName)) {
						logInstruction("LOG INSTRUCTION: THE REQUIRED TOPIC '"
								+ strTopicName + "' IS ALREADY SELECTED");
						break;
					}
				}

			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN SELECTING THE TOPIC '" + strTopicName
					+ "' \n METHOD:selectTopic \n" + e.getLocalizedMessage());
		}

		return this;

	}

	/**
	 * Method helps to click on the Gradebook icon button
	 * 
	 * @author ganapati.bhat
	 * @param strStudentResponseTitle
	 * @return GradebookDetailsUIPage
	 * @throws Exception
	 */
	public GradebookDetailsUIPage clickGradeIcon(String strStudentResponseTitle)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE 'Grade Icon' FOR '"
					+ strStudentResponseTitle + "'");
			frameSwitch.switchToFrameContent();
			imgGradeIcon.replaceValues(strStudentResponseTitle);
			flag = isGradeIconExists(strStudentResponseTitle);
			if (flag) {
				imgGradeIcon.clickAndWait(waitTime);
				logInstruction("LOG INSTRUCTION: 'Grade Icon' IS CLICKED FOR '"
						+ strStudentResponseTitle + "'");
			} else {
				logInstruction("LOG INSTRUCTION: 'Grade Icon' IS NOT DISPLAYED  FOR '"
						+ strStudentResponseTitle + "'");
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON 'Grade Icon' FOR '"
					+ strStudentResponseTitle + "' \n METHOD:clickGradeIcon \n"
					+ e.getLocalizedMessage());
		}
		return new GradebookDetailsUIPage(uiDriver);
	}

	/**
	 * Method helps to verify the Thread Title method return true if title
	 * contains the provided thread name
	 * 
	 * @param strThreadName
	 * @author ganapati.bhat
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyThreadTitle(String strThreadName) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY THE THREAD TITLE FOR THREAD '"
					+ strThreadName + "'");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblThreadTitle, waitTime);
			if (lblThreadTitle.getText().contains(strThreadName)) {
				logInstruction("LOG INSTRUCTION: THE TITLE CONTAINS THREAD NAME '"
						+ strThreadName + "'");
				flag = true;
			} else {
				logInstruction("LOG INSTRUCTION: THE TITLE DOES NOT CONTAINS THREAD NAME '"
						+ strThreadName + "'");
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THREAD TITLE FOR THREAD '"
					+ strThreadName + "' \n METHOD:verifyThreadTitle \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to scroll down to the end of page
	 * 
	 * @author ganapati.bhat
	 * @return ThreadHomePage
	 * @throws Exception
	 */
	public ThreadHomePage scrollDown() throws Exception {
		logInstruction("LOG INSTRUCTION: SCROLL DOWN TO THE END OF THE PAGE");
		for (int sec = 0;; sec++) {
			if (sec >= 60) {
				break;
			}
			uiDriver.executeScript("window.scrollBy(0,200)", "");
			try {
				uiDriver.wait(1000);
			} catch (InterruptedException e) {
				throw new Exception("ISSUE IN PAGE SCROLL DOWN"
						+ "\n METHOD:scrollDown \n" + e.getLocalizedMessage());
			}
		}
		return this;
	}

	/**
	 * Method is clicking on the edit link
	 * 
	 * @param strTopicName
	 * @throws Exception
	 * @return EditTopicPage
	 */
	public EditTopicPage clickOnEditLink(String strTopicName) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE 'edit' LINK");
			frameSwitch.switchToFrameContent();
			lnkEdit.replaceValues(strTopicName);
			uiDriver.waitToBeDisplayed(lnkEdit, waitTime);
			if (lnkEdit.isDisplayedAfterWaiting()) {
				lnkEdit.clickAndWait(waitTime);
			} else {
				List<UIElement> tableHead = lstTableHeader.getUIElementsList();
				int totalHeader = tableHead.size();
				for (int i = 0; i < totalHeader; i++) {
					if (tableHead.get(i).getText().trim().equals(strTopicName)) {
						logInstruction("LOG INSTRUCTION: THE REQUIRED TOPIC '"
								+ strTopicName + "' IS ALREADY SELECTED");
						uiDriver.waitToBeDisplayed(lnkFirstEdit, waitTime);
						lnkFirstEdit.clickAndWait(waitTime);
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON 'edit' LINK"
					+ "\n METHOD:clickOnEditLink \n" + e.getLocalizedMessage());
		}
		return new EditTopicPage(uiDriver);
	}

	/**
	 * Method is used to check provided text is present in the page after
	 * clicking go link from courseList page
	 * 
	 * @param strText
	 * @author ashish.juyal
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifytextinThreadHomePage(String strText) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING THE TEXT '" + strText
					+ "'");
			if (uiDriver.getPageSource().contains(strText)) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERYING THE TEXT '" + strText
					+ ", \n METHOD:verifytextinThreadHomePage \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This methods help to click on delete button for topic
	 * 
	 * @param strTopicName
	 * @author hemant.kumar
	 * @return ThreadHomePage
	 * @throws Exception
	 */
	public ThreadHomePage clickOnDeleteTopic(String strTopicName)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON THE 'Delete Topic' IMAGE");
			frameSwitch.switchToFrameContent();
			imgClickOnDelete.replaceValues(strTopicName);
			uiDriver.waitToBeDisplayed(imgClickOnDelete, waitTime);
			imgClickOnDelete.isDisplayedAfterWaiting();
			imgClickOnDelete.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: 'Delete Topic' IS CLICKED");
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'Delete Topic' IMAGE"
					+ "\n METHOD:clickOnDeleteTopic \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to select the I agree check box for delete topic on content
	 * tab
	 * 
	 * @author hemant.kumar
	 * @return ThreadHomePage
	 * @throws Exception
	 */
	public ThreadHomePage selectIAgreeCheckBox() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELCTING 'I Agree' CHECK BOX");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(chkIAgreeBox, 1500);
			chkIAgreeBox.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN SELCTING 'I Agree' CHECKBOX"
					+ "\n METHOD:selectIAgreeCheckBox \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to click on the Delete content and responses button
	 * 
	 * @author hemant.kumar
	 * @return NextCourseHomePage
	 * @throws Exception
	 */
	public NextCourseHomePage clickDeleteContentAndResponsesButton()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: 'Delete Content And Responses' BUTTON IS CLICKED");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(chkdeletetopicresponse, waitTime);
			chkdeletetopicresponse.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING 'Delete Content And Response' Button"
							+ "\n METHOD:clickDeleteContentAndResponsesButton \n"
							+ e.getLocalizedMessage());
		}
		return new NextCourseHomePage(uiDriver);
	}

	/**
	 * Method helps to click on the cancel button
	 * 
	 * @author hemant.kumar
	 * @return NextCourseHomePage
	 * @throws Exception
	 */
	public NextCourseHomePage clickCancelButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON 'Cancel'");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(chkdeletecancel, waitTime);
			chkdeletecancel.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'Cancel'"
					+ "\n METHOD:clickCancelButton \n"
					+ e.getLocalizedMessage());
		}
		return new NextCourseHomePage(uiDriver);
	}

	/**
	 * This methods help to click on edit button for topic
	 * 
	 * @param strTopicName
	 * @author hemant.kumar
	 * @return EditTopicPage
	 * @throws Exception
	 * 
	 */
	public EditTopicPage clickOnEditTopic(String strTopicName) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE 'Edit Topic'");
			frameSwitch.switchToFrameContent();
			imgClickOnEdit.replaceValues(strTopicName);
			uiDriver.waitToBeDisplayed(imgClickOnEdit, waitTime);
			imgClickOnEdit.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: 'Edit Topic' BUTTON IS CLICKED");
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'Edit Topic' IMAGE"
					+ "\n METHOD:clickOnEditTopic \n" + e.getLocalizedMessage());
		}
		return new EditTopicPage(uiDriver);
	}

	/**
	 * This methods help to click on TopicCollapse button
	 * 
	 * @param strTopicName
	 * @author hemant.kumar
	 * @return ThreadHomePage
	 * @throws Exception
	 */
	public ThreadHomePage clickTopicExpandCollapse(String strTopicName)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON 'Topic ExapandCollapse' LINK");
			frameSwitch.switchToFrameContent();
			lnkTopicExpandCollapse.replaceValues(strTopicName);
			uiDriver.waitToBeDisplayed(lnkTopicExpandCollapse, waitTime);
			lnkTopicExpandCollapse.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING 'Topic ExapandCollapse' LINK"
							+ "\n METHOD:clickTopicExpandCollapse \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to verify Add response is present or not
	 * 
	 * @param strTitle
	 * @author kiran.kumar
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAddRespondForResponsesPresent(String strTitle)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING IS 'Add Respond' PRESENT");
			lnkrespond.replaceValues(strTitle);
			uiDriver.waitToBePresent(lnkrespond, waitTime);
			if (lnkrespond.isEnabled()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING 'Add Respond' FOR RESPONSE PRESENT"
							+ "\n METHOD:isAddRespondForResponsesPresent \n"
							+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify edit response present or not
	 * 
	 * @param strTitle
	 * @author kiran.kumar
	 * @return boolean
	 * @throws Exception
	 */
	public boolean iseditRespondForResponsesPresent(String strTitle)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING IS 'Edit Respond' PRESENT");
			lnkEditLink.replaceValues(strTitle);
			uiDriver.waitToBePresent(lnkEditLink, waitTime);
			if (lnkEditLink.isEnabled()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING 'Edit Respond' FOR RESPONSE PRESENT"
							+ "\n METHOD:iseditRespondForResponsesPresent \n"
							+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify delete is present or not
	 * 
	 * @param strTitle
	 * @author kiran.kumar
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isDeleteRespondForResponsesPresent(String strTitle)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING IS 'Delete Respond' PRESENT");
			lnkDeleteLink.replaceValues(strTitle);
			uiDriver.waitToBePresent(lnkDeleteLink, waitTime);
			if (lnkDeleteLink.isEnabled()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING 'Delete Respond' FOR RESPONSE PRESENT"
							+ "\n METHOD:isDeleteRespondForResponsesPresent \n"
							+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to click on 'AddRespond' link
	 * 
	 * @param strTitle
	 * @author kiran.kumar
	 * @return ThreadHomePage
	 * @throws Exception
	 */
	public ThreadHomePage clickAddRespondForResponses(String strTitle)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON  'AddRespond' FOR RESPONSE");
			frameSwitch.switchToFrameContent();
			lnkrespond.replaceValues(strTitle);
			uiDriver.waitToBePresent(lnkrespond, waitTime);
			lnkrespond.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING ON 'AddRespond' FOR RESPONSE"
							+ "\n METHOD:clickAddRespondForResponses \n"
							+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * Method helps to click edit respond link
	 * 
	 * @param strTitle
	 * @author kiran.kumar
	 * @return ThreadHomePage
	 * @throws Exception
	 */
	public ThreadHomePage clickEditRespondForResponses(String strTitle)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING  'edit' RESPONSE PRESENT");
			frameSwitch.switchToFrameContent();
			lnkEditLink.replaceValues(strTitle);
			uiDriver.waitToBePresent(lnkEditLink, waitTime);
			lnkEditLink.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON 'edit' FOR RESPONSE"
					+ "\n METHOD:clickEditRespondForResponses \n"
					+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * Method helps to click delete link
	 * 
	 * @param strTitle
	 * @author kiran.kumar
	 * @return ThreadHomePage
	 * @throws Exception
	 */
	public ThreadHomePage clickDeleteRespondForResponses(String strTitle)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING IS 'delete' FOR RESPONSE PRESENT");
			frameSwitch.switchToFrameContent();
			lnkDeleteLink.replaceValues(strTitle);
			uiDriver.waitToBePresent(lnkDeleteLink, waitTime);
			lnkDeleteLink.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON 'Delete' FOR RESPONSE"
					+ "\n METHOD:clickDeleteRespondForResponses \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to click on print view
	 * 
	 * @author Raghav
	 * @return ThreadHomePage
	 * @throws Exception
	 **/
	public ThreadHomePage clickPrintView() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON 'Print View'");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkClickPrintView, waitTime);
			if (lnkClickPrintView.isDisplayedAfterWaiting())
				lnkClickPrintView.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON 'Print View' LINK"
					+ "\n METHOD: clickPrintView\n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to check response present or not
	 * 
	 * @param strResponse
	 * @author Raghav
	 * @return boolean
	 * @throws Exception
	 **/
	public boolean isResponsePresentInPrintView(String strResponse)
			throws Exception {
		flag = false;
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING IS 'Response' PRESENT IN PRINT VIEW");
			strResult = lblVerifyResponseprint.getText().trim();
			if (strResult.equalsIgnoreCase(strResponse)) {
				logInstruction("LOG INSTRUCTION: VERIFIED THE 'Response'");
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE LABEL 'Response'"
					+ "\n METHOD: isResponsePresentInPrintView \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to click on Save button
	 * 
	 * @author Raghav
	 * @return ThreadHomePage
	 * @throws Exception
	 **/
	public ThreadHomePage clickOnSave() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE 'Save Topic'");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnClicksave, waitTime);
			btnClicksave.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: 'Save' IS CLICKED");
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON 'Save' BUTTON"
					+ "\n METHOD:clickOnSave \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to click on delete respond thread
	 * 
	 * @author kiran.Kumar
	 * @return ThreadHomePage
	 * @throws Exception
	 **/
	public ThreadHomePage clickPermanentDelete() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON 'Delete' BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnPermanentdelete, waitTime);
			btnPermanentdelete.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON 'Delete' BUTTON"
					+ "\n METHOD:clickPermanentDelete \n"
					+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * Method helps to click on email to author link
	 * 
	 * @author suchi.singh
	 * @param String
	 *            strResponseTitle
	 * @return EmailResponsePage
	 * @throws Exception
	 **/
	public EmailResponsePage clickEmailIconLink(String strResponseTitle)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:CLICK ON 'email' TO AUTHOR LINK");
			frameSwitch.switchToFrameContent();
			lnkClickEmailIcon.replaceValues(strResponseTitle);
			uiDriver.waitToBeDisplayed(lnkClickEmailIcon, waitTime);
			lnkClickEmailIcon.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON 'email' LINK"
					+ "\n METHOD:clickEmailIconLink \n"
					+ e.getLocalizedMessage());
		}
		return new EmailResponsePage(uiDriver);

	}

	/**
	 * Method helps to click on edit.
	 * 
	 * @return EditIntroductoryText
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public EditIntroductoryText clickEditLink() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:CLICK ON THE 'edit' LINK");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkEditlink, waitTime);
			lnkEditlink.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON 'edit' LINK"
					+ "\n METHOD:clickEditLink \n" + e.getLocalizedMessage());
		}
		return new EditIntroductoryText(uiDriver);
	}

	/**
	 * methods helps to click on document icon of attached file
	 * 
	 * @author Chaitali.Barhate
	 * @param String
	 * @param String
	 * @return void
	 * @throws Exception
	 * @category Milestone 2
	 */
	public void clickDocumentIcon(String strSubjectTitle, String strFileName)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION : CLICKING ON DOCUMENT ICON OF FILE '"
					+ strFileName + "'");
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strSubjectTitle)
					&& StringUtils.isNotBlank(strFileName)) {
				imgIconDocument.replaceValues(strSubjectTitle, strFileName);
				if (imgIconDocument.isDisplayedAfterWaiting(waitTime)) {
					imgIconDocument.clickAndWait(waitTime);
				} else
					logInstruction("LOG INSTRUCTION : DOCUMENT ICON NOT DISPLAYED FOR FILE '"
							+ strFileName + "'");
			} else {
				throw new Exception(
						"ISSUE IN CLICKING ON DOCUMENT ICON,EITHER SUBJET TITLE OR FILENAME IS NULL \nMETHOD:clickDocumentIcon \n");
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON DOCUMENT ICON FOR FILE '"
					+ strFileName + "' \n METHOD:clickDocumentIcon \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * Methods helps to get name of attached file for provided subject title
	 * 
	 * @author Chaitali.Barhate
	 * @return String
	 * @param String
	 *            -strSubjectTitle
	 * @throws Exception
	 * @category Milestone 2
	 */
	public String getFileName(String strSubjectTitle) throws Exception {
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION : GETTING ATTACHED FILE NAME FOR '"
					+ strSubjectTitle + "'");
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strSubjectTitle)) {
				lblAttachedFileName.replaceValues(strSubjectTitle);
				if (lblAttachedFileName.isDisplayedAfterWaiting(waitTime)) {
					strResult = lblAttachedFileName.getText();
				} else
					logInstruction("LOG INSTRUCTION :ATTACHED FILE NOT FOUND FOR STUDENT..");
			} else {
				throw new Exception(
						"ISSUE IN GETTING ATTACHED FILE NAME, PROVIDED SUBJET TITLE IS NULL \nMETHOD:getFileName \n");
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING ATTACHED FILE NAME"
					+ "\n METHOD:getFileName \n" + e.getLocalizedMessage());
		}
		return strResult;
	}

	/**
	 * methods helps to click on attached file
	 * 
	 * @author Chaitali.Barhate
	 * @return void
	 * @throws Exception
	 * @param String
	 *            -strSubjectTitle , strFileName
	 * @category Milestone 2
	 */
	public void clickAttachedFile(String strSubjectTitle, String strFileName)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION : CLICKING ON ATTACHED FILE '"
					+ strFileName + "'");
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strSubjectTitle)
					&& StringUtils.isNotBlank(strFileName)) {
				lnkClickAttachedFile
						.replaceValues(strSubjectTitle, strFileName);
				if (lnkClickAttachedFile.isDisplayedAfterWaiting(waitTime)) {
					if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
						lnkClickAttachedFile.clickByJavascript();
						Thread.sleep(waitTime); // Since clickAndWait() is
												// hanging, performing the
					} else {
						lnkClickAttachedFile.clickAndWait(waitTime);
					}
				} else
					logInstruction("LOG INSTRUCTION :ATTACHED FILE '"
							+ strFileName + "' NOT DISPLAYED...");
			} else {
				throw new Exception(
						"ISSUE IN CLICKING ON  ATTACHED FILE, EITHER SUBJET TITLE OR FILENAME IS NULL \n METHOD:clickAttachedFile \n");
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON  ATTACHED FILE '"
					+ strFileName + "' FOR SUBJECT TITLE '" + strSubjectTitle
					+ "'" + "\n METHOD:clickAttachedFile \n"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * methods helps to verify that thread home page is displayed or not.
	 * 
	 * @author Vivek.Singh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isToolBoxDispalyed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR 'ToolBox' TAB.");
			frameSwitch.switchToFrameContent();
			flag = mnuToolBox.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING 'ToolBox' TAB IS EXIST OR NOT"
							+ "\n METHOD:isToolBoxDispalyed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to check whether the topic exists
	 * 
	 * @author Sumanth SV
	 * @category Milestone-2
	 * @param strTopicTitle
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean isTopicExists(String strTopicTitle) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECK FOR EXISTANCE OF TOPIC '"
					+ strTopicTitle + "'");
			frameSwitch.switchToFrameContent();
			lnktopic.replaceValues(strTopicTitle);
			flag = lnktopic.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING TOPIC '" + strTopicTitle
					+ "' IS EXIST OR NOT" + "\n METHOD:isTopicExists \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to check whether the added topic exists
	 * 
	 * @author Sumanth SV
	 * @category Milestone-2
	 * @param strTopicTitle
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean isAddedTopicExists(String strTopicTitle) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECK FOR EXISTANCE OF TOPIC '"
					+ strTopicTitle + "'");
			frameSwitch.switchToFrameContent();
			lnkAddedtopic.replaceValues(strTopicTitle);
			flag = lnkAddedtopic.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING ADDED TOPIC '"
					+ strTopicTitle + "' IS EXIST OR NOT"
					+ "\n METHOD:isAddedTopicExists \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * methods helps to click on attached file under the selected Topic
	 * 
	 * @author Sumanth SV
	 * @category Milestone-2
	 * @param String
	 * @return void
	 * @throws Exception
	 */
	public void clickAttachedFileTopic(String fileName) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION : CLICKING ON ATTACHED FILE '"
					+ fileName + "'");
			frameSwitch.switchToFrameContent();
			lnkTopicAttachment.replaceValues(fileName);
			if (lnkTopicAttachment.isDisplayedAfterWaiting(waitTime)) {

				if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
					lnkTopicAttachment.clickByJavascript();
					Thread.sleep(waitTime); // Since clickAndWait() is hanging,
											// performing the same
				} else {
					lnkTopicAttachment.clickAndWait(waitTime);
				}

				logInstruction("LOG INSTRUCTION : SUCCESSFULLY CLICKED ON ATTACHED FILE"
						+ fileName);
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON  ATTACHED FILE '"
					+ fileName + "' UNDER SELECTED TOPIC"
					+ "\n METHOD:clickAttachedFileTopic \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * Methods helps to get page title from Text threaded page
	 * 
	 * @author amit.deshmukh
	 * @category Milestone2
	 * @return String
	 * @throws Exception
	 */
	public String getPageTitle() throws Exception {
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING 'Page Title'");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblpagetitle, waitTime);
			strResult = lblpagetitle.getText().trim();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN GETTING 'page title' FROM TEXT THREADED PAGE"
							+ "\n METHOD:getPageTitle \n"
							+ e.getLocalizedMessage());
		}
		return strResult;
	}

	/**
	 * Methods helps to get header title from Text Threaded page
	 * 
	 * @author amit.deshmukh
	 * @category Milestone2
	 * @return String
	 * @throws Exception
	 */
	public String getHeaderTitle() throws Exception {
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING 'Header Title'");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblheader, waitTime);
			strResult = lblheader.getText().trim();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN GETTING 'header title' FROM TEXT THREADED PAGE"
							+ "\n METHOD:getHeaderTitle \n"
							+ e.getLocalizedMessage());
		}
		return strResult;
	}

	/**
	 * Method helps to verify ToolBox tab
	 * 
	 * @author amit.deshmukh
	 * @category Milestone2
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isToolBoxPresent() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING 'ToolBox' IS PRESENT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(mnuToolBox, waitTime);
			flag = mnuToolBox.isDisplayedAfterWaiting();
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING 'ToolBox' MENU "
					+ "\n METHOD:isToolBoxPresent \n" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify Alternative Editor Present or not..
	 * 
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author suchi.singh
	 */
	public boolean isEditorSwitchDisplayed() throws Exception {
		flag = false;
		logInstruction("LOG INSTRUCTION: ALTERNATIVE EDITOR PRESENT OR NOT...");
		try {
			flag = lnkEditorSwitch.isDisplayedAfterWaiting(waitTime);
			logInstruction("LOG INSTRUCTION: VERIFYING ALTERNATIVE EDITOR PRESENT");
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING ALTERNATIVE EDITOR SWITCH OPTION."
							+ "\n METHOD : isEditorSwitchDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify thread home page is displayed or not.
	 * 
	 * @author bharat.goel
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isContentTabExists() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR 'Content' TAB.");
			frameSwitch.switchToFrameContent();
			flag = mnuContent.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING 'Content' TAB IS EXIST OR NOT"
							+ "\n METHOD:isContentTabExists \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
}
