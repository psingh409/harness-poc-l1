#!groovy
@Library('julesGlobalLibrary@6.STABLE') _

// keep 5 builds
properties([buildDiscarder(logRotator(numToKeepStr: '5'))])

buildPipeline()

def buildPipeline() {
    jules_pipelineRunner {
        yml = 'jules.yml'
    }
}