node {
	stage 'Baixar o projeto do repositório'
			git 'https://github.com/deividbatfish2/pipeline_teste.git'

	stage 'Disparar Smoke Test'
			sh 'mvn -f pipeline_rest_assured/pom.xml clean test'
			step([$class: 'JunitResultArchiver', testResults: 'pipeline_rest_assured/**/target/*.xml'])

	stage 'Deploy'
		echo 'Deploying....'
}
