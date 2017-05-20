pipeline {
    agent any

    stages {
        stage('Baixar o projeto do repositório') {
		steps {
			echo 'Baixando o projeto do repositório remoto'
			git 'https://github.com/deividbatfish2/pipeline_teste.git'
		}
        }
        stage('Disparar Smoke Test') {
		steps {
			echo 'Verificando repositório'
			sh 'make check || true'
			sh 'mvn -f pipeline_rest_assured/pom.xml clean test'
			[$class: 'JunitResultArchiver', testResults: 'pipeline_rest_assured/**/target/*.xml']
	    	}
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
