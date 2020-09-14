stage 'Checkout'
 node('master') {
  deleteDir()
  checkout scm
 }
stage 'Build'
 node('master') {
  steps {
        sh 'mvn -B -DskipTests clean verify' 
    }
 }