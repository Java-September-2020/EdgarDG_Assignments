public class StringManipulator {
    public String trimAndConcat (String sOne, String sTwo) {
        return (sOne.trim()).concat(sTwo.trim());
    }
    public Integer getIndexOrNull (String str, char indx) {
        if (str.indexOf(indx) < 0) {
            return null;
        } else {
            return str.indexOf(indx);
        }
    }
    public Integer sGetIndexOrNull(String str, String sub) {
        if (str.indexOf(sub) < 0) {
            return null;
        } else {
            return str.indexOf(sub);
        }
    }
    public String concatSubstring(String sOne, int iOne, int iTwo, String sTwo) {
        return (sOne.substring(iOne, iTwo)).concat(sTwo);
    }
}