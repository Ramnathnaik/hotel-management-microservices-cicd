pipeline {
    agent any 
    stages {
        stage("verify tools") {
            steps {
                sh '''
                docker version
                docker info
                docker compose version
                '''
            }
        }
        stage('Check Running Docker Container') {
            steps {
                script {
                    // Check if any Docker container is running
                    def isContainerRunning = sh(script: 'docker ps -q', returnStatus: true).trim()

                    if (isContainerRunning) {
                        echo 'Stopping existing Docker container...'
                        sh 'docker-compose down'
                    } else {
                        echo 'No Docker container running'
                    }
                }
            }
        }
        stage('Start container') {
            steps {
                sh 'docker compose up -d --wait'
                sh 'docker compose ps'
            }
        }
    }
    // post {
    //     always {
    //         sh 'docker compose down'
    //         sh 'docker compose ps'
    //     }
    // }
}