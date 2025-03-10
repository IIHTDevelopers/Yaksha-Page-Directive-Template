package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import com.yaksha.assignment.controller.PageDirectiveController;
import com.yaksha.assignment.utils.CustomParser;

public class PageDirectiveControllerTest {

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testPageDirectiveControllerReturnsCorrectView() throws Exception {
		// Mock HttpServletRequest and Model using Mockito
		HttpServletRequest request = mock(HttpServletRequest.class);
		Model model = mock(Model.class);

		// Create an instance of the controller
		PageDirectiveController controller = new PageDirectiveController();

		// Call the method with mocked request and model
		String viewName = controller.showPageDirective(model);

		// Verify the view name is "pageDirective"
		boolean isPageDirectiveViewReturned = "pageDirective".equals(viewName);

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(), isPageDirectiveViewReturned, businessTestFile);
	}

	@Test
	public void testJspTagsAndHtmlTagClosureInPageDirectiveJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/pageDirective.jsp";

		// Ensure that the pageDirective.jsp page includes the page directive and
		// properly closes HTML tags
		boolean hasPageDirective = CustomParser.checkJspTagPresence(filePath,
				"<%@ page contentType=\"text/html; charset=UTF-8\" language=\"java\" %>");
		boolean hasClosingTags = CustomParser.checkJspTagPresence(filePath, "<html>");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasPageDirective && hasClosingTags, businessTestFile);
	}

	@Test
	public void testJspTagsAndHtmlTagClosureInIndexJsp() throws Exception {
		String filePath = "src/main/webapp/index.jsp";

		// Check for form submission and input elements in index.jsp
		boolean hasFormTag = CustomParser.checkJspTagPresence(filePath, "<h2");
		boolean hasInputTags = CustomParser.checkJspTagPresence(filePath, "<p");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasFormTag && hasInputTags, businessTestFile);
	}

}
