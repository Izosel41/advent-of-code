class Util {

    static List<String> extractLines(String nameFile) {
        ClassLoader.getSystemResource(nameFile).readLines()
    }
}
