package com.pearson.eselenium.ls.common.pages;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pearson.eselenium.ls.common.visualeditor.elements.AjaxSpellCheckElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.AlignCenterElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.AlignLeftElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.AlignRightElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.BackgroundColorElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.BoldElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.BulletListElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.CopyElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.CutTextElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.DesignElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.EquellaLinkWizardInsertElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.FindAndReplaceElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.FontNameElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.ForegroundColorElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.HorizontalRuleElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.HtmlElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.IndentElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.InsertDateElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.InsertSymbolElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.InsertTableElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.InsertTimeElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.ItalicElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.JustifyElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.LinkWizardInsertImageElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.LinkWizardInsertLinkElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.MathEquationEditorElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.MoveFocusToTextEditorElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.NumberedListElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.OutdentElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.ParagraphStyleElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.PasteAsHtmlElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.PasteElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.PasteFromWordElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.PastePlainTextElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.PreviewElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.PrintElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.RedoElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.SizeElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.StrikethroughElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.ToggleScreenModeElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.UnderlineElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.UndoElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.VisualEditorElementsEnum;
import com.pearson.eselenium.ls.common.visualeditor.elements.XhtmlValidatorElement;
import com.pearson.eselenium.ls.common.visualeditor.elements.ZoomElement;
import com.pearson.eselenium.utils.AutoITMethods;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.elements.DefaultUIActions;
import com.pearson.test.eselenium.framework.elements.UIActions;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of DatePicker page Follow
 * the below steps to navigate the page: Login as prof Click on the Course
 * Select Author Tab Click CourseHome in navigation tree Click AddAnnoncement
 * link
 * 
 * @author Kapil Aare
 */
public class VisualEditor extends BasePageObject {

	/* Elements */
	private UIElement btnMoveFocusTotextEditor = createElement(UIType.Css,
			"#{1} .MoveFocusToTextEditor");
	private UIElement btnPrint = createElement(UIType.Css, "#{1} .Print");;
	private UIElement btnFindAndReplace = createElement(UIType.Css,
			"#{1} .FindAndReplace");
	private UIElement btnCut = createElement(UIType.Css, "#{1} .Cut");
	private UIElement btnCopy = createElement(UIType.Css, "#{1} .Copy");
	private UIElement btnPaste = createElement(UIType.Css, "#{1} .Paste");
	private UIElement btnPastePlainText = createElement(UIType.Css,
			"#{1} .PastePlainText");
	private UIElement btnPasteAsHtml = createElement(UIType.Css,
			"#{1} .PasteAsHtml");
	private UIElement btnPasteFromWord = createElement(UIType.Css,
			"#{1} .PasteFromWord");
	private UIElement btnUndo = createElement(UIType.Css, "#{1} .Undo");
	private UIElement btnRedo = createElement(UIType.Css, "#{1} .Redo");
	private UIElement btnEquellaLinkWizardInsert = createElement(UIType.Css,
			"#{1} .EquellaLinkWizardInsert");
	private UIElement btnLinkWizardInsertLink = createElement(UIType.Css,
			"#{1} .LinkWizardInsertLink");
	private UIElement btnLinkWizardInsertImage = createElement(UIType.Css,
			"#{1} .LinkWizardInsertImage");
	private UIElement btnMathEquationEditor = createElement(UIType.Css,
			"#{1} .MathEquationEditor");
	private UIElement btnAjaxSpellCheck = createElement(UIType.Css,
			"#{1} .AjaxSpellCheck");;
	private UIElement btnXhtmlValidator = createElement(UIType.Css,
			"#{1} .XhtmlValidator");
	private UIElement btnInsertSymbol = createElement(UIType.Css,
			"#{1} .InsertSymbol");
	private UIElement btnInsertDate = createElement(UIType.Css,
			"#{1} .InsertDate");
	private UIElement btnInsertTime = createElement(UIType.Css,
			"#{1} .InsertTime");
	private UIElement btnInsertTable = createElement(UIType.Css,
			"#{1} .InsertTable");
	private UIElement btnForeColor = createElement(UIType.Css,
			"#{1} .ForeColor");
	private UIElement btnBackColor = createElement(UIType.Css,
			"#{1} .BackColor");
	private UIElement btnFormatBlock = createElement(UIType.Css,
			"#{1} .FormatBlock");
	private UIElement btnFontName = createElement(UIType.Css, "#{1} .FontName");
	private UIElement btnFontSize = createElement(UIType.Css, "#{1} .FontSize");
	private UIElement btnBold = createElement(UIType.Css, "#{1} .Bold");
	private UIElement btnItalic = createElement(UIType.Css, "#{1} .Italic");
	private UIElement btnUnderline = createElement(UIType.Css,
			"#{1} .Underline");
	private UIElement btnJustifyLeft = createElement(UIType.Css,
			"#{1} .JustifyLeft");
	private UIElement btnJustifyCenter = createElement(UIType.Css,
			"#{1} .JustifyCenter");
	private UIElement btnJustifyRight = createElement(UIType.Css,
			"#{1} .JustifyRight");;
	private UIElement btnJustifyFull = createElement(UIType.Css,
			"#{1} .JustifyFull");
	private UIElement btnOutdent = createElement(UIType.Css, "#{1} .Outdent");
	private UIElement btnIndent = createElement(UIType.Css, "#{1} .Indent");
	private UIElement btnInsertOrderedList = createElement(UIType.Css,
			"#{1} .InsertOrderedList");
	private UIElement btnInsertUnorderedList = createElement(UIType.Css,
			"#{1} .InsertUnorderedList");
	private UIElement btnInsertHorizontalRule = createElement(UIType.Css,
			"#{1} .InsertHorizontalRule");
	private UIElement btnStrikeThrough = createElement(UIType.Css,
			"#{1} .StrikeThrough");
	private UIElement clrpicker = createElement(UIType.Xpath,
			"//div[@title='{1}']");
	private UIElement btnSubjectBackGroundColor = createElement(UIType.Xpath,
			"//td[@id='{1}']//a[span[@class='BackColor']]//span[2]");
	private UIElement btnHtml = createElement(UIType.Css,
			"#{1} .reMode_html span");
	private UIElement btnDesign = createElement(UIType.Css,
			"#{1} .reMode_design span");
	private UIElement btnPreview = createElement(UIType.Css,
			"#{1} .reMode_preview span");
	private UIElement btnZoom = createElement(UIType.Css, "#{1} .Zoom");
	private UIElement isVisualEditorSelected = createElement(UIType.Css,
			"div[id='telerikRAD']+input");
	private UIElement tblinsertTable = createElement(UIType.Xpath,
			"//td[@title='{1}']");
	private UIElement verifyForeground = createElement(UIType.Xpath,
			"//html/body/div[contains(@style,'visible')]");
	private UIElement strikethough = createElement(UIType.Xpath,
			"//a[@title='Strikethrough']");
	private UIElement btninsertsymbol = createElement(UIType.Css,
			"#{1} .InsertSymbol");
	private UIElement lnkdesignview = createElement(UIType.Xpath,
			"//a[@title='Design']");
	private UIElement lnkHTMLnview = createElement(UIType.Xpath,
			"//a[@title='HTML']");
	private UIElement lnkPreviewnview = createElement(UIType.Xpath,
			"//a[@title='Preview']");
	private UIElement lnkZoom = createElement(UIType.Xpath,
			"//a[@title='Zoom']");
	private UIElement isConnecttoEquella = createElement(UIType.Xpath,
			"//div[@class='tablehead']");
	private UIElement verifyFormatBlock = createElement(UIType.Xpath,
			"//html/body/{1}");
	private UIElement verifyFontName = createElement(UIType.Xpath,
			"//html/body/{1}//font");
	private UIElement verifyBold = createElement(UIType.Xpath, "//html/body/b");
	private UIElement verifyItalic = createElement(UIType.Xpath,
			"//html/body//i");
	private UIElement verifyUnderline = createElement(UIType.Xpath,
			"//html/body//u");
	private UIElements Style = createElements(UIType.Css,
			".Default.reDropDownBody>table>tbody>tr>td");
	private UIElement verifyAlignment = createElement(UIType.Xpath,
			"//html/body/div");
	private UIElement spellCheckerSuggestion = createElement(UIType.Css,
			".reAjaxSpellCheckSuggestions>table>tbody>tr:nth-of-type(1)>td");
	String CreatedXpath = "//html/body";
	private UIElement tblsymbol = createElement(UIType.Xpath,
			"//html/body/div[2]/table/tbody/tr[{1}]/td[{2}]");
	private UIElement selectzoom = createElement(UIType.Xpath,
			"//td[contains(text(),'{1}%')]");
	private UIElement areapasteasplain = createElement(UIType.Css, "#holder");
	private UIElement btnpaste = createElement(UIType.Css, "#InsertButton");
	private UIElement areatext = createElement(UIType.Xpath, "//html/body");
	private UIElement btninsert = createElement(UIType.Xpath,
			"//div[@id='initializer']//button[@id='InsertButton']");
	private UIElement btnTogglescreenMode = createElement(UIType.Css,
			"#{1} .ToggleScreenMode");
	private UIElement imgRadedit = createElement(UIType.Xpath,
			"//img[contains(@src,'{1}')]");
	private UIElement parentElement;

	/* Variables */
	private String toolId;
	private String frameId;
	private String footerId;
	private boolean flag = false;
	private StringBuffer sb = null;
	private String alertMsg;
	private StringBuffer RGBcode;
	private String strResult = null;
	private String strSecondResult = null;

	/* Constructor */
	public VisualEditor(UIDriver uiDriver, String RadToolId, String frameId,
			String footerID) {
		super(uiDriver);
		this.toolId = RadToolId;
		this.frameId = frameId;
		this.footerId = footerID;
		logInstruction("LOG INSTRUCTION: ## Visual Editor ##");
	}

