//HomePage Test
describe('Homepage', function() {
    it('perform a search in the api page', function(){
        browser.get('#/api');

        element(by.model('searchTerm')).sendKeys('restart');
        element(by.css('.depth-1')).click;

        expect(element(by.css('.api-title')).getText()).toContain('browser.restart');
    });
});