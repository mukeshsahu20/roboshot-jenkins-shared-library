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
            echo 'sh zip -r ${COMPONENT}-${TAG_NAME}.zip *.py ${COMPONENT}.ini requirement.txt'
        }
    }

    stage ('Publish Artifacts'){
      echo 'publish Artifacts cmd to used (sh curl -v -u admin:admin123 --upload-file ${COMPONENT} http://localhost:8081/repository/${COMPONENT}/${COMPONENT}-${TAG_NAME}.zip)'
        }
     }
}