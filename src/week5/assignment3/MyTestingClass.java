package week5.assignment3;

public class MyTestingClass {
    // MyTestingClass will include: IIN of Student, ENT score, and University code. It will be like ENT result
    private final String iin;
    private final int entScore;
    private int universityCode;

    public MyTestingClass(String iin, int entScore, int universityCode) {
        this.iin = iin;
        this.entScore = entScore;
        this.universityCode = universityCode;
    }

    public void setUniversityCode(int universityCode) {
        this.universityCode = universityCode;
    }

    public String getIin() {
        return iin;
    }

    public int getEntScore() {
        return entScore;
    }

    public int getUniversityCode() {
        return universityCode;
    }

    public int hashCode(){
        char[] s = iin.toCharArray();
        int hashIIN = 0;
        for (int i = 0; i < 12; i++)
            hashIIN += s[i];

        return entScore * hashIIN / (entScore % 10 + 1) * universityCode;
    }

    @Override
    public String toString() {
        return "Student {IIN = '" + iin + "'" +
                "ENT score = '" + entScore + "'" +
                "University code = '" + universityCode + "'";
    }
}