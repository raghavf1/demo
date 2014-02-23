package com.pearson.eselenium.ls.contentitems.exams.pages;

import java.util.ArrayList;
import java.util.List;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all the methods related to Exam Create page
 * 
 * @author monica.anand
 * 
 */

public class ExamHomePage extends BasePageObject {

	/* Elements */
	private UIElement btnAdd = createElement(UIType.Name, "addquestion");
	private UIElement btnClickToolbox = createElement(UIType.LinkText,
			"Toolbox");
	private UIElement btnBegin = createElement(UIType.Css, ".buttontd");
	private UIElement btnBeginNow = createElement(UIType.Css, ".buttontd");
	private UIElement btnSaveAnswer = createElement(UIType.Css,
			"#btnSaveAnswers2");
	private UIElement btnSubmitForGrading = createElement(UIType.Css,
			"#btnSubmitForGrade2");
	private UIElement chkAnswer = createElement(UIType.Css, "#{1}{2}{3}");
	private UIElement txtExamCompleteTableText = createElement(UIType.Css,
			".dkgraytext");
	private UIElement drpQuestionAvail = createElement(UIType.Xpath,
			"//select[@name='ItemType']");
	private UIElement areaVisualDisplayed = createElement(UIType.Xpath,
			"//body");
	private UIElement btnClickpreview = createElement(UIType.Css,
			"a[onclick='javascript:preview_exam(); return false;']");
	private UIElement btnClicktoolbox = createElement(UIType.Css,
			"a[href*='/Main/ExamBuilder/exbtoolbox.ed?']");
	private UIElement lblPageHeader = createElement(UIType.Css,
			"div[class='pageTitle']");
	private UIElement imgExpandQuestion = createElement(UIType.Xpath,
			"//td[contains(text(),'{1}')]/preceding-sibling::td[3]/a/img");
	private UIElement areaTruefalseresponse1 = createElement(UIType.Xpath,
			"//tbody/tr/td[4]/input");
	private UIElement areaTruefalseresponse2 = createElement(UIType.Xpath,
			"//tbody/tr/td[8]/input");
	private UIElement lnkEdit = createElement(UIType.Xpath,
			"//table[1]/tbody/tr/td[2]/a/strong");
	private UIElement lnkaddNewPage = createElement(UIType.Xpath,
			"//table[2]/tbody/tr/td[3]/a[2]/strong");
	private UIElement lnkPageNo = createElement(UIType.Xpath,
			"//strong[contains(text(),'{1}')]");
	private UIElement lnkEditPage = createElement(UIType.Xpath,
			"//table[2]/tbody/tr/td[4]/a[1]/strong[contains(text(),'Edit Page')]");
	private UIElement lnkDeletePage = createElement(UIType.Xpath,
			"//table[2]/tbody/tr/td[4]/a[2]/strong[contains(text(),'Delete Page')]");
	private UIElement lnkclickEditLinkOfQuestion = createElement(
			UIType.Xpath,
			"//tbody[tr[td[contains(text(),'{1}')]]]//tr//td//a[strong[contains(text(),'Edit')]]");
	private UIElement lblExamQuestionType = createElement(UIType.Xpath,
			"//tbody/tr[td[contains(text(),'{1}')]]/td[2]/nobr/strong");

