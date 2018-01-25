
describe("this is my hello world suite", function(){
	
	it("my first test", function(){
		expect(true).toBe(true);
	});
	
	var a = 100;
	it("my second test", function(){
		expect(a).toEqual(100);
	});
});

describe("2nd suite", function(){
	
	beforeAll(function(){
		var foo = 100;
	});
	
	it("my failed test", function(){
		expect(false).toBe(true);
	});
	
	var b = 200;
	it("another failed test", function(){
		expect(b).not.toEqual(200);
	});
	
});


describe(" suite - 3", function(){
	var message = "foo bar baz";
	it("suite 3.0", function(){
		expect(message).not.toEqual("hello world");
	});	
	
	describe("suite - 3.1", function(){
		it("spec 3.1.1", function(){
			expect(message).toMatch(/bar/);
			expect(message).toMatch("bar");
			expect(message).not.toMatch("heloo");
		});
		describe("suite - 3.2", function(){
			it("spec - 3.2.1", function(){
				expect(true).toEqual(true);
			});
			describe("suite - 3.3", function(){
				it("spec - 3.3.1", function(){
					expect(true).toEqual(true);
				});
				describe("suite - 3.4", function(){
					it("spec - 3.4.1", function(){
						expect(true).toEqual(true);
					});
				});
			});
		});
	});
});















