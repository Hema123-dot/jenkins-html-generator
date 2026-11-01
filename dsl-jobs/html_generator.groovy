pipelineJob('html-generator-dev') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/Hema123-dot/jenkins-html-generator.git')
                    }
                    branch('*/dynamic-html')
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}