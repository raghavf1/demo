package com.pearson.eselenium.ls.coursehome.coursechecklist.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.course.pages.NextCourseHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class contains all the methods for the CourseChecklistPage professor view
 * 
 * @author ashish.juyal
 * 
 */
/**
 * @author Praveen.Maled
 * 
 */
public class CourseCheckListPage extends BasePageObject {

    /* Elements */

    private UIElement spnContentItemDuedate1 = createElement(
            UIType.Css,
            ".innercontenttable table tbody tr:nth-of-type({1}) td:nth-of-type(1)");
    private UIElement spnContentItemDuedate2 = createElement(
            UIType.Xpath,
            "//td[@class='innercontenttable']/table/tbody/tr[2]/td/span");
    private UIElement spnContentItemDuedate3 = createElement(
            UIType.Xpath,
            "//td[@class='innercontenttable']/table/tbody/tr[2]/td");
    private UIElement lnkContetnItemGoLink = createElement(
            UIType.Xpath,
            "//table/tbody/tr/td//table/tbody/tr/td[//a[contains(text(),'{1}')]]//table/tbody/tr//td/a[span[contains(.,'{2}')]]");
    private UIElement txtthreadexist = createElement(
            UIType.Xpath,
            "//td[//a[contains(text(),'{1}'')]]//tbody/tr/td/table/tbody/tr[td[contains(text(),'{2}')]]/td[2]");
    private UIElement lblTableHeading = createElement(UIType.Css, ".tablehead");
    private UIElement txttableInstruction = createElement(
            UIType.Xpath,
            "//table/tbody/tr[1]/td[contains(text(),'Course')]");
    private UIElement imgcollapseditems = createElement(
            UIType.Css,
            "[id*=collapsed].outercontenttable tbody tr td a.expandlesson img");
    private UIElement lnkcourseorUnit = createElement(
            UIType.Xpath,
            "//table[@id='courseChecklist{1}_expanded']/tbody/tr/td/table/tbody/ tr[1]/td[2]/a");
    private UIElements lstContentItemrows = createElements(
            UIType.Css,
            ".innercontenttable table tbody tr th[scope='row']");
    private UIElements lstDuedates = createElements(
            UIType.Css,
            ".innercontenttable table tbody tr th");
    private UIElements imgexporcollapseinsidetable = createElements(
            UIType.Css,
            "a.expandlesson img");
    private UIElement chklist = createElement(UIType.Css, "input[type='checkbox']");
    private UIElement imgBacklink = createElement(UIType.Css, ".back_large_double_angle");
    private UIElement spnUnitDate = createElement(
            UIType.Xpath,
            "//table[@id='courseChecklist{1}_expanded']/tbody/tr[1]/td[3]");
    private UIElement spnOldUnitDate = createElement(
            UIType.Xpath,
            "//table[@id='courseChecklist{1}_expanded']/tbody/tr[1]/td[3]/span");
    private UIElement lnkUnitContentItemGo = createElement(
            UIType.Xpath,
            "//table[@id='courseChecklist{1}_expanded']/tbody/tr[{2}]/td[4]/a[@title='Go']");
    private UIElement imgunitContentItemGolink = createElement(
            UIType.Xpath,
            "//table[@id='courseChecklist{1}_expanded']/tbody/tr[{2}]/td[4]/a[@title='Go']/img");
    private UIElement imgcourseOtemContentItemGolink = createElement(
            UIType.Xpath,
            "//table[@id='courseChecklist{1}_expanded']/tbody/tr[2]/td/table[{2}]/tbody/tr/td/a[@title='Go']/img");
    private UIElement lnkCourseItemContentItemGo = createElement(
            UIType.Xpath,
            "//table[@id='courseChecklist{1}_expanded']/tbody/tr[2]/td/table[{2}]/tbody/tr/td/a[@title='Go']");
    private UIElement txtUnitContentitemafterDuedate = createElement(
            UIType.Xpath,
            "//table[@id='courseChecklist{1}_expanded']/tbody/tr[{2}]/td[3]");
    private UIElement txtUnitContentitembeforeDuedate = createElement(
            UIType.Xpath,
            "//table[@id='courseChecklist{1}_expanded']/tbody/tr[{2}]/td[3]/span");
    private UIElement txtCourseHomeContentitemafterDuedate = createElement(
            UIType.Xpath,
            "//table[@id='courseChecklist{1}_expanded']/tbody/tr[2]/td/table[{2}]/tbody/tr/td[3]");
    private UIElement txtCourseHomeContentitembeforeDuedate = createElement(
            UIType.Xpath,
            "//table[@id='courseChecklist{1}_expanded']/tbody/tr[2]/td/table[{2}]/tbody/tr/td[3");
    private UIElements lstContentItemNumber = createElements(
            UIType.Xpath,
            "//table[@id='courseChecklist{1}_expanded']/tbody/tr/td[2]");
    private UIElement imgunitexpandicon = createElement(
            UIType.Xpath,
            "//table[@id='courseChecklist{1}_collapsed']/tbody/tr/td[1]/a/img");
    private UIElement imgunitcollapseicon = createElement(
            UIType.Xpath,
            "//table[@id='courseChecklist{1}_expanded']/tbody/tr/td[1]/a/img");
    private UIElement lnkExpandAll = createElement(UIType.ID, "courseChecklist_expandAllLink");
    private UIElement lnkCollapseAll = createElement(UIType.ID, "courseChecklist_collapseAllLink");
    private UIElement lnkCollapsedUnitGo = createElement(
            UIType.Css,
            "#courseChecklist{1}_collapsed tbody tr td img[src*=goto]");
    private UIElement lnkexpandedUnitGo = createElement(
            UIType.Css,
            "#courseChecklist{1}_expanded tbody tr td img[src*=goto]");
    private UIElement txtNavigatedUnitPageHeader = createElement(UIType.Css, ".pageTitle");
    private UIElement txtNavigatedContentItemPageHeader = createElement(
            UIType.Xpath,
            "//div[@class='pageTitle']");
    private UIElement txtNavigatedThreadItemPageHeader = createElement(
            UIType.Xpath,
            "//div[@class='pageTitle']/h1");
    private UIElement txtNavigatedUnitPageDescription = createElement(UIType.Xpath, "//html/body");
    private UIElement txtnavigatedContetnItemPageDescription = createElement(
            UIType.Xpath,
            "//html/body");
    private UIElement txtUnitThreadExist = createElement(
            UIType.Xpath,
            "//td[//a[contains(.,'{1}')]]//tbody/tr[td[contains(.,'{2}')]]/td[2]");
    private UIElement lnkUnit = createElement(UIType.Xpath, "//a[contains(text(),'Unit')]");

