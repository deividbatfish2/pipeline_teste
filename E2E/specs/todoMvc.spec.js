//todoMvc.spec.js

var	TodoMvc	=	require('../page-objects/todoMvc.po.js');

describe('Todo MVC Angular', function () {
    var todoMvc = new TodoMvc();

    beforeEach(function(){
        todoMvc.visit();
    });

    it('add a item in the todo list', function(){
        todoMvc.addItemOnTodoList('Creat test whith the Page Objects');

        expect(todoMvc.listOfItems.count()).toEqual(1);
    });

    it('add	new	item	in	the	todo	list',	function()	{
        todoMvc.addItemOnTodoList('Create	new	test	without	page	object');

        expect(todoMvc.listOfItems.count()).toEqual(2);
    });

});