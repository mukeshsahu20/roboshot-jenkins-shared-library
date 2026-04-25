def call() {
    env.APPTYPE = "python"
    node {


        common.codeCheckout()
        common.codeQuality()
        common.codechecks()
        common.artifacts()

    }
}
