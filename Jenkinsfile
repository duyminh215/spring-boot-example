pipeline {
    agent any
    stages {
    	stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn -B package --file pom.xml'
            }
        }
        stage('Unit tests') {
            steps {
                echo 'Unit tests'
                sh 'mvn jmeter:jmeter -Pjmeter'
            }
        }
        stage('Intergration tests') {
            steps {
                echo 'Intergration tests'
                sh 'mvn -q test-compile -Dmaven.test.skip=true'
            }
        }
        stage('Benchmark') {
            steps {
                echo 'Benchmark'
                sh 'java -version'
				sh 'java -jar target/template-0.0.1-SNAPSHOT.jar > /dev/null &'
				sh 'sleep 20'
				sh 'mvn jmeter:jmeter -Pjmeter'
            }
        }
    }
}