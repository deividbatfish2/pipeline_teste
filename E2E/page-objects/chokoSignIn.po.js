//	chokoSignIn.po.js

var	ChokoSignInPage	=	function()	{
		this.signInButton	=	element(by.id('element-sign-in-submit'));
};

ChokoSignInPage.prototype.visit	=	function()	{
		browser.get('http://choko.org/sign-in');
};

module.exports	=	ChokoSignInPage;