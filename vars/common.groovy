//def codeQuality() {
//    stage('code quality') {
//        withCredentials([usernamepassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
//            bat  ''' sonar-scanner -Dsonar.host.url=http://localhost:9000 -Dsonar.login=admin -Dsonar.password=Admin@123456 -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true '''
//        }
//    }
//}


def codeCheckout() {
    stage('code checkout') {
    git branch: 'main', url: "https://github.com/mukeshsahu20/${COMPONENT}.git"
        }
    }



def codeQuality() {
    stage('code quality') {
        withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
            bat """
            sonar-scanner ^
            -Dsonar.host.url=http://localhost:9000 ^
            -Dsonar.login=%sonarUser% ^
            -Dsonar.token=%sonarPass% ^
            -Dsonar.projectKey=${COMPONENT} ^
            -Dsonar.qualitygate.wait=true
            """
        }
    }
}

def codechecks () {
    if (env.BRANCH_NAME == "main" || TAG_NAME ==~ ".*") {
        stage('style & Lint checks') {
        echo 'style checks'
    }

       stage('Unit Tests') {
          echo 'Unit Test'
        }
  }
}

def artifacts() {
    if (env.TAG_NAME ==~ ".*"){


    stage ('Prepare Artifacts Nodejs'){
        if (env.APPTYPE == "nodejs") {
            echo 'sh npm install'
        }
        if (env.APPTYPE == "python"){
            echo 'sh directoly zip the file.py'
        }
    }

    stage ('Publish Artifacts'){
      echo 'publish Artifacts cmd to used (sh curl -v -u admin:admin123 --upload-file pom.xml http://localhost:8081/repository/maven-release/org/foo/1.0/foo-1.0.pem)'
        }
     }
}