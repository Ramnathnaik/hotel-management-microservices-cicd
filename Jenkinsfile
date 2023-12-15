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
        stage('Start container') {
            steps {
                bat 'docker compose up -d --wait'
                bat 'docker compose ps'
            }
        }
    }
    post {
        always {
            bat 'docker compose down'
            bat 'docker compose ps'
        }
    }
}