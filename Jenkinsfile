pipeline {
    agent { label 'verisoft-2' } // אם את לא משתמשת בתווית, תשני ל: agent any

    parameters {
        string(name: 'REPO_URL', defaultValue: 'https://github.com/malkiberman/JavaTeat-with-CI.git', description: 'GitHub Repository URL')
        string(name: 'NAME_BRANCH', defaultValue: 'main', description: 'Branch to build from')
    }

    environment {
        MAIN_BRANCH = 'main'
    }

    triggers {
        cron('30 5 * * 1\n0 14 * * *') // שני 5:30 + כל יום 14:00
    }

    stages {
        stage('Clone Repository') {
            when {
                expression {
                    return params.NAME_BRANCH != env.MAIN_BRANCH
                }
            }
            steps {
                echo "🔄 Starting clone from custom branch: ${params.NAME_BRANCH}"
                timeout(time: 5, unit: 'MINUTES') {
                    git branch: "${params.NAME_BRANCH}", url: "${params.REPO_URL}"
                }
                echo "✅ Clone stage completed successfully"
            }
        }

        stage('Checkout Default SCM') {
            when {
                expression {
                    return params.NAME_BRANCH == env.MAIN_BRANCH
                }
            }
            steps {
                echo "🔄 Starting default checkout (main branch)"
                timeout(time: 5, unit: 'MINUTES') {
                    checkout scm
                }
                echo "✅ Checkout stage completed successfully"
            }
        }

        stage('Compile') {
            steps {
                echo "🔧 Starting compilation stage"
                timeout(time: 5, unit: 'MINUTES') {
                    sh 'mvn compile'
                }
                echo "✅ Compilation stage completed successfully"
            }
        }

        stage('Run Tests') {
            steps {
                echo "🧪 Starting test stage"
                timeout(time: 5, unit: 'MINUTES') {
                    sh 'mvn test'
                }
                echo "✅ Test stage completed successfully"
            }
        }
    }

    post {
        success {
            echo "🎉 Pipeline completed successfully!"
        }
        failure {
            echo "❌ Pipeline failed!"
        }
    }
}
