pipeline {
    agent any

    environment {
        NameSpace='geralt'
    }
    stages {
        stage('Checkout') {
            steps {
                git poll: true, url: 'https://github.com/helecopter/spring-boot-basic.git'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Sonarqube') {
            steps {
                sh './gradlew sonarqube'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build'
                sh 'whoami'
                withCredentials([sshUserPrivateKey(credentialsId: "training_pem", keyFileVariable: 'keyfile')]) {
                sh "ssh -i $keyfile ubuntu@172.31.12.139 mkdir -p /home/ubuntu/works/$NameSpace"
                sh "scp -i $keyfile ./build/libs/demo-0.0.1-SNAPSHOT.jar ubuntu@172.31.12.139:/home/ubuntu/works/$NameSpace/demo.jar"
                sh "ssh -i $keyfile ubuntu@172.31.12.139 'ls /home/ubuntu/works/$NameSpace'"
                sh "ssh -i $keyfile ubuntu@172.31.12.139 'kill -9 \$(lsof -t -i:8765) 2>&1 &'"
                sh "ssh -i $keyfile ubuntu@172.31.12.139 'nohup java -jar /home/ubuntu/works/$NameSpace/demo.jar > demo.log 2>&1 &'"
            }
         }
        }
        stage('DeployTest'){
            steps {
                sh 'whoami'
                withCredentials([sshUserPrivateKey(credentialsId: "training_pem", keyFileVariable: 'keyfile')]) {
                    sh "ssh -i $keyfile ubuntu@172.31.12.139 mkdir -p /home/ubuntu/works/$NameSpace"
                    sh "ssh -i $keyfile ubuntu@172.31.12.139 'curl http://172.31.12.139:8765/fizz-buzz/3'"
                }
            }
        }
    }
}