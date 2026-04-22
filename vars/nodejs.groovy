def call(){
    node {


         sh 'env'
         common.codeQuality()

         if (BRANCH_NAME == "main" || TAG_NAME ==~ "*") {
             stage('style checks') {
               echo 'style checks'
             }
         }

////
//            stage('unit tests') {
//                when {
//                    anyOf {
//                        branch 'main'
//                        tag "*"
//                    }
//                }
//
//                steps {
//                    echo "unit tests"
//                }
//            }
//
//            stage('Download dependencies') {
//                when { tag "*" }
//                steps {
//                    echo "Download dependencies only when there is Tag"
//                }
//            }
//
//            stage('Prepare artifact') {
//                when { tag "*" }
//                steps {
//                    echo "Prepare artifact only when tag is there"
//                }
//            }
//
//            stage('Publish artifact') {
//                when { tag "*" }
//                steps {
//                    echo "Publish artifact only when there is Tag"
//                }
//            }

        }

    }

