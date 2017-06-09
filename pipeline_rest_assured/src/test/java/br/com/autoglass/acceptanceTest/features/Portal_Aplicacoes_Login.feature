# language: pt

Funcionalidade: Portal de Aplicações Login

	Como funcionário da Autoglass eu gostaria de poder Logar no Portal de Aplicações

Cenário: Efetuar login
	Quando Eu informo os dados do seguinte usuário:
		|	username	|	senha	|
		|	qualidade.ti	|	megazord	|
		E clico no botão Entrar
	Então vejo a página principal do sistema
	E meu nome é exido no canto superior direito