import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

class D04 {


    public int scanPassport(File f) throws FileNotFoundException {
        int validatedPassport = 0;
        Scanner sc = new Scanner(f);

        String passport = "";
        while (sc.hasNext()) {
            String curLine = sc.nextLine();
            if ("".equals(curLine)) {
                if (validatePassport(passport))
                    validatedPassport++;
                passport = "";
            }
            passport = passport.concat(" ");
            passport = passport.concat(curLine);
        }
        //last line
        if (validatePassport(passport))
            validatedPassport++;
        return validatedPassport;
    }

    boolean validatePassport(String passport) {

        boolean byr = passport.contains("byr:");
        boolean iyr = passport.contains("iyr:");
        boolean eyr = passport.contains("eyr:");
        boolean hgt = passport.contains("hgt:");
        boolean hcl = passport.contains("hcl:");
        boolean ecl = passport.contains("ecl:");
        boolean pid = passport.contains("pid:");

//        System.out.println(passport);
//        System.out.println("byr : "+ byr +", iyr: " + iyr + ",eyr: " + eyr + ", hgt: " + hgt + ",hcl: " + hcl + ",ecl: " + ecl + ",pid: " + pid );

        if (byr
                && iyr
                && eyr
                && hgt
                && hcl
                && ecl
                && pid
                //&&  passport.contains("cid:")
        )
            return validateByr(passport.split("byr:")[1].split(" ")[0])
                    && validateIyr(passport.split("iyr:")[1].split(" ")[0])
                    && validateEyr(passport.split("eyr:")[1].split(" ")[0])
                    && validateHgt(passport.split("hgt:")[1].split(" ")[0])
                    && validateHcl(passport.split("hcl:")[1].split(" ")[0])
                    && validateEcl(passport.split("ecl:")[1].split(" ")[0])
                    && validatePid(passport.split("pid:")[1].split(" ")[0])
                    ;
        else
            return false;

    }

    /**
     * pid (Passport ID) - a nine-digit number, including leading zeroes.
     * @param pid
     * @return
     */
    private boolean validatePid(String pid) {
        return Pattern.matches("[0-9]{9}", pid);
    }

    /**
     * ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
     * @param
     * @return
     */
    private boolean validateEcl(String ecl) {
        return ecl.equals("amb")
            || ecl.equals("blu")
            || ecl.equals("brn")
            || ecl.equals("gry")
            || ecl.equals("grn")
            || ecl.equals("hzl")
            || ecl.equals("oth");
    }

    /**
     * hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
     * @param hcl
     * @return
     */
    private boolean validateHcl(String hcl) {
        return Pattern.matches("#([a-fA-F0-9]{6})", hcl);
    }

    /**
     * hgt (Height) - a number followed by either cm or in:
     *     If cm, the number must be at least 150 and at most 193.
     *     If in, the number must be at least 59 and at most 76.
     *
     * @param hgt
     * @return
     */
    private boolean validateHgt(String hgt) {
        if(hgt.indexOf("i")!=-1) {
            String[] inch = hgt.split("i");
            int height = Integer.valueOf(inch[0]);
            return "n".equals(inch[1]) && height >= 59 && height <= 76;
        }else
        if(hgt.indexOf("c")!=-1) {
            String[] cm = hgt.split("c");
            int height = Integer.valueOf(cm[0]);
            return "m".equals(cm[1]) && height >= 150 && height <= 193;
        } else return false;
    }

    /**
     * eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
     * @param eyr
     * @return
     */
    private boolean validateEyr(String eyr) {
        return eyr.length()==4 && Integer.valueOf(eyr)<=2030 && Integer.valueOf(eyr)>=2020;
    }

    /**
     * iyr (Issue Year) - four digits; at least 2010 and at most 2020.
     * @param iyr
     * @return
     */
    private boolean validateIyr(String iyr) {
        return iyr.length()==4 && Integer.valueOf(iyr)<=2020 && Integer.valueOf(iyr)>=2010;
    }

    /**
     * byr (Birth Year) - four digits; at least 1920 and at most 2002.
     * @param byr
     * @return
     */
    private boolean validateByr(String byr) {
        return byr.length()==4 && Integer.valueOf(byr)<=2002 && Integer.valueOf(byr)>=1920;
    }
}
