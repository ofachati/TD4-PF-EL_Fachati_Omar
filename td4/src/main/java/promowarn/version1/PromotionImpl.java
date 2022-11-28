package promowarn.version1;

import java.util.HashSet;
import java.util.Set;

public class PromotionImpl implements Promotion {
    private final Integer id;
    private final Set<Student> students;

    public PromotionImpl(final Integer id) {
        this.id = id;
        this.students = new HashSet<>();
    }

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public Set<Student> students() {
        return students;
    }
    
    @Override
    public Promotion register(final Student student) {
        this.students.add(student);
        return this;
    }
}