    private UIElement lblCourseChecklistPageTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement lnkBack = createElement(UIType.Css, "div a[title=back]");
    private UIElement lnkdueDate = createElement(UIType.Css, "a[title='Due Date']");
    private UIElement lblCheckListHeading = createElement(UIType.Css, ".pageTitle");
    private UIElement tblCourseCheckListPage = createElement(UIType.Css, ".outercontenttable");
    private UIElement imgExpandAllcourseCheckList = createElement(
            UIType.Css,
            "#courseChecklist{1}_expanded tbody tr td img[src*=goto]");
    private UIElement imgCollapseCourseCheckList = createElement(
            UIType.Css,
            "#courseChecklist_collapseAllLink>img");
    private UIElement lblSortByDisplayed = createElement(
            UIType.Xpath,
            "//table[@class='outercontenttable']//table//tr/td[@align='{1}']");
    private UIElements lstunitNumber = createElements(
            UIType.Xpath,
            "//table[@id[contains(.,'expanded')]]//a[@aria-level='3']");
    private UIElement txtCoursedutedate = createElement(
            UIType.Xpath,
            "//table[@id='courseChecklist0_expanded']//table[tbody//tr[td[contains(.,'{1}')]]]//td[3]");

    String dateFormat = "MM/dd/yyyy hh:mm a";
    private static final String strCourseHome = "course home";
    private static final String CLASS_ATTRIBUTE = "class";
    private static final String REDTEXT_VALUE = "redtext";
    ArrayList<String> arlContentItems = new ArrayList<String>();
    ArrayList<String> arlAllUnits = new ArrayList<String>();
    ArrayList<Integer> arlNumbers = new ArrayList<Integer>();
    List<UIElement> arlUnitNames = new ArrayList<UIElement>();
    ArrayList<Integer> arlListRowNumber = new ArrayList<Integer>();
    List<UIElement> lstUnitNames = new ArrayList<UIElement>();
    ArrayList<String> lstUnits = new ArrayList<String>();
    ArrayList<Integer> arlRowNumber = new ArrayList<Integer>();
    ArrayList<Integer> arlRowNumberFirstRow = new ArrayList<Integer>();
    ArrayList<Integer> arlRowNumberSecondRow = new ArrayList<Integer>();
    ArrayList<Integer> arlRowNumberThirdRow = new ArrayList<Integer>();
    ArrayList<String> arlListContetnItems = new ArrayList<String>();
    List<UIElement> lstContentItemNames = new ArrayList<UIElement>();
    List<UIElement> lstContentItemRows = new ArrayList<UIElement>();
    List<UIElement> lstDueDates = new ArrayList<UIElement>();
    List<UIElement> lstContentItemNamesList = new ArrayList<UIElement>();
    List<UIElement> lstUnitNamesList = new ArrayList<UIElement>();
    private boolean flag = false;
    private String strResult = null;
    int intUnitNumber = -1;
    int intContentItemNumber = -1;
    int intNumber = 0;

    /* Constructor */
    public CourseCheckListPage(UIDriver uidriver) {
        super(uidriver);
        pageTitle = "CourseCheckListPage";
        logInstruction("LOG INSTRUCTION: ## Course Check List Page ##");
    }

