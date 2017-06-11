# language: pt

Funcionalidade: Cadastro de clientes.

Cenário: Inserir Cliente Pessoa Física
	Dado que efetuei login no sistema
	E acessei o menu Cliente >> Inserir
	Quando na tela Dados de identificação informo os dados da pessoa física
	E na tela Dados de Identificação clico em Avançar
	E na tela Endereços informo os endereços
	E na tela Endereços Clico em Salvar
	Então na tela Endereços será exibida a mensagem de sucesso
	E eferuarei logout do sistema