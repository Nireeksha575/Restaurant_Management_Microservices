pipeline {
    agent any

    stages {
        stage('Build (in parallel)') {
            parallel{
                stage('eureka server'){
                    steps{
                        dir('eureka-server'){
                            bat 'mvn clean package -DskipTests=false'
                        }
                    }
                }
                stage('menu service'){
                    steps{
                        dir('menu-service'){
                            bat 'mvn clean package -DskipTests=false'
                        }
                    }
                }
                stage('restaurant-service'){
                    steps{
                        dir('restaurant-service'){
                            bat 'mvn clean package -DskipTests=false'
                        }
                    }
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Testing the application...'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying to production'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
