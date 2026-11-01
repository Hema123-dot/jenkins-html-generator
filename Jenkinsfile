pipeline {
    agent any
 
    tools {
        go 'go-1.16'
    }
 
    environment {
        BRANCH = 'dev'
        DEPLOYED_BY = 'LabsUser'
        ENV = 'dev'
    }
 
    stages {
        stage('Setup Environment') {
            steps {
                script {
                    env.COMMIT = sh(script: 'git rev-parse --short HEAD', returnStdout: true).trim()
                }
            }
        }
 
        stage('Build Generator') {
            steps {
                dir('src') {
                    sh 'go build -o generator main.go'
                }
            }
        }
 
        stage('Generate HTML') {
            steps {
                dir('src') {
                    sh './generator'
                }
            }
        }
 
        stage('Publish Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'src',
                    reportFiles: 'index.html',
                    reportName: 'Dynamic HTML generator'
                ])
            }
        }
    }
}
