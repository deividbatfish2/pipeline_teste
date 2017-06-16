pipeline {
	agent any

	parameters {
		string(defaultValue: 'https://www.autoglass.com.br', description: '', name: 'urlBase')
		choice(choices: 'Firefox\nChrome\nChrome_HeadLess', description: 'Selecine o navegador', name: 'navegador')
	}

	stages {
		stage('Baixar o projeto do repositório') {
			steps {
				git "https://github.com/deividbatfish2/pipeline_teste.git"
			}
		}
		stage('Verificar se o site está no ar') {
			steps {
				sh "casperjs test DeployTest/site-no-ar.js --xunit=DeployTest/report/log.xml"
				junit "**/DeployTest/report/*.xml"
			}
		}
		stage('Disparar Suite de Smoke Test') {
			steps {
				echo "Smoke Test executado"
			}
		}
		stage('WebApi Publica Test') {
			steps {
				sh "mvn -f suiteTest/pom.xml clean test -P ApiTest"
				junit "**/suiteTest/target/surefire-reports/*TEST-apiTest.Suite_ApiPublicaTest.xml"
			}	
		}
		stage('Executar testes de aceitação') {
			steps {
				sh "mvn -f suiteTest/pom.xml clean test -P AcceptanceTest -DurlBase=${params.urlBase} -Dbrowser=${params.navegador}"
				junit "**/suiteTest/target/surefire-reports/*TEST-acceptanceTest.RunnerTest.xml"
			}
		}
		stage('Executar testes funcionais') {
			steps {
				echo "Deploying...."
			}
		}
	}
}
