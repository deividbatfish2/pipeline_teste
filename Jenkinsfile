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
                sh 'pwd'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
