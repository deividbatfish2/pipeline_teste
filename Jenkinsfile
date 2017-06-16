pipeline {
	agent any

	stages {
		stage('Importando Properties'){
			properties([
			  parameters([
			    string(name: 'DEPLOY_ENV', defaultValue: 'TESTING', description: 'The target environment', )
			   ])
			])
		}
		stage('Baixar o projeto do repositório') {
			steps {
				git 'https://github.com/deividbatfish2/pipeline_teste.git'
			}
		}
		stage('Verificar se o site está no ar') {
			steps {
				sh 'casperjs test DeployTest/site-no-ar.js --xunit=DeployTest/report/log.xml'
				junit '**/DeployTest/report/*.xml'
			}
		}
		stage('Disparar Suite de Smoke Test') {
			steps {
				echo 'Smoke Test executado'
			}
		}
		stage('WebApi Publica Test') {
			steps {
				sh 'mvn -f suiteTest/pom.xml clean test -P ApiTest'
				junit '**/suiteTest/target/surefire-reports/*TEST-apiTest.Suite_ApiPublicaTest.xml'
			}	
		}
		stage('Executar testes de aceitação') {
			steps {
				sh 'echo parametro: ${params.urlBase}'
				sh 'mvn -f suiteTest/pom.xml clean test -P AcceptanceTest'
				junit '**/suiteTest/target/surefire-reports/*TEST-acceptanceTest.RunnerTest.xml'
			}
		}
		stage('Executar testes funcionais') {
			steps {
				echo 'Deploying....'
			}
		}
	}
}
