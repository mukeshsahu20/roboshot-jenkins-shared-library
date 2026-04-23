def codeQuality() {
    stage('code quality') {
            echo "code quality"
        echo "sh ''' sonar-scanner -Dsonar.host.url=http://172.168.1.12:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=${COMPONENT} '''"
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