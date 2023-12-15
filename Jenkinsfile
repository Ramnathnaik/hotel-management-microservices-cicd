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
        stage('Start container') {
            steps {
                sh 'docker compose up -d --wait'
                sh 'docker compose ps'
            }
        }
    }
    post {
        always {
            sh 'docker compose down'
            sh 'docker compose ps'
        }
    }
}