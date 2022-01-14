class D04 {

    List<Asleep> buildWatchs(List<String> watchs) {
        watchs = watchs.sort()

        List<Asleep> asleeps = []
        Asleep newSleep = null
        String startHour
        int id

        for (int i = 0; i < watchs.size(); i++) {
            def words = watchs[i].tokenize()
            switch (words[2]) {
                case "Guard":
                    id = words[3].replace("#", "").toInteger()
                break
                case "falls":
                    startHour = words[1].substring(0, 5)
                break
                case "wakes":
                    newSleep = new Asleep()
                    newSleep.end = words[1].substring(3, 5).toInteger()
                    def start = startHour.substring(3, 5).toInteger()
                    newSleep.start = start
                    newSleep.time = newSleep.end - start
                    newSleep.id = id
                    asleeps << newSleep
                break
                 default:
                    println "no!"
                 break
            }
        }
        return asleeps
    }

    def buildSpreadsheet(List<Asleep> asleeps) {
        def spreadsheet = [].withDefault { [] }
        for (asleep in asleeps) {
            for (int idx = asleep.start; idx < asleep.end; idx++) {
                def minute = spreadsheet[idx]
                minute << [asleep.id]

                spreadsheet.set(idx, minute)
            }
        }
        spreadsheet
    }

    int findSleepyHead1(List<String> watchs) {
        List<Asleep> asleeps = buildWatchs(watchs)

        //find the most asleep
        def sleepyhead = asleeps.groupBy { it.id }.collectEntries { k, v -> [k, v.time.sum()] }.max { it.value }

        //find the minute
        def spreadsheet = buildSpreadsheet(asleeps.findAll { it.id == sleepyhead.key })
        // use safe navigation operator to prevent operation on null
        def maxMinute = spreadsheet.max { it?.size }.size
        def minute =  spreadsheet.findIndexOf {it?.size == maxMinute}
        return sleepyhead.key * minute
    }

    int findSleepyHead2(List<String> watchs) {
        List<Asleep> asleeps = buildWatchs(watchs)
        // Caution: unique() changes the original collection, so
        // for the sample we invoke unique each time on a fresh new
        // list.
        List<String> ids = new ArrayList<String>(asleeps)
        ids = ids.unique{it.id}.id
        int sleepMinute = 0
        int sleepId = 0
        int minute =0

        for (id in ids){
            def sleepOfId = buildSpreadsheet(asleeps.findAll { it.id == id })
            int maxSleep = sleepOfId.max { it?.size }.size

            if (maxSleep>sleepMinute) {

                sleepMinute = maxSleep
                minute = sleepOfId.findIndexOf {it?.size==maxSleep}
                sleepId = id

            }
        }
        return minute * sleepId
    }

    class Asleep {
        int id
        int start
        int end
        int time

        @Override
        String toString() {
            return "Asleep{" +
                    "id=" + id +
                    ", start=" + start +
                    ", end=" + end +
                    ", time=" + time +
                    '}'
        }
    }
}