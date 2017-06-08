casper.test.begin('Site no ar', 1, function(test){
    casper.start('https://www.google.com.br/');

    casper.then(function(){
        test.assertHttpStatus(200, 'Site está no ar');
    });

    casper.run(function(){
        test.done();
    })
});
