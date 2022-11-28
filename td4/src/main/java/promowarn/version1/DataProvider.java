package promowarn.version1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DataProvider {
    private final Map<Integer, Student> students;
    private final Map<Integer, PromotionWithDelegate> promotions;
    private final Map<Integer, Faculty> faculties;

    public Student student(final int id) {
        return students.get(id);
    }

    public PromotionWithDelegate promotion(final int id) {
        return promotions.get(id);
    }

    public Faculty faculty(final int id) {
        return faculties.get(id);
    }

    public Student createStudent(final int id, final String email) {
        Student student = new StudentImpl(id, email);
        students.put(id, student);
        return student;
    }

    public PromotionWithDelegate createPromotion(final int id) {
        PromotionWithDelegate p = new PromotionWithDelegateImpl(id);
        promotions.put(id, p);
        return p;
    }

    public Faculty createFaculty(final int id, final PromotionWithDelegate promotion1,
            final PromotionWithDelegate... promotions) {
        Faculty faculty = new FacultyImpl(id, promotion1, promotions);
        faculties.put(id, faculty);
        return faculty;
    }

    public Faculty createFaculty(final int id, final Collection<PromotionWithDelegate> promotions) {
        Faculty faculty = new FacultyImpl(id, promotions);
        faculties.put(id, faculty);
        return faculty;
    }

    public DataProvider() {

        students = new HashMap<>();
        promotions = new HashMap<>();
        faculties = new HashMap<>();
        //
        createStudent(1, "email1@uni-foo.edu").grade(12);
        createStudent(2, "email2@uni-foo.edu").grade(14);
        createStudent(3, "email3@uni-foo.edu").grade(4);
        createStudent(4, "email4@uni-foo.edu").grade(6);
        createStudent(5, "email5@uni-foo.edu").grade(8);
        createStudent(6, "email6@uni-foo.edu").grade(10);
        createStudent(7, "email7@uni-foo.edu");
        //
        createPromotion(1).register(student(1)).register(student(2));
        promotion(1).chooseDelegate(student(1));
        //
        createPromotion(2).register(student(3)).register(student(4));
        promotion(2).chooseDelegate(student(1)); // voluntary bug
        //
        createPromotion(3).register(student(5)).register(student(6));
        promotion(3).chooseDelegate(student(5));
        //
        createPromotion(4).register(student(7)); // no grades
        promotion(4).chooseDelegate(student(7));
        //
        createFaculty(1, promotion(1), promotion(2), promotion(3), promotion(4));
    }
}
