def pipelines = [
    [name: 'jobdsl/demo-1', scriptPath: 'ci/jenkins/Jenkinsfile'],
    [name: 'jobdsl/demo-2', scriptPath: 'ci/jenkins/Jenkinsfile']
]

for (p in pipelines) {
    pipelineJob("${p.name}") {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            name('github')
                            url('https://github.com/sydpachica/interview_me.git')
                        }
                        branch('master')
                        extensions {
                            cloneOptions {
                                shallow(true)
                                dept(1)
                                noTags(true)
                            }
                        }
                    }
                }
                scripPath("${p.scriptPath}")
            }
        }
    }

