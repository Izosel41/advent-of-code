class Util {

    static List<String> extractLines(String nameFile) {
        println nameFile
        println ClassLoader.getSystemResource(nameFile)
        ClassLoader.getSystemResource(nameFile).readLines()
    }
}
