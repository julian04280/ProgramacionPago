pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones especÃ­ficas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una secciÃ³n que define las herramientas â€œpreinstaladasâ€� en Jenkins
  tools {
    jdk 'JDK14_Centos' //Preinstalada en la ConfiguraciÃ³n del Master
    gradle 'Gradle6.0.1_Centos' //Preinstalada en la ConfiguraciÃ³n del Master
  }

  //AquÃ­ comienzan los â€œitemsâ€� del Pipeline
  stages{
    stage('Checkout') {
      steps{
		checkout([
			$class: 'GitSCM',
			branches: [[name: '*/master']], 
			doGenerateSubmoduleConfigurations: false, 
			extensions: [], 
			gitTool: 'Default', 
			submoduleCfg: [], 
			userRemoteConfigs: [[credentialsId: 'GitHub_julian04280', 
				urlhttps://github.com/julian04280/ProgramacionPago.git'
			]]
		])

      }
    }
    
    stage('Compile & Unit Tests') {
      steps{
        echo "------------>Unit Tests<------------"
		sh 'gradle --b ./build.gradle test'
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>AnÃ¡lisis de cÃ³digo estÃ¡tico<------------'
        withSonarQubeEnv('Sonar') {
			sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
        }
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
      }
    }  
  }
  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
    }
    failure {
      echo 'This will run only if failed'
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}