    /**
     * This method checks whether the specified thread is available or not,it return the boolean
     * value
     * 
     * @param String
     *            - strUnitName, strNameOfThread
     * @author ashish.juyal
     * @return boolean
     * @throws Exception
     */
    public boolean isThreadDisplayed(String strUnitName, String strNameOfThread) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING THE THREAD '" + strNameOfThread + "' IS PRESENT OR NOT");
            frameSwitch.switchToFrameContent();
            if (StringUtils.isNotBlank(strUnitName) && StringUtils.isNotBlank(strNameOfThread)) {
                if (strCourseHome.equalsIgnoreCase(strUnitName)) {
                    txtthreadexist.replaceValues(strUnitName, strNameOfThread);
                    flag = txtthreadexist.isDisplayedAfterWaiting(waitTime);
                } else {
                    txtUnitThreadExist.replaceValues(strUnitName, strNameOfThread);
                    flag = txtUnitThreadExist.isDisplayedAfterWaiting(waitTime);
                }
            } else
                throw new Exception(
                        "EITHER 'UnitName' OR 'ThreadName' is NULL \nMETHOD:isThreadDisplayed \n");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CHECKING THE THREAD '" + strNameOfThread + "' IS PRESENT OR NOT" + "\nMETHOD:isThreadDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method checks whether the 'Course Checklist' page is displayed or not
     * 
     * @author ashish.juyal
     * @return boolean
     * @throws Exception
     */
    public boolean isCourseCheckListPageDisplayed(String strCheckListHeader) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING IS 'Course Checklist' PAGE DISPLAYED");
            if (StringUtils.isNotBlank(strCheckListHeader)) {
                frameSwitch.switchToFrameContent();
                lblCourseChecklistPageTitle.isDisplayedAfterWaiting(waitTime);
                if (StringUtils.isNotBlank(lblCourseChecklistPageTitle.getText().trim())) {
                    flag = strCheckListHeader.equalsIgnoreCase(lblCourseChecklistPageTitle
                            .getText().trim());
                } else {
                    throw new Exception(
                            "UNABLE TO GET 'Course Checklist' FROM PAGE \nMETHOD:isCourseCheckListPageDisplayed \n");
                }
            } else
                throw new Exception(
                        "PROVIDED 'Course Checklist' HEADER IS NULL \nMETHOD:isCourseCheckListPageDisplayed \n");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING IS 'Course Checklist' PAGE DISPLAYED" + "\nMETHOD:isCourseCheckListPageDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method clicks the 'Back' Link on Course Checklist page
     * 
     * @author Sumanth
     * @return NextCourseHomePage
     * @throws Exception
     */
    public NextCourseHomePage clickBackLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON THE 'Back' LINK");
            frameSwitch.switchToFrameContent();
            lnkBack.isDisplayedAfterWaiting(waitTime);
            lnkBack.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON THE 'Back' LINK" + "\nMETHOD:clickBackLink \n" + e
                            .getLocalizedMessage());
        }
        return new NextCourseHomePage(uiDriver);
    }

    /**
     * This method clicks on the 'Go' link for specified unit and content item
     * 
     * @param String
     *            strUnitName
     * @param String
     *            strNameOfThread
     * @throws Exception
     * @author ashish.juyal
     */
    public void clickGoLink(String strUnitName, String strNameOfThread) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Go' LINK");
            frameSwitch.switchToFrameContent();
            lnkContetnItemGoLink.replaceValues(strUnitName, strNameOfThread);
            lnkContetnItemGoLink.isDisplayedAfterWaiting(waitTime);
            lnkContetnItemGoLink.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING ON 'Go' LINK" + "\nMETHOD:clickGoLink \n" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * This method clicks the 'DueDate' link
     * 
     * @return CourseCheckListPage
     * @author ashish.juyal
     * @throws Exception
     */

    public CourseCheckListPage clickDueDateLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON THE 'DueDate' LINK");
            frameSwitch.switchToFrameContent();
            lnkdueDate.isDisplayedAfterWaiting(waitTime);
            lnkdueDate.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON THE 'DueDate' LINK" + "\nMETHOD:clickDueDateLink \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method gets the course check list page heading
     * 
     * @return String
     * @author hemant.kumar
     * @throws Exception
     */
    public String getPageHeading() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Course Checklist' PAGE HEADER");
            frameSwitch.switchToFrameContent();
            lblCheckListHeading.isDisplayedAfterWaiting(waitTime);
            strResult = lblCheckListHeading.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'Course Checklist' PAGE HEADER" + "\nMETHOD:getPageHeading \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method verifies whether the table is available on course check list page or not,returns
     * the boolean function
     * 
     * @return boolean
     * @author hemant.kumar
     * @throws Exception
     */
    public boolean isTableDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING IS 'Course Checklist' TABLE DISPLAYED");
            frameSwitch.switchToFrameContent();
            flag = tblCourseCheckListPage.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING IS 'Course Checklist' TABLE DISPLAYED" + "\nMETHOD:isTableDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method verifies whether the expand and collapse button is available or not,returns the
     * boolean function
     * 
     * @return boolean
     * @author hemant.kumar
     * @throws Exception
     * @Edited code is not working hence changed--Praveen
     */
    public boolean isExpandCollapseButton() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING THE 'Expand and Collapse' IMAGE");
            frameSwitch.switchToFrameContent();
            if (imgExpandAllcourseCheckList.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            } else {
                flag = imgCollapseCourseCheckList.isDisplayedAfterWaiting(waitTime);
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Expand and Collapse' IMAGE" + "\nMETHOD:isExpandCollapseButton \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method checks the String sortBy,New Unit and Due Date is displayed or not
     * 
     * @param String
     *            - strAllignement, strTextToBeDisplayed
     * @return boolean
     * @author ashish.juyal
     * @throws Exception
     */
    public boolean isStringDisplayed(String strAllignement, String strTextToBeDisplayed)
            throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING FOR IS '" + strTextToBeDisplayed + "' DISPLAYED");
            if (StringUtils.isNotBlank(strAllignement) && StringUtils
                    .isNotBlank(strTextToBeDisplayed)) {
                frameSwitch.switchToFrameContent();
                lblSortByDisplayed.replaceValues(strAllignement);
                lblSortByDisplayed.isDisplayedAfterWaiting(waitTime);
                if (StringUtils.isNotBlank(lblSortByDisplayed.getText().trim())) {
                    if (lblSortByDisplayed.getText().trim().contains(strTextToBeDisplayed)) {
                        flag = true;
                    } else {
                        throw new Exception("'Text' IS NOT MATCHED \nMETHOD:isStringDisplayed \n");
                    }
                } else {
                    throw new Exception("'Text' PROVIDED IS NULL \nMETHOD:isStringDisplayed \n");
                }
            } else
                throw new Exception(
                        "EITHER 'Allignment' OR 'Text' PROVIDED IS NULL \nMETHOD:isStringDisplayed \n");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING FOR IS '" + strTextToBeDisplayed + "' DISPLAYED" + "\nMETHOD:isStringDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will cross verify the due date of content item with duedate aded in Edit Schedule user
     * has to provide date in mm/dd/yyyy
     * 
     * @author Praveen.Maled
     * @param strThreadName
     * @param strDueDate
     * @return boolean
     * @throws Exception
     */
    public boolean isContetntItemDueDatecorrect(String strThreadName, String strDueDate)
            throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING CONTETNTITEM 'DueDate'");

            frameSwitch.switchToFrameContent();
            lstContentItemRows = lstContentItemrows.getUIElementsList();
            intNumber = 1;
            for (UIElement contentItem : lstContentItemRows) {
                intNumber++;
                if (contentItem.getText().contains(strThreadName)) {
                    spnContentItemDuedate1.replaceValues(String.valueOf(intNumber));

                    if (spnContentItemDuedate1.getText() == null) {
                        spnContentItemDuedate2.replaceValues(String.valueOf(intNumber));
                    }
                    if (spnContentItemDuedate2.getText().contains(strDueDate))
                        flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING CONTETNTITEM 'DueDate'" + "\nMETHOD:isContetntItemDueDatecorrect \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify the due dates are arranged in ascending order or not inside 'DueDate' Link
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDatesinAscendingOrder() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING ARE 'DueDates' IN ASCENDING ORDER");
            frameSwitch.switchToFrameContent();

            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            Date preavDate = sdf.parse("00/0/0000 00:00 PM");
            Date curDate;

            lstDueDates = lstDuedates.getUIElementsList();
            for (int i = 2; i < lstDueDates.size() - 1; i++) {
                spnContentItemDuedate3.replaceValues(String.valueOf(i));

                if (null == spnContentItemDuedate3.getText()) {
                    spnContentItemDuedate2.replaceValues(String.valueOf(i));
                    curDate = sdf.parse(spnContentItemDuedate2.getText().trim());
                } else {
                    curDate = sdf.parse(spnContentItemDuedate3.getText().trim());
                }

                if (curDate.compareTo(preavDate) >= 0) {
                    preavDate = curDate;
                } else {
                    break;
                }
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING ARE 'DueDates' IN ASCENDING ORDER" + "\nMETHOD:isDueDatesinAscendingOrder \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify expand or collapse icon is present
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isExpandorCollapseExistinsideTable() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING IS 'Expand or Collapse Image' EXIST INSIDE TABLE");
            flag = imgexporcollapseinsidetable.areAllPresent();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING IS 'Expand or Collapse Image' EXIST INSIDE TABLE" + "\nMETHOD:isExpandorCollapseExistinsideTable \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify whether 'Checkbox' is present or not in the CheckListPage
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isCheckBoxExist() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Checkbox' IS PRESENT IN THE PAGE OR NOT");
            frameSwitch.switchToFrameContent();
            flag = chklist.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Checkbox'" + "\nMETHOD:isCheckBoxExist \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify the table heading displayed correct or not
     * 
     * @author Praveen.Maled
     * @param strTableHeader
     * @return boolean
     * @throws Exception
     */
    public boolean isTableHeaderExist(String strTableHeader) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Table Heading'");
            lblTableHeading.isDisplayedAfterWaiting(waitTime);
            flag = strTableHeader.equalsIgnoreCase(lblTableHeading.getText().trim());
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'Table Heading'" + "\nMETHOD:isTableHeaderExist \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will get the instructional text inside Course Checklist table
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     */
    public String getTableInstructionalText() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Course Checklist' TABLE INSTRUCTIONAL TEXT");
            txttableInstruction.isDisplayedAfterWaiting(waitTime);
            strResult = txttableInstruction.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'Course Checklist' TABLE INSTRUCTIONAL TEXT" + "\nMETHOD:getTableInstructionalText \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will verify the unit name link is present inside the table or not on specified row
     * number
     * 
     * @author Praveen.Maled
     * @param intRowNo
     * @param strUnitName
     * @return boolean
     * @throws Exception
     */

    public boolean isCourseHomeorUnitLinkExist(int intRowNo, String strUnitName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Course Home' LINK IS EXIST ARE NOT");
            lnkcourseorUnit.replaceValues(String.valueOf((intRowNo - 1)));
            lnkcourseorUnit.isDisplayedAfterWaiting(waitTime);
            if (StringUtils.isNotBlank(strUnitName)) {
                if (strUnitName.trim().equalsIgnoreCase(lnkcourseorUnit.getText().trim()))
                    flag = true;
            } else {
                throw new Exception(
                        "UNIT NAME IS NULL IN 'Course Home' LINK " + "\nMETHOD:isCourseHomeorUnitLinkExist \n");
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'Course Home' LINK " + "\nMETHOD:isCourseHomeorUnitLinkExist \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify that all the sections are expanded are not in course check list page
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isAllSectionsExpanded() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'All Sections' ARE EXPANDED OR NOT");
            imgCollapseCourseCheckList.isDisplayedAfterWaiting(waitTime);
            if (imgCollapseCourseCheckList.isDisplayedAfterWaiting() && !imgcollapseditems
                    .isDisplayedAfterWaiting()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'All Sections'" + "\nMETHOD:isAllSectionsExpanded \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will check Due date is exist for particular unit are not
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return boolean
     * @throws Exception
     */
    public boolean isUnitDuedateExist(String strUnitName) throws Exception {
        flag = false;
        intNumber = 0;
        try {

            logInstruction("LOG INSTRUCTION: VERIFYING 'Duedate' EXIST FOR SPECIFIED UNIT OR NOT");
            intNumber = getunitNumber(strUnitName);
            spnUnitDate.replaceValues(String.valueOf(intNumber));
            spnUnitDate.isDisplayedAfterWaiting(waitTime);
            if (spnUnitDate.isDisplayedAfterWaiting() && spnUnitDate.getText().contains("/")) {
                flag = true;
            } else {
                spnOldUnitDate.replaceValues(String.valueOf(intNumber));
                spnOldUnitDate.isDisplayedAfterWaiting(waitTime);
                if (spnOldUnitDate.isDisplayedAfterWaiting() && spnOldUnitDate.getText().contains(
                        "/")) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'Duedate' FOR UNIT" + "\nMETHOD:isUnitDuedateExist \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will return the due date of specified unit in the form of String
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return String
     * @throws Exception
     */
    public String getUnitDueDate(String strUnitName) throws Exception {
        strResult = null;
        intNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: GETTING  'Duedate' FOR A  UNIT");
            intNumber = getunitNumber(strUnitName);
            spnUnitDate.replaceValues(String.valueOf(intNumber));
            spnUnitDate.isDisplayedAfterWaiting(waitTime);
            if (spnUnitDate.isDisplayedAfterWaiting() && spnUnitDate.getText().contains("/")) {
                strResult = spnUnitDate.getText();

            } else {
                spnOldUnitDate.replaceValues(String.valueOf(intNumber));
                spnOldUnitDate.isDisplayedAfterWaiting(waitTime);
                if (spnOldUnitDate.isDisplayedAfterWaiting() && spnOldUnitDate.getText().contains(
                        "/")) {
                    strResult = spnOldUnitDate.getText();
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING  'Duedate' FOR A  UNIT" + "\nMETHOD:getUnitDueDate \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will check the due date color for the unit is red or not
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return boolean
     * @throws Exception
     */
    public boolean isunitDuedatecolorchanged(String strUnitName) throws Exception {
        flag = false;
        intNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'DueDate Color' IS RED OR NOT");
            intNumber = getunitNumber(strUnitName);
            spnUnitDate.replaceValues(String.valueOf(intNumber));
            spnOldUnitDate.replaceValues(String.valueOf(intNumber));
            spnUnitDate.isDisplayedAfterWaiting(waitTime);
            if (spnUnitDate.getAttribute(CLASS_ATTRIBUTE).contains(REDTEXT_VALUE)) {
                flag = true;
            } else
                if (spnOldUnitDate.isPresent()) {
                    if (spnOldUnitDate.getAttribute(CLASS_ATTRIBUTE).contains(REDTEXT_VALUE)) {
                        flag = true;
                    }
                }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'DueDate Color' " + "\nMETHOD:isunitDuedatecolorchanged \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * method will return the unit row number in table based on unit name
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return int
     * @throws Exception
     * 
     * @Edited for IE we are getting some html in the unit's list hence added check to get correct
     *         unit number-- Praveen
     */
    public int getunitNumber(String strUnitName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Unit row number' IN THE COURSE CHECKLIST PAGE ");
            frameSwitch.switchToFrameContent();
            lstUnitNames = lstunitNumber.getUIElementsList();
            for (UIElement name : lstUnitNames) {
                intUnitNumber++;
                if (name.getText().contains(strUnitName)) {
                    if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
                        return intUnitNumber / 2;
                    } else {
                        return intUnitNumber;
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'Unit row number'" + "\nMETHOD:getunitNumber \n" + e
                            .getLocalizedMessage());
        }
        return intUnitNumber;
    }

    /**
     * method will return the content item number row inside the unit
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @param strContentItem
     * @return ArrayList<Integer>
     * @throws Exception
     */
    public ArrayList<Integer> getProfContetntItemrowNumber(String strUnitName, String strContentItem)
            throws Exception {
        intNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Content item row number' INSIDE UNIT");
            intNumber = getunitNumber(strUnitName);
            arlNumbers.add(intNumber);
            lstContentItemNumber.replaceValues(String.valueOf(intNumber));
            lstContentItemNamesList = lstContentItemNumber.getUIElementsList();
            for (UIElement number : lstContentItemNamesList) {
                intContentItemNumber++;
                if (number.getText().contains(strContentItem)) {
                    arlNumbers.add(intContentItemNumber);
                    return arlNumbers;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'Content item row number'" + "\nMETHOD:getProfContetntItemrowNumber \n" + e
                            .getLocalizedMessage());
        }
        return arlNumbers;
    }

    /**
     * method will verify whether 'Go' link for mentioned content item is exist or not
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @param strContenItem
     * @return boolean
     * @throws Exception
     */
    public boolean iscontentItemGolinkExist(String strUnitName, String strContenItem)
            throws Exception {
        flag = false;
        intUnitNumber = 0;
        intContentItemNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Go' LINK IS PRESENT FOR CONTENT ITEM OR NOT");
            arlListRowNumber = getProfContetntItemrowNumber(strUnitName, strContenItem);
            intUnitNumber = arlListRowNumber.get(0);
            intContentItemNumber = arlListRowNumber.get(1);
            if (intUnitNumber == 0) {
                lnkCourseItemContentItemGo.replaceValues(String.valueOf(intUnitNumber), String
                        .valueOf(intContentItemNumber));
                lnkCourseItemContentItemGo.isDisplayedAfterWaiting(waitTime);
                if (lnkCourseItemContentItemGo.isPresent()) {
                    flag = true;
                }
            } else {
                intContentItemNumber = intContentItemNumber + 2;
                lnkUnitContentItemGo.replaceValues(String.valueOf(intUnitNumber), String
                        .valueOf(intContentItemNumber));
                lnkUnitContentItemGo.isDisplayedAfterWaiting(waitTime);
                if (lnkUnitContentItemGo.isPresent()) {
                    flag = true;
                }
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'Go' LINK IS PRESENT FOR CONTENT ITEM" + "\nMETHOD:iscontentItemGolinkExist \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify whether 'Go' link image is exist for specific content item
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @param strContenItem
     * @return boolean
     * @throws Exception
     */
    public boolean iscontentItemGolinkImageExist(String strUnitName, String strContenItem)
            throws Exception {
        flag = false;
        intUnitNumber = 0;
        intContentItemNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Go' LINK IMAGE IS PRESENT FOR CONTENT ITEM OR NOT");
            arlRowNumber = getProfContetntItemrowNumber(strUnitName, strContenItem);

            intUnitNumber = arlRowNumber.get(0);
            intContentItemNumber = arlRowNumber.get(1);
            if (intUnitNumber == 0) {
                imgcourseOtemContentItemGolink.replaceValues(String.valueOf(intUnitNumber), String
                        .valueOf(intContentItemNumber));
                imgcourseOtemContentItemGolink.isDisplayedAfterWaiting(waitTime);
                if (imgcourseOtemContentItemGolink.isPresent()) {
                    flag = true;
                }
            } else {
                intContentItemNumber = intContentItemNumber + 2;
                imgunitContentItemGolink.replaceValues(String.valueOf(intUnitNumber), String
                        .valueOf(intContentItemNumber));
                imgunitContentItemGolink.isDisplayedAfterWaiting(waitTime);
                if (imgunitContentItemGolink.isPresent()) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'Go' LINK IMAGE" + "\nMETHOD:iscontentItemGolinkImageExist \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method to get all the content items inside the specified unitName
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return ArrayList<String>
     * @throws Exception
     */
    public ArrayList<String> getContentItemsofUnit(String strUnitName) throws Exception {
        intNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Contentitems' INSIDE THE UNIT");
            intNumber = getunitNumber(strUnitName);
            lstContentItemNumber.replaceValues(String.valueOf(intNumber));
            lstContentItemNames = lstContentItemNumber.getUIElementsList();
            for (int i = 1; i < lstContentItemNames.size(); i++) {
                arlContentItems.add(lstContentItemNames.get(i).getText());
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'Contentitems' INSIDE THE UNIT" + "\nMETHOD:getContentItemsofUnit \n" + e
                            .getLocalizedMessage());
        }
        return arlContentItems;
    }

    /**
     * Method will click on unit link top of right side next to Sort By text
     * 
     * @author Praveen.Maled
     * @return CourseCheckListPage
     * @throws Exception
     */
    public CourseCheckListPage clickonUnitLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON THE 'Unit' LINK");
            frameSwitch.switchToFrameContent();
            lnkUnit.isDisplayedAfterWaiting(waitTime);
            lnkUnit.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON THE 'Unit' LINK" + "\nMETHOD:clickonUnitLink \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * method will return the complete unit caption for specified unit shown in the
     * coursechecklistpage page
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return String
     * @throws Exception
     */
    public String geCompletUnitCaption(String strUnitName) throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'complete unit name' SHOWN IN THE COURSECHECKLIST PAGE");
            lstUnitNamesList = lstunitNumber.getUIElementsList();
            for (UIElement unit : lstUnitNamesList) {
                if (unit.getText().contains(strUnitName)) {
                    strResult = unit.getText().trim();
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'complete unit name'" + "\nMETHOD:geCompletUnitCaption \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will verify The page is displayed or not after clicking on DueDate link
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isDuedateLinkDataDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Duedate link data' IS DISPLAYED OR NOT");
            imgExpandAllcourseCheckList.isDisplayedAfterWaiting(waitTime);
            flag = imgExpandAllcourseCheckList.isPresent();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'Duedate link data' IS DISPLAYED" + "\nMETHOD:isDuedateLinkDataDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method will on expand icon of the specified unit if its not expanded
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return CourseCheckListPage
     * @throws Exception
     */
    public CourseCheckListPage clickonExapanduniticon(String strUnitName) throws Exception {
        intNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Expand icon of unit'");
            intNumber = getunitNumber(strUnitName);
            imgunitexpandicon.replaceValues(String.valueOf(intNumber));
            frameSwitch.switchToFrameContent();
            imgunitexpandicon.isDisplayedAfterWaiting(waitTime);
            if (imgunitexpandicon.isPresent()) {
                imgunitexpandicon.clickAndWait(waitTime);
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Expand icon of unit'" + "\nMETHOD:clickonExapanduniticon\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method will click on collapse icon of specified unit if its expanded
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return CourseCheckListPage
     * @throws Exception
     */
    public CourseCheckListPage clickonCollapseuniticon(String strUnitName) throws Exception {
        intNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Collapse icon of unit'");
            intNumber = getunitNumber(strUnitName);
            imgunitcollapseicon.replaceValues(String.valueOf(intNumber));
            if (imgunitcollapseicon.isDisplayedAfterWaiting()) {
                imgunitcollapseicon.clickAndWait(waitTime);
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Collapse icon of unit'" + "\nMETHOD:clickonCollapseuniticon\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method will check ExpandAll link is showing in page or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isExpandAllLinkExist() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'ExpandAll' LINK");
            flag = lnkExpandAll.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'ExpandAll' LINK" + "\nMETHOD:isExpandAllLinkExist \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will check CollapseAll link is showing in page or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isCollapseAllLinkExist() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'CollapseAll' LINK");
            flag = lnkCollapseAll.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'CollapseAll' LINK" + "\nMETHOD:isCollapseAllLinkExist \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will click ExpandAll link
     * 
     * @author Praveen.Maled
     * @return CourseCheckListPage
     * @throws Exception
     */
    public CourseCheckListPage clickExpandAllLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING 'ExpandAll' LINK");
            lnkExpandAll.isDisplayedAfterWaiting(waitTime);
            if (lnkExpandAll.isDisplayedAfterWaiting()) {
                lnkExpandAll.clickAndWait(waitTime);
            } else
                logInstruction("LOG INSTRUCTION: ALREADY EXPANDED");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'ExpandAll' LINK" + "\nMETHOD:clickExpandAllLink \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method will click on COllapseAll link showing in page
     * 
     * @author Praveen.Maled
     * @return CourseCheckListPage
     * @throws Exception
     */
    public CourseCheckListPage clickCollapseAllLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING 'CollapseAll' LINK");
            lnkCollapseAll.isDisplayedAfterWaiting(waitTime);
            if (lnkCollapseAll.isDisplayedAfterWaiting()) {
                lnkCollapseAll.clickAndWait(waitTime);
            } else
                logInstruction("LOG INSTRUCTION: ALREADY COLLAPSED");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'CollapseAll' LINK" + "\nMETHOD:clickCollapseAllLink \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method will click on the Go link of specified unit, return type is void as navigated page
     * varied from one to another
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @throws Exception
     */
    public void clickonUnitGoLink(String strUnitName) throws Exception {
        intNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Go' LINK OF A UNIT");
            intNumber = getunitNumber(strUnitName);
            lnkexpandedUnitGo.replaceValues(String.valueOf(intNumber));
            lnkCollapsedUnitGo.replaceValues(String.valueOf(intNumber));
            if (lnkexpandedUnitGo.isDisplayedAfterWaiting()) {
                lnkexpandedUnitGo.clickAndWait(waitTime);
            } else
                if (lnkCollapsedUnitGo.isDisplayedAfterWaiting()) {
                    lnkCollapsedUnitGo.clickAndWait(waitTime);
                }
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING ON 'Go' LINK OF A UNIT" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * Method will return the Navigated unit page title
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     */
    public String getNavigatedUnitPageHeader() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'navigated unit page header' AFTER CLICKING ON UNIT GOLINK");
            txtNavigatedUnitPageHeader.isDisplayedAfterWaiting(waitTime);
            if (txtNavigatedUnitPageHeader.isDisplayedAfterWaiting()) {
                strResult = txtNavigatedUnitPageHeader.getText().trim();
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'navigated page title'" + "\nMETHOD:getNavigatedUnitPageHeader \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will get the navigated content item page title
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     */
    public String getNavigatedContentItemPageHeader() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'navigated content page header' AFTERCLICKING ON CONTENTITEM GOLINK");
            frameSwitch.switchToFrameContent();
            if (txtNavigatedContentItemPageHeader.isDisplayedAfterWaiting()) {
                strResult = txtNavigatedContentItemPageHeader.getText().trim();
            } else
                if (txtNavigatedThreadItemPageHeader.isDisplayedAfterWaiting()) {
                    strResult = txtNavigatedThreadItemPageHeader.getText().trim();
                }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'navigated content page header'" + "\nMETHOD:getNavigatedContentItemPageHeader \n" + e
                            .getLocalizedMessage());
        }
        return strResult;

    }

    /**
     * Method will check unit page description is exist
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isUnitDescriptionExistinNavigatedPage() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING IS 'unit page description' DISPLAYED");
            flag = txtNavigatedUnitPageDescription.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING IS 'unit page description' DISPLAYED" + "\nMETHOD:isUnitDescriptionExistinNavigatedPage \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * method will return the unit page description in text format
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     */
    public String getNavigatedUnitPageDescription() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Navigatedunit page description'");
            txtNavigatedUnitPageDescription.isDisplayedAfterWaiting(waitTime);
            if (StringUtils.isNotBlank(txtNavigatedUnitPageDescription.getText())) {
                strResult = txtNavigatedUnitPageDescription.getText().substring(
                        txtNavigatedUnitPageDescription.getText().indexOf("\n")).trim();
            } else {
                throw new Exception(
                        "ISSUE IN GETTING 'Navigatedunit page description' IT MIGHT BE NULL \nMETHOD:getNavigatedUnitPageDescription \n");
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'Navigatedunit page description'" + "\nMETHOD:getNavigatedUnitPageDescription \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * method will return the content item page description in text format
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     */
    public String getNavigatedContentItemPageDescription() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Navigatedunit content item page description'");
            frameSwitch.switchToFrameContent();
            if (StringUtils.isNotBlank(txtnavigatedContetnItemPageDescription.getText())) {
                strResult = txtnavigatedContetnItemPageDescription.getText().substring(
                        txtnavigatedContetnItemPageDescription.getText().indexOf("\n")).trim();
            } else {
                throw new Exception(
                        "ISSUE IN GETTING 'Navigatedunit content item page description' IT MIGHT BE NULL \nMETHOD:getNavigatedContentItemPageDescription \n");
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'Navigatedunit content item page description'" + "\nMETHOD:getNavigatedContentItemPageDescription \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will check content item due date is exist for specified unit and content item
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @param strContentItem
     * @return boolean
     * @throws Exception
     */
    public boolean isContentItemDuedateExist(String strUnitName, String strContentItem)
            throws Exception {
        flag = false;
        intUnitNumber = 0;
        intContentItemNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'contentItem Duedate' IS EXISTS");
            arlRowNumberFirstRow = getProfContetntItemrowNumber(strUnitName, strContentItem);
            intUnitNumber = arlRowNumberFirstRow.get(0);
            intContentItemNumber = arlRowNumberFirstRow.get(1);
            if (intUnitNumber == 0) {
                txtCourseHomeContentitembeforeDuedate.replaceValues(
                        String.valueOf(intUnitNumber),
                        String.valueOf(intContentItemNumber));
                txtCourseHomeContentitemafterDuedate.replaceValues(
                        String.valueOf(intUnitNumber),
                        String.valueOf(intContentItemNumber));
                txtCourseHomeContentitembeforeDuedate.isDisplayedAfterWaiting(waitTime);
                if (txtCourseHomeContentitembeforeDuedate.isPresent() && txtCourseHomeContentitembeforeDuedate
                        .getText().contains("/")) {
                    flag = true;
                } else
                    if (txtCourseHomeContentitemafterDuedate.isDisplayedAfterWaiting() && txtCourseHomeContentitemafterDuedate
                            .getText().contains("/")) {
                        flag = true;
                    }
            } else {
                intContentItemNumber = intContentItemNumber + 2;
                txtUnitContentitembeforeDuedate.replaceValues(String.valueOf(intUnitNumber), String
                        .valueOf(intContentItemNumber));
                txtUnitContentitemafterDuedate.replaceValues(String.valueOf(intUnitNumber), String
                        .valueOf(intContentItemNumber));
                if (txtUnitContentitembeforeDuedate.isPresent() && txtUnitContentitembeforeDuedate
                        .getText().contains("/")) {
                    flag = true;
                } else
                    if (txtUnitContentitemafterDuedate.isDisplayedAfterWaiting() && txtUnitContentitemafterDuedate
                            .getText().contains("/")) {
                        flag = true;
                    }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'contentItem Duedate' IS EXISTS" + "\nMETHOD:isContentItemDuedateExist \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * method will return the due date of the content item based on the specified unit or coursename
     * and contentItem ,CourseHome and unit locators are different both are used in same method
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @param strContentItem
     * @return boolean
     * @throws Exception
     */
    public boolean isContentItemDuedateColorChanged(String strUnitName, String strContentItem)
            throws Exception {
        flag = false;
        intUnitNumber = 0;
        intContentItemNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'ContentItem Duedate color'");
            arlRowNumberSecondRow = getProfContetntItemrowNumber(strUnitName, strContentItem);
            intUnitNumber = arlRowNumberSecondRow.get(0);
            intContentItemNumber = arlRowNumberSecondRow.get(1);
            if (intUnitNumber == 0) {
                txtCourseHomeContentitembeforeDuedate.replaceValues(
                        String.valueOf(intUnitNumber),
                        String.valueOf(intContentItemNumber));
                txtCourseHomeContentitemafterDuedate.replaceValues(
                        String.valueOf(intUnitNumber),
                        String.valueOf(intContentItemNumber));
                txtCourseHomeContentitembeforeDuedate.isDisplayedAfterWaiting(waitTime);
                if (txtCourseHomeContentitemafterDuedate.isPresent() && txtCourseHomeContentitemafterDuedate
                        .getAttribute(CLASS_ATTRIBUTE).equalsIgnoreCase(REDTEXT_VALUE)) {
                    flag = true;
                } else
                    if (txtCourseHomeContentitembeforeDuedate.isPresent() && txtCourseHomeContentitembeforeDuedate
                            .getAttribute(CLASS_ATTRIBUTE).equalsIgnoreCase(REDTEXT_VALUE)) {
                        flag = true;
                    }
            } else {
                intContentItemNumber = intContentItemNumber + 2;
                txtUnitContentitembeforeDuedate.replaceValues(String.valueOf(intUnitNumber), String
                        .valueOf(intContentItemNumber));
                txtUnitContentitemafterDuedate.replaceValues(String.valueOf(intUnitNumber), String
                        .valueOf(intContentItemNumber));
                if (txtUnitContentitembeforeDuedate.isPresent() && txtUnitContentitembeforeDuedate
                        .getAttribute(CLASS_ATTRIBUTE).equalsIgnoreCase(REDTEXT_VALUE)) {
                    flag = true;
                } else
                    if (txtUnitContentitemafterDuedate.isPresent() && txtUnitContentitemafterDuedate
                            .getAttribute(CLASS_ATTRIBUTE).equalsIgnoreCase(REDTEXT_VALUE)) {
                        flag = true;
                    }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'ContentItem Duedate color'" + "\nMETHOD:isContentItemDuedateColorChanged \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * method will return the due date of the content item based on the specified unit or coursename
     * and contentItem, CourseHome and unit locators are different both are used in same method
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @param strContentItem
     * @return String
     * @throws Exception
     */
    public String getContentItemDuedate(String strUnitName, String strContentItem) throws Exception {
        strResult = null;
        intUnitNumber = 0;
        intContentItemNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'contentItem Duedate'");
            arlRowNumberThirdRow = getProfContetntItemrowNumber(strUnitName, strContentItem);
            frameSwitch.switchToFrameContent();
            intUnitNumber = arlRowNumberThirdRow.get(0);
            intContentItemNumber = arlRowNumberThirdRow.get(1);
            if (intUnitNumber == 0) {
                txtCourseHomeContentitembeforeDuedate.replaceValues(
                        String.valueOf(intUnitNumber),
                        String.valueOf(intContentItemNumber));
                txtCourseHomeContentitemafterDuedate.replaceValues(
                        String.valueOf(intUnitNumber),
                        String.valueOf(intContentItemNumber));
                txtCourseHomeContentitembeforeDuedate.isDisplayedAfterWaiting(waitTime);
                if (txtCourseHomeContentitembeforeDuedate.isPresent()) {
                    strResult = txtCourseHomeContentitembeforeDuedate.getText().trim();
                } else {
                    strResult = txtCourseHomeContentitemafterDuedate.getText().trim();
                }
            } else {
                intContentItemNumber = intContentItemNumber + 2;
                txtUnitContentitembeforeDuedate.replaceValues(String.valueOf(intUnitNumber), String
                        .valueOf(intContentItemNumber));
                txtUnitContentitemafterDuedate.replaceValues(String.valueOf(intUnitNumber), String
                        .valueOf(intContentItemNumber));
                if (txtUnitContentitembeforeDuedate.isPresent()) {
                    strResult = txtUnitContentitembeforeDuedate.getText().trim();
                } else {
                    strResult = txtUnitContentitemafterDuedate.getText().trim();
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'contentItem Duedate'" + "\nMETHOD:getContentItemDuedate \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will verify the back link is exist or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isBackLinkExist() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Back' LINK");
            flag = lnkBack.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN  VERIFYING 'Back' LINK" + "\nMETHOD:isBackLinkExist \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * method to verify img for back link caption is exist or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isBacklinkimgExist() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Back link image'");
            flag = imgBacklink.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN  VERIFYING 'Back link image'" + "\nMETHOD:isBacklinkimgExist \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * method will check the content items order
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return boolean
     * @throws Exception
     */
    public boolean isContentItemsinOrder(String strUnitName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Content items' ARE IN ORDER FOR SPECIFIED UNIT");
            arlListContetnItems = getContentItemsofUnit(strUnitName);
            strResult = "";// empty string: guaranteed to be less than or equal to any other

            for (String current : arlListContetnItems) {
                if (current.compareTo(strResult) < 0) {
                    return flag;
                }
                strResult = current;
            }
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'Content items' ORDER" + "\nMETHOD:isContentItemsinOrder \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify is expand icon of the specified unit is showing or not
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return boolean
     * @throws Exception
     */
    public boolean isExapanduniticonExist(String strUnitName) throws Exception {
        flag = false;
        intNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Expand icon of unit' IS EXIST");
            intNumber = getunitNumber(strUnitName);
            imgunitexpandicon.replaceValues(String.valueOf(intNumber));
            flag = imgunitexpandicon.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'Expand icon of unit' IS EXIST" + "\nMETHOD:isExapanduniticonExist \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify is collapse icon of specified unit is showing or not
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return boolean
     * @throws Exception
     */
    public boolean isCollapseuniticonExist(String strUnitName) throws Exception {
        flag = false;
        intNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Collapse icon of unit' IS EXIST");
            intNumber = getunitNumber(strUnitName);
            imgunitcollapseicon.replaceValues(String.valueOf(intNumber));
            flag = imgunitcollapseicon.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'Collapse icon of unit' IS EXIST" + "\nMETHOD:isCollapseuniticonExist \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * method will return the all units in the course check list page
     * 
     * @author Praveen.Maled
     * @param unitName
     * @return ArrayList
     * @throws Exception
     */
    public ArrayList<String> getAllUnits() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING ALL 'Units' IN COURSE CHECKLIST PAGE ");
            arlUnitNames = lstunitNumber.getUIElementsList();
            for (UIElement name : arlUnitNames) {
                if (name.getText().contains(strCourseHome)) {
                    continue;
                }
                arlAllUnits.add(name.getText());
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING ALL 'Units' IN COURSE CHECKLIST PAGE" + "\nMETHOD:getAllUnits \n" + e
                            .getLocalizedMessage());
        }
        return arlAllUnits;
    }

    /**
     * method will check the Units are in order or not
     * 
     * @author Praveen.Maled
     * @param unitName
     * @return boolean
     * @throws Exception
     */
    public boolean isUnitsAreinOrder() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING  'Units' ARE IN ORDER");
            lstUnits = getAllUnits();
            strResult = ""; // empty string: guaranteed to be less than or equal to any
                                     // other
            for (String current : lstUnits) {
                if (current.isEmpty()) {
                    continue;
                }
                if (current.compareTo(strResult) < 0) {
                    return flag;
                }
                strResult = current;
            }
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'Units Order'" + "\nMETHOD:isUnitsAreinOrder \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get the due date from 'Course Home' item
     * 
     * @category milestone 2
     * @author ganapati.bhat
     * @param strItemName
     * @return String
     * @throws Exception
     */
    public String getDuedateFromCourseHomeItem(String strItemName) throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE 'Due Date' FOR SPECIFIED COURSE HOME CONTENT ITEM");
            frameSwitch.switchToFrameContent();
            txtCoursedutedate.replaceValues(strItemName);
            strResult = txtCoursedutedate.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'Due Date' FOR SPECIFIED COURSE HOME CONTENT ITEM" + "\nMETHOD:getDuedateFromCourseHomeItem \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }
}