	private SelectQuestionType selectedType;
	private String selectedQuestionTypeCode;
	private String ShortAnswerRadToolId = "radEntryText";
	private String ShortAnswerRadFrameId = "radEntryText_contentIframe";
	private VisualEditor ShortAnswerRad = new VisualEditor(uiDriver,
			ShortAnswerRadToolId, ShortAnswerRadFrameId,ShortAnswerRadToolId);
	private String EssayRadToolId = "radEntryText";
	private String EssayRadFrameId = "radEntryText_contentIframe";
	private VisualEditor EssayRad = new VisualEditor(uiDriver,
			EssayRadToolId, EssayRadFrameId,EssayRadToolId);
	/* Constructor */
	public ExamHomePage(UIDriver driver) {
		super(driver);
		logInstruction("LOG INSTRUCTION: ## Exam Home Page ##");
	}
	public VisualEditor getShortAnswerRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return ShortAnswerRad;
	}
	public VisualEditor getEssayRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return EssayRad;
	}
	public enum SelectQuestionType {
		TRUE_FALSE_QUESTION("New True/False Question", "TF"), MULTIPLE_CHOICE_QUESTION(
				"New Multiple-Choice Question", "MC"), MATCHING_TYPE_QUESTION(
				"New Matching Question", "MT"), FILL_IN_THE_BLANK_QUESTION(
				"New Fill-The-Blank Question", "FB"), MULTIPLE_ANSWER_QUESTION(
				"New Multiple-Answer Question", "MMC"), SHORT_ANSWER_QUESTION(
				"New Short Answer Question", "SA"), ESSAY_QUESTION(
				"New Essay Question", "EQ"), QUESTION_POOL("Question Pool",
				"POOL"), UPLOAD_QUESTION("Upload Questions", "UPLOAD");

		private String question;
		private String code;

		private SelectQuestionType(String name, String code) {
			question = name;
			this.code = code;
		}

		public String getQuestionValue() {
			return question;
		}

		public String getCodeValue() {
			return code;
		}

		public SelectQuestionType getName(String code) {
			for (SelectQuestionType type : SelectQuestionType.values()) {
				if (type.getCodeValue().equals(code)) {
					return type;
				}
			}
			return null;
		}
	}

	/**
	 * This method is used to click the add button on ExamsCreatePage
	 * 
	 * @author monica.anand
	 * @retun Object
	 * @throws Exception
	 */
	public Object clickAddButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON ADD BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnAdd, waitTime);
			btnAdd.clickNoWait();
			switch (selectedType) {
			case TRUE_FALSE_QUESTION:
				return new AddTrueFalseQuestionPage(uiDriver);
			case MULTIPLE_CHOICE_QUESTION:
				return new AddMultipleChoiceQuestionPage(uiDriver);
			case MATCHING_TYPE_QUESTION:
				return new AddMatchingQuestionPage(uiDriver);
			case FILL_IN_THE_BLANK_QUESTION:
				return new AddFillInTheBlankQuestionPage(uiDriver);
			case MULTIPLE_ANSWER_QUESTION:
				return new AddMultipleAnswerQuestionPage(uiDriver);
			case SHORT_ANSWER_QUESTION:
				return new AddShortAnswerQuestionPage(uiDriver);
			case ESSAY_QUESTION:
				return new AddEssayQuestionPage(uiDriver);
			case QUESTION_POOL:
				return null;
			case UPLOAD_QUESTION:
				return null;
			default:
				return null;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Add' BUTTON"
					+ "\n METHOD : clickAddButton \n" + e.getLocalizedMessage());
		}

	}

	/**
	 * This method is click on tool box
	 * 
	 * @author kiran kumar
	 * @return ExamToolboxPage
	 * @throws Exception
	 */

	public ExamToolboxPage clicktoolbox() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON TOOLBOX BUTTON");
			frameSwitch.switchToFrameContent();
			btnClickToolbox.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'ToolBox' BUTTON"
					+ "\n METHOD : clicktoolbox \n" + e.getLocalizedMessage());
		}
		return new ExamToolboxPage(uiDriver);
	}

	/**
	 * This method will click the Begin button on the first page of Exam to be
	 * taken.
	 * 
	 * @author Vivek.Singh
	 * @return ExamHomePage
	 * @throws Exception
	 * **/
	public ExamHomePage clickBeginButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON BEGIN BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnBegin, waitTime);
			btnBegin.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED BEGIN BUTTON.");
			return this;
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Begin' BUTTON"
					+ "\n METHOD : clickBeginButton \n"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method will click the Begin Now button on the second page of Exam to
	 * be taken.
	 * 
	 * @author Vivek.Singh
	 * @return ExamHomePage
	 * @throws Exception
	 * **/
	public ExamHomePage clickBeginNowButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON BEGIN NOW BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnBeginNow, waitTime);
			btnBeginNow.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED BEGIN NOW BUTTON.");
			return this;
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Begin Now' BUTTON"
					+ "\n METHOD : clickBeginNowButton \n"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method will click the Save Answers Button on Exam page.
	 * 
	 * @author Vivek.Singh
	 * @return ExamHomePage
	 * @throws Exception
	 * **/
	public ExamHomePage clickSaveAnswersButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON SAVE ANSWER BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnSaveAnswer, waitTime);
			btnSaveAnswer.clickNoWait();
			uiDriver.switchTo().alert().accept();
			logInstruction("Clicked on Save Answers Button.");
			return this;
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Save Answer' BUTTON"
					+ "\n METHOD : clickSaveAnswersButton \n"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method will click the Submit for Grading Button on Exam page.
	 * 
	 * @author Vivek.Singh
	 * @return ExamHomePage
	 * @throws Exception
	 * **/
	public ExamHomePage clickSubmitForGradingButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON SUBMIT FOR GRADING BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnSubmitForGrading, waitTime);
			btnSubmitForGrading.clickNoWait();
			uiDriver.switchTo().alert().accept();
			logInstruction("Clicked on Submit for grading button.");
			return this;
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING THE 'Submit For Grading' BUTTON"
							+ "\n METHOD : clickSubmitForGradingButton \n"
							+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method will select answer to the true false type. provide the
	 * following Strings for respective question type. Truefalse for True/False
	 * MultipleChoice for Multiple Choice ManyMultipleChoice for Many Multiple
	 * Choice.
	 * 
	 * @param String
	 *            questionType, String questionNumber, String option
	 * @return {@link ExamHomePage}
	 * @throws Exception
	 **/
	public ExamHomePage selectAnswer(String questionType,
			String questionNumber, String option) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECTING ANSWER. ");
			frameSwitch.switchToFrameContent();

			// This will check for the type question.
			if (questionType.equalsIgnoreCase("Truefalse")
					|| questionType.equalsIgnoreCase("ManyMultipleChoice"))
				option = "_" + option;
			else if (questionType.equalsIgnoreCase("MultipleChoice"))
				option = "_0_" + option;

			// This will put the questiontype, questionNumber and option in to
			// the css selector of
			// chkTruefalse.
			chkAnswer.replaceValues(questionType, questionNumber, option);

			uiDriver.waitToBeDisplayed(chkAnswer, waitTime);
			chkAnswer.clickNoWait();
			logInstruction("Selected Answer.");
			return this;
		} catch (Exception e) {
			throw new Exception("ISSUE IN SELECTING ANSWER."
					+ "\n METHOD : selectAnswer \n" + e.getLocalizedMessage());
		}
	}

	/**
	 * method will get the table text from the exam completed page
	 * 
	 * @author Praveen.Maled
	 * @param String
	 *            verifyString
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isExamCompletedPageDisplayed(String verifyString)
			throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING EXAM IS COMPLETED OR NOT. ");
			verifyString = verifyString.toLowerCase();
			logInstruction("get exam complete page table text");
			uiDriver.waitToBeDisplayed(txtExamCompleteTableText);
			if (txtExamCompleteTableText.isDisplayedAfterWaiting(waitTime)) {
				flag = txtExamCompleteTableText.getText().toLowerCase()
						.contains(verifyString);
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING EXAM IS COMPLETED OR NOT."
					+ "\n METHOD : isExamCompletedPageDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method will check whether a particular type of question is present
	 * in question drpDown
	 * 
	 * @param question
	 *            Type of Question
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isQuestionPresent(String question) throws Exception {
		List<String> option = new ArrayList<String>();
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING QUESTION IS AVAILABLE OR NOT.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(drpQuestionAvail, waitTime);
			option = drpQuestionAvail.getSelectedOptions();
			if (option.contains(question))
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CHECKING QUESTION IS AVAILABLE OR NOT."
							+ "\n METHOD : isQuestionPresent \n"
							+ e.getLocalizedMessage());

		}
		return flag;
	}

	/**
	 * this method will check whether RAD is Displayed or not
	 * 
	 * @return {@link Boolean}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isVisualEditorDisplayed() throws Exception {

		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING VISUAL EDITOR IS AVAILABLE OR NOT.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(areaVisualDisplayed, waitTime);
			if (areaVisualDisplayed.isDisplayedAfterWaiting(waitTime))
				flag = true;
			else
				flag = false;

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CHECKING VISUAL EDITOR IS AVAILABLE OR NOT."
							+ "\n METHOD : isVisualEditorDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * this method will click on preview button
	 * 
	 * @return {@link ExamManagerPage}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public ExamManagerPage clickPreviewExambutton() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON PREVIEW EXAM BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnClickpreview, waitTime);
			btnClickpreview.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Preview Exam' BUTTON"
					+ "\n METHOD : clickPreviewExambutton \n"
					+ e.getLocalizedMessage());
		}
		return new ExamManagerPage(uiDriver);
	}

	/**
	 * this method will click on Tool box button
	 * 
	 * @return {@link ExamToolboxPage}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public ExamToolboxPage clickToolBox() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON TOOLBOX BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnClicktoolbox, waitTime);
			btnClicktoolbox.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'ToolBox' BUTTON"
					+ "\n METHOD : clickToolBox \n" + e.getLocalizedMessage());
		}
		return new ExamToolboxPage(uiDriver);
	}

	/**
	 * this method will Select Question from DrpDown
	 * 
	 * @param SelectQuestionType
	 *            questionType
	 * @return {@link ExamHomePage }
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public ExamHomePage selectQuestion(SelectQuestionType questionType)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECTING QUESTION FROM DROPDOWN. ");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(drpQuestionAvail, waitTime);
			drpQuestionAvail.selectByVisibleText(questionType
					.getQuestionValue());
			selectedType = questionType;
		} catch (Exception e) {
			throw new Exception("ISSUE IN SELECTING QUESTION FROM DROPDOWN."
					+ "\n METHOD : selectQuestion \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method will clickAdd button
	 * 
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	/*
	 * public void clickAddBtn() throws Exception {
	 * 
	 * try { logInstruction("Clicking on ToolBox button ");
	 * frameSwitch.switchToFrameContent();
	 * uiDriver.waitToBeDisplayed(clickAddbtn, waitTime); clickAddbtn.click(); }
	 * catch (Exception e) { 
		throw new Exception("NOT ABLE TO GET ADD BUTTON")+ "\n METHOD : clickAddBtn \n" + e.getLocalizedMessage(); }
	 * 
	 * }
	 */
	/**
	 * this method will give you the page Header
	 * 
	 * @return {@link String }
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public String getPageHeader() throws Exception {
		String data = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE PAGE HEADER.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblPageHeader, waitTime);
			data = lblPageHeader.getText().trim();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE PAGE HEADER."
					+ "\n METHOD : getPageHeader \n" + e.getLocalizedMessage());
		}
		return data;
	}

	/**
	 * this method will click on Expand icon related to question
	 * 
	 * @return {@link ExamHomePage }
	 * @param String
	 *            QuestionName name of the question which you want to expand
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public ExamHomePage expandQuestion(String QuestionName) throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: EXPANDING THE QUESTION.");
			imgExpandQuestion.replaceValues(QuestionName);
			uiDriver.waitToBeDisplayed(imgExpandQuestion, waitTime);
			imgExpandQuestion.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN EXPANDING THE QUESTION."
					+ "\n METHOD : expandQuestion \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This Method will check Whether Response in Form of True/False Radio
	 * Button is available Or not
	 * 
	 * @return {@link Boolean}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */

	public boolean isTrueFalseResponseDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING WHETHER TRUE / FALSE RESPONSE IS BEING DISPLAYED OR NOT.");
			frameSwitch.switchToFrameContent();
			if (areaTruefalseresponse1.isDisplayedAfterWaiting(waitTime)) {
				if (areaTruefalseresponse2.isDisplayedAfterWaiting(waitTime)) {
					flag = true;
				}
			} else
				flag = false;

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN  CHECKING WHETHER TRUE / FALSE RESPONSE IS BEING DISPLAYED OR NOT."
							+ "\n METHOD : isTrueFalseResponseDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * this method will click on Edit link of Title & Introductory Text
	 * 
	 * @return {@link EditExamPage }
	 * 
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public EditExamPage clickOnEditLink() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON EDIT LINK");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkEdit, waitTime);
			lnkEdit.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Edit' LINK"
					+ "\n METHOD : clickOnEditLink \n"
					+ e.getLocalizedMessage());
		}
		return new EditExamPage(uiDriver);
	}

	/**
	 * this method will click on Add new Page link
	 * 
	 * @return {@link AddNewExamPage }
	 * 
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public AddNewExamPage clickOnAddNewPageLink() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON ADD NEW PAGE LINK");
			frameSwitch.switchToFrameContent();

			uiDriver.waitToBeDisplayed(lnkaddNewPage, waitTime);
			lnkaddNewPage.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Add New Page' LINK"
					+ "\n METHOD : clickOnAddNewPageLink \n"
					+ e.getLocalizedMessage());
		}
		return new AddNewExamPage(uiDriver);
	}

	/**
	 * this method will click on Page
	 * 
	 * @return {@link ExamHomePage }
	 * @param String
	 *            pageNumber
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public ExamHomePage clickOnPage(String pageNumber) throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON  PAGE .");
			frameSwitch.switchToFrameContent();
			lnkPageNo.replaceValues(pageNumber);
			uiDriver.waitToBeDisplayed(lnkPageNo, waitTime);
			lnkPageNo.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON PAGE"
					+ "\n METHOD : clickOnPage \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * this method will click on Edit Page
	 * 
	 * @return {@link EditPageNPage }
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public EditPageNPage clickOnEditPage() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON EDIT PAGE LINK");
			frameSwitch.switchToFrameContent();

			uiDriver.waitToBeDisplayed(lnkEditPage, waitTime);
			lnkEditPage.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Edit Page' LINK"
					+ "\n METHOD : clickOnEditPage \n"
					+ e.getLocalizedMessage());
		}
		return new EditPageNPage(uiDriver);
	}

	/**
	 * this method will click on Delete Page
	 * 
	 * @return {@link ExamHomePage }
	
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public ExamHomePage clickOnDeletePage() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON DELETE PAGE LINK");
			frameSwitch.switchToFrameContent();

			uiDriver.waitToBeDisplayed(lnkDeletePage, waitTime);
			lnkDeletePage.clickNoWait();
			uiDriver.getUIAlert().acceptAlertIfPresent();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Delete Page' LINK"
					+ "\n METHOD : clickOnDeletePage \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * this method will click On Edit Link Of Question
	 * 
	 * @return {@link Object }
	 * @param String
	 *            question
	 * @return void
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public Object clickOnEditLinkOfQuestion(String question) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON EDIT LINK OF QUESTION . ");
			frameSwitch.switchToFrameContent();
			lnkclickEditLinkOfQuestion.replaceValues(question);
			uiDriver.waitToBeDisplayed(lnkclickEditLinkOfQuestion, waitTime);
			lblExamQuestionType.replaceValues(question);
			selectedQuestionTypeCode = lblExamQuestionType.getText().trim();
			SelectQuestionType type = SelectQuestionType.ESSAY_QUESTION;
			selectedType = type.getName(selectedQuestionTypeCode);
			lnkclickEditLinkOfQuestion.clickNoWait();
			switch (selectedType) {
			case TRUE_FALSE_QUESTION:
				return new EditTrueFalsePage(uiDriver);
			case MULTIPLE_CHOICE_QUESTION:
				return new EditMultipleChoicePage(uiDriver);
			case MATCHING_TYPE_QUESTION:
				return null;
			case FILL_IN_THE_BLANK_QUESTION:
				return new EditFillTheBlankPage(uiDriver);
			case MULTIPLE_ANSWER_QUESTION:
				return null;
			case SHORT_ANSWER_QUESTION:
				return new EditShortAnswerPage(uiDriver);
			case ESSAY_QUESTION:
				return new EditEssayPage(uiDriver);
			case QUESTION_POOL:
				return null;
			case UPLOAD_QUESTION:
				return null;
			default:
				return null;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE EDIT LINK OF QUESTION ."
					+ "\n METHOD : clickOnEditLinkOfQuestion \n"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This is Service level method to Select Type of Exam And Add
	 * 
	 * @author Kapil
	 * @param questionType
	 * @return Object
	 * @throws exception
	 */
	public Object selectExamTypeAndAdd(SelectQuestionType questionType)
			throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(drpQuestionAvail, waitTime);
			drpQuestionAvail.selectByVisibleText(questionType
					.getQuestionValue());
			uiDriver.waitToBeDisplayed(btnAdd, waitTime);
			btnAdd.clickNoWait();
			switch (questionType) {
			case TRUE_FALSE_QUESTION:
				return new AddTrueFalseQuestionPage(uiDriver);
			case MULTIPLE_CHOICE_QUESTION:
				return new AddMultipleChoiceQuestionPage(uiDriver);
			case MATCHING_TYPE_QUESTION:
				return new AddMatchingQuestionPage(uiDriver);
			case FILL_IN_THE_BLANK_QUESTION:
				return new AddFillInTheBlankQuestionPage(uiDriver);
			case MULTIPLE_ANSWER_QUESTION:
				return new AddMultipleAnswerQuestionPage(uiDriver);
			case SHORT_ANSWER_QUESTION:
				return new AddShortAnswerQuestionPage(uiDriver);
			case ESSAY_QUESTION:
				return new AddEssayQuestionPage(uiDriver);
			case QUESTION_POOL:
				return null;
			case UPLOAD_QUESTION:
				return null;
			default:
				return null;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN SELECTING QUESTION TYPE AND CLICKING ADD BUTTON"
					+ "\n METHOD : selectExamTypeAndAdd \n"
					+ e.getLocalizedMessage());
		}
	}

}
