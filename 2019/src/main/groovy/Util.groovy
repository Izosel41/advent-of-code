class Util {

    static List<String> extractLines(String nameFile) {
        ClassLoader.getSystemResource(nameFile).readLines()
    }

    static Integer[] convertStringToIntArray(String s) {
        s.tokenize(",")*.toInteger()
    }
}