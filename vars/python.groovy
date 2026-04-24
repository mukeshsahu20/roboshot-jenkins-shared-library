def call() {
    node {


        common.codeCheckout()
        common.codeQuality()
        common.codechecks()
        common.artifacts()

    }
}
