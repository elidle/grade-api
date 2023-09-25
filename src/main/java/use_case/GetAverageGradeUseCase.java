package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team teamMembers = gradeDB.getMyTeam();
        System.out.println(teamMembers);
        String[] members = teamMembers.getMembers();
        int sum = 0;
        for (String member : members) {
            sum = sum + gradeDB.getGrade(member, course).getGrade();
        }

        return (float) sum / members.length;
    }
}
