pipeline {
    agent any

    stages {
        stage('Baixar o projeto do repositório') {
			echo 'Baixando o projeto do repositório remoto'
			git 'https://github.com/deividbatfish2/pipeline_teste.git'
        }
        stage('Disparar Smoke Test') {
			echo 'Verificando repositório'
			sh 'mvn -f pipeline_rest_assured/pom.xml clean test'
		steps {
		        echo 'Importando relatório de teste'
			junit 'pipeline_rest_assured/**/target/*.xml'
	    	}
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}