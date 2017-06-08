casper.test.begin('Site no ar', 1, function(test){
    casper.start('http://www.globo.com/');

    casper.then(function(){
        test.assertHttpStatus(200, 'Site está no ar');
    });

    casper.run(function(){
        test.done();
    })
});
