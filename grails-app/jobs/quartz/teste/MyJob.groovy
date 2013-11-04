package quartz.teste


class MyJob {
    /**
    def timeout = 5000l // execute job once in 5 seconds

    def execute() {
        // execute task
        println 'Hello World'
    }
     */

    /*
    static triggers = {
        cron name: 'myTrigger', cronExpression: "0 1 10 ? * *"
    }
    def group = "MyGroup"
    def execute(){
        def hoje = new Date()
        print "Job run!"
        print "--- Em: ${hoje} ---"
    }

    **/

    def faturaService
    static triggers = {
        cron name: 'cronTrigger', cronExpression: "0 1 10 ? * *"
    }

    def execute() {
        faturaService.gerarFatura()
        log.info("Faturas geradas em ${new Date()}")
    }
}
