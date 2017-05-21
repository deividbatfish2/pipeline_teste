node {
	stage 'Baixar o projeto do repositório'
		git 'https://github.com/deividbatfish2/pipeline_teste.git'

	stage 'Verificar se o site está no ar'	
		sh 'casperjs test DeployTest/site-no-ar.js --xunit=DeployTest/report/log.xml'
		step(junit '**/DeployTest/report/*.xml')

	stage 'Disparar Smoke Test'
		echo 'Smoke Test executado'

	stage 'WebApi Test'
		sh 'mvn -f pipeline_rest_assured/pom.xml clean test'
		step(junit '**/pipeline_rest_assured/target/surefire-reports/*.xml')	

	stage 'Executar testes de aceitação'
		echo 'Deploying....'

	stage 'Executar testes funcionais'
		echo 'Deploying....'
}
