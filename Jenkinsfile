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
    step([$class: 'ArtifactArchiver', artifacts: 'meu_aplicativo/build/outputs/jar/products.jar'])
 }