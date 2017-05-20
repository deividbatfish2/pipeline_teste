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
                sh 'cd pipeline_rest_assured'
		sh 'pwd'
		sh 'mvn clean test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
