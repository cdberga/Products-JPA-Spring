stage 'Checkout'
 node('master') {
  deleteDir()
  checkout scm
 }
 stage 'Unit tests'
  node('master') {
    sh 'mvn clean test'
}
stage 'Build'
 node('master') {
    sh 'mvn -B -DskipTests clean verify' 
 }