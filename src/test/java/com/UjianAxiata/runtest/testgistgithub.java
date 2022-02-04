package com.UjianAxiata.runtest;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.UjianAxiata.config.AutomationFrameworkConfiguration;
import com.UjianAxiata.driver.DriverSingleton;
import com.UjianAxiata.pages.CreatePostGistPage;
import com.UjianAxiata.pages.DeletePostGistPage;
import com.UjianAxiata.pages.EditPostGistPage;
import com.UjianAxiata.pages.ListGistUserPage;
import com.UjianAxiata.pages.LoginGistPage;
import com.UjianAxiata.pages.LogoutGistPage;
import com.UjianAxiata.utils.ConfigurationProperties;
import com.UjianAxiata.utils.ConstantsDriver;

@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class testgistgithub extends AbstractTestNGSpringContextTests {
	private WebDriver driver;
	private LoginGistPage loginGistPage;
	private CreatePostGistPage createPostGistPage;
	private ListGistUserPage listGistUserPage;
	private DeletePostGistPage deletePostGistPage;
	private EditPostGistPage editPostGistPage;
	private LogoutGistPage logoutGistPage;
	private ConstantsDriver constantsDriver;
	
	

	@Autowired
	ConfigurationProperties configurationProperties;

	@BeforeTest
	public void setup() {

	}
	@Test(priority = 0)
	public void gotoWeblogin() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		driver = DriverSingleton.getDriver();
		driver.get(ConstantsDriver.URL);
		loginGistPage = new LoginGistPage();
		constantsDriver = new ConstantsDriver();
		loginGistPage.loginGist(constantsDriver.USERNAME,ConstantsDriver.PASSWORD);
		assertEquals(loginGistPage.getTextAfterLogin(), configurationProperties.getTextsuccesfulllogin());

	}
	
	@Test(priority = 1)
	public void create_a_gist() {
		createPostGistPage = new CreatePostGistPage();
		createPostGistPage.createGist();
		assertEquals(createPostGistPage.getTextAfterCreate(), constantsDriver.descriptiongistcreate);

	}
	@Test(priority = 2)
	public void seelist_of_gist() {
		listGistUserPage = new ListGistUserPage();
		listGistUserPage.listgist();
		assertEquals(listGistUserPage.getListviewsuccesassert(), configurationProperties.getAlllist());

		
	}
	@Test(priority = 3)
	public void delete_of_gist() {
		deletePostGistPage = new DeletePostGistPage();
		deletePostGistPage.deleteSelectedgist();
		deletePostGistPage.deleteSelectedgistalert();
		assertEquals(deletePostGistPage.getDeletetextbtn(), configurationProperties.getDeletetextbtn());
	}
	@Test(priority = 4)
	public void edit_of_gist() {
		editPostGistPage = new EditPostGistPage();
		editPostGistPage.editpostgist();
		assertEquals(editPostGistPage.getEditassertsucces(), configurationProperties.getEditassertsucces());
	}
	@Test(priority = 5)
	public void logout_of_gist() {
		logoutGistPage = new LogoutGistPage();
		logoutGistPage.logoutUserGist();
		assertEquals(logoutGistPage.getLogoutscucces(), configurationProperties.getLogoutscucces());
	}
	
	


}
