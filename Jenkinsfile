node {
	agent any

	stages {
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
		stage('Disparar Smoke Test') {
			steps {
				echo 'Smoke Test executado'
			}
		}
		stage('WebApi Test') {
			steps {
				sh 'mvn -f pipeline_rest_assured/pom.xml clean test'
				junit '**/pipeline_rest_assured/target/surefire-reports/*.xml'
			}	
		}
		stage('Executar testes de aceitação') {
			steps {
				echo 'Deploying....'
			}
		}
		stage('Executar testes funcionais') {
			steps {
				echo 'Deploying....'
			}
		}
	}
}
