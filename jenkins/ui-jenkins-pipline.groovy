timeout(180) {
    node('maven') {

        wrap([$class: 'BuildUser']) {
            summary = """|<b>Owner:</b> ${env.BUILD_USER}
	                            |<b>Branch:</b> ${BRANCH}""".stripMargin()
            currentBuild.description = summary.replaceAll("\n", "<br>")
            owner_user_id = "${env.BUILD_USER_ID}"
        }
        //yaml_object = readYaml $YAML_CONFIG
        //for (key in params.keySet()) {
        //    {
        //        System.setProperty(key, params[key])
        //    }
        //}
        stage('Checkout') {
            checkout scv
        }
        stage('Run tests') {
            tests_exit_code = sh(
                    script: "mvn test -Dbrowser=$BROWSER_NAME -Dbrowser.version=$BROWSER_VERSION",
            )

            if (tests_exit_code != 0) {
                currentBuild.status = 'UNSTABLE'
            }
        }

    }
}