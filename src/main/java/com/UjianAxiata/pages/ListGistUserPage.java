package com.UjianAxiata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.UjianAxiata.driver.DriverSingleton;

public class ListGistUserPage {
	private WebDriver driver;

	public ListGistUserPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#gist-pjax-container > div.gisthead.pagehead.pb-0.pt-3.mb-4 > div > div.mb-3.d-flex.px-3.px-md-3.px-lg-5 > div > div > div.d-flex.flex-column.width-full > div.d-flex.flex-row.width-full > h1 > span.author > a")
	private WebElement mylistgist;
	@FindBy(css="#gist-pjax-container > div > div > div.h-card.col-md-3.col-12 > div > div.clearfix.d-flex.d-md-block.flex-items-center.mb-4.mb-md-0 > div.vcard-names-container.float-left.js-profile-editable-names.col-12.py-3 > h1 > span.p-nickname.vcard-username.d-block")
	private WebElement listviewsuccesassert;

	public String getListviewsuccesassert() {
		return listviewsuccesassert.getText();
	}
	public void listgist() {
		mylistgist.click();
	}

	
}
