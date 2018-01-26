
describe("suite - 1.0", function(){
	
	var firstField = element(by.model('first'));
	var secondField = element(by.model('second'));
	var goBtn = element(by.id('gobutton'));
	var latestResult = element(by.binding('latest'));
	
	beforeEach(function(){
		browser.get('http://juliemr.github.io/protractor-demo/');
	});	
		
	it("should have a title", function(){
		expect(browser.getTitle()).toEqual('Super Calculator');
	});
	
	it("add - passed test", function(){
		firstField.sendKeys(11);
		secondField.sendKeys(22);
		goBtn.click();
		expect(latestResult.getText()).toEqual('33');
	});
	
	it("add - failed test", function(){
		firstField.sendKeys(111);
		secondField.sendKeys(221);
		goBtn.click();
		expect(latestResult.getText()).toEqual(300);
	});
	
	it("add - failed test", function(){
		firstField.sendKeys(456);
		expect(firstField.getAttribute('value')).toEqual('456');
	});
	
});