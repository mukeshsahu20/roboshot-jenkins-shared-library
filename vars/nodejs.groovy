def call(){
    node {
        try {

            common.codeQuality()
            common.codechecks()
            common.artifacts()
        } catch (Exceptions e) {
      mail bcc: '', body: '', cc: '', from: 'mukeshsahu20@gmail.com', replyTo: '', subject: 'Pipeline job failed', to: 'mukeshsahu20@gmail.com'
        }

//      if (! env.TAG_NAME){
//          env.TAG_NAME = ""
//      }




        }
       }