	/**
	 * This function is a common function that will return the tooltip of
	 * element.
	 * 
	 * @author Sumanth SV
	 * @param UIElement
	 *            element
	 * @return String
	 * @throws Exception
	 * **/
	private String getTooltip(UIElement element) throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(element, waitTime);
			/** get Parent element **/
			parentElement = element.findUIElement(By.xpath(".."));
			/** get the tooltip/title attribute **/
			strResult = parentElement.getAttribute("title");
		} catch (Exception e) {
			throw new Exception("FAILED TO GET THE ATTRIBUTE 'title' \n"
					+ e.getLocalizedMessage());
		}
		return strResult;
	}

	/**
	 * Method helps to check for radEditor Icon display
	 * 
	 * @param VisualEditorElementsEnum
	 *            elementName
	 * @param tableId
	 * @return boolean
	 * @throws Exception
	 * @author ganapati.bhat
	 */
	public boolean isRadEditorElementDisplayed(
			VisualEditorElementsEnum elementName) throws Exception {
		flag = false;
		switch (elementName) {
		case MOVE_FOCUS_TO_TEXT_EDITOR:
			btnMoveFocusTotextEditor.replaceValues(toolId);
			flag = btnMoveFocusTotextEditor.isDisplayedAfterWaiting(waitTime);
			return flag;
		case PRINT:
			btnPrint.replaceValues(toolId);
			flag = btnPrint.isDisplayedAfterWaiting(waitTime);
			return flag;
		case FIND_AND_REPLACE:
			btnFindAndReplace.replaceValues(toolId);
			flag = btnFindAndReplace.isDisplayedAfterWaiting(waitTime);
			return flag;
		case CUT:
			btnCut.replaceValues(toolId);
			flag = btnCut.isDisplayedAfterWaiting(waitTime);
			return flag;
		case COPY:
			btnCopy.replaceValues(toolId);
			flag = btnCopy.isDisplayedAfterWaiting(waitTime);
			return flag;
		case PASTE:
			btnPaste.replaceValues(toolId);
			flag = btnPaste.isDisplayedAfterWaiting(waitTime);
			return flag;
		case PASTE_PLAIN_TEXT:
			btnPastePlainText.replaceValues(toolId);
			flag = btnPastePlainText.isDisplayedAfterWaiting(waitTime);
			return flag;
		case PASTE_AS_HTML:
			btnPasteAsHtml.replaceValues(toolId);
			flag = btnPasteAsHtml.isDisplayedAfterWaiting(waitTime);
			return flag;
		case PASTE_FROM_WORD:
			btnPasteFromWord.replaceValues(toolId);
			flag = btnPasteFromWord.isDisplayedAfterWaiting(waitTime);
			return flag;
		case UNDO:
			btnUndo.replaceValues(toolId);
			flag = btnUndo.isDisplayedAfterWaiting(waitTime);
			return flag;
		case REDO:
			btnRedo.replaceValues(toolId);
			flag = btnRedo.isDisplayedAfterWaiting(waitTime);
			return flag;
		case EQUELLA_LINK_WIZARD_INSERT:
			btnEquellaLinkWizardInsert.replaceValues(toolId);
			flag = btnEquellaLinkWizardInsert.isDisplayedAfterWaiting(waitTime);
			return flag;
		case LINK_WIZARD_INSERT_LINK:
			btnLinkWizardInsertLink.replaceValues(toolId);
			flag = btnLinkWizardInsertLink.isDisplayedAfterWaiting(waitTime);
			return flag;
		case LINK_WIZARD_INSERT_IMAGE:
			btnLinkWizardInsertImage.replaceValues(toolId);
			flag = btnLinkWizardInsertImage.isDisplayedAfterWaiting(waitTime);
			return flag;
		case MATH_EQUATION_EDITOR:
			btnMathEquationEditor.replaceValues(toolId);
			flag = btnMathEquationEditor.isDisplayedAfterWaiting(waitTime);
			return flag;
		case AJAX_SPELL_CHECK:
			btnAjaxSpellCheck.replaceValues(toolId);
			flag = btnAjaxSpellCheck.isDisplayedAfterWaiting(waitTime);
			return flag;
		case XHTML_VALIDATOR:
			btnXhtmlValidator.replaceValues(toolId);
			flag = btnXhtmlValidator.isDisplayedAfterWaiting(waitTime);
			return flag;
		case INSERT_SYMBOL:
			btnInsertSymbol.replaceValues(toolId);
			flag = btnInsertSymbol.isDisplayedAfterWaiting(waitTime);
			return flag;
		case INSERT_DATE:
			btnInsertDate.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnInsertDate, waitTime);
			flag = btnInsertDate.isDisplayedAfterWaiting();
			return flag;
		case INSERT_TIME:
			btnInsertTime.replaceValues(toolId);
			flag = btnInsertTime.isDisplayedAfterWaiting(waitTime);
			return flag;
		case INSERT_TABLE:
			btnInsertTable.replaceValues(toolId);
			flag = btnInsertTable.isDisplayedAfterWaiting(waitTime);
			return flag;
		case FOREGROUND_COLOR:
			btnForeColor.replaceValues(toolId);
			flag = btnForeColor.isDisplayedAfterWaiting(waitTime);
			return flag;
		case BACKGROUND_COLOR:
			btnBackColor.replaceValues(toolId);
			flag = btnBackColor.isDisplayedAfterWaiting(waitTime);
			return flag;
		case FORMAT_BLOCK:
			btnFormatBlock.replaceValues(toolId);
			flag = btnFormatBlock.isDisplayedAfterWaiting(waitTime);
			return flag;
		case FONT_NAME:
			btnFontName.replaceValues(toolId);
			flag = btnFontName.isDisplayedAfterWaiting(waitTime);
			return flag;
		case FONT_SIZE:
			btnFontSize.replaceValues(toolId);
			flag = btnFontSize.isDisplayedAfterWaiting(waitTime);
			return flag;
		case BOLD:
			btnBold.replaceValues(toolId);
			flag = btnBold.isDisplayedAfterWaiting(waitTime);
			return flag;
		case ITALIC:
			btnItalic.replaceValues(toolId);
			flag = btnItalic.isDisplayedAfterWaiting(waitTime);
			return flag;
		case UNDERLINE:
			btnUnderline.replaceValues(toolId);
			flag = btnUnderline.isDisplayedAfterWaiting(waitTime);
			return flag;
		case ALIGN_LEFT:
			btnJustifyLeft.replaceValues(toolId);
			flag = btnJustifyLeft.isDisplayedAfterWaiting(waitTime);
			return flag;
		case ALIGN_CENTRE:
			btnJustifyCenter.replaceValues(toolId);
			flag = btnJustifyCenter.isDisplayedAfterWaiting(waitTime);
			return flag;
		case ALIGN_RIGHT:
			btnJustifyRight.replaceValues(toolId);
			flag = btnJustifyRight.isDisplayedAfterWaiting(waitTime);
			return flag;
		case JUSTIFY_FULL:
			btnJustifyFull.replaceValues(toolId);
			flag = btnJustifyFull.isDisplayedAfterWaiting(waitTime);
			return flag;
		case OUTDENT:
			btnOutdent.replaceValues(toolId);
			flag = btnOutdent.isDisplayedAfterWaiting(waitTime);
			return flag;
		case INDENT:
			btnIndent.replaceValues(toolId);
			flag = btnIndent.isDisplayedAfterWaiting(waitTime);
			return flag;
		case NUMBERED_LIST:
			btnInsertOrderedList.replaceValues(toolId);
			flag = btnInsertOrderedList.isDisplayedAfterWaiting(waitTime);
			return flag;
		case BULLET_LIST:
			btnInsertUnorderedList.replaceValues(toolId);
			flag = btnInsertUnorderedList.isDisplayedAfterWaiting(waitTime);
			return flag;
		case HORIZONTAL_RULE:
			btnInsertHorizontalRule.replaceValues(toolId);
			flag = btnInsertHorizontalRule.isDisplayedAfterWaiting(waitTime);
			return flag;
		case STRIKE_THROUGH:
			btnStrikeThrough.replaceValues(toolId);
			flag = btnStrikeThrough.isDisplayedAfterWaiting(waitTime);
			return flag;
		case DESIGN:
			btnDesign.replaceValues(footerId);
			flag = btnDesign.isDisplayedAfterWaiting(waitTime);
			return flag;
		case HTML:
			btnHtml.replaceValues(footerId);
			flag = btnHtml.isDisplayedAfterWaiting(waitTime);
			return flag;
		case PREVIEW:
			btnPreview.replaceValues(footerId);
			flag = btnPreview.isDisplayedAfterWaiting(waitTime);
			return flag;
		case ZOOM:
			btnZoom.replaceValues(toolId);
			flag = btnZoom.isDisplayedAfterWaiting(waitTime);
			return flag;
		case TOGGLESCREENMODE:
			btnTogglescreenMode.replaceValues(toolId);
			flag = btnTogglescreenMode.isDisplayedAfterWaiting(waitTime);
			return flag;
		default:
			return false;
		}
	}

	/**
	 * Method helps to get the radEditor tool tip
	 * 
	 * @param VisualEditorElementsEnum
	 *            elementName
	 * @return String
	 * @throws Exception
	 * @author ganapati.bhat
	 */
	public String getRadEditorElementToolTip(
			VisualEditorElementsEnum elementName) throws Exception {
		strResult = "";
		switch (elementName) {
		case MOVE_FOCUS_TO_TEXT_EDITOR:
			btnMoveFocusTotextEditor.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnMoveFocusTotextEditor, waitTime);
			strResult = getTooltip(btnMoveFocusTotextEditor);
			return strResult;
		case PRINT:
			btnPrint.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnPrint, waitTime);
			strResult = getTooltip(btnPrint);
			return strResult;
		case FIND_AND_REPLACE:
			btnFindAndReplace.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnFindAndReplace, waitTime);
			strResult = getTooltip(btnFindAndReplace);
			return strResult;
		case CUT:
			btnCut.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnCut, waitTime);
			strResult = getTooltip(btnCut);
			return strResult;
		case COPY:
			btnCopy.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnCopy, waitTime);
			strResult = getTooltip(btnCopy);
			return strResult;
		case PASTE:
			btnPaste.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnPaste, waitTime);
			strResult = getTooltip(btnPaste);
			return strResult;
		case PASTE_PLAIN_TEXT:
			btnPastePlainText.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnPastePlainText, waitTime);
			strResult = getTooltip(btnPastePlainText);
			return strResult;
		case PASTE_AS_HTML:
			btnPasteAsHtml.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnPasteAsHtml, waitTime);
			strResult = getTooltip(btnPasteAsHtml);
			return strResult;
		case PASTE_FROM_WORD:
			btnPasteFromWord.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnPasteFromWord, waitTime);
			strResult = getTooltip(btnPasteFromWord);
			return strResult;
		case UNDO:
			btnUndo.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnUndo, waitTime);
			strResult = getTooltip(btnUndo);
			return strResult;
		case REDO:
			btnRedo.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnRedo, waitTime);
			strResult = getTooltip(btnRedo);
			return strResult;
		case EQUELLA_LINK_WIZARD_INSERT:
			btnEquellaLinkWizardInsert.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnEquellaLinkWizardInsert, waitTime);
			strResult = getTooltip(btnEquellaLinkWizardInsert);
			return strResult;
		case LINK_WIZARD_INSERT_LINK:
			btnLinkWizardInsertLink.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnLinkWizardInsertLink, waitTime);
			strResult = getTooltip(btnLinkWizardInsertLink);
			return strResult;
		case LINK_WIZARD_INSERT_IMAGE:
			btnLinkWizardInsertImage.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnLinkWizardInsertImage, waitTime);
			strResult = getTooltip(btnLinkWizardInsertImage);
			return strResult;
		case MATH_EQUATION_EDITOR:
			btnMathEquationEditor.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnMathEquationEditor, waitTime);
			strResult = getTooltip(btnMathEquationEditor);
			return strResult;
		case AJAX_SPELL_CHECK:
			btnAjaxSpellCheck.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnAjaxSpellCheck, waitTime);
			strResult = getTooltip(btnAjaxSpellCheck);
			return strResult;
		case XHTML_VALIDATOR:
			btnXhtmlValidator.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnXhtmlValidator, waitTime);
			strResult = getTooltip(btnXhtmlValidator);
			return strResult;
		case INSERT_SYMBOL:
			btnInsertSymbol.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnInsertSymbol, waitTime);
			strResult = getTooltip(btnInsertSymbol);
			return strResult;
		case INSERT_DATE:
			btnInsertDate.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnInsertDate, waitTime);
			strResult = getTooltip(btnInsertDate);
			return strResult;
		case INSERT_TIME:
			btnInsertTime.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnInsertTime, waitTime);
			strResult = getTooltip(btnInsertTime);
			return strResult;
		case INSERT_TABLE:
			btnInsertTable.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnInsertTable, waitTime);
			strResult = getTooltip(btnInsertTable);
			return strResult;
		case FOREGROUND_COLOR:
			btnForeColor.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnForeColor, waitTime);
			strResult = getTooltip(btnForeColor);
			return strResult;
		case BACKGROUND_COLOR:
			btnBackColor.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnBackColor, waitTime);
			strResult = getTooltip(btnBackColor);
			return strResult;
		case FORMAT_BLOCK:
			btnFormatBlock.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnFormatBlock, waitTime);
			strResult = getTooltip(btnFormatBlock);
			return strResult;
		case FONT_NAME:
			btnFontName.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnFontName, waitTime);
			strResult = getTooltip(btnFontName);
			return strResult;
		case FONT_SIZE:
			btnFontSize.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnFontSize, waitTime);
			strResult = getTooltip(btnFontSize);
			return strResult;
		case BOLD:
			btnBold.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnBold, waitTime);
			strResult = getTooltip(btnBold);
			return strResult;
		case ITALIC:
			btnItalic.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnItalic, waitTime);
			strResult = getTooltip(btnItalic);
			return strResult;
		case UNDERLINE:
			btnUnderline.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnUnderline, waitTime);
			strResult = getTooltip(btnUnderline);
			return strResult;
		case ALIGN_LEFT:
			btnJustifyLeft.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnJustifyLeft, waitTime);
			strResult = getTooltip(btnJustifyLeft);
			return strResult;
		case ALIGN_CENTRE:
			btnJustifyCenter.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnJustifyCenter, waitTime);
			strResult = getTooltip(btnJustifyCenter);
			return strResult;
		case ALIGN_RIGHT:
			btnJustifyRight.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnJustifyRight, waitTime);
			strResult = getTooltip(btnJustifyRight);
			return strResult;
		case JUSTIFY_FULL:
			btnJustifyFull.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnJustifyFull, waitTime);
			strResult = getTooltip(btnJustifyFull);
			return strResult;
		case OUTDENT:
			btnOutdent.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnOutdent, waitTime);
			strResult = getTooltip(btnOutdent);
			return strResult;
		case INDENT:
			btnIndent.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnIndent, waitTime);
			strResult = getTooltip(btnIndent);
			return strResult;
		case NUMBERED_LIST:
			btnInsertOrderedList.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnInsertOrderedList, waitTime);
			strResult = getTooltip(btnInsertOrderedList);
			return strResult;
		case BULLET_LIST:
			btnInsertUnorderedList.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnInsertUnorderedList, waitTime);
			strResult = getTooltip(btnInsertUnorderedList);
			return strResult;
		case HORIZONTAL_RULE:
			btnInsertHorizontalRule.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnInsertHorizontalRule, waitTime);
			strResult = getTooltip(btnInsertHorizontalRule);
			return strResult;
		case STRIKE_THROUGH:
			btnStrikeThrough.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnStrikeThrough, waitTime);
			strResult = getTooltip(btnStrikeThrough);
			return strResult;
		default:
			return strResult;
		}
	}

	/**
	 * Method helps to apply the color required
	 * 
	 * @author ganapati.bhat
	 * @param String
	 *            colorcode
	 * @return void
	 * @throws Exception
	 * 
	 */
	public void applyColor(String strColorCode) throws Exception {
		try {
			clrpicker.replaceValues(strColorCode);
			uiDriver.switchTo().activeElement();
			clrpicker.clickNoWait();
			logInstruction("LOG INSTRUCTION: SELECTED  COLOR");
		} catch (Exception e) {
			throw new Exception("UNABLE TO SELECT THE COLOR"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * Method helps to apply the color required
	 * 
	 * @author ganapati.bhat
	 * @param String
	 *            strElement
	 * @param String
	 *            strColorCode
	 * @return void
	 * @throws Exception
	 * 
	 */
	public void applySubjectBackGroundColor(String strElement,
			String strColorCode) throws Exception {
		try {
			btnSubjectBackGroundColor.replaceValues(strElement);
			clrpicker.replaceValues(strColorCode);
			uiDriver.switchTo().activeElement();
			clrpicker.clickNoWait();
			logInstruction("LOG INSTRUCTION: SELECTED SUBJECT BACKGROUND COLOR");
		} catch (Exception e) {
			throw new Exception("UNABLE TO SELECT THE BACKGROUND COLOR"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * Method helps to click the radEditor
	 * 
	 * @param VisualEditorElementsEnum
	 *            elementName
	 * @return void
	 * @throws Exception
	 * @author soundarya
	 */
	public void clickRadEditorElement(VisualEditorElementsEnum elementName)
			throws Exception {
		switch (elementName) {
		case MOVE_FOCUS_TO_TEXT_EDITOR:
			btnMoveFocusTotextEditor.replaceValues(toolId);
			MoveFocusToTextEditorElement fousToText = new MoveFocusToTextEditorElement(
					btnMoveFocusTotextEditor);
			fousToText.clickMoveFocusToTextEditorButton();
			break;
		case PRINT:
			btnPrint.replaceValues(toolId);
			PrintElement print = new PrintElement(btnPrint);
			print.clickPrintButton();
			break;
		case CUT:
			btnCut.replaceValues(toolId);
			CutTextElement cut = new CutTextElement(btnCut);
			cut.clickCutButton();
			alertMsg = uiDriver.getUIAlert()
					.acceptAlertIfPresentAndGetMessage();
			break;
		case COPY:
			btnCopy.replaceValues(toolId);
			CopyElement copy = new CopyElement(btnCopy);
			copy.clickCopyButton();
			alertMsg = uiDriver.getUIAlert()
					.acceptAlertIfPresentAndGetMessage();
			break;
		case PASTE:
			btnPaste.replaceValues(toolId);
			PasteElement paste = new PasteElement(btnPaste);
			paste.clickPasteElementButton();
			alertMsg = uiDriver.getUIAlert()
					.acceptAlertIfPresentAndGetMessage();
			break;
		case UNDO:
			btnUndo.replaceValues(toolId);
			UndoElement undo = new UndoElement(btnUndo);
			undo.clickUndoButton();
			break;
		case REDO:
			btnRedo.replaceValues(toolId);
			RedoElement redo = new RedoElement(btnRedo);
			redo.clickRedoButton();
			break;
		case AJAX_SPELL_CHECK:
			btnAjaxSpellCheck.replaceValues(toolId);
			AjaxSpellCheckElement ajax = new AjaxSpellCheckElement(
					btnAjaxSpellCheck);
			ajax.clickAjaxSpellCheckButton();
			alertMsg = uiDriver.getUIAlert()
					.acceptAlertIfPresentAndGetMessage();
			break;
		case INSERT_SYMBOL:
			btnInsertSymbol.replaceValues(toolId);
			InsertSymbolElement symbol = new InsertSymbolElement(
					btnInsertSymbol);
			symbol.clickInsertSymbol();
			break;
		case INSERT_DATE:
			btnInsertDate.replaceValues(toolId);
			InsertDateElement date = new InsertDateElement(btnInsertDate);
			date.clickInsertDateButton();
			break;
		case INSERT_TIME:
			btnInsertTime.replaceValues(toolId);
			InsertTimeElement time = new InsertTimeElement(btnInsertTime);
			time.clickInsertTimeButton();
			break;
		case INSERT_TABLE:
			btnInsertTable.replaceValues(toolId);
			InsertTableElement table = new InsertTableElement(btnInsertTable);
			table.clickInsertTableButton();
			break;
		case FOREGROUND_COLOR:
			btnForeColor.replaceValues(toolId);
			ForegroundColorElement foregroundColorElement = new ForegroundColorElement(
					btnForeColor);
			foregroundColorElement.clickForegroundColorButton();
			break;
		case BACKGROUND_COLOR:
			btnBackColor.replaceValues(toolId);
			BackgroundColorElement backgroundColorElement = new BackgroundColorElement(
					btnBackColor);
			backgroundColorElement.clickBackgroundColourButton();
			break;
		case BOLD:
			btnBold.replaceValues(toolId);
			BoldElement boldElement = new BoldElement(btnBold);
			boldElement.clickBoldButton();
			break;
		case ITALIC:
			btnItalic.replaceValues(toolId);
			ItalicElement italicElement = new ItalicElement(btnItalic);
			italicElement.clickItalicButton();
			break;
		case UNDERLINE:
			btnUnderline.replaceValues(toolId);
			UnderlineElement underlineElement = new UnderlineElement(
					btnUnderline);
			underlineElement.clickUnderlineButton();
			break;
		case ALIGN_LEFT:
			btnJustifyLeft.replaceValues(toolId);
			AlignLeftElement alignLeftElement = new AlignLeftElement(
					btnJustifyLeft);
			alignLeftElement.clickAlignLeftButton();
			break;
		case ALIGN_CENTRE:
			btnJustifyCenter.replaceValues(toolId);
			AlignCenterElement alignCenterElement = new AlignCenterElement(
					btnJustifyCenter);
			alignCenterElement.clickAlignCenterButton();
			break;
		case ALIGN_RIGHT:
			btnJustifyRight.replaceValues(toolId);
			AlignRightElement alignRightElement = new AlignRightElement(
					btnJustifyRight);
			alignRightElement.clickAlignRightButton();
			break;
		case JUSTIFY_FULL:
			btnJustifyFull.replaceValues(toolId);
			JustifyElement justifyElement = new JustifyElement(btnJustifyFull);
			justifyElement.clickJustifyButton();
			break;
		case OUTDENT:
			btnOutdent.replaceValues(toolId);
			OutdentElement outdentElement = new OutdentElement(btnOutdent);
			outdentElement.clickOutdentButton();
			break;
		case INDENT:
			btnIndent.replaceValues(toolId);
			IndentElement indentElement = new IndentElement(btnIndent);
			indentElement.clickIndentButton();
			break;
		case NUMBERED_LIST:
			btnInsertOrderedList.replaceValues(toolId);
			NumberedListElement numberedListElement = new NumberedListElement(
					btnInsertOrderedList);
			numberedListElement.clickNumberedListButton();
			break;
		case BULLET_LIST:
			btnInsertUnorderedList.replaceValues(toolId);
			BulletListElement bulletListElement = new BulletListElement(
					btnInsertUnorderedList);
			bulletListElement.clickBulletListButton();
			break;
		case HORIZONTAL_RULE:
			btnInsertHorizontalRule.replaceValues(toolId);
			HorizontalRuleElement horizontalRuleElement = new HorizontalRuleElement(
					btnInsertHorizontalRule);
			horizontalRuleElement.clickHorizontalRuleButton();
			break;
		case STRIKE_THROUGH:
			btnStrikeThrough.replaceValues(toolId);
			StrikethroughElement strikethroughElement = new StrikethroughElement(
					btnStrikeThrough);
			strikethroughElement.clickStrikethroughButton();
			break;
		case FORMAT_BLOCK:
			btnFormatBlock.replaceValues(toolId);
			ParagraphStyleElement paragraphStyleElement = new ParagraphStyleElement(
					btnFormatBlock);
			paragraphStyleElement.clickParagraphStyleButton();
			break;
		case FONT_NAME:
			btnFontName.replaceValues(toolId);
			FontNameElement fontNameElement = new FontNameElement(btnFontName);
			fontNameElement.clickFontNameButton();
			break;
		case FONT_SIZE:
			btnFontSize.replaceValues(toolId);
			SizeElement sizeElement = new SizeElement(btnFontSize);
			sizeElement.clickSizeButton();
			break;
		case DESIGN:
			btnDesign.replaceValues(footerId);
			DesignElement designElement = new DesignElement(btnDesign);
			designElement.clickDesignButton();
			break;
		case HTML:
			btnHtml.replaceValues(footerId);
			HtmlElement htmlElement = new HtmlElement(btnHtml);
			htmlElement.clickHtmlButton();
			break;
		case PREVIEW:
			btnPreview.replaceValues(footerId);
			PreviewElement previewElement = new PreviewElement(btnPreview);
			previewElement.clickPreviewButton();
			break;
		case ZOOM:
			btnZoom.replaceValues(toolId);
			ZoomElement zoomElement = new ZoomElement(btnZoom);
			zoomElement.clickZoomButton();
			break;
		case TOGGLESCREENMODE:
			btnTogglescreenMode.replaceValues(toolId);
			ToggleScreenModeElement toggleScreenModeElement = new ToggleScreenModeElement(
					btnZoom);
			toggleScreenModeElement.clickToggleScreenMode();
			break;
		default:
			break;
		}
	}

	/**
	 * Method helps to click the radEditor
	 * 
	 * @param VisualEditorElementsEnum
	 *            elementName
	 * @return Object
	 * @throws Exception
	 * @author soundarya
	 */
	public Object clickRadEditorElementReturnObject(
			VisualEditorElementsEnum elementName) throws Exception {
		switch (elementName) {
		case FIND_AND_REPLACE:
			btnFindAndReplace.replaceValues(toolId);
			FindAndReplaceElement find = new FindAndReplaceElement(
					btnFindAndReplace);
			return find.clickFindAndReplaceButton();
		case PASTE_PLAIN_TEXT:
			btnPastePlainText.replaceValues(toolId);
			PastePlainTextElement plaintext = new PastePlainTextElement(
					btnPastePlainText);
			return plaintext.clickPastePlainTextButton();
		case PASTE_AS_HTML:
			btnPasteAsHtml.replaceValues(toolId);
			PasteAsHtmlElement html = new PasteAsHtmlElement(btnPasteAsHtml);
			return html.clickPasteAsHtmlButton();
		case PASTE_FROM_WORD:
			btnPasteFromWord.replaceValues(toolId);
			PasteFromWordElement word = new PasteFromWordElement(
					btnPasteFromWord);
			return word.clickPasteFromWordButton();
		case EQUELLA_LINK_WIZARD_INSERT:
			btnEquellaLinkWizardInsert.replaceValues(toolId);
			EquellaLinkWizardInsertElement equella = new EquellaLinkWizardInsertElement(
					btnEquellaLinkWizardInsert);
			return equella.clickEquellaLinkWizardInsertButton();
		case LINK_WIZARD_INSERT_LINK:
			btnLinkWizardInsertLink.replaceValues(toolId);
			LinkWizardInsertLinkElement insertLink = new LinkWizardInsertLinkElement(
					btnLinkWizardInsertLink);
			return insertLink.clickLinkWizardInsertLink();
		case LINK_WIZARD_INSERT_IMAGE:
			btnLinkWizardInsertImage.replaceValues(toolId);
			LinkWizardInsertImageElement insertImage = new LinkWizardInsertImageElement(
					btnLinkWizardInsertImage);
			return insertImage.clickLinkWizardInsertImageButton();
		case MATH_EQUATION_EDITOR:
			btnMathEquationEditor.replaceValues(toolId);
			MathEquationEditorElement mathequation = new MathEquationEditorElement(
					btnMathEquationEditor);
			return mathequation.clickMathEquationEditorButton();
		case XHTML_VALIDATOR:
			btnXhtmlValidator.replaceValues(toolId);
			XhtmlValidatorElement xhtml = new XhtmlValidatorElement(
					btnXhtmlValidator);
			return xhtml.clickXhtmlValidatorButton();
		default:
			return null;
		}
	}

	/**
	 * Method helps to select a value
	 * 
	 * @author monica.anand
	 * @param VisualEditorElementsEnum
	 *            elementName
	 * @param String
	 *            valueToBeSelected
	 * @throws Exception
	 * 
	 */
	public void selectDropDownValue(VisualEditorElementsEnum elementName,
			String strValueToBeSelected) throws Exception {
		try {
			switch (elementName) {
			case FORMAT_BLOCK:
				btnFormatBlock.replaceValues(toolId);
				ParagraphStyleElement paragraphStyleElement = new ParagraphStyleElement(
						btnFormatBlock);
				paragraphStyleElement
						.selectParagraphStyle(strValueToBeSelected);
				break;
			case FONT_NAME:
				btnFontName.replaceValues(toolId);
				FontNameElement fontNameElement = new FontNameElement(
						btnFontName);
				fontNameElement.selectFontName(strValueToBeSelected);
				break;
			case FONT_SIZE:
				btnFontSize.replaceValues(toolId);
				SizeElement sizeElement = new SizeElement(btnFontSize);
				sizeElement.selectSize(strValueToBeSelected);
				break;
			case ZOOM:
				btnZoom.replaceValues(toolId);
				ZoomElement zoomElement = new ZoomElement(btnZoom);
				zoomElement.selectZoomOption(strValueToBeSelected);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			throw new Exception("UNABLE TO SELECT A VALUE IN THE DROPDOWN"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * This Method will enter Text in The RAD Editor .
	 * 
	 * @param CharSequence
	 *            ... text which you want to enter in the content.
	 * @return void
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public void enterText(CharSequence... strText) throws Exception {
		try {

			logInstruction("LOG INSTRUCTION: Entering text to RAD Editor");
			try {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement content = createElement(UIType.Xpath, "//html/body");
				content.clickAndWait(waitTime);
				content.sendKeys(strText);
			} catch (Exception e) {
				uiDriver.switchTo().defaultContent();
				uiDriver.getUIFrameLocator().selectFrame("generalBottomFrame");
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement content = createElement(UIType.Xpath, "//html/body");
				content.clickAndWait(waitTime);
				content.sendKeys(strText);
			}
		} catch (Exception e) {
			throw new Exception("UNABLE TO GET THE CONTENT FRAME OF RAD EDITOR"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This Method will Select all Text in The RAD Editor .
	 * 
	 * @return void
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public void selectAllText() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: Select All text to RAD Editor");
			frameSwitch.switchToFrameContent();
			uiDriver.getUIFrameLocator().selectFrame(frameId);
			UIElement content = createElement(UIType.Xpath, "//html/body");
			content.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		} catch (Exception e) {
			throw new Exception("UNABLE TO GET THE CONTENT FRAME OF RAD EDITOR"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This Method will enter data In visual Editor in HTML Mode
	 * 
	 * @param CharSequence
	 *            ... text text which you want to get
	 * @return void
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public void enterTextInHTMLMode(CharSequence... strText) throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			List<WebElement> ele = uiDriver.findElements(By.tagName("iframe"));
			uiDriver.switchTo().frame((WebElement) ele.get(1));
			UIElement content = createElement(UIType.Xpath,
					"//html/body/textarea");
			content.clickAndWait(1000);
			content.sendKeys(strText);
			logInstruction("LOG INSTRUCTION: ENTERED TEXT IN  VISUAL EDITOR TEXT AREA");
		} catch (Exception e) {
			throw new Exception("UNABLE TO GET THE TEXT AREA"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This Method will clear Text from The RAD Editor . *
	 * 
	 * @return void
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public void clearText() throws Exception {
		try {
			uiDriver.getUIFrameLocator().selectFrame(frameId);
			UIElement content = createElement(UIType.Xpath, "//html/body");
			content.clickNoWait();
			uiDriver.sendKeysToBrowser(Keys.chord(Keys.CONTROL, "a"));
			uiDriver.sendKeysToBrowser(Keys.BACK_SPACE);
			// content.clear();
		} catch (Exception e) {
			throw new Exception(
					"UANBLE TO CLEAR THE CONTENT FRAME OF VISUAL EDITOR \n"
							+ e.getLocalizedMessage());
		}
	}

	/**
	 * This Method will enter Question in The RAD Editor .
	 * 
	 * @return String
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public String getResponseFromVisualEditor() throws Exception {
		strResult = null;
		try {
			uiDriver.getUIFrameLocator().selectFrame(frameId);
			UIElement content = createElement(UIType.Xpath, "//html/body");
			content.clickNoWait();
			strResult = content.getText();
			logInstruction("LOG INSTRUCTION: GOT CONTENT FROM  VISUAL EDITOR");
		} catch (Exception e) {
			throw new Exception("UANBLE TO GET THE CONTENT FROM VISUAL EDITOR");
		}
		return strResult;
	}

	/**
	 * Method will check specified image is present in rad editor or not, we are
	 * verifying the image name
	 * 
	 * @author Praveen.Maled
	 * @param String
	 *            strImgName
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isImagePresentInVisualEditor(String strImgName)
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING IMAGE IS DISPLAYED IN VISUAL EDITOR");
			if (StringUtils.isNotBlank(strImgName)) {
				frameSwitch.switchToFrameContent();
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement content = createElement(UIType.Xpath, CreatedXpath);
				content.clickNoWait();
				imgRadedit.replaceValues(strImgName);
				if (imgRadedit.isDisplayedAfterWaiting(waitTime)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING IMAGE IS DISPLAYED IN VISUAL EDITOR"
							+ "\nMETHOD:isImagePresentInVisualEditor \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check if Visual Editor is selected
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isVisualEditorSelected() throws Exception {
		flag = false;
		strResult = null;
		try {
			frameSwitch.switchToFrameContent();
			strResult = isVisualEditorSelected.getAttribute("name");
			if (strResult.contains("lastSavedEditor"))
				flag = true;
		} catch (Exception e) {
			throw new Exception("UNABLE TO GET THE CURRENT SELECTED EDITOR"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will insert table in visual Editor
	 * 
	 * @param String
	 *            row number of rows you want
	 * @param String
	 *            col number of coloumns you want
	 * @return void
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public void insertTableUsingTablewizard(String strRow, String strCol)
			throws Exception {
		strResult = null;
		try {
			strResult = " " + strRow + " " + "x" + " " + strCol + " ";
			tblinsertTable.replaceValues(strResult);
			uiDriver.waitToBeDisplayed(tblinsertTable, waitTime);
			UIActions action = new DefaultUIActions(uiDriver, tblinsertTable);
			action.hoverOverAndClickOn();
			logInstruction("LOG INSTRUCTION: SELECTED ROW AND COLOUMN IN TABLE WIZARD");
		} catch (Exception e) {
			throw new Exception("NOT ABLE TO SELECT SPECIFIED ROW AND COLOUMN"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method is to check the ajax spell checker
	 * 
	 * @author ashish.juyal
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAjaxSpellCheckerIsDisplayed() throws Exception {
		flag = false;
		try {
			alertMsg = uiDriver.getUIAlert()
					.acceptAlertIfPresentAndGetMessage();
			if (alertMsg.equals("No mistakes found."))
				flag = true;
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK IF AJAX SPELL CHECKER IS DISPLAYED \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method helps to select the input symbol
	 * 
	 * @author ashish.juyal
	 * @param String
	 *            row - number of rows you want
	 * @param String
	 *            col - number of coloumns you want
	 * @return void
	 * @throws Exception
	 */
	public void insertSymbol(String strRow, String strCol) throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			btninsertsymbol.replaceValues(strRow, strCol);
			uiDriver.waitToBeDisplayed(btninsertsymbol, waitTime);
			btninsertsymbol.clickNoWait();
			logInstruction("LOG INSTRUCTION: SELECTED THE SYMBOL FROM THE INSERT SYMBOL DROPDOWN");
		} catch (Exception e) {
			throw new Exception("UNABLE TO CLICK THE INSERT SYMBOL"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This Method will check whether Table is present inside Visual Editor
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isTableDispalyedInsideRADEDitor() throws Exception {
		flag = false;
		try {
			List<WebElement> element = new ArrayList<WebElement>();
			element = uiDriver.findElements(By.tagName("iframe"));
			uiDriver.switchTo().frame(element.get(0));
			if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				UIElement ele = createElement(UIType.Xpath,
						"//html/body//table");
				if (ele.isDisplayedAfterWaiting(waitTime))
					flag = true;
			} else {
				UIElement ele = createElement(UIType.Xpath,
						"//html/body//table");
				if (ele.isDisplayedAfterWaiting(waitTime))
					flag = true;
			}
		} catch (Exception e) {
			throw new Exception("NOT ABLE TO GET THE TABLE \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check whether correct table is inserted inside Visual
	 * Editor or not
	 * 
	 * @param String
	 *            row, String col
	 * @return boolean
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isCorrectTableInserted(String strRow, String strCol)
			throws Exception {
		flag = false;
		try {
			List<UIElement> rows = new ArrayList<UIElement>();
			List<UIElement> cols = new ArrayList<UIElement>();
			frameSwitch.switchToFrameContent();
			uiDriver.getUIFrameLocator().selectFrame(frameId);
			UIElements TotalRows = createElements(UIType.Xpath,
					"//html/body/table/tbody/tr");
			UIElements TotalCols = createElements(UIType.Xpath,
					"//html/body/table/tbody/tr/td");
			rows = TotalRows.getUIElementsList();
			cols = TotalCols.getUIElementsList();
			int x = Integer.valueOf(strRow);
			int y = Integer.valueOf(strCol);
			if (rows.size() == x && ((cols.size() / x) == y)) {
				flag = true;
			}

		} catch (Exception e) {
			throw new Exception("NOT ABLE TO verify the correct TABLE \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method checks the whether the strike through is selected or not
	 * 
	 * @author ashish.juyal
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isStrikeThroughSelected() throws Exception {
		strResult = null;
		flag = false;
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(strikethough, waitTime);
			strResult = strikethough.getAttribute("class");
			if (strResult.contains("reTool reTool_selected")) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception("UNABLE TO VERIFY IF STRIKETHROUGH IS SELECTED"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method checks the design view
	 * 
	 * @author ashish.juyal
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isDesignViewDisplayed() throws Exception {
		flag = false;
		strResult = null;
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkdesignview, waitTime);
			strResult = lnkdesignview.getAttribute("class");
			if (strResult.contains("reMode_design reMode_selected")) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("UNABLE TO VERIFY THE DESIGN  VIEW"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method checks the html view is selected
	 * 
	 * @author ashish.juyal
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isHTMLViewDisplayed() throws Exception {
		flag = false;
		strResult = null;
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkdesignview, waitTime);
			strResult = lnkHTMLnview.getAttribute("class");
			if (strResult.contains("reMode_html reMode_selected")) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("UNABLE TO VERIFY THE HTML VIEW"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will get data from visual editor from HTML Mode
	 * 
	 * @return String
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public String getResponseFromTextInHTMLMode() throws Exception {
		strResult = null;
		try {
			List<WebElement> element = new ArrayList<WebElement>();
			logInstruction("LOG INSTRUCTION: WRITING TEST IN text area");
			frameSwitch.switchToFrameContent();
			element = uiDriver.findElements(By.tagName("iframe"));
			uiDriver.switchTo().frame(element.get(1));
			UIElement content = createElement(UIType.Xpath,
					"//html/body/textarea");
			strResult = content.getAttribute("value");
		} catch (Exception e) {
			throw new Exception("UNABLE TO GET THE TEXT AREA"
					+ e.getLocalizedMessage());
		}
		return strResult;
	}

	/**
	 * This method checks the preview view is selected
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isPreviewViewDisplayed() throws Exception {
		flag = false;
		strResult = null;
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkdesignview, waitTime);
			strResult = lnkPreviewnview.getAttribute("class");
			if (strResult.contains("reMode_preview reMode_selected")) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("UNABLE TO VERIFY THE PREVIEW"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method checks whether the text is striked after clicking the
	 * strikethough button
	 * 
	 * @author Suchi.Singh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isTextStriked() throws Exception {
		flag = false;
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON STRIKETHOUGH");
			uiDriver.getUIFrameLocator().selectFrame(frameId);
			if (getBrowser().equals(Browser.CHROME)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement numbered = createElement(UIType.Xpath,
						"//html/body/blockquote/div/ul/li/strike");
				uiDriver.waitToBeDisplayed(numbered, waitTime);
				if (numbered.isDisplayedAfterWaiting(waitTime)) {
					flag = true;
				}
			} else if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement numbered = createElement(UIType.Xpath, "//html/body");
				numbered.clickNoWait();
				UIElement content = createElement(UIType.Xpath, "//p/strike");
				uiDriver.waitToBeDisplayed(content, waitTime);
				if (numbered.isDisplayedAfterWaiting(waitTime)) {
					flag = true;
				}
			} else {

				UIElement content = createElement(UIType.Xpath,
						"//html/body/strike");
				strResult = content.getText().trim();

				if (!strResult.isEmpty()
						&& content.isDisplayedAfterWaiting(waitTime)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new Exception("UNABLE TO VERIFY THE TEXT STRIKED"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method checks the horizontal button is clicked or not
	 * 
	 * @author ashish.juyal
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isHorrizontalbuttonclicked() throws Exception {
		flag = false;
		try {
			uiDriver.getUIFrameLocator().selectFrame(frameId);
			if (getBrowser().equals(Browser.CHROME)) {
				UIElement numbered = createElement(UIType.Xpath,
						"//html/body/blockquote/div/ul/li/hr");
				uiDriver.waitToBeDisplayed(numbered, waitTime);
				if (numbered.isDisplayedAfterWaiting(waitTime))
					flag = true;
			} else {
				UIElement content = createElement(UIType.Xpath,
						"//html/body/hr");
				if (content.isDisplayedAfterWaiting(waitTime)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO VERIFY THE HORIZONTAL BUTTON CLICKED"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will Select all text in Visual editor in Design Mode
	 * 
	 * @return VisualEditor
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public VisualEditor selectAllTextInVisualEditor() throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.getUIFrameLocator().selectFrame(frameId);
			UIElement content = createElement(UIType.Xpath, "//html/body");
			content.clickNoWait();
			content.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		} catch (Exception e) {
			throw new Exception("NOT ABLE TO SELECT ALL TEXT IN VISUAL EDITOR"
					+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * This Method will check Whether cut functionality is working or not
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isCut() throws Exception {
		flag = false;
		strResult = null;
		try {
			if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				AutoITMethods obj = new AutoITMethods();
				obj.handleClipboardAccessPopUp("Allow");
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement content = createElement(UIType.Xpath, "//html/body");
				strResult = content.getText();
				if (strResult != null || strResult != "")
					flag = true;
			} else {
				if (alertMsg.contains("Please use Ctrl+X to Cut"))
					flag = true;
			}

		} catch (Exception e) {
			throw new Exception("NOT ABLE TO VERIFY THE CUT"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check Whether copy functionality is working or not
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isCopy() throws Exception {
		flag = false;
		strResult = null;
		try {
			if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				uiDriver.getUIAlert().acceptAlertIfPresent();
				AutoITMethods obj = new AutoITMethods();
				obj.handleClipboardAccessPopUp("Allow access");
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement content = createElement(UIType.Xpath, "//html/body");
				strResult = content.getText().trim();
				if (strResult != null || strResult != "")
					flag = true;

			} else {
				if (alertMsg.contains("Please use Ctrl+C to Copy"))
					flag = true;
			}
		} catch (Exception e) {
			throw new Exception("NOT ABLE TO VERIFY THE COPY"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check Whether Paste functionality is working or not
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isPaste() throws Exception {
		flag = false;
		strResult = null;
		try {
			if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				AutoITMethods obj = new AutoITMethods();
				obj.handleClipboardAccessPopUp("Allow access");
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement content = createElement(UIType.Xpath, "//html/body");
				strResult = content.getText().trim();
				if (strResult != null || strResult != "")
					flag = true;
			} else {

				strResult = uiDriver.getUIAlert()
						.acceptAlertIfPresentAndGetMessage(waitTime);
				if (strResult.contains("Please use Ctrl+V to Paste"))
					flag = true;
			}
		} catch (Exception e) {
			throw new Exception("not able to get the paste"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check Whether Plain text Paste functionality is working
	 * or not
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isPastePlainText() throws Exception {
		flag = false;
		strResult = null;
		try {
			uiDriver.getUIWindowLocator().switchToNewWindow();
			strResult = uiDriver.getTitle();
			if (strResult.contains("Paste Plain Text"))
				flag = true;
		} catch (Exception e) {
			throw new Exception("NOT ABLE TO VERIFY THE PLAIN TEXT PASTE"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check Whether HTML Paste functionality is working or not
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isPasteAsHTML() throws Exception {
		flag = false;
		strResult = null;
		try {
			uiDriver.getUIWindowLocator().switchToNewWindow();
			strResult = uiDriver.getTitle();
			if (strResult.contains("Paste As Html"))
				flag = true;
		} catch (Exception e) {
			throw new Exception("NOT ABLE TO GET THE HTML PASTE"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * This Method will check Whether Word Paste functionality is working or not
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isPasteAsWord() throws Exception {
		flag = false;
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR PASTE FUNCTIONALITY OF WORD ");
			uiDriver.getUIWindowLocator().switchToNewWindow();
			strResult = uiDriver.getTitle();
			if (strResult.contains("Paste from Word"))
				flag = true;
		} catch (Exception e) {
			throw new Exception("NOT ABLE TO GET THE WORD PASTE \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check whether Equella Link is working or not
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isConnectToEquella() throws Exception {
		flag = false;
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR CONNECT TO EQUELLA");
			uiDriver.getUIWindowLocator().switchToNewWindow();
			uiDriver.getUIFrameLocator().selectFrame("popupcontent");
			uiDriver.waitToBeDisplayed(isConnecttoEquella, waitTime);
			strResult = isConnecttoEquella.getText().trim();
			if (strResult.equals("Add Content from Equella"))
				flag = true;
		} catch (Exception e) {
			throw new Exception("UNABLE TO GET THE CONNECT TO EQUELLA"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify ForegroundColorButton on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isForeAndBackGroundColorListDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTURCTION : VERIFY ON FOREGROUND COLOR BUTTON.");
			uiDriver.waitToBeDisplayed(verifyForeground, waitTime);
			if (verifyForeground.isDisplayedAfterWaiting(waitTime)) {
				flag = true;
			}

		} catch (Exception e) {

			throw new Exception("UNABLE TO VERIFY ON FOREGROUNDCOLORBUTTON"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify FormatBlock on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isFormatBlockApplied() throws Exception {
		flag = false;
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON FORMATBLOCK");
			frameSwitch.switchToFrameContent();

			btnFormatBlock.replaceValues(toolId);
			uiDriver.waitToBeDisplayed(btnFormatBlock, waitTime);
			strResult = btnFormatBlock.getText();
			uiDriver.getUIFrameLocator().selectFrame(frameId);
			verifyFormatBlock.replaceValues(strResult);
			if (verifyFormatBlock.isDisplayedAfterWaiting(waitTime)) {
				flag = true;
			}

		} catch (Exception e) {

			throw new Exception("unable to verify on FormatBlock"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify FontName on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isFontNameApplied() throws Exception {
		flag = false;
		strResult = null;
		strSecondResult = null;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON FONTNAME");
			if (!getBrowser().equals(Browser.INTERNETEXPLORER)) {
				btnFontName.replaceValues(toolId);
				uiDriver.waitToBeDisplayed(btnFontName, waitTime);
				strSecondResult = btnFontName.getText();
				btnFormatBlock.replaceValues(toolId);
				uiDriver.waitToBeDisplayed(btnFormatBlock, waitTime);
				strResult = btnFormatBlock.getText();
				if (strResult.equalsIgnoreCase("normal")) {
					uiDriver.getUIFrameLocator().selectFrame(frameId);
					UIElement newpath = createElement(UIType.Xpath,
							"//html/body//font");
					if (newpath.getAttribute("face").trim()
							.equalsIgnoreCase(strSecondResult))
						flag = true;

				} else {
					uiDriver.getUIFrameLocator().selectFrame(frameId);
					verifyFormatBlock.replaceValues(strResult);
					verifyFontName.replaceValues(strResult);
					uiDriver.waitToBeDisplayed(verifyFontName, waitTime);
					if (strSecondResult.equalsIgnoreCase("Verdana")
							|| (verifyFontName.getAttribute("face").trim())
									.equalsIgnoreCase(strSecondResult)) {
						flag = true;
					}

				}
			} else {
				btnFontName.replaceValues(toolId);
				uiDriver.waitToBeDisplayed(btnFontName, waitTime);
				strSecondResult = btnFontName.getText();
				btnFormatBlock.replaceValues(toolId);
				uiDriver.waitToBeDisplayed(btnFormatBlock, waitTime);
				strResult = btnFormatBlock.getText();
				if (strResult.equalsIgnoreCase("normal")) {
					uiDriver.getUIFrameLocator().selectFrame(frameId);
					UIElement newpath = createElement(UIType.Xpath,
							"//html/body");
					newpath.clickNoWait();
					UIElement fontpath = createElement(UIType.Xpath, "//p/font");
					if (fontpath.getAttribute("face").trim()
							.equalsIgnoreCase(strSecondResult))
						flag = true;

				} else {
					uiDriver.getUIFrameLocator().selectFrame(frameId);
					verifyFormatBlock.replaceValues(strResult);
					verifyFontName.replaceValues(strResult);
					uiDriver.waitToBeDisplayed(verifyFontName, waitTime);
					if (strSecondResult.equalsIgnoreCase("Verdana")
							|| (verifyFontName.getAttribute("face").trim())
									.equalsIgnoreCase(strSecondResult)) {
						flag = true;
					}

				}

			}
		} catch (Exception e) {
			throw new Exception("unable to verify on FontName"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify FontSize on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isFontSizeApplied() throws Exception {
		flag = false;
		strResult = null;
		strSecondResult = null;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON FONTSIZE");
			if (!getBrowser().equals(Browser.INTERNETEXPLORER)) {
				btnFontSize.replaceValues(toolId);
				uiDriver.waitToBeDisplayed(btnFontSize, waitTime);
				strSecondResult = btnFontSize.getText();
				btnFormatBlock.replaceValues(toolId);
				uiDriver.waitToBeDisplayed(btnFormatBlock, waitTime);
				strResult = btnFormatBlock.getText();
				if (strResult.equalsIgnoreCase("normal")) {
					uiDriver.getUIFrameLocator().selectFrame(frameId);
					UIElement newpath = createElement(UIType.Xpath,
							"//html/body/font");
					if (newpath.getAttribute("size").trim()
							.equalsIgnoreCase(strSecondResult))
						flag = true;
				} else {
					uiDriver.getUIFrameLocator().selectFrame(frameId);
					verifyFontName.replaceValues(strResult);
					uiDriver.waitToBeDisplayed(verifyFontName, waitTime);

					if (verifyFontName.getAttribute("size").equalsIgnoreCase(
							strSecondResult))

					{
						flag = true;
					}
				}
			} else {
				if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
					btnFontSize.replaceValues(toolId);
					uiDriver.waitToBeDisplayed(btnFontSize, waitTime);
					strSecondResult = btnFontSize.getText();
					btnFormatBlock.replaceValues(toolId);
					uiDriver.waitToBeDisplayed(btnFormatBlock, waitTime);
					strResult = btnFormatBlock.getText();
					if (strResult.equalsIgnoreCase("normal")) {
						uiDriver.getUIFrameLocator().selectFrame(frameId);
						UIElement newpath = createElement(UIType.Xpath,
								"//html/body");
						newpath.clickNoWait();
						UIElement newpath1 = createElement(UIType.Xpath,
								"//p/font");
						if (newpath1.getAttribute("size").trim()
								.equalsIgnoreCase(strSecondResult))
							flag = true;
					} else {
						uiDriver.getUIFrameLocator().selectFrame(frameId);
						verifyFontName.replaceValues(strResult);
						uiDriver.waitToBeDisplayed(verifyFontName, waitTime);

						if (verifyFontName.getAttribute("size")
								.equalsIgnoreCase(strSecondResult))

						{
							flag = true;
						}
					}
				}

			}
		} catch (Exception e) {
			throw new Exception("unable to verify on FontSize"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify Bold on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isBoldApplied() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON BOLD");
			if (getBrowser().equals(Browser.CHROME)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement bold = createElement(UIType.Xpath,
						"//html/body/font/b");
				uiDriver.waitToBeDisplayed(bold, waitTime);
				if (bold.isDisplayedAfterWaiting())
					flag = true;
			} else if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement bold = createElement(UIType.Xpath, "//html/body");
				bold.clickNoWait();
				UIElement content = createElement(UIType.Xpath, "//p/strong");
				uiDriver.waitToBeDisplayed(bold, waitTime);
				if (content.isDisplayedAfterWaiting()) {
					flag = true;
				}
			} else {

				uiDriver.getUIFrameLocator().selectFrame(frameId);
				uiDriver.waitToBeDisplayed(verifyBold, waitTime);
				if (verifyBold.isDisplayedAfterWaiting(waitTime)) {
					flag = true;
				}
			}

		} catch (Exception e) {

			throw new Exception("unable to verify on Bold"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify Italic on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isItalicApplied() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON ITALIC");
			if (getBrowser().equals(Browser.CHROME)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement bold = createElement(UIType.Xpath, "//html/body//i");
				uiDriver.waitToBeDisplayed(bold, waitTime);
				if (bold.isDisplayedAfterWaiting())
					flag = true;
			} else if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement italics = createElement(UIType.Xpath, "//html/body");
				italics.clickNoWait();
				UIElement content = createElement(UIType.Xpath, "//p/strong/em");
				uiDriver.waitToBeDisplayed(italics, waitTime);
				if (content.isDisplayedAfterWaiting()) {
					flag = true;
				}
			} else {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				uiDriver.waitToBeDisplayed(verifyItalic, waitTime);
				if (verifyItalic.isDisplayedAfterWaiting(waitTime)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new Exception("unable to verify on Italic"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify Underline on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isUnderlineApplied() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON UNDERLINE");
			if (getBrowser().equals(Browser.CHROME)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement bold = createElement(UIType.Xpath, "//html/body//u");
				uiDriver.waitToBeDisplayed(bold, waitTime);
				if (bold.isDisplayedAfterWaiting(waitTime))
					flag = true;
			} else if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement italics = createElement(UIType.Xpath, "//html/body");
				italics.clickNoWait();
				UIElement content = createElement(UIType.Xpath, "//p//u");
				uiDriver.waitToBeDisplayed(italics, waitTime);
				if (content.isDisplayedAfterWaiting(waitTime)) {
					flag = true;
				}
			} else {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				uiDriver.waitToBeDisplayed(verifyUnderline, waitTime);
				if (verifyUnderline.isDisplayedAfterWaiting(waitTime))
					flag = true;
			}
		} catch (Exception e) {
			throw new Exception("unable to verify on Underline"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify AlignLeft on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAlignLeftApplied() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON ALIGNLEFT");
			if (!getBrowser().equals(Browser.INTERNETEXPLORER)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);

				uiDriver.waitToBeDisplayed(verifyAlignment, waitTime);
				if ((verifyAlignment.getAttribute("style").trim())
						.contains("text-align: left;")) {
					flag = true;
				}
			} else {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement body = createElement(UIType.Xpath, "//html/body");
				body.clickNoWait();
				UIElement content = createElement(UIType.Xpath, "//p");
				if (content.getAttribute("align").contains("left")) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new Exception("unable to verify on AlignLeft"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify AlignRight on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAlignRightApplied() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON ALOGNRIGHT");
			if (!getBrowser().equals(Browser.INTERNETEXPLORER)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				uiDriver.waitToBeDisplayed(verifyAlignment, waitTime);
				if ((verifyAlignment.getAttribute("style").trim())
						.contains("text-align: right;")) {
					flag = true;
				}
			} else {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement body = createElement(UIType.Xpath, "//html/body");
				body.clickNoWait();
				UIElement content = createElement(UIType.Xpath, "//p");
				if (content.getAttribute("align").contains("right")) {
					flag = true;
				}

			}
		} catch (Exception e) {
			throw new Exception("unable to verify on AlignRight"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify AlignCenter on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAlignCenterApplied() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON ALIGNCENTER");
			if (!getBrowser().equals(Browser.INTERNETEXPLORER)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);

				uiDriver.waitToBeDisplayed(verifyAlignment, waitTime);
				if ((verifyAlignment.getAttribute("style").trim())
						.contains("text-align: center;")) {
					flag = true;
				}
			} else {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement body = createElement(UIType.Xpath, "//html/body");
				body.clickNoWait();
				UIElement content = createElement(UIType.Xpath, "//p");
				if (content.getAttribute("align").contains("center")) {
					flag = true;
				}
			}
		} catch (Exception e) {

			throw new Exception("unable to verify on AlignCenter"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify AlignJustify on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isJustifyApplied() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON ALIGNJUSTIFY");
			if (!getBrowser().equals(Browser.INTERNETEXPLORER)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);

				uiDriver.waitToBeDisplayed(verifyAlignment, waitTime);
				if ((verifyAlignment.getAttribute("style").trim())
						.contains("text-align: justify;")) {
					flag = true;
				}
			} else {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement body = createElement(UIType.Xpath, "//html/body");
				body.clickNoWait();
				UIElement content = createElement(UIType.Xpath, "//p");
				if (content.getAttribute("align").contains("justify")) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new Exception("unable to verify on AlignJustify"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify Indent on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @param int numberOfTimesIndentIconIsclicked, String
	 *        enteredTextIntoRadEditor
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isIndentApplied(int numberOfTimesIndentIconIsclicked,
			String enteredTextIntoRadEditor) throws Exception {
		flag = false;

		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON INDENT");
			uiDriver.getUIFrameLocator().selectFrame(frameId);
			for (int i = 0; i < numberOfTimesIndentIconIsclicked; i++) {
				CreatedXpath = CreatedXpath.concat("/blockquote");
			}

			if (uiDriver.findUIElement(UIType.Xpath, CreatedXpath)
					.isDisplayedAfterWaiting(waitTime)) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("unable to verify on Indent"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify Outdent on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @param int numberOfTimesIndentIconIsclicked
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isOutdentApplied(int numberOfTimesOutdentIconIsclicked)
			throws Exception {
		flag = false;

		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON OUTDENT");
			uiDriver.getUIFrameLocator().selectFrame(frameId);
			for (int i = 0; i < numberOfTimesOutdentIconIsclicked; i++) {
				CreatedXpath = CreatedXpath.replaceFirst("/blockquote", "");
			}
			if (uiDriver.findUIElement(UIType.Xpath, CreatedXpath)
					.isDisplayedAfterWaiting(waitTime)) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("unable to verify on Outdent"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify NumberedList on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @param String
	 *            enteredTextIntoRadEditor
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isNumberedListApplied(String enteredTextIntoRadEditor)
			throws Exception {
		flag = false;

		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON NUMBEREDLIST");
			if (getBrowser().equals(Browser.CHROME)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement numbered = createElement(UIType.Xpath,
						"//html/body/blockquote/div/ol");
				uiDriver.waitToBeDisplayed(numbered, waitTime);
				if (numbered.isDisplayedAfterWaiting(waitTime))
					flag = true;
			} else if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement numbered = createElement(UIType.Xpath,
						"//html/body/ol");
				uiDriver.waitToBeDisplayed(numbered, waitTime);
				if (numbered.isDisplayedAfterWaiting(waitTime)) {
					flag = true;
				}
			} else {
				uiDriver.getUIFrameLocator().selectFrame(frameId);

				UIElement content = createElement(UIType.Xpath,
						"//html/body/ol");
				if (content.isDisplayedAfterWaiting(waitTime)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new Exception("unable to verify on NumberedList"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Method helps to verify Bullet List on RadEditor
	 * 
	 * @author Suchi.Singh
	 * @param String
	 *            enteredTextIntoRadEditor
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isBulletListApplied(String enteredTextIntoRadEditor)
			throws Exception {
		flag = false;

		try {
			logInstruction("LOG INSTRUCTION: VERIFY ON BULLET LIST ON RADEDITOR");
			if (getBrowser().equals(Browser.CHROME)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement numbered = createElement(UIType.Xpath,
						"//html/body/blockquote/div/ul");
				uiDriver.waitToBeDisplayed(numbered, waitTime);
				if (numbered.isDisplayedAfterWaiting())
					flag = true;
			} else if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement numbered = createElement(UIType.Xpath,
						"//html/body/ul");
				uiDriver.waitToBeDisplayed(numbered, waitTime);
				if (numbered.isDisplayedAfterWaiting()) {
					flag = true;
				}
			} else {
				uiDriver.getUIFrameLocator().selectFrame(frameId);
				UIElement content = createElement(UIType.Xpath,
						"//html/body/ul");

				if (content.isDisplayedAfterWaiting(waitTime)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new Exception("unable to verify on NumberedList"
					+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * This Method will verify whether Fore ground color reflected or not .
	 * 
	 * @param String
	 *            colorcode
	 * @return boolean
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isForeGroundColorReflected(String colorcode)
			throws Exception {
		flag = false;
		RGBcode = null;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER FORE GROUND COLOR  REFLECTED OR NOT.");
			uiDriver.getUIFrameLocator().selectFrame(frameId);
			UIElement contentForFireFox = createElement(UIType.Xpath,
					"//html/body//span//span");
			UIElement contentForChromeAndIE = createElement(UIType.Xpath,
					"//html/body//font");
			if (contentForFireFox.isDisplayedAfterWaiting(waitTime)) {
				RGBcode = hexToRGB(colorcode);
				if (contentForFireFox.getAttribute("style").contains(
						"color: rgb" + RGBcode)) {
					flag = true;
				}
			} else {
				if (contentForChromeAndIE.getAttribute("color").contains(
						colorcode)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER FORE GROUND COLOR  REFLECTED OR NOT."
							+ "\n METHOD : isForeGroundColorReflected \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will verify whether back ground color reflected or not .
	 * 
	 * @param String
	 *            colorcode
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isBackGroundColorReflected(String colorcode)
			throws Exception {
		flag = false;
		RGBcode = null;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER BACK GROUND COLOR  REFLECTED OR NOT."); // frameSwitch.switchToFrameContent();
			uiDriver.getUIFrameLocator().selectFrame(frameId);
			RGBcode = hexToRGB(colorcode);
			UIElement contentForFireFoxAndchrome = createElement(UIType.Xpath,
					"//html/body//span");
			UIElement contentForIE = createElement(UIType.Xpath,
					"//html/body//font");
			if (contentForFireFoxAndchrome.isDisplayedAfterWaiting(waitTime)) {
				if (contentForFireFoxAndchrome.getAttribute("style").contains(
						"background-color: rgb" + RGBcode)) {
					flag = true;
				}
			} else {
				if (contentForIE.getAttribute("style").contains(
						"background-color: rgb" + RGBcode)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER BACK GROUND COLOR  REFLECTED OR NOT."
							+ "\n METHOD : isBackGroundColorReflected \n"
							+ e.getLocalizedMessage());

		}
		return flag;
	}

	/**
	 * This Method will convert Hex code of color into RGB
	 * 
	 * @param String
	 *            colorcode
	 * @return StringBuffer
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public StringBuffer hexToRGB(String colorcode) throws Exception {
		sb = new StringBuffer();
		try {
			logInstruction("LOG INSTRUCTION: CONVERTING HEX CODE OF COLOR INTO RGB.");
			Color color = Color.decode(colorcode);
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			sb.append("(");
			sb.append(red);
			sb.append(", ");
			sb.append(green);
			sb.append(", ");
			sb.append(blue);
			sb.append(");");
			sb.toString();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CONVERTING HEX CODE OF COLOR INTO RGB."
							+ "\n METHOD : hexToRGB \n"
							+ e.getLocalizedMessage());
		}
		return sb;
	}

	/**
	 * This Method will select paragraph style /Font Name/ Font Size
	 * 
	 * @param String
	 *            style
	 * @return void
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public void selectFromDropDown(String strStyle) throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: SELECTING PARAGRAPH STYLE/ FONTNAME/ FONT SIZE.");
			Style.getUIElementByText(strStyle).clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN SELECTING PARAGRAPH STYLE/ FONTNAME/ FONT SIZE."
							+ "\n METHOD : selectFromDropDown \n"
							+ e.getLocalizedMessage());
		}

	}

	/**
	 * This Method will get ajax spell checker suggestions and it will select
	 * the first option
	 * 
	 * @return String
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public String getAjaxSpellCheckerSuggestion() throws Exception {
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING AJAX SPELL CHECKER SUGGESTIONS.");
			uiDriver.waitToBeDisplayed(spellCheckerSuggestion, waitTime);
			strResult = spellCheckerSuggestion.getText();
			spellCheckerSuggestion.clickNoWait();
			uiDriver.getUIAlert().acceptAlertIfPresent();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN GETTING AJAX SPELL CHECKER SUGGESTIONS."
							+ "\n METHOD : getAjaxSpellCheckerSuggestion \n"
							+ e.getLocalizedMessage());

		}
		return strResult;
	}

	/**
	 * This Method will click on particular symbol according to row and coloumn
	 * value
	 * 
	 * @param String
	 *            row
	 * @param String
	 *            col
	 * @return void
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public void selectSymbol(String strRow, String strCol) throws Exception {
		try {
			logInstruction("LOG INSTRCUTION :SELECTING SYMBOL");
			tblsymbol.replaceValues(strRow, strCol);
			UIActions action = new DefaultUIActions(uiDriver, tblsymbol);
			action.hoverOverAndClickOn();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO SELECT SYMBOL \n METHOD :selectSymbol");
		}
	}

	/**
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isZoomApplied() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRCUTION :CHECKING FOR ZOOM");
			if (lnkZoom.isDisplayedAfterWaiting(waitTime)) {
				flag = true;
			}

		} catch (Exception e) {
			throw new Exception("UNABLE TO GET THE ZOOM \n METHOD :isZoom");
		}
		return flag;
	}

	/**
	 * 
	 * @param String
	 *            zoomlevel
	 * @return void
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public void selectZoom(String zoomlevel) throws Exception {
		try {
			logInstruction("LOG INSTRCUTION :SELECTING  FOR ZOOM");
			selectzoom.replaceValues(zoomlevel);
			uiDriver.waitToBeDisplayed(selectzoom, waitTime);
			selectzoom.clickNoWait();
		} catch (Exception e) {
			throw new Exception("UNABLE TO GET THE DATA \n METHOD : selectZoom");
		}
	}

	/**
	 * This function will Paste plain text in RAD Editor's Plain Text
	 * functionality
	 * 
	 * @param String
	 *            text
	 * @return void
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public void pasteAsPlainText(String text) throws Exception {

		try {

			logInstruction("LOG INSTRUCTION : PASTING AS PLAIN TEXT ");
			if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				logInstruction("LOG INSTRUCTION: IE EXECUTION GETTING DATA DIRECTLY FROM RAD");
			} else {
				uiDriver.getUIWindowLocator().switchToNewWindow();
				uiDriver.waitToBeDisplayed(areapasteasplain, waitTime);
				areapasteasplain.sendKeys(text);
				uiDriver.waitToBeDisplayed(btnpaste, waitTime);
				btnpaste.clickNoWait();
				uiDriver.close();
				uiDriver.getUIWindowLocator().switchToFirstWindow();
			}

		} catch (Exception e) {
			throw new Exception(
					"NOT ABLE TO GET THE TEXT AREA \n METHOD : pasteAsPlainText");
		}
	}

	/**
	 * This function will Paste HTML text in RAD Editor's HTML Text
	 * functionality
	 * 
	 * @param String
	 *            text
	 * @return void
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public void pasteAsHTML(String text) throws Exception {
		try {
			logInstruction("LOG INSTRCUTION : PASTING HTML TEXT");
			if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				logInstruction("LOG INSTRUCTION: IE EXECUTION GETTING DATA DIRECTLY FROM RAD");
				AutoITMethods obj = new AutoITMethods();
				obj.handleClipboardAccessPopUp("Allow");
			} else {
				uiDriver.getUIWindowLocator().switchToNewWindow();
				uiDriver.waitToBeDisplayed(btninsert, waitTime);
				uiDriver.getUIFrameLocator().selectFrame("holder");
				uiDriver.waitToBeDisplayed(areatext, waitTime);
				areatext.sendKeys(text);
				uiDriver.switchTo().defaultContent();
				btninsert.clickAndWait(waitTime);
				uiDriver.getUIWindowLocator().switchToFirstWindow();
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE TEXT AREA \n METHOD :pasteAsHTML");
		}

	}

	/**
	 * This Method will check whether paste as Plain and HTML is working
	 * 
	 * @author Shishir.Dwivedi
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isPasteASHTMLandPlain() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR PASTE FUNCTIONALILTY");
			if (flag)
				return true;

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE DATA \n METHOD: isPasteASHTMLandPlain");
		}
		return false;
	}

}
