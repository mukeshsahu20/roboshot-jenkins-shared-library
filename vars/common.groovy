def codeQuality() {
    stage('code quality') {
        withCredentials([usernamepassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
            bat  ''' sonar-scanner -Dsonar.host.url=http://localhost:9000 -Dsonar.login=admin -Dsonar.password=Admin@123456 -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true '''
        }
    }
}

def codechecks () {
    if (env.BRANCH_NAME == "main" || TAG_NAME ==~ ".*") {
        stage('style checks') {
        echo 'style checks'
    }

       stage('Unit Tests') {
          echo 'Unit Test'
        }
  }
}

def artifacts() {
    if (env.TAG_NAME ==~ ".*"){

        stage ('Downoad Dependencies'){
            echo 'Download dependencies'
        }

    stage ('Prepare Artifacts'){
        echo 'Prepare Artifacts'
    }

    stage ('Publish Artifacts'){
      echo 'publish Artifacts'
        }
     }
}