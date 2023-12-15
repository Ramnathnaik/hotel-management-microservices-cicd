pipeline {
    agent any

    stages {
        stage('Check Running Docker Container') {
            steps {
                script {
                    // Check if any Docker container is running
                    def isContainerRunning = sh(script: 'docker ps -q', returnStatus: true).trim()

                    if (isContainerRunning) {
                        echo 'Stopping existing Docker container...'
                        sh 'docker-compose down'
                    }
                }
            }
        }

        stage('Check Prerequisites') {
            steps {
                script {
                    // Check if Docker, Maven, and Java are installed
                    def dockerInstalled = tool name: 'docker', type: 'com.cloudbees.jenkins.plugins.customtools.CustomTool'
                    def mavenInstalled = tool name: 'maven', type: 'maven'
                    def javaInstalled = tool name: 'java', type: 'hudson.model.JDK'

                    echo "Docker version: ${sh(script: 'docker --version', returnStatus: true)}"
                    echo "Maven version: ${sh(script: 'mvn --version', returnStatus: true)}"
                    echo "Java version: ${sh(script: 'java -version', returnStatus: true)}"

                    if (!dockerInstalled) {
                        error "Docker is not installed. Please install Docker and configure it in Jenkins."
                    }

                    if (!mavenInstalled) {
                        error "Maven is not installed. Please install Maven and configure it in Jenkins."
                    }

                    if (!javaInstalled) {
                        error "Java is not installed. Please install Java and configure it in Jenkins."
                    }
                }
            }
        }

        stage('Start Docker Container') {
            steps {
                script {
                    // Start Docker container with docker-compose.yml
                    sh 'docker-compose up -d'
                }
            }
        }
    }

    post {
        always {
            // Stop Docker container after build (optional)
            // script {
            //     echo 'Stopping Docker container...'
            //     sh 'docker-compose down'
            // }
        }
    }
}
