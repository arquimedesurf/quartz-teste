package quartz.teste

class FaturaService {

    static transactional = true

    def gerarFatura() {

        def faturasQueVenceEmDezDias = Fatura.findAllByDueDateLessThan(new Date() + 10)
        faturasQueVenceEmDezDias.each{task ->
            def recipient
            if (task.assignedTo)
                recipient task.assignedTo.email
            else
                task.event.organizer.email

            mailService.sendMail {
                to recipient
                from "admin@tekdays.com"
                subject "Task Reminder"
                body """The following task is overdue:
      ${task.title}"""
            }
        }

    }


    /**
    def mailService

    def sendTaskReminders(){
        def tasks = Task.findAllByDueDateLessThan(new Date())
        tasks.each{task ->
            def recipient
            if (task.assignedTo)
                recipient task.assignedTo.email
            else
                task.event.organizer.email

            mailService.sendMail {
                to recipient
                from "admin@tekdays.com"
                subject "Task Reminder"
                body """The following task is overdue:
      ${task.title}"""
            }
        }
    }

    */
}
