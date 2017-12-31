package jenkins;

import org.testng.annotations.Test;



public class CreateLead extends GenericWrappers {
	
	@Test
	public void createLead() throws Exception{
		//My Code
		invokeApp("chrome", "http://leaftaps.com/opentaps");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		
		clickByLink("CRM/SFA");
		clickByLink("Create Lead");
		
		enterById("createLeadForm_companyName", "TestLeaf");
		//clickByXpath("//img[contains(@src,'fieldlookup')]");
		enterById("createLeadForm_firstName", "Namboothri");
		enterById("createLeadForm_lastName","Gothandaraman");
		selectVisibileTextById("createLeadForm_dataSourceId","Cold Call");
		//selectVisibileTextById("createLeadForm_marketingCampaignId", "Automobile");
		selectIndexById("createLeadForm_marketingCampaignId",5);
		enterById("createLeadForm_firstNameLocal", "Sty");
		enterById("createLeadForm_lastNameLocal", "joby");
		enterById("createLeadForm_personalTitle", "Mr");
		enterById("createLeadForm_generalProfTitle", "Apple");
		enterById("createLeadForm_departmentName", "Production");
		enterByName("annualRevenue", "1 Billion");
		selectVisibileTextById("createLeadForm_currencyUomId","EGP - Egyptian Pound");
		selectVisibileTextById("createLeadForm_industryEnumId","Aerospace");
		enterById("createLeadForm_numberEmployees", "2900");
		selectVisibileTextById("createLeadForm_ownershipEnumId","Sole Proprietorship");
		enterById("createLeadForm_sicCode", "SIC001");
		enterById("createLeadForm_tickerSymbol", "Ticket$");
		enterById("createLeadForm_description", "Sample Desc");
		enterById("createLeadForm_importantNote", "Important Note");
		
		enterById("createLeadForm_primaryPhoneCountryCode", "044");
		enterById("createLeadForm_primaryPhoneAreaCode", "115");
		enterById("createLeadForm_primaryPhoneNumber", "9790");
		enterById("createLeadForm_primaryPhoneExtension", "044");
		enterById("createLeadForm_primaryPhoneAskForName", "Panchabikesan");
		enterById("createLeadForm_primaryEmail", "s@k.com");
		enterById("createLeadForm_primaryWebUrl", "wwww.apple.com");
		enterById("createLeadForm_generalToName", "Bill");
		enterById("createLeadForm_generalAttnName", "Gates");
		enterById("createLeadForm_generalAddress1", "107 First Street");
		enterById("createLeadForm_generalAddress2", "White House");
		enterById("createLeadForm_generalCity", "New York");
		selectIndexById("createLeadForm_generalStateProvinceGeoId",23);
		enterById("createLeadForm_generalPostalCode", "1150001");
		selectVisibileTextById("createLeadForm_generalCountryGeoId","United States");
		enterById("createLeadForm_generalPostalCodeExt", "Ext01");
		clickByName("submitButton");
		
	}

}
