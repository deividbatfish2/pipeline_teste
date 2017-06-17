# language: pt
# encoding: utf-8
Funcionalidade: Informações Farol

	Contexto: Acessar o site da Autoglass
		Dado acessei o site da Autoglass

  Cenário: Encontar informações sobre Fárois
    Dado que clique na opção Sou Consumidor
    Quando clicar na opção Fárois
    Então o sie deve exibir inforaçãoes relacionadas a farois
