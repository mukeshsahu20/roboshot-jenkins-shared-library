def call() {
    node {
        try {

            common.codeQuality()
            common.codechecks()
            common.artifacts()
        } catch (Exception e) {
            currentBuild.result = 'FAILURE'
            mail(
                    bcc: '',
                    body: """
                    Pipeline Failed!
                    Job    : ${env.JOB_NAME}
                    Build  : #${env.BUILD_NUMBER}
                    Error  : ${e.message}
                    URL    : ${env.BUILD_URL}
                """,
                    cc: '',
                    from: 'mukeshsahu20@gmail.com',
                    replyTo: '',
                    subject: "FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    to: 'mukeshsahu20@gmail.com'
            )

//      if (! env.TAG_NAME){
//          env.TAG_NAME = ""
//      }

        }
    }


}