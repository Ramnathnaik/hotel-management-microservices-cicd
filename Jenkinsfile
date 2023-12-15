pipeline {
    agent any 
    stages {
        stage("verify tools") {
            steps {
                bat '''
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
                    def isContainerRunning = bat(script: 'docker ps -q', returnStatus: true)

                    if (isContainerRunning) {
                        echo 'Stopping existing Docker container...'
                        bat 'docker-compose down'
                    }
                }
            }
        }
        stage('Start container') {
            steps {
                bat 'docker compose up -d --wait'
                bat 'docker compose ps'
            }
        }
    }
    // post {
    //     always {
    //         bat 'docker compose down'
    //         bat 'docker compose ps'
    //     }
    // }
}