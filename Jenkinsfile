pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }
    parameters{
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'feature/page-object', name: 'BRANCH', type: 'PT_BRANCH'
    }

    stages {
        stage('Build') {
            steps {
                git branch: "${params.BRANCH}", url:'https://github.com/kasatkasss/monkkee.git'
                // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                bat "mvn clean test"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('reports') {
             steps {
                 script {
                         allure([
                                 includeProperties: false,
                                 jdk: '',
                                 properties: [],
                                 reportBuildPolicy: 'ALWAYS',
                                 results: [[path: 'target/allure-results']]
                         ])
                 }
             }
        }
    }

}
