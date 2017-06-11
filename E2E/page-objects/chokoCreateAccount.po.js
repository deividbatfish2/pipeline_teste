// chokoCreateAccount.po.js

var	chokoCreateAccountPage	=	function()	{
		this.createAccountButton	=	element(by.id('element-create-account-submit'));
};

chokoCreateAccountPage.prototype.visit	=	function()	{
		browser.get('http://choko.org/create-account');
};

module.exports	=	chokoCreateAccountPage;