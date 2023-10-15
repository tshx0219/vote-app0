multibranchPipelineJob("${Name}") {
    branchSources {
        branchSource {
            source {
                github {
                    id('github')
                    repoOwner("devops-advanced-camp")
                    configuredByUrl(false)
                    repository("vote")
                    repositoryUrl("https://github.com/tshx0219/vote-app0.git")
                    credentialsId('github-pull-secret')

                    traits {
                        gitHubBranchDiscovery {
                            strategyId(1)
                        }
                        gitHubPullRequestDiscovery {
                            strategyId(2)
                        }
                    }
                }
            }
        }
        factory {
            workflowBranchProjectFactory {
                scriptPath("${jenkinsfile}")
            }
        }
    }
}
