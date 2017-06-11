//	choko.specs.js

var	CreateAccountPage	=	require('../page-objects/chokoCreateAccount.po.js');
var	MessagesWrapper	=	require('../page-objects/chokoMessagesWrapper.po.js');
var	SignInPage	=	require('../page-objects/chokoSignIn.po.js');

var	messageWrapper	=	new	MessagesWrapper();

describe('Choko	-	Sign	in',	function()	{
		var	signInPage	=	new	SignInPage();
		it('try	to	sign	in	without	filling	any	field',	function()	{

				signInPage.visit();
				signInPage.signInButton.click();

				expect(messageWrapper.errorMessage.isDisplayed()).toBe(true);
		});
});

describe('Choko	-	Create	account',	function()	{
		var	createAccountPage	=	new	CreateAccountPage();
		it('try	to	create	account	without	filling	any	field',	function(){

				createAccountPage.visit();
                createAccountPage.createAccountButton.click();
                
				expect(messageWrapper.errorMessage.isDisplayed()).toBe(true);
		});
});