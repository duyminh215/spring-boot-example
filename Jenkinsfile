pipeline {
  agent {
    node {
      label 'maven'
    }
  }

    parameters {
        string(name:'TAG_NAME',defaultValue: '',description:'')
    }

    environment {
        DOCKER_CREDENTIAL_ID = 'docker-login-info'
        GITHUB_CREDENTIAL_ID = 'github-login-info'
        DOCKERHUB_NAMESPACE = 'duyminh215'
        GITHUB_ACCOUNT = 'duyminh215'
        APP_NAME = 'devops-spring-boot-sample'
        BRANCH_NAME = 'master'
        BUILD_NUMBER = '1.0'
    }

    stages {
        stage ('checkout scm') {
            steps {
                checkout(scm)
            }
        }

        stage ('unit test') {
            steps {
                container ('maven') {
                    sh 'mvn clean -o -gs test surefire-report:report'
                }
            }
        }

        stage ('build & push') {
            steps {
                container ('maven') {
                    sh 'mvn -o -Dmaven.test.skip=true -gs clean package'
                    sh 'docker build -t $DOCKERHUB_NAMESPACE/$APP_NAME:SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER .'
                    withCredentials([usernamePassword(passwordVariable : 'DOCKER_PASSWORD', usernameVariable : 'DOCKER_USERNAME', credentialsId : "$DOCKER_CREDENTIAL_ID" ,)]) {
                        sh 'echo "$DOCKER_PASSWORD" | docker login --username "$DOCKER_USERNAME" --password-stdin'
                        sh 'docker push  $DOCKERHUB_NAMESPACE/$APP_NAME:SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER'
                    }
                }
            }
        }

        stage('push latest'){
           when{
             branch 'master'
           }
           steps{
                container ('maven') {
                  sh 'docker tag $DOCKERHUB_NAMESPACE/$APP_NAME:SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER $DOCKERHUB_NAMESPACE/$APP_NAME:latest '
                  sh 'docker push $DOCKERHUB_NAMESPACE/$APP_NAME:latest '
                }
           }
        }

        stage('deploy to dev') {
          when{
            branch 'master'
          }
          steps {
            containerID = sh (
                        script: 'docker run -p 8888:8080 -d $DOCKERHUB_NAMESPACE/$APP_NAME:SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER',
                    returnStdout: true
                    ).trim()
            echo "Container ID is ==> ${containerID}"
            sh "docker cp ${containerID}:/TestResults/test_results.xml test_results.xml"
            sh "docker stop ${containerID}"
            sh "docker rm ${containerID}"
            step([$class: 'MSTestPublisher', failOnError: false, testResultsFile: 'test_results.xml'])
          }
        }
        stage('push with tag'){
          when{
            expression{
              return params.TAG_NAME =~ /v.*/
            }
          }
          steps {
              container ('maven') {
                input(id: 'release-image-with-tag', message: 'release image with tag?')
                  withCredentials([usernamePassword(credentialsId: "$GITHUB_CREDENTIAL_ID", passwordVariable: 'GIT_PASSWORD', usernameVariable: 'GIT_USERNAME')]) {
                    sh 'git config --global user.email "duyminh215@gmail.com" '
                    sh 'git config --global user.name "duyminh215" '
                    sh 'git tag -a $TAG_NAME -m "$TAG_NAME" '
                    sh 'git push http://$GIT_USERNAME:$GIT_PASSWORD@github.com/$GIT_USERNAME/spring-boot-example.git --tags --ipv4'
                  }
                sh 'docker tag $DOCKERHUB_NAMESPACE/$APP_NAME:SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER $DOCKERHUB_NAMESPACE/$APP_NAME:$TAG_NAME '
                sh 'docker push $DOCKERHUB_NAMESPACE/$APP_NAME:$TAG_NAME '
          }
          }
        }
    }
}